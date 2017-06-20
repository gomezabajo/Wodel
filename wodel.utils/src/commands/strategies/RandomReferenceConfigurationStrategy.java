package commands.strategies;

import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;

public class RandomReferenceConfigurationStrategy extends
		ReferenceConfigurationStrategy {

	/**
	 * @param value
	 * Normal constructor
	 */
	protected EReference reference;
	protected EObject object;
	protected EObject obj;
	protected Object source;
	protected EObject target;
	protected List<EObject> o;
	protected boolean removal = false;
	/**
	 * Source reference name of the relation
	 */
	private String srcRefType;
	
	@Override
	public boolean sameType() {
		if (this.source != null) {
			if (this.target != null) {
				if (this.source.getClass().getSimpleName().toLowerCase().equals(this.target.getClass().getSimpleName().toLowerCase())) {
					return true;
				}
				if (this.source instanceof List<?>) {
					if (this.reference.getEType().getName().equals(this.target.eClass().getName())) {
						return true;
					}
				}
			}
		}
		else {
			if (this.target != null) {
				if (this.reference.getEType().getName().equals(this.target.eClass().getName())) {
					return true;
				}
			}
		}
		return false;
	}

	public RandomReferenceConfigurationStrategy(Resource model, EObject object, String refType, String className) {
		super("");
		this.object = object;
		for (EReference ref : object.eClass().getEAllReferences()) {
			if (ref.getName().equals(refType) == true) {
				this.reference = ref;
				break;
			}
		}
		if (this.reference != null) {
			//monovalued
			if (this.object.eGet(reference) instanceof EObject) {
				this.source = (EObject) this.object.eGet(reference);
				ArrayList<EObject> ltar = ModelManager.getObjectsOfType(className, model);
				if (ltar.size() > 0) {
					ArrayList<EObject> targets = new ArrayList<EObject>();
					for (EObject o : ltar) {
						if (EcoreUtil.equals(o, (EObject) this.source) == false) {
							targets.add(o);
						}
					}
					if (targets.size() > 0) {
						this.target = targets.get(ModelManager.getRandomIndex(targets));
					}
				}
				this.obj = EcoreUtil.copy(this.object);
				this.object.eSet(reference, this.target);
			}
			//multivalued
			if (this.object.eGet(reference) instanceof List<?>) {
				this.source = (List<EObject>) this.object.eGet(reference);
				ArrayList<EObject> ltar = ModelManager.getObjectsOfType(className, model);
				if (ltar.size() > 0) {
					ArrayList<EObject> targets = new ArrayList<EObject>();
					for (EObject o : ltar) {
						boolean flag = false;
						for (EObject osrc : (List<EObject>) this.source) {
							if (EcoreUtil.equals(o, osrc)) {
								flag = true;
								break;
							}
						}
						if (flag == false) {
							targets.add(o);
						}
					}
					if (targets.size() > 0) {
						this.target = targets.get(ModelManager.getRandomIndex(targets));
					}
				}
				this.obj = EcoreUtil.copy(this.object);
				this.o = (List<EObject>) this.object.eGet(reference, true);
				if (this.target != null) {
					if (this.o.size() > 0) {
						EObject replacement = this.o.get(ModelManager.getRandomIndex(this.o));
						this.o.remove(replacement);
					}
					//this.o.clear();
					this.o.add(this.target);
				}
			}
		}
		this.srcRefType = this.reference.getName();
	}
	
	public RandomReferenceConfigurationStrategy(Resource model, EObject object, String refType, String className, boolean removal) {
		super("");
		this.object = object;
		this.removal = removal;
		for (EReference ref : object.eClass().getEAllReferences()) {
			if (ref.getName().equals(refType) == true) {
				this.reference = ref;
				break;
			}
		}
		if (this.reference != null) {
			//monovalued
			if (this.object.eGet(reference) instanceof EObject) {
				this.source = (EObject) this.object.eGet(reference);
				ArrayList<EObject> ltar = ModelManager.getObjectsOfType(className, model);
				if (ltar.size() > 0) {
					ArrayList<EObject> targets = new ArrayList<EObject>();
					for (EObject o : ltar) {
						if (EcoreUtil.equals(o, (EObject) this.source) == false) {
							targets.add(o);
						}
					}
					if (targets.size() > 0) {
						this.target = targets.get(ModelManager.getRandomIndex(targets));
					}
				}
				this.obj = EcoreUtil.copy(this.object);
				this.object.eSet(reference, this.target);
			}
			//multivalued
			if (this.object.eGet(reference) instanceof List<?>) {
				this.source = (List<EObject>) this.object.eGet(reference);
				ArrayList<EObject> ltar = ModelManager.getObjectsOfType(className, model);
				if (ltar.size() > 0) {
					ArrayList<EObject> targets = new ArrayList<EObject>();
					for (EObject o : ltar) {
						boolean flag = false;
						for (EObject osrc : (List<EObject>) this.source) {
							if (EcoreUtil.equals(o, osrc)) {
								flag = true;
								break;
							}
						}
						if (flag == false) {
							targets.add(o);
						}
					}
					if (targets.size() > 0) {
						this.target = targets.get(ModelManager.getRandomIndex(targets));
					}
				}
				this.obj = EcoreUtil.copy(this.object);
				this.o = (List<EObject>) this.object.eGet(reference, true);
				if (this.target != null) {
					if (this.o.size() > 0) {
						EObject replacement = this.o.get(ModelManager.getRandomIndex(this.o));
						this.o.remove(replacement);
					}
					//this.o.clear();
					if (this.removal == false) {
						this.o.add(this.target);
					}
				}
			}
		}
		this.srcRefType = this.reference.getName();
	}
	
	public Object getValue(EObject o) {
		if (this.object.eGet(reference) instanceof EObject) {
			return object.eGet(reference);
		}
		if (this.object.eGet(reference) instanceof List<?>) {
			return this.o; 
		}
		return null;
	}
	
	public Object getPrevious() {
		return obj.eGet(reference);
	}
	
	public Object getNext() {
		if (this.object.eGet(reference) instanceof EObject) {
			return object.eGet(reference);
		}
		if (this.object.eGet(reference) instanceof List<?>) {
			return this.o; 
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
