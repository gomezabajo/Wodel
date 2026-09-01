package wodel.utils.manager;

import java.io.IOException;

import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.MaxSmallerThanMinException;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ObjectNoTargetableException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;

public abstract class MutatorStandaloneAPI {

    public static MutatorUtils.MutationResults createMutants(
            String inputFolder,
            String outputFolder,
            String[] mutationOperators,
            boolean registry,
            long exeuctionSeed)
            throws ReferenceNonExistingException,
                   WrongAttributeTypeException,
                   MaxSmallerThanMinException,
                   AbstractCreationException,
                   ObjectNoTargetableException,
                   ObjectNotContainedException,
                   MetaModelNotFoundException,
                   ModelNotFoundException,
                   IOException {

        throw new UnsupportedOperationException(
            "Generated standalone API required");
    }

    public static MutatorUtils.MutationResults createMutants(
            String inputFolder,
            String outputFolder,
            String[] mutationOperators,
            boolean registry)
            throws ReferenceNonExistingException,
                   WrongAttributeTypeException,
                   MaxSmallerThanMinException,
                   AbstractCreationException,
                   ObjectNoTargetableException,
                   ObjectNotContainedException,
                   MetaModelNotFoundException,
                   ModelNotFoundException,
                   IOException {

        throw new UnsupportedOperationException(
            "Generated standalone API required");
    }
}