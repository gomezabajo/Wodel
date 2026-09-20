package wodel.ai.assistant.wodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Deterministic parser for conversational Wodel seed-model generation. */
public final class WodelSeedRequestParser {
    private static final Pattern COUNT_KV = Pattern.compile(
        "(?i)\\b(?:seeds?|seed\\s*models?|number\\s*of\\s*seed\\s*models?|numSeeds)\\s*[:=]\\s*(\\d+)\\b");
    private static final Pattern COUNT_NL = Pattern.compile(
        "(?i)\\b(?:generate|create|produce|make|synthesi[sz]e)\\s+(\\d+)\\s+(?:wodel\\s+)?seed\\s*models?\\b");
    private static final Pattern COUNT_SLASH = Pattern.compile(
        "(?i)^\\s*/(?:seeds?|seeds-ai|ai-seeds|llm-seeds)\\s+(\\d+)\\b");

    private WodelSeedRequestParser() {}

    public static Integer parseCount(String text) {
        String input = text == null ? "" : text.trim();
        for (Pattern pattern : new Pattern[] { COUNT_KV, COUNT_NL, COUNT_SLASH }) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) return Integer.valueOf(matcher.group(1));
        }
        return null;
    }

    public static boolean looksLikeLlmSeedGeneration(String text) {
        if (!looksLikeSeedGeneration(text)) return false;
        String lower = text == null ? "" : text.toLowerCase();
        return lower.startsWith("/seeds-ai") || lower.startsWith("/ai-seeds") || lower.startsWith("/llm-seeds")
            || lower.contains(" using ai") || lower.contains(" with ai") || lower.contains(" via ai")
            || lower.contains(" using the ai") || lower.contains(" with the ai")
            || lower.contains(" using llm") || lower.contains(" with llm") || lower.contains(" via llm")
            || lower.contains(" using the llm") || lower.contains(" with the llm")
            || lower.contains("language model") || lower.contains("openai") || lower.contains("llm api")
            || lower.contains("ai api") || lower.contains("gpt") || lower.contains("generative ai");
    }

    public static boolean looksLikeSeedGeneration(String text) {
        if (text == null || text.isBlank()) return false;
        String lower = text.toLowerCase();
        boolean seedModelPhrase = lower.contains("seed model") || lower.contains("seed-model")
            || lower.contains("seed models") || lower.matches(".*\\bgenerate\\s+seeds?\\b.*")
            || lower.startsWith("/seed") || lower.startsWith("/ai-seeds") || lower.startsWith("/llm-seeds");
        boolean generationVerb = lower.contains("generate") || lower.contains("create")
            || lower.contains("produce") || lower.contains("make")
            || lower.contains("synthesise") || lower.contains("synthesize")
            || lower.startsWith("/seed") || lower.startsWith("/ai-seeds") || lower.startsWith("/llm-seeds");
        return seedModelPhrase && generationVerb;
    }
}
