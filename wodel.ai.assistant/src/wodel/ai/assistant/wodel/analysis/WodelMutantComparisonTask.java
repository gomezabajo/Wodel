package wodel.ai.assistant.wodel.analysis;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.ai.assistant.wodel.analysis.WodelAnalysisService.AnalysisContext;

/** Compares two generated mutants through Wodel's configured comparison extensions. */
public final class WodelMutantComparisonTask extends MTTask implements IntentAwareTask {
    private final WodelAnalysisService analysis = new WodelAnalysisService();

    public WodelMutantComparisonTask() {
        super("Compare two Wodel mutants using installed syntactic and optional semantic comparison extensions");
        this.id = "CompareWodelMutants";
    }

    @Override
    public Collection<String> getIntentAliases() {
        return List.of(
            "compare mutants",
            "compare two mutants",
            "are these mutants equivalent",
            "semantic comparison",
            "syntactic comparison");
    }

    @Override
    public String getIntentGroup() { return "mutant-comparison"; }

    @Override
    public int getIntentPriority() { return 140; }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        final AnalysisContext context;
        try {
            context = analysis.resolve(userInput);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return e.getMessage();
        }

        List<String> requested = modelTokens(userInput);
        if (requested.size() < 2) {
            return "Name two .model files, for example: /compare-mutants Output3.model Output7.model";
        }
        String model1 = resolveMutantPath(context, requested.get(0));
        String model2 = resolveMutantPath(context, requested.get(1));
        if (model1 == null || model2 == null) {
            return "Could not resolve both requested models from Wodel's generated-mutant registry.";
        }

        StringBuilder out = new StringBuilder();
        out.append("Comparing Wodel mutants:\n- ").append(model1).append("\n- ").append(model2);
        List<ComparisonResult> syntactic = compareSyntactic(context, model1, model2);
        if (syntactic.isEmpty()) {
            out.append("\n\nSyntactic comparison: no wodel.syntactic.comparison extension is installed.");
        } else {
            out.append("\n\nSyntactic comparison:");
            for (ComparisonResult result : syntactic) {
                out.append("\n- ").append(result.name()).append(": ")
                    .append(result.equivalent() ? "equivalent/duplicate" : "different");
            }
        }

        boolean semanticRequested = userInput != null
            && userInput.toLowerCase(Locale.ROOT).contains("semantic");
        if (semanticRequested) {
            List<ComparisonResult> semantic = compareSemantic(context, model1, model2);
            if (semantic.isEmpty()) {
                out.append("\n\nSemantic comparison: no wodel.semantic.comparison extension is installed.");
            } else {
                out.append("\n\nSemantic comparison:");
                for (ComparisonResult result : semantic) {
                    out.append("\n- ").append(result.name()).append(": ")
                        .append(result.processed() ? (result.equivalent() ? "equivalent" : "different") : "not applicable/not processed");
                }
            }
        } else {
            out.append("\n\nAdd 'semantic' to the request to invoke installed semantic-comparison extensions as well.");
        }
        return out.toString();
    }

    static List<ComparisonResult> compareSyntactic(AnalysisContext context, String model1, String model2) {
        List<ComparisonResult> results = new ArrayList<>();
        IConfigurationElement[] elements = Platform.getExtensionRegistry()
            .getConfigurationElementsFor("wodel.syntactic.comparison.MutSyntacticComparison");
        for (IConfigurationElement element : elements) {
            try {
                Object comparator = element.createExecutableExtension("class");
                Method name = comparator.getClass().getMethod("getName");
                Method compare = comparator.getClass().getMethod(
                    "doCompare", String.class, String.class, String.class,
                    org.eclipse.core.resources.IProject.class, Class.class);
                boolean equivalent = (Boolean) compare.invoke(
                    comparator, context.metamodel(), model1, model2, context.project(), WodelMutantComparisonTask.class);
                results.add(new ComparisonResult(String.valueOf(name.invoke(comparator)), equivalent, true));
            } catch (Exception e) {
                results.add(new ComparisonResult(element.getAttribute("class") + " (error: " + safeMessage(e) + ")", false, false));
            }
        }
        return results;
    }

    static List<ComparisonResult> compareSemantic(AnalysisContext context, String model1, String model2) {
        List<ComparisonResult> results = new ArrayList<>();
        IConfigurationElement[] elements = Platform.getExtensionRegistry()
            .getConfigurationElementsFor("wodel.semantic.comparison.MutSemanticComparison");
        for (IConfigurationElement element : elements) {
            try {
                Object comparator = element.createExecutableExtension("class");
                Method name = comparator.getClass().getMethod("getName");
                Method compare = comparator.getClass().getMethod(
                    "doCompare", List.class, String.class, String.class,
                    org.eclipse.core.resources.IProject.class, boolean[].class, Class.class);
                boolean[] processed = {false};
                boolean equivalent = (Boolean) compare.invoke(
                    comparator, List.of(context.metamodel()), model1, model2,
                    context.project(), processed, WodelMutantComparisonTask.class);
                results.add(new ComparisonResult(String.valueOf(name.invoke(comparator)), equivalent, processed[0]));
            } catch (Exception e) {
                results.add(new ComparisonResult(element.getAttribute("class") + " (error: " + safeMessage(e) + ")", false, false));
            }
        }
        return results;
    }

    static Set<String> registeredMutantPaths(AnalysisContext context) {
        Set<String> result = new LinkedHashSet<>();
        for (var entry : context.registryEntries()) result.addAll(entry.mutantPaths());
        return result;
    }

    private String resolveMutantPath(AnalysisContext context, String requested) {
        String wanted = Path.of(requested).getFileName().toString();
        for (String mutant : registeredMutantPaths(context)) {
            if (Path.of(mutant).getFileName().toString().equalsIgnoreCase(wanted)) return mutant;
            if (mutant.replace('\\', '/').endsWith("/" + requested.replace('\\', '/'))) return mutant;
        }
        return null;
    }

    private List<String> modelTokens(String text) {
        List<String> result = new ArrayList<>();
        if (text == null) return result;
        for (String token : text.split("\\s+")) {
            String value = token.replaceAll("^[\\\"'`(]+|[\\\"'`,;:)]+$", "");
            if (value.toLowerCase(Locale.ROOT).endsWith(".model")) result.add(value);
        }
        return result;
    }

    static String safeMessage(Throwable error) {
        Throwable current = error;
        while (current.getCause() != null) current = current.getCause();
        String message = current.getMessage();
        return message == null || message.isBlank() ? current.getClass().getSimpleName() : message;
    }

    public record ComparisonResult(String name, boolean equivalent, boolean processed) {}
}
