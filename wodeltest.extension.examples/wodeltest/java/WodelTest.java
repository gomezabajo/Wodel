package mutator.wodeltest.[@**@];

import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.WodelTestGlobalResult;
import wodel.utils.manager.WodelTestGlobalResult.Status;
import wodel.utils.manager.WodelTestInfo;
import wodel.utils.manager.WodelTestResult;
import wodel.utils.manager.WodelTestResultClass;
import wodel.utils.manager.WodelTestUtils;
//import wodeltest.extension.utils.MyGenerateJavaExtended;

import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
//import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.modisco.java.Comment;
import org.eclipse.modisco.java.CompilationUnit;
import org.eclipse.modisco.java.Statement;
import org.eclipse.modisco.java.emf.JavaFactory;
import org.eclipse.modisco.java.emf.JavaPackage;
import org.eclipse.modisco.java.generation.files.GenerateJavaExtended;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;
import org.eclipse.modisco.java.discoverer.DiscoverJavaModelFromJavaProject;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;
import wodel.utils.manager.AcceleoUtils;
import wodel.utils.manager.IOUtils;
import wodel.utils.manager.ModelManager;

import org.eclipse.core.runtime.IProgressMonitor;

public class WodelTest implements IWodelTest {
	
	private static JUnitVersion jUnitVersion = JUnitVersion.UNKNOWN;
	private static final int TIME_SLEEP = 100;
	private static final int TEST_TIMEOUT = 300;
	
	private SummaryGeneratingListener listener;

	public WodelTest() {
		this.listener = new SummaryGeneratingListener(); 
	}

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
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
			Job.getJobManager().join(ResourcesPlugin.FAMILY_MANUAL_BUILD, new NullProgressMonitor());
			//project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OperationCanceledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<String> artifactPaths(IProject project, String projectPath, File outputFolder, List<String> blockNames) {
		List<String> artifactPaths = new ArrayList<String>();
		if (outputFolder.isDirectory()) {
			for (File modelFolder : outputFolder.listFiles()) {
				if (modelFolder.isDirectory()) {
					for (File modelFile : modelFolder.listFiles()) {
						if (blockNames != null) {
							if (modelFile.isDirectory() && blockNames.contains(modelFile.getName())) {
								for (File blockModelFile : modelFile.listFiles()) {
									String artifactPath = WodelTestUtils.findSourcePath(blockModelFile, ".java");
									if (artifactPath != null) {
										artifactPaths.add(artifactPath);
									}
								}
							}
						}
						else {
							if (modelFile.isDirectory()) {
								for (File mutantFile : modelFile.listFiles()) {
									String artifactPath = WodelTestUtils.findSourcePath(mutantFile, ".java");
									if (artifactPath != null) {
										artifactPaths.add(artifactPath);
									}
								}
							}
						}
					}
				}
			}
		}
		return artifactPaths;
	}
	
	private static List<Object> getTestsJUnit5(Class<?> clazz) {
		List<Object> ret = new ArrayList<Object>();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(org.junit.jupiter.api.Test.class)) {
				ret.add(method);
			}
		}
		return ret;
	}

	private static List<Object> getTestsJUnit4(Class<?> clazz) {
		List<Object> ret = new ArrayList<Object>();
		Method[] methods = clazz.getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].isAnnotationPresent(org.junit.Test.class)) {
				ret.add(methods[i]);
			}
		}
		return ret;
	}
	
	private static List<Object> getTestsJUnit3(Class<?> clazz) {
		List<Object> ret = new ArrayList<Object>();
		Method[] methods = clazz.getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().startsWith("test")) {
				ret.add(methods[i]);
			}
		}
		return ret;
	}
	
	private void runTest(WodelTestGlobalResult globalResult, Class<?> clazz, List<Object> tests, IProject project, String folderPath, String artifactPath, boolean initial) {
		List<WodelTestResultClass> results = globalResult.getResults();
		String clazzName = clazz.getName();
		if (clazzName.indexOf(".") != -1) {
			clazzName = clazzName.substring(clazzName.lastIndexOf(".") + 1, clazzName.length());
			clazzName = clazzName.substring(0, 1).toLowerCase() + clazzName.substring(1, clazzName.length());
		}

		if (WodelTest.jUnitVersion == JUnitVersion.JUNIT3 || WodelTest.jUnitVersion == JUnitVersion.JUNIT4) {
			
			Object ret = JUnitRunnerHelper.runJUnit4WithTimeout(WodelTest.jUnitVersion, clazz, TEST_TIMEOUT);
			if (ret == null || !(ret instanceof Result)) {
				globalResult.setStatus(Status.EXCEPTION);
				return;
			}
			Result result = (Result) ret;
			List<Failure> failures = result.getFailures();
			List<WodelTestInfo> testsInfo = new ArrayList<WodelTestInfo>();

			for (Failure failure : failures) {
				if (failure.getTestHeader() != null && failure.getMessage() != null) {
					WodelTestInfo info = new WodelTestInfo(failure.getDescription().getMethodName(), true, failure.getTestHeader(), failure.getMessage().replace("\n", "-").replace("\r", ""));
					testsInfo.add(info);
				}
			}
			if (failures.size() == 0) {
				WodelTestInfo info = new WodelTestInfo(clazzName, false, clazzName, WodelTest.EQUALS);
				testsInfo.add(info);
			}
			WodelTestResult wtr = new WodelTestResult(clazzName, clazz.getProtectionDomain().getCodeSource().getLocation().getPath(), tests, testsInfo);
			globalResult.incNumTestsExecuted(result.getRunCount());
			globalResult.incNumTestsFailed(result.getFailureCount());
			globalResult.incNumTestsError(wtr.getErrorCount());
			WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, folderPath);
			if (resultClass == null) {
				resultClass = new WodelTestResultClass(folderPath);
				results.add(resultClass);
			}
			resultClass.addResult(wtr);
			globalResult.setStatus(Status.OK);
		}
		if (WodelTest.jUnitVersion == JUnitVersion.JUNIT5) {
			Object ret = JUnitRunnerHelper.runJUnit5WithTimeout(WodelTest.jUnitVersion, clazz, this.listener, TEST_TIMEOUT);
			if (ret == null || !(ret instanceof TestExecutionSummary)) {
				globalResult.setStatus(Status.EXCEPTION);
				return;
			}

			long testsFoundCount = 0;
			long testsFailedCount = 0;

			TestExecutionSummary result = (TestExecutionSummary) ret;
			result.printTo(new PrintWriter(System.out));
			
			testsFoundCount += result.getTestsSucceededCount() + result.getTestsFailedCount();
			testsFailedCount += result.getTestsFailedCount();
			
			List<WodelTestInfo> testsInfo = new ArrayList<WodelTestInfo>();
			List<org.junit.platform.launcher.listeners.TestExecutionSummary.Failure> failures = result.getFailures();

			for (org.junit.platform.launcher.listeners.TestExecutionSummary.Failure failure : failures) {
				if (failure.getException() != null) {
					WodelTestInfo info = new WodelTestInfo(clazzName, true, failure.getException().getMessage().replace("\n", "-").replace("\r", "").replace(";","-"), failure.getException().getMessage().replace("\n", "-").replace("\r", "").replace(";","-"));
					testsInfo.add(info);
				}
			}
			if (failures.size() == 0) {
				WodelTestInfo info = new WodelTestInfo(clazzName, false, clazzName, WodelTest.EQUALS);
				testsInfo.add(info);
			}
			WodelTestResult wtr = new WodelTestResult(clazzName, clazz.getProtectionDomain().getCodeSource().getLocation().getPath(), tests, testsInfo);
			globalResult.incNumTestsExecuted((int) testsFoundCount);
			globalResult.incNumTestsFailed((int) testsFailedCount);
			globalResult.incNumTestsError(wtr.getErrorCount());
			WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, folderPath);
			if (resultClass == null) {
				resultClass = new WodelTestResultClass(folderPath);
				results.add(resultClass);
			}
			resultClass.addResult(wtr);
			globalResult.setStatus(Status.OK);
		}
	}

	private int getTotalWork(List<IProject> testSuitesProjects) {
		int totalWork = 0;
		for (IProject testSuiteProject : testSuitesProjects) {
			Class<?>[] classes = WodelTestUtils.loadClasses(testSuiteProject, this, null);
			totalWork += classes.length;
		}
		return totalWork;
	}
	
	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath, IProgressMonitor monitor) {
		List<IProject> testSuitesProjects = new ArrayList<IProject>();
		testSuitesProjects.add(testSuiteProject);
		int totalWork = getTotalWork(testSuitesProjects);
		String mutantName = artifactPath.replace("\\", "/");
		if (mutantName.indexOf("/") != -1) {
			mutantName = mutantName.substring(mutantName.lastIndexOf("/") + 1, mutantName.length());
		}
		WodelTestGlobalResult globalResult = new WodelTestGlobalResult();
		try {
			IJavaProject javaProject = JavaCore.create(project);
			IClasspathEntry[] entries = javaProject.getRawClasspath();
			IClasspathEntry srcEntry = null;
			for (int i = 0; i < entries.length; i++) {
				IPath entryPath = entries[i].getPath();
				if (entryPath.lastSegment().equals("src")) {
					srcEntry = entries[i];
					break;
				}
			}
			Thread current = Thread.currentThread();
			ClassLoader oldLoader = current.getContextClassLoader();
			current.setContextClassLoader(testSuiteProject.getClass().getClassLoader());
			String className = artifactPath.substring(artifactPath.lastIndexOf(File.separator) + 1, artifactPath.length() - ".java".length());
			String packageName = artifactPath.substring(artifactPath.indexOf(project.getName() + File.separator) + (project.getName() + File.separator).length(), artifactPath.length());
			if (packageName.indexOf("." + className) > 0) {
				packageName = packageName.substring(0, packageName.indexOf("." + className));
			}
			String folderPath = "/" + project.getName() + "/" + artifactPath.substring(artifactPath.indexOf(File.separator + packageName + "." + className) + File.pathSeparator.length(), artifactPath.length());
			folderPath = folderPath.substring(0, folderPath.lastIndexOf(File.separator + "src"));
			String javaFileName = className.substring(className.lastIndexOf(".") + 1, className.length()) + ".java";
			String srcJavaFilePath = "";
			String projectName = project.getName();
			String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getLocation().toFile().getPath().replace("\\", "/");
			workspacePath = workspacePath.substring(0, workspacePath.lastIndexOf("/" + projectName));
			if (packageName.length() > 0) {
				srcJavaFilePath = workspacePath + "/" + srcEntry.getPath().toString() + "/" + packageName.replace(".", "/") + "/" + javaFileName;						
			}
			else {
				srcJavaFilePath = workspacePath + "/" + srcEntry.getPath().toString() + "/" + javaFileName;
			}
			String newSrcPath = srcJavaFilePath.replace(".java", ".bak");
			IOUtils.copyFile(srcJavaFilePath, newSrcPath);
			IOUtils.copyFile(artifactPath, srcJavaFilePath);
			compile(project);
			Class<?>[] classes = WodelTestUtils.loadClasses(testSuiteProject, this, null);
			WodelTest.setJUnitVersion(classes);
			List<List<Object>> clazzObject = new ArrayList<List<Object>>();
			for (Class<?> clazz : classes) {
				List<Object> tests = new ArrayList<Object>();
				switch(WodelTest.jUnitVersion) {
				case JUNIT5: 
					tests.addAll(WodelTest.getTestsJUnit5(clazz));
					break;
				case JUNIT4: 
					tests.addAll(WodelTest.getTestsJUnit4(clazz));
					break;
				case JUNIT3: 
					tests.addAll(WodelTest.getTestsJUnit3(clazz));
					break;
				case UNKNOWN: 
					break;
				}
				clazzObject.add(tests);
			}
			int i = 0;
			SubMonitor subMonitor = SubMonitor.convert(monitor, "Processing test suite " + testSuiteProject.getName() + " for " + mutantName + " (" + classes.length + "/" + totalWork + ")", classes.length);
			subMonitor.setWorkRemaining(classes.length);
			subMonitor.beginTask("Processing test suite " + testSuiteProject.getName() + " for " + mutantName + " (" + classes.length + "/" + totalWork + ")", classes.length);
			for (Class<?> clazz : classes) {
				i++;
				List<Object> tests = clazzObject.get(i - 1);
				subMonitor.subTask("Processing " + tests.size() + " test cases found in '" + clazz.getName() + "(" + i + "/" + classes.length + ")");
				subMonitor.worked(1);
				if (tests.size() > 0) {
					runTest(globalResult, clazz, tests, project, folderPath, artifactPath, false);
					if (globalResult.getStatus() != Status.OK) {
						break;
					}
				}
			}
			WodelTestUtils.awaitFile(newSrcPath, TIME_SLEEP);
			File newSrc = new File(newSrcPath);
			if (newSrc != null && newSrc.exists()) {
				IOUtils.copyFile(newSrcPath, srcJavaFilePath);
				IOUtils.deleteFile(newSrcPath);
			}
			current.setContextClassLoader(oldLoader);
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return globalResult;
	}

	private static void setJUnitVersion(Class<?>[] classes) {
		List<Object> testListJUnit3 = new ArrayList<Object>();
		List<Object> testListJUnit4 = new ArrayList<Object>();
		List<Object> testListJUnit5 = new ArrayList<Object>();
		for (Class<?> clazz : classes) {
			testListJUnit3.addAll(WodelTest.getTestsJUnit3(clazz));
			testListJUnit4.addAll(WodelTest.getTestsJUnit4(clazz));
			testListJUnit5.addAll(WodelTest.getTestsJUnit5(clazz));
		}
		if (testListJUnit3.size() != 0) {
			WodelTest.jUnitVersion = JUnitVersion.JUNIT3;
		}
		else if (testListJUnit4.size() != 0) {
			WodelTest.jUnitVersion = JUnitVersion.JUNIT4;
		}
		else if (testListJUnit5.size() != 0) {
			WodelTest.jUnitVersion = JUnitVersion.JUNIT5;
		}
	}

	@Override
	public void projectToModel(String projectName, Class<?> cls) {
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			IJavaProject javaProject = JavaCore.create(project);
			String[] classNames = WodelTestUtils.getClassesFilter(project, javaProject);
			for (String className : classNames) {
				String filter = className.replace(".", "\\.");
				DiscoverJavaModelFromJavaProject discoverer = new DiscoverJavaModelFromJavaProject();
				discoverer.setIncludedElementsRegEx(filter);
				discoverer.discoverElement(javaProject, new NullProgressMonitor());
				Resource resource = discoverer.getTargetModel();
				ModelManager.saveOutModel(resource, ModelManager.getMetaModelPath(cls) + "/" + className + ".model");
			}
		} catch (DiscoveryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void projectToModel(IProject project, Class<?> cls) {
		try {
			IJavaProject javaProject = JavaCore.create(project);
			String[] classNames = WodelTestUtils.getClassesFilter(project, javaProject);
			for (String className : classNames) {
				String filter = className.replace(".", "\\.");
				DiscoverJavaModelFromJavaProject discoverer = new DiscoverJavaModelFromJavaProject();
				discoverer.setIncludedElementsRegEx(filter);
				discoverer.discoverElement(javaProject, new NullProgressMonitor());
				Resource resource = discoverer.getTargetModel();
				ModelManager.saveOutModel(resource, ModelManager.getMetaModelPath(cls) + "/" + className + ".model");
			}
		} catch (DiscoveryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean modelToProject(String className, Resource model, String folderName, String modelName, String projectName, Class<?> cls) {
		try {
			JavaPackage.eINSTANCE.eClass();
			AcceleoUtils.SwitchSuccessNotification(false);
			String projectPath = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getLocation().toFile().getPath().replace("\\", "/");
			String folder = projectPath + "/" + className + "/" + folderName + "/" + modelName.replace(".model", "") + "/src/";
			//boolean serialized = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Serialize models", true, null);
			GenerateJavaExtended javaGenerator = new GenerateJavaExtended(model.getURI(),
				new File(folder), new ArrayList<Object>());
			//if (javaGenerator.status == true) {
				javaGenerator.doGenerate(null);
			//	return true;
			//}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modelToProject(String className, Resource model, String folderName, String modelName,
			IProject project, Class<?> cls) {
		try {
			JavaPackage.eINSTANCE.eClass();
			AcceleoUtils.SwitchSuccessNotification(false);
			String folder = project.getLocation().toFile().getPath().toString() + "/" + className + "/" + folderName + "/" + modelName.replace(".model", "") + "/src/";
			//boolean serialized = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Serialize models", true, null);
			GenerateJavaExtended javaGenerator = new GenerateJavaExtended(model.getURI(),
				new File(folder), new ArrayList<Object>());
			//if (javaGenerator.status == true) {
				javaGenerator.doGenerate(null);
			//	return true;
			//}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getContainerEClassName() {
		return "Statement";
	}

	@Override
	public boolean annotateMutation(Resource model, EObject container, String annotation) {
		// Initialize the model
		System.out.println("Annotations");
		// dynamic
		if (container instanceof Statement) {
			JavaPackage.eINSTANCE.eClass();
			Statement statement = (Statement) container;
			CompilationUnit compilationUnit = statement.getOriginalCompilationUnit();
			Comment comment = JavaFactory.eINSTANCE.createLineComment();
			comment.setContent("//" + annotation);
			comment.setOriginalClassFile(compilationUnit.getOriginalClassFile());
			comment.setOriginalCompilationUnit(compilationUnit);
			statement.getComments().add(comment);
		}
		// static
		else {
			try {
				List<EPackage> packages = new ArrayList<EPackage>();
				packages.add(model.getContents().get(0).eClass().getEPackage());
				EClass statementEClass = ModelManager.getEClassByName(packages, "Statement");
				List<EClass> types = new ArrayList<EClass>();
				types.addAll(ModelManager.getESubClasses(packages, statementEClass));
				types.add(statementEClass);
				EClass currentType = null;
				for (EClass type : types) {
					if (EcoreUtil.getURI(type).equals(EcoreUtil.getURI(container.eClass()))) {
						currentType = type;
						break;
					}
				}
				if (currentType != null) {
					EObject originalCompilationUnit = ModelManager.getReference("originalCompilationUnit", container);
					EObject originalClassFile = ModelManager.getReference("originalClassFile", container);
					List<EObject> comments = ModelManager.getReferences("comments", container);
					EClass lineCommentEClass = ModelManager.getEClassByName(packages, "LineComment");
					EObject comment = EcoreUtil.create(lineCommentEClass);
					ModelManager.setStringAttribute("content", comment, "//" + annotation);
					if (originalClassFile != null) {
						ModelManager.setReference("originalClassFile", comment, originalClassFile);
					}
					if (originalCompilationUnit != null) {
						ModelManager.setReference("originalCompilationUnit", comment, originalCompilationUnit);
					}
					comments.add(comment);
				}
			} catch (ReferenceNonExistingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WrongAttributeTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("End annotations");
		return true;
	}

	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath, int port, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath,
			List<Thread> threads, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects,
			String artifactPath, IProgressMonitor monitor) {
		int totalWork = getTotalWork(testSuitesProjects);
		String mutantName = artifactPath.replace("\\", "/");
		if (mutantName.indexOf("/") != -1) {
			mutantName = mutantName.substring(mutantName.lastIndexOf("/") + 1, mutantName.length());
		}
		Map<IProject, WodelTestGlobalResult> globalResultMap = new LinkedHashMap<IProject, WodelTestGlobalResult>();
		try {
			for (IProject testSuiteProject : testSuitesProjects) {
				WodelTestGlobalResult globalResult = new WodelTestGlobalResult();
				IJavaProject javaProject = JavaCore.create(project);
				IClasspathEntry[] entries = javaProject.getRawClasspath();
				IClasspathEntry srcEntry = null;
				for (int i = 0; i < entries.length; i++) {
					IPath entryPath = entries[i].getPath();
					if (entryPath.lastSegment().equals("src")) {
						srcEntry = entries[i];
						break;
					}
				}
				Thread current = Thread.currentThread();
				ClassLoader oldLoader = current.getContextClassLoader();
				current.setContextClassLoader(testSuiteProject.getClass().getClassLoader());
				String className = artifactPath.substring(artifactPath.lastIndexOf(File.separator) + 1, artifactPath.length() - ".java".length());
				String packageName = artifactPath.substring(artifactPath.indexOf(project.getName() + File.separator) + (project.getName() + File.separator).length(), artifactPath.length());
				if (packageName.indexOf("." + className) > 0) {
					packageName = packageName.substring(0, packageName.indexOf("." + className));
				}
				String folderPath = "/" + project.getName() + "/" + artifactPath.substring(artifactPath.indexOf(File.separator + packageName + "." + className) + File.pathSeparator.length(), artifactPath.length());
				folderPath = folderPath.substring(0, folderPath.lastIndexOf(File.separator + "src"));
				String javaFileName = className.substring(className.lastIndexOf(".") + 1, className.length()) + ".java";
				String srcJavaFilePath = "";
				String projectName = project.getName();
				String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getLocation().toFile().getPath().replace("\\", "/");
				workspacePath = workspacePath.substring(0, workspacePath.lastIndexOf("/" + projectName));
				if (packageName.length() > 0) {
					srcJavaFilePath = workspacePath + "/" + srcEntry.getPath().toString() + "/" + packageName.replace(".", "/") + "/" + javaFileName;						
				}
				else {
					srcJavaFilePath = workspacePath + "/" + srcEntry.getPath().toString() + "/" + javaFileName;
				}
				String newSrcPath = srcJavaFilePath.replace(".java", ".bak");
				IOUtils.copyFile(srcJavaFilePath, newSrcPath);
				IOUtils.copyFile(artifactPath, srcJavaFilePath);
				compile(project);
				Class<?>[] classes = WodelTestUtils.loadClasses(testSuiteProject, this, null);
				WodelTest.setJUnitVersion(classes);
				List<List<Object>> clazzObject = new ArrayList<List<Object>>();
				for (Class<?> clazz : classes) {
					List<Object> tests = new ArrayList<Object>();
					switch(WodelTest.jUnitVersion) {
					case JUNIT5: 
						tests.addAll(WodelTest.getTestsJUnit5(clazz));
						break;
					case JUNIT4: 
						tests.addAll(WodelTest.getTestsJUnit4(clazz));
						break;
					case JUNIT3: 
						tests.addAll(WodelTest.getTestsJUnit3(clazz));
						break;
					case UNKNOWN: 
						break;
					}
					clazzObject.add(tests);
				}
				int i = 0;
				SubMonitor subMonitor = SubMonitor.convert(monitor, "Processing test suite " + testSuiteProject.getName() + " for " + mutantName + " (" + classes.length + "/" + totalWork + ")", classes.length);
				subMonitor.setWorkRemaining(classes.length);
				subMonitor.beginTask("Processing test suite " + testSuiteProject.getName() + " for " + mutantName + " (" + classes.length + "/" + totalWork + ")", classes.length);
				for (Class<?> clazz : classes) {
					i++;
					List<Object> tests = clazzObject.get(i - 1);
					subMonitor.subTask("Processing " + tests.size() + " test cases found in '" + clazz.getName() + "(" + i + "/" + classes.length + ")");
					subMonitor.worked(1);
					if (tests.size() > 0) {
						runTest(globalResult, clazz, tests, project, folderPath, artifactPath, false);
						if (globalResult.getStatus() != Status.OK) {
							break;
						}
					}
				}
				WodelTestUtils.awaitFile(newSrcPath, TIME_SLEEP);
				File newSrc = new File(newSrcPath);
				if (newSrc != null && newSrc.exists()) {
					IOUtils.copyFile(newSrcPath, srcJavaFilePath);
					IOUtils.deleteFile(newSrcPath);
				}
				current.setContextClassLoader(oldLoader);
				globalResultMap.put(testSuiteProject, globalResult);
			}
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return globalResultMap;
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects,
			String artifactPath, int port, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects,
			String artifactPath, List<Thread> threads, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}
}
