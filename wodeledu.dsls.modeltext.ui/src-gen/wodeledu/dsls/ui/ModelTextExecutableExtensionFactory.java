/*
 * generated by Xtext 2.12.0
 */
package wodeledu.dsls.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import wodeledu.dsls.modeltext.ui.internal.ModeltextActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ModelTextExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return ModeltextActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return ModeltextActivator.getInstance().getInjector(ModeltextActivator.WODELEDU_DSLS_MODELTEXT);
	}
	
}
