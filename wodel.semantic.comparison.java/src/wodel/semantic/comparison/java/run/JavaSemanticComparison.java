package wodel.semantic.comparison.java.run;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.modisco.java.emf.JavaPackage;
import org.eclipse.modisco.java.generation.files.GenerateJavaExtended;
import wodel.semantic.comparison.run.SemanticComparison;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.AcceleoUtils;
import wodel.utils.manager.IOUtils;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.WodelTestUtils;
import wodel.project.builder.WodelNature;

public class JavaSemanticComparison extends SemanticComparison {
	
	private static int MAX_SIZE = 32768;

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
			String folder = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getLocation().toFile().getPath() + "/temp/" + folderName + "/" + modelName.replace(".model", "") + "/src/";
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

	private byte[] getBytesFromFile(File file) {
		byte[] bytes = null;
		try {
			FileInputStream is = new FileInputStream(file);
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			int ret = -1;
			byte[] data = new byte[MAX_SIZE];
			while ((ret = is.read(data, 0, data.length)) != -1) {
				os.write(data, 0, ret);
			}
			is.close();
			bytes = os.toByteArray();
			os.close();
			return data;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}
	
	private String getBytecodePath(IProject project, IJavaProject javaProject, File srcFile, String packagename) {
		String bytecodePath = null;
		if (srcFile.isFile() && srcFile.getName().endsWith(".java")) {
			String classname = srcFile.getName().replace(".java", "");
			bytecodePath = project.getLocation().toFile().getPath() + "/bin/" + packagename + "/" + classname + ".class";
		}
		return bytecodePath;
	}
	
	private byte[] getBytecode(IProject project, IJavaProject javaProject, Resource model, String folderName, String modelName, String path, String packageName) {
		byte[] byteArray = null;
		try {
			File srcFile = new File(path);
			if (srcFile.isFile()) {
				String bytecodePath = getBytecodePath(project, javaProject, srcFile, packageName);
				WodelTestUtils.awaitFile(bytecodePath, 2000);
				File bytecode = new File(bytecodePath);
				while (!bytecode.exists()) {
					WodelTestUtils.awaitFile(bytecodePath, 2000);
				}
				String classname = bytecodePath.substring(bytecodePath.lastIndexOf("/") + 1, bytecodePath.lastIndexOf("."));
				String tmpBytecodeName1 = project.getLocation().toFile().getPath() + "/temp/class/" + classname + "." + modelName.replace(".model", "") + ".tmp";
				IOUtils.copyFile(bytecode.getPath(), tmpBytecodeName1);
				File tmpBytecode = new File(tmpBytecodeName1);
				byteArray = getBytesFromFile(tmpBytecode);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byteArray;
	}
	
	private boolean applyTCE(Resource resource1, String model1, Resource resource2, String model2, IProject project) {
		boolean isRepeated = false;
		try {
			AcceleoUtils.SwitchSuccessNotification(false);
			final IFolder iFolder = project.getFolder(new Path("temp"));
			if (iFolder.exists() == false) {
				iFolder.create(true, true, new NullProgressMonitor());
			}
			final IFolder iBytecodeFolder = iFolder.getFolder(new Path("class"));
			if (iBytecodeFolder.exists() == false) {
				iBytecodeFolder.create(true, true, new NullProgressMonitor());
			}
			// GET BYTCODE FOR FIRST PROGRAM
			String mutantName = model1.replace("\\", "/");
			String packageName = mutantName.substring(mutantName.indexOf("/data/model/") + ("/data/model/").length(), mutantName.length());
			packageName = packageName.substring(0, packageName.lastIndexOf(".")).replace(".", "/");
			mutantName = mutantName.substring(mutantName.lastIndexOf("/") + 1, mutantName.length()).replace(".model", "");
			String className = packageName.substring(packageName.lastIndexOf("/") + 1, packageName.length());
			packageName = packageName.substring(0, packageName.lastIndexOf("/"));
			modelToProject(resource1, "", mutantName, project.getName());
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
			String srcJavaFilePath = project.getLocation().toFile().getPath() + "/src/" + packageName + "/" + javaFileName;
			String newSrcPath = srcJavaFilePath.replace(".java", ".bak");
			IOUtils.copyFile(srcJavaFilePath, newSrcPath);
			compile(project);
			byte[] byteArrayModel1 = getBytecode(project, javaProject, resource1, "", className + ".java", srcJavaFilePath, packageName);

			//GET BYTECODE FOR SECOND PROGRAM
			mutantName = model2.replace("\\", "/");
			String block = mutantName.substring(0, mutantName.lastIndexOf("Output") - 1);
			if (block.indexOf("/") != -1) {
				block = block.substring(block.lastIndexOf("/") + 1, block.length());
			}
			mutantName = mutantName.substring(mutantName.lastIndexOf("/") + 1, mutantName.length()).replace(".model", "");
			modelToProject(resource2, block, mutantName, project.getName());
			String artifactPath = project.getLocation().toFile().getPath() + "/temp/" + block + "/" + mutantName + "/src/" + packageName + "/" + className + ".java";
			IOUtils.copyFile(artifactPath, srcJavaFilePath);
			compile(project);
			byte[] byteArrayModel2 = getBytecode(project, javaProject, resource2, block, className + ".java", artifactPath, packageName);

			IOUtils.copyFile(newSrcPath, srcJavaFilePath);
			IOUtils.deleteFile(newSrcPath);

			javaProject.setRawClasspath(entries, new NullProgressMonitor());
			compile(project);

			isRepeated = Arrays.equals(byteArrayModel1, byteArrayModel2);
			iBytecodeFolder.delete(true, new NullProgressMonitor());
			iFolder.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRepeated;
	}

	@Override
	public String getName() {
		return "Java program semantic comparison";
	}

	@Override
	public String getURI() {
		return "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java";
	}

	@Override
	public boolean doCompare(List<String> metamodels, String model1, String model2, IProject project, Class<?> cls) {
		Resource resource1 = null;
		Resource resource2 = null;
		model1 = model1.replace("\\\\", "/");
		model2 = model2.replace("\\\\", "/");
		boolean ret = false;
		try {
			List<EPackage> packages = ModelManager.loadMetaModels(metamodels, cls);
			resource1 = ModelManager.loadModel(packages, model1);
			resource2 = ModelManager.loadModel(packages, model2);
			//If it is a Wodel project
			if (project.hasNature(JavaCore.NATURE_ID) && project.hasNature(WodelNature.NATURE_ID)) {
				System.out.println("Warning:");
				System.out.println("This comparison extension can only be used in the tester instance.");
				System.out.println("Using default syntactic comparison.");
				ret = ModelManager.compareModels(resource1, resource2);
			}
			else {
				ret = applyTCE(resource2, model2, resource1, model1, project);
			}
			try {
				resource2.unload();
				resource1.unload();
			} catch (Exception e) {
			}
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
		return ret;
	}
}
