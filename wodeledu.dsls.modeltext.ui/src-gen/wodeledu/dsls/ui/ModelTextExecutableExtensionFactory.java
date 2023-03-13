/*
 * generated by Xtext 2.30.0
 */
package wodeledu.dsls.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import wodeledu.dsls.modeltext.ui.internal.ModeltextActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ModelTextExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(ModeltextActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		ModeltextActivator activator = ModeltextActivator.getInstance();
		return activator != null ? activator.getInjector(ModeltextActivator.WODELEDU_DSLS_MODELTEXT) : null;
	}

}
