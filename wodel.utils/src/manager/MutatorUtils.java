package manager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

import modeltext.Attribute;
import modeltext.Element;
import mutatext.Option;
import mutatext.Variable;
import mutatext.Word;
import mutatorenvironment.AttributeOperation;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.CompositeMutator;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.LogicOperator;
import mutatorenvironment.MaxValueType;
import mutatorenvironment.MinValueType;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.ObjectEmitter;
import mutatorenvironment.Program;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SelectSampleMutator;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificObjectSelection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;
import org.osgi.framework.Bundle;
import registry.run.IRegistryPostprocessor;
import commands.selection.strategies.RandomTypeSelection;
import commands.strategies.AttributeConfigurationStrategy;
import commands.strategies.MaxValueConfigurationStrategy;
import commands.strategies.MinValueConfigurationStrategy;
import commands.strategies.ReferenceConfigurationStrategy;
import exceptions.AbstractCreationException;
import exceptions.MaxSmallerThanMinException;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.ObjectNoTargetableException;
import exceptions.ObjectNotContainedException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;
import appliedMutations.AppMutation;
import appliedMutations.AppliedMutationsFactory;
import appliedMutations.AttributeChanged;
import appliedMutations.InformationChanged;
import appliedMutations.Mutations;
import appliedMutations.ObjectCloned;
import appliedMutations.ObjectCreated;
import appliedMutations.ObjectRemoved;
import appliedMutations.ObjectRetyped;
import appliedMutations.TargetReferenceChanged;

/**
 * @author Pablo Gomez-Abajo
 * 
 * MutatorUtils methods to get information of
 * the mutations
 * 
 */

public class MutatorUtils {
	
	public static String[] mutatorTypeNames = {
			"CreateObjectMutator",
			"RemoveObjectMutator",
			"CreateReferenceMutator",
			"ModifySourceReferenceMutator",
			"ModifyTargetReferenceMutator",
			"RemoveRandomReferenceMutator",
			"RemoveSpecificReferenceMutator",
			"RemoveCompleteReferenceMutator",
			"ModifyInformationMutator",
			"SelectObjectMutator",
			"SelectSampleMutator",
			"CloneObjectMutator",
			"RetypeObjectMutator"
	};

	private static String[] mutatorOfClassTypeNames = {
			"CreateObjectMutator",
			"RemoveObjectMutator",
			"ModifyInformationMutator",
			"SelectObjectMutator",
			"SelectSampleMutator",
			"CloneObjectMutator",
			"RetypeObjectMutator"
	};
	
	private static String[] creationMutatorTypeNames = {
			"CreateObjectMutator",
			"CloneObjectMutator",
			"RetypeObjectMutator"
	};
	
	private static String[] modificationMutatorTypeNames = {
			"ModifyInformationMutator"
	};
	
	private static String[] referenceModificationMutatorTypeNames = {
			"ModifyInformationMutator",
			"ModifySourceReferenceMutator",
			"ModifyTargetReferenceMutator"
	};

	private static String[] deletionMutatorTypeNames = {
			"RemoveObjectMutator",
			"RetypeObjectMutator"
	};
	
	private static String[] mutatorWithStrategyTypeNames = {
		"RemoveObjectMutator",
		"CloneObjectMutator",
		"ModifyInformationMutator",
		"SelectObjectMutator",
		"ModifySourceReferenceMutator",
		"ModifyTargetReferenceMutator",
		"RetypeObjectMutator"
	};
	
	private static String[] registryMutationTypes = {
		"ObjectCreated",
		"ObjectRemoved",
		"ObjectCloned",
		"ObjectRetyped",
		"SourceReferenceChanged",
		"TargetReferenceChanged",
		"ReferenceCreated",
		"ReferenceRemoved",
		"InformationChanged",
		"AttributeChanged",
		"ReferenceSwap",
		"AttributeSwap"			
	};

	protected static class Operator {
		public String type;

		public Operator() {

		}
	}

	protected static class AttributeEvaluation extends Evaluation {
		public List<String> values;
		public String type;

		public AttributeEvaluation() {

		}
	}

	protected static class ReferenceEvaluation extends Evaluation {
		public String attName;
		public String refName;
		public String refRefName;
		public Object value;
		public boolean container;
//		public int size;

		public ReferenceEvaluation() {

		}
	}

	protected static class Evaluation {
		public String name;
		public String operator;
	}

	protected static class Expression {
		public Evaluation first;
		public List<Operator> operator;
		public List<Evaluation> second;

		public Expression() {

		}
	}
	
	public static class MutationResults {
		public int numMutatorsApplied;
		public int numMutantsGenerated;
		
		public List<String> mutatorsApplied;
		
		public MutationResults() {
			
		}
	}
	
	protected static class MutatorConfiguration {
		public Map<String, List<AttributeConfigurationStrategy>> attsList;
		public Map<String, List<ReferenceConfigurationStrategy>> refsList;
		public Map<String, List<AttributeConfigurationStrategy>> attsRefList;
		public List<EObject> objsAttRef;
		
		public MutatorConfiguration() {
			
		}
	}
	
	/**
	 * Gets a random int in the given range
	 * @param range
	 * @return
	 */
	protected int getRandom(int range) {
		if (range == 1)
			return 0;

		int value = ModelManager.rn.nextInt() % range;
		if (value < 0)
			value = value * -1;

		return value;
	}
	
	/**
	 * Gets a random string
	 * @param min
	 * @param max
	 * @return
	 */
	public static String getRandomString(int min, int max) {
		String value = "";
		int size = ModelManager.rn.nextInt(max-min)+min;
		for (int i=0; i<size; i++) {
			int newchar = ModelManager.rn.nextInt(94)+32;
			while (!Character.isLetter(newchar)) {
				newchar = ModelManager.rn.nextInt(94)+32;
			}
			value = value + String.valueOf((char)newchar);
		}
		return value;
	}

	/**
	 * Gets a random int in the min,max interval
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getRandomInt(int min, int max) {
		int value = 0;
		if (min == 0 && max == 0) {
			value = 0;
		}
		else {
			value = ModelManager.rn.nextInt(max-min)+min;
		}
		return value;
	}
	
	/**
	 * Gets a random double in the min,max interval
	 * @param min
	 * @param max
	 * @return
	 */
	public static double getRandomDouble(double min, double max) {
		double value = 0.0;
		if (min == 0.0 && max == 0.0) {
			value = 0.0;
		}
		else {
			int minInt = (int) Math.floor(min * 100);
			int maxInt = (int) Math.floor(max * 100);
			if (minInt == 0 && maxInt == 0) {
				value = 0.0;
			}
			else {
				int rn = ModelManager.rn.nextInt(maxInt - minInt) + minInt;
				value = rn / 100.0;
			}
		}
		return value;
	}
	
	/**
	 * evaluateFirstAttribute evaluates the attribute expression
	 * @param attev
	 * @param candidates
	 * @param selected
	 */
	private static void evaluateFirstAttribute(AttributeEvaluation attev, List<EObject> candidates, Set<EObject> selected) {
		for (EObject candidate : candidates) {
			if (attev.operator.equals("equals")) {
				for (EAttribute att : candidate.eClass().getEAllAttributes()) {
					if (att.getName().equals(attev.name)) {
						if (candidate.eGet(att) != null) {
							if (candidate.eGet(att).toString().equals(attev.values.get(0).toString())) {
								if (!selected.contains(candidate)) {
									selected.add(candidate);
								}
							}
						}
					}
				}
			}
			if (attev.operator.equals("different")) {
				for (EAttribute att : candidate.eClass().getEAllAttributes()) {
					if (att.getName().equals(attev.name)) {
						if (candidate.eGet(att) != null) {
							if (!candidate.eGet(att).toString().equals(attev.values.get(0))) {
								if (!selected.contains(candidate)) {
									selected.add(candidate);
								}
							}
						}
					}
				}
			}
			if (attev.operator.equals("in")) {
				for (int i = 0; i < attev.values.size(); i++) {
					for (EAttribute att : candidate.eClass().getEAllAttributes()) {
						if (att.getName().equals(attev.name)) {
							if (candidate.eGet(att) != null) {
								if (candidate.eGet(att).toString().equals(attev.values.get(i).toString())) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
						}
					}
				}
			}
		}		
	}
	
	/**
	 * evaluateFirstReferenceEquals evaluates the reference expression
	 * when the operator is '='
	 * @param refev
	 * @param candidate
	 * @param selected
	 */
	private static void evaluateFirstReferenceEquals(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof EObject) {
//				if (refev.size == 1) {
//					selected.add(candidate);
//				}
//			}
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() == refev.size) {
//					selected.add(candidate);
//				}
//			}
//			return;
//		}
		if (refev.name == null) {
			if (refev.container == false) {
				if (candidate.equals(refev.value)) {
					if (!selected.contains(candidate)) {
						selected.add(candidate);
					}
				}
			}
			else if (candidate.eContainer() != null && candidate.eContainer().equals(refev.value)) {
				if (!selected.contains(candidate)) {
					selected.add(candidate);
				}
			}
		} else {
			if (refev.refName == null) {
				if (refev.attName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (refev.value == null) {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									if (objects.size() == 0) {
										if (!selected.contains(candidate)) {
											selected.add(candidate);
										}
									}
								}
								else {
									if (candidate.eGet(ref) == null) {
										if (!selected.contains(candidate)) {
											selected.add(candidate);
										}
									}
								}
							} else {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = new ArrayList<EObject>();
									objects.addAll((List<EObject>) candidate.eGet(ref));
									if (refev.value instanceof List<?>) {
										boolean b = true;
										for (EObject obj : (List<EObject>) refev.value) {
											if (!objects.contains(obj)) {
												b = false;
												break;
											}
											objects.remove(obj);
										}
										if (b == true && objects.size() == 0) {
											if (!selected.contains(candidate)) {
												selected.add(candidate);
											}
										}
									}
									else {
										EObject object = (EObject) refev.value;
										if (objects.contains(object)) {
											if (!selected.contains(candidate)) {
												selected.add(candidate);
											}
										}
									}
								}
								else {
									if (candidate.eGet(ref) instanceof EObject) {
										EObject object = (EObject) candidate.eGet(ref);
										if (refev.value instanceof List<?>) {
											List<EObject> objects = (List<EObject>) refev.value;
											if (objects.contains(object)) {
												if (!selected.contains(candidate)) {
													selected.add(candidate);
												}
											}
										}
										else {
											if (object.equals(refev.value)) {
												if (!selected.contains(candidate)) {
													selected.add(candidate);
												}
											}
										}
									}
								}
							}
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EAttribute att : object.eClass().getEAllAttributes()) {
										if (att.getName().equals(refev.attName)) {
											if (refev.value == null) {
												if (object.eGet(att) == null) {
													if (!selected.contains(candidate)) {
														selected.add(candidate);
													}
												}
											}
											else {
												Object val = object.eGet(att);
												if (val instanceof EEnumLiteral) {
													val = ((EEnumLiteral) val).getLiteral();
												}
												if (val.equals(refev.value)) {
													if (!selected.contains(candidate)) {
														selected.add(candidate);
													}
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EAttribute att : object.eClass().getEAllAttributes()) {
											if (att.getName().equals(refev.attName)) {
												if (refev.value == null) {
													if (object.eGet(att) == null) {
														if (!selected.contains(candidate)) {
															selected.add(candidate);
														}
													}
												}
												else {
													Object val = object.eGet(att);
													if (val instanceof EEnumLiteral) {
														val = ((EEnumLiteral) val).getLiteral();
													}
													if (val.equals(refev.value)) {
														if (!selected.contains(candidate)) {
															selected.add(candidate);
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
				}
			}
			else {
				if (refev.refRefName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (refev.value == null) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													if (obj == null) {
														if (!selected.contains(candidate)) {
															selected.add(candidate);
														}
													}
												}
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objs = (List<EObject>) object.eGet(reff);
													if (objs.size() == 0) {
														if (!selected.contains(candidate)) {
															selected.add(candidate);
														}
													}
												}
											}
											else {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													if (refev.value instanceof List<?>) {
														List<EObject> objects = (List<EObject>) refev.value;
														if (objects.contains(obj)) {
															if (!selected.contains(candidate)) {
																selected.add(candidate);
															}
														}
													}
													else {
														if (obj.equals(refev.value)) {
															if (!selected.contains(candidate)) {
																selected.add(candidate);
															}
														}
													}
												}
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objs = (List<EObject>) object.eGet(reff);
													if (refev.value instanceof List<?>) {
														List<EObject> objects = new ArrayList<EObject>();
														objects.addAll((List<EObject>) refev.value);
														boolean b = true;
														for (EObject obj : objs) {
															if (!objects.contains(obj)) {
																b = false;
																break;
															}
															objects.remove(obj);
														}
														if (b == true && objects.size() == 0) {
															if (!selected.contains(candidate)) {
																selected.add(candidate);
															}
														}
													}
													else {
														for (EObject obj : objs) {
															if (obj.equals(refev.value)) {
																if (!selected.contains(candidate)) {
																	selected.add(candidate);
																}
															}
														}
													}
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EReference reff : object.eClass().getEAllReferences()) {
											if (reff.getName().equals(refev.refName)) {
												if (refev.value == null) {
													if (object.eGet(reff) instanceof EObject) {
														EObject obj = (EObject) object.eGet(reff);
														if (obj == null) {
															if (!selected.contains(candidate)) {
																selected.add(candidate);
															}
														}
													}
													if (object.eGet(reff) instanceof List<?>) {
														List<EObject> objs = (List<EObject>) object.eGet(reff);
														if (objs.size() == 0) {
															if (!selected.contains(candidate)) {
																selected.add(candidate);
															}
														}
													}
												}
												else {
													if (object.eGet(reff) instanceof EObject) {
														EObject obj = (EObject) object.eGet(reff);
														if (refev.value instanceof List<?>) {
															List<EObject> objs = (List<EObject>) refev.value;
															if (objs.contains(obj)) {
																if (!selected.contains(candidate)) {
																	selected.add(candidate);
																}
															}
														}
														else {
															if (obj.equals(refev.value)) {
																if (!selected.contains(candidate)) {
																	selected.add(candidate);
																}
															}
														}
													}
													if (object.eGet(reff) instanceof List<?>) {
														List<EObject> objs = (List<EObject>) object.eGet(reff);
														if (refev.value instanceof List<?>) {
															List<EObject> lobjects = new ArrayList<EObject>();
															lobjects.addAll((List<EObject>) refev.value);
															boolean b = true;
															for (EObject obj : objs) {
																if (!lobjects.contains(obj)) {
																	b = false;
																	break;
																}
																lobjects.remove(obj);
															}
															if (b == true && lobjects.size() == 0) {
																if (!selected.contains(candidate)) {
																	selected.add(candidate);
																}
															}
														}
														else {
															for (EObject obj : objs) {
																if (obj.equals(refev.value)) {
																	if (!selected.contains(candidate)) {
																		selected.add(candidate);
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
							}
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (object.eGet(reff) instanceof EObject) {
												EObject obj = (EObject) object.eGet(reff);
												for (EReference refff : obj.eClass().getEAllReferences()) {
													if (refff.getName().equals(refev.refRefName)) {
														if (refev.value == null) {
															if (obj.eGet(refff) instanceof EObject) {
																EObject o = (EObject) obj.eGet(refff);
																if (o == null) {
																	if (!selected.contains(candidate)) {
																		selected.add(candidate);
																	}
																}
															}
															if (obj.eGet(refff) instanceof List<?>) {
																List<EObject> oo = (List<EObject>) obj.eGet(refff);
																if (oo.size() == 0) {
																	if (!selected.contains(candidate)) {
																		selected.add(candidate);
																	}
																}
																
															}
														}
														else {
															if (obj.eGet(refff) instanceof EObject) {
																EObject o = (EObject) obj.eGet(refff);
																if (refev.value instanceof List<?>) {
																	List<EObject> objects = (List<EObject>) refev.value;
																	if (objects.contains(o)) {
																		if (!selected.contains(candidate)) {
																			selected.add(candidate);
																		}
																	}
																}
																else {
																	if (o.equals(refev.value)) {
																		if (!selected.contains(candidate)) {
																			selected.add(candidate);
																		}
																	}
																}
															}
														}
													}
												}
											}
											else {
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objects = (List<EObject>) object.eGet(reff);
													for (EObject obj : objects) {
														for (EReference refff : obj.eClass().getEAllReferences()) {
															if (refff.getName().equals(refev.refRefName)) {
																if (refev.value == null) {
																	if (obj.eGet(refff) instanceof EObject) {
																		EObject o = (EObject) obj.eGet(refff);
																		if (o == null) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
																			}
																		}
																	}
																	if (obj.eGet(refff) instanceof List<?>) {
																		List<EObject> oo = (List<EObject>) obj.eGet(refff);
																		if (oo.size() == 0) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
																			}
																		}
																		
																	}
																}
																else {
																	if (obj.eGet(refff) instanceof EObject) {
																		EObject o = (EObject) obj.eGet(refff);
																		if (refev.value instanceof List<?>) {
																			List<EObject> objs = (List<EObject>) refev.value;
																			if (objs.contains(o)) {
																				if (!selected.contains(candidate)) {
																					selected.add(candidate);
																				}
																			}
																		}
																		else {
																			if (o.equals(refev.value)) {
																				if (!selected.contains(candidate)) {
																					selected.add(candidate);
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
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EReference reff : object.eClass().getEAllReferences()) {
											if (reff.getName().equals(refev.refName)) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													for (EReference refff : obj.eClass().getEAllReferences()) {
														if (refff.getName().equals(refev.refRefName)) {
															if (refev.value == null) {
																if (obj.eGet(refff) instanceof EObject) {
																	EObject o = (EObject) obj.eGet(refff);
																	if (o == null) {
																		if (!selected.contains(candidate)) {
																			selected.add(candidate);
																		}
																	}
																}
																if (obj.eGet(refff) instanceof EObject) {
																	List<EObject> oo = (List<EObject>) obj.eGet(refff);
																	if (oo.size() == 0) {
																		if (!selected.contains(candidate)) {
																			selected.add(candidate);
																		}
																	}
																}
															}
															else {
																if (obj.eGet(refff) instanceof EObject) {
																	EObject o = (EObject) obj.eGet(refff);
																	if (refev.value instanceof List<?>) {
																		List<EObject> objs = (List<EObject>) refev.value;
																		if (objs.contains(o)) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
																			}
																		}
																	}
																	else {
																		if (o.equals(refev.value)) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
																			}
																		}
																	}
																}
																if (obj.eGet(refff) instanceof List<?>) {
																	List<EObject> oo = (List<EObject>) obj.eGet(refff);
																	if (refev.value instanceof List<?>) {
																		List<EObject> lobjects = new ArrayList<EObject>();
																		lobjects.addAll((List<EObject>) refev.value);
																		boolean b = true;
																		for (EObject o : oo) {
																			if (!lobjects.contains(o)) {
																				b = false;
																				break;
																			}
																			lobjects.remove(o);
																		}
																		if (b == true && lobjects.size() == 0) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
																			}
																		}
																	}
																	else {
																		for (EObject o : oo) {
																			if (o.equals(refev.value)) {
																				if (!selected.contains(candidate)) {
																					selected.add(candidate);
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
	
	/**
	 * evaluateFirstReferenceDifferent evaluates the reference expression
	 * when the operator is '<>'
	 * @param refev
	 * @param candidate
	 * @param selected
	 */
	private static void evaluateFirstReferenceDifferent(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof EObject) {
//				if (refev.size != 1) {
//					selected.add(candidate);
//				}
//			}
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() != refev.size) {
//					selected.add(candidate);
//				}
//			}
//			return;
//		}
		if (refev.name == null) {
			if (refev.container == false) {
				if (!candidate.equals(refev.value)) {
					if (!selected.contains(candidate)) {
						selected.add(candidate);
					}
				}
			}
			else if (candidate.eContainer() != null && !candidate.eContainer().equals(refev.value)) {
				if (!selected.contains(candidate)) {
					selected.add(candidate);
				}
			}
		} else {
			if (refev.refName == null) {
				if (refev.attName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (refev.value == null) {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									if (objects.size() > 0) {
										if (!selected.contains(candidate)) {
											selected.add(candidate);
										}
									}
								}
								else {
									if (candidate.eGet(ref) != null) {
										if (!selected.contains(candidate)) {
											selected.add(candidate);
										}
									}
								}
							}
							else {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = new ArrayList<EObject>();
									objects.addAll((List<EObject>) candidate.eGet(ref));
									if (refev.value instanceof List<?>) {
										List<EObject> objs = (List<EObject>) refev.value;
										boolean b = true;
										for (EObject obj : objs) {
											if (!objects.contains(obj)) {
												b = false;
												break;
											}
											objects.remove(obj);
										}
										if (b == false || objects.size() > 0) {
											if (!selected.contains(candidate)) {
												selected.add(candidate);
											}
										}
									}
									else {
										EObject obj = (EObject) refev.value;
										if (!objects.contains(obj)) {
											if (!selected.contains(candidate)) {
												selected.add(candidate);
											}
										}
									}
								}
								else {
									if (candidate.eGet(ref) instanceof EObject) {
										EObject object = (EObject) candidate.eGet(ref);
										if (refev.value instanceof List<?>) {
											List<EObject> objects = (List<EObject>) refev.value;
											if (!objects.contains(object)) {
												if (!selected.contains(candidate)) {
													selected.add(candidate);
												}
											}
										}
										else {
											if (!object.equals(refev.value)) {
												if (!selected.contains(candidate)) {
													selected.add(candidate);
												}
											}
										}
									}
									else if (candidate.eGet(ref) == null) {
										selected.add(candidate);
									}
								}
							}
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EAttribute att : object.eClass().getEAllAttributes()) {
										if (att.getName().equals(refev.attName)) {
											if (refev.value == null) {
												if (object.eGet(att) != null) {
													if (!selected.contains(candidate)) {
														selected.add(candidate);
													}
												}
											}
											else {
												Object val = object.eGet(att);
												if (val instanceof EEnumLiteral) {
													val = ((EEnumLiteral) val).getLiteral();
												}
												if (!val.equals(refev.value)) {
													if (!selected.contains(candidate)) {
														selected.add(candidate);
													}
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EAttribute att : object.eClass().getEAllAttributes()) {
											if (att.getName().equals(refev.attName)) {
												if (refev.value == null) {
													if (object.eGet(att) != null) {
														if (!selected.contains(candidate)) {
															selected.add(candidate);
														}
													}
												}
												else {
													Object val = object.eGet(att);
													if (val instanceof EEnumLiteral) {
														val = ((EEnumLiteral) val).getLiteral();
													}
													if (!val.equals(refev.value)) {
														if (!selected.contains(candidate)) {
															selected.add(candidate);
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
				}
			}
			else {
				if (refev.refRefName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (refev.value == null) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													if (obj != null) {
														if (!selected.contains(candidate)) {
															selected.add(candidate);
														}
													}
												}
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objs = (List<EObject>) object.eGet(reff);
													if (objs.size() > 0) {
														if (!selected.contains(candidate)) {
															selected.add(candidate);
														}
													}
												}
											} else {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													if (obj != null) {
														if (refev.value instanceof List<?>) {
															List<EObject> objects = (List<EObject>) refev.value;
															if (!objects.contains(obj)) {
																if (!selected.contains(candidate)) {
																	selected.add(candidate);
																}
															}
														}
														else {
															if (!obj.equals(refev.value)) {
																if (!selected.contains(candidate)) {
																	selected.add(candidate);
																}
															}
														}
													}
												}
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objs = (List<EObject>) object.eGet(reff);
													if (refev.value instanceof List<?>) {
														List<EObject> objects = new ArrayList<EObject>();
														objects.addAll((List<EObject>) refev.value);
														boolean b = true;
														for (EObject obj : objs) {
															if (!objects.contains(obj)) {
																b = false;
																break;
															}
															objects.remove(obj);
														}
														if (b == false || objects.size() > 0) {
															if (!selected.contains(candidate)) {
																selected.add(candidate);
															}
														}
													}
													else {
														boolean exists = false;
														for (EObject obj : objs) {
															if (obj.equals(refev.value)) {
																exists = true;
																break;
															}
														}
														if (exists == true) {
															if (!selected.contains(candidate)) {
																selected.add(candidate);
															}
														}
													}
												}
												if (object.eGet(reff) == null) {
													selected.add(candidate);
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EReference reff : object.eClass().getEAllReferences()) {
											if (reff.getName().equals(refev.refName)) {
												if (refev.value == null) {
													if (object.eGet(reff) instanceof EObject) {
														EObject obj = (EObject) object.eGet(reff);
														if (obj != null) {
															if (!selected.contains(candidate)) {
																selected.add(candidate);
															}
														}
													}
													if (object.eGet(reff) instanceof List<?>) {
														List<EObject> objs = (List<EObject>) object.eGet(reff);
														if (objs.size() > 0) {
															if (!selected.contains(candidate)) {
																selected.add(candidate);
															}
														}
													}
												} else {
													if (object.eGet(reff) instanceof EObject) {
														EObject obj = (EObject) object.eGet(reff);
														if (obj != null) {
															if (refev.value instanceof List<?>) {
																List<EObject> objs = (List<EObject>) refev.value;
																if (!objs.contains(obj)) {
																	if (!selected.contains(candidate)) {
																		selected.add(candidate);
																	}
																}
															}
															else {
																if (!obj.equals(refev.value)) {
																	if (!selected.contains(candidate)) {
																		selected.add(candidate);
																	}
																}
															}
														}
													}
													if (object.eGet(reff) instanceof List<?>) {
														List<EObject> objs = (List<EObject>) object.eGet(reff);
														if (refev.value instanceof List<?>) {
															List<EObject> lobjects = new ArrayList<EObject>();
															lobjects.addAll((List<EObject>) refev.value);
															boolean b = true;
															for (EObject obj : objs) {
																if (!lobjects.contains(obj)) {
																	b = false;
																	break;
																}
																lobjects.remove(obj);
															}
															if (b == false || lobjects.size() > 0) {
																if (!selected.contains(candidate)) {
																	selected.add(candidate);
																}
															}
														}
														else {
															boolean exists = false;
															for (EObject obj : objs) {
																if (obj.equals(refev.value)) {
																	exists = true;
																	break;
																}
															}
															if (exists == false) {
																if (!selected.contains(candidate)) {
																	selected.add(candidate);
																}
															}
														}
													}
													if (object.eGet(reff) == null) {
														selected.add(candidate);
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
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (object.eGet(reff) instanceof EObject) {
												EObject obj = (EObject) object.eGet(reff);
												for (EReference refff : obj.eClass().getEAllReferences()) {
													if (refff.getName().equals(refev.refRefName)) {
														if (refev.value == null) {
															if (obj.eGet(refff) instanceof EObject) {
																EObject o = (EObject) obj.eGet(refff);
																if (o != null) {
																	if (!selected.contains(candidate)) {
																		selected.add(candidate);
																	}
																}
															}
															if (obj.eGet(refff) instanceof List<?>) {
																List<EObject> oo = (List<EObject>) obj.eGet(refff);
																if (oo.size() > 0) {
																	if (!selected.contains(candidate)) {
																		selected.add(candidate);
																	}
																}

															}
														}
														else {
															if (obj.eGet(refff) instanceof EObject) {
																EObject o = (EObject) obj.eGet(refff);
																if (refev.value instanceof List<?>) {
																	List<EObject> objects = (List<EObject>) refev.value;
																	if (!objects.contains(o)) {
																		if (!selected.contains(candidate)) {
																			selected.add(candidate);
																		}
																	}
																}
																else {
																	if (!o.equals(refev.value)) {
																		if (!selected.contains(candidate)) {
																			selected.add(candidate);
																		}
																	}
																}
															}
														}
													}
												}
											}
											else {
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objects = (List<EObject>) object.eGet(reff);
													for (EObject obj : objects) {
														for (EReference refff : obj.eClass().getEAllReferences()) {
															if (refff.getName().equals(refev.refRefName)) {
																if (refev.value == null) {
																	if (obj.eGet(refff) instanceof EObject) {
																		EObject o = (EObject) obj.eGet(refff);
																		if (o != null) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
																			}
																		}
																	}
																	if (obj.eGet(refff) instanceof List<?>) {
																		List<EObject> oo = (List<EObject>) obj.eGet(refff);
																		if (oo.size() > 0) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
																			}
																		}

																	}
																}
																else {
																	if (obj.eGet(refff) instanceof EObject) {
																		EObject o = (EObject) obj.eGet(refff);
																		if (refev.value instanceof List<?>) {
																			List<EObject> objs = (List<EObject>) refev.value;
																			if (!objs.contains(o)) {
																				if (!selected.contains(candidate)) {
																					selected.add(candidate);
																				}
																			}
																		}
																		else {
																			if (!o.equals(refev.value)) {
																				if (!selected.contains(candidate)) {
																					selected.add(candidate);
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
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EReference reff : object.eClass().getEAllReferences()) {
											if (reff.getName().equals(refev.refName)) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													for (EReference refff : obj.eClass().getEAllReferences()) {
														if (refff.getName().equals(refev.refRefName)) {
															if (refev.value == null) {
																if (obj.eGet(refff) instanceof EObject) {
																	EObject o = (EObject) obj.eGet(refff);
																	if (o != null) {
																		if (!selected.contains(candidate)) {
																			selected.add(candidate);
																		}
																	}
																}
																if (obj.eGet(refff) instanceof EObject) {
																	List<EObject> oo = (List<EObject>) obj.eGet(refff);
																	if (oo.size() > 0) {
																		if (!selected.contains(candidate)) {
																			selected.add(candidate);
																		}
																	}
																}
															}
															else {
																if (obj.eGet(refff) instanceof EObject) {
																	EObject o = (EObject) obj.eGet(refff);
																	if (refev.value instanceof List<?>) {
																		List<EObject> objs = (List<EObject>) refev.value;
																		if (!objs.contains(o)) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
																			}
																		}
																	}
																	else {
																		if (!o.equals(refev.value)) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
																			}
																		}
																	}
																}
																else {
																	List<EObject> oo = (List<EObject>) obj.eGet(refff);
																	if (obj.eGet(refff) instanceof List<?>) {
																		List<EObject> lobjects = new ArrayList<EObject>();
																		lobjects.addAll((List<EObject>) refev.value);
																		boolean b = true;
																		for (EObject o : oo) {
																			if (!lobjects.contains(o)) {
																				b = false;
																				break;
																			}
																			lobjects.remove(o);
																		}
																		if (b == false || lobjects.size() > 0) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
																			}
																		}
																	}
																	else {
																		boolean exists = false;
																		for (EObject o : oo) {
																			if (o.equals(refev.value)) {
																				exists = true;
																				break;
																			}
																		}
																		if (exists == false) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
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
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * evaluateFirstReferenceIn evaluates the reference expression
	 * when the operator is 'in'
	 * @param refev
	 * @param candidate
	 * @param selected
	 */

	private static void evaluateFirstReferenceIn(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected) {
		if (refev.name != null) {
			if (refev.refName == null) {
				if (refev.attName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (refev.value != null) {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = new ArrayList<EObject>();
									objects.addAll((List<EObject>) candidate.eGet(ref));
									if (refev.value instanceof List<?>) {
										boolean b = true;
										for (EObject obj : (List<EObject>) refev.value) {
											if (!objects.contains(obj)) {
												b = false;
												break;
											}
											objects.remove(obj);
										}
										if (b == true && objects.size() == 0) {
											if (!selected.contains(candidate)) {
												selected.add(candidate);
											}
										}
									}
									else {
										EObject object = (EObject) refev.value;
										if (objects.contains(object)) {
											if (!selected.contains(candidate)) {
												selected.add(candidate);
											}
										}
									}
								}
								else {
									if (candidate.eGet(ref) instanceof EObject) {
										EObject object = (EObject) candidate.eGet(ref);
										if (refev.value instanceof List<?>) {
											List<EObject> objects = (List<EObject>) refev.value;
											if (objects.contains(object)) {
												if (!selected.contains(candidate)) {
													selected.add(candidate);
												}
											}
										}
										else {
											if (object.equals(refev.value)) {
												if (!selected.contains(candidate)) {
													selected.add(candidate);
												}
											}
										}
									}
								}
							}
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EAttribute att : object.eClass().getEAllAttributes()) {
										if (att.getName().equals(refev.attName)) {
											if (refev.value == null) {
												if (object.eGet(att) == null) {
													if (!selected.contains(candidate)) {
														selected.add(candidate);
													}
												}
											}
											else {
												Object val = object.eGet(att);
												if (val instanceof EEnumLiteral) {
													val = ((EEnumLiteral) val).getLiteral();
												}
												if (val.equals(refev.value)) {
													if (!selected.contains(candidate)) {
														selected.add(candidate);
													}
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EAttribute att : object.eClass().getEAllAttributes()) {
											if (att.getName().equals(refev.attName)) {
												if (refev.value == null) {
													if (object.eGet(att) == null) {
														if (!selected.contains(candidate)) {
															selected.add(candidate);
														}
													}
												}
												else {
													Object val = object.eGet(att);
													if (val instanceof EEnumLiteral) {
														val = ((EEnumLiteral) val).getLiteral();
													}
													if (val.equals(refev.value)) {
														if (!selected.contains(candidate)) {
															selected.add(candidate);
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
				}
			}
			else {
				if (refev.refRefName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (refev.value != null) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													if (refev.value instanceof List<?>) {
														List<EObject> objects = (List<EObject>) refev.value;
														if (objects.contains(obj)) {
															if (!selected.contains(candidate)) {
																selected.add(candidate);
															}
														}
													}
													else {
														if (obj.eGet(reff).equals(refev.value)) {
															if (!selected.contains(candidate)) {
																selected.add(candidate);
															}
														}
													}
												}
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objs = (List<EObject>) object.eGet(reff);
													if (refev.value instanceof List<?>) {
														List<EObject> objects = new ArrayList<EObject>();
														objects.addAll((List<EObject>) refev.value);
														boolean b = true;
														for (EObject obj : objs) {
															if (!objects.contains(obj)) {
																b = false;
																break;
															}
															objects.remove(obj);
														}
														if (b == true && objects.size() == 0) {
															if (!selected.contains(candidate)) {
																selected.add(candidate);
															}
														}
													}
													else {
														for (EObject obj : objs) {
															if (obj.equals(refev.value)) {
																if (!selected.contains(candidate)) {
																	selected.add(candidate);
																}
															}
														}
													}
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EReference reff : object.eClass().getEAllReferences()) {
											if (reff.getName().equals(refev.refName)) {
												if (refev.value != null) {
													if (object.eGet(reff) instanceof EObject) {
														EObject obj = (EObject) object.eGet(reff);
														if (refev.value instanceof List<?>) {
															List<EObject> objs = (List<EObject>) refev.value;
															if (objs.contains(obj)) {
																if (!selected.contains(candidate)) {
																	selected.add(candidate);
																}
															}
														}
														else {
															if (obj.equals(refev.value)) {
																if (!selected.contains(candidate)) {
																	selected.add(candidate);
																}
															}
														}
													}
													if (object.eGet(reff) instanceof List<?>) {
														List<EObject> objs = (List<EObject>) object.eGet(reff);
														if (refev.value instanceof List<?>) {
															List<EObject> lobjects = new ArrayList<EObject>();
															lobjects.addAll((List<EObject>) refev.value);
															boolean b = true;
															for (EObject obj : objs) {
																if (!lobjects.contains(obj)) {
																	b = false;
																	break;
																}
																lobjects.remove(obj);
															}
															if (b == true && lobjects.size() == 0) {
																if (!selected.contains(candidate)) {
																	selected.add(candidate);
																}
															}
														}
														else {
															for (EObject obj : objs) {
																if (obj.equals(refev.value)) {
																	if (!selected.contains(candidate)) {
																		selected.add(candidate);
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
							}
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (object.eGet(reff) instanceof EObject) {
												EObject obj = (EObject) object.eGet(reff);
												for (EReference refff : obj.eClass().getEAllReferences()) {
													if (refff.getName().equals(refev.refRefName)) {
														if (refev.value != null) {
															if (obj.eGet(refff) instanceof EObject) {
																EObject o = (EObject) obj.eGet(refff);
																if (refev.value instanceof List<?>) {
																	List<EObject> objects = (List<EObject>) refev.value;
																	if (objects.contains(o)) {
																		if (!selected.contains(candidate)) {
																			selected.add(candidate);
																		}
																	}
																}
																else {
																	if (o.equals(refev.value)) {
																		if (!selected.contains(candidate)) {
																			selected.add(candidate);
																		}
																	}
																}
															}
														}
													}
												}
											}
											else {
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objects = (List<EObject>) object.eGet(reff);
													for (EObject obj : objects) {
														for (EReference refff : obj.eClass().getEAllReferences()) {
															if (refff.getName().equals(refev.refRefName)) {
																if (refev.value != null) {
																	if (obj.eGet(refff) instanceof EObject) {
																		EObject o = (EObject) obj.eGet(refff);
																		if (refev.value instanceof List<?>) {
																			List<EObject> objs = (List<EObject>) refev.value;
																			if (objs.contains(o)) {
																				if (!selected.contains(candidate)) {
																					selected.add(candidate);
																				}
																			}
																		}
																		else {
																			if (o.equals(refev.value)) {
																				if (!selected.contains(candidate)) {
																					selected.add(candidate);
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
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EReference reff : object.eClass().getEAllReferences()) {
											if (reff.getName().equals(refev.refName)) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													for (EReference refff : obj.eClass().getEAllReferences()) {
														if (refff.getName().equals(refev.refRefName)) {
															if (refev.value != null) {
																if (obj.eGet(refff) instanceof EObject) {
																	EObject o = (EObject) obj.eGet(refff);
																	if (refev.value instanceof List<?>) {
																		List<EObject> objs = (List<EObject>) refev.value;
																		if (objs.contains(o)) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
																			}
																		}
																	}
																	else {
																		if (o.equals(refev.value)) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
																			}
																		}
																	}
																}
																if (obj.eGet(refff) instanceof List<?>) {
																	List<EObject> oo = (List<EObject>) obj.eGet(refff);
																	if (refev.value instanceof List<?>) {
																		List<EObject> lobjects = new ArrayList<EObject>();
																		lobjects.addAll((List<EObject>) refev.value);
																		boolean b = true;
																		for (EObject o : oo) {
																			if (!lobjects.contains(o)) {
																				b = false;
																				break;
																			}
																			lobjects.remove(o);
																		}
																		if (b == true && lobjects.size() == 0) {
																			if (!selected.contains(candidate)) {
																				selected.add(candidate);
																			}
																		}
																	}
																	else {
																		for (EObject o : oo) {
																			if (o.equals(refev.value)) {
																				if (!selected.contains(candidate)) {
																					selected.add(candidate);
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

	/**
	 * evaluateFirstReferenceIs evaluates the reference expression
	 * when the operator is 'is'
	 * @param refev
	 * @param candidate
	 * @param selected
	 */
	private static void evaluateFirstReferenceIs(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected) {
		if (refev.name == null) {
			if (refev.container == false) {
				if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) candidate).eClass())) {
					selected.add(candidate);
				}
			}
			else if (candidate.eContainer() != null && refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) candidate).eContainer().eClass())) {
				selected.add(candidate);
			}
		}
		else {
			Object obj = ModelManager.getReferredObject(refev.name, candidate);
			if (obj instanceof EObject) {
				if (refev.refName == null) {
					if (refev.attName == null) {
						if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) obj).eClass())) {
							selected.add(candidate);
						}
					}
				}
				else {
					if (refev.refRefName == null) {
						Object refObj = ModelManager.getReferredObject(refev.refName, (EObject) obj);
						if (refObj != null) {
							if (refObj instanceof EObject) {
								if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refObj).eClass())) {
									selected.add(candidate);
								}
							}
							else {
								List<EObject> objects = (List<EObject>) refObj;
								for (EObject object : objects) {
									if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), object.eClass())) {
										selected.add(candidate);
										break;
									}
								}
							}
						}
					}
					else {
						Object refObj = ModelManager.getReferredObject(refev.refName, (EObject) obj);
						if (refObj != null) {
							if (refObj instanceof EObject) {
								Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refObj);
								if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
									selected.add(candidate);
								}
							}
							else {
								List<EObject> objects = (List<EObject>) refObj;
								for (EObject object : objects) {
									Object refRefObj = ModelManager.getReferredObject(refev.refRefName, object);
									if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
										selected.add(candidate);
										break;
									}
								}
							}
						}
					}
				}
			}
			if (obj instanceof List<?>) {
				List<EObject> objects = (List<EObject>) obj;
				for (EObject object : objects) {
					if (refev.refName == null) {
						if (refev.attName == null) {
							if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), object.eClass())) {
								selected.add(candidate);
								break;
							}
						}
					}
					else {
						if (refev.refRefName == null) {
							Object refObj = ModelManager.getReferredObject(refev.refName, object);
							if (refObj != null) {
								if (refObj instanceof EObject) {
									if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refObj).eClass())) {
										selected.add(candidate);
										break;
									}
								}
								else {
									List<EObject> refObjects = (List<EObject>) refObj;
									boolean found = false;
									for (EObject refOb : refObjects) {
										if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), refOb.eClass())) {
											selected.add(candidate);
											found = true;
											break;
										}
									}
									if (found == true) {
										break;
									}
								}
							}
						}
						else {
							Object refObj = ModelManager.getReferredObject(refev.refName, object);
							if (refObj != null) {
								if (refObj instanceof EObject) {
									Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refObj);
									if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
										selected.add(candidate);
										break;
									}
								}
								else {
									List<EObject> refObjects = (List<EObject>) refObj;
									boolean found = false;
									for (EObject refOb : refObjects) {
										Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refOb);
										if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
											selected.add(candidate);
											found = true;
											break;
										}
									}
									if (found == true) {
										break;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * evaluateFirstReferenceNot evaluates the reference expression
	 * when the operator is 'not'
	 * @param refev
	 * @param candidate
	 * @param selected
	 */
	private static void evaluateFirstReferenceNot(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected) {
		if (refev.name == null) {
			if (refev.container == false) {
				if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), candidate.eClass())) {
					selected.remove(candidate);
				}
			}
			else if (candidate.eContainer() != null && refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), candidate.eContainer().eClass())) {
				selected.remove(candidate);
			}
			return;
		}
		Object obj = ModelManager.getReferredObject(refev.name, candidate);
		if (obj instanceof EObject) {
			if (refev.refName == null) {
				if (refev.attName == null) {
					if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) obj).eClass())) {
						selected.remove(candidate);
					}
				}
			}
			else {
				if (refev.refRefName == null) {
					Object refObj = ModelManager.getReferredObject(refev.refName, (EObject) obj);
					if (refObj != null) {
						if (refObj instanceof EObject) {
							if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refObj).eClass())) {
								selected.remove(candidate);
							}
						}
						else {
							List<EObject> objects = (List<EObject>) refObj;
							for (EObject object : objects) {
								if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), object.eClass())) {
									selected.remove(candidate);
									break;
								}
							}
						}
					}
				}
				else {
					Object refObj = ModelManager.getReferredObject(refev.refName, (EObject) obj);
					if (refObj != null) {
						if (refObj instanceof EObject) {
							Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refObj);
							if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
								selected.remove(candidate);
							}
						}
						else {
							List<EObject> objects = (List<EObject>) refObj;
							for (EObject object : objects) {
								Object refRefObj = ModelManager.getReferredObject(refev.refRefName, object);
								if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
									selected.remove(candidate);
									break;
								}
							}
						}
					}
				}
			}
		}
		if (obj instanceof List<?>) {
			List<EObject> objects = (List<EObject>) obj;
			for (EObject object : objects) {
				if (refev.refName == null) {
					if (refev.attName == null) {
						if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), object.eClass())) {
							selected.remove(candidate);
							break;
						}
					}
				}
				else {
					if (refev.refRefName == null) {
						Object refObj = ModelManager.getReferredObject(refev.refName, object.eClass());
						if (refObj != null) {
							if (refObj instanceof EObject) {
								if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refObj).eClass())) {
									selected.remove(candidate);
									break;
								}
							}
							else {
								List<EObject> refObjects = (List<EObject>) refObj;
								boolean found = false;
								for (EObject refOb : refObjects) {
									if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), refOb.eClass())) {
										selected.remove(candidate);
										found = true;
										break;
									}
								}
								if (found == true) {
									break;
								}
							}
						}
					}
					else {
						Object refObj = ModelManager.getReferredObject(refev.refName, object);
						if (refObj != null) {
							if (refObj instanceof EObject) {
								Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refObj);
								if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
									selected.remove(candidate);
									break;
								}
							}
							else {
								List<EObject> refObjects = (List<EObject>) refObj;
								boolean found = false;
								for (EObject refOb : refObjects) {
									Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refOb);
									if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
										selected.remove(candidate);
										found = true;
										break;
									}
								}
								if (found == true) {
									break;
								}
							}
						}
					}
				}
			}
		}
	}

//	private static void evaluateFirstReferenceGreater(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() > refev.size) {
//					selected.add(candidate);
//				}
//			}
//		}
//	}

//	private static void evaluateFirstReferenceGreaterOrEquals(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof EObject) {
//				if (refev.size == 1) {
//					selected.add(candidate);
//				}
//			}
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() >= refev.size) {
//					selected.add(candidate);
//				}
//			}
//		}
//	}
//	
//	private static void evaluateFirstReferenceLower(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() < refev.size) {
//					selected.add(candidate);
//				}
//			}
//		}
//	}
//
//	private static void evaluateFirstReferenceLowerOrEquals(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof EObject) {
//				if (refev.size == 1) {
//					selected.add(candidate);
//				}
//			}
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() <= refev.size) {
//					selected.add(candidate);
//				}
//			}
//		}
//	}

	/**
	 * evaluateReference evaluates the reference expression
	 * @param refev
	 * @param candidates
	 * @param selected
	 */
	private static void evaluateFirstReference(ReferenceEvaluation refev, List<EObject> candidates, Set<EObject> selected) {
		if (refev.operator.equals("not")) {
			selected.addAll(candidates);
		}
		for (EObject candidate : candidates) {
			if (refev.operator.equals("equals")) {
				evaluateFirstReferenceEquals(refev, candidate, selected);
			}
			if (refev.operator.equals("different")) {
				evaluateFirstReferenceDifferent(refev, candidate, selected);
			}
			if (refev.operator.equals("in")) {
				evaluateFirstReferenceIn(refev, candidate, selected);
			}
			if (refev.operator.equals("is")) {
				evaluateFirstReferenceIs(refev, candidate, selected);
			}
			if (refev.operator.equals("not")) {
				evaluateFirstReferenceNot(refev, candidate, selected);
			}
//			if (refev.operator.equals("gt")) {
//				evaluateFirstReferenceGreater(refev, candidate, selected);
//			}
//			if (refev.operator.equals("gte")) {
//				evaluateFirstReferenceGreaterOrEquals(refev, candidate, selected);
//			}
//			if (refev.operator.equals("lt")) {
//				evaluateFirstReferenceLower(refev, candidate, selected);
//			}
//			if (refev.operator.equals("lte")) {
//				evaluateFirstReferenceLowerOrEquals(refev, candidate, selected);
//			}
		}		
	}
	
	/**
	 * evaluateSecondAttributeAnd evaluates the second and
	 * next attribute expressions preceded by an 'and' operator
	 * @param attev
	 * @param candidates
	 * @param selected
	 * @param selected_tmp
	 */
	private static void evaluateSecondAttributeAnd(AttributeEvaluation attev, List<EObject> candidates, Set<EObject> selected, Set<EObject> selected_tmp) {
		for (EObject candidate : selected) {
			if (attev.operator.equals("equals")) {
				for (EAttribute att : candidate.eClass()
						.getEAllAttributes()) {
					if (att.getName().equals(attev.name)) {
						if (candidate.eGet(att) != null) {
							if (candidate.eGet(att).toString().equals(attev.values.get(0).toString())) {
								selected_tmp.remove(candidate);
							}
						}
					}
				}
			}
			if (attev.operator.equals("different")) {
				for (EAttribute att : candidate.eClass().getEAllAttributes()) {
					if (att.getName().equals(attev.name)) {
						if ((String) candidate.eGet(att) != null) {
							if (candidate.eGet(att).toString().equals(attev.values.get(0).toString())) {
								selected_tmp.remove(candidate);
							}
						}
					}
				}
			}
			if (attev.operator.equals("in")) {
				for (int i = 0; i < attev.values.size(); i++) {
					for (EAttribute att : candidate.eClass().getEAllAttributes()) {
						if (att.getName().equals(attev.name)) {
							// CASO DE QUE SEA STRING
							if (candidate.eGet(att) != null) {
								if (!candidate.eGet(att).equals(attev.values.get(i).toString())) {
									selected_tmp.remove(candidate);
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * evaluateSecondAttributeOr evaluates the second and
	 * next attribute expressions preceded by an 'or' operator
	 * @param attev
	 * @param candidates
	 * @param selected
	 * @param selected_tmp
	 */
	private static void evaluateSecondAttributeOr(AttributeEvaluation attev, List<EObject> candidates, Set<EObject> selected, Set<EObject> selected_tmp) {
		for (EObject candidate : candidates) {
			if (attev.operator.equals("equals")) {
				for (EAttribute att : candidate.eClass().getEAllAttributes()) {
					if (att.getName().equals(attev.name)) {
						if (candidate.eGet(att) != null) {
							if (candidate.eGet(att).toString().equals(attev.values.get(0).toString())) {
								if (!selected_tmp.contains(candidate)) {
									selected_tmp.add(candidate);
								}
							}
						}
					}
				}
			}
			if (attev.operator.equals("different")) {
				for (EAttribute att : candidate.eClass().getEAllAttributes()) {
					if (att.getName().equals(attev.name)) {
						if (candidate.eGet(att).toString().equals(attev.values.get(0).toString())) {
							if (!selected_tmp.contains(candidate)) {
								selected_tmp.add(candidate);
							}
						}
					}
				}
			}
			if (attev.operator.equals("in")) {
				List<String> tmp_values = new ArrayList<String>();
				tmp_values.addAll(attev.values);
				do {
					int n = ModelManager.getRandomIndex(tmp_values);
					for (EAttribute att : candidate.eClass().getEAllAttributes()) {
						if (att.getName().equals(attev.name)) {
							// CASO DE QUE SEA STRING
							if (attev.type.toLowerCase().equals("string")) {
								if (((String) candidate.eGet(att)).equals((String) tmp_values.get(n))) {
									if (!selected_tmp.contains(candidate)) {
										selected_tmp.add(candidate);
									}
								}
							}
						}
					}
				} while (selected.size() == selected_tmp.size()
						&& tmp_values.size() > 0);
			}
		}
	}
	
	/**
	 * evaluateSecondReferenceAndEquals evaluates
	 * the second reference expression and next when
	 * the link is an 'and' with operator '='
	 * @param refev
	 * @param candidate
	 * @param selected
	 * @param selected_tmp
	 */
	private static void evaluateSecondReferenceAndEquals(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof EObject) {
//				if (refev.size != 1) {
//					selected_tmp.remove(candidate);
//				}
//			}
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() != refev.size) {
//					selected_tmp.remove(candidate);
//				}
//			}
//			return;
//		}
		if (refev.name == null) {
			if (refev.container == false) {
				if (!candidate.equals(refev.value)) {
					selected_tmp.remove(candidate);
				}
			}
			else if (candidate.eContainer() != null && !candidate.eContainer().equals(refev.value)) {
				selected_tmp.remove(candidate);
			}
		} else {
			if (refev.refName == null) {
				if (refev.attName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (refev.value == null) {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									if (objects.size() > 0) {
										selected_tmp.remove(candidate);
									}
								}
								else {
									if (candidate.eGet(ref) != null) {
										selected_tmp.remove(candidate);
									}
								}
							} else {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = new ArrayList<EObject>();
									objects.addAll((List<EObject>) candidate.eGet(ref));
									if (refev.value instanceof List<?>) {
										boolean b = true;
										for (EObject obj : (List<EObject>) refev.value) {
											if (!objects.contains(obj)) {
												b = false;
												break;
											}
											objects.remove(obj);
										}
										if (b == false || objects.size() > 0) {
											selected_tmp.remove(candidate);
										}
									}
									else {
										EObject object = (EObject) refev.value;
										if (!objects.contains(object)) {
											selected_tmp.remove(candidate);
										}
									}
								}
								else {
									if (candidate.eGet(ref) instanceof EObject) {
										EObject object = (EObject) candidate.eGet(ref);
										if (refev.value instanceof List<?>) {
											List<EObject> objects = (List<EObject>) refev.value;
											if (!objects.contains(object)) {
												selected_tmp.remove(candidate);
											}
										}
										else {
											if (!object.equals(refev.value)) {
												selected_tmp.remove(candidate);
											}
										}
									}
								}
							}
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EAttribute att : object.eClass().getEAllAttributes()) {
										if (att.getName().equals(refev.attName)) {
											if (refev.value == null) {
												if (object.eGet(att) != null) {
													selected_tmp.remove(candidate);
												}
											}
											else {
												Object val = object.eGet(att);
												if (val instanceof EEnumLiteral) {
													val = ((EEnumLiteral) val).getLiteral();
												}
												if (!val.equals(refev.value)) {
													selected_tmp.remove(candidate);
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EAttribute att : object.eClass().getEAllAttributes()) {
											if (att.getName().equals(refev.attName)) {
												if (refev.value == null) {
													if (object.eGet(att) != null) {
														selected_tmp.remove(candidate);
													}
												}
												else {
													Object val = object.eGet(att);
													if (val instanceof EEnumLiteral) {
														val = ((EEnumLiteral) val).getLiteral();
													}
													if (!val.equals(refev.value)) {
														selected_tmp.remove(candidate);
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
			}
			else {
				if (refev.refRefName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (refev.value == null) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													if (obj != null) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objs = (List<EObject>) object.eGet(reff);
													if (objs.size() > 0) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
											} else {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													if (obj != null) {
														if (refev.value instanceof List<?>) {
															List<EObject> objects = (List<EObject>) refev.value;
															if (!objects.contains(obj)) {
																if (!selected_tmp.contains(candidate)) {
																	selected_tmp.add(candidate);
																}
															}

														}
														else {
															if (!obj.equals(refev.value)) {
																if (!selected_tmp.contains(candidate)) {
																	selected_tmp.add(candidate);
																}
															}
														}
													}
												}
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objs = (List<EObject>) object.eGet(reff);
													if (refev.value instanceof List<?>) {
														List<EObject> objects = new ArrayList<EObject>();
														objects.addAll((List<EObject>) refev.value);
														boolean b = true;
														for (EObject obj : objs) {
															if (!objects.contains(obj)) {
																b = false;
																break;
															}
															objects.remove(obj);
														}
														if (b == false || objects.size() > 0) {
															if (!selected_tmp.contains(candidate)) {
																selected_tmp.add(candidate);
															}
														}
													}
													else {
														boolean exists = false;
														for (EObject obj : objs) {
															if (obj.equals(refev.value)) {
																exists = true;
																break;
															}
														}
														if (exists == true) {
															if (!selected_tmp.contains(candidate)) {
																selected_tmp.add(candidate);
															}
														}
													}
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EReference reff : object.eClass().getEAllReferences()) {
											if (reff.getName().equals(refev.refName)) {
												if (refev.value == null) {
													if (object.eGet(reff) instanceof EObject) {
														EObject obj = (EObject) object.eGet(reff);
														if (obj == null) {
															if (!selected_tmp.contains(candidate)) {
																selected_tmp.add(candidate);
															}
														}
													}
													if (object.eGet(reff) instanceof List<?>) {
														List<EObject> objs = (List<EObject>) object.eGet(reff);
														if (objs.size() == 0) {
															if (!selected_tmp.contains(candidate)) {
																selected_tmp.add(candidate);
															}
														}
													}
												}
												else {
													if (object.eGet(reff) instanceof EObject) {
														EObject obj = (EObject) object.eGet(reff);
														if (refev.value instanceof List<?>) {
															List<EObject> objs = (List<EObject>) refev.value;
															if (objs.contains(obj)) {
																if (!selected_tmp.contains(candidate)) {
																	selected_tmp.add(candidate);
																}
															}
														}
														else {
															if (obj.equals(refev.value)) {
																if (!selected_tmp.contains(candidate)) {
																	selected_tmp.add(candidate);
																}
															}
														}
													}
													if (object.eGet(reff) instanceof List<?>) {
														List<EObject> objs = (List<EObject>) object.eGet(reff);
														if (refev.value instanceof List<?>) {
															List<EObject> lobjects = new ArrayList<EObject>();
															lobjects.addAll((List<EObject>) refev.value);
															boolean b = true;
															for (EObject obj : objs) {
																if (!lobjects.contains(obj)) {
																	b = false;
																	break;
																}
																lobjects.remove(obj);
															}
															if (b == true && lobjects.size() == 0) {
																if (!selected_tmp.contains(candidate)) {
																	selected_tmp.add(candidate);
																}
															}
														}
														else {
															for (EObject obj : objs) {
																if (obj.equals(refev.value)) {
																	if (!selected_tmp.contains(candidate)) {
																		selected_tmp.add(candidate);
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
							}
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (object.eGet(reff) instanceof EObject) {
												EObject obj = (EObject) object.eGet(reff);
												for (EReference refff : obj.eClass().getEAllReferences()) {
													if (refff.getName().equals(refev.refRefName)) {
														if (refev.value == null) {
															if (obj.eGet(refff) instanceof EObject) {
																EObject o = (EObject) obj.eGet(refff);
																if (o == null) {
																	if (!selected_tmp.contains(candidate)) {
																		selected_tmp.add(candidate);
																	}
																}
															}
															if (obj.eGet(refff) instanceof List<?>) {
																List<EObject> oo = (List<EObject>) obj.eGet(refff);
																if (oo.size() == 0) {
																	if (!selected_tmp.contains(candidate)) {
																		selected_tmp.add(candidate);
																	}
																}
																
															}
														}
														else {
															if (obj.eGet(refff) instanceof EObject) {
																EObject o = (EObject) obj.eGet(refff);
																if (refev.value instanceof List<?>) {
																	List<EObject> objects = (List<EObject>) refev.value;
																	if (objects.contains(o)) {
																		if (!selected_tmp.contains(candidate)) {
																			selected_tmp.add(candidate);
																		}
																	}
																}
																else {
																	if (o.equals(refev.value)) {
																		if (!selected_tmp.contains(candidate)) {
																			selected_tmp.add(candidate);
																		}
																	}
																}
															}
														}
													}
												}
											}
											else {
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objects = (List<EObject>) object.eGet(reff);
													for (EObject obj : objects) {
														for (EReference refff : obj.eClass().getEAllReferences()) {
															if (refff.getName().equals(refev.refRefName)) {
																if (refev.value == null) {
																	if (obj.eGet(refff) instanceof EObject) {
																		EObject o = (EObject) obj.eGet(refff);
																		if (o == null) {
																			if (!selected_tmp.contains(candidate)) {
																				selected_tmp.add(candidate);
																			}
																		}
																	}
																	if (obj.eGet(refff) instanceof List<?>) {
																		List<EObject> oo = (List<EObject>) obj.eGet(refff);
																		if (oo.size() == 0) {
																			if (!selected_tmp.contains(candidate)) {
																				selected_tmp.add(candidate);
																			}
																		}
																		
																	}
																}
																else {
																	if (obj.eGet(refff) instanceof EObject) {
																		EObject o = (EObject) obj.eGet(refff);
																		if (refev.value instanceof List<?>) {
																			List<EObject> objs = (List<EObject>) refev.value;
																			if (objs.contains(o)) {
																				if (!selected_tmp.contains(candidate)) {
																					selected_tmp.add(candidate);
																				}
																			}
																		}
																		else {
																			if (o.equals(refev.value)) {
																				if (!selected_tmp.contains(candidate)) {
																					selected_tmp.add(candidate);
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
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EReference reff : object.eClass().getEAllReferences()) {
											if (reff.getName().equals(refev.refName)) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													for (EReference refff : obj.eClass().getEAllReferences()) {
														if (refff.getName().equals(refev.refRefName)) {
															if (refev.value == null) {
																if (obj.eGet(refff) instanceof EObject) {
																	EObject o = (EObject) obj.eGet(refff);
																	if (o == null) {
																		if (!selected_tmp.contains(candidate)) {
																			selected_tmp.add(candidate);
																		}
																	}
																}
																if (obj.eGet(refff) instanceof EObject) {
																	List<EObject> oo = (List<EObject>) obj.eGet(refff);
																	if (oo.size() == 0) {
																		if (!selected_tmp.contains(candidate)) {
																			selected_tmp.add(candidate);
																		}
																	}
																}
															}
															else {
																if (obj.eGet(refff) instanceof EObject) {
																	EObject o = (EObject) obj.eGet(refff);
																	if (refev.value instanceof List<?>) {
																		List<EObject> objs = (List<EObject>) refev.value;
																		if (objs.contains(o)) {
																			if (!selected_tmp.contains(candidate)) {
																				selected_tmp.add(candidate);
																			}
																		}
																	}
																	else {
																		if (o.equals(refev.value)) {
																			if (!selected_tmp.contains(candidate)) {
																				selected_tmp.add(candidate);
																			}
																		}
																	}
																}
																if (obj.eGet(refff) instanceof List<?>) {
																	List<EObject> oo = (List<EObject>) obj.eGet(refff);
																	if (refev.value instanceof List<?>) {
																		List<EObject> lobjects = new ArrayList<EObject>();
																		lobjects.addAll((List<EObject>) refev.value);
																		boolean b = true;
																		for (EObject o : oo) {
																			if (!lobjects.contains(o)) {
																				b = false;
																				break;
																			}
																			lobjects.remove(o);
																		}
																		if (b == true && lobjects.size() == 0) {
																			if (!selected_tmp.contains(candidate)) {
																				selected_tmp.add(candidate);
																			}
																		}
																	}
																	else {
																		for (EObject o : oo) {
																			if (o.equals(refev.value)) {
																				if (!selected_tmp.contains(candidate)) {
																					selected_tmp.add(candidate);
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
	
	/**
	 * evaluateSecondReferenceAndDifferent evaluates
	 * the second reference expression and next when
	 * the link is an 'and' with operator '<>'
	 * @param refev
	 * @param candidate
	 * @param selected
	 * @param selected_tmp
	 */
	private static void evaluateSecondReferenceAndDifferent(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof EObject) {
//				if (refev.size == 1) {
//					selected_tmp.remove(candidate);
//				}
//			}
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() == refev.size) {
//					selected_tmp.remove(candidate);
//				}
//			}
//			return;
//		}
		if (refev.name == null) {
			if (refev.container == false) {
				if (candidate.equals(refev.value)) {
					selected_tmp.remove(candidate);
				}
			}
			else if (candidate.eContainer() != null && candidate.eContainer().equals(refev.value)) {
				selected_tmp.remove(candidate);
			}
		} else {
			if (refev.refName == null) {
				if (refev.attName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals("null")) {
							if (refev.value == null) {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									if (objects.size() == 0) {
										selected_tmp.remove(candidate);
									}
								}
								else {
									if (candidate.eGet(ref) == null) {
										selected_tmp.remove(candidate);
									}
								}
							}
						} else {
							if (ref.getName().equals(refev.name)) {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = new ArrayList<EObject>();
									objects.addAll((List<EObject>) candidate.eGet(ref));
									if (refev.value instanceof List<?>) {
										List<EObject> objs = (List<EObject>) refev.value;
										boolean b = true;
										for (EObject obj : objs) {
											if (!objects.contains(obj)) {
												b = false;
												break;
											}
											objects.remove(obj);
										}
										if (b == true && objects.size() == 0) {
											selected_tmp.remove(candidate);
										}
									}
									else {
										EObject obj = (EObject) refev.value;
										if (objects.contains(obj)) {
											selected_tmp.remove(candidate);
										}
									}
								}
								else {
									if (candidate.eGet(ref) instanceof EObject) {
										EObject object = (EObject) candidate.eGet(ref);
										if (refev.value instanceof List<?>) {
											List<EObject> objects = (List<EObject>) refev.value;
											if (objects.contains(object)) {
												selected_tmp.remove(candidate);
											}
										}
										else {
											if (object.equals(refev.value)) {
												selected_tmp.remove(candidate);
											}
										}
									}
								}
							}
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EAttribute att : object.eClass().getEAllAttributes()) {
										if (att.getName().equals(refev.attName)) {
											if (refev.value == null) {
												if (object.eGet(att) == null) {
													selected_tmp.remove(candidate);
												}
											}
											else {
												Object val = object.eGet(att);
												if (val instanceof EEnumLiteral) {
													val = ((EEnumLiteral) val).getLiteral();
												}
												if (val.equals(refev.value)) {
													selected_tmp.remove(candidate);
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EAttribute att : object.eClass().getEAllAttributes()) {
											if (att.getName().equals(refev.attName)) {
												if (refev.value == null) {
													if (object.eGet(att) == null) {
														selected_tmp.remove(candidate);
													}
												}
												else {
													Object val = object.eGet(att);
													if (val instanceof EEnumLiteral) {
														val = ((EEnumLiteral) val).getLiteral();
													}
													if (val.equals(refev.value)) {
														selected_tmp.remove(candidate);
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
			}
			else {
				if (refev.refRefName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals("null")) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (refev.value == null) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													if (obj == null) {
														selected_tmp.remove(candidate);
													}
												}
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objs = (List<EObject>) object.eGet(reff);
													if (objs.size() == 0) {
														selected_tmp.remove(candidate);
													}
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EReference reff : object.eClass().getEAllReferences()) {
											if (reff.getName().equals(refev.refName)) {
												if (refev.value == null) {
													if (object.eGet(reff) instanceof EObject) {
														EObject obj = (EObject) object.eGet(reff);
														if (obj == null) {
															selected_tmp.remove(candidate);
														}
													}
													if (object.eGet(reff) instanceof List<?>) {
														List<EObject> objs = (List<EObject>) object.eGet(reff);
														if (objs.size() == 0) {
															selected_tmp.remove(candidate);
														}
													}
												}
											}
										}
									}
								}
							}
						} else {
							if (ref.getName().equals(refev.name)) {
								if (candidate.eGet(ref) != null) {
									if (candidate.eGet(ref) instanceof EObject) {
										EObject object = (EObject) candidate.eGet(ref);
										for (EReference reff : object.eClass().getEAllReferences()) {
											if (reff.getName().equals(refev.refName)) {
												if (refev.value != null) {
													if (object.eGet(reff) instanceof EObject) {
														EObject obj = (EObject) object.eGet(reff);
														if (obj != null) {
															if (refev.value instanceof List<?>) {
																List<EObject> objects = (List<EObject>) refev.value;
																if (objects.contains(obj)) {
																	selected_tmp.remove(candidate);
																}
															}
															else {
																if (obj.equals(refev.value)) {
																	selected_tmp.remove(candidate);
																}
															}
														}
													}
													if (object.eGet(reff) instanceof List<?>) {
														List<EObject> objs = (List<EObject>) object.eGet(reff);
														if (refev.value instanceof List<?>) {
															List<EObject> objects = new ArrayList<EObject>();
															objects.addAll((List<EObject>) refev.value);
															boolean b = true;
															for (EObject obj : objs) {
																if (!objects.contains(obj)) {
																	b = false;
																	break;
																}
																objects.remove(obj);
															}
															if (b == true && objects.size() == 0) {
																selected_tmp.remove(candidate);
															}
														}
														else {
															for (EObject obj : objs) {
																if (obj.equals(refev.value)) {
																	selected_tmp.remove(candidate);
																}
															}
														}
													}
												}
											}
										}
									}
									if (candidate.eGet(ref) instanceof List<?>) {
										List<EObject> objects = (List<EObject>) candidate.eGet(ref);
										for (EObject object : objects) {
											for (EReference reff : object.eClass().getEAllReferences()) {
												if (reff.getName().equals(refev.refName)) {
													if (refev.value != null) {
														if (object.eGet(reff) instanceof EObject) {
															EObject obj = (EObject) object.eGet(reff);
															if (obj.equals(refev.value)) {
																selected_tmp.remove(candidate);
															}
														}
														if (object.eGet(reff) instanceof List<?>) {
															List<EObject> objs = (List<EObject>) object.eGet(reff);
															for (EObject obj : objs) {
																if (obj.equals(refev.value)) {
																	selected_tmp.remove(candidate);
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
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (object.eGet(reff) instanceof EObject) {
												EObject obj = (EObject) object.eGet(reff);
												for (EReference refff : obj.eClass().getEAllReferences()) {
													if (refff.getName().equals(refev.refRefName)) {
														if (refev.value == null) {
															if (obj.eGet(refff) instanceof EObject) {
																EObject o = (EObject) obj.eGet(refff);
																if (o == null) {
																	selected_tmp.remove(candidate);
																}
															}
															if (obj.eGet(refff) instanceof List<?>) {
																List<EObject> oo = (List<EObject>) obj.eGet(refff);
																if (oo.size() == 0) {
																	selected_tmp.remove(candidate);
																}
															}
														}
														else {
															if (obj.eGet(refff) instanceof EObject) {
																EObject o = (EObject) obj.eGet(refff);
																if (refev.value instanceof List<?>) {
																	List<EObject> objects = (List<EObject>) refev.value;
																	if (objects.contains(o)) {
																		selected_tmp.remove(candidate);
																	}
																}
																else {
																	if (o.equals(refev.value)) {
																		selected_tmp.remove(candidate);
																	}
																}
															}
														}
													}
												}
											}
											else {
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objects = (List<EObject>) object.eGet(reff);
													for (EObject obj : objects) {
														for (EReference refff : obj.eClass().getEAllReferences()) {
															if (refff.getName().equals(refev.refRefName)) {
																if (refev.value == null) {
																	if (obj.eGet(refff) instanceof EObject) {
																		EObject o = (EObject) obj.eGet(refff);
																		if (o == null) {
																			selected_tmp.remove(candidate);
																		}
																	}
																	if (obj.eGet(refff) instanceof List<?>) {
																		List<EObject> oo = (List<EObject>) obj.eGet(refff);
																		if (oo.size() == 0) {
																			selected_tmp.remove(candidate);
																		}
																	}
																}
																else {
																	if (obj.eGet(refff) instanceof EObject) {
																		EObject o = (EObject) obj.eGet(refff);
																		if (refev.value instanceof List<?>) {
																			List<EObject> objs = (List<EObject>) refev.value;
																			if (objs.contains(o)) {
																				selected_tmp.remove(candidate);
																			}
																		}
																		else {
																			if (o.equals(refev.value)) {
																				selected_tmp.remove(candidate);
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
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EReference reff : object.eClass().getEAllReferences()) {
											if (reff.getName().equals(refev.refName)) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													for (EReference refff : obj.eClass().getEAllReferences()) {
														if (refff.getName().equals(refev.refRefName)) {
															if (refev.value == null) {
																if (obj.eGet(refff) instanceof EObject) {
																	EObject o = (EObject) obj.eGet(refff);
																	if (o == null) {
																		selected_tmp.remove(candidate);
																	}
																}
																if (obj.eGet(refff) instanceof EObject) {
																	List<EObject> oo = (List<EObject>) obj.eGet(refff);
																	if (oo.size() == 0) {
																		selected_tmp.remove(candidate);
																	}
																}
															}
															else {
																if (obj.eGet(refff) instanceof EObject) {
																	EObject o = (EObject) obj.eGet(refff);
																	if (refev.value instanceof List<?>) {
																		List<EObject> objs = (List<EObject>) refev.value;
																		if (objs.contains(o)) {
																			selected_tmp.remove(candidate);
																		}
																	}
																	else {
																		if (o.equals(refev.value)) {
																			selected_tmp.remove(candidate);
																		}
																	}
																}
																if (obj.eGet(refff) instanceof List<?>) {
																	List<EObject> oo = (List<EObject>) obj.eGet(refff);
																	if (refev.value instanceof List<?>) {
																		List<EObject> lobjects = new ArrayList<EObject>();
																		lobjects.addAll((List<EObject>) refev.value);
																		boolean b = true;
																		for (EObject o : oo) {
																			if (!lobjects.contains(o)) {
																				b = false;
																				break;
																			}
																			lobjects.remove(o);
																		}
																		if (b == true && lobjects.size() == 0) {
																			selected_tmp.remove(candidate);
																		}
																	}
																	else {
																		for (EObject o : oo) {
																			if (o.equals(refev.value)) {
																				selected_tmp.remove(candidate);
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
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * evaluateSecondReferenceAndIn evaluates
	 * the second reference expression and next when
	 * the link is an 'and' with operator 'in'
	 * @param refev
	 * @param candidate
	 * @param selected
	 * @param selected_tmp
	 */
	private static void evaluateSecondReferenceAndIn(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
		if (refev.name != null) {
			if (refev.refName == null) {
				if (refev.attName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (refev.value != null) {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = new ArrayList<EObject>();
									objects.addAll((List<EObject>) candidate.eGet(ref));
									if (refev.value instanceof List<?>) {
										boolean b = true;
										for (EObject obj : (List<EObject>) refev.value) {
											if (!objects.contains(obj)) {
												b = false;
												break;
											}
											objects.remove(obj);
										}
										if (b == false || objects.size() > 0) {
											selected_tmp.remove(candidate);
										}
									}
									else {
										EObject object = (EObject) refev.value;
										if (!objects.contains(object)) {
											selected_tmp.remove(candidate);
										}
									}
								}
								else {
									if (candidate.eGet(ref) instanceof EObject) {
										EObject object = (EObject) candidate.eGet(ref);
										if (refev.value instanceof List<?>) {
											List<EObject> objects = (List<EObject>) refev.value;
											if (!objects.contains(object)) {
												selected_tmp.remove(candidate);
											}
										}
										else {
											if (!object.equals(refev.value)) {
												selected_tmp.remove(candidate);
											}
										}
									}
								}
							}
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EAttribute att : object.eClass().getEAllAttributes()) {
										if (att.getName().equals(refev.attName)) {
											if (refev.value != null) {
												Object val = object.eGet(att);
												if (val instanceof EEnumLiteral) {
													val = ((EEnumLiteral) val).getLiteral();
												}
												if (!val.equals(refev.value)) {
													selected_tmp.remove(candidate);
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EAttribute att : object.eClass().getEAllAttributes()) {
											if (att.getName().equals(refev.attName)) {
												if (refev.value != null) {
													Object val = object.eGet(att);
													if (val instanceof EEnumLiteral) {
														val = ((EEnumLiteral) val).getLiteral();
													}
													if (!val.equals(refev.value)) {
														selected_tmp.remove(candidate);
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
			}
			else {
				if (refev.refRefName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (refev.value != null) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													if (obj != null) {
														if (refev.value instanceof List<?>) {
															List<EObject> objects = (List<EObject>) refev.value;
															if (!objects.contains(obj)) {
																if (!selected_tmp.contains(candidate)) {
																	selected_tmp.add(candidate);
																}
															}

														}
														else {
															if (!obj.equals(refev.value)) {
																if (!selected_tmp.contains(candidate)) {
																	selected_tmp.add(candidate);
																}
															}
														}
													}
												}
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objs = (List<EObject>) object.eGet(reff);
													if (refev.value instanceof List<?>) {
														List<EObject> objects = new ArrayList<EObject>();
														objects.addAll((List<EObject>) refev.value);
														boolean b = true;
														for (EObject obj : objs) {
															if (!objects.contains(obj)) {
																b = false;
																break;
															}
															objects.remove(obj);
														}
														if (b == false || objects.size() > 0) {
															if (!selected_tmp.contains(candidate)) {
																selected_tmp.add(candidate);
															}
														}
													}
													else {
														boolean exists = false;
														for (EObject obj : objs) {
															if (obj.equals(refev.value)) {
																exists = true;
																break;
															}
														}
														if (exists == true) {
															if (!selected_tmp.contains(candidate)) {
																selected_tmp.add(candidate);
															}
														}
													}
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EReference reff : object.eClass().getEAllReferences()) {
											if (reff.getName().equals(refev.refName)) {
												if (refev.value != null) {
													if (object.eGet(reff) instanceof EObject) {
														EObject obj = (EObject) object.eGet(reff);
														if (refev.value instanceof List<?>) {
															List<EObject> objs = (List<EObject>) refev.value;
															if (objs.contains(obj)) {
																if (!selected_tmp.contains(candidate)) {
																	selected_tmp.add(candidate);
																}
															}
														}
														else {
															if (obj.equals(refev.value)) {
																if (!selected_tmp.contains(candidate)) {
																	selected_tmp.add(candidate);
																}
															}
														}
													}
													if (object.eGet(reff) instanceof List<?>) {
														List<EObject> objs = (List<EObject>) object.eGet(reff);
														if (refev.value instanceof List<?>) {
															List<EObject> lobjects = new ArrayList<EObject>();
															lobjects.addAll((List<EObject>) refev.value);
															boolean b = true;
															for (EObject obj : objs) {
																if (!lobjects.contains(obj)) {
																	b = false;
																	break;
																}
																lobjects.remove(obj);
															}
															if (b == true && lobjects.size() == 0) {
																if (!selected_tmp.contains(candidate)) {
																	selected_tmp.add(candidate);
																}
															}
														}
														else {
															for (EObject obj : objs) {
																if (obj.equals(refev.value)) {
																	if (!selected_tmp.contains(candidate)) {
																		selected_tmp.add(candidate);
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
							}
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (object.eGet(reff) instanceof EObject) {
												EObject obj = (EObject) object.eGet(reff);
												for (EReference refff : obj.eClass().getEAllReferences()) {
													if (refff.getName().equals(refev.refRefName)) {
														if (refev.value != null) {
															if (obj.eGet(refff) instanceof EObject) {
																EObject o = (EObject) obj.eGet(refff);
																if (refev.value instanceof List<?>) {
																	List<EObject> objects = (List<EObject>) refev.value;
																	if (objects.contains(o)) {
																		if (!selected_tmp.contains(candidate)) {
																			selected_tmp.add(candidate);
																		}
																	}
																}
																else {
																	if (o.equals(refev.value)) {
																		if (!selected_tmp.contains(candidate)) {
																			selected_tmp.add(candidate);
																		}
																	}
																}
															}
														}
													}
												}
											}
											else {
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objects = (List<EObject>) object.eGet(reff);
													for (EObject obj : objects) {
														for (EReference refff : obj.eClass().getEAllReferences()) {
															if (refff.getName().equals(refev.refRefName)) {
																if (refev.value != null) {
																	if (obj.eGet(refff) instanceof EObject) {
																		EObject o = (EObject) obj.eGet(refff);
																		if (refev.value instanceof List<?>) {
																			List<EObject> objs = (List<EObject>) refev.value;
																			if (objs.contains(o)) {
																				if (!selected_tmp.contains(candidate)) {
																					selected_tmp.add(candidate);
																				}
																			}
																		}
																		else {
																			if (o.equals(refev.value)) {
																				if (!selected_tmp.contains(candidate)) {
																					selected_tmp.add(candidate);
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
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EReference reff : object.eClass().getEAllReferences()) {
											if (reff.getName().equals(refev.refName)) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													for (EReference refff : obj.eClass().getEAllReferences()) {
														if (refff.getName().equals(refev.refRefName)) {
															if (refev.value != null) {
																if (obj.eGet(refff) instanceof EObject) {
																	EObject o = (EObject) obj.eGet(refff);
																	if (refev.value instanceof List<?>) {
																		List<EObject> objs = (List<EObject>) refev.value;
																		if (objs.contains(o)) {
																			if (!selected_tmp.contains(candidate)) {
																				selected_tmp.add(candidate);
																			}
																		}
																	}
																	else {
																		if (o.equals(refev.value)) {
																			if (!selected_tmp.contains(candidate)) {
																				selected_tmp.add(candidate);
																			}
																		}
																	}
																}
																if (obj.eGet(refff) instanceof List<?>) {
																	List<EObject> oo = (List<EObject>) obj.eGet(refff);
																	if (refev.value instanceof List<?>) {
																		List<EObject> lobjects = new ArrayList<EObject>();
																		lobjects.addAll((List<EObject>) refev.value);
																		boolean b = true;
																		for (EObject o : oo) {
																			if (!lobjects.contains(o)) {
																				b = false;
																				break;
																			}
																			lobjects.remove(o);
																		}
																		if (b == true && lobjects.size() == 0) {
																			if (!selected_tmp.contains(candidate)) {
																				selected_tmp.add(candidate);
																			}
																		}
																	}
																	else {
																		for (EObject o : oo) {
																			if (o.equals(refev.value)) {
																				if (!selected_tmp.contains(candidate)) {
																					selected_tmp.add(candidate);
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

	/**
	 * evaluateSecondReferenceIs evaluates the second reference expression
	 * when the operator is 'is'
	 * @param refev
	 * @param candidate
	 * @param selected
	 */
	private static void evaluateSecondReferenceAndIs(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
		if (refev.name == null) {
			if (refev.container == false) {
				if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) candidate).eClass())) {
					selected_tmp.remove(candidate);
				}
			}
			else if (candidate.eContainer() != null && refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) candidate).eContainer().eClass()) ) {
				selected_tmp.remove(candidate);
			}
		}
		else {
			Object obj = ModelManager.getReferredObject(refev.name, candidate);
			if (obj instanceof EObject) {
				if (refev.refName == null) {
					if (refev.attName == null) {
						if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) obj).eClass())) {
							selected_tmp.remove(candidate);
						}
					}
				}
				else {
					if (refev.refRefName == null) {
						Object refObj = ModelManager.getReferredObject(refev.refName, (EObject) obj);
						if (refObj != null) {
							if (refObj instanceof EObject) {
								if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refObj).eClass())) {
									selected_tmp.remove(candidate);
								}
							}
							else {
								List<EObject> objects = (List<EObject>) refObj;
								for (EObject object : objects) {
									if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), object.eClass())) {
										selected_tmp.remove(candidate);
										break;
									}
								}
							}
						}
					}
					else {
						Object refObj = ModelManager.getReferredObject(refev.refName, (EObject) obj);
						if (refObj != null) {
							if (refObj instanceof EObject) {
								Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refObj);
								if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
									selected_tmp.remove(candidate);
								}
							}
							else {
								List<EObject> objects = (List<EObject>) refObj;
								for (EObject object : objects) {
									Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) object);
									if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
										selected_tmp.remove(candidate);
										break;
									}
								}
							}
						}
					}
				}
			}
			if (obj instanceof List<?>) {
				List<EObject> objects = (List<EObject>) obj;
				for (EObject object : objects) {
					if (refev.refName == null) {
						if (refev.attName == null) {
							if (!EcoreUtil.equals((EObject) refev.value, object)) {
								selected_tmp.remove(candidate);
								break;
							}
						}
					}
					else {
						if (refev.refRefName == null) {
							Object refObj = ModelManager.getReferredObject(refev.refName, object);
							if (refObj != null) {
								if (refObj instanceof EObject) {
									Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refObj);
									if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
										selected_tmp.remove(candidate);
										break;
									}
								}
								else {
									List<EObject> refObjects = (List<EObject>) refObj;
									boolean found = false;
									for (EObject refOb : refObjects) {
										Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refOb);
										if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
											selected_tmp.remove(candidate);
											found = true;
											break;
										}
									}
									if (found == true) {
										break;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * evaluateSecondReferenceIs evaluates the second reference expression
	 * when the operator is 'is'
	 * @param refev
	 * @param candidate
	 * @param selected
	 */
	private static void evaluateSecondReferenceOrIs(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
		if (refev.name == null) {
			if (refev.container == false) {
				if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) candidate).eClass())) {
					selected_tmp.add(candidate);
				}
			}
			else if (candidate.eContainer() != null && refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) candidate).eContainer().eClass()) ) {
				selected_tmp.add(candidate);
			}
		}
		else {
			Object obj = ModelManager.getReferredObject(refev.name, candidate);
			if (obj instanceof EObject) {
				if (refev.refName == null) {
					if (refev.attName == null) {
						if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) obj).eClass())) {
							selected_tmp.add(candidate);
						}
					}
				}
				else {
					if (refev.refRefName == null) {
						Object refObj = ModelManager.getReferredObject(refev.refName, (EObject) obj);
						if (refObj != null) {
							if (refObj instanceof EObject) {
								if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refObj).eClass())) {
									selected_tmp.add(candidate);
								}
							}
							else {
								List<EObject> objects = (List<EObject>) refObj;
								for (EObject object : objects) {
									if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), object)) {
										selected_tmp.add(candidate);
										break;
									}
								}
							}
						}
					}
					else {
						Object refObj = ModelManager.getReferredObject(refev.refName, (EObject) obj);
						if (refObj != null) {
							if (refObj instanceof EObject) {
								Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refObj);
								if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
									selected_tmp.add(candidate);
								}
							}
							else {
								List<EObject> objects = (List<EObject>) refObj;
								for (EObject object : objects) {
									Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) object);
									if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
										selected_tmp.add(candidate);
										break;
									}
								}
							}
						}
					}
				}
			}
			if (obj instanceof List<?>) {
				List<EObject> objects = (List<EObject>) obj;
				for (EObject object : objects) {
					if (refev.refName == null) {
						if (refev.attName == null) {
							if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), object.eClass())) {
								selected_tmp.add(candidate);
								break;
							}
						}
					}
					else {
						if (refev.refRefName == null) {
							Object refObj = ModelManager.getReferredObject(refev.refName, object);
							if (refObj != null) {
								if (refObj instanceof EObject) {
									Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refObj);
									if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
										selected_tmp.add(candidate);
										break;
									}
								}
								else {
									List<EObject> refObjects = (List<EObject>) refObj;
									boolean found = false;
									for (EObject refOb : refObjects) {
										Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refOb);
										if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
											selected_tmp.add(candidate);
											found = true;
											break;
										}
									}
									if (found == true) {
										break;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * evaluateSecondReferenceNot evaluates the second reference expression
	 * when the operator is 'not'
	 * @param refev
	 * @param candidate
	 * @param selected
	 */
	private static void evaluateSecondReferenceAndNot(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
		if (refev.name == null) {
			if (refev.container == false) {
				if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), candidate.eClass())) {
					selected_tmp.remove(candidate);
				}
			}
			else if (candidate.eContainer() != null && refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), candidate.eContainer().eClass()) ) {
				selected_tmp.remove(candidate);
			}
			return;
		}
		Object obj = ModelManager.getReferredObject(refev.name, candidate);
		if (obj instanceof EObject) {
			if (refev.refName == null) {
				if (refev.attName == null) {
					if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) obj).eClass())) {
						selected_tmp.remove(candidate);
					}
				}
			}
			else {
				if (refev.refRefName == null) {
					Object refObj = ModelManager.getReferredObject(refev.refName, (EObject) obj);
					if (refObj != null) {
						if (refObj instanceof EObject) {
							if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refObj).eClass())) {
								selected_tmp.remove(candidate);
							}
						}
						else {
							List<EObject> objects = (List<EObject>) refObj;
							for (EObject object : objects) {
								if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), object.eClass())) {
									selected_tmp.remove(candidate);
									break;
								}
							}
						}
					}
				}
				else {
					Object refObj = ModelManager.getReferredObject(refev.refName, (EObject) obj);
					if (refObj != null) {
						if (refObj instanceof EObject) {
							Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refObj);
							if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
								selected_tmp.remove(candidate);
							}
						}
						else {
							List<EObject> objects = (List<EObject>) refObj;
							for (EObject object : objects) {
								Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) object);
								if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
									selected_tmp.remove(candidate);
									break;
								}
							}
						}
					}
				}
			}
		}
		if (obj instanceof List<?>) {
			List<EObject> objects = (List<EObject>) obj;
			for (EObject object : objects) {
				if (refev.refName == null) {
					if (refev.attName == null) {
						if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), object.eClass())) {
							selected_tmp.remove(candidate);
							break;
						}
					}
				}
				else {
					if (refev.refRefName == null) {
						Object refObj = ModelManager.getReferredObject(refev.refName, object);
						if (refObj != null) {
							if (refObj instanceof EObject) {
								Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refObj);
								if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
									selected_tmp.remove(candidate);
									break;
								}
							}
							else {
								List<EObject> refObjects = (List<EObject>) refObj;
								boolean found = false;
								for (EObject refOb : refObjects) {
									Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refOb);
									if (refev.value != null && EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
										selected_tmp.remove(candidate);
										found = true;
										break;
									}
								}
								if (found == true) {
									break;
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * evaluateSecondReferenceNot evaluates the second reference expression
	 * when the operator is 'not'
	 * @param refev
	 * @param candidate
	 * @param selected
	 */
	private static void evaluateSecondReferenceOrNot(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
		if (refev.name == null) {
			if (refev.container == false) {
				if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), candidate.eClass())) {
					selected_tmp.add(candidate);
				}
			}
			else if (candidate.eContainer() != null && refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), candidate.eContainer().eClass())) {
				selected_tmp.add(candidate);
			}
			return;
		}
		Object obj = ModelManager.getReferredObject(refev.name, candidate);
		if (obj instanceof EObject) {
			if (refev.refName == null) {
				if (refev.attName == null) {
					if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) obj).eClass())) {
						selected_tmp.add(candidate);
					}
				}
			}
			else {
				if (refev.refRefName == null) {
					Object refObj = ModelManager.getReferredObject(refev.refName, (EObject) obj);
					if (refObj != null) {
						if (refObj instanceof EObject) {
							if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refObj).eClass())) {
								selected_tmp.add(candidate);
							}
						}
						else {
							List<EObject> objects = (List<EObject>) refObj;
							for (EObject object : objects) {
								if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), object.eClass())) {
									selected_tmp.add(candidate);
									break;
								}
							}
						}
					}
				}
				else {
					Object refObj = ModelManager.getReferredObject(refev.refName, (EObject) obj);
					if (refObj != null) {
						if (refObj instanceof EObject) {
							Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refObj);
							if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
								selected_tmp.add(candidate);
							}
						}
						else {
							List<EObject> objects = (List<EObject>) refObj;
							for (EObject object : objects) {
								Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) object);
								if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
									selected_tmp.add(candidate);
									break;
								}
							}
						}
					}
				}
			}
		}
		if (obj instanceof List<?>) {
			List<EObject> objects = (List<EObject>) obj;
			for (EObject object : objects) {
				if (refev.refName == null) {
					if (refev.attName == null) {
						if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), object.eClass())) {
							selected_tmp.add(candidate);
							break;
						}
					}
				}
				else {
					if (refev.refRefName == null) {
						Object refObj = ModelManager.getReferredObject(refev.refName, object);
						if (refObj != null) {
							if (refObj instanceof EObject) {
								Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refObj);
								if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
									selected_tmp.add(candidate);
									break;
								}
							}
							else {
								List<EObject> refObjects = (List<EObject>) refObj;
								boolean found = false;
								for (EObject refOb : refObjects) {
									Object refRefObj = ModelManager.getReferredObject(refev.refRefName, (EObject) refOb);
									if (refev.value != null && !EcoreUtil.equals(((EObject) refev.value).eClass(), ((EObject) refRefObj).eClass())) {
										selected_tmp.add(candidate);
										found = true;
										break;
									}
								}
								if (found == true) {
									break;
								}
							}
						}
					}
				}
			}
		}
	}

//	private static void evaluateSecondReferenceAndGreater(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof EObject) {
//				if (refev.size <= 1) {
//					selected_tmp.remove(candidate);
//				}
//			}
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() <= refev.size) {
//					selected_tmp.remove(candidate);
//				}
//			}
//		}
//	}

//	private static void evaluateSecondReferenceAndGreaterOrEquals(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() < refev.size) {
//					selected_tmp.remove(candidate);
//				}
//			}
//		}
//	}
	
//	private static void evaluateSecondReferenceAndLower(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof EObject) {
//				if (refev.size >= 1) {
//					selected_tmp.remove(candidate);
//				}
//			}
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() >= refev.size) {
//					selected_tmp.remove(candidate);
//				}
//			}
//		}
//	}

//	private static void evaluateSecondReferenceAndLowerOrEquals(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() > refev.size) {
//					selected_tmp.remove(candidate);
//				}
//			}
//		}
//	}
	
	/**
	 * evaluateSecondReferenceAnd evaluates second reference
	 * expression and next when preceded by an 'and' operator
	 * @param refev
	 * @param candidates
	 * @param selected
	 * @param selected_tmp
	 */
	private static void evaluateSecondReferenceAnd(ReferenceEvaluation refev, List<EObject> candidates, Set<EObject> selected, Set<EObject> selected_tmp) {
		for (EObject candidate : selected) {
			if (refev.operator.equals("equals")) {
				evaluateSecondReferenceAndEquals(refev, candidate, selected, selected_tmp);
			}
			if (refev.operator.equals("different")) {
				evaluateSecondReferenceAndDifferent(refev, candidate, selected, selected_tmp);
			}
			if (refev.operator.equals("in")) {
				evaluateSecondReferenceAndIn(refev, candidate, selected, selected_tmp);
			}
			if (refev.operator.equals("is")) {
				evaluateSecondReferenceAndIs(refev, candidate, selected, selected_tmp);
			}
			if (refev.operator.equals("not")) {
				evaluateSecondReferenceAndNot(refev, candidate, selected, selected_tmp);
			}
//			if (refev.operator.equals("gt")) {
//				evaluateSecondReferenceAndGreater(refev, candidate, selected, selected_tmp);
//			}
//			if (refev.operator.equals("gte")) {
//				evaluateSecondReferenceAndGreaterOrEquals(refev, candidate, selected, selected_tmp);
//			}
//			if (refev.operator.equals("lt")) {
//				evaluateSecondReferenceAndLower(refev, candidate, selected, selected_tmp);
//			}
//			if (refev.operator.equals("lte")) {
//				evaluateSecondReferenceAndLowerOrEquals(refev, candidate, selected, selected_tmp);
//			}
		}		
	}
	
	/**
	 * evaluateSecondReferenceOrEquals evaluates
	 * the second reference expression and next when
	 * the link is an 'or' with operator '='
	 * @param refev
	 * @param candidate
	 * @param selected
	 * @param selected_tmp
	 */
	protected static void evaluateSecondReferenceOrEquals(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof EObject) {
//				if (refev.size == 1) {
//					selected_tmp.add(candidate);
//				}
//			}
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() == refev.size) {
//					selected_tmp.add(candidate);
//				}
//			}
//			return;
//		}
		if (refev.name == null) {
			if (refev.container == false) {
				if (candidate.equals(refev.value)) {
					if (!selected_tmp.contains(candidate)) {
						selected_tmp.add(candidate);
					}
				}
			}
			else if (candidate.eContainer() != null && candidate.eContainer().equals(refev.value)) {
				if (!selected_tmp.contains(candidate)) {
					selected_tmp.add(candidate);
				}
			}
		} else {
			if (refev.refName == null) {
				if (refev.attName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (refev.value == null) {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									if (objects.size() == 0) {
										if (!selected_tmp.contains(candidate)) {
											selected_tmp.add(candidate);
										}
									}
								}
								else {
									if (candidate.eGet(ref) == null) {
										if (!selected_tmp.contains(candidate)) {
											selected_tmp.add(candidate);
										}
									}
								}
							} else {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = new ArrayList<EObject>();
									objects.addAll((List<EObject>) candidate.eGet(ref));
									if (refev.value instanceof List<?>) {
										boolean b = true;
										for (EObject obj : (List<EObject>) refev.value) {
											if (!objects.contains(obj)) {
												b = false;
												break;
											}
											objects.remove(obj);
										}
										if (b == true && objects.size() == 0) {
											if (!selected_tmp.contains(candidate)) {
												selected_tmp.add(candidate);
											}
										}
									}
									else {
										EObject object = (EObject) refev.value;
										if (objects.contains(object)) {
											if (!selected_tmp.contains(candidate)) {
												selected_tmp.add(candidate);
											}
										}
									}
								}
								else {
									if (candidate.eGet(ref) instanceof EObject) {
										EObject object = (EObject) candidate.eGet(ref);
										if (refev.value instanceof List<?>) {
											List<EObject> objects = (List<EObject>) refev.value;
											if (objects.contains(object)) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										else {
											if (object.equals(refev.value)) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
									}
								}
							}
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EAttribute att : object.eClass().getEAllAttributes()) {
										if (att.getName().equals(refev.attName)) {
											if (refev.value == null) {
												if (object.eGet(att) == null) {
													if (!selected_tmp.contains(candidate)) {
														selected_tmp.add(candidate);
													}
												}
											}
											else {
												Object val = object.eGet(att);
												if (val instanceof EEnumLiteral) {
													val = ((EEnumLiteral) val).getLiteral();
												}
												if (val.equals(refev.value)) {
													if (!selected_tmp.contains(candidate)) {
														selected_tmp.add(candidate);
													}
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EAttribute att : object.eClass().getEAllAttributes()) {
											if (att.getName().equals(refev.attName)) {
												if (refev.value == null) {
													if (object.eGet(att) == null) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
												else {
													Object val = object.eGet(att);
													if (val instanceof EEnumLiteral) {
														val = ((EEnumLiteral) val).getLiteral();
													}
													if (val.equals(refev.value)) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
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
				}
			}
			else {
				for (EReference ref : candidate.eClass().getEAllReferences()) {
					if (ref.getName().equals(refev.name)) {
						if (candidate.eGet(ref) != null) {
							if (candidate.eGet(ref) instanceof EObject) {
								EObject object = (EObject) candidate.eGet(ref);
								for (EReference reff : object.eClass().getEAllReferences()) {
									if (reff.getName().equals(refev.refName)) {
										if (refev.value == null) {
											if (object.eGet(reff) instanceof EObject) {
												EObject obj = (EObject) object.eGet(ref);
												if (obj == null) {
													if (!selected_tmp.contains(candidate)) {
														selected_tmp.add(candidate);
													}
												}
											}
											if (object.eGet(reff) instanceof List<?>) {
												List<EObject> objs = (List<EObject>) object.eGet(ref);
												if (objs.size() == 0) {
													if (!selected_tmp.contains(candidate)) {
														selected_tmp.add(candidate);
													}
												}
											}
										} else {
											if (object.eGet(reff) instanceof EObject) {
												EObject obj = (EObject) object.eGet(ref);
												if (refev.value instanceof List<?>) {
													List<EObject> objects = (List<EObject>) refev.value;
													if (objects.contains(obj)) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
												else {
													if (obj.equals(refev.value)) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
											}
											if (object.eGet(reff) instanceof List<?>) {
												List<EObject> objs = (List<EObject>) object.eGet(ref);
												if (refev.value instanceof List<?>) {
													List<EObject> objects = new ArrayList<EObject>();
													objects.addAll((List<EObject>) refev.value);
													boolean b = true;
													for (EObject obj : objs) {
														if (!objects.contains(obj)) {
															b = false;
															break;
														}
														objects.remove(obj);
													}
													if (b == true && objects.size() == 0) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
												else {
													boolean exists = false;
													for (EObject obj : objs) {
														if (obj.equals(refev.value)) {
															exists = true;
															break;
														}
													}
													if (exists == true) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
											}
										}
									}
								}
							}
							if (candidate.eGet(ref) instanceof List<?>) {
								List<EObject> objects = (List<EObject>) candidate.eGet(ref);
								for (EObject object : objects) {
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (refev.value == null) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(ref);
													if (obj == null) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objs = (List<EObject>) object.eGet(ref);
													if (objs.size() == 0) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
											} else {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													if (refev.value instanceof List<?>) {
														List<EObject> objs = (List<EObject>) refev.value;
														if (objs.contains(obj)) {
															if (!selected_tmp.contains(candidate)) {
																selected_tmp.add(candidate);
															}
														}
													}
													else {
														if (obj.equals(refev.value)) {
															if (!selected_tmp.contains(candidate)) {
																selected_tmp.add(candidate);
															}
														}
													}
												}
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objs = (List<EObject>) object.eGet(reff);
													if (refev.value instanceof List<?>) {
														List<EObject> lobjects = new ArrayList<EObject>();
														lobjects.addAll((List<EObject>) refev.value);
														boolean b = true;
														for (EObject obj : objs) {
															if (!lobjects.contains(obj)) {
																b = false;
																break;
															}
															lobjects.remove(obj);
														}
														if (b == true && lobjects.size() == 0) {
															if (!selected_tmp.contains(candidate)) {
																selected_tmp.add(candidate);
															}
														}
													}
													else {
														for (EObject obj : objs) {
															if (obj.equals(refev.value)) {
																if (!selected_tmp.contains(candidate)) {
																	selected_tmp.add(candidate);
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
						}
					}
				}
			}
		}
	}
	
	/**
	 * evaluateSecondReferenceOrDifferent evaluates
	 * the second reference expression and next when
	 * the link is an 'or' with operator '<>'
	 * @param refev
	 * @param candidate
	 * @param selected
	 * @param selected_tmp
	 */
	private static void evaluateSecondReferenceOrDifferent(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof EObject) {
//				if (refev.size != 1) {
//					selected_tmp.add(candidate);
//				}
//			}
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() != refev.size) {
//					selected_tmp.add(candidate);
//				}
//			}
//			return;
//		}
		if (refev.name == null) {
			if (refev.container == false) {
				if (!candidate.equals(refev.value)) {
					if (!selected_tmp.contains(candidate)) {
						selected_tmp.add(candidate);
					}
				}
			}
			else if (candidate.eContainer() != null && !candidate.eContainer().equals(refev.value)) {
				if (!selected_tmp.contains(candidate)) {
					selected_tmp.add(candidate);
				}
			}
		} else {
			if (refev.refName == null) {
				if (refev.attName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (refev.value == null) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									if (objects.size() > 0) {
										if (!selected_tmp.contains(candidate)) {
											selected_tmp.add(candidate);
										}
									}
								}
								else {
									if (candidate.eGet(ref) == null) {
										if (!selected_tmp.contains(candidate)) {
											selected_tmp.add(candidate);
										}
									}
								}
							}
						} else {
							if (ref.getName().equals(refev.name)) {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = new ArrayList<EObject>();
									objects.addAll((List<EObject>) candidate.eGet(ref));
									if (refev.value instanceof List<?>) {
										List<EObject> objs = (List<EObject>) refev.value;
										boolean b = true;
										for (EObject obj : objs) {
											if (!objects.contains(obj)) {
												b = false;
												break;
											}
											objects.remove(obj);
										}
										if (b == false || objects.size() > 0) {
											if (!selected_tmp.contains(candidate)) {
												selected_tmp.add(candidate);
											}
										}
									}
									else {
										EObject obj = (EObject) refev.value;
										if (!objects.contains(obj)) {
											if (!selected_tmp.contains(candidate)) {
												selected_tmp.add(candidate);
											}
										}
									}
								}
								else {
									if (candidate.eGet(ref) instanceof EObject) {
										EObject object = (EObject) candidate.eGet(ref);
										if (refev.value instanceof List<?>) {
											List<EObject> objects = (List<EObject>) refev.value;
											if (!objects.contains(object)) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										if (!object.equals(refev.value)) {
											if (!selected_tmp.contains(candidate)) {
												selected_tmp.add(candidate);
											}
										}
									}
								}
							}
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EAttribute att : object.eClass().getEAllAttributes()) {
										if (att.getName().equals(refev.attName)) {
											if (refev.value == null) {
												if (object.eGet(att) != null) {
													if (!selected_tmp.contains(candidate)) {
														selected_tmp.add(candidate);
													}
												}
											}
											else {
												Object val = object.eGet(att);
												if (val instanceof EEnumLiteral) {
													val = ((EEnumLiteral) val).getLiteral();
												}
												if (!val.equals(refev.value)) {
													if (!selected_tmp.contains(candidate)) {
														selected_tmp.add(candidate);
													}
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EAttribute att : object.eClass().getEAllAttributes()) {
											if (att.getName().equals(refev.attName)) {
												if (refev.value == null) {
													if (object.eGet(att) != null) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
												else {
													Object val = object.eGet(att);
													if (val instanceof EEnumLiteral) {
														val = ((EEnumLiteral) val).getLiteral();
													}
													if (!val.equals(refev.value)) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
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
				}
			}
			else {
				for (EReference ref : candidate.eClass().getEAllReferences()) {
					if (ref.getName().equals(refev.name)) {
						if (candidate.eGet(ref) != null) {
							if (candidate.eGet(ref) instanceof EObject) {
								EObject object = (EObject) candidate.eGet(ref);
								for (EReference reff : object.eClass().getEAllReferences()) {
									if (refev.value == null) {
										if (object.eGet(reff) instanceof EObject) {
											EObject obj = (EObject) object.eGet(reff);
											if (obj != null) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										if (object.eGet(reff) instanceof List<?>) {
											List<EObject> objs = (List<EObject>) object.eGet(reff);
											boolean exists = false;
											for (EObject obj : objs) {
												if (obj.equals(refev.value)) {
													exists = true;
													break;
												}
											}
											if (exists == false) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
									}
								}
							}
							if (candidate.eGet(ref) instanceof List<?>) {
								List<EObject> objects = (List<EObject>) candidate.eGet(ref);
								for (EObject object : objects) {
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (refev.value == null) {
											if (object.eGet(reff) instanceof EObject) {
												EObject obj = (EObject) object.eGet(reff);
												if (obj != null) {
													if (!selected_tmp.contains(candidate)) {
														selected_tmp.add(candidate);
													}
												}
											}
											if (object.eGet(reff) instanceof List<?>) {
												List<EObject> objs = (List<EObject>) object.eGet(reff);
												for (EObject obj : objs) {
													if (obj != null) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
											}
										} else {
											if (object.eGet(reff) instanceof EObject) {
												EObject obj = (EObject) object.eGet(reff);
												if (refev.value instanceof List<?>) {
													List<EObject> objs = (List<EObject>) refev.value;
													if (!objs.contains(obj)) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
												else {
													if (!obj.equals(refev.value)) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
											}
											if (object.eGet(reff) instanceof List<?>) {
												List<EObject> objs = (List<EObject>) object.eGet(reff);
												if (refev.value instanceof List<?>) {
													List<EObject> lobjects = new ArrayList<EObject>();
													lobjects.addAll((List<EObject>) refev.value);
													boolean b = true;
													for (EObject obj : objs) {
														if (!lobjects.contains(obj)) {
															b = false;
															break;
														}
														lobjects.remove(obj);
													}
													if (b == false || lobjects.size() > 0) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
												else {
													boolean exists = false;
													for (EObject obj : objs) {
														if (obj.equals(refev.value)) {
															exists = true;
															break;
														}
													}
													if (exists == false) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
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
				}
			}
		}
	}
	
	/**
	 * evaluateSecondReferenceOrIn evaluates
	 * the second reference expression and next when
	 * the link is an 'or' with operator 'in'
	 * @param refev
	 * @param candidate
	 * @param selected
	 * @param selected_tmp
	 */
	private static void evaluateSecondReferenceOrIn(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
		if (refev.name != null) {
			if (refev.refName == null) {
				if (refev.attName == null) {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (refev.value != null) {
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = new ArrayList<EObject>();
									objects.addAll((List<EObject>) candidate.eGet(ref));
									if (refev.value instanceof List<?>) {
										boolean b = true;
										for (EObject obj : (List<EObject>) refev.value) {
											if (!objects.contains(obj)) {
												b = false;
												break;
											}
											objects.remove(obj);
										}
										if (b == true && objects.size() == 0) {
											if (!selected_tmp.contains(candidate)) {
												selected_tmp.add(candidate);
											}
										}
									}
									else {
										EObject object = (EObject) refev.value;
										if (objects.contains(object)) {
											if (!selected_tmp.contains(candidate)) {
												selected_tmp.add(candidate);
											}
										}
									}
								}
								else {
									if (candidate.eGet(ref) instanceof EObject) {
										EObject object = (EObject) candidate.eGet(ref);
										if (refev.value instanceof List<?>) {
											List<EObject> objects = (List<EObject>) refev.value;
											if (objects.contains(object)) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										else {
											if (object.equals(refev.value)) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
									}
								}
							}
						}
					}
				}
				else {
					for (EReference ref : candidate.eClass().getEAllReferences()) {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) != null) {
								if (candidate.eGet(ref) instanceof EObject) {
									EObject object = (EObject) candidate.eGet(ref);
									for (EAttribute att : object.eClass().getEAllAttributes()) {
										if (att.getName().equals(refev.attName)) {
											if (refev.value == null) {
												if (object.eGet(att) == null) {
													if (!selected_tmp.contains(candidate)) {
														selected_tmp.add(candidate);
													}
												}
											}
											else {
												Object val = object.eGet(att);
												if (val instanceof EEnumLiteral) {
													val = ((EEnumLiteral) val).getLiteral();
												}
												if (val.equals(refev.value)) {
													if (!selected_tmp.contains(candidate)) {
														selected_tmp.add(candidate);
													}
												}
											}
										}
									}
								}
								if (candidate.eGet(ref) instanceof List<?>) {
									List<EObject> objects = (List<EObject>) candidate.eGet(ref);
									for (EObject object : objects) {
										for (EAttribute att : object.eClass().getEAllAttributes()) {
											if (att.getName().equals(refev.attName)) {
												if (refev.value == null) {
													if (object.eGet(att) == null) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
												else {
													Object val = object.eGet(att);
													if (val instanceof EEnumLiteral) {
														val = ((EEnumLiteral) val).getLiteral();
													}
													if (val.equals(refev.value)) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
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
				}
			}
			else {
				for (EReference ref : candidate.eClass().getEAllReferences()) {
					if (ref.getName().equals(refev.name)) {
						if (candidate.eGet(ref) != null) {
							if (candidate.eGet(ref) instanceof EObject) {
								EObject object = (EObject) candidate.eGet(ref);
								for (EReference reff : object.eClass().getEAllReferences()) {
									if (reff.getName().equals(refev.refName)) {
										if (refev.value != null) {
											if (object.eGet(reff) instanceof EObject) {
												EObject obj = (EObject) object.eGet(ref);
												if (refev.value instanceof List<?>) {
													List<EObject> objects = (List<EObject>) refev.value;
													if (objects.contains(obj)) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
												else {
													if (obj.equals(refev.value)) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
											}
											if (object.eGet(reff) instanceof List<?>) {
												List<EObject> objs = (List<EObject>) object.eGet(ref);
												if (refev.value instanceof List<?>) {
													List<EObject> objects = new ArrayList<EObject>();
													objects.addAll((List<EObject>) refev.value);
													boolean b = true;
													for (EObject obj : objs) {
														if (!objects.contains(obj)) {
															b = false;
															break;
														}
														objects.remove(obj);
													}
													if (b == true && objects.size() == 0) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
												else {
													boolean exists = false;
													for (EObject obj : objs) {
														if (obj.equals(refev.value)) {
															exists = true;
															break;
														}
													}
													if (exists == true) {
														if (!selected_tmp.contains(candidate)) {
															selected_tmp.add(candidate);
														}
													}
												}
											}
										}
									}
								}
							}
							if (candidate.eGet(ref) instanceof List<?>) {
								List<EObject> objects = (List<EObject>) candidate.eGet(ref);
								for (EObject object : objects) {
									for (EReference reff : object.eClass().getEAllReferences()) {
										if (reff.getName().equals(refev.refName)) {
											if (refev.value != null) {
												if (object.eGet(reff) instanceof EObject) {
													EObject obj = (EObject) object.eGet(reff);
													if (refev.value instanceof List<?>) {
														List<EObject> objs = (List<EObject>) refev.value;
														if (objs.contains(obj)) {
															if (!selected_tmp.contains(candidate)) {
																selected_tmp.add(candidate);
															}
														}
													}
													else {
														if (obj.equals(refev.value)) {
															if (!selected_tmp.contains(candidate)) {
																selected_tmp.add(candidate);
															}
														}
													}
												}
												if (object.eGet(reff) instanceof List<?>) {
													List<EObject> objs = (List<EObject>) object.eGet(reff);
													if (refev.value instanceof List<?>) {
														List<EObject> lobjects = new ArrayList<EObject>();
														lobjects.addAll((List<EObject>) refev.value);
														boolean b = true;
														for (EObject obj : objs) {
															if (!lobjects.contains(obj)) {
																b = false;
																break;
															}
															lobjects.remove(obj);
														}
														if (b == true && lobjects.size() == 0) {
															if (!selected_tmp.contains(candidate)) {
																selected_tmp.add(candidate);
															}
														}
													}
													else {
														for (EObject obj : objs) {
															if (obj.equals(refev.value)) {
																if (!selected_tmp.contains(candidate)) {
																	selected_tmp.add(candidate);
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
						}
					}
				}
			}
		}
	}
	
//	private static void evaluateSecondReferenceOrGreater(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() > refev.size) {
//					selected_tmp.add(candidate);
//				}
//			}
//		}
//	}

//	private static void evaluateSecondReferenceOrGreaterOrEquals(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof EObject) {
//				if (refev.size == 1) {
//					selected_tmp.add(candidate);
//				}
//			}
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() >= refev.size) {
//					selected_tmp.add(candidate);
//				}
//			}
//		}
//	}
	
//	private static void evaluateSecondReferenceOrLower(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() < refev.size) {
//					selected_tmp.add(candidate);
//				}
//			}
//		}
//	}

//	private static void evaluateSecondReferenceOrLowerOrEquals(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
//		if (refev.size != 0) {
//			EObject container = candidate.eContainer();
//			EReference ref = ModelManager.getReferenceBetweenObjects(container, candidate);
//			Object ob = container.eGet(ref);
//			if (ob instanceof EObject) {
//				if (refev.size == 1) {
//					selected_tmp.add(candidate);
//				}
//			}
//			if (ob instanceof List<?>) {
//				List<EObject> values = (List<EObject>) ob;
//				if (values.size() <= refev.size) {
//					selected_tmp.add(candidate);
//				}
//			}
//		}
//	}

	/**
	 * evaluateSecondReferenceOr evaluates second reference
	 * expression and next when preceded by an 'or' operator
	 * @param refev
	 * @param candidates
	 * @param selected
	 * @param selected_tmp
	 */
	private static void evaluateSecondReferenceOr(ReferenceEvaluation refev, List<EObject> candidates, Set<EObject> selected, Set<EObject> selected_tmp) {
		for (EObject candidate : candidates) {
			if (refev.operator.equals("equals")) {
				evaluateSecondReferenceOrEquals(refev, candidate, selected, selected_tmp);
			}
			if (refev.operator.equals("different")) {
				evaluateSecondReferenceOrDifferent(refev, candidate, selected, selected_tmp);
			}
			if (refev.operator.equals("in")) {
				evaluateSecondReferenceOrIn(refev, candidate, selected, selected_tmp);
			}
			if (refev.operator.equals("is")) {
				evaluateSecondReferenceOrIs(refev, candidate, selected, selected_tmp);
			}
			if (refev.operator.equals("not")) {
				evaluateSecondReferenceOrNot(refev, candidate, selected, selected_tmp);
			}
//			if (refev.operator.equals("gt")) {
//				evaluateSecondReferenceOrGreater(refev, candidate, selected, selected_tmp);
//			}
//			if (refev.operator.equals("gte")) {
//				evaluateSecondReferenceOrGreaterOrEquals(refev, candidate, selected, selected_tmp);
//			}
//			if (refev.operator.equals("lt")) {
//				evaluateSecondReferenceOrLower(refev, candidate, selected, selected_tmp);
//			}
//			if (refev.operator.equals("lte")) {
//				evaluateSecondReferenceOrLowerOrEquals(refev, candidate, selected, selected_tmp);
//			}
		}
	}
		
	/**
	 * evaluate returns the objects that matches the given expression
	 * @param candidates
	 * @param exp
	 * @return
	 */
	protected static List<EObject> evaluate(List<EObject> candidates, Expression exp) {
		Set<EObject> selected = new HashSet<EObject>();
		Set<EObject> selected_tmp = null;
//		Map<EObject, EObject> dictionary = new HashMap<EObject, EObject>();

		List<EObject> ret = new ArrayList<EObject>();
		if (candidates == null) {
			return ret;
		}
//		List<EObject> candidates_tmp = new ArrayList<EObject>();
//		for (EObject candidate : candidates) {
//			EObject candidate_tmp = EcoreUtil.copy(candidate);
//			candidates_tmp.add(candidate_tmp);
//			dictionary.put(candidate_tmp, candidate);
//		}
		if (exp.first instanceof AttributeEvaluation) {
			evaluateFirstAttribute((AttributeEvaluation) exp.first, candidates/*candidates_tmp*/, selected);
		}
		if (exp.first instanceof ReferenceEvaluation) {
			evaluateFirstReference((ReferenceEvaluation) exp.first, candidates/*candidates_tmp*/, selected);
		}

		selected_tmp = new HashSet<EObject>();
		selected_tmp.addAll(selected);

		if (exp.operator.size() > 0) {
			int i = 0;
			for (Evaluation ev : exp.second) {
				if (ev instanceof AttributeEvaluation) {
					if (exp.operator.get(i).type.equals("and")) {
						evaluateSecondAttributeAnd((AttributeEvaluation) ev, candidates/*candidates_tmp*/, selected, selected_tmp);
					}
					if (exp.operator.get(i).type.equals("or")) {
						evaluateSecondAttributeOr((AttributeEvaluation) ev, candidates/*candidates_tmp*/, selected, selected_tmp);
					}
				}
				if (ev instanceof ReferenceEvaluation) {
					if (exp.operator.get(i).type.equals("and")) {
						evaluateSecondReferenceAnd((ReferenceEvaluation) ev, candidates/*candidates_tmp*/, selected, selected_tmp);
					}
					if (exp.operator.get(i).type.equals("or")) {
						evaluateSecondReferenceOr((ReferenceEvaluation) ev, candidates/*candidates_tmp*/, selected, selected_tmp);
					}
				}
				i++;
			}
		}

		for (EObject sel : selected_tmp) {
			ret.add(sel/*dictionary.get(sel)*/);
		}
		
		return ret;
	}
	
	private static int check(EObject eObject) {
		TreeIterator<Object> tree = EcoreUtil.getAllContents(eObject, true);
		while (tree.hasNext()) {
			try {
				EObject obj = (EObject) tree.next();
				for (EAttribute att : obj.eClass().getEAllAttributes()) {
					if ((att.getLowerBound() > 0) && (obj.eGet(att) == null)) {
						return 1;
					}
				}
				for (EReference ref : obj.eClass().getEAllReferences()) {
					if ((ref.getLowerBound() > 0) && (obj.eGet(ref) == null)) {
						return 1;
					}
				}
			} catch (Exception ex) {
				return 1;
			}
		}
		return 0;
	}
	
	private static int check(List<EObject> objects) {
		for (EObject eObject : objects) {
			TreeIterator<Object> tree = EcoreUtil.getAllContents(eObject, true);
			while (tree.hasNext()) {
				try {
					EObject obj = (EObject) tree.next();
					for (EAttribute att : obj.eClass().getEAllAttributes()) {
						if ((att.getLowerBound() > 0) && (obj.eGet(att) == null)) {
							return 1;
						}
					}
					for (EReference ref : obj.eClass().getEAllReferences()) {
						if ((ref.getLowerBound() > 0) && (obj.eGet(ref) == null)) {
							return 1;
						}
					}
				} catch (Exception ex) {
					return 1;
				}
			}
		}
		return 0;
	}

	/**
	 * Checks whether the model is a valid program
	 * It uses the model validation extension
	 * @param metamodel
	 * @param model
	 * @return
	 * @throws ModelNotFoundException
	 */
	protected boolean validate(String metamodel, String seed, String model, IProject project) throws ModelNotFoundException {
		boolean isValid = false;
		String extensionName = Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Mutants valid programs extension", "", null);
		if (extensionName.equals("")) {
			return true;
		}
		if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							"wodel.validate.MutValidate");

			try {
				IConfigurationElement appropriateExtension = null;
				for (IConfigurationElement extension : extensions) {
					Class<?> extensionClass = Platform.getBundle(extension.getDeclaringExtension().getContributor().getName()).loadClass(extension.getAttribute("class"));
					Object validation =  extensionClass.newInstance();
					Method getURI = extensionClass.getDeclaredMethod("getURI");
					List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
					String uri = (String) getURI.invoke(validation);
					Method getName = extensionClass.getDeclaredMethod("getName");
					String name = (String) getName.invoke(validation);
					if (uri.equals(packages.get(0).getNsURI())) {
						appropriateExtension = extension;
						break;
					}
				}
				if (appropriateExtension != null) {
					Class<?> extensionClass = Platform.getBundle(appropriateExtension.getDeclaringExtension().getContributor().getName()).loadClass(appropriateExtension.getAttribute("class"));
					Object validation =  extensionClass.newInstance();
					Method getName = extensionClass.getDeclaredMethod("getName");
					Method validate = extensionClass.getDeclaredMethod("isValid", new Class[]{String.class, String.class, String.class, IProject.class});
					isValid = (boolean) validate.invoke(validation, metamodel, seed, model, project);
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidRegistryObjectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MetaModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isValid;
	}

	/**
	 * Checks whether the model is valid
	 * It uses the model validation extension
	 * @param metamodel
	 * @param model
	 * @return
	 * @throws ModelNotFoundException
	 */
	protected boolean validation(String metamodel, String uri) throws ModelNotFoundException {
		boolean isValid = false;
		String extensionName = Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Mutants validation extension", "", null);
		if (extensionName.equals("")) {
			return true;
		}
		if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							"wodel.validation.MutValidation");

			try {
				for (IConfigurationElement extension : extensions) {
					Class<?> extensionClass = Platform.getBundle(extension.getDeclaringExtension().getContributor().getName()).loadClass(extension.getAttribute("class"));
					Object validation =  extensionClass.newInstance();
					Method validate = extensionClass.getDeclaredMethod("isValid", new Class[]{String.class, String.class});
					isValid = (boolean) validate.invoke(validation, metamodel, uri);
					break;
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidRegistryObjectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isValid;
	}

	/**
	 * Checks whether the model is different to the given set
	 * It uses the model comparison extension
	 * @param metamodel
	 * @param model
	 * @param hashset_mutants
	 * @return
	 * @throws ModelNotFoundException
	 */
	protected boolean different(String metamodel, String model,
			Set<String> hashset_mutants, IProject project, Class<?> cls) throws ModelNotFoundException {
		boolean isRepeated = false;
		boolean discardDuplicate = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Discard syntactic duplicate mutants", false, null);
		if (discardDuplicate == true) {
			String extensionName = Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Duplicate mutants detection extension", "Syntactic Comparison", null);
			if (Platform.getExtensionRegistry() != null) {
				IConfigurationElement[] extensions = Platform
						.getExtensionRegistry().getConfigurationElementsFor(
								"wodel.comparison.MutComparison");

				try {
					IConfigurationElement appropriateExtension = null;
					for (IConfigurationElement extension : extensions) {
						Class<?> extensionClass = Platform.getBundle(extension.getDeclaringExtension().getContributor().getName()).loadClass(extension.getAttribute("class"));
						Object comparison =  extensionClass.newInstance();
						Method getURI = extensionClass.getDeclaredMethod("getURI");
						List<EPackage> packages = ModelManager.loadMetaModel(metamodel, cls);
						String uri = (String) getURI.invoke(comparison);
						Method getName = extensionClass.getDeclaredMethod("getName");
						String name = (String) getName.invoke(comparison);
						if (name.equals(extensionName) && uri.equals("")) {
							appropriateExtension = extension;
							break;
						}
						if (name.equals(extensionName) && uri.equals(packages.get(0).getNsURI())) {
							appropriateExtension = extension;
							break;
						}
						if (uri.equals("")) {
							appropriateExtension = extension;
						}
					}
					if (appropriateExtension != null) {
						Class<?> extensionClass = Platform.getBundle(appropriateExtension.getDeclaringExtension().getContributor().getName()).loadClass(appropriateExtension.getAttribute("class"));
						Object comparison =  extensionClass.newInstance();
						Method getName = extensionClass.getDeclaredMethod("getName");
						if (getName.invoke(comparison).equals(extensionName)) {
							Method doCompare = extensionClass.getDeclaredMethod("doCompare", new Class[]{String.class, String.class, String.class, IProject.class, Class.class});
							for (String mutFilename : hashset_mutants) {
								isRepeated = (boolean) doCompare.invoke(comparison, metamodel, model, mutFilename, project, cls);
								if (isRepeated == true) {
									break;
								}
							}
						}
					}
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidRegistryObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MetaModelNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return isRepeated;
	}
	
	/**
	 * Checks whether the model is different to the given set
	 * It uses the model comparison extension
	 * @param metamodel
	 * @param model
	 * @param hashset_mutants
	 * @return
	 * @throws ModelNotFoundException
	 */
	protected boolean equivalent(String metamodel, String model,
			String seed, IProject project) throws ModelNotFoundException {
		boolean isRepeated = false;
		boolean discardEquivalent = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Discard semantic equivalent mutants", false, null);
		if (discardEquivalent == true) {
			String extensionName = Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Semantic equivalent mutants detection extension", "", null);
			if (Platform.getExtensionRegistry() != null) {
				IConfigurationElement[] extensions = Platform
						.getExtensionRegistry().getConfigurationElementsFor(
								"wodel.comparison.MutEquivalence");

				try {
					IConfigurationElement appropriateExtension = null;
					for (IConfigurationElement extension : extensions) {
						Class<?> extensionClass = Platform.getBundle(extension.getDeclaringExtension().getContributor().getName()).loadClass(extension.getAttribute("class"));
						Object equivalence =  extensionClass.newInstance();
						Method getURI = extensionClass.getDeclaredMethod("getURI");
						List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
						String uri = (String) getURI.invoke(equivalence);
						Method getName = extensionClass.getDeclaredMethod("getName");
						String name = (String) getName.invoke(equivalence);
						if (name.equals(extensionName) && uri.equals("")) {
							appropriateExtension = extension;
							break;
						}
						if (name.equals(extensionName) && uri.equals(packages.get(0).getNsURI())) {
							appropriateExtension = extension;
							break;
						}
						if (uri.equals("")) {
							appropriateExtension = extension;
						}
					}
					if (appropriateExtension != null) {
						Class<?> extensionClass = Platform.getBundle(appropriateExtension.getDeclaringExtension().getContributor().getName()).loadClass(appropriateExtension.getAttribute("class"));
						Object equivalence =  extensionClass.newInstance();
						Method getName = extensionClass.getDeclaredMethod("getName");
						if (getName.invoke(equivalence).equals(extensionName)) {
							Method doCompare = extensionClass.getDeclaredMethod("doCompare", new Class[]{String.class, String.class, String.class, IProject.class});
							isRepeated = (boolean) doCompare.invoke(equivalence, metamodel, model, seed, project);
						}
					}
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidRegistryObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MetaModelNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return isRepeated;
	}

	/**
	 * Checks whether the model matches the OCL rules
	 * @param model
	 * @param rules
	 * @return
	 */
	protected boolean matchesOCL(Resource model,
			Map<String, List<String>> rules) {
		boolean matches = true;
		// for each object in the model
		// for (EObject eObject : model.getContents()) {
		for (EObject eObject : ModelManager.getAllObjects(model)) {

			// get metaclasses of object (metaclass and ancestors)
			Set<EClass> metaclasses = new HashSet<EClass>();
			EClass metaclass = eObject.eClass();
			metaclasses.add(metaclass);
			metaclasses.addAll(metaclass.getEAllSuperTypes());

			// for each ocl invariant in the metaclasses...
			for (EClass cl : metaclasses) {
				for (EAnnotation an : cl.getEAnnotations()) {
					if (an.getSource().equals(
							OCLConstants.OCL_DELEGATE_URI + "/Pivot")) {
						for (String key : an.getDetails().keySet()) {

							// ...evaluate invariant in the object
							Object context = eObject;
							String invariant = an.getDetails().get(key);
							OCL ocl = OCL.newInstance(org.eclipse.ocl.ecore.EcoreEnvironmentFactory.INSTANCE);
							OCLHelper helper = ocl.createOCLHelper();
							helper.setInstanceContext(context);
							try {
								OCLExpression exp = helper.createQuery(invariant);
								Query<?, ?, ?> query = OCL.newInstance(org.eclipse.ocl.ecore.EcoreEnvironmentFactory.INSTANCE).createQuery(exp);
								Object eval = query.evaluate(context);

								// check if the constraint failed
								if (eval instanceof Boolean && ((Boolean) eval).booleanValue() == false) {
									System.out.println(">>> ERROR: constraint "	+ key + " does not hold");
									matches = false;
								}
							} catch (ParserException e) {
								e.printStackTrace();
							}
							ocl.dispose();
						}
					}
				}
				if (rules.get(cl.getName()) != null) {
					for (String invariant : rules.get(cl.getName())) {
						// ...evaluate invariant in the object
						Object context = eObject;
						OCL ocl = OCL.newInstance(org.eclipse.ocl.ecore.EcoreEnvironmentFactory.INSTANCE);
						OCLHelper helper = ocl.createOCLHelper();
						helper.setInstanceContext(context);
						try {
							OCLExpression exp = helper.createQuery(invariant);
							Query<?, ?, ?> query = OCL.newInstance(org.eclipse.ocl.ecore.EcoreEnvironmentFactory.INSTANCE).createQuery(exp);
							Object eval = query.evaluate(context);

							// check if the constraint failed
							if (eval instanceof Boolean	&& ((Boolean) eval).booleanValue() == false) {
								System.out.println(">>> ERROR: constraint "	+ invariant + " does not hold");
								matches = false;
							}
						} catch (ParserException e) {
							e.printStackTrace();
						}
						ocl.dispose();
					}
				}
			}
		}
		return matches;
	}
	
	/**
	 * Gets Wodel variable names and its corresponding mutation
	 * @param objects
	 * @return
	 */
	protected static Map<String, Object> getMutatorNames(List<Object> objects) {
		Map<String, Object> mutators = new HashMap<String, Object>();
		if (objects.size() > 0) {
			if (objects.get(0) instanceof EObject) {
				for (Object obj : objects) {
					String name = ((EObject) obj).eClass().getName();
					for (String mutatorTypeName : mutatorTypeNames) {
						if (name.equals(mutatorTypeName)) {
							Mutator mut = (Mutator) obj;
							if (mut.getName() != null) {
								mutators.put(mut.getName(), obj);
							}
							break;
						}
					}
					if (((EObject) obj).eContainer() != null) {
						if (((EObject) obj).eContainer().eClass().getName()
								.equals("MutatorEnvironment")) {
							if (name.equals("CompositeMutator")) {
								Mutator mut = (Mutator) obj;
								if (mut.getName() != null) {
									mutators.put(mut.getName(), obj);
								}
							}
						}
					}
				}
			}
			if (objects.get(0) instanceof Mutator) {
				int counter = 0;
				for (Object obj : objects) {
					Mutator mut = (Mutator) obj;
					String name = mut.eClass().getName();
					for (String mutatorTypeName : mutatorTypeNames) {
						if (name.equals(mutatorTypeName)) {
							if (mut.getName() != null) {
								mutators.put(mut.getName(), mut);
							}
							break;
						}
					}
					if (mut.eContainer() != null) {
						if (mut.eContainer().eClass().getName()
								.equals("MutatorEnvironment")) {
							if (name.equals("CompositeMutator")) {
								if (mut.getName() != null) {
									mutators.put(mut.getName(), mut);
								}
							}
						}
					}
				}

			}
		}
		return mutators;
	}

	/**
	 * Gets Wodel variable name for the given mutation
	 * @param mut
	 * @return
	 */
	public static String getMutatorName(Mutator mut) {
		String name = mut.eClass().getName();
		for (String mutatorTypeName : mutatorTypeNames) {
			if (name.equals(mutatorTypeName)) {
				if (mut.getName() != null) {
					return mut.getName();
				}
				break;
			}
		}
		if (mut.eContainer() != null) {
			if (mut.eContainer().eClass().getName()
					.equals("MutatorEnvironment")) {
				if (name.equals("CompositeMutator")) {
					if (mut.getName() != null) {
						return mut.getName();
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Creates a map with all the mutations in the Wodel program
	 * This method assigns a unique name for each mutation
	 * @param objects
	 * @return
	 */
	protected static Map<String, EObject> getMutators(List<EObject> objects) {
		Map<String, EObject> mutators = new HashMap<String, EObject>();
		int counter = 0;
		for (EObject obj : objects) {
			String name = obj.eClass().getName();
			for (String mutatorTypeName : mutatorTypeNames) {
				if (name.equals(mutatorTypeName)) {
					counter++;
					mutators.put("m" + counter, obj);
					break;
				}
			}
			if (obj.eContainer() != null) {
				if (obj.eContainer().eClass().getName()
						.equals("MutatorEnvironment")) {
					if (name.equals("CompositeMutator")) {
						counter++;
						mutators.put("m" + counter, obj);
					}
				}
			}
		}

		return mutators;
	}
	
	/**
	 * Creates a map with all the mutations in the Wodel program
	 * This method assigns a unique name for each mutation
	 * @param objects
	 * @return
	 */
	protected static Map<String, EObject> getMutatorsByBlock(List<EObject> objects, String blockName) {
		Map<String, EObject> mutators = new HashMap<String, EObject>();
		try {
			int counter = 0;
			for (EObject obj : objects) {
				if (obj.eClass().getName().equals("Block")) {
					EObject block = obj;
					if (ModelManager.getStringAttribute("name", block).equals(blockName)) {
						List<EObject> muts = ModelManager.getReferences("commands", block);
						for (EObject mut : muts) {
							String name = mut.eClass().getName();
							for (String mutatorTypeName : mutatorTypeNames) {
								if (name.equals(mutatorTypeName)) {
									counter++;
									mutators.put("m" + counter, mut);
									break;
								}
							}
							if (name.equals("CompositeMutator")) {
								counter++;
								mutators.put("m" + counter, mut);
							}
						}
					}
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mutators;
	}
	
	/**
	 * Gets the mutator list
	 * @param objects
	 * @return
	 */
	public static List<EObject> getMutatorList(List<EObject> objects) {
		List<EObject> mutators = new ArrayList<EObject>();
		int counter = 0;
		for (EObject obj : objects) {
			String name = obj.eClass().getName();
			for (String mutatorTypeName : mutatorTypeNames) {
				if (name.equals(mutatorTypeName)) {
					counter++;
					mutators.add(obj);
					break;
				}
			}
			if (obj.eContainer() != null) {
				if (obj.eContainer().eClass().getName()
						.equals("MutatorEnvironment")) {
					if (name.equals("CompositeMutator")) {
						counter++;
						mutators.add(obj);
					}
				}
			}
		}

		return mutators;
	}

	/**
	 * Generates the path folder structure for the mutants
	 * @param fromName
	 * @param mutFile
	 * @param folderName
	 * @param hashmapModelFilenames
	 * @param hashmapModelFolders
	 * @param hashmapSeedModelFilenames
	 * @param modelsURI
	 * @param modelFile
	 */
	public static void generateModelPaths(String fromName, File mutFile, String folderName,
		Map<String, String> hashmapModelFilenames,
		Map<String, String> hashmapModelFolders,
		Map<String, String> hashmapSeedModelFilenames,
		String modelsURI, File modelFile) {
		if ((mutFile.getName().equals("registry") || mutFile.getName().endsWith("vs")) != true) {
			File[] blockFolders = mutFile.listFiles();
			for (int i = 0; i < blockFolders.length; i++) {
				File[] blockMutFiles = blockFolders[i].listFiles();
				for (int j = 0; j < blockMutFiles.length; j++) {
					if (blockMutFiles[j].isFile() == true) {
						String pathfile = blockMutFiles[j].getPath();
						if (pathfile.endsWith(".model") == true) {
							hashmapModelFilenames.put(pathfile,	modelsURI + modelFile.getName().
									substring(0, modelFile.getName().length() - ".model".length()));
							hashmapModelFolders.put(pathfile, fromName + "/" + folderName + "/"	+ blockFolders[i].getName()	+ 
									"/" + blockMutFiles[j].getName().substring(0,	blockMutFiles[j].getName().length()	- ".model".length()));
							hashmapSeedModelFilenames.put(pathfile,
									modelFile.getPath());
						}
					} else {
						generateModelPaths(fromName, blockMutFiles[j], 
							folderName + "/" + blockFolders[i].getName()
								+ "/" + blockMutFiles[j].getName(),
								hashmapModelFilenames, hashmapModelFolders,
								hashmapSeedModelFilenames, modelsURI, modelFile);
					}
				}
			}
		}
	}

	/**
	 * Generates the path structure for the mutants
	 * @param block
	 * @param packages
	 * @param hashmap_postproc
	 * @throws ModelNotFoundException
	 */
	public static void generatePostprocessingPaths(File block,
			List<EPackage> packages,
			Map<Resource, String> hashmap_postproc)
			throws ModelNotFoundException {
		if (block.getName().equals("registry") != true) {
			File[] folderBlock = block.listFiles();
			for (int i = 0; i < folderBlock.length; i++) {
				if (folderBlock[i].isFile() == true) {
					String pathfileblock = folderBlock[i].getPath();
					if (pathfileblock.endsWith(".model") == true) {
						Resource modelfileblock = ModelManager.loadModel(
								packages, pathfileblock);
						hashmap_postproc.put(modelfileblock, pathfileblock);
					}
				} else {
					generatePostprocessingPaths(folderBlock[i], packages,
							hashmap_postproc);
				}
			}
		}
	}
	
	/**
	 * Generates the path structure for the mutants
	 * @param block
	 * @param packages
	 * @throws ModelNotFoundException
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void generatePostprocessingPaths(File block,
			List<EPackage> packages, Method doProcess, Object postprocessing, String metamodelpath, String metamodel)
			throws ModelNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (block.getName().equals("registry") != true) {
			File[] folderBlock = block.listFiles();
			for (int i = 0; i < folderBlock.length; i++) {
				if (folderBlock[i].isFile() == true) {
					String pathfileblock = folderBlock[i].getPath();
					if (pathfileblock.endsWith(".model") == true) {
						Resource modelfileblock = ModelManager.loadModel(
								packages, pathfileblock);
						File f = new File(pathfileblock);
						if(!f.isDirectory()) {
							if (doProcess != null) {
								doProcess.invoke(postprocessing, metamodelpath, metamodel, modelfileblock, pathfileblock);
							}
						}
					}
				} else {
					generatePostprocessingPaths(folderBlock[i], packages, doProcess, postprocessing, metamodelpath, metamodel);
				}
			}
		}
	}

	/**
	 * Generates the path structure for the mutants
	 * @param block
	 * @param packages
	 * @param hashmap_postproc
	 * @throws ModelNotFoundException
	 */
	public static void generateLiveMutantPaths(File block,
			List<EPackage> packages,
			Map<Resource, String> hashmap_postproc, List<String> liveMutantPaths)
			throws ModelNotFoundException {
		if (block.getName().equals("registry") != true) {
			File[] folderBlock = block.listFiles();
			for (int i = 0; i < folderBlock.length; i++) {
				if (folderBlock[i].isFile() == true) {
					String pathfileblock = folderBlock[i].getPath();
					if (pathfileblock.endsWith(".model") == true && !pathfileblock.contains("_")) {
						String mutantName = pathfileblock.substring(pathfileblock.lastIndexOf("\\"));
						mutantName = mutantName.substring(1, mutantName.indexOf(".model"));
						String mutatorName = folderBlock[i].getName();
						String mutantPath = mutatorName + "/" + mutantName;
						for (String liveMutantPath : liveMutantPaths) {
							if (liveMutantPath.contains(mutantPath)) {
								Resource modelfileblock = ModelManager.loadModel(
										packages, pathfileblock);
								hashmap_postproc.put(modelfileblock, pathfileblock);
								break;
							}
						}
					}
				} else {
					generateLiveMutantPaths(folderBlock[i], packages,
							hashmap_postproc, liveMutantPaths);
				}
			}
		}
	}

	/**
	 * Generates the path structure for the mutants
	 * @param block
	 * @param packages
	 * @param hashmap_postproc
	 * @throws ModelNotFoundException
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static String generateLiveMutantPaths(File block,
			List<EPackage> packages, List<String> liveMutantPaths, Method doCompare, Object equivalence, String metamodel, String targetfile, IProject sourceProject, String outputPath)
			throws ModelNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String equivalentPaths = "";
		if (block.getName().equals("registry") != true) {
			File[] folderBlock = block.listFiles();
			for (int i = 0; i < folderBlock.length; i++) {
				if (folderBlock[i].isFile() == true) {
					String pathfileblock = folderBlock[i].getPath();
					if (pathfileblock.endsWith(".model") == true && !pathfileblock.contains("_")) {
						String mutantName = pathfileblock.substring(pathfileblock.lastIndexOf("\\"));
						mutantName = mutantName.substring(1, mutantName.indexOf(".model"));
						String mutatorName = folderBlock[i].getName();
						String mutantPath = mutatorName + "/" + mutantName;
						for (String liveMutantPath : liveMutantPaths) {
							if (liveMutantPath.contains(mutantPath)) {
								Resource modelfileblock = ModelManager.loadModel(
										packages, pathfileblock);
								File f = new File(pathfileblock);
								if(!f.isDirectory() && !f.getName().contains("_")) { 
									boolean result = (boolean) doCompare.invoke(equivalence, metamodel, targetfile, pathfileblock, sourceProject);
									if (result == true) {
										String equivalentPath = pathfileblock.replaceAll("\\\\", "/");
										equivalentPath = equivalentPath.substring(equivalentPath.indexOf(outputPath) + outputPath.length(), equivalentPath.length()).replace(".model", "") + "/src/";
										equivalentPaths += equivalentPath + "|";
									}
								}
								break;
							}
						}
					}
				} else {
					equivalentPaths = generateLiveMutantPaths(folderBlock[i], packages,	liveMutantPaths, doCompare, equivalence, metamodel, targetfile, sourceProject, outputPath);
				}
			}
		}
		return equivalentPaths;
	}
	
	/**
	 * Generates the registry paths
	 * @param block
	 * @param packages
	 * @param hashmap_postproc
	 * @param hashmap_mutpostproc
	 * @param file
	 * @param blockModelFolder
	 * @throws ModelNotFoundException
	 */
	public static void generateRegistryPaths(File block,
			List<EPackage> packages, File file,
			String blockModelFolder, IRegistryPostprocessor postprocessor) throws ModelNotFoundException {
		File[] folderBlock = block.listFiles();
		for (int i = 0; i < folderBlock.length; i++) {
			if (folderBlock[i].isDirectory() == true) {
				if (folderBlock[i].getName().equals("registry") == true) {
					File[] regfiles = folderBlock[i].listFiles();
					for (int j = 0; j < regfiles.length; j++) {
						String pathfileblock = regfiles[j].getPath();
						if (pathfileblock.endsWith(".model") == true && (new File(blockModelFolder + ".model")).exists()) {
							Resource blockmodelfile = ModelManager.loadModel(packages, blockModelFolder + ".model");
							Resource mutant = ModelManager.loadModel(packages,	block.getPath()	+ "/" + regfiles[j].getName().replace("Registry", ""));
							postprocessor.doProcess(blockmodelfile, mutant, pathfileblock);
						}
					}
				} else {
					generateRegistryPaths(folderBlock[i], packages,	file, blockModelFolder + "/" + folderBlock[i].getName(), postprocessor);
				}
			}
		}
	}
	
	/**
	 * Generates the registry paths
	 * @param block
	 * @param packages
	 * @param file
	 * @param blockModelFolder
	 * @throws ModelNotFoundException
	 */
	public static void generateRegistryPaths(File block,
			List<EPackage> packages,
			Map<String, Resource> hashmap_postproc,
			Map<String, Resource> hashmap_mutpostproc, File file,
			String blockModelFolder) throws ModelNotFoundException {
		File[] folderBlock = block.listFiles();
		for (int i = 0; i < folderBlock.length; i++) {
			if (folderBlock[i].isDirectory() == true) {
				if (folderBlock[i].getName().equals("registry") == true) {
					File[] regfiles = folderBlock[i].listFiles();
					for (int j = 0; j < regfiles.length; j++) {
						String pathfileblock = regfiles[j].getPath();
						if (pathfileblock.endsWith(".model") == true && (new File(blockModelFolder + ".model")).exists()) {
							Resource blockmodelfile = ModelManager.loadModel(packages, blockModelFolder + ".model");
							hashmap_postproc.put(pathfileblock, blockmodelfile);
							File check = new File(block.getPath()	+ "/" + regfiles[j].getName().replace("Registry", ""));
							if (check.exists()) {
								Resource mutant = ModelManager.loadModel(packages,	block.getPath()	+ "/" + regfiles[j].getName().replace("Registry", ""));
								hashmap_mutpostproc.put(pathfileblock, mutant);
							}
						}
					}
				} else {
					generateRegistryPaths(folderBlock[i], packages,
							hashmap_postproc, hashmap_mutpostproc, file,
							blockModelFolder + "/" + folderBlock[i].getName());
				}
			}
		}
	}

	/**
	 * Gets the registry models
	 * @param folder
	 * @param packages
	 * @param registryModels
	 * @throws ModelNotFoundException
	 */
	public static void getRegistryModels(File folder, List<EPackage> packages, Map<String, Resource> registryModels) throws ModelNotFoundException {
		File[] files = folder.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory() == true) {
				if (files[i].getName().equals("registry") == true) {
					File[] regfiles = files[i].listFiles();
					for (int j = 0; j < regfiles.length; j++) {
						String pathfile = regfiles[j].getPath();
						if (pathfile.endsWith(".model") == true) {
							Resource registrymodel = ModelManager.loadModel(packages, pathfile);
							registryModels.put(pathfile, registrymodel);
						}
					}
				} else {
					if (!files[i].getName().endsWith("vs")) {
						getRegistryModels(files[i], packages, registryModels);
					}
				}
			}
		}
	}

	/**
	 * Gets the seed path from the registry filename
	 * @param registryFilename
	 * @return
	 */
	public static String getSeedFromRegistry(String registryFilename) {
		int start = registryFilename.indexOf("out" + File.separator) + ("out" + File.separator).length();
		int end = start + registryFilename.substring(start, registryFilename.length()).indexOf(File.separator); 
		return ModelManager.getMetaModelPath() + "/" + registryFilename.substring(start, end) + ".model";
	}
	
	/**
	 * Gets the mutant paths from the registry filename
	 * @param registryFilename
	 * @return
	 */
	public static List<String> getMutantsFromRegistry(String registryFilename) {
		int end = registryFilename.indexOf("registry" + File.separator) + ("registry" + File.separator).length();
		String path = registryFilename.substring(0, registryFilename.indexOf("registry" + File.separator));
		File folder = new File(path);
		List<String> mutantFilenames = new ArrayList<String>();
		for (File file : folder.listFiles()) {
			if (file.isFile() && file.getName().endsWith(".model")) {
				mutantFilenames.add(file.getPath().replace(File.separator, "/"));
			}
		}
		return mutantFilenames;
	}
	
	/**
	 * Creates the mutant version registry
	 * @param packages
	 * @param seeds
	 * @param model
	 * @param versionPath
	 * @param mut
	 */
	public void createMutantVersionRegistry(List<EPackage> packages, List<Resource> seeds, Resource model, String versionPath, AppMutation mut) {
		File outputFolder = new File(versionPath.substring(0, versionPath.lastIndexOf("/")) + "/registry");
		if (outputFolder.exists() != true) {
			outputFolder.mkdir();
		}
		if (mut instanceof ObjectCreated) {
			List<EObject> emuts = ((ObjectCreated) mut).getObject();
			if (emuts.size() > 0) {
				EObject emutated = emuts.get(0);
				emuts.remove(0);
				if (ModelManager.getObject(model, emutated) != null) {
					emuts.add(ModelManager.getObject(model, emutated));
				}
			}
		}
		if (mut instanceof ObjectCloned) {
			List<EObject> emuts = ((ObjectCloned) mut).getObject();
			if (emuts.size() > 0) {
				EObject emutated = emuts.get(0);
				emuts.remove(0);
				if (ModelManager.getObject(model, emutated) != null) {
					emuts.add(ModelManager.getObject(model, emutated));
				}
			}
		}
		if (mut instanceof ObjectRemoved) {
			List<EObject> emuts = ((ObjectRemoved) mut).getObject();
			if (emuts.size() > 0) {
				EObject emutated = emuts.get(0);
				emuts.remove(0);
				boolean found = false;
				for (Resource seed : seeds) {
					if (ModelManager.getObject(seed, emutated) != null) {
						found = true;
						emuts.add(ModelManager.getObject(seed, emutated));
						break;
					}
				}
				if (found == false) {
					if (ModelManager.getObject(model, emutated) != null) {
						emuts.add(ModelManager.getObject(model, emutated));
					}
				}
				
			}
		}
		if (mut instanceof ObjectRetyped) {
			List<EObject> emuts = ((ObjectRetyped) mut).getRemovedObject();
			if (emuts.size() > 0) {
				EObject emutated = emuts.get(0);
				emuts.remove(0);
				boolean found = false;
				for (Resource seed : seeds) {
					if (ModelManager.getObject(seed, emutated) != null) {
						found = true;
						emuts.add(ModelManager.getObject(seed, emutated));
						break;
					}
				}
				if (found == false) {
					if (ModelManager.getObject(model, emutated) != null) {
						emuts.add(ModelManager.getObject(model, emutated));
					}
				}
				
			}
		}
		if (mut instanceof InformationChanged) {
			EObject emutated = ((InformationChanged) mut).getObject();
			if (ModelManager.getObject(model, emutated) == null) {
				EObject object = ModelManager.getObject(model, emutated);
				if (object != null) {
					((InformationChanged) mut).setObject(object);
				}
			}
		}
		String registryFilename = versionPath.substring(0, versionPath.lastIndexOf("/")) + "/registry/" + versionPath.substring(versionPath.lastIndexOf("/") + 1, versionPath.length()).replace(".model", "Registry.model");
		Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		muts.getMuts().add(EcoreUtil.copy(mut));
		ModelManager.createModel(muts, registryFilename);
	}
	
	
	/**
	 * Gets the class mutators
	 * @param packages
	 * @return
	 */
	public static List<EClass> getClassMutators(List<EPackage> packages) {
		List<EClass> mutators = new ArrayList<EClass>();
		List<EObject> objects = ModelManager.getAllObjects(packages);
		for (EObject obj : objects) {
			if (obj instanceof EClass) {
				EClass eClass = (EClass) obj;
				String name = eClass.getName();
				for (String mutatorTypeName : mutatorOfClassTypeNames) {
					if (name.equals(mutatorTypeName)) {
						mutators.add(eClass);
						break;
					}
				}
			}
		}
		return mutators;
	}
	
	/**
	 * Gets the creation mutators
	 * @param packages
	 * @return
	 */
	public static List<EClass> getCreationClassMutators(List<EPackage> packages) {
		List<EClass> mutators = new ArrayList<EClass>();
		List<EObject> objects = ModelManager.getAllObjects(packages);
		for (EObject obj : objects) {
			if (obj instanceof EClass) {
				EClass eClass = (EClass) obj;
				String name = eClass.getName();
				for (String mutatorTypeName : creationMutatorTypeNames) {
					if (name.equals(mutatorTypeName)) {
						mutators.add(eClass);
						break;
					}
				}
			}
		}
		return mutators;
	}
	
	/**
	 * Gets the modification mutators
	 * @param packages
	 * @return
	 */
	public static List<EClass> getModificationClassMutators(List<EPackage> packages) {
		List<EClass> mutators = new ArrayList<EClass>();
		List<EObject> objects = ModelManager.getAllObjects(packages);
		for (EObject obj : objects) {
			if (obj instanceof EClass) {
				EClass eClass = (EClass) obj;
				String name = eClass.getName();
				for (String mutatorTypeName : modificationMutatorTypeNames) {
					if (name.equals(mutatorTypeName)) {
						mutators.add(eClass);
						break;
					}
				}
			}
		}
		return mutators;
	}

	/**
	 * Gets the reference modification mutators
	 * @param packages
	 * @return
	 */
	public static List<EClass> getModificationReferenceClassMutators(List<EPackage> packages) {
		List<EClass> mutators = new ArrayList<EClass>();
		List<EObject> objects = ModelManager.getAllObjects(packages);
		for (EObject obj : objects) {
			if (obj instanceof EClass) {
				EClass eClass = (EClass) obj;
				String name = eClass.getName();
				for (String mutatorTypeName : referenceModificationMutatorTypeNames) {
					if (name.equals(mutatorTypeName)) {
						mutators.add(eClass);
						break;
					}
				}
			}
		}
		return mutators;
	}

	/**
	 * Gets the deletion mutators
	 * @param packages
	 * @return
	 */
	public static List<EClass> getDeletionClassMutators(List<EPackage> packages) {
		List<EClass> mutators = new ArrayList<EClass>();
		List<EObject> objects = ModelManager.getAllObjects(packages);
		for (EObject obj : objects) {
			if (obj instanceof EClass) {
				EClass eClass = (EClass) obj;
				String name = eClass.getName();
				for (String mutatorTypeName : deletionMutatorTypeNames) {
					if (name.equals(mutatorTypeName)) {
						mutators.add(eClass);
						break;
					}
				}
			}
		}
		return mutators;
	}

	/**
	 * Gets the mutator strategies
	 * @param packages
	 * @return
	 */
	public static List<EClass> getMutatorStrategies(List<EPackage> packages, String className) {
		List<EClass> strategies = new ArrayList<EClass>();
		List<EObject> objects = ModelManager.getAllObjects(packages);
		for (String mutatorTypeName : mutatorWithStrategyTypeNames) {
			if (className.equals(mutatorTypeName)) {
				for (EObject obj : objects) {
					if (obj instanceof EClass) {
						EClass eClass = (EClass) obj;
						String name = eClass.getName();
						if (name.equals("RandomTypeSelection") ||
								name.equals("CompleteTypeSelection")) {
							strategies.add(eClass);
						}
					}
				}
				break;
			}
		}
		return strategies;
	}
	
	/**
	 * Gets the blocks in the Wodel program
	 * @param model
	 * @return
	 */
	public static List<EObject> getBlocks(Resource model) {
		return ModelManager.getObjectsOfType("Block", model);
	}

	/**
	 * Gets the blocks in the Wodel program
	 * @param model
	 * @return
	 */
	public static List<EObject> getBlocks(List<Resource> models) {
		List<EObject> blocks = new ArrayList<EObject>();
		for (Resource model : models) {
			blocks.addAll(getBlocks(model));
		}
		return blocks;
	}

	/**
	 * Gets the block with the given name
	 * @param model
	 * @param blockName
	 * @return
	 */
	public static EObject getBlock(Resource model, String blockName) {
		EObject block = null;
		List<EObject> blocks = getBlocks(model);
		for (EObject obj : blocks) {
			String name = ModelManager.getStringAttribute("name", obj);
			if (name.equals(blockName)) {
				block = obj;
				break;
			}
		}
		return block;
	}

	/**
	 * Gets the mutator container type
	 * @param model
	 * @param name
	 * @return
	 */
	public static EClass getMutatorContainerType(Resource model, String name) {
		EClass eClass = null;
		List<EObject> objects = ModelManager.getAllObjects(model);
		Map<String, EObject> mutators = getMutators(objects);
		for (String mutatorClassName : mutators.keySet()) {
			EObject mutator = mutators.get(mutatorClassName);
			if (mutator instanceof CreateObjectMutator) {
				CreateObjectMutator mut = (CreateObjectMutator) mutator;
				if (mut.getName() != null) {
					if (mut.getName().equals(name)) {
						//eClass = MutatorUtils.getType(mut);
						ObSelectionStrategy container = mut.getContainer();
						if (container != null) {
							if (container instanceof SpecificObjectSelection) {
								SpecificObjectSelection selection = (SpecificObjectSelection) container;
								eClass = MutatorUtils.getMutatorType(model, selection.getObjSel().getName());
							}
							else {
								eClass = container.getType();
							}
							break;
						}
					}
				}
			}
			if (mutator instanceof CloneObjectMutator) {
				CloneObjectMutator mut = (CloneObjectMutator) mutator;
				if (mut.getName() != null) {
					if (mut.getName().equals(name)) {
						//eClass = MutatorUtils.getStrategyType(mut.getObject());
						ObSelectionStrategy container = mut.getContainer();
						if (container != null) {
							if (container instanceof SpecificObjectSelection) {
								SpecificObjectSelection selection = (SpecificObjectSelection) container;
								eClass = MutatorUtils.getMutatorType(model, selection.getObjSel().getName());
							}
							else {
								eClass = container.getType();
							}
							break;
						}
					}
				}
			}
			if (mutator instanceof RetypeObjectMutator) {
				RetypeObjectMutator mut = (RetypeObjectMutator) mutator;
				if (mut.getName() != null) {
					if (mut.getName().equals(name)) {
//						eClass = MutatorUtils.getStrategyType(mut.getObject());
						ObSelectionStrategy container = mut.getContainer();
						if (container != null) {
							if (container instanceof SpecificObjectSelection) {
								SpecificObjectSelection selection = (SpecificObjectSelection) container;
								eClass = MutatorUtils.getMutatorType(model, selection.getObjSel().getName());
							}
							else {
								eClass = container.getType();
							}
							break;
						}
					}
				}
			}
			if (mutator instanceof mutatorenvironment.SelectObjectMutator) {
				mutatorenvironment.SelectObjectMutator mut = (mutatorenvironment.SelectObjectMutator) mutator;
				if (mut.getName() != null) {
					if (mut.getName().equals(name)) {
						ObSelectionStrategy container = mut.getContainer();
						if (container != null) {
							if (container instanceof SpecificObjectSelection) {
								SpecificObjectSelection selection = (SpecificObjectSelection) container;
								eClass = MutatorUtils.getMutatorType(model, selection.getObjSel().getName());
							}
							else {
								eClass = container.getType();
							}
							break;
						}
					}
				}
			}
		}
		return eClass;
	}

	/**
	 * Gets the mutator container type
	 * @param model
	 * @param name
	 * @return
	 */
	public static EClass getMutatorObjectType(Resource model, String name) {
		EClass eClass = null;
		List<EObject> objects = ModelManager.getAllObjects(model);
		Map<String, EObject> mutators = getMutators(objects);
		for (String mutatorClassName : mutators.keySet()) {
			EObject mutator = mutators.get(mutatorClassName);
			if (mutator instanceof CloneObjectMutator) {
				CloneObjectMutator mut = (CloneObjectMutator) mutator;
				if (mut.getName() != null) {
					if (mut.getName().equals(name)) {
						eClass = MutatorUtils.getStrategyType(mut.getObject());
						break;
					}
				}
			}
			if (mutator instanceof RetypeObjectMutator) {
				RetypeObjectMutator mut = (RetypeObjectMutator) mutator;
				if (mut.getName() != null) {
					if (mut.getName().equals(name)) {
						eClass = MutatorUtils.getStrategyType(mut.getObject());
						break;
					}
				}
			}
			if (mutator instanceof mutatorenvironment.SelectObjectMutator) {
				mutatorenvironment.SelectObjectMutator mut = (mutatorenvironment.SelectObjectMutator) mutator;
				if (mut.getName() != null) {
					if (mut.getName().equals(name)) {
						eClass = MutatorUtils.getStrategyType(mut.getObject());
						break;
					}
				}
			}
		}
		return eClass;
	}

	/**
	 * Gets the mutator type
	 * @param model
	 * @param name
	 * @return
	 */
	public static EClass getMutatorType(Resource model, String name) {
		EClass eClass = null;
		List<EObject> objects = ModelManager.getAllObjects(model);
		List<Object> objs = new ArrayList<Object>();
		objs.addAll(objects);
		Map<String, Object> mutators = getMutatorNames(objs);
		for (String mutatorClassName : mutators.keySet()) {
			Object obj = mutators.get(mutatorClassName);
			if (obj instanceof EObject) {
				EObject mutator = (EObject) obj;
				if (mutator instanceof CreateObjectMutator) {
					CreateObjectMutator mut = (CreateObjectMutator) mutator;
					if (mut.getName().equals(name)) {
						eClass = mut.getType();
						break;
					}
				}
				if (mutator instanceof CloneObjectMutator) {
					CloneObjectMutator mut = (CloneObjectMutator) mutator;
					if (mut.getName().equals(name)) {
						eClass = mut.getType();
						break;
					}
				}
				if (mutator instanceof RetypeObjectMutator) {
					RetypeObjectMutator mut = (RetypeObjectMutator) mutator;
					if (mut.getName().equals(name)) {
						eClass = mut.getType();
						break;
					}
				}
				if (mutator instanceof mutatorenvironment.SelectObjectMutator) {
					mutatorenvironment.SelectObjectMutator mut = (mutatorenvironment.SelectObjectMutator) mutator;
					if (mut.getName().equals(name)) {
						if (mut.getType() != null) {
							eClass = mut.getType();
						}
						else {
							if (mut.getObject() != null) {
								mutatorenvironment.ObSelectionStrategy object = mut.getObject();
								if (object instanceof mutatorenvironment.SpecificObjectSelection) {
									mutatorenvironment.SpecificObjectSelection selection = (mutatorenvironment.SpecificObjectSelection) object;
									if (selection.getRefType() == null) {
										eClass = getMutatorType(model, selection.getObjSel().getName());
									}
									else {
										eClass = (EClass) selection.getRefType().getEType();
									}
								}
								if (object instanceof mutatorenvironment.RandomTypeSelection) {
									mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) object;
									eClass = selection.getType();
									
								}
								if (object instanceof mutatorenvironment.CompleteTypeSelection) {
									mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) object;
									eClass = selection.getType();
									
								}
								if (object instanceof mutatorenvironment.OtherTypeSelection) {
									mutatorenvironment.OtherTypeSelection selection = (mutatorenvironment.OtherTypeSelection) object;
									eClass = selection.getType();
									
								}
							}
							else {
								if (mut.getContainer() != null) {
									mutatorenvironment.ObSelectionStrategy container = mut.getContainer();
									if (container instanceof mutatorenvironment.SpecificObjectSelection) {
										mutatorenvironment.SpecificObjectSelection selection = (mutatorenvironment.SpecificObjectSelection) container;
										if (selection.getRefType() == null) {
											eClass = getMutatorType(model, selection.getObjSel().getName());
										}
										else {
											eClass = (EClass) selection.getRefType().getEType();
										}
									}
									if (container instanceof mutatorenvironment.RandomTypeSelection) {
										mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) container;
										eClass = selection.getType();
										
									}
									if (container instanceof mutatorenvironment.CompleteTypeSelection) {
										mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) container;
										eClass = selection.getType();
										
									}
									if (container instanceof mutatorenvironment.OtherTypeSelection) {
										mutatorenvironment.OtherTypeSelection selection = (mutatorenvironment.OtherTypeSelection) container;
										eClass = selection.getType();
										
									}
								}
							}
						}
						break;
					}
				}
				if (mutator instanceof mutatorenvironment.SelectSampleMutator) {
					mutatorenvironment.SelectSampleMutator mut = (mutatorenvironment.SelectSampleMutator) mutator;
					if (mut.getName().equals(name)) {
						if (mut.getType() != null) {
							eClass = mut.getType();
						}
						else {
							if (mut.getObject() != null) {
								mutatorenvironment.ObSelectionStrategy object = mut.getObject();
								if (object instanceof mutatorenvironment.SpecificObjectSelection) {
									mutatorenvironment.SpecificObjectSelection selection = (mutatorenvironment.SpecificObjectSelection) object;
									if (selection.getRefType() == null) {
										eClass = getMutatorType(model, selection.getObjSel().getName());
									}
									else {
										eClass = (EClass) selection.getRefType().getEType();
									}
								}
								if (object instanceof mutatorenvironment.RandomTypeSelection) {
									mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) object;
									eClass = selection.getType();
									
								}
								if (object instanceof mutatorenvironment.CompleteTypeSelection) {
									mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) object;
									eClass = selection.getType();
									
								}
								if (object instanceof mutatorenvironment.OtherTypeSelection) {
									mutatorenvironment.OtherTypeSelection selection = (mutatorenvironment.OtherTypeSelection) object;
									eClass = selection.getType();
									
								}
							}
						}
						break;
					}
				}
			}
		}
		return eClass;
	}

	/**
	 * Gets the mutator type
	 * @param mutator
	 * @return
	 */
	public static EClass getMutatorType(Mutator mutator) {
		EClass eClass = null;
		if (mutator instanceof CreateObjectMutator) {
			CreateObjectMutator mut = (CreateObjectMutator) mutator;
			eClass = mut.getType();
		}
		if (mutator instanceof CloneObjectMutator) {
			CloneObjectMutator mut = (CloneObjectMutator) mutator;
			eClass = mut.getType();
		}
		if (mutator instanceof RetypeObjectMutator) {
			RetypeObjectMutator mut = (RetypeObjectMutator) mutator;
			eClass = mut.getType();
		}
		if (mutator instanceof mutatorenvironment.SelectObjectMutator) {
			mutatorenvironment.SelectObjectMutator mut = (mutatorenvironment.SelectObjectMutator) mutator;
			if (mut.getType() != null) {
				eClass = mut.getType();
			}
			else {
				if (mut.getObject() != null) {
					mutatorenvironment.ObSelectionStrategy object = mut.getObject();
					if (object instanceof mutatorenvironment.SpecificObjectSelection) {
						mutatorenvironment.SpecificObjectSelection selection = (mutatorenvironment.SpecificObjectSelection) object;
						if (selection.getRefType() == null) {
							eClass = getMutatorType((Mutator) selection.getObjSel());
						}
						else {
							eClass = (EClass) selection.getRefType().getEType();
						}
					}
					if (object instanceof mutatorenvironment.RandomTypeSelection) {
						mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) object;
						eClass = selection.getType();
					}
					if (object instanceof mutatorenvironment.CompleteTypeSelection) {
						mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) object;
						eClass = selection.getType();
					}
					if (object instanceof mutatorenvironment.OtherTypeSelection) {
						mutatorenvironment.OtherTypeSelection selection = (mutatorenvironment.OtherTypeSelection) object;
						eClass = selection.getType();
					}
				}
				else {
					if (mut.getContainer() != null) {
						mutatorenvironment.ObSelectionStrategy container = mut.getContainer();
						if (container instanceof mutatorenvironment.SpecificObjectSelection) {
							mutatorenvironment.SpecificObjectSelection selection = (mutatorenvironment.SpecificObjectSelection) container;
							if (selection.getRefType() == null) {
								eClass = getMutatorType((Mutator) selection.getObjSel());
							}
							else {
								eClass = (EClass) selection.getRefType().getEType();
							}
						}
						if (container instanceof mutatorenvironment.RandomTypeSelection) {
							mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) container;
							eClass = selection.getType();
						}
						if (container instanceof mutatorenvironment.CompleteTypeSelection) {
							mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) container;
							eClass = selection.getType();
						}
						if (container instanceof mutatorenvironment.OtherTypeSelection) {
							mutatorenvironment.OtherTypeSelection selection = (mutatorenvironment.OtherTypeSelection) container;
							eClass = selection.getType();
						}
					}
				}
			}
		}
		if (mutator instanceof mutatorenvironment.SelectSampleMutator) {
			mutatorenvironment.SelectSampleMutator mut = (mutatorenvironment.SelectSampleMutator) mutator;
			if (mut.getType() != null) {
				eClass = mut.getType();
			}
			else {
				if (mut.getObject() != null) {
					mutatorenvironment.ObSelectionStrategy object = mut.getObject();
					if (object instanceof mutatorenvironment.SpecificObjectSelection) {
						mutatorenvironment.SpecificObjectSelection selection = (mutatorenvironment.SpecificObjectSelection) object;
						if (selection.getRefType() == null) {
							eClass = getMutatorType((Mutator) selection.getObjSel());
						}
						else {
							eClass = (EClass) selection.getRefType().getEType();
						}
					}
					if (object instanceof mutatorenvironment.RandomTypeSelection) {
						mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) object;
						eClass = selection.getType();
					}
					if (object instanceof mutatorenvironment.CompleteTypeSelection) {
						mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) object;
						eClass = selection.getType();
					}
					if (object instanceof mutatorenvironment.OtherTypeSelection) {
						mutatorenvironment.OtherTypeSelection selection = (mutatorenvironment.OtherTypeSelection) object;
						eClass = selection.getType();
					}
				}
			}
		}
		return eClass;
	}
	
	/**
	 * Gets the mutator type
	 * @param mutator
	 * @return
	 */
	public static List<EClass> getMutatorTypes(Mutator mutator) {
		List<EClass> eClasses = new ArrayList<EClass>();
		if (mutator instanceof CreateObjectMutator) {
			CreateObjectMutator mut = (CreateObjectMutator) mutator;
			eClasses.addAll(mut.getTypes());
		}
		if (mutator instanceof CloneObjectMutator) {
			CloneObjectMutator mut = (CloneObjectMutator) mutator;
			eClasses.addAll(mut.getTypes());
		}
		if (mutator instanceof RetypeObjectMutator) {
			RetypeObjectMutator mut = (RetypeObjectMutator) mutator;
			eClasses.addAll(mut.getTypes());
		}
		if (mutator instanceof mutatorenvironment.SelectObjectMutator) {
			mutatorenvironment.SelectObjectMutator mut = (mutatorenvironment.SelectObjectMutator) mutator;
			if (mut.getType() != null) {
				eClasses.addAll(mut.getTypes());
			}
			else {
				if (mut.getObject() != null) {
					mutatorenvironment.ObSelectionStrategy object = mut.getObject();
					if (object instanceof mutatorenvironment.SpecificObjectSelection) {
						mutatorenvironment.SpecificObjectSelection selection = (mutatorenvironment.SpecificObjectSelection) object;
						if (selection.getRefType() == null) {
							eClasses = getMutatorTypes((Mutator) selection.getObjSel());
						}
						else {
							eClasses.add((EClass) selection.getRefType().getEType());
						}
					}
					if (object instanceof mutatorenvironment.RandomTypeSelection) {
						mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) object;
						eClasses.add(selection.getType());
						eClasses.addAll(selection.getTypes());
					}
					if (object instanceof mutatorenvironment.CompleteTypeSelection) {
						mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) object;
						eClasses.add(selection.getType());
						eClasses.addAll(selection.getTypes());
					}
					if (object instanceof mutatorenvironment.OtherTypeSelection) {
						mutatorenvironment.OtherTypeSelection selection = (mutatorenvironment.OtherTypeSelection) object;
						eClasses.add(selection.getType());
						eClasses.addAll(selection.getTypes());
					}
				}
				else {
					if (mut.getContainer() != null) {
						mutatorenvironment.ObSelectionStrategy container = mut.getContainer();
						if (container instanceof mutatorenvironment.SpecificObjectSelection) {
							mutatorenvironment.SpecificObjectSelection selection = (mutatorenvironment.SpecificObjectSelection) container;
							if (selection.getRefType() == null) {
								eClasses = getMutatorTypes((Mutator) selection.getObjSel());
							}
							else {
								eClasses.add((EClass) selection.getRefType().getEType());
							}
						}
						if (container instanceof mutatorenvironment.RandomTypeSelection) {
							mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) container;
							eClasses.add(selection.getType());
							eClasses.addAll(selection.getTypes());
						}
						if (container instanceof mutatorenvironment.CompleteTypeSelection) {
							mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) container;
							eClasses.add(selection.getType());
							eClasses.addAll(selection.getTypes());
						}
						if (container instanceof mutatorenvironment.OtherTypeSelection) {
							mutatorenvironment.OtherTypeSelection selection = (mutatorenvironment.OtherTypeSelection) container;
							eClasses.add(selection.getType());
							eClasses.addAll(selection.getTypes());
						}
					}
				}
			}
		}
		if (mutator instanceof mutatorenvironment.SelectSampleMutator) {
			mutatorenvironment.SelectSampleMutator mut = (mutatorenvironment.SelectSampleMutator) mutator;
			if (mut.getType() != null) {
				eClasses.addAll(mut.getTypes());
			}
			else {
				if (mut.getObject() != null) {
					mutatorenvironment.ObSelectionStrategy object = mut.getObject();
					if (object instanceof mutatorenvironment.SpecificObjectSelection) {
						mutatorenvironment.SpecificObjectSelection selection = (mutatorenvironment.SpecificObjectSelection) object;
						if (selection.getRefType() == null) {
							eClasses.addAll(getMutatorTypes((Mutator) selection.getObjSel()));
						}
						else {
							eClasses.add((EClass) selection.getRefType().getEType());
						}
					}
					if (object instanceof mutatorenvironment.RandomTypeSelection) {
						mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) object;
						eClasses.add(selection.getType());
						eClasses.addAll(selection.getTypes());
					}
					if (object instanceof mutatorenvironment.CompleteTypeSelection) {
						mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) object;
						eClasses.add(selection.getType());
						eClasses.addAll(selection.getTypes());
					}
					if (object instanceof mutatorenvironment.OtherTypeSelection) {
						mutatorenvironment.OtherTypeSelection selection = (mutatorenvironment.OtherTypeSelection) object;
						eClasses.add(selection.getType());
					}
				}
			}
		}
		return eClasses;
	}

	/**
	 * Gets the type name string
	 * @param e
	 * @return
	 */
	public static String getTypeName(MinValueType e) {
		String className = null;
		Mutator mut = null;
		EObject container = e.eContainer();
		while (container instanceof Mutator == false && container != null) {
			container = container.eContainer();
		}
		if (container != null) {
			mut = (Mutator) container;
			if (mut instanceof CreateObjectMutator) {
				className = mut.getType().getName();
			}
			if (mut instanceof mutatorenvironment.CloneObjectMutator) {
				mutatorenvironment.CloneObjectMutator mutCln = (mutatorenvironment.CloneObjectMutator) mut;
				if (mutCln.getObject() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) mutCln.getObject();
					if (selection.getRefType() == null) {
						if (selection.getObjSel() instanceof CreateObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectObjectMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectSampleMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof CloneObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
					}
					else {
						className = selection.getRefType().getEType().getName();
					}
				}
				if (mutCln.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
					mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) mutCln.getObject();
       				className = selection.getType().getName();
       			}
       			if (mutCln.getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
       				mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) mutCln.getObject();
       				className = selection.getType().getName();
       			}
			}
			if (mut instanceof mutatorenvironment.SelectObjectMutator) {
				mutatorenvironment.SelectObjectMutator mutSel = (mutatorenvironment.SelectObjectMutator) mut;
				if (mutSel.getObject() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) mutSel.getObject();
					if (selection.getRefType() == null) {
						if (selection.getObjSel() instanceof CreateObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectObjectMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectSampleMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof CloneObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
					}
					else {
						className = selection.getRefType().getEType().getName();
					}
				}
				if (mutSel.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
					mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) mutSel.getObject();
       				className = selection.getType().getName();
       			}
       			if (mutSel.getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
       				mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) mutSel.getObject();
       				className = selection.getType().getName();
       			}
			}
			if (mut instanceof mutatorenvironment.SelectSampleMutator) {
				mutatorenvironment.SelectSampleMutator mutSel = (mutatorenvironment.SelectSampleMutator) mut;
				if (mutSel.getObject() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) mutSel.getObject();
					if (selection.getRefType() == null) {
						if (selection.getObjSel() instanceof CreateObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectObjectMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectSampleMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof CloneObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
					}
					else {
						className = selection.getRefType().getEType().getName();
					}
				}
				if (mutSel.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
					mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) mutSel.getObject();
       				className = selection.getType().getName();
       			}
       			if (mutSel.getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
       				mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) mutSel.getObject();
       				className = selection.getType().getName();
       			}
			}
			if (mut instanceof mutatorenvironment.ModifyInformationMutator) {
				mutatorenvironment.ModifyInformationMutator mutMod = (mutatorenvironment.ModifyInformationMutator) mut;
				if (mutMod.getObject() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) mutMod.getObject();
					if (selection.getRefType() == null) {
						if (selection.getObjSel() instanceof CreateObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectObjectMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectSampleMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof CloneObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
					}
					else {
						className = selection.getRefType().getEType().getName();
					}
				}
				if (mutMod.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
					mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) mutMod.getObject();
       				className = selection.getType().getName();
       			}
       			if (mutMod.getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
       				mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) mutMod.getObject();
       				className = selection.getType().getName();
       			}
			}
		}
		return className;
	}
	
	/**
	 * Gets the type name as string
	 * @param e
	 * @return
	 */
	public static String getTypeName(MaxValueType e) {
		String className = null;
		Mutator mut = null;
		EObject container = e.eContainer();
		while (container instanceof Mutator == false && container != null) {
			container = container.eContainer();
		}
		if (container != null) {
			mut = (Mutator) container;
			if (mut instanceof CreateObjectMutator) {
				className = mut.getType().getName();
			}
			if (mut instanceof mutatorenvironment.CloneObjectMutator) {
				mutatorenvironment.CloneObjectMutator mutCln = (mutatorenvironment.CloneObjectMutator) mut;
				if (mutCln.getObject() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) mutCln.getObject();
					if (selection.getRefType() == null) {
						if (selection.getObjSel() instanceof CreateObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectObjectMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectSampleMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof CloneObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
					}
					else {
						className = selection.getRefType().getEType().getName();
					}
				}
				if (mutCln.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
					mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) mutCln.getObject();
       				className = selection.getType().getName();
       			}
       			if (mutCln.getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
       				mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) mutCln.getObject();
       				className = selection.getType().getName();
       			}
			}
			if (mut instanceof mutatorenvironment.SelectObjectMutator) {
				mutatorenvironment.SelectObjectMutator mutSel = (mutatorenvironment.SelectObjectMutator) mut;
				if (mutSel.getObject() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) mutSel.getObject();
					if (selection.getRefType() == null) {
						if (selection.getObjSel() instanceof CreateObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectObjectMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectSampleMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof CloneObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
					}
					else {
						className = selection.getRefType().getEType().getName();
					}
				}
				if (mutSel.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
					mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) mutSel.getObject();
       				className = selection.getType().getName();
       			}
       			if (mutSel.getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
       				mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) mutSel.getObject();
       				className = selection.getType().getName();
       			}
			}
			if (mut instanceof mutatorenvironment.SelectSampleMutator) {
				mutatorenvironment.SelectSampleMutator mutSel = (mutatorenvironment.SelectSampleMutator) mut;
				if (mutSel.getObject() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) mutSel.getObject();
					if (selection.getRefType() == null) {
						if (selection.getObjSel() instanceof CreateObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectObjectMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectSampleMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof CloneObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
					}
					else {
						className = selection.getRefType().getEType().getName();
					}
				}
				if (mutSel.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
					mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) mutSel.getObject();
       				className = selection.getType().getName();
       			}
       			if (mutSel.getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
       				mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) mutSel.getObject();
       				className = selection.getType().getName();
       			}
			}
			if (mut instanceof mutatorenvironment.ModifyInformationMutator) {
				mutatorenvironment.ModifyInformationMutator mutMod = (mutatorenvironment.ModifyInformationMutator) mut;
				if (mutMod.getObject() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) mutMod.getObject();
					if (selection.getRefType() == null) {
						if (selection.getObjSel() instanceof CreateObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectObjectMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectSampleMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof CloneObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
					}
					else {
						className = selection.getRefType().getEType().getName();
					}
				}
				if (mutMod.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
					mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) mutMod.getObject();
       				className = selection.getType().getName();
       			}
       			if (mutMod.getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
       				mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) mutMod.getObject();
       				className = selection.getType().getName();
       			}
			}
		}
		return className;
	}

	/**
	 * Gets the type name string
	 * @param e
	 * @return
	 */
	public static String getMinTypeName(EObject e) {
		String className = null;
		EObject mut = null;
		EObject container = e.eContainer();
		try {
			while (container.eClass().getName().equals("Mutator") == false && container != null) {
				container = container.eContainer();
			}
			if (container != null) {
				mut = container;
				if (mut.eClass().getName().equals("CreateObjectMutator")) {
					EObject type = ModelManager.getReference("type", mut);
					className = ModelManager.getStringAttribute("name", type);
				}
				if (mut.eClass().getName().equals("CloneObjectMutator")) {
					EObject object = ModelManager.getReference("object", mut);
					if (object.eClass().getName().equals("SpecificObjectSelection")) {
						EObject refType = ModelManager.getReference("refType", object);
						EObject objSel = ModelManager.getReference("objSel", object);
						if (refType == null) {
							if (objSel.eClass().getName().equals("CreateObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectObjectMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectSampleMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("CloneObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("RetypeObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
						}
						else {
							EReference ref = (EReference) refType;
							className = ref.getEType().getName();
						}
					}
					if (object.eClass().getName().equals("RandomTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
					if (object.eClass().getName().equals("CompleteTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
				}
				if (mut.eClass().getName().equals("SelectObjectMutator")) {
					EObject object = ModelManager.getReference("object", mut);
					if (object.eClass().getName().equals("SpecificObjectSelection")) {
						EObject refType = ModelManager.getReference("refType", object);
						EObject objSel = ModelManager.getReference("objSel", object);
						if (refType == null) {
							if (objSel.eClass().getName().equals("CreateObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectObjectMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectSampleMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("CloneObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("RetypeObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
						}
						else {
							EReference ref = (EReference) refType;
							className = ref.getEType().getName();
						}
					}
					if (object.eClass().getName().equals("RandomTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
					if (object.eClass().getName().equals("CompleteTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
				}
				if (mut.eClass().getName().equals("SelectSampleMutator")) {
					EObject object = ModelManager.getReference("object", mut);
					if (object.eClass().getName().equals("SpecificObjectSelection")) {
						EObject refType = ModelManager.getReference("refType", object);
						EObject objSel = ModelManager.getReference("objSel", object);
						if (refType == null) {
							if (objSel.eClass().getName().equals("CreateObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectObjectMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectSampleMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("CloneObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("RetypeObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
						}
						else {
							EReference ref = (EReference) refType;
							className = ref.getEType().getName();
						}
					}
					if (object.eClass().getName().equals("RandomTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
					if (object.eClass().getName().equals("CompleteTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
				}
				if (mut.eClass().getName().equals("ModifyInformationMutator")) {
					EObject object = ModelManager.getReference("object", mut);
					if (object.eClass().getName().equals("SpecificObjectSelection")) {
						EObject refType = ModelManager.getReference("refType", object);
						EObject objSel = ModelManager.getReference("objSel", object);
						if (refType == null) {
							if (objSel.eClass().getName().equals("CreateObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectObjectMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectSampleMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("CloneObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("RetypeObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
						}
						else {
							EReference ref = (EReference) refType;
							className = ref.getEType().getName();
						}
					}
					if (object.eClass().getName().equals("RandomTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
					if (object.eClass().getName().equals("CompleteTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
				}
			}
		} catch (ReferenceNonExistingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return className;
	}

	/**
	 * Gets the type name as string
	 * @param e
	 * @return
	 */
	public static String getMaxTypeName(EObject e) {
		String className = null;
		EObject mut = null;
		EObject container = e.eContainer();
		try {
			while (container.eClass().getName().equals("Mutator") == false && container != null) {
				container = container.eContainer();
			}
			if (container != null) {
				mut = container;
				if (mut.eClass().getName().equals("CreateObjectMutator")) {
					EObject type = ModelManager.getReference("type", mut);
					className = ModelManager.getStringAttribute("name", type);
				}
				if (mut.eClass().getName().equals("CloneObjectMutator")) {
					EObject object = ModelManager.getReference("object", mut);
					if (object.eClass().getName().equals("SpecificObjectSelection")) {
						EObject refType = ModelManager.getReference("refType", object);
						EObject objSel = ModelManager.getReference("objSel", object);
						if (refType == null) {
							if (objSel.eClass().getName().equals("CreateObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectObjectMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectSampleMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("CloneObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("RetypeObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
						}
						else {
							EReference ref = (EReference) refType;
							className = ref.getEType().getName();
						}
					}
					if (object.eClass().getName().equals("RandomTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
					if (object.eClass().getName().equals("CompleteTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
				}
				if (mut.eClass().getName().equals("SelectObjectMutator")) {
					EObject object = ModelManager.getReference("object", mut);
					if (object.eClass().getName().equals("SpecificObjectSelection")) {
						EObject refType = ModelManager.getReference("refType", object);
						EObject objSel = ModelManager.getReference("objSel", object);
						if (refType == null) {
							if (objSel.eClass().getName().equals("CreateObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectObjectMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectSampleMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("CloneObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("RetypeObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
						}
						else {
							EReference ref = (EReference) refType;
							className = ref.getEType().getName();
						}
					}
					if (object.eClass().getName().equals("RandomTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
					if (object.eClass().getName().equals("CompleteTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
				}
				if (mut.eClass().getName().equals("SelectSampleMutator")) {
					EObject object = ModelManager.getReference("object", mut);
					if (object.eClass().getName().equals("SpecificObjectSelection")) {
						EObject refType = ModelManager.getReference("refType", object);
						EObject objSel = ModelManager.getReference("objSel", object);
						if (refType == null) {
							if (objSel.eClass().getName().equals("CreateObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectObjectMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectSampleMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("CloneObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("RetypeObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
						}
						else {
							EReference ref = (EReference) refType;
							className = ref.getEType().getName();
						}
					}
					if (object.eClass().getName().equals("RandomTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
					if (object.eClass().getName().equals("CompleteTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
				}
				if (mut.eClass().getName().equals("ModifyInformationMutator")) {
					EObject object = ModelManager.getReference("object", mut);
					if (object.eClass().getName().equals("SpecificObjectSelection")) {
						EObject refType = ModelManager.getReference("refType", object);
						EObject objSel = ModelManager.getReference("objSel", object);
						if (refType == null) {
							if (objSel.eClass().getName().equals("CreateObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectObjectMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("SelectSampleMutator")) {
								EObject obj = ModelManager.getReference("object", objSel);
								EObject type = ModelManager.getReference("type", obj);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("CloneObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
							if (objSel.eClass().getName().equals("RetypeObjectMutator")) {
								EObject type = ModelManager.getReference("type", objSel);
								className = ModelManager.getStringAttribute("name", type);
							}
						}
						else {
							EReference ref = (EReference) refType;
							className = ref.getEType().getName();
						}
					}
					if (object.eClass().getName().equals("RandomTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
					if (object.eClass().getName().equals("CompleteTypeSelection")) {
						EObject obj = ModelManager.getReference("object", object);
						EObject type = ModelManager.getReference("type", obj);
						className = ModelManager.getStringAttribute("name", type);
					}
				}
			}
		} catch (ReferenceNonExistingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return className;
	}

	/**
	 * Gets the type name as string 
	 * @param op
	 * @return
	 */
	public static String getTypeName(AttributeOperation op) {
		String className = null;
		Mutator mut = null;
		EObject container = op.eContainer();
		while (container instanceof Mutator == false && container != null) {
			container = container.eContainer();
		}
		if (container != null) {
			mut = (Mutator) container;
			if (mut instanceof CreateObjectMutator) {
				className = mut.getType().getName();
			}
			if (mut instanceof mutatorenvironment.CloneObjectMutator) {
				mutatorenvironment.CloneObjectMutator mutCln = (mutatorenvironment.CloneObjectMutator) mut;
				if (mutCln.getObject() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) mutCln.getObject();
					if (selection.getRefType() == null) {
						if (selection.getObjSel() instanceof CreateObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectObjectMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectSampleMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof CloneObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
					}
					else {
						className = selection.getRefType().getEType().getName();
					}
				}
				if (mutCln.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
					mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) mutCln.getObject();
       				className = selection.getType().getName();
       			}
       			if (mutCln.getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
       				mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) mutCln.getObject();
       				className = selection.getType().getName();
       			}
			}
			if (mut instanceof mutatorenvironment.SelectObjectMutator) {
				mutatorenvironment.SelectObjectMutator mutSel = (mutatorenvironment.SelectObjectMutator) mut;
				if (mutSel.getObject() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) mutSel.getObject();
					if (selection.getRefType() == null) {
						if (selection.getObjSel() instanceof CreateObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectObjectMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectSampleMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof CloneObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
					}
					else {
						className = selection.getRefType().getEType().getName();
					}
				}
				if (mutSel.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
					mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) mutSel.getObject();
       				className = selection.getType().getName();
       			}
       			if (mutSel.getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
       				mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) mutSel.getObject();
       				className = selection.getType().getName();
       			}
			}
			if (mut instanceof mutatorenvironment.SelectSampleMutator) {
				mutatorenvironment.SelectSampleMutator mutSel = (mutatorenvironment.SelectSampleMutator) mut;
				if (mutSel.getObject() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) mutSel.getObject();
					if (selection.getRefType() == null) {
						if (selection.getObjSel() instanceof CreateObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectObjectMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectSampleMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof CloneObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
					}
					else {
						className = selection.getRefType().getEType().getName();
					}
				}
				if (mutSel.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
					mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) mutSel.getObject();
       				className = selection.getType().getName();
       			}
       			if (mutSel.getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
       				mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) mutSel.getObject();
       				className = selection.getType().getName();
       			}
			}
			if (mut instanceof mutatorenvironment.ModifyInformationMutator) {
				mutatorenvironment.ModifyInformationMutator mutMod = (mutatorenvironment.ModifyInformationMutator) mut;
				if (mutMod.getObject() instanceof SpecificObjectSelection) {
					SpecificObjectSelection selection = (SpecificObjectSelection) mutMod.getObject();
					if (selection.getRefType() == null) {
						if (selection.getObjSel() instanceof CreateObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectObjectMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
							className = ((ObSelectionStrategy) ((mutatorenvironment.SelectSampleMutator) selection.getObjSel()).getObject()).getType().getName();
						}
						if (selection.getObjSel() instanceof CloneObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							className = selection.getObjSel().getType().getName();
						}
					}
					else {
						className = selection.getRefType().getEType().getName();
					}
				}
				if (mutMod.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
					mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) mutMod.getObject();
       				className = selection.getType().getName();
       			}
       			if (mutMod.getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
       				mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) mutMod.getObject();
       				className = selection.getType().getName();
       			}
			}
		}
		return className;
	}
	
	/**
	 * Gets the type name as string
	 * @param oe
	 * @return
	 */
	public static String getTypeName(ObjectEmitter oe) {
		String type = null;
		if (oe instanceof ObjectEmitter) {
			if (oe instanceof SpecificObjectSelection) {
				type = getTypeName(((SpecificObjectSelection) oe).getObjSel());
			}
			if (oe instanceof mutatorenvironment.RandomTypeSelection) {
				type = ((mutatorenvironment.RandomTypeSelection) oe).getType().getName();
			}
			if (oe instanceof mutatorenvironment.CompleteTypeSelection) {
				type = ((mutatorenvironment.CompleteTypeSelection) oe).getType().getName();
			}
			if (oe instanceof mutatorenvironment.OtherTypeSelection) {
				type = ((mutatorenvironment.OtherTypeSelection) oe).getType().getName();
			}
			if (oe instanceof mutatorenvironment.SpecificClosureSelection) {
				type = ((mutatorenvironment.SpecificClosureSelection) oe).getRefType().getEType().getName();
			}
			if (oe instanceof mutatorenvironment.SelectObjectMutator) {
				type = getTypeName((ObjectEmitter) ((mutatorenvironment.SelectObjectMutator) oe).getObject());
			}
			if (oe instanceof mutatorenvironment.SelectSampleMutator) {
				type = getTypeName((ObjectEmitter) ((mutatorenvironment.SelectSampleMutator) oe).getObject());
			}
			if (oe instanceof mutatorenvironment.CreateObjectMutator) {
				type = ((mutatorenvironment.CreateObjectMutator) oe).getType().getName();
			}
			if (oe instanceof mutatorenvironment.CloneObjectMutator) {
				type = ((mutatorenvironment.CloneObjectMutator) oe).getType().getName();
			}
			if (oe instanceof mutatorenvironment.RetypeObjectMutator) {
				type = ((mutatorenvironment.RetypeObjectMutator) oe).getType().getName();
			}
		}
		return type;
	}

	/**
	 * Gets the type name as string
	 * @param oe
	 * @return
	 */
	public static List<String> getTypeNames(ObjectEmitter oe) {
		List<String> types = new ArrayList<String>();
		if (oe instanceof ObjectEmitter) {
			if (oe instanceof SpecificObjectSelection) {
				types.addAll(getTypeNames(((SpecificObjectSelection) oe).getObjSel()));
			}
			if (oe instanceof mutatorenvironment.RandomTypeSelection) {
				for (EClass type : ((mutatorenvironment.RandomTypeSelection) oe).getTypes()) {
					types.add(type.getName());
				}
			}
			if (oe instanceof mutatorenvironment.CompleteTypeSelection) {
				for (EClass type : ((mutatorenvironment.CompleteTypeSelection) oe).getTypes()) {
					types.add(type.getName());
				}
			}
			if (oe instanceof mutatorenvironment.OtherTypeSelection) {
				for (EClass type : ((mutatorenvironment.OtherTypeSelection) oe).getTypes()) {
					types.add(type.getName());
				}
			}
			if (oe instanceof mutatorenvironment.SpecificClosureSelection) {
				types.add(((mutatorenvironment.SpecificClosureSelection) oe).getRefType().getEType().getName());
			}
			if (oe instanceof mutatorenvironment.SelectObjectMutator) {
				types.addAll(getTypeNames((ObjectEmitter) ((mutatorenvironment.SelectObjectMutator) oe).getObject()));
			}
			if (oe instanceof mutatorenvironment.SelectSampleMutator) {
				types.addAll(getTypeNames((ObjectEmitter) ((mutatorenvironment.SelectSampleMutator) oe).getObject()));
			}
			if (oe instanceof mutatorenvironment.CreateObjectMutator) {
				for (EClass type : ((mutatorenvironment.CreateObjectMutator) oe).getTypes()) {
					types.add(type.getName());
				}
			}
			if (oe instanceof mutatorenvironment.CloneObjectMutator) {
				for (EClass type : ((mutatorenvironment.CloneObjectMutator) oe).getTypes()) {
					types.add(type.getName());
				}
			}
			if (oe instanceof mutatorenvironment.RetypeObjectMutator) {
				for (EClass type : ((mutatorenvironment.RetypeObjectMutator) oe).getTypes()) {
					types.add(type.getName());
				}
			}
		}
		return types;
	}

	/**
	 * Gets the type of the objectemitter
	 * @param oe
	 * @return
	 */
	public static EClass getType(ObjectEmitter oe) {
		EClass type = null;
		if (oe instanceof CreateObjectMutator) {
			type = ((CreateObjectMutator) oe).getType();
		}
		if (oe instanceof SelectObjectMutator) {
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.SpecificObjectSelection) {
				type = getType(((SpecificObjectSelection) ((SelectObjectMutator) oe).getObject()).getObjSel());
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.RandomTypeSelection) {
				type = ((SelectObjectMutator) oe).getObject().getType();
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
				type = ((SelectObjectMutator) oe).getObject().getType();
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.OtherTypeSelection) {
				type = ((SelectObjectMutator) oe).getObject().getType();
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.SpecificClosureSelection) {
				type = (EClass) ((SelectObjectMutator) oe).getObject().getRefType().getEType();
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.SelectObjectMutator) {
				type = getType((ObjectEmitter) ((mutatorenvironment.SelectObjectMutator) oe).getObject());
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.SelectSampleMutator) {
				type = getType((ObjectEmitter) ((SelectObjectMutator) oe).getObject());
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.CreateObjectMutator) {
				type = ((CreateObjectMutator) ((mutatorenvironment.SelectObjectMutator) oe).getObject()).getType();
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.CloneObjectMutator) {
				type = ((CloneObjectMutator) ((mutatorenvironment.SelectObjectMutator) oe).getObject()).getType();
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.RetypeObjectMutator) {
				type = ((RetypeObjectMutator) ((mutatorenvironment.SelectObjectMutator) oe).getObject()).getType();
			}
		}
		if (oe instanceof RemoveObjectMutator) {
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.SpecificObjectSelection) {
				type = getType(((SpecificObjectSelection) ((RemoveObjectMutator) oe).getObject()).getObjSel());
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.RandomTypeSelection) {
				type = ((RemoveObjectMutator) oe).getObject().getType();
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
				type = ((RemoveObjectMutator) oe).getObject().getType();
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.OtherTypeSelection) {
				type = ((RemoveObjectMutator) oe).getObject().getType();
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.SpecificClosureSelection) {
				type = (EClass) ((RemoveObjectMutator) oe).getObject().getRefType().getEType();
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.SelectObjectMutator) {
				type = getType((ObjectEmitter) ((mutatorenvironment.RemoveObjectMutator) oe).getObject());
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.SelectSampleMutator) {
				type = getType((ObjectEmitter) ((RemoveObjectMutator) oe).getObject());
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.CreateObjectMutator) {
				type = ((CreateObjectMutator) ((mutatorenvironment.RemoveObjectMutator) oe).getObject()).getType();
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.CloneObjectMutator) {
				type = ((CloneObjectMutator) ((mutatorenvironment.RemoveObjectMutator) oe).getObject()).getType();
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.RetypeObjectMutator) {
				type = ((RetypeObjectMutator) ((mutatorenvironment.RemoveObjectMutator) oe).getObject()).getType();
			}
		}
		if (oe instanceof ModifyInformationMutator) {
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.SpecificObjectSelection) {
				type = ((SpecificObjectSelection) ((ModifyInformationMutator) oe).getObject()).getType();
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.RandomTypeSelection) {
				type = ((ModifyInformationMutator) oe).getObject().getType();
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
				type = ((ModifyInformationMutator) oe).getObject().getType();
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.OtherTypeSelection) {
				type = ((ModifyInformationMutator) oe).getObject().getType();
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.SpecificClosureSelection) {
				type = (EClass) ((ModifyInformationMutator) oe).getObject().getRefType().getEType();
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.SelectObjectMutator) {
				type = getType((ObjectEmitter) ((mutatorenvironment.ModifyInformationMutator) oe).getObject());
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.SelectSampleMutator) {
				type = getType((ObjectEmitter) ((ModifyInformationMutator) oe).getObject());
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.CreateObjectMutator) {
				type = ((CreateObjectMutator) ((mutatorenvironment.ModifyInformationMutator) oe).getObject()).getType();
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.CloneObjectMutator) {
				type = ((CloneObjectMutator) ((mutatorenvironment.ModifyInformationMutator) oe).getObject()).getType();
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.RetypeObjectMutator) {
				type = ((RetypeObjectMutator) ((mutatorenvironment.ModifyInformationMutator) oe).getObject()).getType();
			}
		}
		if (oe instanceof SelectSampleMutator) {
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.SpecificObjectSelection) {
				type = getType(((SpecificObjectSelection) ((SelectSampleMutator) oe).getObject()).getObjSel());
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.RandomTypeSelection) {
				type = ((SelectObjectMutator) oe).getObject().getType();
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
				type = ((SelectSampleMutator) oe).getObject().getType();
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.OtherTypeSelection) {
				type = ((SelectSampleMutator) oe).getObject().getType();
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.SpecificClosureSelection) {
				type = (EClass) ((SelectSampleMutator) oe).getObject().getRefType().getEType();
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.SelectObjectMutator) {
				type = getType((ObjectEmitter) ((mutatorenvironment.SelectSampleMutator) oe).getObject());
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.SelectSampleMutator) {
				type = getType((ObjectEmitter) ((SelectSampleMutator) oe).getObject());
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.CreateObjectMutator) {
				type = ((CreateObjectMutator) ((mutatorenvironment.SelectSampleMutator) oe).getObject()).getType();
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.CloneObjectMutator) {
				type = ((CloneObjectMutator) ((mutatorenvironment.SelectSampleMutator) oe).getObject()).getType();
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.RetypeObjectMutator) {
				type = ((RetypeObjectMutator) ((mutatorenvironment.SelectSampleMutator) oe).getObject()).getType();
			}
		}
		if (oe instanceof CloneObjectMutator) {
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.SpecificObjectSelection) {
				type = getType(((SpecificObjectSelection) ((CloneObjectMutator) oe).getObject()).getObjSel());
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.RandomTypeSelection) {
				type = ((CloneObjectMutator) oe).getObject().getType();
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
				type = ((CloneObjectMutator) oe).getObject().getType();
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.OtherTypeSelection) {
				type = ((CloneObjectMutator) oe).getObject().getType();
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.SpecificClosureSelection) {
				type = (EClass) ((CloneObjectMutator) oe).getObject().getRefType().getEType();
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.SelectObjectMutator) {
				type = getType((ObjectEmitter) ((mutatorenvironment.CloneObjectMutator) oe).getObject());
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.SelectSampleMutator) {
				type = getType((ObjectEmitter) ((CloneObjectMutator) oe).getObject());
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.CreateObjectMutator) {
				type = ((CreateObjectMutator) ((mutatorenvironment.CloneObjectMutator) oe).getObject()).getType();
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.CloneObjectMutator) {
				type = ((CloneObjectMutator) ((mutatorenvironment.CloneObjectMutator) oe).getObject()).getType();
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.RetypeObjectMutator) {
				type = ((RetypeObjectMutator) ((mutatorenvironment.CloneObjectMutator) oe).getObject()).getType();
			}
		}
		if (oe instanceof RetypeObjectMutator) {
			type = ((RetypeObjectMutator) oe).getType();
		}
		return type;
	}
	
	/**
	 * Gets the type of the objectemitter
	 * @param oe
	 * @return
	 */
	public static List<EClass> getTypes(ObjectEmitter oe) {
		List<EClass> types = new ArrayList<EClass>();
		if (oe instanceof CreateObjectMutator) {
			types.addAll(((CreateObjectMutator) oe).getTypes());
		}
		if (oe instanceof SelectObjectMutator) {
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.SpecificObjectSelection) {
				types.addAll(getTypes(((SpecificObjectSelection) ((SelectObjectMutator) oe).getObject()).getObjSel()));
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.RandomTypeSelection) {
				types.add(((SelectObjectMutator) oe).getObject().getType());
				types.addAll(((SelectObjectMutator) oe).getObject().getTypes());
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
				types.add(((SelectObjectMutator) oe).getObject().getType());
				types.addAll(((SelectObjectMutator) oe).getObject().getTypes());
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.OtherTypeSelection) {
				types.add(((SelectObjectMutator) oe).getObject().getType());
				types.addAll(((SelectObjectMutator) oe).getObject().getTypes());
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.SpecificClosureSelection) {
				types.add((EClass) ((SelectObjectMutator) oe).getObject().getRefType().getEType());
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.SelectObjectMutator) {
				types.add(getType((ObjectEmitter) ((mutatorenvironment.SelectObjectMutator) oe).getObject()));
				types.addAll(getTypes((ObjectEmitter) ((mutatorenvironment.SelectObjectMutator) oe).getObject()));
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.SelectSampleMutator) {
				types.add(getType((ObjectEmitter) ((SelectObjectMutator) oe).getObject()));
				types.addAll(getTypes((ObjectEmitter) ((SelectObjectMutator) oe).getObject()));
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.CreateObjectMutator) {
				types.add(((CreateObjectMutator) ((mutatorenvironment.SelectObjectMutator) oe).getObject()).getType());
				types.addAll(((CreateObjectMutator) ((mutatorenvironment.SelectObjectMutator) oe).getObject()).getTypes());
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.CloneObjectMutator) {
				types.add(((CloneObjectMutator) ((mutatorenvironment.SelectObjectMutator) oe).getObject()).getType());
				types.addAll(((CloneObjectMutator) ((mutatorenvironment.SelectObjectMutator) oe).getObject()).getTypes());
			}
			if (((SelectObjectMutator) oe).getObject() instanceof mutatorenvironment.RetypeObjectMutator) {
				types.add(((RetypeObjectMutator) ((mutatorenvironment.SelectObjectMutator) oe).getObject()).getType());
				types.addAll(((RetypeObjectMutator) ((mutatorenvironment.SelectObjectMutator) oe).getObject()).getTypes());
			}
		}
		if (oe instanceof RemoveObjectMutator) {
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.SpecificObjectSelection) {
				types.add(getType(((SpecificObjectSelection) ((RemoveObjectMutator) oe).getObject()).getObjSel()));
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.RandomTypeSelection) {
				types.add(((RemoveObjectMutator) oe).getObject().getType());
				types.addAll(((RemoveObjectMutator) oe).getObject().getTypes());
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
				types.add(((RemoveObjectMutator) oe).getObject().getType());
				types.addAll(((RemoveObjectMutator) oe).getObject().getTypes());
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.OtherTypeSelection) {
				types.add(((RemoveObjectMutator) oe).getObject().getType());
				types.addAll(((RemoveObjectMutator) oe).getObject().getTypes());
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.SpecificClosureSelection) {
				types.add((EClass) ((RemoveObjectMutator) oe).getObject().getRefType().getEType());
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.SelectObjectMutator) {
				types.add(getType((ObjectEmitter) ((mutatorenvironment.RemoveObjectMutator) oe).getObject()));
				types.addAll(getTypes((ObjectEmitter) ((mutatorenvironment.RemoveObjectMutator) oe).getObject()));
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.SelectSampleMutator) {
				types.add(getType((ObjectEmitter) ((RemoveObjectMutator) oe).getObject()));
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.CreateObjectMutator) {
				types.add(((CreateObjectMutator) ((mutatorenvironment.RemoveObjectMutator) oe).getObject()).getType());
				types.addAll(((CreateObjectMutator) ((mutatorenvironment.RemoveObjectMutator) oe).getObject()).getTypes());
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.CloneObjectMutator) {
				types.add(((CloneObjectMutator) ((mutatorenvironment.RemoveObjectMutator) oe).getObject()).getType());
				types.addAll(((CloneObjectMutator) ((mutatorenvironment.RemoveObjectMutator) oe).getObject()).getTypes());
			}
			if (((RemoveObjectMutator) oe).getObject() instanceof mutatorenvironment.RetypeObjectMutator) {
				types.add(((RetypeObjectMutator) ((mutatorenvironment.RemoveObjectMutator) oe).getObject()).getType());
				types.addAll(((RetypeObjectMutator) ((mutatorenvironment.RemoveObjectMutator) oe).getObject()).getTypes());
			}
		}
		if (oe instanceof ModifyInformationMutator) {
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.SpecificObjectSelection) {
				types.add(((SpecificObjectSelection) ((ModifyInformationMutator) oe).getObject()).getType());
				types.addAll(((SpecificObjectSelection) ((ModifyInformationMutator) oe).getObject()).getTypes());
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.RandomTypeSelection) {
				types.add(((ModifyInformationMutator) oe).getObject().getType());
				types.addAll(((ModifyInformationMutator) oe).getObject().getTypes());
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
				types.add(((ModifyInformationMutator) oe).getObject().getType());
				types.addAll(((ModifyInformationMutator) oe).getObject().getTypes());
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.OtherTypeSelection) {
				types.add(((ModifyInformationMutator) oe).getObject().getType());
				types.addAll(((ModifyInformationMutator) oe).getObject().getTypes());
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.SpecificClosureSelection) {
				types.add((EClass) ((ModifyInformationMutator) oe).getObject().getRefType().getEType());
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.SelectObjectMutator) {
				types.add(getType((ObjectEmitter) ((mutatorenvironment.ModifyInformationMutator) oe).getObject()));
				types.addAll(getTypes((ObjectEmitter) ((mutatorenvironment.ModifyInformationMutator) oe).getObject()));
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.SelectSampleMutator) {
				types.add(getType((ObjectEmitter) ((ModifyInformationMutator) oe).getObject()));
				types.addAll(getTypes((ObjectEmitter) ((ModifyInformationMutator) oe).getObject()));
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.CreateObjectMutator) {
				types.add(((CreateObjectMutator) ((mutatorenvironment.ModifyInformationMutator) oe).getObject()).getType());
				types.addAll(((CreateObjectMutator) ((mutatorenvironment.ModifyInformationMutator) oe).getObject()).getTypes());
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.CloneObjectMutator) {
				types.add(((CloneObjectMutator) ((mutatorenvironment.ModifyInformationMutator) oe).getObject()).getType());
				types.addAll(((CloneObjectMutator) ((mutatorenvironment.ModifyInformationMutator) oe).getObject()).getTypes());
			}
			if (((ModifyInformationMutator) oe).getObject() instanceof mutatorenvironment.RetypeObjectMutator) {
				types.add(((RetypeObjectMutator) ((mutatorenvironment.ModifyInformationMutator) oe).getObject()).getType());
				types.addAll(((RetypeObjectMutator) ((mutatorenvironment.ModifyInformationMutator) oe).getObject()).getTypes());
			}
		}
		if (oe instanceof SelectSampleMutator) {
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.SpecificObjectSelection) {
				types.add(getType(((SpecificObjectSelection) ((SelectSampleMutator) oe).getObject()).getObjSel()));
				types.addAll(getTypes(((SpecificObjectSelection) ((SelectSampleMutator) oe).getObject()).getObjSel()));
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.RandomTypeSelection) {
				types.add(((SelectObjectMutator) oe).getObject().getType());
				types.addAll(((SelectObjectMutator) oe).getObject().getTypes());
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
				types.add(((SelectSampleMutator) oe).getObject().getType());
				types.addAll(((SelectSampleMutator) oe).getObject().getTypes());
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.OtherTypeSelection) {
				types.add(((SelectSampleMutator) oe).getObject().getType());
				types.addAll(((SelectSampleMutator) oe).getObject().getTypes());
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.SpecificClosureSelection) {
				types.add((EClass) ((SelectSampleMutator) oe).getObject().getRefType().getEType());
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.SelectObjectMutator) {
				types.add(getType((ObjectEmitter) ((mutatorenvironment.SelectSampleMutator) oe).getObject()));
				types.addAll(getTypes((ObjectEmitter) ((mutatorenvironment.SelectSampleMutator) oe).getObject()));
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.SelectSampleMutator) {
				types.add(getType((ObjectEmitter) ((SelectSampleMutator) oe).getObject()));
				types.addAll(getTypes((ObjectEmitter) ((SelectSampleMutator) oe).getObject()));
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.CreateObjectMutator) {
				types.add(((CreateObjectMutator) ((mutatorenvironment.SelectSampleMutator) oe).getObject()).getType());
				types.addAll(((CreateObjectMutator) ((mutatorenvironment.SelectSampleMutator) oe).getObject()).getTypes());
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.CloneObjectMutator) {
				types.add(((CloneObjectMutator) ((mutatorenvironment.SelectSampleMutator) oe).getObject()).getType());
				types.addAll(((CloneObjectMutator) ((mutatorenvironment.SelectSampleMutator) oe).getObject()).getTypes());
			}
			if (((SelectSampleMutator) oe).getObject() instanceof mutatorenvironment.RetypeObjectMutator) {
				types.add(((RetypeObjectMutator) ((mutatorenvironment.SelectSampleMutator) oe).getObject()).getType());
				types.addAll(((RetypeObjectMutator) ((mutatorenvironment.SelectSampleMutator) oe).getObject()).getTypes());
			}
		}
		if (oe instanceof CloneObjectMutator) {
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.SpecificObjectSelection) {
				types.add(getType(((SpecificObjectSelection) ((CloneObjectMutator) oe).getObject()).getObjSel()));
				types.addAll(getTypes(((SpecificObjectSelection) ((CloneObjectMutator) oe).getObject()).getObjSel()));
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.RandomTypeSelection) {
				types.add(((CloneObjectMutator) oe).getObject().getType());
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.CompleteTypeSelection) {
				types.add(((CloneObjectMutator) oe).getObject().getType());
				types.addAll(((CloneObjectMutator) oe).getObject().getTypes());
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.OtherTypeSelection) {
				types.add(((CloneObjectMutator) oe).getObject().getType());
				types.addAll(((CloneObjectMutator) oe).getObject().getTypes());
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.SpecificClosureSelection) {
				types.add((EClass) ((CloneObjectMutator) oe).getObject().getRefType().getEType());
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.SelectObjectMutator) {
				types.add(getType((ObjectEmitter) ((mutatorenvironment.CloneObjectMutator) oe).getObject()));
				types.addAll(getTypes((ObjectEmitter) ((mutatorenvironment.CloneObjectMutator) oe).getObject()));
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.SelectSampleMutator) {
				types.add(getType((ObjectEmitter) ((CloneObjectMutator) oe).getObject()));
				types.addAll(getTypes((ObjectEmitter) ((CloneObjectMutator) oe).getObject()));
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.CreateObjectMutator) {
				types.add(((CreateObjectMutator) ((mutatorenvironment.CloneObjectMutator) oe).getObject()).getType());
				types.addAll(((CreateObjectMutator) ((mutatorenvironment.CloneObjectMutator) oe).getObject()).getTypes());
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.CloneObjectMutator) {
				types.add(((CloneObjectMutator) ((mutatorenvironment.CloneObjectMutator) oe).getObject()).getType());
				types.addAll(((CloneObjectMutator) ((mutatorenvironment.CloneObjectMutator) oe).getObject()).getTypes());
			}
			if (((CloneObjectMutator) oe).getObject() instanceof mutatorenvironment.RetypeObjectMutator) {
				types.add(((RetypeObjectMutator) ((mutatorenvironment.CloneObjectMutator) oe).getObject()).getType());
				types.addAll(((RetypeObjectMutator) ((mutatorenvironment.CloneObjectMutator) oe).getObject()).getTypes());
			}
		}
		if (oe instanceof RetypeObjectMutator) {
			types.add(((RetypeObjectMutator) oe).getType());
			types.addAll(((RetypeObjectMutator) oe).getTypes());
		}
		return types;
	}

	/**
	 * Gets the mutator for the given name
	 * @param model
	 * @param name
	 * @return
	 */
	public static EObject getMutator(Resource model, String name) {
		List<EObject> objects = ModelManager.getAllObjects(model);
		List<Object> objs = new ArrayList<Object>();
		objs.addAll(objects);
		Map<String, Object> mutators = getMutatorNames(objs);
		Object mut = mutators.get(name);
		if (mut instanceof EObject) {
			return (EObject) mut;
		}
		return null;
	}

	/**
	 * Gets the type of the given strategy
	 * @param strategy
	 * @return
	 */
	public static EClass getStrategyType(ObSelectionStrategy strategy) {
		EClass type = null;
		
		if (strategy instanceof mutatorenvironment.SpecificObjectSelection) {
			mutatorenvironment.SpecificObjectSelection selection = (mutatorenvironment.SpecificObjectSelection) strategy;
			type = getType(selection.getObjSel());
		}
		if (strategy instanceof mutatorenvironment.RandomTypeSelection) {
			mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) strategy;
			type = selection.getType();
			
		}
		if (strategy instanceof mutatorenvironment.CompleteTypeSelection) {
			mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) strategy;
			type = selection.getType();
			
		}
		if (strategy instanceof mutatorenvironment.OtherTypeSelection) {
			mutatorenvironment.OtherTypeSelection selection = (mutatorenvironment.OtherTypeSelection) strategy;
			type = selection.getType();
		}
		return type;
	}
	
	/**
	 * Gets the type of the given strategy
	 * @param strategy
	 * @return
	 */
	public static List<EClass> getStrategyTypes(ObSelectionStrategy strategy) {
		List<EClass> types = new ArrayList<EClass>();
		
		if (strategy instanceof mutatorenvironment.SpecificObjectSelection) {
			mutatorenvironment.SpecificObjectSelection selection = (mutatorenvironment.SpecificObjectSelection) strategy;
			types.addAll(getTypes(selection.getObjSel()));
		}
		if (strategy instanceof mutatorenvironment.RandomTypeSelection) {
			mutatorenvironment.RandomTypeSelection selection = (mutatorenvironment.RandomTypeSelection) strategy;
			types.addAll(selection.getTypes());
			
		}
		if (strategy instanceof mutatorenvironment.CompleteTypeSelection) {
			mutatorenvironment.CompleteTypeSelection selection = (mutatorenvironment.CompleteTypeSelection) strategy;
			types.addAll(selection.getTypes());
			
		}
		if (strategy instanceof mutatorenvironment.OtherTypeSelection) {
			mutatorenvironment.OtherTypeSelection selection = (mutatorenvironment.OtherTypeSelection) strategy;
			types.addAll(selection.getTypes());
		}
		return types;
	}

	/**
	 * Gets the total number of seed models
	 * @param e
	 * @param path
	 * @return
	 */
	public static int getNumberOfSeedModels(MutatorEnvironment e, String path) {
		int total = 0;
	   	String modelURI = path + '/' + ((Program) e.getDefinition()).getSource().getPath();
		List<File> files = new ArrayList<File>();
		File folder = new File(modelURI);
		if (modelURI.endsWith("/")) {
			for (File file : folder.listFiles()) {
				files.add(file);
			}
		}
		else {
			files.add(folder);
		}
		for (int i = 0; i < files.size(); i++) {
			if (files.get(i).isFile()== true) {
				String pathfile = files.get(i).getPath();
				if (pathfile.endsWith(".model") == true) {
					total++;
				}
			}
		}
		return total;
	}
	
	/**
	 * Gets the type of the SelectSampleMutator
	 * as a string
	 * @param com
	 * @return
	 */
	public static String selectModifyInformationMutatorHelperName(ModifyInformationMutator com) {
		String className = null;
		if (com.getObject() instanceof ObSelectionStrategy) {
        	if (com.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
       			className = ((mutatorenvironment.RandomTypeSelection) com.getObject()).getType().getName();
       		}
       		if (com.getObject() instanceof CompleteTypeSelection) {
       			className = ((CompleteTypeSelection) com.getObject()).getType().getName();
       		}
			if (com.getObject() instanceof SpecificObjectSelection) {
				SpecificObjectSelection selection = (SpecificObjectSelection) com.getObject();
				if (selection.getObjSel() instanceof CreateObjectMutator) {
					className = selection.getObjSel().getType().getName();
				}
				if (selection.getObjSel() instanceof SelectObjectMutator) {
					className = ((SelectObjectMutator) selection.getObjSel()).getObject().getType().getName();
				}
				if (selection.getObjSel() instanceof SelectSampleMutator) {
					className = selectSampleMutatorHelperName((SelectSampleMutator) selection.getObjSel());
				}
				if (selection.getObjSel() instanceof CloneObjectMutator) {
					className = selection.getObjSel().getType().getName();
				}
				if (selection.getObjSel() instanceof RetypeObjectMutator) {
					className = selection.getObjSel().getType().getName();
				}
				if (selection.getObjSel() instanceof ModifyInformationMutator) {
					className = selectModifyInformationMutatorHelperName((ModifyInformationMutator) selection.getObjSel());
				}
			}
       		if (com.getObject() instanceof SpecificClosureSelection) {
       			SpecificClosureSelection selection = (SpecificClosureSelection) com.getObject();
     			if (selection.getObjSel() instanceof CreateObjectMutator) {
       				className = selection.getObjSel().getType().getName();
       			}
       			if (selection.getObjSel() instanceof SelectObjectMutator) {
       				className = ((SelectObjectMutator) selection.getObjSel()).getObject().getType().getName();
       			}
       			if (selection.getObjSel() instanceof SelectSampleMutator) {
					className = selectSampleMutatorHelperName((SelectSampleMutator) selection.getObjSel());
				}
       			if (selection.getObjSel() instanceof CloneObjectMutator) {
       				className = selection.getObjSel().getType().getName();
       			}
				if (selection.getObjSel() instanceof RetypeObjectMutator) {
					className = selection.getObjSel().getType().getName();
				}
				if (selection.getObjSel() instanceof ModifyInformationMutator) {
					className = selectModifyInformationMutatorHelperName((ModifyInformationMutator) selection.getObjSel());
				}
       		}
		}
		return className;
	}
	
	/**
	 * Gets the type of the SelectSampleMutator
	 * @param com
	 * @return
	 */
	public static EClass selectModifyInformationMutatorHelperType(ModifyInformationMutator com) {
		EClass eClass = null;
		if (com.getObject() instanceof ObSelectionStrategy) {
        	if (com.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
       			eClass = ((mutatorenvironment.RandomTypeSelection) com.getObject()).getType();
       		}
       		if (com.getObject() instanceof CompleteTypeSelection) {
       			eClass = ((CompleteTypeSelection) com.getObject()).getType();
       		}
			if (com.getObject() instanceof SpecificObjectSelection) {
				SpecificObjectSelection selection = (SpecificObjectSelection) com.getObject();
				if (selection.getObjSel() instanceof CreateObjectMutator) {
					eClass = selection.getObjSel().getType();
				}
				if (selection.getObjSel() instanceof SelectObjectMutator) {
					eClass = ((SelectObjectMutator) selection.getObjSel()).getObject().getType();
				}
				if (selection.getObjSel() instanceof SelectSampleMutator) {
					eClass = selectSampleMutatorHelperType((SelectSampleMutator) selection.getObjSel());
				}
				if (selection.getObjSel() instanceof CloneObjectMutator) {
					eClass = selection.getObjSel().getType();
				}
				if (selection.getObjSel() instanceof RetypeObjectMutator) {
					eClass = selection.getObjSel().getType();
				}
				if (selection.getObjSel() instanceof ModifyInformationMutator) {
					eClass = selectModifyInformationMutatorHelperType((ModifyInformationMutator) selection.getObjSel());
				}
			}
       		if (com.getObject() instanceof SpecificClosureSelection) {
       			SpecificClosureSelection selection = (SpecificClosureSelection) com.getObject();
     			if (selection.getObjSel() instanceof CreateObjectMutator) {
       				eClass = selection.getObjSel().getType();
       			}
       			if (selection.getObjSel() instanceof SelectObjectMutator) {
       				eClass = ((SelectObjectMutator) selection.getObjSel()).getObject().getType();
       			}
       			if (selection.getObjSel() instanceof SelectSampleMutator) {
					eClass = selectSampleMutatorHelperType((SelectSampleMutator) selection.getObjSel());
				}
       			if (selection.getObjSel() instanceof CloneObjectMutator) {
       				eClass = selection.getObjSel().getType();
       			}
				if (selection.getObjSel() instanceof RetypeObjectMutator) {
					eClass = selection.getObjSel().getType();
				}
				if (selection.getObjSel() instanceof ModifyInformationMutator) {
					eClass = selectModifyInformationMutatorHelperType((ModifyInformationMutator) selection.getObjSel());
				}
       		}
		}
		return eClass;
	}

	/**
	 * Gets the type of the SelectSampleMutator
	 * as a string
	 * @param com
	 * @return
	 */
	public static String selectSampleMutatorHelperName(SelectSampleMutator com) {
		String className = null;
		if (com.getObject() instanceof ObSelectionStrategy) {
        	if (com.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
       			className = ((mutatorenvironment.RandomTypeSelection) com.getObject()).getType().getName();
       		}
       		if (com.getObject() instanceof CompleteTypeSelection) {
       			className = ((CompleteTypeSelection) com.getObject()).getType().getName();
       		}
			if (com.getObject() instanceof SpecificObjectSelection) {
				SpecificObjectSelection selection = (SpecificObjectSelection) com.getObject();
				if (selection.getObjSel() instanceof CreateObjectMutator) {
					className = selection.getObjSel().getType().getName();
				}
				if (selection.getObjSel() instanceof SelectObjectMutator) {
					className = ((SelectObjectMutator) selection.getObjSel()).getObject().getType().getName();
				}
				if (selection.getObjSel() instanceof SelectSampleMutator) {
					className = selectSampleMutatorHelperName((SelectSampleMutator) selection.getObjSel());
				}
				if (selection.getObjSel() instanceof CloneObjectMutator) {
					className = selection.getObjSel().getType().getName();
				}
				if (selection.getObjSel() instanceof RetypeObjectMutator) {
					className = selection.getObjSel().getType().getName();
				}
				if (selection.getObjSel() instanceof ModifyInformationMutator) {
					className = selectModifyInformationMutatorHelperName((ModifyInformationMutator) selection.getObjSel());
				}
			}
       		if (com.getObject() instanceof SpecificClosureSelection) {
       			SpecificClosureSelection selection = (SpecificClosureSelection) com.getObject();
     			if (selection.getObjSel() instanceof CreateObjectMutator) {
       				className = selection.getObjSel().getType().getName();
       			}
       			if (selection.getObjSel() instanceof SelectObjectMutator) {
       				className = ((SelectObjectMutator) selection.getObjSel()).getObject().getType().getName();
       			}
       			if (selection.getObjSel() instanceof SelectSampleMutator) {
					className = selectSampleMutatorHelperName((SelectSampleMutator) selection.getObjSel());
				}
       			if (selection.getObjSel() instanceof CloneObjectMutator) {
       				className = selection.getObjSel().getType().getName();
       			}
				if (selection.getObjSel() instanceof RetypeObjectMutator) {
					className = selection.getObjSel().getType().getName();
				}
				if (selection.getObjSel() instanceof ModifyInformationMutator) {
					className = selectModifyInformationMutatorHelperName((ModifyInformationMutator) selection.getObjSel());
				}
       		}
		}
		return className;
	}
	
	/**
	 * Gets the type of the SelectSampleMutator
	 * @param com
	 * @return
	 */
	public static EClass selectSampleMutatorHelperType(SelectSampleMutator com) {
		EClass eClass = null;
		if (com.getObject() instanceof ObSelectionStrategy) {
        	if (com.getObject() instanceof mutatorenvironment.RandomTypeSelection) {
       			eClass = ((mutatorenvironment.RandomTypeSelection) com.getObject()).getType();
       		}
       		if (com.getObject() instanceof CompleteTypeSelection) {
       			eClass = ((CompleteTypeSelection) com.getObject()).getType();
       		}
			if (com.getObject() instanceof SpecificObjectSelection) {
				SpecificObjectSelection selection = (SpecificObjectSelection) com.getObject();
				if (selection.getObjSel() instanceof CreateObjectMutator) {
					eClass = selection.getObjSel().getType();
				}
				if (selection.getObjSel() instanceof SelectObjectMutator) {
					eClass = ((SelectObjectMutator) selection.getObjSel()).getObject().getType();
				}
				if (selection.getObjSel() instanceof SelectSampleMutator) {
					eClass = selectSampleMutatorHelperType((SelectSampleMutator) selection.getObjSel());
				}
				if (selection.getObjSel() instanceof CloneObjectMutator) {
					eClass = selection.getObjSel().getType();
				}
				if (selection.getObjSel() instanceof RetypeObjectMutator) {
					eClass = selection.getObjSel().getType();
				}
				if (selection.getObjSel() instanceof ModifyInformationMutator) {
					eClass = selectModifyInformationMutatorHelperType((ModifyInformationMutator) selection.getObjSel());
				}
			}
       		if (com.getObject() instanceof SpecificClosureSelection) {
       			SpecificClosureSelection selection = (SpecificClosureSelection) com.getObject();
     			if (selection.getObjSel() instanceof CreateObjectMutator) {
       				eClass = selection.getObjSel().getType();
       			}
       			if (selection.getObjSel() instanceof SelectObjectMutator) {
       				eClass = ((SelectObjectMutator) selection.getObjSel()).getObject().getType();
       			}
       			if (selection.getObjSel() instanceof SelectSampleMutator) {
					eClass = selectSampleMutatorHelperType((SelectSampleMutator) selection.getObjSel());
				}
       			if (selection.getObjSel() instanceof CloneObjectMutator) {
       				eClass = selection.getObjSel().getType();
       			}
				if (selection.getObjSel() instanceof RetypeObjectMutator) {
					eClass = selection.getObjSel().getType();
				}
				if (selection.getObjSel() instanceof ModifyInformationMutator) {
					eClass = selectModifyInformationMutatorHelperType((ModifyInformationMutator) selection.getObjSel());
				}
       		}
		}
		return eClass;
	}
	
	/**
	 * Mutant registry generation
	 * (Wodel program with no blocks)
	 * @param metamodel
	 * @param packages
	 * @param registeredPackages
	 * @param seed
	 * @param model
	 * @param rules
	 * @param muts
	 * @param modelFilename
	 * @param mutFilename
	 * @param registry
	 * @param hashsetMutants
	 * @param hashmapModelFilenames
	 * @param n
	 * @param mutPaths
	 * @param hashmapMutVersions
	 * @param project
	 * @return
	 * @throws ModelNotFoundException
	 */
	public boolean registryMutant(String metamodel, List<EPackage> packages, Map<String, EPackage> registeredPackages,
			Resource seed, Resource model, Map<String, List<String>> rules,
			Mutations muts, String modelFilename, String mutFilename, 
			boolean registry, Set<String> hashsetMutants,
			Map<String, String> hashmapModelFilenames,
			int n, List<String> mutPaths, Map<String,
			List<String>> hashmapMutVersions, IProject project,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes, Class<?> cls, boolean save) throws MetaModelNotFoundException, ModelNotFoundException {
		boolean isRepeated = false;
		boolean isEquivalent = false;
		boolean isValid = false;
		if (registeredPackages != null) {
			ModelManager.registerMetaModel(registeredPackages);
		}
		boolean valid = validation(metamodel, seed.getURI().toFileString());
		if (registeredPackages != null) {
			List<EPackage> registered = new ArrayList<EPackage>();
			registered.addAll(registeredPackages.values());
			ModelManager.unregisterMetaModel(registered);
		}
		if (valid == false) {
			return true;
		}
		if (serialize == false) {
			String className = modelFilename.replace(".model", "").substring(modelFilename.lastIndexOf(File.separator) + File.separator.length(), modelFilename.lastIndexOf("."));
			String mutantName = mutFilename.substring(mutFilename.lastIndexOf("/") + 1, mutFilename.length()).replace(".model", "");
			if (registeredPackages != null) {
				ModelManager.registerMetaModel(registeredPackages);
			}
			boolean value = test.modelToProject(className, model, "", mutantName, project.getName(), null);
			if (value == false) {
				return true;
			}
			if (value && classes.size() > 0) {
				String projectPath = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/" + className + "/" + mutantName + "/src/";
				WodelTestUtils.addPathToClasses(project.getName(), classes, projectPath);
			}
			if (registeredPackages != null) {
				List<EPackage> registered = new ArrayList<EPackage>();
				registered.addAll(registeredPackages.values());
				ModelManager.unregisterMetaModel(registered);
			}
		}
		else {
			if (matchesOCL(model, rules) == true) {
				File outputFolder = new File(hashmapModelFilenames.get(modelFilename));
				if (outputFolder.exists() != true) {
					outputFolder.mkdir();
				}
				if (save == true) {
					ModelManager.saveOutModel(model, mutFilename);
				}
				// VERIFY IF MUTANT IS VALID
				if (registeredPackages != null) {
					ModelManager.registerMetaModel(registeredPackages);
				}
				isValid = validate(metamodel, seed.getURI().toFileString(), mutFilename, project);
				if (isValid == false) {
					IOUtils.deleteFile(mutFilename);
					isRepeated = true;
				}
				// VERIFY IF MUTANT IS DIFFERENT
				if (isValid == true) {
					isRepeated = different(metamodel, mutFilename, hashsetMutants, project, cls);
					if (isRepeated == true) {
						IOUtils.deleteFile(mutFilename);
					}
				}
				if (isValid == true && isRepeated == false) {
					// VERIFY IF MUTANT IS EQUIVALENT
					isEquivalent = equivalent(metamodel, mutFilename, modelFilename, project);
					if (isEquivalent == true) {
						IOUtils.deleteFile(mutFilename);
					}
				}
				if (registeredPackages != null) {
					List<EPackage> registered = new ArrayList<EPackage>();
					registered.addAll(registeredPackages.values());
					ModelManager.unregisterMetaModel(registered);
				}
				// IF MUTANT IS VALID AND DIFFERENT STORES IT AND PROCEEDS
				if (isValid == true && isRepeated == false && isEquivalent == false) {
					hashsetMutants.add(mutFilename);
					if (registry == true) {
						List<String> mutVersions = null;
						if (hashmapMutVersions.containsKey(mutFilename) == true) {
							mutVersions = hashmapMutVersions.get(mutFilename);
						}
						else {
							mutVersions = new ArrayList<String>();
						}
						mutVersions.addAll(mutPaths);
						hashmapMutVersions.put(mutFilename, mutVersions);
						List<Resource> pastVersions = new ArrayList<Resource>();
						pastVersions.add(seed);
						Resource lastVersion = seed;
						for (AppMutation mut : muts.getMuts()) {
							String mutVersion = "";
							if (mut instanceof ObjectCreated) {
								List<EObject> emuts = ((ObjectCreated) mut).getObject();
								if (emuts.size() > 0) {
									EObject emutated = null;
									if (emuts.get(0).eIsProxy()) {
										emutated = EcoreUtil.resolve(emuts.get(0), model);
									}
									else {
										emutated = emuts.get(0);
									}
									emuts.remove(0);
									if (ModelManager.getObject(model, emutated) != null) {
										emuts.add(ModelManager.getObject(model, emutated));
										mutVersion = mutFilename;
									}
									else {
										if ((mutPaths != null) && (packages != null)) {
											EObject object = null;
											for (String mutatorPath : mutPaths) {
												Resource mutantvs = ModelManager.loadModel(packages, mutatorPath);
												object = ModelManager.getObject(mutantvs, emutated);
												if (object != null) {
													mutVersion = mutatorPath;
													break;
												}
											}
											if (object != null) {
												emuts.add(object);
											}
										}
									}
								}
							}
							if (mut instanceof ObjectCloned) {
								List<EObject> emuts = ((ObjectCloned) mut).getObject();
								if (emuts.size() > 0) {
									EObject emutated = null;
									if (emuts.get(0).eIsProxy()) {
										emutated = EcoreUtil.resolve(emuts.get(0), model);
									}
									else {
										emutated = emuts.get(0);
									}
									emuts.remove(0);
									if (ModelManager.getObject(model, emutated) != null) {
										emuts.add(ModelManager.getObject(model, emutated));
										mutVersion = mutFilename;
									}
									else {
										if ((mutPaths != null) && (packages != null)) {
											EObject object = null;
											for (String mutatorPath : mutPaths) {
												Resource mutantvs = ModelManager.loadModel(packages, mutatorPath);
												object = ModelManager.getObject(mutantvs, emutated);
												if (object != null) {
													mutVersion = mutatorPath;
													break;
												}
											}
											if (object != null) {
												emuts.add(object);
											}
										}
									}
								}
							}
							if (mut instanceof ObjectRemoved) {
								List<EObject> emuts = ((ObjectRemoved) mut).getObject();
								if (emuts.size() > 0) {
									EObject emutated = null;
									if (emuts.get(0).eIsProxy()) {
										emutated = EcoreUtil.resolve(emuts.get(0), seed);
									}
									else {
										emutated = emuts.get(0);
									}
									emuts.remove(0);
									if (ModelManager.getObject(seed, emutated) != null) {
										emuts.add(ModelManager.getObject(seed, emutated));
										mutVersion = mutFilename;
									}
									else {
										if ((mutPaths != null) && (packages != null)) {
											EObject object = null;
											for (String mutatorPath : mutPaths) {
												Resource mutantvs = ModelManager.loadModel(packages, mutatorPath);
												object = ModelManager.getObject(mutantvs, emutated);
												if (object != null) {
													mutVersion = mutatorPath;
													break;
												}
											}
											if (object != null) {
												emuts.add(object);
											}
										}
									}
								}
							}
							if (mut instanceof InformationChanged) {
								EObject emutated = ((InformationChanged) mut).getObject();
								if (ModelManager.getObject(model, emutated) == null) {
									if ((mutPaths != null) && (packages != null)) {
										EObject object = null;
										for (String mutatorPath : mutPaths) {
											Resource mutantvs = ModelManager.loadModel(packages, mutatorPath);
											object = ModelManager.getObject(mutantvs, emutated);
											if (object != null) {
												mutVersion = mutatorPath;
												break;
											}
										}
										if (object != null) {
											((InformationChanged) mut).setObject(object);
										}
									}
								}
							}
							if (mut instanceof ObjectRetyped) {
								List<EObject> emuts = ((ObjectRetyped) mut).getObject();
								if (emuts.size() > 0) {
									EObject emutated = null;
									if (emuts.get(0).eIsProxy()) {
										emutated = EcoreUtil.resolve(emuts.get(0), model);
									}
									else {
										emutated = emuts.get(0);
									}
									emuts.remove(0);
									if (ModelManager.getObject(model, emutated) != null) {
										emuts.add(ModelManager.getObject(model, emutated));
										mutVersion = mutFilename;
									}
									else {
										if ((mutPaths != null) && (packages != null)) {
											EObject object = null;
											for (String mutatorPath : mutPaths) {
												Resource mutantvs = ModelManager.loadModel(packages, mutatorPath);
												object = ModelManager.getObject(mutantvs, emutated);
												if (object != null) {
													mutVersion = mutatorPath;
													break;
												}
											}
											if (object != null) {
												emuts.add(object);
											}
										}
									}
								}
							}
							if (mutVersion.length() > 0) {
								Resource activeVersion = ModelManager.loadModel(packages, mutVersion);
								createMutantVersionRegistry(packages, pastVersions, activeVersion, mutVersion, mut);
								pastVersions.add(activeVersion);
								lastVersion = activeVersion;
							}
						}
						File registryFolder = new File(hashmapModelFilenames.get(modelFilename) + "/registry");
						if (registryFolder.exists() != true) {
							registryFolder.mkdir();
						}
						String registryFilename = hashmapModelFilenames.get(modelFilename) + "/registry/" + "Output" + n + "Registry.model";
						ModelManager.createModel(muts, registryFilename);
					}
				}
				else {
					// CODE TO DELETE STORED MUTANT VERSIONS
				}
			}
		}
		return isRepeated;
	}

	/**
	 * Mutant registry generation
	 * (Wodel program with blocks)
	 * @param metamodel
	 * @param packages
	 * @param seed
	 * @param model
	 * @param rules
	 * @param muts
	 * @param modelFilename
	 * @param mutFilename
	 * @param registry
	 * @param hashsetMutantsBlock
	 * @param hashmapModelFilenames
	 * @param hashmapModelFolders
	 * @param block
	 * @param fromBlocks
	 * @param n
	 * @param mutPaths
	 * @param hashmapMutVersions
	 * @param project
	 * @return
	 * @throws ModelNotFoundException
	 * @throws ReferenceNonExistingException 
	 * @throws IOException 
	 */
	public boolean registryMutantWithBlocks(String metamodel, List<EPackage> packages,
			Map<String, EPackage> registeredPackages, Resource seed, Resource model, Map<String, List<String>> rules,
			Mutations muts, String modelFilename, String mutFilename, 
			boolean registry, Set<String> hashsetMutantsBlock,
			Map<String, String> hashmapModelFilenames,
			Map<String, String> hashmapModelFolders, String block,
			List<String> fromBlocks, int n, List<String> mutPaths,
			Map<String, List<String>> hashmapMutVersions, IProject project,
			boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes, Class<?> cls, boolean save, boolean reverse) throws MetaModelNotFoundException, ModelNotFoundException, ReferenceNonExistingException, IOException {
		boolean isRepeated = false;
		boolean isEquivalent = false;
		boolean isValid = false;
		if (registeredPackages != null) {
			ModelManager.registerMetaModel(registeredPackages);
		}
		boolean valid = validation(metamodel, seed.getURI().toFileString());
		if (registeredPackages != null) {
			List<EPackage> registered = new ArrayList<EPackage>();
			registered.addAll(registeredPackages.values());
			ModelManager.unregisterMetaModel(registered);
		}
		if (valid == false) {
			return true;
		}
		if (serialize == false) {
			String className = modelFilename.replace(".model", "").substring(modelFilename.lastIndexOf(File.separator) + File.separator.length(), modelFilename.lastIndexOf("."));
			String mutantName = mutFilename.substring(mutFilename.lastIndexOf("/") + 1, mutFilename.length()).replace(".model", "");
			if (registeredPackages != null) {
				ModelManager.registerMetaModel(registeredPackages);
			}
			boolean value = test.modelToProject(className, model, block, mutantName, project.getName(), null);
			if (value == false) {
				return true;
			}
			if (value && classes.size() > 0) {
				String projectPath = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/" + className + "/" + block + "/" + mutantName + "/src/";
				WodelTestUtils.addPathToClasses(project.getName(), classes, projectPath);
			}
			if (registeredPackages != null) {
				List<EPackage> registered = new ArrayList<EPackage>();
				registered.addAll(registeredPackages.values());
				ModelManager.unregisterMetaModel(registered);
			}
		}
		else {
			if (matchesOCL(model, rules) == true) {
			File outputFolder = new File(
					hashmapModelFilenames.get(modelFilename));
				if (outputFolder.exists() != true) {
					outputFolder.mkdir();
				}
				outputFolder = new File(
						hashmapModelFilenames.get(modelFilename) + '/' + block);
				if (outputFolder.exists() != true) {
					outputFolder.mkdir();
				}
				if (fromBlocks.size() > 0) {
					outputFolder = new File(hashmapModelFilenames.get(modelFilename) + '/' + block + '/' + hashmapModelFolders.get(modelFilename));
					if (outputFolder.exists() != true) {
						outputFolder.mkdir();
					}
				}
				if (save == true) {
					ModelManager.saveOutModel(model, mutFilename);
				}
				// VERIFY IF MUTANT IS VALID
				if (registeredPackages != null) {
					ModelManager.registerMetaModel(registeredPackages);
				}
				isValid = validate(metamodel, seed.getURI().toFileString(), mutFilename, project);
				if (isValid == false) {
					IOUtils.deleteFile(mutFilename);
					isRepeated = true;
				}
				if (isValid == true) {
					// VERIFY IF MUTANT IS DIFFERENT
					isRepeated = different(metamodel, mutFilename, hashsetMutantsBlock, project, cls);
					if (isRepeated == true) {
						IOUtils.deleteFile(mutFilename);
					}
				}
				if (isValid == true && isRepeated == false) {
					// VERIFY IF MUTANT IS EQUIVALENT
					isEquivalent = equivalent(metamodel, mutFilename, modelFilename, project);
					if (isEquivalent == true) {
						IOUtils.deleteFile(mutFilename);
					}
				}
				if (registeredPackages != null) {
					List<EPackage> registered = new ArrayList<EPackage>();
					registered.addAll(registeredPackages.values());
					ModelManager.unregisterMetaModel(registered);
				}

				// IF MUTANT IS VALID AND DIFFERENT STORES IT AND PROCEEDS
				if (isValid == true && isRepeated == false && isEquivalent == false) {
					hashsetMutantsBlock.add(mutFilename);
					if (registry == true) {
						List<String> mutVersions = null;
						if (hashmapMutVersions.containsKey(mutFilename) == true) {
							mutVersions = hashmapMutVersions.get(mutFilename);
						}
						else {
							mutVersions = new ArrayList<String>();
						}
						mutVersions.addAll(mutPaths);
						hashmapMutVersions.put(mutFilename, mutVersions);
						List<Resource> pastVersions = new ArrayList<Resource>();
						pastVersions.add(seed);
						Resource lastVersion = seed;
						for (AppMutation mut : muts.getMuts()) {
							String mutVersion = "";
							if (mut instanceof ObjectCreated) {
								List<EObject> emuts = ((ObjectCreated) mut).getObject();
								if (emuts.size() > 0) {
									EObject emutated = null;
									if (emuts.get(0).eIsProxy()) {
										emutated = EcoreUtil.resolve(emuts.get(0), model);
									}
									else {
										emutated = emuts.get(0);
									}
									emuts.remove(0);
									if (ModelManager.getObject(seed, emutated) != null) {
										emuts.add(ModelManager.getObject(seed, emutated));
										mutVersion = mutFilename;
									}
									else {
										if ((mutPaths != null) && (packages != null)) {
											EObject object = null;
											for (String mutatorPath : mutPaths) {
												Resource mutantvs = ModelManager.loadModel(packages, mutatorPath);
												object = ModelManager.getObject(mutantvs, emutated);
												if (object != null) {
													mutVersion = mutatorPath;
													break;
												}
											}
											if (object != null) {
												emuts.add(object);
											}
										}
									}
								}
							}
							if (mut instanceof ObjectCloned) {
								List<EObject> emuts = ((ObjectCloned) mut).getObject();
								if (emuts.size() > 0) {
									EObject emutated = null;
									if (emuts.get(0).eIsProxy()) {
										emutated = EcoreUtil.resolve(emuts.get(0), model);
									}
									else {
										emutated = emuts.get(0);
									}
									emuts.remove(0);
									if (ModelManager.getObject(seed, emutated) != null) {
										emuts.add(ModelManager.getObject(seed, emutated));
										mutVersion = mutFilename;
									}
									else {
										if ((mutPaths != null) && (packages != null)) {
											EObject object = null;
											for (String mutatorPath : mutPaths) {
												Resource mutantvs = ModelManager.loadModel(packages, mutatorPath);
												object = ModelManager.getObject(mutantvs, emutated);
												if (object != null) {
													mutVersion = mutatorPath;
													break;
												}
											}
											if (object != null) {
												emuts.add(object);
											}
										}
									}
								}
							}
							if (mut instanceof ObjectRemoved) {
								List<EObject> emuts = ((ObjectRemoved) mut).getObject();
								if (emuts.size() > 0) {
									EObject emutated = null;
									if (emuts.get(0).eIsProxy()) {
										emutated = EcoreUtil.resolve(emuts.get(0), seed);
									}
									else {
										emutated = emuts.get(0);
									}
									emuts.remove(0);
									if (ModelManager.getObject(seed, emutated) != null) {
										emuts.add(ModelManager.getObject(seed, emutated));
										mutVersion = mutFilename;
									}
									else {
										if ((mutPaths != null) && (packages != null)) {
											EObject object = null;
											for (String mutatorPath : mutPaths) {
												Resource mutantvs = ModelManager.loadModel(packages, mutatorPath);
												object = ModelManager.getObject(mutantvs, emutated);
												if (object != null) {
													mutVersion = mutatorPath;
													break;
												}
											}
											if (object != null) {
												emuts.add(object);
											}
										}
									}
								}
							}
							if (mut instanceof InformationChanged) {
								EObject emutated = ((InformationChanged) mut).getObject();
								if (ModelManager.getObject(model, emutated) == null) {
									if ((mutPaths != null) && (packages != null)) {
										EObject object = null;
										for (String mutatorPath : mutPaths) {
											Resource mutantvs = ModelManager.loadModel(packages, mutatorPath);
											object = ModelManager.getObject(mutantvs, emutated);
											if (object != null) {
												mutVersion = mutatorPath;
												break;
											}
										}
										if (object != null) {
											((InformationChanged) mut).setObject(object);
										}
									}
								}
							}
							if (mut instanceof ObjectRetyped) {
								List<EObject> emuts = ((ObjectRetyped) mut).getObject();
								if (emuts.size() > 0) {
									EObject emutated = null;
									if (emuts.get(0).eIsProxy()) {
										emutated = EcoreUtil.resolve(emuts.get(0), seed);
									}
									else {
										emutated = emuts.get(0);
									}
									emuts.remove(0);
									if (ModelManager.getObject(seed, emutated) != null) {
										emuts.add(ModelManager.getObject(seed, emutated));
										mutVersion = mutFilename;
									}
									else {
										if ((mutPaths != null) && (packages != null)) {
											EObject object = null;
											for (String mutatorPath : mutPaths) {
												Resource mutantvs = ModelManager.loadModel(packages, mutatorPath);
												object = ModelManager.getObject(mutantvs, emutated);
												if (object != null) {
													mutVersion = mutatorPath;
													break;
												}
											}
											if (object != null) {
												emuts.add(object);
											}
										}
									}
								}
							}
							if (mutVersion.length() > 0) {
								Resource activeVersion = ModelManager.loadModel(packages, mutVersion);
								createMutantVersionRegistry(packages, pastVersions, activeVersion, mutVersion, mut);
								pastVersions.add(activeVersion);
								lastVersion = activeVersion;
							}
						}
						File registryFolder = null;
						if (fromBlocks.size() == 0) {
							registryFolder = new File(
									hashmapModelFilenames.get(modelFilename) + "/" + block + "/registry");
						} else {
							registryFolder = new File(hashmapModelFilenames.get(modelFilename) + "/" + block + '/' + hashmapModelFolders.get(modelFilename) + "/registry");
						}
						if (registryFolder.exists() != true) {
							registryFolder.mkdir();
						}
						String registryFilename = null;
						if (fromBlocks.size() == 0) {
							registryFilename = hashmapModelFilenames.get(modelFilename)	+ "/" + block + "/registry/" + "Output" + n + "Registry.model";
						} else {
							registryFilename = hashmapModelFilenames.get(modelFilename) + "/" + block + '/'	+ hashmapModelFolders.get(modelFilename) + "/registry/" + "Output" + n + "Registry.model";
						}
						ModelManager.createModel(muts, registryFilename);

						if (reverse == true && save == true) {
							List<EPackage> registryPackages = new ArrayList<EPackage>();
							if (muts.getMuts().size() > 0) {
								registryPackages.add(muts.getMuts().get(0).eClass().getEPackage());
								Resource currentRegistry = ModelManager.loadModel(registryPackages, registryFilename);
								List<EObject> mutations = MutatorUtils.getMutations(ModelManager.getObjects(currentRegistry));
								Resource mutant = ModelManager.loadModel(packages, mutFilename);
								for (EObject mutation : mutations) {
									String text = "";
									List<EClass> superTypes = mutation.eClass().getEAllSuperTypes();
									boolean flag = false;
									for (EClass cl : superTypes) {
										if (cl.getName().equals("AppMutation")) {
											flag = true;
											break;
										}
									}
									if (flag == true) {
										if (mutation instanceof InformationChanged) {
											InformationChanged modify = (InformationChanged) mutation;
											EObject modifiedObject = ModelManager.getObjectByURIEnding(mutant, EcoreUtil.getURI(modify.getObject())); 
											List<AttributeChanged> attChanges = modify.getAttChanges();
											for (AttributeChanged attChange : attChanges) {
												EMFUtils.setAttribute(packages.get(0), modifiedObject, attChange.getAttName(), attChange.getOldVal());
											}
										}
										if (mutation instanceof TargetReferenceChanged) {
											TargetReferenceChanged modifyRef = (TargetReferenceChanged) mutation;
											EObject modifiedObject = ModelManager.getObjectByURIEnding(mutant, EcoreUtil.getURI(modifyRef.getObject().get(0)));
											//ModelManager.setReference(modifyRef.getRefName(), modifiedObject, modifyRef.getOldTo());
											EMFUtils.setReference(packages.get(0), modifiedObject, modifyRef.getRefName(), ModelManager.getObject(mutant, modifyRef.getOldTo()));
										}
									}
									String reverseFilename = mutFilename.replace(".model", "/" + block + "/Reverse.model");
									ModelManager.saveOutModel(mutant, reverseFilename);
								}
								
								for (String fromBlock : fromBlocks) {
									String previousRegistryFilename = modelFilename.replaceAll("\\\\", "/");
									previousRegistryFilename = previousRegistryFilename.substring(0, previousRegistryFilename.lastIndexOf("/")) + "/registry/" + previousRegistryFilename.substring(previousRegistryFilename.lastIndexOf("/") + "/".length(), previousRegistryFilename.length());
									previousRegistryFilename = previousRegistryFilename.replace(".model", "Registry.model");
									Resource previousRegistry = ModelManager.loadModel(registryPackages, previousRegistryFilename);
									mutations = MutatorUtils.getMutations(ModelManager.getObjects(previousRegistry));
									mutant = ModelManager.loadModel(packages, mutFilename);
									for (EObject mutation : mutations) {
										String text = "";
										List<EClass> superTypes = mutation.eClass().getEAllSuperTypes();
										boolean flag = false;
										for (EClass cl : superTypes) {
											if (cl.getName().equals("AppMutation")) {
												flag = true;
												break;
											}
										}
										if (flag == true) {
											if (mutation instanceof InformationChanged) {
												InformationChanged modify = (InformationChanged) mutation;
												EObject modifiedObject = ModelManager.getObjectByURIEnding(mutant, EcoreUtil.getURI(modify.getObject())); 
												List<AttributeChanged> attChanges = modify.getAttChanges();
												for (AttributeChanged attChange : attChanges) {
													EMFUtils.setAttribute(packages.get(0), modifiedObject, attChange.getAttName(), attChange.getOldVal());
												}
											}
											if (mutation instanceof TargetReferenceChanged) {
												TargetReferenceChanged modifyRef = (TargetReferenceChanged) mutation;
												EObject modifiedObject = ModelManager.getObjectByURIEnding(mutant, EcoreUtil.getURI(modifyRef.getObject().get(0)));
												//ModelManager.setReference(modifyRef.getRefName(), modifiedObject, modifyRef.getOldTo());
												EMFUtils.setReference(packages.get(0), modifiedObject, modifyRef.getRefName(), ModelManager.getObject(mutant, modifyRef.getOldTo()));
											}
										}
										String reverseFilename = mutFilename.replace(".model", "/" + fromBlock + "/Reverse.model");
										ModelManager.saveOutModel(mutant, reverseFilename);
									}
									Bundle bundle = Platform.getBundle("wodel.models");
									URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
									String ecore = FileLocator.resolve(fileURL).getFile();
									List<EPackage> ecorePackages = ModelManager.loadMetaModel(ecore);
									String xmiFileName = "file:/" + ModelManager.getOutputPath(cls) + "/" + ModelManager.getMutatorName(cls).replace(".mutator", ".model");
									Resource program = ModelManager.loadModel(ecorePackages, URI.createURI(xmiFileName).toFileString());
									List<EObject> blocks = ModelManager.getObjectsOfType("Block", program);
									for (String prevBlock : fromBlocks) {
										EObject previousBlock = null;
										for (EObject b : blocks) {
											if (ModelManager.getStringAttribute("name", b).equals(prevBlock)) {
												previousBlock = b;
												break;
											}
										}
										String iterateModelFilename = modelFilename;
										String iterateFromBlock = fromBlock;
										while (previousBlock != null) {
											List<EObject> from = ModelManager.getReferences("from", previousBlock);
											if (from.size() == 0) {
												break;
											}
											for (EObject f : from) {
												String fName = ModelManager.getStringAttribute("name", f);
												String previousModelFilename = iterateModelFilename.replaceAll("\\\\", "/");
												previousModelFilename = previousModelFilename.substring(0, previousModelFilename.lastIndexOf("/"));
												previousModelFilename = previousModelFilename.replace("/" + iterateFromBlock + "/", "/");
												previousModelFilename = previousModelFilename + ".model";
												if (previousModelFilename.contains("/" + fName + "/")) {
													previousRegistryFilename = previousModelFilename.substring(0, previousModelFilename.lastIndexOf("/")) + "/registry/" + previousModelFilename.substring(previousModelFilename.lastIndexOf("/") + "/".length(), previousModelFilename.length());
													previousRegistryFilename = previousRegistryFilename.replace(".model", "Registry.model");
													previousRegistry = ModelManager.loadModel(registryPackages, previousRegistryFilename);
													mutations = MutatorUtils.getMutations(ModelManager.getObjects(previousRegistry));
													mutant = ModelManager.loadModel(packages, mutFilename);
													for (EObject mutation : mutations) {
														String text = "";
														List<EClass> superTypes = mutation.eClass().getEAllSuperTypes();
														boolean flag = false;
														for (EClass cl : superTypes) {
															if (cl.getName().equals("AppMutation")) {
																flag = true;
																break;
															}
														}
														if (flag == true) {
															if (mutation instanceof InformationChanged) {
																InformationChanged modify = (InformationChanged) mutation;
																EObject modifiedObject = ModelManager.getObjectByURIEnding(mutant, EcoreUtil.getURI(modify.getObject())); 
																List<AttributeChanged> attChanges = modify.getAttChanges();
																for (AttributeChanged attChange : attChanges) {
																	EMFUtils.setAttribute(packages.get(0), modifiedObject, attChange.getAttName(), attChange.getOldVal());
																}
															}
															if (mutation instanceof TargetReferenceChanged) {
																TargetReferenceChanged modifyRef = (TargetReferenceChanged) mutation;
																EObject modifiedObject = ModelManager.getObjectByURIEnding(mutant, EcoreUtil.getURI(modifyRef.getObject().get(0)));
																//ModelManager.setReference(modifyRef.getRefName(), modifiedObject, modifyRef.getOldTo());
																EMFUtils.setReference(packages.get(0), modifiedObject, modifyRef.getRefName(), ModelManager.getObject(mutant, modifyRef.getOldTo()));
															}
														}
														String reverseFilename = mutFilename.replace(".model", "/" + fName + "/Reverse.model");
														ModelManager.saveOutModel(mutant, reverseFilename);
													}
													for (EObject b : blocks) {
														if (ModelManager.getStringAttribute("name", b).equals(fName)) {
															previousBlock = b;
															break;
														}
													}
													iterateModelFilename = previousModelFilename;
													iterateFromBlock = fName;
												}
											}
										}
									}
								}
							}
						}
					}
				}
				else {
					// CODE TO DELETE STORED MUTANT VERSIONS
				}
			}
		}
		return isRepeated;
	}
	
	/**
	 * Finds the object for the registry
	 * @param seed
	 * @param object
	 * @param objectByID
	 * @param objectByURI
	 * @param mutPaths
	 * @param packages
	 * @return
	 */
	public static EObject findEObjectForRegistry(Resource seed, EObject object, EObject objectByID, EObject objectByURI, List<String> mutPaths, List<EPackage> packages) {
		if (ModelManager.getObject(seed, object) != null) {
			return ModelManager.getObject(seed, object);
		}
		else {
			if (ModelManager.getObject(seed, objectByID) != null) {
				EObject o = ModelManager.getObject(seed, objectByID);
				if (o.eIsProxy()) {
					return EcoreUtil.resolve(o, seed);
				}
				else {
					return o;
				}
			}
			else {
				if (ModelManager.getObject(seed, objectByURI) != null) {
					EObject o = ModelManager.getObject(seed, objectByURI);
					if (o.eIsProxy()) {
						return EcoreUtil.resolve(o, seed);
					}
					else {
						return o;
					}
				}
				else {
					if ((mutPaths != null) && (packages != null)) {
						try {
							Resource mutant = null;
							EObject obj = null;
							for (String mutatorPath : mutPaths) {
								mutant = ModelManager.loadModel(packages, mutatorPath);
								obj = ModelManager.getObject(mutant, object);
								if (obj != null) {
									break;
								}
								else {
									EObject o = ModelManager.getObject(mutant, objectByID);
									if (o != null) {
										if (o.eIsProxy()) {
											obj = EcoreUtil.resolve(o, mutant);
										}
										else {
											obj = o;
										}
									}
								}
								//Reload input
								try {
									mutant.unload();
									mutant.load(null); 
								} catch (Exception e) {}
							}
							if (obj != null) {
								return obj;
							}
							else {
								for (String mutatorPath : mutPaths) {
									mutant = ModelManager.loadModel(packages, mutatorPath);
									IComparisonScope scope = new DefaultComparisonScope(seed, mutant, null);
									Comparison comparison = EMFCompare.builder().build().compare(scope);
									List<Diff> differences = comparison.getDifferences();
									for (Diff diff : differences) {
										if (diff instanceof ReferenceChange) {
											obj = ((ReferenceChange) diff).getValue();
											if (obj.eClass().getName().equals(object.eClass().getName())) {
												return obj;
											}
										}
									}
									//Reload input
									try {
										mutant.unload();
										mutant.load(null); 
									} catch (Exception e) {}
								}
							}
						} catch (ModelNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Finds the objects for the registry
	 * @param seed
	 * @param mut
	 * @param mutPaths
	 * @param packages
	 * @return
	 */
	public static List<EObject> findEObjectsForRegistry(Resource seed, commands.Mutator mut, List<String> mutPaths, List<EPackage> packages) {
		List<EObject> objects = new ArrayList<EObject>();
		List<EObject> direct = mut.getObjects();
		List<EObject> referenced = mut.getObjectsByIdentification();
		int i = 0;
		for (EObject obj : mut.getObjects()) {
			if (ModelManager.getObject(seed, obj) != null) {
				objects.add(ModelManager.getObject(seed, obj));
			}
			else if (referenced != null && referenced.size() > i) {
				EObject oo = ModelManager.getObject(seed, referenced.get(i));
				if (oo != null) {
					if (oo.eIsProxy()) {
						objects.add(EcoreUtil.resolve(oo, seed));
					}
					else {
						objects.add(oo);
					}
				}
				else {
					if ((mutPaths != null) && (packages != null)) {
						try {
							Resource mutant = null;
							EObject object = null;
							for (String mutatorPath : mutPaths) {
								mutant = ModelManager.loadModel(packages, mutatorPath);
								object = ModelManager.getObject(mutant, obj);
								if (object != null) {
									break;
								}
								else {
									List<EObject> lo = mut.getObjectsByIdentification();
									for (EObject ob : lo) {
										EObject o = ModelManager.getObject(mutant, ob);
										if (o != null) {
											if (o.eIsProxy()) {
												object = EcoreUtil.resolve(o, mutant);
											}
											else {
												object = o;
											}
										}
									}
								}
								//Reload input
								try {
									mutant.unload();
									mutant.load(null); 
								} catch (Exception e) {}
							}
							if (object != null) {
								objects.add(object);
							}
						} catch (ModelNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			i++;
		}
		return objects;
	}
	
	/**
	 * Counts the number of commands inside the composite mutator.
	 */
	public static int mutatorSize(CompositeMutator cmut) {
		int count = 0;
		for (Mutator c : cmut.getCommands()) {
			if (c instanceof CompositeMutator) {
				count += mutatorSize((CompositeMutator) c);
			} else {
				count++;
			}
		}
		return count;
	}

	/**
	 * Counts the number of composite mutators inside the composite mutator.
	 */
	public static int compositeMutatorSize(CompositeMutator cmut) {
		int count = 1;
		for (Mutator c : cmut.getCommands()) {
			if (c instanceof CompositeMutator) {
				count += compositeMutatorSize((CompositeMutator) c);
			}
		}
		return count;
	}

	/**
	 * Counts the number of commands inside the Wodel program.
	 */
	public static int mutatorEnvironmentSize(MutatorEnvironment env) {
		int count = 0;
		for (Mutator c : env.getCommands()) {
			if (c instanceof CompositeMutator) {
				count++;
				count += compositeMutatorSize((CompositeMutator) c);
			}
		}
		return count;
	}
	
	/**
	 * Gets mutation objects from the registry
	 */
	public static List<EObject> getMutations(List<EObject> objects) {
		List<EObject> mutations = new ArrayList<EObject>();
		for (EObject obj : objects) {
			String name = obj.eClass().getName();
			for (String registryMutationType : registryMutationTypes) {
				if (name.equals(registryMutationType)) {
					mutations.add(obj);
					break;
				}
			}
		}
		
		return mutations;
	}
	
	/**
	 * Gets mutator commands by block
	 */
	public static Map<String, List<EObject>> getBlockCommands(Resource program) {
		Map<String, List<EObject>> commands = new LinkedHashMap<String, List<EObject>>();
		try {
			EObject root = ModelManager.getRoot(program);
			List<EObject> blocks = ModelManager.getReferences("blocks", root);
			if (blocks != null) {
				if (blocks.size() > 0) {
					for (EObject block : blocks) {
						String name = null;
						List<EObject> listEObjects = null;
						for (EAttribute att : block.eClass().getEAllAttributes()) {
							if (att.getName().equals("name")) {
								name = (String) block.eGet(att);
								break;
							}
						}
						if (commands.containsKey(name) == true) {
							listEObjects = commands.get(name);
						}
						else {
							listEObjects = new ArrayList<EObject>();
						}
						List<EObject> coms = ModelManager.getReferences("commands", block);
						if (coms != null) {
							if (coms.size() > 0) {
								for (EObject com : coms) {
									listEObjects.add(com);
								}
							}
						}
						commands.put(name, listEObjects);
					}
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commands;
	}
	
	/**
	 * Gets mutator commands
	 */
	public static List<EObject> getCommands(Resource program) {
		List<EObject> commands = new ArrayList<EObject>();
		try {
			EObject root = ModelManager.getRoot(program);
			List<EObject> coms = ModelManager.getReferences("commands", root);
			if (coms != null) {
				if (coms.size() > 0) {
					for (EObject com : coms) {
						commands.add(com);
					}
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commands;
	}
	
	/**
	 * Gets the corresponding seed model for the given mutant
	 */
	public static File getSeedModel(File seed, File mutant, String output) {
		File ret = null;
		String outputPath = output.endsWith("/") ? output.replace("/", File.separator) + seed.getName().replace(".model", "") : output.replace("/", File.separator) + File.separator + seed.getName().replace(".model", "");
		String mutantPath = mutant.getPath();
		String mutantFolder = mutantPath.substring(0, mutantPath.lastIndexOf(File.separator));
		int sub1 = outputPath.length() + 1;
		int sub2 = mutantFolder.length();
		if (sub1 < sub2) {
			String mutantHierarchy = mutantFolder.substring(sub1, sub2);
			if (mutantHierarchy.indexOf(File.separator) != -1) {
				String[] levels = mutantHierarchy.split(Pattern.quote(File.separator));
				if (levels.length == 1) {
					ret = seed;
				}
				else {
					String folders = "";
					for (int i = 1; i < levels.length - 1; i++) {
						folders += levels[i] + File.separator;
					}
					ret = new File(outputPath + File.separator + folders + File.separator + levels[levels.length - 1] + ".model");
				}
			}
			else {
				ret = seed;
			}
		}
		else {
			ret = seed;
		}
		return ret;
	}
	
	/**
	 * Gets the given type configure option - DSL mutaText
	 */
	public static Option getConfigureOption(String type, Resource model) {
		Iterator<EObject> objects = model.getAllContents();

		Option opt = null;
		while (objects.hasNext()) {
			EObject object = objects.next();
			if (object instanceof Option) {
				Option op = (Option) object;
				if (op.getType().getName().equals(type)) {
					opt = op;
					break;
				}
			}
		}
		if (opt == null) {
			opt = mutatext.MutatextFactory.eINSTANCE.createOption();
			if (type.equals("TargetReferenceChanged")) {
				Word w = mutatext.MutatextFactory.eINSTANCE.createConstant();
				ModelManager.setStringAttribute("value", w, "Change");
				opt.getValid().getWords().add(w);
				Variable v = mutatext.MutatextFactory.eINSTANCE.createVariable();
				//v.
				//v.setType(value);
				
				//COMPLETE

				opt.getInvalid().getWords().add(w);
				
			}
		}
		
		return opt;
	}

	/**
	 * Gets the corresponding element of the given object - DSL modelText
	 */
	public static Element getElement(EObject object, Resource model) {
		Iterator<EObject> objects = model.getAllContents();

		if (object != null) {
			objects = model.getAllContents();
			while (objects.hasNext()) {
				EObject obj = objects.next();
				if (obj instanceof Element) {
					Element element = (Element) obj;
					if (EcoreUtil.equals(element.getType(), object.eClass())) {
						if (element.getAtt() == null || element.getAtt().size() == 0) {
							return element;
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Gets the corresponding element of the given object - DSL modelText
	 */
	public static Element getElementValues(EObject object, Resource model, boolean order) {
		Iterator<EObject> objects = model.getAllContents();
		
		if (object != null) {
			objects = model.getAllContents();
			while (objects.hasNext()) {
				EObject obj = objects.next();
				if (obj instanceof Element) {
					Element element = (Element) obj;
					if (EcoreUtil.equals(element.getType(), object.eClass())) {
						if (element.getAtt() == null || element.getAtt().size() == 0) {
							continue;
						}
						Map<Attribute, EAttribute> atts = new HashMap<Attribute, EAttribute>();
						for (Attribute att : element.getAtt()) {
							EAttribute eAttribute = att.getAtt();
							for (EAttribute eAtt : object.eClass().getEAllAttributes()) {
								if (EcoreUtil.equals(eAttribute, eAtt)) {
									atts.put(att, eAtt);
								}
							}
						}
						boolean found = true;
						for (Attribute att : atts.keySet()) {
							Object value = object.eGet(atts.get(att));
							if (order == true) {
								if (att.isNegation() && (boolean) value == true) {
									found = false;
									break;
								}
								else if (!att.isNegation() && (boolean) value == false) {
									found = false;
									break;
								}
							}
							else {
								if (!att.isNegation() && (boolean) value == true) {
									found = false;
									break;
								}
								else if (att.isNegation() && (boolean) value == false) {
									found = false;
									break;
								}
							}
						}
						if (found == true) {
							return element;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Gets the corresponding element of the given object - DSL modelText
	 */
	public static List<Element> getAllElementValues(EObject object, Resource model) {
		Iterator<EObject> objects = model.getAllContents();
		
		List<Element> elements = new ArrayList<Element>();
		if (object != null) {
			objects = model.getAllContents();
			while (objects.hasNext()) {
				EObject obj = objects.next();
				if (obj instanceof Element) {
					Element element = (Element) obj;
					if (EcoreUtil.equals(element.getType(), object.eClass())) {
						if (element.getAtt() == null || element.getAtt().size() == 0) {
							continue;
						}
						elements.add(element);
					}
				}
			}
		}
		return elements;
	}

	/**
	 * Gets the corresponding reference element for the give feature
	 * DSL modelText
	 */
	public static Element getRefElement(EObject object, EStructuralFeature feature, Resource model) {
		Iterator<EObject> objects = model.getAllContents();

		objects = model.getAllContents();
		while (objects.hasNext()) {
			EObject obj = objects.next();
			if (obj instanceof Element) {
				Element element = (Element) obj;
				if (EcoreUtil.equals(element.getType(), object.eClass())) {
					if (element.getAtt() == null || element.getAtt().size() == 0) {
						if (feature != null) {
							if (element.getRef() != null) {
								if (EcoreUtil.equals(element.getRef().getEReferenceType(), feature.getEType())) {
									return element;
								}
							}
						}
						else {
							return element;
						}
					}
				}
			}
		}
		return null;
	}
	
	private static Expression transformExpression(List<EPackage> packages, Resource model, EObject mutatorExpression, Map<String, EObject> hmObjects) {
		Expression expression = new Expression();
		
		try {
			EObject first = ModelManager.getReference("first", mutatorExpression);
			if (first.eClass().getName().equals("AttributeEvaluation")) {
				EObject value = ModelManager.getReference("value", first);
				if (value.eClass().equals("ObjectAttributeType")) {
					expression.first = new AttributeEvaluation();
					EObject name = ModelManager.getReference("name", first);
					expression.first.operator = String.valueOf(ModelManager.getAttribute("operator", value));
					((AttributeEvaluation) expression.first).values = new ArrayList<String>();
				}
				else {
					expression.first = new AttributeEvaluation();
					EObject name = ModelManager.getReference("name", first);
					expression.first.name = (String) ModelManager.getStringAttribute("name", name);
					expression.first.operator = String.valueOf(ModelManager.getAttribute("operator", value));
					((AttributeEvaluation) expression.first).values = new ArrayList<String>();
					((AttributeEvaluation) expression.first).values.add(String.valueOf(value));
					if (value.eClass().getName().equals("StringType")) {
						((AttributeEvaluation) expression.first).type = "String";
					}
					if (value.eClass().getName().equals("DoubleType")) {
						((AttributeEvaluation) expression.first).type = "double";
					}
					if (value.eClass().getName().equals("BooleanType")) {
						((AttributeEvaluation) expression.first).type = "Boolean";
					}
					if (value.eClass().getName().equals("IntegerType")) {
						((AttributeEvaluation) expression.first).type = "int";
					}
					if (value.eClass().getName().equals("MinValueType")) {
						EAttribute att = (EAttribute) ModelManager.getAttribute("attribute", value);
						MinValueConfigurationStrategy min = new MinValueConfigurationStrategy(packages, model, MutatorUtils.getMinTypeName(value), att.getName());
						if (att.getEType().getName().equals("EInt")) {
							((AttributeEvaluation) expression.first).type = "int";
						}
						if (att.getEType().getName().equals("EDouble")) {
							((AttributeEvaluation) expression.first).type = "double";
						}
					}
					if (value.eClass().getName().equals("MaxValueType")) {
						EAttribute att = (EAttribute) ModelManager.getAttribute("attribute", value);
						MaxValueConfigurationStrategy min = new MaxValueConfigurationStrategy(packages, model, MutatorUtils.getMaxTypeName(value), att.getName());
						((AttributeEvaluation) expression.first).values.add(min.getValue().toString());
						if (att.getEType().getName().equals("EInt")) {
							((AttributeEvaluation) expression.first).type = "int";
						}
						if (att.getEType().getName().equals("EDouble")) {
							((AttributeEvaluation) expression.first).type = "double";
						}
					}
					if (value.eClass().getName().equals("ListStringType")) {
						List<String> list = (List<String>) ModelManager.getListStringAttribute("value", value);
						for (String item : list) {
							((AttributeEvaluation) expression.first).values.add(item);
						}
						((AttributeEvaluation) expression.first).type = "String";
					}
					if (value.eClass().getName().equals("ListType")) {
						List<EObject> list = (List<EObject>) ModelManager.getReferences("value", value);
						for (EObject item : list) {
							((AttributeEvaluation) expression.first).values.add(String.valueOf(item));
						}
						((AttributeEvaluation) expression.first).type = "String";
					}
				}
			}
			if (first.eClass().getName().equals("ReferenceEvaluation")) {
				expression.first = new ReferenceEvaluation();
				EObject name = ModelManager.getReference("name", first);
				if (name != null) {
					expression.first.name = ModelManager.getStringAttribute("name", name);
				}
				else {
					expression.first.name = null;
				}
				EObject refName = ModelManager.getReference("refName", first);
				if (refName != null) {
					((ReferenceEvaluation) expression.first).refName = ModelManager.getStringAttribute("name", refName);
					EObject refRefName = ModelManager.getReference("refRefName", first);
					if (refRefName != null) {
						((ReferenceEvaluation) expression.first).refRefName = ModelManager.getStringAttribute("name", refRefName);
					}
				}
				else {
					((ReferenceEvaluation) expression.first).refName = null;
				}
				EObject value = ModelManager.getReference("value", first);
				expression.first.operator = String.valueOf(ModelManager.getAttribute("operator", value));
				if (value == null) {
					((ReferenceEvaluation) expression.first).value = null;
				}
				else if (value.eClass().getName().equals("SpecificObjectSelection")) {
					EObject refType = ModelManager.getReference("refType", first);
					EObject valueRefType = ModelManager.getReference("refType", value);
					EObject objSel = ModelManager.getReference("objSel", value);
					String objSelName = ModelManager.getStringAttribute("name", objSel);
					if (refType == null && valueRefType == null) {
						((ReferenceEvaluation) expression.first).value = new commands.selection.strategies.SpecificObjectSelection(packages, model, hmObjects.get(objSelName)).getObject();
					}
					else {
						if (refType != null) {
							EObject srcObjExp = hmObjects.get(objSelName);
							String refTypeName = ModelManager.getStringAttribute("name", refType);
					   		for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
					   			if (ref.getName().equals(refTypeName)) {
					   				((ReferenceEvaluation) expression.first).value = srcObjExp.eGet(ref);
					   			}
					   		}
						}
						if (valueRefType != null) {
							EObject srcObjExp = hmObjects.get(objSelName);
							String valueRefTypeName = ModelManager.getStringAttribute("name", valueRefType);
					   		for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
					   			if (ref.getName().equals(valueRefTypeName)) {
					   				((ReferenceEvaluation) expression.first).value = srcObjExp.eGet(ref);
					   			}
					   		}
						}
					}
				}
			}
			expression.operator = new ArrayList<Operator>();
			List<EObject> operators = ModelManager.getReferences("operator", mutatorExpression);
			for (EObject op : operators) {
				Operator operator = new Operator();
				Object literal = ModelManager.getEEnumAttribute("type", op);
				if (literal instanceof EEnumLiteral) {
					operator.type = ((EEnumLiteral) literal).getLiteral();
				}
				else if (literal instanceof LogicOperator) {
					operator.type = ((LogicOperator) literal).getLiteral();
				}
				expression.operator.add(operator);
			}
			expression.second = new ArrayList<Evaluation>();
			List<EObject> secondEvaluations = ModelManager.getReferences("second", mutatorExpression);
			for (EObject mutatorEv : secondEvaluations) {
				Evaluation second = null;
				if (mutatorEv.eClass().getName().equals("AttributeEvaluation")) {
					EObject value = ModelManager.getReference("value", mutatorEv);
					if (value.eClass().getName().equals("ObjectAttributeType")) {
						second = new AttributeEvaluation();
						EObject name = ModelManager.getReference("name", mutatorEv);
						second.name = (String) ModelManager.getStringAttribute("name", name);
						second.operator = String.valueOf(ModelManager.getAttribute("operator", value));
						((AttributeEvaluation) second).values = new ArrayList<String>();
					}
					else {
						second = new AttributeEvaluation();
						EObject name = ModelManager.getReference("name", mutatorEv);
						second.name = (String) ModelManager.getStringAttribute("name", name);
						second.operator = String.valueOf(ModelManager.getAttribute("operator", value));
						((AttributeEvaluation) second).values = new ArrayList<String>();
						((AttributeEvaluation) second).values.add(String.valueOf(value));
						if (value.eClass().getName().equals("StringType")) {
							((AttributeEvaluation) second).type = "String";
						}
						if (value.eClass().getName().equals("DoubleType")) {
							((AttributeEvaluation) second).type = "double";
						}
						if (value.eClass().getName().equals("BooleanType")) {
							((AttributeEvaluation) second).type = "Boolean";
						}
						if (value.eClass().getName().equals("IntegerType")) {
							((AttributeEvaluation) second).type = "int";
						}
						if (value.eClass().getName().equals("MinValueType")) {
							EAttribute att = (EAttribute) ModelManager.getAttribute("attribute", value);
							MinValueConfigurationStrategy min = new MinValueConfigurationStrategy(packages, model, MutatorUtils.getMinTypeName(value), att.getName());
							if (att.getEType().getName().equals("EInt")) {
								((AttributeEvaluation) second).type = "int";
							}
							if (att.getEType().getName().equals("EDouble")) {
								((AttributeEvaluation) second).type = "double";
							}
						}
						if (value.eClass().getName().equals("MaxValueType")) {
							EAttribute att = (EAttribute) ModelManager.getAttribute("attribute", value);
							MaxValueConfigurationStrategy min = new MaxValueConfigurationStrategy(packages, model, MutatorUtils.getMaxTypeName(value), att.getName());
							((AttributeEvaluation) second).values.add(min.getValue().toString());
							if (att.getEType().getName().equals("EInt")) {
								((AttributeEvaluation) second).type = "int";
							}
							if (att.getEType().getName().equals("EDouble")) {
								((AttributeEvaluation) second).type = "double";
							}
						}
						if (value.eClass().getName().equals("ListStringType")) {
							List<String> list = (List<String>) ModelManager.getListStringAttribute("value", value);
							for (String item : list) {
								((AttributeEvaluation) second).values.add(item);
							}
							((AttributeEvaluation) second).type = "String";
						}
						if (value.eClass().getName().equals("ListType")) {
							List<EObject> list = (List<EObject>) ModelManager.getReferences("value", value);
							for (EObject item : list) {
								((AttributeEvaluation) second).values.add(String.valueOf(item));
							}
							((AttributeEvaluation) second).type = "String";
						}
					}
				}
				if (mutatorEv.eClass().getName().equals("ReferenceEvaluation")) {
					second = new ReferenceEvaluation();
					EObject name = ModelManager.getReference("name", mutatorEv);
					if (name != null) {
						second.name = ModelManager.getStringAttribute("name", name);
					}
					else {
						second.name = null;
					}
					EObject refName = ModelManager.getReference("refName", mutatorEv);
					if (refName != null) {
						((ReferenceEvaluation) second).refName = ModelManager.getStringAttribute("name", refName);
						EObject refRefName = ModelManager.getReference("refRefName", mutatorEv);
						if (refRefName != null) {
							((ReferenceEvaluation) second).refRefName = ModelManager.getStringAttribute("name", refRefName);
						}
					}
					else {
						((ReferenceEvaluation) second).refName = null;
					}
					Object literal = ModelManager.getEEnumAttribute("operator", mutatorEv);
					if (literal instanceof EEnumLiteral) {
						second.operator = ((EEnumLiteral) literal).getLiteral();
					}
					else if (literal instanceof mutatorenvironment.Operator) {
						second.operator = ((mutatorenvironment.Operator) literal).getLiteral();
					}
					EObject value = ModelManager.getReference("value", mutatorEv);
					if (value == null) {
						((ReferenceEvaluation) second).value = null;
					}
					else if (value.eClass().getName().equals("SpecificObjectSelection")) {
						EObject refType = ModelManager.getReference("refType", mutatorEv);
						EObject valueRefType = ModelManager.getReference("refType", value);
						EObject objSel = ModelManager.getReference("objSel", value);
						String objSelName = ModelManager.getStringAttribute("name", objSel);
						if (refType == null && valueRefType == null) {
							((ReferenceEvaluation) second).value = new commands.selection.strategies.SpecificObjectSelection(packages, model, hmObjects.get(objSelName)).getObject();
						}
						else {
							if (refType != null) {
								EObject srcObjExp = hmObjects.get(objSelName);
								String refTypeName = ModelManager.getStringAttribute("name", refType);
						   		for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
						   			if (ref.getName().equals(refTypeName)) {
						   				((ReferenceEvaluation) second).value = srcObjExp.eGet(ref);
						   			}
						   		}
							}
							if (valueRefType != null) {
								EObject srcObjExp = hmObjects.get(objSelName);
								String valueRefTypeName = ModelManager.getStringAttribute("name", valueRefType);
						   		for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
						   			if (ref.getName().equals(valueRefTypeName)) {
						   				((ReferenceEvaluation) second).value = srcObjExp.eGet(ref);
						   			}
						   		}
							}
						}
					}
				}
				expression.second.add(second);
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return expression;
	}
	
	private static int getNumMutantsByStrategy(List<EPackage> packages, EObject strategy, Resource model, Map<String, EObject> hmObjects) {
		int numMutants = 0;
		
		try {
			if (strategy.eClass().getName().equals("RandomTypeSelection")) {
				EObject type = ModelManager.getReference("type", strategy);
				RandomTypeSelection selection = new RandomTypeSelection(packages, model, ((EClass) type).getName());
				List<EObject> objects = selection.getObjects();
				EObject mutatorExpression = ModelManager.getReference("expression", strategy);
				Expression expression = transformExpression(packages, model, mutatorExpression, hmObjects);

				objects = evaluate(objects, expression);
				numMutants += objects.size();
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numMutants;
	}
	
	private static int getNumMutants(List<EPackage> packages, EObject mutator, Resource model, Map<String, EObject> hmObjects) {
		int numMutants = 0;
		
		try {
			if (mutator.eClass().getName().equals("ModifyInformationMutator")) {
				EObject strategy = ModelManager.getReference("object", mutator);
				numMutants += getNumMutantsByStrategy(packages, strategy, model, hmObjects);
			}
			if (mutator.eClass().getName().equals("RemoveObjectMutator")) {
				EObject strategy = ModelManager.getReference("object", mutator);
				numMutants += getNumMutantsByStrategy(packages, strategy, model, hmObjects);
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numMutants;
	}
	
	private static int getNumMutants(List<EPackage> packages, EObject mutator, Set<String> modelFilenames, Map<String, EObject> hmObjects) {
		int numMutants = 0;
		
		try {
			for (String modelFilename : modelFilenames) {
				Resource model = ModelManager.loadModel(packages, modelFilename);
				numMutants += getNumMutants(packages, mutator, model, hmObjects);
			}
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numMutants;
	}
	
	private static int getNumMutantsBySeedModel(List<EPackage> packages, EObject mutator, String modelFilename, Map<String, EObject> hmObjects) {
		int numMutants = 0;
		
		try {
			Resource model = ModelManager.loadModel(packages, modelFilename);
			numMutants += getNumMutants(packages, mutator, model, hmObjects);
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numMutants;
	}

	protected static int getNumMutants(List<EPackage> packages, String xmiFileName, Set<String> modelFilenames, Map<String, EObject> hmObjects) {
		int numMutants = 0;
		
   		try {
   			Bundle bundle = Platform.getBundle("wodel.models");
   	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
   			String ecore = FileLocator.resolve(fileURL).getFile();
   			List<EPackage> mutatorecore = ModelManager.loadMetaModel(ecore);
   			Resource model = ModelManager.loadModel(mutatorecore, URI.createURI(xmiFileName).toFileString());
   			List<EObject> objects = ModelManager.getAllObjects(model);
   			Map<String, EObject> mutators = MutatorUtils.getMutators(objects);
   			for (String mutatorName : mutators.keySet()) {
   				EObject mutator = mutators.get(mutatorName);
   				numMutants += getNumMutants(packages, mutator, modelFilenames, hmObjects);
   			}
   			
   		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numMutants;
	}

	protected static int getNumMutantsBySeedModel(List<EPackage> packages, String xmiFileName, String modelFilename, Map<String, EObject> hmObjects) {
		int numMutants = 0;
		
   		try {
   			Bundle bundle = Platform.getBundle("wodel.models");
   	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
   			String ecore = FileLocator.resolve(fileURL).getFile();
   			List<EPackage> mutatorecore = ModelManager.loadMetaModel(ecore);
   			Resource model = ModelManager.loadModel(mutatorecore, URI.createURI(xmiFileName).toFileString());
   			List<EObject> objects = ModelManager.getAllObjects(model);
   			Map<String, EObject> mutators = MutatorUtils.getMutators(objects);
   			for (String mutatorName : mutators.keySet()) {
   				EObject mutator = mutators.get(mutatorName);
   				numMutants += getNumMutantsBySeedModel(packages, mutator, modelFilename, hmObjects);
   			}
   			
   		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numMutants;
	}

	protected static int getNumMutants(List<EPackage> packages, String xmiFileName, String modelFilename, Map<String, EObject> hmObjects) {
		int numMutants = 0;
		
   		try {
   			Bundle bundle = Platform.getBundle("wodel.models");
   	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
   			String ecore = FileLocator.resolve(fileURL).getFile();
   			List<EPackage> mutatorecore = ModelManager.loadMetaModel(ecore);
   			Resource model = ModelManager.loadModel(mutatorecore, URI.createURI(xmiFileName).toFileString());
   			List<EObject> objects = ModelManager.getAllObjects(model);
   			Map<String, EObject> mutators = MutatorUtils.getMutators(objects);
   			for (String mutatorName : mutators.keySet()) {
   				EObject mutator = mutators.get(mutatorName);
   				numMutants += getNumMutantsBySeedModel(packages, mutator, modelFilename, hmObjects);
   			}
   			
   		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numMutants;
	}

	protected static int getNumMutants(List<EPackage> packages, String xmiFileName, String modelFilename, Map<String, EObject> hmObjects, String blockName) {
		int numMutants = 0;
		
   		try {
   			Bundle bundle = Platform.getBundle("wodel.models");
   	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
   			String ecore = FileLocator.resolve(fileURL).getFile();
   			List<EPackage> mutatorecore = ModelManager.loadMetaModel(ecore);
   			Resource model = ModelManager.loadModel(mutatorecore, URI.createURI(xmiFileName).toFileString());
   			List<EObject> objects = ModelManager.getAllObjects(model);
   			Map<String, EObject> mutators = MutatorUtils.getMutatorsByBlock(objects, blockName);
   			for (String mutatorName : mutators.keySet()) {
   				EObject mutator = mutators.get(mutatorName);
   				numMutants += getNumMutantsBySeedModel(packages, mutator, modelFilename, hmObjects);
   			}
   			
   		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numMutants;
	}
	
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, 
			MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
			ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		return null;
	}
}