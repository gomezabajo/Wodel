package mutator.testATLOPE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.MaxSmallerThanMinException;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ObjectNoTargetableException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;
import wodel.utils.manager.ModelManager;
import mutator.testATLOPEStandalone.testATLOPEStandalone;
import org.eclipse.core.runtime.NullProgressMonitor;
import wodel.utils.manager.MutatorStandaloneAPI;
import wodel.utils.manager.MutatorUtils;

public class testATLOPEStandaloneAPI extends MutatorStandaloneAPI {
	public static void createMutants(String[] mutationOperators)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		System.out.println("Wodel mutator file: testATLOPE");
		String ecoreURI = "C:/eclipse/runtime-EclipseApplication14/WodelTest4ATL/data/model/ATL.ecore";
		List<EPackage> packages = null;
		try {
			packages = ModelManager.loadMetaModel(ecoreURI, testATLOPEStandaloneAPI.class);
		} catch (Exception e) {
		}
		boolean isRegistered = ModelManager.isRegistered(packages);
		Map<String, EPackage> registeredPackages = ModelManager.registeredMetaModels(packages);
		Map<String, EPackage> localRegisteredPackages = null;
		if (isRegistered == true) {
			if (registeredPackages != null) {
				List<EPackage> packageList = new ArrayList<EPackage>();
				packageList.addAll(registeredPackages.values());
				ModelManager.unregisterMetaModel(packageList);
			}
			localRegisteredPackages = ModelManager.unregisterMetaModel(packages);
		}
		int maxAttempts = 3;
		int numMutants = 3;
		boolean registry = true;
		boolean metrics = false;
		boolean debugMetrics = false;
		MutatorUtils muttestATLOPE = new testATLOPEStandalone();
		muttestATLOPE.execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages,
				localRegisteredPackages, mutationOperators, new NullProgressMonitor(), true, null,
				new TreeMap<String, List<String>>());
		if (isRegistered == true) {
			ModelManager.registerMetaModel(localRegisteredPackages);
			if (registeredPackages != null) {
				ModelManager.registerMetaModel(registeredPackages);
			}
		}
		System.out.println("testATLOPE Mutant generation process finished.");
	}
}
