package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mutatorenvironment.Block;
import mutatorenvironment.Constraint;
import mutatorenvironment.Mutator;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
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
import org.osgi.framework.Bundle;

import appliedMutations.AppMutation;
import appliedMutations.Mutations;
import appliedMutations.ObjectCreated;
import appliedMutations.ReferenceCreated;
import commands.ModifyInformationMutator;
import commands.ModifyTargetReferenceMutator;
import commands.SelectObjectMutator;
import commands.selection.strategies.ObSelectionStrategy;
import commands.selection.strategies.OtherTypeSelection;
import commands.selection.strategies.RandomTypeSelection;
import commands.selection.strategies.SpecificObjectSelection;
import commands.selection.strategies.SpecificReferenceSelection;
import commands.strategies.AttributeConfigurationStrategy;
import commands.strategies.RandomBooleanConfigurationStrategy;
import commands.strategies.RandomDoubleConfigurationStrategy;
import commands.strategies.RandomIntegerConfigurationStrategy;
import commands.strategies.RandomStringConfigurationStrategy;
import commands.strategies.ReferenceConfigurationStrategy;
import commands.strategies.SpecificBooleanConfigurationStrategy;
import commands.strategies.SwapAttributeConfigurationStrategy;
import commands.strategies.SwapReferenceConfigurationStrategy;
import exceptions.AbstractCreationException;
import exceptions.MaxSmallerThanMinException;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.ObjectNoTargetableException;
import exceptions.ObjectNotContainedException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;

public class MutatorUtils {

	protected class Operator {
		public String type;

		public Operator() {

		}
	}

	protected class AttributeEvaluation extends Evaluation {
		public String value;
		public String type;

		public AttributeEvaluation() {

		}
	}

	protected class ReferenceEvaluation extends Evaluation {
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

		if (exp.first instanceof AttributeEvaluation) {
			AttributeEvaluation attev = (AttributeEvaluation) exp.first;
			for (EObject candidate : candidates) {
				if (attev.operator.equals("=")) {
					for (EAttribute att : candidate.eClass()
							.getEAllAttributes()) {
						if (att.getName().equals(attev.name)) {
							if (attev.type.toLowerCase().equals("string")) {
								if (((String) candidate.eGet(att))
										.equals((String) attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							// CASO DE QUE SEA DOUBLE
							if (attev.type.toLowerCase().equals("double")) {
								if (((double) candidate.eGet(att)) == Double
										.parseDouble(attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							// CASO DE QUE SEA BOOLEAN
							if (attev.type.toLowerCase().equals("boolean")) {
								if (((Boolean) candidate.eGet(att)) == Boolean
										.parseBoolean(attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							// CASO DE QUE SEA INT
							if (attev.type.toLowerCase().equals("int")) {
								if (((int) candidate.eGet(att)) == Integer
										.parseInt(attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
						}
					}
				}
				if (attev.operator.equals("<>")) {
					for (EAttribute att : candidate.eClass()
							.getEAllAttributes()) {
						if (att.getName().equals(attev.name)) {
							// CASO DE QUE SEA STRING
							if (attev.type.toLowerCase().equals("string")) {
								if (!((String) candidate.eGet(att))
										.equals((String) attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							// CASO DE QUE SEA DOUBLE
							if (attev.type.toLowerCase().equals("double")) {
								if (((double) candidate.eGet(att)) != Double
										.parseDouble(attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							// CASO DE QUE SEA BOOLEAN
							if (attev.type.toLowerCase().equals("boolean")) {
								if (((Boolean) candidate.eGet(att)) != Boolean
										.parseBoolean(attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							// CASO DE QUE SEA INT
							if (attev.type.toLowerCase().equals("int")) {
								if (((int) candidate.eGet(att)) != Integer
										.parseInt(attev.value)) {
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
		if (exp.first instanceof ReferenceEvaluation) {
			ReferenceEvaluation refev = (ReferenceEvaluation) exp.first;
			for (EObject candidate : candidates) {
				if (refev.operator.equals("=")) {
					if (refev.name == null) {
						if (candidate.equals(refev.value)) {
							if (!selected.contains(candidate)) {
								selected.add(candidate);
							}
						}
					} else {
						for (EReference ref : candidate.eClass()
								.getEAllReferences()) {
							if (refev.value == null) {
								if (candidate.eGet(ref) == null) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							} else {
								if (ref.getName().equals(refev.name)) {
									if (candidate.eGet(ref).equals(refev.value)) {
										if (!selected.contains(candidate)) {
											selected.add(candidate);
										}
									}
								}
							}
						}
					}
				}
				if (refev.operator.equals("<>")) {
					if (refev.name == null) {
						if (!candidate.equals(refev.value)) {
							if (!selected.contains(candidate)) {
								selected.add(candidate);
							}
						}
					} else {
						for (EReference ref : candidate.eClass()
								.getEAllReferences()) {
							if (refev.value == null) {
								if (candidate.eGet(ref) != null) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							} else {
								if (ref.getName().equals(refev.name)) {
									if (!candidate.eGet(ref)
											.equals(refev.value)) {
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

		selected_tmp = new HashSet<EObject>();
		selected_tmp.addAll(selected);

		if (exp.operator.size() > 0) {
			int i = 0;
			for (Evaluation ev : exp.second) {
				if (ev instanceof AttributeEvaluation) {
					AttributeEvaluation attev = (AttributeEvaluation) ev;
					if (exp.operator.get(i).type.equals("and")) {
						for (EObject candidate : selected) {
							if (attev.operator.equals("=")) {
								for (EAttribute att : candidate.eClass()
										.getEAllAttributes()) {
									if (att.getName().equals(attev.name)) {
										// CASO DE QUE SEA STRING
										if (attev.type.toLowerCase().equals(
												"string")) {
											if (!((String) candidate.eGet(att))
													.equals((String) attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
										// CASO DE QUE SEA DOUBLE
										if (attev.type.toLowerCase().equals(
												"double")) {
											if (((double) candidate.eGet(att)) != Double
													.parseDouble(attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
										// CASO DE QUE SEA BOOLEAN
										if (attev.type.toLowerCase().equals(
												"boolean")) {
											if (((Boolean) candidate.eGet(att)) != Boolean
													.parseBoolean(attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
										// CASO DE QUE SEA INT
										if (attev.type.toLowerCase().equals(
												"int")) {
											if (((int) candidate.eGet(att)) != Integer
													.parseInt(attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
									}
								}
							}
							if (attev.operator.equals("<>")) {
								for (EAttribute att : candidate.eClass()
										.getEAllAttributes()) {
									if (att.getName().equals(attev.name)) {
										// CASO DE QUE SEA STRING
										if (attev.type.toLowerCase().equals(
												"string")) {
											if (((String) candidate.eGet(att))
													.equals((String) attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
										// CASO DE QUE SEA DOUBLE
										if (attev.type.toLowerCase().equals(
												"double")) {
											if (((double) candidate.eGet(att)) == Double
													.parseDouble(attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
										// CASO DE QUE SEA BOOLEAN
										if (attev.type.toLowerCase().equals(
												"boolean")) {
											if (((Boolean) candidate.eGet(att)) == Boolean
													.parseBoolean(attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
										// CASO DE QUE SEA INT
										if (attev.type.toLowerCase().equals(
												"int")) {
											if (((int) candidate.eGet(att)) == Integer
													.parseInt(attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
									}
								}
							}
						}
					}
					if (exp.operator.get(i).type.equals("or")) {
						for (EObject candidate : candidates) {
							if (attev.operator.equals("=")) {
								for (EAttribute att : candidate.eClass()
										.getEAllAttributes()) {
									if (att.getName().equals(attev.name)) {
										// CASO DE QUE SEA STRING
										if (attev.type.toLowerCase().equals(
												"string")) {
											if (((String) candidate.eGet(att))
													.equals((String) attev.value)) {
												if (!selected_tmp
														.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										// CASO DE QUE SEA DOUBLE
										if (attev.type.toLowerCase().equals(
												"double")) {
											if (((double) candidate.eGet(att)) == Double
													.parseDouble(attev.value)) {
												if (!selected_tmp
														.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										// CASO DE QUE SEA BOOLEAN
										if (attev.type.toLowerCase().equals(
												"boolean")) {
											if (((Boolean) candidate.eGet(att)) == Boolean
													.parseBoolean(attev.value)) {
												if (!selected_tmp
														.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										// CASO DE QUE SEA INT
										if (attev.type.toLowerCase().equals(
												"int")) {
											if (((int) candidate.eGet(att)) == Integer
													.parseInt(attev.value)) {
												if (!selected_tmp
														.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
									}
								}
							}
							if (attev.operator.equals("<>")) {
								for (EAttribute att : candidate.eClass()
										.getEAllAttributes()) {
									if (att.getName().equals(attev.name)) {
										// CASO DE QUE SEA STRING
										if (attev.type.toLowerCase().equals(
												"string")) {
											if (!((String) candidate.eGet(att))
													.equals((String) attev.value)) {
												if (!selected_tmp
														.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										// CASO DE QUE SEA DOUBLE
										if (attev.type.toLowerCase().equals(
												"double")) {
											if (((double) candidate.eGet(att)) != Double
													.parseDouble(attev.value)) {
												if (!selected_tmp
														.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										// CASO DE QUE SEA BOOLEAN
										if (attev.type.toLowerCase().equals(
												"boolean")) {
											if (((Boolean) candidate.eGet(att)) != Boolean
													.parseBoolean(attev.value)) {
												if (!selected_tmp
														.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										// CASO DE QUE SEA INT
										if (attev.type.toLowerCase().equals(
												"int")) {
											if (((int) candidate.eGet(att)) != Integer
													.parseInt(attev.value)) {
												if (!selected_tmp
														.contains(candidate)) {
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
				if (ev instanceof ReferenceEvaluation) {
					ReferenceEvaluation refev = (ReferenceEvaluation) ev;
					if (exp.operator.get(i).type.equals("and")) {
						for (EObject candidate : selected) {
							if (refev.operator.equals("=")) {
								if (refev.name == null) {
									if (!candidate.equals(refev.value)) {
										selected_tmp.remove(candidate);
									}
								} else {
									for (EReference ref : candidate.eClass()
											.getEAllReferences()) {
										if (refev.value == null) {
											if (candidate.eGet(ref) != null) {
												selected_tmp.remove(candidate);
											}
										} else {
											if (ref.getName()
													.equals(refev.name)) {
												if (!candidate.eGet(ref)
														.equals(refev.value)) {
													selected_tmp
															.remove(candidate);
												}
											}
										}
									}
								}
							}
							if (refev.operator.equals("<>")) {
								if (refev.name == null) {
									if (candidate.equals(refev.value)) {
										selected_tmp.remove(candidate);
									}
								} else {
									for (EReference ref : candidate.eClass()
											.getEAllReferences()) {
										if (ref.getName().equals("null")) {
											if (refev.value == null) {
												selected_tmp.remove(candidate);
											}
										} else {
											if (ref.getName()
													.equals(refev.name)) {
												if (candidate.eGet(ref).equals(
														refev.value)) {
													selected_tmp
															.remove(candidate);
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
							if (refev.operator.equals("=")) {
								if (refev.name == null) {
									if (candidate.equals(refev.value)) {
										if (!selected_tmp.contains(candidate)) {
											selected_tmp.add(candidate);
										}
									}
								} else {
									for (EReference ref : candidate.eClass()
											.getEAllReferences()) {
										if (refev.value == null) {
											if (candidate.eGet(ref) == null) {
												if (!selected_tmp
														.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										} else {
											if (ref.getName()
													.equals(refev.name)) {
												if (candidate.eGet(ref).equals(
														refev.value)) {
													if (!selected_tmp
															.contains(candidate)) {
														selected_tmp
																.add(candidate);
													}
												}
											}
										}
									}
								}
							}
							if (refev.operator.equals("<>")) {
								if (refev.name == null) {
									if (!candidate.equals(refev.value)) {
										if (!selected_tmp.contains(candidate)) {
											selected_tmp.add(candidate);
										}
									}
								} else {
									for (EReference ref : candidate.eClass()
											.getEAllReferences()) {
										if (refev.value == null) {
											if (candidate.eGet(ref) != null) {
												if (!selected_tmp
														.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										} else {
											if (ref.getName()
													.equals(refev.name)) {
												if (!candidate.eGet(ref)
														.equals(refev.value)) {
													if (!selected_tmp
															.contains(candidate)) {
														selected_tmp
																.add(candidate);
													}
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

	protected boolean different(ArrayList<EPackage> packages, Resource model,
			HashSet<String> hashset_mutants) throws ModelNotFoundException {
		boolean isRepeated = false;
		for (String mutFilename : hashset_mutants) {
			Resource cmpmutant = ModelManager.loadModel(packages, mutFilename);
			isRepeated = ModelManager.compareModels(model, cmpmutant);
			if (isRepeated == true) {
				break;
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

	protected HashMap<String, EObject> getMutators(ArrayList<EObject> objects) {
		HashMap<String, EObject> mutators = new HashMap<String, EObject>();
		int counter = 0;
		for (EObject obj : objects) {
			String name = obj.eClass().getName();
			System.out.println("name: " + name);
			if (name.equals("CreateObjectMutator")
					|| name.equals("RemoveObjectMutator")
					|| name.equals("CreateReferenceMutator")
					|| name.equals("CreateReferenceMutator")
					|| name.equals("ModifySourceReferenceMutator")
					|| name.equals("ModifyTargetReferenceMutator")
					|| name.equals("RemoveRandomReferenceMutator")
					|| name.equals("RemoveSpecificReferenceMutator")
					|| name.equals("RemoveCompleteReferenceMutator")
					|| name.equals("ModifyInformationMutator")
					|| name.equals("SelectObjectMutator")) {
				counter++;
				mutators.put("m" + counter, obj);
			}
			if (obj.eContainer().eClass().getName()
					.equals("MutatorEnvironment")) {
				if (name.equals("CompositeMutator")) {
					counter++;
					mutators.put("m" + counter, obj);
				}
			}
		}

		for (String id : mutators.keySet()) {
			System.out.println("id: " + id + "; mutator: " + mutators.get(id));
		}

		return mutators;
	}

	public static void generateModelPaths(String fromName, File mutFile, String folderName,
		HashMap<String, String> hashmapModelFilenames,
		HashMap<String, String> hashmapModelFolders,
		HashMap<String, String> hashmapSeedModelFilenames,
		String modelsURI, File modelFile) {
		if (mutFile.getName().equals("registry") != true) {
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
	
	public boolean registryMutantWithBlocks(ArrayList<EPackage> packages,
			Resource model, HashMap<String, ArrayList<String>> rules,
			Mutations muts, String modelFilename, String mutFilename,
			boolean registry, HashSet<String> hashsetMutantsBlock,
			HashMap<String, String> hashmapModelFilenames,
			HashMap<String, String> hashmapModelFolders, String block,
			ArrayList<String> fromBlocks, int n) throws ModelNotFoundException {
		boolean isRepeated = false;
		int valid = complete(packages, model);
		if (valid != 1) {
			if (matchesOCL(model, rules) == true) {
				// VERIFY IF MUTANT IS DIFFERENT
				isRepeated = different(packages, model, hashsetMutantsBlock);
				// IF MUTANT IS DIFFERENT STORES IT AND PROCEEDS
				if (isRepeated == false) {
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
					hashsetMutantsBlock.add(mutFilename);
					if (registry == true) {
						Resource mutant = ModelManager.loadModel(packages, mutFilename);
						for (AppMutation mut : muts.getMuts()) {
							if (mut instanceof ObjectCreated) {
								List<EObject> emuts = ((ObjectCreated) mut).getObject();
								if (emuts.size() > 0) {
									EObject emutated = emuts.get(0);
									emuts.remove(0);
									if (ModelManager.getObject(mutant, emutated) != null) {
										emuts.add(ModelManager.getObject(mutant, emutated));
									}
								}
							}
							if (mut instanceof ReferenceCreated) {
								List<EReference> emuts = ((ReferenceCreated) mut).getRef();
								if (emuts.size() > 0) {
									EReference emutated = emuts.get(0);
									emuts.remove(0);
									if (ModelManager.getReference(mutant, emutated) != null) {
										emuts.add(ModelManager.getReference(mutant, emutated));
									}
								}
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
			}
		}
		return isRepeated;
	}
}
