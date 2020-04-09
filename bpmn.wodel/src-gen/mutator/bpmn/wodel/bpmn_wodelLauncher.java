package mutator.bpmn.wodel;

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
import mutator.bpmnDelete.bpmnDelete;
import mutator.bpmnInsert.bpmnInsert;
import mutator.bpmnMove.bpmnMove;
import mutator.bpmnReplace.bpmnReplace;
import mutator.bpmnRetype.bpmnRetype;
import manager.IMutatorExecutor;
import manager.IWodelTest;
import manager.ModelManager;
import manager.MutatorUtils;
import manager.MutatorUtils.MutationResults;

public class bpmn_wodelLauncher implements IMutatorExecutor {
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics,
			boolean debugMetrics, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize,
			Object testObject, TreeMap<String, List<String>> classes)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		IWodelTest test = testObject != null ? (IWodelTest) testObject : null;
		String ecoreURI = "C:/eclipse/runtime-EclipseApplication/bpmn.wodel/data/model/simplebpmn.ecore";
		List<EPackage> packages = ModelManager.loadMetaModel(ecoreURI);
		boolean isRegistered = ModelManager.isRegistered(packages);
		Map<String, EPackage> registeredPackages = new HashMap<String, EPackage>();
		if (isRegistered == true) {
			registeredPackages = ModelManager.unregisterMetaModel(packages);
		}
		MutationResults mutationResults = new MutationResults();
		MutatorUtils mutbpmnDelete = new bpmnDelete();
		MutationResults resultsbpmnDelete = mutbpmnDelete.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, blockNames, project, monitor, serialize, test, classes);
		mutationResults.numMutatorsApplied += resultsbpmnDelete.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultsbpmnDelete.numMutantsGenerated;
		if (resultsbpmnDelete.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultsbpmnDelete.mutatorsApplied);
		}
		MutatorUtils mutbpmnInsert = new bpmnInsert();
		MutationResults resultsbpmnInsert = mutbpmnInsert.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, blockNames, project, monitor, serialize, test, classes);
		mutationResults.numMutatorsApplied += resultsbpmnInsert.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultsbpmnInsert.numMutantsGenerated;
		if (resultsbpmnInsert.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultsbpmnInsert.mutatorsApplied);
		}
		MutatorUtils mutbpmnMove = new bpmnMove();
		MutationResults resultsbpmnMove = mutbpmnMove.execute(maxAttempts, numMutants, registry, metrics, debugMetrics,
				packages, registeredPackages, blockNames, project, monitor, serialize, test, classes);
		mutationResults.numMutatorsApplied += resultsbpmnMove.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultsbpmnMove.numMutantsGenerated;
		if (resultsbpmnMove.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultsbpmnMove.mutatorsApplied);
		}
		MutatorUtils mutbpmnReplace = new bpmnReplace();
		MutationResults resultsbpmnReplace = mutbpmnReplace.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, blockNames, project, monitor, serialize, test, classes);
		mutationResults.numMutatorsApplied += resultsbpmnReplace.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultsbpmnReplace.numMutantsGenerated;
		if (resultsbpmnReplace.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultsbpmnReplace.mutatorsApplied);
		}
		MutatorUtils mutbpmnRetype = new bpmnRetype();
		MutationResults resultsbpmnRetype = mutbpmnRetype.execute(maxAttempts, numMutants, registry, metrics,
				debugMetrics, packages, registeredPackages, blockNames, project, monitor, serialize, test, classes);
		mutationResults.numMutatorsApplied += resultsbpmnRetype.numMutatorsApplied;
		mutationResults.numMutantsGenerated += resultsbpmnRetype.numMutantsGenerated;
		if (resultsbpmnRetype.mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(resultsbpmnRetype.mutatorsApplied);
		}
		if (isRegistered == true) {
			ModelManager.registerMetaModel(registeredPackages);
		}
		return mutationResults;
	}
}
