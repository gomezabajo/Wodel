package wodel.ai.assistant.wodel.ai;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.google.inject.Injector;

import mutatorenvironment.Block;
import mutatorenvironment.Definition;
import mutatorenvironment.Library;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.Program;
import wodel.dsls.WodelStandaloneSetup;
import wodel.dsls.runner.WodelUtils;
import wodel.utils.manager.ProjectUtils;

/**
 * Shared Wodel-aware source service for conversational AI tasks.
 *
 * The service deliberately uses the Wodel Xtext parser and validator rather
 * than trying to reproduce the language rules in the assistant. Candidate
 * code is validated in an in-memory resource whose URI belongs to the active
 * Wodel project, so project-relative metamodel/import resolution behaves like
 * a normal .mutator editor resource.
 */
public final class WodelLanguageService {
    private static final Pattern NAMED_SOURCE = Pattern.compile(
        "(?i)\\b(?:program|mutator|file)\\s*(?:[:=]\\s*|named\\s+)(?:\"([^\"]+)\"|'([^']+)'|([A-Za-z0-9_./\\\\-]+(?:\\.mutator)?))");
    private static final Pattern MUTATOR_FILE = Pattern.compile(
        "(?i)([A-Za-z0-9_./\\\\-]+\\.mutator)\\b");
    private static final int MAX_METAMODEL_DESCRIPTION = 18000;

    public record Problem(Severity severity, Integer line, Integer column, String message) {
        public String format() {
            StringBuilder out = new StringBuilder(severity == null ? "ISSUE" : severity.name());
            if (line != null) out.append(" line ").append(line);
            if (column != null) out.append(':').append(column);
            out.append(": ").append(message == null ? "" : message);
            return out.toString();
        }
    }

    public record ValidationReport(List<Problem> problems) {
        public ValidationReport {
            problems = problems == null ? List.of() : List.copyOf(problems);
        }

        public boolean hasErrors() {
            return problems.stream().anyMatch(p -> p.severity() == Severity.ERROR);
        }

        public boolean hasWarnings() {
            return problems.stream().anyMatch(p -> p.severity() == Severity.WARNING);
        }

        public boolean isClean() {
            return problems.isEmpty();
        }

        public String format() {
            if (problems.isEmpty()) return "No Wodel validation errors or warnings.";
            StringBuilder out = new StringBuilder();
            for (Problem problem : problems) {
                if (out.length() > 0) out.append(System.lineSeparator());
                out.append("- ").append(problem.format());
            }
            return out.toString();
        }
    }

    public record SourceSnapshot(
            IProject project,
            IFile file,
            String source,
            MutatorEnvironment environment,
            ValidationReport validation,
            String metamodelDescription,
            String structuralSummary) {
    }

    public IProject activeProject() {
        return ProjectUtils.getActiveWodelProject().orElse(null);
    }

    public IFile resolveSource(IProject project, String utterance) throws CoreException {
        if (project == null) return null;
        List<IFile> sources = allMutatorSources(project);
        if (sources.isEmpty()) return null;

        String requested = extractRequestedSource(utterance);
        if (requested != null) {
            List<IFile> matches = matchSources(sources, requested);
            if (matches.size() == 1) return matches.get(0);
            if (matches.isEmpty()) {
                throw new IllegalArgumentException(
                    "No .mutator source matching '" + requested + "' exists in Wodel project '" + project.getName() + "'.");
            }
            throw new IllegalArgumentException(
                "The source name '" + requested + "' is ambiguous: " +
                String.join(", ", matches.stream().map(f -> f.getProjectRelativePath().toString()).toList()) + ".");
        }

        IFile active = ProjectUtils.getActiveFile().orElse(null);
        if (active != null && project.equals(active.getProject()) && "mutator".equalsIgnoreCase(active.getFileExtension())) {
            return active;
        }
        if (sources.size() == 1) return sources.get(0);
        throw new IllegalArgumentException(
            "Several .mutator sources are available. Open/select one or name it explicitly (for example, program=testFA1.mutator). Available sources: "
            + String.join(", ", sources.stream().map(f -> f.getProjectRelativePath().toString()).toList()) + ".");
    }

    public List<IFile> allMutatorSources(IProject project) throws CoreException {
        IContainer base = project.getFolder("src");
        if (!base.exists()) base = project;
        List<IFile> sources = new ArrayList<>(WodelUtils.findFilesByExtension(base, "mutator"));
        sources.sort(Comparator.comparing(f -> f.getProjectRelativePath().toString(), String.CASE_INSENSITIVE_ORDER));
        return sources;
    }

    public SourceSnapshot load(IFile file) throws Exception {
        if (file == null) throw new IllegalArgumentException("No Wodel source file was selected.");
        IProject project = file.getProject();
        String source = read(file);

        Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        IResourceValidator validator = injector.getInstance(IResourceValidator.class);
        URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
        Resource resource = resourceSet.getResource(uri, true);
        MutatorEnvironment environment = rootEnvironment(resource);
        ValidationReport validation = report(validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl));
        String metamodelDescription = environment == null
            ? ""
            : describeMetamodel(project, environment.getDefinition());
        String structuralSummary = environment == null
            ? "The source could not be converted to a complete MutatorEnvironment model."
            : describeEnvironment(environment);
        return new SourceSnapshot(project, file, source, environment, validation, metamodelDescription, structuralSummary);
    }

    public ValidationReport validateCandidate(String code, IProject project, IFile anchor) throws Exception {
        if (project == null) throw new IllegalArgumentException("No active Wodel project is available.");
        Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        IResourceValidator validator = injector.getInstance(IResourceValidator.class);

        IPath parentPath;
        if (anchor != null && anchor.getParent() != null) parentPath = anchor.getParent().getFullPath();
        else if (project.getFolder("src").exists()) parentPath = project.getFolder("src").getFullPath();
        else parentPath = project.getFullPath();

        String name = ".wodel-assistant-candidate-" + System.nanoTime() + ".mutator";
        URI candidateUri = URI.createPlatformResourceURI(parentPath.append(name).toString(), true);
        Resource resource = resourceSet.createResource(candidateUri);
        try {
            resource.load(new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8)), null);
            return report(validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl));
        } finally {
            if (resource != null) resource.unload();
        }
    }

    public void replaceSource(IFile file, String code) throws CoreException {
        if (file == null) throw new IllegalArgumentException("No Wodel source file was selected.");
        if (isDirtyInOpenEditor(file)) {
            throw new IllegalStateException(
                "The target .mutator has unsaved editor changes. Save it before using apply=true so the assistant cannot overwrite an unsaved buffer.");
        }
        ByteArrayInputStream in = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
        file.setContents(in, IFile.KEEP_HISTORY | IFile.FORCE, null);
    }

    public String describeEnvironment(MutatorEnvironment environment) {
        StringBuilder out = new StringBuilder();
        Definition definition = environment.getDefinition();
        if (definition instanceof Program program) {
            out.append("Definition: executable Wodel program\n");
            out.append("Generation: ");
            if (program.isExhaustive()) out.append("exhaustive");
            else if (program.getNum() > 0) out.append(program.getNum()).append(" mutant(s)");
            else out.append("default mutant count");
            out.append("\nOutput: ").append(program.getOutput());
            out.append("\nSource models: ").append(program.getSource() == null ? "<unspecified>" : program.getSource().getPath());
            out.append("\nMetamodel: ").append(program.getMetamodel());
            if (program.getDescription() != null && !program.getDescription().isBlank()) {
                out.append("\nDescription: ").append(program.getDescription());
            }
            if (!program.getResources().isEmpty()) {
                out.append("\nAuxiliary resources: ").append(program.getResources().size());
            }
        } else if (definition instanceof Library library) {
            out.append("Definition: Wodel library\nMetamodel: ").append(library.getMetamodel());
        } else {
            out.append("Definition: <unknown>");
        }

        out.append("\nTop-level commands: ").append(environment.getCommands().size());
        out.append("\nMutation blocks: ").append(environment.getBlocks().size());
        for (Block block : environment.getBlocks()) {
            out.append("\n- ").append(block.getName());
            if (block.getDescription() != null && !block.getDescription().isBlank()) {
                out.append(" - ").append(block.getDescription());
            }
            out.append(" [").append(block.getCommands().size()).append(" command(s)]");
            List<String> commandKinds = new ArrayList<>();
            for (Mutator mutator : block.getCommands()) {
                String kind = mutator.eClass().getName();
                if (!commandKinds.contains(kind)) commandKinds.add(kind);
            }
            if (!commandKinds.isEmpty()) out.append(" types=").append(String.join(", ", commandKinds));
            if (!block.getFrom().isEmpty()) {
                out.append(" from=").append(String.join(", ", block.getFrom().stream().map(Block::getName).toList()));
            }
        }
        return out.toString();
    }


    private boolean isDirtyInOpenEditor(IFile file) {
        if (!PlatformUI.isWorkbenchRunning()) return false;
        var display = PlatformUI.getWorkbench().getDisplay();
        if (display == null || display.isDisposed()) return false;
        AtomicBoolean dirty = new AtomicBoolean(false);
        Runnable check = () -> {
            var window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            if (window == null) return;
            IWorkbenchPage page = window.getActivePage();
            if (page == null) return;
            for (IEditorReference reference : page.getEditorReferences()) {
                IEditorPart editor = reference.getEditor(false);
                if (editor == null || !editor.isDirty()) continue;
                IFile editorFile = editor.getEditorInput().getAdapter(IFile.class);
                if (file.equals(editorFile)) {
                    dirty.set(true);
                    return;
                }
            }
        };
        if (display.getThread() == Thread.currentThread()) check.run();
        else display.syncExec(check);
        return dirty.get();
    }

    private String read(IFile file) throws CoreException, IOException {
        try (InputStream in = file.getContents(true)) {
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    private MutatorEnvironment rootEnvironment(Resource resource) {
        if (resource == null || resource.getContents().isEmpty()) return null;
        EObject root = resource.getContents().get(0);
        return root instanceof MutatorEnvironment environment ? environment : null;
    }

    private ValidationReport report(List<Issue> issues) {
        List<Problem> problems = new ArrayList<>();
        if (issues != null) {
            for (Issue issue : issues) {
                if (issue.getSeverity() != Severity.ERROR && issue.getSeverity() != Severity.WARNING) continue;
                problems.add(new Problem(issue.getSeverity(), issue.getLineNumber(), issue.getColumn(), issue.getMessage()));
            }
        }
        return new ValidationReport(problems);
    }

    private String extractRequestedSource(String utterance) {
        if (utterance == null || utterance.isBlank()) return null;
        for (Pattern pattern : List.of(NAMED_SOURCE, MUTATOR_FILE)) {
            Matcher matcher = pattern.matcher(utterance);
            if (!matcher.find()) continue;
            for (int i = 1; i <= matcher.groupCount(); i++) {
                String value = matcher.group(i);
                if (value != null && !value.isBlank()) return value.trim();
            }
        }
        return null;
    }

    private List<IFile> matchSources(List<IFile> sources, String requested) {
        String q = normalize(requested);
        String qNoExt = q.endsWith(".mutator") ? q.substring(0, q.length() - ".mutator".length()) : q;
        return sources.stream().filter(file -> {
            String rel = normalize(file.getProjectRelativePath().toString());
            String name = normalize(file.getName());
            String noExt = name.endsWith(".mutator") ? name.substring(0, name.length() - ".mutator".length()) : name;
            return rel.equals(q) || name.equals(q) || noExt.equals(qNoExt) || rel.endsWith("/" + q);
        }).toList();
    }

    private String normalize(String text) {
        return text.replace('\\', '/').toLowerCase(Locale.ROOT).replaceFirst("^/+", "");
    }

    private String describeMetamodel(IProject project, Definition definition) {
        if (definition == null || definition.getMetamodel() == null || definition.getMetamodel().isBlank()) return "";
        try {
            URI uri = resolveMetamodelUri(project, definition.getMetamodel());
            if (uri == null) return "Metamodel path: " + definition.getMetamodel() + " (not resolved by the assistant).";
            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
            ResourceSet rs = new ResourceSetImpl();
            Resource resource = rs.getResource(uri, true);
            StringBuilder out = new StringBuilder();
            for (EObject object : resource.getContents()) {
                if (object instanceof EPackage ePackage) appendPackage(out, ePackage, "");
            }
            if (out.length() == 0) return "Metamodel path: " + definition.getMetamodel();
            if (out.length() > MAX_METAMODEL_DESCRIPTION) {
                return out.substring(0, MAX_METAMODEL_DESCRIPTION) + "\n... [metamodel description truncated]";
            }
            return out.toString();
        } catch (Exception e) {
            return "Metamodel path: " + definition.getMetamodel() + " (description unavailable: " + safeMessage(e) + ").";
        }
    }

    private URI resolveMetamodelUri(IProject project, String value) {
        String normalized = value.trim().replace('\\', '/');
        normalized = normalized.replace("/[@**@]/", "/" + project.getName() + "/");
        if (normalized.startsWith("platform:/resource/") || normalized.startsWith("file:")) {
            return URI.createURI(normalized);
        }
        String projectPrefix = "/" + project.getName() + "/";
        if (normalized.startsWith(projectPrefix)) {
            return URI.createPlatformResourceURI(normalized, true);
        }

        Path candidate;
        try {
            candidate = Paths.get(normalized);
            if (candidate.isAbsolute() && Files.isRegularFile(candidate)) return URI.createFileURI(candidate.toString());
        } catch (Exception ignored) {
        }

        String relative = normalized.replaceFirst("^/+", "");
        IFile workspaceFile = project.getFile(relative);
        if (workspaceFile.exists()) {
            return URI.createPlatformResourceURI(workspaceFile.getFullPath().toString(), true);
        }
        IFile modelFallback = project.getFile("data/model/" + Path.of(relative).getFileName());
        if (modelFallback.exists()) {
            return URI.createPlatformResourceURI(modelFallback.getFullPath().toString(), true);
        }

        IPath workspacePath = org.eclipse.core.runtime.Path.fromPortableString(normalized);
        if (workspacePath.isAbsolute()) {
            IFile absoluteWorkspaceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(workspacePath);
            if (absoluteWorkspaceFile.exists()) {
                return URI.createPlatformResourceURI(absoluteWorkspaceFile.getFullPath().toString(), true);
            }
        }
        return null;
    }

    private void appendPackage(StringBuilder out, EPackage ePackage, String indent) {
        out.append(indent).append("Package ").append(ePackage.getName())
            .append(" (nsURI=").append(ePackage.getNsURI()).append(")\n");
        for (EClassifier classifier : ePackage.getEClassifiers()) {
            if (!(classifier instanceof EClass eClass)) continue;
            out.append(indent).append("  Class ").append(eClass.getName());
            if (eClass.isAbstract()) out.append(" [abstract]");
            if (!eClass.getESuperTypes().isEmpty()) {
                out.append(" extends ").append(String.join(", ", eClass.getESuperTypes().stream().map(EClass::getName).toList()));
            }
            out.append('\n');
            for (EAttribute attribute : eClass.getEAttributes()) {
                out.append(indent).append("    attribute ").append(attribute.getName())
                    .append(": ").append(attribute.getEAttributeType() == null ? "?" : attribute.getEAttributeType().getName())
                    .append(" [").append(cardinality(attribute.getLowerBound(), attribute.getUpperBound())).append("]\n");
            }
            for (EReference reference : eClass.getEReferences()) {
                out.append(indent).append("    reference ").append(reference.getName())
                    .append(" -> ").append(reference.getEReferenceType() == null ? "?" : reference.getEReferenceType().getName())
                    .append(" [").append(cardinality(reference.getLowerBound(), reference.getUpperBound())).append("]")
                    .append(reference.isContainment() ? " containment" : "")
                    .append('\n');
            }
        }
        for (EPackage child : ePackage.getESubpackages()) appendPackage(out, child, indent + "  ");
    }

    private String cardinality(int lower, int upper) {
        return lower + ".." + (upper < 0 ? "*" : Integer.toString(upper));
    }

    private String safeMessage(Exception e) {
        String message = e.getMessage();
        return message == null || message.isBlank() ? e.getClass().getSimpleName() : message;
    }
}
