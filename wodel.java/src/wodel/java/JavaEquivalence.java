package wodel.java;

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
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmt.modisco.java.emf.JavaPackage;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import wodel.wodeltest.MyGenerateJavaExtended;
import builder.SampleNature;
import equivalence.run.Equivalence;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.AcceleoUtils;
import manager.IOUtils;
import manager.ModelManager;

public class JavaEquivalence extends Equivalence {
	
	private static int MAX_SIZE = 32768;
	
	@Override
	public String getName() {
		return "Java Program Equivalence";
	}
	
	@Override
	public String getURI() {
		return "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java";
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
		
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
			boolean serialized = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Serialize models", true, null);
			MyGenerateJavaExtended javaGenerator = new MyGenerateJavaExtended(model,
				new File(folder), new ArrayList<Object>(), serialized);
			if (javaGenerator.status == true) {
				javaGenerator.doGenerate(null);
				return true;
			}
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
			bytecodePath = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/bin/" + packagename + "/" + classname + ".class";
		}
		
		return bytecodePath;
	}
	
	private byte[] getBytecode(IProject project, IJavaProject javaProject, Resource model, String folderName, String modelName, String path, String packageName) {
		byte[] byteArray = null;
		try {
			System.out.println("path: " + path);
			File srcFile = new File(path);
			if (srcFile.isFile()) {
				String bytecodePath = getBytecodePath(project, javaProject, srcFile, packageName);
				System.out.println("bytecodePath: " + bytecodePath);
				File bytecode = new File(bytecodePath);
				while (!bytecode.exists()) {
					Thread.sleep(200);
				}
				String classname = bytecodePath.substring(bytecodePath.lastIndexOf("/") + 1, bytecodePath.lastIndexOf("."));
				String tmpBytecodeName1 = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/temp/class/" + classname + "." + modelName.replace(".model", "") + ".tmp";
				IOUtils.copyFile(bytecode.getPath(), tmpBytecodeName1);
				File tmpBytecode = new File(tmpBytecodeName1);
				byteArray = getBytesFromFile(tmpBytecode);
			}
		} catch (InterruptedException e) {
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
			String mutantName = model1.substring(model1.lastIndexOf("\\") + 1, model1.length()).replace(".model", "");
			String className = mutantName;
			String packageName = "";
			if (mutantName.lastIndexOf(".") > 0) {
				className = mutantName.substring(mutantName.lastIndexOf(".") + 1, mutantName.length());
				packageName = mutantName.substring(0, mutantName.lastIndexOf("."));
			}
			System.out.println("mutantName: " + mutantName);
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
			String srcJavaFilePath = ModelManager.getWorkspaceAbsolutePath() + srcEntry.getPath().toString() + "/" + packageName.replace(".", "/") + "/" + javaFileName;						
			String newSrcPath = srcJavaFilePath.replace(".java", ".bak");
			IOUtils.copyFile(srcJavaFilePath, newSrcPath);
			compile(project);
			byte[] byteArrayModel1 = getBytecode(project, javaProject, resource1, "", className + ".java", srcJavaFilePath, packageName);

			//GET BYTECODE FOR SECOND PROGRAM
			mutantName = model2.substring(model2.lastIndexOf("\\") + 1, model2.length()).replace(".model", "");
			System.out.println("mutantName: " + mutantName);
			String block = model2.substring(0, model2.lastIndexOf(mutantName) - 1);
			block = block.substring(block.lastIndexOf("\\") + 1, block.length());
			System.out.println("block: " + block);
			modelToProject(resource2, block, mutantName, project.getName());
			String artifactPath = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/temp/" + block + "/" + mutantName + "/src/" + packageName + "/" + className + ".java";
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
	public boolean doCompare(String metamodel, String model1, String model2, IProject project) {
		Resource resource1 = null;
		Resource resource2 = null;
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			resource1 = ModelManager.loadModel(packages, model1);
			resource2 = ModelManager.loadModel(packages, model2);
			//If it is a Wodel project
			if (project.hasNature(JavaCore.NATURE_ID) && project.hasNature(SampleNature.NATURE_ID)) {
				System.out.println("Warning:");
				System.out.println("This comparison extension can only be used in the tester instance.");
				System.out.println("Using default synctactic comparison.");
				return ModelManager.compareModels(resource1, resource2);
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
		return applyTCE(resource1, model1, resource2, model2, project);
	}
}
