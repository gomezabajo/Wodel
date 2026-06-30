package efinder.core.errors;

import org.eclipse.jdt.annotation.NonNull;

public class UnsupportedTranslationException extends RuntimeException{

	private static final long serialVersionUID = -7954708684972509879L;
	private @NonNull String reason;

	public UnsupportedTranslationException(@NonNull String message, @NonNull String reason) {
		super(message);
		this.reason = reason;
	}
	
	public String getReason() {
		return reason;
	}

}
