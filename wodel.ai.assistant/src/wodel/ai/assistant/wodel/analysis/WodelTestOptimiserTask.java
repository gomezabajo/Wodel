package wodel.ai.assistant.wodel.analysis;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.ai.assistant.wodel.WodelWorkbenchContext;

/** Runs installed Wodel-Test mutation optimisers through the extension point. */
public final class WodelTestOptimiserTask extends MTTask implements IntentAwareTask {
    public WodelTestOptimiserTask() {
        super("Run installed Wodel-Test mutation optimisers, such as the subsumption mutation optimiser");
        this.id = "OptimiseWodelTestMutants";
    }

    @Override
    public Collection<String> getIntentAliases() {
        return List.of("optimise mutants", "optimize mutants", "subsumption optimiser", "subsumption optimizer", "optimise wodel-test");
    }

    @Override
    public String getIntentGroup() { return "wodel-test"; }

    @Override
    public int getIntentPriority() { return 110; }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        IProject project = WodelWorkbenchContext.selectedProject();
        if (project == null) return "Select the relevant Wodel/Wodel-Test project first.";
        IConfigurationElement[] elements = Platform.getExtensionRegistry()
            .getConfigurationElementsFor("wodeltest.optimiser.MutTestingOptimiser");
        if (elements.length == 0) return "No Wodel-Test mutation optimiser extension is installed.";

        StringBuilder out = new StringBuilder();
        for (IConfigurationElement element : elements) {
            try {
                Object optimiser = element.createExecutableExtension("class");
                Method getName = optimiser.getClass().getMethod("getName");
                Method optimise = optimiser.getClass().getMethod("doOptimise", IProject.class);
                String name = String.valueOf(getName.invoke(optimiser));
                boolean ok = (Boolean) optimise.invoke(optimiser, project);
                out.append(out.length() == 0 ? "" : "\n").append(name).append(": ").append(ok ? "completed" : "reported failure");
            } catch (Exception e) {
                out.append(out.length() == 0 ? "" : "\n").append(element.getAttribute("class"))
                    .append(": failed - ").append(WodelMutantComparisonTask.safeMessage(e));
            }
        }
        out.append("\nDetailed optimiser statistics are also written by the optimiser to the Wodel console.");
        return out.toString();
    }
}
