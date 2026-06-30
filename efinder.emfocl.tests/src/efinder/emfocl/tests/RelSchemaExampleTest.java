package efinder.emfocl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.pivot.Model;
import org.junit.Test;

import efinder.core.IModelFinder.Result;
import efinder.core.IModelFinder.ScrollingResult;
import efinder.core.management.EMFModel;
import efinder.core.utils.ResourceUtils;
import efinder.emfocl.runner.EFinderRunner;
import efinder.usemv.UseMvFinder;
import efinder.usemv.UseMvFinder.FindingMode;

public class RelSchemaExampleTest extends AbstractEmfOclTest {
	
	@Test
	public void testValidation() throws IOException {
		Model pivot = loadOclDocumentFromURI("efinder.emfocl.tests/resources/examples/relschema.ocl");

		// Assume that in all tests there is a root class called Model
		TestBoundsProvider boundsProvider = new TestBoundsProvider()
				.withInterval("RelModel", 1, 1)
				.withInterval("RelSchema", 1, 1)
				.withInterval("AttrMap", 2, 2);
		
		UseMvFinder finder = new UseMvFinder()
				.withBoundsProvider(boundsProvider);
		
		EFinderRunner runner = EFinderRunner.
				withOclModel(pivot).
				withFinder(finder);
		
		Result result = runner.find();
		assertTrue(result.isSat());
		
		Resource model = result.getWitness().getResource();
		model.save(new FileOutputStream("outputs/" + "relschema.xmi"), null);
	}
	
	@Test
	public void testScrolling() throws IOException {
		Model pivot = loadOclDocumentFromURI("efinder.emfocl.tests/resources/examples/relschema.ocl");

		// Assume that in all tests there is a root class called Model
		TestBoundsProvider boundsProvider = new TestBoundsProvider()
				.withInterval("RelModel", 1, 1)
				.withInterval("RelSchema", 1, 1)
				.withInterval("AttrMap", 2, 2);
		
		UseMvFinder finder = new UseMvFinder()
				.withMode(FindingMode.SCROLL)
				.withBoundsProvider(boundsProvider);
		
		EFinderRunner runner = EFinderRunner.
				withOclModel(pivot).
				withFinder(finder);
		
		ScrollingResult result = (ScrollingResult) runner.find();
		assertTrue(result.isSat());
		
		List<File> outputFiles = new ArrayList<File>();
		for (EMFModel m : result) {
			File f = new File("outputs/" + "relschema-scrolling-" + outputFiles.size() + ".xmi");
			m.getResource().save(new FileOutputStream(f), null);
			outputFiles.add(f);
		
			if (outputFiles.size() == 2)
				break;
		}	
		
		for(int i = 0; i < outputFiles.size(); i++) {
			File file1 = outputFiles.get(i);
			for(int j = i + 1; j < outputFiles.size(); j++) {
				File file2 = outputFiles.get(j);
				byte[] f1 = Files.readAllBytes(file1.toPath());
				byte[] f2 = Files.readAllBytes(file2.toPath());
				assertNotEquals(file1 + " does not differ from " + file2, f1, f2); 
			}	
		}
	}	

	@Test
	public void testPartialModel() throws IOException {
		String xmiPartialModel = "partial-model-1.xmi";
		Model pivot = loadOclDocumentFromURI("efinder.emfocl.tests/resources/examples/relschema.ocl");
		EMFModel partialModel = ResourceUtils.fromFile("resources/examples/" + xmiPartialModel, "resources/examples/RelSchema.ecore");		

		// Assume that in all tests there is a root class called Model
		TestBoundsProvider boundsProvider = new TestBoundsProvider()
				.withInterval("RelModel", 1, 1)
				.withInterval("Attribute", 3, 3) /* Make it has one more attribute */
				.withInterval("Row", 1, 1)
				.withInterval("AttrMap", 2, 2)
				.withInterval("Value", 1, 4)
				;
		
		UseMvFinder finder = new UseMvFinder()
				.withBoundsProvider(boundsProvider)
				.withPartialModel(partialModel);
		
		EFinderRunner runner = EFinderRunner.
				withOclModel(pivot).
				withFinder(finder);
		
		Result result = runner.find();
		if (result.isSat()) {
			Resource model = result.getWitness().getResource();
			model.save(new FileOutputStream("outputs/" + xmiPartialModel.replace(".xmi",".complete.xmi")), null);
		
		}
//		// Save to debug, possibly use a flag
//		if (result.isSat()) {
//			Resource model = result.getWitness().getResource();
//			model.save(new FileOutputStream("outputs/" + data.getWitnessAsFileOutput()), null);
//		}
//		
//		if (data.oracle != null ) {
//			OclTestOracle oracle = readTestOracle(data.oracle.getAbsolutePath());
//			oracle.assertResult(result);
//		}
	}

}
