package wodel.utils.commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import wodel.utils.commands.ObjectEmitter;
import wodel.utils.exceptions.ReferenceNonExistingException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * SpecificObjectSelection selects an specific object
 *  
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */
public class SpecificObjectSelection extends SpecificSelection{
	
	/**
	 * Object to select
	 */
	private EObject obj;
	
	private List<EObject> objs;
	
	private ObjectEmitter oe;
	
	private String refType;
	
	private EObject container;
	
	private EReference reference;
	
	
	/**
	 * @param metaModel
	 * @param model
	 * @param obj
	 * Normal constructor
	 */
	public SpecificObjectSelection(List<EPackage> metaModel, Resource model, EObject obj){
		super(metaModel, model);
		this.obj = obj;
	}
	

	/**
	 * @param metaModel
	 * @param model
	 * @param obj
	 * Normal constructor
	 */
	public SpecificObjectSelection(List<EPackage> metaModel, List<Resource> models, EObject obj){
		super(metaModel, models);
		this.obj = obj;
	}
	
	public SpecificObjectSelection(List<EPackage> metaModel, Resource model, List<EObject> objs){
		super(metaModel, model);
		this.objs = objs;
	}

	public SpecificObjectSelection(List<EPackage> metaModel, List<Resource> models, List<EObject> objs){
		super(metaModel, models);
		this.objs = objs;
	}

	public SpecificObjectSelection(List<EPackage> metaModel, Resource model, ObjectEmitter oe){
		super(metaModel, model);
		this.oe = oe;
	}

	public SpecificObjectSelection(List<EPackage> metaModel, List<Resource> models, ObjectEmitter oe){
		super(metaModel, models);
		this.oe = oe;
	}

	public SpecificObjectSelection(List<EPackage> metaModel, Resource model, EObject obj, String refType){
		super(metaModel, model);
		this.obj = obj;
		this.refType = refType;
	}
	
	public SpecificObjectSelection(List<EPackage> metaModel, List<Resource> models, EObject obj, String refType){
		super(metaModel, models);
		this.obj = obj;
		this.refType = refType;
	}

	public SpecificObjectSelection(List<EPackage> metaModel, Resource model, List<EObject> objs, String refType){
		super(metaModel, model);
		this.objs = objs;
		this.refType = refType;
	}
	
	public SpecificObjectSelection(List<EPackage> metaModel, List<Resource> models, List<EObject> objs, String refType){
		super(metaModel, models);
		this.objs = objs;
		this.refType = refType;
	}

	public SpecificObjectSelection(List<EPackage> metaModel, Resource model, ObjectEmitter oe, String refType){
		super(metaModel, model);
		this.oe = oe;
		this.refType = refType;
	}
	
	public SpecificObjectSelection(List<EPackage> metaModel, List<Resource> models, ObjectEmitter oe, String refType){
		super(metaModel, models);
		this.oe = oe;
		this.refType = refType;
	}

	public SpecificObjectSelection(List<EPackage> metaModel, Resource model, EObject obj, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection) {
		super(metaModel, model);
		this.obj = obj;
		try {
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SpecificObjectSelection(List<EPackage> metaModel, List<Resource> models, EObject obj, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection) {
		super(metaModel, models);
		this.obj = obj;
		try {
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SpecificObjectSelection(List<EPackage> metaModel, Resource model, List<EObject> objs, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection) {
		super(metaModel, model);
		this.objs = objs;
		try {
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SpecificObjectSelection(List<EPackage> metaModel, List<Resource> models, List<EObject> objs, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection) {
		super(metaModel, models);
		this.objs = objs;
		try {
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public EObject getObject() throws ReferenceNonExistingException {
		if ((container == null) && (reference == null)) {
			if(obj!=null) {
				if (this.refType != null) {
					for (EReference ref : obj.eClass().getEAllReferences()) {
						if (ref.getName().equals(this.refType)) {
							if (obj.eGet(ref) == null) {
								return null;
							}
							if (obj.eGet(ref) instanceof EObject) {
								return (EObject) obj.eGet(ref);
							}
							if ((obj.eGet(ref) instanceof List<?>) && (((List<EObject>) obj.eGet(ref)).size() > 0)) {
								return ((List<EObject>) obj.eGet(ref)).get(0);
							}
						}
					}
				}
				else {
					return this.obj;
				}
			}
			if(oe != null) {
				if (this.refType != null) {
					for (EReference ref : oe.getObject().eClass().getEAllReferences()) {
						if (ref.getName().equals(this.refType)) {
							if (obj.eGet(ref) == null) {
								return null;
							}
							if (obj.eGet(ref) instanceof EObject) {
								return (EObject) obj.eGet(ref);
							}
							if ((obj.eGet(ref) instanceof List<?>) && (((List<EObject>) obj.eGet(ref)).size() > 0)) {
								return ((List<EObject>) obj.eGet(ref)).get(0);
							}
						}
					}
				}
			}
		}
		if ((container != null) && (reference != null)) {
			if(obj!=null) {
				if (container.eGet(reference) instanceof List<?>) {
					List<EObject> objects = (List<EObject>) container.eGet(reference);
					for (EObject o : objects) {
						if (EcoreUtil.equals(o, obj)) {
							return o;
						}
					}
				}
				if (container.eGet(reference) instanceof EObject) {
					EObject object = (EObject) container.eGet(reference);
					if (EcoreUtil.equals(object, obj)) {
						return object;
					}
				}
			}
		}
		return null;
	}


	@Override
	public List<EObject> getObjects() throws ReferenceNonExistingException {
		List<EObject> objects = new ArrayList<EObject>();
		if ((container == null) && (reference == null)) {
			if(objs!=null) {
				if (this.refType != null) {
					for (EObject obj : objs) {
						for (EReference ref : obj.eClass().getEAllReferences()) {
							if (ref.getName().equals(this.refType)) {
								if (obj.eGet(ref) != null) {
									if (obj.eGet(ref) instanceof EObject) {
										objects.add((EObject) obj.eGet(ref));
									}
									else {
										objects.addAll((List<EObject>) obj.eGet(ref));
									}
								}
							}
						}
					}
				}
				else {
					return this.objs;
				}
			}
		}
		if ((container != null) && (reference != null)) {
			if(objs!=null) {
				if (container.eGet(reference) instanceof List<?>) {
					for (EObject obj : objs) {
						List<EObject> lo = (List<EObject>) container.eGet(reference);
						for (EObject o : lo) {
							if (EcoreUtil.equals(o, obj)) {
								objects.add(o);
							}
						}
					}
				}
				if (container.eGet(reference) instanceof EObject) {
					EObject object = (EObject) container.eGet(reference);
					for (EObject obj : objs) {
						if (EcoreUtil.equals(object, obj)) {
							objects.add(object);
						}
					}
				}
			}
		}
		return null;
	}
}
