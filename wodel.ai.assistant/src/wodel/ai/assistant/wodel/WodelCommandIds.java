package wodel.ai.assistant.wodel;

/** Eclipse command ids exposed by the Wodel UI plugins. */
public final class WodelCommandIds {
    public static final String EXECUTE_MUTATIONS = "wodel.run.popup.actions.RunWodel";
    public static final String MUTANTS_WIZARD = "wodel.run.popup.actions.GenerateWodelMutantsWizard";
    public static final String MUTATION_OPERATORS_WIZARD = "wodel.run.popup.actions.GenerateWodelMutationOperatorsWizard";
    public static final String CLEAN_OUTPUT = "wodel.run.popup.actions.CleanUpWodelOutputFolder";
    public static final String CLEAN_REGISTRY = "wodel.run.popup.actions.CleanUpWodelRegistry";
    public static final String GENERATE_ALL_MUTANTS = "generateAllWodelMutants";
    public static final String RUN_WODEL_TEST = "wodeltest.run.commands.wodelTestCommandRun";
    public static final String LOAD_AND_RUN_WODEL_TEST = "wodeltest.run.commands.wodelTestCommandLoad";

    private WodelCommandIds() {
    }
}
