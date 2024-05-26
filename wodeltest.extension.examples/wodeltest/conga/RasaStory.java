package mutator.wodeltest.[@**@];

import java.util.List;

public class RasaStory {
	private String story = null;
	private List<RasaStep> steps = null;
	
	public void setStory(String story) {
		this.story = story;
	}
	public String getStory() {
		return this.story;
	}
	
	public void setSteps(List<RasaStep> steps) {
		this.steps = steps;
	}
	public List<RasaStep> getSteps() {
		return this.steps;
	}
}
