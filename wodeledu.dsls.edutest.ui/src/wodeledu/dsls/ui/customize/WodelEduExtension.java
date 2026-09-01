package wodeledu.dsls.ui.customize;

public enum WodelEduExtension {

    DFA(
        "http://dfaAutomaton/1.0",
        "Dot"
    ),

    LC(
        "http://lc/1.0",
        "Circuit"
    ),

    UML(
        "http://UMLDiagram/1.0",
        "PlantUML"
    ),

    PY(
        "http://www.python.org/pythonast/3.14",
        "PyCode"
    );

    private final String uri;
    private final String modelDrawMode;

    WodelEduExtension(
            String uri,
            String modelDrawMode) {

        this.uri = uri;
        this.modelDrawMode =
            modelDrawMode;
    }

    public String getURI() {
        return uri;
    }

    public String getModelDrawMode() {
        return modelDrawMode;
    }

    public static WodelEduExtension fromURI(
            String uri) {

        if (uri == null) {
            return null;
        }

        for (WodelEduExtension extension :
                values()) {

            if (extension.uri.equals(uri)) {
                return extension;
            }
        }

        return null;
    }
}