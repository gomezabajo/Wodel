package wodel.ai.assistant.wodel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.osgi.framework.Bundle;

import mutatorenvironment.Program;
import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.ai.assistant.wodel.ai.WodelLanguageService;
import wodel.ai.assistant.wodel.ai.WodelLanguageService.SourceSnapshot;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

/**
 * Generates Wodel seed models with the framework's existing
 * wodel.synthesizer/USE-Kodkod workflow.
 *
 * The synthesizer currently exposes generation through its wizard internals
 * rather than a public headless API. This adapter deliberately invokes that
 * implementation reflectively so the assistant reuses Wodel's established
 * synthesis semantics without copying the solver/generator code or adding a
 * hard bundle dependency to the assistant.
 */
public final class WodelSeedGenerationTask extends MTTask implements IntentAwareTask {
    private static final String SYNTHESIZER_BUNDLE = "wodel.synthesizer";
    private static final String WIZARD_CLASS = "wodel.synthesizer.generator.GenerateWodelWizard";
    private static final String WORKER_CLASS = WIZARD_CLASS + "$GenerateWodelWithProgress";

    public WodelSeedGenerationTask() {
        super("Generate seed models conforming to the metamodel of the selected or named executable Wodel program");
        this.id = "GenerateWodelSeedModels";
    }

    @Override
    public Collection<String> getIntentAliases() {
        return List.of(
            "generate seed models",
            "generate seed model",
            "create seed models",
            "create seed model",
            "produce seed models",
            "synthesise seed models",
            "synthesize seed models",
            "generate seeds"
        );
    }

    @Override
    public int matchIndex(String userUtterance) {
        if (WodelSeedRequestParser.looksLikeLlmSeedGeneration(userUtterance)) return -1;
        if (!WodelSeedRequestParser.looksLikeSeedGeneration(userUtterance)) return -1;
        String lower = userUtterance.toLowerCase(Locale.ROOT);
        int first = Integer.MAX_VALUE;
        for (String token : List.of("generate", "create", "produce", "make", "synthesise", "synthesize", "seed model", "seed-model")) {
            int index = lower.indexOf(token);
            if (index >= 0 && index < first) first = index;
        }
        return first == Integer.MAX_VALUE ? 0 : first;
    }

    @Override
    public String getIntentGroup() {
        return "seed-generation";
    }

    @Override
    public int getIntentPriority() {
        return 120;
    }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        IProject project = WodelWorkbenchContext.selectedProject();
        if (project == null || !ProjectUtils.isWodelProject(project)) {
            return "Select a Wodel project (or a resource inside it) first.";
        }

        Integer requestedCount = WodelSeedRequestParser.parseCount(userInput);
        int count = requestedCount != null ? requestedCount : integerPreference("Number of seed models", 10);
        if (count <= 0) return "The number of seed models must be greater than zero.";

        WodelLanguageService language = new WodelLanguageService();
        final IFile source;
        final SourceSnapshot snapshot;
        try {
            source = language.resolveSource(project, userInput);
            snapshot = language.load(source);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        if (snapshot.validation().hasErrors()) {
            return "Seed-model generation requires an error-free executable Wodel program. Validation problems in '"
                + source.getProjectRelativePath() + "':\n" + snapshot.validation().format();
        }
        if (snapshot.environment() == null || !(snapshot.environment().getDefinition() instanceof Program program)) {
            return "The selected source '" + source.getProjectRelativePath()
                + "' is not an executable Wodel program. Select/name a program rather than a Wodel library.";
        }

        Bundle synthesizer = Platform.getBundle(SYNTHESIZER_BUNDLE);
        if (synthesizer == null) {
            return "The Wodel seed synthesizer bundle ('" + SYNTHESIZER_BUNDLE
                + "') is not installed. Install/enable the standard Wodel synthesizer to generate seed models.";
        }

        String metamodel = program.getMetamodel();
        WorkspaceJob job = new WorkspaceJob("Wodel seed-model generation - " + source.getName()) {
            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) {
                SubMonitor sub = SubMonitor.convert(monitor, "Generating Wodel seed models", 100);
                try {
                    ProjectUtils.setProject(project);
                    project.build(IncrementalProjectBuilder.FULL_BUILD, sub.split(20));
                    ProjectUtils.setProject(project);

                    String outputFolder = ModelManager.getMetaModelPath();
                    if (outputFolder == null || outputFolder.isBlank()) {
                        throw new IllegalStateException("Wodel's configured model folder could not be resolved from data/config/config.txt");
                    }
                    Map<Path, FileStamp> before = snapshotExpectedSeeds(outputFolder, source.getName(), count);

                    invokeNativeSynthesizer(synthesizer, source, count, sub.split(75));
                    project.refreshLocal(IResource.DEPTH_INFINITE, sub.split(5));

                    List<Path> produced = changedExpectedSeeds(outputFolder, source.getName(), count, before);
                    String producedText = produced.isEmpty()
                        ? "No newly-created/updated expected seed files could be confirmed; inspect the Wodel synthesizer console for solver diagnostics."
                        : "Generated/updated " + produced.size() + " seed model(s): "
                            + String.join(", ", produced.stream().map(Path::toString).toList());
                    System.out.println("[Wodel AI] Seed generation completed for '" + source.getProjectRelativePath()
                        + "' using metamodel '" + metamodel + "'. Requested=" + count + ". " + producedText);
                    return Status.OK_STATUS;
                } catch (Throwable e) {
                    Throwable root = unwrap(e);
                    String message = safeMessage(root);
                    System.out.println("[Wodel AI] Seed generation failed for '" + source.getProjectRelativePath() + "': " + message);
                    root.printStackTrace(System.out);
                    return new Status(IStatus.ERROR, "wodel.ai.assistant", "Wodel seed-model generation failed: " + message, root);
                } finally {
                    sub.done();
                }
            }
        };
        job.setUser(true);
        job.schedule();

        return "Started generation of " + count + " seed model" + (count == 1 ? "" : "s")
            + " for Wodel program '" + source.getProjectRelativePath() + "' using its metamodel '" + metamodel + "'. "
            + "The native Wodel USE/Kodkod seed synthesizer is used with all mutation blocks and the default root constraint. "
            + "Completion and generated model paths will be reported in the Wodel console/chat system output.";
    }

    private static void invokeNativeSynthesizer(Bundle synthesizer, IFile source, int count, IProgressMonitor monitor) throws Exception {
        Class<?> wizardClass = synthesizer.loadClass(WIZARD_CLASS);
        Class<?> workerClass = synthesizer.loadClass(WORKER_CLASS);

        // The synthesizer stores wizard choices in static fields. Serialise
        // assistant-driven runs so concurrent requests cannot overwrite them.
        synchronized (wizardClass) {
            setStaticField(wizardClass, "file", source);
            setStaticField(wizardClass, "numSeeds", Integer.valueOf(count));
            setStaticField(wizardClass, "initialPath", "");
            setStaticField(wizardClass, "customOCL", "");
            setStaticField(wizardClass, "forceRoot", Boolean.TRUE);
            setStaticField(wizardClass, "blockNames", new ArrayList<>(List.of("*")));
            setStaticField(wizardClass, "numObjects", null);
            setStaticField(wizardClass, "classNames", new ArrayList<String>());
            setStaticField(wizardClass, "tagsByClass", null);
            setStaticField(wizardClass, "savedConfiguration", null);
            setStaticField(wizardClass, "configurationFile", null);
            setStaticFieldIfPresent(wizardClass, "predefinedConfiguration", "");
            setStaticFieldIfPresent(wizardClass, "configurationName", "");

            Constructor<?> constructor = workerClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object worker = constructor.newInstance();
            Method run = workerClass.getDeclaredMethod("run", IProgressMonitor.class);
            run.setAccessible(true);
            try {
                run.invoke(worker, monitor);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause instanceof Exception exception) throw exception;
                if (cause instanceof Error error) throw error;
                throw e;
            }
        }
    }

    private static void setStaticField(Class<?> type, String name, Object value) throws Exception {
        Field field = type.getDeclaredField(name);
        field.setAccessible(true);
        field.set(null, value);
    }

    private static void setStaticFieldIfPresent(Class<?> type, String name, Object value) throws Exception {
        try {
            setStaticField(type, name, value);
        } catch (NoSuchFieldException ignored) {
            // Keeps the adapter compatible with synthesizer versions where
            // these optional configuration fields do not exist.
        }
    }

    private static Map<Path, FileStamp> snapshotExpectedSeeds(String folder, String mutatorName, int count) {
        Map<Path, FileStamp> result = new LinkedHashMap<>();
        for (Path path : expectedSeedPaths(folder, mutatorName, count)) result.put(path, FileStamp.of(path));
        return result;
    }

    private static List<Path> changedExpectedSeeds(String folder, String mutatorName, int count, Map<Path, FileStamp> before) {
        List<Path> changed = new ArrayList<>();
        for (Path path : expectedSeedPaths(folder, mutatorName, count)) {
            FileStamp oldStamp = before.get(path);
            FileStamp newStamp = FileStamp.of(path);
            if (newStamp.exists() && !newStamp.equals(oldStamp)) changed.add(path);
        }
        return changed;
    }

    private static List<Path> expectedSeedPaths(String folder, String mutatorName, int count) {
        String base = mutatorName.toLowerCase(Locale.ROOT).endsWith(".mutator")
            ? mutatorName.substring(0, mutatorName.length() - ".mutator".length())
            : mutatorName;
        List<Path> paths = new ArrayList<>();
        Path root = Path.of(folder);
        for (int i = 0; i < count; i++) paths.add(root.resolve(base + i + ".model"));
        return paths;
    }

    private record FileStamp(boolean exists, long modified, long size) {
        static FileStamp of(Path path) {
            try {
                if (!Files.isRegularFile(path)) return new FileStamp(false, -1L, -1L);
                return new FileStamp(true, Files.getLastModifiedTime(path).toMillis(), Files.size(path));
            } catch (Exception e) {
                return new FileStamp(false, -1L, -1L);
            }
        }
    }

    private static int integerPreference(String key, int fallback) {
        String value = Platform.getPreferencesService().getString("wodel.dsls.Wodel", key, Integer.toString(fallback), null);
        try { return Integer.parseInt(value); } catch (NumberFormatException e) { return fallback; }
    }

    private static Throwable unwrap(Throwable throwable) {
        Throwable current = throwable;
        while (current instanceof InvocationTargetException ite && ite.getCause() != null) current = ite.getCause();
        return current;
    }

    private static String safeMessage(Throwable throwable) {
        if (throwable == null) return "Unknown error";
        String message = throwable.getMessage();
        return message == null || message.isBlank() ? throwable.getClass().getSimpleName() : message;
    }
}
