package manager;

public class WodelTestInfo {
	private String info;
	private String message;
	private boolean failure;
	
	public WodelTestInfo(String info, String message) {
		this.info = info;
		this.message = message;
		this.failure = false;
	}
	
	public String getInfo() {
		return info;
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
