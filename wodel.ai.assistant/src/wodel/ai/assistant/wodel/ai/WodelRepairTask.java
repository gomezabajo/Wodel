package wodel.ai.assistant.wodel.ai;

import java.util.List;
import java.util.Locale;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

import wodel.ai.assistant.wodel.ai.WodelLanguageService.SourceSnapshot;

/** Produces a validator-checked repair for an invalid Wodel source. */
public final class WodelRepairTask extends WodelAiTask {
    public WodelRepairTask() {
        super(
            "RepairWodelSource",
            "Repair Wodel validation errors in the selected or named .mutator source and revalidate the proposed source",
            List.of(
                "repair wodel", "repair mutator", "fix wodel", "fix mutator", "correct wodel source",
                "correct mutator", "fix this wodel program", "repair this mutator"));
    }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        IProject project = language.activeProject();
        if (project == null) return "Select or open a Wodel project first.";
        try {
            IFile file = language.resolveSource(project, userInput);
            if (file == null) return "The selected Wodel project contains no .mutator source files.";
            SourceSnapshot snapshot = language.load(file);
            if (snapshot.validation().isClean()) {
                return "Wodel source '" + file.getProjectRelativePath()
                    + "' already passes validation with no errors or warnings. Use /suggest if you want mutation-design improvements rather than a validation repair.";
            }

            Candidate candidate;
            try {
                candidate = requestValidatedCandidate(
                    snapshot,
                    userInput,
                    "Repair the current Wodel source with the smallest changes that correctly address its parser/linker/validator issues. "
                    + "Preserve the intended mutation semantics, existing metamodel/input/output paths, block names and valid commands unless a change is required to fix an issue. "
                    + "Return the complete repaired .mutator source.");
            } catch (Exception e) {
                return missingKeyMessage(e);
            }

            String heading = "Proposed repair for " + file.getProjectRelativePath();
            String result = formatCandidate(heading, candidate);
            if (shouldApply(userInput)) {
                if (candidate == null || candidate.validation() == null || candidate.validation().hasErrors()) {
                    return result + "\n\nThe repair was NOT written because validation errors remain.";
                }
                try {
                    language.replaceSource(file, candidate.code());
                } catch (IllegalStateException e) {
                    return result + "\n\nThe repair was NOT written: " + e.getMessage();
                }
                SourceSnapshot applied = language.load(file);
                return result + "\n\nApplied to " + file.getProjectRelativePath()
                    + " using Eclipse resource history. Post-write validation:\n" + applied.validation().format();
            }
            return result + "\n\nThe source file was not modified. Add `apply=true` to /repair to write an error-free candidate explicitly.";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    private boolean shouldApply(String userInput) {
        String text = userInput == null ? "" : userInput.toLowerCase(Locale.ROOT);
        return text.matches("(?s).*\\bapply\\s*[:=]\\s*(true|yes|on)\\b.*")
            || text.contains("apply the repair")
            || text.contains("apply repair")
            || text.contains("write the repair")
            || text.contains("save the repair");
    }
}
