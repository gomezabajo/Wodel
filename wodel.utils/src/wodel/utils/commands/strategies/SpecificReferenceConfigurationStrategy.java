package wodel.utils.commands.strategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import wodel.utils.manager.EMFCopier;
import wodel.utils.manager.EMFUtils;

/**
 * @author Pablo Gomez-Abajo
 * 
 * SpecificReferenceConfigurationStrategy specific reference configuration
 * 
 */
public class SpecificReferenceConfigurationStrategy extends
		ReferenceConfigurationStrategy {

	protected EReference reference;
	protected EObject object;
	protected EObject target;
	protected List<EObject> targets;
	protected EObject obj;
	protected EObject refObj;
	protected List<EObject> o;
	protected Object value = null;
	protected boolean removal = false;
	/**
	 * Source reference name of the relation
	 */
	private String srcRefType;
	
	@Override
	public boolean sameType() {
		if (this.reference != null && this.target != null) {
			List<EClass> types = new ArrayList<EClass>();
			types.add(this.target.eClass());
			types.addAll(this.target.eClass().getEAllSuperTypes());
			boolean found = false;
			for (EClass type : types) {
				if (EcoreUtil.equals(this.reference.getEReferenceType(), type)) {
					found = true;
					break;
				}
			}
			return found;
		}
		return false;
	}
	

	public SpecificReferenceConfigurationStrategy(Resource model, EObject object, List<EObject> targets,
			String refType) {

		this(model, object, targets, refType, false);
	}

	@SuppressWarnings("unchecked")
	public SpecificReferenceConfigurationStrategy(Resource model, EObject object, List<EObject> targets, String refType,
			boolean removal) {

		super("");

		if (model == null || object == null || targets == null || refType == null) {
			throw new IllegalArgumentException("Model, object, targets and reference name cannot be null");
		}

		this.object = object;
		this.removal = removal;

		// A defensive copy is essential: the original collection
		// could be an EMF containment list modified during reparenting.
		this.targets = new ArrayList<>(targets);

		for (EReference ref : object.eClass().getEAllReferences()) {
			if (ref.getName().equals(refType)) {
				this.reference = ref;
				break;
			}
		}

		if (this.reference == null) {
			throw new IllegalArgumentException(
					"Reference '" + refType + "' does not exist in " + object.eClass().getName());
		}

		this.srcRefType = this.reference.getName();

		for (EObject target : this.targets) {
			if (target == null) {
				throw new IllegalArgumentException("The target collection contains null");
			}
		}

		// Preserve the original state before any modification.
		try {
			this.obj = EMFCopier.copy(this.object);
		} catch (Exception ex) {
			this.obj = this.object;
		}

		if (this.reference.isMany()) {

			this.o = (List<EObject>) this.object.eGet(this.reference);

			// Snapshot the previous values, not the live EMF list.
			this.value = new ArrayList<>(this.o);

			for (EObject target : this.targets) {

				if (!this.reference.getEReferenceType().isSuperTypeOf(target.eClass())) {
					throw new IllegalArgumentException("Incompatible target type: " + target.eClass().getName());
				}

				if (!this.removal) {

					// The EMF containment list normally handles
					// detaching from an existing container.
					if (this.reference.isContainment() && model.getContents().contains(target)) {
						model.getContents().remove(target);
					}

					if (!this.o.contains(target)) {
						this.o.add(target);
					}

				} else {
					this.o.remove(target);
				}
			}

		} else {

			if (this.targets.size() > 1) {
				throw new IllegalArgumentException(
						"Cannot assign multiple targets to " + "single-valued reference '" + refType + "'");
			}

			this.value = this.object.eGet(this.reference);

			if (!this.targets.isEmpty()) {

				EObject target = this.targets.get(0);

				if (!this.reference.getEReferenceType().isSuperTypeOf(target.eClass())) {
					throw new IllegalArgumentException("Incompatible target type: " + target.eClass().getName());
				}

				if (this.removal) {
					if (this.object.eGet(this.reference) == target) {
						this.object.eUnset(this.reference);
					}
				} else {
					if (this.reference.isContainment() && model.getContents().contains(target)) {
						model.getContents().remove(target);
					}

					this.object.eSet(this.reference, target);
				}
			}
		}

		// Maintain compatibility with existing single-target fields.
		this.target = this.targets.isEmpty() ? null : this.targets.get(0);
	}

	public List<EObject> getTargets() {
		return targets == null ? Collections.emptyList() : Collections.unmodifiableList(targets);
	}


	public SpecificReferenceConfigurationStrategy(Resource model, EObject object, EObject target, String refType) {
		super("");
		this.object = object;
		if (object != null) {
			for (EReference ref : object.eClass().getEAllReferences()) {
				if (ref.getName().equals(refType) == true) {
					this.reference = ref;
					break;
				}
			}
			if (this.reference != null) {
				//monovalued
				if (this.object.eGet(reference) == null) {
					this.target = target;
					if (model.getContents().contains(this.target)) {
						model.getContents().remove(this.target);
					}
					try {
						this.value = this.object.eGet(reference);
						EMFUtils.setReference(this.object.eClass().getEPackage(), this.object, reference.getName(), this.target);
					}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				if (this.object.eGet(reference) instanceof EObject) {
                    try {
                        this.obj = EMFCopier.copy(this.object);
                        this.refObj = EMFCopier.copy((EObject)this.object.eGet(this.reference, true));
                        EStructuralFeature feat = (this.refObj.eClass().getEStructuralFeature("name"));
                        System.out.println(this.refObj.eClass().eGet(feat));
                    } catch (Exception ex) {
                        this.obj = this.object;
                    }
					this.target = target;
					if (model.getContents().contains(this.target)) {
						model.getContents().remove(this.target);
					}
					try {
						this.value = this.object.eGet(reference);
						EMFUtils.setReference(this.object.eClass().getEPackage(), this.object, reference.getName(), this.target);
					}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				//multivalued
				if (this.object.eGet(reference) instanceof List<?>) {
                    try { 
                        this.obj = EMFCopier.copy(this.object);
                    } catch (Exception ex) {
                        this.obj = this.object;
                    }
					this.o = (List<EObject>) this.object.eGet(reference, true);
					this.value = this.object.eGet(reference);
					this.target = target;
					if (model.getContents().contains(this.target)) {
						model.getContents().remove(this.target);
					}
					this.o.add(this.target);
				}
				this.srcRefType = this.reference.getName();
			}
		}
	}
	
	public SpecificReferenceConfigurationStrategy(Resource model, EObject object, EObject target, String refType, boolean removal) {
		super("");
		this.object = object;
		this.removal = removal;
		if (object != null) {
			for (EReference ref : object.eClass().getEAllReferences()) {
				if (ref.getName().equals(refType) == true) {
					this.reference = ref;
					break;
				}
			}
			if (this.reference != null) {
				//monovalued
				if (this.object.eGet(reference) == null) {
					this.target = target;
					if (model.getContents().contains(this.target)) {
						model.getContents().remove(this.target);
					}
					try {
						this.value = this.object.eGet(reference);
						EMFUtils.setReference(this.object.eClass().getEPackage(), this.object, reference.getName(), this.target);
					}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				if (this.object.eGet(reference) instanceof EObject) {
                    try { 
                        this.obj = EMFCopier.copy(this.object);
                    } catch (Exception ex) {
                        this.obj = this.object;
                    }
					this.target = target;
					if (model.getContents().contains(this.target)) {
						model.getContents().remove(this.target);
					}
					try {
						this.value = this.object.eGet(reference);
						EMFUtils.setReference(this.object.eClass().getEPackage(), this.object, reference.getName(), this.target);
					}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				//multivalued
				if (this.object.eGet(reference) instanceof List<?>) {
                    try { 
                        this.obj = EMFCopier.copy(this.object);
                    } catch (Exception ex) {
                        this.obj = this.object;
                    }
					this.o = (List<EObject>) this.object.eGet(reference, true);
					this.value = this.object.eGet(reference);
					this.target = target;
					if (this.removal == false) {
						if (model.getContents().contains(this.target)) {
							model.getContents().remove(this.target);
						}
						this.o.add(this.target);
					}
					else {
						if (this.o.size() > 0) {
							if (this.o.contains(this.target)) {
								this.o.remove(this.target);
							}
						}
					}
				}
				this.srcRefType = this.reference.getName();
			}
		}
	}
	
	public Object getValue() {
		return this.value;
	}
	
	public Object getValue(EObject o) {
		if (object != null) {
			if (this.object.eGet(reference) instanceof EObject) {
				return object.eGet(reference);
			}
			if (this.object.eGet(reference) instanceof List<?>) {
				return this.o; 
			}
		}
		return null;
	}
	
	public Object getPrevious() {
		if (this.refObj != null) {
			return this.refObj;
		}
		return null;
	}
	
	public Object getNext() {
		if (object != null) {
			if (this.object.eGet(reference) instanceof EObject) {
				return object.eGet(reference);
			}
			if (this.object.eGet(reference) instanceof List<?>) {
				return this.o; 
			}
		}
		return null;
	}
	
	public String getSrcRefType() {
		return srcRefType;
	}
	
	@Override
	public boolean isRemoval() {
		return this.removal;
	}

	@Override
	public EReference getRef() {
		return this.reference;
	}
}
