package manager;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;

public class MutatorChangeListener implements IResourceChangeListener {
        
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		WodelContext.setProject(null);
		WodelContext.getProject();
	}
 }