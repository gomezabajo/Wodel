package mutator.wodeltest.designer;

import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.WodelTestGlobalResult;
import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.core.runtime.IProgressMonitor;

public class WodelTest implements IWodelTest {

	@Override
	public String getProjectName() {
		return "designer";
	}

	@Override
	public String getNatureId() {
		return "";
	}

	@Override
	public void compile(IProject project) {
	}

	@Override
	public List<String> artifactPaths(IProject project, String projectPath, File outputFolder, List<String> blockNames) {
		return null;
	}

	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath, IProgressMonitor monitor) {
		return null;
	}

	@Override
	public void projectToModel(String projectName, Class<?> cls) {
	}

	@Override
	public void projectToModel(IProject project, Class<?> cls) {
	}

	@Override
	public boolean modelToProject(String className, Resource model, String folderName, String modelName, String projectName, Class<?> cls) {
		return false;
	}

	@Override
	public boolean modelToProject(String className, Resource model, String folderName, String modelName, IProject project, Class<?> cls) {
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
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath, int port, IProgressMonitor monitor) {
	return null;
	}

	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath, List<Thread> threads, IProgressMonitor monitor) {
		return null;
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects, String artifactPath, IProgressMonitor monitor) {
		return null;
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects, String artifactPath, int port, IProgressMonitor monitor) {
		return null;
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects, String artifactPath, List<Thread> threads, IProgressMonitor monitor) {
		return null;
	}
}