package wodel.semantic.comparison.atl.run;

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

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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

import wodel.semantic.comparison.run.SemanticComparison;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.LockRegistry;
import wodel.utils.manager.ModelManager;
import wodel.project.builder.WodelNature;

@SuppressWarnings("restriction")
public class ATLSemanticComparison extends SemanticComparison {

	@Override
	public String getName() {
		return "ATL program semantic comparison";
	}

	@Override
	public String getURI() {
		return "http://www.eclipse.org/gmt/2005/ATL";
	}

	private void compile(IProject project) {
		try {
			Atl2006Compiler compiler = new Atl2006Compiler();
			FileInputStream trafoFile;
			String projectPath = project.getLocation().toFile().getPath().replace("\\", "/");
			File folder = new File(projectPath + "/temp");
			for (File atl_file : folder.listFiles()) {
				if (atl_file.isFile() && atl_file.getName().endsWith(".atl")) {
					trafoFile = new FileInputStream(atl_file);
					String asm_transformation = atl_file.getName().replace(".atl", ".asm");
					compiler.compile(trafoFile, projectPath + "/temp/" + asm_transformation);
				}
				if (atl_file.isDirectory()) {
					for (File atl_file2 : atl_file.listFiles()) {
						if (atl_file2.isFile() && atl_file2.getName().endsWith(".atl")) {
							trafoFile = new FileInputStream(atl_file2);
							String asm_transformation = atl_file2.getName().replace(".atl", ".asm");
							compiler.compile(trafoFile, projectPath + "/temp/" + atl_file.getName() + "/" + asm_transformation);
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

			String projectPath = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getLocation().toFile().getPath().replace("\\", "/");
			String outputPath = projectPath + "/temp/";
			File outputFolder = new File(outputPath);
			if (!outputFolder.exists()) {
				outputFolder.mkdir();
			}
			AtlParser atlParser = new AtlParser();
			atlParser.extract(atlModel, "file:/" + outputPath + "/" + modelFile.getName().replace(".model", ".atl"));
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	private String getXML(File modelFile, String projectName) {
		String xml = "";
		try {
			String projectPath = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getLocation().toFile().getPath().replace("\\", "/");
			String path = projectPath + "/temp/" + modelFile.getName().replace(".model", ".asm");
			File xmlFile = new File(path);
			if (xmlFile.exists()) {
				FileReader xmlReader = new FileReader(xmlFile);
				BufferedReader bufferedReader = new BufferedReader(xmlReader);
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					xml += line + "\n";
				}
				bufferedReader.close();
				xmlReader.close();
			}
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
	
	public boolean applyTCE(String model1, String model2, boolean[] processed, IProject project) {
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
			String xml1 = getXML(modelFile1, project.getName());
			//GET XML FOR SECOND PROGRAM
			File modelFile2 = new File(model2);
			done = modelToProject(modelFile2, project.getName());
			if (!done) return false;
			compile(project);
			String xml2 = getXML(modelFile2, project.getName());
			//isRepeated = doCompare(xml1, xml2);
			if (!xml1.equals("") && !xml2.equals("")) {
				isRepeated = doCompare(xml1, xml2);
				processed[0] = true;
			}
			LockRegistry.INSTANCE.acquire(iFolder.getFullPath().toFile().getPath(), LockRegistry.LockType.WRITE);
			iFolder.delete(true, new NullProgressMonitor());
			LockRegistry.INSTANCE.release(iFolder.getFullPath().toFile().getPath(), LockRegistry.LockType.WRITE);
		} catch (ResourceException e) {
			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRepeated;
	}

	public boolean applyTCE(String model2, boolean[] processed, IProject project) {
		boolean isRepeated = false;
		try {
			final IFolder iFolder = project.getFolder(new Path("temp"));
			if (iFolder.exists() == false) {
				iFolder.create(true, true, new NullProgressMonitor());
			}
			// GET XML FOR FIRST PROGRAM
			File modelFile1 = new File(this.getSeedPath());
			boolean done = modelToProject(modelFile1, project.getName());
			if (!done) return false;
			compile(project);
			String xml1 = getXML(modelFile1, project.getName());
			//GET XML FOR SECOND PROGRAM
			File modelFile2 = new File(model2);
			done = modelToProject(modelFile2, project.getName());
			if (!done) return false;
			compile(project);
			String xml2 = getXML(modelFile2, project.getName());
			//isRepeated = doCompare(xml1, xml2);
			if (!xml1.equals("") && !xml2.equals("")) {
				isRepeated = doCompare(xml1, xml2);
				processed[0] = true;
			}
			LockRegistry.INSTANCE.acquire(iFolder.getFullPath().toFile().getPath(), LockRegistry.LockType.WRITE);
			iFolder.delete(true, new NullProgressMonitor());
			LockRegistry.INSTANCE.release(iFolder.getFullPath().toFile().getPath(), LockRegistry.LockType.WRITE);
		} catch (ResourceException e) {
			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRepeated;
	}

	@Override
	public boolean doCompare(List<String> metamodels, String model1, String model2, IProject project, boolean[] processed, Class<?> cls) {
		boolean ret = false;
		Resource resource1 = null;
		Resource resource2 = null;
		try {
			List<EPackage> packages = ModelManager.loadMetaModels(metamodels, cls);
			if (this.getSeedPath() == null) {
				this.setSeedPath(model1);
			}
			//If it is a Wodel project
			if (project.hasNature(JavaCore.NATURE_ID) && project.hasNature(WodelNature.NATURE_ID)) {
				System.out.println("Warning:");
				System.out.println("This comparison extension can only be used in the tester instance.");
				System.out.println("Using default syntactic comparison.");
				resource1 = ModelManager.loadModel(packages, this.getSeedPath());
				resource2 = ModelManager.loadModel(packages, model2);
				ret = ModelManager.compareModels(resource1, resource2);
				resource2.unload();
				resource1.unload();
			}
			else {
				System.out.println("Warning:");
				System.out.println("This comparison extension can only be used in the tester instance.");
				System.out.println("Using semantic XML comparison.");
				ret = applyTCE(model2, processed, project);
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
		return ret;
	}
}
