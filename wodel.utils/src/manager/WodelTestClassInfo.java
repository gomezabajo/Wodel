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
					String[] test = values[3].split(":");
					if (info.tests == null) {
						info.tests = new ArrayList<WodelTestResultInfo>();
					}
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
							result.numExecutions = 1;
							result.numFailed = result.value ? 1 : 0;
							result.message = messagesText.length > i ? messagesText[i].trim() : "";
							if (result.value == false) {
								result.failure = failureText.length > i ? Boolean.parseBoolean(failureText[i]) : false;
								if (result.failure == true) {
									info.numFailures++;
								}
							}
							i++;
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
	
	public int getNumExecutedTests() 
	{
		int numExecutedTests = 0;
		if (this.tests != null) {
			numExecutedTests = this.tests.size();
		}
		return numExecutedTests;
	}

	public int getNumFailedTests() 
	{
		int numFailedTests = 0;
		if (this.tests != null) {
			for (WodelTestResultInfo test : this.tests) {
				numFailedTests += test.value ? 1 : 0;
			}
		}
		return numFailedTests;
	}

	public WodelTestClassInfo() {
		
	}

}
