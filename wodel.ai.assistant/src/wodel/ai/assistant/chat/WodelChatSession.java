package wodel.ai.assistant.chat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.wodel.WodelTaskProvider;

/** Facade used by the Eclipse Wodel chat view. */
public class WodelChatSession {
    private final PlannerAgent planner;
    private final Map<String, MTTask> slashCommands = new LinkedHashMap<>();

    public WodelChatSession() {
        WodelTaskProvider provider = WodelTaskProvider.getInstance();
        this.planner = new PlannerAgent();
        for (MTTask task : provider.getSupportedTasks()) slashCommands.put(task.getId().toLowerCase(Locale.ROOT), task);
        alias("/explain", "ExplainWodelSource");
        alias("/diagnose", "DiagnoseWodelSource");
        alias("/repair", "RepairWodelSource");
        alias("/suggest", "SuggestWodelMutations");
        alias("/author", "AuthorWodelSource");
        alias("/explain-mutant", "ExplainWodelMutant");
        alias("/trace-mutant", "ExplainWodelMutant");
        alias("/adequacy", "AnalyzeWodelMutationAdequacy");
        alias("/why-no-mutants", "ExplainWhyWodelGeneratesNoMutants");
        alias("/metrics", "SummarizeWodelMutationMetrics");
        alias("/compare-mutants", "CompareWodelMutants");
        alias("/equivalents", "FindEquivalentWodelMutants");
        alias("/test", "RunWodelTest");
        alias("/test-results", "SummarizeWodelTestResults");
        alias("/survivors", "SummarizeWodelTestResults");
        alias("/optimise-mutants", "OptimiseWodelTestMutants");
        alias("/optimize-mutants", "OptimiseWodelTestMutants");
        alias("/doctor", "InspectWodelConfiguration");
        alias("/config", "InspectWodelConfiguration");
        alias("/reproduce", "CreateWodelReproducibilityManifest");
        alias("/compare-seeds", "CompareWodelSeedStrategies");
        alias("/improve-seeds", "ImproveWodelSeedAdequacy");
        alias("/run", "ExecuteWodelMutations");
        alias("/all", "GenerateAllWodelMutants");
        alias("/generate", "ParameterizedWodelMutation");
        alias("/seeds", "GenerateWodelSeedModels");
        alias("/seeds-ai", "GenerateWodelSeedModelsWithAI");
        alias("/ai-seeds", "GenerateWodelSeedModelsWithAI");
        alias("/llm-seeds", "GenerateWodelSeedModelsWithAI");
        alias("/seed", "GenerateWodelSeedModels");
        alias("/mutants", "GenerateWodelMutantsWizard");
        alias("/operators", "GenerateWodelMutationOperatorsWizard");
        alias("/clean-output", "CleanWodelOutput");
        alias("/clean-registry", "CleanWodelRegistry");
        alias("/project", "WodelProjectOverview");
        alias("/blocks", "WodelProjectDetails");
        alias("/validate", "ValidateWodelProject");
    }

    private void alias(String command, String taskId) {
        MTTask task = slashCommands.get(taskId.toLowerCase(Locale.ROOT));
        if (task != null) slashCommands.put(command, task);
    }

    public String handle(String utterance) throws Exception {
        if (utterance == null || utterance.isBlank()) return "Type /help to see the Wodel workflows I can execute.";
        String trimmed = utterance.trim();
        if (trimmed.equalsIgnoreCase("/help") || trimmed.equalsIgnoreCase("help")) return help();

        MTTask task;
        if (trimmed.startsWith("/")) {
            String command = trimmed.split("\\s+", 2)[0].toLowerCase(Locale.ROOT);
            task = slashCommands.get(command);
            if (task == null) return "Unknown Wodel chat command '" + command + "'.\n\n" + help();
        } else {
            task = planner.getIntent(trimmed);
        }
        if (task == null) return "I could not map that request to a Wodel workflow.\n\n" + help();
        String missing = task.canExecute();
        if (missing != null && !missing.isBlank()) return "I still need: " + missing + ".";
        return formatResult(task.executeWithInput(trimmed));
    }

    private String formatResult(Object result) {
        if (result == null) return "Wodel workflow completed.";
        if (result instanceof List<?> values) {
            StringBuilder out = new StringBuilder();
            for (Object value : values) {
                if (value == null) continue;
                if (out.length() > 0) out.append(System.lineSeparator());
                out.append(value);
            }
            return out.length() == 0 ? "Wodel workflow completed." : out.toString();
        }
        return String.valueOf(result);
    }

    public String help() {
        return String.join(System.lineSeparator(),
            "Wodel chat workflows:",
            "  /explain         Explain the selected/named .mutator program using its parsed Wodel/metamodel context",
            "  /diagnose        Explain parser/linker/validator problems in a .mutator source",
            "  /repair          Generate and revalidate a minimal repair; add apply=true to write an error-free repair",
            "  /suggest         Propose additional/improved mutation blocks and return a validated complete candidate",
            "  /author          Author a new complete Wodel program using the selected source/metamodel as context",
            "  /explain-mutant  Explain a generated mutant from its Wodel applied-mutation registry trace",
            "  /adequacy        Measure command/operator coverage from applied-mutation registries",
            "  /why-no-mutants Explain why a block/operator appears not to generate mutants",
            "  /metrics         Summarize applied, command/static, dynamic and debug mutation metrics",
            "  /compare-mutants Compare two generated mutants using installed Wodel comparators",
            "  /equivalents     Find duplicate/equivalent mutant pairs (semantic optional)",
            "  /test            Run Wodel-Test through its Eclipse command (optional plugin)",
            "  /test-results    Summarize persisted Wodel-Test results and mutation score",
            "  /survivors       List live/surviving mutants from Wodel-Test results",
            "  /optimise-mutants Run installed Wodel-Test mutation optimisers",
            "  /doctor          Inspect effective Wodel preferences and optional plugin availability",
            "  /reproduce       Create a JSON reproducibility manifest; add save=true to persist it",
            "  /compare-seeds   Compare native vs LLM seeds using observed mutation-command coverage",
            "  /improve-seeds   Generate targeted LLM seeds for currently uncovered mutation commands",
            "  /run             Execute the selected .mutator program with normal Wodel preferences",
            "  /all             Generate mutants for all executable programs with normal preferences",
            "  /generate ...    Parameterized mutation EXECUTION (program, mutants, attempts, blocks, seed, registry/metrics)",
            "  /seeds [N]       Generate N seed models with the native Wodel USE/Kodkod synthesizer",
            "  /seeds-ai [N]    Generate N seed models through the LLM API; optional features=... guides model characteristics",
            "  /mutants         Open the customised mutants-generation wizard",
            "  /operators       Open the mutation-operator generation wizard",
            "  /project         List executable .mutator programs in the selected project",
            "  /blocks          Show each program's metamodel and mutation blocks",
            "  /validate        Validate all .mutator sources (programs and libraries)",
            "  /clean-output    Clean Wodel generated output",
            "  /clean-registry  Clean the Wodel mutant registry",
            "",
            "AI examples:",
            "  /explain program=testFA1.mutator",
            "  /diagnose program=testFA1.mutator",
            "  /repair program=testFA1.mutator",
            "  /repair program=testFA1.mutator apply=true",
            "  /suggest Add boundary-value mutations for numeric attributes",
            "  /author Create a mutator that removes optional transitions and changes final states",
            "",
            "Mutant-analysis examples:",
            "  /explain-mutant Output3.model program=testFA1.mutator",
            "  /adequacy program=testFA1.mutator",
            "  /why-no-mutants Why does block RemoveFinalState generate no mutants? program=testFA1.mutator",
            "  /metrics all program=testFA1.mutator",
            "  /compare-mutants Output3.model Output7.model semantic program=testFA1.mutator",
            "  /equivalents semantic=true program=testFA1.mutator",
            "  /test",
            "  /survivors",
            "  /optimise-mutants",
            "  /doctor",
            "  /reproduce program=testFA1.mutator seed=42 save=true",
            "  /compare-seeds program=testFA1.mutator",
            "  /improve-seeds program=testFA1.mutator count=3",
            "",
            "Execution examples:",
            "  /generate program=testFA1 mutants=20 attempts=5 blocks=BlockA,BlockB seed=1234 registry=true",
            "  /seeds 5",
            "  /seeds-ai 5",
            "  /seeds-ai 5 program=testFA1.mutator features=\"at least three states and two transitions\"",
            "  Generate 5 seed models for the corresponding Wodel program metamodel",
            "  Generate 5 seed models for the corresponding Wodel program metamodel using the LLM API",
            "  Generate 10 mutants for blocks Foo and Bar with seed 42 without registry",
            "  Clean Wodel output and then generate 5 mutants with seed 7",
            "",
            "The AI source workflows and /seeds-ai require the configured LLM API. /seeds-ai validates every candidate against the program metamodel before saving it. The source workflows use the active/named .mutator plus the Wodel Xtext validator. Code-producing AI tasks retry invalid candidates up to three times and never modify source by default. /repair writes only when apply=true is explicit and the candidate has no validation errors.",
            "Unspecified execution parameters use current Wodel preferences. /generate is execution; /author is source generation.");
    }
}
