package manager;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import modeltext.Element;
import mutatext.Option;
import mutatorenvironment.AttributeOperation;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.CompositeMutator;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.MaxValueType;
import mutatorenvironment.MinValueType;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.ObjectEmitter;
import mutatorenvironment.Program;
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SelectSampleMutator;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificObjectSelection;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.common.OCLConstants;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

import commands.selection.strategies.RandomTypeSelection;
import commands.strategies.RandomBooleanConfigurationStrategy;
import commands.strategies.RandomDoubleConfigurationStrategy;
import commands.strategies.RandomIntegerConfigurationStrategy;
import commands.strategies.RandomStringConfigurationStrategy;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;
import appliedMutations.AppMutation;
import appliedMutations.AppliedMutationsFactory;
import appliedMutations.InformationChanged;
import appliedMutations.Mutations;
import appliedMutations.ObjectCloned;
import appliedMutations.ObjectCreated;
import appliedMutations.ObjectRemoved;
import appliedMutations.ObjectRetyped;

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

	protected class Operator {
		public String type;

		public Operator() {

		}
	}

	protected class AttributeEvaluation extends Evaluation {
		public List<String> values;
		public String type;

		public AttributeEvaluation() {

		}
	}

	protected class ReferenceEvaluation extends Evaluation {
		public String refName;
		public Object value;

		public ReferenceEvaluation() {

		}
	}

	protected class Evaluation {
		public String name;
		public String operator;
	}

	protected class Expression {
		public Evaluation first;
		public List<Operator> operator;
		public List<Evaluation> second;

		public Expression() {

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
	private void evaluateFirstAttribute(AttributeEvaluation attev, List<EObject> candidates, Set<EObject> selected) {
		for (EObject candidate : candidates) {
			if (attev.operator.equals("equals")) {
				for (EAttribute att : candidate.eClass().getEAllAttributes()) {
					if (att.getName().equals(attev.name)) {
						if (candidate.eGet(att).toString().equals(attev.values.get(0).toString())) {
							if (!selected.contains(candidate)) {
								selected.add(candidate);
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
				ArrayList<String> tmp_values = new ArrayList<String>();
				tmp_values.addAll(attev.values);
				do {
					int n = ModelManager.getRandomIndex(tmp_values);
					for (EAttribute att : candidate.eClass().getEAllAttributes()) {
						if (att.getName().equals(attev.name)) {
							if (candidate.eGet(att) != null) {
								if (candidate.eGet(att).toString().equals(tmp_values.get(n).toString())) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
						}
					}
					tmp_values.remove(n);
				}
				while (selected.size() == 0 && tmp_values.size() > 0);
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
	private void evaluateFirstReferenceEquals(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected) {
		if (refev.name == null) {
			if (candidate.equals(refev.value)) {
				if (!selected.contains(candidate)) {
					selected.add(candidate);
				}
			}
		} else {
			if (refev.refName == null) {
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
								if (candidate.eGet(ref) instanceof EObject) {
									if (candidate.eGet(ref) == null) {
										if (!selected.contains(candidate)) {
											selected.add(candidate);
										}
									}
								}
							}
						} else {
							if (candidate.eGet(ref) instanceof List<?>) {
								List<EObject> objects = (List<EObject>) candidate.eGet(ref);
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
													List<EObject> objects = (List<EObject>) refev.value;
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
														List<EObject> lobjects = (List<EObject>) refev.value;
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
		}
	}
	
	/**
	 * evaluateFirstReferenceDifferent evaluates the reference expression
	 * when the operator is '<>'
	 * @param refev
	 * @param candidate
	 * @param selected
	 */
	private void evaluateFirstReferenceDifferent(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected) {
		if (refev.name == null) {
			if (!candidate.equals(refev.value)) {
				if (!selected.contains(candidate)) {
					selected.add(candidate);
				}
			}
		} else {
			if (refev.refName == null) {
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
								List<EObject> objects = (List<EObject>) candidate.eGet(ref);
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
													List<EObject> objects = (List<EObject>) refev.value;
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
														List<EObject> lobjects = (List<EObject>) refev.value;
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

	private void evaluateFirstReferenceIn(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected) {
		if (refev.name != null) {
			if (refev.refName == null) {
				for (EReference ref : candidate.eClass().getEAllReferences()) {
					if (ref.getName().equals(refev.name)) {
						if (refev.value != null) {
							if (candidate.eGet(ref) instanceof List<?>) {
								List<EObject> objects = (List<EObject>) candidate.eGet(ref);
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
													List<EObject> objects = (List<EObject>) refev.value;
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
														List<EObject> lobjects = (List<EObject>) refev.value;
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
		}
	}

	/**
	 * evaluateReference evaluates the reference expression
	 * @param refev
	 * @param candidates
	 * @param selected
	 */
	private void evaluateFirstReference(ReferenceEvaluation refev, List<EObject> candidates, Set<EObject> selected) {
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
	private void evaluateSecondAttributeAnd(AttributeEvaluation attev, List<EObject> candidates, Set<EObject> selected, Set<EObject> selected_tmp) {
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
				ArrayList<String> tmp_values = new ArrayList<String>();
				tmp_values.addAll(attev.values);
				do {
					int n = ModelManager.getRandomIndex(tmp_values);
					for (EAttribute att : candidate.eClass().getEAllAttributes()) {
						if (att.getName().equals(attev.name)) {
							// CASO DE QUE SEA STRING
							if (candidate.eGet(att) != null) {
								if (!candidate.eGet(att).equals(tmp_values.get(n).toString())) {
									selected_tmp.remove(candidate);
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
	 * evaluateSecondAttributeOr evaluates the second and
	 * next attribute expressions preceded by an 'or' operator
	 * @param attev
	 * @param candidates
	 * @param selected
	 * @param selected_tmp
	 */
	private void evaluateSecondAttributeOr(AttributeEvaluation attev, List<EObject> candidates, Set<EObject> selected, Set<EObject> selected_tmp) {
		for (EObject candidate : candidates) {
			if (attev.operator.equals("equals")) {
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
				ArrayList<String> tmp_values = new ArrayList<String>();
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
	private void evaluateSecondReferenceAndEquals(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
		if (refev.name == null) {
			if (!candidate.equals(refev.value)) {
				selected_tmp.remove(candidate);
			}
		} else {
			if (refev.refName == null) {
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
								List<EObject> objects = (List<EObject>) candidate.eGet(ref);
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
													List<EObject> objects = (List<EObject>) refev.value;
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
														List<EObject> lobjects = (List<EObject>) refev.value;
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
	 * evaluateSecondReferenceAndDifferent evaluates
	 * the second reference expression and next when
	 * the link is an 'and' with operator '<>'
	 * @param refev
	 * @param candidate
	 * @param selected
	 * @param selected_tmp
	 */
	private void evaluateSecondReferenceAndDifferent(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
		if (refev.name == null) {
			if (candidate.equals(refev.value)) {
				selected_tmp.remove(candidate);
			}
		} else {
			if (refev.refName == null) {
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
								List<EObject> objects = (List<EObject>) candidate.eGet(ref);
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
														List<EObject> objects = (List<EObject>) refev.value;
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
	private void evaluateSecondReferenceAndIn(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
		if (refev.name != null) {
			if (refev.refName == null) {
				for (EReference ref : candidate.eClass().getEAllReferences()) {
					if (ref.getName().equals(refev.name)) {
						if (refev.value != null) {
							if (candidate.eGet(ref) instanceof List<?>) {
								List<EObject> objects = (List<EObject>) candidate.eGet(ref);
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
													List<EObject> objects = (List<EObject>) refev.value;
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
														List<EObject> lobjects = (List<EObject>) refev.value;
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
	 * evaluateSecondReferenceAnd evaluates second reference
	 * expression and next when preceded by an 'and' operator
	 * @param refev
	 * @param candidates
	 * @param selected
	 * @param selected_tmp
	 */
	private void evaluateSecondReferenceAnd(ReferenceEvaluation refev, List<EObject> candidates, Set<EObject> selected, Set<EObject> selected_tmp) {
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
	protected void evaluateSecondReferenceOrEquals(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
		if (refev.name == null) {
			if (candidate.equals(refev.value)) {
				if (!selected_tmp.contains(candidate)) {
					selected_tmp.add(candidate);
				}
			}
		} else {
			if (refev.refName == null) {
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
								List<EObject> objects = (List<EObject>) candidate.eGet(ref);
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
													List<EObject> objects = (List<EObject>) refev.value;
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
														List<EObject> lobjects = (List<EObject>) refev.value;
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
	private void evaluateSecondReferenceOrDifferent(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
		if (refev.name == null) {
			if (!candidate.equals(refev.value)) {
				if (!selected_tmp.contains(candidate)) {
					selected_tmp.add(candidate);
				}
			}
		} else {
			if (refev.refName == null) {
				for (EReference ref : candidate.eClass().getEAllReferences()) {
					if (refev.value == null) {
						if (candidate.eGet(ref) != null) {
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
						}
					} else {
						if (ref.getName().equals(refev.name)) {
							if (candidate.eGet(ref) instanceof List<?>) {
								List<EObject> objects = (List<EObject>) candidate.eGet(ref);
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
													List<EObject> lobjects = (List<EObject>) refev.value;
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
	private void evaluateSecondReferenceOrIn(ReferenceEvaluation refev, EObject candidate, Set<EObject> selected, Set<EObject> selected_tmp) {
		if (refev.name != null) {
			if (refev.refName == null) {
				for (EReference ref : candidate.eClass().getEAllReferences()) {
					if (ref.getName().equals(refev.name)) {
						if (refev.value != null) {
							if (candidate.eGet(ref) instanceof List<?>) {
								List<EObject> objects = (List<EObject>) candidate.eGet(ref);
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
													List<EObject> objects = (List<EObject>) refev.value;
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
														List<EObject> lobjects = (List<EObject>) refev.value;
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
	 * evaluateSecondReferenceOr evaluates second reference
	 * expression and next when preceded by an 'or' operator
	 * @param refev
	 * @param candidates
	 * @param selected
	 * @param selected_tmp
	 */
	private void evaluateSecondReferenceOr(ReferenceEvaluation refev, List<EObject> candidates, Set<EObject> selected, Set<EObject> selected_tmp) {
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
		}
	}
		
	
	/**
	 * evaluate returns the objects that matches the given expression
	 * @param candidates
	 * @param exp
	 * @return
	 */
	protected List<EObject> evaluate(List<EObject> candidates, Expression exp) {
		Set<EObject> selected = new HashSet<EObject>();
		Set<EObject> selected_tmp = null;
		HashMap<EObject, EObject> dictionary = new HashMap<EObject, EObject>();

		List<EObject> ret = new ArrayList<EObject>();
		if (candidates == null) {
			return ret;
		}
		List<EObject> candidates_tmp = new ArrayList<EObject>();
		for (EObject candidate : candidates) {
			EObject candidate_tmp = EcoreUtil.copy(candidate);
			candidates_tmp.add(candidate_tmp);
			dictionary.put(candidate_tmp, candidate);
		}
		if (exp.first instanceof AttributeEvaluation) {
			evaluateFirstAttribute((AttributeEvaluation) exp.first, candidates_tmp, selected);
		}
		if (exp.first instanceof ReferenceEvaluation) {
			evaluateFirstReference((ReferenceEvaluation) exp.first, candidates_tmp, selected);
		}

		selected_tmp = new HashSet<EObject>();
		selected_tmp.addAll(selected);

		if (exp.operator.size() > 0) {
			int i = 0;
			for (Evaluation ev : exp.second) {
				if (ev instanceof AttributeEvaluation) {
					if (exp.operator.get(i).type.equals("and")) {
						evaluateSecondAttributeAnd((AttributeEvaluation) ev, candidates_tmp, selected, selected_tmp);
					}
					if (exp.operator.get(i).type.equals("or")) {
						evaluateSecondAttributeOr((AttributeEvaluation) ev, candidates_tmp, selected, selected_tmp);
					}
				}
				if (ev instanceof ReferenceEvaluation) {
					if (exp.operator.get(i).type.equals("and")) {
						evaluateSecondReferenceAnd((ReferenceEvaluation) ev, candidates_tmp, selected, selected_tmp);
					}
					if (exp.operator.get(i).type.equals("or")) {
						evaluateSecondReferenceOr((ReferenceEvaluation) ev, candidates_tmp, selected, selected_tmp);
					}
				}
				i++;
			}
		}

		for (EObject sel : selected_tmp) {
			ret.add(dictionary.get(sel));
		}
		
		return ret;
	}
	
	/**
	 * Completes the model with mandatory features
	 * @param packages
	 * @param model
	 * @return
	 */
	protected static int complete(List<EPackage> packages, Resource model) {
		// VALIDATE MUTANT
		for (EObject eObject : model.getContents()) {
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				int code = ((BasicDiagnostic) diagnostic.getChildren().get(0)).getCode();
				if (code == 0 || code == 1) {
					// COMPLETES THE CARDINALITIES
					TreeIterator<Object> tree = EcoreUtil.getAllContents(eObject, true);
					ArrayList<EClass> classes = ModelManager.getEClasses(packages);
					ArrayList<Boolean> solved = new ArrayList<Boolean>();
					while (tree.hasNext()) {
						EObject obj = (EObject) tree.next();
						for (EAttribute att : obj.eClass().getEAttributes()) {
							if ((att.getLowerBound() > 0) && (obj.eGet(att) == null)) {
								try {
									if (att.getEType().getInstanceClassName().equals(String.class.getCanonicalName())) {
										ModelManager.setAttribute(att.getName(), obj, new RandomStringConfigurationStrategy(4, 5, false));
									}
									if (att.getEType().getInstanceClassName().equals(boolean.class.getCanonicalName())) {
										ModelManager.setAttribute(att.getName(), obj, new RandomBooleanConfigurationStrategy());
									}
									if (att.getEType().getInstanceClassName().equals(double.class.getCanonicalName())) {
										ModelManager.setAttribute(att.getName(), obj, new RandomDoubleConfigurationStrategy(1, 100, false));
									}
									if (att.getEType().getInstanceClassName().equals(int.class.getCanonicalName())) {
										ModelManager.setAttribute(att.getName(), obj, new RandomIntegerConfigurationStrategy(1, 100, false));
									}
								} catch (WrongAttributeTypeException e) {
									e.printStackTrace();
								}
							}
						}
						for (EReference ref : obj.eClass().getEReferences()) {
							if ((ref.getLowerBound() > 0) && (obj.eGet(ref) == null)) {
								solved.add(true);
								try {
									if (ref.isChangeable()) {
										ModelManager.setReference(ref.getName(), obj, new RandomTypeSelection(packages, model, ref.getEReferenceType().getName()));
										solved.set(solved.size() - 1, true);
									}
								} catch (WrongAttributeTypeException e) {
									solved.set(solved.size() - 1, false);
								} catch (ReferenceNonExistingException e) {
									solved.set(solved.size() - 1, false);
								}
							}
						}
					}
					for (boolean s : solved) {
						if (s == false) {
							return 1;
						}
					}
					return 2;
				}
				// if the diagnostic code is 0 the error is because of an OCL
				// restriction that shall be ignored
				else {
					if (code != 0) {
						return 3;
					}
				}
			}
		}
		return 0;
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
			HashSet<String> hashset_mutants) throws ModelNotFoundException {
		boolean isRepeated = false;
		String extensionName = Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Mutants equivalence extension", "Synctactic Comparison", null);
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
					List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
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
					Method getURI = extensionClass.getDeclaredMethod("getURI");
					if (getName.invoke(comparison).equals(extensionName) ) {
						Method doCompare = extensionClass.getDeclaredMethod("doCompare", new Class[]{String.class, String.class, String.class});
						for (String mutFilename : hashset_mutants) {
							isRepeated = (boolean) doCompare.invoke(comparison, metamodel, model, mutFilename);
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
		return isRepeated;
	}
	
	/**
	 * Checks whether the model matches the OCL rules
	 * @param model
	 * @param rules
	 * @return
	 */
	protected boolean matchesOCL(Resource model,
			HashMap<String, ArrayList<String>> rules) {
		boolean matches = true;
		// for each object in the model
		// for (EObject eObject : model.getContents()) {
		for (EObject eObject : ModelManager.getAllObjects(model)) {

			// get metaclasses of object (metaclass and ancestors)
			HashSet<EClass> metaclasses = new HashSet<EClass>();
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
	protected static HashMap<String, EObject> getMutatorNames(ArrayList<EObject> objects) {
		HashMap<String, EObject> mutators = new HashMap<String, EObject>();
		for (EObject obj : objects) {
			String name = obj.eClass().getName();
			for (String mutatorTypeName : mutatorTypeNames) {
				if (name.equals(mutatorTypeName)) {
					Mutator mut = (Mutator) obj;
					if (mut.getName() != null) {
						mutators.put(mut.getName(), obj);
					}
					break;
				}
			}
			if (obj.eContainer() != null) {
				if (obj.eContainer().eClass().getName()
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

		return mutators;
	}

	/**
	 * Gets Wodel variable names and its corresponding mutation
	 * @param mutators
	 * @return
	 */
	protected static HashMap<String, Mutator> getMutatorNames(List<Mutator> mutators) {
		HashMap<String, Mutator> ret = new HashMap<String, Mutator>();
		int counter = 0;
		for (Mutator mut : mutators) {
			String name = mut.eClass().getName();
			for (String mutatorTypeName : mutatorTypeNames) {
				if (name.equals(mutatorTypeName)) {
					if (mut.getName() != null) {
						ret.put(mut.getName(), mut);
					}
					break;
				}
			}
			if (mut.eContainer() != null) {
				if (mut.eContainer().eClass().getName()
						.equals("MutatorEnvironment")) {
					if (name.equals("CompositeMutator")) {
						if (mut.getName() != null) {
							ret.put(mut.getName(), mut);
						}
					}
				}
			}
		}

		return ret;
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
	protected static HashMap<String, EObject> getMutators(ArrayList<EObject> objects) {
		HashMap<String, EObject> mutators = new HashMap<String, EObject>();
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
	 * Gets the mutator list
	 * @param objects
	 * @return
	 */
	public static List<EObject> getMutatorList(ArrayList<EObject> objects) {
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
		HashMap<String, String> hashmapModelFilenames,
		HashMap<String, String> hashmapModelFolders,
		HashMap<String, String> hashmapSeedModelFilenames,
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
			HashMap<Resource, String> hashmap_postproc)
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
			List<EPackage> packages,
			HashMap<String, Resource> hashmap_postproc,
			HashMap<String, Resource> hashmap_mutpostproc, File file,
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
							Resource mutant = ModelManager.loadModel(packages,	block.getPath()	+ "/" + regfiles[j].getName().replace("Registry", ""));
							hashmap_mutpostproc.put(pathfileblock, mutant);
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
	public static void getRegistryModels(File folder, List<EPackage> packages, HashMap<String, Resource> registryModels) throws ModelNotFoundException {
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
	public static ArrayList<EClass> getClassMutators(List<EPackage> packages) {
		ArrayList<EClass> mutators = new ArrayList<EClass>();
		ArrayList<EObject> objects = ModelManager.getAllObjects(packages);
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
	public static ArrayList<EClass> getCreationClassMutators(List<EPackage> packages) {
		ArrayList<EClass> mutators = new ArrayList<EClass>();
		ArrayList<EObject> objects = ModelManager.getAllObjects(packages);
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
	public static ArrayList<EClass> getModificationClassMutators(List<EPackage> packages) {
		ArrayList<EClass> mutators = new ArrayList<EClass>();
		ArrayList<EObject> objects = ModelManager.getAllObjects(packages);
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
	public static ArrayList<EClass> getModificationReferenceClassMutators(List<EPackage> packages) {
		ArrayList<EClass> mutators = new ArrayList<EClass>();
		ArrayList<EObject> objects = ModelManager.getAllObjects(packages);
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
	public static ArrayList<EClass> getDeletionClassMutators(List<EPackage> packages) {
		ArrayList<EClass> mutators = new ArrayList<EClass>();
		ArrayList<EObject> objects = ModelManager.getAllObjects(packages);
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
	public static ArrayList<EClass> getMutatorStrategies(List<EPackage> packages, String className) {
		ArrayList<EClass> strategies = new ArrayList<EClass>();
		ArrayList<EObject> objects = ModelManager.getAllObjects(packages);
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
	public static ArrayList<EObject> getBlocks(Resource model) {
		return ModelManager.getObjectsOfType("Block", model);
	}

	/**
	 * Gets the block with the given name
	 * @param model
	 * @param blockName
	 * @return
	 */
	public static EObject getBlock(Resource model, String blockName) {
		EObject block = null;
		ArrayList<EObject> blocks = getBlocks(model);
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
		ArrayList<EObject> objects = ModelManager.getAllObjects(model);
		HashMap<String, EObject> mutators = getMutators(objects);
		for (String mutatorClassName : mutators.keySet()) {
			EObject mutator = mutators.get(mutatorClassName);
			if (mutator instanceof CreateObjectMutator) {
				CreateObjectMutator mut = (CreateObjectMutator) mutator;
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
			if (mutator instanceof CloneObjectMutator) {
				CloneObjectMutator mut = (CloneObjectMutator) mutator;
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
			if (mutator instanceof RetypeObjectMutator) {
				RetypeObjectMutator mut = (RetypeObjectMutator) mutator;
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
	 * Gets the mutator type
	 * @param model
	 * @param name
	 * @return
	 */
	public static EClass getMutatorType(Resource model, String name) {
		EClass eClass = null;
		ArrayList<EObject> objects = ModelManager.getAllObjects(model);
		HashMap<String, EObject> mutators = getMutatorNames(objects);
		for (String mutatorClassName : mutators.keySet()) {
			EObject mutator = mutators.get(mutatorClassName);
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
	 * Gets the mutator for the given name
	 * @param model
	 * @param name
	 * @return
	 */
	public static EObject getMutator(Resource model, String name) {
		ArrayList<EObject> objects = ModelManager.getAllObjects(model);
		HashMap<String, EObject> mutators = getMutatorNames(objects);
		return mutators.get(name);
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
       		}
		}
		return eClass;
	}

	/**
	 * Mutant registry generation
	 * (Wodel program with no blocks)
	 * @param metamodel
	 * @param packages
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
	 * @return
	 * @throws ModelNotFoundException
	 */
	public boolean registryMutant(String metamodel, List<EPackage> packages,
			Resource seed, Resource model, HashMap<String, ArrayList<String>> rules,
			Mutations muts, String modelFilename, String mutFilename, 
			boolean registry, HashSet<String> hashsetMutants,
			HashMap<String, String> hashmapModelFilenames,
			int n, List<String> mutPaths, HashMap<String, List<String>> hashmapMutVersions) throws ModelNotFoundException {
		boolean isRepeated = false;
		int valid = complete(packages, model);
		if (valid != 1) {
			if (matchesOCL(model, rules) == true) {
				// VERIFY IF MUTANT IS DIFFERENT
				File outputFolder = new File(hashmapModelFilenames.get(modelFilename));
				if (outputFolder.exists() != true) {
					outputFolder.mkdir();
				}
				ModelManager.saveOutModel(model, mutFilename);
				isRepeated = different(metamodel, mutFilename, hashsetMutants);
				if (isRepeated == true) {
					IOUtils.deleteFile(mutFilename);
				}
				// IF MUTANT IS DIFFERENT STORES IT AND PROCEEDS
				if (isRepeated == false) {
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
	 * @return
	 * @throws ModelNotFoundException
	 */
	public boolean registryMutantWithBlocks(String metamodel, List<EPackage> packages,
			Resource seed, Resource model, HashMap<String, ArrayList<String>> rules,
			Mutations muts, String modelFilename, String mutFilename, 
			boolean registry, HashSet<String> hashsetMutantsBlock,
			HashMap<String, String> hashmapModelFilenames,
			HashMap<String, String> hashmapModelFolders, String block,
			ArrayList<String> fromBlocks, int n, List<String> mutPaths,
			HashMap<String, List<String>> hashmapMutVersions) throws ModelNotFoundException {
		boolean isRepeated = false;
		int valid = complete(packages, model);
		if (valid != 1) {
			if (matchesOCL(model, rules) == true) {
				// VERIFY IF MUTANT IS DIFFERENT
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
				ModelManager.saveOutModel(model, mutFilename);
				isRepeated = different(metamodel, mutFilename, hashsetMutantsBlock);
				if (isRepeated == true) {
					IOUtils.deleteFile(mutFilename);
				}
				
				// IF MUTANT IS DIFFERENT STORES IT AND PROCEEDS
				if (isRepeated == false) {
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
								if (object != null) {
									break;
								}
								else {
									EObject o = ModelManager.getObject(mutant, objectByID);
									if (o != null) {
										if (o.eIsProxy()) {
											object = EcoreUtil.resolve(o, mutant);
										}
										else {
											object = o;
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
								return object;
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
			else {
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
	public static LinkedHashMap<String, List<EObject>> getBlockCommands(Resource program) {
		LinkedHashMap<String, List<EObject>> commands = new LinkedHashMap<String, List<EObject>>();
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

		while (objects.hasNext()) {
			EObject object = objects.next();
			if (object instanceof Option) {
				Option opt = (Option) object;
				if (opt.getType().getName().equals(type)) {
					return opt;
				}
			}
		}
		return null;
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
						if (element.getAtt() == null) {
							return element;
						}
					}
				}
			}
		}
		return null;
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
					if (element.getAtt() == null) {
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
}