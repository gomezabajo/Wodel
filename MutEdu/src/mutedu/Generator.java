package mutedu;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import manager.IMutatorGraph;
import mutextension.generator.IGenerator;

public class Generator implements IGenerator {


	public static void copyFolder(File src, File dest) throws IOException {
		
		if (src.isDirectory()) {

			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdir();
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile);
			}

		} else {
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Wodel-Edu: Generation of a web environment with test exercises for education";
	}

	@Override
	public boolean doGenerate(String fileName, IProject mutProject, IFolder srcPath, IFolder configPath, 
			IProgressMonitor monitor) {
		Path filePath = new Path(fileName);
		String fileExtension = filePath.getFileExtension();
		String graphFileName = fileName.replace(fileExtension, "graph");
		// create a sample file
		monitor.beginTask("Creating " + graphFileName, 2);
		String testsFileName = fileName.replace(fileExtension, "tests");
		final IFile graphFile = srcPath.getFile(new Path(graphFileName));
		try {
			InputStream stream = openContentStream();
			String def = "metamodel \"\" //fill this with the path to the meta-model\n\n"
					+ "RootClass -> diagram {\n"
					+ "\tStartingNode(isInitial) -> markednode\n"
					+ "\tSimpleNode(not isFinal) -> node, shape=circle\n"
					+ "\tEndingNode(isFinal) -> node, shape=doublecircle\n"
					+ "\tRelation(source, target) -> edge, label=symbol\n"
					+ "}";
			if (graphFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				graphFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				graphFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		final IFile testsFile = srcPath.getFile(new Path(testsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "retry=yes, showall=yes\n\n"
					+ "description for 'model1-name.model' = ''\n";
			if (testsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				testsFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				testsFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		
		final IFile configFile = configPath.getFile(new Path("config.txt"));
		try {
			InputStream stream = configFile.getContents();
			if (configFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += "\n" + this.getName();
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				configFile.setContents(stream, true, true, monitor);
			}
			else {
				configFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		
		final IFolder srcgenFolder = mutProject.getFolder(new Path("src-gen"));
		try {
			srcgenFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		final IFolder htmlFolder = srcgenFolder.getFolder(new Path("html"));
		try {
			htmlFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		String srcName = Generator.class.getProtectionDomain().getCodeSource().getLocation().getFile() + "content/";
		final File src = new Path(srcName).toFile();
		final File dest = htmlFolder.getRawLocation().makeAbsolute().toFile();
		
		if ((src != null) && (dest != null)) {
			try {
				copyFolder(src, dest);
			} catch (IOException e) {
			}
		}
		
		return false;
	}
	
	@Override
	public void doRun(IFile file) {
		Class<?> cls = null;
		String fileName = file.getName();
		String classname = fileName.replaceAll(".mutator", "") + "_Graph";
		
		try {
			cls = Class.forName(classname);
		} catch (ClassNotFoundException e) {
		}
		
		if (cls == null) {
			try {
				IProject project = file.getProject();
				if (project.hasNature(JavaCore.NATURE_ID)) {
					IJavaProject javaProject = JavaCore.create(project);
					// read class path entries of the project
					String[] classPathEntries = JavaRuntime
							.computeDefaultRuntimeClassPath(javaProject);
					List<URL> urlList = new ArrayList<URL>();
					for (String classPathEntry : classPathEntries) {
						Path path = new Path(classPathEntry);
						urlList.add(path.toFile().toURI().toURL());
					}
					// create url class loader whose parent is the class loader
					// of the project
					// and containing the class path entries of the project
					ClassLoader parentClassLoader = project.getClass()
							.getClassLoader();
					URL[] urls = (URL[]) urlList
							.toArray(new URL[urlList.size()]);
					URLClassLoader classLoader = new URLClassLoader(urls,
							parentClassLoader);
					// load class
					cls = classLoader.loadClass(classname);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Object ob = null;
		try {
			ob = cls.newInstance();
			Method m = cls.getMethod("generate");
			m.invoke(ob);
			// ime = (IMutatorExecutor)ob;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		final IFile testsFile = file.getParent().getFile(new Path(file.getName().replace(".mutator", ".tests")));
		try {
			InputStream stream = testsFile.getContents();
			if (testsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				testsFile.setContents(stream, true, true, null);
			}
			else {
				testsFile.create(stream, true, null);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}

	}

	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// TODO Auto-generated method stub

	}

	/**
	 * We will initialize file contents with a sample text.
	 */

	private InputStream openContentStream() {
		String contents = "";
		return new ByteArrayInputStream(contents.getBytes());
	}
}
