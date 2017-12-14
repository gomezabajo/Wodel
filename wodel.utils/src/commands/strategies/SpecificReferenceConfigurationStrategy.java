package commands.strategies;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
	protected boolean removal = false;
	/**
	 * Source reference name of the relation
	 */
	private String srcRefType;
	
	@Override
	public boolean sameType() {
		if (this.reference != null && this.target != null) {
			if (EcoreUtil.equals(this.reference.getEReferenceType(), this.target.eClass())) {
				return true;
			}
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
				if (this.object.eGet(reference) instanceof EObject) {
					this.obj = EcoreUtil.copy(this.object);
					this.target = target;
					this.object.eSet(reference, this.target);
				}
				//multivalued
				if (this.object.eGet(reference) instanceof List<?>) {
					this.obj = EcoreUtil.copy(this.object);
					this.o = (List<EObject>) this.object.eGet(reference, true);
					this.target = target;
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
				if (this.object.eGet(reference) instanceof EObject) {
					this.obj = EcoreUtil.copy(this.object);
					this.target = target;
					this.object.eSet(reference, this.target);
				}
				//multivalued
				if (this.object.eGet(reference) instanceof List<?>) {
					this.obj = EcoreUtil.copy(this.object);
					this.o = (List<EObject>) this.object.eGet(reference, true);
					this.target = target;
					if (this.removal == false) {
						this.o.add(this.target);
					}
					else {
						if (this.o.size() > 0) {
							this.o.remove(this.target);
						}
					}
				}
			}
			this.srcRefType = this.reference.getName();
		}
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
