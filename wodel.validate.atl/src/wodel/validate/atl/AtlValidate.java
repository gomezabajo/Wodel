package wodel.validate.atl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.common.ATL.ATLPackage;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

import anatlyzer.atl.analyser.AnalyserInternalError;
import anatlyzer.atl.analyser.AnalysisResult;
import anatlyzer.atl.errors.Problem;
import anatlyzer.atl.errors.ProblemStatus;
import anatlyzer.atl.errors.atl_error.LocalProblem;
import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.tests.api.AtlLoader;
import anatlyzer.atl.tests.api.AtlLoader.LoadException;
import anatlyzer.atl.tests.api.StandaloneUSEWitnessFinder;
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
	
	private String getIn(String trafo) {
		String in = "";
		try {
			AtlSourceManager manager = new AtlSourceManager();
			manager.updateDataSource(new FileInputStream(trafo));
			System.out.println("trafo(in): " + trafo);
			for (Iterator<?> iterator = manager.getInputModels().entrySet().iterator(); iterator.hasNext();) {
				Entry<?, ?> entry = (Entry<?, ?>)iterator.next();
				String modelName = (String) entry.getKey();
				if (modelName.equals("IN")) {
					in = (String) entry.getValue();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
	}
	
	private String getOut(String trafo) {
		String out = "";
		try {
			AtlSourceManager manager = new AtlSourceManager();
			manager.updateDataSource(new FileInputStream(trafo));
			System.out.println("trafo(out): " + trafo);
			for (Iterator<?> iterator = manager.getOutputModels().entrySet().iterator(); iterator.hasNext();) {
				Entry<?, ?> entry = (Entry<?, ?>)iterator.next();
				String modelName = (String) entry.getKey();
				if (modelName.equals("OUT")) {
					out = (String) entry.getValue();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
		
	}
	public List<Problem> findProblems(IProject project) {
		List<Problem> problems = new ArrayList<Problem>();
		
		try {
			File folder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/temp");
			for (File atl_file : folder.listFiles()) {
				if (atl_file.isFile() && atl_file.getName().endsWith(".atl")) {
					Resource atlTrafo = AtlLoader.load(atl_file.getPath());
					String projectPath = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName();
					String in = getIn(atl_file.getPath());
					String inMetamodel = "file:/" + projectPath + "/" + in + ".ecore";
					String out = getOut(atl_file.getPath());
					String outMetamodel = "file:/" + projectPath + "/" + out + ".ecore";
					// The analyser is configured with the paths to the meta-models (WF_METAMODEL and PN_METAMODEL)
					// and the logical names (as two arrays)
					AnalysisLoader loader = AnalysisLoader.fromResource(atlTrafo, 
							new Object[] { inMetamodel, outMetamodel },  
							new String[] { in, out });

					// The analysis result is wrapped into AnalysisResult
					AnalysisResult result = loader.analyse();

					// Check which problems needs to be confirmed by the constraint solver
					for (Problem problem : result.getProblems()) {
						if ( problem.getStatus() == ProblemStatus.WITNESS_REQUIRED ) {
							// Launchs the constraint solver and (hopefully) confirms or discard
							// the proble, updating the problem status
							ProblemStatus status = StandaloneUSEWitnessFinder.confirmOrDiscard(problem, result);
							System.out.println(status);
						}
					}

					System.out.println("Confirmed problems (either statically or by the constraint solver):");
					for (Problem p : result.getConfirmedProblems()) {
						String location = (p instanceof LocalProblem) ? ((LocalProblem) p).getLocation() : "-";
						System.out.println(location + ": " + p.getDescription());
					}
				}
			}
		} catch (AnalyserInternalError e) {
			problems.add(null);
		} catch (LoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return problems;
	}
	
	private void modelToProject(File modelFile, String projectName) {
		ATLPackage.eINSTANCE.eClass();
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isValid(String metamodel, String seed, String model, Class<?> cls, IProject project) {
		boolean isValid = false;
		
		try {
			final IFolder iFolder = project.getFolder(new Path("temp"));
			if (iFolder.exists() == false) {
				iFolder.create(true, true, new NullProgressMonitor());
			}
			File modelFile = new File(model);
			modelToProject(modelFile, project.getName());
			List<Problem> problems = findProblems(project);
			isValid = problems.size() == 0;
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
