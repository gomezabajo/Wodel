package wodel.utils.commands.strategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import wodel.utils.manager.EMFCopier;
import wodel.utils.manager.ModelManager;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * SwapReferenceConfigurationStrategy reference swap
 *  
 */

public class SwapReferenceConfigurationStrategy extends ReferenceConfigurationStrategy {
	
	/**
	 * @param value
	 * Normal constructor
	 */
	protected EReference source;
	protected EReference target;
	protected EObject obj;
	protected EObject eobjsrc;
	protected EObject eobjtar;
	protected EObject othereobjsrc;
	protected String othereobjsrcname;
	protected EObject othereobjtar;
	protected String othereobjtarname;
	
	@Override
	public boolean sameType() {
		// A referenced EObject is not necessarily an instance of the owner's EClass.
		// Compare the declared reference types rather than calling eGet on it.
		return source != null && target != null
				&& (source.getEReferenceType().isSuperTypeOf(target.getEReferenceType())
						|| target.getEReferenceType().isSuperTypeOf(source.getEReferenceType()));
	}

	public SwapReferenceConfigurationStrategy(EObject o, String target, String source) {
		super("");
		for (EReference r : o.eClass().getEAllReferences()) {
			if (r.getName().equals(source)) {
				this.source = r;
				break;
			}
		}
		for (EReference r : o.eClass().getEAllReferences()) {
			if (r.getName().equals(target)) {
				this.target = r;
				break;
			}
		}
		
		if (this.source != null) {
			if (o.eGet(this.source) != null) {
				if (o.eGet(this.source) instanceof EObject) {
					if (EcoreUtil.equals(this.source.getEType(), (((EObject) o.eGet(this.source)).eClass()))) {
						othereobjsrc = (EObject) o.eGet(this.source, true);
						othereobjsrcname = this.source.getName();
					}
				}
				if (o.eGet(this.source) instanceof List<?> && ((List<EObject>)o.eGet(this.source)).size() > 0) {
					if (EcoreUtil.equals(this.source.getEType(), (((List<EObject>) o.eGet(this.source)).get(0).eClass()))) {
						othereobjsrc = ((List<EObject>) o.eGet(this.source, true)).get(0);
						othereobjsrcname = this.source.getName();
					}
					
				}
			}
		}

		if (this.target != null) {
			if (o.eGet(this.target) != null) {
				if (o.eGet(this.target) instanceof EObject) {
					if (EcoreUtil.equals(this.target.getEType(), (((EObject) o.eGet(this.target)).eClass()))) {
						othereobjtar = (EObject) o.eGet(this.target, true);
						othereobjtarname = this.target.getName();
					}
				}
				if (o.eGet(this.target) instanceof List<?> && ((List<EObject>)o.eGet(this.target)).size() > 0) {
					if (EcoreUtil.equals(this.target.getEType(), (((List<EObject>) o.eGet(this.target)).get(0).eClass()))) {
						othereobjtar = ((List<EObject>) o.eGet(this.target, true)).get(0);
						othereobjtarname = this.target.getName();
					}
					
				}
			}
		}

		if (othereobjsrc != null) {
			eobjsrc = EMFCopier.copy(othereobjsrc);
		}
		if (othereobjtar != null) {
			eobjtar = EMFCopier.copy(othereobjtar);
		}
		
		Object src = o.eGet(this.source, true);
		Object tar = o.eGet(this.target, true);

		obj = EMFCopier.copy(o);

		try {
			if (this.target.isMany() == false && this.source.isMany() == false) {
				List<EObject> tmp = new ArrayList<EObject>();
				tmp.add((EObject) src);
				ModelManager.setReference(this.source.getName(), o, (EObject) tar);
				ModelManager.setReference(this.target.getName(), o, tmp.get(0));
			}
			if (this.target.isMany() == true && this.source.isMany() == true
					&& this.target != this.source) {
				List<EObject> tmp = new ArrayList<EObject>();
				tmp.addAll((List<EObject>) tar);
				((List<EObject>) tar).clear();
				((List<EObject>) tar).addAll((List<EObject>) src);
				((List<EObject>) src).clear();
				((List<EObject>) src).addAll(tmp);
			}
		}
		catch (ReferenceNonExistingException ex) {
		}
		catch (WrongAttributeTypeException ex) {
		}
	}
	
	public SwapReferenceConfigurationStrategy(EObject obj_source, String src_name, String target, String source, Resource model) {
		super("");
		//obtiene un objeto aleatorio de los objetos referidos por source y target
		Object obs = null;
		try {
			obs = ModelManager.getReferenced(source, obj_source);
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<EObject> l = new ArrayList<EObject>();
		if (obs instanceof List<?>) {
			l.addAll((List<EObject>) obs);
		}
		if (obs instanceof EObject) {
			l.add((EObject) obs);
		}
		if(l==null || l.size()==0) return;
		EObject obj_src = l.get(ModelManager.getRandomIndex(l));
		try {
			obs = ModelManager.getReferenced(target, obj_source);
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l = new ArrayList<EObject>();
		if (obs instanceof List<?>) {
			l.addAll((List<EObject>) obs);
		}
		if (obs instanceof EObject) {
			l.add((EObject) obs);
		}
		if(l==null || l.size()==0) return;
		EObject obj_tar = l.get(ModelManager.getRandomIndex(l));
		//obtiene los valores de los atributos
		for (EReference r : obj_source.eClass().getEAllReferences()) {
			if (r.getName().equals(source)) {
				this.source = r;
				break;
			}
		}
		for (EReference r : obj_source.eClass().getEAllReferences()) {
			if (r.getName().equals(target)) {
				this.target = r;
				break;
			}
		}
		
		if (this.source != null) {
			if (obj_source.eGet(this.source) != null) {
				if (obj_source.eGet(this.source) instanceof EObject) {
					if (EcoreUtil.equals(this.source.getEType(), (((EObject) obj_source.eGet(this.source)).eClass()))) {
						othereobjsrc = (EObject) obj_source.eGet(this.source, true);
						othereobjsrcname = this.source.getName();
					}
				}
				if (obj_source.eGet(this.source) instanceof List<?> && ((List<EObject>)obj_source.eGet(this.source)).size() > 0) {
					if (EcoreUtil.equals(this.source.getEType(), (((List<EObject>) obj_source.eGet(this.source)).get(0)).eClass())) {
						othereobjsrc = ((List<EObject>) obj_source.eGet(this.source, true)).get(0);
						othereobjsrcname = this.source.getName();
					}
				}
			}
		}

		if (this.target != null) {
			if (obj_source.eGet(this.target) != null) {
				if (obj_source.eGet(this.target) instanceof EObject) {
					if (EcoreUtil.equals(this.target.getEType(), (((EObject) obj_source.eGet(this.target)).eClass()))) {
						othereobjtar = (EObject) obj_source.eGet(this.target, true);
						othereobjtarname = this.target.getName();
					}
				}
				if (obj_source.eGet(this.target) instanceof List<?> && ((List<EObject>)obj_source.eGet(this.target)).size() > 0) {
					if (EcoreUtil.equals(this.target.getEType(), (((List<EObject>) obj_source.eGet(this.target)).get(0)).eClass())) {
						othereobjtar = ((List<EObject>) obj_source.eGet(this.target, true)).get(0);
						othereobjtarname = this.target.getName();
					}
				}
			}
		}

		eobjsrc = EMFCopier.copy(obj_src);
		eobjtar = EMFCopier.copy(obj_tar);

		Object src = obj_source.eGet(this.source, true);
		Object tar = obj_source.eGet(this.target, true);

		obj = EMFCopier.copy(obj_source);

		try {
			if (this.target.isMany() == false && this.source.isMany() == false) {
				List<EObject> tmp = new ArrayList<EObject>();
				tmp.add((EObject) src);
				ModelManager.setReference(this.source.getName(), obj_source, (EObject) tar);
				ModelManager.setReference(this.target.getName(), obj_source, tmp.get(0));
			}
			if (this.target.isMany() == true && this.source.isMany() == true
					&& this.target != this.source) {
				List<EObject> tmp = new ArrayList<EObject>();
				tmp.addAll((List<EObject>) tar);
				((List<EObject>) tar).clear();
				((List<EObject>) tar).addAll((List<EObject>) src);
				((List<EObject>) src).clear();
				((List<EObject>) src).addAll(tmp);
			}
		}
		catch (ReferenceNonExistingException ex) {
		}
		catch (WrongAttributeTypeException ex) {
		}
	}

	/**
	 * Exchanges one referenced EObject from {@code obj_source.source} with one
	 * referenced EObject from {@code obj_target.target}. Multi-valued references
	 * are supported: only the selected entries are exchanged, not the entire
	 * lists. This also supports the same reference name (e.g. "actions") on
	 * two different owners.
	 */
	public SwapReferenceConfigurationStrategy(EObject obj_target, EObject obj_source,
			String target, String source) {
		super("");
		this.source = requireReference(obj_source, source);
		this.target = requireReference(obj_target, target);
		// getPrevious() concerns the target reference; retain its owner's state.
		this.obj = EMFCopier.copy(obj_target);
		this.othereobjsrcname = source;
		this.othereobjtarname = target;

		List<EObject> sourceValues = referencedObjects(obj_source, this.source);
		List<EObject> targetValues = referencedObjects(obj_target, this.target);
		if (sourceValues.isEmpty() || targetValues.isEmpty()) {
			return;
		}

		// If both owners and features are identical, exchange two list positions.
		// Exchanging an EObject with itself would be a no-op.
		if (obj_source == obj_target && this.source == this.target) {
			if (!this.source.isMany() || sourceValues.size() < 2) {
				return;
			}
			int srcIndex = ModelManager.getRandomIndex(sourceValues);
			int tarIndex = ModelManager.getRandomIndex(targetValues);
			if (srcIndex == tarIndex) {
				tarIndex = (tarIndex + 1) % targetValues.size();
			}
			recordSelectedObjects(sourceValues.get(srcIndex), targetValues.get(tarIndex));
			swapListPositions(referenceList(obj_source, this.source), srcIndex, tarIndex);
			return;
		}

		// Find a compatible pair, including subtype compatibility and EMF's
		// uniqueness requirement for multi-valued EReferences.
		int start = ModelManager.getRandomIndex(sourceValues);
		for (int offset = 0; offset < sourceValues.size(); offset++) {
			EObject sourceValue = sourceValues.get((start + offset) % sourceValues.size());
			List<EObject> compatibleTargets = new ArrayList<EObject>();
			for (EObject targetValue : targetValues) {
				if (accepts(this.source, targetValue)
						&& accepts(this.target, sourceValue)
						&& canReplace(obj_source, this.source, sourceValue, targetValue)
						&& canReplace(obj_target, this.target, targetValue, sourceValue)) {
					compatibleTargets.add(targetValue);
				}
			}
			if (!compatibleTargets.isEmpty()) {
				EObject targetValue = compatibleTargets.get(ModelManager.getRandomIndex(compatibleTargets));
				recordSelectedObjects(sourceValue, targetValue);
				swapReferencedValues(obj_source, this.source, sourceValue,
						obj_target, this.target, targetValue);
				return;
			}
		}
		// No pair can be exchanged without violating reference type/uniqueness.
	}

	/**
	 * Replaces one existing referenced object with the selected target objects.
	 *
	 * <p>This overload accepts the call
	 * {@code new SwapReferenceConfigurationStrategy(owner, selected, "actions", "actions")}
	 * where {@code selected} is a {@code List<EObject>} of reference values
	 * (rather than a list of reference-owning objects).
	 *
	 * <p>For a multi-valued reference [A, B, C], replacing B with [X, Y]
	 * produces [A, X, Y, C]. One existing source value is chosen using
	 * {@link ModelManager#getRandomIndex(List)}. Other values keep their order.
	 * The source and target reference names must identify the same feature;
	 * using different features requires an explicitly defined swap operation.
	 *
	 * @param owner the EObject containing the multi-valued reference
	 * @param selected replacement referenced objects (copied as a Java list)
	 * @param target name of the reference receiving the selected objects
	 * @param source name of the reference supplying the replaced object
	 * @throws IllegalArgumentException if reference names differ, the feature
	 *         is not multi-valued, or replacement values violate its constraints
	 */
	public SwapReferenceConfigurationStrategy(EObject owner,
			List<? extends EObject> selected, String target, String source) {
		super("");
		this.source = requireReference(owner, source);
		this.target = requireReference(owner, target);
		if (this.source != this.target) {
			throw new IllegalArgumentException(
					"One-to-many replacement requires the same source and target EReference");
		}
		if (!this.source.isMany()) {
			throw new IllegalArgumentException(
					"Reference '" + source + "' is not multi-valued");
		}
		if (selected == null) {
			throw new IllegalArgumentException("Selected replacement targets cannot be null");
		}

		this.obj = EMFCopier.copy(owner);
		this.othereobjsrcname = source;
		this.othereobjtarname = target;
		// The caller may pass a live EMF EList: capture it before editing the model.
		this.replacementTargets = Collections.unmodifiableList(
				new ArrayList<EObject>(selected));

		List<EObject> existingValues = referencedObjects(owner, this.source);
		if (existingValues.isEmpty()) {
			return; // Nothing to replace; consistent with the other swap constructors.
		}

		EObject oldValue = existingValues.get(ModelManager.getRandomIndex(existingValues));
		this.othereobjsrc = oldValue;
		this.eobjsrc = EMFCopier.copy(oldValue);
		if (!this.replacementTargets.isEmpty()) {
			this.othereobjtar = this.replacementTargets.get(0);
			this.eobjtar = EMFCopier.copy(this.othereobjtar);
		}
		// Validate bounds, types and uniqueness before changing any reference.
		replaceSourceWithTargets(owner, source, oldValue, this.replacementTargets);
	}

	/**
	 * Replaces one value of a multi-valued reference with zero or more values.
	 * The existing values before and after the replaced entry are preserved.
	 * For example, actions [A, B, C], replacing B with [X, Y] produces
	 * [A, X, Y, C].
	 *
	 * @param owner EObject containing the multi-valued reference
	 * @param oldValue referenced EObject to replace
	 * @param newValues replacement EObjects, in insertion order
	 * @param referenceName the reference to modify (e.g. "actions")
	 */
	public SwapReferenceConfigurationStrategy(EObject owner, EObject oldValue,
			List<? extends EObject> newValues, String referenceName) {
		super("");
		this.source = requireReference(owner, referenceName);
		this.target = this.source;
		this.obj = EMFCopier.copy(owner);
		this.othereobjsrc = oldValue;
		this.othereobjsrcname = referenceName;
		this.othereobjtarname = referenceName;
		this.eobjsrc = oldValue == null ? null : EMFCopier.copy(oldValue);
		if (newValues != null && !newValues.isEmpty()) {
			this.othereobjtar = newValues.get(0);
			this.eobjtar = EMFCopier.copy(newValues.get(0));
		}
		this.replacementTargets = newValues == null
				? Collections.<EObject>emptyList()
				: Collections.unmodifiableList(new ArrayList<EObject>(newValues));
		replaceSourceWithTargets(owner, referenceName, oldValue, newValues);
	}

	/** Values supplied to the one-to-many replacement constructor. */
	private List<EObject> replacementTargets = Collections.emptyList();

	public List<EObject> getReplacementTargets() {
		return replacementTargets;
	}

	/**
	 * Replaces one EObject in an EMF multi-valued reference with several others.
	 * All checks are performed before changing the list.
	 *
	 * @return {@code true} when the requested replacement was applied
	 * @throws IllegalArgumentException if the reference or target values are invalid
	 */
	public static boolean replaceSourceWithTargets(EObject owner, String referenceName,
			EObject oldValue, List<? extends EObject> newValues) {
		EReference reference = requireReference(owner, referenceName);
		if (!reference.isMany()) {
			throw new IllegalArgumentException("Reference '" + referenceName + "' is not multi-valued");
		}
		if (newValues == null) {
			throw new IllegalArgumentException("Replacement values cannot be null");
		}
		EList<EObject> values = referenceList(owner, reference);
		int index = values.indexOf(oldValue);
		if (index < 0) {
			throw new IllegalArgumentException("The source value is not present in '" + referenceName + "'");
		}
		List<EObject> replacements = new ArrayList<EObject>(newValues);
		for (EObject value : replacements) {
			if (!accepts(reference, value)) {
				throw new IllegalArgumentException("Replacement has an incompatible EClass for '"
						+ referenceName + "'");
			}
		}
		int sizeAfter = values.size() - 1 + replacements.size();
		if (sizeAfter < reference.getLowerBound()
				|| (reference.getUpperBound() >= 0 && sizeAfter > reference.getUpperBound())) {
			throw new IllegalArgumentException("Replacement violates the bounds of '" + referenceName + "'");
		}
		if (reference.isUnique()) {
			List<EObject> prospective = new ArrayList<EObject>(values);
			prospective.remove(index);
			for (EObject value : replacements) {
				if (prospective.contains(value)) {
					throw new IllegalArgumentException("Duplicate reference value in '" + referenceName + "'");
				}
				prospective.add(value);
			}
		}
		values.remove(index);
		values.addAll(index, replacements);
		return true;
	}

	private void recordSelectedObjects(EObject sourceValue, EObject targetValue) {
		othereobjsrc = sourceValue;
		othereobjtar = targetValue;
		eobjsrc = EMFCopier.copy(sourceValue);
		eobjtar = EMFCopier.copy(targetValue);
	}

	private static EReference requireReference(EObject owner, String name) {
		if (owner == null || name == null) {
			throw new IllegalArgumentException("Reference owner and name must be non-null");
		}
		for (EReference ref : owner.eClass().getEAllReferences()) {
			if (name.equals(ref.getName())) {
				if (!ref.isChangeable() || ref.isDerived()) {
					throw new IllegalArgumentException("Reference '" + name + "' is not changeable");
				}
				return ref;
			}
		}
		throw new IllegalArgumentException("Unknown EReference: " + name);
	}

	private static List<EObject> referencedObjects(EObject owner, EReference reference) {
		Object value = owner.eGet(reference, true);
		if (value instanceof EObject) {
			return Collections.singletonList((EObject) value);
		}
		if (value instanceof List<?>) {
			List<EObject> result = new ArrayList<EObject>();
			for (Object element : (List<?>) value) {
				if (element instanceof EObject) {
					result.add((EObject) element);
				}
			}
			return result;
		}
		return Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	private static EList<EObject> referenceList(EObject owner, EReference reference) {
		return (EList<EObject>) owner.eGet(reference, true);
	}

	private static boolean accepts(EReference reference, EObject value) {
		return value != null && reference.getEReferenceType().isSuperTypeOf(value.eClass());
	}

	private static boolean canReplace(EObject owner, EReference reference,
			EObject oldValue, EObject replacement) {
		return !reference.isMany() || !reference.isUnique()
				|| oldValue == replacement || !referenceList(owner, reference).contains(replacement);
	}

	private static void swapListPositions(EList<EObject> values, int first, int second) {
		if (first == second) {
			return;
		}
		// EList.move avoids temporary duplicates in unique EMF lists.
		int low = Math.min(first, second);
		int high = Math.max(first, second);
		values.move(low, high);
		values.move(high, low + 1);
	}

	private static void swapReferencedValues(EObject sourceOwner, EReference sourceReference,
			EObject sourceValue, EObject targetOwner, EReference targetReference, EObject targetValue) {
		EList<EObject> sourceList = sourceReference.isMany()
				? referenceList(sourceOwner, sourceReference) : null;
		EList<EObject> targetList = targetReference.isMany()
				? referenceList(targetOwner, targetReference) : null;
		int sourceIndex = sourceList == null ? -1 : sourceList.indexOf(sourceValue);
		int targetIndex = targetList == null ? -1 : targetList.indexOf(targetValue);

		// Detach both values before attaching either; this matters for containment
		// references, where attaching to a new owner removes the old containment.
		if (sourceList != null) {
			sourceList.remove(sourceIndex);
		} else {
			sourceOwner.eUnset(sourceReference);
		}
		if (targetList != null) {
			targetList.remove(targetIndex);
		} else {
			targetOwner.eUnset(targetReference);
		}
		if (sourceList != null) {
			sourceList.add(sourceIndex, targetValue);
		} else {
			sourceOwner.eSet(sourceReference, targetValue);
		}
		if (targetList != null) {
			targetList.add(targetIndex, sourceValue);
		} else {
			targetOwner.eSet(targetReference, sourceValue);
		}
	}

	public Object getValue(EObject o) {
		return o.eGet(this.target);
	}
	
	public Object getPrevious() {
		if (obj == null || this.target == null) {
			return null;
		}
		return obj.eGet(this.target);
	}
	
	public Object getNext(EObject o) {
		if (o == null || this.target == null) {
			return null;
		}
		return o.eGet(this.target);
	}
	
	public EObject getSourceObject() {
		return eobjsrc;
	}

	public EObject getTargetObject() {
		return eobjtar;
	}

	public EObject getOtherSource() {
		return othereobjsrc;
	}
	
	public String getOtherSourceName() {
		return othereobjsrcname;
	}

	public EObject getOtherTarget() {
		return othereobjtar;
	}
	
	public String getOtherTargetName() {
		return othereobjtarname;
	}
	
	@Override
	public EReference getRef() {
		return this.source;
	}
}
