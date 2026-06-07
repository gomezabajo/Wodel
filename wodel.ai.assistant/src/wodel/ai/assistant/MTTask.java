package wodel.ai.assistant;

import java.util.*;
import java.util.stream.Collectors;

import wodel.ai.assistant.tasks.Parameter;

public abstract class MTTask {
	// To reflectively know which parameters are required 
	protected Map<Parameter, Object> requiredParams = new LinkedHashMap<>();
	protected String id;
	protected String description;
	//protected static List<MTTask> taskRegistry = new ArrayList<>();
		
	public MTTask() {
		this.id = this.getClass().getSimpleName();
	}
	
	public MTTask(String desc) {
		this();
		this.description = desc;
	}
		
	public Collection<Parameter> requiredParameters() {
		return this.requiredParams.keySet();
	}
	
	public Collection<Parameter> userParameters() {
		return this.requiredParameters()
				.stream()
				.filter(p ->p.userProvided())
				.collect(Collectors.toList());
	}
	
	public Object getParameter(String paramName) {
		for (Parameter p: this.requiredParams.keySet()) {
			if (p.name().equalsIgnoreCase(paramName)) 
				return this.requiredParams.get(p);
		}
		return null;
	}
	
	public boolean withParameter(String param, Object value) {
		for (Parameter p: this.requiredParams.keySet()) {
			if (p.name().equalsIgnoreCase(param)) {
				this.requiredParams.put(p, value);
				return true;
			}
		}
		return false;
	}
	
	public String canExecute() {		
		if (!this.requiredParams.values().contains(null)) return null;
		String result = "";
		boolean first = true;
		for (Parameter p: this.requiredParams.keySet()) {
			if (this.requiredParams.get(p)==null) {
				if (!first) result += ",";
				result+= p.name();
				first = false;
			}
		}
		return result;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public String toString() {
		return "Task "+this.id+": "+this.getDescription();
	}
	
	public String getUsageDescription() {
		String desc = "";
		if (!this.requiredParameters().isEmpty()) 
			for (Parameter p: this.requiredParameters())
				if (p.userProvided())
					desc += "\n- "+p; 			
		return desc;
	}
	
	public boolean hasUserParams() {
		for (Parameter p: this.requiredParameters())
			if (p.userProvided()) return true;
		return false;
	}

	public String getId() {
		return this.id;
	}

	public abstract Object executeWithInput(String params) throws Exception;

	public void withParameters(Map<String, Object> params) {
		for (String param: params.keySet())
			this.withParameter(param, params.get(param));
	} 
}
