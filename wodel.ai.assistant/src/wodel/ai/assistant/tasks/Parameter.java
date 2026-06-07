package wodel.ai.assistant.tasks;

public record Parameter(String name, ParameterType type, String description, boolean userProvided) {
	public Parameter(String name, ParameterType type, String description) {
		this(name, type, description, false);
	}
}
