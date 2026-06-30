package efinder.emfocl.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import efinder.core.EFinderModel;
import efinder.core.IModelFinder.Result;
import efinder.core.footprint.FootprintComputation;
import efinder.core.footprint.IFootprint;
import efinder.core.footprint.ISlicingStrategy;
import efinder.emfocl.runner.EFinderRunner;
import efinder.usemv.UseMvFinder;

@RunWith(Parameterized.class)
public class FootprintTest extends AbstractEmfOclTest {

	@Parameters(name="{0}")
	public static Collection<? extends Object> data() throws IOException {
		List<TestData> tests = new ArrayList<>();
	
		tests.add(new TestData("relschema-1.footprint.ocl"));
		tests.add(new TestData("relschema-2.footprint.ocl"));
		tests.add(new TestData("relschema-3.footprint.ocl"));
		tests.add(new TestData("relschema-4.footprint.ocl")); /* Assertion: Base should not be in the footprint */
		tests.add(new TestData("relschema-5.footprint.ocl")); 
		
		return tests;
	}
	
	private static class TestData {
		private @NonNull String oclFileName;

		public TestData(@NonNull String oclFileName) {
			this.oclFileName = oclFileName;
		}
		
		public String getWitnessAsFileOutput() {
			return this.oclFileName.replace(".ocl", ".xmi");
		}
		
		@Override
		public String toString() {
			return oclFileName;
		}
	}

	private @NonNull TestData data;
	
	public FootprintTest(@NonNull TestData data) {
		this.data = data;
	}
	
	@Test
	public void testFootprint() {
		Model pivot = loadOclDocument("footprint/" + data.oclFileName);

		// Assume that in all tests there is a root class called Model
		TestBoundsProvider boundsProvider = new TestBoundsProvider()
				.withInterval("RelModel", 1, 1)
				.withInterval("RelSchema", 1, 1)
				.withInterval("AttrMap", 2, 2);
		
		UseMvFinder finder = new UseMvFinder()
				.withBoundsProvider(boundsProvider);
		
		EFinderRunner runner = EFinderRunner.
				withOclModel(pivot).
				withSlicingStrategy(new TestSlicingStrategy()).
				withFinder(finder);
		
		Result result = runner.find();
		assertTrue(result.isSat());
	}

	public static class TestSlicingStrategy implements ISlicingStrategy {

		@Override
		public @NonNull IFootprint getFootprint(@NonNull EFinderModel model) {
			IFootprint footprint = FootprintComputation.INSTANCE.compute(model);
			// TODO: Check that it has the classes that I want
			return footprint;
		}
		
	}
	
}
