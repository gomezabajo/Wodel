package efinder.core;

import org.eclipse.jdt.annotation.NonNull;

public interface IDialectAdaptation {

	void transform(@NonNull EFinderModel ir);

}
