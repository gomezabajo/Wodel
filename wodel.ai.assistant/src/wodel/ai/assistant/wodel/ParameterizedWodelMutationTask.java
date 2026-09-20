package wodel.ai.assistant.wodel;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.dsls.WodelStandaloneSetup;
import wodel.utils.manager.IMutatorExecutor;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.ProjectUtils;
import wodel.utils.manager.WodelUtils;
import wodel.utils.manager.MutatorUtils.MutationResults;

/**
 * Parameterized conversational execution. If an executable program is named,
 * or an executable .mutator file is active, its generated Dynamic class is
 * invoked directly. Otherwise the generated project DynamicLauncher is used.
 */
public class ParameterizedWodelMutationTask extends MTTask implements IntentAwareTask {
    public ParameterizedWodelMutationTask() {
        super("Generate Wodel mutants with an optional target program plus explicit mutant count, attempts, blocks, registry/metrics flags and/or deterministic seed");
        this.id = "ParameterizedWodelMutation";
    }

    @Override public Collection<String> getIntentAliases() { return List.of(); }
    @Override public String getIntentGroup() { return "mutation-execution"; }
    @Override public int getIntentPriority() { return 100; }

    @Override
    public int matchIndex(String userUtterance) {
        if (!WodelMutationRequestParser.looksLikeParameterizedMutation(userUtterance)) return -1;
        String lower = userUtterance.toLowerCase(Locale.ROOT);
        int first = Integer.MAX_VALUE;
        for (String token : List.of("generate", "create", "produce", "make", "execute", "run")) {
            int index = lower.indexOf(token);
            if (index >= 0 && index < first) first = index;
        }
        if (first != Integer.MAX_VALUE) return first;
        for (String token : List.of("mutant", "mutation", "mutator")) {
            int index = lower.indexOf(token);
            if (index >= 0 && index < first) first = index;
        }
        return first == Integer.MAX_VALUE ? 0 : first;
    }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        IProject project = WodelWorkbenchContext.selectedProject();
        if (project == null || !ProjectUtils.isWodelProject(project)) {
            return "Select a Wodel project (or a resource inside it) first.";
        }

        WodelMutationRequest request = WodelMutationRequestParser.parse(userInput);
        IFile targetProgram;
        try {
            targetProgram = resolveTargetProgram(project, request.programName());
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        int maxAttempts = request.maxAttempts() != null ? request.maxAttempts() : integerPreference("Number of attempts", 3);
        int numMutants = request.numMutants() != null ? request.numMutants() : integerPreference("Number of mutants", 3);
        boolean registry = request.registry() != null ? request.registry() : booleanPreference("Generate registry", true);
        boolean metrics = request.metrics() != null ? request.metrics() : booleanPreference("Generate net mutant footprints", false);
        boolean debugMetrics = request.debugMetrics() != null ? request.debugMetrics() : booleanPreference("Generate debug mutant footprints", false);
        boolean serialize = request.serialize() != null ? request.serialize() : true;
        long seed = request.executionSeed() != null ? request.executionSeed() : System.nanoTime();
        String[] blocks = request.blockNames().isEmpty() ? null : request.blockNames().toArray(String[]::new);

        if (numMutants <= 0) return "The number of mutants must be greater than zero.";
        if (maxAttempts <= 0) return "The maximum number of attempts must be greater than zero.";

        String scope = targetProgram == null
            ? "project '" + project.getName() + "'"
            : "program '" + targetProgram.getProjectRelativePath() + "'";

        WorkspaceJob job = new WorkspaceJob("Wodel AI mutation generation - " + project.getName()) {
            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) {
                SubMonitor sub = SubMonitor.convert(monitor, "Generating Wodel mutants", 100);
                try {
                    project.build(IncrementalProjectBuilder.FULL_BUILD, sub.split(25));
                    MutationResults results = targetProgram == null
                        ? executeProject(project, maxAttempts, numMutants, registry, metrics, debugMetrics, blocks, serialize, seed, sub.split(70))
                        : executeProgram(project, targetProgram, maxAttempts, numMutants, registry, metrics, debugMetrics, blocks, serialize, seed, sub.split(70));
                    project.refreshLocal(IResource.DEPTH_INFINITE, sub.split(5));

                    System.out.println("[Wodel AI] Parameterized generation completed for " + scope + ". "
                        + "Generated mutants=" + results.getNumMutantsGenerated()
                        + ", applied mutators=" + results.getNumMutatorsApplied()
                        + ", seed=" + seed
                        + (blocks == null ? ", blocks=<all>." : ", blocks=" + String.join(", ", blocks) + "."));
                    return Status.OK_STATUS;
                } catch (Exception e) {
                    System.out.println("[Wodel AI] Parameterized generation failed for " + scope + ": " + e.getMessage());
                    e.printStackTrace(System.out);
                    return new Status(IStatus.ERROR, "wodel.ai.assistant", "Parameterized Wodel generation failed", e);
                } finally {
                    sub.done();
                }
            }
        };
        job.setUser(true);
        job.schedule();

        return "Started parameterized Wodel generation for " + scope + " with "
            + "mutants=" + numMutants + ", attempts=" + maxAttempts + ", seed=" + seed
            + ", registry=" + registry + ", metrics=" + metrics + ", debugMetrics=" + debugMetrics
            + ", serialize=" + serialize
            + (blocks == null ? ", blocks=<all>." : ", blocks=" + String.join(", ", blocks) + ".")
            + " The completion summary will be written to the Wodel console/chat system output."
            + (request.numMutants() == null ? "" : " Note: a program-declared mutant count or exhaustive mode can override the requested mutant count.");
    }

    private static MutationResults executeProject(IProject project, int maxAttempts, int numMutants,
            boolean registry, boolean metrics, boolean debugMetrics, String[] blocks,
            boolean serialize, long seed, IProgressMonitor monitor) throws Exception {
        String projectName = project.getName();
        String launcherName = "mutator." + projectName + "." + projectName.replace(".", "_") + "DynamicLauncher";
        Class<?> launcherClass = loadGeneratedClass(project, launcherName);
        Object object = launcherClass.getDeclaredConstructor().newInstance();
        if (!(object instanceof IMutatorExecutor launcher)) {
            throw new IllegalStateException(launcherName + " does not implement IMutatorExecutor");
        }
        Map<String, List<String>> classes = new LinkedHashMap<>();
        Map<String, EPackage> registeredPackages = new LinkedHashMap<>();
        return launcher.execute(maxAttempts, numMutants, registry, metrics, debugMetrics,
            blocks, project, monitor, serialize, null, classes, registeredPackages, seed);
    }

    private static MutationResults executeProgram(IProject project, IFile programFile,
            int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics,
            String[] blocks, boolean serialize, long seed, IProgressMonitor monitor) throws Exception {
        String baseName = programFile.getName();
        int dot = baseName.lastIndexOf('.');
        if (dot > 0) baseName = baseName.substring(0, dot);
        String dynamicName = baseName + "Dynamic";
        String className = "mutator." + dynamicName + "." + dynamicName;
        Class<?> mutatorClass = loadGeneratedClass(project, className);
        Object object = mutatorClass.getDeclaredConstructor().newInstance();
        if (!(object instanceof MutatorUtils mutator)) {
            throw new IllegalStateException(className + " does not extend MutatorUtils");
        }

        String metamodel = readMetamodel(programFile);
        List<EPackage> packages = ModelManager.loadMetaModel(metamodel, mutatorClass);
        Map<String, EPackage> registeredPackages = new LinkedHashMap<>();
        Map<String, EPackage> localRegisteredPackages = null;
        boolean wasRegistered = ModelManager.isRegistered(packages);
        try {
            if (wasRegistered) {
                localRegisteredPackages = ModelManager.unregisterMetaModel(packages);
            }
            Map<String, List<String>> classes = new LinkedHashMap<>();
            return mutator.execute(maxAttempts, numMutants, registry, metrics, debugMetrics,
                packages, registeredPackages, localRegisteredPackages, blocks, project,
                monitor, serialize, null, classes, seed);
        } finally {
            if (wasRegistered) {
                if (localRegisteredPackages != null) ModelManager.registerMetaModel(localRegisteredPackages);
                if (!registeredPackages.isEmpty()) ModelManager.registerMetaModel(registeredPackages);
            }
        }
    }

    private static Class<?> loadGeneratedClass(IProject project, String className) throws Exception {
        Class<?> type = WodelUtils.loadClass(project, className);
        if (type != null) return type;
        project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
        type = WodelUtils.loadClass(project, className);
        if (type == null) throw new ClassNotFoundException("Cannot load generated Wodel class: " + className);
        return type;
    }

    private static String readMetamodel(IFile programFile) throws Exception {
        Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
        XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
        Resource resource = rs.getResource(URI.createPlatformResourceURI(programFile.getFullPath().toString(), true), true);
        EObject root = resource.getContents().isEmpty() ? null : resource.getContents().get(0);
        if (!(root instanceof MutatorEnvironment env) || !(env.getDefinition() instanceof Program program)) {
            throw new IllegalArgumentException(programFile.getName() + " is not an executable Wodel Program.");
        }
        if (program.getMetamodel() == null || program.getMetamodel().isBlank()) {
            throw new IllegalArgumentException("Wodel program " + programFile.getName() + " does not declare a metamodel.");
        }
        return program.getMetamodel();
    }

    private static IFile resolveTargetProgram(IProject project, String requested) throws Exception {
        List<IFile> programs = wodel.dsls.runner.WodelUtils.getMutatorFiles(project);
        if (requested != null) {
            String wanted = normalize(requested);
            List<IFile> matches = programs.stream().filter(file -> matches(file, wanted)).toList();
            if (matches.size() == 1) return matches.get(0);
            String available = programs.isEmpty() ? "<none>" : programs.stream()
                .map(f -> f.getProjectRelativePath().toString()).reduce((a, b) -> a + ", " + b).orElse("<none>");
            if (matches.isEmpty()) throw new IllegalArgumentException("I could not find executable Wodel program '" + requested + "'. Available programs: " + available);
            throw new IllegalArgumentException("Program name '" + requested + "' is ambiguous. Use a project-relative path. Matches: "
                + matches.stream().map(f -> f.getProjectRelativePath().toString()).reduce((a, b) -> a + ", " + b).orElse(""));
        }

        Optional<IFile> active = ProjectUtils.getActiveFile();
        if (active.isPresent()) {
            IFile file = active.get();
            if (project.equals(file.getProject()) && "mutator".equalsIgnoreCase(file.getFileExtension())) {
                for (IFile executable : programs) {
                    if (executable.getFullPath().equals(file.getFullPath())) return executable;
                }
                throw new IllegalArgumentException("The active .mutator file '" + file.getProjectRelativePath()
                    + "' is not an executable Wodel Program (it may be a library or contain validation errors). ");
            }
        }
        return null;
    }

    private static boolean matches(IFile file, String wanted) {
        String relative = normalize(file.getProjectRelativePath().toString());
        String name = normalize(file.getName());
        String base = name.endsWith(".mutator") ? name.substring(0, name.length() - ".mutator".length()) : name;
        String requestedBase = wanted.endsWith(".mutator") ? wanted.substring(0, wanted.length() - ".mutator".length()) : wanted;
        String relativeBase = relative.endsWith(".mutator") ? relative.substring(0, relative.length() - ".mutator".length()) : relative;
        return relative.equals(wanted) || relativeBase.equals(requestedBase) || name.equals(wanted) || base.equals(requestedBase);
    }

    private static String normalize(String value) {
        return value.trim().replace('\\', '/').toLowerCase(Locale.ROOT);
    }

    private static int integerPreference(String key, int fallback) {
        String value = Platform.getPreferencesService().getString("wodel.dsls.Wodel", key, Integer.toString(fallback), null);
        try { return Integer.parseInt(value); } catch (NumberFormatException e) { return fallback; }
    }

    private static boolean booleanPreference(String key, boolean fallback) {
        return Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", key, fallback, null);
    }
}
