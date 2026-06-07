package wodel.ai.assistant;

import java.util.Map;

public interface IMTFramework extends ITaskProvider {
	public Object get(String property);
	public Map<? extends String, ? extends Object> getAllParams();
}
