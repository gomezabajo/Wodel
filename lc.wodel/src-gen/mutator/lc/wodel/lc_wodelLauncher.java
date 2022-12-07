package mutator.lc.wodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.AbstractMap.SimpleEntry;
import org.eclipse.core.resources.IProject;
import exceptions.*;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import mutator.lc.lc;
import manager.IMutatorExecutor;
import manager.IWodelTest;
import manager.ModelManager;
import manager.MutatorUtils;
import manager.MutatorUtils.MutationResults;

public class lc_wodelLauncher implements IMutatorExecutor {
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics,
			boolean debugMetrics, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize,
			Object testObject, TreeMap<String, List<String>> classes, HashMap<String, EPackage> registeredPackages)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		IWodelTest test = testObject != null ? (IWodelTest) testObject : null;
		String ecoreURI = "/lc.wodel/data/model/LogicCircuit.ecore";
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
		MutatorUtils mutlc = new lc();
		MutationResults resultslc = mutlc.execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages,
				registeredPackages, localRegisteredPackages, blockNames, project, monitor, serialize, test, classes);
		mutationResults.numMutatorsApplied += resultslc.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultslc.numMutantsGenerated;
		if (resultslc.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultslc.mutatorsApplied);
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
