package wodel.dsls.imports

import com.google.inject.Singleton
import java.util.ArrayList
import java.util.LinkedHashSet
import java.util.List
import java.util.Set
import mutatorenvironment.Library
import mutatorenvironment.Mutator
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Program
import mutatorenvironment.Block
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.eclipse.emf.ecore.util.EcoreUtil

/**
 * Resolves Wodel library imports and builds an effective
 * MutatorEnvironment for code generation.
 *
 * <p>
 * The resolver does not modify the original Xtext resource.
 * Instead, it creates a deep copy of the importing program and
 * inserts deep copies of all imported mutations before the local
 * mutations.
 * </p>
 *
 * <p>
 * Initial semantics:
 * </p>
 *
 * <ul>
 *   <li>Only a Program may be resolved for generation.</li>
 *   <li>Only Library files may be imported.</li>
 *   <li>Libraries contain commands, not blocks.</li>
 *   <li>Libraries do not contribute constraints.</li>
 *   <li>Libraries may import other libraries.</li>
 *   <li>Imported commands precede local commands.</li>
 *   <li>Imports preserve declaration order.</li>
 *   <li>A library is included only once.</li>
 *   <li>Circular imports are rejected.</li>
 *   <li>Program and library metamodel identifiers must match.</li>
 * </ul>
 * 
 * @author Pablo Gomez-Abajo
 */
@Singleton
class WodelImporterResolver {

	private static class LibraryContent {

		val List<Mutator> commands = new ArrayList<Mutator>
		val List<Block> blocks = new ArrayList<Block>

		def void addAll(LibraryContent other) {
			commands.addAll(other.commands)
			blocks.addAll(other.blocks)
		}
	}

		/**
	 * Returns true when the supplied resource represents
	 * a Wodel library.
	 */
	def boolean isLibrary(Resource resource) {
		val environment = getEnvironment(resource)

		return environment.definition instanceof Library
	}

	/**
	 * Returns true when the supplied resource represents
	 * an executable Wodel program.
	 */
	def boolean isProgram(Resource resource) {
		val environment = getEnvironment(resource)

		return environment.definition instanceof Program
	}

	private def void checkUniqueBlockNames(
		List<Block> blocks
	) {

		val Set<String> names = new LinkedHashSet<String>

		for (block : blocks) {

			if (!names.add(block.name)) {
				throw new IllegalArgumentException(
					"Duplicate Wodel block name '" + block.name + "' after resolving library imports."
				)
			}
		}
	}

	/**
	 * Resolves all imports of an executable Wodel program.
	 * 
	 * The original Resource is left untouched.
	 * 
	 * If the program has no imports, the original resource
	 * is returned directly.
	 * 
	 * Otherwise, a synthetic Resource containing the
	 * flattened program is returned.
	 */
	def Resource resolve(Resource sourceResource) {

		if (sourceResource === null) {
			throw new IllegalArgumentException(
				"Cannot resolve imports from a null resource."
			)
		}

		val sourceEnvironment = getEnvironment(sourceResource)

		if (sourceEnvironment.definition instanceof Library) {
			throw new IllegalArgumentException(
				"Cannot generate a Wodel library directly: " + resourceName(sourceResource)
			)
		}

		if (!(sourceEnvironment.definition instanceof Program)) {
			throw new IllegalArgumentException(
				"The Wodel resource does not contain a Program: " + resourceName(sourceResource)
			)
		}

		if (sourceEnvironment.load.empty) {
			return sourceResource
		}

		checkResourceErrors(sourceResource)

		EcoreUtil.resolveAll(sourceResource)

		checkResourceErrors(sourceResource)

		val program = sourceEnvironment.definition as Program

		/*
		 * Copy the general structure of the original environment.
		 * 
		 * We will replace blocks/commands below with a single
		 * flattened copy.
		 */
		val resolvedEnvironment = EcoreUtil.copy(sourceEnvironment) as MutatorEnvironment

		resolvedEnvironment.commands.clear
		resolvedEnvironment.blocks.clear
		resolvedEnvironment.load.clear

		val Set<URI> visited = new LinkedHashSet<URI>

		val List<URI> stack = new ArrayList<URI>

		/*
		 * IMPORTANT:
		 * 
		 * Keep the ORIGINAL objects here. We will perform one
		 * EcoreUtil.copyAll operation later. This allows EMF to
		 * correctly remap references such as:
		 * 
		 *     block B from A
		 */
		val List<Mutator> allCommands = new ArrayList<Mutator>

		val List<Block> allBlocks = new ArrayList<Block>

		for (load : sourceEnvironment.load) {

			val content = resolveLibrary(
				sourceResource,
				load.file,
				program.metamodel,
				visited,
				stack
			)

			allCommands.addAll(content.commands)
			allBlocks.addAll(content.blocks)
		}

		/*
		 * Local definitions come AFTER imported definitions.
		 */
		allCommands.addAll(sourceEnvironment.commands)
		allBlocks.addAll(sourceEnvironment.blocks)

		/*
		 * Wodel currently treats top-level commands and blocks as
		 * two different generation modes. Do not allow an effective
		 * program to contain both.
		 */
		if (!allCommands.empty && !allBlocks.empty) {
			throw new IllegalArgumentException(
				"A Wodel program cannot mix imported top-level commands " +
					"and blocks. Import command libraries from programs using " +
					"'with commands', and block libraries from programs using " + "'with blocks'."
			)
		}

		/*
		 * Block names must be unique because they become generated
		 * Java method names and are also used by 'from'.
		 */
		checkUniqueBlockNames(allBlocks)

		/*
		 * Copy everything in a SINGLE operation.
		 * 
		 * This is particularly important for Block.from references.
		 */
		resolvedEnvironment.commands.addAll(
			EcoreUtil.copyAll(allCommands)
		)

		resolvedEnvironment.blocks.addAll(
			EcoreUtil.copyAll(allBlocks)
		)

		val resolvedResource = new ResourceImpl(sourceResource.URI)

		resolvedResource.contents.add(
			resolvedEnvironment
		)

		return resolvedResource
	}

	/**
	 * Recursively resolves one library.
	 * 
	 * Returned Mutators are copies and therefore have no
	 * container until they are inserted in the effective
	 * MutatorEnvironment.
	 */
	private def LibraryContent resolveLibrary(
		Resource importingResource,
		String importPath,
		String expectedMetamodel,
		Set<URI> visited,
		List<URI> stack
	) {

		val importedURI = resolveImportURI(importingResource, importPath)

		if (stack.contains(importedURI)) {
			throw new IllegalStateException(
				"Circular Wodel library import detected: " + formatCycle(stack, importedURI)
			)
		}

		/*
		 * Already imported through some other dependency.
		 */
		if (visited.contains(importedURI)) {
			return new LibraryContent
		}

		stack.add(importedURI)

		try {

			val importedResource = loadResource(importingResource, importedURI)

			val importedEnvironment = getEnvironment(importedResource)

			if (!(importedEnvironment.definition instanceof Library)) {
				throw new IllegalArgumentException(
					"Wodel import '" + importPath + "' does not reference a library."
				)
			}

			val library = importedEnvironment.definition as Library

			if (expectedMetamodel != library.metamodel) {
				throw new IllegalArgumentException(
					"Metamodel mismatch in imported Wodel library '" + importPath + "'. The program uses '" +
						expectedMetamodel + "', whereas the library uses '" + library.metamodel + "'."
				)
			}

			/*
			 * I would still postpone constraint reuse until its
			 * semantics have been explicitly defined.
			 */
			if (!importedEnvironment.constraints.empty) {
				throw new IllegalArgumentException(
					"Wodel library '" + importPath + "' contains constraints. Imported constraints " +
						"are currently not supported."
				)
			}

			val result = new LibraryContent

			/*
			 * First resolve libraries imported by this library.
			 */
			for (load : importedEnvironment.load) {

				result.addAll(
					resolveLibrary(
						importedResource,
						load.file,
						expectedMetamodel,
						visited,
						stack
					)
				)
			}

			/*
			 * IMPORTANT:
			 * 
			 * Do NOT copy here. Accumulate original objects and
			 * copy all blocks together later.
			 */
			result.commands.addAll(
				importedEnvironment.commands
			)

			result.blocks.addAll(
				importedEnvironment.blocks
			)

			visited.add(importedURI)

			return result

		} finally {

			stack.remove(stack.size - 1)
		}
	}

	/**
	 * Loads an imported Xtext resource using the SAME
	 * ResourceSet as the importing resource.
	 * 
	 * This is important because that ResourceSet already knows
	 * how to load .mutator files and contains the Xtext/EMF
	 * environment used by the current build.
	 */
	private def Resource loadResource(
		Resource importingResource,
		URI importedURI
	) {

		val resourceSet = importingResource.resourceSet

		if (resourceSet === null) {
			throw new IllegalStateException(
				"Cannot resolve Wodel import '" + importedURI + "' because the importing resource is not attached " +
					"to an EMF ResourceSet."
			)
		}

		var Resource importedResource = null

		try {

			importedResource = resourceSet.getResource(importedURI, true)

		} catch (RuntimeException exception) {

			throw new IllegalStateException(
				"Cannot load Wodel library '" + importedURI + "' imported from '" +
					resourceName(importingResource) + "'.",
				exception
			)
		}

		if (importedResource === null) {
			throw new IllegalStateException(
				"Cannot load Wodel library '" + importedURI + "' imported from '" +
					resourceName(importingResource) + "'."
			)
		}

		/*
		 * First report ordinary parser errors.
		 */
		checkResourceErrors(importedResource)

		/*
		 * Then resolve Xtext cross-references and proxies.
		 */
		EcoreUtil.resolveAll(importedResource)

		/*
		 * Proxy resolution may expose linking errors, so check
		 * the resource once again.
		 */
		checkResourceErrors(importedResource)

		return importedResource
	}

	/**
	 * Resolves an import path relative to the resource containing
	 * the import statement.
	 * 
	 * Example:
	 * 
	 *   platform:/resource/my.project/mutations/main.mutator
	 * 
	 * importing:
	 * 
	 *   common.mutator
	 * 
	 * resolves to:
	 * 
	 *   platform:/resource/my.project/mutations/common.mutator
	 */
	private def URI resolveImportURI(
		Resource importingResource,
		String importPath
	) {

		if (importPath === null || importPath.trim.empty) {
			throw new IllegalArgumentException(
				"Wodel import path cannot be empty in resource '" + resourceName(importingResource) + "'."
			)
		}

		var URI importURI = null

		try {

			importURI = URI.createURI(importPath)

		} catch (IllegalArgumentException exception) {

			throw new IllegalArgumentException(
				"Invalid Wodel import URI '" + importPath + "' in resource '" + resourceName(importingResource) + "'.",
				exception
			)
		}

		if (importURI.hasFragment()) {
			throw new IllegalArgumentException(
				"Wodel library imports cannot contain URI fragments: '" + importPath + "'."
			)
		}

		/*
		 * Absolute URIs such as:
		 * 
		 *     platform:/resource/...
		 *     file:/...
		 * 
		 * are returned unchanged.
		 */
		if (!importURI.isRelative()) {
			return importURI
		}

		val baseURI = importingResource.URI

		if (baseURI === null) {
			throw new IllegalStateException(
				"Cannot resolve relative Wodel import '" + importPath + "' because the importing resource has no URI."
			)
		}

		return importURI.resolve(baseURI.trimFragment())
	}

	/**
	 * Returns the MutatorEnvironment root of a Wodel resource.
	 */
	private def MutatorEnvironment getEnvironment(
		Resource resource
	) {

		if (resource === null) {
			throw new IllegalArgumentException(
				"Wodel resource cannot be null."
			)
		}

		if (resource.contents.empty) {
			throw new IllegalArgumentException(
				"Wodel resource '" + resourceName(resource) + "' is empty."
			)
		}

		val root = resource.contents.get(0)

		if (!(root instanceof MutatorEnvironment)) {
			throw new IllegalArgumentException(
				"Resource '" + resourceName(resource) + "' does not contain a MutatorEnvironment root."
			)
		}

		return root as MutatorEnvironment
	}

	/**
	 * Converts Xtext/EMF resource errors into a clear exception.
	 * 
	 * Later I recommend moving these diagnostics into
	 * WodelValidator as proper Eclipse/Xtext validation errors.
	 * For the resolver itself, however, failing fast is useful.
	 */
	private def void checkResourceErrors(Resource resource) {

		if (resource.errors.empty) {
			return
		}

		val details = resource.errors.map[message].join("; ")

		throw new IllegalStateException(
			"Errors were found while loading Wodel resource '" + resourceName(resource) + "': " + details
		)
	}

	/**
	 * Produces a readable circular-import chain.
	 */
	private def String formatCycle(
		List<URI> stack,
		URI repeatedURI
	) {

		val cycle = new ArrayList<URI>

		val firstIndex = stack.indexOf(repeatedURI)

		if (firstIndex >= 0) {
			cycle.addAll(
				stack.subList(firstIndex, stack.size)
			)
		} else {
			cycle.addAll(stack)
		}

		cycle.add(repeatedURI)

		return cycle.map[shortName].join(" -> ")
	}

	/**
	 * Small readable representation of a URI for diagnostics.
	 */
	private def String shortName(URI uri) {

		if (uri === null) {
			return "<unknown>"
		}

		val lastSegment = uri.lastSegment

		if (lastSegment !== null) {
			return lastSegment
		}

		return uri.toString
	}

	/**
	 * Returns a useful resource name for diagnostics.
	 */
	private def String resourceName(Resource resource) {

		if (resource === null) {
			return "<null>"
		}

		if (resource.URI === null) {
			return "<unknown>"
		}

		val lastSegment = resource.URI.lastSegment

		if (lastSegment !== null) {
			return lastSegment
		}

		return resource.URI.toString
	}
}
