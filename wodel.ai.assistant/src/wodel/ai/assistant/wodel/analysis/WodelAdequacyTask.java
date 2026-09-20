package wodel.ai.assistant.wodel.analysis;

import java.util.Collection;
import java.util.List;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.ai.assistant.wodel.analysis.WodelAnalysisService.AnalysisContext;

/** Reports which Wodel mutation commands have actually been applied. */
public final class WodelAdequacyTask extends MTTask implements IntentAwareTask {
    private final WodelAnalysisService analysis = new WodelAnalysisService();

    public WodelAdequacyTask() {
        super("Measure mutation-command adequacy from Wodel's applied-mutation registries: covered commands, seeds and generated mutants");
        this.id = "AnalyzeWodelMutationAdequacy";
    }

    @Override
    public Collection<String> getIntentAliases() {
        return List.of(
            "mutation adequacy",
            "operator adequacy",
            "command coverage",
            "mutation coverage",
            "which mutation operators are exercised",
            "which mutation commands are covered",
            "uncovered mutation operators");
    }

    @Override
    public String getIntentGroup() { return "mutation-analysis"; }

    @Override
    public int getIntentPriority() { return 120; }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        try {
            AnalysisContext context = analysis.resolve(userInput);
            String report = analysis.adequacyReport(context);
            if (context.registryEntries().isEmpty()) {
                report += "\n\nNo applied-mutation registry entries were found. Run mutation generation with registry=true before interpreting zero coverage as operator inapplicability.";
            }
            return report;
        } catch (IllegalArgumentException | IllegalStateException e) {
            return e.getMessage();
        }
    }
}
