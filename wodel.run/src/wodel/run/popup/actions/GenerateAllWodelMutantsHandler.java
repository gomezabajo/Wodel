package wodel.run.popup.actions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.random.RandomGenerator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.WorkspaceJob;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import org.eclipse.swt.widgets.Shell;

import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import wodel.utils.manager.IMutatorExecutor;
import wodel.utils.manager.ProjectUtils;
import wodel.utils.manager.WodelUtils;
import wodel.utils.manager.MutatorUtils.MutationResults;


public class GenerateAllWodelMutantsHandler
        extends AbstractHandler {

    private static final String PLUGIN_ID =
        "wodel.dsls.wodel.ui";

    @Override
    public Object execute(ExecutionEvent event)
            throws ExecutionException {

        IProject project =
            getSelectedProject(event);

        if (project == null ||
            !ProjectUtils.isWodelProject(project)) {

            MessageDialog.openInformation(
                HandlerUtil.getActiveShell(event),
                "Wodel",
                "Please select a Wodel project."
            );

            return null;
        }

        /*
         * Remember this project as the active Wodel project.
         * This is useful for the other project-aware Wodel
         * utilities too.
         */
        ProjectUtils.setActiveWindowProject(project);

        final IProject wodelProject = project;

        WorkspaceJob job =
            new WorkspaceJob(
                "Generate all Wodel mutants - "
                + wodelProject.getName()
            ) {

                @Override
                public IStatus runInWorkspace(
                        IProgressMonitor monitor) {

                    SubMonitor subMonitor =
                        SubMonitor.convert(
                            monitor,
                            "Generating all Wodel mutants",
                            100
                        );

                    try {

                        /*
                         * First make sure that all .mutator
                         * files and the project launcher have
                         * been generated.
                         */
                        subMonitor.subTask(
                            "Building Wodel project"
                        );

                        wodelProject.build(
                            IncrementalProjectBuilder.FULL_BUILD,
                            subMonitor.split(20)
                        );

                        if (subMonitor.isCanceled()) {
                            return Status.CANCEL_STATUS;
                        }

                        /*
                         * IMPORTANT:
                         *
                         * WodelUtils.getMutatorFiles() now
                         * returns executable Programs only.
                         * Library .mutator files are ignored.
                         */
                        List<IFile> programs =
                            wodel.dsls.runner.WodelUtils.getMutatorFiles(
                                wodelProject
                            );

                        if (programs.isEmpty()) {

                            showInformation(
                                "Wodel",
                                "The project does not contain "
                                + "any executable Wodel programs."
                            );

                            return Status.OK_STATUS;
                        }

                        /*
                         * Generated launcher:
                         *
                         * package:
                         *   mutator.<project-name>
                         *
                         * class:
                         *   <project_name>DynamicLauncher
                         *
                         * Dots in the Java class name are
                         * converted to underscores.
                         */
                        String projectName =
                            wodelProject.getName();

                        String launcherClassName =
                            "mutator."
                            + projectName
                            + "."
                            + projectName.replace(".", "_")
                            + "DynamicLauncher";

                        subMonitor.subTask(
                            "Loading Wodel project launcher"
                        );

                        Class<?> launcherClass =
                            WodelUtils.loadClass(
                                wodelProject,
                                launcherClassName);

                        /*
                         * Occasionally generated Java sources
                         * may require one additional incremental
                         * Java build before their classes become
                         * available.
                         */
                        if (launcherClass == null) {

                            wodelProject.build(
                                IncrementalProjectBuilder
                                    .INCREMENTAL_BUILD,
                                subMonitor.split(10)
                            );

                            launcherClass =
                                WodelUtils.loadClass(
                                    wodelProject,
                                    launcherClassName);
                        }
                        else {
                            subMonitor.worked(10);
                        }

                        if (launcherClass == null) {
                            throw new ClassNotFoundException(
                                "Cannot load generated Wodel "
                                + "launcher: "
                                + launcherClassName
                            );
                        }

                        Object launcherObject =
                            launcherClass
                                .getDeclaredConstructor()
                                .newInstance();

                        if (!(launcherObject
                                instanceof IMutatorExecutor)) {

                            throw new IllegalStateException(
                                launcherClassName
                                + " does not implement "
                                + IMutatorExecutor.class
                                    .getName()
                            );
                        }

                        IMutatorExecutor launcher =
                            (IMutatorExecutor)
                                launcherObject;

                        /*
                         * Use the same normal Wodel preferences
                         * already used by Wodel-Test.
                         */
                        int maxAttempts =
                            getIntegerPreference(
                                "Number of attempts",
                                3
                            );

                        int numMutants =
                            getIntegerPreference(
                                "Number of mutants",
                                3
                            );

                        boolean registry =
                            Platform
                                .getPreferencesService()
                                .getBoolean(
                                    "wodel.dsls.Wodel",
                                    "Generate registry",
                                    true,
                                    null
                                );

                        boolean metrics =
                            Platform
                                .getPreferencesService()
                                .getBoolean(
                                    "wodel.dsls.Wodel",
                                    "Generate net mutant footprints",
                                    false,
                                    null
                                );

                        boolean debugMetrics =
                            Platform
                                .getPreferencesService()
                                .getBoolean(
                                    "wodel.dsls.Wodel",
                                    "Generate debug mutant footprints",
                                    false,
                                    null
                                );

                        /*
                         * null means ALL blocks.
                         *
                         * We deliberately do not filter block
                         * names here because this command means
                         * "execute the whole project".
                         */
                        String[] blockNames = null;

                        /*
                         * This command generates MODEL mutants,
                         * therefore serialization should be true.
                         *
                         * serialize == false belongs to the
                         * language-specific Wodel-Test path,
                         * where an IWodelTest implementation is
                         * needed for modelToProject().
                         */
                        boolean serialize = true;

                        Map<String, List<String>> classes =
                            new LinkedHashMap<
                                String,
                                List<String>
                            >();

                        Map<String, EPackage>
                            registeredPackages =
                                new LinkedHashMap<
                                    String,
                                    EPackage
                                >();

                        subMonitor.subTask(
                            "Generating mutants"
                        );
                        
                        //MutatorUtils.initializeOCL();

                        long seed = System.nanoTime();
                        MutationResults results =
                            launcher.execute(
                                maxAttempts,
                                numMutants,
                                registry,
                                metrics,
                                debugMetrics,

                                /*
                                 * null -> every block
                                 */
                                blockNames,

                                wodelProject,
                                subMonitor.split(60),

                                serialize,

                                /*
                                 * Pure model generation:
                                 * no IWodelTest required.
                                 */
                                null,

                                classes,
                                registeredPackages,
                                seed
                            );

                        if (subMonitor.isCanceled()) {
                            return Status.CANCEL_STATUS;
                        }

                        /*
                         * Make newly generated models immediately
                         * visible in Project/Package Explorer.
                         */
                        wodelProject.refreshLocal(
                            IResource.DEPTH_INFINITE,
                            subMonitor.split(10)
                        );

                        int generated =
                            results != null
                                ? results
                                    .getNumMutantsGenerated()
                                : 0;

                        int applied =
                            results != null
                                ? results
                                    .getNumMutatorsApplied()
                                : 0;

                        showInformation(
                            "Wodel mutant generation",
                            "Wodel mutant generation completed "
                            + "successfully.\n\n"
                            + "Programs executed: "
                            + programs.size()
                            + "\n"
                            + "Mutation blocks/operators applied: "
                            + applied
                            + "\n"
                            + "Mutants generated: "
                            + generated
                        );

                        return Status.OK_STATUS;
                    }
                    catch (Exception exception) {

                        exception.printStackTrace();

                        showError(
                            "Wodel mutant generation",
                            "The Wodel mutant generation "
                            + "process could not be completed.\n\n"
                            + exception.getMessage()
                        );

                        return new Status(
                            IStatus.ERROR,
                            PLUGIN_ID,
                            "Error generating all Wodel mutants",
                            exception
                        );
                    }
                    finally {
                        subMonitor.done();
                    }
                }
            };

        /*
         * User-visible job in Eclipse Progress view.
         */
        job.setUser(true);

        job.schedule();

        return null;
    }


    private static IProject getSelectedProject(
            ExecutionEvent event) {

        ISelection selection =
            HandlerUtil.getCurrentSelection(event);

        if (!(selection
                instanceof IStructuredSelection)) {

            return ProjectUtils
                .getActiveWodelProject()
                .orElse(null);
        }

        Object selected =
            ((IStructuredSelection) selection)
                .getFirstElement();

        if (selected instanceof IProject) {
            return (IProject) selected;
        }

        if (selected instanceof IResource) {
            return ((IResource) selected)
                .getProject();
        }

        if (selected instanceof IAdaptable) {

            IProject project =
                ((IAdaptable) selected)
                    .getAdapter(IProject.class);

            if (project != null) {
                return project;
            }

            IResource resource =
                ((IAdaptable) selected)
                    .getAdapter(IResource.class);

            if (resource != null) {
                return resource.getProject();
            }
        }

        return ProjectUtils
            .getActiveWodelProject()
            .orElse(null);
    }


    private static int getIntegerPreference(
            String key,
            int defaultValue) {

        String value =
            Platform
                .getPreferencesService()
                .getString(
                    "wodel.dsls.Wodel",
                    key,
                    Integer.toString(defaultValue),
                    null
                );

        try {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException exception) {
            return defaultValue;
        }
    }


    private static void showInformation(
            String title,
            String message) {

        PlatformUI
            .getWorkbench()
            .getDisplay()
            .asyncExec(() -> {

                Shell shell = getActiveShell();

                MessageDialog.openInformation(
                    shell,
                    title,
                    message
                );
            });
    }


    private static void showError(
            String title,
            String message) {

        PlatformUI
            .getWorkbench()
            .getDisplay()
            .asyncExec(() -> {

                Shell shell = getActiveShell();

                MessageDialog.openError(
                    shell,
                    title,
                    message
                );
            });
    }


    private static Shell getActiveShell() {

        IWorkbenchWindow window =
            PlatformUI
                .getWorkbench()
                .getActiveWorkbenchWindow();

        return window != null
            ? window.getShell()
            : null;
    }
}