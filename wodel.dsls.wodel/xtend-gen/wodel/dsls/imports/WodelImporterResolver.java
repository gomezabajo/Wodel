package wodel.dsls.imports;

import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import mutatorenvironment.Block;
import mutatorenvironment.Definition;
import mutatorenvironment.Library;
import mutatorenvironment.Load;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

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
@SuppressWarnings("all")
public class WodelImporterResolver {
  private static class LibraryContent {
    private final List<Mutator> commands = new ArrayList<Mutator>();

    private final List<Block> blocks = new ArrayList<Block>();

    public void addAll(final WodelImporterResolver.LibraryContent other) {
      this.commands.addAll(other.commands);
      this.blocks.addAll(other.blocks);
    }
  }

  /**
   * Returns true when the supplied resource represents
   * a Wodel library.
   */
  public boolean isLibrary(final Resource resource) {
    final MutatorEnvironment environment = this.getEnvironment(resource);
    Definition _definition = environment.getDefinition();
    return (_definition instanceof Library);
  }

  /**
   * Returns true when the supplied resource represents
   * an executable Wodel program.
   */
  public boolean isProgram(final Resource resource) {
    final MutatorEnvironment environment = this.getEnvironment(resource);
    Definition _definition = environment.getDefinition();
    return (_definition instanceof Program);
  }

  private void checkUniqueBlockNames(final List<Block> blocks) {
    final Set<String> names = new LinkedHashSet<String>();
    for (final Block block : blocks) {
      boolean _add = names.add(block.getName());
      boolean _not = (!_add);
      if (_not) {
        String _name = block.getName();
        String _plus = ("Duplicate Wodel block name \'" + _name);
        String _plus_1 = (_plus + "\' after resolving library imports.");
        throw new IllegalArgumentException(_plus_1);
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
  public Resource resolve(final Resource sourceResource) {
    if ((sourceResource == null)) {
      throw new IllegalArgumentException(
        "Cannot resolve imports from a null resource.");
    }
    final MutatorEnvironment sourceEnvironment = this.getEnvironment(sourceResource);
    Definition _definition = sourceEnvironment.getDefinition();
    if ((_definition instanceof Library)) {
      String _resourceName = this.resourceName(sourceResource);
      String _plus = ("Cannot generate a Wodel library directly: " + _resourceName);
      throw new IllegalArgumentException(_plus);
    }
    Definition _definition_1 = sourceEnvironment.getDefinition();
    boolean _not = (!(_definition_1 instanceof Program));
    if (_not) {
      String _resourceName_1 = this.resourceName(sourceResource);
      String _plus_1 = ("The Wodel resource does not contain a Program: " + _resourceName_1);
      throw new IllegalArgumentException(_plus_1);
    }
    boolean _isEmpty = sourceEnvironment.getLoad().isEmpty();
    if (_isEmpty) {
      return sourceResource;
    }
    this.checkResourceErrors(sourceResource);
    EcoreUtil.resolveAll(sourceResource);
    this.checkResourceErrors(sourceResource);
    Definition _definition_2 = sourceEnvironment.getDefinition();
    final Program program = ((Program) _definition_2);
    MutatorEnvironment _copy = EcoreUtil.<MutatorEnvironment>copy(sourceEnvironment);
    final MutatorEnvironment resolvedEnvironment = ((MutatorEnvironment) _copy);
    resolvedEnvironment.getCommands().clear();
    resolvedEnvironment.getBlocks().clear();
    resolvedEnvironment.getLoad().clear();
    final Set<URI> visited = new LinkedHashSet<URI>();
    final List<URI> stack = new ArrayList<URI>();
    final List<Mutator> allCommands = new ArrayList<Mutator>();
    final List<Block> allBlocks = new ArrayList<Block>();
    EList<Load> _load = sourceEnvironment.getLoad();
    for (final Load load : _load) {
      {
        final WodelImporterResolver.LibraryContent content = this.resolveLibrary(sourceResource, 
          load.getFile(), 
          program.getMetamodel(), visited, stack);
        allCommands.addAll(content.commands);
        allBlocks.addAll(content.blocks);
      }
    }
    allCommands.addAll(sourceEnvironment.getCommands());
    allBlocks.addAll(sourceEnvironment.getBlocks());
    if (((!allCommands.isEmpty()) && (!allBlocks.isEmpty()))) {
      throw new IllegalArgumentException(
        ((("A Wodel program cannot mix imported top-level commands " + 
          "and blocks. Import command libraries from programs using ") + 
          "\'with commands\', and block libraries from programs using ") + "\'with blocks\'."));
    }
    this.checkUniqueBlockNames(allBlocks);
    resolvedEnvironment.getCommands().addAll(
      EcoreUtil.<Mutator>copyAll(allCommands));
    resolvedEnvironment.getBlocks().addAll(
      EcoreUtil.<Block>copyAll(allBlocks));
    URI _uRI = sourceResource.getURI();
    final ResourceImpl resolvedResource = new ResourceImpl(_uRI);
    resolvedResource.getContents().add(resolvedEnvironment);
    return resolvedResource;
  }

  /**
   * Recursively resolves one library.
   * 
   * Returned Mutators are copies and therefore have no
   * container until they are inserted in the effective
   * MutatorEnvironment.
   */
  private WodelImporterResolver.LibraryContent resolveLibrary(final Resource importingResource, final String importPath, final String expectedMetamodel, final Set<URI> visited, final List<URI> stack) {
    final URI importedURI = this.resolveImportURI(importingResource, importPath);
    boolean _contains = stack.contains(importedURI);
    if (_contains) {
      String _formatCycle = this.formatCycle(stack, importedURI);
      String _plus = ("Circular Wodel library import detected: " + _formatCycle);
      throw new IllegalStateException(_plus);
    }
    boolean _contains_1 = visited.contains(importedURI);
    if (_contains_1) {
      return new WodelImporterResolver.LibraryContent();
    }
    stack.add(importedURI);
    try {
      final Resource importedResource = this.loadResource(importingResource, importedURI);
      final MutatorEnvironment importedEnvironment = this.getEnvironment(importedResource);
      Definition _definition = importedEnvironment.getDefinition();
      boolean _not = (!(_definition instanceof Library));
      if (_not) {
        throw new IllegalArgumentException(
          (("Wodel import \'" + importPath) + "\' does not reference a library."));
      }
      Definition _definition_1 = importedEnvironment.getDefinition();
      final Library library = ((Library) _definition_1);
      String _metamodel = library.getMetamodel();
      boolean _notEquals = (!Objects.equals(expectedMetamodel, _metamodel));
      if (_notEquals) {
        String _metamodel_1 = library.getMetamodel();
        String _plus_1 = ((((("Metamodel mismatch in imported Wodel library \'" + importPath) + "\'. The program uses \'") + expectedMetamodel) + "\', whereas the library uses \'") + _metamodel_1);
        String _plus_2 = (_plus_1 + "\'.");
        throw new IllegalArgumentException(_plus_2);
      }
      boolean _isEmpty = importedEnvironment.getConstraints().isEmpty();
      boolean _not_1 = (!_isEmpty);
      if (_not_1) {
        throw new IllegalArgumentException(
          ((("Wodel library \'" + importPath) + "\' contains constraints. Imported constraints ") + 
            "are currently not supported."));
      }
      final WodelImporterResolver.LibraryContent result = new WodelImporterResolver.LibraryContent();
      EList<Load> _load = importedEnvironment.getLoad();
      for (final Load load : _load) {
        result.addAll(
          this.resolveLibrary(importedResource, 
            load.getFile(), expectedMetamodel, visited, stack));
      }
      result.commands.addAll(
        importedEnvironment.getCommands());
      result.blocks.addAll(
        importedEnvironment.getBlocks());
      visited.add(importedURI);
      return result;
    } finally {
      int _size = stack.size();
      int _minus = (_size - 1);
      stack.remove(_minus);
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
  private Resource loadResource(final Resource importingResource, final URI importedURI) {
    final ResourceSet resourceSet = importingResource.getResourceSet();
    if ((resourceSet == null)) {
      throw new IllegalStateException(
        ((("Cannot resolve Wodel import \'" + importedURI) + "\' because the importing resource is not attached ") + 
          "to an EMF ResourceSet."));
    }
    Resource importedResource = null;
    try {
      importedResource = resourceSet.getResource(importedURI, true);
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException exception = (RuntimeException)_t;
        String _resourceName = this.resourceName(importingResource);
        String _plus = ((("Cannot load Wodel library \'" + importedURI) + "\' imported from \'") + _resourceName);
        String _plus_1 = (_plus + "\'.");
        throw new IllegalStateException(_plus_1, exception);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    if ((importedResource == null)) {
      String _resourceName = this.resourceName(importingResource);
      String _plus = ((("Cannot load Wodel library \'" + importedURI) + "\' imported from \'") + _resourceName);
      String _plus_1 = (_plus + "\'.");
      throw new IllegalStateException(_plus_1);
    }
    this.checkResourceErrors(importedResource);
    EcoreUtil.resolveAll(importedResource);
    this.checkResourceErrors(importedResource);
    return importedResource;
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
  private URI resolveImportURI(final Resource importingResource, final String importPath) {
    if (((importPath == null) || importPath.trim().isEmpty())) {
      String _resourceName = this.resourceName(importingResource);
      String _plus = ("Wodel import path cannot be empty in resource \'" + _resourceName);
      String _plus_1 = (_plus + "\'.");
      throw new IllegalArgumentException(_plus_1);
    }
    URI importURI = null;
    try {
      importURI = URI.createURI(importPath);
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException exception = (IllegalArgumentException)_t;
        String _resourceName_1 = this.resourceName(importingResource);
        String _plus_2 = ((("Invalid Wodel import URI \'" + importPath) + "\' in resource \'") + _resourceName_1);
        String _plus_3 = (_plus_2 + "\'.");
        throw new IllegalArgumentException(_plus_3, exception);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    boolean _hasFragment = importURI.hasFragment();
    if (_hasFragment) {
      throw new IllegalArgumentException(
        (("Wodel library imports cannot contain URI fragments: \'" + importPath) + "\'."));
    }
    boolean _isRelative = importURI.isRelative();
    boolean _not = (!_isRelative);
    if (_not) {
      return importURI;
    }
    final URI baseURI = importingResource.getURI();
    if ((baseURI == null)) {
      throw new IllegalStateException(
        (("Cannot resolve relative Wodel import \'" + importPath) + "\' because the importing resource has no URI."));
    }
    return importURI.resolve(baseURI.trimFragment());
  }

  /**
   * Returns the MutatorEnvironment root of a Wodel resource.
   */
  private MutatorEnvironment getEnvironment(final Resource resource) {
    if ((resource == null)) {
      throw new IllegalArgumentException(
        "Wodel resource cannot be null.");
    }
    boolean _isEmpty = resource.getContents().isEmpty();
    if (_isEmpty) {
      String _resourceName = this.resourceName(resource);
      String _plus = ("Wodel resource \'" + _resourceName);
      String _plus_1 = (_plus + "\' is empty.");
      throw new IllegalArgumentException(_plus_1);
    }
    final EObject root = resource.getContents().get(0);
    if ((!(root instanceof MutatorEnvironment))) {
      String _resourceName_1 = this.resourceName(resource);
      String _plus_2 = ("Resource \'" + _resourceName_1);
      String _plus_3 = (_plus_2 + "\' does not contain a MutatorEnvironment root.");
      throw new IllegalArgumentException(_plus_3);
    }
    return ((MutatorEnvironment) root);
  }

  /**
   * Converts Xtext/EMF resource errors into a clear exception.
   * 
   * Later I recommend moving these diagnostics into
   * WodelValidator as proper Eclipse/Xtext validation errors.
   * For the resolver itself, however, failing fast is useful.
   */
  private void checkResourceErrors(final Resource resource) {
    boolean _isEmpty = resource.getErrors().isEmpty();
    if (_isEmpty) {
      return;
    }
    final Function1<Resource.Diagnostic, String> _function = (Resource.Diagnostic it) -> {
      return it.getMessage();
    };
    final String details = IterableExtensions.join(ListExtensions.<Resource.Diagnostic, String>map(resource.getErrors(), _function), "; ");
    String _resourceName = this.resourceName(resource);
    String _plus = ("Errors were found while loading Wodel resource \'" + _resourceName);
    String _plus_1 = (_plus + "\': ");
    String _plus_2 = (_plus_1 + details);
    throw new IllegalStateException(_plus_2);
  }

  /**
   * Produces a readable circular-import chain.
   */
  private String formatCycle(final List<URI> stack, final URI repeatedURI) {
    final ArrayList<URI> cycle = new ArrayList<URI>();
    final int firstIndex = stack.indexOf(repeatedURI);
    if ((firstIndex >= 0)) {
      cycle.addAll(
        stack.subList(firstIndex, stack.size()));
    } else {
      cycle.addAll(stack);
    }
    cycle.add(repeatedURI);
    final Function1<URI, String> _function = (URI it) -> {
      return this.shortName(it);
    };
    return IterableExtensions.join(ListExtensions.<URI, String>map(cycle, _function), " -> ");
  }

  /**
   * Small readable representation of a URI for diagnostics.
   */
  private String shortName(final URI uri) {
    if ((uri == null)) {
      return "<unknown>";
    }
    final String lastSegment = uri.lastSegment();
    if ((lastSegment != null)) {
      return lastSegment;
    }
    return uri.toString();
  }

  /**
   * Returns a useful resource name for diagnostics.
   */
  private String resourceName(final Resource resource) {
    if ((resource == null)) {
      return "<null>";
    }
    URI _uRI = resource.getURI();
    boolean _tripleEquals = (_uRI == null);
    if (_tripleEquals) {
      return "<unknown>";
    }
    final String lastSegment = resource.getURI().lastSegment();
    if ((lastSegment != null)) {
      return lastSegment;
    }
    return resource.getURI().toString();
  }
}
