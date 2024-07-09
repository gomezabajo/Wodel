package mutator.wodeltest.WodelTest4Chatbots;

import java.util.List;

public class RasaResult {
	private String version = null;
	private List<RasaStory> stories = null;
	
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVersion() {
		return this.version;
	}
	public void setStories(List<RasaStory> stories) {
		this.stories = stories;
	}
	public List<RasaStory> getStories() {
		return this.stories;
	}
	
	@Override
	public String toString() {
		String toString = "";
		toString += "version: " + this.version + "\n";
		toString += "stories:\n";
		if (this.stories != null) {
			for (RasaStory story : this.stories) {
				toString += "story: " + story.getStory() + "\n";
				toString += "steps:\n";
				if (story.getSteps() != null) {
					for (RasaStep step : story.getSteps()) {
						if (step.getIntent() != null) { 
							toString += "intent: " + step.getIntent() + "\n"; 
						}
						if (step.getAction() != null) {
							toString += "action: " + step.getAction() + "\n";
						}
						if (step.getComments() != null) {
							for (String comment : step.getComments()) {
								if (comment != null) {
									toString += "comment: #" + comment + "\n"; 
								}
							}
						}
					}
				}
			}
		}
		return toString;
	}
}
