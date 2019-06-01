package manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import manager.IWodelTest;
import manager.WodelTestUtils;

public class WodelTestClassInfo {
	
	public String packagename;
	public String path;
	public int numExecutedTests;
	public int numFailedTests;
	public int numFailures;
	public List<WodelTestResultInfo> tests;
	public List<String> mutationText;
	
	public static WodelTestClassInfo getInfo(IWodelTest wodelTest, String projectName, String packagename, String infopath, String classpath) {
		WodelTestClassInfo info = new WodelTestClassInfo();
		info.packagename = packagename;
		info.path = classpath;
		try {
			FileReader fr = new FileReader(infopath);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				String infoLine = null;
				String[] values = line.split("[|]");
				String path = values[0].replaceAll("\\\\", "/");
				if (path.equals(classpath)) {
					infoLine = line;
				}
				else {
					if (path.endsWith("/")) {
						path = path.substring(0, path.length() - 1);
					}
					if (classpath.indexOf("/") != -1 && (classpath.substring(0, classpath.lastIndexOf("/")).startsWith(path))) {
						infoLine = line;
					}
				}
				if (infoLine != null) {
					String[] testsText = values[3].split(";");
					if (info.tests == null) {
						info.tests = new ArrayList<WodelTestResultInfo>();
					}
					String[] test = testsText[0].split(":");
					int index = 6;
					values = infoLine.split("[|]");
					int value = 0;
					while (index < values.length) {
						try {
							value = Integer.parseInt(values[index++]);
						}
						catch (NumberFormatException ex) {
							continue;
						}
						break;
					}
					int numExecutedTests = value;
					info.numExecutedTests += numExecutedTests > test.length ? numExecutedTests / test.length : 0;
					value = 0;
					while (index < values.length) {
						try {
							value = Integer.parseInt(values[index++]);
						}
						catch (NumberFormatException ex) {
							continue;
						}
						break;
					}
					int numFailedTests = value;
					info.numFailedTests += numFailedTests > test.length ? numFailedTests / test.length : 0;
					String[] messagesText = values[4].split(";");
					String[] failureText = values[5].split(";");
					int i = 0;
					for (String t : test) {
						String[] pair = t.split("=");
						if (pair.length > 1) {
							boolean notAdded = true;
							for (WodelTestResultInfo tt : info.tests) {
								if (tt.name.equals(pair[0])) {
									notAdded = false;
									break;
								}
							}
							if (notAdded == false) {
								continue;
							}
							WodelTestResultInfo result = new WodelTestResultInfo();
							result.name = pair[0];
							result.value = Boolean.parseBoolean(pair[1]);
							result.numExecutions = numExecutedTests > test.length ? numExecutedTests / test.length : 1;
							info.numExecutedTests += numFailedTests > test.length ? 0 : result.numExecutions;
							result.numFailed = numFailedTests > test.length ? numFailedTests / test.length : result.value ? 0 : 1;
							info.numFailedTests += numFailedTests > test.length ? 0 : result.numFailed;
							if (result.value == false) {
								result.message = messagesText.length > i ? messagesText[i].trim() : "";
								result.failure = failureText.length > i ? Boolean.parseBoolean(failureText[i++]) : false;
								if (result.failure == true) {
									info.numFailures++;
								}
							}
							info.tests.add(result);
						}
					}
				}
			}
			br.close();
			fr.close();
		} catch (IOException ex){
		}
		info.mutationText = WodelTestUtils.getMutationTextList(wodelTest, projectName, info.packagename, info.path);
		return info;
	}

	public WodelTestClassInfo() {
		
	}

}
