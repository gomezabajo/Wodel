package wodel.utils.manager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public final class MutatorExecutorResolver {

    private MutatorExecutorResolver() {
    }


    public static MutatorExecutorHandle resolve(
            Path mutatorFile,
            Path metamodelFile) {

        Objects.requireNonNull(
            mutatorFile,
            "mutatorFile");

        Objects.requireNonNull(
            metamodelFile,
            "metamodelFile");

        Path mutator =
            mutatorFile
                .toAbsolutePath()
                .normalize();

        Path metamodel =
            metamodelFile
                .toAbsolutePath()
                .normalize();

        if (!Files.isRegularFile(mutator)) {

            throw new IllegalArgumentException(
                "Wodel mutator does not exist: "
                + mutator);
        }

        if (!Files.isRegularFile(metamodel)) {

            throw new IllegalArgumentException(
                "Metamodel does not exist: "
                + metamodel);
        }

        Path projectRoot =
            findProjectRoot(
                mutator);

        String filename =
            mutator
                .getFileName()
                .toString();

        int dot =
            filename.lastIndexOf('.');

        String mutatorName =
            dot > 0
                ? filename.substring(
                    0,
                    dot)
                : filename;

        return new MutatorExecutorHandle(
            projectRoot,
            mutator,
            metamodel,
            mutatorName);
    }


    private static Path findProjectRoot(
            Path file) {

        Path current =
            file.getParent();

        while (current != null) {

            if (Files.isRegularFile(
                    current.resolve(
                        ".project"))) {

                return current;
            }

            current =
                current.getParent();
        }

        throw new IllegalArgumentException(
            "Cannot determine Wodel project root "
            + "for "
            + file
            + ". No parent .project file was found.");
    }
}