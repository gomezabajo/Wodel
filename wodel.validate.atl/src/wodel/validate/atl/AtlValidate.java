package wodel.validate.atl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;
import org.eclipse.m2m.atl.engine.compiler.atl2006.Atl2006Compiler;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import manager.ModelManager;
import wodel.validate.Validate;

public class AtlValidate extends Validate {
	
	@Override
	public String getName() {
		return "ATL Program Validate";
	}
	
	@Override
	public String getURI() {
		return "http://www.eclipse.org/gmt/2005/ATL";
	}
	
	private List<CompileTimeError> compile(IProject project) {
		List<CompileTimeError> errors = new ArrayList<CompileTimeError>(); 
		try {
			Atl2006Compiler compiler = new Atl2006Compiler();
			FileInputStream trafoFile;
			File folder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/temp");
			for (File atl_file : folder.listFiles()) {
				if (atl_file.isFile() && atl_file.getName().endsWith(".atl")) {
					trafoFile = new FileInputStream(atl_file);
					String asm_transformation = atl_file.getName().replace(".atl", ".asm");
					errors.addAll(Arrays.asList(compiler.compile(trafoFile, ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/temp/" + asm_transformation)));
				}
				if (atl_file.isDirectory()) {
					for (File atl_file2 : atl_file.listFiles()) {
						if (atl_file2.isFile() && atl_file2.getName().endsWith(".atl")) {
							trafoFile = new FileInputStream(atl_file2);
							String asm_transformation = atl_file2.getName().replace(".atl", ".asm");
							errors.addAll(Arrays.asList(compiler.compile(trafoFile, ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/temp/" + atl_file.getName() + "/" + asm_transformation)));
						}
					}
				}
			}
			Job.getJobManager().join(ResourcesPlugin.FAMILY_MANUAL_BUILD, new NullProgressMonitor());
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return errors;
	}
	
	private void modelToProject(File modelFile, String projectName) {
		try {
			ModelFactory modelFactory = new EMFModelFactory();
			IReferenceModel atlMetamodel = AtlParser.getDefault().getAtlMetamodel();
			IModel atlModel = modelFactory.newModel(atlMetamodel);
			String path = modelFile.getPath();
			IInjector injector = new EMFInjector();
			injector.inject(atlModel, "file:/" + path);

			String outputPath = ModelManager.getWorkspaceAbsolutePath() + "/" + projectName + "/temp/";
			File outputFolder = new File(outputPath);
			if (!outputFolder.exists()) {
				outputFolder.mkdir();
			}
			AtlParser atlParser = new AtlParser();
			atlParser.extract(atlModel, "file:/" + outputPath + "/" + modelFile.getName().replace(".model", ".atl"));
		} catch (ATLCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isValid(String metamodel, String seed, String model, IProject project) {
		boolean isValid = true;
		
		try {
			final IFolder iFolder = project.getFolder(new Path("temp"));
			if (iFolder.exists() == false) {
				iFolder.create(true, true, new NullProgressMonitor());
			}
			File modelFile = new File(model);
			modelToProject(modelFile, project.getName());
			List<CompileTimeError> errors = compile(project);
			isValid = errors.size() == 0;
			iFolder.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isValid;
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
	}
}
