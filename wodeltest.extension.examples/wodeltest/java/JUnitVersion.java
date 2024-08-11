package mutator.wodeltest.[@**@];

public enum JUnitVersion {
	UNKNOWN(-1),
	JUNIT3(3),
	JUNIT4(4),
	JUNIT5(5);
	
	private int id;
	
	private JUnitVersion(int id) {
		this.id = id;
	}
}
