package wodel.ai.assistant.chat;

import wodel.ai.assistant.llm.GPTClient;

/** Base for assistant agents that need an LLM only as a fallback. */
public abstract class AssistantAgent {
    protected String systemPrompt;
    private GPTClient llmClient;

    protected GPTClient llmClient() {
        if (llmClient == null) {
            llmClient = new GPTClient();
        }
        return llmClient;
    }

    public GPTClient getLLMClient() {
        return llmClient();
    }
}
