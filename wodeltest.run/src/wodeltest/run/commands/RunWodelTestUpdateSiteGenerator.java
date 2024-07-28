package wodeltest.run.commands;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import wodel.utils.manager.ProjectUtils;
import wodeltest.run.generators.feature.CreateFeatureProjectOperation;
import wodeltest.run.generators.updatesite.NewSiteProjectCreationOperation;

public class RunWodelTestUpdateSiteGenerator extends AbstractHandler {
	
	private static String CATEGORY_NAME = "Wodel-Test for custom project";

	public class FeatureProjectRunnableWithProgress implements IRunnableWithProgress {

		private IProject projectFeature;
		private final String projectName;
		private final Shell shell;
		
		public FeatureProjectRunnableWithProgress(String projectName, Shell shell) {
			this.projectName = projectName;
			this.shell = shell;
		}
		
		public void run(IProgressMonitor monitor)
				throws InvocationTargetException {
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			this.projectFeature = workspace.getRoot().getProject(projectName);

			final Shell fShell = shell;
			// Clean up any old project information.
			if (this.projectFeature.exists()) {
				final boolean[] result = new boolean[1];
				PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
					public void run() {
						result[0] = MessageDialog.openQuestion(fShell, "Do you want to overwrite the project "
								+ projectName, "Note that everything inside the project '" + projectName
								+ "' will be deleted if you confirm this dialog.");
					}
				});
				if (result[0]) {
					try {
						this.projectFeature.delete(true, true, null);
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		public IProject getProjectFeature() {
			return this.projectFeature;
		}
		
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IProject project = ProjectUtils.getProject();
		if (project == null) {
			return null;
		}
		LinkedHashMap<String, String> featureMap = new LinkedHashMap<String, String>();
		LinkedHashMap<String, Set<String>> featureIncludedPluginsMap = new LinkedHashMap<String, Set<String>>();
		LinkedHashMap<String, Set<String>> featureIncludedFeaturesMap = new LinkedHashMap<String, Set<String>>();
		
		Shell shell = HandlerUtil.getActiveShell(event);

		if (project != null) {
			featureMap.put(project.getName() + ".plugins", "Wodel-Test for ATL plugins");
			Set<String> includedPlugins = new LinkedHashSet<String>();
			includedPlugins.add(project.getName());
			featureIncludedPluginsMap.put(project.getName() + ".plugins", includedPlugins);
			Set<String> includedFeatures = new LinkedHashSet<String>();
			includedFeatures.add("wodel.additions");
			includedFeatures.add("wodel.core");
			includedFeatures.add("wodel.emf.comparison");
			includedFeatures.add("wodel.emf.validation");
			includedFeatures.add("wodel.examples");
			includedFeatures.add("wodel.footprints");
			includedFeatures.add("wodel.seed.synthesis");
			includedFeatures.add("wodel.wodeltest");
			featureIncludedFeaturesMap.put(project.getName() + ".plugins", includedFeatures);
			featureMap.put("wodel.additions", "Wodel extended features");
			includedPlugins = new LinkedHashSet<String>();
			includedPlugins.add("wodel.semantic.comparison.dfa");
			featureIncludedPluginsMap.put("wodel.additions", includedPlugins);
			includedFeatures = new LinkedHashSet<String>();
			featureIncludedFeaturesMap.put("wodel.additions", includedFeatures);
			featureMap.put("wodel.core", "Wodel core");
			includedPlugins = new LinkedHashSet<String>();
			includedPlugins.add("wodel.dsls.wodel.ui");
			includedPlugins.add("wodel.dsls.wodel");
			includedPlugins.add("wodel.postprocessor");
			includedPlugins.add("wodel.dsls.wodel.ide");
			includedPlugins.add("wodel.registry.reduce");
			includedPlugins.add("wodel.utils");
			includedPlugins.add("wodel.extension");
			includedPlugins.add("wodel.models");
			includedPlugins.add("wodel.project");
			includedPlugins.add("wodel.run");
			includedPlugins.add("wodel.registry");
			includedPlugins.add("wodel.semantic.comparison");
			includedPlugins.add("wodel.syntactic.comparison");
			includedPlugins.add("wodel.semantic.validation");
			includedPlugins.add("wodel.syntactic.validation");
			featureIncludedPluginsMap.put("wodel.core", includedPlugins);
			includedFeatures = new LinkedHashSet<String>();
			featureIncludedFeaturesMap.put("wodel.core", includedFeatures);
			featureMap.put("wodel.emf.comparison", "EMF model comparison");
			includedPlugins = new LinkedHashSet<String>();
			includedPlugins.add("wodel.syntactic.comparison.emf");
			featureIncludedPluginsMap.put("wodel.emf.comparison", includedPlugins);
			includedFeatures = new LinkedHashSet<String>();
			featureIncludedFeaturesMap.put("wodel.emf.comparison", includedFeatures);
			featureMap.put("wodel.emf.validation", "EMF model validation");
			includedPlugins = new LinkedHashSet<String>();
			includedPlugins.add("wodel.syntactic.validation.emf");
			featureIncludedPluginsMap.put("wodel.emf.validation", includedPlugins);
			includedFeatures = new LinkedHashSet<String>();
			featureIncludedFeaturesMap.put("wodel.emf.validation", includedFeatures);
			featureMap.put("wodel.examples", "Wodel examples");
			includedPlugins = new LinkedHashSet<String>();
			includedPlugins.add("wodel.project.examples");
			featureIncludedPluginsMap.put("wodel.examples", includedPlugins);
			includedFeatures = new LinkedHashSet<String>();
			featureIncludedFeaturesMap.put("wodel.examples", includedFeatures);
			featureMap.put("wodel.footprints", "Mutation footprints views");
			includedPlugins = new LinkedHashSet<String>();
			includedPlugins.add("wodel.metrics.command");
			includedPlugins.add("wodel.metrics.debug");
			includedPlugins.add("wodel.metrics.dynamic");
			includedPlugins.add("wodel.metrics.fixed");
			includedPlugins.add("wodel.metrics.data");
			featureIncludedPluginsMap.put("wodel.footprints", includedPlugins);
			includedFeatures = new LinkedHashSet<String>();
			featureIncludedFeaturesMap.put("wodel.footprints", includedFeatures);
			featureMap.put("wodel.seed.synthesis", "Seed automated synthesis");
			includedPlugins = new LinkedHashSet<String>();
			includedPlugins.add("wodel.synthesizer");
			featureIncludedPluginsMap.put("wodel.seed.synthesis", includedPlugins);
			includedFeatures = new LinkedHashSet<String>();
			featureIncludedFeaturesMap.put("wodel.seed.synthesis", includedFeatures);
			featureMap.put("wodel.wodeltest", "Wodel-Test core");
			includedPlugins = new LinkedHashSet<String>();
			includedPlugins.add("wodeltest.extension");
			includedPlugins.add("wodeltest.run");
			includedPlugins.add("wodeltest.optimiser");
			featureIncludedPluginsMap.put("wodel.wodeltest", includedPlugins);
			includedFeatures = new LinkedHashSet<String>();
			featureIncludedFeaturesMap.put("wodel.wodeltest", includedFeatures);

			for (String featureName : featureMap.keySet()) {
				FeatureProjectRunnableWithProgress opCreateFeatureProject = new FeatureProjectRunnableWithProgress(featureName, shell);
				try {
					new ProgressMonitorDialog(shell).run(true, false, opCreateFeatureProject);
				} catch (InterruptedException e) {
					return false;
				} catch (InvocationTargetException e) {
					Throwable realException = e.getTargetException();
					MessageDialog.openError(shell, "Error",
							realException.getMessage());
					return false;
				}
				IRunnableWithProgress featureOp = new CreateFeatureProjectOperation(opCreateFeatureProject.getProjectFeature(), ResourcesPlugin.getWorkspace().getRoot().getLocation(), shell, featureName, featureMap.get(featureName), featureIncludedPluginsMap.get(featureName), featureIncludedFeaturesMap.get(featureName));
				try {
					new ProgressMonitorDialog(shell).run(true, false, featureOp);
				} catch (InterruptedException e) {
					return false;
				} catch (InvocationTargetException e) {
					Throwable realException = e.getTargetException();
					realException.printStackTrace();
					MessageDialog.openError(shell, "Error",
							realException.getMessage());
					return false;
				}
			}
			
			includedFeatures = new LinkedHashSet<String>();
			includedFeatures.add(project.getName() + ".plugins");
			IProject updateSiteProject = ResourcesPlugin.getWorkspace().getRoot().getProject(project.getName() + ".updatesite");
			NewSiteProjectCreationOperation updateSiteOp = new NewSiteProjectCreationOperation(shell.getDisplay(), updateSiteProject, ResourcesPlugin.getWorkspace().getRoot().getLocation(), "web", CATEGORY_NAME, includedFeatures);
			try {
				new ProgressMonitorDialog(shell).run(true, false, updateSiteOp);
			} catch (InterruptedException e) {
				return false;
			} catch (InvocationTargetException e) {
				Throwable realException = e.getTargetException();
				realException.printStackTrace();
				MessageDialog.openError(shell, "Error",
						realException.getMessage());
				return false;
			}
		}
		return null;
	}
}
