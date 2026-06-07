package wodel.ai.assistant.llm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.framework.Bundle;

import wodel.ai.assistant.utils.AssistantUtils;
import wodel.dsls.ui.customize.WodelGeneralPreferencePage;
//import org.osgi.framework.Bundle;
import wodel.ai.assistant.tasks.fixers.LLMResponse;

public class GPTClient {
	private static final String API_URL = "https://api.openai.com/v1/chat/completions";
	private String apiKey;
	private String model ="gpt-4";
	private double temperature = 0.7;
	private boolean verbose;
	//private static List<String> modelsWithNoTemperature = List.of("gpt-5", "o4-mini");

	public GPTClient(String key) {
		this.apiKey = key;
	}

	public GPTClient() {
		this.apiKey = this.readOpenAIKey();
	}

	public GPTClient withModel(String model) {
		this.model = model;
		return this;
	}

	public GPTClient withTemperature(double temp) {
		this.temperature = temp;
		return this;
	}

	private boolean supportsTemperature() {    	
		if (this.model.contains("gpt-5")) return false;
		if (this.model.equals("o4-mini")) return false;
		return true;
	}

	private String buildPromptJSONMessage(String prompt) {
		String jsonBody = "{"
				+ "\"model\":\""+this.model+"\","
				+ "\"messages\":[{\"role\":\"user\",\"content\":\"" + prompt + "\"}]";
		if (this.supportsTemperature()) 
			jsonBody += ","
					+ "\"temperature\":"+this.temperature;
		//jsonBody += ",\"max_completion_tokens\":16384";	// added because o4-mini truncates long outputs
		jsonBody += "}";
		return jsonBody;
	}

	public LLMResponse sendPrompt(String prompt, boolean escape) throws Exception {
		if (escape) prompt = AssistantUtils.escapeJson(prompt);
		return this.sendPrompt(prompt);
	}

	public LLMResponse sendPrompt(String prompt) throws Exception {
		String jsonBody = this.buildPromptJSONMessage(prompt);

		if (this.verbose) 
			System.out.println("JSON:\n"+jsonBody);

		URL url = new URL(API_URL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", "Bearer " + this.apiKey);
		connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		connection.setDoOutput(true); // Enable output for POST body

		try (OutputStream os = connection.getOutputStream()) {
			byte[] input = jsonBody.getBytes(StandardCharsets.UTF_8);
			os.write(input, 0, input.length);
		}

		int responseCode = connection.getResponseCode();
		InputStream is = (responseCode < HttpURLConnection.HTTP_BAD_REQUEST)
				? connection.getInputStream() // Success 
						: connection.getErrorStream(); // Error 

		String response = extractResponse(is);

		connection.disconnect();

		if (responseCode != HttpURLConnection.HTTP_OK) {
			throw new Exception("Error from OpenAI API: " + response.toString());
		}

		return new LLMResponse(prompt, this.extractContent(response));
	}

	private String extractResponse(InputStream is) throws IOException {
		StringBuilder response = new StringBuilder();
		try (InputStream stream = is) {
			int bytesRead;
			byte[] buffer = new byte[1024];
			while ((bytesRead = stream.read(buffer)) != -1) {
				response.append(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
			}
		}
		return response.toString();
	}

	private String extractContent(String jsonString) {		
		try {
			JSONObject jsonObject = new JSONObject(jsonString);

			// Navigate to the "choices" array
			JSONArray choicesArray = jsonObject.getJSONArray("choices");

			// Get the first element of the "choices" array (TODO: take others?)
			JSONObject choice = choicesArray.getJSONObject(0);

			// Navigate to "message" and then "content"
			JSONObject message = choice.getJSONObject("message");
			String content = message.getString("content");

			return content;
		} catch (Exception e) {
			e.printStackTrace();
			return "Error parsing JSON or extracting content.";
		}
	}

	/**
	private String readOpenAIKey() {
		Properties properties = new Properties();
		try (FileInputStream fis = new FileInputStream("keys.properties")) {
			properties.load(fis);
			String openAIKey = properties.getProperty("OPENAI_API_KEY");
			return openAIKey;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	**/

	private String readOpenAIKey() {
		String openAPIKeyPreference = WodelGeneralPreferencePage.PREF_GPT_API_KEY;
		
		String apiKey = Platform.getPreferencesService().getString("gotten.dsls.Gotten", openAPIKeyPreference, "", null);
		if (apiKey != null && apiKey.length() > 0) {
			return apiKey;
		}
		
    	Properties properties = new Properties();
		Bundle bundle = Platform.getBundle("wodel.ai.assistant");
		URL keysPropertiesURL = bundle.getEntry("/keys.properties");
		try {
			String keysProperties = FileLocator.resolve(keysPropertiesURL).getFile();
			if (keysProperties.contains(":") && keysProperties.startsWith("/")) {
				keysProperties = keysProperties.substring(1);
			}
			FileInputStream fis = new FileInputStream(Paths.get(keysProperties).toFile());
            properties.load(fis);
            String openAIKey = properties.getProperty("OPENAI_API_KEY");
            return openAIKey;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

	public void setVerbose(boolean v) {
		this.verbose = v;
	}

	public double getTemperature() {
		return this.temperature;
	}
}

