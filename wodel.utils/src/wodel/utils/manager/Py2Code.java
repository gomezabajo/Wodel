package wodel.utils.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Py2Code {

    public static String toPython(EObject root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String rootType = root.eClass().getName();
        switch (rootType) {
        case "Module", "Interactive" -> printModule(root, sb);
        case "Expression" -> sb.append(printExprToString((EObject) get(root, "body"))).append("\n");
        default -> printStmt(root, 0, sb);
        }
        return sb.toString();
    }

    private static EStructuralFeature f(EObject o, String name) {
        return (o == null) ? null : o.eClass().getEStructuralFeature(name);
    }

    private static Object get(EObject o, String name) {
        EStructuralFeature feat = f(o, name);
        return (feat == null) ? null : o.eGet(feat);
    }

    @SuppressWarnings("unchecked")
    private static <T> List<T> list(EObject o, String name) {
        Object v = get(o, name);
        return v == null ? java.util.List.of() : (List<T>) v;
    }

    private static boolean hasAny(EObject o, String name) {
        return !list(o, name).isEmpty();
    }

    // ===== Module =====
    private static void printModule(EObject module, StringBuilder out) {
        List<EObject> body = list(module, "body");
        for (int i = 0; i < body.size(); i++) {
            EObject stmt = body.get(i);
            printStmt(stmt, 0, out);
            if (i < body.size() - 1) {
                out.append("\n");
                if (isBlockStmt(stmt) || isBlockStmt(body.get(i + 1))) {
                    out.append("\n");
                }
            }
        }
    }

    // ===== Statements =====
    private static void printStmt(EObject stmt, int indent, StringBuilder out) {
        if (stmt == null) {
            indent(out, indent).append("pass\n");
            return;
        }

        String k = stmt.eClass().getName();
        switch (k) {
        case "FunctionDef" -> printFunctionDef(stmt, indent, out, false);
        case "AsyncFunctionDef" -> printFunctionDef(stmt, indent, out, true);
        case "Return" -> printReturn(stmt, indent, out);
        case "Expr" -> indent(out, indent)
                .append(printExprToString((EObject) get(stmt, "value")))
                .append("\n");
        case "Assign" -> printAssign(stmt, indent, out);
        case "AugAssign" -> printAugAssign(stmt, indent, out);
        case "AnnAssign" -> printAnnAssign(stmt, indent, out);
        case "If" -> printIf(stmt, indent, out);
        case "For" -> printFor(stmt, indent, out, false);
        case "AsyncFor" -> printFor(stmt, indent, out, true);
        case "While" -> printWhile(stmt, indent, out);
        case "Pass" -> indent(out, indent).append("pass\n");
        case "Break" -> indent(out, indent).append("break\n");
        case "Continue" -> indent(out, indent).append("continue\n");
        case "Import" -> printImport(stmt, indent, out);
        case "ImportFrom" -> printImportFrom(stmt, indent, out);
        default -> indent(out, indent).append("# TODO: ").append(k).append("\n");
        }
    }

    private static void printFunctionDef(EObject fn, int indent, StringBuilder out, boolean async) {
        String name = safeString(get(fn, "name"), "anonymous");
        EObject args = (EObject) get(fn, "args");
        String params = printArguments(args);
        String returns = "";
        EObject ret = (EObject) get(fn, "returns");
        if (ret != null) {
            returns = " -> " + printExprToString(ret);
        }

        for (Object dec : list(fn, "decorator_list")) {
            indent(out, indent).append("@").append(printExprToString((EObject) dec)).append("\n");
        }

        indent(out, indent);
        if (async) {
            out.append("async ");
        }
        out.append("def ").append(name).append("(").append(params).append(")").append(returns).append(":\n");
        printSuite(list(fn, "body"), indent + 1, out);
    }

    private static void printReturn(EObject stmt, int indent, StringBuilder out) {
        EObject value = (EObject) get(stmt, "value");
        indent(out, indent).append("return");
        if (value != null) {
            out.append(" ").append(printExprToString(value));
        }
        out.append("\n");
    }

    private static void printAssign(EObject stmt, int indent, StringBuilder out) {
        List<EObject> targets = list(stmt, "targets");
        String left = targets.isEmpty()
                ? "_"
                : targets.stream().map(Py2Code::printExprToString).collect(Collectors.joining(" = "));
        String right = printExprToString((EObject) get(stmt, "value"));
        indent(out, indent).append(left).append(" = ").append(right).append("\n");
    }

    private static void printAugAssign(EObject stmt, int indent, StringBuilder out) {
        String target = printExprToString((EObject) get(stmt, "target"));
        String op = operatorToken((EObject) get(stmt, "op"));
        String value = printExprToString((EObject) get(stmt, "value"));
        indent(out, indent).append(target).append(" ").append(op).append("= ").append(value).append("\n");
    }

    private static void printAnnAssign(EObject stmt, int indent, StringBuilder out) {
        String target = printExprToString((EObject) get(stmt, "target"));
        String ann = printExprToString((EObject) get(stmt, "annotation"));
        EObject value = (EObject) get(stmt, "value");
        indent(out, indent).append(target).append(": ").append(ann);
        if (value != null) {
            out.append(" = ").append(printExprToString(value));
        }
        out.append("\n");
    }

    private static void printIf(EObject stmt, int indent, StringBuilder out) {
        indent(out, indent).append("if ").append(printExprToString((EObject) get(stmt, "test"))).append(":\n");
        printSuite(list(stmt, "body"), indent + 1, out);

        List<EObject> orelse = list(stmt, "orelse");
        if (!orelse.isEmpty()) {
            if (orelse.size() == 1 && "If".equals(orelse.get(0).eClass().getName())) {
                printElif(orelse.get(0), indent, out);
            } else {
                indent(out, indent).append("else:\n");
                printSuite(orelse, indent + 1, out);
            }
        }
    }

    private static void printElif(EObject stmt, int indent, StringBuilder out) {
        indent(out, indent).append("elif ").append(printExprToString((EObject) get(stmt, "test"))).append(":\n");
        printSuite(list(stmt, "body"), indent + 1, out);

        List<EObject> orelse = list(stmt, "orelse");
        if (!orelse.isEmpty()) {
            if (orelse.size() == 1 && "If".equals(orelse.get(0).eClass().getName())) {
                printElif(orelse.get(0), indent, out);
            } else {
                indent(out, indent).append("else:\n");
                printSuite(orelse, indent + 1, out);
            }
        }
    }

    private static void printFor(EObject stmt, int indent, StringBuilder out, boolean async) {
        indent(out, indent);
        if (async) {
            out.append("async ");
        }
        out.append("for ")
           .append(printExprToString((EObject) get(stmt, "target")))
           .append(" in ")
           .append(printExprToString((EObject) get(stmt, "iter")))
           .append(":\n");
        printSuite(list(stmt, "body"), indent + 1, out);

        if (hasAny(stmt, "orelse")) {
            indent(out, indent).append("else:\n");
            printSuite(list(stmt, "orelse"), indent + 1, out);
        }
    }

    private static void printWhile(EObject stmt, int indent, StringBuilder out) {
        indent(out, indent).append("while ").append(printExprToString((EObject) get(stmt, "test"))).append(":\n");
        printSuite(list(stmt, "body"), indent + 1, out);

        if (hasAny(stmt, "orelse")) {
            indent(out, indent).append("else:\n");
            printSuite(list(stmt, "orelse"), indent + 1, out);
        }
    }

    private static void printImport(EObject stmt, int indent, StringBuilder out) {
        String names = list(stmt, "names").stream()
                .map(x -> printAlias((EObject) x))
                .collect(Collectors.joining(", "));
        indent(out, indent).append("import ").append(names).append("\n");
    }

    private static void printImportFrom(EObject stmt, int indent, StringBuilder out) {
        String dots = ".".repeat(Math.max(0, asInt(get(stmt, "level"), 0)));
        String module = safeString(get(stmt, "module"), "");
        String names = list(stmt, "names").stream()
                .map(x -> printAlias((EObject) x))
                .collect(Collectors.joining(", "));
        indent(out, indent).append("from ").append(dots).append(module).append(" import ").append(names).append("\n");
    }

    private static void printSuite(List<EObject> body, int indent, StringBuilder out) {
        if (body == null || body.isEmpty()) {
            indent(out, indent).append("pass\n");
            return;
        }
        for (EObject s : body) {
            printStmt(s, indent, out);
        }
    }

    // ===== Expressions =====
    private static String printExprToString(EObject expr) {
        if (expr == null) {
            return "";
        }
        String k = expr.eClass().getName();
        return switch (k) {
        case "Name" -> safeString(get(expr, "id"), "_");
        case "Constant" -> renderConstant(get(expr, "value"));
        case "Call" -> printCall(expr);
        case "BinOp" -> printBinOp(expr);
        case "UnaryOp" -> printUnaryOp(expr);
        case "Compare" -> printCompare(expr);
        case "BoolOp" -> printBoolOp(expr);
        case "Attribute" -> printAttribute(expr);
        case "Subscript" -> printSubscript(expr);
        case "Tuple" -> printTuple(expr);
        case "List" -> printList(expr);
        case "Slice" -> printSlice(expr);
        case "IfExp" -> printIfExp(expr);
        case "NamedExpr" -> printNamedExpr(expr);
        case "FormattedValue" -> "{" + printExprToString((EObject) get(expr, "value")) + "}";
        case "Interpolation" -> safeString(get(expr, "str"), printExprToString((EObject) get(expr, "value")));
        case "JoinedStr", "TemplateStr" -> printJoined(expr);
        default -> "#<" + k + ">";
        };
    }

    private static String printCall(EObject call) {
        String func = printExprToString((EObject) get(call, "func"));
        List<String> args = new ArrayList<>();
        args.addAll(list(call, "args").stream()
                .map(x -> printExprToString((EObject) x))
                .collect(Collectors.toList()));
        args.addAll(list(call, "keywords").stream()
                .map(x -> printKeyword((EObject) x))
                .collect(Collectors.toList()));
        return func + "(" + String.join(", ", args) + ")";
    }

    private static String printBinOp(EObject b) {
        String left = wrapIfNeeded((EObject) get(b, "left"));
        String right = wrapIfNeeded((EObject) get(b, "right"));
        EObject op = (EObject) get(b, "op");
        return left + " " + operatorToken(op) + " " + right;
    }

    private static String printUnaryOp(EObject u) {
        EObject op = (EObject) get(u, "op");
        String tok = unaryOperatorToken(op);
        EObject operand = (EObject) get(u, "operand");
        String rendered = wrapIfNeeded(operand);
        if ("not".equals(tok)) {
            return tok + " " + rendered;
        }
        return tok + rendered;
    }

    private static String printCompare(EObject c) {
        List<EObject> ops = list(c, "ops");
        List<EObject> comparators = list(c, "comparators");
        StringBuilder out = new StringBuilder();
        out.append(wrapIfNeeded((EObject) get(c, "left")));
        for (int i = 0; i < Math.min(ops.size(), comparators.size()); i++) {
            out.append(" ").append(compareToken(ops.get(i))).append(" ")
               .append(wrapIfNeeded(comparators.get(i)));
        }
        return out.toString();
    }

    private static String printBoolOp(EObject b) {
        String tok = boolOperatorToken((EObject) get(b, "op"));
        return list(b, "values").stream()
                .map(x -> wrapIfNeeded((EObject) x))
                .collect(Collectors.joining(" " + tok + " "));
    }

    private static String printAttribute(EObject a) {
        return wrapIfNeeded((EObject) get(a, "value")) + "." + safeString(get(a, "attr"), "attr");
    }

    private static String printSubscript(EObject s) {
        return wrapIfNeeded((EObject) get(s, "value")) + "[" + printExprToString((EObject) get(s, "slice")) + "]";
    }

    private static String printTuple(EObject t) {
        List<EObject> elts = list(t, "elts");
        if (elts.size() == 1) {
            return "(" + printExprToString(elts.get(0)) + ",)";
        }
        return "(" + elts.stream().map(Py2Code::printExprToString).collect(Collectors.joining(", ")) + ")";
    }

    private static String printList(EObject l) {
        return "[" + list(l, "elts").stream().map(x -> printExprToString((EObject) x)).collect(Collectors.joining(", ")) + "]";
    }

    private static String printSlice(EObject s) {
        EObject lower = (EObject) get(s, "lower");
        EObject upper = (EObject) get(s, "upper");
        EObject step = (EObject) get(s, "step");
        String base = (lower == null ? "" : printExprToString(lower)) + ":" + (upper == null ? "" : printExprToString(upper));
        if (step != null) {
            base += ":" + printExprToString(step);
        }
        return base;
    }

    private static String printIfExp(EObject expr) {
        return printExprToString((EObject) get(expr, "body"))
                + " if " + printExprToString((EObject) get(expr, "test"))
                + " else " + printExprToString((EObject) get(expr, "orelse"));
    }

    private static String printNamedExpr(EObject expr) {
        return printExprToString((EObject) get(expr, "target")) + " := " + printExprToString((EObject) get(expr, "value"));
    }

    private static String printJoined(EObject s) {
        List<EObject> vals = list(s, "values");
        boolean hasFormatted = vals.stream().anyMatch(v -> {
            String k = v.eClass().getName();
            return "FormattedValue".equals(k) || "Interpolation".equals(k);
        });
        String inner = vals.stream().map(v -> {
            String k = v.eClass().getName();
            if ("Constant".equals(k)) {
                return stripQuotes(renderConstant(get(v, "value")));
            }
            if ("FormattedValue".equals(k)) {
                return "{" + printExprToString((EObject) get(v, "value")) + "}";
            }
            if ("Interpolation".equals(k)) {
                return safeString(get(v, "str"), printExprToString((EObject) get(v, "value")));
            }
            return printExprToString(v);
        }).collect(Collectors.joining());
        return (hasFormatted ? "f" : "") + quote(inner);
    }

    // ===== Tokens =====
    private static String operatorToken(EObject op) {
        if (op == null) {
            return "?";
        }
        return switch (op.eClass().getName()) {
        case "Add" -> "+";
        case "Sub" -> "-";
        case "Mult" -> "*";
        case "Div" -> "/";
        case "FloorDiv" -> "//";
        case "ModOp" -> "%";
        case "Pow" -> "**";
        case "MatMult" -> "@";
        case "BitAnd" -> "&";
        case "BitOr" -> "|";
        case "BitXor" -> "^";
        case "LShift" -> "<<";
        case "RShift" -> ">>";
        default -> "?";
        };
    }

    private static String unaryOperatorToken(EObject op) {
        if (op == null) {
            return "";
        }
        return switch (op.eClass().getName()) {
        case "UAdd" -> "+";
        case "USub" -> "-";
        case "Not" -> "not";
        case "Invert" -> "~";
        default -> "";
        };
    }

    private static String compareToken(EObject op) {
        if (op == null) {
            return "?";
        }
        return switch (op.eClass().getName()) {
        case "Eq" -> "==";
        case "NotEq" -> "!=";
        case "Lt" -> "<";
        case "LtE" -> "<=";
        case "Gt" -> ">";
        case "GtE" -> ">=";
        case "Is" -> "is";
        case "IsNot" -> "is not";
        case "In" -> "in";
        case "NotIn" -> "not in";
        default -> "?";
        };
    }

    private static String boolOperatorToken(EObject op) {
        if (op == null) {
            return "and";
        }
        return switch (op.eClass().getName()) {
        case "And" -> "and";
        case "Or" -> "or";
        default -> "and";
        };
    }

    // ===== Misc rendering helpers =====
    private static String printArguments(EObject args) {
        if (args == null) {
            return "";
        }

        List<String> params = new ArrayList<>();
        List<EObject> posOnly = list(args, "posonlyargs");
        List<EObject> regular = list(args, "args");
        List<EObject> kwOnly = list(args, "kwonlyargs");
        List<EObject> defaults = list(args, "defaults");
        List<EObject> kwDefaults = list(args, "kw_defaults");

        List<String> posOnlyRendered = renderArgsWithDefaults(posOnly, java.util.List.of());
        if (!posOnlyRendered.isEmpty()) {
            params.addAll(posOnlyRendered);
            params.add("/");
        }

        params.addAll(renderArgsWithDefaults(regular, defaults));

        EObject vararg = (EObject) get(args, "vararg");
        if (vararg != null) {
            params.add("*" + printArg(vararg));
        } else if (!kwOnly.isEmpty()) {
            params.add("*");
        }

        params.addAll(renderArgsWithDefaults(kwOnly, kwDefaults));

        EObject kwarg = (EObject) get(args, "kwarg");
        if (kwarg != null) {
            params.add("**" + printArg(kwarg));
        }

        return params.stream().filter(Objects::nonNull).collect(Collectors.joining(", "));
    }

    private static List<String> renderArgsWithDefaults(List<EObject> args, List<EObject> defaults) {
        List<String> rendered = new ArrayList<>();
        int plainCount = Math.max(0, args.size() - defaults.size());
        for (int i = 0; i < args.size(); i++) {
            String base = printArg(args.get(i));
            if (i >= plainCount && !defaults.isEmpty()) {
                EObject def = defaults.get(i - plainCount);
                rendered.add(base + "=" + printExprToString(def));
            } else {
                rendered.add(base);
            }
        }
        return rendered;
    }

    private static String printArg(EObject arg) {
        if (arg == null) {
            return "arg";
        }
        String name = safeString(get(arg, "arg"), "arg");
        EObject ann = (EObject) get(arg, "annotation");
        return ann == null ? name : name + ": " + printExprToString(ann);
    }

    private static String printKeyword(EObject kw) {
        String arg = safeString(get(kw, "arg"), "");
        String value = printExprToString((EObject) get(kw, "value"));
        return arg.isEmpty() ? "**" + value : arg + "=" + value;
    }

    private static String printAlias(EObject alias) {
        String name = safeString(get(alias, "nameText"), safeString(get(alias, "name"), "module"));
        String asname = safeString(get(alias, "asname"), "");
        return asname.isEmpty() ? name : name + " as " + asname;
    }

    private static String wrapIfNeeded(EObject expr) {
        if (expr == null) {
            return "";
        }
        String rendered = printExprToString(expr);
        return needsParentheses(expr) ? "(" + rendered + ")" : rendered;
    }

    private static boolean needsParentheses(EObject expr) {
        if (expr == null) {
            return false;
        }
        return switch (expr.eClass().getName()) {
        case "BinOp", "BoolOp", "Compare", "IfExp", "NamedExpr" -> true;
        default -> false;
        };
    }

    private static boolean isBlockStmt(EObject stmt) {
        if (stmt == null) {
            return false;
        }
        return switch (stmt.eClass().getName()) {
        case "FunctionDef", "AsyncFunctionDef", "If", "For", "AsyncFor", "While" -> true;
        default -> false;
        };
    }

    private static String renderConstant(Object value) {
        if (value == null) {
            return "None";
        }
        String s = String.valueOf(value);
        if (s.equals("True") || s.equals("False") || s.equals("None")) {
            return s;
        }
        if (isNumericLiteral(s)) {
            return s;
        }
        return quote(s);
    }

    private static boolean isNumericLiteral(String s) {
        return s.matches("[+-]?\\d+(_\\d+)*(\\.\\d+(_\\d+)*)?([eE][+-]?\\d+)?")
                || s.matches("[+-]?\\.\\d+([eE][+-]?\\d+)?");
    }

    private static String quote(String s) {
        return "\"" + s.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }

    private static String stripQuotes(String s) {
        if (s != null && s.length() >= 2 && s.startsWith("\"") && s.endsWith("\"")) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }

    private static String safeString(Object value, String fallback) {
        return value == null ? fallback : String.valueOf(value);
    }

    private static int asInt(Object value, int fallback) {
        if (value instanceof Number n) {
            return n.intValue();
        }
        if (value != null) {
            try {
                return Integer.parseInt(String.valueOf(value));
            } catch (NumberFormatException ex) {
                return fallback;
            }
        }
        return fallback;
    }

    private static StringBuilder indent(StringBuilder out, int indent) {
        return out.append("    ".repeat(Math.max(0, indent)));
    }
}
