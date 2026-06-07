package wodel.ai.assistant.tasks.fixers;

public abstract class TaskQualityEvaluationResult {
	private int qualityRank; 	// lower is better, with 0 = perfect
	protected String error;		// Reported error
	
	public TaskQualityEvaluationResult(int qualityRank) {
		this(qualityRank, "");
	}
	
	public TaskQualityEvaluationResult(int qualityRank, String error) {
		this.qualityRank = qualityRank;
		this.error = error;
	}
	
	public int getQualityRank() {
		return this.qualityRank;
	}
	
	public String error() {
		return this.error;
	}
	
	public boolean isCorrect() {
		return this.qualityRank == 0;
	}
	
	public abstract String fixPrompt();	// returns the prompt for the fixer task
	
	public String toString() {
		return "Error message: " + this.error + " quality: "+this.qualityRank;
	}
}
