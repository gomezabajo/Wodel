package wodel.validate.java;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.java.emf.JavaPackage;
import org.eclipse.modisco.java.generation.files.GenerateJavaExtended;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IProblemRequestor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.core.compiler.IProblem;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.AcceleoUtils;
import manager.IOUtils;
import manager.ModelManager;
import wodel.validate.Validate;

public class JavaValidate extends Validate {
	
	@Override
	public String getName() {
		return "Java Program Validate";
	}
	
	@Override
	public String getURI() {
		return "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java";
	}
	
	private void compile(IProject project) {
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
			Job.getJobManager().join(ResourcesPlugin.FAMILY_MANUAL_BUILD, new NullProgressMonitor());
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
	
	public boolean modelToProject(Resource model, String folderName, String modelName, String projectName) {
		try {
			JavaPackage.eINSTANCE.eClass();
			AcceleoUtils.SwitchSuccessNotification(false);
			String folder = ModelManager.getWorkspaceAbsolutePath() + "/" + projectName + "/temp/" + folderName + "/" + modelName.replace(".model", "") + "/src/";
			//boolean serialized = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Serialize models", true, null);
			GenerateJavaExtended javaGenerator = new GenerateJavaExtended(model.getURI(),
				new File(folder), new ArrayList<Object>()); //serialized);
			//if (javaGenerator.status == true) {
				javaGenerator.doGenerate(null);
				return true;
			//}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private static List<ICompilationUnit> getCompilationUnits(IJavaProject javaProject) {
		List<ICompilationUnit> units = new LinkedList<ICompilationUnit>();
		try {
			IPackageFragmentRoot[] packageFragmentRoots = javaProject.getAllPackageFragmentRoots();
			for(int i = 0; i < packageFragmentRoots.length; i++) {
				IPackageFragmentRoot packageFragmentRoot = packageFragmentRoots[i];
				IJavaElement[] fragments = packageFragmentRoot.getChildren();
				for(int j = 0; j < fragments.length; j++) {
					IPackageFragment fragment = (IPackageFragment)fragments[j];
					IJavaElement[] javaElements = fragment.getChildren();
					for(int k = 0; k < javaElements.length; k++) {
						IJavaElement javaElement = javaElements[k];
						if(javaElement.getElementType() == IJavaElement.COMPILATION_UNIT) {
							units.add( (ICompilationUnit)javaElement);
						}
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return units;
	}
	
	private static class ProblemRequestor implements IProblemRequestor {

		public boolean hasErrors = false;
		@Override
		public void acceptProblem(IProblem problem) {
			if (problem.isError()) {
				hasErrors = true;
			}
		}

		@Override
		public void beginReporting() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void endReporting() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isActive() {
			// TODO Auto-generated method stub
			return true;
		}
		
		public ProblemRequestor() {
			hasErrors = false;
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static boolean hasErrors(List<ICompilationUnit> compilationUnits) {
		try {
			// use working copy to hold source with error
			for (ICompilationUnit compilationUnit : compilationUnits) {
				ProblemRequestor problemRequestor = new ProblemRequestor();
				compilationUnit.getWorkingCopy(new WorkingCopyOwner() {}, problemRequestor, null);
				if (problemRequestor.hasErrors == true) {
					return true;
				}
			}
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean isValid(String metamodel, String seed, String model, Class<?> cls, IProject project) {
		boolean isValid = false;
		
		try {
			AcceleoUtils.SwitchSuccessNotification(false);
			final IFolder iFolder = project.getFolder(new Path("temp"));
			if (iFolder.exists() == false) {
				iFolder.create(true, true, new NullProgressMonitor());
			}
			String mutantName = seed;
			if (mutantName.indexOf("\\") != -1) {
				mutantName = mutantName.substring(mutantName.lastIndexOf("\\") + 1, mutantName.length()).replace(".model", "");
			}
			if (mutantName.indexOf("/") != -1) {
				mutantName = mutantName.substring(mutantName.lastIndexOf("/") + 1, mutantName.length()).replace(".model", "");
			}
			String className = mutantName;
			String packageName = "";
			if (mutantName.lastIndexOf(".") != -1) {
				className = mutantName.substring(mutantName.lastIndexOf(".") + 1, mutantName.length());
				packageName = mutantName.substring(0, mutantName.lastIndexOf("."));
			}
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel, cls);
			Resource resource = ModelManager.loadModel(packages, model);
			modelToProject(resource, "", mutantName, project.getName());
			IJavaProject javaProject = JavaCore.create(project);
			IClasspathEntry[] entries = javaProject.getRawClasspath();
			IClasspathEntry srcEntry = null;
			//if it is a Java project
			if (project.hasNature(JavaCore.NATURE_ID)) {
				for (int i = 0; i < entries.length; i++) {
					IPath entryPath = entries[i].getPath();
					if (entryPath.lastSegment().equals("src")) {
						srcEntry = entries[i];
						break;
					}
				}
			}
			String javaFileName = className + ".java";
			String block = model.substring(0, model.lastIndexOf("Output") - 1);
			if (block.indexOf("\\") != -1) {
				block = block.substring(block.lastIndexOf("\\") + 1, block.length());
			}
			if (block.indexOf("/") != -1) {
				block = block.substring(block.lastIndexOf("/") + 1, block.length());
			}
			System.out.println("block: " + block);
			modelToProject(resource, block, mutantName, project.getName());
			String artifactPath = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/temp/" + block + "/" + mutantName + "/src/" + packageName + "/" + className + ".java";
			String srcJavaFilePath = ModelManager.getWorkspaceAbsolutePath() + srcEntry.getPath().toString() + "/" + packageName.replace(".", "/") + "/" + javaFileName;						
			String newSrcPath = srcJavaFilePath.replace(".java", ".bak");
			IOUtils.copyFile(srcJavaFilePath, newSrcPath);
			IOUtils.copyFile(artifactPath, srcJavaFilePath);
			compile(project);
			List<ICompilationUnit> compilationUnits = getCompilationUnits(javaProject);
			isValid = !hasErrors(compilationUnits);
			IOUtils.copyFile(newSrcPath, srcJavaFilePath);
			IOUtils.deleteFile(newSrcPath);
			iFolder.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
	}
}
