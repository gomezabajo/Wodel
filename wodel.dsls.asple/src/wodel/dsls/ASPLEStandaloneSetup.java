/*
 * generated by Xtext 2.30.0
 */
package wodel.dsls;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class ASPLEStandaloneSetup extends ASPLEStandaloneSetupGenerated {

	public static void doSetup() {
		new ASPLEStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
