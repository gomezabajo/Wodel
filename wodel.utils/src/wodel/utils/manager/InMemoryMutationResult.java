package wodel.utils.manager;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import appliedMutations.Mutations;

public record InMemoryMutationResult(
        Resource mutant,
        List<EPackage> packages,
        Mutations registry,
        String mutatorName) {
}