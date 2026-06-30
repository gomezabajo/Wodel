package efinder.core.errors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import efinder.ir.ocl.CollectionCallExp;

/**
 * Record of the issues in the translation.
 * 
 * @author jesus
 */
public class Report {

	public static enum Action {
		IGNORE,
		STOP
	}

	private List<Item> unsupported = new ArrayList<>();
	
	public void addUnsupported(@NonNull String message, @NonNull Object object, @NonNull Action action) {
		addUnsupported(message, object, action, message);
	}

	public void addUnsupported(@NonNull String message, @Nullable Object object, @NonNull Action action, @NonNull String reason) {
		System.out.println(message + "\n   - " + object + "\n   - " + action);
		unsupported.add(new Item(reason, object, action));		
	}

	public List<? extends Item> getUnsupported() {
		return unsupported;
	}
	
	public boolean isUnsupported() {
		return ! unsupported.isEmpty();
	}
	
	public static class Item {
		private String reason;
		private Object object;
		private Action action;
		
		public Item(@NonNull String reason, @NonNull Object object, @NonNull Action action) {
			this.reason = reason;
			this.object = object;
			this.action = action;
		}
		
		public String getReason() {
			return reason;
		}
		
		public Object getObject() {
			return object;
		}
		
		public Action getAction() {
			return action;
		}		
	}
	
}
