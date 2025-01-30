package wodeledu.dsls.ui.customize;

public enum WodelEduExtension {
	DFA("http://dfaAutomaton/1.0"),
	LC("http://lc/1.0"),
	UML("http://UMLDiagram/1.0");
	
	private String uri;
	
	WodelEduExtension(String uri) {
		this.uri = uri;
	};
	
	public String getURI() {
		return this.uri;
	}
}
