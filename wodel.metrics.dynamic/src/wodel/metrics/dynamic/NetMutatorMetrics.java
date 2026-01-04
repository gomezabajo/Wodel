package wodel.metrics.dynamic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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

	// ---------------------------------------------------------------------
	// Helper methods to reduce duplication
	// ---------------------------------------------------------------------

	private static void accumulateAttributeMetrics(WodelMetricClass targetClass,
			WodelMetricAttribute sourceAttr) {
		WodelMetricAttribute metricAttribute = targetClass.getAttributeByName(sourceAttr.getName());
		if (metricAttribute == null) {
			metricAttribute = new WodelMetricAttribute();
			metricAttribute.setEAttribute(sourceAttr.getEAttribute());
			targetClass.addAttribute(metricAttribute);
		}
		metricAttribute.creation += sourceAttr.creation;
		metricAttribute.modification += sourceAttr.modification;
		metricAttribute.deletion += sourceAttr.deletion;
		metricAttribute.ccreation += sourceAttr.ccreation;
		metricAttribute.cmodification += sourceAttr.cmodification;
		metricAttribute.cdeletion += sourceAttr.cdeletion;
	}

	private static void accumulateReferenceMetrics(WodelMetricClass targetClass,
			WodelMetricReference sourceRef) {
		WodelMetricReference metricReference = targetClass.getReferenceByName(sourceRef.getName());
		if (metricReference == null) {
			metricReference = new WodelMetricReference();
			metricReference.setEReference(sourceRef.getEReference());
			targetClass.addReference(metricReference);
		}
		metricReference.creation += sourceRef.creation;
		metricReference.modification += sourceRef.modification;
		metricReference.deletion += sourceRef.deletion;
		metricReference.ccreation += sourceRef.ccreation;
		metricReference.cmodification += sourceRef.cmodification;
		metricReference.cdeletion += sourceRef.cdeletion;
	}

	private static void accumulateClassMetrics(WodelMetricClass sourceClass,
			LinkedHashMap<String, WodelMetricClass> classMetrics) {

		WodelMetricClass metricClass = classMetrics.get(sourceClass.getName());
		if (metricClass == null) {
			metricClass = new WodelMetricClass();
			metricClass.setEClass(sourceClass.getEClass());
			classMetrics.put(sourceClass.getName(), metricClass);
		}

		// Aggregate global class metrics
		metricClass.creation += sourceClass.creation;
		metricClass.modification += sourceClass.modification;
		metricClass.deletion += sourceClass.deletion;
		metricClass.ccreation += sourceClass.ccreation;
		metricClass.cmodification += sourceClass.cmodification;
		metricClass.cdeletion += sourceClass.cdeletion;

		// Aggregate attributes
		for (WodelMetricAttribute metAtt : sourceClass.getAttributes()) {
			accumulateAttributeMetrics(metricClass, metAtt);
		}

		// Aggregate references
		for (WodelMetricReference metRef : sourceClass.getReferences()) {
			accumulateReferenceMetrics(metricClass, metRef);
		}
	}

	// ---------------------------------------------------------------------
	// Single metrics model
	// ---------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	public static WodelMetricClassifier[] createWodelDynamicMetrics(String metricsmodel,
			List<EPackage> metricspackages,
			List<EPackage> packages)
					throws ReferenceNonExistingException {

		Resource resource = ModelManager.loadModelNoException(metricspackages, metricsmodel);
		if (resource == null) {
			// No model loaded, nothing to classify
			return new WodelMetricClassifier[0];
		}

		EObject root = ModelManager.getRoot(resource);
		List<WodelMetricItem> metricItems = new ArrayList<>();
		LinkedHashMap<String, WodelMetricClass> classMetrics = new LinkedHashMap<>();

		for (EObject tree : (List<EObject>) ModelManager.getReferenced("trees", root)) {
			WodelMetricItem metric = dynamicMetricHelper(tree, packages);

			// Accumulate class metrics
			for (WodelMetricClass metricCl : metric.getClasses()) {
				accumulateClassMetrics(metricCl, classMetrics);
			}

			metricItems.add(metric);
		}

		// Build final list of classes
		List<WodelMetricClass> metricClasses = new ArrayList<>(classMetrics.values());

		// Root metric node
		WodelMetricModel metricRoot = new WodelMetricModel("root", "/");
		metricRoot.addChildren(metricItems);
		metricRoot.addClasses(metricClasses);

		return metricRoot.getClassifiers();
	}

	// ---------------------------------------------------------------------
	// Multiple metrics models
	// ---------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	public static WodelMetricClassifier[] createWodelDynamicMetrics(List<String> metricsmodels,
			List<EPackage> metricspackages,
			List<EPackage> packages)
					throws ModelNotFoundException, ReferenceNonExistingException {

		List<WodelMetricItem> metricItems = new ArrayList<>();
		LinkedHashMap<String, WodelMetricClass> classMetrics = new LinkedHashMap<>();
		List<WodelMetricClass> metricClasses = new ArrayList<>();

		for (String metricsmodel : metricsmodels) {
			Resource resource = ModelManager.loadModel(metricspackages, metricsmodel);
			EObject root = ModelManager.getRoot(resource);

			for (EObject tree : (List<EObject>) ModelManager.getReferenced("trees", root)) {
				WodelMetricItem metric = dynamicMetricHelper(tree, packages);

				// 1) Aggregate class metrics into global map
				for (WodelMetricClass metricCl : metric.getClasses()) {
					accumulateClassMetrics(metricCl, classMetrics);
				}

				// 2) Merge tree metrics into metricItems (by name)
				WodelMetricItem previous = null;
				for (WodelMetricItem item : metricItems) {
					if (item.getName().equals(metric.getName())) {
						previous = item;
						break;
					}
				}

				if (previous == null) {
					metricItems.add(metric);
				} else {
					// Merge child items
					for (WodelMetricItem currentItem : metric.getChildren()) {
						boolean exists = false;
						for (WodelMetricItem existingChild : previous.getChildren()) {
							if (existingChild.getName().equals(currentItem.getName())) {
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

							// Merge classes inside the tree node
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
											accumulateAttributeMetrics(previousClass, metAtt);
										}
										for (WodelMetricReference metRef : currentClass.getReferences()) {
											accumulateReferenceMetrics(previousClass, metRef);
										}
									}
								}
							}
						}
					}
				}
			}
		}

		// Build global class list from aggregated map
		metricClasses.addAll(classMetrics.values());

		// Root metric node
		WodelMetricModel metricRoot = new WodelMetricModel("root", "/");
		metricRoot.addChildren(metricItems);
		metricRoot.addClasses(metricClasses);

		return metricRoot.getClassifiers();
	}
}

