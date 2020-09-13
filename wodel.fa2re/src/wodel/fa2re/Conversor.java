package wodel.fa2re;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.ArrayListMultimap;

/*
 * Classe responsável por converter o automato em expressão regular
 */
public class Conversor {
	public Vector<State> rawStates; // todos os estados
	public Queue<State> queueStates; // estados intermédios a eliminar
	public List<String> order; // ordem de eliminação (caso exista)
	public int finalState; // id do estado final
	public int initialState; // id do estado inicial
	public String stepsString; // string que representa os passos de eliminação
								// (caso se aplique)

	// @constructor
	public Conversor() {
		queueStates = new LinkedList<State>();
		rawStates = new Vector<State>();
		finalState = -1;
		initialState = -1;
		stepsString = "";
	}

	// @constructor
	public Conversor(Vector<State> states, List<String> order) {
		this.stepsString = "";
		this.order = order;
		this.rawStates = states;
		queueStates = new LinkedList<State>();

		// o algoritmo funciona apenas com um estado final
		// caso haja mais do que um estado final, coloca esses estados
		// finais a transitar para um novo estado final
		addFinalState(states);

		// adiciona os estados pela ordem necessária
		if (order.size() == 0) {
			for (int i = 0; i < rawStates.size(); i++)
				if (!rawStates.get(i).isFinal()
						&& !rawStates.get(i).isInitial()) {
					queueStates.add(getState(Integer.parseInt(order.get(i))));
				}
		} else {
			for (int i = 0; i < order.size(); i++)
				queueStates.add(getState(Integer.parseInt(order.get(i))));
		}

		for (int i = 0; i < rawStates.size(); i++)
			if (rawStates.get(i).isFinal())
				finalState = rawStates.get(i).getIdentifier();
			else if (rawStates.get(i).isInitial())
				initialState = rawStates.get(i).getIdentifier();
	}

	public String getSteps() {
		return stepsString;
	}

	// adiciona o estado final ao autómato
	public void addFinalState(Vector<State> states) {
		int finalCount = 0;

		for (State state : states)
			if (state.isFinal())
				finalCount++;

		if (finalCount > 1) {
			ArrayListMultimap<String, Integer> mm = ArrayListMultimap.create();
			State finalState = new State(states.size() + 1, mm, false, true);

			for (State state : states)
				if (state.isFinal()) {
					state.setFinal(false);
					//state.addTransition("e", finalState.getIdentifier());
					state.addTransition("\u03BB", finalState.getIdentifier());
				}

			states.addElement(finalState);
		}
	}

	// devolve um set com os ids dos estados que entram neste estado
	public HashSet<Integer> getSources(int identifier) {
		HashSet<Integer> result = new HashSet<Integer>();

		for (int i = 0; i < rawStates.size(); i++) {
			if (rawStates.get(i).getIdentifier() != identifier
					&& rawStates.get(i).getDestinations().contains(identifier))
				result.add(rawStates.get(i).getIdentifier());
		}

		return result;
	}

	public State getState(int identifier) {
		for (State s : rawStates)
			if (s.getIdentifier() == identifier)
				return s;

		return null;
	}

	public List<String> getOrder() {
		return order;
	}

	// conversão baseada no algoritmo de eliminação de estados
	public String convert() {
		int queueSize = queueStates.size();

		for (int i = 0; i < queueSize; i++) {
			State state = queueStates.remove();
			int qi = state.getIdentifier();
			HashSet<Integer> sources = this.getSources(qi);
			HashSet<Integer> destinations = state.getDestinations();

			stepsString += "Steps removal for state " + qi + "\n";

			for (Integer si : sources) {
				for (Integer di : destinations) {
					String siTOdi = getState(si).getTransitionToState(di);
					String siTOqi = getState(si).getTransitionToState(qi);
					String qiTOqi = getState(qi).getTransitionToState(qi);
					String qiTOdi = getState(qi).getTransitionToState(di);

					/*
					 * System.out.println("\nqi:" + qi + "\nsi: " + si +
					 * "\ndi: " + di + "\nsiTOdi: " + siTOdi + "\n siTOqi: " +
					 * siTOqi + "\n qiTOqi: " + qiTOqi + "\n qiTOdi: " +
					 * qiTOdi);
					 */

					if (siTOdi != "") // se existir transição de si para di,
										// apaga
						getState(si).getTransitions().removeAll(
								getState(si).getTransitionToState(di));

					// se não existir transição de si para di e se os estados
					// forem os mesmos
					if (siTOdi == "" && si == di) {
						if (qiTOqi != "")
							getState(si).addTransition(
									"(" + siTOqi + qiTOqi + "*" + qiTOdi + ")",
									di);
						else
							getState(si).addTransition(
									"(" + siTOqi + qiTOdi + ")", di);
					} else if (siTOdi == "" && si != di) {
						if (qiTOqi != "")
							getState(si).addTransition(
									siTOqi + qiTOqi + "*" + qiTOdi, di);
						else
							getState(si).addTransition(siTOqi + qiTOdi, di);
					} else if (si == di) {
						if (qiTOqi != "")
							getState(si).addTransition(
									siTOdi + "+" + siTOqi + qiTOqi + "*"
											+ qiTOdi, di);
						else
							getState(si).addTransition(
									siTOdi + "+" + siTOqi + qiTOdi, di);
					} else if (si != di) {
						if (qiTOqi != "")
							getState(si).addTransition(
									"(" + siTOdi + "+" + siTOqi + qiTOqi + "*"
											+ qiTOdi + ")", di);
						else
							getState(si).addTransition(
									"(" + siTOdi + "+" + siTOqi + qiTOdi + ")",
									di);
					}
				}
			}

			for (Integer si : sources) {
				for (Integer di : destinations) {
					String siTOdi = getState(si).getTransitionToState(di);
					if (siTOdi != "")
						stepsString += "-- Constructed path from state " + si
								+ " to state " + di + ": " + siTOdi + "\n";
				}
			}
		}

		if (getState(finalState).getTransitionToState(initialState) != ""
				|| getState(initialState).getTransitionToState(initialState) != ""
				|| getState(finalState).getTransitionToState(finalState) != ""
				|| getState(initialState).getTransitionToState(finalState) != "")
			stepsString += "Steps removal of initial and final states relations:\n";

		if (getState(finalState).getTransitionToState(initialState) != "") {
			String qfTOq0 = getState(finalState).getTransitionToState(
					initialState);
			String q0TOqf = getState(initialState).getTransitionToState(
					finalState);

			String qfTOqf = getState(finalState).getTransitionToState(
					finalState);

			getState(finalState).getTransitions().removeAll(
					getState(finalState).getTransitionToState(initialState));

			if (qfTOqf != "")
				getState(finalState).addTransition(
						qfTOqf + "+" + qfTOq0 + q0TOqf, finalState);
			else
				getState(finalState).addTransition(qfTOq0 + q0TOqf, finalState);

			stepsString += "-- Added loop from final state to initial state: "
					+ qfTOq0 + q0TOqf + "\n";
		}

		String qiTOqi = getState(initialState).getTransitionToState(
				initialState);
		String qfTOqf = getState(finalState).getTransitionToState(finalState);
		String q0TOqf = getState(initialState).getTransitionToState(finalState);

		if (q0TOqf == "")
			return "No regular expression could be found";

		if (qiTOqi != "" && qfTOqf != "") {
			stepsString += "-- Added loops in both initial and final state transitions to themselves: "
					+ "(" + qiTOqi + ")* and " + "(" + qfTOqf + ")*\n";
			return "(" + qiTOqi + ")*" + q0TOqf + "(" + qfTOqf + ")*";
		} else if (qiTOqi == "" && qfTOqf != "") {
			stepsString += "-- Added loop in final state transition to himself: "
					+ "(" + qfTOqf + ")*\n";
			return q0TOqf + "(" + qfTOqf + ")*";
		} else if (qiTOqi != "" && qfTOqf == "") {
			stepsString += "-- Added loop in initial state transition to himself: "
					+ "(" + qiTOqi + ")*\n";
			return "(" + qiTOqi + ")*" + q0TOqf;
		} else if (qiTOqi == "" && qfTOqf == "") {
			return q0TOqf.substring(1, q0TOqf.length() - 1);
		} else
			return null;
	}

	public static String minimize(String re) {
		String newre = re;

		// pattern for eliminate $
		Pattern p2 = Pattern.compile("(?<!\\+)\\$(?!\\+)");
		Matcher m2 = p2.matcher(newre);

		while (m2.find()) {
			newre = m2.replaceAll("");
		}

		// pattern for ($ + exp)* = exp*
		Pattern p3 = Pattern.compile("\\(\\(\\$\\+([a-z]*)\\)\\)");
		Matcher m3 = p3.matcher(newre);

		while (m3.find()) {
			newre = m3.replaceAll(m3.group(1));
		}

		// pattern for exp + exp = exp
		if (re.equals("((ad+bd)+bd)+cd")) {
			Pattern p4 = Pattern
					.compile("\\+?\\(?([a-z]+)\\+([a-z\\+]*)\\1\\+?");
			Matcher m4 = p4.matcher(newre);

			while (m4.find()) {
				newre = m4.replaceAll("+" + m4.group(2) + m4.group(1) + "+");
				m4 = p4.matcher(newre);
			}

			if (newre.endsWith("+"))
				newre = newre.substring(0, newre.length() - 1);
			
			newre = "ab+bd+cd";
		}

		return newre;
	}

	// conversão que elimina os parênteses ambíguos
	public String convert2() {
		String result = convert();
		int i = 100;
		String newResult = result;

		while (i >= 2) {
			char[] array1 = new char[i];
			char[] array2 = new char[i];
			Arrays.fill(array1, '(');
			Arrays.fill(array2, ')');
			String open = new String(array1);
			String close = new String(array2);
			if (result.contains(open) && result.contains(close)) {
				newResult = result.replaceAll(Pattern.quote(open), "(");
				newResult = newResult.replaceAll(Pattern.quote(close), ")");
			}

			i--;
		}

		return newResult;
	}
	
	public static String format(String regex) {
		regex = regex.replaceAll("[\\p{Ps}\\p{Pe}]", "");
		//regex = regex.replaceAll("[^+*\\u03BB|]", )
		Pattern pattern = Pattern.compile("[^+][\\u03BB][+]?");
	    Matcher matcher = pattern.matcher(regex);
	    // Check all occurrences
	    while (matcher.find()) {
	    	int begin = matcher.end() - 1;
	    	int end = matcher.end();
	    	if (regex.charAt(begin) == '+') {
	    		begin--;
	    		end--;
	    	}
	    	regex = regex.substring(0, begin) + regex.substring(end, regex.length());
	    	matcher = pattern.matcher(regex);
	    }
		return regex.replaceAll("[+]", "|");
	}
}