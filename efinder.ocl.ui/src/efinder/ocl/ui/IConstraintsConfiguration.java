package efinder.ocl.ui;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * The configuration data that is required to verify a given OCL model.
 * This can be implemented, for instance, by a user interface which gets
 * this information from the user.
 * 
 * @author jesus
 *
 */
public interface IConstraintsConfiguration {

	@Nullable
	IProject getProject();

	/**
	 * @return If the project is not-null, it returns an output folder in which the generated
	 *         models can be stored.
	 */
	@NonNull
	IFolder getOutputFolder();

	/**
	 * @return The information about the document to be verified and the selected constraints.
	 */
	@NonNull 
	OclDocumentData getDocument();

	// TODO: It is not clear that this belongs here
	void showMessage(String msg);
	void log(String msg);
	
}
