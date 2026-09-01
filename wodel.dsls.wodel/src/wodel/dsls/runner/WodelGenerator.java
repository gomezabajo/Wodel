package wodel.dsls.runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.Program;
import mutatorenvironment.Source;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.manager.ModelManager;

/**
 * Fluent, headless-friendly facade for creating, compiling and executing Wodel
 * mutation programs. The class is also a dependency-free command-line entry
 * point; run with --help for usage.
 */
public class WodelGenerator {

    private final List<String> creationClasses = new ArrayList<String>();
    private final List<String> removalClasses = new ArrayList<String>();
    private final List<String> cloningClasses = new ArrayList<String>();
    private final List<String> modificationClasses = new ArrayList<String>();
    private final List<String> retypingClasses = new ArrayList<String>();
    private final List<String> retypingExcludedSuperClasses = new ArrayList<String>();

    private int intMin = 0;
    private int intMax = 10;
    private double doubleMin = 0;
    private double doubleMax = 10;
    private int stringMin = 0;
    private int stringMax = 10;

    private String metamodelPath = "";
    private String wodelProjectPath = "";
    private String currentPath = "";
    private String environmentPath = "";
    private String compilerName = "";
    private String operatorInputPath = "";
    private String programInputPath = "data/model/";
    private String programOutputPath = "data/out/";

    private int mutantCount = 1;
    private long randomSeed = 1L;
    private int randomClassCount = 1;
    /** Persist textual .mutator source in addition to the canonical XMI model. */
    private boolean exportSource = false;

    private MutatorEnvironment lastEnvironment;
    private WodelUtils.ExecutionResult lastExecutionResult;

    public enum ApplicationMode { EXHAUSTIVE, STOCHASTIC }
    public enum OperatorCoverage { FULL, PARTIAL }
    public enum ClassSelectionMode { NONE, ALL, RANDOM, CONCRETE, ABSTRACT }
    public enum CloningType { DEEP, SHALLOW }
    public enum AttributeSelectionMode { ALL, RANDOM, INTEGER, DOUBLE, BOOLEAN, STRING }

    private ApplicationMode applicationMode = ApplicationMode.EXHAUSTIVE;
    private OperatorCoverage creationOperatorCoverage = OperatorCoverage.FULL;
    private OperatorCoverage removalOperatorCoverage = OperatorCoverage.FULL;
    private OperatorCoverage cloningOperatorCoverage = OperatorCoverage.FULL;
    private OperatorCoverage modificationOperatorCoverage = OperatorCoverage.FULL;
    private OperatorCoverage retypingOperatorCoverage = OperatorCoverage.FULL;
    private CloningType cloningType = CloningType.DEEP;
    private ClassSelectionMode creationClassSelectionMode = ClassSelectionMode.NONE;
    private ClassSelectionMode removalClassSelectionMode = ClassSelectionMode.NONE;
    private ClassSelectionMode cloningClassSelectionMode = ClassSelectionMode.NONE;
    private ClassSelectionMode modificationClassSelectionMode = ClassSelectionMode.NONE;
    private ClassSelectionMode retypingClassSelectionMode = ClassSelectionMode.NONE;
    private AttributeSelectionMode attributeSelectionMode = AttributeSelectionMode.ALL;

    public WodelGenerator() {}

    public WodelGenerator setApplicationMode(ApplicationMode value) {
        this.applicationMode = requireNonNull(value, "applicationMode"); return this;
    }
    public WodelGenerator setMutantCount(int value) {
        if (value < 1) throw new IllegalArgumentException("mutantCount must be >= 1");
        this.mutantCount = value; return this;
    }
    public WodelGenerator setMetamodelPath(String value) { this.metamodelPath = clean(value); return this; }
    public WodelGenerator setWodelProjectPath(String value) { this.wodelProjectPath = clean(value); return this; }
    /** Path containing Wodel/runtime jars/plugins used by standalone javac/java. */
    public WodelGenerator setCurrentPath(String value) { this.currentPath = clean(value); return this; }
    /** Eclipse installation/home used by headless compilation. */
    public WodelGenerator setEnvironmentPath(String value) { this.environmentPath = clean(value); return this; }
    public WodelGenerator setCompilerName(String value) { this.compilerName = clean(value); return this; }
    /** Filesystem folder used to inspect seed models when synthesizing operators. */
    public WodelGenerator setOperatorInputPath(String value) { this.operatorInputPath = clean(value); return this; }
    /** Source path written into the generated Wodel program. */
    public WodelGenerator setProgramInputPath(String value) { this.programInputPath = clean(value); return this; }
    /** Output path written into the generated Wodel program. */
    public WodelGenerator setProgramOutputPath(String value) { this.programOutputPath = clean(value); return this; }
    public WodelGenerator setRandomSeed(long value) { this.randomSeed = value; return this; }
    /**
     * Controls whether generated textual <code>.mutator</code> source is kept.
     * The default is false; the headless pipeline keeps the XMI semantic model
     * and creates textual source only transiently when the legacy Xtext code
     * generator requires it.
     */
    public WodelGenerator setExportSource(boolean value) { this.exportSource = value; return this; }
    public boolean isExportSource() { return exportSource; }
    public WodelGenerator setRandomClassCount(int value) {
        if (value < 1) throw new IllegalArgumentException("randomClassCount must be >= 1");
        this.randomClassCount = value; return this;
    }

    public WodelGenerator creationOperatorsFor(String... classes) { replace(creationClasses, classes); return this; }
    public WodelGenerator creationOperatorsCoverage(OperatorCoverage value) { creationOperatorCoverage = requireNonNull(value, "coverage"); return this; }
    public WodelGenerator creationOperatorsClassMode(ClassSelectionMode value) { creationClassSelectionMode = requireNonNull(value, "class mode"); return this; }
    public WodelGenerator removalOperatorsFor(String... classes) { replace(removalClasses, classes); return this; }
    public WodelGenerator removalOperatorsCoverage(OperatorCoverage value) { removalOperatorCoverage = requireNonNull(value, "coverage"); return this; }
    public WodelGenerator removalOperatorsClassMode(ClassSelectionMode value) { removalClassSelectionMode = requireNonNull(value, "class mode"); return this; }
    public WodelGenerator cloningOperatorsFor(String... classes) { replace(cloningClasses, classes); return this; }
    public WodelGenerator cloningOperatorsCoverage(OperatorCoverage value) { cloningOperatorCoverage = requireNonNull(value, "coverage"); return this; }
    public WodelGenerator cloningOperatorsType(CloningType value) { cloningType = requireNonNull(value, "cloning type"); return this; }
    public WodelGenerator cloningOperatorsClassMode(ClassSelectionMode value) { cloningClassSelectionMode = requireNonNull(value, "class mode"); return this; }
    public WodelGenerator modificationOperatorsFor(String... classes) { replace(modificationClasses, classes); return this; }
    public WodelGenerator modificationOperatorsCoverage(OperatorCoverage value) { modificationOperatorCoverage = requireNonNull(value, "coverage"); return this; }
    public WodelGenerator modificationOperatorsClassMode(ClassSelectionMode value) { modificationClassSelectionMode = requireNonNull(value, "class mode"); return this; }
    public WodelGenerator modificationOperatorsAttributeMode(AttributeSelectionMode value) { attributeSelectionMode = requireNonNull(value, "attribute mode"); return this; }
    public WodelGenerator modificationOperatorsIntRange(int min, int max) { checkRange("integer", min, max); intMin=min; intMax=max; return this; }
    public WodelGenerator modificationOperatorsDoubleRange(int min, int max) { return modificationOperatorsDoubleRange((double)min, (double)max); }
    public WodelGenerator modificationOperatorsDoubleRange(double min, double max) { checkRange("double", min, max); doubleMin=min; doubleMax=max; return this; }
    public WodelGenerator modificationOperatorsStringLength(int min, int max) {
        if (min < 0) throw new IllegalArgumentException("string minimum length must be >= 0");
        checkRange("string length", min, max); stringMin=min; stringMax=max; return this;
    }
    public WodelGenerator retypingOperatorsFor(String... classes) { replace(retypingClasses, classes); return this; }
    public WodelGenerator retypingOperatorsCoverage(OperatorCoverage value) { retypingOperatorCoverage = requireNonNull(value, "coverage"); return this; }
    public WodelGenerator retypingOperatorsClassMode(ClassSelectionMode value) { retypingClassSelectionMode = requireNonNull(value, "class mode"); return this; }
    public WodelGenerator retypingExcludedSuperClasses(String... classes) { replace(retypingExcludedSuperClasses, classes); return this; }

    /** Build the effective in-memory mutation program without writing files. */
    public MutatorEnvironment generateEnvironment() {
        validateGenerationConfiguration();
        try {
            MutatorEnvironment environment = WodelUtils.generateWodelProgram(metamodelPath);
            Program program = (Program)environment.getDefinition();
            program.setExhaustive(applicationMode == ApplicationMode.EXHAUSTIVE);
            program.setNum(applicationMode == ApplicationMode.STOCHASTIC ? mutantCount : 0);
            program.setOutput(programOutputPath);
            Source source = program.getSource();
            if (source == null) {
                source = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createSource();
                program.setSource(source);
            }
            source.setPath(programInputPath);

            List<EPackage> packages = ModelManager.loadMetaModelNoException(metamodelPath);
            List<EClass> classes = ModelManager.getEClasses(packages);
            EClass root = ModelManager.getRootEClass(packages);
            String input = effectiveOperatorInputPath();

            Selection creation = selectionFor(creationClassSelectionMode, creationClasses, classes, root, true, "create");
            if (creation.enabled) {
                WodelUtils.generateCreationMutationOperators(environment, input,
                        creation.helperMode, creationOperatorCoverage, creation.names);
            }
            Selection removal = selectionFor(removalClassSelectionMode, removalClasses, classes, root, false, "remove");
            if (removal.enabled) {
                WodelUtils.generateRemovalMutationOperators(environment, input,
                        removal.helperMode, removalOperatorCoverage, removal.names);
            }
            Selection cloning = selectionFor(cloningClassSelectionMode, cloningClasses, classes, root, false, "clone");
            if (cloning.enabled) {
                WodelUtils.generateCloningMutationOperators(environment, input,
                        cloningType == CloningType.DEEP,
                        cloning.helperMode, cloningOperatorCoverage, cloning.names);
            }
            Selection modification = selectionFor(modificationClassSelectionMode, modificationClasses, classes, root, false, "modify");
            if (modification.enabled) {
                WodelUtils.generateModificationMutationOperators(environment, input,
                        modification.helperMode, modificationOperatorCoverage, modification.names);
            }
            Selection retyping = selectionFor(retypingClassSelectionMode, retypingClasses, classes, root, false, "retype");
            if (retyping.enabled) {
                WodelUtils.generateRetypingMutationOperators(environment, input,
                        retyping.helperMode, retypingOperatorCoverage,
                        retypingExcludedSuperClasses.toArray(new String[0]), retyping.names);
            }

            WodelUtils.configureModificationMutators(environment, attributeSelectionMode,
                    intMin, intMax, doubleMin, doubleMax, stringMin, stringMax, randomSeed);

            if (environment.getBlocks().isEmpty() && environment.getCommands().isEmpty()) {
                throw new WodelGenerationException(
                        "No mutation operators were generated. Check class selection and seed models.");
            }
            lastEnvironment = environment;
            return environment;
        }
        catch (MetaModelNotFoundException e) {
            throw new WodelGenerationException("Could not load metamodel " + metamodelPath, e);
        }
    }

    /**
     * Generates the configured mutation environment and persists its canonical
     * XMI representation. Textual .mutator source is exported only when
     * {@link #setExportSource(boolean)} has been enabled.
     */
    public WodelGenerator generate() {
        MutatorEnvironment environment = generateEnvironment();
        try {
            WodelUtils.persistWodelProgramModel(environment, wodelProjectPath);
            if (exportSource) {
                WodelUtils.exportWodelSource(environment, wodelProjectPath);
            }
            return this;
        }
        catch (IOException e) {
            throw new WodelGenerationException("Could not persist generated Wodel program", e);
        }
    }

    /** Explicitly exports textual .mutator source for the current environment. */
    public WodelGenerator exportSource() {
        MutatorEnvironment environment = lastEnvironment != null
                ? lastEnvironment : generateEnvironment();
        try {
            WodelUtils.persistWodelProgramModel(environment, wodelProjectPath);
            WodelUtils.exportWodelSource(environment, wodelProjectPath);
            exportSource = true;
            return this;
        }
        catch (IOException e) {
            throw new WodelGenerationException("Could not export generated Wodel source", e);
        }
    }

    /** Generate src-gen Java directly from the in-memory or canonical XMI program. */
    public WodelUtils.ExecutionResult generateCodeChecked() {
        try {
            if (lastEnvironment != null) {
                lastExecutionResult = WodelUtils.generateWodelCodeChecked(
                        lastEnvironment, wodelProjectPath);
            }
            else {
                Path project = Paths.get(wodelProjectPath)
                        .toAbsolutePath().normalize();
                Path model = project.resolve("data").resolve("out")
                        .resolve(project.getFileName().toString() + ".model");
                lastExecutionResult = WodelUtils.generateWodelCodeFromModelChecked(
                        model.toString(), wodelProjectPath);
            }
            return lastExecutionResult;
        }
        catch (IOException e) {
            throw new WodelGenerationException(
                    "Could not generate Java directly from Wodel semantic model", e);
        }
    }

    public WodelUtils.ExecutionResult generateCodeFromModelChecked(String modelPath) {
        try {
            lastExecutionResult = WodelUtils.generateWodelCodeFromModelChecked(
                    modelPath, wodelProjectPath);
            return lastExecutionResult;
        }
        catch (IOException e) {
            throw new WodelGenerationException(
                    "Could not generate Java from Wodel XMI model " + modelPath, e);
        }
    }

    public WodelUtils.ExecutionResult compileChecked() {
        validateCompileConfiguration();
        try {
            if (lastEnvironment != null) {
                lastExecutionResult = WodelUtils.compileWodelEnvironmentChecked(
                        lastEnvironment, wodelProjectPath, environmentPath,
                        compilerName, exportSource);
            }
            else {
                // Compatibility path for the standalone `compile` command: it
                // compiles an already existing project/source file.
                lastExecutionResult = WodelUtils.compileWodelProjectChecked(
                        wodelProjectPath, environmentPath, compilerName);
            }
            return lastExecutionResult;
        }
        catch (IOException e) {
            throw new WodelGenerationException("Could not start Wodel headless compilation", e);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new WodelGenerationException("Wodel compilation was interrupted", e);
        }
    }

    public WodelGenerator compile() {
        WodelUtils.ExecutionResult result = compileChecked();
        if (!result.isSuccess()) throw new WodelGenerationException(result.toString());
        return this;
    }

    public synchronized WodelUtils.ExecutionResult generateMutantsChecked(String inputPath, String outputPath) {
        validateExecutionConfiguration(inputPath, outputPath);
        try {
            lastExecutionResult = WodelUtils.generateMutantsChecked(
                    inputPath, outputPath, currentPath, wodelProjectPath, environmentPath);
            return lastExecutionResult;
        }
        catch (IOException e) {
            throw new WodelGenerationException("Could not start standalone mutant generation", e);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new WodelGenerationException("Mutant generation was interrupted", e);
        }
    }

    /**
     * Generate and execute mutants directly from a canonical Wodel .model XMI.
     * This path never serializes or parses textual .mutator source.
     */
    public synchronized WodelUtils.ExecutionResult generateMutantsFromModelChecked(
            String modelPath, String inputPath, String outputPath) {
        validateExecutionConfiguration(inputPath, outputPath);
        try {
            lastExecutionResult = WodelUtils.generateMutantsFromModelChecked(
                    modelPath, inputPath, outputPath, currentPath,
                    wodelProjectPath, environmentPath);
            return lastExecutionResult;
        }
        catch (IOException e) {
            throw new WodelGenerationException(
                    "Could not generate mutants directly from Wodel XMI model", e);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new WodelGenerationException(
                    "Direct mutant generation was interrupted", e);
        }
    }

    /**
     * Generate and execute mutants directly from the current in-memory semantic
     * environment. No textual .mutator serialization/parsing is performed.
     */
    public synchronized WodelUtils.ExecutionResult generateMutantsFromEnvironmentChecked(
            String inputPath, String outputPath) {
        validateExecutionConfiguration(inputPath, outputPath);
        MutatorEnvironment environment = lastEnvironment != null
                ? lastEnvironment : generateEnvironment();
        try {
            lastExecutionResult = WodelUtils.generateMutantsFromEnvironmentChecked(
                    environment, inputPath, outputPath, currentPath,
                    wodelProjectPath, environmentPath);
            return lastExecutionResult;
        }
        catch (IOException e) {
            throw new WodelGenerationException(
                    "Could not generate mutants directly from in-memory Wodel environment", e);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new WodelGenerationException(
                    "Direct mutant generation was interrupted", e);
        }
    }

    public WodelGenerator generateMutants(String inputPath, String outputPath) {
        WodelUtils.ExecutionResult result = generateMutantsChecked(inputPath, outputPath);
        if (!result.isSuccess()) throw new WodelGenerationException(result.toString());
        return this;
    }

    /** Complete generate -> compile -> execute pipeline. */
    public WodelGenerator run(String inputPath, String outputPath) {
        return generate().compile().generateMutants(inputPath, outputPath);
    }

    public MutatorEnvironment getLastEnvironment() { return lastEnvironment; }
    public WodelUtils.ExecutionResult getLastExecutionResult() { return lastExecutionResult; }

    public List<String> validateGeneration() {
        List<String> errors = new ArrayList<String>();
        if (metamodelPath.isBlank()) errors.add("metamodelPath is required");
        if (wodelProjectPath.isBlank()) errors.add("wodelProjectPath is required");
        if (applicationMode == ApplicationMode.STOCHASTIC && mutantCount < 1) errors.add("mutantCount must be >= 1");
        if (!hasAnyOperatorSelection()) errors.add("at least one mutation operator/class selection must be enabled");
        String input = effectiveOperatorInputPathNoThrow();
        if (input.isBlank() || !Files.isDirectory(Paths.get(input))) errors.add("operator input directory does not exist: " + input);
        return errors;
    }

    private void validateGenerationConfiguration() {
        List<String> errors = validateGeneration();
        if (!errors.isEmpty()) throw new WodelGenerationException(String.join("; ", errors));
    }

    private void validateCompileConfiguration() {
        if (wodelProjectPath.isBlank()) throw new WodelGenerationException("wodelProjectPath is required");
        if (environmentPath.isBlank()) throw new WodelGenerationException("environmentPath/Eclipse home is required");
    }

    private void validateExecutionConfiguration(String inputPath, String outputPath) {
        if (wodelProjectPath.isBlank()) throw new WodelGenerationException("wodelProjectPath is required");
        if (inputPath == null || inputPath.isBlank()) throw new WodelGenerationException("inputPath is required");
        if (outputPath == null || outputPath.isBlank()) throw new WodelGenerationException("outputPath is required");
    }

    private boolean hasAnyOperatorSelection() {
        return enabled(creationClassSelectionMode, creationClasses)
            || enabled(removalClassSelectionMode, removalClasses)
            || enabled(cloningClassSelectionMode, cloningClasses)
            || enabled(modificationClassSelectionMode, modificationClasses)
            || enabled(retypingClassSelectionMode, retypingClasses);
    }

    private static boolean enabled(ClassSelectionMode mode, List<String> classes) {
        return mode != ClassSelectionMode.NONE || (classes != null && !classes.isEmpty());
    }

    private String effectiveOperatorInputPath() {
        String value = effectiveOperatorInputPathNoThrow();
        if (value.isBlank()) throw new WodelGenerationException("operator input path is not configured");
        return value;
    }

    private String effectiveOperatorInputPathNoThrow() {
        if (!operatorInputPath.isBlank()) return Paths.get(operatorInputPath).toAbsolutePath().normalize().toString();
        if (!programInputPath.isBlank()) {
            Path source = Paths.get(programInputPath);
            if (source.isAbsolute()) return source.normalize().toString();
            if (!wodelProjectPath.isBlank()) return Paths.get(wodelProjectPath).resolve(source).toAbsolutePath().normalize().toString();
        }
        return "";
    }

    private Selection selectionFor(ClassSelectionMode mode, List<String> explicit,
            List<EClass> metamodelClasses, EClass root, boolean concreteOnly, String salt) {
        if (!enabled(mode, explicit)) return Selection.disabled();
        Map<String,EClass> byName = new LinkedHashMap<String,EClass>();
        for (EClass eClass : metamodelClasses) byName.put(eClass.getName(), eClass);

        if (explicit != null && !explicit.isEmpty()) {
            List<String> names = new ArrayList<String>();
            for (String name : explicit) {
                EClass eClass = byName.get(name);
                if (eClass == null) throw new WodelGenerationException("Unknown EClass '" + name + "' for " + salt);
                if (root != null && eClass == root) continue;
                if (concreteOnly && eClass.isAbstract()) continue;
                names.add(name);
            }
            return names.isEmpty() ? Selection.disabled()
                    : new Selection(true, ClassSelectionMode.NONE, names.toArray(new String[0]));
        }

        if (mode == ClassSelectionMode.ALL) return new Selection(true, ClassSelectionMode.ALL, new String[0]);
        if (mode == ClassSelectionMode.CONCRETE) return new Selection(true, ClassSelectionMode.CONCRETE, new String[0]);

        List<String> candidates = new ArrayList<String>();
        for (EClass eClass : metamodelClasses) {
            if (root != null && eClass == root) continue;
            if (concreteOnly && eClass.isAbstract()) continue;
            if (mode == ClassSelectionMode.ABSTRACT && !eClass.isAbstract()) continue;
            candidates.add(eClass.getName());
        }
        if (mode == ClassSelectionMode.RANDOM) {
            Collections.shuffle(candidates, new Random(randomSeed ^ salt.hashCode()));
            if (candidates.size() > randomClassCount) candidates = new ArrayList<String>(candidates.subList(0, randomClassCount));
        }
        if (mode == ClassSelectionMode.NONE) return Selection.disabled();
        return candidates.isEmpty() ? Selection.disabled()
                : new Selection(true, ClassSelectionMode.NONE, candidates.toArray(new String[0]));
    }

    private static final class Selection {
        final boolean enabled;
        final ClassSelectionMode helperMode;
        final String[] names;
        Selection(boolean enabled, ClassSelectionMode helperMode, String[] names) {
            this.enabled=enabled; this.helperMode=helperMode; this.names=names;
        }
        static Selection disabled() { return new Selection(false, ClassSelectionMode.NONE, new String[0]); }
    }

    private static <T> T requireNonNull(T value, String name) {
        if (value == null) throw new IllegalArgumentException(name + " must not be null");
        return value;
    }
    private static String clean(String value) { return value == null ? "" : value.trim(); }
    private static void replace(List<String> target, String... values) {
        target.clear();
        if (values == null) return;
        for (String value : values) if (value != null && !value.isBlank()) target.add(value.trim());
    }
    private static void checkRange(String name, double min, double max) {
        if (min > max) throw new IllegalArgumentException(name + " min must be <= max");
    }

    public static final class WodelGenerationException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public WodelGenerationException(String message) { super(message); }
        public WodelGenerationException(String message, Throwable cause) { super(message, cause); }
    }

    // ----------------------------- CLI ---------------------------------

    public static void main(String[] args) {
        int exit = runCli(args);
        if (exit != 0) System.exit(exit);
    }

    public static int runCli(String[] args) {
        if (args == null || args.length == 0 || "--help".equals(args[0]) || "help".equalsIgnoreCase(args[0])) {
            printUsage(); return 0;
        }
        String command = args[0].toLowerCase(Locale.ROOT);
        try {
            Map<String,String> options = parseOptions(Arrays.copyOfRange(args, 1, args.length));
            
            if ("codegen".equals(command)) {
                WodelGenerator g = configureCommon(options, false);
                WodelUtils.ExecutionResult result = options.containsKey("program-model")
                        ? g.generateCodeFromModelChecked(options.get("program-model"))
                        : g.generateCodeChecked();
                System.out.println(result); return result.isSuccess() ? 0 : 3;
            }
            if ("compile".equals(command)) {
                WodelGenerator g = configureCommon(options, false);
                WodelUtils.ExecutionResult result = g.compileChecked();
                System.out.println(result); return result.isSuccess() ? 0 : 3;
            }
            if ("mutate-model".equals(command) || "mutate-direct".equals(command)) {
                WodelGenerator g = configureCommon(options, false);
                String input = required(options, "input");
                String output = required(options, "output");
                String model = options.get("program-model");
                WodelUtils.ExecutionResult result =
                        g.generateMutantsFromModelChecked(model, input, output);
                System.out.println(result);
                return result.isSuccess() ? 0 : 4;
            }
            if ("mutate".equals(command)) {
                WodelGenerator g = configureCommon(options, false);
                String input = required(options, "input");
                String output = required(options, "output");
                WodelUtils.ExecutionResult result = g.generateMutantsChecked(input, output);
                System.out.println(result); return result.isSuccess() ? 0 : 4;
            }
            if ("generate".equals(command) || "export".equals(command) || "run".equals(command)) {
                WodelGenerator g = configureCommon(options, true);
                configureOperators(g, options);
                boolean export = "export".equals(command)
                        || booleanOption(options, "export-source", false);
                g.setExportSource(export);
                g.generate();
                System.out.println("Generated canonical Wodel model in "
                        + Paths.get(required(options, "project"), "data", "out"));
                if (export) {
                    System.out.println("Exported textual .mutator source in "
                            + Paths.get(required(options, "project"), "src"));
                }
                if ("generate".equals(command) || "export".equals(command)) return 0;
                WodelUtils.ExecutionResult compile = g.compileChecked();
                System.out.println(compile);
                if (!compile.isSuccess()) return 3;
                String input = required(options, "input");
                String output = required(options, "output");
                WodelUtils.ExecutionResult mutate = g.generateMutantsChecked(input, output);
                System.out.println(mutate); return mutate.isSuccess() ? 0 : 4;
            }
            if ("apply".equals(command)
                    || "mutate-source".equals(command)) {

                WodelGenerator g =
                    configureCommon(
                        options,
                        false);

                String program =
                    required(
                        options,
                        "program");

                String input =
                    required(
                        options,
                        "input");

                String output =
                    required(
                        options,
                        "output");

                WodelUtils.ExecutionResult result =
                    g.applyMutatorChecked(
                        program,
                        input,
                        output);

                System.out.println(result);

                return result.isSuccess()
                    ? 0
                    : 4;
            }
            System.err.println("Unknown command: " + command);
            printUsage(); return 2;
        }
        catch (Exception e) {
            System.err.println("Wodel CLI error: " + e.getMessage());
            return 2;
        }
    }

    private static WodelGenerator configureCommon(Map<String,String> o, boolean generation) {
        WodelGenerator g = new WodelGenerator();
        g.setWodelProjectPath(required(o, "project"));
        if (o.containsKey("eclipse-home")) g.setEnvironmentPath(o.get("eclipse-home"));
        if (o.containsKey("compiler")) g.setCompilerName(o.get("compiler"));
        if (o.containsKey("plugin-path")) g.setCurrentPath(o.get("plugin-path"));
        if (generation) {
            g.setMetamodelPath(required(o, "metamodel"));
            String input = required(o, "input");
            String output = o.getOrDefault("output", Paths.get(required(o,"project"), "data", "out").toString());
            g.setOperatorInputPath(input).setProgramInputPath(input).setProgramOutputPath(output);
            g.setApplicationMode(parseEnum(ApplicationMode.class, o.getOrDefault("mode", "exhaustive")));
            if (o.containsKey("mutants")) g.setMutantCount(Integer.parseInt(o.get("mutants")));
            if (o.containsKey("seed")) g.setRandomSeed(Long.parseLong(o.get("seed")));
            if (o.containsKey("random-class-count")) g.setRandomClassCount(Integer.parseInt(o.get("random-class-count")));
            if (o.containsKey("attribute-mode")) g.modificationOperatorsAttributeMode(parseEnum(AttributeSelectionMode.class, o.get("attribute-mode")));
            if (o.containsKey("int-range")) { double[] r=parseRange(o.get("int-range")); g.modificationOperatorsIntRange((int)r[0],(int)r[1]); }
            if (o.containsKey("double-range")) { double[] r=parseRange(o.get("double-range")); g.modificationOperatorsDoubleRange(r[0],r[1]); }
            if (o.containsKey("string-length")) { double[] r=parseRange(o.get("string-length")); g.modificationOperatorsStringLength((int)r[0],(int)r[1]); }
            if (o.containsKey("exclude-retype-super")) g.retypingExcludedSuperClasses(splitCsv(o.get("exclude-retype-super")));
        }
        return g;
    }

    private static void configureOperators(WodelGenerator g, Map<String,String> o) {
        Set<String> operators = new LinkedHashSet<String>(Arrays.asList(splitCsv(o.getOrDefault("operators", "create,remove,clone,modify,retype"))));
        String[] classes = o.containsKey("classes") ? splitCsv(o.get("classes")) : new String[0];
        ClassSelectionMode mode = classes.length > 0 ? ClassSelectionMode.NONE
                : parseEnum(ClassSelectionMode.class, o.getOrDefault("class-mode", "concrete"));
        OperatorCoverage coverage = parseEnum(OperatorCoverage.class, o.getOrDefault("coverage", "full"));
        if (operators.contains("create")) { if(classes.length>0) g.creationOperatorsFor(classes); else g.creationOperatorsClassMode(mode); g.creationOperatorsCoverage(coverage); }
        if (operators.contains("remove")) { if(classes.length>0) g.removalOperatorsFor(classes); else g.removalOperatorsClassMode(mode); g.removalOperatorsCoverage(coverage); }
        if (operators.contains("clone")) { if(classes.length>0) g.cloningOperatorsFor(classes); else g.cloningOperatorsClassMode(mode); g.cloningOperatorsCoverage(coverage); g.cloningOperatorsType(parseEnum(CloningType.class, o.getOrDefault("clone", "deep"))); }
        if (operators.contains("modify")) { if(classes.length>0) g.modificationOperatorsFor(classes); else g.modificationOperatorsClassMode(mode); g.modificationOperatorsCoverage(coverage); }
        if (operators.contains("retype")) { if(classes.length>0) g.retypingOperatorsFor(classes); else g.retypingOperatorsClassMode(mode); g.retypingOperatorsCoverage(coverage); }
    }

    private static Map<String,String> parseOptions(String[] args) {
        Map<String,String> options = new LinkedHashMap<String,String>();
        Set<String> booleanFlags = Set.of("export-source");
        for (int i=0; i<args.length; i++) {
            String token=args[i];
            if (!token.startsWith("--")) throw new IllegalArgumentException("Expected option, got: " + token);
            String key=token.substring(2);
            if (key.isBlank()) throw new IllegalArgumentException("Empty option name");

            if (booleanFlags.contains(key)) {
                if (i+1 < args.length && !args[i+1].startsWith("--")
                        && ("true".equalsIgnoreCase(args[i+1])
                            || "false".equalsIgnoreCase(args[i+1]))) {
                    options.put(key, args[++i]);
                }
                else {
                    options.put(key, "true");
                }
                continue;
            }

            if (i+1>=args.length || args[i+1].startsWith("--"))
                throw new IllegalArgumentException("Missing value for --" + key);
            options.put(key, args[++i]);
        }
        return options;
    }

    private static boolean booleanOption(
            Map<String,String> options, String key, boolean defaultValue) {
        String value = options.get(key);
        if (value == null) return defaultValue;
        if ("true".equalsIgnoreCase(value)) return true;
        if ("false".equalsIgnoreCase(value)) return false;
        throw new IllegalArgumentException("--" + key + " must be true or false");
    }
    private static String required(Map<String,String> options, String key) {
        String value=options.get(key);
        if(value==null || value.isBlank()) throw new IllegalArgumentException("Missing --" + key);
        return value;
    }
    private static String[] splitCsv(String value) {
        if(value==null || value.isBlank()) return new String[0];
        return Arrays.stream(value.split(",")).map(String::trim).filter(s->!s.isEmpty()).toArray(String[]::new);
    }
    private static double[] parseRange(String value) {
        String[] p=value.split(":",-1);
        if(p.length!=2) throw new IllegalArgumentException("Range must be min:max: " + value);
        return new double[]{Double.parseDouble(p[0]),Double.parseDouble(p[1])};
    }
    private static <E extends Enum<E>> E parseEnum(Class<E> type, String value) {
        return Enum.valueOf(type, value.trim().replace('-', '_').toUpperCase(Locale.ROOT));
    }

    private static void printUsage() {
        System.out.println("Wodel headless CLI\n"
            + "Usage:\n"
            + "  WodelGenerator generate --metamodel <file> --project <dir> --input <dir> [options]\n"
            + "  WodelGenerator export   --metamodel <file> --project <dir> --input <dir> [options]\n"
            + "  WodelGenerator codegen  --project <dir> [--program-model <file>]\n"
            + "  WodelGenerator compile  --project <dir> --eclipse-home <dir> [--compiler <exe>]\n"
            + "  WodelGenerator mutate   --project <dir> --input <dir> --output <dir> [--plugin-path <dir>] [--eclipse-home <dir>]\n"
            + "  WodelGenerator mutate-model --project <dir> --input <dir> --output <dir> [--program-model <file>] [--plugin-path <dir>] [--eclipse-home <dir>]\n"
            + "  WodelGenerator run      --metamodel <file> --project <dir> --input <dir> --output <dir> --eclipse-home <dir> [options]\n\n"
            + "Generation options:\n"
            + "  --mode exhaustive|stochastic    --mutants <n>\n"
            + "  --operators create,remove,clone,modify,retype\n"
            + "  --class-mode all|concrete|abstract|random   --classes A,B,C\n"
            + "  --coverage full|partial          --clone deep|shallow\n"
            + "  --seed <long>                    --random-class-count <n>\n"
            + "  --attribute-mode all|random|integer|double|boolean|string\n"
            + "  --int-range min:max  --double-range min:max  --string-length min:max\n"
            + "  --exclude-retype-super A,B,C\n"
            + "  --export-source                 keep generated .mutator source\n"
            + "  --program-model <file>          explicit canonical .model for codegen/mutate-model\n"
            + "                                  default: data/out/<project>.model\n\n"
            + "Runtime options:\n"
            + "  --eclipse-home <dir>  --compiler <eclipse/eclipsec executable>\n"
            + "  --plugin-path <dir containing Wodel/runtime jars>\n");
    }
    
    public WodelUtils.ExecutionResult applyMutatorChecked(
            String mutatorPath,
            String inputPath,
            String outputPath) {

        validateExecutionConfiguration(
            inputPath,
            outputPath);

        try {

            lastExecutionResult =
            		new WodelUtils().generateMutantsFromMutatorChecked(
                        mutatorPath,
                        inputPath,
                        outputPath,
                        currentPath,
                        wodelProjectPath,
                        environmentPath);

            return lastExecutionResult;
        }
        catch (IOException e) {

            throw new WodelGenerationException(
                "Could not apply Wodel program "
                + mutatorPath,
                e);
        }
        catch (InterruptedException e) {

            Thread.currentThread()
                  .interrupt();

            throw new WodelGenerationException(
                "Applying Wodel program was interrupted",
                e);
        }
    }

	List<String> mutatorList = new ArrayList<String>();
	
}
