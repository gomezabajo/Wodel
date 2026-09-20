package wodel.ai.assistant.wodel.ai;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

import wodel.ai.assistant.wodel.ai.WodelLanguageService.SourceSnapshot;

/** Authors a new complete Wodel program using the selected source as domain context. */
public final class WodelAuthorTask extends WodelAiTask {
    public WodelAuthorTask() {
        super(
            "AuthorWodelSource",
            "Generate a new complete Wodel .mutator program from a natural-language mutation requirement using the selected program/metamodel as context",
            List.of(
                "author wodel", "write wodel program", "create wodel program", "generate wodel source",
                "write a mutator", "write mutator program", "create mutator program", "author mutator"));
    }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        IProject project = language.activeProject();
        if (project == null) return "Select or open a Wodel project first.";
        try {
            IFile reference = language.resolveSource(project, userInput);
            if (reference == null) {
                return "To author a Wodel program safely, select an existing .mutator source that provides the domain metamodel and project path conventions.";
            }
            SourceSnapshot snapshot = language.load(reference);
            Candidate candidate;
            try {
                candidate = requestValidatedCandidate(
                    snapshot,
                    userInput,
                    "Author a NEW complete executable Wodel program that satisfies the user's requested mutation behaviour. "
                    + "Use the current source only as a domain/project reference: retain its domain metamodel and compatible input/output/resource path conventions unless the user explicitly requests alternatives. "
                    + "Choose clear block names and descriptions, use only metamodel elements that actually exist, and return a self-contained complete .mutator source.");
            } catch (Exception e) {
                return missingKeyMessage(e);
            }
            return formatCandidate("New Wodel program proposal based on " + reference.getProjectRelativePath(), candidate)
                + "\n\nNo new file was created automatically; copy/save the validated proposal under the desired .mutator name.";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
