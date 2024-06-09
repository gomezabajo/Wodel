package mutator.wodeltest.testFA;

import wodel.utils.manager.ModelManager;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.exceptions.ReferenceNonExistingException;

public class FAUtils {
	
	public static class FA {
	
		public static class State {
			public String name = "";
			public boolean isInitial = false;
			public boolean isFinal = false;
		}
	
		public static class Symbol {
			public String symbol = "";
		}
	
		public static class Transition {
			public Symbol symbol = null;
			public State src = null;
			public State tar = null;
		}

		public List<State> states = null;
		public List<Symbol> alphabet = null;
		public List<Transition> transitions = null;
		
		public String name = "";
	}

	public static FA fa = null;
	
	public static void loadFA(Resource model) {
		fa = new FA();
		EObject automaton = ModelManager.getRoot(model);
		try {
			List<EObject> states = ModelManager.getReferences("states", automaton);
			List<EObject> alphabet = ModelManager.getReferences("alphabet", automaton);
			List<EObject> transitions = ModelManager.getReferences("transitions", automaton);
			
			fa.name = ModelManager.getStringAttribute("name", automaton);
			for (EObject state : states) {
				if (fa.states == null) {
					fa.states = new ArrayList<FA.State>();
				}
				FA.State st = new FA.State();
				st.name = ModelManager.getStringAttribute("name", state);
				st.isInitial = ModelManager.getBooleanAttribute("isInitial", state);
				st.isFinal = ModelManager.getBooleanAttribute("isFinal", state);
				
				fa.states.add(st);
			}
			
			for (EObject symbol : alphabet) {
				if (fa.alphabet == null) {
					fa.alphabet = new ArrayList<FA.Symbol>();
				}
				FA.Symbol sym = new FA.Symbol();
				sym.symbol = ModelManager.getStringAttribute("symbol", symbol);
				
				fa.alphabet.add(sym);
			}
			
			for (EObject transition : transitions) {
				if (fa.transitions == null) {
					fa.transitions = new ArrayList<FA.Transition>();
				}
				FA.Transition tr = new FA.Transition();

				EObject symbol = ModelManager.getReference("symbol", transition);
				FA.Symbol sym = new FA.Symbol();
				if (symbol != null) {
					sym.symbol = ModelManager.getStringAttribute("symbol", symbol);
				}
				else {
					sym.symbol = "";
				}
				tr.symbol = sym;

				EObject src = ModelManager.getReference("src", transition);
				if (src != null) {
					FA.State st_src = new FA.State();
					st_src.name = ModelManager.getStringAttribute("name", src);
					st_src.isInitial = ModelManager.getBooleanAttribute("isInitial", src);
					st_src.isFinal = ModelManager.getBooleanAttribute("isFinal", src);
					tr.src = st_src;
				}
				
				EObject tar = ModelManager.getReference("tar", transition);
				
				if (tar != null) {
					FA.State st_tar = new FA.State();
					st_tar.name = ModelManager.getStringAttribute("name", tar);
					st_tar.isInitial = ModelManager.getBooleanAttribute("isInitial", tar);
					st_tar.isFinal = ModelManager.getBooleanAttribute("isFinal", tar);
					tr.tar = st_tar;
				}
				
				fa.transitions.add(tr);
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void printState(FA.State state) {
		if (state == null) {
			return;
		}
		System.out.println(state.name + " (" + (state.isInitial ? "initial" : "") + " " + (state.isFinal ? "final" : "") + ")");
	}
	
	private static void printSymbol(FA.Symbol symbol) {
		if (symbol == null) {
			return;
		}
		System.out.println(symbol.symbol);
	}
	
	private static void printTransition(FA.Transition transition) {
		if (transition == null) {
			return;
		}
		System.out.println("Symbol:");
		printSymbol(transition.symbol);
		System.out.println("Source:");
		printState(transition.src);
		System.out.println("Target:");
		printState(transition.tar);
	}
	
	public static void print() {
		if (fa == null) {
			return;
		}
		System.out.println("States--------------------");
		if (fa.states != null) {
			for (FA.State state : fa.states) {
				printState(state);
			}
		}
		System.out.println("Symbols-------------------");
		if (fa.alphabet != null) {
			for (FA.Symbol symbol : fa.alphabet) {
				printSymbol(symbol);
			}
		}
		System.out.println("Transitions---------------");
		if (fa.transitions != null) {
			for (FA.Transition transition : fa.transitions) {
				printTransition(transition);
			}
		}
	}
	
	private static FA.State getInitial() {
		if (fa == null) {
			return null;
		}
		FA.State initial = null;
		if (fa.states != null) {
			for (FA.State state : fa.states) {
				if (state.isInitial) {
					initial = state;
					break;
				}
			}
		}
		
		return initial;
	}
	
	private static List<FA.Transition> getTransitions(FA.State src) {
		if (fa == null || src == null) {
			return null;
		}
		List<FA.Transition> transitions = new ArrayList<FA.Transition>();
		if (fa.transitions != null) {
			for (FA.Transition transition : fa.transitions) {
				if (transition.src != null) {
					if (transition.src.name.equals(src.name)) {
						transitions.add(transition);
					}
				}
			}
		}
		
		return transitions;
	}
	
	private static FA.State process(char c, List<FA.Transition> transitions) {
		if (transitions == null) {
			return null;
		}
		FA.State st = null;
		for (FA.Transition transition : transitions) {
			if (transition.symbol != null) {
				if (String.format("%c", c).equals(transition.symbol.symbol)) {
					st = transition.tar;
					break;
				}
			}
		}
		return st;
	}
	
	public static boolean process(String input) {
		boolean accepted = false;
		if (fa == null) {
			return accepted;
		}
		FA.State state = getInitial();
		List<FA.Transition> transitions = getTransitions(state);
		if (input.length() == 0) {
			accepted = state.isFinal;
		}
		else {
			for (char c : input.toCharArray()) {
				state = process(c, transitions);
				if (state == null) {
					return false;
				}
				transitions = getTransitions(state);
			}
			accepted = state.isFinal;
		}
		return accepted;
	}
}
