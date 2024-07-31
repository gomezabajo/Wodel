package wodeledu.extension.run.commands;

import java.net.URL;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.osgi.framework.Bundle;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.inject.Injector;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;
import wodel.utils.manager.WodelTestUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;


import wodeledu.dsls.EduTestStandaloneSetup;
import wodeledu.dsls.generator.edutest.EduTestAndroidAppGenerator;
import wodeledu.dsls.generator.edutest.EduTestGenerator;
import wodeledu.dsls.generator.edutest.EduTestMoodleGenerator;
import wodeledu.dsls.generator.edutest.EduTestWebGenerator;
import wodeledu.dsls.generator.edutest.EduTestiOSAppGenerator;
import wodeledu.utils.manager.WodelEduUtils;

public class GenerateEduTestCode extends AbstractHandler {
	
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

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		IProject project = null;
		
		if (selection.getFirstElement() instanceof IAdaptable)
        {
            project = (IProject)((IAdaptable) selection.getFirstElement()).getAdapter(IProject.class);
        }
		if (project == null && selection.getFirstElement() instanceof IProject) {
			project = (IProject) selection.getFirstElement();
		}
		if (project == null && selection.getFirstElement() instanceof IFile) {
			project = ((IFile) selection.getFirstElement()).getProject();
		}
		if (project == null && selection.getFirstElement() instanceof IJavaProject) {
			project = ((IJavaProject) selection.getFirstElement()).getProject();
		}
		if (project == null) {
			project = ProjectUtils.getProject();
		}
		if (project == null) {
			return null;
		}
		
		String projectName = project.getName();
		String filename = projectName + ".test";
		
		IFile generatedCodeFile = project.getFile(new Path("/src-gen/xml/" + project.getName() + ".xml"));

		try {
			if (generatedCodeFile.exists() == true) {
				generatedCodeFile.delete(true, new NullProgressMonitor());
			}
			final IFolder src = project.getFolder(new Path("src"));
			if (src.exists() == false) {
				return null;
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
		
		String generatedCode = generatedCodeFile.getLocation().toFile().getPath().replace("\\", "/");
		
		try {
			WodelEduUtils.awaitFile(generatedCode, 10000);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
