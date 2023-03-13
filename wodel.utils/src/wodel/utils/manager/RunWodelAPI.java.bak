package manager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.TreeMap;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

public class RunWodelAPI {
	
	/**
	 * @author Pablo Gomez-Abajo - Wodel external execution 
	 *  
	 */

	public static void generateMutants(IProject project, String inputPath, String outputPath) {
		File inputFolder = new File(inputPath);
		if (!inputFolder.exists() || !inputFolder.isDirectory()) {
			System.out.println("The input models path does not exist or it is not a folder");
			return;
		}
		File outputFolder = new File(outputPath);
		if (outputFolder.exists()) {
			IOUtils.deleteFolder(outputFolder.getPath());
			try {
				String outputFolderPath = outputFolder.getPath();
				Files.createDirectories(Paths.get(outputFolderPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		File currentInputFolder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/data/model");
		if (!currentInputFolder.exists()) {
			try {
				String currentInputFolderPath = currentInputFolder.getPath();
				Files.createDirectories(Paths.get(currentInputFolderPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (currentInputFolder.listFiles() != null) {
			for (File file : currentInputFolder.listFiles()) {
				if (file.getName().endsWith(".model")) {
					IOUtils.deleteFile(file.getPath());
				}
			}
		}
		if (inputFolder.listFiles() != null) {
			for (File file : inputFolder.listFiles()) {
				if (file.getName().endsWith(".model")) {
					IOUtils.copyFile(file.getPath(), currentInputFolder.getPath() + "/" + file.getName());
				}
			}
		}
		File currentOutputFolder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/data/out");
		if (!currentOutputFolder.exists()) {
			try {
				String currentOutputFolderPath = currentOutputFolder.getPath();
				Files.createDirectories(Paths.get(currentOutputFolderPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (currentOutputFolder.listFiles() != null) {
			for (File file : currentOutputFolder.listFiles()) {
				if (file.isDirectory()) {
					IOUtils.deleteFolder(file.getPath());
				}
			}
		}
		
		System.out.println("Starting Wodel process. Wait until the process ends.");
		try {
			String classname = "mutator." + project.getName() + "." + project.getName().replaceAll("[.]", "_") + "Launcher";
			Class<?> cls = WodelTestUtils.loadClass(project, classname);
			Object ob = cls.getDeclaredConstructor().newInstance();
			Method m = cls.getMethod("execute", new Class[]{int.class, int.class, boolean.class, boolean.class, boolean.class, String[].class, IProject.class, IProgressMonitor.class, boolean.class, Object.class, TreeMap.class, HashMap.class});
			int maxAttempts = 30;
			int numMutants = 5;
			boolean registry = true;
			boolean metrics = true;
			boolean debugMetrics = true;
			m.invoke(ob, maxAttempts, numMutants, registry, metrics, debugMetrics, null, project, new NullProgressMonitor(), true, null, null, null);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		try {
			IOUtils.copyFolder(currentOutputFolder, outputFolder);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Process finished.");
	}
}
