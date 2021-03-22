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
		public int index = -1;
	}
	
	public static class Symbol {
		public String symbol = null;
	}
	
	public static class Transition {
		public State src = null;
		public State tar = null;
		public Symbol symbol = null;
	}
	
	private static class Distinguishable {
		private int nStates;
		private int nDistinguishables;
		private boolean[] triangle;
		
		public Distinguishable(int nStates) {
			if (nStates > 0) {
				this.nStates = nStates;
				this.triangle = new boolean[nStates * (nStates - 1) / 2];
			}
		}
		
		public int position(int i, int j) {
			if (j < i && i > 0 && j >= 0) {
				return ((i - 1) * i) / 2 + j;
			}
			return -1;
		}
		
		public boolean get(int i, int j) {
			if (i >= 0 && i < this.nStates) {
				if (j >= 0 && j < this.nStates) {
					if (i == j) {
						return false;
					}
					int position = i < j ? position(j, i) : position(i, j);
					if (this.triangle[position] != false) {
						return true;
					}
				}
			}
			return false;
		}
		
		public void set(int i, int j) {
			if (i >= 0 && i < this.nStates) {
				if (j >= 0 && j < this.nStates) {
					if (i != j) {
						int position = i < j ? position(j, i) : position(i, j);
						if (this.triangle[position] != true) {
							this.triangle[position] = true;
							this.nDistinguishables++;
						}
					}
				}
			}
		}
		
		public int count() {
			return this.nDistinguishables;
		}
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
		
		public boolean process(String value) {
			State current = this.getInitial();
			int count = 0;
			for (char symbol : value.toCharArray()) {
				boolean found = false;
				for (Transition tr : this.transitions) {
					if (tr.src.equals(current) && tr.symbol.symbol.equals("" + symbol)) {
						current = tr.tar;
						found = true;
						break;
					}
				}
				if (found == false) {
					break;
				}
				count++;
			}
			return (count == value.length() && current.isFinal);
		}

		public String toPythonDictionaryString() {
			String dString = "";
			dString += "{";
			DFAUtils.State initial = this.getInitial();
			if (initial != null) {
				dString += initial.index + ":(";
				dString += (initial.isFinal ? "True" : "False") + ",";
				if (this.transitions != null && this.transitions.size() > 0) {
					dString += "{";
					for (DFAUtils.Transition transition : this.transitions) {
						if (transition.src.equals(initial) && transition.symbol != null && transition.tar != null) {
							dString += "'" + transition.symbol.symbol + "'";
							dString += ":";
							dString += transition.tar.index + ",";
						}
					}
					if (dString.endsWith(",")) {
						dString = dString.substring(0, dString.lastIndexOf(","));
					}
					dString += "}),";
				}
				for (DFAUtils.State state : this.states) {
					if (state.equals(initial)) {
						continue;
					}
					dString += state.index + ":(";
					dString += (state.isFinal ? "True" : "False") + ",";
					if (this.transitions != null && this.transitions.size() > 0) {
						dString += "{";
						for (DFAUtils.Transition transition : this.transitions) {
							if (transition.src.equals(state) && transition.symbol != null && transition.tar != null) {
								dString += "'" + transition.symbol.symbol + "'";
								dString += ":";
								dString += transition.tar.index + ",";
							}
						}
						if (dString.endsWith(",")) {
							dString = dString.substring(0, dString.lastIndexOf(","));
						}
						dString += "}),";
					}
				}
				if (dString.endsWith(",")) {
					dString = dString.substring(0, dString.lastIndexOf(","));
				}
			}
			dString += "}";
			return dString;
		}
	}
	
	public static class StatesSet {
		public int contents;
		public boolean[] bits;
		
		public StatesSet(int size) {
			this.bits = new boolean[size];
			this.contents = 0;
		}
		
		public boolean contains(int value) {
			if (this.bits != null && value < this.bits.length && this.bits[value] == true) {
				return true;
			}
			return false;
		}
		public void insert(int value) {
			if (this.bits != null && value < this.bits.length && this.bits[value] == false) {
				this.bits[value] = true;
				this.contents++;
			}
		}
		public void delete(int value) {
			if (this.bits != null && value < this.bits.length && this.bits[value] == true) {
				this.bits[value] = false;
				this.contents--;
			}
		}
		public int compare(StatesSet other) {
			if (this.equals(other)) {
				return 0;
			}
			if (this.contents != other.contents) {
				return -1;
			}
			int size = this.bits.length;
			if (other.bits != null && other.bits.length > size) {
				size = other.bits.length;
			}
			for (int i = 0; i < size; i++) {
				boolean b1 = this.contains(i);
				boolean b2 = other.contains(i);
				if (b1 != b2) {
					return 1;
				}
			}
			return 0;
		}
		public String getStatesSetName(DFAUtils.DFA dfa) {
			String name = "";
			for (int i = 0; i < this.bits.length; i++) {
				if (this.contains(i) == true) {
					name += dfa.states.get(i).name;
				}
			}
			return name;
		}
		
		public int searchStatesSet(StatesSet[] statesSet) {
			for (int i = 0; i < statesSet.length; i++) {
				if (this.compare(statesSet[i]) == 0) {
					return i;
				}
			}
			return -1;
		}
		
		public boolean isFinalStatesSet(DFAUtils.DFA dfa) {
			if (this.bits != null) {
				for (int i = 0; i < dfa.states.size(); i++) {
					if (this.contains(i) == true) {
						if (dfa.states.get(i).isFinal == true) {
							return true;
						}
					}
				}
			}
			return false;
		}
		
		private int nextState(int previous) {
			int r = previous + 1;
			int max = this.bits.length;
			while (r < max && this.contains(r) == false) {
				r++;
			}
			return r;
		}
		
		public boolean isFinal(DFAUtils.DFA dfa, int i) {
			return dfa.states.get(i).isFinal;
		}
		
		public int getTransition(DFAUtils.DFA dfa, int i, int symbol, int acc) {
			int nStates = dfa.states.size();
			if (i == acc) {
				return acc;
			}
			for (int j = this.nextState(-1); j < nStates; j = this.nextState(j)) {
				if (dfa.existsTransition(dfa.states.get(i), dfa.alphabet.get(symbol), dfa.states.get(j)) == true) {
					return j;
				}
			}
			return acc;
		}
		
	
		public int[][] createTransitions(DFAUtils.DFA source, StatesSet[] newStates, int[] cl, int acc) {
			int[][] newTransitions = new int[newStates.length][source.alphabet.size()];
			for (int i = 0; i < newStates.length; i++) {
				int j = newStates[i].nextState(-1);
				for (int l = 0; l < source.alphabet.size(); l++) {
					int tar = this.getTransition(source, j, l, acc);
					if (tar != acc) {
						newTransitions[i][l] = cl[tar];
					}
					else {
						newTransitions[i][l] = -1;
					}
				}
			}
			return newTransitions;
		}
		
		public int createClasses(int nStates, int[] cl, Distinguishable d) {
			int nNewStates = 0;
			
			for (int i = 0; i < nStates; i++) {
				cl[i] = -1;
			}
			for (int i = this.nextState(-1); i < nStates; i = this.nextState(i)) {
				if (cl[i] == -1) {
					for (int j = i; j < nStates; j = this.nextState(j)) {
						if (d.get(i, j) == false) {
							cl[j] = nNewStates;
						}
					}
					nNewStates++;
				}
			}
			return nNewStates;
		}
		
		public StatesSet[] classes2sets(int nStates, int nNewStates, int[] cl) {
			StatesSet[] newStates = new StatesSet[nNewStates];
			for (int i = 0; i < nNewStates; i++) {
				newStates[i] = new StatesSet(nStates);
			}
			for (int i = 0; i < nStates; i++) {
				int c = cl[i];
				if (c != -1) {
					newStates[c].insert(i);
				}
			}
			return newStates;
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
			index = 0;
			for (EObject state : states) {
				State st = new State();
				st.isInitial = ModelManager.getBooleanAttribute("isInitial", state);
				st.isFinal = ModelManager.getBooleanAttribute("isFinal", state);
				st.name = ModelManager.getStringAttribute("name", state);
				st.index = index++;
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
	
	public static StatesSet reachableSet(DFAUtils.DFA dfa) {
		StatesSet statesSet = new StatesSet(dfa.states.size());
		DFAUtils.State initial = dfa.getInitial();
		reachableSetFrom(dfa, statesSet, initial);
		return statesSet;
	}
	
	private static void reachableSetFrom(DFAUtils.DFA dfa, StatesSet statesSet, DFAUtils.State initial) {
		if (statesSet.contains(initial.index) == false) {
			statesSet.insert(initial.index);
			for (int i = 0; i < dfa.alphabet.size(); i++) {
				for (int j = 0; j < dfa.states.size(); j++) {
					if (dfa.existsTransition(initial, dfa.alphabet.get(i), dfa.states.get(j)) == true) {
						reachableSetFrom(dfa, statesSet, dfa.states.get(j));
					}
				}
			}
		}
	}
	
	public static void distinguishFinals(DFAUtils.DFA dfa, int acc, StatesSet statesSet, Distinguishable d) {
		int nStates = dfa.states.size();
		
		for (int i = statesSet.nextState(-1); i < nStates; i = statesSet.nextState(i)) {
			boolean endI = statesSet.isFinal(dfa, i);
			for (int j = statesSet.nextState(i); j <= nStates; j = statesSet.nextState(j)) {
				boolean endJ = false;
				if (j != acc) {
					endJ = statesSet.isFinal(dfa, j);
				}
				if (endI != endJ) {
					d.set(i, j);
				}
			}
		}
	}
	

	public static Distinguishable getDistinguishable(DFAUtils.DFA dfa, StatesSet statesSet) {
		Distinguishable d = new Distinguishable(dfa.states.size() + 1);
		int acc = dfa.states.size();
		distinguishFinals(dfa, acc, statesSet, d);
		int nPairs = 0;
		
		while (nPairs != d.count()) {
			nPairs = d.count();
			for (int i = statesSet.nextState(-1); i < dfa.states.size(); i = statesSet.nextState(i)) {
				for (int j = statesSet.nextState(i); j <= dfa.states.size(); j = statesSet.nextState(j)) {
					if (d.get(i, j) == false) {
						for (int l = 0; l < dfa.alphabet.size(); l++) {
							int tarI = statesSet.getTransition(dfa, i, l, acc);
							int tarJ = statesSet.getTransition(dfa, j, l, acc);
							if (d.get(tarI, tarJ)) {
								d.set(i, j);
								break;
							}
						}
					}
				}
			}
		}
		return d;
	}

	public static DFAUtils.DFA createAutomata(DFAUtils.DFA source, int nStates, StatesSet[] statesSet, int initial, int[][] transitions) {
		DFAUtils.DFA ret = new DFAUtils.DFA();
		String[] names = new String[nStates];
		for (int i = 0; i < nStates; i++) {
			names[i] = statesSet[i].getStatesSetName(source);
			boolean isFinal = statesSet[i].isFinalStatesSet(source);
			DFAUtils.State state = new DFAUtils.State();
			state.index = i;
			state.name = names[i];
			if (i == initial) {
				state.isFinal = source.getInitial().isFinal;
				state.isInitial = true;
			}
			else {
				state.isFinal = isFinal;
				state.isInitial = false;
			}
			ret.states.add(state);
		}
		for (int i = 0; i < source.alphabet.size(); i++) {
			DFAUtils.Symbol symbol = new DFAUtils.Symbol();
			symbol.symbol = source.alphabet.get(i).symbol;
			ret.alphabet.add(symbol);
		}
		for (int i = 0; i < nStates; i++) {
			for (int j = 0; j < ret.alphabet.size(); j++) {
				int end = transitions[i][j];
				if (end != -1) {
					DFAUtils.Transition transition = new DFAUtils.Transition();
					transition.src = ret.states.get(i);
					transition.symbol = ret.alphabet.get(j);
					transition.tar = ret.states.get(end);
					ret.transitions.add(transition);
				}
			}
		}
		return ret;
	}

	public static DFAUtils.DFA getDFA(Distinguishable d, StatesSet statesSet, DFAUtils.DFA source) {
		int nStates = source.states.size();
		int acc = nStates;
		int[] cl = new int[nStates];
		
		for (int i = statesSet.nextState(-1); i < nStates; i = statesSet.nextState(i)) {
			if (d.get(acc, i) == false) {
				statesSet.delete(i);
			}
		}
		int nNewStates = statesSet.createClasses(nStates, cl, d);
		StatesSet[] newStatesSet = statesSet.classes2sets(nStates, nNewStates, cl);
		
		int[][] newTransitions = statesSet.createTransitions(source, newStatesSet, cl, acc);
		int initial = cl[source.getInitial().index];
		DFAUtils.DFA ret = createAutomata(source, nNewStates, newStatesSet, initial, newTransitions);
		
		return ret;
	}

	public static DFAUtils.DFA minimize(DFAUtils.DFA source) {
		StatesSet statesSet = reachableSet(source);
		Distinguishable d = getDistinguishable(source, statesSet);
		DFAUtils.DFA result = getDFA(d, statesSet, source);
		return result;
	}
}
