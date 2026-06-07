package wodel.ai.assistant;

import java.util.*;

import wodel.ai.assistant.tasks.Parameter;
import wodel.ai.assistant.tasks.fixers.EvaluationContext;
import wodel.ai.assistant.tasks.fixers.LLMResponse;
import wodel.ai.assistant.tasks.fixers.TaskQualityEvaluationResult;

public class MTWorkflow extends AITask {
	private List<MTTask> tasks = new ArrayList<>();
	
		
	public MTWorkflow(Collection<? extends MTTask> tasks) {
		this.tasks.addAll(tasks);
	}
	
	public boolean withParameter(String param, Object value) {
		boolean result = super.withParameter(param, value); // needed?
		for (MTTask t: this.tasks) { // pass parameters to subtasks
			boolean rslt = t.withParameter(param, value);
			result = rslt || result;
		}
		return result;
	}
	
	@Override
	public String canExecute() {		
		String res = null;
		for (MTTask t: this.tasks) {
			String canExec = t.canExecute();
			if (canExec!=null) {
				if (res==null) res = canExec;
				else res+=", "+canExec;
			}
		}
		return res;		
	}
	
	@Override
	public String getDescription() {
		String desc = "";
		boolean first = true;
		for (MTTask t: this.tasks) {
			if (!first)
				desc += " and "+t.getDescription();
			else 
				desc += t.getDescription();
			first = false;
		}
		return desc;
	}
	
	public Collection<Parameter> requiredParameters() {
		Set<Parameter> params = new LinkedHashSet<>();
		for (MTTask mt: this.tasks) 
			params.addAll(mt.requiredParameters());		
		return params;
	}
	
	public Object executeWithInput(String userInput) throws Exception {	
		List<Object> outputs = new ArrayList<>();
		for (MTTask task: this.tasks) {
			System.out.println("Executing task "+task);
			outputs.add(task.executeWithInput(userInput));		// ? does this make sense
		}
		return outputs; // does this make sense?
	}

	@Override
	public LLMResponse fix(TaskQualityEvaluationResult result, EvaluationContext evalContext) {
		// TODO Auto-generated method stub
		return null;
	}
}
