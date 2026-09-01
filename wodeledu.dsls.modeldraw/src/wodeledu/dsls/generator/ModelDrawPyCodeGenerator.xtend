package wodeledu.dsls.generator

import java.util.ArrayList
import java.util.List

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

import modeldraw.MutatorDraw
import wodel.utils.manager.JavaUtils
import wodel.utils.manager.ModelManager

/**
 * @author Pablo Gomez-Abajo - modelDraw Python code generator.
 *
 * Generates Java code that renders model instances as Python source and
 * syntax-highlighted HTML. Runtime paths are resolved by the generated class;
 * no workspace-specific locations are embedded at generation time.
 */
class ModelDrawPyCodeGenerator extends AbstractGenerator {
    private String fileName
    private String className
    private List<EPackage> metamodel
    private List<EClass> roots
    private String rootName
    private String metamodelFileName

    private def String lastSegment(String value) {
        if (value === null || value.empty) {
            return ""
        }
        val normalized = value.replace("\\", "/")
        val slash = normalized.lastIndexOf("/")
        if (slash >= 0) normalized.substring(slash + 1) else normalized
    }

    private def String baseName(String value) {
        if (value === null || value.empty) {
            return "Model"
        }
        var name = value
        if (name.endsWith(".draw")) {
            name = name.substring(0, name.length - ".draw".length)
        }
        name.replace(".", "_")
    }

    private def String javaString(String value) {
        if (value === null) {
            return ""
        }
        value.replace("\\", "\\\\").replace("\"", "\\\"")
    }

    override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
        val sourceBaseName = baseName(resource?.URI?.lastSegment)
        var index = 0

        for (draw : resource.allContents.toIterable.filter(MutatorDraw)) {
            val generatedBaseName = if (index == 0) sourceBaseName else sourceBaseName + index

            className = generatedBaseName
            fileName = generatedBaseName + "Draw.java"

            metamodel = new ArrayList<EPackage>()
            metamodel.addAll(ModelManager.loadMetaModel(draw.metamodel))

            roots = new ArrayList<EClass>()
            roots.addAll(ModelManager.getRootEClasses(metamodel))
            rootName = if (roots.empty) "Model" else roots.get(0).name
            metamodelFileName = lastSegment(draw.metamodel)

            fsa.generateFile(
                "mutator/" + className + "/" + fileName,
                JavaUtils.format(draw.compile, false)
            )

            index++
        }
    }

    def compile(MutatorDraw draw) '''
        package mutator.«className»;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.IOException;
        import java.lang.reflect.InvocationTargetException;
        import java.net.URISyntaxException;
        import java.nio.charset.StandardCharsets;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.util.Collections;
        import java.util.List;
        import java.util.concurrent.TimeUnit;

        import org.eclipse.core.commands.AbstractHandler;
        import org.eclipse.core.commands.ExecutionEvent;
        import org.eclipse.core.commands.ExecutionException;
        import org.eclipse.core.resources.IProject;
        import org.eclipse.core.runtime.IProgressMonitor;
        import org.eclipse.core.runtime.NullProgressMonitor;
        import org.eclipse.core.runtime.Platform;
        import org.eclipse.emf.ecore.EObject;
        import org.eclipse.emf.ecore.EPackage;
        import org.eclipse.emf.ecore.resource.Resource;
        import org.eclipse.jface.dialogs.ProgressMonitorDialog;
        import org.eclipse.jface.operation.IRunnableWithProgress;
        import org.eclipse.swt.widgets.Shell;
        import org.eclipse.ui.handlers.HandlerUtil;

        import wodel.utils.exceptions.MetaModelNotFoundException;
        import wodel.utils.exceptions.ModelNotFoundException;
        import wodel.utils.manager.ModelManager;
        import wodel.utils.manager.ProjectUtils;
        import wodel.utils.manager.Py2Code;

        public class «className»Draw extends AbstractHandler
                implements wodeledu.extension.run.commands.IMutatorDraw {

            private static final String MODEL_EXTENSION = ".model";
            private static final String ECORE_EXTENSION = ".ecore";
            private static final String ROOT_NAME = "«javaString(rootName)»";
            private static final String METAMODEL_FILE_NAME = "«javaString(metamodelFileName)»";

            /*
             * Reuse the generic Model-Draw renderer preference when it happens
             * to identify a pygmentize executable or a directory containing it.
             * Otherwise pygmentize is resolved from PATH.
             */
            private static final String RENDERER_PLUGIN_ID = "wodeledu.dsls.EduTest";
            private static final String RENDERER_PREFERENCE = "Model-Draw renderer path";

            private static final class ProjectFolders {
                final File modelDirectory;
                final File mutantDirectory;

                ProjectFolders(File modelDirectory, File mutantDirectory) {
                    this.modelDirectory = modelDirectory;
                    this.mutantDirectory = mutantDirectory;
                }
            }

            private final class RunMutatorPyCodeWithProgress
                    implements IRunnableWithProgress {

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

            private ProjectFolders readProjectFolders(File projectDirectory)
                    throws IOException {

                File configFile = new File(
                        projectDirectory,
                        "data/config/config.txt"
                );

                if (!configFile.isFile()) {
                    throw new IOException(
                            "Cannot find Wodel configuration file: " + configFile
                    );
                }

                try (BufferedReader reader = Files.newBufferedReader(
                        configFile.toPath(),
                        StandardCharsets.UTF_8
                )) {
                    String modelFolder = reader.readLine();
                    String mutantFolder = reader.readLine();

                    if (modelFolder == null || modelFolder.isBlank()
                            || mutantFolder == null || mutantFolder.isBlank()) {
                        throw new IOException(
                                "Invalid Wodel configuration file: " + configFile
                        );
                    }

                    return new ProjectFolders(
                            new File(projectDirectory, modelFolder).getCanonicalFile(),
                            new File(projectDirectory, mutantFolder).getCanonicalFile()
                    );
                }
            }

            private File resolveMetamodelFile(File modelDirectory)
                    throws IOException {

                if (METAMODEL_FILE_NAME != null
                        && !METAMODEL_FILE_NAME.isBlank()) {
                    File expected = new File(
                            modelDirectory,
                            METAMODEL_FILE_NAME
                    );
                    if (expected.isFile()) {
                        return expected;
                    }
                }

                File[] files = modelDirectory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()
                                && file.getName().endsWith(ECORE_EXTENSION)) {
                            return file;
                        }
                    }
                }

                throw new IOException(
                        "Cannot find an Ecore metamodel in " + modelDirectory
                );
            }

            private String resolvePygmentizeExecutable() {
                String rendererPath = Platform.getPreferencesService().getString(
                        RENDERER_PLUGIN_ID,
                        RENDERER_PREFERENCE,
                        "",
                        null
                );

                if (rendererPath != null && !rendererPath.isBlank()) {
                    File configured = new File(rendererPath).getAbsoluteFile();

                    if (configured.isFile()) {
                        String name = configured.getName().toLowerCase();
                        if (name.startsWith("pygmentize")) {
                            return configured.getAbsolutePath();
                        }
                    }

                    if (configured.isDirectory()) {
                        String executableName = isWindows()
                                ? "pygmentize.exe"
                                : "pygmentize";
                        File executable = new File(
                                configured,
                                executableName
                        );
                        if (executable.isFile()) {
                            return executable.getAbsolutePath();
                        }
                    }
                }

                String systemProperty = System.getProperty("wodel.pygmentize");
                if (systemProperty != null && !systemProperty.isBlank()) {
                    return systemProperty;
                }

                String environment = System.getenv("WODEL_PYGMENTIZE");
                if (environment != null && !environment.isBlank()) {
                    return environment;
                }

                return isWindows() ? "pygmentize.exe" : "pygmentize";
            }

            private boolean isWindows() {
                return System.getProperty("os.name", "")
                        .toLowerCase()
                        .contains("win");
            }

            private void renderHighlightedHtml(
                    File pythonFile,
                    File htmlFile,
                    File workingDirectory,
                    IProgressMonitor monitor)
                    throws IOException, InterruptedException {

                checkCanceled(monitor);

                ProcessBuilder processBuilder = new ProcessBuilder(
                        resolvePygmentizeExecutable(),
                        "-O",
                        "full,style=emacs,linenos=1",
                        "-o",
                        htmlFile.getAbsolutePath(),
                        pythonFile.getAbsolutePath()
                );

                processBuilder.directory(workingDirectory);
                processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
                processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);

                Process process;
                try {
                    process = processBuilder.start();
                }
                catch (IOException e) {
                    throw new IOException(
                            "Cannot start Pygments 'pygmentize'. "
                            + "Install Pygments or configure the Model-Draw renderer path. "
                            + "Resolved command: "
                            + resolvePygmentizeExecutable(),
                            e
                    );
                }

                try {
                    while (!process.waitFor(200, TimeUnit.MILLISECONDS)) {
                        checkCanceled(monitor);
                    }

                    int exitCode = process.exitValue();
                    if (exitCode != 0) {
                        throw new IOException(
                                "Pygments failed with exit code " + exitCode
                                + " while rendering " + pythonFile
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

                if (!htmlFile.isFile()) {
                    throw new IOException(
                            "Pygments completed without creating HTML output: "
                            + htmlFile
                    );
                }
            }

            private void renderModel(
                    File modelFile,
                    List<EPackage> packages,
                    File outputDirectory,
                    File projectDirectory,
                    IProgressMonitor monitor,
                    boolean mutant)
                    throws MetaModelNotFoundException,
                           ModelNotFoundException,
                           IOException,
                           InterruptedException {

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
                        "Generating Python code for "
                        + (mutant ? "mutant " : "model ")
                        + displayPath
                );

                Resource model = null;
                try {
                    model = ModelManager.loadModel(
                            packages,
                            modelFile.getAbsolutePath()
                    );

                    EObject root = ModelManager.getRoot(model);
                    if (root == null) {
                        throw new IOException(
                                "Cannot determine model root for " + modelFile
                        );
                    }

                    String program = Py2Code.toPython(root);
                    if (program == null) {
                        throw new IOException(
                                "Python code generation returned null for " + modelFile
                        );
                    }

                    String outputBaseName = ROOT_NAME
                            + "_"
                            + stripExtension(modelFile.getName());

                    File pythonFile = new File(
                            outputDirectory,
                            outputBaseName + ".py"
                    );
                    File htmlFile = new File(
                            outputDirectory,
                            outputBaseName + ".html"
                    );

                    Files.writeString(
                            pythonFile.toPath(),
                            program,
                            StandardCharsets.UTF_8
                    );

                    renderHighlightedHtml(
                            pythonFile,
                            htmlFile,
                            outputDirectory,
                            monitor
                    );

                    monitor.worked(1);
                }
                finally {
                    if (model != null && model.isLoaded()) {
                        model.unload();
                    }
                }
            }

            public void generate(IProgressMonitor progressMonitor)
                    throws MetaModelNotFoundException,
                           ModelNotFoundException,
                           IOException,
                           InterruptedException {

                IProgressMonitor monitor = progressMonitor != null
                        ? progressMonitor
                        : new NullProgressMonitor();

                File projectDirectory = resolveProjectDirectory();
                ProjectFolders folders = readProjectFolders(projectDirectory);
                File metamodelFile = resolveMetamodelFile(folders.modelDirectory);

                File codeDirectory = new File(
                        projectDirectory,
                        "src-gen/html/code"
                );
                ensureDirectory(codeDirectory);

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

                monitor.beginTask(
                        "Generating Python code",
                        models.size() + mutants.size()
                );

                try {
                    for (String modelPath : models) {
                        checkCanceled(monitor);

                        File modelFile = new File(modelPath);
                        File outputDirectory = new File(
                                codeDirectory,
                                stripExtension(modelFile.getName())
                        );

                        renderModel(
                                modelFile,
                                packages,
                                outputDirectory,
                                projectDirectory,
                                monitor,
                                false
                        );
                    }

                    Path mutantRoot = folders.mutantDirectory
                            .toPath()
                            .toAbsolutePath()
                            .normalize();

                    for (String mutantPath : mutants) {
                        checkCanceled(monitor);

                        File mutantFile = new File(mutantPath);
                        File parentFile = mutantFile.getParentFile();
                        Path parent = parentFile != null
                                ? parentFile.toPath().toAbsolutePath().normalize()
                                : mutantRoot;

                        String relative = safeRelativize(
                                mutantRoot,
                                parent
                        );

                        File outputDirectory = relative.isEmpty()
                                ? codeDirectory
                                : new File(codeDirectory, relative);

                        renderModel(
                                mutantFile,
                                packages,
                                outputDirectory,
                                projectDirectory,
                                monitor,
                                true
                        );
                    }
                }
                finally {
                    monitor.done();
                }
            }

            private String safeRelativize(Path root, Path child) {
                if (root == null || child == null) {
                    return "";
                }

                try {
                    if (!child.startsWith(root)) {
                        return "";
                    }

                    String relative = root.relativize(child).toString();
                    return relative.replace('\\', '/');
                }
                catch (IllegalArgumentException e) {
                    return "";
                }
            }

            private String stripExtension(String name) {
                if (name == null) {
                    return "";
                }

                int dot = name.lastIndexOf('.');
                return dot > 0 ? name.substring(0, dot) : name;
            }

            private void ensureDirectory(File directory) throws IOException {
                if (directory.isDirectory()) {
                    return;
                }

                if (!directory.mkdirs() && !directory.isDirectory()) {
                    throw new IOException(
                            "Cannot create directory: " + directory
                    );
                }
            }

            private void checkCanceled(IProgressMonitor monitor)
                    throws InterruptedException {

                if (monitor != null && monitor.isCanceled()) {
                    throw new InterruptedException(
                            "Python-code generation was canceled"
                    );
                }
            }

            @Override
            public Object execute(ExecutionEvent event) throws ExecutionException {
                Shell shell = event != null
                        ? HandlerUtil.getActiveShell(event)
                        : null;

                if (shell == null || shell.isDisposed()) {
                    try {
                        generate(new NullProgressMonitor());
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    catch (Exception e) {
                        throw new ExecutionException(
                                "Error generating Wodel-EDU Python code",
                                e
                        );
                    }
                    return null;
                }

                ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
                try {
                    dialog.run(true, true, new RunMutatorPyCodeWithProgress());
                }
                catch (InvocationTargetException e) {
                    Throwable cause = e.getCause() != null
                            ? e.getCause()
                            : e;
                    throw new ExecutionException(
                            "Error generating Wodel-EDU Python code",
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
                 * Wodel may already be running inside a background progress
                 * operation, so never create a nested UI dialog here.
                 */
                try {
                    generate(new NullProgressMonitor());
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException(
                            "Python-code generation was interrupted",
                            e
                    );
                }
                catch (Exception e) {
                    throw new IllegalStateException(
                            "Error generating Wodel-EDU Python code",
                            e
                    );
                }
            }
        }
    '''
}
