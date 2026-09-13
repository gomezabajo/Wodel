package wodel.utils.manager;

import org.eclipse.ocl.xtext.essentialocl.EssentialOCLStandaloneSetup;


final class PivotOclStandaloneSupport {

    private static boolean initialized;


    private PivotOclStandaloneSupport() {
    }


    static synchronized void initialize() {

        if (initialized) {
            return;
        }


        EssentialOCLStandaloneSetup.doSetup();

        initialized = true;
    }
}