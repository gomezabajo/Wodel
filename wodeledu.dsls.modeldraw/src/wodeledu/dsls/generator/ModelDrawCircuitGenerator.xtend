package wodeledu.dsls.generator

import modeldraw.MutatorDraw
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import wodel.utils.manager.JavaUtils
import wodel.utils.manager.ModelManager

/**
 * @author Pablo Gomez-Abajo - modelDraw code generator.
 *
 * Generates the Java code for the graphical representation of logical-circuit
 * models. The generated Draw class resolves project and renderer paths at
 * runtime, preserves the logical circuit while traversing it, and performs
 * robust resource/process cleanup.
 */
class ModelDrawCircuitGenerator extends AbstractGenerator {

    override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
        val sourceName = resource.URI.lastSegment
        val baseName = sourceName
            .replaceFirst("\\.draw$", "")
            .replaceAll("[.]", "_")

        var index = 0
        for (draw : resource.allContents.toIterable.filter(MutatorDraw)) {
            val generatedClassName = if (index == 0) baseName else baseName + index
            val generatedFileName = generatedClassName + "Draw.java"
            val metamodel = ModelManager.loadMetaModel(draw.metamodel)
            val roots = ModelManager.getRootEClasses(metamodel)
            val generatedRootName = if (roots.empty) "Model" else roots.get(0).name
            val generatedMetamodelFileName = lastSegment(draw.metamodel)

            fsa.generateFile(
                "mutator/" + generatedClassName + "/" + generatedFileName,
                JavaUtils.format(
                    compile(
                        draw,
                        generatedClassName,
                        generatedRootName,
                        generatedMetamodelFileName
                    ),
                    false
                )
            )
            index++
        }
    }

    private def String lastSegment(String value) {
        if (value === null || value.empty) {
            return ""
        }
        val normalized = value.replace("\\", "/")
        val slash = normalized.lastIndexOf("/")
        if (slash >= 0) normalized.substring(slash + 1) else normalized
    }

    private def String javaString(String value) {
        if (value === null) {
            return ""
        }
        value.replace("\\", "\\\\").replace("\"", "\\\"")
    }

    def compile(
        MutatorDraw draw,
        String className,
        String rootName,
        String metamodelFileName
    ) '''
        package mutator.«className»;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.IOException;
        import java.lang.reflect.InvocationTargetException;
        import java.net.URISyntaxException;
        import java.nio.charset.StandardCharsets;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.util.AbstractMap.SimpleEntry;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Collections;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.concurrent.TimeUnit;

        import org.eclipse.core.commands.AbstractHandler;
        import org.eclipse.core.commands.ExecutionEvent;
        import org.eclipse.core.commands.ExecutionException;
        import org.eclipse.core.resources.IProject;
        import org.eclipse.core.runtime.IProgressMonitor;
        import org.eclipse.core.runtime.NullProgressMonitor;
        import org.eclipse.core.runtime.Platform;
        import org.eclipse.emf.ecore.EPackage;
        import org.eclipse.emf.ecore.resource.Resource;
        import org.eclipse.jface.dialogs.ProgressMonitorDialog;
        import org.eclipse.jface.operation.IRunnableWithProgress;
        import org.eclipse.swt.widgets.Shell;
        import org.eclipse.ui.handlers.HandlerUtil;

        import wodel.utils.exceptions.MetaModelNotFoundException;
        import wodel.utils.exceptions.ModelNotFoundException;
        import wodel.utils.manager.CircuitUtils;
        import wodel.utils.manager.CircuitUtils.LogicalAND;
        import wodel.utils.manager.CircuitUtils.LogicalCircuit;
        import wodel.utils.manager.CircuitUtils.LogicalInputPin;
        import wodel.utils.manager.CircuitUtils.LogicalNOT;
        import wodel.utils.manager.CircuitUtils.LogicalNode;
        import wodel.utils.manager.CircuitUtils.LogicalOR;
        import wodel.utils.manager.CircuitUtils.LogicalOutputPin;
        import wodel.utils.manager.ModelManager;
        import wodel.utils.manager.ProjectUtils;

        public class «className»Draw extends AbstractHandler
                implements wodeledu.extension.run.commands.IMutatorDraw {

            private static final String MODEL_EXTENSION = ".model";
            private static final String ECORE_EXTENSION = ".ecore";
            private static final String DIAGRAM_PREFIX = "«javaString(rootName)»";
            private static final String METAMODEL_FILE_NAME = "«javaString(metamodelFileName)»";
            private static final String RENDERER_PLUGIN_ID = "wodeledu.dsls.EduTest";
            private static final String RENDERER_PREFERENCE = "Model-Draw renderer path";
            private static final String BATIK_JAR = "batik-rasterizer-1.19.jar";

            private class RunMutatorDrawWithProgress implements IRunnableWithProgress {
                @Override
                public void run(IProgressMonitor monitor)
                        throws InvocationTargetException, InterruptedException {
                    try {
                        generate(monitor);
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw e;
                    }
                    catch (Exception e) {
                        throw new InvocationTargetException(e);
                    }
                }
            }

            private String generateCircuitMacrosSpecification(
                    List<EPackage> packages,
                    Resource model,
                    String modelFileName) {

                StringBuilder m4 = new StringBuilder();
                m4.append(".PS\n");
                m4.append("# ").append(stripExtension(modelFileName)).append(".m4\n");
                m4.append("log_init\n\n");
                m4.append("define(`del',`L_unit*5/2')\n\n");
                m4.append("dmov = 0.4\n");
                m4.append("# Input labels\n");
                m4.append("C: grid_(0,0)\n");
                m4.append("DE: C+grid_(0,AND_ht*7/4)\n");

                LogicalCircuit circuit = CircuitUtils.convertToLC(packages, model);
                if (circuit == null) {
                    throw new IllegalStateException("Cannot convert model to a logical circuit: " + modelFileName);
                }

                // Defensive copies are essential: the traversal clears and repopulates
                // the frontier and must never modify LogicalCircuit#getInputPins().
                List<LogicalInputPin> originalInputPins =
                        new ArrayList<LogicalInputPin>(circuit.getInputPins());
                List<LogicalInputPin> frontierPins =
                        new ArrayList<LogicalInputPin>(originalInputPins);

                Map<String, SimpleEntry<String, Integer>> relations =
                        new HashMap<String, SimpleEntry<String, Integer>>();

                int position = 0;
                if (!frontierPins.isEmpty()) {
                    LogicalInputPin input = frontierPins.get(0);
                    m4.append("A0: DE+grid_(0,BUF_ht*5/2); dot(at A0); \"")
                      .append(input.getName())
                      .append("\" rjust at A0\n");
                    relations.put(input.getName(),
                            new SimpleEntry<String, Integer>("A0", position));
                }

				if (frontierPins != null) {
                	for (int i = 1; i < frontierPins.size(); i++) {
                    	LogicalInputPin input = frontierPins.get(i);
                    	m4.append("A").append(i)
                     	 	.append(": A").append(i - 1)
                      		.append("+grid_(0,BUF_ht*5/2); dot(at A").append(i)
                      		.append("); \"").append(input.getName())
                      		.append("\" rjust at A").append(i).append("\n");
                    	relations.put(input.getName(),
                        	    new SimpleEntry<String, Integer>("A" + i, position));
                	}
                }

                m4.append("  move to (-0.2,0)   # Lettering within the global object\n\n");

                List<LogicalNode> currentLevel = collectNodesForPins(circuit, frontierPins);
                frontierPins = collectNextPins(currentLevel);

                char alphabet = 'G';
                int level = 0;
                int directInputCounter = 0;

                renderLevel(
                    m4,
                    circuit,
                    currentLevel,
                    relations,
                    originalInputPins,
                    alphabet,
                    level,
                    directInputCounter,
                    true
                );

                // renderLevel cannot return a primitive counter by reference, so the first
                // level's direct input numbering is reproduced here for the next level only
                // through graph topology; later levels do not consume A<n> inputs.
                LogicalNode outputNode = circuit.getOutputNode();

                while (outputNode != null
                        && !currentLevel.contains(outputNode)
                        && level < circuit.getDistance()) {

                    level++;
                    checkLogicalProgress(level, circuit.getDistance());

                    currentLevel = collectInternalNodesForPins(
                            circuit,
                            frontierPins,
                            originalInputPins
                    );
                    frontierPins = collectNextPins(currentLevel);

                    renderLevel(
                        m4,
                        circuit,
                        currentLevel,
                        relations,
                        originalInputPins,
                        alphabet,
                        level,
                        0,
                        false
                    );
                }

                if (outputNode != null) {
                    SimpleEntry<String, Integer> relation = relations.get(outputNode.getName());
                    LogicalOutputPin outputPin = outputNode.getOutputPin();
                    if (relation != null && outputPin != null) {
                        m4.append("LOUT: line right del from ")
                          .append(relation.getKey())
                          .append(".Out; dot at (LOUT,Here); move right 0.2; \"")
                          .append(outputPin.getName())
                          .append("\" rjust\n\n");
                    }
                }

                m4.append(".PE\n");
                return m4.toString();
            }

            private void renderLevel(
                    StringBuilder m4,
                    LogicalCircuit circuit,
                    List<LogicalNode> nodes,
                    Map<String, SimpleEntry<String, Integer>> relations,
                    List<LogicalInputPin> originalInputPins,
                    char alphabet,
                    int level,
                    int directInputCounter,
                    boolean firstLevel) {

                int counter = directInputCounter;

				if (nodes != null) {
                	for (int i = 0; i < nodes.size(); i++) {
                    	LogicalNode node = nodes.get(i);
                    	SimpleEntry<String, Integer> previous = firstLevel
                        	    ? firstRelationForPins(relations, node.getInputPins())
                            	: firstRelationForNodes(relations, node.getInputs());

                    	if (previous == null) {
                        	throw new IllegalStateException(
                            	    "Cannot resolve predecessor while drawing logical node " + node.getName());
                    	}

                    	int position = previous.getValue() + (firstLevel ? 8 : 16);
                    	if (firstLevel
                        	    && !originalInputPins.containsAll(node.getInputPins())) {
                        	position += 16;
                    	}

                    	String gateName = gateName(node);
                    	String label = String.valueOf((char) (alphabet + level)) + (i + 1);

	                    m4.append(label)
    	                  .append(": ").append(gateName).append("_gate at (")
        	              .append(previous.getKey())
            	          .append("+grid_(").append(position)
                	      .append(",BUF_ht*").append(position).append("),")
                    	  .append(previous.getKey());

                    	if (!firstLevel) {
                        	m4.append("+grid_(0,BUF_ht*15/13)");
                    	}
                    	m4.append(")\n\n");

	                    relations.put(node.getName(),
    	                        new SimpleEntry<String, Integer>(label, position));
        	        }
				}

                for (int i = 0; i < nodes.size(); i++) {
                    LogicalNode node = nodes.get(i);
                    SimpleEntry<String, Integer> nodeRelation = relations.get(node.getName());
                    if (nodeRelation == null) {
                        continue;
                    }
                    String label = nodeRelation.getKey();

                    if (!firstLevel) {
                        appendInternalConnections(m4, node, label, relations);
                        continue;
                    }

                    int pinCount = node.getInputPins().size();
                    int internalCount = node.getInputs().size();

                    if (pinCount == 1) {
                        if (internalCount == 0) {
                            m4.append("line right 3*del from A")
                              .append(counter++)
                              .append(" to ").append(label).append(".In1\n");
                        }
                        else {
                            appendConnectionFromNode(
                                m4,
                                relations,
                                node.getInputs().get(0),
                                label,
                                ".In2"
                            );
                        }
                    }
                    else if (pinCount > 1) {
                        if (internalCount == 0) {
                            m4.append("line right 3*del from A")
                              .append(counter++)
                              .append(" to ").append(label).append(".In2\n");
                            m4.append("line right 3*del from A")
                              .append(counter++)
                              .append(" to ").append(label).append(".In1\n");
                        }
                        else if (internalCount == 1) {
                            m4.append("line right 3*del from A")
                              .append(counter++)
                              .append(" to ").append(label).append(".In2\n");
                            appendConnectionFromNode(
                                m4,
                                relations,
                                node.getInputs().get(0),
                                label,
                                ".In1"
                            );
                        }
                        else {
                            appendConnectionFromNode(
                                m4,
                                relations,
                                node.getInputs().get(0),
                                label,
                                ".In2"
                            );
                            appendConnectionFromNode(
                                m4,
                                relations,
                                node.getInputs().get(1),
                                label,
                                ".In1"
                            );
                        }
                    }
                    m4.append("\n");
                }
            }

            private void appendInternalConnections(
                    StringBuilder m4,
                    LogicalNode node,
                    String label,
                    Map<String, SimpleEntry<String, Integer>> relations) {

                List<LogicalNode> inputs = node.getInputs();
                if (inputs == null || inputs.isEmpty()) {
                    return;
                }

                if (inputs.size() == 1) {
                    appendConnectionFromNode(m4, relations, inputs.get(0), label, ".In1");
                }
                else {
                    appendConnectionFromNode(m4, relations, inputs.get(0), label, ".In2");
                    appendConnectionFromNode(m4, relations, inputs.get(1), label, ".In1");
                }
                m4.append("\n");
            }

            private void appendConnectionFromNode(
                    StringBuilder m4,
                    Map<String, SimpleEntry<String, Integer>> relations,
                    LogicalNode inputNode,
                    String targetLabel,
                    String targetPin) {

                if (inputNode == null) {
                    return;
                }
                SimpleEntry<String, Integer> relation = relations.get(inputNode.getName());
                if (relation != null) {
                    m4.append("line right 3*del from ")
                      .append(relation.getKey())
                      .append(".Out to ")
                      .append(targetLabel)
                      .append(targetPin)
                      .append("\n");
                }
            }

            private List<LogicalNode> collectNodesForPins(
                    LogicalCircuit circuit,
                    List<LogicalInputPin> pins) {

                List<LogicalNode> nodes = new ArrayList<LogicalNode>();
                if (pins != null) {
                	for (LogicalInputPin pin : pins) {
                    	if (pin == null) {
                        	continue;
                    	}
                    	LogicalNode node = circuit.getNodeWithInput(pin.getName());
                    	if (node != null && !nodes.contains(node)) {
                        	nodes.add(node);
                    	}
                	}
                }
                return nodes;
            }

            private List<LogicalNode> collectInternalNodesForPins(
                    LogicalCircuit circuit,
                    List<LogicalInputPin> pins,
                    List<LogicalInputPin> originalInputPins) {

                List<LogicalNode> nodes = new ArrayList<LogicalNode>();
                if (pins != null) {
                	for (LogicalInputPin pin : pins) {
                    	if (pin == null) {
                        	continue;
                    	}
                    	LogicalNode node = circuit.getNodeWithInput(pin.getName());
                    	if (node == null || nodes.contains(node)) {
                        	continue;
                    	}

                    	List<LogicalInputPin> nodePins = node.getInputPins();
                    	if (nodePins == null || nodePins.isEmpty()) {
                        	continue;
                    	}

                    	boolean internal = true;
                    	for (LogicalInputPin nodePin : nodePins) {
                        	if (originalInputPins.contains(nodePin)) {
	                            internal = false;
    	                        break;
        	                }
            	        }
                	    if (internal) {
                    	    nodes.add(node);
                    	}
                	}
                }
                return nodes;
            }

            private List<LogicalInputPin> collectNextPins(List<LogicalNode> nodes) {
                List<LogicalInputPin> pins = new ArrayList<LogicalInputPin>();
                if (nodes == null) {
                	return pins;
                }
                for (LogicalNode node : nodes) {
                    LogicalOutputPin outputPin = node.getOutputPin();
                    if (outputPin == null || outputPin.getTarget() == null) {
                        continue;
                    }
                    LogicalInputPin target = outputPin.getTarget();
                    if (!pins.contains(target)) {
                        pins.add(target);
                    }
                }
                return pins;
            }

            private SimpleEntry<String, Integer> firstRelationForPins(
                    Map<String, SimpleEntry<String, Integer>> relations,
                    List<LogicalInputPin> pins) {

				if (pins == null || relations == null) {
					return null;
				}
                for (LogicalInputPin pin : pins) {
                    if (pin != null) {
                        SimpleEntry<String, Integer> relation = relations.get(pin.getName());
                        if (relation != null) {
                            return relation;
                        }
                    }
                }
                return null;
            }

            private SimpleEntry<String, Integer> firstRelationForNodes(
                    Map<String, SimpleEntry<String, Integer>> relations,
                    List<LogicalNode> nodes) {

				if (nodes == null) {
					return null;
				}
                for (LogicalNode node : nodes) {
                    if (node != null) {
                        SimpleEntry<String, Integer> relation = relations.get(node.getName());
                        if (relation != null) {
                            return relation;
                        }
                    }
                }
                return null;
            }

            private String gateName(LogicalNode node) {
                if (node instanceof LogicalNOT) {
                    return "NOT";
                }
                if (node instanceof LogicalAND) {
                    return "AND";
                }
                if (node instanceof LogicalOR) {
                    return "OR";
                }
                throw new IllegalStateException(
                        "Unsupported logical node type: " + node.getClass().getName());
            }

            private void checkLogicalProgress(int level, int distance) {
                if (level > distance) {
                    throw new IllegalStateException("Logical circuit traversal exceeded its declared distance");
                }
            }

            public void generate(IProgressMonitor progressMonitor)
                    throws MetaModelNotFoundException, ModelNotFoundException,
                           IOException, InterruptedException {

                IProgressMonitor monitor = progressMonitor != null
                        ? progressMonitor
                        : new NullProgressMonitor();

                File projectDirectory = resolveProjectDirectory();
                ProjectFolders folders = readProjectFolders(projectDirectory);
                File metamodelFile = resolveMetamodelFile(folders.modelDirectory);
                File rendererDirectory = resolveRendererDirectory(projectDirectory);
                File diagramsDirectory = new File(projectDirectory, "src-gen/html/diagrams");
                ensureDirectory(diagramsDirectory);

                List<EPackage> packages =
                        ModelManager.loadMetaModel(metamodelFile.getAbsolutePath());

                List<String> models = ModelManager.getModels(«className»Draw.class);
                List<String> mutants = ModelManager.getMutants(«className»Draw.class);
                if (models == null) {
                    models = Collections.emptyList();
                }
                if (mutants == null) {
                    mutants = Collections.emptyList();
                }

                monitor.beginTask("Rendering logical-circuit models", models.size() + mutants.size());
                try {
                    for (String modelPath : models) {
                        checkCanceled(monitor);
                        File modelFile = new File(modelPath);
                        File outputDirectory = new File(
                                diagramsDirectory,
                                stripExtension(modelFile.getName())
                        );
                        renderModel(
                            modelFile,
                            packages,
                            outputDirectory,
                            projectDirectory,
                            rendererDirectory,
                            monitor,
                            false
                        );
                    }

                    Path mutantRoot = folders.mutantDirectory.toPath().toAbsolutePath().normalize();
                    for (String mutantPath : mutants) {
                        checkCanceled(monitor);
                        File mutantFile = new File(mutantPath);
                        Path parent = mutantFile.getParentFile().toPath().toAbsolutePath().normalize();
                        String relative = safeRelativize(mutantRoot, parent);
                        File outputDirectory = relative.isEmpty()
                                ? diagramsDirectory
                                : new File(diagramsDirectory, relative);

                        renderModel(
                            mutantFile,
                            packages,
                            outputDirectory,
                            projectDirectory,
                            rendererDirectory,
                            monitor,
                            true
                        );
                    }
                }
                finally {
                    monitor.done();
                }
            }

            private void renderModel(
                    File modelFile,
                    List<EPackage> packages,
                    File outputDirectory,
                    File projectDirectory,
                    File rendererDirectory,
                    IProgressMonitor monitor,
                    boolean mutant)
                    throws MetaModelNotFoundException, ModelNotFoundException,
                           IOException, InterruptedException {

                if (modelFile == null
                        || !modelFile.isFile()
                        || !modelFile.getName().endsWith(MODEL_EXTENSION)) {
                    return;
                }

                checkCanceled(monitor);
                ensureDirectory(outputDirectory);

                String displayPath = safeRelativize(
                        projectDirectory.toPath().toAbsolutePath().normalize(),
                        modelFile.toPath().toAbsolutePath().normalize()
                );
                monitor.subTask(
                        "Rendering image for " + (mutant ? "mutant " : "model ") + displayPath
                );

                Resource model = null;
                try {
                    model = ModelManager.loadModel(packages, modelFile.getAbsolutePath());
                    String m4Text = generateCircuitMacrosSpecification(
                            packages,
                            model,
                            modelFile.getName()
                    );

                    String outputBaseName =
                            DIAGRAM_PREFIX + "_" + stripExtension(modelFile.getName());
                    File m4File = new File(outputDirectory, outputBaseName + ".m4");
                    File svgFile = new File(outputDirectory, outputBaseName + ".svg");
                    File pngFile = new File(outputDirectory, outputBaseName + ".png");

                    Files.writeString(m4File.toPath(), m4Text, StandardCharsets.UTF_8);
                    renderM4(rendererDirectory, m4File, svgFile, pngFile, monitor);
                    monitor.worked(1);
                }
                finally {
                    if (model != null && model.isLoaded()) {
                        model.unload();
                    }
                }
            }

            private void renderM4(
                    File rendererDirectory,
                    File m4File,
                    File svgFile,
                    File pngFile,
                    IProgressMonitor monitor)
                    throws IOException, InterruptedException {

                checkCanceled(monitor);

                File macroLibrary = new File(rendererDirectory, "liblog.m4");
                if (!macroLibrary.isFile()) {
                    throw new IOException("Cannot find renderer macro library: " + macroLibrary);
                }

                String m4Executable = resolveExecutable(rendererDirectory, "m4");
                String dpicExecutable = resolveExecutable(rendererDirectory, "dpic");

                ProcessBuilder m4 = new ProcessBuilder(
                        m4Executable,
                        macroLibrary.getAbsolutePath(),
                        m4File.getAbsolutePath()
                );
                m4.directory(rendererDirectory);
                m4.redirectError(ProcessBuilder.Redirect.INHERIT);

                ProcessBuilder dpic = new ProcessBuilder(dpicExecutable, "-v");
                dpic.directory(rendererDirectory);
                dpic.redirectOutput(svgFile);
                dpic.redirectError(ProcessBuilder.Redirect.INHERIT);

                List<Process> pipeline = ProcessBuilder.startPipeline(Arrays.asList(m4, dpic));
                waitForProcesses(pipeline, monitor, "m4/dpic");

                checkCanceled(monitor);

                File batikDirectory = new File(rendererDirectory, "batik");
                File batikJar = new File(batikDirectory, BATIK_JAR);
                if (!batikJar.isFile()) {
                    throw new IOException("Cannot find Batik rasterizer: " + batikJar);
                }

                ProcessBuilder rasterizer = new ProcessBuilder(
                        javaExecutable(),
                        "-jar",
                        batikJar.getAbsolutePath(),
                        "-m",
                        "image/png",
                        "-d",
                        pngFile.getAbsolutePath(),
                        svgFile.getAbsolutePath()
                );
                rasterizer.directory(batikDirectory);
                rasterizer.redirectError(ProcessBuilder.Redirect.INHERIT);
                rasterizer.redirectOutput(ProcessBuilder.Redirect.INHERIT);

                Process process = rasterizer.start();
                waitForProcess(process, monitor, "Batik rasterizer");
            }

            private void waitForProcesses(
                    List<Process> processes,
                    IProgressMonitor monitor,
                    String description)
                    throws IOException, InterruptedException {

                try {
                    for (Process process : processes) {
                        waitForProcess(process, monitor, description);
                    }
                }
                catch (InterruptedException e) {
                    for (Process process : processes) {
                        if (process.isAlive()) {
                            process.destroyForcibly();
                        }
                    }
                    throw e;
                }
            }

            private void waitForProcess(
                    Process process,
                    IProgressMonitor monitor,
                    String description)
                    throws IOException, InterruptedException {

                try {
                    while (!process.waitFor(200, TimeUnit.MILLISECONDS)) {
                        checkCanceled(monitor);
                    }
                    int exitCode = process.exitValue();
                    if (exitCode != 0) {
                        throw new IOException(
                                description + " failed with exit code " + exitCode
                        );
                    }
                }
                catch (InterruptedException e) {
                    if (process.isAlive()) {
                        process.destroyForcibly();
                    }
                    Thread.currentThread().interrupt();
                    throw e;
                }
            }

            private String resolveExecutable(File directory, String baseName) {
                boolean windows = System.getProperty("os.name", "")
                        .toLowerCase()
                        .contains("win");
                File executable = new File(directory, windows ? baseName + ".exe" : baseName);
                return executable.isFile() ? executable.getAbsolutePath() : baseName;
            }

            private String javaExecutable() {
                boolean windows = System.getProperty("os.name", "")
                        .toLowerCase()
                        .contains("win");
                File executable = new File(
                        new File(System.getProperty("java.home"), "bin"),
                        windows ? "java.exe" : "java"
                );
                return executable.isFile() ? executable.getAbsolutePath() : "java";
            }
            
	private File resolveRendererDirectory(File projectDirectory) throws IOException {

		String rendererPath = Platform.getPreferencesService().getString(RENDERER_PLUGIN_ID, RENDERER_PREFERENCE, "",
				null);

		/*
		 * 1. Explicit preference takes precedence.
		 */
		if (rendererPath != null && !rendererPath.isBlank()) {

			File configured = new File(rendererPath).getCanonicalFile();

			if (isRendererDirectory(configured)) {
				return configured;
			}

			throw new IOException("The configured Model-Draw renderer " + "directory is invalid: " + configured);
		}

		/*
		 * 2. Default to <Wodel project>/dpic.
		 */
		File projectRenderer = new File(projectDirectory, "dpic").getCanonicalFile();

		if (isRendererDirectory(projectRenderer)) {

			return projectRenderer;
		}

		throw new IOException("Cannot find the Model-Draw renderer. " + "No '" + RENDERER_PREFERENCE
				+ "' preference is configured and " + "the default directory does not exist " + "or is incomplete: "
				+ projectRenderer);
	}

	private boolean isRendererDirectory(File directory) {

		if (directory == null || !directory.isDirectory()) {

			return false;
		}

		File macroLibrary = new File(directory, "liblog.m4");

		File batikJar = new File(new File(directory, "batik"), BATIK_JAR);

		return macroLibrary.isFile() && batikJar.isFile();
	}

            private File resolveProjectDirectory() throws IOException {
                try {
                    File location = new File(
                            «className»Draw.class
                                .getProtectionDomain()
                                .getCodeSource()
                                .getLocation()
                                .toURI()
                    );

                    if (location.isFile()) {
                        location = location.getParentFile();
                    }
                    if (location != null && "bin".equals(location.getName())) {
                        location = location.getParentFile();
                    }
                    else if (location != null
                            && "classes".equals(location.getName())
                            && location.getParentFile() != null
                            && "target".equals(location.getParentFile().getName())) {
                        location = location.getParentFile().getParentFile();
                    }

                    if (location != null && location.isDirectory()) {
                        return location.getCanonicalFile();
                    }
                }
                catch (URISyntaxException e) {
                    // Fall through to the Eclipse workspace lookup below.
                }

                IProject project = ProjectUtils.getProject();
                if (project != null && project.getLocation() != null) {
                    return project.getLocation().toFile().getCanonicalFile();
                }

                throw new IOException(
                        "Cannot determine the Wodel-EDU project directory for "
                        + «className»Draw.class.getName()
                );
            }

            private ProjectFolders readProjectFolders(File projectDirectory) throws IOException {
                File configFile = new File(projectDirectory, "data/config/config.txt");
                if (!configFile.isFile()) {
                    throw new IOException("Cannot find Wodel configuration file: " + configFile);
                }

                try (BufferedReader reader = Files.newBufferedReader(
                        configFile.toPath(),
                        StandardCharsets.UTF_8
                )) {
                    String modelFolder = reader.readLine();
                    String mutantFolder = reader.readLine();
                    if (modelFolder == null || modelFolder.isBlank()
                            || mutantFolder == null || mutantFolder.isBlank()) {
                        throw new IOException("Invalid Wodel configuration file: " + configFile);
                    }

                    return new ProjectFolders(
                            new File(projectDirectory, modelFolder).getCanonicalFile(),
                            new File(projectDirectory, mutantFolder).getCanonicalFile()
                    );
                }
            }

            private File resolveMetamodelFile(File modelDirectory) throws IOException {
                if (METAMODEL_FILE_NAME != null && !METAMODEL_FILE_NAME.isBlank()) {
                    File expected = new File(modelDirectory, METAMODEL_FILE_NAME);
                    if (expected.isFile()) {
                        return expected;
                    }
                }

                File[] files = modelDirectory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile() && file.getName().endsWith(ECORE_EXTENSION)) {
                            return file;
                        }
                    }
                }

                throw new IOException(
                        "Cannot find an Ecore metamodel in " + modelDirectory
                );
            }

            private void ensureDirectory(File directory) throws IOException {
                if (directory.isDirectory()) {
                    return;
                }
                if (!directory.mkdirs() && !directory.isDirectory()) {
                    throw new IOException("Cannot create directory: " + directory);
                }
            }

            private void checkCanceled(IProgressMonitor monitor) throws InterruptedException {
                if (monitor != null && monitor.isCanceled()) {
                    throw new InterruptedException("Logical-circuit rendering was canceled");
                }
            }

            private String safeRelativize(Path root, Path path) {
                try {
                    if (root.getRoot() != null
                            && path.getRoot() != null
                            && !root.getRoot().equals(path.getRoot())) {
                        return path.toString();
                    }
                    return root.relativize(path).toString();
                }
                catch (IllegalArgumentException e) {
                    return path.toString();
                }
            }

            private String stripExtension(String name) {
                if (name == null) {
                    return "";
                }
                int index = name.lastIndexOf('.');
                return index > 0 ? name.substring(0, index) : name;
            }

            private static final class ProjectFolders {
                private final File modelDirectory;
                private final File mutantDirectory;

                private ProjectFolders(File modelDirectory, File mutantDirectory) {
                    this.modelDirectory = modelDirectory;
                    this.mutantDirectory = mutantDirectory;
                }
            }

            @Override
            public Object execute(ExecutionEvent event) throws ExecutionException {
                /*
                 * Interactive command entry point. When Eclipse invokes this
                 * handler from the UI, use the active shell for a progress
                 * dialog. If no UI shell is available, fall back to direct
                 * execution rather than failing.
                 */
                Shell shell = event != null ? HandlerUtil.getActiveShell(event) : null;

                if (shell == null || shell.isDisposed()) {
                    try {
                        generate(new NullProgressMonitor());
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    catch (Exception e) {
                        throw new ExecutionException(
                                "Error rendering Wodel-EDU logical-circuit diagrams",
                                e
                        );
                    }
                    return null;
                }

                ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
                try {
                    dialog.run(true, true, new RunMutatorDrawWithProgress());
                }
                catch (InvocationTargetException e) {
                    Throwable cause = e.getCause() != null ? e.getCause() : e;
                    throw new ExecutionException(
                            "Error rendering Wodel-EDU logical-circuit diagrams",
                            cause
                    );
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return null;
            }

            @Override
            public void run() {
                /*
                 * Non-UI extension entry point used reflectively by Wodel.
                 * It is commonly called from Wodel's existing background
                 * progress operation, where there may be no active workbench
                 * window. Do not open a nested ProgressMonitorDialog here.
                 */
                try {
                    generate(new NullProgressMonitor());
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException(
                            "Logical-circuit rendering was interrupted",
                            e
                    );
                }
                catch (Exception e) {
                    throw new IllegalStateException(
                            "Error rendering Wodel-EDU logical-circuit diagrams",
                            e
                    );
                }
            }
        }
    '''
}
