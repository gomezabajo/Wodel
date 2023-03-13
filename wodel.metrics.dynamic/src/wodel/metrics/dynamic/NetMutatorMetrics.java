package wodel.metrics.dynamic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.manager.DynamicMutatorMetrics;
import wodel.utils.manager.ModelManager;

/**
 * @author Pablo Gomez-Abajo
 * 
 * NetMutatorMetrics net dynamic footprints
 * 
 */
public class NetMutatorMetrics extends DynamicMutatorMetrics {

	public static WodelMetricClassifier[] createWodelDynamicMetrics(String metricsmodel, List<EPackage> metricspackages, List<EPackage> packages) {
		WodelMetricClassifier[] classifier = null;
		try {
			Resource resource = ModelManager.loadModel(metricspackages, URI.createURI(metricsmodel).toFileString());
			EObject root = ModelManager.getRoot(resource);
			ArrayList<WodelMetricItem> metricItems = new ArrayList<WodelMetricItem>();
			LinkedHashMap<String, WodelMetricClass> classMetrics = new LinkedHashMap<String, WodelMetricClass>();
			for (EObject tree : ModelManager.getReferences("trees", root)) {
				WodelMetricItem metric = dynamicMetricHelper(tree, packages);
				for (WodelMetricClass metricCl : metric.getClasses()) {
					if (classMetrics.containsKey(metricCl.getName()) == false) {
						WodelMetricClass metricClass = new WodelMetricClass();
						metricClass.setEClass(metricCl.getEClass());
						metricClass.creation = metricCl.creation;
						metricClass.modification = metricCl.modification;
						metricClass.deletion = metricCl.deletion;
						metricClass.ccreation = metricCl.ccreation;
						metricClass.cmodification = metricCl.cmodification;
						metricClass.cdeletion = metricCl.cdeletion;
						for (WodelMetricAttribute metAtt : metricCl.getAttributes()) {
							WodelMetricAttribute metricAttribute = null;
							if (metricClass.getAttributeByName(metAtt.getName()) != null) {
								metricAttribute = metricClass.getAttributeByName(metAtt.getName());
							}
							else {
								metricAttribute = new WodelMetricAttribute();
								metricAttribute.setEAttribute(metAtt.getEAttribute());
								metricClass.addAttribute(metricAttribute);
							}
							metricAttribute.creation += metAtt.creation;
							metricAttribute.modification += metAtt.modification;
							metricAttribute.deletion += metAtt.deletion;
							metricAttribute.ccreation += metAtt.ccreation;
							metricAttribute.cmodification += metAtt.cmodification;
							metricAttribute.cdeletion += metAtt.cdeletion;
						}
						for (WodelMetricReference metRef : metricCl.getReferences()) {
							WodelMetricReference metricReference = null;
							if (metricClass.getReferenceByName(metRef.getName()) != null) {
								metricReference = metricClass.getReferenceByName(metRef.getName());
							}
							else {
								metricReference = new WodelMetricReference();
								metricReference.setEReference(metRef.getEReference());
								metricClass.addReference(metricReference);
							}
							metricReference.creation += metRef.creation;
							metricReference.modification += metRef.modification;
							metricReference.deletion += metRef.deletion;
							metricReference.ccreation += metRef.ccreation;
							metricReference.cmodification += metRef.cmodification;
							metricReference.cdeletion += metRef.cdeletion;
						}
						classMetrics.put(metricCl.getName(), metricClass);
					}
					else {
						WodelMetricClass metricClass = classMetrics.get(metricCl.getName());
						metricClass.creation += metricCl.creation;
						metricClass.modification += metricCl.modification;
						metricClass.deletion += metricCl.deletion;
						metricClass.ccreation += metricCl.ccreation;
						metricClass.cmodification += metricCl.cmodification;
						metricClass.cdeletion += metricCl.cdeletion;
						for (WodelMetricAttribute metAtt : metricCl.getAttributes()) {
							WodelMetricAttribute metricAttribute = null;
							if (metricClass.getAttributeByName(metAtt.getName()) != null) {
								metricAttribute = metricClass.getAttributeByName(metAtt.getName());
							}
							else {
								metricAttribute = new WodelMetricAttribute();
								metricAttribute.setEAttribute(metAtt.getEAttribute());
								metricClass.addAttribute(metricAttribute);
							}
							metricAttribute.creation += metAtt.creation;
							metricAttribute.modification += metAtt.modification;
							metricAttribute.deletion += metAtt.deletion;
							metricAttribute.ccreation += metAtt.ccreation;
							metricAttribute.cmodification += metAtt.cmodification;
							metricAttribute.cdeletion += metAtt.cdeletion;
						}
						for (WodelMetricReference metRef : metricCl.getReferences()) {
							WodelMetricReference metricReference = null;
							if (metricClass.getReferenceByName(metRef.getName()) != null) {
								metricReference = metricClass.getReferenceByName(metRef.getName());
							}
							else {
								metricReference = new WodelMetricReference();
								metricReference.setEReference(metRef.getEReference());
								metricClass.addReference(metricReference);
							}
							metricReference.creation += metRef.creation;
							metricReference.modification += metRef.modification;
							metricReference.deletion += metRef.deletion;
							metricReference.ccreation += metRef.ccreation;
							metricReference.cmodification += metRef.cmodification;
							metricReference.cdeletion += metRef.cdeletion;
						}
						classMetrics.put(metricCl.getName(), metricClass);
					}
				}
				metricItems.add(metric);
			}
			ArrayList<WodelMetricClass> metricClasses = new ArrayList<WodelMetricClass>();
			for (String className : classMetrics.keySet()) {
				metricClasses.add(classMetrics.get(className));
			}
			WodelMetricModel metricRoot = new WodelMetricModel("root", "/");
			metricRoot.addChildren(metricItems);
			metricRoot.addClasses(metricClasses);
			ArrayList<WodelMetric> metrics = new ArrayList<WodelMetric>();
			metrics.add(metricRoot);
			classifier = metricRoot.getClassifiers();
			return classifier;
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public static WodelMetricClassifier[] createWodelDynamicMetrics(List<String> metricsmodels, List<EPackage> metricspackages, List<EPackage> packages) {
		WodelMetricClassifier[] classifier = null;
		try {
			List<WodelMetricItem> metricItems = new ArrayList<WodelMetricItem>();
			LinkedHashMap<String, WodelMetricClass> classMetrics = new LinkedHashMap<String, WodelMetricClass>();
			List<WodelMetricClass> metricClasses = new ArrayList<WodelMetricClass>();
			for (String metricsmodel : metricsmodels) {
				Resource resource = ModelManager.loadModel(metricspackages, metricsmodel);
				EObject root = ModelManager.getRoot(resource);
				for (EObject tree : ModelManager.getReferences("trees", root)) {
					WodelMetricItem metric = dynamicMetricHelper(tree, packages);
					for (WodelMetricClass metricCl : metric.getClasses()) {
						if (classMetrics.containsKey(metricCl.getName()) == false) {
							WodelMetricClass metricClass = new WodelMetricClass();
							metricClass.setEClass(metricCl.getEClass());
							metricClass.creation = metricCl.creation;
							metricClass.modification = metricCl.modification;
							metricClass.deletion = metricCl.deletion;
							metricClass.ccreation = metricCl.ccreation;
							metricClass.cmodification = metricCl.cmodification;
							metricClass.cdeletion = metricCl.cdeletion;
							for (WodelMetricAttribute metAtt : metricCl.getAttributes()) {
								WodelMetricAttribute metricAttribute = null;
								if (metricClass.getAttributeByName(metAtt.getName()) != null) {
									metricAttribute = metricClass.getAttributeByName(metAtt.getName());
								}
								else {
									metricAttribute = new WodelMetricAttribute();
									metricAttribute.setEAttribute(metAtt.getEAttribute());
									metricClass.addAttribute(metricAttribute);
								}
								metricAttribute.creation += metAtt.creation;
								metricAttribute.modification += metAtt.modification;
								metricAttribute.deletion += metAtt.deletion;
								metricAttribute.ccreation += metAtt.ccreation;
								metricAttribute.cmodification += metAtt.cmodification;
								metricAttribute.cdeletion += metAtt.cdeletion;
							}
							for (WodelMetricReference metRef : metricCl.getReferences()) {
								WodelMetricReference metricReference = null;
								if (metricClass.getReferenceByName(metRef.getName()) != null) {
									metricReference = metricClass.getReferenceByName(metRef.getName());
								}
								else {
									metricReference = new WodelMetricReference();
									metricReference.setEReference(metRef.getEReference());
									metricClass.addReference(metricReference);
								}
								metricReference.creation += metRef.creation;
								metricReference.modification += metRef.modification;
								metricReference.deletion += metRef.deletion;
								metricReference.ccreation += metRef.ccreation;
								metricReference.cmodification += metRef.cmodification;
								metricReference.cdeletion += metRef.cdeletion;
							}
							classMetrics.put(metricCl.getName(), metricClass);
						}
						else {
							WodelMetricClass metricClass = classMetrics.get(metricCl.getName());
							metricClass.creation += metricCl.creation;
							metricClass.modification += metricCl.modification;
							metricClass.deletion += metricCl.deletion;
							metricClass.ccreation += metricCl.ccreation;
							metricClass.cmodification += metricCl.cmodification;
							metricClass.cdeletion += metricCl.cdeletion;
							for (WodelMetricAttribute metAtt : metricCl.getAttributes()) {
								WodelMetricAttribute metricAttribute = null;
								if (metricClass.getAttributeByName(metAtt.getName()) != null) {
									metricAttribute = metricClass.getAttributeByName(metAtt.getName());
								}
								else {
									metricAttribute = new WodelMetricAttribute();
									metricAttribute.setEAttribute(metAtt.getEAttribute());
									metricClass.addAttribute(metricAttribute);
								}
								metricAttribute.creation += metAtt.creation;
								metricAttribute.modification += metAtt.modification;
								metricAttribute.deletion += metAtt.deletion;
								metricAttribute.ccreation += metAtt.ccreation;
								metricAttribute.cmodification += metAtt.cmodification;
								metricAttribute.cdeletion += metAtt.cdeletion;
							}
							for (WodelMetricReference metRef : metricCl.getReferences()) {
								WodelMetricReference metricReference = null;
								if (metricClass.getReferenceByName(metRef.getName()) != null) {
									metricReference = metricClass.getReferenceByName(metRef.getName());
								}
								else {
									metricReference = new WodelMetricReference();
									metricReference.setEReference(metRef.getEReference());
									metricClass.addReference(metricReference);
								}
								metricReference.creation += metRef.creation;
								metricReference.modification += metRef.modification;
								metricReference.deletion += metRef.deletion;
								metricReference.ccreation += metRef.ccreation;
								metricReference.cmodification += metRef.cmodification;
								metricReference.cdeletion += metRef.cdeletion;
							}
							classMetrics.put(metricCl.getName(), metricClass);
						}
					}
					WodelMetricItem previous = null;
					for (WodelMetricItem item : metricItems) {
						if (item.getName().equals(metric.getName())) {
							previous = item;
						}
					}
					if (previous == null) {
						metricItems.add(metric);
					}
					else {
						for (WodelMetricItem currentItem : metric.getChildren()) {
							boolean exists = false;
							for (WodelMetricItem metricItem : previous.getChildren()) {
								if (metricItem.getName().equals(currentItem.getName())) {
									exists = true;
									break;
								}
							}
							if (!exists) {
								previous.addChild(currentItem);
								previous.creation += currentItem.creation;
								previous.modification += currentItem.modification;
								previous.deletion += currentItem.deletion;
								previous.ccreation += currentItem.ccreation;
								previous.cmodification += currentItem.cmodification;
								previous.cdeletion += currentItem.cdeletion;
								for (WodelMetricClass previousClass : previous.getClasses()) {
									for (WodelMetricClass currentClass : currentItem.getClasses()) {
										if (previousClass.getName().equals(currentClass.getName())) {
											previousClass.creation += currentClass.creation;
											previousClass.modification += currentClass.modification;
											previousClass.deletion += currentClass.deletion;
											previousClass.ccreation += currentClass.ccreation;
											previousClass.cmodification += currentClass.cmodification;
											previousClass.cdeletion += currentClass.cdeletion;
											for (WodelMetricAttribute metAtt : currentClass.getAttributes()) {
												WodelMetricAttribute metricAttribute = null;
												if (previousClass.getAttributeByName(metAtt.getName()) != null) {
													metricAttribute = previousClass.getAttributeByName(metAtt.getName());
												}
												else {
													metricAttribute = new WodelMetricAttribute();
													metricAttribute.setEAttribute(metAtt.getEAttribute());
													previousClass.addAttribute(metricAttribute);
												}
												metricAttribute.creation += metAtt.creation;
												metricAttribute.modification += metAtt.modification;
												metricAttribute.deletion += metAtt.deletion;
												metricAttribute.ccreation += metAtt.ccreation;
												metricAttribute.cmodification += metAtt.cmodification;
												metricAttribute.cdeletion += metAtt.cdeletion;
											}
											for (WodelMetricReference metRef : currentClass.getReferences()) {
												WodelMetricReference metricReference = null;
												if (previousClass.getReferenceByName(metRef.getName()) != null) {
													metricReference = previousClass.getReferenceByName(metRef.getName());
												}
												else {
													metricReference = new WodelMetricReference();
													metricReference.setEReference(metRef.getEReference());
													previousClass.addReference(metricReference);
												}
												metricReference.creation += metRef.creation;
												metricReference.modification += metRef.modification;
												metricReference.deletion += metRef.deletion;
												metricReference.ccreation += metRef.ccreation;
												metricReference.cmodification += metRef.cmodification;
												metricReference.cdeletion += metRef.cdeletion;
											}
										}
									}
								}
							}
						}
					}
				}
			}
			for (String className : classMetrics.keySet()) {
				metricClasses.add(classMetrics.get(className));
			}
			WodelMetricModel metricRoot = new WodelMetricModel("root", "/");
			metricRoot.addChildren(metricItems);
			metricRoot.addClasses(metricClasses);
			ArrayList<WodelMetric> metrics = new ArrayList<WodelMetric>();
			metrics.add(metricRoot);
			classifier = metricRoot.getClassifiers();
			return classifier;
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}

