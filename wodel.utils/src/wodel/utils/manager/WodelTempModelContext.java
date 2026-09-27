package wodel.utils.manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.resource.Resource;


/**
 * Execution-local storage for temporary EMF models created
 * while a Wodel mutation block is being executed.
 *
 * Each worker thread / mutation block owns one independent
 * temporary context.
 */
public final class WodelTempModelContext {


    /*
     * Each Wodel block runs in its own worker thread
     * (currently typically a virtual thread).
     *
     * Therefore ThreadLocal gives every block an isolated
     * temporary workspace and filename sequence.
     */
    private static final ThreadLocal<TempContext> CURRENT =
        new ThreadLocal<>();


    private WodelTempModelContext() {
    }


    /**
     * State associated with one Wodel block execution.
     */
    private static final class TempContext {

        private final Path folder;

        /*
         * Monotonically increasing identifier used only for
         * temporary model filenames.
         *
         * It is deliberately execution-local.
         */
        private long sequence;


        private TempContext(
                Path folder) {

            this.folder =
                folder;

            this.sequence =
                0L;
        }


        private long nextSequence() {

            return sequence++;
        }


        private Path folder() {

            return folder;
        }
    }


    /**
     * Converts the path representation traditionally returned
     * by Wodel/EMF into a native java.nio.file.Path.
     *
     * In particular, EMF frequently represents a Windows path as:
     *
     *     /C:/workspace/project/data/model
     *
     * while java.nio.file.Path on Windows expects:
     *
     *     C:/workspace/project/data/model
     */
    private static Path toNativePath(
            String path) {

        if (path == null
                || path.isBlank()) {

            throw new IllegalArgumentException(
                "The Wodel models folder cannot be null or blank");
        }


        String normalized =
            path.trim()
                .replace(
                    '\\',
                    '/');


        /*
         * Handle a real file URI first.
         *
         * Examples:
         *
         *     file:/C:/workspace/...
         *     file:///C:/workspace/...
         */
        if (normalized
                .toLowerCase()
                .startsWith(
                    "file:")) {

            try {

                return Paths.get(
                        java.net.URI.create(
                            normalized))
                    .toAbsolutePath()
                    .normalize();
            }
            catch (Exception e) {

                throw new IllegalArgumentException(
                    "Cannot convert Wodel file URI to a path: "
                    + path,
                    e);
            }
        }


        /*
         * Handle EMF-style absolute Windows paths:
         *
         *     /C:/workspace/...
         *
         * becomes:
         *
         *     C:/workspace/...
         */
        if (normalized.matches(
                "^/[A-Za-z]:/.*")) {

            normalized =
                normalized.substring(
                    1);
        }


        return Paths.get(
                normalized)
            .toAbsolutePath()
            .normalize();
    }
    
    public static void deleteFolder(
            Path folder) {

        if (folder == null
                || !Files.exists(
                    folder)) {

            return;
        }


        try (Stream<Path> paths =
                Files.walk(
                    folder)) {

            paths
                .sorted(
                    Comparator.reverseOrder())
                .forEach(
                    path -> {

                        try {

                            Files.deleteIfExists(
                                path);
                        }
                        catch (IOException ignored) {
                        }
                    });
        }
        catch (IOException ignored) {
        }
    }
    
    private static void deleteRecursively(
            Path folder) {

        if (folder == null
                || !Files.exists(
                    folder)) {

            return;
        }

        try (Stream<Path> paths =
                Files.walk(
                    folder)) {

            paths
                .sorted(
                    Comparator.reverseOrder())
                .forEach(
                    path -> {

                        try {

                            Files.deleteIfExists(
                                path);
                        }
                        catch (IOException e) {

                            throw new IllegalStateException(
                                "Cannot delete temporary Wodel path: "
                                + path,
                                e);
                        }
                    });
        }
        catch (IOException e) {

            throw new IllegalStateException(
                "Cannot clean deterministic Wodel "
                + "temporary workspace: "
                + folder,
                e);
        }
    }


    private static Path inferProjectRootFromCodeSource(
            Class<?> standaloneClass)
            throws IOException {

        Objects.requireNonNull(
            standaloneClass,
            "standaloneClass");


        try {

            java.security.ProtectionDomain protectionDomain =
                standaloneClass.getProtectionDomain();


            if (protectionDomain == null) {

                throw new IOException(
                    "Cannot inspect protection domain for "
                    + standaloneClass.getName());
            }


            java.security.CodeSource codeSource =
                protectionDomain.getCodeSource();


            if (codeSource == null
                    || codeSource.getLocation() == null) {

                throw new IOException(
                    "Cannot determine code-source location for "
                    + standaloneClass.getName());
            }


            java.net.URL location =
                codeSource.getLocation();


            if (!"file".equalsIgnoreCase(
                    location.getProtocol())) {

                throw new IOException(
                    "Unsupported Wodel standalone code-source protocol "
                    + location.getProtocol()
                    + " for "
                    + standaloneClass.getName()
                    + ": "
                    + location);
            }


            Path current =
                Paths.get(
                        location.toURI())
                    .toAbsolutePath()
                    .normalize();


            /*
             * A CodeSource normally points to a classes directory.
             * Be defensive if it happens to point to a file.
             */
            if (!Files.isDirectory(
                    current)) {

                current =
                    current.getParent();
            }


            while (current != null) {

                if (Files.isRegularFile(
                        current.resolve(
                            ".project"))) {

                    return current
                        .toAbsolutePath()
                        .normalize();
                }


                current =
                    current.getParent();
            }


            throw new IOException(
                "Cannot determine the Wodel project root for "
                + standaloneClass.getName()
                + " from code-source location "
                + location
                + ": no parent .project file was found");
        }
        catch (java.net.URISyntaxException e) {

            throw new IOException(
                "Cannot convert the code-source location of "
                + standaloneClass.getName()
                + " to a filesystem path",
                e);
        }
    }
    
    private static Path resolveModelsFolder(
            Class<?> standaloneClass)
            throws IOException {

        /*
         * =========================================================
         * 1. Normal Wodel resolution
         * =========================================================
         */

        String rawModelsFolder =
            null;


        try {

            rawModelsFolder =
                ModelManager.getModelsFolder(
                    standaloneClass);
        }
        catch (RuntimeException ignored) {

            /*
             * Fall through to the code-source strategy.
             */
        }


        if (rawModelsFolder != null
                && !rawModelsFolder.isBlank()) {

            try {

                Path resolved =
                    toNativePath(
                        rawModelsFolder);


                if (Files.isDirectory(
                        resolved)) {

                    return resolved;
                }
            }
            catch (RuntimeException ignored) {

                /*
                 * A stale or malformed path should not prevent the
                 * archived-project fallback below.
                 */
            }
        }


        /*
         * =========================================================
         * 2. Headless / archived replay fallback
         * =========================================================
         *
         * The generated standalone class is loaded from:
         *
         *     <wodel-project>/bin/
         *
         * or:
         *
         *     <wodel-project>/target/classes/
         *
         * or:
         *
         *     <wodel-project>/build/classes/java/main/
         *
         * Therefore walk upwards from its code-source location until
         * the Wodel project's .project file is found.
         */

        Path projectRoot =
            inferProjectRootFromCodeSource(
                standaloneClass);


        Path fallback =
            projectRoot
                .resolve(
                    "data")
                .resolve(
                    "model")
                .toAbsolutePath()
                .normalize();


        if (!Files.isDirectory(
                fallback)) {

            throw new IOException(
                "Cannot determine the Wodel models folder for "
                + standaloneClass.getName()
                + ". ModelManager returned "
                + String.valueOf(
                    rawModelsFolder)
                + " and the inferred project models directory "
                + "does not exist: "
                + fallback);
        }


        System.out.println(
            "[WODEL TEMP] ModelManager models folder unavailable; "
            + "using code-source fallback "
            + fallback);


        return fallback;
    }
    
    public static Path detach() {

        TempContext context =
            CURRENT.get();


        CURRENT.remove();


        return context != null
            ? context.folder()
            : null;
    }
    
    /**
     * Opens a fresh temporary workspace for one execution
     * of one Wodel mutation block.
     *
     * Example:
     *
     *     .../data/temp/
     *         wodel-cf-abc123-84729384/
     */
    public static void begin(
            Class<?> standaloneClass,
            String blockName,
            long executionSeed)
            throws IOException {

        if (standaloneClass == null) {

            throw new IllegalArgumentException(
                "standaloneClass cannot be null");
        }


        /*
         * Defensive cleanup in case this thread already owns
         * a context.
         */
        end();


//        String rawModelsFolder =
//            ModelManager.getModelsFolder(
//                standaloneClass);
//
//
//        Path modelsFolder =
//            toNativePath(
//                rawModelsFolder);
        
        Path modelsFolder =
        	    resolveModelsFolder(
        	        standaloneClass);


        /*
         * If:
         *
         *     modelsFolder = .../data/model
         *
         * then:
         *
         *     tempRoot = .../data/temp
         */
        Path dataFolder =
            modelsFolder.getParent();


        Path tempRoot;

        if (dataFolder != null) {

            tempRoot =
                dataFolder.resolve(
                    "temp");
        }
        else {

            tempRoot =
                Paths.get(
                    System.getProperty(
                        "java.io.tmpdir"),
                    "wodel");
        }


        Files.createDirectories(
            tempRoot);


        
        String prefix =
            "wodel-"
            + sanitize(
                blockName)
            + "-"
            + Long.toUnsignedString(
                executionSeed,
                36)
            + "-";


        /*
         * createTempDirectory adds a unique suffix.
         *
         * Therefore two deterministic executions having the
         * same executionSeed still never share physical files
         * or EMF resource URIs.
         */

        Path executionFolder =
            Files.createTempDirectory(
                tempRoot,
                prefix)
            .toAbsolutePath()
            .normalize();


//        
//        String folderName =
//        	    "wodel-"
//        	    + sanitize(
//        	        blockName)
//        	    + "-"
//        	    + Long.toUnsignedString(
//        	        executionSeed,
//        	        36);
//
//        	Path executionFolder =
//        	    tempRoot
//        	        .resolve(
//        	            folderName)
//        	        .toAbsolutePath()
//        	        .normalize();

        	/*
        	 * A previous abnormal execution may have left the
        	 * deterministic workspace behind.
        	 */
        	deleteRecursively(
        	    executionFolder);

        	Files.createDirectories(
        	    executionFolder);
        	
        CURRENT.set(
            new TempContext(
                executionFolder));


        /*
         * Useful while stabilising the new implementation.
         * This can later be removed or changed to debug logging.
         */
        System.out.println(
            "[WODEL TEMP] block="
            + blockName
            + " folder="
            + executionFolder);
    }


    /**
     * Allocates a fresh path for the next intermediate model.
     *
     * The filename sequence is local to the current block
     * execution and therefore cannot collide with another
     * worker or another Wodel invocation.
     */
    public static String nextModelPath(
            Resource source,
            String mutationName) {

        TempContext context =
            requireContext();


        String sourceName =
            source != null
            && source.getURI() != null
            ? source.getURI()
                .lastSegment()
            : null;


        if (sourceName == null
                || sourceName.isBlank()) {

            sourceName =
                "Candidate.model";
        }


        String stem =
            removeExtension(
                sourceName);


        long sequence =
            context.nextSequence();


        String filename =
            stem
            + "."
            + sanitize(
                mutationName)
            + "."
            + sequence
            + ".model";


        return context.folder()
            .resolve(
                filename)
            .toAbsolutePath()
            .normalize()
            .toString();
    }

    /**
     * Returns the temporary directory belonging to the current
     * Wodel block, or null when no context is active.
     */
    public static Path currentFolder() {

        TempContext context =
            CURRENT.get();

        return context != null
            ? context.folder()
            : null;
    }


    /**
     * Returns true when the current worker owns a temporary
     * Wodel context.
     */
    public static boolean isActive() {

        return CURRENT.get()
            != null;
    }


    /**
     * Closes the current execution-local temporary workspace.
     *
     * Cleanup errors are deliberately non-fatal because a
     * cleanup problem must not hide the original mutation
     * generation exception.
     */
//    public static void end() {
//
//        TempContext context =
//            CURRENT.get();
//
//
//        /*
//         * Always remove the ThreadLocal reference first.
//         *
//         * This is particularly important for executor threads.
//         */
//        CURRENT.remove();
//
//
//        if (context == null) {
//
//            return;
//        }
//
//
//        Path folder =
//            context.folder();
//
//
//        if (folder == null
//                || !Files.exists(
//                    folder)) {
//
//            return;
//        }
//
//
//        try (Stream<Path> paths =
//                Files.walk(
//                    folder)) {
//
//            paths
//                .sorted(
//                    Comparator.reverseOrder())
//                .forEach(
//                    path -> {
//
//                        try {
//
//                            Files.deleteIfExists(
//                                path);
//                        }
//                        catch (IOException e) {
//
//                            System.err.println(
//                                "[WODEL TEMP] Cannot delete "
//                                + path
//                                + ": "
//                                + e.getMessage());
//                        }
//                    });
//        }
//        catch (IOException e) {
//
//            System.err.println(
//                "[WODEL TEMP] Cannot clean "
//                + folder
//                + ": "
//                + e.getMessage());
//        }
//    }

//    public static void end() {
//
//        TempContext context =
//            CURRENT.get();
//
//        CURRENT.remove();
//
//        if (context == null) {
//            return;
//        }
//
//        try {
//
//            deleteRecursively(
//                context.folder());
//        }
//        catch (RuntimeException e) {
//
//            /*
//             * Cleanup must not hide the mutation exception.
//             */
//            System.err.println(
//                "[WODEL TEMP] Cannot clean "
//                + context.folder()
//                + ": "
//                + e.getMessage());
//        }
//    }
    
    public static void end() {

        /*
         * IMPORTANT:
         *
         * Do not delete the execution folder here.
         *
         * The generated Wodel worker returns mutant paths pointing
         * into this directory. Those paths are consumed afterwards
         * by the parent execution while merging/publishing the
         * block result.
         *
         * Deleting the directory here makes MutationResults report
         * generated mutants although no physical mutant survives
         * long enough to be copied to data/out.
         */

        CURRENT.remove();
    }

    /**
     * Obtains the current context or fails with an explanatory
     * error instead of producing a NullPointerException.
     */
    private static TempContext requireContext() {

        TempContext context =
            CURRENT.get();

        if (context == null) {

            throw new IllegalStateException(
                "No Wodel temporary model context "
                + "is active for the current thread");
        }

        return context;
    }


    private static String removeExtension(
            String filename) {

        int dot =
            filename.lastIndexOf(
                '.');

        if (dot > 0) {

            return filename.substring(
                0,
                dot);
        }

        return filename;
    }


    private static String sanitize(
            String value) {

        if (value == null
                || value.isBlank()) {

            return "unknown";
        }

        return value.replaceAll(
            "[^A-Za-z0-9._-]",
            "_");
    }
}