package wodel.ai.assistant.wodel;

import org.eclipse.core.resources.IProject;

import wodel.utils.manager.ProjectUtils;

public final class WodelWorkbenchContext {
    private WodelWorkbenchContext() {}

    public static IProject selectedProject() {
        return ProjectUtils.getActiveWodelProject().orElse(null);
    }
}
