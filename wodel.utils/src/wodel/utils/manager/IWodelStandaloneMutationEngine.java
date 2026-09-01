package wodel.utils.manager;

import org.eclipse.emf.ecore.resource.Resource;

public interface IWodelStandaloneMutationEngine {

	    InMemoryMutationResult mutate(
	        Resource source,
	        StandaloneMutationContext context);
}

