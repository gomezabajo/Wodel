package mutator.testATL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import mutator.testATLBStandalone.testATLBStandalone;
import mutator.testATLFStandalone.testATLFStandalone;
import mutator.testATLIPEStandalone.testATLIPEStandalone;
import mutator.testATLMRStandalone.testATLMRStandalone;
import mutator.testATLOPEStandalone.testATLOPEStandalone;
import wodel.utils.manager.IMutatorStandaloneExecutor;
import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.MutatorUtils.MutationResults;

public class testATLStandaloneLauncher implements IMutatorStandaloneExecutor {
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics,
			boolean debugMetrics, String[] blockNames, IProgressMonitor monitor, boolean serialize, Object testObject,
			TreeMap<String, List<String>> classes, HashMap<String, EPackage> registeredPackages)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		IWodelTest test = testObject != null ? (IWodelTest) testObject : null;
		String ecoreURI = "/testATL/data/model/ATL.ecore";
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
		MutatorUtils muttestATLB = new testATLBStandalone();
		MutationResults resultstestATLB = muttestATLB.execute(maxAttempts, numMutants, registry, metrics, debugMetrics,
				packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize, test, classes);
		mutationResults.numMutatorsApplied += resultstestATLB.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestATLB.numMutantsGenerated;
		if (resultstestATLB.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestATLB.mutatorsApplied);
		}
		MutatorUtils muttestATLF = new testATLFStandalone();
		MutationResults resultstestATLF = muttestATLF.execute(maxAttempts, numMutants, registry, metrics, debugMetrics,
				packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize, test, classes);
		mutationResults.numMutatorsApplied += resultstestATLF.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestATLF.numMutantsGenerated;
		if (resultstestATLF.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestATLF.mutatorsApplied);
		}
		MutatorUtils muttestATLIPE = new testATLIPEStandalone();
		MutationResults resultstestATLIPE = muttestATLIPE.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestATLIPE.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestATLIPE.numMutantsGenerated;
		if (resultstestATLIPE.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestATLIPE.mutatorsApplied);
		}
		MutatorUtils muttestATLMR = new testATLMRStandalone();
		MutationResults resultstestATLMR = muttestATLMR.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestATLMR.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestATLMR.numMutantsGenerated;
		if (resultstestATLMR.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestATLMR.mutatorsApplied);
		}
		MutatorUtils muttestATLOPE = new testATLOPEStandalone();
		MutationResults resultstestATLOPE = muttestATLOPE.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestATLOPE.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestATLOPE.numMutantsGenerated;
		if (resultstestATLOPE.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestATLOPE.mutatorsApplied);
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
