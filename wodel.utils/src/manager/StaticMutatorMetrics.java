package manager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SelectSampleMutator;
import mutatorenvironment.SpecificObjectSelection;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.Bundle;

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.ReferenceNonExistingException;

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
	}
	
	public static class WodelMetricClass extends WodelMetric{
		private EClass eclass = null;
		private WodelMetricFeature[] features = new WodelMetricFeature[2];

		private ArrayList<WodelMetricAttribute> attributes = new ArrayList<WodelMetricAttribute>();
		private ArrayList<WodelMetricReference> references = new ArrayList<WodelMetricReference>();

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
	
	public static class WodelMetricAttribute {
		private EAttribute attribute = null;
		public int creation = 0;
		public int modification = 0;
		public int deletion = 0;
		public int icreation = 0;
		public int imodification = 0;
		public int ideletion = 0;

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
	
	public static class WodelMetricReference {
		private EReference reference = null;
		public int creation = 0;
		public int modification = 0;
		public int deletion = 0;
		public int icreation = 0;
		public int imodification = 0;
		public int ideletion = 0;

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

	private static void getCommandMetricsClass(Resource model, ArrayList<EClass> classes, EObject command, EClass mutatedClass, String refName, LinkedHashMap<String, String> strategies, String atts, String refs, int operation, LinkedHashMap<String, WodelMetricClass> classMetrics, boolean filterAbstract) {
		try {
			EObject cl = ModelManager.getReference(refName, command);
			if (cl != null) {
				WodelMetricClass metricClass = classMetrics.get(mutatedClass.getName());
				WodelMetricAttribute[] metricatt = metricClass.getAttributes();
				int counter = 0;
				int counterInline = 0;
				if (atts != null) {
					if (command.eClass().getName().equals("ModifyInformationMutator")) {
						List<EObject> attributes = ModelManager.getReferences(atts, command);
						for (EObject o : attributes) {
							if (o.eClass().getName().equals("AttributeScalar")) {
								for (EReference refatt : o.eClass().getEAllReferences()) {
									if (refatt.getName().equals("attribute")) {
										List<EAttribute> att = (List<EAttribute>) o.eGet(refatt);
										for (WodelMetricAttribute wmatt : metricatt) {
											if (wmatt.getName().equals(att.get(0).getName())) {
												wmatt.modification++;
												counter++;
											}
										}
									}
								}
							}
							if (o.eClass().getName().equals("AttributeUnset")) {
								for (EReference refatt : o.eClass().getEAllReferences()) {
									if (refatt.getName().equals("attribute")) {
										List<EAttribute> att = (List<EAttribute>) o.eGet(refatt);
										for (WodelMetricAttribute wmatt : metricatt) {
											if (wmatt.getName().equals(att.get(0).getName())) {
												wmatt.modification++;
												counter++;
											}
										}
									}
								}
							}
							if (o.eClass().getName().equals("AttributeSwap")) {
								for (EReference refatt : o.eClass().getEAllReferences()) {
									if (refatt.getName().equals("attribute")) {
										List<EAttribute> att = (List<EAttribute>) o.eGet(refatt);
										for (WodelMetricAttribute wmatt : metricatt) {
											if (wmatt.getName().equals(att.get(0).getName())) {
												wmatt.modification++;
												counter++;
											}
											if (wmatt.getName().equals(att.get(1).getName())) {
												wmatt.modification++;
												counter++;
											}
										}
									}
								}
							}
							if (o.eClass().getName().equals("AttributeCopy")) {
								for (EReference refatt : o.eClass().getEAllReferences()) {
									if (refatt.getName().equals("attribute")) {
										List<EAttribute> att = (List<EAttribute>) o.eGet(refatt);
										for (WodelMetricAttribute wmatt : metricatt) {
											if (wmatt.getName().equals(att.get(0).getName())) {
												wmatt.modification++;
												counter++;
											}
										}
									}
								}
							}
							if (o.eClass().getName().equals("AttributeReverse")) {
								for (EReference refatt : o.eClass().getEAllReferences()) {
									if (refatt.getName().equals("attribute")) {
										List<EAttribute> att = (List<EAttribute>) o.eGet(refatt);
										for (WodelMetricAttribute wmatt : metricatt) {
											if (wmatt.getName().equals(att.get(0).getName())) {
												wmatt.modification++;
												counter++;
											}
										}
									}
								}
							}
						}
					}
				}
				WodelMetricReference[] metricref = metricClass.getReferences();
				if (refs != null) {
					if (command.eClass().getName().equals("ModifyInformationMutator")) {
						List<EObject> references = ModelManager.getReferences(refs, command);
						for (EObject o : references) {
							if (o.eClass().getName().equals("ReferenceInit")) {
								for (EReference refref : o.eClass().getEAllReferences()) {
									if (refref.getName().equals("reference")) {
										List<EReference> ref = (List<EReference>) o.eGet(refref);
										for (WodelMetricReference wmref : metricref) {
											if (wmref.getName().equals(ref.get(0).getName())) {
												wmref.modification++;
												counter++;
											}
										}
									}
								}
							}
							if (o.eClass().getName().equals("ReferenceAdd")) {
								for (EReference refref : o.eClass().getEAllReferences()) {
									if (refref.getName().equals("reference")) {
										List<EReference> ref = (List<EReference>) o.eGet(refref);
										for (WodelMetricReference wmref : metricref) {
											if (wmref.getName().equals(ref.get(0).getName())) {
												wmref.modification++;
												counter++;
												counterInline++;
											}
										}
									}
								}
							}
							if (o.eClass().getName().equals("ReferenceRemove")) {
								for (EReference refref : o.eClass().getEAllReferences()) {
									if (refref.getName().equals("reference")) {
										List<EReference> ref = (List<EReference>) o.eGet(refref);
										for (WodelMetricReference wmref : metricref) {
											if (wmref.getName().equals(ref.get(0).getName())) {
												wmref.modification++;
												counter++;
												counterInline++;
											}
										}
									}
								}
							}
							if (o.eClass().getName().equals("ReferenceSwap")) {
								for (EReference refref : o.eClass().getEAllReferences()) {
									if (refref.getName().equals("reference")) {
										List<EReference> ref = (List<EReference>) o.eGet(refref);
										for (WodelMetricReference wmref : metricref) {
											if (wmref.getName().equals(ref.get(0).getName())) {
												wmref.modification++;
												counter++;
											}
											if (wmref.getName().equals(ref.get(1).getName())) {
												wmref.modification++;
												counter++;
											}
										}
									}
								}
							}
							if (o.eClass().getName().equals("ReferenceAtt")) {
								List<EReference> ref = null;
								EAttribute att = null;
								for (EReference refref : o.eClass().getEAllReferences()) {
									if (refref.getName().equals("reference")) {
										ref = (List<EReference>) o.eGet(refref);
									}
									if (refref.getName().equals("attribute")) {
										att = (EAttribute) o.eGet(refref);
									}
								}
								// The mutation is applied on a referenced object
								metricClass = classMetrics.get(((EClass) ref.get(0).getEType()).getName());
								for (WodelMetricAttribute wmatt : metricClass.getAttributes()) {
									if (wmatt.getName().equals(att.getName())) {
										wmatt.modification++;
										counter++;
									}
								}
							}
						}
					}
					if (command.eClass().getName().equals("ModifySourceReferenceMutator")) {
						EReference reference = (EReference) ModelManager.getReference(refs, command);
						for (WodelMetricReference wmref : metricClass.getReferences()) {
							if (wmref.getName().equals(reference.getName())) {
								wmref.modification++;
								counter++;
							}
						}
					}
					if (command.eClass().getName().equals("ModifyTargetReferenceMutator")) {
						EReference reference = (EReference) ModelManager.getReference(refs, command);
						for (WodelMetricReference wmref : metricClass.getReferences()) {
							if (wmref.getName().equals(reference.getName())) {
								wmref.modification++;
								counter++;
							}
						}
					}
					if (command.eClass().getName().equals("CreateReferenceMutator")) {
						EReference reference = (EReference) ModelManager.getReference(refs, command);
						for (WodelMetricReference wmref : metricClass.getReferences()) {
							if (wmref.getName().equals(reference.getName())) {
								wmref.modification++;
								counter++;
							}
						}
					}
					if (command.eClass().getName().equals("RemoveRandomReferenceMutator")) {
						EReference reference = (EReference) ModelManager.getReference(refs, command);
						for (WodelMetricReference wmref : metricClass.getReferences()) {
							if (wmref.getName().equals(reference.getName())) {
								wmref.modification++;
								counter++;
							}
						}
					}
					if (command.eClass().getName().equals("RemoveSpecificReferenceMutator")) {
						EReference reference = (EReference) ModelManager.getReference(refs, command);
						for (WodelMetricReference wmref : metricClass.getReferences()) {
							if (wmref.getName().equals(reference.getName())) {
								wmref.modification++;
								counter++;
							}
						}
					}
					if (command.eClass().getName().equals("RemoveCompleteReferenceMutator")) {
						EReference reference = (EReference) ModelManager.getReference(refs, command);
						for (WodelMetricReference wmref : metricClass.getReferences()) {
							if (wmref.getName().equals(reference.getName())) {
								wmref.modification++;
								counter++;
							}
						}
					}
				}
				if (operation == 0) {
					List<EObject> attributes = ModelManager.getReferences("attributes", command);
					ArrayList<String> explicitAttNames = new ArrayList<String>();
					for (EObject attModifier : attributes) {
						for (EReference ref : attModifier.eClass().getEAllReferences()) {
							if (ref.getName().equals("attribute")) {
								List<EAttribute> listAttributes = (List<EAttribute>) attModifier.eGet(ref);
								explicitAttNames.add(listAttributes.get(0).getName());
							}
						}
					}
					for (EAttribute eAttribute : mutatedClass.getEAllAttributes()) {
						for (WodelMetricAttribute wmatt : metricatt) {
							if (wmatt.getName().equals(eAttribute.getName())) {
								if (eAttribute.getLowerBound() > 0) {
									if (explicitAttNames.contains(wmatt.getName())) {
										wmatt.creation++;
										counter++;
									}
									else {
										wmatt.icreation++;
										metricClass.icreation++;
									}
								}
								else {
									if (explicitAttNames.contains(wmatt.getName())) {
										wmatt.creation++;
										counter++;
									}
								}
								break;
							}
						}

					}
					List<EObject> references = ModelManager.getReferences("references", command);
					ArrayList<String> explicitRefNames = new ArrayList<String>();
					for (EObject refModifier : references) {
						for (EReference ref : refModifier.eClass().getEAllReferences()) {
							if (ref.getName().equals("reference")) {
								List<EReference> listReferences = (List<EReference>) refModifier.eGet(ref);
								explicitRefNames.add(listReferences.get(0).getName());
							}
						}
					}
					for (EReference eReference : mutatedClass.getEAllReferences()) {
						for (WodelMetricReference wmref : metricref) {
							if (wmref.getName().equals(eReference.getName())) {
								if (eReference.getLowerBound() > 0) {
									if (explicitRefNames.contains(wmref.getName())) {
										wmref.creation++;
										counter++;
									}
									else {
										wmref.icreation++;
										metricClass.icreation++;
									}
								}
								else {
									if (explicitRefNames.contains(wmref.getName())) {
										wmref.creation++;
										counter++;
									}
								}
								break;
							}
						}
					}
					metricClass.creation+=counter;
					metricClass.ccreation++;
					EClass eClass = metricClass.getEClass();
					EClass container = null;
					for (EClass ec : classes) {
						for (EReference ref : ec.getEAllReferences()) {
							if (ref.getEType().getName().equals(eClass.getName())) {
								if (ref.isContainment()) {
									container = ec;
									break;
								}
							}
						}
						if (container != null) {
							break;
						}
					}
					if (container == null) {
						List<EClass> superClasses = eClass.getEAllSuperTypes();
						for (EClass superCl : superClasses) {
							if (filterAbstract == true) {
								if (superCl.isAbstract() == true) {
									continue;
								}
							}
							for (EClass ec : classes) {
								for (EReference ref : ec.getEAllReferences()) {
									if (ref.getEType().getName().equals(superCl.getName())) {
										if (ref.isContainment()) {
											container = ec;
											break;
										}
									}
								}
								if (container != null) {
									break;
								}
							}
							if (container != null) {
								break;
							}
						}
					}
					if (container != null) {
						WodelMetricClass metricContainer = classMetrics.get(container.getName());
						WodelMetricReference[] containerRef = metricContainer.getReferences();
						for (EReference eReference : container.getEAllReferences()) {
							if (eReference.getEType().getName().equals(eClass.getName())) {
								for (WodelMetricReference wmref : containerRef) {
									if (wmref.getName().equals(eReference.getName())) {
										wmref.imodification++;
										break;
									}
								}
								break;
							}
						}
						metricContainer.imodification++;
						metricContainer.immodification++;
					}
					List<EClass> superClasses = eClass.getEAllSuperTypes();
					for (EClass superClass : superClasses) {
						if (filterAbstract == true) {
							if (superClass.isAbstract() == true) {
								continue;
							}
						}
						WodelMetricClass metricSuperClass = classMetrics.get(superClass.getName());
						WodelMetricAttribute[] metricSuperAtt = metricSuperClass.getAttributes();
						counter = 0;
						for (EAttribute eAttribute : superClass.getEAllAttributes()) {
							for (WodelMetricAttribute wmatt : metricSuperAtt) {
								if (wmatt.getName().equals(eAttribute.getName())) {
									if (eAttribute.getLowerBound() > 0) {
										wmatt.icreation++;
										counter++;
									}
									else {
										if (explicitAttNames.contains(wmatt.getName())) {
											wmatt.icreation++;
											counter++;
										}
									}
									break;
								}
							}
						}
						WodelMetricReference[] metricSuperRef = metricSuperClass.getReferences();
						for (EReference eReference : superClass.getEAllReferences()) {
							for (WodelMetricReference wmref : metricSuperRef) {
								if (wmref.getName().equals(eReference.getName())) {
									if (eReference.getLowerBound() > 0) {
										wmref.icreation++;
										counter++;
									}
									else {
										if (explicitRefNames.contains(wmref.getName())) {
											wmref.icreation++;
											counter++;
										}
									}
									break;
								}
							}
						}
						metricSuperClass.icreation+=counter;
						metricSuperClass.iccreation++;
					}
				}
				if (operation == 1) {
					metricClass.modification+= counter;
					if (counterInline > 0) {
						metricClass.mmodification += counterInline - 1;
					}
					metricClass.mmodification++;
				}
				if (operation == 2) {
					for (EAttribute eAttribute : mutatedClass.getEAllAttributes()) {
						for (WodelMetricAttribute wmatt : metricatt) {
							if (wmatt.getName().equals(eAttribute.getName())) {
								wmatt.ideletion++;
								metricClass.ideletion++;
								break;
							}
						}
					}
					for (EReference eReference : mutatedClass.getEAllReferences()) {
						for (WodelMetricReference wmref : metricref) {
							if (wmref.getName().equals(eReference.getName())) {
								wmref.ideletion++;
								metricClass.ideletion++;
								break;
							}
						}
					}
					metricClass.ddeletion++;
					EClass eClass = metricClass.getEClass();
					EClass container = null;
					for (EClass ec : classes) {
						for (EReference ref : ec.getEAllReferences()) {
							if (ref.getEType().getName().equals(eClass.getName())) {
								if (ref.isContainment()) {
									container = ec;
									break;
								}
							}
						}
						if (container != null) {
							break;
						}
					}
					if (container == null) {
						List<EClass> superClasses = eClass.getEAllSuperTypes();
						for (EClass superCl : superClasses) {
							if (filterAbstract == true) {
								if (superCl.isAbstract() == true) {
									continue;
								}
							}
							for (EClass ec : classes) {
								for (EReference ref : ec.getEAllReferences()) {
									if (ref.getEType().getName().equals(superCl.getName())) {
										if (ref.isContainment()) {
											container = ec;
											break;
										}
									}
								}
								if (container != null) {
									break;
								}
							}
							if (container != null) {
								break;
							}
						}
					}
					if (container != null) {
						WodelMetricClass metricContainer = classMetrics.get(container.getName());
						WodelMetricReference[] containerRef = metricContainer.getReferences();
						for (EReference eReference : container.getEAllReferences()) {
							if (eReference.getEType().getName().equals(eClass.getName())) {
								for (WodelMetricReference wmref : containerRef) {
									if (wmref.getName().equals(eReference.getName())) {
										wmref.imodification++;
										break;
									}
								}
								break;
							}
						}
						metricContainer.imodification++;
						metricContainer.immodification++;
					}
					List<EClass> subClasses = ModelManager.getSubClasses(classes, eClass);
					for (EClass subClass : subClasses) {
						if (filterAbstract == true) {
							if (subClass.isAbstract() == true) {
								continue;
							}
						}
						WodelMetricClass metricSubClass = classMetrics.get(subClass.getName());
						WodelMetricAttribute[] metricSubAtt = metricSubClass.getAttributes();
						counter = 0;
						for (EAttribute eAttribute : subClass.getEAllAttributes()) {
							for (WodelMetricAttribute wmatt : metricSubAtt) {
								if (wmatt.getName().equals(eAttribute.getName())) {
									wmatt.ideletion++;
									counter++;
									break;
								}
							}
						}
						WodelMetricReference[] metricSubRef = metricSubClass.getReferences();
						for (EReference eReference : subClass.getEAllReferences()) {
							for (WodelMetricReference wmref : metricSubRef) {
								if (wmref.getName().equals(eReference.getName())) {
									wmref.ideletion++;
									counter++;
									break;
								}
							}
						}
						metricSubClass.ideletion+=counter;
						metricSubClass.iddeletion++;
					}

				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private static LinkedHashMap<String, String> createStrategies() {
		LinkedHashMap<String, String> strategies = new LinkedHashMap<String, String>();
		strategies.put("RandomTypeSelection", "type");
		strategies.put("SpecificObjectSelection", "objSel");
		strategies.put("CompleteTypeSelection", "type");
		strategies.put("OtherTypeSelection", "type");
		
		return strategies;
	}
	
	private static void commandMetricsClassHelper(Resource model, ArrayList<EClass> classes, EObject command, EClass mutatedClass, LinkedHashMap<String, WodelMetricClass> classMetrics, boolean filterAbstract) {
		LinkedHashMap<String, String> strategies = null;
		String refName = null;
		String atts = null;
		String refs = null;
		int operation = -1;
		if (command != null) {
			EClass eClass = command.eClass();
			if (eClass.getName().equals("CreateObjectMutator")) {
				refName = "type";
				operation = 0;
			}
			if (eClass.getName().equals("ModifySourceReferenceMutator")) {
				refName = "source";
				strategies = createStrategies();
				refs = "refType";
				operation = 1;
			}
			if (eClass.getName().equals("ModifyTargetReferenceMutator")) {
				refName = "source";
				strategies = createStrategies();
				refs = "refType";
				operation = 1;
			}
			if (eClass.getName().equals("CreateReferenceMutator")) {
				refName = "source";
				strategies = createStrategies();
				refs = "refType";
				operation = 1;
			}
			if (eClass.getName().equals("RemoveObjectMutator")) {
				refName = "object";
				strategies = createStrategies();
				operation = 2;
			}
			if (eClass.getName().equals("RemoveRandomReferenceMutator")) {
				refName = "type";
				refs = "refType";
				operation = 1;
			}
			if (eClass.getName().equals("RemoveSpecificReferenceMutator")) {
				refName = "container";
				refs = "refType";
				operation = 1;
			}
			if (eClass.getName().equals("RemoveCompleteReferenceMutator")) {
				refName = "type";
				refs = "refType";
				operation = 1;
			}
			if (eClass.getName().equals("ModifyInformationMutator")) {
				refName = "object";
				strategies = createStrategies();
				atts = "attributes";
				refs = "references";
				operation = 1;
			}
			if (eClass.getName().equals("CloneObjectMutator")) {
				refName = "type";
				operation = 0;
			}
		}
		getCommandMetricsClass(model, classes, command, mutatedClass, refName, strategies, atts, refs, operation, classMetrics, filterAbstract);
	}

	
	private static void staticMetricsHelper(Resource model, ArrayList<EClass> classes, ArrayList<EObject> objects, String mutatorName, String eclass, String refName, LinkedHashMap<String, WodelMetricClass> metrics, int operation, LinkedHashMap<String, String> strategies, String atts, String refs, ArrayList<EPackage> packages, boolean filterAbstract) {
		try {
			if (objects != null) {
				if (objects.size() > 0) {
					for (EObject obj : objects) {
						if (obj.eClass().getName().equals(mutatorName)) {
							EObject cl = ModelManager.getReference(refName, obj);
							if (cl != null) {
								String className = null;
								if (strategies == null) {
									className = ModelManager.getStringAttribute("name", cl);
								}
								else {
									for (String strategy : strategies.keySet()) {
										EAttribute attribute = null;
										if (cl.eClass().getName().equals(strategy)) {
											for (EAttribute att : cl.eClass().getEAttributes()) {
												if (att.getName().equals("name")) {
													attribute = att;
													break;
												}
											}
											if (attribute != null) {
												className = (String) cl.eGet(attribute);
											}
											else {
												EObject cl2 = ModelManager.getReference("type", cl);
												if (cl2 != null) {
													className = ((EClass) cl2).getName();
												}
												else {
													EObject cl3 = ModelManager.getReference("objSel", cl);
													if (cl3 != null) {
														if (cl3.eClass().getName().equals("CreateObjectMutator")) {
															EObject cl4 = ModelManager.getReference("type", cl3);
															if (cl4 != null) {
																className = ModelManager.getStringAttribute("name", cl4);
															}
														}
														if (cl3.eClass().getName().equals("CloneObjectMutator")) {
															EObject cl4 = ModelManager.getReference("type", cl3);
															if (cl4 != null) {
																className = ModelManager.getStringAttribute("name", cl4);
															}
														}
														if (cl3.eClass().getName().equals("SelectObjectMutator") || cl3.eClass().getName().equals("SelectSampleMutator")) {
															String mutator = ModelManager.getStringAttribute("name", cl3);
															EClass cl4 = MutatorUtils.getMutatorType(model, mutator);
															if (cl4 != null) {
																EClass cl5 = MutatorUtils.getMutatorContainerType(model, mutator);
																if (cl5 != null) {
																	if (cl5.getName().equals(eclass)) {
																		if (mutatorName.equals("RemoveObjectMutator")) {
																			ModifyInformationMutator newCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
																			RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
																			rts.setType(cl5);
																			newCommand.setObject(rts);
																			ReferenceInit newReferenceInit = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
																			EReference reference = null;
																			for (EReference ref : cl5.getEAllReferences()) {
																				if (ref.getEType().getName().equals(cl4.getName())) {
																					reference = ref;
																					break;
																				}
																			}
																			newReferenceInit.getReference().add(reference);
																			newCommand.getReferences().add(newReferenceInit);
																			commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract);
																		}
																	}
																}
																else {
																	className = cl4.getName();
																}
															}
														}
													}
												}
											}
										}
									}
								}
								if (className != null) {
									if (eclass.equals(className) == true) {
										WodelMetricClass metric = metrics.get(eclass);
										WodelMetricAttribute[] metricatt = metric.getAttributes();
										int counter = 0;
										int counterInline = 0;
										if (atts != null) {
											if (obj.eClass().getName().equals("ModifyInformationMutator")) {
												List<EObject> attributes = ModelManager.getReferences(atts, obj);
												for (EObject o : attributes) {
													if (o.eClass().getName().equals("AttributeScalar")) {
														for (EReference refatt : o.eClass().getEAllReferences()) {
															if (refatt.getName().equals("attribute")) {
																List<EAttribute> att = (List<EAttribute>) o.eGet(refatt);
																for (WodelMetricAttribute wmatt : metricatt) {
																	if (wmatt.getName().equals(att.get(0).getName())) {
																		wmatt.modification++;
																		counter++;
																	}
																}
															}
														}
													}
													if (o.eClass().getName().equals("AttributeUnset")) {
														for (EReference refatt : o.eClass().getEAllReferences()) {
															if (refatt.getName().equals("attribute")) {
																List<EAttribute> att = (List<EAttribute>) o.eGet(refatt);
																for (WodelMetricAttribute wmatt : metricatt) {
																	if (wmatt.getName().equals(att.get(0).getName())) {
																		wmatt.modification++;
																		counter++;
																	}
																}
															}
														}
													}
													if (o.eClass().getName().equals("AttributeSwap")) {
														for (EReference refatt : o.eClass().getEAllReferences()) {
															if (refatt.getName().equals("attribute")) {
																List<EAttribute> att = (List<EAttribute>) o.eGet(refatt);
																for (WodelMetricAttribute wmatt : metricatt) {
																	if (wmatt.getName().equals(att.get(0).getName())) {
																		wmatt.modification++;
																		counter++;
																	}
																	if (wmatt.getName().equals(att.get(1).getName())) {
																		wmatt.modification++;
																		counter++;
																	}
																}
															}
														}
													}
													if (o.eClass().getName().equals("AttributeCopy")) {
														for (EReference refatt : o.eClass().getEAllReferences()) {
															if (refatt.getName().equals("attribute")) {
																List<EAttribute> att = (List<EAttribute>) o.eGet(refatt);
																for (WodelMetricAttribute wmatt : metricatt) {
																	if (wmatt.getName().equals(att.get(0).getName())) {
																		wmatt.modification++;
																		counter++;
																	}
																}
															}
														}
													}
													if (o.eClass().getName().equals("AttributeReverse")) {
														for (EReference refatt : o.eClass().getEAllReferences()) {
															if (refatt.getName().equals("attribute")) {
																List<EAttribute> att = (List<EAttribute>) o.eGet(refatt);
																for (WodelMetricAttribute wmatt : metricatt) {
																	if (wmatt.getName().equals(att.get(0).getName())) {
																		wmatt.modification++;
																		counter++;
																	}
																}
															}
														}
													}
												}
											}
										}
										WodelMetricReference[] metricref = metric.getReferences();
										if (refs != null) {
											if (obj.eClass().getName().equals("ModifyInformationMutator")) {
												List<EObject> references = ModelManager.getReferences(refs, obj);
												for (EObject o : references) {
													if (o.eClass().getName().equals("ReferenceInit")) {
														for (EReference refref : o.eClass().getEAllReferences()) {
															if (refref.getName().equals("reference")) {
																List<EReference> ref = (List<EReference>) o.eGet(refref);
																for (WodelMetricReference wmref : metricref) {
																	if (wmref.getName().equals(ref.get(0).getName())) {
																		wmref.modification++;
																		counter++;
																	}
																}
															}
														}
													}
													if (o.eClass().getName().equals("ReferenceAdd")) {
														for (EReference refref : o.eClass().getEAllReferences()) {
															if (refref.getName().equals("reference")) {
																List<EReference> ref = (List<EReference>) o.eGet(refref);
																for (WodelMetricReference wmref : metricref) {
																	if (wmref.getName().equals(ref.get(0).getName())) {
																		wmref.modification++;
																		counter++;
																		counterInline++;
																	}
																}
															}
														}
													}
													if (o.eClass().getName().equals("ReferenceRemove")) {
														for (EReference refref : o.eClass().getEAllReferences()) {
															if (refref.getName().equals("reference")) {
																List<EReference> ref = (List<EReference>) o.eGet(refref);
																for (WodelMetricReference wmref : metricref) {
																	if (wmref.getName().equals(ref.get(0).getName())) {
																		wmref.modification++;
																		counter++;
																		counterInline++;
																	}
																}
															}
														}
													}
													if (o.eClass().getName().equals("ReferenceSwap")) {
														for (EReference refref : o.eClass().getEAllReferences()) {
															if (refref.getName().equals("reference")) {
																List<EReference> ref = (List<EReference>) o.eGet(refref);
																for (WodelMetricReference wmref : metricref) {
																	if (wmref.getName().equals(ref.get(0).getName())) {
																		wmref.modification++;
																		counter++;
																	}
																	if (wmref.getName().equals(ref.get(1).getName())) {
																		wmref.modification++;
																		counter++;
																	}
																}
															}
														}
													}
													if (o.eClass().getName().equals("ReferenceAtt")) {
														List<EReference> ref = null;
														EAttribute att = null;
														for (EReference refref : o.eClass().getEAllReferences()) {
															if (refref.getName().equals("reference")) {
																ref = (List<EReference>) o.eGet(refref);
															}
															if (refref.getName().equals("attribute")) {
																att = (EAttribute) o.eGet(refref);
															}
														}
														// The mutation is applied on a referenced object
														metric = metrics.get(((EClass) ref.get(0).getEType()).getName());
														for (WodelMetricAttribute wmatt : metric.getAttributes()) {
															if (wmatt.getName().equals(att.getName())) {
																wmatt.modification++;
																counter++;
															}
														}
													}
												}
											}
											if (obj.eClass().getName().equals("ModifySourceReferenceMutator")) {
												EReference reference = (EReference) ModelManager.getReference(refs, obj);
												for (WodelMetricReference wmref : metric.getReferences()) {
													if (wmref.getName().equals(reference.getName())) {
														wmref.modification++;
														counter++;
													}
												}
											}
											if (obj.eClass().getName().equals("ModifyTargetReferenceMutator")) {
												EReference reference = (EReference) ModelManager.getReference(refs, obj);
												for (WodelMetricReference wmref : metric.getReferences()) {
													if (wmref.getName().equals(reference.getName())) {
														wmref.modification++;
														counter++;
													}
												}
											}
											if (obj.eClass().getName().equals("CreateReferenceMutator")) {
												EReference reference = (EReference) ModelManager.getReference(refs, obj);
												for (WodelMetricReference wmref : metric.getReferences()) {
													if (wmref.getName().equals(reference.getName())) {
														wmref.modification++;
														counter++;
													}
												}
											}
											if (obj.eClass().getName().equals("RemoveRandomReferenceMutator")) {
												EReference reference = (EReference) ModelManager.getReference(refs, obj);
												for (WodelMetricReference wmref : metric.getReferences()) {
													if (wmref.getName().equals(reference.getName())) {
														wmref.modification++;
														counter++;
													}
												}
											}
											if (obj.eClass().getName().equals("RemoveSpecificReferenceMutator")) {
												EReference reference = (EReference) ModelManager.getReference(refs, obj);
												for (WodelMetricReference wmref : metric.getReferences()) {
													if (wmref.getName().equals(reference.getName())) {
														wmref.modification++;
														counter++;
													}
												}
											}
											if (obj.eClass().getName().equals("RemoveCompleteReferenceMutator")) {
												EReference reference = (EReference) ModelManager.getReference(refs, obj);
												for (WodelMetricReference wmref : metric.getReferences()) {
													if (wmref.getName().equals(reference.getName())) {
														wmref.modification++;
														counter++;
													}
												}
											}
										}
										if (operation == 0) {
											EClass eClass = ModelManager.getEClassByName(packages, className);
											List<EObject> attributes = ModelManager.getReferences("attributes", obj);
											ArrayList<String> explicitAttNames = new ArrayList<String>();
											for (EObject attModifier : attributes) {
												for (EReference ref : attModifier.eClass().getEAllReferences()) {
													if (ref.getName().equals("attribute")) {
														List<EAttribute> listAttributes = (List<EAttribute>) attModifier.eGet(ref);
														explicitAttNames.add(listAttributes.get(0).getName());
													}
												}
											}
											for (EAttribute eAttribute : eClass.getEAllAttributes()) {
												for (WodelMetricAttribute wmatt : metricatt) {
													if (wmatt.getName().equals(eAttribute.getName())) {
														if (eAttribute.getLowerBound() > 0) {
															if (explicitAttNames.contains(wmatt.getName())) {
																wmatt.creation++;
																counter++;
															}
															else {
																wmatt.icreation++;
																metric.icreation++;
															}
														}
														else {
															if (explicitAttNames.contains(wmatt.getName())) {
																wmatt.creation++;
																counter++;
															}
														}
														break;
													}
												}
											}
											List<EObject> references = ModelManager.getReferences("references", obj);
											ArrayList<String> explicitRefNames = new ArrayList<String>();
											for (EObject refModifier : references) {
												for (EReference ref : refModifier.eClass().getEAllReferences()) {
													if (ref.getName().equals("reference")) {
														List<EReference> listReferences = (List<EReference>) refModifier.eGet(ref);
														explicitRefNames.add(listReferences.get(0).getName());
													}
												}
											}
											for (EReference eReference : eClass.getEAllReferences()) {
												for (WodelMetricReference wmref : metricref) {
													if (wmref.getName().equals(eReference.getName())) {
														if (eReference.getLowerBound() > 0) {
															if (explicitRefNames.contains(wmref.getName())) {
																wmref.creation++;
																counter++;
															}
															else {
																wmref.icreation++;
																metric.icreation++;
															}
														}
														else {
															if (explicitRefNames.contains(wmref.getName())) {
																wmref.creation++;
																counter++;
															}
														}
														break;
													}
												}
											}
											metric.creation+=counter;
											metric.ccreation++;

											EClass containerClass = null;
											for (EClass ec : classes) {
												for (EReference ref : ec.getEAllReferences()) {
													if (ref.getEType().getName().equals(eClass.getName())) {
														if (ref.isContainment()) {
															containerClass = ec;
															break;
														}
													}
												}
												if (containerClass != null) {
													break;
												}
											}
											if (containerClass == null) {
												List<EClass> superClasses = eClass.getEAllSuperTypes();
												for (EClass superCl : superClasses) {
													if (filterAbstract == true) {
														if (superCl.isAbstract() == true) {
															continue;
														}
													}
													for (EClass ec : classes) {
														for (EReference ref : ec.getEAllReferences()) {
															if (ref.getEType().getName().equals(superCl.getName())) {
																if (ref.isContainment()) {
																	containerClass = ec;
																	break;
																}
															}
														}
														if (containerClass != null) {
															break;
														}
													}
													if (containerClass != null) {
														break;
													}
												}
											}
											if (containerClass != null) {
												WodelMetricClass metricContainer = metrics.get(containerClass.getName());
												WodelMetricReference[] containerRef = metricContainer.getReferences();
												for (EReference eReference : containerClass.getEAllReferences()) {
													if (eReference.getEType().getName().equals(eClass.getName())) {
														for (WodelMetricReference wmref : containerRef) {
															if (wmref.getName().equals(eReference.getName())) {
																wmref.imodification++;
															}
														}
														break;
													}
												}
												metricContainer.imodification++;
												metricContainer.immodification++;
											}
											List<EClass> superClasses = eClass.getEAllSuperTypes();
											for (EClass superClass : superClasses) {
												if (filterAbstract == true) {
													if (superClass.isAbstract() == true) {
														continue;
													}
												}
												WodelMetricClass metricSuperClass = metrics.get(superClass.getName());
												WodelMetricAttribute[] metricSuperAtt = metricSuperClass.getAttributes();
												counter = 0;
												for (EAttribute eAttribute : superClass.getEAllAttributes()) {
													for (WodelMetricAttribute wmatt : metricSuperAtt) {
														if (wmatt.getName().equals(eAttribute.getName())) {
															if (eAttribute.getLowerBound() > 0) {
																wmatt.icreation++;
																counter++;
																break;
															}
															else {
																if (explicitAttNames.contains(wmatt.getName())) {
																	wmatt.icreation++;
																	counter++;
																	break;
																}
															}
														}
													}
												}
												WodelMetricReference[] metricSuperRef = metricSuperClass.getReferences();
												for (EReference eReference : superClass.getEAllReferences()) {
													for (WodelMetricReference wmref : metricSuperRef) {
														if (wmref.getName().equals(eReference.getName())) {
															if (eReference.getLowerBound() > 0) {
																wmref.icreation++;
																counter++;
																break;
															}
															else {
																if (explicitRefNames.contains(wmref.getName())) {
																	wmref.icreation++;
																	counter++;
																	break;
																}
															}
														}
													}
												}
												metricSuperClass.icreation+=counter;
												metricSuperClass.iccreation++;
											}
											EObject container = ModelManager.getReference("container", obj);
											if (container != null) {
												if (container instanceof SpecificObjectSelection) {
													SpecificObjectSelection selection = (SpecificObjectSelection) container;
													if (selection.getRefType() != null) {
														EReference refType = selection.getRefType();
														EClass cl5 = null;
														if (selection.getObjSel() instanceof SelectObjectMutator) {
															cl5 = ((SelectObjectMutator) selection.getObjSel()).getObject().getType();
														}
														if (selection.getObjSel() instanceof SelectSampleMutator) {
															cl5 = ((SelectSampleMutator) selection.getObjSel()).getObject().getType();
														}
														if (selection.getObjSel() instanceof CreateObjectMutator) {
															cl5 = ((CreateObjectMutator) selection.getObjSel()).getType();
														}
														if (selection.getObjSel() instanceof CloneObjectMutator) {
															cl5 = ((CloneObjectMutator) selection.getObjSel()).getType();
														}
														if (cl5 != null) {
															ModifyInformationMutator newCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
															RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
															rts.setType(cl5);
															newCommand.setObject(rts);
															ReferenceInit newReferenceInit = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
															newReferenceInit.getReference().add(refType);
															newCommand.getReferences().add(newReferenceInit);
															commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract);
														}
													}
												}
												if (container instanceof RandomTypeSelection) {
													RandomTypeSelection selection = (RandomTypeSelection) container;
													if (selection.getRefType() != null) {
														EReference refType = selection.getRefType();
														EClass cl5 = selection.getType();
														ModifyInformationMutator newCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
														RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
														rts.setType(cl5);
														newCommand.setObject(rts);
														ReferenceInit newReferenceInit = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
														newReferenceInit.getReference().add(refType);
														newCommand.getReferences().add(newReferenceInit);
														commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract);
													}
												}
											}
										}
										if (operation == 1) {
											metric.modification += counter;
											if (counterInline > 0) {
												metric.mmodification+=counterInline - 1;
											}
											metric.mmodification++;
										}
										if (operation == 2) {
											EObject container = ModelManager.getReference("container", obj);
											if (container == null) {
												EClass eClass = ModelManager.getEClassByName(packages, className);
												for (EAttribute eAttribute : eClass.getEAllAttributes()) {
													for (WodelMetricAttribute wmatt : metricatt) {
														if (wmatt.getName().equals(eAttribute.getName())) {
															wmatt.ideletion++;
															metric.ideletion++;
															break;
														}
													}
												}
												for (EReference eReference : eClass.getEAllReferences()) {
													for (WodelMetricReference wmref : metricref) {
														if (wmref.getName().equals(eReference.getName())) {
															wmref.ideletion++;
															metric.ideletion++;
															break;
														}
													}
												}
												metric.ddeletion++;

												EClass containerClass = null;
												for (EClass ec : classes) {
													for (EReference ref : ec.getEAllReferences()) {
														if (ref.getEType().getName().equals(eClass.getName())) {
															if (ref.isContainment()) {
																containerClass = ec;
																break;
															}
														}
													}
													if (containerClass != null) {
														break;
													}
												}
												if (containerClass == null) {
													List<EClass> superClasses = eClass.getEAllSuperTypes();
													for (EClass superCl : superClasses) {
														if (filterAbstract == true) {
															if (superCl.isAbstract() == true) {
																continue;
															}
														}
														for (EClass ec : classes) {
															for (EReference ref : ec.getEAllReferences()) {
																if (ref.getEType().getName().equals(superCl.getName())) {
																	if (ref.isContainment()) {
																		containerClass = ec;
																		break;
																	}
																}
															}
															if (containerClass != null) {
																break;
															}
														}
														if (containerClass != null) {
															break;
														}
													}
												}
												if (containerClass != null) {
													WodelMetricClass metricContainer = metrics.get(containerClass.getName());
													WodelMetricReference[] containerRef = metricContainer.getReferences();
													for (EReference eReference : containerClass.getEAllReferences()) {
														if (eReference.getEType().getName().equals(eClass.getName())) {
															for (WodelMetricReference wmref : containerRef) {
																if (wmref.getName().equals(eReference.getName())) {
																	wmref.imodification++;
																	break;
																}
															}
															break;
														}
													}
													metricContainer.imodification++;
													metricContainer.immodification++;
												}
												List<EClass> subClasses = ModelManager.getSubClasses(classes, eClass);
												for (EClass subClass : subClasses) {
													if (filterAbstract == true) {
														if (subClass.isAbstract() == true) {
															continue;
														}
													}
													WodelMetricClass metricSubClass = metrics.get(subClass.getName());
													WodelMetricAttribute[] metricSubAtt = metricSubClass.getAttributes();
													counter = 0;
													for (EAttribute eAttribute : subClass.getEAllAttributes()) {
														for (WodelMetricAttribute wmatt : metricSubAtt) {
															if (wmatt.getName().equals(eAttribute.getName())) {
																wmatt.ideletion++;
																counter++;
																break;
															}
														}
													}
													WodelMetricReference[] metricSubRef = metricSubClass.getReferences();
													for (EReference eReference : subClass.getEAllReferences()) {
														for (WodelMetricReference wmref : metricSubRef) {
															if (wmref.getName().equals(eReference.getName())) {
																wmref.ideletion++;
																counter++;
																break;
															}
														}
													}
													metricSubClass.ideletion+=counter;
													metricSubClass.iddeletion++;
												}
											}
											if (container != null) {
												if (container instanceof SpecificObjectSelection) {
													SpecificObjectSelection selection = (SpecificObjectSelection) container;
													if (selection.getRefType() != null) {
														EReference refType = selection.getRefType();
														EClass cl5 = null;
														if (selection.getObjSel() instanceof SelectObjectMutator) {
															cl5 = ((SelectObjectMutator) selection.getObjSel()).getObject().getType();
														}
														if (selection.getObjSel() instanceof SelectSampleMutator) {
															cl5 = ((SelectSampleMutator) selection.getObjSel()).getObject().getType();
														}
														if (selection.getObjSel() instanceof CreateObjectMutator) {
															cl5 = ((CreateObjectMutator) selection.getObjSel()).getType();
														}
														if (selection.getObjSel() instanceof CloneObjectMutator) {
															cl5 = ((CloneObjectMutator) selection.getObjSel()).getType();
														}
														if (cl5 != null) {
															ModifyInformationMutator newCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
															RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
															rts.setType(cl5);
															newCommand.setObject(rts);
															ReferenceInit newReferenceInit = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
															newReferenceInit.getReference().add(refType);
															newCommand.getReferences().add(newReferenceInit);
															commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract);
														}
													}
												}
												if (container instanceof RandomTypeSelection) {
													RandomTypeSelection selection = (RandomTypeSelection) container;
													if (selection.getRefType() != null) {
														EReference refType = selection.getRefType();
														EClass cl5 = selection.getType();
														ModifyInformationMutator newCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
														RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
														rts.setType(cl5);
														newCommand.setObject(rts);
														ReferenceInit newReferenceInit = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
														newReferenceInit.getReference().add(refType);
														newCommand.getReferences().add(newReferenceInit);
														commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static WodelMetricClass[] createWodelStaticMetrics(String xmiFileName, String metamodel) {
		try {
			
			Bundle bundle = Platform.getBundle("wodel.models");
	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
	   		String mutatorecore = FileLocator.resolve(fileURL).getFile();
	   		ArrayList<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource program = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString());
			boolean filterAbstract = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Filter concrete classes", false, null);
			
			ArrayList<EPackage> packages = ModelManager.loadMetaModel(metamodel);

			ArrayList<EObject> creation = ModelManager.getObjectsOfType("CreateObjectMutator", program);
			ArrayList<EObject> modifysrc = ModelManager.getObjectsOfType("ModifySourceReferenceMutator", program);
			ArrayList<EObject> modifytar = ModelManager.getObjectsOfType("ModifyTargetReferenceMutator", program);
			ArrayList<EObject> createref = ModelManager.getObjectsOfType("CreateReferenceMutator", program);
			ArrayList<EObject> removal = ModelManager.getObjectsOfType("RemoveObjectMutator", program);
			ArrayList<EObject> removerndref = ModelManager.getObjectsOfType("RemoveRandomReferenceMutator", program);
			ArrayList<EObject> removespref = ModelManager.getObjectsOfType("RemoveSpecificReferenceMutator", program);
			ArrayList<EObject> removecompref = ModelManager.getObjectsOfType("RemoveCompleteReferenceMutator", program);
			ArrayList<EObject> modifyinf = ModelManager.getObjectsOfType("ModifyInformationMutator", program);
			ArrayList<EObject> clonation = ModelManager.getObjectsOfType("CloneObjectMutator", program);
			
			ArrayList<EClass> classes = ModelManager.getEClasses(packages);
			LinkedHashMap<String, WodelMetricClass> metrics = new LinkedHashMap<String, WodelMetricClass>();
			LinkedHashMap<String, String> strategies = new LinkedHashMap<String, String>();
			strategies.put("RandomTypeSelection", "type");
			strategies.put("SpecificObjectSelection", "objSel");
			strategies.put("SpecificClosureSelection", "objSel");
			strategies.put("CompleteTypeSelection", "type");
			strategies.put("OtherTypeSelection", "type");
			
			for (EClass cl : classes) {
				if (filterAbstract == true) {
					if (cl.isAbstract() == true) {
						continue;
					}
				}
				WodelMetricClass metric = new WodelMetricClass();
				metric.setEClass(cl);
				for (EAttribute att : cl.getEAllAttributes()) {
					WodelMetricAttribute metricatt = new WodelMetricAttribute();
					metricatt.setEAttribute(att);
					metric.addAttribute(metricatt);
				}
				for (EReference ref : cl.getEAllReferences()) {
					WodelMetricReference metricref = new WodelMetricReference();
					metricref.setEReference(ref);
					metric.addReference(metricref);
				}
				metrics.put(cl.getName(), metric);
			}
			for (EClass cl : classes) {
				if (filterAbstract == true) {
					if (cl.isAbstract() == true) {
						continue;
					}
				}
				staticMetricsHelper(program, classes, creation, "CreateObjectMutator", cl.getName(), "type", metrics, 0, null, null, null, packages, filterAbstract);
				staticMetricsHelper(program, classes, modifysrc, "ModifySourceReferenceMutator", cl.getName(), "source", metrics, 1, strategies, null, "refType", packages, filterAbstract);
				staticMetricsHelper(program, classes, modifytar, "ModifyTargetReferenceMutator", cl.getName(), "source", metrics, 1, strategies, null, "refType", packages, filterAbstract);
				staticMetricsHelper(program, classes, createref, "CreateReferenceMutator", cl.getName(), "source", metrics, 1, strategies, null, "refType", packages, filterAbstract);
				staticMetricsHelper(program, classes, removal, "RemoveObjectMutator", cl.getName(), "object", metrics, 2, strategies, null, null, packages, filterAbstract);
				staticMetricsHelper(program, classes, removerndref, "RemoveRandomReferenceMutator", cl.getName(), "type", metrics, 1, null, null, "refType", packages, filterAbstract);
				staticMetricsHelper(program, classes, removespref, "RemoveSpecificReferenceMutator", cl.getName(), "container", metrics, 1, null, null, "refType", packages, filterAbstract);
				staticMetricsHelper(program, classes, removecompref, "RemoveCompleteReferenceMutator", cl.getName(), "type", metrics, 1, null, null, "refType", packages, filterAbstract);
				staticMetricsHelper(program, classes, modifyinf, "ModifyInformationMutator", cl.getName(), "object", metrics, 1, strategies, "attributes", "references", packages, filterAbstract);
				staticMetricsHelper(program, classes, clonation, "CloneObjectMutator", cl.getName(), "object", metrics, 0, strategies, null, null, packages, filterAbstract);
			}
			
			WodelMetricClass[] ret = new WodelMetricClass[metrics.values().size()];
			metrics.values().toArray(ret);
			return ret;
			
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
