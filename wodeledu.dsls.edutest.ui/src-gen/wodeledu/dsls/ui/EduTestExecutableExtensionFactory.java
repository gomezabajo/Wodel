/*
 * generated by Xtext
 */
package wodeledu.dsls.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import wodeledu.dsls.ui.internal.EduTestActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class EduTestExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return EduTestActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return EduTestActivator.getInstance().getInjector(EduTestActivator.WODELEDU_DSLS_EDUTEST);
	}
	
}
