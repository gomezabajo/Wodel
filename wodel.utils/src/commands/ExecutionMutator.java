package commands;

import exceptions.MaxSmallerThanMinException;

public class ExecutionMutator {
	
	private Mutator command;
	
	private int max;
	private int min;
	
	public ExecutionMutator(Mutator command, int max, int min) throws MaxSmallerThanMinException{
		if(max<min){
			throw new MaxSmallerThanMinException("The max attribute has a smaller value than the min attribute.");
		}
		this.command = command;
		this.max = max;
		this.min = min;
	}

	//GETTERS AND SETTERS
	public Mutator getCommand() {
		return command;
	}
	public void setCommand(Mutator command) {
		this.command = command;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
}
