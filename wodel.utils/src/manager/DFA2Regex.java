package manager;

//import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import com.google.common.collect.ArrayListMultimap;

import wodel.fa2re.Conversor;
//import wodel.jflap.automata.Automaton;
//import wodel.jflap.automata.fsa.FSAToRegularExpressionConverter;
//import wodel.jflap.automata.fsa.FiniteStateAutomaton;
//import manager.DFAUtils.State;
import manager.DFAUtils.Transition;

final public class DFA2Regex {

	public static String toRegExp(DFAUtils.DFA automata) {
		
//		Automaton automaton = new FiniteStateAutomaton();
//		automaton.clear();
		
//		String[] b = new String[automata.states.size()];
//		String[][] a = new String[automata.states.size()][automata.states.size()];
		
//		Map<DFAUtils.State, wodel.jflap.automata.State> states = new HashMap<DFAUtils.State, wodel.jflap.automata.State>();
//		DFAUtils.State initial = automata.getInitial();
//		wodel.jflap.automata.State initialState = new wodel.jflap.automata.State(0, new Point(), automaton);
//		initialState.setName(initial.name);
//		automaton.setInitialState(initialState);
//		automaton.addState(initialState);
//		states.put(initial, initialState);
//
//		int i = 1;
//		for (State state : automata.states) {
//			if (!state.equals(initial)) {
//				wodel.jflap.automata.State st = new wodel.jflap.automata.State(i, new Point(), automaton);
//				st.setName(state.name);
//				st.setLabel(state.name);
//				automaton.addState(st);
//				states.put(state, st);
//				if (state.isFinal) {
//					automaton.addFinalState(st);
//				}
//				i++;
//			}
//		}
//		
//		Map<DFAUtils.Transition, wodel.jflap.automata.fsa.FSATransition> transitions = new HashMap<DFAUtils.Transition, wodel.jflap.automata.fsa.FSATransition>();
//		for (Transition transition : automata.transitions) {
//			wodel.jflap.automata.State from = states.get(transition.src);
//			wodel.jflap.automata.State to = states.get(transition.tar);
//			wodel.jflap.automata.fsa.FSATransition trans = new wodel.jflap.automata.fsa.FSATransition(from, to, transition.symbol.symbol);
//			trans.setFromState(from);
//			trans.setToState(to);
//			automaton.addTransition(trans);
//			transitions.put(transition, trans);
//		}
//		
//		return FSAToRegularExpressionConverter.getExpression(0, i, i, automaton);
		
		Vector<wodel.fa2re.State> states = new Vector<wodel.fa2re.State>();
		int id = 0;
		List<String> order = new ArrayList<String>();
		Map<DFAUtils.State, wodel.fa2re.State> stateMap = new HashMap<DFAUtils.State, wodel.fa2re.State>();
		for (DFAUtils.State state : automata.states) {
			order.add(String.format("%d", id));
			wodel.fa2re.State st = new wodel.fa2re.State(id++, ArrayListMultimap.create(), state.isInitial, state.isFinal);
			stateMap.put(state, st);
			states.add(st);
		}
		for (Transition transition : automata.transitions) {
			wodel.fa2re.State from = stateMap.get(transition.src);
			wodel.fa2re.State to = stateMap.get(transition.tar);
			if (transition.symbol != null && to != null) {
				from.addTransition(transition.symbol.symbol, to.getIdentifier());
			}
		}
		
		wodel.fa2re.Conversor conversor = new wodel.fa2re.Conversor(states, order);
		return Conversor.format(Conversor.minimize(conversor.convert2()));
		
//		List<State> states = new ArrayList<State>();
//		DFAUtils.State initial = automata.getInitial();
//		states.add(initial);
//		for (State state : automata.states) {
//			if (!state.equals(initial)) {
//				states.add(state);
//			}
//		}
//		int i = 0;
//		for (DFAUtils.State state : states) {
//			if (state.isFinal) {
//				b[i] = "lambda";
//			}
//			else {
//				b[i] = "";
//			}
//			i++;
//		}
//		
//		i = 0;
//		for (DFAUtils.State sti : states) {
//			int j = 0;
//			for (DFAUtils.State stj : states) {
//				for (DFAUtils.Symbol symbol : automata.alphabet) {
//					if (automata.existsTransition(sti, symbol, stj)) {
//						a[i][j] = symbol.symbol;
//					}
//					else {
//						a[i][j] = "";
//					}
//				}
//				j++;
//			}
//			i++;
//		}
//		
//		for (int n = states.size() - 1; n >= 0; n--) {
//			b[n] = "(" + a[n][n] + ")*" + b[n];
//			for (int m = 0; m < n; m++) {
//				a[n][m] = "(" + a[n][n] + ")*" + a[n][m]; 
//			}
//			for (int m = 0; m < n; m++) {
//				b[m] += a[m][n] + b[n];
//				for (int k = 0; k < n; k++) {
//					a[m][k] += a[m][n] + a[n][k];
//				}
//			}
//		}
		
//		return b[0];
	}
}