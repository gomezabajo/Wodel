package mutator.wodeltest.[@**@];

import wodel.utils.manager.IOUtils;
import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.WodelTestGlobalResult;
import wodel.utils.manager.WodelTestInfo;
import wodel.utils.manager.WodelTestResult;
import wodel.utils.manager.WodelTestResultClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.JavaCore;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;

public class WodelTest implements IWodelTest {

	@Override
	public String getProjectName() {
		return "[@**@]";
	}
	
	@Override
	public String getNatureId() {
		return JavaCore.NATURE_ID;
	}

	@Override
	public void compile(IProject project) {
	}
	
	private void artifactPathsHelper(File file, List<String> artifactPaths) {
		if (file.isFile()) {
			artifactPaths.add(file.getPath());
		}
		else {
			for (File innerFile : file.listFiles()) {
				artifactPathsHelper(innerFile, artifactPaths);
			}
		}
	}

	@Override
	public List<String> artifactPaths(IProject project, String projectPath, File outputFolder, List<String> blockNames) {
		List<String> artifactPaths = new ArrayList<String>();
		File projectFolder = new File(projectPath + "/model");
		for (File file : projectFolder.listFiles()) {
			artifactPathsHelper(file, artifactPaths);
		}
		return artifactPaths;
	}

	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath) {
		WodelTestGlobalResult globalResult = new WodelTestGlobalResult();
		List<WodelTestResultClass> results = globalResult.getResults();
		String projectPath = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName();
		String testSuitePath = ModelManager.getWorkspaceAbsolutePath() + "/" + testSuiteProject.getName();
		try {
			String metamodel = projectPath + "/model/DFAAutomaton.ecore";
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			Resource model = ModelManager.loadModel(packages, artifactPath);
			String seedName = artifactPath.substring(artifactPath.indexOf("\\model\\") + "\\model\\".length(), artifactPath.length());
			seedName = seedName.substring(0, seedName.indexOf("\\"));
			FAUtils.loadFA(model);
			FAUtils.print();
			File testsFolder = new File(testSuitePath + "/" + seedName);
			for (File testFile : testsFolder.listFiles()) {
				FileReader reader = new FileReader(testFile);
				BufferedReader br = new BufferedReader(reader);
				String test = "";
				List<Object> tests = new ArrayList<Object>();
				List<WodelTestInfo> testsInfo = new ArrayList<WodelTestInfo>();
				boolean testValue = true;
				while ((test = br.readLine()) != null) {
					String[] data = test.split(";");
					if (data.length < 2) {
						break;
					}
					String input = data[0];
					String result = data[1];
					boolean accepted = FAUtils.process(input);
					boolean value = false;
					if (!((accepted == true && result.equals("yes")) || (accepted == false && result.equals("no")))) {
						value = true;
						testValue = false;
					}
					String message = value ? DIFFERENT : EQUALS;
					WodelTestInfo info = new WodelTestInfo(testFile.getName() + "/" + input, value, model.getURI().lastSegment(), message);
					testsInfo.add(info);
					tests.add(testFile.getName() + "/" + input);
				}
				WodelTestResult wtr = new WodelTestResult(model.getURI().lastSegment(), artifactPath.replaceAll("\\\\", "/"), tests, testsInfo);
				globalResult.incNumTestsExecuted(1);
				globalResult.incNumTestsFailed(testValue ? 0 : 1);
				WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, artifactPath.replaceAll("\\\\", "/"));
				if (resultClass == null) {
					resultClass = new WodelTestResultClass(artifactPath.replaceAll("\\\\", "/"));
					results.add(resultClass);
				}
				resultClass.addResult(wtr);
				br.close();
				reader.close();
			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return globalResult;
	}

	@Override
	public void projectToModel(String projectName, Class<?> cls) {
		String projectPath = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getLocation().toOSString();
		String targetPath = ModelManager.getMetaModelPath(cls);
		File sourceFolder = new File(projectPath + "/model");
		for (File source : sourceFolder.listFiles()) {
			if (source.getName().endsWith(".model")) {
				try {
					IOUtils.copyFile(source, new File(targetPath + "/" + source.getName()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void projectToModel(IProject project, Class<?> cls) {
		String targetPath = ModelManager.getMetaModelPath(cls);
		File sourceFolder = new File(project.getLocation().toFile().toPath().toString() + "/model");
		for (File source : sourceFolder.listFiles()) {
			if (source.getName().endsWith(".model")) {
				try {
					IOUtils.copyFile(source, new File(targetPath + "/" + source.getName()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean modelToProject(String className, Resource model, String folderName, String modelName, String projectName, Class<?> cls) {
		String targetPath = ModelManager.getWorkspaceAbsolutePath() + "/" + projectName + "/model/" + className + "/" + folderName + "/" + modelName;
		ModelManager.saveOutModel(model, targetPath);
		return false;
	}

	@Override
	public boolean modelToProject(String className, Resource model, String folderName, String modelName,
			IProject project, Class<?> cls) {
		String targetPath = project.getLocation().toFile().toPath().toString() + "/model/" + className + "/" + folderName + "/" + modelName;
		ModelManager.saveOutModel(model, targetPath);
		return false;
	}

	@Override
	public String getContainerEClassName() {
		return "";
	}

	@Override
	public boolean annotateMutation(Resource model, EObject container, String annotation) {
		return false;
	}

	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath, int port) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath,
			List<Thread> threads) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects,
			String artifactPath) {
		Map<IProject, WodelTestGlobalResult> globalResultMap = new HashMap<IProject, WodelTestGlobalResult>();
		for (IProject testSuiteProject : testSuitesProjects) {
			WodelTestGlobalResult globalResult = new WodelTestGlobalResult();
			List<WodelTestResultClass> results = globalResult.getResults();
			String projectPath = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName();
			String testSuitePath = ModelManager.getWorkspaceAbsolutePath() + "/" + testSuiteProject.getName();
			try {
				String metamodel = projectPath + "/model/DFAAutomaton.ecore";
				List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
				Resource model = ModelManager.loadModel(packages, artifactPath);
				String seedName = artifactPath.substring(artifactPath.indexOf("\\model\\") + "\\model\\".length(), artifactPath.length());
				seedName = seedName.substring(0, seedName.indexOf("\\"));
				FAUtils.loadFA(model);
				FAUtils.print();
				File testsFolder = new File(testSuitePath + "/" + seedName);
				for (File testFile : testsFolder.listFiles()) {
					FileReader reader = new FileReader(testFile);
					BufferedReader br = new BufferedReader(reader);
					String test = "";
					List<Object> tests = new ArrayList<Object>();
					List<WodelTestInfo> testsInfo = new ArrayList<WodelTestInfo>();
					boolean testValue = true;
					while ((test = br.readLine()) != null) {
						String[] data = test.split(";");
						if (data.length < 2) {
							break;
						}
						String input = data[0];
						String result = data[1];
						boolean accepted = FAUtils.process(input);
						boolean value = false;
						if (!((accepted == true && result.equals("yes")) || (accepted == false && result.equals("no")))) {
							value = true;
							testValue = false;
						}
						String message = value ? DIFFERENT : EQUALS;
						WodelTestInfo info = new WodelTestInfo(testFile.getName() + "/" + input, value, model.getURI().lastSegment(), message);
						testsInfo.add(info);
						tests.add(testFile.getName() + "/" + input);
					}
					WodelTestResult wtr = new WodelTestResult(model.getURI().lastSegment(), artifactPath.replaceAll("\\\\", "/"), tests, testsInfo);
					globalResult.incNumTestsExecuted(1);
					globalResult.incNumTestsFailed(testValue ? 0 : 1);
					WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, artifactPath.replaceAll("\\\\", "/"));
					if (resultClass == null) {
						resultClass = new WodelTestResultClass(artifactPath.replaceAll("\\\\", "/"));
						results.add(resultClass);
					}
					resultClass.addResult(wtr);
					br.close();
					reader.close();
				}
				globalResultMap.put(testSuiteProject, globalResult);
			} catch (MetaModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return globalResultMap;
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects,
			String artifactPath, int port) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects,
			String artifactPath, List<Thread> threads) {
		// TODO Auto-generated method stub
		return null;
	}
}