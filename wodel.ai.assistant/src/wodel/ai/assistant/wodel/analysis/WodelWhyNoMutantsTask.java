package wodel.ai.assistant.wodel.analysis;

import java.util.List;

import wodel.ai.assistant.tasks.fixers.LLMResponse;
import wodel.ai.assistant.wodel.ai.WodelAiTask;
import wodel.ai.assistant.wodel.analysis.WodelAnalysisService.AnalysisContext;

/**
 * Uses deterministic registry evidence plus Wodel source/metamodel context to
 * explain why a requested block/operator appears not to generate mutants.
 */
public final class WodelWhyNoMutantsTask extends WodelAiTask {
    private final WodelAnalysisService analysis = new WodelAnalysisService();

    public WodelWhyNoMutantsTask() {
        super(
            "ExplainWhyWodelGeneratesNoMutants",
            "Explain why a Wodel block or mutation command generates no mutants, grounding the answer in registry coverage plus the parsed Wodel/metamodel context",
            List.of(
                "why no mutants",
                "why does this block generate no mutants",
                "why does this operator generate no mutants",
                "why is this mutation uncovered",
                "why is this operator uncovered"));
    }

    @Override
    public String getIntentGroup() { return "mutation-analysis"; }

    @Override
    public int getIntentPriority() { return 160; }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        final AnalysisContext context;
        try {
            context = analysis.resolve(userInput);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return e.getMessage();
        }

        String evidence = analysis.adequacyReport(context);
        if (context.registryEntries().isEmpty()) {
            evidence += "\n\nIMPORTANT: no applied-mutation registries are present, so absence of coverage cannot yet prove that a command is inapplicable.";
        }

        String system = commonSystemPrompt() + """

            You are diagnosing Wodel mutant-generation behaviour.
            Treat the registry/adequacy report as observed evidence.
            Distinguish observed facts from hypotheses. Do not claim a cause is proven unless the evidence proves it.
            Consider, where supported by the source/metamodel: missing target objects, unsatisfied select/where conditions,
            cardinality/containment constraints, invalid candidate rejection, block dependencies, duplicate/equivalent filtering,
            and missing registry/metrics generation.
            End with 1-3 concrete diagnostic actions the user can perform in Wodel.
            """;

        String user = "USER QUESTION\n" + userInput
            + "\n\nOBSERVED MUTATION ADEQUACY\n" + evidence
            + "\n\nWODEL SOURCE AND METAMODEL CONTEXT\n" + sourceContext(context.snapshot());
        try {
            LLMResponse response = ask(system, user);
            return response.getResponse().trim();
        } catch (Exception e) {
            return missingKeyMessage(e);
        }
    }
}
