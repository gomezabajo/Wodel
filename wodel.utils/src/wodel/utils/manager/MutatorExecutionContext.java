package wodel.utils.manager;

import java.nio.file.Path;

public record MutatorExecutionContext(
        MutatorExecutorHandle executor,
        Path inputFolder,
        Path outputFolder) {
}