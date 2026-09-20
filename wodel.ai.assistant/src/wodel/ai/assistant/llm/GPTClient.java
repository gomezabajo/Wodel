package wodel.ai.assistant.llm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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

	/**
	 * Sends a proper two-role chat request without requiring callers to pre-escape
	 * JSON. New Wodel-native AI tasks use this method; legacy tasks keep the
	 * original sendPrompt contract for compatibility.
	 */
	public LLMResponse sendChat(String systemPrompt, String userPrompt) throws Exception {
		if (this.apiKey == null || this.apiKey.isBlank()) {
			throw new IllegalStateException(
				"No OpenAI API key is configured. Set 'gen-AI API Key' in the Wodel preferences or OPENAI_API_KEY in the environment.");
		}

		JSONObject body = new JSONObject();
		body.put("model", this.model);
		JSONArray messages = new JSONArray();
		if (systemPrompt != null && !systemPrompt.isBlank()) {
			messages.put(new JSONObject().put("role", "system").put("content", systemPrompt));
		}
		messages.put(new JSONObject().put("role", "user").put("content", userPrompt == null ? "" : userPrompt));
		body.put("messages", messages);
		if (this.supportsTemperature()) body.put("temperature", this.temperature);

		String promptForTrace = (systemPrompt == null ? "" : systemPrompt + "\n\n")
			+ (userPrompt == null ? "" : userPrompt);
		return sendJsonBody(body.toString(), promptForTrace);
	}

	private LLMResponse sendJsonBody(String jsonBody, String promptForTrace) throws Exception {
		if (this.verbose) System.out.println("JSON:\n" + jsonBody);

		URL url = new URL(API_URL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", "Bearer " + this.apiKey);
		connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		connection.setDoOutput(true);

		try (OutputStream os = connection.getOutputStream()) {
			byte[] input = jsonBody.getBytes(StandardCharsets.UTF_8);
			os.write(input, 0, input.length);
		}

		int responseCode = connection.getResponseCode();
		InputStream is = responseCode < HttpURLConnection.HTTP_BAD_REQUEST
			? connection.getInputStream() : connection.getErrorStream();
		String response = extractResponse(is);
		connection.disconnect();
		if (responseCode != HttpURLConnection.HTTP_OK) {
			throw new Exception("Error from OpenAI API: " + response);
		}
		return new LLMResponse(promptForTrace, this.extractContent(response));
	}

	public LLMResponse sendPrompt(String prompt) throws Exception {
		if (this.apiKey == null || this.apiKey.isBlank()) {
			throw new IllegalStateException(
				"No OpenAI API key is configured. Set 'gen-AI API Key' in the Wodel preferences or OPENAI_API_KEY in the environment.");
		}
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
		String preference = WodelGeneralPreferencePage.PREF_GPT_API_KEY;

		String apiKey = Platform.getPreferencesService()
			.getString("wodel.dsls.Wodel", preference, "", null);
		if (apiKey != null && !apiKey.isBlank()) {
			return apiKey.trim();
		}

		String environmentKey = System.getenv("OPENAI_API_KEY");
		if (environmentKey != null && !environmentKey.isBlank()) {
			return environmentKey.trim();
		}

		Bundle bundle = Platform.getBundle("wodel.ai.assistant");
		if (bundle == null) return null;
		URL keysPropertiesURL = bundle.getEntry("/keys.properties");
		if (keysPropertiesURL == null) return null;

		Properties properties = new Properties();
		try {
			URL resolved = FileLocator.resolve(keysPropertiesURL);
			try (InputStream fis = resolved.openStream()) {
				properties.load(fis);
			}
			String bundledKey = properties.getProperty("OPENAI_API_KEY");
			return bundledKey == null || bundledKey.isBlank() ? null : bundledKey.trim();
		} catch (IOException e) {
			return null;
		}
    }

	public void setVerbose(boolean v) {
		this.verbose = v;
	}

	public double getTemperature() {
		return this.temperature;
	}
}

