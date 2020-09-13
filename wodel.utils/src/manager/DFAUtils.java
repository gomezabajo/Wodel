package manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import exceptions.ReferenceNonExistingException;

public class DFAUtils {
	
	public static class State {
		public String name = null;
		public boolean isInitial = false;
		public boolean isFinal = false;
	}
	
	public static class Symbol {
		public String symbol = null;
	}
	
	public static class Transition {
		public State src = null;
		public State tar = null;
		public Symbol symbol = null;
	}
	public static class DFA {
		public List<State> states = new ArrayList<State>();
		public List<Transition> transitions = new ArrayList<Transition>();
		public List<Symbol> alphabet = new ArrayList<Symbol>();
		
		public State getInitial() {
			State initial = null;
			for (State state : states) {
				if (state.isInitial) {
					initial = state;
					break;
				}
			}
			return initial;
		}
		
		public boolean existsTransition(State src, Symbol symbol, State tar) {
			boolean existsTransition = false;
			for (Transition transition : transitions) {
				if (transition.src.equals(src) && transition.symbol.symbol.equals(symbol.symbol) && transition.tar.equals(tar)) {
					existsTransition = true;
					break;
				}
			}
			return existsTransition;
		}
	}
	
	private static void getStateClosure(EObject initial, EObject root, EObject[] transitions, List<EObject> closure) {
		try {
			if (!closure.contains(initial)) {
				closure.add(initial);
				for (EObject transition : transitions) {
					EObject source = ModelManager.getReference("src", transition);
					if (EcoreUtil.equals(initial, source)) {
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
	
	private static boolean compareEObjectLists(List<Object> l1, List<Object> l2) {
		if (l1 != null && l2 != null) {
			if (l1.size() == l2.size()) {
				HashMap<Object, Boolean> found = new HashMap<Object, Boolean>();
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
										if (EcoreUtil.equals(eo1, eo2)) {
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
								if (EcoreUtil.equals((EObject) o1, (EObject) o2)) {
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
	
	public static DFA convertToDFA(List<EPackage> packages, Resource ndfa) {
		DFA dfa = new DFA();
		try {
			List<List<Object>> transitionTable = null;
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
										if (EcoreUtil.equals(state, source)) {
											EObject label = ModelManager.getReference("symbol", transition);
											if (EcoreUtil.equals(symbol, label)) {
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
			for (EObject state : states) {
				State st = new State();
				st.isInitial = ModelManager.getBooleanAttribute("isInitial", state);
				st.isFinal = ModelManager.getBooleanAttribute("isFinal", state);
				st.name = ModelManager.getStringAttribute("name", state);
				dfa.states.add(st);
			}
			for (EObject symbol : alphabet) {
				Symbol sym = new Symbol();
				sym.symbol = ModelManager.getStringAttribute("symbol", symbol);
				dfa.alphabet.add(sym);
			}
			for (EObject transition : transitions) {
				Transition t = new Transition();
				EObject src = ModelManager.getReference("src", transition);
				EObject tar = ModelManager.getReference("tar", transition);
				EObject symbol = ModelManager.getReference("symbol", transition);
				String srcName = null;
				if (src != null) {
					srcName = ModelManager.getStringAttribute("name", src);
				}
				String tarName = null;
				if (tar != null) {
					tarName = ModelManager.getStringAttribute("name", tar);
				}
				String symName = null; 
				if (symbol != null) {
					symName = ModelManager.getStringAttribute("symbol", symbol);
				}
				State sr = null;
				if (srcName != null) {
					for (State st : dfa.states) {
						if (st.name.equals(srcName)) {
							sr = st;
							break;
						}
					}
				}
				State tr = null;
				if (tarName != null) {
					for (State st : dfa.states) {
						if (st.name.equals(tarName)) {
							tr = st;
							break;
						}
					}
				}
				Symbol sym = null;
				if (symName != null) {
					for (Symbol sy : dfa.alphabet) {
						if (sy.symbol.equals(symName)) {
							sym = sy;
							break;
						}
					}
				}
				t.src = sr;
				t.tar = tr;
				t.symbol = sym;
				dfa.transitions.add(t);
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dfa;
		
		//return transitionTable;
	}
}
