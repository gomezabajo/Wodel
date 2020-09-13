package wodel.fa2re;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;

import com.google.common.collect.ArrayListMultimap;

/*
 * Classe responsável por criar um Estado de um autómato.
 * Contém um identificador, um único estado inicial e final e as transições
 * para outro estado. O uso de um multimap permite aceitar NFAs (transições
 * para estados diferentes dada a mesma entrada).
 */
public class State {
	private int identifier;
	private boolean finalState, initialState;
	private ArrayListMultimap<String, Integer> transitions;

	public State(int identifier,
			ArrayListMultimap<String, Integer> transitions, boolean isInitial,
			boolean isFinal) {
		this.identifier = identifier;
		this.transitions = transitions;
		this.finalState = isFinal;
		this.initialState = isInitial;
	}

	// multimap permite aceitar NFAs
	public ArrayListMultimap<String, Integer> getTransitions() {
		return transitions;
	}

	public void addTransition(String s, Integer i) {
		transitions.put(s, i);
	}

	public boolean isFinal() {
		return finalState;
	}

	public boolean isInitial() {
		return initialState;
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setFinal(boolean finalState) {
		this.finalState = finalState;
	}

	// devolve a transição (label) do estado para outro estado destino
	public String getTransitionToState(Integer destination) {
		Vector<String> keys = new Vector<String>();

		for (Map.Entry<String, Integer> entry : transitions.entries()) {
			if (entry.getValue().equals(destination)) {
				keys.add(entry.getKey());
			}
		}

		String result = "";

		if (keys.size() > 1) {
			for (int i = 0; i < keys.size(); i++)
				if (i == 0)
					result = "(" + keys.get(i);
				else if (i != keys.size() - 1)
					result += "+" + keys.get(i);
				else
					result += "+" + keys.get(i) + ")";
		} else if (keys.size() == 1)
			result += keys.get(0);

		/*if (destination == 4 && this.getIdentifier() == 4)
			System.out.println(result);*/
		
		return result;
	}

	public HashSet<Integer> getDestinations() {
		Collection<Integer> values = transitions.values();
		HashSet<Integer> result = new HashSet<Integer>();

		for (Integer i : values)
			if (i != identifier)
				result.add(i);

		return result;
	}

	public String toString() {
		String result;

		result = "Identifier: " + identifier;
		result += "\n isFinal: " + finalState;
		result += "\n isInitial: " + initialState;
		result += "\n transitions: " + transitions;

		return result;
	}
}