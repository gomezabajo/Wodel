package mutator.wodeltest.[@**@];

import manager.IWodelTest;
import manager.WodelTestGlobalResult;
import manager.WodelTestGlobalResult.Status;
import manager.WodelTestInfo;
import manager.WodelTestResult;
import manager.WodelTestResultClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.adt.AtlNature;
import org.eclipse.m2m.atl.common.ATL.ATLPackage;
import org.eclipse.m2m.atl.common.ATL.Module;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.compiler.atl2006.Atl2006Compiler;
import org.eclipse.m2m.atl.engine.emfvm.VMException;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.m2m.atl.engine.parser.AtlSourceManager;

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.ModelManager;

public class WodelTest implements IWodelTest {

	@Override
	public String getProjectName() {
		return "[@**@]";
	}

	@Override
	public String getNatureId() {
		return AtlNature.ATL_NATURE_ID;
	}
	
	@Override
	public void compile(IProject project) {
		try {
			Atl2006Compiler compiler = new Atl2006Compiler();
			FileInputStream trafoFile;
			File folder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName());
			for (File atl_file : folder.listFiles()) {
				if (atl_file.isFile() && atl_file.getName().endsWith(".atl")) {
					trafoFile = new FileInputStream(atl_file);
					String asm_transformation = atl_file.getName().replace(".atl", ".asm");
					compiler.compile(trafoFile, ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/" + asm_transformation);
				}
				if (atl_file.isDirectory()) {
					for (File atl_file2 : atl_file.listFiles()) {
						if (atl_file2.isFile() && atl_file2.getName().endsWith(".atl")) {
							trafoFile = new FileInputStream(atl_file2);
							String asm_transformation = atl_file2.getName().replace(".atl", ".asm");
							compiler.compile(trafoFile, ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/" + atl_file.getName() + "/" + asm_transformation);
						}
					}
				}
			}
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getIn(String projectPath, String projectName) {
		String in = "";
		try {
			AtlSourceManager manager = new AtlSourceManager();
			manager.updateDataSource(new FileInputStream(projectPath + "/" + projectName + ".atl"));
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
	
	private String getOut(String projectPath, String projectName) {
		String out = "";
		try {
			AtlSourceManager manager = new AtlSourceManager();
			manager.updateDataSource(new FileInputStream(projectPath + "/" + projectName + ".atl"));
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

	@Override
	public List<String> artifactPaths(IProject project, String projectPath, File outputFolder, List<String> blockNames) {
		List<String> artifactPaths = new ArrayList<String>();
		if (blockNames.size() > 0) {
			for (String blockName : blockNames) {
				int i = 0;
				File fileTransformationModule = new File(projectPath + "/" + blockName + "/Output" + i + ".atl");
				while (fileTransformationModule.exists()) {
					artifactPaths.add(projectPath + "/" + blockName + "/Output" + i + ".atl");
					i++;
					fileTransformationModule = new File(projectPath + "/" + blockName + "/Output" + i + ".atl");
				}
			}
		}
		else {
			int i = 0;
			File fileTransformationModule = new File(projectPath + "/Output" + i + ".atl");
			while (fileTransformationModule.exists()) {
				artifactPaths.add(projectPath + "/Output" + i + ".atl");
				i++;
				fileTransformationModule = new File(projectPath + "/Output" + i + ".atl");
			}
		}
		
		return artifactPaths;
	}
	
	private WodelTestResult getResult(String projectName, Object template, Object initial, String artifactPath, List<Object> tests) {
		List<WodelTestInfo> testsInfo = new ArrayList<WodelTestInfo>();
		try {
			String outMetamodel = (String) template;
			List<EPackage> packages = ModelManager.loadMetaModel(outMetamodel);
			Resource seed = ModelManager.loadModel(packages, (String) initial);
			packages = ModelManager.loadMetaModel(outMetamodel);
			Resource mutant = ModelManager.loadModel(packages, artifactPath);
			boolean value = ModelManager.compareModels(seed, mutant);
			String message = value ? EQUALS : DIFFERENT;
			WodelTestInfo info = new WodelTestInfo(artifactPath.substring(artifactPath.lastIndexOf(projectName), artifactPath.length()), !value, seed.getURI().lastSegment(), message);
			testsInfo.add(info);
		} catch (MetaModelNotFoundException e) {
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
		}
		return new WodelTestResult(projectName, projectName, tests, testsInfo);
	}

	private List<Object> getTests(String testSuitePath) {
		List<Object> ret = new ArrayList<Object>();
		File inFolder = new File(testSuitePath + "/in");
		for (File inFile : inFolder.listFiles()) {
			if (inFile.getName().endsWith(".model")) {
				ret.add(testSuitePath + "/in/" + inFile.getName());
			}
		}
		return ret;
	}
	
	
	//Main transformation launch method
	private Status runTest(String in, String inMetamodelPath, String inModelPath, String out, String outMetamodelPath, String outModelPath,
			String transformationDir, String transformationModule) {
		try {
			/*
			 * Initializations
			 */
			ILauncher transformationLauncher = new EMFVMLauncher();
			ModelFactory modelFactory = new EMFModelFactory();
			IInjector injector = new EMFInjector();
			IExtractor extractor = new EMFExtractor();

			/*
			 * Load metamodels
			 */
			IReferenceModel inMetamodel = modelFactory.newReferenceModel();
			injector.inject(inMetamodel, "file:/" + inMetamodelPath);
			IReferenceModel outMetamodel = modelFactory.newReferenceModel();
			injector.inject(outMetamodel, "file:/" + outMetamodelPath);

			/*
			 * Run "Cut" transformation
			 */
			IModel inModel = modelFactory.newModel(inMetamodel);
			injector.inject(inModel, "file:/" + inModelPath);

			IModel outModel = modelFactory.newModel(outMetamodel);
			outModel.setIsTarget(true);

			transformationLauncher.initialize(new HashMap<String,Object>());
			transformationLauncher.addInOutModel(inModel, "IN", in);
			transformationLauncher.addOutModel(outModel, "OUT", out);
			transformationLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), new HashMap<String,Object>(),
					new FileInputStream(transformationDir + "/" + transformationModule + ".asm"));

			extractor.extract(outModel, "file:/" + outModelPath);

			/*
			 * Unload all models and metamodels (EMF-specific)
			 */
			EMFModelFactory emfModelFactory = (EMFModelFactory) modelFactory;
			emfModelFactory.unload((EMFModel) inModel);
			emfModelFactory.unload((EMFModel) outModel);
			emfModelFactory.unload((EMFReferenceModel) inMetamodel);
			emfModelFactory.unload((EMFReferenceModel) outMetamodel);
		} catch (VMException e) {
		} catch (ATLCoreException e) {
			e.printStackTrace();
			return Status.EXCEPTION;
		} catch (FileNotFoundException e) {
			return Status.ERROR;
		}
		return Status.OK;
	}

	private void runHelper(WodelTestGlobalResult globalResult, List<WodelTestResultClass> results, IProject project, List<Object> tests, Object test, String artifactPath, String blockName, String in, String inMetamodel, String out, String outMetamodel, String projectPath) {
		String inModel = (String) test;
		String modelName = inModel.substring(inModel.lastIndexOf("/") + 1, inModel.length());
		int i = Integer.parseInt(artifactPath.substring(artifactPath.indexOf("/Output") + "/Output".length(), artifactPath.indexOf(".atl")));
		String modelPath = artifactPath.substring(0, artifactPath.indexOf(project.getName() + "/") + (project.getName() + "/").length()) + "out/out_" + modelName; 
		String outputPath = artifactPath.replace("/" + blockName + "/Output" + i + ".atl", "/out/" + blockName + "/" + modelName.replace(".model", "") + "/out_" + modelName.replace(".model", "_" + i + "_mut.model"));
		File transformationModuleFile = new File(artifactPath);
		if (transformationModuleFile != null && transformationModuleFile.getName().startsWith("Output") && transformationModuleFile.getName().endsWith(".atl")) {
			Status status = null;
			String transformationModule = null;
			if (!blockName.equals("")) {
				transformationModule = blockName + "/" + transformationModuleFile.getName().replace(".atl", "");
				status = runTest(in, inMetamodel, inModel, out, outMetamodel, outputPath, projectPath, transformationModule);
			}
			else {
				status = runTest(in, inMetamodel, inModel, out, outMetamodel, outputPath, projectPath, transformationModuleFile.getName().replace(".atl", ""));
			}
			WodelTestResult result = getResult(project.getName(), outMetamodel, modelPath, outputPath, tests);
			globalResult.incNumTestsExecuted(result != null ? result.getRunCount() : 0);
			globalResult.incNumTestsFailed(result != null ? result.getFailureCount() : 0);
			WodelTestResultClass resultClass = null;
			if (!blockName.equals("")) {
				resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, "/" + project.getName() + "/" + transformationModule + ".atl");
				if (resultClass == null) {
					resultClass = new WodelTestResultClass("/" + project.getName() + "/" + transformationModule + ".atl");
					results.add(resultClass);
				}
			}
			else {
				resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, "/" + project.getName() + "/" + transformationModuleFile.getName());
				if (resultClass == null) {
					resultClass = new WodelTestResultClass("/" + project.getName() + "/" + transformationModuleFile.getName() + ".atl");
					results.add(resultClass);
				}
			}
			if (result != null) {
				resultClass.addResult(result);
			}
			globalResult.setStatus(status);
		}
	}

	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath) {
		WodelTestGlobalResult globalResult = new WodelTestGlobalResult();
		try {
			List<WodelTestResultClass> results = globalResult.getResults();
			String projectPath = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName();
			String in = getIn(projectPath, project.getName());
			String inMetamodel = projectPath + "/" + in + ".ecore";
			String out = getOut(projectPath, project.getName());
			String outMetamodel = projectPath + "/" + out + ".ecore";
			String testSuitePath = ModelManager.getWorkspaceAbsolutePath() + "/" + testSuiteProject.getName();
			List<Object> tests = getTests(testSuitePath);
			for (Object test : tests) {
				String inModel = (String) test;
				String modelName = inModel.substring(inModel.lastIndexOf("/") + 1, inModel.length());
				String modelPath = artifactPath.substring(0, artifactPath.indexOf(project.getName() + "/") + (project.getName() + "/").length()) + "out/out_" + modelName; 
				runTest(in, inMetamodel, inModel, out, outMetamodel, modelPath, projectPath, artifactPath.replace(".atl", ""));
				String blockName = artifactPath.substring(artifactPath.indexOf("\\" + project.getName() + "/") + ("\\" + project.getName() + "/").length(), artifactPath.length());
				blockName = blockName.substring(0, blockName.indexOf("/"));
				runHelper(globalResult, results, project, tests, test, artifactPath, blockName, in, inMetamodel, out, outMetamodel, projectPath);
			}
		} catch (SecurityException e) {
			// 	TODO Auto-generated catch block
			e.printStackTrace();
			globalResult.setStatus(Status.EXCEPTION);
		}
		return globalResult;
	}

	@Override
	public void projectToModel(String projectName, Class<?> cls) {
		try {
			String transformationFile = ModelManager.getWorkspaceAbsolutePath() + "/" + projectName + "/" + projectName + ".atl";
			ModelFactory modelFactory = new EMFModelFactory();
			IReferenceModel atlMetamodel = AtlParser.getDefault().getAtlMetamodel();
			IModel atlModel = modelFactory.newModel(atlMetamodel);
			AtlParser atlParser = new AtlParser();		
			atlParser.inject(atlModel, transformationFile);			
			atlModel.setIsTarget(true); // the model is not write-only

			// serialize the atl file into a model
			String injectedFile = "file:/" + ModelManager.getMetaModelPath(cls) + "/" + projectName + ".model";
			IExtractor extractor = new EMFExtractor();
			extractor.extract(atlModel, injectedFile);

		} catch (ATLCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean modelToProject(String className, Resource model, String folderName, String modelName, String projectName, Class<?> cls) {
		ATLPackage.eINSTANCE.eClass();
		try {
			ModelFactory modelFactory = new EMFModelFactory();
			IReferenceModel atlMetamodel = AtlParser.getDefault().getAtlMetamodel();
			IModel atlModel = modelFactory.newModel(atlMetamodel);
			IInjector injector = new EMFInjector();
			injector.inject(atlModel, "file:/" + ModelManager.getOutputPath(cls) + "/" + projectName
					+ "/" + folderName + "/" + modelName);

			AtlParser atlParser = new AtlParser();
			String outputPath = ModelManager.getWorkspaceAbsolutePath() + "/" + projectName + "/" + folderName;
			File outputFolder = new File(outputPath);
			if (!outputFolder.exists()) {
				outputFolder.mkdir();
			}
			atlParser.extract(atlModel, outputPath + "/" + modelName.replace(".model", ".atl"));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public String getContainerEClassName() {
		return "Module";
	}

	@Override
	public boolean annotateMutation(Resource model, EObject container, String annotation) {
		System.out.println("Annotations");
		Module element = (Module) container;
		List<String> comments = element.getCommentsAfter();
		comments.add("--" + annotation);
		System.out.println("End annotations");
		return true;
	}

}