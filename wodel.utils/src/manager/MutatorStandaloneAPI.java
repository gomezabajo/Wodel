package manager;

import java.io.IOException;

import exceptions.AbstractCreationException;
import exceptions.MaxSmallerThanMinException;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.ObjectNoTargetableException;
import exceptions.ObjectNotContainedException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;

public abstract class MutatorStandaloneAPI {

	public static void createMutants(String[] mutationOperators) 
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		
	}
}
