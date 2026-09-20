package wodel.ai.assistant.wodel.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.ai.assistant.wodel.ai.WodelAiSeedGenerationTask;
import wodel.ai.assistant.wodel.analysis.WodelAnalysisService.AnalysisContext;
import wodel.ai.assistant.wodel.analysis.WodelAnalysisService.CommandInfo;

/**
 * Feedback-guided seed generation: find uncovered Wodel commands and ask the
 * existing validated LLM seed generator for models targeted at those gaps.
 */
public final class WodelImproveSeedsTask extends MTTask implements IntentAwareTask {
    private static final Pattern COUNT = Pattern.compile("(?i)\\b(?:count|seeds?|models?)\\s*=\\s*(\\d+)");
    private static final Pattern SLASH_COUNT = Pattern.compile("(?i)^\\s*/improve-seeds\\s+(\\d+)\\b");
    private final WodelAnalysisService analysis = new WodelAnalysisService();

    public WodelImproveSeedsTask() {
        super("Generate targeted LLM seed models for currently uncovered Wodel mutation commands, based on applied-mutation adequacy feedback");
        this.id = "ImproveWodelSeedAdequacy";
    }

    @Override
    public Collection<String> getIntentAliases() {
        return List.of(
            "improve seed adequacy",
            "improve seed coverage",
            "generate seeds for uncovered operators",
            "generate seeds for uncovered mutations",
            "target uncovered mutation commands");
    }

    @Override
    public String getIntentGroup() { return "seed-analysis"; }

    @Override
    public int getIntentPriority() { return 130; }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        final AnalysisContext context;
        try {
            context = analysis.resolve(userInput);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return e.getMessage();
        }
        if (context.registryEntries().isEmpty()) {
            return "No applied-mutation registry data exists yet. Run mutant generation with registry=true before asking the assistant to target uncovered commands.";
        }

        List<CommandInfo> uncovered = context.commands().stream().filter(command -> !command.covered()).toList();
        if (uncovered.isEmpty()) {
            return "All " + context.commands().size() + " Wodel mutation commands already have applied-mutation registry evidence. No targeted seed is currently needed.";
        }

        int count = requestedCount(userInput, Math.min(5, Math.max(1, uncovered.size())));
        String features = buildFeatures(uncovered);
        String program = context.source().getProjectRelativePath().toString();
        String delegated = "/seeds-ai " + count + " program=" + program + " features=\"" + escape(features) + "\"";

        Object generation = new WodelAiSeedGenerationTask().executeWithInput(delegated);
        return "Found " + uncovered.size() + " uncovered Wodel mutation command(s).\n"
            + "Targeted model guidance sent to the validated LLM seed generator:\n" + features
            + "\n\n" + String.valueOf(generation)
            + "\n\nNext step: run /generate program=" + program + " registry=true, then /adequacy to measure whether the new seeds improved observed command coverage.";
    }

    private String buildFeatures(List<CommandInfo> uncovered) {
        List<String> targets = new ArrayList<>();
        for (CommandInfo command : uncovered) {
            targets.add(command.displayName());
            if (targets.size() >= 12) break;
        }
        return "Create structurally diverse valid instances that make these currently uncovered Wodel mutation commands applicable where the metamodel permits: "
            + String.join("; ", targets)
            + ". Populate the object types, attributes and references needed by their selections/preconditions rather than generating minimal empty instances.";
    }

    private int requestedCount(String text, int fallback) {
        if (text == null) return fallback;
        Matcher matcher = SLASH_COUNT.matcher(text);
        if (!matcher.find()) matcher = COUNT.matcher(text);
        if (!matcher.find()) return fallback;
        try { return Math.max(1, Math.min(20, Integer.parseInt(matcher.group(1)))); }
        catch (NumberFormatException e) { return fallback; }
    }

    private String escape(String text) {
        return text.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
