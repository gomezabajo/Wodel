package wodeledu.extension.builder;

import java.util.Iterator;
import org.eclipse.core.commands.*;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class AddRemoveWodelEduNatureHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		//
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> it = ((IStructuredSelection) selection).iterator(); it
					.hasNext();) {
				Object element = it.next();
				IProject project = null;
				if (element instanceof IProject) {
					project = (IProject) element;
				} else if (element instanceof IAdaptable) {
					project = (IProject) ((IAdaptable) element)
							.getAdapter(IProject.class);
				}
				if (project != null) {
					try {
						toggleNature(project);
					} catch (CoreException e) {
						//TODO log something
						throw new ExecutionException("Failed to toggle nature",
								e);
					}
				}
			}
		}

		return null;
	}
	
	private boolean toggleNature(String natureID, String[] natures, IProjectDescription description, IProject project) throws CoreException {
		for (int i = 0; i < natures.length; ++i) {
			if (natureID.equals(natures[i])) {
				// Remove the nature
				String[] newNatures = new String[natures.length - 1];
				System.arraycopy(natures, 0, newNatures, 0, i);
				System.arraycopy(natures, i + 1, newNatures, i, natures.length - i - 1);
				description.setNatureIds(newNatures);
				project.setDescription(description, null);
				return true;
			}
		}
		return false;
	}
	
	private void addNature(String natureID, String[] natures, IProjectDescription description, IProject project) throws CoreException {
		// Add the nature
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = natureID;
		description.setNatureIds(newNatures);
		project.setDescription(description, null);
	}

	/**
	 * Toggles sample nature on a project
	 *
	 * @param project
	 *            to have sample nature added or removed
	 */
	private void toggleNature(IProject project) throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();

		boolean natureID = toggleNature(WodelEduNature.WODEL_NATURE_ID, natures, description, project);
		if (!natureID) {
			addNature(WodelEduNature.WODEL_NATURE_ID, natures, description, project);
		}
 
		natureID = toggleNature(WodelEduNature.NATURE_ID, natures, description, project);
		if (!natureID) {
			addNature(WodelEduNature.NATURE_ID, natures, description, project);
		}
	}
}