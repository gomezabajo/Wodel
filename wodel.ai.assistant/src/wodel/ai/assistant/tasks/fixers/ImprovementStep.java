package wodel.ai.assistant.tasks.fixers;

import wodel.ai.assistant.tasks.evaluator.IEvalTask;

public class ImprovementStep {
	public static final int DEFAULT_RETRIES = 3;
	private IEvalTask evaluator;
	private IFixerTask fixer;
	private boolean earlyTermination = false;
	private boolean withRestart = false;
	private int maxIterations = DEFAULT_RETRIES;
	private String name;
	
	public ImprovementStep(String name, IEvalTask evaluator, IFixerTask fixer) {
		this(name, evaluator, fixer, DEFAULT_RETRIES);
	}
	
	public ImprovementStep(String name, IEvalTask evaluator, IFixerTask fixer, int maxIterations) {
		this.evaluator = evaluator;
		this.fixer = fixer;
		this.maxIterations = maxIterations;
		this.name = name;
	}
	
	public ImprovementStep withEarlyTermination() {		
		return this.withEarlyTermination(true);
	}
	
	public ImprovementStep withEarlyTermination(boolean termination) {
		this.earlyTermination = termination;
		return this;
	}
	
	public ImprovementStep withRestart() {
		this.withRestart = true;
		return this;
	}
			
	public Direction improve(EvaluationContext input) {
		System.out.println("["+name+"] Starting...");
		TaskQualityEvaluationResult result = evaluator.eval(input);
		if (result == null) {
			System.out.println("["+name+"] Fatal error: Aborting ...");
			return Direction.ABORT;
		}
		if (result.isCorrect()) {
			System.out.println("["+name+"] Success!");
			return nextDirection();	// correct result, so we are done
		}
		System.out.println("[improvement step] Starting...");
		int numIteration = this.maxIterations;
		int currentQualityLevel = result.getQualityRank(); 
		while (numIteration > 0) {
			numIteration --;
			fixer.fix(result, input);
			System.out.println("["+name+"] Iteration "+(this.maxIterations - numIteration));
			result = evaluator.eval(input);
			if (result == null) {
				System.out.println("["+name+"] Fatal error: Aborting ...");
				return Direction.ABORT;
			}
			if (result.isCorrect()) {
				System.out.println("["+name+"] Correct result!");
				return nextDirection();
			}
			System.out.println("["+name+"] Eval result: "+result);
			if (result.getQualityRank() == currentQualityLevel && this.earlyTermination) return Direction.ABORT;
			currentQualityLevel = result.getQualityRank();
		} 
		return Direction.ABORT;	// We could not succeed
	}

	private Direction nextDirection() {
		return this.withRestart ? Direction.START : Direction.FORWARD;
	}
}
