package wodel.ai.assistant.wodel.analysis;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;

/** Deterministic diagnostic summary of Wodel preferences and optional plugins. */
public final class WodelDoctorTask extends MTTask implements IntentAwareTask {
    private static final String NODE = "wodel.dsls.Wodel";

    public WodelDoctorTask() {
        super("Inspect effective Wodel generation, filtering, footprint, seed and AI configuration plus installed optional analysis/test bundles");
        this.id = "InspectWodelConfiguration";
    }

    @Override
    public Collection<String> getIntentAliases() {
        return List.of("wodel doctor", "wodel configuration", "wodel config", "check wodel setup", "diagnose wodel setup");
    }

    @Override
    public String getIntentGroup() { return "configuration"; }

    @Override
    public int getIntentPriority() { return 100; }

    @Override
    public Object executeWithInput(String userInput) {
        StringBuilder out = new StringBuilder("Wodel configuration doctor\n");
        Map<String, Object> prefs = new LinkedHashMap<>();
        prefs.put("Number of mutants", string("Number of mutants", "3"));
        prefs.put("Number of attempts", string("Number of attempts", "3"));
        prefs.put("Generate registry", bool("Generate registry", true));
        prefs.put("Serialize models", bool("Serialize models", true));
        prefs.put("Discard invalid mutants", bool("Discard invalid mutants", true));
        prefs.put("Mutants validation extension", string("Mutants validation extension", "EMF model validation"));
        prefs.put("Discard syntactic duplicate mutants", bool("Discard syntactic duplicate mutants", true));
        prefs.put("Duplicate mutants detection extension", string("Duplicate mutants detection extension", "EMF model comparison"));
        prefs.put("Discard semantic equivalent mutants", bool("Discard semantic equivalent mutants", false));
        prefs.put("Semantic equivalent mutants detection extension", string("Semantic equivalent mutants detection extension", ""));
        prefs.put("Optimise mutants", bool("Optimise mutants", false));
        prefs.put("Mutants optimiser extension", string("Mutants optimiser extension", ""));
        prefs.put("Generate net mutant footprints", bool("Generate net mutant footprints", false));
        prefs.put("Generate debug mutant footprints", bool("Generate debug mutant footprints", false));
        prefs.put("Filter concrete classes", bool("Filter concrete classes", false));
        prefs.put("Number of seed models", string("Number of seed models", "10"));
        prefs.put("Seed model synthesis", bool("Seed model synthesis", false));
        prefs.put("AI generative model", string("AI generative model", "gpt-4o-mini"));
        prefs.put("Temperature", string("Temperature", "0"));

        out.append("\nEffective preferences:");
        prefs.forEach((key, value) -> out.append("\n- ").append(key).append(": ").append(value));
        out.append("\n- gen-AI API key: ").append(apiKeyConfigured() ? "configured" : "not configured");

        out.append("\n\nOptional capabilities:");
        capability(out, "Native USE/Kodkod seed synthesis", "wodel.synthesizer");
        capability(out, "Command/static metrics", "wodel.metrics.command");
        capability(out, "Dynamic metrics", "wodel.metrics.dynamic");
        capability(out, "Debug metrics", "wodel.metrics.debug");
        capability(out, "Syntactic comparison", "wodel.syntactic.comparison");
        capability(out, "Semantic comparison", "wodel.semantic.comparison");
        capability(out, "Wodel-Test runner", "wodeltest.run");
        capability(out, "Wodel-Test optimiser API", "wodeltest.optimiser");
        capability(out, "Subsumption optimiser", "wodeltest.optimiser.subsumption");

        if (!bool("Generate registry", true)) {
            out.append("\n\nRecommendation: enable 'Generate registry' before using /adequacy or /explain-mutant; those workflows need applied-mutation traces.");
        }
        if (!bool("Generate net mutant footprints", false) && !bool("Generate debug mutant footprints", false)) {
            out.append("\nRecommendation: enable footprint generation before expecting /metrics dynamic/debug data.");
        }
        return out.toString();
    }

    private void capability(StringBuilder out, String label, String bundleId) {
        out.append("\n- ").append(label).append(": ")
            .append(Platform.getBundle(bundleId) == null ? "not installed" : "installed");
    }

    private String string(String key, String fallback) {
        return Platform.getPreferencesService().getString(NODE, key, fallback, null);
    }

    private boolean bool(String key, boolean fallback) {
        return Platform.getPreferencesService().getBoolean(NODE, key, fallback, null);
    }

    private boolean apiKeyConfigured() {
        String value = string("wodel.ai.gptApiKey", "");
        if (value != null && !value.isBlank()) return true;
        String env = System.getenv("OPENAI_API_KEY");
        return env != null && !env.isBlank();
    }
}
