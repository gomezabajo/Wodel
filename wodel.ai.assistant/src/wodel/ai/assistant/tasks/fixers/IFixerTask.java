package wodel.ai.assistant.tasks.fixers;

public interface IFixerTask {
	public LLMResponse fix(TaskQualityEvaluationResult result, EvaluationContext evalContext);
}
