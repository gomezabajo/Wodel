package mutator.testJavaRO;

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
import mutator.testJavaROStandalone.testJavaROStandalone;
import org.eclipse.core.runtime.NullProgressMonitor;
import wodel.utils.manager.MutatorStandaloneAPI;
import wodel.utils.manager.MutatorUtils;

public class testJavaROStandaloneAPI extends MutatorStandaloneAPI {
	public static void createMutants(String[] mutationOperators)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		System.out.println("Wodel mutator file: testJavaRO");
		String ecoreURI = "C:/eclipse/runtime-EclipseApplication7/WodelTest4Java/data/model/java.ecore";
		List<EPackage> packages = null;
		try {
			packages = ModelManager.loadMetaModel(ecoreURI, testJavaROStandaloneAPI.class);
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
		MutatorUtils muttestJavaRO = new testJavaROStandalone();
		muttestJavaRO.execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages,
				localRegisteredPackages, mutationOperators, new NullProgressMonitor(), true, null,
				new TreeMap<String, List<String>>());
		if (isRegistered == true) {
			ModelManager.registerMetaModel(localRegisteredPackages);
			if (registeredPackages != null) {
				ModelManager.registerMetaModel(registeredPackages);
			}
		}
		System.out.println("testJavaRO Mutant generation process finished.");
	}
}
