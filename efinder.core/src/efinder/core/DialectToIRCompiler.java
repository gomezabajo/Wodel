package efinder.core;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Represents a compiler that transforms a dialect into an IR specification.
 * 
 * @author jesus
 *
 */
public interface DialectToIRCompiler {
	
	@NonNull
	EFinderModel compile();
}
