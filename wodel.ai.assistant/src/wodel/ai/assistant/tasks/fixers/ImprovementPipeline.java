package wodel.ai.assistant.tasks.fixers;

import java.util.*;

//import wodel.ai.assistant.tasks.fixers.EvaluationContext;
import wodel.ai.assistant.tasks.evaluator.IEvalTask;

public class ImprovementPipeline {
	private int defaultIerations = ImprovementStep.DEFAULT_RETRIES;
	private List<ImprovementStep> steps = new ArrayList<>();
	
	public ImprovementPipeline() {}
	
	public ImprovementPipeline(int defaultIterations) {
		this.defaultIerations = defaultIterations;
	}
	
	public ImprovementPipeline(IEvalTask evaluator, IFixerTask fixer, int maxIterations) {
		this(evaluator, fixer, maxIterations, false);
	}
	
	public ImprovementPipeline(IEvalTask evaluator, IFixerTask fixer, int maxIterations, boolean earlyTermination) {
		this.steps.add(new ImprovementStep(evaluator.getClass().getSimpleName(), evaluator, fixer, maxIterations)
				           .withEarlyTermination(earlyTermination));		
	}
	
	public ImprovementPipeline addStep(String name, IEvalTask evaluator, IFixerTask fixer) {	// To-Do: Possibility to go back, early termination
		return this.addStep(new ImprovementStep(name, evaluator, fixer, this.defaultIerations));
	}
	
	public ImprovementPipeline addStep(String name, IEvalTask evaluator, IFixerTask fixer, int maxIterations) {	// To-Do: Possibility to go back, early termination
		return this.addStep(new ImprovementStep(name, evaluator, fixer, maxIterations));
	}
	
	public ImprovementPipeline addStep(ImprovementStep step) {	
		this.steps.add(step);
		return this;
	}
	
	public void improve(EvaluationContext input) {	// TO-DO: Add counter (max execs) to avoid infinite loops
		int index = 0;
		ImprovementStep current = steps.get(index);
		Direction whereTo = Direction.FORWARD;
		
		while (current != null) {
			whereTo = current.improve(input);
			switch (whereTo) {
				case ABORT: {
					System.out.println("[Improvement pipeline] Aborting...");
					return;
				}
				case FORWARD: 
					index++;
					if (index >= this.steps.size()) {
						System.out.println("[Improvement pipeline] Success!");
						return;
					}
					else
						current = steps.get(index); 
					break;
				case START: 
					index = 0;
					current = steps.get(index);
					break;
			}
			
		}
	}	
}
