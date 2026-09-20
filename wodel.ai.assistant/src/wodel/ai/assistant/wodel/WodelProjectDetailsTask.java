package wodel.ai.assistant.wodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import mutatorenvironment.Block;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.dsls.WodelStandaloneSetup;
import wodel.dsls.runner.WodelUtils;

public class WodelProjectDetailsTask extends MTTask implements IntentAwareTask {
    public WodelProjectDetailsTask() {
        super("Show executable Wodel programs, their metamodels and mutation blocks");
        this.id = "WodelProjectDetails";
    }

    @Override public Collection<String> getIntentAliases() {
        return List.of("list wodel blocks", "show wodel blocks", "mutation blocks", "list mutation blocks", "wodel program details", "programs and blocks", "program blocks", "show operators", "list operators");
    }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        IProject project = WodelWorkbenchContext.selectedProject();
        if (project == null) return "Select a Wodel project (or a resource inside it) first.";
        List<IFile> programs = WodelUtils.getMutatorFiles(project);
        if (programs.isEmpty()) return "Wodel project '" + project.getName() + "' contains no executable .mutator programs.";

        Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
        XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
        List<String> lines = new ArrayList<>();
        lines.add("Wodel project '" + project.getName() + "':");
        for (IFile file : programs) {
            Resource resource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);
            EObject root = resource.getContents().isEmpty() ? null : resource.getContents().get(0);
            if (!(root instanceof MutatorEnvironment env) || !(env.getDefinition() instanceof Program program)) continue;
            lines.add("- " + file.getProjectRelativePath() + " | metamodel=" + program.getMetamodel()
                + " | top-level commands=" + env.getCommands().size());
            if (env.getBlocks().isEmpty()) {
                lines.add("    blocks: <none>");
            } else {
                for (Block block : env.getBlocks()) {
                    lines.add("    block " + block.getName() + " (" + block.getCommands().size() + " command" + (block.getCommands().size() == 1 ? "" : "s") + ")");
                }
            }
        }
        return String.join(System.lineSeparator(), lines);
    }
}
