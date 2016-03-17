package manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
import exceptions.ModelNotFoundException;
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
					for (EAttribute att : candidate.eClass().getEAllAttributes()) {
						if (att.getName().equals(attev.name)) {
							if (attev.type.toLowerCase().equals("string")) {
								if (((String) candidate.eGet(att)).equals((String) attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							//CASO DE QUE SEA DOUBLE
							if (attev.type.toLowerCase().equals("double")) {
								if (((double) candidate.eGet(att)) == Double.parseDouble(attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							//CASO DE QUE SEA BOOLEAN
							if (attev.type.toLowerCase().equals("boolean")) {
								if (((Boolean) candidate.eGet(att)) == Boolean.parseBoolean(attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							//CASO DE QUE SEA INT
							if (attev.type.toLowerCase().equals("int")) {
								if (((int) candidate.eGet(att)) == Integer.parseInt(attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
						}
					}
				}
				if (attev.operator.equals("<>")) {
					for (EAttribute att : candidate.eClass().getEAllAttributes()) {
						if (att.getName().equals(attev.name)) {
							//CASO DE QUE SEA STRING
							if (attev.type.toLowerCase().equals("string")) {
								if (!((String) candidate.eGet(att)).equals((String) attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							//CASO DE QUE SEA DOUBLE
							if (attev.type.toLowerCase().equals("double")) {
								if (((double) candidate.eGet(att)) != Double.parseDouble(attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							//CASO DE QUE SEA BOOLEAN
							if (attev.type.toLowerCase().equals("boolean")) {
								if (((Boolean) candidate.eGet(att)) != Boolean.parseBoolean(attev.value)) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							//CASO DE QUE SEA INT
							if (attev.type.toLowerCase().equals("int")) {
								if (((int) candidate.eGet(att)) != Integer.parseInt(attev.value)) {
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
					}
					else {
						for (EReference ref : candidate.eClass().getEAllReferences()) {
							if (refev.value == null) {
								if (candidate.eGet(ref) == null) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							else {
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
					}
					else {
						for (EReference ref : candidate.eClass().getEAllReferences()) {
							if (refev.value == null) {
								if (candidate.eGet(ref) != null) {
									if (!selected.contains(candidate)) {
										selected.add(candidate);
									}
								}
							}
							else {
								if (ref.getName().equals(refev.name)) {
									if (!candidate.eGet(ref).equals(refev.value)) {
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
								for (EAttribute att : candidate.eClass().getEAllAttributes()) {
									if (att.getName().equals(attev.name)) {
										//CASO DE QUE SEA STRING
										if (attev.type.toLowerCase().equals("string")) {
											if (!((String) candidate.eGet(att)).equals((String) attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
										//CASO DE QUE SEA DOUBLE
										if (attev.type.toLowerCase().equals("double")) {
											if (((double) candidate.eGet(att)) != Double.parseDouble(attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
										//CASO DE QUE SEA BOOLEAN
										if (attev.type.toLowerCase().equals("boolean")) {
											if (((Boolean) candidate.eGet(att)) != Boolean.parseBoolean(attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
										//CASO DE QUE SEA INT
										if (attev.type.toLowerCase().equals("int")) {
											if (((int) candidate.eGet(att)) != Integer.parseInt(attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
									}
								}
							}
							if (attev.operator.equals("<>")) {
								for (EAttribute att : candidate.eClass().getEAllAttributes()) {
									if (att.getName().equals(attev.name)) {
										//CASO DE QUE SEA STRING
										if (attev.type.toLowerCase().equals("string")) {
											if (((String) candidate.eGet(att)).equals((String) attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
										//CASO DE QUE SEA DOUBLE
										if (attev.type.toLowerCase().equals("double")) {
											if (((double) candidate.eGet(att)) == Double.parseDouble(attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
										//CASO DE QUE SEA BOOLEAN
										if (attev.type.toLowerCase().equals("boolean")) {
											if (((Boolean) candidate.eGet(att)) == Boolean.parseBoolean(attev.value)) {
												selected_tmp.remove(candidate);
											}
										}
										//CASO DE QUE SEA INT
										if (attev.type.toLowerCase().equals("int")) {
											if (((int) candidate.eGet(att)) == Integer.parseInt(attev.value)) {
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
								for (EAttribute att : candidate.eClass().getEAllAttributes()) {
									if (att.getName().equals(attev.name)) {
										//CASO DE QUE SEA STRING
										if (attev.type.toLowerCase().equals("string")) {
											if (((String) candidate.eGet(att)).equals((String) attev.value)) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										//CASO DE QUE SEA DOUBLE
										if (attev.type.toLowerCase().equals("double")) {
											if (((double) candidate.eGet(att)) == Double.parseDouble(attev.value)) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										//CASO DE QUE SEA BOOLEAN
										if (attev.type.toLowerCase().equals("boolean")) {
											if (((Boolean) candidate.eGet(att)) == Boolean.parseBoolean(attev.value)) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										//CASO DE QUE SEA INT
										if (attev.type.toLowerCase().equals("int")) {
											if (((int) candidate.eGet(att)) == Integer.parseInt(attev.value)) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
									}
								}
							}
							if (attev.operator.equals("<>")) {
								for (EAttribute att : candidate.eClass().getEAllAttributes()) {
									if (att.getName().equals(attev.name)) {
										//CASO DE QUE SEA STRING
										if (attev.type.toLowerCase().equals("string")) {
											if (!((String) candidate.eGet(att)).equals((String) attev.value)) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										//CASO DE QUE SEA DOUBLE
										if (attev.type.toLowerCase().equals("double")) {
											if (((double) candidate.eGet(att)) != Double.parseDouble(attev.value)) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										//CASO DE QUE SEA BOOLEAN
										if (attev.type.toLowerCase().equals("boolean")) {
											if (((Boolean) candidate.eGet(att)) != Boolean.parseBoolean(attev.value)) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										//CASO DE QUE SEA INT
										if (attev.type.toLowerCase().equals("int")) {
											if (((int) candidate.eGet(att)) != Integer.parseInt(attev.value)) {
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
				if (ev instanceof ReferenceEvaluation) {
					ReferenceEvaluation refev = (ReferenceEvaluation) ev;
					if (exp.operator.get(i).type.equals("and")) {
						for (EObject candidate : selected) {
							if (refev.operator.equals("=")) {
								if (refev.name == null) {
									if (!candidate.equals(refev.value)) {
										selected_tmp.remove(candidate);
									}
								}
								else {
									for (EReference ref : candidate.eClass().getEAllReferences()) {
										if (refev.value == null) {
											if (candidate.eGet(ref) != null) {
												selected_tmp.remove(candidate);
											}
										}
										else {
											if (ref.getName().equals(refev.name)) {
												if (!candidate.eGet(ref).equals(refev.value)) {
													selected_tmp.remove(candidate);
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
								}
								else {
									for (EReference ref : candidate.eClass().getEAllReferences()) {
										if (ref.getName().equals("null")) {
											if (refev.value == null) {
												selected_tmp.remove(candidate);
											}
										}
										else {
											if (ref.getName().equals(refev.name)) {
												if (candidate.eGet(ref).equals(refev.value)) {
													selected_tmp.remove(candidate);
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
								}
								else {
									for (EReference ref : candidate.eClass().getEAllReferences()) {
										if (refev.value == null) {
											if (candidate.eGet(ref) == null) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										else {
											if (ref.getName().equals(refev.name)) {
												if (candidate.eGet(ref).equals(refev.value)) {
													if (!selected_tmp.contains(candidate)) {
														selected_tmp.add(candidate);
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
								}
								else {
									for (EReference ref : candidate.eClass().getEAllReferences()) {
										if (refev.value == null) {
											if (candidate.eGet(ref) != null) {
												if (!selected_tmp.contains(candidate)) {
													selected_tmp.add(candidate);
												}
											}
										}
										else {
											if (ref.getName().equals(refev.name)) {
												if (!candidate.eGet(ref).equals(refev.value)) {
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
        		System.out.println( ((BasicDiagnostic)diagnostic.getChildren().get(0)).getMessage() );
        		System.out.println("Diagnostic code: " + ((BasicDiagnostic)diagnostic.getChildren().get(0)).getCode());
        		int code = ((BasicDiagnostic)diagnostic.getChildren().get(0)).getCode();
        		if (code == 0 || code == 1) {
        			// COMPLETES THE CARDINALITIES
        			TreeIterator<Object> tree = EcoreUtil.getAllContents(eObject, true);
        			ArrayList<EClass> classes = ModelManager.getEClasses(packages);
    				ArrayList<Boolean> solved = new ArrayList<Boolean>();
        			while (tree.hasNext()) {
        				EObject obj = (EObject) tree.next();
        				for (EAttribute att: obj.eClass().getEAttributes()) {
            				if ((att.getLowerBound() > 0) && (obj.eGet(att) == null)) {
            					System.out.println("att.getEType().getInstanceClassName()" + att.getEType().getInstanceClassName());
            					System.out.println("String.class.getCanonicalName()" + String.class.getCanonicalName());
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
									System.out.println(e.getMessage());
								}
            				}
            			}
           				for (EReference ref: obj.eClass().getEReferences()) {
           					if ((ref.getLowerBound() > 0) && (obj.eGet(ref) == null)) {
           						System.out.println("ref: " + ref);
           						System.out.println("ref.getEReferenceType().getName(): " + ref.getEReferenceType().getName());
           						solved.add(true);
           						try {
           							ModelManager.setReference(ref.getName(), obj, new RandomTypeSelection(packages, model, ref.getEReferenceType().getName()));
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
       			// if the diagnostic code is 0 the error is because of an OCL restriction that shall be ignored
        		else {
        			if (code != 0) {
       	     			return 3;
        			}
        		}
    		}
		}
    	return 0;
	}
	
	protected boolean different(ArrayList<EPackage> packages, Resource model, HashSet<String> hashset_mutants) throws ModelNotFoundException {
		boolean isRepeated = false;
		for (String mutFilename : hashset_mutants) {
			Resource cmpmutant =  ModelManager.loadModel(packages, mutFilename);
			isRepeated = ModelManager.compareModels(model, cmpmutant);
			if (isRepeated == true) {
				break;
			}
		}
		return isRepeated;
	}
	
	protected boolean matchesOCL(Resource model) {
		boolean matches = true;
		// for each object in the model
		for (EObject eObject : model.getContents()) {

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
			if (obj.eContainer().eClass().getName().equals("MutatorEnvironment")) {
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
}
