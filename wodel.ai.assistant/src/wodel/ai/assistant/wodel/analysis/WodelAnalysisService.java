package wodel.ai.assistant.wodel.analysis;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import appliedMutations.AppMutation;
import mutatorenvironment.Program;
import wodel.ai.assistant.wodel.ai.WodelLanguageService;
import wodel.ai.assistant.wodel.ai.WodelLanguageService.SourceSnapshot;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.ProjectUtils;

/**
 * Read-only analysis facade shared by the conversational post-generation tasks.
 * It reuses Wodel's compiled mutation-program model and applied-mutation registry.
 */
public final class WodelAnalysisService {
    private final WodelLanguageService language = new WodelLanguageService();

    public record RegistryEntry(
            String registryPath,
            String seedPath,
            List<String> mutantPaths,
            List<AppMutation> mutations) {
    }

    public record CommandInfo(
            String block,
            String kind,
            String uri,
            Set<String> seedPaths,
            Set<String> mutantPaths,
            int applications) {
        public boolean covered() { return applications > 0; }
        public String displayName() {
            return (block == null || block.isBlank() ? "<top-level>" : block) + " / " + kind;
        }
    }

    public record AnalysisContext(
            IProject project,
            IFile source,
            SourceSnapshot snapshot,
            Program program,
            String metamodel,
            Path outputFolder,
            Path compiledProgramPath,
            Resource compiledProgram,
            List<RegistryEntry> registryEntries,
            List<CommandInfo> commands) {
    }

    public record MutantTrace(
            String requested,
            String resolvedMutantPath,
            String seedPath,
            String registryPath,
            List<AppMutation> mutations) {
    }

    public AnalysisContext resolve(String userInput) throws Exception {
        IProject project = language.activeProject();
        if (project == null || !ProjectUtils.isWodelProject(project)) {
            throw new IllegalStateException("Select a Wodel project (or a resource inside it) first.");
        }

        IFile source = language.resolveSource(project, userInput);
        SourceSnapshot snapshot = language.load(source);
        if (snapshot.validation().hasErrors()) {
            throw new IllegalStateException("The selected Wodel source has validation errors:\n" + snapshot.validation().format());
        }
        if (snapshot.environment() == null || !(snapshot.environment().getDefinition() instanceof Program program)) {
            throw new IllegalStateException("The selected source is not an executable Wodel program.");
        }

        ProjectUtils.setProject(project);
        String output = ModelManager.getOutputPath();
        if (output == null || output.isBlank()) {
            throw new IllegalStateException("Wodel's generated-output folder could not be resolved from data/config/config.txt.");
        }
        Path outputFolder = Path.of(output);
        Files.createDirectories(outputFolder);

        String base = source.getName();
        int dot = base.lastIndexOf('.');
        if (dot > 0) base = base.substring(0, dot);
        Path compiledProgramPath = outputFolder.resolve(base + ".model");
        if (!Files.isRegularFile(compiledProgramPath)) {
            project.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
        }
        if (!Files.isRegularFile(compiledProgramPath)) {
            throw new IllegalStateException(
                "The compiled Wodel program model was not found at " + compiledProgramPath
                + ". Build/execute the Wodel project first.");
        }

        Resource compiledProgram = loadCompiledProgram(compiledProgramPath);
        List<RegistryEntry> registryEntries = loadRegistryEntries(outputFolder);
        List<CommandInfo> commands = buildCommandInfo(compiledProgram, registryEntries);

        return new AnalysisContext(
            project, source, snapshot, program, program.getMetamodel(), outputFolder,
            compiledProgramPath, compiledProgram, registryEntries, commands);
    }

    public MutantTrace resolveMutant(AnalysisContext context, String userInput) {
        String requested = extractModelName(userInput);
        if (requested == null || requested.isBlank()) {
            throw new IllegalArgumentException(
                "Name the generated mutant to analyse, for example: /explain-mutant Output3.model");
        }
        String wanted = normalize(requested);
        List<MutantTrace> matches = new ArrayList<>();
        for (RegistryEntry entry : context.registryEntries()) {
            for (String mutant : entry.mutantPaths()) {
                String normalized = normalize(mutant);
                if (normalized.equals(wanted)
                        || normalized.endsWith("/" + wanted)
                        || Path.of(mutant).getFileName().toString().equalsIgnoreCase(Path.of(requested).getFileName().toString())) {
                    matches.add(new MutantTrace(requested, mutant, entry.seedPath(), entry.registryPath(), entry.mutations()));
                }
            }
        }
        if (matches.isEmpty()) {
            throw new IllegalArgumentException("No generated mutant matching '" + requested + "' was found under " + context.outputFolder() + ".");
        }
        if (matches.size() > 1) {
            Set<String> unique = new LinkedHashSet<>();
            for (MutantTrace match : matches) unique.add(match.resolvedMutantPath());
            if (unique.size() > 1) {
                throw new IllegalArgumentException("Mutant name '" + requested + "' is ambiguous. Matches: " + String.join(", ", unique));
            }
        }
        return matches.get(0);
    }

    public String adequacyReport(AnalysisContext context) {
        int total = context.commands().size();
        long covered = context.commands().stream().filter(CommandInfo::covered).count();
        StringBuilder out = new StringBuilder();
        out.append("Mutation adequacy for ").append(context.source().getProjectRelativePath()).append('\n');
        out.append("Commands covered: ").append(covered).append('/').append(total);
        if (total > 0) out.append(String.format(Locale.ROOT, " (%.1f%%)", 100.0 * covered / total));
        out.append("\nRegistry entries: ").append(context.registryEntries().size()).append('\n');
        for (CommandInfo command : context.commands()) {
            out.append("\n- ").append(command.covered() ? "[COVERED] " : "[UNCOVERED] ")
                .append(command.displayName())
                .append(" | applications=").append(command.applications())
                .append(" | seeds=").append(command.seedPaths().size())
                .append(" | mutants=").append(command.mutantPaths().size());
        }
        return out.toString();
    }

    public String traceReport(MutantTrace trace) {
        StringBuilder out = new StringBuilder();
        out.append("Mutant: ").append(trace.resolvedMutantPath()).append('\n');
        out.append("Seed: ").append(trace.seedPath() == null ? "<unknown>" : trace.seedPath()).append('\n');
        out.append("Registry: ").append(trace.registryPath()).append('\n');
        out.append("Applied mutations: ").append(trace.mutations().size());
        int i = 1;
        for (AppMutation mutation : trace.mutations()) {
            out.append("\n\n").append(i++).append(". ").append(formatMutation(mutation));
        }
        return out.toString();
    }

    public Map<String, Set<String>> commandsBySeed(AnalysisContext context) {
        Map<String, Set<String>> result = new LinkedHashMap<>();
        for (CommandInfo command : context.commands()) {
            for (String seed : command.seedPaths()) {
                result.computeIfAbsent(seed, ignored -> new LinkedHashSet<>()).add(command.uri());
            }
        }
        return result;
    }

    private Resource loadCompiledProgram(Path compiledProgramPath) throws Exception {
        Bundle bundle = Platform.getBundle("wodel.models");
        if (bundle == null) throw new IllegalStateException("The wodel.models bundle is not installed.");
        URL entry = bundle.getEntry("/model/MutatorEnvironment.ecore");
        String ecore = FileLocator.resolve(entry).getFile();
        List<EPackage> packages = ModelManager.loadMetaModel(ecore);
        return ModelManager.loadModel(packages, compiledProgramPath.toString());
    }

    private List<RegistryEntry> loadRegistryEntries(Path outputFolder) throws Exception {
        Bundle bundle = Platform.getBundle("wodel.models");
        if (bundle == null) throw new IllegalStateException("The wodel.models bundle is not installed.");
        URL entry = bundle.getEntry("/model/AppliedMutations.ecore");
        String ecore = FileLocator.resolve(entry).getFile();
        List<EPackage> packages = ModelManager.loadMetaModel(ecore);
        Map<String, Resource> registryModels = new LinkedHashMap<>();
        MutatorUtils.getRegistryModels(outputFolder.toFile(), packages, registryModels);

        List<RegistryEntry> result = new ArrayList<>();
        for (Map.Entry<String, Resource> item : registryModels.entrySet()) {
            List<AppMutation> mutations = new ArrayList<>();
            for (EObject object : ModelManager.getAllObjects(item.getValue())) {
                if (object instanceof AppMutation mutation) mutations.add(mutation);
            }
            String seed;
            try { seed = MutatorUtils.getSeedFromRegistry(item.getKey()); }
            catch (Exception e) { seed = null; }
            if (seed == null || seed.isBlank()) {
                try {
                    Path relative = outputFolder.relativize(Path.of(item.getKey()));
                    if (relative.getNameCount() > 0) {
                        String seedBase = relative.getName(0).toString();
                        String modelsPath = ModelManager.getMetaModelPath();
                        if (modelsPath != null && !modelsPath.isBlank()) {
                            seed = Path.of(modelsPath).resolve(seedBase + ".model").toString();
                        }
                    }
                } catch (Exception ignored) {
                }
            }
            List<String> mutants;
            try { mutants = MutatorUtils.getMutantsFromRegistry(item.getKey()); }
            catch (Exception e) { mutants = List.of(); }
            result.add(new RegistryEntry(item.getKey(), seed, List.copyOf(mutants), List.copyOf(mutations)));
        }
        result.sort(Comparator.comparing(RegistryEntry::registryPath, String.CASE_INSENSITIVE_ORDER));
        return result;
    }

    private List<CommandInfo> buildCommandInfo(Resource program, List<RegistryEntry> entries) {
        Map<String, MutableCommandInfo> commands = new LinkedHashMap<>();
        Map<String, List<EObject>> blocks = MutatorUtils.getBlockCommands(program);
        for (Map.Entry<String, List<EObject>> block : blocks.entrySet()) {
            for (EObject command : block.getValue()) addCommand(commands, block.getKey(), command);
        }
        for (EObject command : MutatorUtils.getCommands(program)) {
            String uri = fragment(command);
            if (!commands.containsKey(uri)) addCommand(commands, "<top-level>", command);
        }

        for (RegistryEntry entry : entries) {
            for (AppMutation mutation : entry.mutations()) {
                EObject def = mutation.getDef();
                if (def == null) continue;
                MutableCommandInfo command = commands.get(fragment(def));
                if (command == null) continue;
                command.applications++;
                if (entry.seedPath() != null) command.seeds.add(entry.seedPath());
                command.mutants.addAll(entry.mutantPaths());
            }
        }

        List<CommandInfo> result = new ArrayList<>();
        for (MutableCommandInfo command : commands.values()) result.add(command.freeze());
        return result;
    }

    private void addCommand(Map<String, MutableCommandInfo> commands, String block, EObject command) {
        String uri = fragment(command);
        commands.putIfAbsent(uri, new MutableCommandInfo(block, command.eClass().getName(), uri));
    }

    private static String fragment(EObject object) {
        if (object == null) return "";
        String uri = EcoreUtil.getURI(object).toString().replace("//", "/");
        int hash = uri.indexOf('#');
        return hash >= 0 ? uri.substring(hash) : uri;
    }

    private String formatMutation(AppMutation mutation) {
        StringBuilder out = new StringBuilder(mutation.eClass().getName());
        if (mutation.getDef() != null) {
            out.append("\n   command=").append(fragment(mutation.getDef()));
        }
        for (EAttribute attribute : mutation.eClass().getEAllAttributes()) {
            if (!mutation.eIsSet(attribute)) continue;
            Object value = mutation.eGet(attribute);
            out.append("\n   ").append(attribute.getName()).append('=').append(String.valueOf(value));
        }
        for (EReference reference : mutation.eClass().getEAllReferences()) {
            if (reference.isContainment() || "def".equals(reference.getName()) || !mutation.eIsSet(reference)) continue;
            Object value = mutation.eGet(reference);
            out.append("\n   ").append(reference.getName()).append('=').append(formatReferenceValue(value));
        }
        return out.toString();
    }

    private String formatReferenceValue(Object value) {
        if (value instanceof EObject object) return fragment(object);
        if (value instanceof List<?> list) {
            List<String> values = new ArrayList<>();
            for (Object item : list) {
                values.add(item instanceof EObject object ? fragment(object) : String.valueOf(item));
            }
            return values.toString();
        }
        return String.valueOf(value);
    }

    private String extractModelName(String text) {
        if (text == null) return null;
        for (String token : text.split("\\s+")) {
            String cleaned = token.replaceAll("^[\\\"'`(]+|[\\\"'`,;:)]+$", "");
            if (cleaned.toLowerCase(Locale.ROOT).endsWith(".model")) return cleaned;
        }
        return null;
    }

    private String normalize(String value) {
        return value.replace('\\', '/').toLowerCase(Locale.ROOT).replaceFirst("^file:/+", "/");
    }

    private static final class MutableCommandInfo {
        final String block;
        final String kind;
        final String uri;
        final Set<String> seeds = new LinkedHashSet<>();
        final Set<String> mutants = new LinkedHashSet<>();
        int applications;

        MutableCommandInfo(String block, String kind, String uri) {
            this.block = block;
            this.kind = kind;
            this.uri = uri;
        }

        CommandInfo freeze() {
            return new CommandInfo(block, kind, uri, Set.copyOf(seeds), Set.copyOf(mutants), applications);
        }
    }
}
