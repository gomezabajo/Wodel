package wodeltest.extension.utils;

import java.util.List;

public class WodelTestMutatorResult {

	private String mutator;
	private int num;
	private List<String> paths;
	private String description;
	private int failures;
	
	public WodelTestMutatorResult(String mutator, String description, int num, int failures, List<String> paths) {
		this.mutator = mutator;
		this.num = num;
		this.paths = paths;
		this.description = description;
		this.failures = failures;
	}
	
	public void setMutatorName(String mutator) {
		this.mutator = mutator;
	}
	
	public String getMutatorName() {
		return mutator;
	}
	
	public void setMutatorDescription(String description) {
		this.description = description;
	}
	
	public String getMutatorDescription() {
		return description;
	}

	public void setNumberOfMutants(int num) {
		this.num = num;
	}
	
	public int getNumberOfMutants() {
		return num;
	}
	
	public void setFailures(int failures) {
		this.failures = failures;
	}
	
	public int getFailures() {
		return failures;
	}

	public void setPaths(List<String> paths) {
		this.paths = paths;
	}
	
	public List<String> getPaths() {
		return paths;
	}
	
	public static WodelTestMutatorResult find(String mutator, List<WodelTestMutatorResult> mutatorData) {
		for (WodelTestMutatorResult wtmr : mutatorData) {
			if (wtmr.getMutatorName().equals(mutator)) {
				return wtmr;
			}
		}
		return null;
	}
}
