package efinder.emfocl.tests.ocldataset;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.jdt.annotation.NonNull;

import efinder.core.EFinderModel;
import efinder.core.IModelFinder.Result;
import efinder.core.errors.Report;
import efinder.usemv.UseMvResult;

public class Stats implements ExecutionRecord {

	private int totalFiles;
	// Failures
	List<String> doNotValidate = new ArrayList<>();
	List<String> loadErrors = new ArrayList<>();

	List<String> processedOk = new ArrayList<>();
	List<String> invalidTranslation = new ArrayList<>();
	// Reason => File
	HashMap<String, List<String>> unsupportedFeature = new HashMap<>();	
	HashMap<String, List<String>> typeErrors = new HashMap<>();	
	
	List<String> unknownFailure = new ArrayList<>();
	
	@Override
	public void processed(@NonNull String filename, Result result, EFinderModel ir) {
		switch(result.getStatus()) {
		case SAT:
		case UNSAT:
			processedOk.add(filename);
			break;
		case UNSUPPORTED_FEATURE:
			Report report = ((UseMvResult.Unsupported) result).getReport();
			String reason = report.getUnsupported().get(0).getReason();
			unsupportedFeature.computeIfAbsent(reason, (k) -> new ArrayList<>());
			unsupportedFeature.get(reason).add(filename);
			break;
		case INVALID_TRANSLATION:
			invalidTranslation.add(filename);
			break;
		default:
			throw new IllegalStateException("Unknown STATUS = " + result);
		}
		
	}

	@Override
	public void unknownFailure(@NonNull String filename) {
		unknownFailure.add(filename);
	}

	@Override
	public void doNotValidate(@NonNull String filename) {
		doNotValidate.add(filename);
	}

	public void setExpectedFiles(int size) {
		totalFiles = size;
	}

	public void printTo(PrintStream out) {
		int numProcessed = processedOk.size();

		out.println();
		out.println("*** Load error:");
		for (String string : loadErrors) {
			out.println("  - " + string);
		}
		out.println();

		out.println();
		out.println("*** Do not validate:");
		for (String string : doNotValidate) {
			out.println("  - " + string);
		}
		out.println();

		out.println();
		out.println("*** Unsupported:");
		for (Entry<String, List<String>> items : unsupportedFeature.entrySet()) {
			out.println("  - " + items.getKey() + "(" + items.getValue().size() + " files)");
			for (String string : items.getValue()) {
				out.println("     - " + string);
			}
		}
		out.println();

		out.println();
		out.println("*** Type errors:");
		for (Entry<String, List<String>> items : typeErrors.entrySet()) {
			out.println("  - " + items.getKey() + "(" + items.getValue().size() + " files)");
			for (String string : items.getValue()) {
				out.println("     - " + string);
			}
		}
		out.println();
		
		out.println();
		out.println("*** Invalid translation:");
		for (String string : invalidTranslation) {
			out.println("  - " + string);
		}
		out.println();

		out.println();
		out.println("*** Failures");
		for (String string : unknownFailure) {
			out.println("  - " + string);
		}
		out.println();
		
		int totalFailures = getTotalFailures();
		out.println("Total files: " + totalFiles);
		out.println("   * Processed ok: " + numProcessed);
		out.println("   *  Unsupported: " + totalUnsupportedFeatures());
		out.println("   *  Inv. transl: " + invalidTranslation.size());
		out.println("   *     Failures: " + totalFailures);
		out.println("       -  Unknown: " + unknownFailure.size());
		out.println("       - Load err: " + loadErrors.size());
		out.println("       - Type err: " + typeErrors.size());
		out.println("       - Validate: " + doNotValidate.size());
		// Preconditions.checkState(totalFailures + numProcessed == totalFiles);
		
		
	}

	private int totalUnsupportedFeatures() {
		int count = 0;
		for (Entry<String, List<String>> entry : unsupportedFeature.entrySet()) {
			count += entry.getValue().size();
		}
		return count;
	}
	
	private int totalTypeErrors() {
		int count = 0;
		for (Entry<String, List<String>> entry : typeErrors.entrySet()) {
			count += entry.getValue().size();
		}
		return count;
	}

	private int getTotalFailures() {
		return unknownFailure.size() + doNotValidate.size() + loadErrors.size() + totalTypeErrors();
	}

	@Override
	public void loadError(@NonNull String filename) {
		loadErrors.add(filename);
	}

	@Override
	public void typeError(@NonNull String filename, String reason) {
		typeErrors.computeIfAbsent(reason, (k) -> new ArrayList<>());
		typeErrors.get(reason).add(filename);
	}

}
