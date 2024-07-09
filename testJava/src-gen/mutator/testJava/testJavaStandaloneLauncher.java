package mutator.testJava;

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
import mutator.testJavaAOStandalone.testJavaAOStandalone;
import mutator.testJavaAPStandalone.testJavaAPStandalone;
import mutator.testJavaASOStandalone.testJavaASOStandalone;
import mutator.testJavaCOStandalone.testJavaCOStandalone;
import mutator.testJavaCODStandalone.testJavaCODStandalone;
import mutator.testJavaDLMStandalone.testJavaDLMStandalone;
import mutator.testJavaINStandalone.testJavaINStandalone;
import mutator.testJavaLOStandalone.testJavaLOStandalone;
import mutator.testJavaNLSStandalone.testJavaNLSStandalone;
import mutator.testJavaRestStandalone.testJavaRestStandalone;
import mutator.testJavaROStandalone.testJavaROStandalone;
import mutator.testJavaSOStandalone.testJavaSOStandalone;
import mutator.testJavaUCODStandalone.testJavaUCODStandalone;
import wodel.utils.manager.IMutatorStandaloneExecutor;
import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.MutatorUtils.MutationResults;

public class testJavaStandaloneLauncher implements IMutatorStandaloneExecutor {
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics,
			boolean debugMetrics, String[] blockNames, IProgressMonitor monitor, boolean serialize, Object testObject,
			Map<String, List<String>> classes, Map<String, EPackage> registeredPackages)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		IWodelTest test = testObject != null ? (IWodelTest) testObject : null;
		String ecoreURI = "/testJava/data/model/java.ecore";
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
		MutatorUtils muttestJavaAO = new testJavaAOStandalone();
		MutationResults resultstestJavaAO = muttestJavaAO.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestJavaAO.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestJavaAO.numMutantsGenerated;
		if (resultstestJavaAO.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestJavaAO.mutatorsApplied);
		}
		MutatorUtils muttestJavaAP = new testJavaAPStandalone();
		MutationResults resultstestJavaAP = muttestJavaAP.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestJavaAP.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestJavaAP.numMutantsGenerated;
		if (resultstestJavaAP.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestJavaAP.mutatorsApplied);
		}
		MutatorUtils muttestJavaASO = new testJavaASOStandalone();
		MutationResults resultstestJavaASO = muttestJavaASO.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestJavaASO.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestJavaASO.numMutantsGenerated;
		if (resultstestJavaASO.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestJavaASO.mutatorsApplied);
		}
		MutatorUtils muttestJavaCO = new testJavaCOStandalone();
		MutationResults resultstestJavaCO = muttestJavaCO.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestJavaCO.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestJavaCO.numMutantsGenerated;
		if (resultstestJavaCO.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestJavaCO.mutatorsApplied);
		}
		MutatorUtils muttestJavaCOD = new testJavaCODStandalone();
		MutationResults resultstestJavaCOD = muttestJavaCOD.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestJavaCOD.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestJavaCOD.numMutantsGenerated;
		if (resultstestJavaCOD.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestJavaCOD.mutatorsApplied);
		}
		MutatorUtils muttestJavaDLM = new testJavaDLMStandalone();
		MutationResults resultstestJavaDLM = muttestJavaDLM.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestJavaDLM.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestJavaDLM.numMutantsGenerated;
		if (resultstestJavaDLM.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestJavaDLM.mutatorsApplied);
		}
		MutatorUtils muttestJavaIN = new testJavaINStandalone();
		MutationResults resultstestJavaIN = muttestJavaIN.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestJavaIN.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestJavaIN.numMutantsGenerated;
		if (resultstestJavaIN.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestJavaIN.mutatorsApplied);
		}
		MutatorUtils muttestJavaLO = new testJavaLOStandalone();
		MutationResults resultstestJavaLO = muttestJavaLO.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestJavaLO.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestJavaLO.numMutantsGenerated;
		if (resultstestJavaLO.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestJavaLO.mutatorsApplied);
		}
		MutatorUtils muttestJavaNLS = new testJavaNLSStandalone();
		MutationResults resultstestJavaNLS = muttestJavaNLS.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestJavaNLS.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestJavaNLS.numMutantsGenerated;
		if (resultstestJavaNLS.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestJavaNLS.mutatorsApplied);
		}
		MutatorUtils muttestJavaRest = new testJavaRestStandalone();
		MutationResults resultstestJavaRest = muttestJavaRest.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestJavaRest.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestJavaRest.numMutantsGenerated;
		if (resultstestJavaRest.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestJavaRest.mutatorsApplied);
		}
		MutatorUtils muttestJavaRO = new testJavaROStandalone();
		MutationResults resultstestJavaRO = muttestJavaRO.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestJavaRO.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestJavaRO.numMutantsGenerated;
		if (resultstestJavaRO.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestJavaRO.mutatorsApplied);
		}
		MutatorUtils muttestJavaSO = new testJavaSOStandalone();
		MutationResults resultstestJavaSO = muttestJavaSO.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestJavaSO.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestJavaSO.numMutantsGenerated;
		if (resultstestJavaSO.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestJavaSO.mutatorsApplied);
		}
		MutatorUtils muttestJavaUCOD = new testJavaUCODStandalone();
		MutationResults resultstestJavaUCOD = muttestJavaUCOD.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize,
				test, classes);
		mutationResults.numMutatorsApplied += resultstestJavaUCOD.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultstestJavaUCOD.numMutantsGenerated;
		if (resultstestJavaUCOD.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultstestJavaUCOD.mutatorsApplied);
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
