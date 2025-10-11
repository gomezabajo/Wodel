package wodel.utils.commands.strategies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.manager.EMFCopier;

public class NullReferenceConfigurationStrategy extends ReferenceConfigurationStrategy {

	public NullReferenceConfigurationStrategy(String a2m) {
		super(a2m);
		// TODO Auto-generated constructor stub
	}

	protected EReference reference;
	protected EObject source;
	protected EObject obj;
	protected EObject refObj;
	protected List<EObject> sources;
	protected Object value = null;
	/**
	 * Source reference name of the relation
	 */
	private String srcRefType;
	
	@Override
	public boolean sameType() {
		return true;
	}

	public NullReferenceConfigurationStrategy(Resource model, EObject object, String refType) {
		super("");
		this.source = object;
		for (EReference ref : object.eClass().getEAllReferences()) {
			if (ref.getName().equals(refType) == true) {
				this.reference = ref;
				break;
			}
		}
		if (this.reference != null) {
			//monovalued
			if (this.source.eGet(reference) instanceof EObject) {
				this.obj = EMFCopier.copy(this.source);
				this.source.eUnset(reference);
			}
			//multivalued
			if (this.source.eGet(reference) instanceof List<?>) {
				this.sources = (List<EObject>) this.source.eGet(reference);
				List<EObject> targets = new ArrayList<EObject>();
				this.obj = EMFCopier.copy(this.source);
				this.source.eSet(reference, targets);
			}
		}
		this.srcRefType = this.reference.getName();
	}
	
	public NullReferenceConfigurationStrategy(EObject object, String refType) {
		super("");
		this.source = object;
		for (EReference ref : object.eClass().getEAllReferences()) {
			if (ref.getName().equals(refType) == true) {
				this.reference = ref;
				break;
			}
		}
		if (this.reference != null) {
			//monovalued
			if (this.source.eGet(reference) instanceof EObject) {
				this.obj = EMFCopier.copy(this.source);
				this.source.eUnset(reference);
			}
			//multivalued
			if (this.source.eGet(reference) instanceof List<?>) {
				this.sources = (List<EObject>) this.source.eGet(reference);
				List<EObject> targets = new ArrayList<EObject>();
				this.obj = EMFCopier.copy(this.source);
				this.source.eSet(reference, targets);
			}
		}
		this.srcRefType = this.reference.getName();
	}
	
	public Object getValue(EObject o) {
		return this.source.eGet(reference);
	}
	
	public Object getPrevious() {
		if (this.obj != null && this.obj.eGet(reference) != null) {
			return this.obj.eGet(reference);
		}
		return this.sources;
	}
	
	public Object getNext() {
		if (this.source != null) {
			return this.source.eGet(reference);
		}
		return null;
	}
	
	public String getSrcRefType() {
		return srcRefType;
	}
}
