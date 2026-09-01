package wodel.utils.manager;

import java.nio.file.Path;
import java.util.Objects;

public record MutatorExecutorHandle(
        Path projectRoot,
        Path mutatorFile,
        Path metamodelFile,
        String mutatorName) {

    public MutatorExecutorHandle {

        Objects.requireNonNull(
            projectRoot,
            "projectRoot");

        Objects.requireNonNull(
            mutatorFile,
            "mutatorFile");

        Objects.requireNonNull(
            metamodelFile,
            "metamodelFile");

        Objects.requireNonNull(
            mutatorName,
            "mutatorName");

        projectRoot =
            projectRoot
                .toAbsolutePath()
                .normalize();

        mutatorFile =
            mutatorFile
                .toAbsolutePath()
                .normalize();

        metamodelFile =
            metamodelFile
                .toAbsolutePath()
                .normalize();

        if (mutatorName.isBlank()) {

            throw new IllegalArgumentException(
                "mutatorName must not be blank");
        }
    }
}