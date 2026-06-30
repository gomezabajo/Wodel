package efinder.emfocl.tests.ocldataset;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import efinder.core.EFinderModel;
import efinder.core.IModelFinder.Result;

/**
 * 
 */
public interface ExecutionRecord {

	void setExpectedFiles(int files);
	
	void processed(@NonNull String filename, Result result, @Nullable EFinderModel ir);

	void unknownFailure(@NonNull String filename);

	void doNotValidate(@NonNull String filename);

	void loadError(@NonNull String filename);

	void typeError(@NonNull String filename, String reason);

}