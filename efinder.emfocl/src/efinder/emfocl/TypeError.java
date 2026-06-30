package efinder.emfocl;

import org.eclipse.jdt.annotation.NonNull;

@SuppressWarnings("serial")
public class TypeError extends RuntimeException {
	
	private String reason;

	public TypeError(@NonNull String message, String reason) {
		super(message);
		this.reason = reason;
	}
	
	public String getReason() {
		return reason;
	}

}
