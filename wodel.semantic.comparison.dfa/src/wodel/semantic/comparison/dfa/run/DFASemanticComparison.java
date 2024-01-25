package wodel.semantic.comparison.dfa.run;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.semantic.comparison.run.SemanticComparison;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.manager.EMFComparison;
import wodel.utils.manager.ModelManager;

public class DFASemanticComparison extends SemanticComparison {
	@Override
	public String getName() {
		return "DFA semantic comparison";
	}

	@Override
	public String getURI() {
		return "http://dfaAutomaton/1.0";
	}

	private boolean compareEObjectLists(List<Object> l1, List<Object> l2) {
		if (l1 != null && l2 != null) {
			if (l1.size() == l2.size()) {
				Map<Object, Boolean> found = new HashMap<Object, Boolean>();
				for (Object o1 : l1) {
					found.put(o1, false);
				}
				for (Object o1 : l1) {
					for (Object o2 : l2) {
						if (o1 instanceof List<?> && o2 instanceof List<?>) {
							List<EObject> lo1 = (List<EObject>) o1;
							List<EObject> lo2 = (List<EObject>) o2;
							if (lo1.size() == lo2.size()) {
								for (EObject eo1 : lo1) {
									boolean efound = false;
									for (EObject eo2 :lo2) {
										if (EMFComparison.equals(eo1, eo2) == true) {
											efound = true;
											break;
										}
									}
									if (efound != false) {
										found.put(o1, true);
									}
								}
							}
						}
						else {
							if (o1 instanceof EObject && o2 instanceof EObject) {
								if (EMFComparison.equals((EObject) o1, (EObject) o2) == true) {
									found.put(o1, true);
									break;
								}
							}
						}
					}
				}
				for (Object o1 : found.keySet()) {
					if (found.get(o1) != true) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	private void getStateClosure(EObject initial, EObject root, EObject[] transitions, List<EObject> closure) {
		try {
			if (!closure.contains(initial)) {
				closure.add(initial);
				for (EObject transition : transitions) {
					EObject source = ModelManager.getReference("src", transition);
					if (EMFComparison.equals(initial, source) == true) {
						EObject symbol = ModelManager.getReference("symbol", transition);
						if (symbol == null) {
							EObject target = ModelManager.getReference("tar", transition);
							if (!closure.contains(target)) {
								getStateClosure(target, root, transitions, closure);
							}
						}
					}
				}
			}

		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<List<Object>> convertToDFA(List<EPackage> packages, Resource ndfa) {
		List<List<Object>> transitionTable = null;
		try {
			EObject root = ModelManager.getRoot(ndfa);
			List<EObject> states = ModelManager.getReferences("states", root);
			EObject initial = null;
			for (EObject state : states) {
				boolean isInitial = ModelManager.getBooleanAttribute("isInitial", state);
				if (isInitial == true) {
					initial = state;
					break;
				}
			}
			List<EObject> transitionList = ModelManager.getReferences("transitions", root);
			EObject[] transitions = new EObject[transitionList.size()];
			transitionList.toArray(transitions);
			List<EObject> initials = new ArrayList<EObject>();
			getStateClosure(initial, root, transitions, initials);

			List<EObject> alphabetList = ModelManager.getReferences("alphabet", root);
			EObject[] alphabet = new EObject[alphabetList.size()];
			alphabetList.toArray(alphabet);

			transitionTable = new ArrayList<List<Object>>();
			List<Object> row = new ArrayList<Object>();
			row.add(null);
			for (EObject symbol : alphabet) {
				row.add(symbol);
			}
			transitionTable.add(row);
			row = new ArrayList<Object>();
			row.add(initials);
			transitionTable.add(row);
			int index = 0;
			while (index + 1 < transitionTable.size()) {
				List<Object> transitionRow = transitionTable.get(0);
				List<List<EObject>> cells = new ArrayList<List<EObject>>();
				row = transitionTable.get(index + 1);
				for (Object cell : transitionRow) {
					if (cell != null) {
						EObject symbol = (EObject) cell;
						List<EObject> newState = new ArrayList<EObject>();
						for (Object value : row) {
							if (value instanceof List<?>) {
								List<EObject> stateList = (List<EObject>) value;
								for (EObject state : stateList) {
									for (EObject transition : transitions) {
										EObject source = ModelManager.getReference("src", transition);
										if (EMFComparison.equals(state, source) == true) {
											EObject label = ModelManager.getReference("symbol", transition);
											if (EMFComparison.equals(symbol, label) == true) {
												EObject target = ModelManager.getReference("tar", transition);
												List<EObject> closure = new ArrayList<EObject>();
												getStateClosure(target, root, transitions, closure);
												for (EObject tar : closure) {
													if (newState.contains(tar) == false) {
														newState.add(tar);
													}
												}
											}
										}
									}
								}
							}
						}
						cells.add(newState);
					}
				}
				row.addAll(cells);
				for (Object cell : row.subList(1, row.size())) {
					if (cell != null) {
						List<Object> list = (List<Object>) cell;
						if (list.size() > 0) {
							boolean isNew = true;
							for (List<Object> tr : transitionTable.subList(1, transitionTable.size())) {
								if (tr.get(0) != null) {
									List<Object> list2 = (List<Object>) tr.get(0);
									if (compareEObjectLists(list, list2) == true) {
										isNew = false;
										break;
									}
								}
							}
							if (isNew == true) {
								List<Object> newRow = new ArrayList<Object>();
								newRow.add(cell);
								transitionTable.add(newRow);
							}
						}
					}
				}
				index++;
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return transitionTable;
	}

	public void buildDisjoint(List<Object> instance, Object q, HashMap<Object, List<Object>> one, HashMap<Object, List<Object>> two, HashMap<Object, Boolean> included) {
		if (included.get(q) == false) {
			if (q instanceof List<?>) {
				List<Object> qlist = (List<Object>) q;
				boolean found = false;
				for (Object o : instance) {
					if (o instanceof List<?>) {
						List<Object> olist = (List<Object>) o;
						if (compareEObjectLists(qlist, olist)) {
							found = true;
							break;
						}
					}
				}
				if (found == false) {
					instance.add(q);
					included.put(q, true);
					List<Object> entry1 = one.get(q);
					if (entry1 != null) {
						boolean found1 = false;
						for (Object r : entry1) {
							if (r instanceof List<?>) {
								List<Object> rlist = (List<Object>) r;
								for (Object o : instance) {
									if (o instanceof List<?>) {
										List<Object> olist = (List<Object>) o;
										if (compareEObjectLists(rlist, olist)) {
											found1 = true;
											break;
										}
									}
								}
								if (found1 == true) {
									break;
								}
							}
							if (found1 == false) {
								instance.add(r);
								included.put(r, true);
							}
							List<Object> entry2 = two.get(r);
							if (entry2 != null) {
								for (Object s : entry2) {
									buildDisjoint(instance, s, one, two, included);
								}
							}
						}
					}

				}
			}
			else {
				if (!instance.contains(q)) {
					instance.add(q);
					included.put(q, true);
					List<Object> entry1 = one.get(q);
					if (entry1 != null) {
						for (Object r : entry1) {
							if (!instance.contains(r)) {
								instance.add(r);
								included.put(r, true);
							}
							List<Object> entry2 = two.get(r);
							if (entry2 != null) {
								for (Object s : entry2) {
									buildDisjoint(instance, s, one, two, included);
								}
							}
						}
					}
				}
			}
		}
	}

	public boolean compareDFAs(List<List<Object>> dfa1, List<List<Object>> dfa2) {

		// gets alphabet
		List<String> alphabet = new ArrayList<String>();
		for (Object symbol : dfa1.get(0)) {
			if (symbol != null) {
				alphabet.add(ModelManager.getStringAttribute("symbol", (EObject) symbol));
			}
		}
		for (Object symbol : dfa2.get(0)) {
			if (symbol != null) {
				String value = ModelManager.getStringAttribute("symbol", (EObject) symbol);
				if (!alphabet.contains(value)) {
					alphabet.add(value);
				}
			}
		}

		// create sets for each state
		HashMap<String, HashMap<Object, List<Object>>> set = new HashMap<String, HashMap<Object, List<Object>>>();
		HashMap<Object, List<Object>> one = new HashMap<Object, List<Object>>();
		set.put("one", one);
		List<List<Object>> states1 = new ArrayList<List<Object>>();
		for (List<Object> row : dfa1) {
			Object state = row.get(0);
			if (state != null) {
				List<Object> states = new ArrayList<Object>();
				states.add(state);
				one.put(state, null);
				states1.add(states);
			}
		}
		List<List<Object>> states2 = new ArrayList<List<Object>>();
		HashMap<Object, List<Object>> two = new HashMap<Object, List<Object>>();
		set.put("two", two);
		for (List<Object> row : dfa2) {
			Object state = row.get(0);
			if (state != null) {
				List<Object> states = new ArrayList<Object>();
				states.add(state);
				two.put(state, null);
				states2.add(states);
			}
		}

		Stack<List<Object>> stack = new Stack<List<Object>>();
		List<Object> list = new ArrayList<Object>();
		Object s1 = states1.get(0).get(0);
		Object s2 = states2.get(0).get(0);
		list.add(s1);
		list.add(s2);
		stack.push(list);
		List<Object> oneSet = new ArrayList<Object>();
		oneSet.add(s2);
		one.put(s1, oneSet);
		List<Object> twoSet = new ArrayList<Object>();
		twoSet.add(s1);
		two.put(s2, twoSet);

		while (stack.isEmpty() != true) {
			List<Object> pop = stack.pop();
			List<Object> q1 = (List<Object>) pop.get(0);
			List<Object> q2 = (List<Object>) pop.get(1);
			for (String symbol : alphabet) {
				List<Object> r1 = null;
				List<Object> symbols = dfa1.get(0);
				for (List<Object> row : dfa1.subList(1, dfa1.size())) {
					List<Object> t = (List<Object>) row.get(0);
					if (compareEObjectLists(q1, t)) {
						int i = 0;
						for (Object obj : symbols) {
							if (obj != null) {
								EObject label = (EObject) obj;
								String labelValue = ModelManager.getStringAttribute("symbol", label);
								if (symbol.equals(labelValue)) {
									r1 = (List<Object>) row.get(i);
									break;
								}
							}
							i++;
						}
					}
					if (r1 != null) {
						break;
					}
				}
				List<Object> r2 = null;
				symbols = dfa1.get(0);
				for (List<Object> row : dfa2.subList(1, dfa2.size())) {
					List<Object> t = (List<Object>) row.get(0);
					if (compareEObjectLists(q2, t)) {
						int i = 0;
						for (Object obj : symbols) {
							if (obj != null) {
								EObject label = (EObject) obj;
								String labelValue = ModelManager.getStringAttribute("symbol", label);
								if (symbol.equals(labelValue)) {
									r2 = (List<Object>) row.get(i);
									break;
								}
								i++;
							}
						}
					}
					if (r2 != null) {
						break;
					}
				}
				if (compareEObjectLists(r1, r2) == false) {
					list = new ArrayList<Object>();
					list.add(r1);
					list.add(r2);
					boolean push = false;
					oneSet = null;
					if (one.get(r1) == null) {
						oneSet = new ArrayList<Object>();
					}
					else {
						oneSet = one.get(r1);
					}
					if (oneSet.contains(r2) == false) {
						oneSet.add(r2);
						one.put(r1, oneSet);
						push = true;
					}
					twoSet = null;
					if (two.get(r2) == null) {
						twoSet = new ArrayList<Object>();
					}
					else {
						twoSet = two.get(r2);
					}
					if (twoSet.contains(r1) == false) {
						twoSet.add(r1);
						two.put(r2, twoSet);
						push = true;
					}
					if (push == true) {
						stack.push(list);
					}
				}
			}
		}

		List<List<Object>> disjoint = new ArrayList<List<Object>>();
		HashMap<Object, Boolean> included = new HashMap<Object, Boolean>();
		for (Object q : one.keySet()) {
			included.put(q, false);
		}

		for (Object q : one.keySet()) {
			List<Object> instance = new ArrayList<Object>();
			buildDisjoint(instance, q, one, two, included);
			if (instance.size() > 0) {
				boolean found = false;
				for (List<Object> entry : disjoint) {
					if (compareEObjectLists(entry, instance) == true) {
						found = true;
						break;
					}
				}
				if (found == false) {
					disjoint.add(instance);
				}
			}
		}

		for (List<Object> subset : disjoint) {
			boolean isFinal1 = false;
			if (subset.get(0) != null) {
				for (EObject state : (List<EObject>) subset.get(0)) {
					boolean value = ModelManager.getBooleanAttribute("isFinal", state);
					if (value == true) {
						isFinal1 = true;
						break;
					}
				}
			}
			if (subset.size() > 1) {
				for (Object states : subset.subList(1, subset.size())) {
					if (states != null) {
						boolean isFinal2 = false;
						for (EObject state : (List<EObject>) states) {
							if (state != null) {
								boolean value = ModelManager.getBooleanAttribute("isFinal", state);
								if (value == true) {
									isFinal2 = true;
									break;
								}
							}
						}
						if (isFinal1 != isFinal2) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	@Override
	public boolean doCompare(List<String> metamodels, String model1, String model2, IProject project, Class<?> cls) {
		boolean isRepeated = false;
		try {
			//metamodel = "C:\\eclipse\\workspace\\wodel.automata\\models\\DFAAutomaton.ecore";
			//model1 = "C:\\eclipse\\workspace\\wodel.automata\\models\\dfa1.model";
			//model2 = "C:\\eclipse\\workspace\\wodel.automata\\models\\dfa2.model";
			List<EPackage> packages = ModelManager.loadMetaModels(metamodels, cls);
			Resource ndfa1 = ModelManager.loadModel(packages, model1);
			Resource ndfa2 = ModelManager.loadModel(packages, model2);
			//isRepeated = ModelManager.compareModels(resource1, resource2);

			List<List<Object>> dfa1 = convertToDFA(packages, ndfa1);
			List<List<Object>> dfa2 = convertToDFA(packages, ndfa2);

			isRepeated = compareDFAs(dfa1, dfa2);
			try {
				ndfa2.unload();
				ndfa1.unload();
			} catch (Exception e) {
			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRepeated;
	}
}