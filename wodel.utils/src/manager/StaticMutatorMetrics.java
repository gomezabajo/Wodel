package manager;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Pablo Gomez-Abajo
 * 
 * StaticMutatorMetrics static footprints
 * 
 */

public class StaticMutatorMetrics {
	
	public static abstract class WodelMetric {
		public int creation = 0;
		public int ccreation = 0;
		public int modification = 0;
		public int mmodification = 0;
		public int deletion = 0;
		public int ddeletion = 0;
		public int icreation = 0;
		public int iccreation = 0;
		public int imodification = 0;
		public int immodification = 0;
		public int ideletion = 0;
		public int iddeletion = 0;
		
		public String getName() {
			return "";
		}
	}
	
	public static class WodelMetricClass extends WodelMetric{
		private EClass eclass = null;
		private WodelMetricFeature[] features = new WodelMetricFeature[2];

		private List<WodelMetricAttribute> attributes = new ArrayList<WodelMetricAttribute>();
		private List<WodelMetricReference> references = new ArrayList<WodelMetricReference>();
		
		public void setEClass(EClass eclass) {
			this.eclass = eclass;
		}
		
		public EClass getEClass() {
			return eclass;
		}
		
		public String getName() {
			if (eclass != null) {
				return eclass.getName();
			}
			return null;
		}
		
		public URI getURI() {
			if (eclass != null) {
				return EcoreUtil.getURI(eclass);
			}
			return null;
		}
		
		public WodelMetricFeature[] getFeatures() {
			return features;
		}
		
		public WodelMetricAttribute[] getAttributes() {
			WodelMetricAttribute[] ret = new WodelMetricAttribute[attributes.size()];
			attributes.toArray(ret);
			return ret;
		}
		
		public WodelMetricReference[] getReferences() {
			WodelMetricReference[] ret = new WodelMetricReference[references.size()];
			references.toArray(ret);
			return ret;
		}
		
		public boolean addAttribute(WodelMetricAttribute attribute) {
			return attributes.add(attribute);
		}
		
		public boolean addAttributes(List<WodelMetricAttribute> attributes) {
			return this.attributes.addAll(attributes);
		}
		
		public boolean addReference(WodelMetricReference reference) {
			return references.add(reference);
		}
		
		public boolean addReferences(List<WodelMetricReference> references) {
			return this.references.addAll(references);
		}
		
		public WodelMetricClass() {
			features[0] = new WodelMetricFeature(this, "Attributes");
			features[1] = new WodelMetricFeature(this, "References");
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
		public int getAttributesImplicitCreation() {
			int value = 0;
			for (WodelMetricAttribute att : this.metric.getAttributes()) {
				value += att.icreation;
			}
			return value;
		}
		public int getAttributesImplicitModification() {
			int value = 0;
			for (WodelMetricAttribute att : this.metric.getAttributes()) {
				value += att.imodification;
			}
			return value;
		}
		public int getAttributesImplicitDeletion() {
			int value = 0;
			for (WodelMetricAttribute att : this.metric.getAttributes()) {
				value += att.ideletion;
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
		public int getReferencesImplicitCreation() {
			int value = 0;
			for (WodelMetricReference ref : this.metric.getReferences()) {
				value += ref.icreation;
			}
			return value;
		}
		public int getReferencesImplicitModification() {
			int value = 0;
			for (WodelMetricReference ref : this.metric.getReferences()) {
				value += ref.imodification;
			}
			return value;
		}
		public int getReferencesImplicitDeletion() {
			int value = 0;
			for (WodelMetricReference ref : this.metric.getReferences()) {
				value += ref.ideletion;
			}
			return value;
		}
	}
	
	public static class WodelMetricAttribute extends WodelMetric {
		private EAttribute attribute = null;

		public void setEAttribute(EAttribute attribute) {
			this.attribute = attribute;
		}
		public EAttribute getEAttribute() {
			return attribute;
		}
		
		public String getName() {
			if (attribute != null) {
				return attribute.getName();
			}
			return null;
		}
		
		public WodelMetricAttribute() {
			
		}
	}
	
	public static class WodelMetricReference extends WodelMetric {
		private EReference reference = null;

		public void setEReference(EReference reference) {
			this.reference = reference;
		}
		
		public EReference getEReference() {
			return reference;
		}
		
		public String getName() {
			if (reference != null) {
				return reference.getName();
			}
			return null;
		}
		
		public WodelMetricReference() {
			
		}
	}
}