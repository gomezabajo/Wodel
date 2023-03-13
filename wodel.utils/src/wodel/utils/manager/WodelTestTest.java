package wodel.utils.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WodelTestTest {
	
	private String name;
	
	private List<WodelTestResultTest> results;
	
	public String getName() {
		return name;
	}
	
	public List<WodelTestResultTest> getResults() {
		return results;
	}
	
	public int getKilledMutants() {
		Map<String, Boolean> mutants = new HashMap<String, Boolean>();
		for (WodelTestResultTest result : results) {
			for (WodelTestResultTestInfo mutant : result.getMutants()) {
				if (!mutants.containsKey(mutant.getName())) {
					mutants.put(mutant.getName(), mutant.getValue());
				}
				else {
					if (mutant.getValue() == true) {
						mutants.put(mutant.getName(), mutant.getValue());
					}
				}
			}
		}
		int numKilledMutants = 0;
		for (String mutant : mutants.keySet()) {
			if (mutants.get(mutant) == true) {
				numKilledMutants++;
			}
		}
		return numKilledMutants;
	}
	
	public static List<WodelTestTest> loadFile(String path) {
		List<WodelTestTest> wodelTestResults = new ArrayList<WodelTestTest>();
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] data = line.split("[|]");
				String mutant = data[0];
				String name = data[2];
				WodelTestTest test = null;
				List<WodelTestResultTest> wodelTestResultTest = null;
				for (WodelTestTest t : wodelTestResults) {
					if (name.equals(t.getName())) {
						test = t;
						wodelTestResultTest = t.getResults();
						break;
					}
				}
				if (test == null) {
					test = new WodelTestTest();
					test.name = name;
					test.results = new ArrayList<WodelTestResultTest>();
					wodelTestResultTest = test.results;
				}
				String[] testText = data[3].split(":");
				Map<String, Boolean> tests = new HashMap<String, Boolean>();
				String[] messagesText = data[4].split(";");
				String[] errorText = data[5].split(";");
				int counter = 0;
				for (String t : testText) {
					String[] pair = t.split("=");
					if (pair.length > 1) {
						tests.put(pair[0], Boolean.parseBoolean(pair[1]));
						WodelTestResultTest wodelTestResult = null;
						for (WodelTestResultTest trt : wodelTestResultTest) {
							if (pair[0].equals(trt.getName())) {
								wodelTestResult = trt;
								break;
							}
						}
						if (wodelTestResult == null) {
							wodelTestResult = new WodelTestResultTest();
							wodelTestResult.setName(pair[0]);
							test.results.add(wodelTestResult);
						}
						boolean added = false;
						for (WodelTestResultTestInfo mut : wodelTestResult.getMutants()) {
							if (mut.getName().equals(mutant)) {
								added = true;
								break;
							}
						}
						if (added == false) {
							boolean value = Boolean.parseBoolean(pair[1]);
							String message = "";
							boolean error = false;
							message = messagesText.length > counter ? messagesText[counter].trim() : "";
							if (value == true) {
								error = errorText.length > counter ? Boolean.parseBoolean(errorText[counter].trim()) : false;
							}
							wodelTestResult.addMutant(mutant, value, error, message, null);
						}
					}
					counter++;
				}
				boolean added = false;
				for (WodelTestTest wodelTestResult : wodelTestResults) {
					if (wodelTestResult.getName().equals(test.getName())) {
						added = true;
					}
				}
				if (added == false) {
					wodelTestResults.add(test);
				}
			}
			br.close();
			fr.close();
		} catch (IOException ex){
		}
		
		return wodelTestResults;
	}

}
