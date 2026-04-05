package wodel.utils.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Py2Code {

	public static String toPython(EObject root) {
		StringBuilder sb = new StringBuilder();
		printModule(root, sb);
		return sb.toString();
	}

	private static EStructuralFeature f(EObject o, String name) {
		return o.eClass().getEStructuralFeature(name);
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

	// ===== Module =====
	private static void printModule(EObject module, StringBuilder out) {
		if (!"Module".equals(module.eClass().getName())) {
		}
		for (Object s : list(module, "body")) {
			printStmt((EObject) s, 0, out);
			out.append("\n");
		}
	}

	// ===== Statements =====
	private static void printStmt(EObject stmt, int indent, StringBuilder out) {
		String k = stmt.eClass().getName();
		switch (k) {
		case "FunctionDef" -> printFunctionDef(stmt, indent, out);
		case "Return"      -> indent(out, indent).append("return ")
		.append(printExprToString((EObject) get(stmt, "value")))
		.append("\n");
		case "Expr"        -> indent(out, indent)
		.append(printExprToString((EObject) get(stmt, "value")))
		.append("\n");
		default            -> indent(out, indent).append("# TODO: ").append(k).append("\n");
		}
	}

	private static void printFunctionDef(EObject fn, int indent, StringBuilder out) {
		String name = (String) get(fn, "name");
		EObject args = (EObject) get(fn, "args");
		String params = "";
		if (args != null) {
			List<EObject> argList = list(args, "args");
			params = argList.stream()
					.map(a -> (String) get(a, "arg"))
					.collect(Collectors.joining(", "));
		}
		indent(out, indent).append("def ").append(name).append("(").append(params).append("):").append("\n");

		List<EObject> body = list(fn, "body");
		if (body.isEmpty()) {
			indent(out, indent + 1).append("pass").append("\n");
			return;
		}
		for (EObject s : body) {
			printStmt(s, indent + 1, out);
		}
	}

	// ===== Expressions =====
	private static String printExprToString(EObject expr) {
		if (expr == null) return "";
		String k = expr.eClass().getName();
		return switch (k) {
		case "Name"    -> (String) get(expr, "id");
		case "Constant"-> String.valueOf(get(expr, "value"));
		case "Call"    -> printCall(expr);
		case "BinOp"   -> printBinOp(expr);
		case "JoinedStr", "TemplateStr" -> printJoined(expr);
		default        -> "#<" + k + ">";
		};
	}

	private static String printCall(EObject call) {
		String func = printExprToString((EObject) get(call, "func"));
		List<EObject> args = list(call, "args");
		String argStr = args.stream().map(Py2Code::printExprToString).collect(Collectors.joining(", "));
		return func + "(" + argStr + ")";
	}

	private static String printBinOp(EObject b) {
		String left  = printExprToString((EObject) get(b, "left"));
		String right = printExprToString((EObject) get(b, "right"));
		EObject op   = (EObject) get(b, "op");
		String tok = operatorToken(op);
		return left + " " + tok + " " + right;
	}

	private static String operatorToken(EObject op) {
		if (op == null) return "?";
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

	private static String printJoined(EObject s) {
		List<EObject> vals = list(s, "values");
		String inner = vals.stream().map(Py2Code::printExprToString).collect(Collectors.joining());
		return "\"" + inner + "\"";
	}

	private static StringBuilder indent(StringBuilder out, int indent) {
		return out.append("    ".repeat(Math.max(0, indent)));
	}
}
