/*
 * generated by Xtext 2.30.0
 */
package wodeledu.dsls;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class ModelDrawStandaloneSetup extends ModelDrawStandaloneSetupGenerated {

	public static void doSetup() {
		new ModelDrawStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
