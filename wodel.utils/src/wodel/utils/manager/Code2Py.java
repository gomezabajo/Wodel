package wodel.utils.manager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * Converts Python source code into an EMF/XMI model conformant to python.ecore.
 *
 * <p>This implementation delegates parsing to the local Python interpreter
 * (python3 or python) using Python's built-in {@code ast} module, and then
 * rebuilds the corresponding EMF object tree dynamically from the supplied
 * Ecore metamodel.</p>
 *
 * <p>Requirements:</p>
 * <ul>
 *   <li>A Python 3 interpreter available as {@code python3} or {@code python}.</li>
 *   <li>The provided Ecore must be the Python AST metamodel compatible with the
 *       node names produced by Python's {@code ast} module.</li>
 * </ul>
 */
public class Code2Py {

    private static final String PY_AST_TO_XML_SCRIPT = String.join("\n",
        "import ast, sys, xml.etree.ElementTree as ET",
        "",
        "TYPE_MAP = {",
        "    'arguments': 'Arguments',",
        "    'arg': 'Arg',",
        "    'keyword': 'Keyword',",
        "    'alias': 'Alias',",
        "    'withitem': 'WithItem',",
        "    'match_case': 'MatchCase',",
        "    'comprehension': 'Comprehension',",
        "    'ExceptHandler': 'Excepthandler',",
        "}",
        "",
        "FIELD_MAP = {",
        "    ('alias', 'name'): 'nameText',",
        "    ('ExceptHandler', 'name'): 'alias',",
        "    ('TypeIgnore', 'lineno'): 'linenoty',",
        "}",
        "",
        "def map_type(name):",
        "    return TYPE_MAP.get(name, name)",
        "",
        "def map_field(owner_type, field_name):",
        "    return FIELD_MAP.get((owner_type, field_name), field_name)",
        "",
        "def kind_of(value):",
        "    if isinstance(value, bool):",
        "        return 'bool'",
        "    if isinstance(value, int):",
        "        return 'int'",
        "    if isinstance(value, float):",
        "        return 'float'",
        "    if isinstance(value, str):",
        "        return 'str'",
        "    return type(value).__name__",
        "",
        "def scalar_to_text(value):",
        "    if value is None:",
        "        return ''",
        "    if isinstance(value, bool):",
        "        return 'True' if value else 'False'",
        "    return str(value)",
        "",
        "def encode(parent, owner_type, field_name, value):",
        "    mapped_field = map_field(owner_type, field_name) if field_name else None",
        "    if isinstance(value, ast.AST):",
        "        py_type = value.__class__.__name__",
        "        node = ET.SubElement(parent, 'node', {'type': map_type(py_type)})",
        "        if mapped_field is not None:",
        "            node.set('field', mapped_field)",
        "        for f in getattr(value, '_fields', ()):",
        "            encode(node, py_type, f, getattr(value, f))",
        "        for a in getattr(value, '_attributes', ()):",
        "            attr_value = getattr(value, a, None)",
        "            if attr_value is not None:",
        "                encode(node, py_type, a, attr_value)",
        "        return",
        "    if isinstance(value, list):",
        "        lst = ET.SubElement(parent, 'list')",
        "        if mapped_field is not None:",
        "            lst.set('field', mapped_field)",
        "        for item in value:",
        "            encode(lst, owner_type, 'item', item)",
        "        return",
        "    if value is None:",
        "        n = ET.SubElement(parent, 'null')",
        "        if mapped_field is not None:",
        "            n.set('field', mapped_field)",
        "        return",
        "    v = ET.SubElement(parent, 'value', {'kind': kind_of(value)})",
        "    if mapped_field is not None:",
        "        v.set('field', mapped_field)",
        "    v.text = scalar_to_text(value)",
        "",
        "mode = sys.argv[1] if len(sys.argv) > 1 else 'exec'",
        "source = sys.stdin.read()",
        "tree = ast.parse(source, mode=mode)",
        "root = ET.Element('ast')",
        "encode(root, None, None, tree)",
        "sys.stdout.write(ET.tostring(root, encoding='unicode'))"
    );

    private Code2Py() {
        // utility class
    }

    public static EObject fromPython(String code, String ecorePath) throws Exception {
        return fromPython(code, ecorePath, "exec", "module");
    }

    public static EObject fromPython(String code, String ecorePath, String mode, String rootName) throws Exception {
        if (code == null) {
            throw new IllegalArgumentException("Python source code cannot be null");
        }
        EPackage ePackage = loadMetamodel(ecorePath);
        String xml = pythonAstAsXml(code, mode == null ? "exec" : mode);
        EObject root = buildModelFromXml(xml, ePackage);
        setRootNameIfPresent(root, rootName);
        return root;
    }

    public static EObject fromPythonFile(String sourcePath, String ecorePath) throws Exception {
        return fromPythonFile(Path.of(sourcePath), ecorePath, "exec");
    }

    public static EObject fromPythonFile(Path sourceFile, String ecorePath, String mode) throws Exception {
        String code = Files.readString(sourceFile, StandardCharsets.UTF_8);
        String inferredName = inferRootName(sourceFile);
        return fromPython(code, ecorePath, mode, inferredName);
    }

    public static void convertFileToXmi(String sourcePath, String ecorePath, String xmiPath) throws Exception {
        EObject root = fromPythonFile(sourcePath, ecorePath);
        saveAsXmi(root, xmiPath);
    }

    public static void saveAsXmi(EObject root, String xmiPath) throws IOException {
        if (root == null) {
            throw new IllegalArgumentException("Root EObject cannot be null");
        }

        ResourceSet rs = new ResourceSetImpl();
        registerResourceFactories(rs);
        EPackage ePackage = root.eClass().getEPackage();
        rs.getPackageRegistry().put(ePackage.getNsURI(), ePackage);

        Resource resource = rs.createResource(URI.createFileURI(Path.of(xmiPath).toAbsolutePath().toString()));
        resource.getContents().add(root);

        Map<Object, Object> options = new HashMap<>();
        options.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
        resource.save(options);
    }

    private static EPackage loadMetamodel(String ecorePath) throws IOException {
        ResourceSet rs = new ResourceSetImpl();
        registerResourceFactories(rs);

        Resource resource = rs.getResource(URI.createFileURI(Path.of(ecorePath).toAbsolutePath().toString()), true);
        if (resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof EPackage)) {
            throw new IOException("The provided .ecore file does not contain an EPackage root: " + ecorePath);
        }

        EPackage ePackage = (EPackage) resource.getContents().get(0);
        rs.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
        return ePackage;
    }

    private static void registerResourceFactories(ResourceSet rs) {
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
                new XMIResourceFactoryImpl());
    }

    private static String pythonAstAsXml(String code, String mode) throws Exception {
        List<String> errors = new ArrayList<>();
        try {
            return runPython(List.of("python3", "-c", PY_AST_TO_XML_SCRIPT, mode), code);
        } catch (IOException ex) {
            errors.add(ex.getMessage());
        }

        try {
            return runPython(List.of("python", "-c", PY_AST_TO_XML_SCRIPT, mode), code);
        } catch (IOException ex) {
            errors.add(ex.getMessage());
        }

        throw new IOException("Unable to execute a Python interpreter. Tried python3 and python. Details: "
                + String.join(" | ", errors));
    }

    private static String runPython(List<String> command, String stdin) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(command);
        Process process = pb.start();

        byte[] input = stdin.getBytes(StandardCharsets.UTF_8);
        process.getOutputStream().write(input);
        process.getOutputStream().flush();
        process.getOutputStream().close();

        String stdout;
        String stderr;
        try (Reader outReader = new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8);
             Reader errReader = new InputStreamReader(process.getErrorStream(), StandardCharsets.UTF_8)) {
            stdout = readAll(outReader);
            stderr = readAll(errReader);
        }

        int exit = process.waitFor();
        if (exit != 0) {
            throw new IOException("Python AST extraction failed (exit code " + exit + "): " + stderr);
        }
        return stdout;
    }

    private static String readAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[4096];
        int n;
        while ((n = reader.read(buffer)) != -1) {
            sb.append(buffer, 0, n);
        }
        return sb.toString();
    }

    private static EObject buildModelFromXml(String xml, EPackage ePackage) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(false);
        dbf.setXIncludeAware(false);
        dbf.setExpandEntityReferences(false);
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        try {
            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        } catch (Exception ignored) {
            // Optional hardening: harmless if unsupported.
        }

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new InputSource(new StringReader(xml)));
        Element ast = doc.getDocumentElement();
        Element rootNode = firstChildElement(ast, "node");
        if (rootNode == null) {
            throw new IOException("The Python AST XML does not contain a root node");
        }
        return buildEObject(rootNode, ePackage);
    }

    private static EObject buildEObject(Element nodeElement, EPackage ePackage) {
        String typeName = nodeElement.getAttribute("type");
        EClass eClass = findEClass(ePackage, typeName);
        EObject target = ePackage.getEFactoryInstance().create(eClass);

        NodeList children = nodeElement.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (!(node instanceof Element child)) {
                continue;
            }
            String fieldName = child.getAttribute("field");
            if (fieldName == null || fieldName.isEmpty()) {
                continue;
            }

            EStructuralFeature feature = eClass.getEStructuralFeature(fieldName);
            if (feature == null) {
                continue;
            }

            switch (child.getTagName()) {
            case "node" -> setFeatureValue(target, feature, buildEObject(child, ePackage));
            case "list" -> fillListFeature(target, feature, child, ePackage);
            case "value" -> setScalarFeature(target, feature, child.getTextContent());
            case "null" -> {
                // Explicit null from Python AST. Nothing to assign.
            }
            default -> {
                // Ignore unknown XML helper nodes.
            }
            }
        }

        return target;
    }

    private static void fillListFeature(EObject target, EStructuralFeature feature, Element listElement, EPackage ePackage) {
        NodeList children = listElement.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (!(node instanceof Element child)) {
                continue;
            }

            switch (child.getTagName()) {
            case "node" -> addToFeatureList(target, feature, buildEObject(child, ePackage));
            case "value" -> addToFeatureList(target, feature, convertScalar((EAttribute) feature, child.getTextContent()));
            case "null" -> {
                // skip null list entries
            }
            default -> {
                // ignore
            }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void addToFeatureList(EObject target, EStructuralFeature feature, Object value) {
        Object current = target.eGet(feature);
        if (current instanceof EList<?>) {
            ((EList<Object>) current).add(value);
        }
    }

    private static void setFeatureValue(EObject target, EStructuralFeature feature, Object value) {
        if (feature.isMany()) {
            addToFeatureList(target, feature, value);
        } else {
            target.eSet(feature, value);
        }
    }

    private static void setScalarFeature(EObject target, EStructuralFeature feature, String rawValue) {
        if (!(feature instanceof EAttribute attr)) {
            return;
        }
        Object value = convertScalar(attr, rawValue);
        setFeatureValue(target, feature, value);
    }

    private static Object convertScalar(EAttribute attribute, String rawValue) {
        EDataType dataType = attribute.getEAttributeType();
        if (rawValue == null) {
            return null;
        }
        return dataType.getEPackage().getEFactoryInstance().createFromString(dataType, rawValue);
    }

    private static EClass findEClass(EPackage ePackage, String name) {
        EClassifier classifier = ePackage.getEClassifier(name);
        if (classifier instanceof EClass eClass) {
            return eClass;
        }
        throw new IllegalArgumentException("EClass not found in metamodel: " + name);
    }

    private static Element firstChildElement(Element parent, String tagName) {
        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node instanceof Element child && tagName.equals(child.getTagName())) {
                return child;
            }
        }
        return null;
    }

    private static void setRootNameIfPresent(EObject root, String rootName) {
        if (root == null || rootName == null || rootName.isBlank()) {
            return;
        }
        EStructuralFeature nameFeature = root.eClass().getEStructuralFeature("name");
        if (nameFeature instanceof EAttribute) {
            root.eSet(nameFeature, rootName);
        }
    }

    private static String inferRootName(Path sourceFile) {
        String fileName = sourceFile.getFileName().toString();
        int dot = fileName.lastIndexOf('.');
        return dot > 0 ? fileName.substring(0, dot) : fileName;
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.err.println("Usage: Code2Py <python-file> <python.ecore> <output.xmi> [mode]");
            System.err.println("  mode: exec (default), eval, or single");
            System.exit(1);
        }

        String sourcePath = args[0];
        String ecorePath = args[1];
        String outPath = args[2];
        String mode = args.length >= 4 ? args[3] : "exec";

        EObject root = fromPythonFile(Path.of(sourcePath), ecorePath, mode);
        saveAsXmi(root, outPath);
        System.out.println("XMI model written to: " + outPath);
    }
}
