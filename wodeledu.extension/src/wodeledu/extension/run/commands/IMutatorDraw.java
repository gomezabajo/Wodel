package wodeledu.extension.run.commands;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.Job;

/**
 * @author Pablo Gomez-Abajo
 * 
 * IMutatorDraw interface for the execution
 * of the models graphical representation
 * 
 */

public interface IMutatorDraw {
	public void run(IProject project, String filename);
	
	public default void compile(IProject project) {
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
	
	public default void update(IProject project, String filename) {
		
		compile(project);
/*		
		final IFile testsFile = project.getFile(new Path(filename));
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
		compile(project);
		
		try {
			String xmiFileName = project.getLocation().toFile().getPath().replace("\\", "/") + "/" + ModelManager.getOutputFolder() + "/" + filename.replace(".test", "_test.model");
			Bundle bundle = Platform.getBundle("wodeledu.models");
	   		URL fileURL = bundle.getEntry("/model/EduTest.ecore");
	   		String testecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> testpackages = ModelManager.loadMetaModel(testecore);
			Resource testmodel = ModelManager.loadModel(testpackages, xmiFileName);
			String stringURI = "/resource/" + project.getName();
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
		
		compile(project);
*/
	}

}
