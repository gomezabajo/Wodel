package wodel.ai.assistant.tasks.fixers;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class LLMResponse {
	private String prompt;
	private String rawResponse;
	private String jsonResponse;
	private JSONObject jsonObject;
	private Object code;
	private Object explanation;
	private String userInput;
	
	public LLMResponse(String prompt, String response) {
		this.prompt = prompt;
		this.rawResponse = response;
	}
	
	public String getResponse( ) {
		return this.rawResponse;
	}
	
	public String getCode() {
		if (this.code == null) this.extractCode();
		return this.code==null? "": this.code.toString();
	}

	public String getExplanation() {
		if (this.explanation == null) this.extractExplanation();
		return this.explanation.toString();
	}
	
	public Object extract(String key) {
		try {
			this.extractJson();
			if (this.jsonObject != null) {
				if (jsonObject.has(key))
					return jsonObject.get(key);
			}
		} catch (JSONException e) {
			return null;
		}
		return null;
	}

	private void extractCode() {
		if (this.code==null) 
			this.code = this.extract("code");		
	}
	
	private void extractExplanation() {
		if (this.explanation==null)
			this.explanation = this.extract("explanation");	
	}
	
	private void extractJson() throws JSONException {
		if (this.jsonObject!=null) 
			return;
		
		boolean bException = false;
		if (this.jsonResponse == null) {
			try
			{
				String startPattern = "```json";
				String endPattern = "```";		
				
				extractJson(startPattern, endPattern);
			}
			catch(Exception e)
			{
				bException = true;
			}
			
			//Re-try with other pattern: used for example to create MM
			if(bException)
			{
				try
				{
					extractJson("```", "```");
				}
				catch(Exception e)
				{
					bException = true;
					throw new JSONException("Exception while extracting json: "+e.getMessage());
				}
			}
		}
	}
	private void extractJson(String startPattern, String endPattern) throws JSONException
	{
		//System.out.println(rawResponse);
		
		int index = this.rawResponse.indexOf(startPattern);
		if(index != -1)
		{
			this.jsonResponse = this.rawResponse.substring(index+startPattern.length());
			this.jsonResponse = jsonResponse.substring(0, jsonResponse.indexOf(endPattern));
			
		}
		else
		{
			this.jsonResponse = this.rawResponse;
		}
		this.jsonObject = new JSONObject(this.jsonResponse);
	}
	public String toString() {
		String separator = "\n--------------------------------------------------\n";
		//return "Raw:"+separator+this.rawResponse+"\n\nCode"+separator+this.getCode()+"\n\nExp:"+separator+this.getExplanation();
		return "Code"+separator+this.getCode()+"\n\nExp:"+separator+this.getExplanation();
	}
	
	public String serialize() {
		return "UserInput:" + this.userInput+"\n\n"+this.toString();
	}
	
	public String serialize(String filePath) {
		String contentToAppend = this.serialize();
		try (FileWriter fileWriter = new FileWriter(filePath, true)) { // 'true' enables append mode
            fileWriter.write(contentToAppend);            
        } catch (IOException e) {
            System.err.println("An error occurred while appending to the file: " + e.getMessage());
        }
		return contentToAppend;
	}

	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	public JSONObject getJson() {
		if (this.jsonObject==null)
			try {
				this.extractJson();
			} catch (JSONException e) {				
			}
		return this.jsonObject;
	}
}
