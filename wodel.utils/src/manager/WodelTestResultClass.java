package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WodelTestResultClass {

	private String name;
	private List<WodelTestResult> results;
	
	public String getName() {
		return name;
	}
	
	public List<WodelTestResult> getResults() {
		return results;
	}
	
	public int getFailureCount() {
		int failures = 0;
		for (WodelTestResult result : results) {
			failures += result.getFailureCount();
		}
		return failures;
	}
	
	public void addResult(WodelTestResult newResult) {
		boolean found = false;
		for (WodelTestResult result : results) {
			if (result.getClassName().equals(newResult.getClassName())) {
				result.addTests(newResult.getTests());
				found = true;
				break;
			}
		}
		if (found == false) {
			results.add(newResult);
		}
	}

	public int getRunCount() {
		int run = 0;
		for (WodelTestResult result : results) {
			run += result.getRunCount();
		}
		return run;
	}
	
	public static void storeProjectInfo(String path, String projectName, String natureId) {
		File file = new File(path);
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write(projectName + "\n");
			writer.write(natureId + "\n");
			writer.flush();
			writer.close();

		} catch (IOException e) {
		}
	}

	public static String[] loadProjectInfo(String path) {
		String projectName = "";
		String natureId = "";
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			projectName = br.readLine();
			natureId = br.readLine();
			br.close();
			fr.close();
		} catch (IOException ex){
		}
		String[] info = new String[2];
		info[0] = projectName;
		info[1] = natureId ;
		return info;
	}
	
	private static void addResults(List<WodelTestResultClass> currentResults, List<WodelTestResultClass> resultsClass) {
		List<WodelTestResultClass> newResults = new ArrayList<WodelTestResultClass>();
		for (WodelTestResultClass resultClass : resultsClass) {
			boolean found = false;
			for (WodelTestResultClass currentResult : currentResults) {
				if (currentResult.getName().equals(resultClass.getName())) {
					for (WodelTestResult testResult : resultClass.getResults()) {
						currentResult.addResult(testResult);
					}
					found = true;
					break;
				}
			}
			if (found == false) {
				newResults.add(resultClass);
			}
		}
		currentResults.addAll(newResults);
	}
	
	public static void storeFile(String path, List<WodelTestResultClass> resultsClass) {
		File file = new File(path);
		try {
			if (file.exists() != true) {
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file, true);
			for (WodelTestResultClass resultClass : resultsClass) {
				for (WodelTestResult result : resultClass.getResults()) {
					writer.write(resultClass.getName() + "|" + result.toText() + "\n");
				}
			}
			writer.flush();
			writer.close();

		} catch (IOException e) {
		}
	}
	
	public static WodelTestResultClass getWodelTestResultClassByName(List<WodelTestResultClass> resultsClass, String name) {
		for (WodelTestResultClass wodelTestResultClass : resultsClass) {
			if (wodelTestResultClass.getName().equals(name)) {
				return wodelTestResultClass;
			}
		}
		return null;
	}

	public static List<WodelTestResultClass> loadFile(String path) {
		List<WodelTestResultClass> resultsClass = new ArrayList<WodelTestResultClass>();
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] data = line.split("[|]");
				String name = data[0];
				String clazz = data[1];
				String testpath = data[2];
				String[] testsText = data[3].split(";");
				Map<String, Boolean> tests = new HashMap<String, Boolean>();
				String[] test = testsText[0].split(":");
				List<String> testNames = new ArrayList<String>();
				List<Boolean> values = new ArrayList<Boolean>();
				for (String t : test) {
					String[] pair = t.split("=");
					if (pair.length > 1) {
						tests.put(pair[0], Boolean.parseBoolean(pair[1]));
						testNames.add(pair[0]);
						values.add(Boolean.parseBoolean(pair[1]));
					}
				}
				String[] testsFailed = new String[testsText.length - 1];
				Arrays.asList(testsText).subList(1, testsText.length).toArray(testsFailed);
				String[] messagesText = data[4].split(";");
				List<WodelTestInfo> testsInfo = new ArrayList<WodelTestInfo>();
				String[] errorText = data[5].split(";");
				for (int i = 0; i < testsFailed.length || i < messagesText.length; i++) {
					String info = "";
					if (i < testsFailed.length) {
						info = testsFailed[i].trim();
					}
					String message = "";
					if (i < messagesText.length) {
						message = messagesText[i].trim();
					}
					boolean error = false;
					if (i < errorText.length) {
						error = Boolean.parseBoolean(errorText[i].trim());
					}
					if (!(info.equals("") && message.equals("")) && testNames.size() > i && values.size() > i) {
						WodelTestInfo testInfo = new WodelTestInfo(testNames.get(i), values.get(i), info, message);
						testInfo.setFailure(error);
						testsInfo.add(testInfo);
					}
				}
				WodelTestResult result = new WodelTestResult(clazz, testpath, tests, testsInfo);
				WodelTestResultClass wodelTestResultClass = getWodelTestResultClassByName(resultsClass, name);
				if (wodelTestResultClass == null) {
					wodelTestResultClass = new WodelTestResultClass(name);
					resultsClass.add(wodelTestResultClass);
				}
				wodelTestResultClass.addResult(result);
			}
			br.close();
			fr.close();
		} catch (IOException ex){
		}
		
		return resultsClass;
	}

	public static int[] getDifferentRatio(String path) {
		int[] ratio = new int[2];
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			String[] values = line.split("[|]");
			ratio[0] = Integer.parseInt(values[0]);
			ratio[1] = Integer.parseInt(values[1]);
			br.close();
			fr.close();
		} catch (IOException ex){
		}
		return ratio;
	}
	
	public WodelTestResultClass(String name) {
		this.name = name;
		this.results = new ArrayList<WodelTestResult>();
	}
}
