package wodel.ai.assistant.chat;

import java.util.*;

import wodel.ai.assistant.*;
import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.tasks.fixers.LLMResponse;

/**
 * Classifies the intent of the user into one of the available tasks, or none
 * @author jdelara
 *
 */
public class PlannerAgent extends AssistantAgent{
	public List<MTTask> registeredTasks = new ArrayList<>();
	
	public PlannerAgent() {
		/*this.systemPrompt= 
				"""
				You are an assistant for metamorphic testing (MT). Your task is to classify the intent of the user utterance below into one of the following
				tasks:
				{tasks}

				return ONLY one word: the task name, or if none of the task apply, return "None".

				Notes:
				- The user may use abbreviations like MR for metamorphic relation
				- The user may refer to Gotten, a metamorphic testing environment the assistant is integrated with

				User utterance: 
				{user_utterance}
				""";*/	
		this.systemPrompt= 
				"""
				You are an assistant for metamorphic testing (MT). Your task is to classify the intent of the user utterance below into one of the following
				or more tasks:
				{tasks}

				Instructions:
				- If the user only wants to perform one task, return ONLY one word: the task name
				- If none of the task apply, return "None"
				- If the user wants to perform more than one task in sequence, return the task names separated by ";"

				Notes:
				- The user may use abbreviations like MR for metamorphic relation
				- The user may refer to Gotten, a metamorphic testing environment the assistant is integrated with

				User utterance: 
				{user_utterance}
				""";
		this.registeredTasks.addAll(AITaskProvider.getInstance().getSupportedTasks());
	}
	
	public PlannerAgent(ITaskProvider... providers) {
		this();
		for (ITaskProvider provider: providers)
			this.registeredTasks.addAll(provider.getSupportedTasks());
	}
	
	/**
	 * Return the registered MTTask that the user wants to perform
	 * @param userUtterance
	 * @return
	 */
	public MTTask getIntent(String userUtterance) {
		String prompt = this.buildPrompt(userUtterance);
		this.llmClient
			.withModel("gpt-4.1-mini")
			.withTemperature(0);
		try {
			LLMResponse resp = this.llmClient.sendPrompt(prompt, true);
			return this.findTask(resp);
		} catch (Exception e) {			
			return null;
		}		
	}

	private MTTask findTask(LLMResponse resp) {		
		String response = resp.getResponse();
		System.out.println("[Intent classifier] Raw response: "+response);
		if (response.equalsIgnoreCase("None") || response.equalsIgnoreCase("\"None\""))
			return null;
		
		String[] taskNames = response.split(";");
		Map<String, MTTask> tasks = new LinkedHashMap<>();
		for (String t: taskNames)
			tasks.put(t, null);
		
		// 1st attempt exact match
		for (String taskName: taskNames)
			for (MTTask t : this.registeredTasks) 
				if (t.getId().equalsIgnoreCase(taskName.trim())) {
					tasks.put(taskName, t);
					break;
				}
			
		if (!tasks.values().contains(null)) {
			if (tasks.size()==1) return new ArrayList<>(tasks.values()).get(0);
			else return new MTWorkflow(tasks.values());
		}			
		
		response = response.toLowerCase();
		// 2nd round: fuzzy matching
		for (String taskName: taskNames) {
			if (tasks.get(taskName)!=null) continue;
			for (MTTask t : this.registeredTasks) 			
				if (taskName.contains(t.getId().toLowerCase())) { 
					tasks.put(taskName, t);
					break;
				}
		}
		
		return null;
	}

	private String buildPrompt(String utterance) {
		String tasks = "";
		for (MTTask task: this.registeredTasks)
			tasks += "\n - "+task;
		String prompt = systemPrompt.replace("{tasks}", tasks);
		prompt = prompt.replace("{user_utterance}", utterance);
		return prompt;
	}
}
