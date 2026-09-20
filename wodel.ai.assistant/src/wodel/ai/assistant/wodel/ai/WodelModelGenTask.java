package wodel.ai.assistant.wodel.ai;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Shared support for Wodel model-generation tasks backed by an LLM.
 *
 * This is the Wodel counterpart of the older Gotten ModelGenTask pattern:
 * it keeps a generation history and can append previous generated models to
 * the next prompt so the LLM is explicitly asked to produce diverse models.
 */
public abstract class WodelModelGenTask extends WodelAiTask {
    protected static final String OUTPUT = """
        Generate ONE EMF model in XMI format. Do not produce any explanation.
        Return ONLY the XMI document: no Markdown fences, no comments, no prose.
        """;

    private static final int MAX_PREVIOUS_MODELS_IN_PROMPT = 8;
    private static final int MAX_PREVIOUS_MODEL_CHARS = 8000;

    protected final List<String> previousGeneratedModels = new ArrayList<>();
    protected int numGenModels = -1;

    protected WodelModelGenTask(String id, String description, Collection<String> aliases) {
        super(id, description, aliases);
    }

    protected void resetGenerationHistory() {
        previousGeneratedModels.clear();
    }

    protected void rememberGeneratedModel(String xmi) {
        if (xmi == null || xmi.isBlank()) return;
        previousGeneratedModels.add(xmi.trim());
    }

    protected String doNotRepeatPrompt() {
        if (previousGeneratedModels.isEmpty()) return "";

        StringBuilder prompt = new StringBuilder();
        prompt.append('\n').append(getNoRepMessage().trim()).append('\n');

        int from = Math.max(0, previousGeneratedModels.size() - MAX_PREVIOUS_MODELS_IN_PROMPT);
        for (int i = from; i < previousGeneratedModels.size(); i++) {
            String model = previousGeneratedModels.get(i);
            if (model.length() > MAX_PREVIOUS_MODEL_CHARS) {
                model = model.substring(0, MAX_PREVIOUS_MODEL_CHARS)
                    + "\n... [previous model truncated by Wodel AI assistant]";
            }
            prompt.append("\n======================================================\n")
                .append("PREVIOUS VALIDATED SEED ").append(i + 1).append('\n')
                .append(model).append('\n');
        }
        return prompt.toString();
    }

    protected abstract String getNoRepMessage();
}
