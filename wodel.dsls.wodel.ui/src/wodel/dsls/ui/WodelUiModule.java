/*
 * generated by Xtext 2.36.0
 */
package wodel.dsls.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.resource.containers.IAllContainersState;

import com.google.inject.Provider;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
public class WodelUiModule extends AbstractWodelUiModule {

	public WodelUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	@Override
    public Provider<IAllContainersState> provideIAllContainersState() {
      return org.eclipse.xtext.ui.shared.Access.getWorkspaceProjectsState();
    }
}
