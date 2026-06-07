package wodel.ai.assistant.tasks.evaluator;

import wodel.ai.assistant.tasks.fixers.EvaluationContext;
import wodel.ai.assistant.tasks.fixers.TaskQualityEvaluationResult;

/**
 * Class to configure how to evaluate the result of an Assistant Task
 * @author jdelara
 *
 */
public interface IEvalTask {
	public TaskQualityEvaluationResult eval(EvaluationContext input);
}
