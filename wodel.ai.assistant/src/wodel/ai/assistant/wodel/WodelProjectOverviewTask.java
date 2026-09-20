package wodel.ai.assistant.wodel;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.dsls.runner.WodelUtils;

/** Reports the executable Wodel programs in the currently selected project. */
public class WodelProjectOverviewTask extends MTTask implements IntentAwareTask {

    public WodelProjectOverviewTask() {
        super("Show the active Wodel project and list its executable .mutator programs");
        this.id = "WodelProjectOverview";
    }

    @Override
    public Collection<String> getIntentAliases() {
        return List.of(
            "wodel project overview",
            "project overview",
            "project status",
            "list wodel programs",
            "list mutator programs",
            "show mutator programs",
            "what wodel programs",
            "which wodel programs"
        );
    }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        IProject project = selectedProject();
        if (project == null) {
            return "Select a Wodel project (or a resource inside it) in Project/Package Explorer first.";
        }

        List<IFile> programs = WodelUtils.getMutatorFiles(project);
        if (programs.isEmpty()) {
            return "Wodel project '" + project.getName()
                + "' contains no executable .mutator programs. Library-only .mutator files are not listed.";
        }

        String names = programs.stream()
            .map(f -> "- " + f.getProjectRelativePath().toString())
            .collect(Collectors.joining(System.lineSeparator()));

        return "Wodel project '" + project.getName() + "' has " + programs.size()
            + " executable program" + (programs.size() == 1 ? "" : "s") + ":"
            + System.lineSeparator() + names;
    }

    private IProject selectedProject() {
        return WodelWorkbenchContext.selectedProject();
    }
}
