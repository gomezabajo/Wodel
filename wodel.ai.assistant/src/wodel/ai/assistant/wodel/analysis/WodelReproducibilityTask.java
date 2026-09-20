package wodel.ai.assistant.wodel.analysis;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.time.Instant;
import java.util.Collection;
import java.util.HexFormat;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.json.JSONObject;

import mutatorenvironment.Program;
import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.ai.assistant.wodel.ai.WodelLanguageService;
import wodel.ai.assistant.wodel.ai.WodelLanguageService.SourceSnapshot;
import wodel.utils.manager.ProjectUtils;

/** Builds a reproducibility manifest for the selected Wodel program. */
public final class WodelReproducibilityTask extends MTTask implements IntentAwareTask {
    private static final String NODE = "wodel.dsls.Wodel";
    private final WodelLanguageService language = new WodelLanguageService();

    public WodelReproducibilityTask() {
        super("Create a JSON reproducibility manifest containing the selected Wodel source hash, metamodel, execution preferences and optional requested execution seed");
        this.id = "CreateWodelReproducibilityManifest";
    }

    @Override
    public Collection<String> getIntentAliases() {
        return List.of("reproducibility manifest", "reproduce wodel run", "capture wodel configuration", "wodel reproduction", "reproducible wodel");
    }

    @Override
    public String getIntentGroup() { return "configuration"; }

    @Override
    public int getIntentPriority() { return 110; }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        IProject project = language.activeProject();
        if (project == null || !ProjectUtils.isWodelProject(project)) return "Select a Wodel project first.";
        IFile source;
        SourceSnapshot snapshot;
        try {
            source = language.resolveSource(project, userInput);
            snapshot = language.load(source);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        if (snapshot.environment() == null || !(snapshot.environment().getDefinition() instanceof Program program)) {
            return "The selected source is not an executable Wodel program.";
        }

        JSONObject execution = new JSONObject();
        execution.put("numberOfMutants", string("Number of mutants", "3"));
        execution.put("numberOfAttempts", string("Number of attempts", "3"));
        execution.put("generateRegistry", bool("Generate registry", true));
        execution.put("serializeModels", bool("Serialize models", true));
        execution.put("generateNetFootprints", bool("Generate net mutant footprints", false));
        execution.put("generateDebugFootprints", bool("Generate debug mutant footprints", false));
        Long seed = requestedSeed(userInput);
        if (seed != null) execution.put("executionSeed", seed);
        else execution.put("executionSeed", JSONObject.NULL);

        JSONObject filtering = new JSONObject();
        filtering.put("discardInvalid", bool("Discard invalid mutants", true));
        filtering.put("validationExtension", string("Mutants validation extension", "EMF model validation"));
        filtering.put("discardSyntacticDuplicates", bool("Discard syntactic duplicate mutants", true));
        filtering.put("syntacticComparison", string("Duplicate mutants detection extension", "EMF model comparison"));
        filtering.put("discardSemanticEquivalents", bool("Discard semantic equivalent mutants", false));
        filtering.put("semanticComparison", string("Semantic equivalent mutants detection extension", ""));

        JSONObject manifest = new JSONObject();
        manifest.put("schema", "wodel-ai-assistant/reproducibility-manifest/1");
        manifest.put("createdAt", Instant.now().toString());
        manifest.put("project", project.getName());
        manifest.put("program", source.getProjectRelativePath().toString());
        manifest.put("programSha256", sha256(source));
        manifest.put("metamodel", program.getMetamodel());
        manifest.put("execution", execution);
        manifest.put("filtering", filtering);
        manifest.put("optimiseMutants", bool("Optimise mutants", false));
        manifest.put("optimiser", string("Mutants optimiser extension", ""));

        String json = manifest.toString(2);
        boolean save = userInput != null && userInput.toLowerCase(java.util.Locale.ROOT).contains("save=true");
        if (!save) return json + "\n\nAdd save=true to write this manifest into the Wodel project.";

        Path target = project.getLocation().toFile().toPath().resolve("wodel-reproducibility.json");
        Files.writeString(target, json + System.lineSeparator(), StandardCharsets.UTF_8);
        project.refreshLocal(org.eclipse.core.resources.IResource.DEPTH_ONE, null);
        return "Saved Wodel reproducibility manifest to " + target + "\n\n" + json;
    }

    private String sha256(IFile file) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        try (InputStream in = file.getContents(true)) {
            byte[] buffer = new byte[8192];
            int read;
            while ((read = in.read(buffer)) >= 0) digest.update(buffer, 0, read);
        }
        return HexFormat.of().formatHex(digest.digest());
    }

    private Long requestedSeed(String text) {
        if (text == null) return null;
        var matcher = java.util.regex.Pattern.compile("(?i)\\bseed\\s*=\\s*(-?\\d+)").matcher(text);
        if (!matcher.find()) return null;
        try { return Long.parseLong(matcher.group(1)); } catch (NumberFormatException e) { return null; }
    }

    private String string(String key, String fallback) {
        return Platform.getPreferencesService().getString(NODE, key, fallback, null);
    }

    private boolean bool(String key, boolean fallback) {
        return Platform.getPreferencesService().getBoolean(NODE, key, fallback, null);
    }
}
