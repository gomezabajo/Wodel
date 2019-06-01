package manager;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

public interface IWodelTest {
	
	public static final String EQUALS = "Equals";
	public static final String DIFFERENT = "Different";
	
	public String getProjectName();
	
	public String getNatureId();
	
	public void compile(IProject project);
	
	public List<String> artifactPaths(IProject project, String projectPath, File outputFolder, List<String> blockNames);
	
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath);
	
	public void projectToModel(String projectName, Class<?> cls);
	
	public boolean modelToProject(String className, Resource model, String folderName, String modelName, String projectName, Class<?> cls);
	
	public String getContainerEClassName();
	
	public boolean annotateMutation(Resource model, EObject container, String annotation);
}
