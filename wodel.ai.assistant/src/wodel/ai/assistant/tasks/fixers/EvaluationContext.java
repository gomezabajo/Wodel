package wodel.ai.assistant.tasks.fixers;

import java.util.*;

public class EvaluationContext {
	private Map<String, Object> data = new LinkedHashMap<>();

	public EvaluationContext(Map<String, Object> inputs) {
		this.data.putAll(inputs);
	}
	
	public Object get(String field) {
		return this.data.get(field);
	}

	public void set(String field, Object value) {
		this.data.put(field, value);
	}
}
