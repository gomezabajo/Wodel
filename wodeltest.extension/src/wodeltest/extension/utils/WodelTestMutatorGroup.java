package wodeltest.extension.utils;

import java.util.List;

public class WodelTestMutatorGroup {

	private String group;
	private String description;
	private List<WodelTestMutatorResult> results;

	public WodelTestMutatorGroup(String group, String description, List<WodelTestMutatorResult> results) {
		this.group = group;
		this.description = description;
		this.results = results;
	}
	
	public void setGroupDescription(String description) {
		this.description = description;
	}
	
	public String getGroupDescription() {
		return description;
	}

	public void setMutatorGroup(String group) {
		this.group = group;
	}
	
	public String getGroupName() {
		return group;
	}

	public void setResults(List<WodelTestMutatorResult> results) {
		this.results = results;
	}
	
	public List<WodelTestMutatorResult> getResults() {
		return results;
	}
	
	public int getNumberOfMutants() {
		int num = 0;
		if (results != null) {
			for (WodelTestMutatorResult result : results) {
				num += result.getNumberOfMutants();
			}
		}
		return num;
	}

	public int getFailures() {
		int failures = 0;
		if (results != null) {
			for (WodelTestMutatorResult result : results) {
				failures += result.getFailures();
			}
		}
		return failures;
	}
}
