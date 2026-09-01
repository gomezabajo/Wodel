package wodel.utils.manager;

import java.util.List;
import java.util.Random;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

public interface IWodelMutationEngine {

    InMemoryMutationResult mutate(
        MutatorExecutorHandle executor,
        List<EPackage> packages,
        Resource source,
        String[] blockNames,
        Random random,
        boolean registry);

	List<String> getOperatorIds(MutatorExecutorHandle executor);
}