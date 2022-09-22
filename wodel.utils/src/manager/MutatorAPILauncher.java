package manager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class MutatorAPILauncher implements IRunnableWithProgress {
	
	private ExecutionEvent event = null;
	private IProject project = null;
	private String[] mutatorNames = null;
	private String[][] mutationOperators = null;
	private String inputFolder = null;
	private String outputFolder = null;
	
	public MutatorAPILauncher(ExecutionEvent event, IProject project, String[] mutatorNames, String[][] mutationOperators, String inputFolder,
			String outputFolder) {
		this.event = event;
		this.project = project;
		this.mutatorNames = new String[mutatorNames.length];
		List<String> listMutatorNames = new ArrayList<String>();
		listMutatorNames.addAll(Arrays.asList(mutatorNames));
		listMutatorNames.toArray(this.mutatorNames);
		this.mutationOperators = new String[mutatorNames.length][];
		for (int i = 0; i < mutatorNames.length; i++) {
			this.mutationOperators[i] = new String[mutationOperators[i].length];
			List<String> listMutationOperators = new ArrayList<String>();
			listMutationOperators.addAll(Arrays.asList(mutationOperators[i]));
			listMutationOperators.toArray(this.mutationOperators[i]);
		}
		this.inputFolder = inputFolder;
		this.outputFolder = outputFolder;
	}
	
	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		int totalTasks = mutatorNames.length;
		monitor.beginTask("Executing Wodel with " + project.getName(), totalTasks);
		
		String inputWodelFolder = ModelManager.getModelsFolder();
		IOUtils.deleteFolder(inputWodelFolder, "model");
		
		File seedWodelFolder = new File(inputWodelFolder);
		File inputCustomizedFolder = new File(this.inputFolder);

		try {
			IOUtils.copyFolder(inputCustomizedFolder, seedWodelFolder, "model");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File projectFolder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + this.project.getName());
		List<String> mutatorList = MutatorUtils.getMutators(projectFolder.listFiles());
		String outputWodelFolder = ModelManager.getWorkspaceAbsolutePath() + "/" + this.project.getName() + "/" + ModelManager.getOutputFolder();
		// clean-up output folder preserving xtext auto generated models
		IOUtils.deleteFolder(outputWodelFolder, "model", mutatorList);
		
		URLClassLoader classLoader = null;
		try {
			if (project.hasNature(JavaCore.NATURE_ID)) {
				IJavaProject javaProject = JavaCore.create(this.project);
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
				ClassLoader parentClassLoader = this.project.getClass()
						.getClassLoader();
				URL[] urls = (URL[]) urlList
						.toArray(new URL[urlList.size()]);
				classLoader = new URLClassLoader(urls,
						parentClassLoader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Class<?>> mutatorClasses = new ArrayList<Class<?>>();
		for (String mutatorName : this.mutatorNames) {
			String classname = "mutator." + mutatorName.replaceAll("[.]", "_") + "." + mutatorName.replaceAll("[.]", "_") + "API";
			Class<?> mutatorClass = null;
			try {
				mutatorClass = Class.forName(classname);
			} catch (ClassNotFoundException e) {
			}
			
			if (mutatorClass == null && classLoader != null) {
				try {
					mutatorClass = classLoader.loadClass(classname);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (mutatorClass != null) {
				mutatorClasses.add(mutatorClass);
			}
		}
		final IProject fProject = this.project;
		final String[] fMutatorNames = this.mutatorNames;
		final String[][] fMutationOperators = this.mutationOperators;
		int i = 0;
		for (String mutatorName : fMutatorNames) {
			monitor.subTask("Executing Wodel program " + mutatorName + " (" + (i + 1) + "/" + totalTasks + ")");
			try {
				Object ob = mutatorClasses.get(i).getDeclaredConstructor().newInstance();
				Method m = mutatorClasses.get(i).getMethod("createMutants", new Class[]{String[].class, IProject.class, IProgressMonitor.class});
				m.invoke(ob, fMutationOperators[i], fProject, monitor);
			} catch (Exception e) {
				e.printStackTrace();
			}
			monitor.worked(1);
			i++;
		}
		
		IOUtils.deleteFolder(this.outputFolder, "model");
		
		File mutantWodelFolder = new File(outputWodelFolder);
		File outputCustomizedFolder = new File(this.outputFolder);
		
		try {
			IOUtils.copyFolder(mutantWodelFolder, outputCustomizedFolder, "model", mutatorList);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final String textToShow = "Wodel mutants generation process finished succesfully";
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
				MessageBox messageBox = new MessageBox(shell);
				messageBox.setText("Wodel mutants generation process completed");
				messageBox.setMessage(textToShow);
				messageBox.open();
			}
		});
	}
}
