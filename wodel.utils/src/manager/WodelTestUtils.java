package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.osgi.framework.Bundle;

import appliedMutations.AttributeChanged;
import appliedMutations.InformationChanged;
import appliedMutations.ObjectCreated;
import appliedMutations.ObjectRemoved;
import appliedMutations.ReferenceChanged;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.ModelManager;
import manager.MutatorUtils;

public class WodelTestUtils {
	
	public static Class<?> loadClass(String className, Object source) {
		Class<?> cls = null;
		String classname = className;

		try {
			cls = Class.forName(classname);
		} catch (ClassNotFoundException e) {
		}
		
		if (cls == null) {
			try {
				// create url class loader whose parent is the class loader
				// of the project
				// and containing the class path entries of the project
				ClassLoader classLoader = source.getClass()
					.getClassLoader();
				// load class
				cls = classLoader.loadClass(classname);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cls;
	}

	public static Class<?> loadClass(IProject project, String className, Object source) {
		Class<?> cls = null;
		String classname = className;

		try {
			cls = Class.forName(classname);
		} catch (ClassNotFoundException e) {
		}
		
		URLClassLoader classLoader = null;
		if (cls == null) {
			try {
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
					ClassLoader parentClassLoader = source.getClass()
							.getClassLoader();
					URL[] urls = (URL[]) urlList
							.toArray(new URL[urlList.size()]);
					classLoader = new URLClassLoader(urls,
							parentClassLoader);
					// load class
					cls = classLoader.loadClass(classname);
				}
			} catch (ClassNotFoundException e) {
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (cls == null) {
			try {
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
			} catch (ClassNotFoundException e) {
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cls;
	}
	
	private static List<Class<?>> getClasses(IProject project, IContainer container, Object source, String pk) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		try {
			IResource[] members = container.members();

			for (IResource member : members) {
				if (member instanceof IContainer) {
					classes.addAll(getClasses(project, (IContainer) member, source, pk));
				}
				else if (member instanceof IFile) {
					if (member.getName().endsWith(".java")) {
						String classname = member.getLocation().toFile().getPath();
						if (classname.indexOf(project.getName() + "\\src\\") != -1) {
							classname = classname.substring(classname.indexOf(project.getName() + "\\src\\") + (project.getName() + "\\src\\").length(), classname.length());
						}
						else {
							classname = classname.substring(classname.indexOf(project.getName() + "/src/") + (project.getName() + "/src/").length(), classname.length());
						}
						classname = classname.replace(".java", "");
						if (classname.indexOf("\\") != -1) {
							classname = classname.replaceAll("\\\\", ".");
						}
						else {
							classname = classname.replaceAll("/", ".");
						}
						if (pk != null && !pk.equals("") && !pk.equals("default")) {
							String pack = classname.substring(0, classname.lastIndexOf("."));
							if (!pack.equals(pk)) continue;
						}
						classes.add(loadClass(project, classname, source));
					}
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classes;
	}
	
	public static Class<?>[] loadClasses(IProject project, Object source, String pk) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		try {
			IResource[] members = project.members();

			for (IResource member : members) {
				if (member instanceof IContainer) {
					classes.addAll(getClasses(project, (IContainer) member, source, pk));
				}
				else if (member instanceof IFile) {
					if (member.getName().endsWith(".java")) {
						String classname = member.getLocation().toFile().getPath();
						classname = classname.substring(classname.indexOf(project.getName() + File.separator + "src" + File.separator) + (project.getName() + File.separator +"src" + File.separator).length(), classname.length());
						classname = classname.replace(".java", "");
						classname = classname.replaceAll("/", ".");
						if (pk != null && !pk.equals("") && !pk.equals("default")) {
							String pack = classname.substring(0, classname.lastIndexOf("."));
							if (!pack.equals(pk)) continue;
						}
						Class<?> cls = loadClass(project, classname, source);
						if (cls != null) {
							classes.add(cls);
						}
					}
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class<?>[] retClasses = new Class<?>[classes.size()];
		classes.toArray(retClasses);
		return retClasses;
	}
	
	public static Class<?>[] loadClasses(IProject project, Object source) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		try {
			IResource[] members = project.members();

			for (IResource member : members) {
				if (member instanceof IContainer) {
					classes.addAll(getClasses(project, (IContainer) member, source, null));
				}
				else if (member instanceof IFile) {
					if (member.getName().endsWith(".java")) {
						String classname = member.getLocation().toFile().getPath();
						classname = classname.substring(classname.indexOf(project.getName() + File.separator + "src" + File.separator) + (project.getName() + File.separator +"src" + File.separator).length(), classname.length());
						classname = classname.replace(".java", "");
						classname = classname.replaceAll("/", ".");
						Class<?> cls = loadClass(project, classname, source);
						if (cls != null) {
							classes.add(cls);
						}
					}
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class<?>[] retClasses = new Class<?>[classes.size()];
		classes.toArray(retClasses);
		return retClasses;
	}

	public static String[] getClassesFilter(IProject project, IJavaProject javaProject) {
		String path = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/data/classes.txt";
		TreeMap<String, List<String>> classes = loadClasses(path);
		if (classes.size() == 0) {
			try {
				IPackageFragment[] packageFragments = javaProject.getPackageFragments();
				TreeMap<String, String> options = new TreeMap<String, String>();
				for (IPackageFragment packageFragment : packageFragments) {
					String packageName = packageFragment.getElementName();
					ICompilationUnit[] compilationUnits = packageFragment.getCompilationUnits();
					for (ICompilationUnit compilationUnit : compilationUnits) {
						if (packageName.equals("")) {
							options.put(compilationUnit.getElementName().replace(".java", ""), compilationUnit.getPath().toString());
						}
						else {
							options.put(packageFragment.getElementName() + "." + compilationUnit.getElementName().replace(".java", ""), compilationUnit.getPath().toString());
						}
					}
				}
				PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
					public void run() {
						Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
						ListSelectionDialog dialog = new ListSelectionDialog(shell, options.keySet().toArray(), ArrayContentProvider.getInstance(), new LabelProvider(), "Select classes where to apply mutations");
						dialog.setTitle("Classes selection");
						dialog.open();
						Object[] results = dialog.getResult();
						for (Object result : results) {
							List<String> paths = new ArrayList<String>();
							paths.add(options.get((String) result));
							classes.put((String) result, paths);
						}
						storeClasses(path, classes);
					}
				});
			} catch (JavaModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String[] classesArray = new String[classes.size()];
		classes.keySet().toArray(classesArray);
		return classesArray;
	}

//	public static void filterClasses(Resource resource, List<String> classes) {
//		Model model = (Model) resource.getContents().get(0);
//		List<CompilationUnit> lcu = model.getCompilationUnits();
//		List<CompilationUnit> tmplcu = new ArrayList<CompilationUnit>();
//		tmplcu.addAll(lcu);
//		for (CompilationUnit cu : tmplcu) {
//			boolean found = false;
//			for (String classname : classes) {
//				if (cu.getName().replace(".java", "").equals(classname)) {
//					found = true;
//					break;
//				}
//			}
//			if (found == false) {
//				lcu.remove(cu);
//			}
//		}
//		
//		EList<org.eclipse.gmt.modisco.java.Package> ownedElements = model.getOwnedElements();
//		for (org.eclipse.gmt.modisco.java.Package ownedElement : ownedElements) {
//			EList<AbstractTypeDeclaration> declarations = ownedElement.getOwnedElements();
//			List<AbstractTypeDeclaration> tmpDeclarations = new ArrayList<AbstractTypeDeclaration>();
//			tmpDeclarations.addAll(declarations);
//			for (AbstractTypeDeclaration declaration : tmpDeclarations) {
//				boolean found = false;
//				for (String classname : classes) {
//					if (declaration.getName().replace(".java", "").equals(classname)) {
//						found = true;
//						break;
//					}
//				}
//				if (found == false) {
//					declarations.remove(declaration);
//				}
//			}
//		}
//	}
	
	public static void storeClasses(String path, TreeMap<String, List<String>> classes) {
		File file = new File(path);
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			for (String classname : classes.keySet()) {
				writer.write(classname + "|");
				String paths = "";
				for (String pth : classes.get(classname)) {
					paths += pth + "|";
				}
				paths = paths.substring(0, paths.length() - 1);
				writer.write(paths + "\n");
			}
			writer.flush();
			writer.close();

		} catch (IOException e) {
		}
	}
	
	public static TreeMap<String, List<String>> loadClasses(String path) {
		TreeMap<String, List<String>> classes = new TreeMap<String, List<String>>();
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] values = line.split("[|]");
				List<String> paths = new ArrayList<String>();
				for (int i = 1; i < values.length; i++) {
					paths.add(values[i]);
				}
				classes.put(values[0], paths);
			}
			br.close();
			fr.close();
		} catch (IOException ex){
		}
		return classes;
	}
	
	public static void deleteDirectory(File file) {
		File[] contents = file.listFiles();
		if (contents != null) {
			for (File f : contents) {
				deleteDirectory(f);
			}
		}
		file.delete();
	}
	
	public static void storeFile(String path, String data) {
		File file = new File(path);
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write(data);
			writer.flush();
			writer.close();

		} catch (IOException e) {
		}
	}

	public static String[] loadFile(String path) {
		String[] data = new String[0];
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			int i = 0;
			while ((line = br.readLine()) != null) {
				data = Arrays.copyOf(data, i + 1);
				data[i] = line;
				i++;
			}
			br.close();
			fr.close();
		} catch (IOException ex){
		}
		return data;
	}
	
	public static Map<String, List<WodelTestClass>> getPackageClasses(IWodelTest wodelTest, String projectName, String path, String pathResults) {
		TreeMap<String, List<String>> classes = loadClasses(path);
		Map<String, List<WodelTestClass>> packageClasses = new HashMap<String, List<WodelTestClass>>();
		if (classes.size() > 0) {
			for (String classname : classes.keySet()) {
				String[] splitted = classname.split("\\.");
				String packagename = "";
				for (String value : Arrays.asList(splitted).subList(0, splitted.length - 1)) {
					packagename += value + ".";
				}
				if (packagename.equals("")) {
					packagename = "default";
				}
				else {
					packagename = packagename.substring(0, packagename.length() - 1);
				}
				String clsname = splitted[splitted.length - 1];
				WodelTestClass wodelTestClass = new WodelTestClass();
				wodelTestClass.depth = true;
				wodelTestClass.classname = clsname;
				List<String> paths = classes.get(classname);
				List<WodelTestClass> currentClasses = packageClasses.get(packagename);
				if (currentClasses == null) {
					currentClasses = new ArrayList<WodelTestClass>();
				}
				wodelTestClass.info = new ArrayList<WodelTestClassInfo>();
				for (String classpath : paths) {
					if (!packagename.equals("default")) {
						wodelTestClass.info.add(WodelTestClassInfo.getInfo(wodelTest, projectName, packagename, pathResults, classpath));
					}
					else {
						wodelTestClass.info.add(WodelTestClassInfo.getInfo(wodelTest, projectName, "", pathResults, classpath));
					}
				}
				currentClasses.add(wodelTestClass);
				packageClasses.put(packagename, currentClasses);
			}
		}
		else {
			String[] values = loadFile(pathResults);
			List<WodelTestClass> currentClasses = new ArrayList<WodelTestClass>();
			for (String value : values) {
				String data[] = value.split("[|]");
				WodelTestClass wodelTestClass = null;
				for (WodelTestClass currentClass : currentClasses) {
					if (currentClass.classname.equals(data[0])) {
						wodelTestClass = currentClass;
						break;
					}
				}
				if (wodelTestClass == null) {
					wodelTestClass = new WodelTestClass();
					currentClasses.add(wodelTestClass);
				}
				wodelTestClass.depth = false;
				wodelTestClass.classname = data[0];
				if (wodelTestClass.info == null) {
					wodelTestClass.info = new ArrayList<WodelTestClassInfo>();
					wodelTestClass.info.add(WodelTestClassInfo.getInfo(wodelTest, projectName, "", pathResults, data[0]));
				}
			}
			packageClasses.put("default", currentClasses);
		}
		return packageClasses;
	}
	
	private static List<String> getPaths(TreeMap<String, List<String>> classes, String classname) {
		for (String clsname : classes.keySet()) {
			String[] values = clsname.split("\\.");
			if (values[values.length - 1].equals(classname)) {
				return classes.get(clsname);
			}
		}
		return null;
	}

	private static void addPathToClassesRecursion(String projectName, File pathFile, TreeMap<String, List<String>> classes) {
		for (File content : pathFile.listFiles()) {
			if (content.isDirectory()) {
				addPathToClassesRecursion(projectName, content, classes);
			}
			if (content.isFile()) {
				if (content.getName().endsWith(".java")) {
					String classname = content.getName().replace(".java", "");
					List<String> paths = getPaths(classes, classname);
					if (paths == null) {
						continue;
					}
					String newPath = content.toPath().toString().replaceAll("\\\\", "/");
					newPath = newPath.substring(newPath.indexOf("/" + projectName), newPath.length());
					paths.add(newPath);
				}
			}
		}
	}
	
	public static void addPathToClasses(String projectName, TreeMap<String, List<String>> classes, String path) {
		File pathFile = new File(path);
		for (File content : pathFile.listFiles()) {
			if (content.isDirectory()) {
				addPathToClassesRecursion(projectName, content, classes);
			}
			if (content.isFile()) {
				if (content.getName().endsWith(".java")) {
					String classname = content.getName().replace(".java", "");
					List<String> paths = getPaths(classes, classname);
					if (paths == null) {
						continue;
					}
					String newPath = content.toPath().toString().replaceAll("\\\\", "/");
					newPath = newPath.substring(newPath.indexOf("/" + projectName), newPath.length());
					paths.add(newPath);
				}
			}
		}
	}
	
	public static List<String> getMutationTextList(IWodelTest test, String projectName, String packagename, String sourcepath) {
		List<String> mutationTextList = new ArrayList<String>();
		try {
			String mutantpath = packagename.length() > 0 ? sourcepath.substring(sourcepath.indexOf(packagename) + (packagename + "/").length(), sourcepath.length()) : sourcepath.indexOf(projectName) > 0 ? sourcepath.substring(sourcepath.indexOf(projectName) + (projectName + "/").length(), sourcepath.length()) : sourcepath;
			String blockName = mutantpath.indexOf("/") > 0 ? mutantpath.substring(0, mutantpath.indexOf("/")) : "";
			String modelName = blockName.length() > 0 ? mutantpath.substring(mutantpath.indexOf(blockName) + (blockName + "/").length(), mutantpath.length()) : mutantpath;
			if (modelName.indexOf("/") != -1) {
				modelName = modelName.substring(0, modelName.indexOf("/")) + ".model";
			}
			else if (modelName.indexOf(".") != -1){
				modelName = modelName.substring(0, modelName.indexOf(".")) + ".model";
			}
			else {
				return mutationTextList;
			}
			String path = ModelManager.getOutputPath(test.getClass()) + "/" + projectName + "/" + blockName + "/" + modelName;
			if (!modelName.contains("_") && path.contains("out")) {
				String registryName = modelName.replace(".model", "Registry.model");
				String registryPath = path.substring(0, path.lastIndexOf("/") + 1) + "registry" + "/" + registryName;
				if (new File(registryPath).exists()) {
					Bundle bundle = Platform.getBundle("wodel.models");
					URL fileURL = bundle.getEntry("/models/AppliedMutations.ecore");
					String ecore = FileLocator.resolve(fileURL).getFile();
					List<EPackage> packages = ModelManager.loadMetaModel(ecore);
					Resource registry = ModelManager.loadModel(packages, registryPath);
					List<EObject> objects = ModelManager.getAllObjects(registry);
					List<EObject> mutations = MutatorUtils.getMutations(objects);
					for (EObject mutation : mutations) {
						if (mutation.eClass().getName().equals("InformationChanged")) {
							InformationChanged mut = (InformationChanged) mutation;
							String mutationText = "modify information mutator: ";
							List<AttributeChanged> attChanges = mut.getAttChanges();
							for (AttributeChanged attChange : attChanges) {
								mutationText += attChange.getOldVal() + " replaced by " + attChange.getNewVal();
							}
							List<ReferenceChanged> refChanges = mut.getRefChanges();
							for (ReferenceChanged refChange : refChanges) {
								EObject from = refChange.getFrom();
								EObject to = refChange.getTo();
								if (from != null && to != null) {
									mutationText += "source " + from.eClass().getName() + " to " + to.eClass().getName();
								}
							}
							mutationTextList.add(mutationText);
						}
						if (mutation.eClass().getName().equals("ObjectRemoved")) {
							ObjectRemoved mut = (ObjectRemoved) mutation;
							String mutationText = "remove object mutator: ";
							mutationText += mut.getType().getName() + " object removed";
							mutationTextList.add(mutationText);
						}
						if (mutation.eClass().getName().equals("ObjectCreated")) {
							ObjectCreated mut = (ObjectCreated) mutation;
							String mutationText = "create object mutator: ";
							if (mut.getObject().size() > 0) {
								mutationText += mut.getObject().get(0).eClass().getName() + " object created";
							}
							mutationTextList.add(mutationText);
						}
					}
				}
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
		return mutationTextList;
	}


	public static List<WodelTestTest> getTests(IWodelTest wodelTest, Map<String, List<WodelTestClass>> packageClasses, String projectName, String path, String pathResults) {
		List<WodelTestTest> tests = WodelTestTest.loadFile(pathResults);
		for (String packagename : packageClasses.keySet()) {
			List<WodelTestClass> testClasses = packageClasses.get(packagename);
			for (WodelTestClass testClass : testClasses) {
				for (WodelTestClassInfo info : testClass.info) {
					for (WodelTestTest test : tests) {
						for (WodelTestResultTest testResult : test.getResults()) {
							for (WodelTestResultTestInfo mutant : testResult.getMutants()) {
								String mutantName = mutant.getName();
								if (info.path.equals(mutantName)) {
									mutant.setMutation(info.mutationText);
									continue;
								}
								if (!mutantName.endsWith("/")) {
									mutantName += "/";
								}
								if (!packagename.equals("default")) {
									mutantName += "src/" + packagename.replaceAll("\\.", "/") + "/";
								}
								String infoPath = info.path.substring(0, info.path.lastIndexOf("/") + 1);
								mutantName = mutantName.replaceAll("\\\\", "/");
								if (infoPath.equals(mutantName)) {
									mutant.setName(mutantName + testClass.classname + ".java");
									mutant.setMutation(info.mutationText);
								}
							}
						}
					}
					
				}
			}
		}
		return tests;
	}
	
	public static String getTestSuiteName(IProject project) {
		String testSuiteName = "";
		String path = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getFullPath().toFile().getPath().toString();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "/data/" + project.getName() + ".test.txt"));
			br.readLine();
			String line = null;
			while ((line = br.readLine()) != null) {
				testSuiteName = line;
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testSuiteName;
	}
	
	public static String findSourcePath(File file, String ext) {
		if (file.isDirectory()) {
			for (File inner : file.listFiles()) {
				return findSourcePath(inner, ext);
			}
		}
		if (file.isFile() && file.getName().endsWith(ext)) {
			return file.getPath();
		}
		return null;
	}
}
