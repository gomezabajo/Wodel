/*
 * generated by Xtext 2.37.0
 */
package wodeledu.dsls.modeltext.ui.internal;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.osgi.framework.BundleContext;
import wodeledu.dsls.ModelTextRuntimeModule;
import wodeledu.dsls.ui.ModelTextUiModule;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ModeltextActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "wodeledu.dsls.modeltext.ui";
	public static final String WODELEDU_DSLS_MODELTEXT = "wodeledu.dsls.ModelText";
	
	private static final Logger logger = Logger.getLogger(ModeltextActivator.class);
	
	private static ModeltextActivator INSTANCE;
	
	private Map<String, Injector> injectors = Collections.synchronizedMap(new HashMap<>(2));
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		injectors.clear();
		INSTANCE = null;
		super.stop(context);
	}
	
	public static ModeltextActivator getInstance() {
		return INSTANCE;
	}
	
	public Injector getInjector(String language) {
		synchronized (injectors) {
			Injector injector = injectors.get(language);
			if (injector == null) {
				injectors.put(language, injector = createInjector(language));
			}
			return injector;
		}
	}
	
	protected Injector createInjector(String language) {
		try {
			com.google.inject.Module runtimeModule = getRuntimeModule(language);
			com.google.inject.Module sharedStateModule = getSharedStateModule();
			com.google.inject.Module uiModule = getUiModule(language);
			com.google.inject.Module mergedModule = Modules2.mixin(runtimeModule, sharedStateModule, uiModule);
			return Guice.createInjector(mergedModule);
		} catch (Exception e) {
			logger.error("Failed to create injector for " + language);
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Failed to create injector for " + language, e);
		}
	}
	
	protected com.google.inject.Module getRuntimeModule(String grammar) {
		if (WODELEDU_DSLS_MODELTEXT.equals(grammar)) {
			return new ModelTextRuntimeModule();
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected com.google.inject.Module getUiModule(String grammar) {
		if (WODELEDU_DSLS_MODELTEXT.equals(grammar)) {
			return new ModelTextUiModule(this);
		}
		throw new IllegalArgumentException(grammar);
	}
	
	protected com.google.inject.Module getSharedStateModule() {
		return new SharedStateModule();
	}
	
	
}
