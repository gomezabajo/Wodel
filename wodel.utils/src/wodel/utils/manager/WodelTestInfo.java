package wodel.utils.manager;

public class WodelTestInfo {
	private String test;
	private boolean value;
	private String info;
	private String message;
	private boolean failure;
	
	public WodelTestInfo(String test, boolean value, String info, String message) {
		this.test = test;
		this.value = value;
		this.info = info;
		this.message = message;
		this.failure = false;
	}
	
	public String getInfo() {
		return info;
	}
	
	public String getTest() {
		return test;
	}
	
	public boolean getValue() {
		return this.value;
	}

	public String getMessage() {
		return message;
	}
	
	public boolean getFailure() {
		return this.failure;
	}
	
	public void setFailure(boolean failure) {
		this.failure = failure;
	}
}
