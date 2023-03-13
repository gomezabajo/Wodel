package wodeltest.run.utils;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import wodel.utils.manager.ModelManager;

import java.io.File;

import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.WodelTestResultClass;
import wodel.utils.manager.WodelTestUtils;

public class MutatorHelper {
	
	private File source = null;
	private IWodelTest test = null;

	private Map<String, Class<?>> getMutators(File folder) {
		Map<String, Class<?>> mutators = new HashMap<String, Class<?>>();
		if (folder.exists() && folder.isDirectory()) {
			for (File file : folder.listFiles()) {
				if (file.isFile()) {
					if (file.getName().endsWith(".mutator")) {
						String mutatorName = file.getName().replace(".mutator", "");
						String className = "mutator." + mutatorName + "Dynamic." + mutatorName + "Dynamic";
						Class<?> mutator = WodelTestUtils.loadClass(className, test);
						mutators.put(mutatorName, mutator);
					}
				}
				if (file.isDirectory()) {
					Map<String, Class<?>> innerMutators = getMutators(file);
					for (String mutatorName : innerMutators.keySet()) {
						mutators.put(mutatorName, innerMutators.get(mutatorName));
					}
				}
			}
		}

		return mutators;
	}

	public SimpleEntry<String, Class<?>> getLauncher() {
		String projectName = test.getProjectName();
		String className = "mutator." + projectName + "." + projectName + "DynamicLauncher";
		Class<?> cls = WodelTestUtils.loadClass(className, test);
		return new SimpleEntry<String, Class<?>>(className, cls);
	}
	
	public Map<String, Class<?>> getMutators() {
		Map<String, Class<?>> mutators = new HashMap<String, Class<?>>();
		if (source != null && source.exists() && source.isDirectory()) {
			for (File file : source.listFiles()) {
				if (file.isFile()) {
					if (file.getName().endsWith(".mutator")) {
						String mutatorName = file.getName().replace(".mutator", "");
						String className = "mutator." + mutatorName + "Dynamic." + mutatorName + "Dynamic";
						Class<?> mutator = WodelTestUtils.loadClass(className, test);
						mutators.put(mutatorName, mutator);
					}
				}
				if (file.isDirectory()) {
					Map<String, Class<?>> innerMutators = getMutators(file);
					for (String mutatorName : innerMutators.keySet()) {
						mutators.put(mutatorName, innerMutators.get(mutatorName));
					}
				}
			}
		}
		
		return mutators;
	}
	
	public MutatorHelper(IWodelTest test) {
		String path = test.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		path = path.substring(0, path.lastIndexOf("/"));
		this.test = test;
		this.source = new File(path);
	}
	
	public static IWodelTest getTest(IProject project) {
		String path = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getFullPath().toFile().getPath().toString();
		String projectNamePath = path + "/data/project.txt";
		String[] testInfo = WodelTestResultClass.loadProjectInfo(projectNamePath);
		List<IWodelTest> tests = new ArrayList<IWodelTest>();
		if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							"wodeltest.extension.MutTesting");
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
		
		IWodelTest test = null;
		for (IWodelTest t : tests) {
			if (t.getProjectName().equals(testInfo[0]))
			{
				test = t;
				break;
			}
		}
		return test;
	}
}
