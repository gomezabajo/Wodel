package wodel.ai.assistant.wodel.analysis;

import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.ai.assistant.wodel.analysis.WodelAnalysisService.AnalysisContext;

/** Compares native and LLM seed sets using observed Wodel command coverage. */
public final class WodelSeedComparisonTask extends MTTask implements IntentAwareTask {
    private final WodelAnalysisService analysis = new WodelAnalysisService();

    public WodelSeedComparisonTask() {
        super("Compare native USE/Kodkod and LLM-generated seed models using observed Wodel mutation-command coverage");
        this.id = "CompareWodelSeedStrategies";
    }

    @Override
    public Collection<String> getIntentAliases() {
        return List.of(
            "compare seed models",
            "compare native and ai seeds",
            "compare native vs ai seeds",
            "seed generation comparison",
            "which seeds cover more mutations");
    }

    @Override
    public String getIntentGroup() { return "seed-analysis"; }

    @Override
    public int getIntentPriority() { return 100; }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        final AnalysisContext context;
        try {
            context = analysis.resolve(userInput);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return e.getMessage();
        }
        if (context.registryEntries().isEmpty()) {
            return "No applied-mutation registry data is available. Generate mutants with registry=true from both native and AI seed sets before comparing their mutation coverage.";
        }

        Map<String, Set<String>> bySeed = analysis.commandsBySeed(context);
        StrategyData nativeData = new StrategyData();
        StrategyData aiData = new StrategyData();
        for (Map.Entry<String, Set<String>> entry : bySeed.entrySet()) {
            StrategyData target = isAiSeed(entry.getKey()) ? aiData : nativeData;
            target.seeds.add(entry.getKey());
            target.commands.addAll(entry.getValue());
            target.applications += entry.getValue().size();
        }

        int totalCommands = context.commands().size();
        StringBuilder out = new StringBuilder("Seed-strategy mutation coverage for ")
            .append(context.source().getProjectRelativePath()).append('\n');
        append(out, "Native USE/Kodkod", nativeData, totalCommands);
        append(out, "LLM", aiData, totalCommands);

        Set<String> nativeOnly = new LinkedHashSet<>(nativeData.commands);
        nativeOnly.removeAll(aiData.commands);
        Set<String> aiOnly = new LinkedHashSet<>(aiData.commands);
        aiOnly.removeAll(nativeData.commands);
        Set<String> union = new LinkedHashSet<>(nativeData.commands);
        union.addAll(aiData.commands);

        out.append("\nCombined unique command coverage: ").append(union.size()).append('/').append(totalCommands);
        out.append("\nCommands covered only by native seeds: ").append(nativeOnly.size());
        out.append("\nCommands covered only by LLM seeds: ").append(aiOnly.size());
        out.append("\n\nClassification rule: seed filenames containing '_ai' are treated as LLM-generated; all other registered seed paths are treated as native/current seeds.");
        return out.toString();
    }

    private void append(StringBuilder out, String label, StrategyData data, int totalCommands) {
        out.append("\n\n").append(label)
            .append("\n- registered seeds exercising commands: ").append(data.seeds.size())
            .append("\n- unique commands covered: ").append(data.commands.size()).append('/').append(totalCommands)
            .append("\n- seed-command coverage links: ").append(data.applications);
        if (!data.seeds.isEmpty()) {
            out.append("\n- seeds:");
            for (String seed : data.seeds) out.append("\n  - ").append(Path.of(seed).getFileName());
        }
    }

    private boolean isAiSeed(String seedPath) {
        return Path.of(seedPath).getFileName().toString().toLowerCase(java.util.Locale.ROOT).contains("_ai");
    }

    private static final class StrategyData {
        final Set<String> seeds = new LinkedHashSet<>();
        final Set<String> commands = new LinkedHashSet<>();
        int applications;
    }
}
