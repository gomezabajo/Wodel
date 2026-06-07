package wodel.ai.assistant.tasks.fixers;

import java.time.LocalDateTime;
import java.util.*;

public class FixerTrace {
	private String fixerName;
	private List<Object> state = new ArrayList<>();
	private LocalDateTime timeStamp;

	public FixerTrace(String fixerName, Object ...states) {
		this.timeStamp = LocalDateTime.now();
		this.fixerName = fixerName;		
		this.state.addAll(List.of(states));
	}
	
	public String getFixerName() {
		return this.fixerName;
	}
	
	public Object getState() {
		return this.state;
	}
	
	public String toString() {
		return "["+this.timeStamp+"] "+this.fixerName+": "+this.state;
	}
	
}
