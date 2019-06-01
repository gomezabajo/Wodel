package manager;

import java.util.ArrayList;
import java.util.List;

public class WodelTestResultTest {
	
	private String name;
	
	private boolean value;
	
	private List<WodelTestResultTestInfo> mutants;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getValue() {
		return value;
	}
	
	public void setValue(boolean value) {
		this.value = value;
	}
	
	public List<WodelTestResultTestInfo> getMutants() {
		return this.mutants;
	}
	
	public int getDetectedMutants() {
		int detected = 0;
		for (WodelTestResultTestInfo mutant : mutants) {
			if (mutant.getValue() == false) {
				detected++;
			}
		}
		return detected;
	}
	
	public int getFailures() {
		int failures = 0;
		for (WodelTestResultTestInfo mutant : mutants) {
			if (mutant.getFailure() == true) {
				failures++;
			}
		}
		return failures;
	}

	public void addMutant(String mutant, boolean value, boolean error, String message, List<String> mutation) {
		if (value == false) {
			this.value = false;
		}
		WodelTestResultTestInfo testInfo = new WodelTestResultTestInfo();
		testInfo.setName(mutant);
		testInfo.setValue(value);
		testInfo.setMessage(message);
		testInfo.setMutation(mutation);
		testInfo.setFailure(error);
		this.mutants.add(testInfo);
	}
	
	public WodelTestResultTest() {
		this.value = true;
		this.mutants = new ArrayList<WodelTestResultTestInfo>();
	}

}
