package manager;

import java.io.IOException;

import exceptions.*;

public interface IMutatorExecutor {
	public void execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics)  throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
	  							  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException;

}
