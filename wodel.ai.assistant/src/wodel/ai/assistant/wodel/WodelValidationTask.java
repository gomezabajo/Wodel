package wodel.ai.assistant.wodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.dsls.WodelStandaloneSetup;
import wodel.dsls.runner.WodelUtils;

/** Validates all Wodel source files, including libraries and malformed programs. */
public class WodelValidationTask extends MTTask implements IntentAwareTask {
    public WodelValidationTask() {
        super("Validate all .mutator source files in the selected Wodel project");
        this.id = "ValidateWodelProject";
    }

    @Override public Collection<String> getIntentAliases() {
        return List.of("validate wodel", "validate mutator", "validate project", "validate this wodel project", "check mutator", "check wodel program", "check wodel project", "wodel errors", "wodel validation");
    }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        IProject project = WodelWorkbenchContext.selectedProject();
        if (project == null) return "Select a Wodel project (or a resource inside it) first.";

        IContainer base = project.getFolder("src");
        if (!base.exists()) base = project;
        List<IFile> sources = new ArrayList<>(WodelUtils.findFilesByExtension(base, "mutator"));
        sources.sort(Comparator.comparing(f -> f.getProjectRelativePath().toString(), String.CASE_INSENSITIVE_ORDER));
        if (sources.isEmpty()) return "Wodel project '" + project.getName() + "' contains no .mutator source files.";

        Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
        XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
        IResourceValidator validator = injector.getInstance(IResourceValidator.class);
        List<String> output = new ArrayList<>();
        int problems = 0;

        for (IFile file : sources) {
            try {
                Resource resource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);
                List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
                List<Issue> relevant = issues.stream()
                    .filter(i -> i.getSeverity() == Severity.ERROR || i.getSeverity() == Severity.WARNING)
                    .toList();
                if (relevant.isEmpty()) {
                    output.add("- " + file.getProjectRelativePath() + ": OK");
                } else {
                    output.add("- " + file.getProjectRelativePath() + ":");
                    for (Issue issue : relevant) {
                        problems++;
                        Integer lineNumber = issue.getLineNumber();
                        String line = lineNumber == null ? "" : " line " + lineNumber;
                        output.add("    " + issue.getSeverity() + line + ": " + issue.getMessage());
                    }
                }
            } catch (Exception e) {
                problems++;
                output.add("- " + file.getProjectRelativePath() + ": ERROR: " + e.getMessage());
            }
        }

        output.add(0, problems == 0
            ? "Wodel validation completed with no errors or warnings."
            : "Wodel validation found " + problems + " error/warning item" + (problems == 1 ? "." : "s."));
        return String.join(System.lineSeparator(), output);
    }
}
