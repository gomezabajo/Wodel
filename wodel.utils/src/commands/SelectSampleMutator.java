package commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import manager.ModelManager;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import commands.selection.strategies.ObSelectionStrategy;
import exceptions.AbstractCreationException;
import exceptions.ObjectNotContainedException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

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
	public SelectSampleMutator(Resource model, ArrayList<EPackage> metaModel,
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
	public SelectSampleMutator(Resource model, ArrayList<EPackage> metaModel,
			ObSelectionStrategy referenceSelection, ObSelectionStrategy object, boolean equals, List<String> features){
		super(model, metaModel, "SampleSelected");
		this.referenceSelection = referenceSelection;
		this.objectSelection = object;
		this.equals = equals;
		this.features = features;
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
								//equals
								if (equals == true) {
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
						}
					}
				}
			}
		}
		if (objects != null) {
			List<EObject> selected = objects;
			if (selected.size() > 0) {
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
				HashMap<EObject, List<EObject>> hmEObjects = new HashMap<EObject, List<EObject>>();
				//distinct
				if (equals == false) {
					List<String> otherFeatures = null;
					for (String feature : features) {
						otherFeatures = new ArrayList<String>();
						otherFeatures.addAll(features);
						otherFeatures.remove(feature);
						for (EStructuralFeature feat : eClass.getEAllStructuralFeatures()) {
							if (feat.getName().equals(feature)) {
								for (Object key : classify.get(feat).keySet()) {
									HashMap<Object, List<EObject>> others = (HashMap<Object, List<EObject>>) classify.get(feat).clone();
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
											if (lo2.size() > 0) {
												EObject o2 = lo2.get(ModelManager.getRandomIndex(lo2));
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
													if (sel.contains(o2) != true) {
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
				//equals
				if (equals == true) {
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
				Map<EObject, List<EObject>> sorted = hmEObjects.entrySet().stream()
				        .sorted(comparingInt(e->e.getValue().size()))
				        .collect(toMap(
				                Map.Entry::getKey,
				                Map.Entry::getValue,
				                (a,b) -> {throw new AssertionError();},
				                LinkedHashMap::new
				        )); 

				List<List<EObject>> candidates = new ArrayList<List<EObject>>();
				ListIterator<EObject> iter = new ArrayList<>(sorted.keySet()).listIterator(sorted.size());

				int max = Integer.MIN_VALUE;
				while (iter.hasPrevious()) {
					if (max == Integer.MIN_VALUE) {
						EObject previous = iter.previous();
						max = sorted.get(previous).size();
						List<EObject> candidate = new ArrayList<EObject>();
						candidate.add(previous);
						candidate.addAll(sorted.get(previous));
						candidates.add(candidate);
					}
					else {
						EObject previous = iter.previous();
						if (sorted.get(previous).size() == max) {
							List<EObject> candidate = new ArrayList<EObject>();
							candidate.add(previous);
							candidate.addAll(sorted.get(previous));
							candidates.add(candidate);
						}
					}
				}
				result = candidates.get(ModelManager.getRandomIndex(candidates));
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
