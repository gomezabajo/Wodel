package mutator;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import manager.IOUtils;
import manager.ModelManager;
import manager.WodelContext;
import mutatorenvironment.AttributeOperation;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.MaxValueType;
import mutatorenvironment.MinValueType;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.ObjectEmitter;
import mutatorenvironment.Program;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SelectSampleMutator;
import mutatorenvironment.SpecificClosureSelection;
//import mutatorenvironment.SelectObjectMutator;
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

public class MutatorUtils {
	
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
	
	protected List<EObject> evaluate(List<EObject> candidates, Expression exp) {
		HashSet<EObject> selected = new HashSet<EObject>();
		HashSet<EObject> selected_tmp = null;

		if (candidates == null) {
			return null;
		}
		if (exp.first instanceof AttributeEvaluation) {
			AttributeEvaluation attev = (AttributeEvaluation) exp.first;
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
							// CASO DE QUE SEA STRING
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
		if (exp.first instanceof ReferenceEvaluation) {
			ReferenceEvaluation refev = (ReferenceEvaluation) exp.first;
			for (EObject candidate : candidates) {
				if (refev.operator.equals("equals")) {
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
				if (refev.operator.equals("different")) {
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
																System.out.println("object name: " + ModelManager.getStringAttribute("name", object));
																System.out.println("ref name: " + reff.getName());
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
				if (refev.operator.equals("in") == true) {
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
			}
		}

		selected_tmp = new HashSet<EObject>();
		selected_tmp.addAll(selected);

		if (exp.operator.size() > 0) {
			int i = 0;
			for (Evaluation ev : exp.second) {
				if (ev instanceof AttributeEvaluation) {
					AttributeEvaluation attev = (AttributeEvaluation) ev;
					if (exp.operator.get(i).type.equals("and")) {
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
					if (exp.operator.get(i).type.equals("or")) {
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
				}
				if (ev instanceof ReferenceEvaluation) {
					ReferenceEvaluation refev = (ReferenceEvaluation) ev;
					if (exp.operator.get(i).type.equals("and")) {
						for (EObject candidate : selected) {
							if (refev.operator.equals("equals")) {
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
							if (refev.operator.equals("different")) {
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
							if (refev.operator.equals("in")) {
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
						}
					}
					if (exp.operator.get(i).type.equals("or")) {
						for (EObject candidate : candidates) {
							if (refev.operator.equals("equals")) {
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
							if (refev.operator.equals("different")) {
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
							if (refev.operator.equals("in")) {
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
						}
					}
				}
				i++;
			}
		}

		ArrayList<EObject> ret = new ArrayList<EObject>();
		if (selected_tmp != null) {
			ret.addAll(selected_tmp);
		}
		
		for (EObject r : ret) {
			System.out.println("ret: " + ModelManager.getStringAttribute("name", r));
		}

		return ret;
	}

	protected int complete(ArrayList<EPackage> packages, Resource model) {
		// VALIDATE MUTANT
		for (EObject eObject : model.getContents()) {
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				System.out.println(((BasicDiagnostic) diagnostic.getChildren()
						.get(0)).getMessage());
				System.out.println("Diagnostic code: "
						+ ((BasicDiagnostic) diagnostic.getChildren().get(0))
								.getCode());
				int code = ((BasicDiagnostic) diagnostic.getChildren().get(0))
						.getCode();
				if (code == 0 || code == 1) {
					// COMPLETES THE CARDINALITIES
					TreeIterator<Object> tree = EcoreUtil.getAllContents(
							eObject, true);
					ArrayList<EClass> classes = ModelManager
							.getEClasses(packages);
					ArrayList<Boolean> solved = new ArrayList<Boolean>();
					while (tree.hasNext()) {
						EObject obj = (EObject) tree.next();
						for (EAttribute att : obj.eClass().getEAttributes()) {
							if ((att.getLowerBound() > 0)
									&& (obj.eGet(att) == null)) {
								System.out
										.println("att.getEType().getInstanceClassName()"
												+ att.getEType()
														.getInstanceClassName());
								System.out
										.println("String.class.getCanonicalName()"
												+ String.class
														.getCanonicalName());
								try {
									if (att.getEType()
											.getInstanceClassName()
											.equals(String.class
													.getCanonicalName())) {
										ModelManager
												.setAttribute(
														att.getName(),
														obj,
														new RandomStringConfigurationStrategy(
																4, 5, false));
									}
									if (att.getEType()
											.getInstanceClassName()
											.equals(boolean.class
													.getCanonicalName())) {
										ModelManager
												.setAttribute(
														att.getName(),
														obj,
														new RandomBooleanConfigurationStrategy());
									}
									if (att.getEType()
											.getInstanceClassName()
											.equals(double.class
													.getCanonicalName())) {
										ModelManager
												.setAttribute(
														att.getName(),
														obj,
														new RandomDoubleConfigurationStrategy(
																1, 100, false));
									}
									if (att.getEType()
											.getInstanceClassName()
											.equals(int.class
													.getCanonicalName())) {
										ModelManager
												.setAttribute(
														att.getName(),
														obj,
														new RandomIntegerConfigurationStrategy(
																1, 100, false));
									}
								} catch (WrongAttributeTypeException e) {
									System.out.println(e.getMessage());
								}
							}
						}
						for (EReference ref : obj.eClass().getEReferences()) {
							if ((ref.getLowerBound() > 0)
									&& (obj.eGet(ref) == null)) {
								System.out.println("ref: " + ref);
								System.out
										.println("ref.getEReferenceType().getName(): "
												+ ref.getEReferenceType()
														.getName());
								solved.add(true);
								try {
									ModelManager.setReference(ref.getName(),
											obj, new RandomTypeSelection(
													packages, model,
													ref.getEReferenceType()
															.getName()));
									solved.set(solved.size() - 1, true);
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
	
	protected boolean different(String metamodel, String model,
			HashSet<String> hashset_mutants) throws ModelNotFoundException {
		boolean isRepeated = false;
		String extensionName = Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Mutants equivalence extension", "", null);
		if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							"wodel.comparation.MutComparation");

			for (IConfigurationElement extension : extensions) {
				try {
					Class<?> extensionClass = Platform.getBundle(extension.getDeclaringExtension().getContributor().getName()).loadClass(extension.getAttribute("class"));
					Object comparation =  extensionClass.newInstance();
					Method getName = extensionClass.getDeclaredMethod("getName");
					if (getName.invoke(comparation).equals(extensionName)) {
						Method doCompare = extensionClass.getDeclaredMethod("doCompare", new Class[]{String.class, String.class, String.class});
						boolean contained = false;
						for (String mutFilename : hashset_mutants) {
							isRepeated = (boolean) doCompare.invoke(comparation, metamodel, model, mutFilename);
							if (isRepeated == true) {
								break;
							}
						}
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
				}
			}
		}
		return isRepeated;
	}
	
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
							OCL ocl = OCL
									.newInstance(org.eclipse.ocl.ecore.EcoreEnvironmentFactory.INSTANCE);
							OCLHelper helper = ocl.createOCLHelper();
							helper.setInstanceContext(context);
							try {
								OCLExpression exp = helper
										.createQuery(invariant);
								Query<?, ?, ?> query = OCL
										.newInstance(
												org.eclipse.ocl.ecore.EcoreEnvironmentFactory.INSTANCE)
										.createQuery(exp);
								Object eval = query.evaluate(context);

								// check if the constraint failed
								if (eval instanceof Boolean
										&& ((Boolean) eval).booleanValue() == false) {
									System.out.println(">>> ERROR: constraint "
											+ key + " does not hold");
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
						OCL ocl = OCL
								.newInstance(org.eclipse.ocl.ecore.EcoreEnvironmentFactory.INSTANCE);
						OCLHelper helper = ocl.createOCLHelper();
						helper.setInstanceContext(context);
						try {
							OCLExpression exp = helper.createQuery(invariant);
							Query<?, ?, ?> query = OCL
									.newInstance(
											org.eclipse.ocl.ecore.EcoreEnvironmentFactory.INSTANCE)
									.createQuery(exp);
							Object eval = query.evaluate(context);

							// check if the constraint failed
							if (eval instanceof Boolean
									&& ((Boolean) eval).booleanValue() == false) {
								System.out.println(">>> ERROR: constraint "
										+ invariant + " does not hold");
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

	protected int getRandom(int range) {
		if (range == 1)
			return 0;

		int value = ModelManager.rn.nextInt() % range;
		if (value < 0)
			value = value * -1;

		return value;
	}
	protected static HashMap<String, EObject> getMutatorNames(ArrayList<EObject> objects) {
		HashMap<String, EObject> mutators = new HashMap<String, EObject>();
		for (EObject obj : objects) {
			String name = obj.eClass().getName();
			if (name.equals("CreateObjectMutator")
					|| name.equals("RemoveObjectMutator")
					|| name.equals("CreateReferenceMutator")
					|| name.equals("ModifySourceReferenceMutator")
					|| name.equals("ModifyTargetReferenceMutator")
					|| name.equals("RemoveRandomReferenceMutator")
					|| name.equals("RemoveSpecificReferenceMutator")
					|| name.equals("RemoveCompleteReferenceMutator")
					|| name.equals("ModifyInformationMutator")
					|| name.equals("SelectObjectMutator")
					|| name.equals("SelectSampleMutator")
					|| name.equals("CloneObjectMutator")) {
				Mutator mut = (Mutator) obj;
				if (mut.getName() != null) {
					mutators.put(mut.getName(), obj);
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
	
	protected static HashMap<String, Mutator> getMutatorNames(List<Mutator> mutators) {
		HashMap<String, Mutator> ret = new HashMap<String, Mutator>();
		int counter = 0;
		for (Mutator mut : mutators) {
			String name = mut.eClass().getName();
			if (name.equals("CreateObjectMutator")
					|| name.equals("RemoveObjectMutator")
					|| name.equals("CreateReferenceMutator")
					|| name.equals("ModifySourceReferenceMutator")
					|| name.equals("ModifyTargetReferenceMutator")
					|| name.equals("RemoveRandomReferenceMutator")
					|| name.equals("RemoveSpecificReferenceMutator")
					|| name.equals("RemoveCompleteReferenceMutator")
					|| name.equals("ModifyInformationMutator")
					|| name.equals("SelectObjectMutator")
					|| name.equals("SelectSampleMutator")
					|| name.equals("CloneObjectMutator")) {
				if (mut.getName() != null) {
					ret.put(mut.getName(), mut);
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

	public static String getMutatorName(Mutator mut) {
		String name = mut.eClass().getName();
		if (name.equals("CreateObjectMutator")
				|| name.equals("RemoveObjectMutator")
				|| name.equals("CreateReferenceMutator")
				|| name.equals("ModifySourceReferenceMutator")
				|| name.equals("ModifyTargetReferenceMutator")
				|| name.equals("RemoveRandomReferenceMutator")
				|| name.equals("RemoveSpecificReferenceMutator")
				|| name.equals("RemoveCompleteReferenceMutator")
				|| name.equals("ModifyInformationMutator")
				|| name.equals("SelectObjectMutator")
				|| name.equals("SelectSampleMutator")
				|| name.equals("CloneObjectMutator")) {
			if (mut.getName() != null) {
				return mut.getName();
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
	
	protected static HashMap<String, EObject> getMutators(ArrayList<EObject> objects) {
		HashMap<String, EObject> mutators = new HashMap<String, EObject>();
		int counter = 0;
		for (EObject obj : objects) {
			String name = obj.eClass().getName();
			System.out.println("name: " + name);
			if (name.equals("CreateObjectMutator")
					|| name.equals("RemoveObjectMutator")
					|| name.equals("CreateReferenceMutator")
					|| name.equals("ModifySourceReferenceMutator")
					|| name.equals("ModifyTargetReferenceMutator")
					|| name.equals("RemoveRandomReferenceMutator")
					|| name.equals("RemoveSpecificReferenceMutator")
					|| name.equals("RemoveCompleteReferenceMutator")
					|| name.equals("ModifyInformationMutator")
					|| name.equals("SelectObjectMutator")
					|| name.equals("SelectSampleMutator")
					|| name.equals("CloneObjectMutator")) {
				counter++;
				mutators.put("m" + counter, obj);
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

		for (String id : mutators.keySet()) {
			System.out.println("id: " + id + "; mutator: " + mutators.get(id));
		}

		return mutators;
	}
	
	protected static List<EObject> getMutatorList(ArrayList<EObject> objects) {
		List<EObject> mutators = new ArrayList<EObject>();
		int counter = 0;
		for (EObject obj : objects) {
			String name = obj.eClass().getName();
			System.out.println("name: " + name);
			if (name.equals("CreateObjectMutator")
					|| name.equals("RemoveObjectMutator")
					|| name.equals("CreateReferenceMutator")
					|| name.equals("ModifySourceReferenceMutator")
					|| name.equals("ModifyTargetReferenceMutator")
					|| name.equals("RemoveRandomReferenceMutator")
					|| name.equals("RemoveSpecificReferenceMutator")
					|| name.equals("RemoveCompleteReferenceMutator")
					|| name.equals("ModifyInformationMutator")
					|| name.equals("SelectObjectMutator")
					|| name.equals("SelectSampleMutator")
					|| name.equals("CloneObjectMutator")) {
				counter++;
				mutators.add(obj);
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

	protected static EObject getLastMutatorOfBlock(Resource resource, String blockName) {
		List<EObject> commands = null;
		try {
			EObject block = MutatorUtils.getBlock(resource, blockName);
			commands = ModelManager.getReferences("commands", block);
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (commands != null) {
			return commands.get(commands.size() - 1);
		}
		return null;
	}

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

	public static void generateJSONPaths(File block,
			ArrayList<EPackage> packages,
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
					generateJSONPaths(folderBlock[i], packages,
							hashmap_postproc);
				}
			}
		}
	}

	public static void generateRegistryPaths(File block,
			ArrayList<EPackage> packages,
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
						if (pathfileblock.endsWith(".model") == true) {
							System.out.println(blockModelFolder + ".model");
							Resource blockmodelfile = ModelManager.loadModel(
									packages, blockModelFolder + ".model");
							hashmap_postproc.put(pathfileblock, blockmodelfile);
							System.out.println(block.getPath()
									+ "/"
									+ regfiles[j].getName().replace("Registry",
											""));
							Resource mutant = ModelManager.loadModel(
									packages,
									block.getPath()
											+ "/"
											+ regfiles[j].getName().replace(
													"Registry", ""));
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

	public static void getRegistryModels(File folder, ArrayList<EPackage> packages, HashMap<String, Resource> registryModels) throws ModelNotFoundException {
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

	public static String getSeedFromRegistry(String registryFilename) {
		int start = registryFilename.indexOf("out" + File.separator) + ("out" + File.separator).length();
		int end = start + registryFilename.substring(start, registryFilename.length()).indexOf(File.separator); 
		return ModelManager.getMetaModelPath() + "/" + registryFilename.substring(start, end) + ".model";
	}

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
	
	public void createMutantVersionRegistry(ArrayList<EPackage> packages, List<Resource> seeds, Resource model, String versionPath, AppMutation mut) {
		File outputFolder = new File(versionPath.substring(0, versionPath.lastIndexOf("/")) + "/registry");
		System.out.println(versionPath.substring(0, versionPath.lastIndexOf("/")) + "/registry");
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

	public static ArrayList<EClass> getClassMutators(ArrayList<EPackage> packages) {
		ArrayList<EClass> mutators = new ArrayList<EClass>();
		ArrayList<EObject> objects = ModelManager.getAllObjects(packages);
		for (EObject obj : objects) {
			if (obj instanceof EClass) {
				EClass eClass = (EClass) obj;
				String name = eClass.getName();
				if (name.equals("CreateObjectMutator")
						|| name.equals("RemoveObjectMutator")
						//|| name.equals("CreateReferenceMutator")
						//|| name.equals("CreateReferenceMutator")
						//|| name.equals("ModifySourceReferenceMutator")
						//|| name.equals("ModifyTargetReferenceMutator")
						//|| name.equals("RemoveRandomReferenceMutator")
						//|| name.equals("RemoveSpecificReferenceMutator")
						//|| name.equals("RemoveCompleteReferenceMutator")
						|| name.equals("ModifyInformationMutator")
						|| name.equals("SelectObjectMutator")
						|| name.equals("CloneObjectMutator")
						//|| name.equals("CompositeMutator")
						) {
					mutators.add(eClass);
				}
			}
		}
		return mutators;
	}
	
	public static ArrayList<EClass> getCreationClassMutators(ArrayList<EPackage> packages) {
		ArrayList<EClass> mutators = new ArrayList<EClass>();
		ArrayList<EObject> objects = ModelManager.getAllObjects(packages);
		for (EObject obj : objects) {
			if (obj instanceof EClass) {
				EClass eClass = (EClass) obj;
				String name = eClass.getName();
				if (name.equals("CreateObjectMutator")
						|| name.equals("CloneObjectMutator")) {
					mutators.add(eClass);
				}
			}
		}
		return mutators;
	}
	
	public static ArrayList<EClass> getModificationClassMutators(ArrayList<EPackage> packages) {
		ArrayList<EClass> mutators = new ArrayList<EClass>();
		ArrayList<EObject> objects = ModelManager.getAllObjects(packages);
		for (EObject obj : objects) {
			if (obj instanceof EClass) {
				EClass eClass = (EClass) obj;
				String name = eClass.getName();
				if (name.equals("ModifyInformationMutator")) {
					mutators.add(eClass);
				}
			}
		}
		return mutators;
	}

	public static ArrayList<EClass> getModificationReferenceClassMutators(ArrayList<EPackage> packages) {
		ArrayList<EClass> mutators = new ArrayList<EClass>();
		ArrayList<EObject> objects = ModelManager.getAllObjects(packages);
		for (EObject obj : objects) {
			if (obj instanceof EClass) {
				EClass eClass = (EClass) obj;
				String name = eClass.getName();
				if (name.equals("ModifyInformationMutator") ||
						name.equals("ModifySourceReferenceMutator") ||
						name.equals("ModifyTargetReferenceMutator")) {
					mutators.add(eClass);
				}
			}
		}
		return mutators;
	}

	public static ArrayList<EClass> getDeletionClassMutators(ArrayList<EPackage> packages) {
		ArrayList<EClass> mutators = new ArrayList<EClass>();
		ArrayList<EObject> objects = ModelManager.getAllObjects(packages);
		for (EObject obj : objects) {
			if (obj instanceof EClass) {
				EClass eClass = (EClass) obj;
				String name = eClass.getName();
				if (name.equals("RemoveObjectMutator")) {
					mutators.add(eClass);
				}
			}
		}
		return mutators;
	}

	public static ArrayList<EClass> getMutatorStrategies(ArrayList<EPackage> packages, String className) {
		ArrayList<EClass> strategies = new ArrayList<EClass>();
		ArrayList<EObject> objects = ModelManager.getAllObjects(packages);
		if (className.equals("RemoveObjectMutator")
				|| className.equals("CloneObjectMutator")
				|| className.equals("ModifyInformationMutator")
				|| className.equals("SelectObjectMutator")
				|| className.equals("ModifySourceReferenceMutator")
				|| className.equals("ModifyTargetReferenceMutator")) {
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
		}
		return strategies;
	}
	
	public static ArrayList<EObject> getBlocks(Resource model) {
		return ModelManager.getObjectsOfType("Block", model);
	}


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
								eClass = getMutatorType(model, selection.getObjSel().getName());
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
									eClass = getMutatorType(model, selection.getObjSel().getName());
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
								eClass = getMutatorType(model, selection.getObjSel().getName());
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
						return getMutatorType((Mutator) selection.getObjSel());
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
							eClass = getMutatorType((Mutator) selection.getObjSel());
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
						eClass = getMutatorType((Mutator) selection.getObjSel());
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
					if (selection.getObjSel() instanceof CreateObjectMutator) {
						className = selection.getObjSel().getType().getName();
					}
					if (selection.getObjSel() instanceof mutatorenvironment.SelectObjectMutator) {
						className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
					}
					if (selection.getObjSel() instanceof CloneObjectMutator) {
						className = selection.getObjSel().getType().getName();
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
					if (selection.getObjSel() instanceof CreateObjectMutator) {
						className = selection.getObjSel().getType().getName();
					}
					if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
						className = ((ObSelectionStrategy) ((mutatorenvironment.SelectObjectMutator) selection.getObjSel()).getObject()).getType().getName();
					}
					if (selection.getObjSel() instanceof mutatorenvironment.SelectSampleMutator) {
						className = ((ObSelectionStrategy) ((mutatorenvironment.SelectSampleMutator) selection.getObjSel()).getObject()).getType().getName();
					}
					if (selection.getObjSel() instanceof CloneObjectMutator) {
						className = selection.getObjSel().getType().getName();
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
	
	protected List<EObject> unique(List<EObject> candidates, String featureName, boolean isReference) {
		List<EObject> result = new ArrayList<EObject>();
		List<Object> in = new ArrayList<Object>();
		if (isReference == false) {
			for (EObject candidate : candidates) {
				for (EAttribute att : candidate.eClass().getEAllAttributes()) {
					if (att.getName().equals(featureName)) {
						Object object = candidate.eGet(att);
						if (in.contains(object) == false) {
							result.add(candidate);
							in.add(object);
						}
					}
				}
			}
		}
		if (isReference == true) {
			for (EObject candidate : candidates) {
				for (EReference ref : candidate.eClass().getEAllReferences()) {
					if (ref.getName().equals(featureName)) {
						Object object = candidate.eGet(ref);
						if (in.contains(object) == false) {
							result.add(candidate);
							in.add(object);
						}
					}
				}
			}
		}
		return result;
	}
	
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
		}
		return type;
	}
	
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
		}
		return type;
	}
	
	private static CloneObjectMutator SpecificObjectSelection(
			SelectObjectMutator oe) {
		// TODO Auto-generated method stub
		return null;
	}

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
	
	public static String selectSampleMutatorHelper(SelectSampleMutator com) {
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
					className = selectSampleMutatorHelper((SelectSampleMutator) selection.getObjSel());
				}
				if (selection.getObjSel() instanceof CloneObjectMutator) {
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
					className = selectSampleMutatorHelper((SelectSampleMutator) selection.getObjSel());
				}
       			if (selection.getObjSel() instanceof CloneObjectMutator) {
       				className = selection.getObjSel().getType().getName();
       			}
       		}
		}
		return className;
	}
	
	public boolean registryMutant(String metamodel, ArrayList<EPackage> packages,
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
				System.out.println("isRepeated: " + isRepeated);
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
									EObject emutated = emuts.get(0);
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
													System.out.println("FOUND!!!");
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
									EObject emutated = emuts.get(0);
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
													System.out.println("FOUND!!!");
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
									EObject emutated = emuts.get(0);
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
													System.out.println("FOUND!!!");
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
												System.out.println("FOUND!!!");
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

	public boolean registryMutantWithBlocks(String metamodel, ArrayList<EPackage> packages,
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
									EObject emutated = emuts.get(0);
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
													System.out.println("FOUND!!!");
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
									EObject emutated = emuts.get(0);
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
													System.out.println("FOUND!!!");
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
									EObject emutated = emuts.get(0);
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
													System.out.println("FOUND!!!");
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
												System.out.println("FOUND!!!");
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

}