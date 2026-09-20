package wodel.ai.assistant.wodel.ai;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

import wodel.ai.assistant.tasks.fixers.LLMResponse;
import wodel.ai.assistant.wodel.ai.WodelLanguageService.SourceSnapshot;

/** Explains a selected/named Wodel program using parsed project context. */
public final class WodelExplainTask extends WodelAiTask {
    public WodelExplainTask() {
        super(
            "ExplainWodelSource",
            "Explain the selected or named .mutator program, its blocks, selections and mutation semantics",
            List.of(
                "explain wodel", "explain mutator", "explain this mutator", "explain this wodel program",
                "what does this mutator", "what does this wodel", "understand this mutator", "describe wodel source"));
    }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        IProject project = language.activeProject();
        if (project == null) return "Select or open a Wodel project first.";
        try {
            IFile file = language.resolveSource(project, userInput);
            if (file == null) return "The selected Wodel project contains no .mutator source files.";
            SourceSnapshot snapshot = language.load(file);
            String system = commonSystemPrompt() + """

                Explain the supplied Wodel source for a software engineer familiar with model-driven engineering.
                Cover the generation header, model/metamodel context, each mutation block, important selections/conditions,
                and the expected mutation effect. Call out validation errors/warnings separately. Do not generate replacement
                code unless the user explicitly asks for it. Keep the explanation grounded in the supplied source and metamodel.
                """;
            String user = "USER QUESTION\n" + userInput + "\n\n" + sourceContext(snapshot);
            try {
                LLMResponse response = ask(system, user);
                return response.getResponse().trim();
            } catch (Exception e) {
                String fallback = missingKeyMessage(e);
                if (e instanceof IllegalStateException && fallback.startsWith("This Wodel AI workflow")) {
                    return "Wodel source: " + file.getProjectRelativePath() + "\n\n"
                        + snapshot.structuralSummary() + "\n\nValidation:\n" + snapshot.validation().format()
                        + "\n\n" + fallback;
                }
                throw e;
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
