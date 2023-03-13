package wodel.utils.commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import wodel.utils.manager.ModelManager;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import wodel.utils.exceptions.ReferenceNonExistingException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * RandomTypeSelection selects a random object
 *  
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */
public class RandomTypeSelection extends RandomSelection{
	
	/**
	 * Object type
	 */
	private String type;
	
	private List<String> types;
	
	private EObject container;
	
	private EReference reference;
	
	private List<EObject> excludedObjects;
	
	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, Resource model, String type){
		super(metaModel, model);
		this.type = type;
	}
	
	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, Resource model, List<String> types){
		super(metaModel, model);
		this.types = types;
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, List<Resource> models, String type){
		super(metaModel, models);
		this.type = type;
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, List<Resource> models, List<String> types){
		super(metaModel, models);
		this.types = types;
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, Resource model, String type, List<EObject> excludedObjects){
		super(metaModel, model);
		this.type = type;
		this.excludedObjects = excludedObjects;
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, Resource model, List<String> types, List<EObject> excludedObjects){
		super(metaModel, model);
		this.types = types;
		this.excludedObjects = excludedObjects;
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, List<Resource> models, String type, List<EObject> excludedObjects){
		super(metaModel, models);
		this.type = type;
		this.excludedObjects = excludedObjects;
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, List<Resource> models, List<String> types, List<EObject> excludedObjects){
		super(metaModel, models);
		this.types = types;
		this.excludedObjects = excludedObjects;
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, Resource model, String type, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection){
		super(metaModel, model);
		try {
			this.type = type;
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, Resource model, List<String> types, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection){
		super(metaModel, model);
		try {
			this.types = types;
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, List<Resource> models, String type, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection){
		super(metaModel, models);
		try {
			this.type = type;
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, List<Resource> models, List<String> types, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection){
		super(metaModel, models);
		try {
			this.types = types;
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, Resource model, String type, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, List<EObject> excludedObjects) {
		super(metaModel, model);
		try {
			this.type = type;
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
			this.excludedObjects = excludedObjects;
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, Resource model, List<String> types, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, List<EObject> excludedObjects) {
		super(metaModel, model);
		try {
			this.types = types;
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
			this.excludedObjects = excludedObjects;
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, List<Resource> models, String type, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, List<EObject> excludedObjects) {
		super(metaModel, models);
		try {
			this.type = type;
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
			this.excludedObjects = excludedObjects;
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public RandomTypeSelection(List<EPackage> metaModel, List<Resource> models, List<String> types, ObSelectionStrategy referenceSelection, ObSelectionStrategy containerSelection, List<EObject> excludedObjects) {
		super(metaModel, models);
		try {
			this.types = types;
			this.container = containerSelection.getObject();
			this.reference = (EReference) referenceSelection.getObject();
			this.excludedObjects = excludedObjects;
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public EObject getObject() {
		List<EObject> l = new ArrayList<EObject>();
		if (type != null) {
			if (this.getModel() != null) {
				l.addAll(ModelManager.getObjectsOfType(type, this.getModel())); 
			}
			if (this.getModels() != null) {
				for (Resource resource : this.getModels()) {
					List<EObject> lr = ModelManager.getObjectsOfType(type, resource);
					for (EObject rob : lr) {
						if (!l.contains(rob)) {
							l.add(rob);
						}
					}
				}
			}
			if (excludedObjects != null) {
				ModelManager.removeEObjects(l, excludedObjects);
			}
			if(l==null || l.size()==0) return null;
			List<EObject> ret = new ArrayList<EObject>();
			if ((container == null) && (reference == null)) {
				ret.addAll(l);
			}
			if ((container != null) && (reference != null)) {
				if (container.eGet(reference) instanceof List<?>) {
					List<EObject> objects = (List<EObject>) container.eGet(reference);
					for (EObject obj : objects) {
						URI objURI = EcoreUtil.getURI(obj);
						for (EObject ob : l) {
							URI obURI = EcoreUtil.getURI(ob);
							if (obURI != null && objURI != null) {
								if (EcoreUtil.getURI(ob).equals(EcoreUtil.getURI(obj))) {
									ret.add(ob);
								}
							}
							else {
								if (ob.equals(obj)) {
									ret.add(ob);
								}
							}
						}
					}
				}
				else {
					EObject obj = (EObject) container.eGet(reference);
					if (obj != null) {
						URI objURI = EcoreUtil.getURI(obj);
						for (EObject ob : l) {
							URI obURI = EcoreUtil.getURI(ob);
							if (obURI != null && objURI != null) {
								if (EcoreUtil.getURI(ob).equals(EcoreUtil.getURI(obj))) {
									ret.add(ob);
								}
							}
							else {
								if (ob.equals(obj)) {
									ret.add(ob);
								}
							}
						}
					}
				}
			}
			else if (reference != null) {
				for (EObject o : l) {
					if (EcoreUtil.equals(o.eContainingFeature(), reference)) {
						ret.add(o);
					}
				}
			}
			int index = ModelManager.getRandomIndex(ret);
			if (index < ret.size()) {
				return ret.get(index);
			}
			else {
				return null;
			}
		}
		else {
			if (this.getModel() != null) {
				for (String t : types) {
					l.addAll(ModelManager.getObjectsOfType(t, this.getModel()));
				}
			}
			if (this.getModels() != null) {
				for (Resource resource : this.getModels()) {
					for (String t : types) {
						List<EObject> lr = ModelManager.getObjectsOfType(t, resource);
						for (EObject rob : lr) {
							if (!l.contains(rob)) {
								l.add(rob);
							}
						}
					}
				}
			}
			if (excludedObjects != null) {
				ModelManager.removeEObjects(l, excludedObjects);
			}
			if(l==null || l.size()==0) return null;
			List<EObject> ret = new ArrayList<EObject>();
			if ((container == null) && (reference == null)) {
				ret.addAll(l);
			}
			if ((container != null) && (reference != null)) {
				if (container.eGet(reference) instanceof List<?>) {
					List<EObject> objects = (List<EObject>) container.eGet(reference);
					for (EObject obj : objects) {
						URI objURI = EcoreUtil.getURI(obj);
						for (EObject ob : l) {
							URI obURI = EcoreUtil.getURI(ob);
							if (obURI != null && objURI != null) {
								if (EcoreUtil.getURI(ob).equals(EcoreUtil.getURI(obj))) {
									ret.add(ob);
								}
							}
							else {
								if (ob.equals(obj)) {
									ret.add(ob);
								}
							}
						}
					}
				}
				else {
					EObject obj = (EObject) container.eGet(reference);
					if (obj != null) {
						URI objURI = EcoreUtil.getURI(obj);
						for (EObject ob : l) {
							URI obURI = EcoreUtil.getURI(ob);
							if (obURI != null && objURI != null) {
								if (EcoreUtil.getURI(ob).equals(EcoreUtil.getURI(obj))) {
									ret.add(ob);
								}
							}
							else {
								if (ob.equals(obj)) {
									ret.add(ob);
								}
							}
						}
					}
				}
			}
			else if (reference != null) {
				for (EObject o : l) {
					if (EcoreUtil.equals(o.eContainingFeature(), reference)) {
						ret.add(o);
					}
				}
			}
			int index = ModelManager.getRandomIndex(ret);
			if (index < ret.size()) {
				return ret.get(index);
			}
			else {
				return null;
			}
		}
	}
	
	@Override
	public List<EObject> getObjects() {
		List<EObject> l = new ArrayList<EObject>();
		if (type != null) {
			if (this.getModel() != null) {
				l.addAll(ModelManager.getObjectsOfType(type, this.getModel())); 
			}
			if (this.getModels() != null) {
				for (Resource resource : this.getModels()) {
					List<EObject> lr = ModelManager.getObjectsOfType(type, resource);
					for (EObject rob : lr) {
						if (!l.contains(rob)) {
							l.add(rob);
						}
					}
				}
			}
			if (excludedObjects != null) {
				ModelManager.removeEObjects(l, excludedObjects);
			}
			List<EObject> ret = new ArrayList<EObject>();
			if(l==null || l.size()==0) return ret;
			if ((container == null) && (reference == null)) {
				ret.addAll(l);
			}
			if ((container != null) && (reference != null)) {
				if (container.eGet(reference) instanceof List<?>) {
					List<EObject> objects = (List<EObject>) container.eGet(reference);
					for (EObject obj : objects) {
						URI objURI = EcoreUtil.getURI(obj);
						for (EObject ob : l) {
							URI obURI = EcoreUtil.getURI(ob);
							if (obURI != null && objURI != null) {
								if (EcoreUtil.getURI(ob).equals(EcoreUtil.getURI(obj))) {
									ret.add(ob);
								}
							}
							else {
								if (ob.equals(obj)) {
									ret.add(ob);
								}
							}
						}
					}
				}
				else {
					EObject obj = (EObject) container.eGet(reference);
					if (obj != null) {
						URI objURI = EcoreUtil.getURI(obj);
						for (EObject ob : l) {
							URI obURI = EcoreUtil.getURI(ob);
							if (obURI != null && objURI != null) {
								if (EcoreUtil.getURI(ob).equals(EcoreUtil.getURI(obj))) {
									ret.add(ob);
								}
							}
							else {
								if (ob.equals(obj)) {
									ret.add(ob);
								}
							}
						}
					}
				}
			}
			else if (reference != null) {
				for (EObject o : l) {
					if (EcoreUtil.equals(o.eContainingFeature(), reference)) {
						ret.add(o);
					}
				}
			}
			return ret;
		}
		else {
			if (this.getModel() != null) {
				for (String t : types) {
					l.addAll(ModelManager.getObjectsOfType(t, this.getModel()));
				}
			}
			if (this.getModels() != null) {
				for (Resource resource : this.getModels()) {
					for (String t : types) {
						List<EObject> lr = ModelManager.getObjectsOfType(t, resource);
						for (EObject rob : lr) {
							if (!l.contains(rob)) {
								l.add(rob);
							}
						}
					}
				}
			}
			if (excludedObjects != null) {
				ModelManager.removeEObjects(l, excludedObjects);
			}
			List<EObject> ret = new ArrayList<EObject>();
			if(l==null || l.size()==0) return ret;
			if ((container == null) && (reference == null)) {
				ret.addAll(l);
			}
			if ((container != null) && (reference != null)) {
				if (container.eGet(reference) instanceof List<?>) {
					List<EObject> objects = (List<EObject>) container.eGet(reference);
					for (EObject obj : objects) {
						URI objURI = EcoreUtil.getURI(obj);
						for (EObject ob : l) {
							URI obURI = EcoreUtil.getURI(ob);
							if (obURI != null && objURI != null) {
								if (EcoreUtil.getURI(ob).equals(EcoreUtil.getURI(obj))) {
									ret.add(ob);
								}
							}
							else {
								if (ob.equals(obj)) {
									ret.add(ob);
								}
							}
						}
					}
				}
				else {
					EObject obj = (EObject) container.eGet(reference);
					if (obj != null) {
						URI objURI = EcoreUtil.getURI(obj);
						for (EObject ob : l) {
							URI obURI = EcoreUtil.getURI(ob);
							if (obURI != null && objURI != null) {
								if (EcoreUtil.getURI(ob).equals(EcoreUtil.getURI(obj))) {
									ret.add(ob);
								}
							}
							else {
								if (ob.equals(obj)) {
									ret.add(ob);
								}
							}
						}
					}
				}
			}
			else if (reference != null) {
				for (EObject o : l) {
					if (EcoreUtil.equals(o.eContainingFeature(), reference)) {
						ret.add(o);
					}
				}
			}
			return ret;
		}
	}
}
