package wodel.ai.assistant.chat;

import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.tasks.fixers.LLMResponse;

/**
 * A class that extracts required parameters from a user utterance
 * @author jdelara
 *
 */
public class ParameterExtractor extends AssistantAgent {
	private MTTask task;

	public ParameterExtractor(MTTask task) {
		this.systemPrompt= 
				"""
						You are an assistant for metamorphic testing (MT). Your task is to extract the value of the following parameters
						of the user utterance below:
						{parameters}

						Notes:
						- Extract the values in a JSON dictionary, with keys the parameter name, and value, the extracted value
						- If some value is not present, add the value None/null to the dictionary
						- The user may use abbreviations like MR for metamorphic relation
						- The user may refer to Gotten, a metamorphic testing environment the assistant is integrated with

						User utterance: 
						{user_utterance}
						""";		
		this.task = task;
	}

	public Map<String, Object> getParameters(String userUtterance) {
		String prompt = this.buildPrompt(userUtterance);		
		this.llmClient
			.withModel("gpt-4.1-mini")
			.withTemperature(0);
		try {
			LLMResponse resp = this.llmClient.sendPrompt(prompt, true);
			System.out.println("Parameter checker response: "+resp.getJson());			
			return this.parseResult(resp);
		} catch (Exception e) {			
			return null;
		}	
	}

	private Map<String, Object> parseResult(LLMResponse resp) {
	    Map<String, Object> result = new LinkedHashMap<>();
	    JSONObject jso = resp.getJson();

	    if (jso != null) {
	        Iterator<String> keys = jso.keys();
	        while (keys.hasNext()) {
	            String key = keys.next();
	            Object value = null;
				try {
					value = jso.get(key);
				} catch (JSONException e) {					
				}

	            if (value instanceof JSONObject) {
	                value = toMap((JSONObject) value);
	            } else if (value instanceof org.json.JSONArray) {
	                value = toList((org.json.JSONArray) value);
	            } 
	            	if (value!=null && value.toString().equals("null"))
	            		result.put(key, null);
	            	else result.put(key, value);
	        }
	    }

	    return result;
	}

	private Map<String, Object> toMap(JSONObject jso) {
	    Map<String, Object> map = new LinkedHashMap<>();
	    Iterator<String> keys = jso.keys();
	    while (keys.hasNext()) {
	        String key = keys.next();
	        Object value = null;
			try {
				value = jso.get(key);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if (value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        } else if (value instanceof org.json.JSONArray) {
	            value = toList((org.json.JSONArray) value);
	        }
	        map.put(key, value);
	    }
	    return map;
	}

	private List<Object> toList(org.json.JSONArray arr) {
	    List<Object> list = new ArrayList<>();
	    for (int i = 0; i < arr.length(); i++) {
	        Object value = null;
			try {
				value = arr.get(i);
			} catch (JSONException e) {
				
			}
	        if (value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        } else if (value instanceof org.json.JSONArray) {
	            value = toList((org.json.JSONArray) value);
	        }
	        list.add(value);
	    }
	    return list;
	}

	private String buildPrompt(String userUtterance) {
		String prompt = this.systemPrompt.replace("{parameters}", this.task.getUsageDescription());
		prompt = prompt.replace("{user_utterance}", userUtterance);
		return prompt;
	}
}
