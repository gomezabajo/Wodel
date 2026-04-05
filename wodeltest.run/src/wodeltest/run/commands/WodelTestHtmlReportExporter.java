package wodeltest.run.commands;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import wodel.utils.manager.IWodelTest;

/**
 * Exports WodelTest plain-text mutation testing results into an HTML/CSS/JS report bundle.
 *
 * <p>The exporter mirrors the structure used by the Eclipse views:
 * global summary, class results, mutator results, and test results.</p>
 *
 * <p>Expected input files inside {@code inputDir}:</p>
 * <ul>
 *   <li>{@code classes.results.txt} (required)</li>
 *   <li>{@code *.global.results.txt} (required)</li>
 *   <li>{@code *.tests.results.txt} (required)</li>
 *   <li>{@code mutators.txt} (optional)</li>
 *   <li>{@code project.txt} (optional)</li>
 *   <li>{@code *.test.txt} (optional)</li>
 *   <li>{@code classes.equivalent.txt} (optional)</li>
 *   <li>{@code classes.txt} (optional)</li>
 * </ul>
 */
public final class WodelTestHtmlReportExporter extends AbstractHandler {

    private static final String RESOURCE_ROOT = "/wodeltest/report/";
    private static final String REPORT_HTML = "index.html";
    private static final String REPORT_CSS = "report.css";
    private static final String REPORT_JS = "report.js";
    private static final String REPORT_DATA_JS = "report-data.js";
    private static final String REPORT_JSON = "report.json";

    public static class RunWodelTestHtmlReportExporterWithProgress implements IRunnableWithProgress {
    	
    	private static ExecutionEvent EVENT;

    	public RunWodelTestHtmlReportExporterWithProgress(ExecutionEvent event) {
    		EVENT = event;
    	}
        public static ExportResult export() throws IOException {
        	
			List<IWodelTest> tests = new ArrayList<IWodelTest>();
			if (Platform.getExtensionRegistry() != null) {
				IConfigurationElement[] extensions = Platform
						.getExtensionRegistry().getConfigurationElementsFor("wodeltest.extension", "MutTesting");
				for (int j = 0; j < extensions.length; j++) {
					IWodelTest test = null;
					try {
						test = (IWodelTest) extensions[j]
								.createExecutableExtension("class");
					} catch (CoreException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tests.add(test);
				}
			}

			
        	IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(EVENT);
			IProject sProject = null;
			if (selection.getFirstElement() instanceof IAdaptable)
	        {
	            sProject = (IProject)((IAdaptable) selection.getFirstElement()).getAdapter(IProject.class);
	        }
			if (selection.getFirstElement() instanceof IProject) {
				sProject = (IProject) selection.getFirstElement();
			}
			if (selection.getFirstElement() instanceof IJavaProject) {
				sProject = ((IJavaProject) selection.getFirstElement()).getProject();
			}
			final IProject sourceProject = sProject;
			IWodelTest test = null;
			for (IWodelTest t : tests) {
				try {
					if (sourceProject.hasNature(t.getNatureId())) {
						test = t;
						break;
					}
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (test == null) {
				return null;
			}

			Path inputDir = Paths.get(sourceProject.getLocation().toPath().toString(), "data");
			Path outputDir = Paths.get(sourceProject.getLocation().toPath().toString(), "report"); 
            Objects.requireNonNull(inputDir, "inputDir");
            Objects.requireNonNull(outputDir, "outputDir");

            Files.createDirectories(outputDir);
            
            //IOUtils.copyFile(ModelManager.getWorkspaceAbsolutePath(test.getClass()) + "/resources/wodeltest/report/" + REPORT_HTML, outputDir.toString());
            //IOUtils.copyFile(ModelManager.getWorkspaceAbsolutePath(test.getClass()) + "/resources/wodeltest/report/" + REPORT_CSS, outputDir.toString());
            //IOUtils.copyFile(ModelManager.getWorkspaceAbsolutePath(test.getClass()) + "/resources/wodeltest/report/" + REPORT_JS, outputDir.toString());

            ReportInput reportInput = parseReportInput(inputDir, sourceProject.getName());
            Map<String, Object> reportData = buildReportData(reportInput);
            String json = JsonWriter.write(reportData);

            writeResource(outputDir.resolve(REPORT_HTML), REPORT_HTML);
            writeResource(outputDir.resolve(REPORT_CSS), REPORT_CSS);
            writeResource(outputDir.resolve(REPORT_JS), REPORT_JS);
            Files.writeString(outputDir.resolve(REPORT_DATA_JS), "window.WodelTestReportData = " + json + ";\n", StandardCharsets.UTF_8);
            Files.writeString(outputDir.resolve(REPORT_JSON), json + "\n", StandardCharsets.UTF_8);

            return new ExportResult(
                    outputDir.resolve(REPORT_HTML),
                    outputDir.resolve(REPORT_CSS),
                    outputDir.resolve(REPORT_JS),
                    outputDir.resolve(REPORT_DATA_JS),
                    outputDir.resolve(REPORT_JSON));
        }

        public static void main(String[] args) throws Exception {
            if (args.length != 2) {
                System.err.println("Usage: java " + WodelTestHtmlReportExporter.class.getName() + " <inputDir> <outputDir>");
                System.exit(1);
            }
            ExportResult result = export();
            System.out.println("Wrote " + result.html());
            System.out.println("Wrote " + result.css());
            System.out.println("Wrote " + result.javascript());
            System.out.println("Wrote " + result.dataJavascript());
            System.out.println("Wrote " + result.json());
        }

        private static ReportInput parseReportInput(Path inputDir, String projectName) throws IOException {
            Path absoluteInput = inputDir.toAbsolutePath().normalize();
            if (!Files.isDirectory(absoluteInput)) {
                throw new IOException("Input directory does not exist: " + absoluteInput);
            }

            String testProject = projectName + "-test";
            
            List<Path> testInfoFiles = listMatching(absoluteInput, "*.test.txt");
            Path testInfoFile = testInfoFiles.isEmpty() ? null : testInfoFiles.get(0);

            Path projectTxt = absoluteInput.resolve("project.txt");
            List<String> projectLines = readLinesIfExists(projectTxt);
            String generatorProfile = projectLines.isEmpty() ? projectName : projectLines.get(0).trim();

            if (testInfoFile != null) {
                List<String> testInfoLines = readLinesIfExists(testInfoFile);
                if (testInfoLines.size() > 1 && !testInfoLines.get(1).trim().isEmpty()) {
                    testProject = testInfoLines.get(1).trim();
                }
            }
            
            Path testInput = Paths.get(absoluteInput + "/" + testProject).toAbsolutePath().normalize();
            
            List<Path> globalFiles = listMatching(testInput, "*.global.results.txt");
            List<Path> testsFiles = listMatching(testInput, "*.tests.results.txt");
            if (globalFiles.isEmpty() || testsFiles.isEmpty()) {
                throw new IOException("Expected at least one *.global.results.txt and one *.tests.results.txt file in " + absoluteInput);
            }
            Path globalFile = globalFiles.get(0);
            Path testsFile = testsFiles.get(0);

            List<String> globalLines = Files.readAllLines(globalFile, StandardCharsets.UTF_8).stream()
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .collect(Collectors.toList());
            if (globalLines.size() < 6) {
                throw new IOException("Expected 6 lines in " + globalFile + " but found " + globalLines.size());
            }
            String suiteName = stripSuffix(globalFile.getFileName().toString(), ".global.results.txt");

            long runningMs = parseLong(globalLines.get(0), globalFile, 1);
            long mutationMs = parseLong(globalLines.get(1), globalFile, 2);
            int operatorsSelected = parseInt(globalLines.get(2), globalFile, 3);
            int operatorsApplied = parseInt(globalLines.get(3), globalFile, 4);
            int mutantsGenerated = parseInt(globalLines.get(4), globalFile, 5);
            int nonCompiling = parseInt(globalLines.get(5), globalFile, 6);

            String testsPayload = Files.readString(testsFile, StandardCharsets.UTF_8).trim();
            String[] testCounts = testsPayload.split("\\|");
            if (testCounts.length < 3) {
                throw new IOException("Expected three pipe-separated counters in " + testsFile + ": " + testsPayload);
            }
            int testsExecuted = Integer.parseInt(testCounts[0].trim());
            int testsFailed = Integer.parseInt(testCounts[1].trim());
            int testsError = Integer.parseInt(testCounts[2].trim());

            List<String> mutators = splitPipeFile(absoluteInput.resolve("mutators.txt"));
            List<String> equivalentPrefixes = splitEquivalentPrefixes(testInput.resolve("classes.equivalent.txt"));
            Map<String, String> classSourcePaths = readClassSourcePaths(absoluteInput.resolve("classes.txt"));

            Path classesResults = testInput.resolve("classes.results.txt");
            if (!Files.exists(classesResults)) {
                throw new IOException("Expected classes.results.txt in " + testInput);
            }
            
            List<MutationRecord> records = parseMutationRecords(classesResults, suiteName);

            return new ReportInput(
                    absoluteInput,
                    projectName,
                    suiteName,
                    generatorProfile,
                    testProject,
                    runningMs,
                    mutationMs,
                    operatorsSelected,
                    operatorsApplied,
                    mutantsGenerated,
                    nonCompiling,
                    testsExecuted,
                    testsFailed,
                    testsError,
                    mutators,
                    equivalentPrefixes,
                    classSourcePaths,
                    records);
        }

        private static Map<String, Object> buildReportData(ReportInput input) {
            Map<String, List<MutationRecord>> recordsByMutant = input.records.stream()
                    .sorted(Comparator.comparing(record -> normalizePath(record.mutantPath)))
                    .collect(Collectors.groupingBy(
                            record -> record.mutantPath,
                            LinkedHashMap::new,
                            Collectors.toList()));

            List<String> killedClasses = new ArrayList<>();
            List<String> equivalentClasses = new ArrayList<>();
            List<String> liveClasses = new ArrayList<>();
            List<String> errorClasses = new ArrayList<>();

            LinkedHashMap<String, LinkedHashMap<String, List<Map<String, Object>>>> packageClassMap = new LinkedHashMap<>();
            TreeMap<String, List<String>> operatorPaths = new TreeMap<>();
            TreeMap<String, Integer> operatorFailures = new TreeMap<>();

            for (Map.Entry<String, List<MutationRecord>> entry : recordsByMutant.entrySet()) {
                String mutantPath = entry.getKey();
                List<MutationRecord> mutantRecords = entry.getValue();
                MutationRecord first = mutantRecords.get(0);
                String normalizedMutantPath = normalizePath(mutantPath);
                boolean equivalent = isEquivalent(normalizedMutantPath, input.equivalentPrefixes);
                boolean killed = mutantRecords.stream().anyMatch(record -> record.value);
                boolean errored = mutantRecords.stream().anyMatch(record -> record.failure);

                if (killed) {
                    killedClasses.add(normalizedMutantPath);
                } else if (errored) {
                    errorClasses.add(normalizedMutantPath);
                } else if (equivalent) {
                    equivalentClasses.add(normalizedMutantPath);
                } else {
                    liveClasses.add(normalizedMutantPath);
                }

                String packageName = first.packageName == null || first.packageName.isEmpty() ? "(default)" : first.packageName;
                String className = first.className == null || first.className.isEmpty() ? first.classFull : first.className;
                packageClassMap.computeIfAbsent(packageName, ignored -> new LinkedHashMap<>())
                        .computeIfAbsent(className, ignored -> new ArrayList<>());

                int executedTests = mutantRecords.stream().mapToInt(record -> record.numExecutions).sum();
                int failedTests = (int) mutantRecords.stream().filter(record -> record.value).count();
                int numFailures = (int) mutantRecords.stream().filter(record -> record.failure).count();

                List<Map<String, Object>> tests = mutantRecords.stream()
                        .sorted(Comparator.comparing(record -> normalizePath(record.testPath)))
                        .map(record -> {
                            Map<String, Object> test = new LinkedHashMap<>();
                            test.put("name", normalizePath(record.testPath));
                            test.put("numExecutions", record.numExecutions);
                            test.put("numFailed", record.value ? 1 : 0);
                            test.put("message", normalizeAssertionMessage(record));
                            test.put("value", record.value);
                            test.put("failure", record.failure);
                            return test;
                        })
                        .collect(Collectors.toList());

                Map<String, Object> mutant = new LinkedHashMap<>();
                mutant.put("path", normalizedMutantPath);
                mutant.put("equivalent", equivalent);
                mutant.put("executedTests", executedTests);
                mutant.put("failedTests", failedTests);
                mutant.put("passedTests", Math.max(0, executedTests - failedTests));
                mutant.put("numFailures", numFailures);
                mutant.put("mutationText", Collections.singletonList(first.operator));
                if (input.classSourcePaths.containsKey(first.classFull)) {
                    mutant.put("sourcePath", normalizePath(input.classSourcePaths.get(first.classFull)));
                }
                mutant.put("tests", tests);
                packageClassMap.get(packageName).get(className).add(mutant);

                operatorPaths.computeIfAbsent(first.operator, ignored -> new ArrayList<>()).add(normalizedMutantPath);
                if (errored) {
                    operatorFailures.put(first.operator, operatorFailures.getOrDefault(first.operator, 0) + 1);
                }
            }

            List<Map<String, Object>> classResults = new ArrayList<>();
            for (Map.Entry<String, LinkedHashMap<String, List<Map<String, Object>>>> pkgEntry : packageClassMap.entrySet()) {
                Map<String, Object> pkg = new LinkedHashMap<>();
                pkg.put("packageName", pkgEntry.getKey());
                List<Map<String, Object>> classes = new ArrayList<>();
                for (Map.Entry<String, List<Map<String, Object>>> classEntry : pkgEntry.getValue().entrySet()) {
                    Map<String, Object> cls = new LinkedHashMap<>();
                    cls.put("className", classEntry.getKey());
                    cls.put("mutants", classEntry.getValue());
                    classes.add(cls);
                }
                pkg.put("classes", classes);
                classResults.add(pkg);
            }

            List<Map<String, Object>> operators = input.mutators.stream()
                    .map(operator -> {
                        Map<String, Object> op = new LinkedHashMap<>();
                        op.put("name", operator);
                        op.put("description", null);
                        op.put("numberOfMutants", operatorPaths.getOrDefault(operator, Collections.emptyList()).size());
                        op.put("failures", operatorFailures.getOrDefault(operator, 0));
                        op.put("paths", operatorPaths.getOrDefault(operator, Collections.emptyList()));
                        return op;
                    })
                    .collect(Collectors.toList());

            Map<String, Object> mutatorGroup = new LinkedHashMap<>();
            mutatorGroup.put("groupName", input.generatorProfile);
            mutatorGroup.put("groupDescription", "Generated from WodelTest plain-text result files");
            mutatorGroup.put("operators", operators);
            List<Map<String, Object>> mutatorResults = Collections.singletonList(mutatorGroup);

            LinkedHashMap<String, List<MutationRecord>> byTest = input.records.stream()
                    .sorted(Comparator.comparing(record -> record.testName + "::" + normalizePath(record.mutantPath)))
                    .collect(Collectors.groupingBy(record -> record.testName, LinkedHashMap::new, Collectors.toList()));

            List<Map<String, Object>> testCaseResults = new ArrayList<>();
            List<String> failedTests = new ArrayList<>();
            List<String> passedTests = new ArrayList<>();
            List<String> errorTests = new ArrayList<>();

            for (Map.Entry<String, List<MutationRecord>> entry : byTest.entrySet()) {
                String testName = entry.getKey();
                List<MutationRecord> testRecords = entry.getValue();
                int detectedMutants = (int) testRecords.stream().filter(record -> record.value).count();
                int failures = (int) testRecords.stream().filter(record -> record.failure).count();

                if (testRecords.stream().anyMatch(record -> record.value)) {
                    failedTests.add(testName);
                } else if (testRecords.stream().anyMatch(record -> record.failure)) {
                    errorTests.add(testName);
                } else {
                    passedTests.add(testName);
                }

                List<Map<String, Object>> mutants = testRecords.stream()
                        .sorted(Comparator.comparing(record -> normalizePath(record.mutantPath)))
                        .map(record -> {
                            Map<String, Object> mutant = new LinkedHashMap<>();
                            mutant.put("name", normalizePath(record.mutantPath));
                            mutant.put("message", normalizeAssertionMessage(record));
                            mutant.put("mutation", Collections.singletonList(record.operator));
                            mutant.put("value", record.value);
                            mutant.put("failure", record.failure);
                            return mutant;
                        })
                        .collect(Collectors.toList());

                Map<String, Object> result = new LinkedHashMap<>();
                result.put("name", testName);
                result.put("testPath", normalizePath(testRecords.get(0).testPath));
                result.put("detectedMutants", detectedMutants);
                result.put("failures", failures);
                result.put("mutants", mutants);
                testCaseResults.add(result);
            }

            Map<String, Object> testSuiteResult = new LinkedHashMap<>();
            testSuiteResult.put("name", input.testProject);
            testSuiteResult.put("killedMutants", killedClasses.size());
            testSuiteResult.put("results", testCaseResults);
            List<Map<String, Object>> testResults = Collections.singletonList(testSuiteResult);

            int mutantsCompiling = Math.max(0, input.mutantsGenerated - input.nonCompiling);
            int mutantsKilled = killedClasses.size();
            int mutantsEquivalent = equivalentClasses.size();
            int mutantsLive = Math.max(0, mutantsCompiling - mutantsKilled - mutantsEquivalent);
            double mutationScore = (mutantsCompiling - mutantsEquivalent) > 0
                    ? (double) mutantsKilled / (double) (mutantsCompiling - mutantsEquivalent)
                    : 0.0d;

            List<String> notes = new ArrayList<>();
            notes.add("Generator profile from project.txt: " + input.generatorProfile);
            if (input.equivalentPrefixes.isEmpty()) {
                notes.add("Equivalent mutant information was not found, so equivalent mutants were assumed to be 0.");
            }
            if (input.operatorsSelected > input.operatorsApplied) {
                notes.add((input.operatorsSelected - input.operatorsApplied)
                        + " selected operators were not named in mutators.txt; only the applied operators are listed explicitly.");
            }

            Map<String, Object> global = new LinkedHashMap<>();
            global.put("generatedMutants", input.mutantsGenerated);
            global.put("mutationScore", round(mutationScore, 6));
            global.put("runningTimeSeconds", input.runningMs / 1000L);
            global.put("mutationTimeSeconds", input.mutationMs / 1000L);
            global.put("testsExecutionTimeSeconds", Math.max(0L, (input.runningMs - input.mutationMs) / 1000L));
            global.put("operatorsSelected", input.operatorsSelected);
            global.put("operatorsApplied", input.operatorsApplied);
            global.put("mutantsCompiling", mutantsCompiling);
            global.put("mutantsKilled", mutantsKilled);
            global.put("mutantsLive", mutantsLive);
            global.put("mutantsEquivalent", mutantsEquivalent);
            global.put("testsExecuted", input.testsExecuted);
            global.put("testsFailed", input.testsFailed);
            global.put("testsPassed", Math.max(0, input.testsExecuted - input.testsFailed));
            global.put("testsError", input.testsError);
            global.put("appliedMutators", input.mutators);
            global.put("notAppliedMutators", input.operatorsSelected > input.operatorsApplied
                    ? Collections.singletonList((input.operatorsSelected - input.operatorsApplied)
                    + " selected operators were not applied or were not named in mutators.txt.")
                    : Collections.emptyList());
            global.put("killedClasses", killedClasses);
            global.put("equivalentClasses", equivalentClasses);
            global.put("liveClasses", liveClasses);
            global.put("errorClasses", errorClasses);
            global.put("failedTests", failedTests);
            global.put("passedTests", passedTests);
            global.put("errorTests", errorTests);

            Map<String, Object> suite = new LinkedHashMap<>();
            suite.put("name", input.suiteName);
            suite.put("global", global);
            suite.put("classResults", classResults);
            suite.put("mutatorResults", mutatorResults);
            suite.put("testResults", testResults);

            Map<String, Object> report = new LinkedHashMap<>();
            report.put("projectName", input.projectName);
            report.put("generatedAt", Instant.now().toString());
            report.put("notes", notes);
            report.put("testSuites", Collections.singletonList(suite));
            return report;
        }

        private static List<MutationRecord> parseMutationRecords(Path classesResults, String fallbackSuiteName) throws IOException {
            List<MutationRecord> records = new ArrayList<>();
            int lineNumber = 0;
            for (String line : Files.readAllLines(classesResults, StandardCharsets.UTF_8)) {
                lineNumber++;
                if (line == null || line.isBlank()) {
                    continue;
                }
                String[] parts = line.split("\\|", -1);
                if (parts.length != 8) {
                    throw new IOException("Unexpected classes.results.txt row with " + parts.length + " fields at line "
                            + lineNumber + " in " + classesResults + ": " + line);
                }
                String mutantPath = parts[0];
                String testName = parts[1];
                String testPath = parts[2];
                String nameValue = parts[3];
                String message = parts[4];
                boolean failure = Boolean.parseBoolean(parts[5]);
                int numExecutions = Integer.parseInt(parts[6]);
                int rawLast = Integer.parseInt(parts[7]);
                String valueToken = nameValue.contains("=") ? nameValue.substring(nameValue.lastIndexOf('=') + 1) : nameValue;
                boolean value = Boolean.parseBoolean(valueToken);

                String normalizedMutantPath = normalizePath(mutantPath);
                String[] pieces = trimSlashes(normalizedMutantPath).split("/");
                String suiteName = pieces.length > 0 && !pieces[0].isEmpty() ? pieces[0] : fallbackSuiteName;
                String classFull = pieces.length > 1 ? pieces[1] : "";
                String operator = pieces.length > 2 ? pieces[2] : "";
                String output = pieces.length > 3 ? pieces[3] : "";
                String className = classFull.contains(".") ? classFull.substring(classFull.lastIndexOf('.') + 1) : classFull;
                String packageName = classFull.contains(".") ? classFull.substring(0, classFull.lastIndexOf('.')) : "";

                records.add(new MutationRecord(
                        mutantPath,
                        normalizedMutantPath,
                        testName,
                        testPath,
                        value,
                        message,
                        failure,
                        numExecutions,
                        rawLast,
                        suiteName,
                        classFull,
                        className,
                        packageName,
                        operator,
                        output));
            }
            return records;
        }

        private static List<Path> listMatching(Path directory, String glob) throws IOException {
            try (Stream<Path> stream = Files.list(directory)) {
                return stream
                        .filter(path -> path.getFileName().toString().endsWith(glob.substring(1)))
                        .sorted()
                        .collect(Collectors.toList());
            }
        }

        private static List<String> readLinesIfExists(Path file) throws IOException {
            if (!Files.exists(file)) {
                return Collections.emptyList();
            }
            return Files.readAllLines(file, StandardCharsets.UTF_8);
        }

        private static List<String> splitPipeFile(Path file) throws IOException {
            if (!Files.exists(file)) {
                return Collections.emptyList();
            }
            String content = Files.readString(file, StandardCharsets.UTF_8).trim();
            if (content.isEmpty()) {
                return Collections.emptyList();
            }
            List<String> values = new ArrayList<>();
            for (String part : content.split("\\|")) {
                String value = part.trim();
                if (!value.isEmpty()) {
                    values.add(value);
                }
            }
            return values;
        }

        private static List<String> splitEquivalentPrefixes(Path file) throws IOException {
            if (!Files.exists(file)) {
                return Collections.emptyList();
            }
            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            if (lines.isEmpty() || lines.get(0).trim().isEmpty()) {
                return Collections.emptyList();
            }
            List<String> prefixes = new ArrayList<>();
            for (String part : lines.get(0).split("\\|")) {
                String prefix = normalizePath(part.trim());
                if (!prefix.isEmpty()) {
                    prefixes.add(prefix);
                }
            }
            return prefixes;
        }

        private static Map<String, String> readClassSourcePaths(Path file) throws IOException {
            if (!Files.exists(file)) {
                return Collections.emptyMap();
            }
            Map<String, String> classPaths = new LinkedHashMap<>();
            for (String line : Files.readAllLines(file, StandardCharsets.UTF_8)) {
                if (line == null || line.isBlank()) {
                    continue;
                }
                String[] parts = line.split("\\|", -1);
                if (parts.length >= 2) {
                    classPaths.put(parts[0].trim(), parts[1].trim());
                }
            }
            return classPaths;
        }

        private static boolean isEquivalent(String normalizedMutantPath, List<String> equivalentPrefixes) {
            for (String prefix : equivalentPrefixes) {
                if (normalizedMutantPath.startsWith(prefix)) {
                    return true;
                }
            }
            return false;
        }

        private static String normalizeAssertionMessage(MutationRecord record) {
            if (!record.value && !record.failure && "Equals".equals(record.message)) {
                return "";
            }
            return record.message == null ? "" : record.message;
        }

        private static void writeResource(Path target, String resourceName) throws IOException {
            try (InputStream input = WodelTestHtmlReportExporter.class.getResourceAsStream(RESOURCE_ROOT + resourceName)) {
                if (input == null) {
                    throw new IOException("Missing bundled resource: " + RESOURCE_ROOT + resourceName);
                }
                Files.copy(input, target, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            }
        }

        private static String stripSuffix(String value, String suffix) {
            return value.endsWith(suffix) ? value.substring(0, value.length() - suffix.length()) : value;
        }

        private static long parseLong(String value, Path file, int line) throws IOException {
            try {
                return Long.parseLong(value.trim());
            } catch (NumberFormatException ex) {
                throw new IOException("Invalid long value at line " + line + " in " + file + ": " + value, ex);
            }
        }

        private static int parseInt(String value, Path file, int line) throws IOException {
            try {
                return Integer.parseInt(value.trim());
            } catch (NumberFormatException ex) {
                throw new IOException("Invalid integer value at line " + line + " in " + file + ": " + value, ex);
            }
        }

        private static double round(double value, int scale) {
            double factor = Math.pow(10.0d, scale);
            return Math.round(value * factor) / factor;
        }

        private static String normalizePath(String value) {
            return value == null ? "" : value.replace('\\', '/');
        }

        private static String trimSlashes(String value) {
            String result = value == null ? "" : value;
            while (result.startsWith("/")) {
                result = result.substring(1);
            }
            while (result.endsWith("/")) {
                result = result.substring(0, result.length() - 1);
            }
            return result;
        }

        public record ExportResult(Path html, Path css, Path javascript, Path dataJavascript, Path json) {
        }

        private record ReportInput(
                Path inputDir,
                String projectName,
                String suiteName,
                String generatorProfile,
                String testProject,
                long runningMs,
                long mutationMs,
                int operatorsSelected,
                int operatorsApplied,
                int mutantsGenerated,
                int nonCompiling,
                int testsExecuted,
                int testsFailed,
                int testsError,
                List<String> mutators,
                List<String> equivalentPrefixes,
                Map<String, String> classSourcePaths,
                List<MutationRecord> records) {
        }

        private record MutationRecord(
                String mutantPath,
                String normalizedMutantPath,
                String testName,
                String testPath,
                boolean value,
                String message,
                boolean failure,
                int numExecutions,
                int rawLast,
                String suiteName,
                String classFull,
                String className,
                String packageName,
                String operator,
                String output) {
        }

        private static final class JsonWriter {
            private JsonWriter() {
            }

            static String write(Object value) {
                StringBuilder builder = new StringBuilder(16_384);
                append(builder, value, 0);
                return builder.toString();
            }

            private static void append(StringBuilder builder, Object value, int depth) {
                if (value == null) {
                    builder.append("null");
                    return;
                }
                if (value instanceof String string) {
                    appendString(builder, string);
                    return;
                }
                if (value instanceof Number || value instanceof Boolean) {
                    builder.append(value);
                    return;
                }
                if (value instanceof Map<?, ?> map) {
                    builder.append("{\n");
                    boolean first = true;
                    for (Map.Entry<?, ?> entry : map.entrySet()) {
                        if (!first) {
                            builder.append(",\n");
                        }
                        indent(builder, depth + 1);
                        appendString(builder, String.valueOf(entry.getKey()));
                        builder.append(": ");
                        append(builder, entry.getValue(), depth + 1);
                        first = false;
                    }
                    builder.append('\n');
                    indent(builder, depth);
                    builder.append('}');
                    return;
                }
                if (value instanceof Collection<?> collection) {
                    builder.append("[\n");
                    boolean first = true;
                    for (Object item : collection) {
                        if (!first) {
                            builder.append(",\n");
                        }
                        indent(builder, depth + 1);
                        append(builder, item, depth + 1);
                        first = false;
                    }
                    builder.append('\n');
                    indent(builder, depth);
                    builder.append(']');
                    return;
                }
                appendString(builder, String.valueOf(value));
            }

            private static void appendString(StringBuilder builder, String value) {
                builder.append('"');
                for (int i = 0; i < value.length(); i++) {
                    char c = value.charAt(i);
                    switch (c) {
                        case '"' -> builder.append("\\\"");
                        case '\\' -> builder.append("\\\\");
                        case '\b' -> builder.append("\\b");
                        case '\f' -> builder.append("\\f");
                        case '\n' -> builder.append("\\n");
                        case '\r' -> builder.append("\\r");
                        case '\t' -> builder.append("\\t");
                        default -> {
                            if (c < 0x20) {
                                builder.append(String.format(Locale.ROOT, "\\u%04x", (int) c));
                            } else {
                                builder.append(c);
                            }
                        }
                    }
                }
                builder.append('"');
            }

            private static void indent(StringBuilder builder, int depth) {
                builder.append("  ".repeat(Math.max(0, depth)));
            }
        }

        @Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			// TODO Auto-generated method stub
			try {
				export();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    }
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			RunWodelTestHtmlReportExporterWithProgress runWodelTestHtmlReportExporterWithProgress = new RunWodelTestHtmlReportExporterWithProgress(event);
			ProgressMonitorDialog monitor = new ProgressMonitorDialog(HandlerUtil.getActiveShell(event));
			monitor.setCancelable(true);
			monitor.run(true, true, runWodelTestHtmlReportExporterWithProgress);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
