package wodel.dsls.runner;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;

import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.Program;
import wodel.dsls.generator.WodelStandaloneAPIGenerator;
import wodel.dsls.generator.WodelStandaloneMutatorGenerator;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Direct semantic entry point for Wodel code generation.
 *
 * <p>
 * This class deliberately bypasses the textual Xtext serializer/parser round
 * trip. An in-memory {@link MutatorEnvironment}, or an environment loaded from
 * the canonical .model XMI file, is wrapped in a synthetic EMF Resource and
 * passed directly to the existing Xtend Java generators.
 * </p>
 */
public final class WodelSemanticCodeGenerator {
	
	@Inject
	private Provider<WodelStandaloneMutatorGenerator>
	    standaloneMutatorProvider;

	@Inject
	private Provider<WodelStandaloneAPIGenerator>
	    standaloneApiProvider;

	@Inject
	private Provider<JavaIoFileSystemAccess>
	    fileAccessProvider;

	public static final class GenerationResult {
		private final Path projectDirectory;
		private final Path outputDirectory;
		private final int blocks;
		private final int commands;

		GenerationResult(Path projectDirectory, Path outputDirectory, int blocks, int commands) {
			this.projectDirectory = projectDirectory;
			this.outputDirectory = outputDirectory;
			this.blocks = blocks;
			this.commands = commands;
		}

		public Path getProjectDirectory() {
			return projectDirectory;
		}

		public Path getOutputDirectory() {
			return outputDirectory;
		}

		public int getBlocks() {
			return blocks;
		}

		public int getCommands() {
			return commands;
		}

		@Override
		public String toString() {
			return "Wodel code generation: " + blocks + " blocks, " + commands + " commands -> "
					+ outputDirectory;
		}
	}

	public GenerationResult generateStandalone(
	        MutatorEnvironment environment,
	        String projectPath)
	        throws IOException {

	    return generate(
	        environment,
	        projectPath
	    );
	}

	private GenerationResult generate(
	        MutatorEnvironment environment,
	        String projectPath)
	        throws IOException {

	    if (environment == null) {
	        throw new IllegalArgumentException(
	            "environment must not be null"
	        );
	    }

	    if (!(environment.getDefinition()
	            instanceof Program)) {

	        throw new IllegalArgumentException(
	            "The MutatorEnvironment must "
	            + "contain a Program definition"
	        );
	    }

	    Path project =
	        requireProject(projectPath);

	    Path output =
	        project.resolve("src-gen");

	    Files.createDirectories(output);

	    String logicalName =
	        project.getFileName().toString();

	    Resource resource =
	        wrap(
	            environment,
	            logicalName
	        );

	    IProject generationProject =
	        headlessProject(project);

	    /*
	     * Obtain FSA through Guice too.
	     */
	    JavaIoFileSystemAccess fsa =
	        fileAccessProvider.get();

	    fsa.setOutputPath(
	        output.toString()
	    );

	    GeneratorContext context =
	        new GeneratorContext();

	    context.setCancelIndicator(
	        CancelIndicator.NullImpl
	    );

	    /*
	     * IMPORTANT:
	     *
	     * Guice creates the standalone generator.
	     * WodelGenerator.xtend is never invoked.
	     */
	    WodelStandaloneMutatorGenerator mutator =
	        standaloneMutatorProvider.get();

	    mutator.setGenerationProject(
	        generationProject
	    );

	    mutator.doGenerate(
	        resource,
	        fsa,
	        context
	    );

	    /*
	     * Generate the standalone API too.
	     *
	     * This is required by the mutant execution
	     * pipeline.
	     */
	    WodelStandaloneAPIGenerator api =
	        standaloneApiProvider.get();

	    api.setGenerationProject(
	        generationProject
	    );

	    api.doGenerate(
	        resource,
	        fsa,
	        context
	    );

	    int commands =
	        environment.getCommands().size();

	    for (mutatorenvironment.Block block :
	            environment.getBlocks()) {

	        commands +=
	            block.getCommands().size();
	    }

	    return new GenerationResult(
	        project,
	        output,
	        environment.getBlocks().size(),
	        commands
	    );
	}
	
	public GenerationResult generateStandaloneFromModel(String modelPath, String projectPath) throws IOException {

		return generateFromModel(modelPath, projectPath);
	}

	public GenerationResult generateFromModel(String modelPath, String projectPath) throws IOException {

		if (modelPath == null || modelPath.isBlank()) {
			throw new IllegalArgumentException("modelPath must not be blank");
		}

		Path model = Paths.get(modelPath).toAbsolutePath().normalize();
		if (!Files.isRegularFile(model)) {
			throw new IOException("Cannot find Wodel XMI model: " + model);
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(MutatorenvironmentPackage.eNS_URI, MutatorenvironmentPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("model", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
				new EcoreResourceFactoryImpl());

		Resource resource = resourceSet.getResource(URI.createFileURI(model.toString()), true);
		EcoreUtil.resolveAll(resourceSet);

		if (resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof MutatorEnvironment)) {
			throw new IOException("The XMI model does not contain a MutatorEnvironment root: " + model);
		}

		Map<?, ?> unresolved = EcoreUtil.UnresolvedProxyCrossReferencer.find(resourceSet);
		if (!unresolved.isEmpty()) {
			Object first = unresolved.keySet().iterator().next();
			throw new IOException("The Wodel XMI model contains unresolved references (" + unresolved.size()
					+ "). First unresolved object: " + first);
		}

		return generate((MutatorEnvironment) resource.getContents().get(0), projectPath);
	}

	private static Resource wrap(MutatorEnvironment environment, String logicalName) {

		Resource resource = new ResourceImpl(URI.createURI("memory:/" + logicalName + ".model"));

		EcoreUtil.Copier copier = new EcoreUtil.Copier(true, true);
		EObject copy = copier.copy(environment);
		copier.copyReferences();
		resource.getContents().add(copy);
		return resource;
	}

	private static Path requireProject(String projectPath) throws IOException {
		if (projectPath == null || projectPath.isBlank()) {
			throw new IllegalArgumentException("projectPath must not be blank");
		}
		Path project = Paths.get(projectPath).toAbsolutePath().normalize();
		if (!Files.isDirectory(project)) {
			throw new IOException("Cannot find Wodel project directory: " + project);
		}
		return project;
	}

	/**
	 * The existing generators only need a very small generation-time subset of
	 * IProject (name and filesystem location). A lightweight proxy keeps direct
	 * semantic generation independent of an initialized Eclipse workspace. Runtime
	 * Java emitted by Wodel still uses the real IProject API where appropriate.
	 */
	private static IProject headlessProject(Path projectDirectory) {
		final String name = projectDirectory.getFileName().toString();
		final org.eclipse.core.runtime.IPath location = new org.eclipse.core.runtime.Path(projectDirectory.toString());
		final org.eclipse.core.runtime.IPath fullPath = new org.eclipse.core.runtime.Path("/" + name);

		final Object[] holder = new Object[1];
		IProject proxy = (IProject) Proxy.newProxyInstance(IProject.class.getClassLoader(),
				new Class<?>[] { IProject.class }, (object, method, args) -> {
					switch (method.getName()) {
					case "getName":
						return name;
					case "getLocation":
					case "getRawLocation":
						return location;
					case "getLocationURI":
						return projectDirectory.toUri();
					case "getFullPath":
					case "getProjectRelativePath":
						return fullPath;
					case "getProject":
						return holder[0];
					case "exists":
					case "isAccessible":
					case "isOpen":
						return Boolean.TRUE;
					case "hashCode":
						return System.identityHashCode(object);
					case "equals":
						return object == (args == null ? null : args[0]);
					case "toString":
						return "HeadlessIProject[" + projectDirectory + "]";
					default:
						Class<?> returnType = method.getReturnType();
						if (!returnType.isPrimitive())
							return null;
						if (returnType == boolean.class)
							return false;
						if (returnType == byte.class)
							return (byte) 0;
						if (returnType == short.class)
							return (short) 0;
						if (returnType == int.class)
							return 0;
						if (returnType == long.class)
							return 0L;
						if (returnType == float.class)
							return 0F;
						if (returnType == double.class)
							return 0D;
						if (returnType == char.class)
							return '\0';
						return null;
					}
				});
		holder[0] = proxy;
		return proxy;
	}
}
