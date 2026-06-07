package wodel.ai.assistant.mock;

import wodel.ai.assistant.MTTask;

// Just a mock task
public class GottenTestExecutionTask extends MTTask {

	public GottenTestExecutionTask() {
		super("Executes test cases with Gotten");
	}
	
	@Override
	public Object executeWithInput(String params) throws Exception {		
		return "[Test Execution] Testing executed with "+params;
	}

}
