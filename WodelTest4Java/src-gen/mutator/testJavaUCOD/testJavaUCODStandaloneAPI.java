package mutator.testJavaUCOD;

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
import mutator.testJavaUCODStandalone.testJavaUCODStandalone;
import org.eclipse.core.runtime.NullProgressMonitor;
import wodel.utils.manager.MutatorStandaloneAPI;
import wodel.utils.manager.MutatorUtils;

public class testJavaUCODStandaloneAPI extends MutatorStandaloneAPI {
	public static void createMutants(String[] mutationOperators)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		System.out.println("Wodel mutator file: testJavaUCOD");
		String ecoreURI = "C:/eclipse/workspace4/WodelTest4Java/data/model/java.ecore";
		List<EPackage> packages = null;
		try {
			packages = ModelManager.loadMetaModel(ecoreURI, testJavaUCODStandaloneAPI.class);
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
		int maxAttempts = 8;
		int numMutants = 8;
		boolean registry = true;
		boolean metrics = false;
		boolean debugMetrics = false;
		MutatorUtils muttestJavaUCOD = new testJavaUCODStandalone();
		muttestJavaUCOD.execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages,
				localRegisteredPackages, mutationOperators, new NullProgressMonitor(), true, null,
				new TreeMap<String, List<String>>());
		if (isRegistered == true) {
			ModelManager.registerMetaModel(localRegisteredPackages);
			if (registeredPackages != null) {
				ModelManager.registerMetaModel(registeredPackages);
			}
		}
		System.out.println("testJavaUCOD Mutant generation process finished.");
	}
}
