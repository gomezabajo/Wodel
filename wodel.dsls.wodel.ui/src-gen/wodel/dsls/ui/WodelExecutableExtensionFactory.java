/*
 * generated by Xtext 2.38.0
 */
package wodel.dsls.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import wodel.dsls.wodel.ui.internal.WodelActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class WodelExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(WodelActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		WodelActivator activator = WodelActivator.getInstance();
		return activator != null ? activator.getInjector(WodelActivator.WODEL_DSLS_WODEL) : null;
	}

}
