/*
 * generated by Xtext
 */
package wodeledu.dsls;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ModelTextStandaloneSetup extends ModelTextStandaloneSetupGenerated{

	public static void doSetup() {
		new ModelTextStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

