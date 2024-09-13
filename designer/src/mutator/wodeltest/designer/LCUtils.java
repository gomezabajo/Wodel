package mutator.wodeltest.designer;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashSet;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.manager.CircuitUtils;
import wodel.utils.manager.CircuitUtils.LogicalAND;
import wodel.utils.manager.CircuitUtils.LogicalCircuit;
import wodel.utils.manager.CircuitUtils.LogicalInputPin;
import wodel.utils.manager.CircuitUtils.LogicalNOT;
import wodel.utils.manager.CircuitUtils.LogicalNode;
import wodel.utils.manager.CircuitUtils.LogicalOR;

public class LCUtils {
	
	private static LogicalCircuit lc;
	
	public static void loadLC(List<EPackage> packages, Resource model) {
		
		lc = CircuitUtils.convertToLC(packages, model);
	}
	
	private static String process(LogicalNode node, int size, String[] inputs, int index) {
		String output = "";
		if (lc == null || node == null || size <= 0 || inputs == null || index < 0 || index >= inputs.length) {
			return output;
		}
		if (node instanceof LogicalNOT) {
			if (inputs.length > index && inputs[index].equals("1")) {
				output = "0";
			}
			else {
				output = "1";
			}
		}
		if (node instanceof LogicalAND) {
			if (inputs.length > index && inputs[index].equals("1") && inputs.length > index + 1&& inputs[index + 1].equals("1")) {
				output = "1";
			}
			else {
				output = "0";
			}
		}
		if (node instanceof LogicalOR) {
			if ((inputs.length > index && inputs[index].equals("1") && inputs.length > index + 1 && inputs[index + 1].equals("1")) 
				|| (inputs.length > index && inputs[index].equals("0") && inputs.length > index + 1 && inputs[index + 1].equals("1")) 
				|| (inputs.length > index && inputs[index].equals("1") && inputs.length > index + 1 && inputs[index + 1].equals("0"))) {
				output = "1";
			}
			else {
				output = "0";
			}
		}
		return output;
	}
	
	public static boolean process(String input, String expected) {
		if (lc == null || input == null) {
			return false;
		}
		String[] inputs = input.split(""); 
		Set<LogicalNode> prev = new LinkedHashSet<LogicalNode>();
		List<LogicalInputPin> inputPins = lc.getInputPins();
		for (LogicalInputPin inputPin : inputPins) {
			prev.add(lc.getNodeWithInput(inputPin.getName()));
		}
		int index = 0;
		List<String> outputs = new ArrayList<String>();
		for (LogicalNode i : prev) {
			int size = i.getInputPins().size();
			outputs.add(process(i, size, inputs, index));
		}
		Set<LogicalNode> nodes = new LinkedHashSet<LogicalNode>();
		for (LogicalNode p : prev) {
			LogicalNode node = lc.getNextNode(p);
			if (node != null) {
				nodes.add(node);
			}
		}
		while (outputs.size() > 1 && nodes.size() > 0) {
			inputs = new String[outputs.size()];
			outputs.toArray(inputs);
			index = 0;
			outputs = new ArrayList<String>();
			for (LogicalNode n : nodes) {
				int size = n.getInputPins().size();
				outputs.add(process(n, size, inputs, index));
			}
			
			prev = new LinkedHashSet<LogicalNode>();
			prev.addAll(nodes);
			nodes = new LinkedHashSet<LogicalNode>();
			for (LogicalNode p : prev) {
				LogicalNode node = lc.getNextNode(p);
				if (node != null) {
					nodes.add(node);
				}
			}
		}
		boolean accepted = false;
		if (outputs.size() == 1 && outputs.get(0).equals(expected)) {
			accepted = true;
		}
		return accepted;
	}
}
