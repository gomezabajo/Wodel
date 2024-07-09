package mutator.wodeltest.WodelTest4Chatbots;

import java.util.List;
import java.util.ArrayList;

public class RasaStep {
	private String intent = null;
	private String action = null;
	private List<String> comments = null;
	
	public void setIntent(String intent) {
		this.intent = intent;
	}
	public String getIntent() {
		return this.intent;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getAction() {
		return this.action;
	}
	public void addComment(String comment) {
		if (this.comments == null) {
			this.comments = new ArrayList<String>();
		}
		this.comments.add(comment);
	}
	public List<String> getComments() {
		return this.comments;
	}
	public String getContext() {
		String context = "";
		if (this.comments == null) {
			return context;
		}
		for (String comment : this.comments) {
			context += "# " + comment + " ";
		}
		return context.trim();
	}
	@Override
	public String toString() {
		String toString = "";
		if (this.intent == null && this.action != null) {
			toString = "action(" + this.action + ")";
		}
		if (this.intent != null && this.action == null) {
			toString = "intent(" + this.intent + ")";
		}
		if (this.intent != null && this.action != null) {
			toString = "intent(" + this.intent + "), action(" + this.action + ")";
		}
		return toString;
	}
}
