package wodel.ai.assistant.wodel.ai;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

import wodel.ai.assistant.wodel.ai.WodelLanguageService.SourceSnapshot;

/** Proposes and generates additional Wodel mutation blocks/operators. */
public final class WodelSuggestMutationTask extends WodelAiTask {
    public WodelSuggestMutationTask() {
        super(
            "SuggestWodelMutations",
            "Propose or generate useful Wodel mutation blocks/operators for the selected .mutator program and validate the complete candidate",
            List.of(
                "suggest wodel mutations", "suggest mutation blocks", "suggest mutation operators",
                "propose mutation blocks", "propose mutation operators", "improve this mutator",
                "extend this mutator", "add mutation blocks", "add mutation operators"));
    }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        IProject project = language.activeProject();
        if (project == null) return "Select or open a Wodel project first.";
        try {
            IFile file = language.resolveSource(project, userInput);
            if (file == null) return "The selected Wodel project contains no .mutator source files.";
            SourceSnapshot snapshot = language.load(file);
            Candidate candidate;
            try {
                candidate = requestValidatedCandidate(
                    snapshot,
                    userInput,
                    "Improve or extend the current Wodel mutation design according to the user's request. "
                    + "Add only mutation blocks/operators that are meaningful for the supplied domain metamodel. Preserve all existing valid source by default. "
                    + "Avoid redundant operators and use existing Wodel idioms from the language reference. Return the complete source containing the proposal, not only new fragments.");
            } catch (Exception e) {
                return missingKeyMessage(e);
            }
            return formatCandidate("Suggested mutation design for " + file.getProjectRelativePath(), candidate)
                + "\n\nThe original source file was not modified.";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
