package wodeltest.extension.examples.wizards.generators.feature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.internal.core.ICoreConstants;
import org.eclipse.pde.internal.core.TargetPlatformHelper;
import org.eclipse.pde.internal.core.bundle.BundlePluginBase;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundlePluginModel;
import org.eclipse.pde.internal.core.feature.FeaturePlugin;
import org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel;
import org.eclipse.pde.internal.core.ibundle.IBundle;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginBase;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModelBase;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeaturePlugin;
import org.eclipse.pde.internal.core.project.PDEProject;
import org.eclipse.pde.internal.core.util.CoreUtility;
import org.eclipse.pde.internal.ui.wizards.feature.AbstractCreateFeatureOperation;
import org.eclipse.pde.internal.ui.wizards.feature.FeatureData;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Constants;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;

public class CreateFeatureProjectOperation extends AbstractCreateFeatureProjectOperation {

	protected IPluginBase[] fPlugins;

	public CreateFeatureProjectOperation(IProject project, IPath location, Shell shell, String pluginName, String labelName, Set<String> pluginBaseNames) {
		super(project, location, shell, pluginName, labelName);
		final IFile fragmentXml = PDEProject.getFragmentXml(project);
		final IFile pluginXml = PDEProject.getPluginXml(project);
		final IFile manifest = PDEProject.getManifest(project);
		final List<String> pluginBaseNamesList = new ArrayList<String>(pluginBaseNames);
		fPlugins = new IPluginBase[pluginBaseNamesList.size()];
		for (int i = 0; i < pluginBaseNamesList.size(); i++) {
			WorkspaceBundlePluginModel fModel = new WorkspaceBundlePluginModel(manifest, pluginXml);
			final IPluginBase pluginBase = fModel.getPluginBase();
			final String targetVersion = "3.8";
			try {
				pluginBase.setSchemaVersion(TargetPlatformHelper.getSchemaVersionForTargetVersion(targetVersion));
				pluginBase.setId(pluginBaseNamesList.get(i));
				pluginBase.setVersion("1.0.0");
				pluginBase.setName(pluginBaseNamesList.get(i));
				pluginBase.setProviderName("");
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (fModel instanceof IBundlePluginModelBase) {
				final IBundlePluginModelBase bmodel = ((IBundlePluginModelBase) fModel);
				((IBundlePluginBase) bmodel.getPluginBase()).setTargetVersion(targetVersion);
				bmodel.getBundleModel().getBundle().setHeader(Constants.BUNDLE_MANIFESTVERSION, "2");
			}

			final IBundle bundle = ((BundlePluginBase) pluginBase).getBundle();
			final String exeEnvironment = "JavaSE-11";
			if (exeEnvironment != null) {
				bundle.setHeader(Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT, exeEnvironment);
			}
			fPlugins[i] = pluginBase;
		}
	}

	@Override
	protected void configureFeature(IFeature feature, WorkspaceFeatureModel model) throws CoreException {
		IFeaturePlugin[] added = new IFeaturePlugin[fPlugins.length];
		for (int i = 0; i < fPlugins.length; i++) {
			IPluginBase plugin = fPlugins[i];
			FeaturePlugin fplugin = (FeaturePlugin) model.getFactory().createPlugin();
			fplugin.loadFrom(plugin);
			fplugin.setVersion(ICoreConstants.DEFAULT_VERSION);
			fplugin.setUnpack(CoreUtility.guessUnpack(plugin.getPluginModel().getBundleDescription()));
			added[i] = fplugin;
		}
		feature.addPlugins(added);
	}


}
