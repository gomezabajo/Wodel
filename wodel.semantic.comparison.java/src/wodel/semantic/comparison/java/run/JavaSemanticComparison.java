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
	
	private static final int MAX_SIZE = 32768;
	private static final int TIME_SLEEP = 100;
	
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
			String folder = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getLocation().toFile().getPath().replace("\\", "/") + "/temp/" + folderName + "/" + modelName.replace(".model", "") + "/src/";
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
		byte[] byteArray = new byte[0];
		File srcFile = new File(path);
		if (srcFile != null && srcFile.exists() && srcFile.isFile()) {
			String bytecodePath = getBytecodePath(project, javaProject, srcFile, packageName);
			boolean bytecodeGenerated = WodelTestUtils.awaitFile(bytecodePath, TIME_SLEEP);
			if (!bytecodeGenerated) {
				return byteArray;
			}
			File bytecode = new File(bytecodePath);
			if (bytecode != null && bytecode.exists() && bytecode.isFile()) {
				byteArray = getBytesFromFile(bytecode);
			}
		}
		return byteArray;
	}
	
	private byte[] getBytecodeFromSeed(IProject project, String path, Resource model) {
		String mutantName = path.replace("\\", "/");
		String packageName = mutantName.substring(mutantName.indexOf("/data/model/") + ("/data/model/").length(), mutantName.length());
		packageName = packageName.substring(0, packageName.lastIndexOf(".")).replace(".", "/");
		mutantName = mutantName.substring(mutantName.lastIndexOf("/") + 1, mutantName.length()).replace(".model", "");
		String className = mutantName;
		if (className.indexOf(".") != - 1) {
			className = className.substring(className.indexOf(".") + 1, className.length());
		}
		packageName = packageName.substring(0, packageName.lastIndexOf("/"));
		IJavaProject javaProject = JavaCore.create(project);
		String javaFileName = className + ".java";
		String srcJavaFilePath = project.getLocation().toFile().getPath() + "/src/" + packageName + "/" + javaFileName;
		compile(project);
		return getBytecode(project, javaProject, model, "", javaFileName, srcJavaFilePath, packageName);
	}
	
	/*
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
	*/
	
	private boolean applyTCE(byte[] byteArrayModel1, Resource resource1, String model1, Resource resource2, String model2, boolean[] processed, IProject project) {
		boolean isRepeated = false;
		if (byteArrayModel1 == null) {
			return isRepeated;
		}
		try {
			IJavaProject javaProject = JavaCore.create(project);
			IClasspathEntry[] entries = javaProject.getRawClasspath();
			AcceleoUtils.SwitchSuccessNotification(false);
			byte[] byteArrayModel2 = new byte[0];
			final IFolder iFolder = project.getFolder(new Path("temp"));
			if (iFolder.exists() == false) {
				iFolder.create(true, true, new NullProgressMonitor());
			}
			final IFolder iBytecodeFolder = iFolder.getFolder(new Path("class"));
			if (iBytecodeFolder.exists() == false) {
				iBytecodeFolder.create(true, true, new NullProgressMonitor());
			}
			String mutantName = model1.replace("\\", "/");
			String packageName = "";
			if (mutantName.indexOf("/data/model/") != -1) {
				packageName = mutantName.substring(mutantName.indexOf("/data/model/") + ("/data/model/").length(), mutantName.length());
			}
			if (mutantName.indexOf("/data/out/") != -1) {
				packageName = mutantName.substring(mutantName.indexOf("/data/out/") + ("/data/out/").length(), mutantName.length());
			}
			if (packageName.indexOf(".") > packageName.lastIndexOf("/")) {
				packageName = packageName.substring(packageName.lastIndexOf("/") + 1, packageName.lastIndexOf(".")).replace(".", "/");
				packageName = packageName.substring(0, packageName.lastIndexOf("/"));
				mutantName = mutantName.substring(mutantName.lastIndexOf("/") + 1, mutantName.length()).replace(".model", "");
				//GET BYTECODE FOR MUTANT PROGRAM
				String className = mutantName;
				if (className.indexOf(".") != - 1) {
					className = className.substring(className.indexOf(".") + 1, className.length());
				}
				String javaFileName = className + ".java";
				String srcJavaFilePath = project.getLocation().toFile().getPath() + "/src/" + packageName + "/" + javaFileName;
				String newSrcPath = srcJavaFilePath.replace(".java", ".bak");
				IOUtils.copyFile(srcJavaFilePath, newSrcPath);
				mutantName = model2.replace("\\", "/");
				String block = mutantName.substring(0, mutantName.lastIndexOf("Output") - 1);
				if (block.indexOf("/") != -1) {
					block = block.substring(block.lastIndexOf("/") + 1, block.length());
				}
				mutantName = mutantName.substring(mutantName.lastIndexOf("/") + 1, mutantName.length()).replace(".model", "");
				modelToProject(resource2, block, mutantName, project.getName());
				String artifactPath = project.getLocation().toFile().getPath() + "/temp/" + block + "/" + mutantName + "/src/" + packageName + "/" + javaFileName;
				if (new File(artifactPath).exists()) {
					IOUtils.copyFile(artifactPath, srcJavaFilePath);
					compile(project);
					byteArrayModel2 = getBytecode(project, javaProject, resource2, block, javaFileName, artifactPath, packageName);
				}
				else {
					byteArrayModel2 = null;
				}
				IOUtils.copyFile(newSrcPath, srcJavaFilePath);
				IOUtils.deleteFile(newSrcPath);
			}
			else if (packageName.indexOf(".") != -1) {
				String firstPck = packageName.substring(0, packageName.indexOf("."));
				firstPck = firstPck.substring(firstPck.lastIndexOf("/") + 1, firstPck.length());
				packageName = firstPck + "." + packageName.substring(packageName.indexOf(".") + 1, packageName.lastIndexOf("/"));
				packageName = packageName.replace(".", "/");
				String className = model2.substring(0, model2.lastIndexOf("."));
				if (className.indexOf(".") != -1) {
					className = className.substring(className.lastIndexOf(".") + 1, className.length());
				}
				//GET BYTECODE FOR MUTANT PROGRAM
				String javaFileName = className + ".java";
				String srcJavaFilePath = project.getLocation().toFile().getPath() + "/src/" + packageName + "/" + javaFileName;
				String newSrcPath = srcJavaFilePath.replace(".java", ".bak");
				IOUtils.copyFile(srcJavaFilePath, newSrcPath);
				String block = packageName.substring(packageName.lastIndexOf("/") + 1, packageName.length());
				packageName = packageName.substring(packageName.lastIndexOf("/" + className + "/"));
				mutantName = mutantName.substring(mutantName.lastIndexOf("/") + 1, mutantName.length()).replace(".model", "");
				String artifactPath = project.getLocation().toFile().getPath() + "/" + packageName.replace("/", ".") + "." + className + "/" + block + "/" + mutantName + "/src/" + packageName + "/" + javaFileName;
				if (new File(artifactPath).exists()) {
					IOUtils.copyFile(artifactPath, srcJavaFilePath);
					compile(project);
					byteArrayModel2 = getBytecode(project, javaProject, resource2, block, javaFileName, artifactPath, packageName);
				}
				else {
					byteArrayModel2 = null;
				}
				IOUtils.copyFile(newSrcPath, srcJavaFilePath);
				IOUtils.deleteFile(newSrcPath);
			}
			javaProject.setRawClasspath(entries, new NullProgressMonitor());
			compile(project);
			if (byteArrayModel2 != null) {
				isRepeated = Arrays.equals(byteArrayModel1, byteArrayModel2);
				processed[0] = true;
			}
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
	public boolean doCompare(List<String> metamodels, String model1, String model2, IProject project, boolean[] processed, Class<?> cls) {
		Resource resource1 = null;
		Resource resource2 = null;
		model1 = model1.replace("\\\\", "/");
		model2 = model2.replace("\\\\", "/");
		boolean ret = false;
		try {
			List<EPackage> packages = ModelManager.loadMetaModels(metamodels, cls);
			if (this.getSeedPath() == null) {
				this.setSeedPath(model1);
				resource1 = ModelManager.loadModel(packages, this.getSeedPath());
				byte[] byteArrayModel1 = getBytecodeFromSeed(project, model1, resource1);
				if (byteArrayModel1 != null) {
					this.setSeedCompiled(byteArrayModel1);
				}
				resource1.unload();
			}
			if (resource1 == null) {
				resource1 = ModelManager.loadModel(packages, this.getSeedPath());
			}
			resource2 = ModelManager.loadModel(packages, model2);
			//If it is a Wodel project
			if (project.hasNature(JavaCore.NATURE_ID) && project.hasNature(WodelNature.NATURE_ID)) {
				System.out.println("Warning:");
				System.out.println("This comparison extension can only be used in the tester instance.");
				System.out.println("Using default syntactic comparison.");
				ret = ModelManager.compareModels(resource1, resource2);
			}
			else {
				System.out.println("Warning:");
				System.out.println("This comparison extension can only be used in the tester instance.");
				System.out.println("Using TCE semantic comparison.");
				byte[] seedBytecode = this.getSeedCompiled() != null ? (byte[]) this.getSeedCompiled() : null;
				ret = applyTCE(seedBytecode, resource1, model1, resource2, model2, processed, project);
			}
			resource2.unload();
			resource1.unload();
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
