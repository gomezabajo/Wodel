package wodel.utils.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class EMFDiff {
	
	private EMFDiff() {
		
	}

	public static final class ModelDelta {
        private final List<EObject> added;
        private final List<EObject> removed;

        public ModelDelta(List<EObject> added, List<EObject> removed) {
            this.added = added;
            this.removed = removed;
        }

        public List<EObject> getAdded() {
            return added;
        }

        public List<EObject> getRemoved() {
            return removed;
        }
    }
	
	/**
     * Returns the EObjects newly added to the mutant model and the EObjects
     * removed from the original model.
     *
     * added   = present in mutant, absent in original
     * removed = present in original, absent in mutant
     */
    public static ModelDelta findAddedAndRemovedEObjects(Resource original, Resource mutant) {
        Map<String, List<EObject>> originalBuckets = bucketByStableKey(original);
        Map<String, List<EObject>> mutantBuckets = bucketByStableKey(mutant);

        Set<String> allKeys = new LinkedHashSet<String>();
        allKeys.addAll(originalBuckets.keySet());
        allKeys.addAll(mutantBuckets.keySet());

        List<EObject> added = new ArrayList<EObject>();
        List<EObject> removed = new ArrayList<EObject>();

        for (String key : allKeys) {
            List<EObject> originalObjects = originalBuckets.containsKey(key)
                    ? originalBuckets.get(key)
                    : Collections.<EObject>emptyList();

            List<EObject> mutantObjects = mutantBuckets.containsKey(key)
                    ? mutantBuckets.get(key)
                    : Collections.<EObject>emptyList();

            int commonCount = Math.min(originalObjects.size(), mutantObjects.size());

            // Extra objects in mutant => added
            for (int i = commonCount; i < mutantObjects.size(); i++) {
                added.add(mutantObjects.get(i));
            }

            // Extra objects in original => removed
            for (int i = commonCount; i < originalObjects.size(); i++) {
                removed.add(originalObjects.get(i));
            }
        }

        return new ModelDelta(added, removed);
    }

    private static Map<String, List<EObject>> bucketByStableKey(Resource resource) {
        Map<String, List<EObject>> result = new LinkedHashMap<String, List<EObject>>();

        for (EObject obj : getAllEObjects(resource)) {
            String key = buildStableKey(obj);
            List<EObject> bucket = result.get(key);
            if (bucket == null) {
                bucket = new ArrayList<EObject>();
                result.put(key, bucket);
            }
            bucket.add(obj);
        }

        return result;
    }

    private static List<EObject> getAllEObjects(Resource resource) {
        List<EObject> all = new ArrayList<EObject>();

        for (EObject root : resource.getContents()) {
            all.add(root);

            TreeIterator<EObject> it = root.eAllContents();
            while (it.hasNext()) {
                all.add(it.next());
            }
        }

        return all;
    }

    /**
     * Matching strategy:
     * 1) Prefer xmi:id / EMF ID if available
     * 2) Else prefer EID attribute if present
     * 3) Else fall back to a structural signature
     */
    private static String buildStableKey(EObject obj) {
        // 1) xmi:id / EMF resource ID
        String emfId = EcoreUtil.getID(obj);
        if (emfId != null && !emfId.trim().isEmpty()) {
            return "ID::" + obj.eClass().getEPackage().getNsURI()
                    + "::" + obj.eClass().getName()
                    + "::" + emfId;
        }

        // 2) EID attribute
        EAttribute eid = obj.eClass().getEIDAttribute();
        if (eid != null && obj.eIsSet(eid)) {
            Object value = obj.eGet(eid);
            return "EID::" + obj.eClass().getEPackage().getNsURI()
                    + "::" + obj.eClass().getName()
                    + "::" + String.valueOf(value);
        }

        // 3) Structural signature fallback
        StringBuilder sb = new StringBuilder();
        sb.append("SIG::");
        sb.append(obj.eClass().getEPackage().getNsURI()).append("::");
        sb.append(obj.eClass().getName());

        if (obj.eContainingFeature() != null) {
            sb.append("|feature=").append(obj.eContainingFeature().getName());
        }

        if (obj.eContainer() != null) {
            sb.append("|containerType=").append(obj.eContainer().eClass().getName());
        }

        List<EAttribute> attrs = new ArrayList<EAttribute>(obj.eClass().getEAllAttributes());
        Collections.sort(attrs, new Comparator<EAttribute>() {
            @Override
            public int compare(EAttribute a1, EAttribute a2) {
                return a1.getName().compareTo(a2.getName());
            }
        });

        for (EAttribute attr : attrs) {
            if (attr.isDerived() || attr.isTransient() || attr.isVolatile()) {
                continue;
            }

            sb.append("|").append(attr.getName()).append("=");

            Object value = obj.eGet(attr);
            if (value instanceof List<?>) {
                List<?> list = (List<?>) value;
                sb.append("[");
                for (int i = 0; i < list.size(); i++) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(String.valueOf(list.get(i)));
                }
                sb.append("]");
            } else {
                sb.append(String.valueOf(value));
            }
        }

        return sb.toString();
    }
}
