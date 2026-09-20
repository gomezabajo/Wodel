package wodel.ai.assistant.chat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import wodel.ai.assistant.ITaskProvider;
import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.MTWorkflow;
import wodel.ai.assistant.tasks.fixers.LLMResponse;
import wodel.ai.assistant.wodel.WodelTaskProvider;

/** Classifies a user request into one or more Wodel tasks. */
public class PlannerAgent extends AssistantAgent {
    public final List<MTTask> registeredTasks = new ArrayList<>();

    public PlannerAgent() {
        this.systemPrompt = """
            You are an assistant for Wodel, a model-driven mutation framework. Classify the user utterance into one or more of these tasks:
            {tasks}

            Instructions:
            - If one task applies, return ONLY the task name.
            - If no task applies, return "None".
            - If several tasks are explicitly requested in sequence, return their names separated by semicolons.
            - A Wodel mutation program may be called a mutator or .mutator file.
            - Distinguish source understanding/diagnosis/repair/authoring from mutation execution.
            - /generate-style parameterized mutation execution RUNS mutants; AuthorWodelSource creates source code.
            - Distinguish normal execution, parameterized execution, seed-model synthesis, project inspection, validation, AI source workflows, wizards and cleanup.
            - Requests to generate seed models with the LLM/AI/OpenAI API are GenerateWodelSeedModelsWithAI. Plain seed-model requests are GenerateWodelSeedModels (native USE/Kodkod). Neither is mutant generation; a numeric seed in mutation execution is a random/execution seed.
            - Distinguish post-generation mutant analysis (explain mutant, adequacy, metrics, comparison/equivalence) from mutation execution.
            - Wodel-Test execution/results/optimisation are separate from normal Wodel mutant generation.
            - Configuration/reproducibility requests map to the doctor/reproducibility tasks.
            - Seed strategy comparison and seed-adequacy improvement analyse generated seeds; they do not mean ordinary seed synthesis.

            User utterance:
            {user_utterance}
            """;
        this.registeredTasks.addAll(WodelTaskProvider.getInstance().getSupportedTasks());
    }

    public PlannerAgent(ITaskProvider... providers) {
        this();
        for (ITaskProvider provider : providers) addUnique(provider.getSupportedTasks());
    }

    private void addUnique(Collection<MTTask> tasks) {
        for (MTTask task : tasks) {
            boolean exists = registeredTasks.stream().anyMatch(t -> t.getId().equalsIgnoreCase(task.getId()));
            if (!exists) registeredTasks.add(task);
        }
    }

    public MTTask getIntent(String userUtterance) {
        MTTask deterministic = findDeterministically(userUtterance);
        if (deterministic != null) return deterministic;

        String prompt = buildPrompt(userUtterance);
        var client = this.llmClient().withModel("gpt-4.1-mini").withTemperature(0);
        try {
            return findTask(client.sendPrompt(prompt, true));
        } catch (Exception e) {
            return null;
        }
    }

    private MTTask findDeterministically(String utterance) {
        record Match(MTTask task, IntentAwareTask intent, int index) {}
        List<Match> matches = new ArrayList<>();
        for (MTTask task : registeredTasks) {
            if (!(task instanceof IntentAwareTask aware)) continue;
            int index = aware.matchIndex(utterance);
            if (index >= 0) matches.add(new Match(task, aware, index));
        }
        if (matches.isEmpty()) return null;

        Map<String, Match> grouped = new LinkedHashMap<>();
        List<Match> ungrouped = new ArrayList<>();
        for (Match match : matches) {
            String group = match.intent().getIntentGroup();
            if (group == null || group.isBlank()) {
                ungrouped.add(match);
                continue;
            }
            Match previous = grouped.get(group);
            if (previous == null
                    || match.intent().getIntentPriority() > previous.intent().getIntentPriority()
                    || (match.intent().getIntentPriority() == previous.intent().getIntentPriority() && match.index() < previous.index())) {
                grouped.put(group, match);
            }
        }

        List<Match> selected = new ArrayList<>(ungrouped);
        selected.addAll(grouped.values());
        selected.sort(Comparator.comparingInt(Match::index));
        if (selected.size() == 1) return selected.get(0).task();
        return new MTWorkflow(selected.stream().map(Match::task).toList());
    }

    private MTTask findTask(LLMResponse resp) {
        String response = resp.getResponse().trim();
        if (response.equalsIgnoreCase("None") || response.equalsIgnoreCase("\"None\"")) return null;
        String[] names = response.split(";");
        List<MTTask> tasks = new ArrayList<>();
        for (String raw : names) {
            String name = raw.trim();
            MTTask exact = registeredTasks.stream().filter(t -> t.getId().equalsIgnoreCase(name)).findFirst().orElse(null);
            if (exact == null) {
                String lower = name.toLowerCase(Locale.ROOT);
                exact = registeredTasks.stream().filter(t -> lower.contains(t.getId().toLowerCase(Locale.ROOT))).findFirst().orElse(null);
            }
            if (exact == null) return null;
            tasks.add(exact);
        }
        return tasks.size() == 1 ? tasks.get(0) : new MTWorkflow(tasks);
    }

    private String buildPrompt(String utterance) {
        StringBuilder tasks = new StringBuilder();
        for (MTTask task : registeredTasks) tasks.append("\n - ").append(task);
        return systemPrompt.replace("{tasks}", tasks).replace("{user_utterance}", utterance == null ? "" : utterance);
    }
}
