package wodel.ai.assistant.wodel;

import java.util.List;

/** Parsed conversational overrides for a Wodel mutation execution. */
public record WodelMutationRequest(
        String programName,
        Integer numMutants,
        Integer maxAttempts,
        Long executionSeed,
        List<String> blockNames,
        Boolean registry,
        Boolean metrics,
        Boolean debugMetrics,
        Boolean serialize) {

    public WodelMutationRequest {
        programName = programName == null || programName.isBlank() ? null : programName.trim();
        blockNames = blockNames == null ? List.of() : List.copyOf(blockNames);
    }

    public boolean hasOverrides() {
        return programName != null
            || numMutants != null
            || maxAttempts != null
            || executionSeed != null
            || !blockNames.isEmpty()
            || registry != null
            || metrics != null
            || debugMetrics != null
            || serialize != null;
    }
}
