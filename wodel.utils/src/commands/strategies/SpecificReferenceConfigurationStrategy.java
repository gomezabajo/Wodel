package commands.strategies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import manager.EMFCopier;
import manager.EMFUtils;

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
	protected EObject obj;
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
			}
			this.srcRefType = this.reference.getName();
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
			}
			this.srcRefType = this.reference.getName();
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
		if (obj != null) {
			return obj.eGet(reference);
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
}
