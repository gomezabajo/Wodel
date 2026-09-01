package wodel.utils.manager;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import appliedMutations.AppliedMutationsFactory;
import appliedMutations.Mutations;

import wodel.utils.manager.MutatorUtils.MutationResults;


public final class StandaloneWodelMutationEngine
        implements IWodelMutationEngine {

	/*
	 * Wodel currently uses ModelManager.rn as process-global mutable
	 * random state.
	 *
	 * WoMoT requires deterministic mutation and replay. Therefore all
	 * in-process Wodel executions that install an execution-specific RNG
	 * must be serialized until Wodel no longer depends on static random
	 * state.
	 *
	 * IMPORTANT:
	 * This lock must remain static because ModelManager.rn is static.
	 */
	private static final Object WODEL_EXECUTION_LOCK =
		    new Object();
	
	private static final Map<Path, ProjectFirstClassLoader>
    CLASS_LOADERS =
        new ConcurrentHashMap<>();
	
	private InMemoryMutationResult executeMutatorWithRandom(
			MutatorExecutorHandle executor,
			List<EPackage> packages,
            Resource source,
            Path input,
            Path output,
            String[] blockNames,
            Random random,
            boolean registry,
            long executionSeed) {
		
		InMemoryMutationResult result = null;

	    synchronized (WODEL_EXECUTION_LOCK) {

	        Random previous =
	            ModelManager.rn;

	        try {

	            ModelManager.rn =
	                random;

	            result = executeMutator(
	            		 executor,
	            		 packages,
	                     source,
	                     input,
	                     output,
	                     blockNames,
	                     random,
	                     registry,
	                     executionSeed);
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        finally {

	            ModelManager.rn =
	                previous;
	        }
	    }
	    return result;
	}
	
	private static String sha256(
	        Path file)
	        throws IOException {

	    try {

	        MessageDigest digest =
	            MessageDigest.getInstance(
	                "SHA-256");

	        return HexFormat.of()
	            .formatHex(
	                digest.digest(
	                    Files.readAllBytes(
	                        file)));
	    }
	    catch (NoSuchAlgorithmException e) {

	        throw new IllegalStateException(
	            e);
	    }
	}
	
    /*
     * M1 is deliberately sequential.
     *
     * Wodel currently uses global/static runtime state,
     * including ModelManager.rn, and the generated
     * standalone launcher temporarily uses the Wodel
     * project's model/output directories.
     */
    @Override
    public synchronized InMemoryMutationResult mutate(
            MutatorExecutorHandle executor,
            List<EPackage> packages,
            Resource source,
            String[] blockNames,
            Random random,
            boolean registry) {

        Objects.requireNonNull(
            executor,
            "executor");

        Objects.requireNonNull(
            source,
            "source");

        Objects.requireNonNull(
            random,
            "random");

        /*
         * Derive one deterministic Wodel execution seed
         * from the caller-provided random stream.
         *
         * IMPORTANT:
         * never use System.nanoTime() here, because
         * deterministic WoMoT replay requires the same
         * input Random state to produce the same Wodel
         * execution.
         */
        long executionSeed =
            random.nextLong();
        
        System.out.println(
        	    "[WODEL RNG] executionSeed="
        	    + executionSeed);


        /*
         * Legacy Wodel code using ModelManager.rn and
         * the new execution-scoped random machinery
         * should both originate from a deterministic
         * execution seed.
         */
        Random executionRandom =
            new Random(
                executionSeed);

        Path work =
            null;

        try {

            work =
                Files.createTempDirectory(
                    "womot-wodel-");

            Path input =
                Files.createDirectories(
                    work.resolve(
                        "input"));

            Path output =
                Files.createDirectories(
                    work.resolve(
                        "output"));

            /*
             * Exactly ONE candidate enters Wodel.
             */
            Path candidate =
                input.resolve(
                    "Candidate.model");

            saveResourceCopy(
                source,
                candidate);
            
            System.out.println(
            	    "WoMoT candidate: "
            	    + candidate
            	    + " size="
            	    + Files.size(candidate)
            	    + " sha256="
            	    + sha256(candidate));

            return executeMutatorWithRandom(
                executor,
                packages,
                source,
                input,
                output,
                blockNames,
                executionRandom,
                registry,
                executionSeed);
        }
        catch (Exception e) {

            throw new IllegalStateException(
                "Cannot execute Wodel mutator '"
                + executor.mutatorName()
                + "'",
                e);
        }
        finally {

            deleteRecursively(
                work);
        }
    }


    private InMemoryMutationResult executeMutator(
            MutatorExecutorHandle executor,
            List<EPackage> packages,
            Resource source,
            Path input,
            Path output,
            String[] blockNames,
            Random random,
            boolean registry,
            long executionSeed)
            throws Exception {

        Files.createDirectories(
            input);

        Files.createDirectories(
            output);

        MutationResults results =
            invokeStandaloneLauncher(
                executor,
                input,
                output,
                blockNames,
                random,
                registry,
                executionSeed);

        if (results == null) {

            throw new IllegalStateException(
                "Generated Wodel launcher "
                + "returned null MutationResults");
        }

        System.out.println(
            "Wodel numMutantsGenerated = "
            + results.getNumMutantsGenerated());

        System.out.println(
            "Wodel numMutatorsApplied = "
            + results.getNumMutatorsApplied());

        System.out.println(
            "Wodel mutatorsApplied = "
            + results.getMutatorsApplied());

        /*
         * This is normal Wodel non-applicability.
         */
        if (results.getNumMutantsGenerated()
                <= 0) {

            return null;
        }

        Path mutantFile =
            findFirstMutant(
                executor,
                output);

        if (mutantFile == null) {

            throw new IllegalStateException(
                "Wodel reports "
                + results.getNumMutantsGenerated()
                + " generated mutant(s), "
                + "but no mutant model exists under "
                + output);
        }

        System.out.println(
        	    "WoMoT selected mutant = "
        	    + mutantFile
        	    + " size="
        	    + Files.size(mutantFile)
        	    + " sha256="
        	    + sha256(mutantFile));

        /*
         * CRITICAL:
         *
         * Reuse the exact EPackage instances belonging
         * to source. Do not reload the .ecore here.
         */
        Resource mutant =
            loadMutant(
                mutantFile,
                packages,
                source);

        Mutations mutations =
            null;

        if (registry) {

            Path registryFile =
                findRegistryFor(
                    mutantFile,
                    output);

            if (registryFile != null) {

                mutations =
                    loadRegistry(
                        registryFile);
            }
        }

        return new InMemoryMutationResult(
            mutant,
        	packages,
            mutations,
            executor.mutatorName());
    }


    private MutationResults invokeStandaloneLauncher(
            MutatorExecutorHandle executor,
            Path input,
            Path output,
            String[] blockNames,
            Random random,
            boolean registry,
            long executionSeed)
            throws Exception {

        Path classesDirectory =
            findClassesDirectory(
                executor.projectRoot());

        String projectName =
            executor.projectRoot()
                .getFileName()
                .toString();

        String launcherSimpleName =
            projectName
                .replace(
                    ".",
                    "_")
            + "StandaloneAPILauncher";

        /*
         * IMPORTANT:
         * launcher package follows PROJECT NAME,
         * not mutator filename.
         */
        String launcherClassName =
            "mutator."
            + projectName
            + "."
            + launcherSimpleName;

        URL[] urls = {
            classesDirectory
                .toUri()
                .toURL()
        };

        ClassLoader parent =
            StandaloneWodelMutationEngine.class
                .getClassLoader();

        Random previousRandom =
            ModelManager.rn;

        Thread thread =
            Thread.currentThread();

        ClassLoader previousContextLoader =
            thread.getContextClassLoader();

        try (ProjectFirstClassLoader loader =
                new ProjectFirstClassLoader(
                    urls,
                    parent)) {

            /*
             * Sequential M1 deterministic bridge.
             */
            ModelManager.rn =
                random;

            thread.setContextClassLoader(
                loader);

            Class<?> launcherClass =
                Class.forName(
                    launcherClassName,
                    true,
                    loader);

            Method method =
                launcherClass.getMethod(
                    "createMutants",
                    String.class,
                    String.class,
                    String[].class,
                    boolean.class,
                    long.class);

            Object value;

            try {

                value =
                    method.invoke(
                        null,
                        input
                            .toAbsolutePath()
                            .normalize()
                            .toString(),
                        output
                            .toAbsolutePath()
                            .normalize()
                            .toString(),
                        blockNames,
                        registry,
                        executionSeed);
            }
            catch (InvocationTargetException e) {

                Throwable cause =
                    e.getCause();

                if (cause instanceof Exception ex) {
                    throw ex;
                }

                if (cause instanceof Error error) {
                    throw error;
                }

                throw e;
            }

            if (!(value
                    instanceof MutationResults)) {

                throw new IllegalStateException(
                    "Unexpected return value from "
                    + launcherClassName
                    + ".createMutants(): "
                    + (value == null
                        ? "null"
                        : value.getClass()));
            }

            return (MutationResults) value;
        }
        finally {

            ModelManager.rn =
                previousRandom;

            thread.setContextClassLoader(
                previousContextLoader);
        }
    }

/*
    private static void saveResourceCopy(
            Resource source,
            Path target)
            throws IOException {

        ResourceSet resourceSet =
            new ResourceSetImpl();

        resourceSet
            .getResourceFactoryRegistry()
            .getExtensionToFactoryMap()
            .put(
                Resource.Factory.Registry.DEFAULT_EXTENSION,
                new XMIResourceFactoryImpl());

        Resource copy =
            resourceSet.createResource(
                URI.createFileURI(
                    target
                        .toAbsolutePath()
                        .normalize()
                        .toString()));

        copy.getContents()
            .addAll(
                EcoreUtil.copyAll(
                    source.getContents()));

        Map<Object, Object> options =
            new HashMap<>();

        options.put(
            XMLResource.OPTION_PROCESS_DANGLING_HREF,
            XMLResource.OPTION_PROCESS_DANGLING_HREF_THROW);

        copy.save(
            options);
    }
*/
    private static void saveResourceCopy(
            Resource source,
            Path target)
            throws IOException {

        ResourceSet resourceSet =
            new ResourceSetImpl();

        resourceSet
            .getResourceFactoryRegistry()
            .getExtensionToFactoryMap()
            .put(
                Resource.Factory.Registry.DEFAULT_EXTENSION,
                new XMIResourceFactoryImpl());

        Resource copy =
            null;

        try {

            copy =
                resourceSet.createResource(
                    URI.createFileURI(
                        target
                            .toAbsolutePath()
                            .normalize()
                            .toString()));

            copy.getContents()
                .addAll(
                    EcoreUtil.copyAll(
                        source.getContents()));

            Map<Object, Object> options =
                new HashMap<>();

            options.put(
                XMLResource.OPTION_PROCESS_DANGLING_HREF,
                XMLResource.OPTION_PROCESS_DANGLING_HREF_THROW);

            copy.save(
                options);
        }
        finally {

            if (copy != null) {

                copy.unload();
            }

            resourceSet
                .getResources()
                .clear();
        }
    }

    private static Resource loadMutant(
            Path mutantFile,
            List<EPackage> packages,
            Resource source)
            throws IOException {

        ResourceSet resourceSet =
            new ResourceSetImpl();

        resourceSet
            .getResourceFactoryRegistry()
            .getExtensionToFactoryMap()
            .put(
                "model",
                new XMIResourceFactoryImpl());

        resourceSet
            .getResourceFactoryRegistry()
            .getExtensionToFactoryMap()
            .put(
                Resource.Factory.Registry.DEFAULT_EXTENSION,
                new XMIResourceFactoryImpl());
        
        for (EPackage ePackage : packages) {

            resourceSet
                .getPackageRegistry()
                .put(
                    ePackage.getNsURI(),
                    ePackage);
        }
        
        registerSourcePackages(
            resourceSet,
            source);

        Resource mutant =
            resourceSet.getResource(
                URI.createFileURI(
                    mutantFile
                        .toAbsolutePath()
                        .normalize()
                        .toString()),
                true);

        EcoreUtil.resolveAll(
            resourceSet);

        return mutant;
    }


    private static void registerSourcePackages(
            ResourceSet resourceSet,
            Resource source) {

        Set<EPackage> visited =
            Collections.newSetFromMap(
                new IdentityHashMap<>());

        for (EObject root :
                source.getContents()) {

            registerPackageRecursively(
                resourceSet,
                root.eClass()
                    .getEPackage(),
                visited);
        }
    }


    private static void registerPackageRecursively(
            ResourceSet resourceSet,
            EPackage ePackage,
            Set<EPackage> visited) {

        if (ePackage == null
                || !visited.add(
                    ePackage)) {

            return;
        }

        String nsURI =
            ePackage.getNsURI();

        if (nsURI != null
                && !nsURI.isBlank()) {

            resourceSet
                .getPackageRegistry()
                .put(
                    nsURI,
                    ePackage);
        }

        for (EPackage child :
                ePackage.getESubpackages()) {

            registerPackageRecursively(
                resourceSet,
                child,
                visited);
        }

        if (ePackage.getESuperPackage()
                != null) {

            registerPackageRecursively(
                resourceSet,
                ePackage.getESuperPackage(),
                visited);
        }
    }


    private static Path findFirstMutant(
            MutatorExecutorHandle executor,
            Path output)
            throws IOException {

        try (Stream<Path> files =
                Files.walk(output)) {

            return files
                .filter(
                    Files::isRegularFile)
                .filter(
                    file ->
                        looksLikeMutant(
                            executor,
                            file))
                .sorted()
                .findFirst()
                .orElse(null);
        }
    }


    private static boolean looksLikeMutant(
            MutatorExecutorHandle executor,
            Path file) {

        String name =
            file.getFileName()
                .toString()
                .toLowerCase();

        if (!name.endsWith(
                ".model")) {

            return false;
        }

        if (name.endsWith(
                "registry.model")) {

            return false;
        }

        if (name.equals(
                executor.mutatorName()
                    .toLowerCase()
                + ".model")) {

            return false;
        }

        return true;
    }


    private static Path findRegistryFor(
            Path mutantFile,
            Path output)
            throws IOException {

        String mutantName =
            mutantFile.getFileName()
                .toString();

        String baseName =
            mutantName.endsWith(
                ".model")
                ? mutantName.substring(
                    0,
                    mutantName.length()
                    - ".model".length())
                : mutantName;

        /*
         * Wodel block layout:
         *
         * .../cfs/Output0.model
         * .../cfs/registry/Output0Registry.model
         */
        Path direct =
            mutantFile
                .getParent()
                .resolve(
                    "registry")
                .resolve(
                    baseName
                    + "Registry.model");

        if (Files.isRegularFile(
                direct)) {

            return direct;
        }

        String expectedName =
            baseName
            + "Registry.model";

        try (Stream<Path> files =
                Files.walk(output)) {

            return files
                .filter(
                    Files::isRegularFile)
                .filter(
                    file ->
                        file.getFileName()
                            .toString()
                            .equalsIgnoreCase(
                                expectedName))
                .findFirst()
                .orElse(null);
        }
    }


    private static Mutations loadRegistry(
            Path registryFile)
            throws IOException {

        ResourceSet resourceSet =
            new ResourceSetImpl();

        resourceSet
            .getResourceFactoryRegistry()
            .getExtensionToFactoryMap()
            .put(
                "model",
                new XMIResourceFactoryImpl());

        resourceSet
            .getResourceFactoryRegistry()
            .getExtensionToFactoryMap()
            .put(
                Resource.Factory.Registry.DEFAULT_EXTENSION,
                new XMIResourceFactoryImpl());

        /*
         * Avoid assuming a generated Package class name.
         */
        EPackage registryPackage =
            AppliedMutationsFactory
                .eINSTANCE
                .createMutations()
                .eClass()
                .getEPackage();

        resourceSet
            .getPackageRegistry()
            .put(
                registryPackage.getNsURI(),
                registryPackage);

        Resource resource =
            resourceSet.getResource(
                URI.createFileURI(
                    registryFile
                        .toAbsolutePath()
                        .normalize()
                        .toString()),
                true);

        if (resource.getContents()
                .isEmpty()) {

            throw new IOException(
                "Empty Wodel registry: "
                + registryFile);
        }

        EObject root =
            resource.getContents()
                .get(0);

        if (!(root
                instanceof Mutations)) {

            throw new IOException(
                "Expected Mutations registry root "
                + "but found "
                + root.eClass()
                    .getName()
                + " in "
                + registryFile);
        }

        return (Mutations) root;
    }


    private static Path findClassesDirectory(
            Path projectRoot)
            throws IOException {

        Path[] candidates = {

            projectRoot.resolve(
                "bin"),

            projectRoot.resolve(
                "target/classes"),

            projectRoot.resolve(
                "build/classes/java/main")
        };

        for (Path candidate :
                candidates) {

            if (Files.isDirectory(
                    candidate)) {

                return candidate
                    .toAbsolutePath()
                    .normalize();
            }
        }

        throw new IOException(
            "Cannot locate compiled classes "
            + "for Wodel project "
            + projectRoot);
    }


    private static void deleteRecursively(
            Path root) {

        if (root == null
                || !Files.exists(root)) {

            return;
        }

        try (Stream<Path> files =
                Files.walk(root)) {

            files.sorted(
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


    /*
     * Generated mutator classes must come from the
     * current Wodel project first.
     *
     * EMF/Wodel/WoMoT/JDK classes remain parent-loaded.
     */
    private static final class ProjectFirstClassLoader
            extends URLClassLoader {

        ProjectFirstClassLoader(
                URL[] urls,
                ClassLoader parent) {

            super(
                urls,
                parent);
        }


        @Override
        protected Class<?> loadClass(
                String name,
                boolean resolve)
                throws ClassNotFoundException {

            synchronized (
                    getClassLoadingLock(
                        name)) {

                Class<?> loaded =
                    findLoadedClass(
                        name);

                if (loaded == null) {

                    if (name.startsWith(
                            "mutator.")) {

                        try {

                            loaded =
                                findClass(
                                    name);
                        }
                        catch (
                            ClassNotFoundException ignored) {
                        }
                    }

                    if (loaded == null) {

                        loaded =
                            super.loadClass(
                                name,
                                false);
                    }
                }

                if (resolve) {

                    resolveClass(
                        loaded);
                }

                return loaded;
            }
        }
    }
    private static String removeExtension(String fileName) {

	    int dot =
	        fileName.lastIndexOf('.');

	    return dot > 0
	        ? fileName.substring(0, dot)
	        : fileName;
	}
    
    private Class<?> loadStandaloneLauncher(
            MutatorExecutorHandle executor) {

        Objects.requireNonNull(
            executor,
            "executor");

        Path projectRoot =
            executor.projectRoot()
                .toAbsolutePath()
                .normalize();

        Path bin =
            projectRoot.resolve(
                "bin");

        if (!Files.isDirectory(
                bin)) {

            throw new IllegalStateException(
                "The Wodel project bin directory does not exist: "
                + bin);
        }


        String projectName =
            projectRoot
                .getFileName()
                .toString();

        String launcherClassName =
            "mutator."
            + projectName
            + "."
            + projectName.replace(
                ".",
                "_")
            + "StandaloneAPILauncher";


        try {

            ProjectFirstClassLoader loader =
                CLASS_LOADERS.computeIfAbsent(
                    projectRoot,
                    root -> {

                        try {

                            return new ProjectFirstClassLoader(
                                new URL[] {
                                    root.resolve(
                                        "bin")
                                        .toUri()
                                        .toURL()
                                },
                                StandaloneWodelMutationEngine.class
                                    .getClassLoader());
                        }
                        catch (Exception e) {

                            throw new IllegalStateException(
                                "Cannot create Wodel class loader for "
                                + root,
                                e);
                        }
                    });


            return Class.forName(
                launcherClassName,
                true,
                loader);
        }
        catch (ClassNotFoundException e) {

            throw new IllegalStateException(
                "Cannot load generated Wodel standalone launcher '"
                + launcherClassName
                + "' from "
                + bin
                + ". Ensure the Wodel project has generated and "
                + "compiled its standalone classes.",
                e);
        }
    }
    
    @Override
    public List<String> getOperatorIds(
            MutatorExecutorHandle executor) {

        Objects.requireNonNull(
            executor,
            "executor");

        try {
            Class<?> launcherClass = loadStandaloneLauncher(executor);

            Method method =
                launcherClass.getMethod(
                    "getAllOperatorNames");

            Object value =
                method.invoke(null);

            if (!(value instanceof List<?> list)) {

                throw new IllegalStateException(
                    "Generated Wodel launcher "
                    + launcherClass.getName()
                    + ".getOperatorNames() "
                    + "did not return a List");
            }

            List<String> result =
                new ArrayList<>();

            for (Object element : list) {

                if (!(element instanceof String name)
                        || name.isBlank()) {

                    throw new IllegalStateException(
                        "Generated Wodel launcher returned "
                        + "an invalid operator name: "
                        + element);
                }

                result.add(
                    name);
            }

            return List.copyOf(
                result);
        }
        catch (ReflectiveOperationException e) {

            throw new IllegalStateException(
                "Cannot obtain Wodel operator names for "
                + executor.mutatorName(),
                e);
        }
    }
}