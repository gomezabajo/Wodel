package efinder.emfocl.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.junit.Test;

import efinder.core.EFinderModel;
import efinder.core.IModelFinder.Result;
import efinder.emfocl.PivotOclCompiler;
import efinder.usemv.UseMvFinder;

public class ValidateEcoreTest extends AbstractEmfOclTest {
		
	@Test
	public void testValidateECore() throws IOException, ParserException {
		File file = new File("../efinder.core.tests/resources/metamodels/universe.ecore");
		
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		EcoreUtil.resolveAll(rs);
		
		// Make sure that the packages are registered so that they can be picked by the PivotOclCompiler
		for (Resource res : rs.getResources()) {
			res.getAllContents().forEachRemaining(o -> {
				if (o instanceof EPackage) {
					EPackage pkg = (EPackage) o;
					rs.getPackageRegistry().put(pkg.getNsURI(), pkg);
				}
			});
		}
		
		ASResource as = OCL.newInstance().ecore2as(r);
		Model pivot = (Model) as.getContents().get(0);
		
		PivotOclCompiler compiler = new PivotOclCompiler(pivot, rs);
		EFinderModel ir = compiler.compile();

		// Assume that in all tests there is a root class called Model
		TestBoundsProvider boundsProvider = new TestBoundsProvider().withInterval("Model", 1, 1); 
		UseMvFinder finder = new UseMvFinder().withBoundsProvider(boundsProvider);
				
		Result result = finder.find(ir);
		assertTrue(result.isSat());
	}

}
