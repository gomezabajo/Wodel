package wodel.metrics.command;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.ReferenceNonExistingException;
import manager.ModelManager;
import manager.MutatorUtils;
import manager.StaticMutatorMetrics;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SelectSampleMutator;
import mutatorenvironment.SpecificObjectSelection;

/**
 * @author Pablo Gomez-Abajo
 * 
 * CommandMutatorMetrics operator static footprints
 * 
 */
public class CommandMutatorMetrics extends StaticMutatorMetrics {

	public static class WodelMetricCommand extends WodelMetric {
		private String name = null;
		private List<WodelMetricCommand> children = new ArrayList<WodelMetricCommand>();
		private List<WodelMetricClass> classes = new ArrayList<WodelMetricClass>();

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
			if (containsClass(metricClass)) {
				return true;
			}
			return this.classes.add(metricClass);
		}

		public boolean addClasses(List<WodelMetricClass> metricClasses) {
			boolean value = true;
			for (WodelMetricClass metricClass : metricClasses) {
				value = addClass(metricClass);
				if (value == false) {
					return false;
				}
			}
			return true;
		}

		public boolean containsClass(WodelMetricClass metricClass) {
			boolean isContained = false;
			for (WodelMetricClass metricCl : this.classes) {
				if (metricCl.getURI().equals(metricClass.getURI())) {
					isContained = true;
					break;
				}
			}
			return isContained;
		}

		public WodelMetricClass getClass(WodelMetricClass metricClass) {
			for (WodelMetricClass metricCl : this.classes) {
				if (metricCl.getURI().equals(metricClass.getURI())) {
					return metricCl;
				}
			}
			return null;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
	}

	private static void staticCloneMetricsHelper(Resource model, List<EClass> classes, EObject command, WodelMetricCommand metricCommand, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, boolean filterAbstract, List<EClass> recursion) {
		int counter = 0;
		WodelMetricClass metricClass = classMetrics.get(EcoreUtil.getURI(mutatedClass));
		if (metricClass == null) {
			return;
		}
		WodelMetricAttribute[] metricatt = metricClass.getAttributes();
		for (EAttribute eAttribute : mutatedClass.getEAllAttributes()) {
			for (WodelMetricAttribute wmatt : metricatt) {
				if (wmatt.getName().equals(eAttribute.getName())) {
					if (eAttribute.getLowerBound() > 0) {
						wmatt.icreation++;
						metricClass.icreation++;
						metricCommand.icreation++;
					}
					break;
				}
			}

		}
		WodelMetricReference[] metricref = metricClass.getReferences();
		for (EReference eReference : mutatedClass.getEAllReferences()) {
			for (WodelMetricReference wmref : metricref) {
				if (wmref.getName().equals(eReference.getName())) {
					if (eReference.getLowerBound() > 0) {
						wmref.icreation++;
						metricClass.icreation++;
						metricCommand.icreation++;
					}
					break;
				}
			}
		}
		metricClass.icreation+=counter;
		metricCommand.icreation+=counter;
		metricClass.iccreation++;
		metricCommand.iccreation++;

		EClass containerClass = null;
		for (EClass ec : classes) {
			for (EReference ref : ec.getEAllReferences()) {
				if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
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
		List<EClass> superClasses = mutatedClass.getEAllSuperTypes();
		for (EClass superClass : superClasses) {
			if (filterAbstract == true) {
				if (superClass.isAbstract() == true) {
					continue;
				}
			}
			WodelMetricClass metricSuperClass = classMetrics.get(EcoreUtil.getURI(superClass));
			if (metricSuperClass != null) {
				WodelMetricAttribute[] metricSuperAtt = metricSuperClass.getAttributes();
				counter = 0;
				for (EAttribute eAttribute : superClass.getEAllAttributes()) {
					for (WodelMetricAttribute wmatt : metricSuperAtt) {
						if (wmatt.getName().equals(eAttribute.getName())) {
							if (eAttribute.getLowerBound() > 0) {
								wmatt.icreation++;
								counter++;
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
		}
		if (containerClass == null) {
			for (EClass superCl : superClasses) {
				if (filterAbstract == true) {
					if (superCl.isAbstract() == true) {
						continue;
					}
				}
				for (EClass ec : classes) {
					for (EReference ref : ec.getEAllReferences()) {
						if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(superCl))) {
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
			boolean proceed = true;
			if (filterAbstract == true) {
				if (containerClass.isAbstract() == true) {
					proceed = false;
				}
			}
			if (proceed == true) {
				WodelMetricClass metricContainer = classMetrics.get(EcoreUtil.getURI(containerClass));
				if (metricContainer != null) {
					WodelMetricReference[] containerRef = metricContainer.getReferences();
					for (EReference eReference : containerClass.getEAllReferences()) {
						if (EcoreUtil.getURI(eReference.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
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
			}
		}
		metricCommand.addClass(metricClass);
		if (command.eClass().getName().equals("CloneObjectMutator")) {
			boolean contents = ModelManager.getBooleanAttribute("contents", command);
			if (contents == true) {
				for (EReference ref : mutatedClass.getEAllReferences()) {
					if (ref.isContainment()) {
						boolean previous = false;
						for (EClass rec : recursion) {
							if (EcoreUtil.getURI(rec).equals(EcoreUtil.getURI(ref.getEType()))) {
								previous = true;
								break;
							}
						}
						if (ref.isContainment() && previous == false) {
							recursion.add((EClass) ref.getEType());
							cloneMetricsHelper(model, classes, command, metricCommand, (EClass) ref.getEType(), classMetrics, filterAbstract, recursion);
						}
					}
				}
			}
		}
	}

	private static void cloneMetricsHelper(Resource model, List<EClass> classes, EObject command, WodelMetricCommand metricCommand, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, boolean filterAbstract, List<EClass> recursion) {
		if (filterAbstract && mutatedClass.isAbstract()) {
			return;
		}
		CloneObjectMutator cloneCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createCloneObjectMutator();
		RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
		rts.setType(mutatedClass);
		cloneCommand.setObject(rts);
		cloneCommand.setContents(true);
		staticCloneMetricsHelper(model, classes, cloneCommand, metricCommand, mutatedClass, classMetrics, filterAbstract, recursion);
	}

	private static void staticRemoveMetricsHelper(Resource model, List<EClass> classes, EObject command, WodelMetricCommand metricCommand, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, boolean filterAbstract, List<EClass> recursion, List<EPackage> packages) {
		WodelMetricClass metricClass = classMetrics.get(EcoreUtil.getURI(mutatedClass));
		if (metricClass == null) {
			return;
		}
		WodelMetricAttribute[] metricatt = metricClass.getAttributes();
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
		WodelMetricReference[] metricref = metricClass.getReferences();
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
		metricClass.iddeletion++;
		metricCommand.iddeletion++;
		List<EClass> subClasses = ModelManager.getESubClasses(packages, mutatedClass);
		for (EClass subClass : subClasses) {
			if (filterAbstract == true) {
				if (subClass.isAbstract() == true) {
					continue;
				}
			}
			WodelMetricClass metricSubClass = classMetrics.get(EcoreUtil.getURI(subClass));
			if (metricSubClass != null) {
				WodelMetricAttribute[] metricSubAtt = metricSubClass.getAttributes();
				int counter = 0;
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
		EClass containerClass = null;
		for (EClass ec : classes) {
			for (EReference ref : ec.getEAllReferences()) {
				if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
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
			List<EClass> superClasses = mutatedClass.getEAllSuperTypes();
			for (EClass superCl : superClasses) {
				if (filterAbstract == true) {
					if (superCl.isAbstract() == true) {
						continue;
					}
				}
				for (EClass ec : classes) {
					for (EReference ref : ec.getEAllReferences()) {
						if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(superCl))) {
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
			boolean proceed = true;
			if (filterAbstract == true) {
				if (containerClass.isAbstract() == true) {
					proceed = false;
				}
			}
			if (proceed == true) {
				WodelMetricClass metricContainer = classMetrics.get(EcoreUtil.getURI(containerClass));
				if (metricContainer != null) {
					WodelMetricReference[] containerRef = metricContainer.getReferences();
					for (EReference eReference : containerClass.getEAllReferences()) {
						if (EcoreUtil.getURI(eReference.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
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
			}
		}
		if (command.eClass().getName().equals("RemoveObjectMutator")) {
			for (EReference ref : mutatedClass.getEAllReferences()) {
				if (ref.isContainment()) {
					boolean previous = false;
					for (EClass rec : recursion) {
						if (EcoreUtil.getURI(rec).equals(EcoreUtil.getURI(ref.getEType()))) {
							previous = true;
							break;
						}
					}
					if (ref.isContainment() && previous == false) {
						recursion.add((EClass) ref.getEType());
						removeMetricsHelper(model, classes, command, metricCommand, (EClass) ref.getEType(), classMetrics, filterAbstract, recursion, packages);
					}
				}
			}
		}
	}

	private static void removeMetricsHelper(Resource model, List<EClass> classes, EObject command, WodelMetricCommand metricCommand, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, boolean filterAbstract, List<EClass> recursion, List<EPackage> packages) {
		if (filterAbstract && mutatedClass.isAbstract()) {
			return;
		}
		RemoveObjectMutator removeCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRemoveObjectMutator();
		RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
		rts.setType(mutatedClass);
		removeCommand.setObject(rts);
		staticRemoveMetricsHelper(model, classes, removeCommand, metricCommand, mutatedClass, classMetrics, filterAbstract, recursion, packages);
	}
	
	private static URI getClassURI(Resource model, List<EClass> classes, EObject command, WodelMetricCommand metricCommand, EClass mutatedClass, LinkedHashMap<String, String> strategies, LinkedHashMap<URI, WodelMetricClass> classMetrics, boolean filterAbstract, List<EPackage> packages, EObject cl) {
		URI classURI = null;
		try {
			if (strategies == null) {
				classURI = EcoreUtil.getURI(cl);
			}
			else {
				for (String strategy : strategies.keySet()) {
					if (cl.eClass().getName().equals(strategy)) {
						EObject cl2 = ModelManager.getReference("type", cl);
						if (cl2 != null) {
							classURI = EcoreUtil.getURI(cl2);
						}
						else {
							EObject cl3 = ModelManager.getReference("objSel", cl);
							if (cl3 != null) {
								if (cl3.eClass().getName().equals("CreateObjectMutator")) {
									EObject cl4 = ModelManager.getReference("type", cl3);
									if (cl4 != null) {
										classURI = EcoreUtil.getURI(cl4);
									}
								}
								if (cl3.eClass().getName().equals("CloneObjectMutator")) {
									EObject cl4 = ModelManager.getReference("type", cl3);
									if (cl4 != null) {
										classURI = EcoreUtil.getURI(cl4);
									}
								}
								if (cl3.eClass().getName().equals("RetypeObjectMutator")) {
									EObject cl4 = ModelManager.getReference("type", cl3);
									if (cl4 != null) {
										classURI = EcoreUtil.getURI(cl4);
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
														if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(cl4))) {
															reference = ref;
															break;
														}
													}
													newReferenceInit.getReference().add(reference);
													newCommand.getReferences().add(newReferenceInit);
													commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract, packages);
													if (reference.isContainment()) {
														RemoveObjectMutator removeCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRemoveObjectMutator();
														rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
														rts.setType(cl4);
														removeCommand.setObject(rts);
														List<EClass> recursion = new ArrayList<EClass>();
														recursion.add(cl4);
														removeMetricsHelper(model, classes, command, metricCommand, cl4, classMetrics, filterAbstract, recursion, packages);
													}
												}
												if (command.eClass().getName().equals("ModifyInformationMutator")) {
													ModifyInformationMutator newCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
													RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
													rts.setType(cl4);
													newCommand.setObject(rts);
													AttributeSet newAttributeSet = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createAttributeSet();
													List<AttributeSet> attributeSet = new ArrayList<AttributeSet>();
													for (EObject attSet : ModelManager.getReferences("attributes", command)) {
														if (attSet instanceof AttributeSet) {
															attributeSet.add((AttributeSet) attSet);
														}
													}
													for (AttributeSet attSet : attributeSet) {
														for (EAttribute att : attSet.getAttribute()) {
															newAttributeSet.getAttribute().add(att);
														}
													}
													newCommand.getAttributes().add(newAttributeSet);
													ReferenceSet newReferenceSet = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createReferenceSet();
													List<ReferenceSet> referenceSet = new ArrayList<ReferenceSet>();
													for (EObject refSet : ModelManager.getReferences("references", command)) {
														if (refSet instanceof ReferenceSet) {
															referenceSet.add((ReferenceSet) refSet);
														}
													}
													for (ReferenceSet refSet : referenceSet) {
														for (EReference ref : refSet.getReference()) {
															newReferenceSet.getReference().add(ref);
														}
													}
													newCommand.getReferences().add(newReferenceSet);
													commandMetricsHelper(model, classes, newCommand, metricCommand, cl4, classMetrics, filterAbstract, packages);
												}
											}
										}
										else {
											classURI = EcoreUtil.getURI(cl4);
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
		return classURI;
	}

	private static void processModificationMetrics(EObject command, LinkedHashMap<URI, WodelMetricClass> classMetrics, WodelMetricClass metricClass, String atts, String refs, int[] counters) {
		try {
			WodelMetricAttribute[] metricatt = metricClass.getAttributes();
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
											counters[0]++;
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
											counters[0]++;
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
											counters[0]++;
										}
										if (wmatt.getName().equals(att.get(1).getName())) {
											wmatt.modification++;
											counters[0]++;
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
											counters[0]++;
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
											counters[0]++;
										}
									}
								}
							}
						}
						if (o.eClass().getName().equals("AttributeOperation")) {
							for (EReference refatt : o.eClass().getEAllReferences()) {
								if (refatt.getName().equals("attribute")) {
									List<EAttribute> att = (List<EAttribute>) o.eGet(refatt);
									for (WodelMetricAttribute wmatt : metricatt) {
										if (wmatt.getName().equals(att.get(0).getName())) {
											wmatt.modification++;
											counters[0]++;
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
											counters[0]++;
										}
									}
								}
							}
						}
						if (o.eClass().getName().equals("ReferenceAdd") ||
								o.eClass().getName().equals("ReferenceRemove")) {
							for (EReference refref : o.eClass().getEAllReferences()) {
								if (refref.getName().equals("reference")) {
									List<EReference> ref = (List<EReference>) o.eGet(refref);
									for (WodelMetricReference wmref : metricref) {
										if (wmref.getName().equals(ref.get(0).getName())) {
											wmref.modification++;
											counters[0]++;
											counters[1]++;
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
											counters[0]++;
										}
										if (wmref.getName().equals(ref.get(1).getName())) {
											wmref.modification++;
											counters[0]++;
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
							metricClass = classMetrics.get(EcoreUtil.getURI(ref.get(0).getEType()));
							for (WodelMetricAttribute wmatt : metricClass.getAttributes()) {
								if (wmatt.getName().equals(att.getName())) {
									wmatt.modification++;
									counters[0]++;
								}
							}
						}
					}
				}
				if (command.eClass().getName().equals("ModifySourceReferenceMutator") ||
					command.eClass().getName().equals("ModifyTargetReferenceMutator") ||
					command.eClass().getName().equals("CreateReferenceMutator") ||
					command.eClass().getName().equals("RemoveRandomReferenceMutator") ||
					command.eClass().getName().equals("RemoveSpecificReferenceMutator") ||
					command.eClass().getName().equals("RemoveCompleteReferenceMutator")) {
					EReference reference = (EReference) ModelManager.getReference(refs, command);
					for (WodelMetricReference wmref : metricClass.getReferences()) {
						if (wmref.getName().equals(reference.getName())) {
							wmref.modification++;
							counters[0]++;
						}
					}
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void processCreationMetrics(Resource model, List<EClass> classes, EObject command, WodelMetricCommand metricCommand, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, WodelMetricClass metricClass, int[] counters, boolean filterAbstract, List<EPackage> packages) {
		try {
			List<EObject> attributes = ModelManager.getReferences("attributes", command);
			List<String> explicitAttNames = new ArrayList<String>();
			for (EObject attModifier : attributes) {
				for (EReference ref : attModifier.eClass().getEAllReferences()) {
					if (ref.getName().equals("attribute")) {
						List<EAttribute> listAttributes = (List<EAttribute>) attModifier.eGet(ref);
						explicitAttNames.add(listAttributes.get(0).getName());
					}
				}
			}
			WodelMetricAttribute[] metricatt = metricClass.getAttributes();
			for (EAttribute eAttribute : mutatedClass.getEAllAttributes()) {
				for (WodelMetricAttribute wmatt : metricatt) {
					if (wmatt.getName().equals(eAttribute.getName())) {
						if (eAttribute.getLowerBound() > 0) {
							if (explicitAttNames.contains(wmatt.getName())) {
								wmatt.creation++;
								counters[0]++;
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
								counters[0]++;
							}
						}	
						break;
					}
				}

			}
			List<EObject> references = ModelManager.getReferences("references", command);
			List<String> explicitRefNames = new ArrayList<String>();
			for (EObject refModifier : references) {
				for (EReference ref : refModifier.eClass().getEAllReferences()) {
					if (ref.getName().equals("reference")) {
						List<EReference> listReferences = (List<EReference>) refModifier.eGet(ref);
						explicitRefNames.add(listReferences.get(0).getName());
					}
				}
			}
			WodelMetricReference[] metricref = metricClass.getReferences();
			for (EReference eReference : mutatedClass.getEAllReferences()) {
				for (WodelMetricReference wmref : metricref) {
					if (wmref.getName().equals(eReference.getName())) {
						if (eReference.getLowerBound() > 0) {
							if (explicitRefNames.contains(wmref.getName())) {
								wmref.creation++;
								counters[0]++;
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
								counters[0]++;
							}
						}
						break;
					}
				}
			}
			metricClass.creation+=counters[0];
			metricCommand.creation+=counters[0];
			metricClass.ccreation++;
			metricCommand.ccreation++;
			EClass containerClass = null;
			for (EClass ec : classes) {
				for (EReference ref : ec.getEAllReferences()) {
					if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
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
				List<EClass> superClasses = mutatedClass.getEAllSuperTypes();
				for (EClass superCl : superClasses) {
					if (filterAbstract == true) {
						if (superCl.isAbstract() == true) {
							continue;
						}
					}
					for (EClass ec : classes) {
						for (EReference ref : ec.getEAllReferences()) {
							if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(superCl))) {
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
				boolean proceed = true;
				if (filterAbstract == true) {
					if (containerClass.isAbstract() == true) {
						proceed = false;
					}
				}
				if (proceed == true) {
					WodelMetricClass metricContainer = classMetrics.get(EcoreUtil.getURI(containerClass));
					if (metricContainer != null) {
						WodelMetricReference[] containerRef = metricContainer.getReferences();
						for (EReference eReference : containerClass.getEAllReferences()) {
							if (EcoreUtil.getURI(eReference.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
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
				}
			}
			List<EClass> superClasses = mutatedClass.getEAllSuperTypes();
			for (EClass superClass : superClasses) {
				if (filterAbstract == true) {
					if (superClass.isAbstract() == true) {
						continue;
					}
				}
				WodelMetricClass metricSuperClass = classMetrics.get(EcoreUtil.getURI(superClass));
				if (metricSuperClass != null) {
					WodelMetricAttribute[] metricSuperAtt = metricSuperClass.getAttributes();
					counters[0] = 0;
					for (EAttribute eAttribute : superClass.getEAllAttributes()) {
						for (WodelMetricAttribute wmatt : metricSuperAtt) {
							if (wmatt.getName().equals(eAttribute.getName())) {
								if (eAttribute.getLowerBound() > 0) {
									wmatt.icreation++;
									counters[0]++;
								}
								else {
									if (explicitAttNames.contains(wmatt.getName())) {
										wmatt.icreation++;
										counters[0]++;
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
									counters[0]++;
								}
								else {
									if (explicitRefNames.contains(wmref.getName())) {
										wmref.icreation++;
										counters[0]++;
									}
								}
								break;
							}
						}
					}
					metricSuperClass.icreation+=counters[0];
					metricCommand.icreation+=counters[0];
					metricSuperClass.iccreation++;
					metricCommand.iccreation++;
					metricCommand.addClass(metricSuperClass);
				}
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
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							cl5 = ((RetypeObjectMutator) selection.getObjSel()).getType();
						}
						if (cl5 != null) {
							ModifyInformationMutator newCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
							RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
							rts.setType(cl5);
							newCommand.setObject(rts);
							ReferenceInit newReferenceInit = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
							newReferenceInit.getReference().add(refType);
							newCommand.getReferences().add(newReferenceInit);
							commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract, packages);
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
						commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract, packages);
					}
				}
			}
			if (command.eClass().getName().equals("CloneObjectMutator")) {
				boolean contents = ModelManager.getBooleanAttribute("contents", command);
				if (contents == true) {
					for (EReference ref : mutatedClass.getEAllReferences()) {
						if (ref.isContainment()) {
							List<EClass> recursion = new ArrayList<EClass>();
							recursion.add((EClass) ref.getEType());
							cloneMetricsHelper(model, classes, command, metricCommand, (EClass) ref.getEType(), classMetrics, filterAbstract, recursion);
						}
					}
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void processRemovalMetrics(Resource model, List<EClass> classes, EObject command, WodelMetricCommand metricCommand, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, WodelMetricClass metricClass, int[] counters, boolean filterAbstract, List<EPackage> packages) {
		try {
			EObject container = ModelManager.getReference("container", command);
			if (container == null) {
				WodelMetricAttribute[] metricatt = metricClass.getAttributes();
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
				WodelMetricReference[] metricref = metricClass.getReferences();
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
				EClass containerClass = null;
				for (EClass ec : classes) {
					for (EReference ref : ec.getEAllReferences()) {
						if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
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
					List<EClass> superClasses = mutatedClass.getEAllSuperTypes();
					for (EClass superCl : superClasses) {
						if (filterAbstract == true) {
							if (superCl.isAbstract() == true) {
								continue;
							}
						}
						for (EClass ec : classes) {
							for (EReference ref : ec.getEAllReferences()) {
								if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(superCl))) {
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
					boolean proceed = true;
					if (filterAbstract == true) {
						if (containerClass.isAbstract() == true) {
							proceed = false;
						}
					}
					if (proceed == true) {
						WodelMetricClass metricContainer = classMetrics.get(EcoreUtil.getURI(containerClass));
						if (metricContainer != null) {
							WodelMetricReference[] containerRef = metricContainer.getReferences();
							for (EReference eReference : containerClass.getEAllReferences()) {
								if (EcoreUtil.getURI(eReference.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
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
					}
				}
				List<EClass> subClasses = ModelManager.getESubClasses(packages, mutatedClass);
				for (EClass subClass : subClasses) {
					if (filterAbstract == true) {
						if (subClass.isAbstract() == true) {
							continue;
						}
					}
					WodelMetricClass metricSubClass = classMetrics.get(EcoreUtil.getURI(subClass));
					if (metricSubClass != null) {
						WodelMetricAttribute[] metricSubAtt = metricSubClass.getAttributes();
						counters[0] = 0;
						for (EAttribute eAttribute : subClass.getEAllAttributes()) {
							for (WodelMetricAttribute wmatt : metricSubAtt) {
								if (wmatt.getName().equals(eAttribute.getName())) {
									wmatt.ideletion++;
									counters[0]++;
									break;
								}
							}
						}
						WodelMetricReference[] metricSubRef = metricSubClass.getReferences();
						for (EReference eReference : subClass.getEAllReferences()) {
							for (WodelMetricReference wmref : metricSubRef) {
								if (wmref.getName().equals(eReference.getName())) {
									wmref.ideletion++;
									counters[0]++;
									break;
								}
							}
						}
						metricSubClass.ideletion+=counters[0];
						metricCommand.ideletion+=counters[0];
						metricSubClass.iddeletion++;
						metricCommand.iddeletion++;
						metricCommand.addClass(metricSubClass);
					}
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
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							cl5 = ((RetypeObjectMutator) selection.getObjSel()).getType();
						}
						if (cl5 != null) {
							ModifyInformationMutator newCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
							RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
							rts.setType(cl5);
							newCommand.setObject(rts);
							ReferenceInit newReferenceInit = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
							newReferenceInit.getReference().add(refType);
							newCommand.getReferences().add(newReferenceInit);
							commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract, packages);
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
						commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract, packages);
					}
				}
			}
			if (command.eClass().getName().equals("RemoveObjectMutator")) {
				for (EReference ref : mutatedClass.getEAllReferences()) {
					if (ref.isContainment()) {
						List<EClass> recursion = new ArrayList<EClass>();
						recursion.add((EClass) ref.getEType());
						removeMetricsHelper(model, classes, command, metricCommand, (EClass) ref.getEType(), classMetrics, filterAbstract, recursion, packages);
					}
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void processRetypingMetrics(Resource model, List<EClass> classes, EObject command, WodelMetricCommand metricCommand, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, WodelMetricClass metricClass, int[] counters, boolean filterAbstract, List<EPackage> packages) {
		try {
			EClass targetClass = MutatorUtils.getMutatorType((Mutator) command);
			WodelMetricClass metricTarget = classMetrics.get(EcoreUtil.getURI(targetClass));
			WodelMetricAttribute[] metricatttar = metricTarget.getAttributes();
			for (EAttribute eAttribute : targetClass.getEAllAttributes()) {
				for (WodelMetricAttribute wmatt : metricatttar) {
					if (wmatt.getName().equals(eAttribute.getName())) {
						if (eAttribute.getLowerBound() > 0) {
							wmatt.icreation++;
							metricTarget.icreation++;
							metricCommand.icreation++;
						}	
						break;
					}
				}

			}
			WodelMetricReference[] metricreftar = metricTarget.getReferences();
			for (EReference eReference : targetClass.getEAllReferences()) {
				for (WodelMetricReference wmref : metricreftar) {
					if (wmref.getName().equals(eReference.getName())) {
						if (eReference.getLowerBound() > 0) {
							wmref.icreation++;
							metricTarget.icreation++;
							metricCommand.icreation++;
						}
						break;
					}
				}
			}
			metricTarget.ccreation++;
			metricCommand.ccreation++;
			EClass containerClass = null;
			for (EClass ec : classes) {
				for (EReference ref : ec.getEAllReferences()) {
					if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(targetClass))) {
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
				List<EClass> superClasses = targetClass.getEAllSuperTypes();
				for (EClass superCl : superClasses) {
					if (filterAbstract == true) {
						if (superCl.isAbstract() == true) {
							continue;
						}
					}
					for (EClass ec : classes) {
						for (EReference ref : ec.getEAllReferences()) {
							if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(superCl))) {
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
				boolean proceed = true;
				if (filterAbstract == true) {
					if (containerClass.isAbstract() == true) {
						proceed = false;
					}
				}
				if (proceed == true) {
					WodelMetricClass metricContainer = classMetrics.get(EcoreUtil.getURI(containerClass));
					if (metricContainer != null) {
						WodelMetricReference[] containerRef = metricContainer.getReferences();
						for (EReference eReference : containerClass.getEAllReferences()) {
							if (EcoreUtil.getURI(eReference.getEType()).equals(EcoreUtil.getURI(targetClass))) {
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
				}
			}
			List<EClass> superClasses = targetClass.getEAllSuperTypes();
			for (EClass superClass : superClasses) {
				if (filterAbstract == true) {
					if (superClass.isAbstract() == true) {
						continue;
					}
				}
				WodelMetricClass metricSuperClass = classMetrics.get(EcoreUtil.getURI(superClass));
				if (metricSuperClass != null) {
					WodelMetricAttribute[] metricSuperAtt = metricSuperClass.getAttributes();
					counters[0] = 0;
					for (EAttribute eAttribute : superClass.getEAllAttributes()) {
						for (WodelMetricAttribute wmatt : metricSuperAtt) {
							if (wmatt.getName().equals(eAttribute.getName())) {
								if (eAttribute.getLowerBound() > 0) {
									wmatt.icreation++;
									counters[0]++;
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
									counters[0]++;
								}
								break;
							}
						}
					}
					metricSuperClass.icreation+=counters[0];
					metricCommand.icreation+=counters[0];
					metricSuperClass.iccreation++;
					metricCommand.iccreation++;
					metricCommand.addClass(metricSuperClass);
				}
			}
			for (EReference ref : targetClass.getEAllReferences()) {
				if (ref.isContainment()) {
					List<EClass> recursion = new ArrayList<EClass>();
					recursion.add((EClass) ref.getEType());
					cloneMetricsHelper(model, classes, command, metricCommand, (EClass) ref.getEType(), classMetrics, filterAbstract, recursion);
				}
			}
			metricCommand.addClass(metricTarget);
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
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							cl5 = ((RetypeObjectMutator) selection.getObjSel()).getType();
						}
						if (cl5 != null) {
							ModifyInformationMutator newCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
							RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
							rts.setType(cl5);
							newCommand.setObject(rts);
							ReferenceInit newReferenceInit = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
							newReferenceInit.getReference().add(refType);
							newCommand.getReferences().add(newReferenceInit);
							commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract, packages);
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
						commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract, packages);
					}
				}
			}
			WodelMetricAttribute[] metricatt = metricClass.getAttributes();
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
			WodelMetricReference[] metricref = metricClass.getReferences();
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
			containerClass = null;
			for (EClass ec : classes) {
				for (EReference ref : ec.getEAllReferences()) {
					if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
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
				superClasses = mutatedClass.getEAllSuperTypes();
				for (EClass superCl : superClasses) {
					if (filterAbstract == true) {
						if (superCl.isAbstract() == true) {
							continue;
						}
					}
					for (EClass ec : classes) {
						for (EReference ref : ec.getEAllReferences()) {
							if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(superCl))) {
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
				boolean proceed = true;
				if (filterAbstract == true) {
					if (containerClass.isAbstract() == true) {
						proceed = false;
					}
				}
				if (proceed == true) {
					WodelMetricClass metricContainer = classMetrics.get(EcoreUtil.getURI(containerClass));
					if (metricContainer != null) {
						WodelMetricReference[] containerRef = metricContainer.getReferences();
						for (EReference eReference : containerClass.getEAllReferences()) {
							if (EcoreUtil.getURI(eReference.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
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
				}
			}
			List<EClass> subClasses = ModelManager.getESubClasses(packages, mutatedClass);
			for (EClass subClass : subClasses) {
				if (filterAbstract == true) {
					if (subClass.isAbstract() == true) {
						continue;
					}
				}
				WodelMetricClass metricSubClass = classMetrics.get(EcoreUtil.getURI(subClass));
				if (metricSubClass != null) {
					WodelMetricAttribute[] metricSubAtt = metricSubClass.getAttributes();
					counters[0] = 0;
					for (EAttribute eAttribute : subClass.getEAllAttributes()) {
						for (WodelMetricAttribute wmatt : metricSubAtt) {
							if (wmatt.getName().equals(eAttribute.getName())) {
								wmatt.ideletion++;
								counters[0]++;
								break;
							}
						}
					}
					WodelMetricReference[] metricSubRef = metricSubClass.getReferences();
					for (EReference eReference : subClass.getEAllReferences()) {
						for (WodelMetricReference wmref : metricSubRef) {
							if (wmref.getName().equals(eReference.getName())) {
								wmref.ideletion++;
								counters[0]++;
								break;
							}
						}
					}
					metricSubClass.ideletion+=counters[0];
					metricCommand.ideletion+=counters[0];
					metricSubClass.iddeletion++;
					metricCommand.iddeletion++;
					metricCommand.addClass(metricSubClass);
				}
			}
			for (EReference ref : mutatedClass.getEAllReferences()) {
				if (ref.isContainment()) {
					List<EClass> recursion = new ArrayList<EClass>();
					recursion.add((EClass) ref.getEType());
					removeMetricsHelper(model, classes, command, metricCommand, (EClass) ref.getEType(), classMetrics, filterAbstract, recursion, packages);
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
						if (selection.getObjSel() instanceof RetypeObjectMutator) {
							cl5 = ((RetypeObjectMutator) selection.getObjSel()).getType();
						}
						if (cl5 != null) {
							ModifyInformationMutator newCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
							RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
							rts.setType(cl5);
							newCommand.setObject(rts);
							ReferenceInit newReferenceInit = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
							newReferenceInit.getReference().add(refType);
							newCommand.getReferences().add(newReferenceInit);
							commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract, packages);
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
						commandMetricsHelper(model, classes, newCommand, metricCommand, cl5, classMetrics, filterAbstract, packages);
					}
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getCommandMetrics(Resource model, List<EClass> classes, EObject command, WodelMetricCommand metricCommand, EClass mutatedClass, String refName, LinkedHashMap<String, String> strategies, String atts, String refs, int operation, LinkedHashMap<URI, WodelMetricClass> classMetrics, boolean filterAbstract, List<EPackage> packages) {
		try {
			EObject cl = ModelManager.getReference(refName, command);
			if (cl != null) {
				URI classURI = getClassURI(model, classes, command, metricCommand, mutatedClass, strategies, classMetrics, filterAbstract, packages, cl);
				if (EcoreUtil.getURI(mutatedClass).equals(classURI) == true) {
					WodelMetricClass metricClass = classMetrics.get(classURI);
					if (metricClass != null) {
						int[] counters = new int[2];
						processModificationMetrics(command, classMetrics, metricClass, atts, refs, counters); 
						//modification mutations
						if (operation == 0) {
							processCreationMetrics(model, classes, command, metricCommand, mutatedClass, classMetrics, metricClass, counters, filterAbstract, packages);
						}
						if (operation == 1) {
							metricClass.modification+= counters[0];
							metricCommand.modification+= counters[0];
							if (counters[1] > 0) {
								metricClass.mmodification += counters[1] - 1;
								metricCommand.mmodification += counters[1] - 1;
							}
							metricClass.mmodification++;
							metricCommand.mmodification++;
							metricCommand.addClass(metricClass);
						}
						if (operation == 2) {
							processRemovalMetrics(model, classes, command, metricCommand, mutatedClass, classMetrics, metricClass, counters, filterAbstract, packages);
						}
						if (operation == 3) {
							processRetypingMetrics(model, classes, command, metricCommand, mutatedClass, classMetrics, metricClass, counters, filterAbstract, packages);
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

	private static void commandMetricsHelper(Resource model, List<EClass> classes, EObject command, WodelMetricCommand metricCommand, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, boolean filterAbstract, List<EPackage> packages) {
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
			if (eClass.getName().equals("RetypeObjectMutator")) {
				refName = "object";
				strategies = createStrategies();
				operation = 3;
			}
		}
		getCommandMetrics(model, classes, command, metricCommand, mutatedClass, refName, strategies, atts, refs, operation, classMetrics, filterAbstract, packages);
	}

	private static LinkedHashMap<URI, WodelMetricClass> createClassMetrics(List<EClass> classes) {
		LinkedHashMap<URI, WodelMetricClass> classMetrics = new LinkedHashMap<URI, WodelMetricClass>();

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
			classMetrics.put(EcoreUtil.getURI(cl), metric);
		}
		return classMetrics;
	}

	public static WodelMetricCommand[] createWodelCommandMetrics(String xmiFileName, String metamodel) {
		try {
			Bundle bundle = Platform.getBundle("wodel.models");
			URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
			String mutatorecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource program = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString());

			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			List<EClass> classes = ModelManager.getEClasses(packages);

			boolean filterAbstract = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Filter concrete classes", false, null);

			List<WodelMetricCommand> metricCommands = new ArrayList<WodelMetricCommand>();
			Map<String, List<EObject>> blocks = MutatorUtils.getBlockCommands(program);
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
							LinkedHashMap<URI, WodelMetricClass> classMetrics = createClassMetrics(classes);
							commandMetricsHelper(program, classes, command, metricCommand, cl, classMetrics, filterAbstract, packages);
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
				List<EObject> commands = MutatorUtils.getCommands(program);
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
							LinkedHashMap<URI, WodelMetricClass> classMetrics = createClassMetrics(classes);
							commandMetricsHelper(program, classes, command, metricCommand, cl, classMetrics, filterAbstract, packages);
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
