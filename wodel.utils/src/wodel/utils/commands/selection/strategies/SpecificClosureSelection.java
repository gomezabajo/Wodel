package wodel.utils.commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import wodel.utils.manager.ModelManager;

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
 * SpecificClosureSelection selects an specific object
 * contained in the given reference
 */

public class SpecificClosureSelection extends SpecificSelection{
	
	/**
	 * Object to select
	 */
	private EObject obj;
	
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
	public SpecificClosureSelection(List<EPackage> metaModel, Resource model, EObject obj){
		super(metaModel, model);
		this.obj = obj;
	}
	
	public SpecificClosureSelection(List<EPackage> metaModel, Resource model, ObjectEmitter oe){
		super(metaModel, model);
		this.oe = oe;
	}

	public SpecificClosureSelection(List<EPackage> metaModel, Resource model, EObject obj, String refType){
		super(metaModel, model);
		this.obj = obj;
		this.refType = refType;
	}
	
	public SpecificClosureSelection(List<EPackage> metaModel, Resource model, ObjectEmitter oe, String refType){
		super(metaModel, model);
		this.oe = oe;
		this.refType = refType;
	}
	
	public SpecificClosureSelection(List<EPackage> metaModel, Resource model, EObject obj, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection) {
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
	
	private List<EObject> getChildren(EObject object, EReference ref) {
		List<EObject> ret = new ArrayList<EObject>();
		if (ref.getEType().getName().equals(object.eClass().getName())) {
			if (object.eGet(ref) instanceof List<?>) {
				List<EObject> children = (List<EObject>) object.eGet(ref);
				if (children.size() > 0) {
					ret.add(object);
				}
				for (EObject obj : children) {
					ret.addAll(getChildren(obj, ref));
				}
			}
		}
		return ret;
	}


	@Override
	public EObject getObject() throws ReferenceNonExistingException {
		if ((container == null) && (reference == null)) {
			if(obj!=null) {
				if (this.refType != null) {
					for (EReference ref : obj.eClass().getEAllReferences()) {
						if (ref.getName().equals(this.refType)) {
							if (obj.eGet(ref) instanceof List<?>) {
								List<EObject> children = getChildren(obj, ref);
								return children.get(ModelManager.getRandomIndex(children));
							}
							else {
								return null;
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
							if (obj.eGet(ref) instanceof List<?>) {
								List<EObject> children = getChildren(obj, ref);
								return children.get(ModelManager.getRandomIndex(children));
							}
							else {
								return null;
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
						if (EcoreUtil.getURI(o).equals(EcoreUtil.getURI(obj))) {
							return o;
						}
					}
				}
				if (container.eGet(reference) instanceof EObject) {
					EObject object = (EObject) container.eGet(reference);
					if (EcoreUtil.getURI(object).equals(EcoreUtil.getURI(obj))) {
						return object;
					}
				}
			}
		}
		return null;
	}
}
