package efinder.emfocl.tests.ocldataset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Ignore;
import org.junit.Test;

import efinder.emfocl.tests.ocldataset.Dataset.Mode;

/**
 * Evaluates the OclDataset and reports statistics about coverage:
 * 
 * See https://github.com/tue-mdse/ocl-dataset
 * 
 * @author jesus
 *
 */
public class DatasetEvaluationTest {

	
	public static Set<String> invalidCases = getInvalidCases();	
	private static Set<String> getInvalidCases() {
		Set<String> invalids = new HashSet<String>();
		if (true)
			return invalids;
		// This invariant is wrong because SelectionDivergence is type, not an enumerate
		//    invariant mustDefineTriggerIfComingFromDivergence: if self.incoming->collect(1_ : statesml::Edge[1] | 1_.source)->=(statesml::SelectionDivergence)
		invalids.add("edonjakupi/model-engineering/Lab 1/Group16_Lab1/model/statesml.ecore");

		// The meta-model is wrong, contains duplicated elements Student - Student
		invalids.add("siba88/ame/at.ac.tuwien.big.momot.examples.university.ocl/model/university_ocl.ecore");
		
		// The meta-model is wrong. Opposite is the same reference
		invalids.add("songhui/cspadapt/vmplacement/vmplace/model/VmPlacement-Backup.ecore");
		
		// There is a non-boolean invariant
		invalids.add("SSGunduz/foo/TicketSystemSerdarSuatGunduz/org.eclipse.example.Ticketmodel/model/Ticket.ecore");
		
		
		// REMOVE WHEN TIMEOUT IS IMPLEMENTED
		invalids.add("ablunk/dmx/dev-plugins/hub.sam.dmx/resources/dbl.ecore");
		
		// Invalid because a property with 'derivation' annotation is changeable => make the witness model creation fail
		invalids.add("adilinam/QVTdCaseStudy/org.eclipse.ocl.examples.xtext.tests/model/OCLinEcoreTutorial.ecore");
		
		return invalids;
	}
	
	// This is not done in regular integration mode, so ignore and uncomment on-demand
	@Ignore
	@Test
	public void testEvaluation() throws FileNotFoundException, IOException, ParseException, Exception {
		String where = System.getenv("OCL_DATASET");		
		if (where == null) {
			where = System.getProperty("user.home") + "/third-party/ocl-dataset";			
		}
		String resultFolder = "result";
		doTest(where + "/dataset/meta.json", 
			   where + "/dataset/repos",
			   resultFolder);
	}

	private void doTest(@NonNull String metadataFile, @NonNull String repoDir, String results) throws FileNotFoundException, IOException, ParseException {
		Predicate<String> predicate = (f) -> true;
		// Uncomment and replace with the proper path if you want to test a single file
		//Predicate<String> onlyOneFile = (f) -> f.contains("kchristi-MrAleborg/ProjetIDM_StateMachine/StateMachine/metaModels/StateMachine.ecore");
		//predicate = onlyOneFile;

		Mode evaluationMode = Mode.PER_INVARIANT;
		Dataset dataset = Dataset.load(metadataFile, repoDir, predicate, invalidCases);		
		Stats stats = new Stats();
		dataset.evaluate(evaluationMode, stats);
		stats.printTo(System.out);
	}
	
	
}
