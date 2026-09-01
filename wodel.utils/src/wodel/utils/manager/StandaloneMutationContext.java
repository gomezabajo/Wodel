package wodel.utils.manager;

import java.util.Map;
import java.util.Random;

import org.eclipse.emf.ecore.EPackage;

public record StandaloneMutationContext(
        Random random,
        String[] blockNames,
        boolean registry,
        Map<String, EPackage> registeredPackages) {
}
