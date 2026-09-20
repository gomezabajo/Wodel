package wodel.ai.assistant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import wodel.ai.assistant.tasks.Parameter;

/** A sequence of assistant tasks executed in order. */
public class MTWorkflow extends MTTask {
    private final List<MTTask> tasks = new ArrayList<>();

    public MTWorkflow(Collection<? extends MTTask> tasks) {
        this.tasks.addAll(tasks);
        this.id = "Workflow";
    }

    @Override
    public boolean withParameter(String param, Object value) {
        boolean result = super.withParameter(param, value);
        for (MTTask task : this.tasks) {
            result = task.withParameter(param, value) || result;
        }
        return result;
    }

    @Override
    public String canExecute() {
        List<String> missing = new ArrayList<>();
        for (MTTask task : this.tasks) {
            String canExec = task.canExecute();
            if (canExec != null && !canExec.isBlank()) {
                missing.add(canExec);
            }
        }
        return missing.isEmpty() ? null : String.join(", ", missing);
    }

    @Override
    public String getDescription() {
        return tasks.stream()
            .map(MTTask::getDescription)
            .reduce((a, b) -> a + " and then " + b)
            .orElse("Empty workflow");
    }

    @Override
    public Collection<Parameter> requiredParameters() {
        Set<Parameter> params = new LinkedHashSet<>();
        for (MTTask task : this.tasks) {
            params.addAll(task.requiredParameters());
        }
        return params;
    }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        List<Object> outputs = new ArrayList<>();
        for (MTTask task : this.tasks) {
            outputs.add(task.executeWithInput(userInput));
        }
        return outputs;
    }
}
