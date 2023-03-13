package wodel.utils.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import wodel.utils.manager.ModelManager;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.commands.selection.strategies.ObSelectionStrategy;
import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * SelectSampleMutator sample set object selection
 *  
 */

public class SelectSampleMutator extends Mutator {

	/**
	 * Object that will be selected
	 */
	private ObSelectionStrategy objectSelection;
	/**
	 * Reference we are going to select the object in
	 */
	private ObSelectionStrategy referenceSelection;
	
	/**
	 * Selected object
	 */
	private List<EObject> result;
	
	private EObject selectedObject;
	
	private boolean equals = false;
	
	private List<String> features = null;
	
	/**
	 * @param model
	 * @param metaModel
	 * @param referenceSelection
	 * @param containerSelection
	 * @param attributeConfig
	 * Normal constructor
	 */
	public SelectSampleMutator(Resource model, List<EPackage> metaModel,
			ObSelectionStrategy referenceSelection, ObSelectionStrategy object, EObject obj, boolean equals, List<String> features){
		super(model, metaModel, "SampleSelected");
		this.referenceSelection = referenceSelection;
		this.objectSelection = object;
		this.selectedObject = obj;
		this.equals = equals;
		this.features = features;
	}
	
	/**
	 * @param model
	 * @param metaModel
	 * @param referenceSelection
	 * @param containerSelection
	 * @param attributeConfig
	 * Normal constructor
	 */
	public SelectSampleMutator(Resource model, List<EPackage> metaModel,
			ObSelectionStrategy referenceSelection, ObSelectionStrategy object, boolean equals, List<String> features){
		super(model, metaModel, "SampleSelected");
		this.referenceSelection = referenceSelection;
		this.objectSelection = object;
		this.equals = equals;
		this.features = features;
	}
	
	private void selectSampleDifferentFeaturesOneObjectHelper(EClass eClass, LinkedHashMap<EStructuralFeature, HashMap<Object, List<EObject>>> classify, HashMap<EObject, List<EObject>> hmEObjects) {
		List<String> otherFeatures = null;
		for (String feature : features) {
			otherFeatures = new ArrayList<String>();
			otherFeatures.addAll(features);
			otherFeatures.remove(feature);
			for (EStructuralFeature feat : eClass.getEAllStructuralFeatures()) {
				if (feat.getName().equals(feature)) {
					for (Object key : classify.get(feat).keySet()) {
						HashMap<Object, List<EObject>> others = classify.get(feat);
						others.remove(key);
						List<EObject> lo = classify.get(feat).get(key);
						for (EObject o1 : lo) {
							List<EObject> sel = new ArrayList<EObject>();
							List<EObject> rej = new ArrayList<EObject>();
							List<EObject> lo1 = new ArrayList<EObject>();
							lo1.addAll(lo);
							lo1.remove(o1);
							rej.addAll(lo1);
							for (Object key1 : others.keySet()) {
								List<EObject> lo2 = others.get(key1);
								for (EObject o2 : lo2) {
									if (rej.contains(o2) != true) {
										for (String of : otherFeatures) {
											for (EStructuralFeature f2 : o2.eClass().getEAllStructuralFeatures()) {
												if (f2.getName().equals(of)) {
													if (o2.eGet(f2).equals(o1.eGet(f2))) {
														rej.add(o2);
													}
												}
											}
										}
										if (rej.contains(o2) != true) {
											sel.add(o2);
										}
									}
								}
							}
							hmEObjects.put(o1, sel);
						}
					}
				}
			}
		}
	}
	
	private void selectSampleEqualFeaturesOneObjectHelper(EClass eClass, LinkedHashMap<EStructuralFeature, HashMap<Object, List<EObject>>> classify, HashMap<EObject, List<EObject>> hmEObjects) {
		for (String feature : features) {
			for (EStructuralFeature feat : eClass.getEAllStructuralFeatures()) {
				if (feat.getName().equals(feature)) {
					Iterator<List<EObject>> iterator = classify.get(feat).values().iterator();
					while (iterator.hasNext()) {
						List<EObject> lo = iterator.next();
						List<EObject> sel = new ArrayList<EObject>();
						EObject o = lo.get(0);
						List<EObject> lo1 = new ArrayList<EObject>();
						lo1.addAll(lo);
						lo1.remove(o);
						hmEObjects.put(o, sel);
					}
				}
			}
		}
	}
	
	private static List<List<EObject>> getCombinations(List<List<EObject>> lists) {
		List<List<EObject>> combinations = new ArrayList<List<EObject>>();
		List<List<EObject>> newCombinations;

		int index = 0;

		// extract each of the integers in the first list
		// and add each to ints as a new list
		for(EObject o: lists.get(0)) {
			List<EObject> newList = new ArrayList<EObject>();
			newList.add(o);
			combinations.add(newList);
		}
		index++;
		while(index < lists.size()) {
			List<EObject> nextList = lists.get(index);
			newCombinations = new ArrayList<List<EObject>>();
			for(List<EObject> first: combinations) {
				for(EObject second: nextList) {
					List<EObject> newList = new ArrayList<EObject>();
					newList.addAll(first);
					newList.add(second);
					newCombinations.add(newList);
				}
			}
			combinations = newCombinations;

			index++;
		}

		return combinations;
	}

	private List<List<EObject>> selectSampleDifferentFeaturesObjectsHelper(EClass eClass, LinkedHashMap<EStructuralFeature, HashMap<Object, List<EObject>>> classify) {
		List<List<EObject>> combinations = new ArrayList<List<EObject>>();
		List<String> otherFeatures = null;
		for (String feature : features) {
			otherFeatures = new ArrayList<String>();
			otherFeatures.addAll(features);
			otherFeatures.remove(feature);
			for (EStructuralFeature feat : eClass.getEAllStructuralFeatures()) {
				if (feat.getName().equals(feature)) {
					List<List<EObject>> values = new ArrayList<List<EObject>>();
					for (Object key : classify.get(feat).keySet()) {
						values.add(classify.get(feat).get(key));
					}
					combinations.addAll(getCombinations(values));
				}
			}
		}
		return combinations;
	}
	
	private List<List<EObject>> selectSampleEqualFeaturesObjectsHelper(EClass eClass, LinkedHashMap<EStructuralFeature, HashMap<Object, List<EObject>>> classify, List<EObject> objects) {
		List<List<EObject>> combinations = new ArrayList<List<EObject>>();
		if (features.size() > 0) {
			for (String feature : features) {
				for (EStructuralFeature feat : eClass.getEAllStructuralFeatures()) {
					if (feat.getName().equals(feature)) {
						Iterator<List<EObject>> iterator = classify.get(feat).values().iterator();
						while (iterator.hasNext()) {
							List<EObject> lo = iterator.next();
							//List<EObject> sel = new ArrayList<EObject>();
							List<EObject> sel = new ArrayList<EObject>();
							EObject o = lo.get(0);
							List<EObject> lo1 = new ArrayList<EObject>();
							lo1.addAll(lo);
							lo1.remove(o);
							sel.add(o);
							combinations.add(sel);
						}
					}
				}
			}
		}
		else {
			List<EObject> sel = new ArrayList<EObject>();
			sel.addAll(objects.subList(1, objects.size() -1));
			sel.add(objects.get(0));
			combinations.add(sel);
		}
		return combinations;
	}
	
	private List<List<EObject>> getCandidates(List<List<EObject>> combinations) {
		List<List<EObject>> candidates = new ArrayList<List<EObject>>();
		List<List<EObject>> maxCandidates = new ArrayList<List<EObject>>();
		candidates.addAll(combinations);
		if (candidates.size() > 0) {
			candidates.sort((candidate1, candidate2) -> candidate2.size() - candidate1.size());
			int size = candidates.get(0).size();
			for (List<EObject> candidate : candidates) {
				if (candidate.size() == size) {
					maxCandidates.add(candidate);
				}
			}
		}
		return maxCandidates;
	}
	
	public Object mutate() throws ReferenceNonExistingException, WrongAttributeTypeException, AbstractCreationException, ObjectNotContainedException {		

		if (objectSelection == null && selectedObject == null) {
			return null;
		}
		EObject object = null;
		List<EObject> objects = null;
		if (objectSelection != null) {
		 object = objectSelection.getObject();
			if (object == null) {
				objects = objectSelection.getObjects();
			}
		}
		if (selectedObject != null) {
			object = selectedObject;
		}
		//We select the containers of the new Object
		EReference reference = null;
		if (referenceSelection != null) {
			reference = (EReference) referenceSelection.getObject();
		}
		//only one object
		if (object != null) {
			if (reference != null) {
				for (EReference ref : object.eClass().getEAllReferences()) {
					if (ref.getName().equals(reference.getName())) {
						if (object.eGet(ref) instanceof EObject) {
							if (result == null) {
								result = new ArrayList<EObject>();
							}
							result.add((EObject) object.eGet(ref));
						}
						else {
							if (result == null) {
								result = new ArrayList<EObject>();
							}
							List<EObject> selected = (List<EObject>) object.eGet(ref);
							if (selected.size() > 0) {
								EClass eClass = selected.get(0).eClass();
								LinkedHashMap<EStructuralFeature, HashMap<Object, List<EObject>>> classify = new LinkedHashMap<EStructuralFeature, HashMap<Object, List<EObject>>>();
								if (features.size() > 0) {
									for (String feature : features) {
										for (EStructuralFeature feat : eClass.getEAllStructuralFeatures()) {
											if (feat.getName().equals(feature)) {
												for (EObject sel : selected) {
													Object value = sel.eGet(feat);
													HashMap<Object, List<EObject>> sameValue = null;
													if (classify.get(feat) == null) {
														sameValue = new HashMap<Object, List<EObject>>();
													}
													else {
														sameValue = classify.get(feat);
													}
													List<EObject> objs = null;
													if (sameValue.get(value) == null) {
														objs = new ArrayList<EObject>();
													}
													else {
														objs = sameValue.get(value);
													}
													objs.add(sel);
													sameValue.put(value, objs);
													classify.put(feat, sameValue);
												}
											}
										}
									}
									HashMap<EObject, List<EObject>> hmEObjects = new HashMap<EObject, List<EObject>>();
									List<EObject> listObjects = null;
									//distinct
									if (equals == false) {
										selectSampleDifferentFeaturesOneObjectHelper(eClass, classify, hmEObjects);
									}
									//equals
									if (equals == true) {
										selectSampleEqualFeaturesOneObjectHelper(eClass, classify, hmEObjects);
									}
									EObject key = null;
									for (EObject o1 : hmEObjects.keySet()) {
										if (key == null) {
											key = o1;
										}
										else {
											if (hmEObjects.get(o1).size() > hmEObjects.get(key).size()) {
												key = o1;
											}
										}
									}
									listObjects = new ArrayList<EObject>();
									listObjects.add(key);
									listObjects.addAll(hmEObjects.get(key));
									result.addAll(listObjects);
								}
								else {
									Object value = object.eGet(ref);
									if (value != null) {
										if (value instanceof EObject) {
											result.add((EObject) value);
										}
										if (value instanceof List<?>) {
											result.addAll((List<EObject>)value);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		// a list of objects
		if (objects != null) {
			List<EObject> selected = objects;
			if (selected.size() > 1) {
				EClass eClass = selected.get(0).eClass();
				LinkedHashMap<EStructuralFeature, HashMap<Object, List<EObject>>> classify = new LinkedHashMap<EStructuralFeature, HashMap<Object, List<EObject>>>();
				for (String feature : features) {
					for (EStructuralFeature feat : eClass.getEAllStructuralFeatures()) {
						if (feat.getName().equals(feature)) {
							for (EObject sel : selected) {
								Object value = sel.eGet(feat);
								HashMap<Object, List<EObject>> sameValue = null;
								if (classify.get(feat) == null) {
									sameValue = new HashMap<Object, List<EObject>>();
								}
								else {
									sameValue = classify.get(feat);
								}
								List<EObject> objs = null;
								if (sameValue.get(value) == null) {
									objs = new ArrayList<EObject>();
								}
								else {
									objs = sameValue.get(value);
								}
								objs.add(sel);
								sameValue.put(value, objs);
								classify.put(feat, sameValue);
							}
						}
					}
				}
				List<List<EObject>> combinations = null;
				//distinct
				if (equals == false) {
					combinations = selectSampleDifferentFeaturesObjectsHelper(eClass, classify);
				}
				//equals
				if (equals == true) {
					combinations = selectSampleEqualFeaturesObjectsHelper(eClass, classify, objects);
				}
				List<List<EObject>> candidates = getCandidates(combinations);
				if (candidates.size() > 0) {
					result = candidates.get(ModelManager.getRandomIndex(candidates));
				}
			}
			else {
				result = selected;
			}
		}
		
		return this.result;
	}

	//GETTERS AND SETTERS
	public List<EObject> getObjects() {
		return result;
	}
	//END GETTERS AND SETTERS
}
