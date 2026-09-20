package wodel.ai.assistant.wodel.analysis;

import java.util.Collection;
import java.util.List;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.ai.assistant.wodel.analysis.WodelAnalysisService.AnalysisContext;
import wodel.ai.assistant.wodel.analysis.WodelAnalysisService.MutantTrace;

/** Explains one generated mutant from Wodel's applied-mutation registry. */
public final class WodelExplainMutantTask extends MTTask implements IntentAwareTask {
    private final WodelAnalysisService analysis = new WodelAnalysisService();

    public WodelExplainMutantTask() {
        super("Explain a generated Wodel mutant using its seed and applied-mutation registry trace");
        this.id = "ExplainWodelMutant";
    }

    @Override
    public Collection<String> getIntentAliases() {
        return List.of(
            "explain mutant",
            "explain generated mutant",
            "what changed in mutant",
            "mutation trace",
            "trace mutant");
    }

    @Override
    public String getIntentGroup() { return "mutant-analysis"; }

    @Override
    public int getIntentPriority() { return 100; }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        try {
            AnalysisContext context = analysis.resolve(userInput);
            MutantTrace trace = analysis.resolveMutant(context, userInput);
            return analysis.traceReport(trace);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return e.getMessage();
        }
    }
}
