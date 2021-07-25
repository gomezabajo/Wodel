package manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class EMFCopier {
	
	private static EObject createEObject(EPackage pck, String className) {
		EClass eClass = null;
		List<EClassifier> classifiers = pck.getEClassifiers();
		for (EClassifier classifier : classifiers) {
			if (classifier instanceof EClass) {
				EClass eClazz = (EClass) classifier;
				if (eClazz.getName().equals(className)) {
					eClass = eClazz;
					break;
				}
			}
		}
		if (eClass == null) {
			return null;
		}
		return EcoreUtil.create(eClass);
	}
	
	public static void getContainedEObjects(List<EObject> objects, List<EObject> contained) {
		if (contained == null) {
			return;
		}
		// contained objects
		for (EObject object : objects) {
			if (!contained.contains(object)) {
				contained.add(object);
			}
			Object value = null;
			for (EReference ref : object.eClass().getEAllReferences()) {
				if ((value = object.eGet(ref)) != null) {
					if (ref.isContainment()) {
						List<EObject> list = new ArrayList<EObject>();
						if (ref.isMany()) {
							list.addAll((EList<EObject>) value);
						}
						else {
							list.add((EObject) value);
						}
						if (list.size() > 0) {
							getContainedEObjects(list, contained);
						}
					}
				}
			}
		}
	}

	
	public static EObject process (Resource model, EObject object) {
		EObject processed = createEObject(object.eClass().getEPackage(), object.eClass().getName());
		Object value = null;
		for (EAttribute att : object.eClass().getEAllAttributes()) {
			if ((value = object.eGet(att)) != null) {
				if (att.isMany()) {
					for (Object elem : (EList<?>)value) { 
						EMFUtils.setAttribute(object.eClass().getEPackage(), processed, att.getName(), elem.toString());
					}
				}
				else EMFUtils.setAttribute(object.eClass().getEPackage(), processed, att.getName(), value.toString());
			}
		}

		// reference clones
		for (EReference ref : object.eClass().getEAllReferences()) {
			if ((value = object.eGet(ref)) != null) {
				if (ref.isContainment()) {
					if (ref.isMany()) {
						EObject found = ModelManager.getObject(model, object);
						if (found != null) {
							value = found.eGet(ref);
						}
						List<EObject> list = (List<EObject>) processed.eGet(ref);
						list.clear();
						list.addAll((EList<EObject>) value);
					}
					else {
						EObject found = ModelManager.getObject(model, (EObject) value);
						if (found == null) {
							found = (EObject) value;
						}
						EMFUtils.setReference(object.eClass().getEPackage(), processed, ref.getName(), found);
					}
				}
				else {
					if (ref.isMany()) {
						EObject found = ModelManager.getObject(model, object);
						if (found != null) {
							value = found.eGet(ref);
						}
						List<EObject> list = (List<EObject>) processed.eGet(ref);
						list.clear();
						list.addAll((EList<EObject>) value);
					}
					else {
						EObject found = ModelManager.getObject(model, (EObject) value);
						if (found == null) {
							found = (EObject) value;
						}
						EMFUtils.setReference(object.eClass().getEPackage(), processed, ref.getName(), found);
					}
				}
			}
		}
		return processed;
	}
	

	public static EObject clone (EObject source) {
		Map<EObject, EObject> objectclones = new HashMap<EObject, EObject>();
		EObject target = null;
		Object value = null;

		List<EObject> containedobjects = new ArrayList<EObject>();
		List<EObject> list = new ArrayList<EObject>();
		list.add(source);
		getContainedEObjects(list, containedobjects);
		
		// object clones
		for (EObject object : containedobjects) {
			EObject clone  = createEObject(object.eClass().getEPackage(), object.eClass().getName());
			objectclones.put(object, clone);
			if (source.equals(object)) {
				target = clone;
			}
		}
		
		for (EObject object : objectclones.keySet()) {
			// attribute clones
			for (EAttribute att : object.eClass().getEAllAttributes()) {
				if ((value = object.eGet(att)) != null) {
					if (att.isMany()) {
						for (Object elem : (EList<?>)value) { 
							EMFUtils.setAttribute(object.eClass().getEPackage(), objectclones.get(object), att.getName(), elem.toString());
						}
					}
					else EMFUtils.setAttribute(object.eClass().getEPackage(), objectclones.get(object), att.getName(), value.toString());
				}
			}
		
			// reference clones
			for (EReference ref : object.eClass().getEAllReferences()) {
				if (ref.isChangeable()) {
					if ((value = object.eGet(ref)) != null) {
						if (ref.isContainment()) {
							if (ref.isMany()) {
								List<EObject> elems = new ArrayList<EObject>();
								elems.addAll((EList<EObject>) value);
								for (EObject elem : elems) {
									if (objectclones.get(elem) != null) {
										EMFUtils.setReference(object.eClass().getEPackage(), objectclones.get(object), ref.getName(), objectclones.get(elem));
									}
									else {
										EMFUtils.setReference(object.eClass().getEPackage(), objectclones.get(object), ref.getName(), elem);
									}
								}
							}
							else if (objectclones.get((EObject) value) != null) {
								EMFUtils.setReference(object.eClass().getEPackage(), objectclones.get(object), ref.getName(), objectclones.get((EObject) value));
							}
							else {
								EMFUtils.setReference(object.eClass().getEPackage(), objectclones.get(object), ref.getName(), (EObject) value);
							}
						}
						else if (ref.getEOpposite() == null) {
							if (ref.isMany()) {
								List<EObject> elems = new ArrayList<EObject>();
								elems.addAll((EList<EObject>) value);
								for (EObject elem : elems) {
									((List<EObject>) objectclones.get(object).eGet(ref)).add(elem);
								}
							}
							else {
								EMFUtils.setReference(object.eClass().getEPackage(), objectclones.get(object), ref.getName(), (EObject) value);
							}
						}
						else if (value instanceof EObject) { 
							if (objectclones.get((EObject) value) != null) {
								if (ref.getEOpposite().isChangeable()) {
									if (ref.getEOpposite().isMany()) {
										((List<EObject>) objectclones.get((EObject) value).eGet(ref.getEOpposite())).add(objectclones.get(object));
									}
									else {
										EMFUtils.setReference(object.eClass().getEPackage(), objectclones.get((EObject) value), ref.getEOpposite().getName(), objectclones.get(object));
									}
								}
							}
							else if (ref.getEOpposite().isChangeable()) {
								if (ref.getEOpposite().isMany()) {
									((List<EObject>) ((EObject) value).eGet(ref.getEOpposite())).add(objectclones.get(object));
								}
							}
						}
					}
				}
			}
		}

		return target;
	}
	
	public static List<EObject> clone (Resource model) {
		Map<EObject, EObject> objectclones = new HashMap<>();
		List<EObject> rootobjects = new ArrayList<>();
		Object value;

		// object clones
		Iterator<EObject> it = model.getAllContents();
		while (it.hasNext()) { 
			EObject object = it.next();
			EObject clone  = createEObject(object.eClass().getEPackage(), object.eClass().getName());
			objectclones.put(object, clone);
			if (model.getContents().contains(object))
				rootobjects.add(clone);
		}		

		for (EObject object : objectclones.keySet()) {
			// attribute clones
			for (EAttribute att : object.eClass().getEAllAttributes()) {
				if ((value = object.eGet(att)) != null) {
					if (att.isMany()) {
						for (Object elem : (EList<?>)value) { 
							EMFUtils.setAttribute(object.eClass().getEPackage(), objectclones.get(object), att.getName(), elem.toString());
						}
					}
					else EMFUtils.setAttribute(object.eClass().getEPackage(), objectclones.get(object), att.getName(), value.toString());
				}
			}

			// reference clones
			for (EReference ref : object.eClass().getEAllReferences()) {
				if ((value = object.eGet(ref)) != null) {
					if (ref.isMany()) {
						for (EObject elem : (EList<EObject>)value) {
							EMFUtils.setReference(object.eClass().getEPackage(), objectclones.get(object), ref.getName(), objectclones.get(elem));
						}
					}
					else EMFUtils.setReference(object.eClass().getEPackage(), objectclones.get(object), ref.getName(), objectclones.get(value));
				}
			}
		}

		return rootobjects;
	}	

	public static List<EObject> clone (Resource model, EObject[] cloned) {
		Map<EObject, EObject> objectclones = new HashMap<EObject, EObject>();
		List<EObject> rootobjects = new ArrayList<EObject>();
		Object value = null;

		// object clones
		Iterator<EObject> it = model.getAllContents();
		while (it.hasNext()) { 
			EObject object = it.next();
			EObject clone  = createEObject(object.eClass().getEPackage(), object.eClass().getName());
			if (object.equals(cloned[0])) {
				cloned[0] = clone;
			}
			objectclones.put(object, clone);
			if (model.getContents().contains(object))
				rootobjects.add(clone);
		}		

		for (EObject object : objectclones.keySet()) {
			// attribute clones
			for (EAttribute att : object.eClass().getEAllAttributes()) {
				if ((value = object.eGet(att)) != null) {
					if (att.isMany()) {
						for (Object elem : (EList<?>)value) { 
							EMFUtils.setAttribute(object.eClass().getEPackage(), objectclones.get(object), att.getName(), elem.toString());
						}
					}
					else EMFUtils.setAttribute(object.eClass().getEPackage(), objectclones.get(object), att.getName(), value.toString());
				}
			}

			// reference clones
			for (EReference ref : object.eClass().getEAllReferences()) {
				if ((value = object.eGet(ref)) != null) {
					if (ref.isMany()) {
						for (EObject elem : (EList<EObject>)value) {
							EMFUtils.setReference(object.eClass().getEPackage(), objectclones.get(object), ref.getName(), objectclones.get(elem));
						}
					}
					else EMFUtils.setReference(object.eClass().getEPackage(), objectclones.get(object), ref.getName(), objectclones.get(value));
				}
			}
		}

		return rootobjects;
	}	


	public static List<EObject> copy(Resource model) {
		Collection<EObject> copies = new ArrayList<EObject>();
		EcoreUtil.Copier copier = new EcoreUtil.Copier();
		copies = copier.copyAll(model.getContents());
		copier.copyReferences();
		List<EObject> rootobjects = new ArrayList<EObject>();
		rootobjects.addAll(copies);
		return rootobjects;
	}
	
	public static Resource copyResource(Resource model) {
		Resource copy = ModelManager.createModel(model.getURI().toString());
		List<EObject> copied = copy(model);
		copy.getContents().addAll(copied);
		return copy;
	}
	
	public static List<EObject> clone (List<EObject> objects) {
		List<EObject> cloned = new ArrayList<EObject>();
		for (EObject object : objects) {
			cloned.add(EMFCopier.clone(object));
		}
		return cloned;
	}
}
