package wodel.atl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.engine.compiler.atl2006.Atl2006Compiler;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;
import org.xmlunit.diff.ElementSelectors;

import builder.SampleNature;
import equivalence.run.Equivalence;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.ModelManager;

public class AtlEquivalence extends Equivalence {
	
	@Override
	public String getName() {
		return "ATL Program Equivalence";
	}
	
	@Override
	public String getURI() {
		return "http://www.eclipse.org/gmt/2005/ATL";
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
		
	}
	
	private void compile(IProject project) {
		try {
			Atl2006Compiler compiler = new Atl2006Compiler();
			FileInputStream trafoFile;
			File folder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/temp");
			for (File atl_file : folder.listFiles()) {
				if (atl_file.isFile() && atl_file.getName().endsWith(".atl")) {
					trafoFile = new FileInputStream(atl_file);
					String asm_transformation = atl_file.getName().replace(".atl", ".asm");
					compiler.compile(trafoFile, ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/temp/" + asm_transformation);
				}
				if (atl_file.isDirectory()) {
					for (File atl_file2 : atl_file.listFiles()) {
						if (atl_file2.isFile() && atl_file2.getName().endsWith(".atl")) {
							trafoFile = new FileInputStream(atl_file2);
							String asm_transformation = atl_file2.getName().replace(".atl", ".asm");
							compiler.compile(trafoFile, ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/temp/" + atl_file.getName() + "/" + asm_transformation);
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
	}
	
	private boolean modelToProject(File modelFile, String projectName) {
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
			return false;
		}
		return true;	}
	
	private String getXML(File modelFile, String projectName) {
		String xml = "";
		try {
			String path = ModelManager.getWorkspaceAbsolutePath() + "/" + projectName + "/temp/" + modelFile.getName().replace(".model", ".asm");
			File xmlFile = new File(path);
			FileReader xmlReader = new FileReader(xmlFile);
			BufferedReader bufferedReader = new BufferedReader(xmlReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				xml += line + "\n";
			}
			bufferedReader.close();
			xmlReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xml;
	}
	
	private boolean doCompare(String xml1, String xml2) {
		
		boolean isRepeated = false;
		StringReader stringReader1 = new StringReader(xml1);
		Source source1 = new StreamSource(stringReader1);
		StringReader stringReader2 = new StringReader(xml2);
		Source source2 = new StreamSource(stringReader2);

		Map<String, String> changes1 = new HashMap<String, String>();
		Diff diff = DiffBuilder.compare(source1).withTest(source2)
				.withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText))
				.checkForSimilar()
				.ignoreWhitespace()
				.ignoreComments()
				.build();
		
		if (diff.hasDifferences() == true) {
			Iterator<Difference> differences = diff.getDifferences().iterator();
			while (differences.hasNext()) {
				Difference difference = differences.next();
				Comparison comparison = difference.getComparison();
				changes1.put(comparison.getTestDetails().getXPath(),
						comparison.getTestDetails().getValue() != null ? comparison.getTestDetails().getValue().toString() : "");
			}

			Map<String, String> changes2 = new HashMap<String, String>();
			stringReader1 = new StringReader(xml2);
			source1 = new StreamSource(stringReader1);
			stringReader2 = new StringReader(xml1);
			source2 = new StreamSource(stringReader2);
			diff = DiffBuilder.compare(source1).withTest(source2)
					.withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText))
					.checkForSimilar()
					.ignoreWhitespace()
					.ignoreComments()
					.build();
			differences = diff.getDifferences().iterator();
			int counter = 0;
			while (differences.hasNext()) {
				Difference difference = differences.next();
				Comparison comparison = difference.getComparison();
				changes2.put(comparison.getTestDetails().getXPath(),
						comparison.getTestDetails().getValue() != null ? comparison.getTestDetails().getValue().toString() : "");
				counter++;
			}
			int equivalences = 0;
			for (String key1 : changes1.keySet()) {
				String value2 = changes2.get(key1);
				if (value2 != null) {
					for (String key2 : changes2.keySet()) {
						if (!key1.equals(key2)) {
							String value1 = changes1.get(key2);
							if (value1 != null) {
								if (value1.equals(value2)) {
									equivalences++;
								}
							}
						}
					}
				}
			}
			isRepeated = counter == equivalences;
		}
		else {
			isRepeated = true;
		}
		stringReader2.close();
		stringReader1.close();
		return isRepeated;
	}
	
	public boolean applyTCE(String model1, String model2, IProject project) {
		boolean isRepeated = false;
		try {
			final IFolder iFolder = project.getFolder(new Path("temp"));
			if (iFolder.exists() == false) {
				iFolder.create(true, true, new NullProgressMonitor());
			}
			// GET XML FOR FIRST PROGRAM
			File modelFile1 = new File(model1);
			boolean done = modelToProject(modelFile1, project.getName());
			if (!done) return false;
			compile(project);
			//String xml1 = getXML(modelFile, project.getName());
			//GET XML FOR SECOND PROGRAM
			File modelFile2 = new File(model2);
			done = modelToProject(modelFile2, project.getName());
			if (!done) return false;
			compile(project);
			//String xml2 = getXML(modelFile, project.getName());
			//isRepeated = doCompare(xml1, xml2);
			isRepeated = doCompare(getXML(modelFile1, project.getName()), getXML(modelFile2, project.getName()));
			iFolder.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRepeated;
	}

	@Override
	public boolean doCompare(String metamodel, String model1, String model2, IProject project) {
		try {
			//If it is a Wodel project
			if (project.hasNature(JavaCore.NATURE_ID) && project.hasNature(SampleNature.NATURE_ID)) {
				System.out.println("Warning:");
				System.out.println("This comparison extension can only be used in the tester instance.");
				System.out.println("Using default synctactic comparison.");
				List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
				Resource resource1 = ModelManager.loadModel(packages, model1);
				Resource resource2 = ModelManager.loadModel(packages, model2);
				return ModelManager.compareModels(resource1, resource2);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applyTCE(model1, model2, project);
	}
	
}
