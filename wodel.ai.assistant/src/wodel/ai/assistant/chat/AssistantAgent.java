package wodel.ai.assistant.chat;

import wodel.ai.assistant.llm.GPTClient;

public abstract class AssistantAgent {
	protected String systemPrompt;
	protected GPTClient llmClient = new GPTClient();
	
	
	public GPTClient getLLMClient() {
		return llmClient;
	}
}
