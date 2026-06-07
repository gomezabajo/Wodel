package wodel.ai.experiments;

import java.util.*;

public class AggregatedResult {	
	private Map<String, List<ExperimentResult>> results = new LinkedHashMap<>();
	
	public void add(String mr, ExperimentResult result) {
		this.results.putIfAbsent(mr, new ArrayList<>());
		this.results.get(mr).add(result);
	}
	
	@Override
	public String toString() {		
		String result = "";
		List<String> orderedKeys = new ArrayList<>(this.results.keySet());
		orderedKeys.sort(null);
		for (String relation: orderedKeys) {
			result += "Relation: "+relation;
			ExperimentResult finalResult = null;
			for (ExperimentResult er : this.results.get(relation)) {
				if (finalResult == null) finalResult = er;
				else finalResult = finalResult.add(er);
			}
			result+=finalResult+"\n";
		}
		return result;
	}
}
