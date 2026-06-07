package wodel.ai.assistant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AITaskProvider implements ITaskProvider{
	private static final AITaskProvider instance = new AITaskProvider();
	private List<AITask> taskRegistry = new ArrayList<AITask>();	
	
	private AITaskProvider() {
		/*this.register(new MRInferTask())
			.register(new MRFixerTask())
			.register(new MRCreateTask())
			.register(new MRExplainerTask())
			.register(new MROptimiseTask())
			.register(new MRCombinerTask())
			.register(new FollowUpGenTask())
			.register(new SeedModelGenTask());*/
	}
	
	public static AITaskProvider getInstance() {
		return instance;
	}

	public AITaskProvider register(AITask task) {
		this.taskRegistry.add(task);
		return this;
	}

	@Override
	public Collection<MTTask> getSupportedTasks() {		
		return Collections.unmodifiableList(taskRegistry);
	}

}
