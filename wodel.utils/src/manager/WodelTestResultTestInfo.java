package manager;

import java.util.List;

public class WodelTestResultTestInfo {
	
	private String name;
	
	private boolean value;
	
	private String message;
	
	private List<String> mutation;
	
	private boolean failure;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getValue() {
		return value;
	}
	
	public void setValue(boolean value) {
		this.value = value;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<String> getMutation() {
		return this.mutation;
	}
	
	public void setMutation(List<String> mutation) {
		this.mutation = mutation;
	}
	
	public boolean getFailure() {
		return failure;
	}
	
	public void setFailure(boolean failure) {
		this.failure = failure;
	}
}
