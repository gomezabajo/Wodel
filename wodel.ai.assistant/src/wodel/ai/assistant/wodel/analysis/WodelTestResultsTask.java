package wodel.ai.assistant.wodel.analysis;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IProject;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.ai.assistant.wodel.WodelWorkbenchContext;
import wodel.utils.manager.ProjectUtils;
import wodel.utils.manager.WodelTestResult;
import wodel.utils.manager.WodelTestResultClass;

/** Reads persisted Wodel-Test results and reports killed/live/equivalent mutants. */
public final class WodelTestResultsTask extends MTTask implements IntentAwareTask {
    public WodelTestResultsTask() {
        super("Summarize Wodel-Test persisted mutation-testing results, including mutation score and surviving mutants");
        this.id = "SummarizeWodelTestResults";
    }

    @Override
    public Collection<String> getIntentAliases() {
        return List.of(
            "wodel-test results",
            "wodel test results",
            "mutation score",
            "surviving mutants",
            "which mutants survived",
            "test results for mutants");
    }

    @Override
    public String getIntentGroup() { return "wodel-test"; }

    @Override
    public int getIntentPriority() { return 120; }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        IProject project = WodelWorkbenchContext.selectedProject();
        if (project == null || !ProjectUtils.isWodelProject(project)) {
            return "Select the Wodel project whose Wodel-Test data you want to inspect.";
        }
        Path data = project.getLocation().toFile().toPath().resolve("data");
        if (!Files.isDirectory(data)) return "No Wodel-Test data folder exists at " + data + ".";

        List<Path> suites;
        try (var stream = Files.list(data)) {
            suites = stream.filter(Files::isDirectory).sorted().toList();
        }
        StringBuilder out = new StringBuilder("Wodel-Test results for project '").append(project.getName()).append("'.");
        boolean found = false;
        for (Path suite : suites) {
            Path classes = suite.resolve("classes.results.txt");
            if (!Files.isRegularFile(classes)) continue;
            found = true;
            List<WodelTestResultClass> results = WodelTestResultClass.loadFile(classes.toString());
            List<String> killed = new ArrayList<>();
            List<String> live = new ArrayList<>();
            for (WodelTestResultClass mutantClass : results) {
                boolean isKilled = false;
                for (WodelTestResult result : mutantClass.getResults()) {
                    if (result.getFailureCount() > 0) {
                        isKilled = true;
                        break;
                    }
                }
                (isKilled ? killed : live).add(mutantClass.getName());
            }

            List<String> equivalent = loadEquivalent(suite.resolve("classes.equivalent.txt"));
            int generated = globalValue(suite, 4, results.size());
            int nonCompiling = globalValue(suite, 5, 0);
            int compiling = Math.max(0, generated - nonCompiling);
            int denominator = Math.max(0, compiling - equivalent.size());
            double score = denominator == 0 ? 0.0 : (double) killed.size() / denominator;

            out.append("\n\nTest suite: ").append(suite.getFileName())
                .append("\n- generated mutants: ").append(generated)
                .append("\n- non-compiling/error mutants: ").append(nonCompiling)
                .append("\n- equivalent mutants: ").append(equivalent.size())
                .append("\n- killed mutants: ").append(killed.size())
                .append("\n- live/surviving mutants: ").append(Math.max(0, denominator - killed.size()))
                .append(String.format(java.util.Locale.ROOT, "\n- mutation score: %.2f%%", score * 100.0));

            if (userInput != null && userInput.toLowerCase(java.util.Locale.ROOT).contains("surviv")) {
                out.append("\nSurvivors:");
                for (String name : live) {
                    if (!matchesEquivalent(name, equivalent)) out.append("\n  - ").append(name);
                }
            }
        }
        if (!found) out.append("\nNo classes.results.txt file was found. Run Wodel-Test first.");
        return out.toString();
    }

    private List<String> loadEquivalent(Path path) {
        try {
            if (!Files.isRegularFile(path)) return List.of();
            String text = Files.readString(path).trim();
            if (text.isBlank()) return List.of();
            List<String> values = new ArrayList<>();
            for (String token : text.split("[|\\r\\n]+")) if (!token.isBlank()) values.add(token.trim());
            return values;
        } catch (Exception e) {
            return List.of();
        }
    }

    private boolean matchesEquivalent(String mutant, List<String> equivalent) {
        String normalized = mutant.replace('\\', '/');
        for (String eq : equivalent) {
            String candidate = eq.replace('\\', '/');
            if (normalized.equals(candidate) || normalized.endsWith(candidate) || candidate.endsWith(normalized)) return true;
        }
        return false;
    }

    private int globalValue(Path suite, int lineIndex, int fallback) {
        try (var stream = Files.list(suite)) {
            Path file = stream.filter(p -> p.getFileName().toString().endsWith(".global.results.txt")).findFirst().orElse(null);
            if (file == null) return fallback;
            List<String> lines = Files.readAllLines(file);
            return lines.size() > lineIndex ? Integer.parseInt(lines.get(lineIndex).trim()) : fallback;
        } catch (Exception e) {
            return fallback;
        }
    }
}
