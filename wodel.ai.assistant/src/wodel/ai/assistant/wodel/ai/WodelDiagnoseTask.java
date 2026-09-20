package wodel.ai.assistant.wodel.ai;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

import wodel.ai.assistant.tasks.fixers.LLMResponse;
import wodel.ai.assistant.wodel.ai.WodelLanguageService.SourceSnapshot;

/** Explains Wodel parser/linker/validator diagnostics in source context. */
public final class WodelDiagnoseTask extends WodelAiTask {
    public WodelDiagnoseTask() {
        super(
            "DiagnoseWodelSource",
            "Diagnose Wodel syntax/linking/validation problems in the selected or named .mutator source",
            List.of(
                "diagnose wodel", "diagnose mutator", "explain wodel errors", "explain validation errors",
                "why is this mutator invalid", "why does this mutator fail", "why does wodel fail", "diagnose this wodel"));
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

                Diagnose the supplied Wodel source. Start from the exact Wodel validator messages and explain their likely
                cause in the source. For each concrete error/warning, identify the relevant construct and propose a focused
                correction. If the Xtext validator reports no errors/warnings, say so explicitly; you may then identify only
                clearly labelled semantic/maintainability risks, not invented compiler errors. Do not silently rewrite the file.
                """;
            String user = "USER REQUEST\n" + userInput + "\n\n" + sourceContext(snapshot);
            try {
                LLMResponse response = ask(system, user);
                return response.getResponse().trim();
            } catch (Exception e) {
                String fallback = missingKeyMessage(e);
                if (e instanceof IllegalStateException && fallback.startsWith("This Wodel AI workflow")) {
                    return "Wodel diagnostics for " + file.getProjectRelativePath() + ":\n"
                        + snapshot.validation().format() + "\n\n" + fallback;
                }
                throw e;
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
