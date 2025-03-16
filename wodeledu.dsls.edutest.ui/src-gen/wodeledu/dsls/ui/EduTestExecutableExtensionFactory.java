/*
 * generated by Xtext 2.38.0
 */
package wodeledu.dsls.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import wodeledu.dsls.edutest.ui.internal.EdutestActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class EduTestExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(EdutestActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		EdutestActivator activator = EdutestActivator.getInstance();
		return activator != null ? activator.getInjector(EdutestActivator.WODELEDU_DSLS_EDUTEST) : null;
	}

}
