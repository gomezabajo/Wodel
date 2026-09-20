package wodel.ai.assistant.wodel;

import java.util.Collection;
import java.util.List;

import wodel.ai.assistant.ITaskProvider;
import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.wodel.ai.WodelAuthorTask;
import wodel.ai.assistant.wodel.ai.WodelAiSeedGenerationTask;
import wodel.ai.assistant.wodel.ai.WodelDiagnoseTask;
import wodel.ai.assistant.wodel.ai.WodelExplainTask;
import wodel.ai.assistant.wodel.ai.WodelRepairTask;
import wodel.ai.assistant.wodel.ai.WodelSuggestMutationTask;
import wodel.ai.assistant.wodel.analysis.WodelExplainMutantTask;
import wodel.ai.assistant.wodel.analysis.WodelAdequacyTask;
import wodel.ai.assistant.wodel.analysis.WodelWhyNoMutantsTask;
import wodel.ai.assistant.wodel.analysis.WodelMetricsTask;
import wodel.ai.assistant.wodel.analysis.WodelMutantComparisonTask;
import wodel.ai.assistant.wodel.analysis.WodelEquivalentMutantsTask;
import wodel.ai.assistant.wodel.analysis.WodelTestResultsTask;
import wodel.ai.assistant.wodel.analysis.WodelTestOptimiserTask;
import wodel.ai.assistant.wodel.analysis.WodelDoctorTask;
import wodel.ai.assistant.wodel.analysis.WodelReproducibilityTask;
import wodel.ai.assistant.wodel.analysis.WodelSeedComparisonTask;
import wodel.ai.assistant.wodel.analysis.WodelImproveSeedsTask;

/** The Wodel workflows exposed to the conversational planner. */
public final class WodelTaskProvider implements ITaskProvider {
    private static final WodelTaskProvider INSTANCE = new WodelTaskProvider();

    private final List<MTTask> tasks = List.of(
        // Wodel-native AI authoring/analysis tasks. These are deliberately
        // registered before the generic UI workflows so the LLM fallback also
        // receives their descriptions as first-class Wodel intents.
        new WodelExplainTask(),
        new WodelDiagnoseTask(),
        new WodelRepairTask(),
        new WodelSuggestMutationTask(),
        new WodelAuthorTask(),

        new WodelExplainMutantTask(),
        new WodelAdequacyTask(),
        new WodelWhyNoMutantsTask(),
        new WodelMetricsTask(),
        new WodelMutantComparisonTask(),
        new WodelEquivalentMutantsTask(),
        new WodelTestResultsTask(),
        new WodelTestOptimiserTask(),
        new WodelDoctorTask(),
        new WodelReproducibilityTask(),
        new WodelSeedComparisonTask(),
        new WodelImproveSeedsTask(),

        new EclipseCommandTask(
            "RunWodelTest",
            "Run Wodel-Test for the current selection/project when the optional wodeltest.run plugin is installed",
            WodelCommandIds.RUN_WODEL_TEST,
            "Wodel-Test execution was started.",
            List.of("run wodel-test", "run wodel test", "execute wodel-test", "mutation testing"),
            "wodel-test", 130),

        new WodelAiSeedGenerationTask(),
        new WodelSeedGenerationTask(),
        new ParameterizedWodelMutationTask(),

        new EclipseCommandTask(
            "ExecuteWodelMutations",
            "Execute the selected Wodel .mutator program using the normal Wodel execution workflow",
            WodelCommandIds.EXECUTE_MUTATIONS,
            "Wodel mutation execution was started for the current selection.",
            List.of("execute mutations", "execute wodel mutations", "run wodel", "run mutations", "execute mutator"),
            "mutation-execution", 10),

        new EclipseCommandTask(
            "GenerateAllWodelMutants",
            "Build the selected Wodel project and generate mutants for all executable Wodel programs and blocks",
            WodelCommandIds.GENERATE_ALL_MUTANTS,
            "Generation of all Wodel mutants was started for the selected project.",
            List.of("generate all mutants", "generate every mutant", "all wodel mutants", "run all wodel programs"),
            "mutation-execution", 10),

        new EclipseCommandTask(
            "GenerateWodelMutantsWizard",
            "Open the Wodel mutants generation wizard to choose programs, operators, input models and output folder",
            WodelCommandIds.MUTANTS_WIZARD,
            "The Wodel mutants generation wizard was opened.",
            List.of("mutants generation wizard", "open mutant wizard", "generate selected mutants", "choose mutants", "custom mutant generation")),

        new EclipseCommandTask(
            "GenerateWodelMutationOperatorsWizard",
            "Open the Wodel mutation-operator generation wizard",
            WodelCommandIds.MUTATION_OPERATORS_WIZARD,
            "The Wodel mutation-operator generation wizard was opened.",
            List.of("mutation operator wizard", "generate mutation operators", "operator generation wizard", "create mutation operators")),

        new EclipseCommandTask(
            "CleanWodelOutput",
            "Clean generated Wodel output while preserving the project structure expected by Wodel",
            WodelCommandIds.CLEAN_OUTPUT,
            "The Wodel output clean-up workflow was started.",
            List.of("clean wodel output", "clean output folder", "delete generated mutants", "clear wodel output")),

        new EclipseCommandTask(
            "CleanWodelRegistry",
            "Clean the Wodel mutant registry for the current selection",
            WodelCommandIds.CLEAN_REGISTRY,
            "The Wodel registry clean-up workflow was started.",
            List.of("clean wodel registry", "clean mutant registry", "clear registry", "reset wodel registry")),

        new WodelProjectOverviewTask(),
        new WodelProjectDetailsTask(),
        new WodelValidationTask()
    );

    private WodelTaskProvider() {}
    public static WodelTaskProvider getInstance() { return INSTANCE; }
    @Override public Collection<MTTask> getSupportedTasks() { return tasks; }
}
