package manager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import manager.StaticMutatorMetrics.WodelMetricAttribute;
import manager.StaticMutatorMetrics.WodelMetricClass;
import manager.StaticMutatorMetrics.WodelMetricReference;
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

public class CommandMutatorMetrics {

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
	
	public static class WodelMetricCommand extends WodelMetric {
		private String name = null;
		private ArrayList<WodelMetricCommand> children = new ArrayList<WodelMetricCommand>();
		private ArrayList<WodelMetricClass> classes = new ArrayList<WodelMetricClass>();
		
		public WodelMetricCommand[] getChildren() {
			WodelMetricCommand[] ret = new WodelMetricCommand[children.size()];
			this.children.toArray(ret);
			return ret;
		}
		
		public WodelMetricClass[] getClasses() {
			WodelMetricClass[] ret = new WodelMetricClass[classes.size()];
			this.classes.toArray(ret);
			return ret;
		}
		
		public boolean addChild(WodelMetricCommand child) {
			return this.children.add(child);
		}
		
		public boolean addChildren(List<WodelMetricCommand> children) {
			return this.children.addAll(children);
		}
		
		public boolean containsChild(WodelMetricCommand child) {
			boolean isContained = false;
			for (WodelMetricCommand command : this.children) {
				if (command.getName().equals(child.getName())) {
					isContained = true;
					break;
				}
			}
			return isContained;
		}
		
		public boolean addClass(WodelMetricClass metricClass) {
			return this.classes.add(metricClass);
		}
		
		public boolean addClasses(List<WodelMetricClass> metricClasses) {
			return this.classes.addAll(metricClasses);
		}
		
		public boolean containsClass(WodelMetricClass metricClass) {
			boolean isContained = false;
			for (WodelMetricClass metricCl : this.classes) {
				if (metricCl.getName().equals(metricClass.getName())) {
					isContained = true;
					break;
				}
			}
			return isContained;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
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
	
	private static void getCommandMetrics(Resource model, ArrayList<EClass> classes, EObject command, WodelMetricCommand metricCommand, EClass mutatedClass, String refName, LinkedHashMap<String, String> strategies, String atts, String refs, int operation, LinkedHashMap<String, WodelMetricClass> classMetrics, boolean filterAbstract) {
		try {
			EObject cl = ModelManager.getReference(refName, command);
			if (cl != null) {
				String name = null;
				if (strategies == null) {
					name = ModelManager.getStringAttribute("name", cl);
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
								name = (String) cl.eGet(attribute);
							}
							else {
								EObject cl2 = ModelManager.getReference("type", cl);
								if (cl2 != null) {
									name = ((EClass) cl2).getName();
								}
								else {
									EObject cl3 = ModelManager.getReference("objSel", cl);
									if (cl3 != null) {
										if (cl3.eClass().getName().equals("CreateObjectMutator")) {
											EObject cl4 = ModelManager.getReference("type", cl3);
											if (cl4 != null) {
												name = ModelManager.getStringAttribute("name", cl4);
											}
										}
										if (cl3.eClass().getName().equals("CloneObjectMutator")) {
											EObject cl4 = ModelManager.getReference("type", cl3);
											if (cl4 != null) {
												name = ModelManager.getStringAttribute("name", cl4);
											}
										}
										if (cl3.eClass().getName().equals("SelectObjectMutator") || cl3.eClass().getName().equals("SelectSampleMutator")) {
											String mutatorName = ModelManager.getStringAttribute("name", cl3);
											EClass cl4 = MutatorUtils.getMutatorType(model, mutatorName);
											if (cl4 != null) {
												EClass cl5 = MutatorUtils.getMutatorContainerType(model, mutatorName);
												if (cl5 != null) {
													if (cl5.getName().equals(mutatedClass.getName())) {
														if (command.eClass().getName().equals("RemoveObjectMutator")) {
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
															commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract);
														}
													}
												}
												else {
													name = cl4.getName();
												}
											}
										}
									}
								}
							}
						}
					}
				}
				if (mutatedClass.getName().equals(name) == true) {
					WodelMetricClass metricClass = classMetrics.get(name);
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
											metricCommand.icreation++;
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
											metricCommand.icreation++;
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
						metricCommand.creation+=counter;
						metricClass.ccreation++;
						metricCommand.ccreation++;
						EClass eClass = metricClass.getEClass();
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
							WodelMetricClass metricContainer = classMetrics.get(containerClass.getName());
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
							metricCommand.imodification++;
							metricCommand.immodification++;
							metricCommand.addClass(metricContainer);
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
							metricCommand.icreation+=counter;
							metricSuperClass.iccreation++;
							metricCommand.iccreation++;
							metricCommand.addClass(metricSuperClass);
						}
						metricCommand.addClass(metricClass);
						EObject container = ModelManager.getReference("container", command);
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
										commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract);
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
									commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract);
								}
							}
						}
					}
					if (operation == 1) {
						metricClass.modification+= counter;
						metricCommand.modification+= counter;
						if (counterInline > 0) {
							metricClass.mmodification += counterInline - 1;
							metricCommand.mmodification += counterInline - 1;
						}
						metricClass.mmodification++;
						metricCommand.mmodification++;
						metricCommand.addClass(metricClass);
					}
					if (operation == 2) {
						EObject container = ModelManager.getReference("container", command);
						if (container == null) {
							for (EAttribute eAttribute : mutatedClass.getEAllAttributes()) {
								for (WodelMetricAttribute wmatt : metricatt) {
									if (wmatt.getName().equals(eAttribute.getName())) {
										wmatt.ideletion++;
										metricClass.ideletion++;
										metricCommand.ideletion++;
										break;
									}
								}
							}
							for (EReference eReference : mutatedClass.getEAllReferences()) {
								for (WodelMetricReference wmref : metricref) {
									if (wmref.getName().equals(eReference.getName())) {
										wmref.ideletion++;
										metricClass.ideletion++;
										metricCommand.ideletion++;
										break;
									}
								}
							}
							metricClass.ddeletion++;
							metricCommand.ddeletion++;
							EClass eClass = metricClass.getEClass();
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
								WodelMetricClass metricContainer = classMetrics.get(containerClass.getName());
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
								metricCommand.imodification++;
								metricContainer.immodification++;
								metricCommand.immodification++;
								metricCommand.addClass(metricContainer);
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
								metricCommand.ideletion+=counter;
								metricSubClass.iddeletion++;
								metricCommand.iddeletion++;
								metricCommand.addClass(metricSubClass);
							}
						}
						metricCommand.addClass(metricClass);
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
										commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract);
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
									commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract);
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
	
	private static LinkedHashMap<String, String> createStrategies() {
		LinkedHashMap<String, String> strategies = new LinkedHashMap<String, String>();
		strategies.put("RandomTypeSelection", "type");
		strategies.put("SpecificObjectSelection", "objSel");
		strategies.put("SpecificClosureSelection", "objSel");
		strategies.put("CompleteTypeSelection", "type");
		strategies.put("OtherTypeSelection", "type");
		
		return strategies;
	}
	
	private static void commandMetricsHelper(Resource model, ArrayList<EClass> classes, EObject command, WodelMetricCommand metricCommand, EClass mutatedClass, LinkedHashMap<String, WodelMetricClass> classMetrics, boolean filterAbstract) {
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
				refName = "object";
				strategies = createStrategies();
				operation = 0;
			}
		}
		getCommandMetrics(model, classes, command, metricCommand, mutatedClass, refName, strategies, atts, refs, operation, classMetrics, filterAbstract);
	}
	
	private static LinkedHashMap<String, WodelMetricClass> createClassMetrics(ArrayList<EClass> classes) {
		LinkedHashMap<String, WodelMetricClass> classMetrics = new LinkedHashMap<String, WodelMetricClass>();
		
		for (EClass cl : classes) {
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
			classMetrics.put(cl.getName(), metric);
		}
		return classMetrics;
	}
	
	public static WodelMetricCommand[] createWodelCommandMetrics(String xmiFileName, String metamodel) {
		try {
			Bundle bundle = Platform.getBundle("wodel.models");
	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
	   		String mutatorecore = FileLocator.resolve(fileURL).getFile();
	   		ArrayList<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource program = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString());
			
			ArrayList<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			ArrayList<EClass> classes = ModelManager.getEClasses(packages);
			
			boolean filterAbstract = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Filter concrete classes", false, null);
			
			ArrayList<WodelMetricCommand> metricCommands = new ArrayList<WodelMetricCommand>();
			LinkedHashMap<String, List<EObject>> blocks = ModelManager.getBlockCommands(program);
			if (blocks.size() > 0) {
				for (String blockName : blocks.keySet()) {
					WodelMetricCommand metricBlock = new WodelMetricCommand();
					metricBlock.setName(blockName);
					List<EObject> commands = blocks.get(blockName);
					for (EObject command : commands) {
						WodelMetricCommand metricCommand = new WodelMetricCommand();
						//String uriID = EcoreUtil.getURI(command).toString().split("#/")[1];
						metricCommand.setName(command.eClass().getName());
						for (EClass cl : classes) {
							if (filterAbstract == true) {
								if (cl.isAbstract() == true) {
									continue;
								}
							}
							LinkedHashMap<String, WodelMetricClass> classMetrics = createClassMetrics(classes);
							commandMetricsHelper(program, classes, command, metricCommand, cl, classMetrics, filterAbstract);
						}
						metricBlock.creation += metricCommand.creation;
						metricBlock.ccreation += metricCommand.ccreation;
						metricBlock.modification += metricCommand.modification;
						metricBlock.mmodification += metricCommand.mmodification;
						metricBlock.deletion += metricCommand.deletion;
						metricBlock.ddeletion += metricCommand.ddeletion;
						metricBlock.icreation += metricCommand.icreation;
						metricBlock.iccreation += metricCommand.iccreation;
						metricBlock.imodification += metricCommand.imodification;
						metricBlock.immodification += metricCommand.immodification;
						metricBlock.ideletion += metricCommand.ideletion;
						metricBlock.iddeletion += metricCommand.iddeletion;
						metricBlock.addChild(metricCommand);
					}
					metricCommands.add(metricBlock);
				}
			}
			else {
				List<EObject> commands = ModelManager.getCommands(program);
				if (commands.size() > 0) {
					for (EObject command : commands) {
						WodelMetricCommand metricCommand = new WodelMetricCommand();
						//String uriID = EcoreUtil.getURI(command).toString().split("#/")[1];
						metricCommand.setName(command.eClass().getName());
						for (EClass cl : classes) {
							if (filterAbstract == true) {
								if (cl.isAbstract() == true) {
									continue;
								}
							}
							LinkedHashMap<String, WodelMetricClass> classMetrics = createClassMetrics(classes);
							commandMetricsHelper(program, classes, command, metricCommand, cl, classMetrics, filterAbstract);
						}
						metricCommands.add(metricCommand);
					}
				}
			}
			WodelMetricCommand[] ret = new WodelMetricCommand[metricCommands.size()];
			metricCommands.toArray(ret);
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
