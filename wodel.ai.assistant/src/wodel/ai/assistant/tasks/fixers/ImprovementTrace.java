package wodel.ai.assistant.tasks.fixers;

import java.util.*;

/*** 
 * Singleton to trace fixer execution results
 * @author jdelara
 *
 */
public class ImprovementTrace {
	private List<FixerTrace> traces = new ArrayList<>();
	private Map<String, List<FixerTrace>> classifiedTraces = new LinkedHashMap<>();
	private static final ImprovementTrace instance = new ImprovementTrace();
	
	private ImprovementTrace() {}
	
	public static ImprovementTrace getInstance() {
		return instance;
	}
	
	public void addTrace(String fixerName, Object ...state) {
		FixerTrace ft = new FixerTrace(fixerName, state);
		this.traces.add(ft);
		this.classifiedTraces.putIfAbsent(fixerName, new ArrayList<>());
		this.classifiedTraces.get(fixerName).add(ft);
	}
	
	public List<FixerTrace> getTracesFrom(String emmitter) {
		if (!this.classifiedTraces.containsKey(emmitter)) return Collections.emptyList();
		return this.classifiedTraces.get(emmitter);
	}
	
	public void reset() {
		this.traces.clear();
		this.classifiedTraces.clear();
	}
	
	public String toString() {
		return this.traces.toString();
	}
}
