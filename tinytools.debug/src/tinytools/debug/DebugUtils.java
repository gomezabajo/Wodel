package tinytools.debug;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class DebugUtils {

	private static class IdManager {
		private final HashMap<EObject, String> map = new HashMap<>();
		private int counter = 0;
		
		private String get(EObject obj) {
			String v = map.computeIfAbsent(obj, (k) -> k.eClass().getName() + ++counter);
			return v;
		}
		
	}
	
	public static String toTree(EObject obj) {
		StringBuilder builder = new StringBuilder();
		IdManager idManager = new IdManager();
		toTree(obj, builder, 0, idManager);
		return builder.toString();
	}
	
	private static void toTree(EObject obj, StringBuilder builder, int level, IdManager idManager) {
		if (obj == null) { 
			builder.append("null");
			return;
		}
		
		
		EClass eclass = obj.eClass();
		builder.append(indent(level)).append(idManager.get(obj)).append(" : ").append(eclass.getName()).append(" {").append("\n");
		level++;
		for (EAttribute att : eclass.getEAllAttributes()) {
			builder.append(indent(level)).append(att.getName()).append(" = ").append(obj.eGet(att)).append("\n");
		}
			
		for (EReference ref : eclass.getEAllContainments()) {
			Object r = obj.eGet(ref);
			if (r instanceof Collection) {
				@SuppressWarnings("unchecked")
				Collection<EObject> objs = (Collection<EObject>) r;
				for (EObject eObject : objs) {
					toTree(eObject, builder, level + 1, idManager);
				}
			} else {
				toTree((EObject) r, builder, level + 1, idManager);
			}
			
			// builder.append(indent(level)).append(ref.getName()).append(" = ").append(obj.eGet(ref)).append("\n");
		}
		
		for (EReference ref : eclass.getEAllReferences()) {
			if (ref.isContainment())
				continue;
			
			builder.append(indent(level)).append(ref.getName()).append(" = ").append(obj.eGet(ref)).append("\n");
		}
		
		level--;
		builder.append(indent(level)).append("}\n");
	}

	private static String indent(int level) {
		String s = "";
		for(int i = 0; i < level; i++) {
			s += "  ";
		}
		return s;
	}
	
}
