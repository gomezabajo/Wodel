package wodeledu;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import manager.IOUtils;
import manager.ModelManager;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;

import wodeledu.dsls.ModelTextUtils;
import wodeledu.dsls.MutaTextUtils;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import exceptions.MetaModelNotFoundException;
import generator.IGenerator;

/**
 * @author Pablo Gomez-Abajo
 * 
 * Wodel-edu: Wodel postprocessing application
 * extension for the automated generation of exercises
 * 
 */
public class Generator implements IGenerator {


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Wodel-Edu: Generation of a web environment with test exercises for education";
	}

	@Override
	public boolean doGenerate(String fileName, String metamodel, String project, String outputPath, IProject mutProject, IFolder srcPath, IFolder configPath, 
			IProgressMonitor monitor) {
		Path filePath = new Path(fileName);
		String fileExtension = filePath.getFileExtension();
		String graphFileName = fileName.replace(fileExtension, "graph");
		// create a sample file
		monitor.beginTask("Creating " + graphFileName, 2);
		String testsFileName = fileName.replace(fileExtension, "test");
		String idelemsFileName = fileName.replace(fileExtension, "modeltext");
		String cfgoptsFileName = fileName.replace(fileExtension, "mutatext");
		
		final IFile graphFile = srcPath.getFile(new Path(graphFileName));
		try {
			InputStream stream = openContentStream();
			String def = "";
			if (metamodel != null) {
				def += "metamodel \"" + ModelManager.getMetaModelPath(project) + "/" + metamodel + "\"\n\n";
			}
			else {
				def = "metamodel \"\" //fill this with the path to the meta-model\n\n";
			}
			
			if (metamodel != null) {
				List<EPackage> packages = ModelManager.loadMetaModel(ModelManager.getMetaModelPath(project) + "/" + metamodel);
				ArrayList<EClass> eclasses = ModelManager.getEClasses(packages);
				EClass eclass = eclasses.get(1);
				EList<EAttribute> eatts = eclass.getEAllAttributes();
				EAttribute eatt = null;
				if (eatts != null) {
					if (eatts.size() > 0) {
						eatt = eatts.get(0);
					}
				}
				EClass rooteclass = eclasses.get(0);
				def += rooteclass.getName() + ": diagram {\n";
				if (eatt != null) {
					def += "\t" + eclass.getName() + "(" + eatt.getName() + "): node shape=circle\n";
				}
			}
			else {
				def += "//RootNode: diagram {\n";
			}
			def += "\t//InitialNode(isInitial): markednode\n"
				+ "\t//SimpleNode(not isFinal): node shape=circle\n"
				+ "\t//EndingNode(isFinal): node shape=doublecircle\n"
				+ "\t//Relation(source, target): edge label=symbol\n"
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
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		final IFile testsFile = srcPath.getFile(new Path(testsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "navigation=free\n"
					+ "AlternativeResponse {\n"
					+ "\tretry=yes"
					+ "\t//description for 'model1-name.model' = 'Description for model1'\n"
					+ "\t//other descriptions...\n"
					+ "}\n"
					+ "MultiChoiceDiagram {\n"
					+ "\tretry=no"
					+ "\t//description for 'model1-name.model' = 'Description for model1'\n"
					+ "\t//other descriptions...\n"
					+ "}\n"
					+ "MultiChoiceEmendation {\n"
					+ "\tretry=yes, weighted=no, penalty=0.0, order=options-descending, mode=checkbox\n"
					+ "\t//description for 'model2-name.model' = 'Description for model2'\n"
					+ "\t//other descriptions...\n"
					+ "}";
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
		final IFile idelemsFile = srcPath.getFile(new Path(idelemsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "";
			if (metamodel != null) {
				def += "metamodel \"" + ModelManager.getMetaModelPath(project) + "/" + metamodel + "\"\n\n";
			}
			else {
				def = "metamodel \"\" //fill this with the path to the meta-model\n\n";
			}
			
			if (metamodel != null) {
				List<EPackage> packages = ModelManager.loadMetaModel(ModelManager.getMetaModelPath(project) + "/" + metamodel);
				ArrayList<EClass> eclasses = ModelManager.getEClasses(packages);
				EClass eclass = eclasses.get(0);
				EList<EAttribute> eatts = eclass.getEAllAttributes();
				EAttribute eatt1 = null;
				EAttribute eatt2 = null;
				if (eatts != null) {
					if (eatts.size() > 0) {
						eatt1 = eatts.get(0);
					}
					if (eatts.size() > 1) {
						eatt2 = eatts.get(1);
					}
				}
				if ((eatt1 != null) && (eatt2 != null)) {
					def += ">" + eclass.getName() + "(" + eatt2.getName() + "): " + eclass.getName() + " %" + eatt1.getName() + "\n";
				}
				if (eatt1 != null) {
					def += ">" + eclass.getName() + ": " + eclass.getName() + " %" + eatt1.getName() + "\n";
				}
			}
			def += "//>ClassName(attName): (LeftText %AttributeName|%ReferenceName.AttributeName RightText)+\n";
			if (idelemsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				idelemsFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				idelemsFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		String xTextFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() +'/' + mutProject.getFolder(new Path("/src/" + idelemsFileName)).getFullPath();
		String xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + '/' + mutProject.getFolder(new Path('/' + outputPath + '/' + idelemsFileName.replaceAll(".modeltext", "_modeltext.model"))).getFullPath();
		ModelTextUtils.serialize(xTextFileName, xmiFileName);

		final IFile cfgoptsFile = srcPath.getFile(new Path(cfgoptsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "";
			if (metamodel != null) {
				def += "metamodel \"" + ModelManager.getMetaModelPath(project) + "/" + metamodel + "\"\n\n";
			}
			else {
				def = "metamodel \"\" //fill this with the path to the meta-model\n\n";
			}
			
			def += "//>RegistryClassName(ClassName): (LeftOptionOkText %variable RightOptionOkText)+ /\n";
			def += "//\t\t(LeftOptionWrongText %variable RightOptionWrongText)+";
			if (cfgoptsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				cfgoptsFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				cfgoptsFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		
		xTextFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() +'/' + mutProject.getFolder(new Path("/src/" + cfgoptsFileName)).getFullPath();
		xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + '/' + mutProject.getFolder(new Path('/' + outputPath + '/' + cfgoptsFileName.replaceAll(".mutatext", "_mutatext.model"))).getFullPath();
		MutaTextUtils.serialize(xTextFileName, xmiFileName);
		
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
		try {
		//Bundle bundle = Platform.getBundle("wodel.wodeledu");
		//URL fileURL = bundle.getEntry("content");
		final File jarFile = new File(Generator.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String srcName = "";
		if (jarFile.isFile()) {
			final JarFile jar = new JarFile(jarFile);
			final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		    while(entries.hasMoreElements()) {
		    	JarEntry entry = entries.nextElement();
		    	if (! entry.isDirectory()) {
		    		if (entry.getName().startsWith("content")) {
		    			final File f = htmlFolder.getRawLocation().makeAbsolute().toFile();
		    			File path = new File(f.getPath() + '/' + entry.getName().replace("content/", "").split("/")[0]);
		    			if (!path.exists()) {
		    				path.mkdir();
		    			}
		    			File dest = new File(f.getPath() + '/' + entry.getName().replace("content/", ""));
		    			InputStream input = jar.getInputStream(entry);
		    			FileOutputStream output = new FileOutputStream(dest);
		    			while (input.available() > 0) {
		    				output.write(input.read());
		    			}
		    			output.close();
		    			input.close();
		    		}
	    		}
		    }
		    jar.close();
		}
		else {
			srcName = Generator.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "content";
			final File src = new Path(srcName).toFile();
			final File dest = htmlFolder.getRawLocation().makeAbsolute().toFile();
			if ((src != null) && (dest != null)) {
				IOUtils.copyFolder(src, dest);
			}
		}
		} catch (IOException e) {
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

		URLClassLoader classLoader = null;
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
					classLoader = new URLClassLoader(urls,
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
		
		final IFile testsFile = file.getParent().getFile(new Path(file.getName().replace(".mutator", ".test")));
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
		
		try {
			classLoader.close();
		} catch (IOException e) {
			e.printStackTrace();
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
