package wodel.utils.manager;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WodelTestResult {
	
	private String className;
	private String path;
	private Map<String, Boolean> tests = null;
	private List<WodelTestInfo> info = null;
	
	public String getClassName() {
		return className;
	}
	public String getPath() {
		return path;
	}
	public List<WodelTestInfo> getTests() {
		return info;
	}
	public void addTests(List<WodelTestInfo> info) {
		this.info.addAll(info);
	}
	public String[] testsToText() {
		String testsText = "";
		String messagesText = "";
		String failureText = "";
		//for (String testName : tests.keySet()) {
		//	testsText += testName + "=" + tests.get(testName) + ":";
		//}
		//testsText = testsText.substring(0, testsText.lastIndexOf(":"));
		//testsText +="; ";
		for (WodelTestInfo inf : info) {
			testsText += inf.getTest() + "=" + (inf.getValue() ? "true" : "false") + ":";
		}
		if (testsText.lastIndexOf(":") > 0) {
			testsText = testsText.substring(0, testsText.lastIndexOf(":"));
		}
		testsText +="; ";
		for (WodelTestInfo inf : info) {
			//testsText += inf.getInfo() + "; ";
			messagesText += inf.getMessage() + "; ";
			failureText += inf.getFailure() + "; ";
		}
		if (testsText.length() > 0) {
			testsText = testsText.substring(0, testsText.lastIndexOf(";"));
		}
		if (messagesText.length() > 0) {
			messagesText = messagesText.substring(0, messagesText.lastIndexOf(";"));
		}
		if (failureText.length() > 0) {
			failureText = failureText.substring(0, failureText.lastIndexOf(";"));
		}
		String[] testsToText = new String[3];
		testsToText[0] = testsText;
		testsToText[1] = messagesText;
		testsToText[2] = failureText;
		return testsToText;
	}
	
	public int getRunCount() {
		return tests.size();
	}
	
	public int getFailureCount() {
		int failureCount = 0;
		for (boolean value : tests.values()) {
			if (value == true) {
				failureCount++;
			}
		}
		return failureCount;
	}

	public int getErrorCount() {
		int errorCount = 0;
		for (WodelTestInfo wti : info) {
			errorCount += wti.getFailure() ? 1 : 0;
		}
		return errorCount;
	}
	
	public String toText() {
		String[] testsText = testsToText();
		return className + "|" + path + "|" + testsText[0] + "|" + testsText[1] + "|" + testsText[2] + "|" + getRunCount() + "|" + getFailureCount(); 
	}
	
	public WodelTestResult(String className, String path, List<Object> tests, List<WodelTestInfo> info) {
		this.className = className;
		if (path.indexOf("/bin/") >= 0) {
			this.path = path.substring(0, path.indexOf("/bin/"));
			this.path = this.path.substring(this.path.lastIndexOf("/"), this.path.length()) + "/src/" + className.replaceAll("\\.", "/") + ".java";
		}
		else {
			this.path = path;
		}
		this.tests = new HashMap<String, Boolean>();
		if (tests.get(0) instanceof Method) {
			List<Method> methods = new ArrayList<Method>();
			for (Object test : tests) {
				methods.add((Method) test);
			}
			for (Method method : methods) {
				boolean error = false;
				for (WodelTestInfo inf : info) {
					String value = "";
					if (inf.getInfo().indexOf("(") > 0) {
						value = inf.getInfo().substring(0, inf.getInfo().indexOf("("));
					}
					else {
						value = inf.getInfo();
					}
					if (value.equals(method.getName())) {
						error = true;
						break;
					}
				}
				this.tests.put(method.getName(), !error);
			}
		}
		if (tests.get(0) instanceof String) {
			List<String> methods = new ArrayList<String>();
			for (Object test : tests) {
				methods.add((String) test);
			}
			for (String method : methods) {
				boolean error = false;
				for (WodelTestInfo inf : info) {
					String value = inf.getMessage();
					if (value.equals(IWodelTest.DIFFERENT)) {
						error = true;
						break;
					}
				}
				this.tests.put(method, !error);
			}
		}
		this.info = info;
	}

	public WodelTestResult(String className, String path, Map<String, Boolean> tests, List<WodelTestInfo> info) {
		this.className = className;
		this.path = path;
		this.tests = tests;
		this.info = info;
	}
}
