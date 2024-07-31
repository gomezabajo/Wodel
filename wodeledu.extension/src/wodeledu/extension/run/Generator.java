package wodeledu.extension.run;

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
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import wodel.utils.manager.IOUtils;
import wodel.utils.manager.ModelManager;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.osgi.framework.Bundle;

import wodeledu.dsls.EduTestStandaloneSetup;
import wodeledu.dsls.EduTestUtils;
import wodeledu.dsls.ModelDrawStandaloneSetup;
import wodeledu.dsls.ModelDrawUtils;
import wodeledu.dsls.ModelTextUtils;
import wodeledu.dsls.MutaTextUtils;
import wodeledu.dsls.generator.modeldraw.ModelDrawGenerator;
import wodeledu.dsls.generator.modeldraw.ModelDrawPlantUMLGenerator;
import wodeledu.dsls.generator.modeldraw.ModelDrawDotGenerator;
import wodeledu.dsls.generator.modeldraw.ModelDrawCircuitGenerator;
import wodeledu.dsls.generator.edutest.EduTestAndroidAppGenerator;
import wodeledu.dsls.generator.edutest.EduTestGenerator;
import wodeledu.dsls.generator.edutest.EduTestMoodleGenerator;
import wodeledu.dsls.generator.edutest.EduTestWebGenerator;
import wodeledu.dsls.generator.edutest.EduTestiOSAppGenerator;

import wodeledu.extension.builder.WodelEduNature;
import wodeledu.utils.manager.WodelEduUtils;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.inject.Injector;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.extension.generator.IGenerator;

/**
 * @author Pablo Gomez-Abajo
 * 
 * Wodel-edu: Wodel postprocessing application
 * extension for the automated generation of exercises
 * 
 */
public class Generator implements IGenerator {

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

	private void addTextToFile(IFolder path, String fileName, String text, IProgressMonitor monitor) {
		IFile file = path.getFile(new Path(fileName));
		try {
			InputStream stream = file.getContents();
			if (file.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += text;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				file.setContents(stream, true, true, monitor);
			}
			else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Wodel-Edu: Environment for the automated generation and evaluation of exercises";
	}
	
	@Override
	public List<String> requiredBundles() {
		List<String> requiredBundles = new ArrayList<String>();
		requiredBundles.add("wodeledu.extension");
		requiredBundles.add("wodeledu.models");
		return requiredBundles;
	}
	
	@Override
	public List<String> importPackages() {
		List<String> importPackages = new ArrayList<String>();
		importPackages.add("org.apache.log4j");
		importPackages.add("org.eclipse.xtext.generator");
		importPackages.add("org.eclipse.xtext.xbase.lib");
		importPackages.add("org.eclipse.xtext.util");
		importPackages.add("wodeledu.dsls.generator.edutest");
		importPackages.add("wodeledu.dsls.generator.modeldraw");
		importPackages.add("com.google.inject");
		importPackages.add("javax.inject");
		importPackages.add("com.google.common.util.concurrent.internal");
		importPackages.add("org.antlr.runtime");
		importPackages.add("edutest");
		return importPackages;
	}

	@Override
	public boolean doGenerate(String fileName, String metamodel, String project, String outputPath, IProject mutProject, IFolder srcPath, IFolder configPath, 
			IProgressMonitor monitor) {
		Path filePath = new Path(fileName);
		String fileExtension = filePath.getFileExtension();
		String graphFileName = fileName.replace(fileExtension, "draw");
		// create a sample file
		monitor.beginTask("Creating " + graphFileName, 2);
		String testsFileName = fileName.replace(fileExtension, "test");
		String idelemsFileName = fileName.replace(fileExtension, "modeltext");
		String cfgoptsFileName = fileName.replace(fileExtension, "mutatext");
		
		final String modelName = ModelManager.getModelName(project);
		final IFile graphFile = srcPath.getFile(new Path(graphFileName));
		try {
			InputStream stream = openContentStream();
			String def = "";
			if (metamodel != null) {
				def += "metamodel \"/" + project + "/" + modelName + "/" + metamodel + "\"\n\n";
			}
			else {
				def = "metamodel \"\" //fill this with the path to the meta-model\n\n";
			}
			
			if (metamodel != null) {
				List<EPackage> packages = ModelManager.loadMetaModel(ModelManager.getMetaModelPath(project) + "/" + metamodel);
				List<EClass> eclasses = ModelManager.getEClasses(packages);
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
		
		String xTextFileName = "file:/" + mutProject.getLocation().toFile().getPath() + "/src/" + graphFileName;
		String xmiFileName = "file:/" + mutProject.getLocation().toFile().getPath() + "/" + outputPath + '/' + graphFileName.replaceAll(".draw", "_draw.model");
		ModelDrawUtils.serialize(xTextFileName, xmiFileName);
		
		final IFile testsFile = srcPath.getFile(new Path(testsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "metamodel \"/"+ project + "/" + modelName + "/" + metamodel + "\"\n\n" 
					+ "navigation=free\n"
					+ "AlternativeResponse {\n"
					+ "\tretry=yes\n"
					+ "\t//description for 'model1-name.model' = 'Description for model1'\n"
					+ "\t//other descriptions...\n"
					+ "}\n"
					+ "MultiChoiceDiagram {\n"
					+ "\tretry=no\n"
					+ "\t//description for 'model2-name.model' = 'Description for model2'\n"
					+ "\t//other descriptions...\n"
					+ "}\n"
					+ "MultiChoiceEmendation {\n"
					+ "\tretry=yes, weighted=no, penalty=0.0, order=options-descending, mode=checkbox\n"
					+ "\t//description for 'model3-name.model' = 'Description for model3'\n"
					+ "\t//other descriptions...\n"
					+ "}\n"
					+ "MatchPairs {\n"
					+ "\tretry=no, text='model2text'\n"
					+ "\t//description for 'model4-name.model' = 'Description for model4'\n"
					+ "\t//other descriptions...\n"
					+ "}\n"
					+ "MissingWords {\n"
					+ "\tretry=no\n"
					+ "\t//description for 'model5-name.model' = 'Description for model5'\n"
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
		xTextFileName = "file:/" + mutProject.getLocation().toFile().getPath() + "/src/" + testsFileName;
		xmiFileName = "file:/" + mutProject.getLocation().toFile().getPath() + "/" + outputPath + '/' + testsFileName.replaceAll(".test", "_test.model");
		EduTestUtils.serialize(xTextFileName, xmiFileName);

		final IFile idelemsFile = srcPath.getFile(new Path(idelemsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "";
			if (metamodel != null) {
				def += "metamodel \"/" + project + "/" + modelName + "/" + metamodel + "\"\n\n";
			}
			else {
				def = "metamodel \"\" //fill this with the path to the meta-model\n\n";
			}
			
			if (metamodel != null) {
				List<EPackage> packages = ModelManager.loadMetaModel(ModelManager.getMetaModelPath(project) + "/" + metamodel);
				List<EClass> eclasses = ModelManager.getEClasses(packages);
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
		xTextFileName = "file:/" + mutProject.getLocation().toFile().getPath() + "/src/" + idelemsFileName;
		xmiFileName = "file:/" + mutProject.getLocation().toFile().getPath() + "/" + outputPath + '/' + idelemsFileName.replaceAll(".modeltext", "_modeltext.model");
		ModelTextUtils.serialize(xTextFileName, xmiFileName);

		final IFile cfgoptsFile = srcPath.getFile(new Path(cfgoptsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "";
			if (metamodel != null) {
				def += "metamodel \"/" + project + "/" + modelName + "/" + metamodel + "\"\n\n";
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
		
		xTextFileName = "file:/" + mutProject.getLocation().toFile().getPath() + "/src/" + cfgoptsFileName;
		xmiFileName = "file:/" + mutProject.getLocation().toFile().getPath() + "/" + outputPath + '/' + cfgoptsFileName.replaceAll(".modeltext", "_modeltext.model");

		MutaTextUtils.serialize(xTextFileName, xmiFileName);
		
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
		    			String entryPath = entry.getName().replace("content/", "");
		    			String pathName = "";
		    			String[] entryFolders = entryPath.split("/");
		    			for (String entryFolder : Arrays.asList(entryFolders).subList(0, entryFolders.length - 1)) {
		    				pathName += entryFolder + "/";
		    			}
		    			String fName = entryFolders[entryFolders.length - 1];
		    			File path = new File(f.getPath() + "/" + pathName);
		    			if (!path.exists()) {
		    				path.mkdirs();
		    			}
		    			File dest = new File(f.getPath() + '/' + pathName + "/" + fName);
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
		
		final IFolder appFolder = mutProject.getFolder(new Path("app"));
		try {
			appFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		final IFolder mobileFolder = appFolder.getFolder(new Path("mobile"));
		try {
			mobileFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		
		final IFolder iOSFolder = appFolder.getFolder(new Path("ios"));
		try {
			iOSFolder.create(true, true, monitor);
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
		    		if (entry.getName().startsWith("mobile")) {
		    			final File f = mobileFolder.getRawLocation().makeAbsolute().toFile();
		    			String entryPath = entry.getName().replace("mobile/", "");
		    			String pathName = "";
		    			String[] entryFolders = entryPath.split("/");
		    			for (String entryFolder : Arrays.asList(entryFolders).subList(0, entryFolders.length - 1)) {
		    				pathName += entryFolder + "/";
		    			}
		    			String fName = entryFolders[entryFolders.length - 1];
		    			File path = new File(f.getPath() + "/" + pathName);
		    			if (!path.exists()) {
		    				path.mkdirs();
		    			}
		    			File dest = new File(f.getPath() + '/' + pathName + "/" + fName);
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
			srcName = Generator.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "mobile";
			final File src = new Path(srcName).toFile();
			final File dest = mobileFolder.getRawLocation().makeAbsolute().toFile();
			if ((src != null) && (dest != null)) {
				IOUtils.copyFolder(src, dest);
			}
		}
		} catch (IOException e) {
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
		    		if (entry.getName().startsWith("ios")) {
		    			final File f = iOSFolder.getRawLocation().makeAbsolute().toFile();
		    			String entryPath = entry.getName().replace("ios/", "");
		    			String pathName = "";
		    			String[] entryFolders = entryPath.split("/");
		    			for (String entryFolder : Arrays.asList(entryFolders).subList(0, entryFolders.length - 1)) {
		    				pathName += entryFolder + "/";
		    			}
		    			String fName = entryFolders[entryFolders.length - 1];
		    			File path = new File(f.getPath() + "/" + pathName);
		    			if (!path.exists()) {
		    				path.mkdirs();
		    			}
		    			File dest = new File(f.getPath() + '/' + pathName + "/" + fName);
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
			srcName = Generator.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "ios";
			final File src = new Path(srcName).toFile();
			final File dest = iOSFolder.getRawLocation().makeAbsolute().toFile();
			if ((src != null) && (dest != null)) {
				IOUtils.copyFolder(src, dest);
			}
		}
		} catch (IOException e) {
		}

		try {

			addTextToFile(configPath, "config.txt", "\n" + this.getName(), monitor);
			
			IProjectDescription description = mutProject.getDescription();

			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = WodelEduNature.NATURE_ID;

			// validate the natures
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IStatus status = workspace.validateNatureSet(newNatures);

			// only apply new nature, if the status is ok
			if (status.getCode() == IStatus.OK) {
				description.setNatureIds(newNatures);
				mutProject.setDescription(description, null);
			}
			
			//final IFolder metaInf = mutProject.getFolder("META-INF");
			//addTextToFile(metaInf, "MANIFEST.MF", "Export-Package: mutator." + mutProject.getName() + ",\n mutator.wodeltest." + mutProject.getName() + "\n", monitor);
			createPlugin(monitor, mutProject);
			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
		
	}
	
	@Override
	public void doRun(IFile file) {

		/*
		try {
			String xmiFileName = file.getProject().getLocation().toFile().getPath().replace("\\", "/") + "/" + ModelManager.getOutputFolder() + "/" + file.getName().replace(".mutator", "_draw.model");
			Bundle bundle = Platform.getBundle("wodeledu.models");
	   		URL fileURL = bundle.getEntry("/model/ModelDraw.ecore");
	   		String drawecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> drawpackages = ModelManager.loadMetaModel(drawecore);
			Resource drawmodel = ModelManager.loadModel(drawpackages, xmiFileName);
			String stringURI = "/resource/" + file.getProject().getName();
			stringURI = stringURI + "/src/" + file.getName().replace(".mutator", ".draw");
			if (drawmodel != null) {
				drawmodel.setURI(URI.createURI(stringURI));
				ModelDrawGenerator generator = new ModelDrawGenerator();
				Injector injector = new ModelDrawStandaloneSetup().createInjectorAndDoEMFRegistration();
				InMemoryFileSystemAccess fsa = injector.getInstance(InMemoryFileSystemAccess.class);
				generator.circuitGenerator = new ModelDrawCircuitGenerator();
				generator.plantUMLGenerator = new ModelDrawPlantUMLGenerator();
				generator.dotGenerator = new ModelDrawDotGenerator();
				generator.doGenerate(drawmodel, fsa, null);
				compile(file.getProject());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		compile(file.getProject());
		
		try {
			String xmiFileName = file.getProject().getLocation().toFile().getPath().replace("\\", "/") + "/" + ModelManager.getOutputFolder() + "/" + file.getName().replace(".mutator", "_test.model");
			Bundle bundle = Platform.getBundle("wodeledu.models");
	   		URL fileURL = bundle.getEntry("/model/EduTest.ecore");
	   		String testecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> testpackages = ModelManager.loadMetaModel(testecore);
			Resource testmodel = ModelManager.loadModel(testpackages, xmiFileName);
			String stringURI = "/resource/" + file.getProject().getName();
			stringURI = stringURI + "/src/" + file.getName().replace(".mutator", ".test");
			if (testmodel != null) {
				testmodel.setURI(URI.createURI(stringURI));
				EduTestGenerator generator = new EduTestGenerator();
				generator.webGenerator = new EduTestWebGenerator();
				generator.moodleGenerator = new EduTestMoodleGenerator();
				generator.androidAppGenerator = new EduTestAndroidAppGenerator();
				generator.iOSAppGenerator = new EduTestiOSAppGenerator();
				Injector injector = new EduTestStandaloneSetup().createInjectorAndDoEMFRegistration();
				InMemoryFileSystemAccess fsa = injector.getInstance(InMemoryFileSystemAccess.class);
				generator.doGenerate(testmodel, fsa, null);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		compile(file.getProject());
		*/
		
		String projectName = file.getProject().getName();
		String filename = projectName + ".draw";

		IFile generatedCodeFile = file.getProject().getFile(new Path("/src-gen/mutator/" + file.getProject().getName() + "/" + filename.replace(".draw", "Draw.java")));

		try {
			if (generatedCodeFile.exists() == true) {
				generatedCodeFile.delete(true, new NullProgressMonitor());
			}
			final IFolder src = file.getProject().getFolder(new Path("src"));
			if (src.exists() == false) {
				return;
			}
			final IFile dslFile = src.getFile(new Path(filename));
			InputStream stream = dslFile.getContents();
			if (dslFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				dslFile.setContents(stream, true, true, null);
			}
			else {
				dslFile.create(stream, true, null);
			}
			stream.close();

		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String generatedCode = generatedCodeFile.getLocation().toFile().getPath().replace("\\", "/");
		
		try {
			WodelEduUtils.awaitFile(generatedCode, 10000);
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Class<?> cls = null;
		String mutatorName = file.getProject().getName();
		String classname = "mutator." + mutatorName + "." + mutatorName.replaceAll("[.]", "_") + "Draw";
		
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
			ob = cls.getDeclaredConstructor().newInstance();
			Method m = cls.getMethod("run", new Class[]{IProject.class, String.class});
			m.invoke(ob, file.getProject(), file.getName().replace(".mutator", ".test"));
			// ime = (IMutatorExecutor)ob;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			classLoader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		filename = projectName + ".test";
		
		generatedCodeFile = file.getProject().getFile(new Path("/src-gen/xml/" + file.getProject().getName() + ".xml"));

		try {
			if (generatedCodeFile.exists() == true) {
				generatedCodeFile.delete(true, new NullProgressMonitor());
			}
			final IFolder src = file.getProject().getFolder(new Path("src"));
			if (src.exists() == false) {
				return;
			}
			final IFile dslFile = src.getFile(new Path(filename));
			InputStream stream = dslFile.getContents();
			if (dslFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				dslFile.setContents(stream, true, true, null);
			}
			else {
				dslFile.create(stream, true, null);
			}
			stream.close();

			/*
			String path = project.getLocation().toFile().getPath().replace("\\", "/");
			String modelname = projectName + "_test.model";
			String xmiFileName = path + "/" + ModelManager.getOutputFolder() + "/" + modelname;
			Bundle bundle = Platform.getBundle("wodeledu.models");
	   		URL fileURL = bundle.getEntry("/model/EduTest.ecore");
	   		String testecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> testpackages = ModelManager.loadMetaModel(testecore);
			Resource testmodel = ModelManager.loadModel(testpackages, xmiFileName);
			String stringURI = "/resource/" + projectName;
			stringURI = stringURI + "/src/" + filename;
			if (testmodel != null) {
				testmodel.setURI(URI.createURI(stringURI));
				EduTestGenerator generator = new EduTestGenerator();
				generator.webGenerator = new EduTestWebGenerator();
				generator.moodleGenerator = new EduTestMoodleGenerator();
				generator.androidAppGenerator = new EduTestAndroidAppGenerator();
				generator.iOSAppGenerator = new EduTestiOSAppGenerator();
				Injector injector = new EduTestStandaloneSetup().createInjectorAndDoEMFRegistration();
				InMemoryFileSystemAccess fsa = injector.getInstance(InMemoryFileSystemAccess.class);
				generator.doGenerate(testmodel, fsa, null);
			}
			*/
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		generatedCode = generatedCodeFile.getLocation().toFile().getPath().replace("\\", "/");
		
		try {
			WodelEduUtils.awaitFile(generatedCode, 10000);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
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
	
	private static void assertExist(final IContainer c) {
		if (!c.exists()) {
			if (!c.getParent().exists()) {
				assertExist(c.getParent());
			}
			if (c instanceof IFolder) {
				try {
					((IFolder) c).create(false, true, new NullProgressMonitor());
				}
				catch (final CoreException e) {
					//OawLog.logError(e);
				}
			}

		}

	}
	
	public static IFile createFile(final String name, final IContainer container, final String content,
			final IProgressMonitor progressMonitor) {
		final IFile file = container.getFile(new Path(name));
		assertExist(file.getParent());
		try {
			final InputStream stream = new ByteArrayInputStream(content.getBytes(file.getCharset()));
			if (file.exists()) {
				file.setContents(stream, true, true, progressMonitor);
			}
			else {
				file.create(stream, true, progressMonitor);
			}
			stream.close();
		}
		catch (final Exception e) {
			// TO-DO: Something
		}
		progressMonitor.worked(1);

		return file;
	}

	
	public static IFile createFile(final String name, final IContainer container, final String content,
			final String charSet, final IProgressMonitor progressMonitor) throws CoreException {
		final IFile file = createFile(name, container, content, progressMonitor);
		if (file != null && charSet != null) {
			file.setCharset(charSet, progressMonitor);
		}

		return file;
	}
	
	
	private static void createPlugin(final IProgressMonitor progressMonitor, final IProject project) {
		final StringBuilder pContent = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pContent.append("\n");
		pContent.append("<?eclipse version=\"3.4\"?>");
		pContent.append("\n");
		pContent.append("<plugin>");
		pContent.append("\n");
		pContent.append("</plugin>");
		pContent.append("\n");
		createFile("plugin.xml", project, pContent.toString(), progressMonitor);
	}
}
