package wodel.ai.assistant.mock;

import java.util.*;

import wodel.ai.assistant.IMTFramework;
import wodel.ai.assistant.MTTask;

public class GottenMock implements IMTFramework{
	private static final GottenMock gotten = new GottenMock();
	private Map<String, Object> parameters = new LinkedHashMap<>();
	
	public static GottenMock getInstance() {
		return gotten;
	}
	
	private GottenMock() {}
	
	public GottenMock withParameter(String paramName, Object value) {
		this.parameters.put(paramName, value);
		return this;
	}

	@Override
	public Object get(String property) {
		return this.parameters.get(property);
	}

	public Map<? extends String, ? extends Object> getAllParams() {
		return Collections.unmodifiableMap(this.parameters);
	}

	@Override
	public Collection<MTTask> getSupportedTasks() {
		return List.of(new GottenTestExecutionTask());
	}

}
