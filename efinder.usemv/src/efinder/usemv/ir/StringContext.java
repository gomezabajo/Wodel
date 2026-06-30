package efinder.usemv.ir;

import org.eclipse.jdt.annotation.NonNull;

public class StringContext {
	private StringBuilder builder;
	
	public StringContext(@NonNull StringBuilder builder) {
		this.builder = builder;
	}

	@NonNull
	public StringContext append(@NonNull String str) {
		builder.append(str);	
		return this;
	}

	@NonNull
	public StringContext append(int value) {
		builder.append(value);
		return this;
	}

	@NonNull
	public StringContext append(boolean value) {
		builder.append(value);
		return this;		
	}

	public void append(double value) {
		builder.append(value);
	}

	@NonNull
	public StringContext indent() {
		// TODO: Unindent properly
		builder.append("  ");
		return this;
	}
		
	@NonNull
	public StringContext unindent() {
		// TODO: Indent properly
		return this;
	}

	@NonNull
	public StringContext newLine() {
		builder.append("\n");
		return this;
	}
	
}