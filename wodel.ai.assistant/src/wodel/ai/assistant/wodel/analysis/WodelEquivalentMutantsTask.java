package wodel.ai.assistant.wodel.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.ai.assistant.wodel.analysis.WodelAnalysisService.AnalysisContext;
import wodel.ai.assistant.wodel.analysis.WodelMutantComparisonTask.ComparisonResult;

/** Finds duplicate/equivalent pairs among registered generated mutants. */
public final class WodelEquivalentMutantsTask extends MTTask implements IntentAwareTask {
    private static final int MAX_MODELS = 120;
    private final WodelAnalysisService analysis = new WodelAnalysisService();

    public WodelEquivalentMutantsTask() {
        super("Find syntactically duplicate and optionally semantically equivalent Wodel mutants through installed comparison extensions");
        this.id = "FindEquivalentWodelMutants";
    }

    @Override
    public Collection<String> getIntentAliases() {
        return List.of(
            "find equivalent mutants",
            "equivalent mutants",
            "duplicate mutants",
            "find duplicate mutants",
            "which mutants are equivalent");
    }

    @Override
    public String getIntentGroup() { return "mutant-comparison"; }

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

        Set<String> registered = WodelMutantComparisonTask.registeredMutantPaths(context);
        List<String> mutants = new ArrayList<>(registered);
        if (mutants.size() > MAX_MODELS) {
            return "There are " + mutants.size() + " registered mutants. Pairwise comparison is O(n^2); narrow the output first or keep at most " + MAX_MODELS + " mutants for an interactive scan.";
        }
        boolean semantic = userInput != null && userInput.toLowerCase(Locale.ROOT).contains("semantic");
        List<String> equivalentPairs = new ArrayList<>();
        for (int i = 0; i < mutants.size(); i++) {
            for (int j = i + 1; j < mutants.size(); j++) {
                String a = mutants.get(i);
                String b = mutants.get(j);
                boolean syntacticEquivalent = WodelMutantComparisonTask.compareSyntactic(context, a, b).stream()
                    .anyMatch(result -> result.processed() && result.equivalent());
                if (syntacticEquivalent) {
                    equivalentPairs.add("SYNTACTIC: " + a + " == " + b);
                    continue;
                }
                if (semantic) {
                    List<ComparisonResult> semanticResults = WodelMutantComparisonTask.compareSemantic(context, a, b);
                    if (semanticResults.stream().anyMatch(result -> result.processed() && result.equivalent())) {
                        equivalentPairs.add("SEMANTIC: " + a + " ~= " + b);
                    }
                }
            }
        }

        StringBuilder out = new StringBuilder();
        out.append("Compared ").append(mutants.size()).append(" registered mutant(s)")
            .append(semantic ? " syntactically and semantically." : " syntactically.");
        if (equivalentPairs.isEmpty()) {
            out.append("\nNo equivalent/duplicate pairs were reported by the installed comparison extensions.");
        } else {
            out.append("\nEquivalent/duplicate pairs:");
            for (String pair : equivalentPairs) out.append("\n- ").append(pair);
        }
        if (!semantic) out.append("\nAdd semantic=true (or the word 'semantic') to include installed semantic-comparison extensions.");
        return out.toString();
    }
}
