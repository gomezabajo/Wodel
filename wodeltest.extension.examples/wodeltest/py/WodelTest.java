package mutator.wodeltest.[@**@];

import wodel.utils.manager.Code2Py;
import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.Py2Code;
import wodel.utils.manager.WodelTestGlobalResult;
import wodel.utils.manager.WodelTestGlobalResult.Status;
import wodel.utils.manager.WodelTestInfo;
import wodel.utils.manager.WodelTestResult;
import wodel.utils.manager.WodelTestResultClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class WodelTest implements IWodelTest {

	private static final int TEST_TIMEOUT = 30;
	public static String path = ModelManager.getWorkspaceAbsolutePath(WodelTest.class);

	public WodelTest() {
	}

	@Override
	public String getProjectName() {
		return "[@**@]";
	}

	@Override
	public String getNatureId() {
		return "wodeltest.extension.wodelTestSUTNature";
	}

	@Override
	public void compile(IProject project) {
		// Python does not require compilation
	}

	@Override
	public List<String> artifactPaths(IProject project, String projectPath, File outputFolder, List<String> blockNames) {
		List<String> artifactPaths = new ArrayList<>();
		System.out.println("[[@**@]] artifactPaths: outputFolder=" + outputFolder.getAbsolutePath());
		if (!outputFolder.isDirectory()) return artifactPaths;
		
		File outBase = new File(outputFolder.getAbsolutePath());
		System.out.println("[[@**@]] artifactPaths: outBase=" + outBase.getAbsolutePath() + " exists=" + outBase.exists());
		
		File[] outputFiles = outputFolder.listFiles();
		if (outputFiles == null) return artifactPaths;

		for (File d : outputFiles) {
			if (!d.isDirectory() || d.getName().startsWith("test_")) continue;
			for (File dd : d.listFiles()) {
				if (!dd.isDirectory() || dd.getName().startsWith("test_")) continue;
				for (File ddd : dd.listFiles()) {
					if (!ddd.isDirectory() || ddd.getName().startsWith("test_")) continue;
					for (File f : ddd.listFiles()) {
						if (!f.isFile() || !f.getName().endsWith(".py") || f.getName().startsWith("test_")) continue;
						String prog = f.getName();
						File mutant = new File(ddd, prog);
						if (mutant.isFile() && mutant.getName().endsWith(".py")) {
							String blockName = dd.getName();
							if (blockNames != null && !blockNames.contains(blockName)) continue;
							artifactPaths.add(mutant.getAbsolutePath());
						}
					}
				}
			}
		}
		System.out.println("[[@**@]] artifactPaths: returning " + artifactPaths.size() + " paths");
		return artifactPaths;
	}

	@Override
	public void projectToModel(String projectName, Class<?> cls) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		projectToModel(project, cls);
	}

	@Override
	public void projectToModel(IProject project, Class<?> cls) {
		ensureJavaNature(project);
		try {
			String projectPath = project.getLocation().toFile().getPath();
			File testListFile = new File(projectPath + "/data/" + project.getName() + ".test.txt");
			if (testListFile.exists()) {
				try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(testListFile))) {
					br.readLine();
					String suiteName;
					while ((suiteName = br.readLine()) != null) {
						suiteName = suiteName.trim();
						if (suiteName.isEmpty()) continue;
						IProject suiteProject = ResourcesPlugin.getWorkspace().getRoot().getProject(suiteName);
						if (suiteProject != null && suiteProject.exists()) {
							ensureJavaNature(suiteProject);
						}
					}
				}
			}
		} catch (Exception ex) {
			System.err.println("[[@**@]] Could not process test suite projects: " + ex.getMessage());
		}
		try {
			String projectPath = project.getLocation().toFile().getPath();
			
			String pluginPath = WodelTest.path;
			String modelOutputDir = pluginPath + "/data/model/";
			String ecorePath = pluginPath + "/data/model/python.ecore";
			new File(modelOutputDir).mkdirs();

			String[] sourceDirs = { projectPath, projectPath + "/src", projectPath + "/data/model" };
			for (String sourceDir : sourceDirs) {
				File dir = new File(sourceDir);
				if (!dir.isDirectory()) continue;
				File[] pyFiles = dir.listFiles(f ->
					f.isFile() && f.getName().endsWith(".py") && !f.getName().startsWith("test_"));
				if (pyFiles == null) continue;
				for (File pyFile : pyFiles) {
					String outputPath = modelOutputDir + pyFile.getName().replace(".py", ".model");
					System.out.println("[[@**@]] projectToModel: converting " + pyFile.getName());
					try {
						Code2Py.convertFileToXmi(pyFile.getAbsolutePath(), ecorePath, outputPath);
					} catch (Exception ex) {
						System.err.println("[[@**@]] projectToModel: error converting "
								+ pyFile.getName() + ": " + ex.getMessage());
					}
				}
			}
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean modelToProject(String className, Resource model, String folderName, String modelName,
			String projectName, Class<?> cls) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		return modelToProject(className, model, folderName, modelName, project, cls);
	}

	@Override
	public boolean modelToProject(String className, Resource model, String folderName, String modelName,
			IProject project, Class<?> cls) {
		try {
			org.eclipse.emf.common.util.URI modelURI = model.getURI();
			String modelPath = modelURI.toFileString();
			if (modelPath == null) {
				String platformPath = modelURI.toPlatformString(true);
				if (platformPath != null) {
					org.eclipse.core.resources.IFile ifile = ResourcesPlugin.getWorkspace().getRoot()
							.getFile(new org.eclipse.core.runtime.Path(platformPath));
					if (ifile.exists()) {
						modelPath = ifile.getLocation().toOSString();
					}
				}
			}
			if (modelPath == null) {
				return false;
			}
			String projectPath = project.getLocation().toFile().getPath().toString() + "/" + className + "/" + folderName + "/" + modelName.replace(".model", "");
			File projectDirectory = new File(projectPath);
			projectDirectory.mkdirs();
			String programName = modelPath.replace(".model", ".py").replace("\\", "/");
			programName = programName.indexOf("/") > 0 ? programName.substring(programName.lastIndexOf("/"), programName.length()) : programName;
			String pyPath = projectPath + "/" + programName;
			File pyFile = new File(pyPath);
			if (pyFile.exists()) {
				return true;
			}
			String pyCode = Py2Code.toPython(ModelManager.getRoot(model));
			try (FileWriter fw = new FileWriter(pyFile)) {
				fw.write(pyCode);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getContainerEClassName() {
		return "Module";
	}

	@Override
	public boolean annotateMutation(Resource model, EObject container, String annotation) {
		return false;
	}

	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath,
			IProgressMonitor monitor) {
		List<IProject> suites = new ArrayList<>();
		suites.add(testSuiteProject);
		Map<IProject, WodelTestGlobalResult> map = run(project, suites, artifactPath, monitor);
		if (map != null && !map.isEmpty()) {
			return map.values().iterator().next();
		}
		return new WodelTestGlobalResult();
	}

	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath,
			int port, IProgressMonitor monitor) {
		return run(project, testSuiteProject, artifactPath, monitor);
	}

	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath,
			List<Thread> threads, IProgressMonitor monitor) {
		return run(project, testSuiteProject, artifactPath, monitor);
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects,
			String artifactPath, IProgressMonitor monitor) {

		Map<IProject, WodelTestGlobalResult> globalResultMap = new LinkedHashMap<>();
		String programName = extractProgramNameFromMutantPath(artifactPath);
		String operatorName = extractOperatorFromMutantPath(artifactPath);
		if (programName == null) return globalResultMap;

		String sutPath = project.getLocation().toFile().getPath().replace("\\", "/");
		String originalSrcPath = sutPath + "/" + programName + ".py";
		if (!new File(originalSrcPath).exists()) return globalResultMap;
		String backupPath = originalSrcPath + ".bak";

		try {
			java.nio.file.Files.copy(new File(originalSrcPath).toPath(), new File(backupPath).toPath(),
					java.nio.file.StandardCopyOption.REPLACE_EXISTING);
			java.nio.file.Files.copy(new File(artifactPath).toPath(), new File(originalSrcPath).toPath(),
					java.nio.file.StandardCopyOption.REPLACE_EXISTING);
			for (IProject testSuiteProject : testSuitesProjects) {
				String testFilePath = findTestFile(testSuiteProject, project, programName, sutPath);
				if (testFilePath == null) continue;
				String mutantName = new File(artifactPath).getName().replace(".py", "");
				String folderPath = "/" + programName + "/" + (operatorName != null ? operatorName : "unknown") + "/" + mutantName;
				WodelTestGlobalResult result = runPytest(sutPath, testFilePath, programName, originalSrcPath, folderPath);
				globalResultMap.put(testSuiteProject, result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				File backup = new File(backupPath);
				if (backup.exists()) {
					java.nio.file.Files.copy(backup.toPath(), new File(originalSrcPath).toPath(),
							java.nio.file.StandardCopyOption.REPLACE_EXISTING);
					backup.delete();
				}
			} catch (Exception e) { e.printStackTrace(); }
		}
		return globalResultMap;
	}

	private String extractProgramNameFromMutantPath(String path) {
		String p = path.replace("\\", "/");
		int idx = p.lastIndexOf("/");
		if (idx == -1) return null;
		p = p.substring(0, idx);
		idx = p.lastIndexOf("/");
		if (idx == -1) return null;
		p = p.substring(0, idx);
		idx = p.lastIndexOf("/");
		if (idx == -1) return null;
		p = p.substring(0, idx);
		idx = p.lastIndexOf("/");
		if (idx == -1) return null;
		String rest = p.substring(idx + "/".length());
		rest = rest.endsWith(".py") ? rest.replace(".py", "") : rest;
		return rest;
	}

	private String extractOperatorFromMutantPath(String path) {
		String p = path.replace("\\", "/");
		int idx = p.lastIndexOf("/data/out/");
		if (idx == -1) return null;
		String rest = p.substring(idx + "/data/out/".length());
		String[] parts = rest.split("/");
		return parts.length >= 2 ? parts[1] : null;
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects,
			String artifactPath, int port, IProgressMonitor monitor) {
		return run(project, testSuitesProjects, artifactPath, monitor);
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects,
			String artifactPath, List<Thread> threads, IProgressMonitor monitor) {
		return run(project, testSuitesProjects, artifactPath, monitor);
	}

	private WodelTestGlobalResult runPytest(String workingDir, String testFilePath,
			String programName, String srcPath, String folderPath) {
		WodelTestGlobalResult globalResult = new WodelTestGlobalResult();
		try {
			ProcessBuilder pb = new ProcessBuilder(
					"python", "-m", "pytest", testFilePath, "-v", "--tb=line");
			pb.directory(new File(workingDir));
			pb.redirectErrorStream(false);

			Process proc = pb.start();

			final StringBuilder stdout = new StringBuilder();
			Thread readerThread = new Thread(() -> {
				try (BufferedReader br = new BufferedReader(
						new InputStreamReader(proc.getInputStream()))) {
					String line;
					while ((line = br.readLine()) != null) {
						stdout.append(line).append("\n");
					}
				} catch (Exception ignored) {}
			});
			readerThread.setDaemon(true);
			readerThread.start();

			boolean finished = proc.waitFor(TEST_TIMEOUT, TimeUnit.SECONDS);
			if (!finished) {
				proc.destroyForcibly();
				globalResult.setStatus(Status.EXCEPTION);
				return globalResult;
			}
			readerThread.join(1000);

			int exitCode     = proc.exitValue();
			String output    = stdout.toString();

			int[] counts = new int[2]; // [0]=passed, [1]=failed
			List<WodelTestInfo> testsInfo = parsePytestOutput(output, exitCode, counts);
			int passed = counts[0];
			int failed = counts[1];

			Map<String, Boolean> testsMap = new LinkedHashMap<>();
			for (WodelTestInfo ti : testsInfo) {
				testsMap.put(ti.getTest(), ti.getValue());
			}
			WodelTestResult wtr = new WodelTestResult(programName, srcPath, testsMap, testsInfo);
			globalResult.incNumTestsExecuted(passed + failed);
			globalResult.incNumTestsFailed(failed);
			globalResult.incNumTestsError(wtr.getErrorCount());

			WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(globalResult.getResults(), folderPath);
			if (resultClass == null) {
				resultClass = new WodelTestResultClass(folderPath);
				globalResult.getResults().add(resultClass);
			}
			resultClass.addResult(wtr);
			globalResult.setStatus(Status.OK);

		} catch (Exception e) {
			e.printStackTrace();
			globalResult.setStatus(Status.EXCEPTION);
		}
		return globalResult;
	}

	private String findTestFile(IProject testSuiteProject, IProject sutProject,
			String programName, String srcDir) {
		String testName = "test_" + programName + ".py";

		if (testSuiteProject != null && !testSuiteProject.equals(sutProject)) {
			String testProjectPath = testSuiteProject.getLocation().toFile().getPath().replace("\\", "/");
			String[] candidates = {
				testProjectPath + "/" + testName,
				testProjectPath + "/src/" + testName
			};
			for (String candidate : candidates) {
				if (new File(candidate).exists()) return candidate;
			}
		}
		
		String fallback = srcDir + "/" + testName;
		if (new File(fallback).exists()) return fallback;

		return null;
	}

	private List<WodelTestInfo> parsePytestOutput(String output, int exitCode, int[] counts) {
		List<WodelTestInfo> testsInfo = new ArrayList<>();
		for (String line : output.split("\n")) {
			line = line.trim();
			if (line.contains("::") && line.contains(" PASSED")) {
				String full = line.split(" PASSED")[0].trim();
				String methodName = full.contains("::") ? full.substring(full.lastIndexOf("::") + 2) : full;
				String className = full.contains("::") ? full.substring(0, full.lastIndexOf("::")) : full;
				testsInfo.add(new WodelTestInfo(methodName, false, className, IWodelTest.EQUALS));
				counts[0]++;
			} else if (line.contains("::") && line.contains(" FAILED")) {
				String full = line.split(" FAILED")[0].trim();
				String methodName = full.contains("::") ? full.substring(full.lastIndexOf("::") + 2) : full;
				String className = full.contains("::") ? full.substring(0, full.lastIndexOf("::")) : full;
				testsInfo.add(new WodelTestInfo(methodName, true, className, IWodelTest.DIFFERENT));
				counts[1]++;
			}
		}
		if (testsInfo.isEmpty()) {
			boolean allPassed = (exitCode == 0);
			testsInfo.add(new WodelTestInfo("pytest", !allPassed, "pytest",
					allPassed ? IWodelTest.EQUALS : IWodelTest.DIFFERENT));
			if (allPassed) counts[0]++; else counts[1]++;
		}
		return testsInfo;
	}

	private void ensureJavaNature(IProject project) {
		try {
			IProjectDescription desc = project.getDescription();
			String[] natures = desc.getNatureIds();
			for (String n : natures) {
				if ("org.eclipse.jdt.core.javanature".equals(n)) return;
			}
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = "org.eclipse.jdt.core.javanature";
			desc.setNatureIds(newNatures);
			project.setDescription(desc, new NullProgressMonitor());
			File classpathFile = new File(project.getLocation().toOSString(), ".classpath");
			if (!classpathFile.exists()) {
				try (java.io.FileWriter fw = new java.io.FileWriter(classpathFile)) {
					fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<classpath>\n");
					fw.write("\t<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER\"/>\n");
					fw.write("\t<classpathentry kind=\"output\" path=\"bin\"/>\n");
					fw.write("</classpath>\n");
				}
			}
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			System.out.println("[[@**@]] Added Java nature and .classpath to: " + project.getName());
		} catch (Exception ex) {
			System.err.println("[[@**@]] Could not add Java nature to " + project.getName() + ": " + ex.getMessage());
		}
	}
}
