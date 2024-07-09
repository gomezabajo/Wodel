package mutator.WodelTest4Chatbots;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.AbstractMap.SimpleEntry;
import org.eclipse.core.resources.IProject;
import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.MaxSmallerThanMinException;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ObjectNoTargetableException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import mutator.testBotGeneratorStandalone.testBotGeneratorStandalone;
import wodel.utils.manager.IMutatorStandaloneExecutor;
import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.MutatorUtils.MutationResults;

public class WodelTest4ChatbotsStandaloneLauncher implements IMutatorStandaloneExecutor {
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics,
			boolean debugMetrics, String[] blockNames, IProgressMonitor monitor, boolean serialize, Object testObject,
			Map<String, List<String>> classes, Map<String, EPackage> registeredPackages)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		IWodelTest test = testObject != null ? (IWodelTest) testObject : null;
		String ecoreURI = "/data/model/BotGenerator.ecore";
		List<EPackage> packages = ModelManager.loadMetaModel(ecoreURI, this.getClass());
		boolean isRegistered = ModelManager.isRegistered(packages);
		Map<String, EPackage> localRegisteredPackages = null;
		if (isRegistered == true) {
			if (registeredPackages != null) {
				List<EPackage> packageList = new ArrayList<EPackage>();
				packageList.addAll(registeredPackages.values());
				ModelManager.unregisterMetaModel(packageList);
			}
			localRegisteredPackages = ModelManager.unregisterMetaModel(packages);
		}
		MutationResults mutationResults = new MutationResults();
		MutatorUtils muttestBotGenerator = new testBotGeneratorStandalone();
		MutationResults resultstestBotGenerator = muttestBotGenerator.execute(maxAttempts, numMutants, registry,
				metrics, debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor,
				serialize, test, classes);
		mutationResults.numMutatorsApplied += resultstestBotGenerator.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestBotGenerator.numMutantsGenerated;
		if (resultstestBotGenerator.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestBotGenerator.mutatorsApplied);
		}
		if (isRegistered == true) {
			ModelManager.registerMetaModel(localRegisteredPackages);
			if (registeredPackages != null) {
				ModelManager.registerMetaModel(registeredPackages);
			}
		}
		return mutationResults;
	}
}
