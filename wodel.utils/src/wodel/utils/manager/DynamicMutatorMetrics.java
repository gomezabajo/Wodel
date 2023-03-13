package wodel.utils.manager;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import wodel.utils.exceptions.ReferenceNonExistingException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * DynamicMutatorMetrics dynamic footprints
 * 
 */

public class DynamicMutatorMetrics {
	
	public static abstract class WodelMetric {
		public int creation = 0;
		public int modification = 0;
		public int deletion = 0;
		public int ccreation = 0;
		public int cmodification = 0;
		public int cdeletion = 0;
		
		public String getName() {
			return "";
		}
	}
	
	public static abstract class WodelMetricItem extends WodelMetric {
		private String name = null;
		private String path = null;
		
		private ArrayList<WodelMetricItem> children = new ArrayList<WodelMetricItem>();
		private ArrayList<WodelMetricClass> classes = new ArrayList<WodelMetricClass>();
		
		private WodelMetricClassifier[] classifiers = new WodelMetricClassifier[2];
		
		public WodelMetricItem[] getChildren() {
			WodelMetricItem[] ret = new WodelMetricItem[children.size()];
			this.children.toArray(ret);
			return ret;
		}
		
		public WodelMetricClassifier[] getClassifiers() {
			return this.classifiers;
		}
		
		public boolean addChild(WodelMetricItem child) {
			return this.children.add(child);
		}
		
		public boolean addChildren(List<WodelMetricItem> children) {
			return this.children.addAll(children);
		}
		
		public WodelMetricClass[] getClasses() {
			WodelMetricClass[] ret = new WodelMetricClass[classes.size()];
			this.classes.toArray(ret);
			return ret;
		}
		
		public boolean addClass(WodelMetricClass metricClass) {
			return this.classes.add(metricClass);
		}
		
		public boolean addClasses(List<WodelMetricClass> metricClasses) {
			return this.classes.addAll(metricClasses);
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public void setPath(String path) {
			this.path = path;
		}
		
		public String getPath() {
			return this.path;
		}
		
		public WodelMetricItem(String name, String path, String classifier) {
			this.name = name;
			this.path = path;
			this.classifiers[0] = new WodelMetricClassifier(this, classifier);
			this.classifiers[1] = new WodelMetricClassifier(this, "Classes");
		}
	}
	
	public static class WodelMetricModel extends WodelMetricItem {
		public WodelMetricModel(String name, String path) {
			super(name, path, "Models");
		}
	}
	
	public static class WodelMetricBlock extends WodelMetricItem {
		public WodelMetricBlock(String name, String path) {
			super(name, path, "Blocks");
		}
	}
	
	public static class WodelMetricMutantsBlock extends WodelMetricItem {
		public WodelMetricMutantsBlock(String name, String path) {
			super(name, path, "Mutants");
		}
	}
	
	public static class WodelMetricMutant extends WodelMetricItem {
		public WodelMetricMutant(String name, String path) {
			super(name, path, "Mutant");
		}
	}
	
	public static class WodelMetricFeature {
		private WodelMetricClass metric = null;
		private String name = null;
		
		public String getName() {
			return name;
		}
		
		public WodelMetricFeature(WodelMetricClass metric, String name) {
			this.metric = metric;
			this.name = name;
		}
		
		public WodelMetricAttribute[] getAttributes() {
			return this.metric.getAttributes();
		}
		
		public WodelMetricReference[] getReferences() {
			return this.metric.getReferences();
		}
		
		public int getAttributesCreation() {
			int value = 0;
			for (WodelMetricAttribute att : this.metric.getAttributes()) {
				value += att.creation;
			}
			return value;
		}
		
		public int getAttributesModification() {
			int value = 0;
			for (WodelMetricAttribute att : this.metric.getAttributes()) {
				value += att.modification;
			}
			return value;
		}
		
		public int getAttributesDeletion() {
			int value = 0;
			for (WodelMetricAttribute att : this.metric.getAttributes()) {
				value += att.deletion;
			}
			return value;
		}
		
		public int getReferencesCreation() {
			int value = 0;
			for (WodelMetricReference ref : this.metric.getReferences()) {
				value += ref.creation;
			}
			return value;
		}
		
		public int getReferencesModification() {
			int value = 0;
			for (WodelMetricReference ref : this.metric.getReferences()) {
				value += ref.modification;
			}
			return value;
		}
		
		public int getReferencesDeletion() {
			int value = 0;
			for (WodelMetricReference ref : this.metric.getReferences()) {
				value += ref.deletion;
			}
			return value;
		}
	}
	
	public static class WodelMetricAttribute extends WodelMetric {
		private EAttribute eAttribute = null;
		
		public void setEAttribute(EAttribute eAttribute) {
			this.eAttribute = eAttribute;
		}
		
		public EAttribute getEAttribute() {
			return this.eAttribute;
		}
		
		public String getName() {
			if (this.eAttribute != null) {
				return this.eAttribute.getName();
			}
			return null;
		}
		
		public WodelMetricAttribute() {
			
		}
	}
	
	public static class WodelMetricReference extends WodelMetric {
		private EReference eReference = null;
		
		public void setEReference(EReference eReference) {
			this.eReference = eReference;
		}
		
		public EReference getEReference() {
			return this.eReference;
		}
		
		public String getName() {
			if (this.eReference != null) {
				return this.eReference.getName();
			}
			return null;
		}
		
		public WodelMetricReference() {
			
		}
	}
	
	public static class WodelMetricClass extends WodelMetric {
		private EClass eClass = null;
		private WodelMetricFeature[] features = new WodelMetricFeature[2];
		
		private ArrayList<WodelMetricAttribute> attributes = new ArrayList<WodelMetricAttribute>();
		private ArrayList<WodelMetricReference> references = new ArrayList<WodelMetricReference>();
		
		public void setEClass(EClass eClass) {
			this.eClass = eClass;
		}
		
		public EClass getEClass() {
			return this.eClass;
		}
		
		public String getName() {
			if (this.eClass != null) {
				return this.eClass.getName();
			}
			return null;
		}
		
		public WodelMetricFeature[] getFeatures() {
			return this.features;
		}
		
		public WodelMetricAttribute[] getAttributes() {
			WodelMetricAttribute[] ret = new WodelMetricAttribute[this.attributes.size()];
			this.attributes.toArray(ret);
			return ret;
		}
		
		public WodelMetricReference[] getReferences() {
			WodelMetricReference[] ret = new WodelMetricReference[this.references.size()];
			this.references.toArray(ret);
			return ret;
		}
		
		public boolean addAttribute(WodelMetricAttribute attribute) {
			return this.attributes.add(attribute);
		}
		
		public boolean addAttributes(List<WodelMetricAttribute> attributes) {
			return this.attributes.addAll(attributes);
		}
		
		public boolean addReference(WodelMetricReference reference) {
			return this.references.add(reference);
		}
		
		public boolean addReferences(List<WodelMetricReference> references) {
			return this.references.addAll(references);
		}
		
		public WodelMetricAttribute getAttributeByName(String name) {
			for (WodelMetricAttribute metAtt : this.attributes) {
				if (metAtt.getName().equals(name)) {
					return metAtt;
				}
			}
			return null;
		}
		
		public WodelMetricReference getReferenceByName(String name) {
			for (WodelMetricReference metRef : this.references) {
				if (metRef.getName().equals(name)) {
					return metRef;
				}
			}
			return null;
		}

		public WodelMetricClass() {
			this.features[0] = new WodelMetricFeature(this, "Attributes");
			this.features[1] = new WodelMetricFeature(this, "References");
		}
	}
	

	public static class WodelMetricClassifier {
		private WodelMetricItem metric = null;
		private String name = null;
		
		public String getName() {
			return name;
		}
		
		public WodelMetricClassifier(WodelMetricItem metric, String name) {
			this.metric = metric;
			this.name = name;
		}
		
		public WodelMetricItem[] getChildren() {
			return this.metric.getChildren();
		}
		
		public WodelMetricClass[] getClasses() {
			return this.metric.getClasses();
		}
		
		public int getCreation() {
			int value = 0;
			for (WodelMetricClass cl : this.metric.getClasses()) {
				value += cl.creation;
			}
			return value;
		}
		
		public int getClassCreation() {
			int value = 0;
			for (WodelMetricClass cl : this.metric.getClasses()) {
				value += cl.ccreation;
			}
			return value;
		}
		
		public int getModification() {
			int value = 0;
			for (WodelMetricClass cl : this.metric.getClasses()) {
				value += cl.modification;
			}
			return value;
		}
		
		public int getClassModification() {
			int value = 0;
			for (WodelMetricClass cl : this.metric.getClasses()) {
				value += cl.cmodification;
			}
			return value;
		}

		public int getDeletion() {
			int value = 0;
			for (WodelMetricClass cl : this.metric.getClasses()) {
				value += cl.deletion;
			}
			return value;
		}
		
		public int getClassDeletion() {
			int value = 0;
			for (WodelMetricClass cl : this.metric.getClasses()) {
				value += cl.cdeletion;
			}
			return value;
		}
	}
	
	public static WodelMetricItem dynamicMetricHelper(EObject object, List<EPackage> packages) {
		WodelMetricItem metric = null;
		try {
			String name = ModelManager.getStringAttribute("name", object);
			String path = ModelManager.getStringAttribute("path", object);
			List<EObject> children = ModelManager.getReferences("mutants", object);
			if (children.size() > 0) {
				EObject child = children.get(0);
				String childName = ModelManager.getStringAttribute("name", child);
				if (childName.endsWith(".model") == true) {
					metric = new WodelMetricMutantsBlock(name, path);
				}
			}
			if (metric == null) {
				if (name.endsWith(".model") == true) {
					metric = new WodelMetricMutant(name, path);
				}
				else {
					metric = new WodelMetricBlock(name, path);
				}
			}
			List<EObject> metricClasses = ModelManager.getReferences("classes", object);
			for (EObject metricCl : metricClasses) {
				WodelMetricClass met = new WodelMetricClass();
				EClass metricClass = ModelManager.getEClassByName(packages, ModelManager.getStringAttribute("name", metricCl));
				met.setEClass(metricClass);
				met.creation = ModelManager.getIntAttribute("created", metricCl);
				met.modification = ModelManager.getIntAttribute("modified", metricCl);
				met.deletion = ModelManager.getIntAttribute("removed", metricCl);
				met.ccreation = ModelManager.getIntAttribute("ccreated", metricCl);
				met.cmodification = ModelManager.getIntAttribute("cmodified", metricCl);
				met.cdeletion = ModelManager.getIntAttribute("cremoved", metricCl);
				List<EObject> metricAttributes = ModelManager.getReferences("attributes", metricCl);
				for (EObject metricAtt : metricAttributes) {
					WodelMetricAttribute metAtt = new WodelMetricAttribute();
					String nameAtt = ModelManager.getStringAttribute("name", metricAtt);
					EAttribute attribute = null;
					for (EAttribute att : metricClass.getEAllAttributes()) {
						if (att.getName().equals(nameAtt)) {
							attribute = att;
							break;
						}
					}
					if (attribute != null) {
						metAtt.setEAttribute(attribute);
						metAtt.creation = ModelManager.getIntAttribute("created", metricAtt);
						metAtt.modification = ModelManager.getIntAttribute("modified", metricAtt);
						metAtt.deletion = ModelManager.getIntAttribute("removed", metricAtt);
						met.addAttribute(metAtt);
					}
				}
				List<EObject> metricReferences = ModelManager.getReferences("references", metricCl);
				for (EObject metricRef : metricReferences) {
					WodelMetricReference metRef = new WodelMetricReference();
					String nameRef = ModelManager.getStringAttribute("name", metricRef);
					EReference reference = null;
					for (EReference ref : metricClass.getEAllReferences()) {
						if (ref.getName().equals(nameRef)) {
							reference = ref;
							break;
						}
					}
					if (reference != null) {
						metRef.setEReference(reference);
						metRef.creation = ModelManager.getIntAttribute("created", metricRef);
						metRef.modification = ModelManager.getIntAttribute("modified", metricRef);
						metRef.deletion = ModelManager.getIntAttribute("removed", metricRef);
						met.addReference(metRef);
					}
				}
				metric.creation += met.creation;
				metric.modification += met.modification;
				metric.deletion += met.deletion;
				metric.ccreation += met.ccreation;
				metric.cmodification += met.cmodification;
				metric.cdeletion += met.cdeletion;
				metric.addClass(met);
			}
			for (EObject child : children) {
				WodelMetricItem childMetric = dynamicMetricHelper(child, packages);
				metric.addChild(childMetric);
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return metric;
	}
}

