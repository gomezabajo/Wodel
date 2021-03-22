package wodel.metrics.fixed;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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
 * MetaModelMutatorMetrics meta-model static footprints
 * 
 */
public class MetaModelMutatorMetrics extends manager.StaticMutatorMetrics {

	private static void staticCloneMetricsHelper(Resource model, List<EClass> classes, EObject command, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, boolean filterAbstract, List<EClass> recursion) {
		int counter = 0;
		WodelMetricClass metric = classMetrics.get(EcoreUtil.getURI(mutatedClass));
		if (metric == null) {
			return;
		}
		WodelMetricAttribute[] metricatt = metric.getAttributes();
		for (EAttribute eAttribute : mutatedClass.getEAllAttributes()) {
			for (WodelMetricAttribute wmatt : metricatt) {
				if (wmatt.getName().equals(eAttribute.getName())) {
					if (eAttribute.getLowerBound() > 0) {
						wmatt.icreation++;
						metric.icreation++;
					}
					break;
				}
			}
		}
		WodelMetricReference[] metricref = metric.getReferences();
		for (EReference eReference : mutatedClass.getEAllReferences()) {
			for (WodelMetricReference wmref : metricref) {
				if (wmref.getName().equals(eReference.getName())) {
					if (eReference.getLowerBound() > 0) {
						wmref.icreation++;
						metric.icreation++;
					}
					break;
				}
			}
		}
		metric.iccreation++;

		List<EClass> superClasses = mutatedClass.getEAllSuperTypes();
		for (EClass superClass : superClasses) {
			if (filterAbstract == true) {
				if (superClass.isAbstract() == true) {
					continue;
				}
			}
			WodelMetricClass metricSuperClass = classMetrics.get(EcoreUtil.getURI(superClass));
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
			metricSuperClass.iccreation++;
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
				}
			}
		}
		if (command.eClass().getName().equals("CloneObjectMutator")) {
			boolean contents = ModelManager.getBooleanAttribute("contents", command);
			if (contents == true) {
				for (EReference ref : mutatedClass.getEAllReferences()) {
					boolean previous = false;
					for (EClass rec : recursion) {
						if (EcoreUtil.getURI(rec).equals(EcoreUtil.getURI(ref.getEType()))) {
							previous = true;
							break;
						}
					}
					if (ref.isContainment() && previous == false) {
						recursion.add((EClass) ref.getEType());
						cloneMetricsClassHelper(model, classes, command, (EClass) ref.getEType(), classMetrics, filterAbstract, recursion);
					}
				}
			}
		}
	}

	private static void cloneMetricsClassHelper(Resource model, List<EClass> classes, EObject command, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, boolean filterAbstract, List<EClass> recursion) {
		if (filterAbstract && mutatedClass.isAbstract()) {
			return;
		}
		CloneObjectMutator cloneCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createCloneObjectMutator();
		RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
		rts.setType(mutatedClass);
		cloneCommand.setObject(rts);
		cloneCommand.setContents(true);
		staticCloneMetricsHelper(model, classes, cloneCommand, mutatedClass, classMetrics, filterAbstract, recursion);
	}

	private static void staticRemoveMetricsHelper(Resource model, List<EClass> classes, EObject command, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, boolean filterAbstract, List<EClass> recursion, List<EPackage> packages, boolean explicit) {
		WodelMetricClass metric = classMetrics.get(EcoreUtil.getURI(mutatedClass));
		if (metric == null) {
			return;
		}
		WodelMetricAttribute[] metricatt = metric.getAttributes();
		for (EAttribute eAttribute : mutatedClass.getEAllAttributes()) {
			for (WodelMetricAttribute wmatt : metricatt) {
				if (wmatt.getName().equals(eAttribute.getName())) {
					wmatt.ideletion++;
					metric.ideletion++;
					break;
				}
			}
		}
		WodelMetricReference[] metricref = metric.getReferences();
		for (EReference eReference : mutatedClass.getEAllReferences()) {
			for (WodelMetricReference wmref : metricref) {
				if (wmref.getName().equals(eReference.getName())) {
					wmref.ideletion++;
					metric.ideletion++;
					break;
				}
			}
		}
		if (!explicit) {
			metric.iddeletion++;
		}
		else {
			metric.ddeletion++;
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
			WodelMetricClass metricContainer = classMetrics.get(EcoreUtil.getURI(containerClass));
			if (metricContainer != null) {
				WodelMetricReference[] containerRef = metricContainer.getReferences();
				for (EReference eReference : containerClass.getEAllReferences()) {
					boolean isTypeOf = false;
					List<EClass> types = new ArrayList<EClass>();
					types.add(mutatedClass);
					types.addAll(mutatedClass.getEAllSuperTypes());
					for (EClass type : types) {
						if (EcoreUtil.getURI(type).equals(EcoreUtil.getURI(eReference.getEReferenceType()))) {
							isTypeOf = true;
							break;
						}
					}
					if (isTypeOf == true) {
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
		}
		List<EClass> subClasses = ModelManager.getESubClasses(packages, mutatedClass);
		for (EClass subClass : subClasses) {
			if (filterAbstract == true) {
				if (subClass.isAbstract() == true) {
					continue;
				}
			}
			WodelMetricClass metricSubClass = classMetrics.get(EcoreUtil.getURI(subClass));
			int counter = 0;
			if (metricSubClass != null) {
				WodelMetricAttribute[] metricSubAtt = metricSubClass.getAttributes();
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
				if (metricSubRef != null) {
					for (EReference eReference : subClass.getEAllReferences()) {
						for (WodelMetricReference wmref : metricSubRef) {
							if (wmref.getName().equals(eReference.getName())) {
								wmref.ideletion++;
								counter++;
								break;
							}
						}
					}
				}
				metricSubClass.ideletion+=counter;
				metricSubClass.iddeletion++;
			}
		}
		if (command.eClass().getName().equals("RemoveObjectMutator")) {
			for (EReference ref : mutatedClass.getEAllReferences()) {
				boolean previous = false;
				for (EClass rec : recursion) {
					if (EcoreUtil.getURI(rec).equals(EcoreUtil.getURI(ref.getEType()))) {
						previous = true;
						break;
					}
				}
				if (ref.isContainment() && previous == false) {
					recursion.add((EClass) ref.getEType());
					removeMetricsClassHelper(model, classes, command, (EClass) ref.getEType(), classMetrics, filterAbstract, recursion, packages, explicit);
				}
			}
		}
	}

	private static void removeMetricsClassHelper(Resource model, List<EClass> classes, EObject command, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, boolean filterAbstract, List<EClass> recursion, List<EPackage> packages, boolean explicit) {
		if (filterAbstract && mutatedClass.isAbstract()) {
			return;
		}
		RemoveObjectMutator removeCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRemoveObjectMutator();
		RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
		rts.setType(mutatedClass);
		removeCommand.setObject(rts);
		staticRemoveMetricsHelper(model, classes, removeCommand, mutatedClass, classMetrics, filterAbstract, recursion, packages, explicit);
	}

	private static void processModificationCommandMetrics(EObject command, WodelMetricClass metricClass, String atts, String refs, LinkedHashMap<URI, WodelMetricClass> classMetrics, int[] counters) {
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
						if (o.eClass().getName().equals("ReferenceAdd")) {
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
						if (o.eClass().getName().equals("ReferenceRemove")) {
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
							metricClass = classMetrics.get(EcoreUtil.getURI(((EClass) ref.get(0).getEType())));
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

	private static void processCreationCommandMetrics(Resource model, List<EClass> classes, EObject command, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, WodelMetricClass metricClass, int[] counters, boolean filterAbstract, List<EPackage> packages) {
		try {
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
			ArrayList<String> explicitRefNames = new ArrayList<String>();
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
			metricClass.ccreation++;
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
					metricSuperClass.iccreation++;
				}
			}
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
							commandMetricsClassHelper(model, classes, newCommand, cl5, classMetrics, filterAbstract, packages);
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
						commandMetricsClassHelper(model, classes, newCommand, cl5, classMetrics, filterAbstract, packages);
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
							cloneMetricsClassHelper(model, classes, command, (EClass) ref.getEType(), classMetrics, filterAbstract, recursion);
						}
					}
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void processRemovalCommandMetrics(Resource model, List<EClass> classes, EObject command, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, WodelMetricClass metricClass, int[] counters, boolean filterAbstract, List<EPackage> packages) {
		WodelMetricAttribute[] metricatt = metricClass.getAttributes();
		for (EAttribute eAttribute : mutatedClass.getEAllAttributes()) {
			for (WodelMetricAttribute wmatt : metricatt) {
				if (wmatt.getName().equals(eAttribute.getName())) {
					wmatt.ideletion++;
					metricClass.ideletion++;
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
					break;
				}
			}
		}
		metricClass.ddeletion++;
		EClass container = null;
		for (EClass ec : classes) {
			for (EReference ref : ec.getEAllReferences()) {
				if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
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
			List<EClass> superClasses = mutatedClass.getEAllSuperTypes();
			for (EClass superCl : superClasses) {
				for (EClass ec : classes) {
					for (EReference ref : ec.getEAllReferences()) {
						if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(superCl))) {
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
			WodelMetricClass metricContainer = classMetrics.get(EcoreUtil.getURI(container));
			if (metricContainer != null) {
				WodelMetricReference[] containerRef = metricContainer.getReferences();
				for (EReference eReference : container.getEAllReferences()) {
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
						commandMetricsClassHelper(model, classes, newCommand, cl5, classMetrics, filterAbstract, packages);
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
					commandMetricsClassHelper(model, classes, newCommand, cl5, classMetrics, filterAbstract, packages);
				}
			}
			for (EReference ref : mutatedClass.getEAllReferences()) {
				if (ref.isContainment()) {
					List<EClass> recursion = new ArrayList<EClass>();
					recursion.add((EClass) ref.getEType());
					removeMetricsClassHelper(model, classes, command, (EClass) ref.getEType(), classMetrics, filterAbstract, recursion, packages, false);
				}
			}
		}
		if (command.eClass().getName().equals("RemoveObjectMutator")) {
			for (EReference ref : mutatedClass.getEAllReferences()) {
				if (ref.isContainment()) {
					List<EClass> recursion = new ArrayList<EClass>();
					recursion.add((EClass) ref.getEType());
					removeMetricsClassHelper(model, classes, command, (EClass) ref.getEType(), classMetrics, filterAbstract, recursion, packages, false);
				}
			}
		}
	}
	
	private static void processRetypingCommandMetrics(Resource model, List<EClass> classes, EObject command, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, WodelMetricClass metricClass, int[] counters, boolean filterAbstract, List<EPackage> packages) {
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
						}
						break;
					}
				}
			}
			metricTarget.ccreation++;
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
					metricSuperClass.iccreation++;
				}
			}
			for (EReference ref : targetClass.getEAllReferences()) {
				if (ref.isContainment()) {
					List<EClass> recursion = new ArrayList<EClass>();
					recursion.add((EClass) ref.getEType());
					cloneMetricsClassHelper(model, classes, command, (EClass) ref.getEType(), classMetrics, filterAbstract, recursion);
				}
			}
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
							commandMetricsClassHelper(model, classes, newCommand, cl5, classMetrics, filterAbstract, packages);
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
						commandMetricsClassHelper(model, classes, newCommand, cl5, classMetrics, filterAbstract, packages);
					}
				}
			}
			
			WodelMetricAttribute[] metricatt = metricClass.getAttributes();
			for (EAttribute eAttribute : mutatedClass.getEAllAttributes()) {
				for (WodelMetricAttribute wmatt : metricatt) {
					if (wmatt.getName().equals(eAttribute.getName())) {
						wmatt.ideletion++;
						metricClass.ideletion++;
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
						break;
					}
				}
			}
			metricClass.ddeletion++;
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
							commandMetricsClassHelper(model, classes, newCommand, cl5, classMetrics, filterAbstract, packages);
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
						commandMetricsClassHelper(model, classes, newCommand, cl5, classMetrics, filterAbstract, packages);
					}
				}
			}
			for (EReference ref : mutatedClass.getEAllReferences()) {
				if (ref.isContainment()) {
					List<EClass> recursion = new ArrayList<EClass>();
					recursion.add((EClass) ref.getEType());
					removeMetricsClassHelper(model, classes, command, (EClass) ref.getEType(), classMetrics, filterAbstract, recursion, packages, false);
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getCommandMetricsClass(Resource model, List<EClass> classes, EObject command, EClass mutatedClass, String refName, LinkedHashMap<String, String> strategies, String atts, String refs, int operation, LinkedHashMap<URI, WodelMetricClass> classMetrics, boolean filterAbstract, List<EPackage> packages) {
		try {
			EObject cl = ModelManager.getReference(refName, command);
			if (cl != null) {
				WodelMetricClass metricClass = classMetrics.get(EcoreUtil.getURI(mutatedClass));
				int[] counters = new int[2];
				processModificationCommandMetrics(command, metricClass, atts, refs, classMetrics, counters);
				if (operation == 0) {
					processCreationCommandMetrics(model, classes, command, mutatedClass, classMetrics, metricClass, counters, filterAbstract, packages);
				}
				if (operation == 1) {
					metricClass.modification+= counters[0];
					if (counters[1] > 0) {
						metricClass.mmodification += counters[1] - 1;
					}
					metricClass.mmodification++;
				}
				if (operation == 2) {
					processRemovalCommandMetrics(model, classes, command, mutatedClass, classMetrics, metricClass, counters, filterAbstract, packages);
				}
				if (operation == 3) {
					processRetypingCommandMetrics(model, classes, command, mutatedClass, classMetrics, metricClass, counters, filterAbstract, packages);
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

	private static void commandMetricsClassHelper(Resource model, List<EClass> classes, EObject command, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> classMetrics, boolean filterAbstract, List<EPackage> packages) {
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
			if (eClass.getName().contentEquals("RetypeObjectMutator")) {
				refName = "object";
				strategies = createStrategies();
				operation = 3;
			}
		}
		getCommandMetricsClass(model, classes, command, mutatedClass, refName, strategies, atts, refs, operation, classMetrics, filterAbstract, packages);
	}

	private static List<URI> getClassURI(Resource model, List<EClass> classes, String mutatorName, EObject obj, URI uri, LinkedHashMap<String, String> strategies, LinkedHashMap<URI, WodelMetricClass> metrics, boolean filterAbstract, List<EPackage> packages, EObject cl) {
		List<URI> classURI = new ArrayList<URI>();
		try {
			if (strategies == null) {
				classURI.add(EcoreUtil.getURI(cl));
			}
			else {
				for (String strategy : strategies.keySet()) {
					if (cl.eClass().getName().equals(strategy)) {
						EObject cl2 = ModelManager.getReference("type", cl);
						if (cl2 != null) {
							classURI.add(EcoreUtil.getURI(cl2));
						}
						else {
							List<EObject> cls = ModelManager.getReferences("types", cl);
							if (cls != null && cls.size() > 0) {
								for (EObject c : cls) {
									classURI.add(EcoreUtil.getURI(c));
								}
							}
							else {
								EObject cl3 = ModelManager.getReference("objSel", cl);
								if (cl3 != null) {
									if (cl3.eClass().getName().equals("CreateObjectMutator")) {
										EObject cl4 = ModelManager.getReference("type", cl3);
										if (cl4 != null) {
											classURI.add(EcoreUtil.getURI(cl4));
										}
									}
									if (cl3.eClass().getName().equals("CloneObjectMutator")) {
										EObject cl4 = ModelManager.getReference("type", cl3);
										if (cl4 != null) {
											classURI.add(EcoreUtil.getURI(cl4));
										}
									}
									if (cl3.eClass().getName().equals("SelectObjectMutator") || cl3.eClass().getName().equals("SelectSampleMutator")) {
										String mutator = ModelManager.getStringAttribute("name", cl3);
										EClass cl4 = MutatorUtils.getMutatorType(model, mutator);
										if (cl4 != null) {
											EClass cl5 = MutatorUtils.getMutatorContainerType(model, mutator);
											if (cl5 != null) {
												if (EcoreUtil.getURI(cl5).equals(uri)) {
													if (mutatorName.equals("RemoveObjectMutator")) {
														//ModifyInformationMutator newCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
														RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
														rts.setType(cl5);
														//													newCommand.setObject(rts);
														//													ReferenceInit newReferenceInit = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
														EReference reference = null;
														for (EReference ref : cl5.getEAllReferences()) {
															List<EClass> types = new ArrayList<EClass>();
															types.add(ref.getEReferenceType());
															types.addAll(ModelManager.getESubClasses(packages, ref.getEReferenceType()));
															for (EClass type : types) {
																if (EcoreUtil.getURI(type).equals(EcoreUtil.getURI(cl4))) {
																	reference = ref;
																	break;
																}
															}
														}
														//													newReferenceInit.getReference().add(reference);
														//													newCommand.getReferences().add(newReferenceInit);
														//													commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract, packages);
														if (reference != null && reference.isContainment()) {
															RemoveObjectMutator removeCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRemoveObjectMutator();
															rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
															rts.setType(cl4);
															removeCommand.setObject(rts);
															List<EClass> recursion = new ArrayList<EClass>();
															recursion.add(cl4);
															removeMetricsClassHelper(model, classes, obj, cl4, metrics, filterAbstract, recursion, packages, false);
														}
													}
													if (mutatorName.equals("ModifyInformationMutator")) {
														ModifyInformationMutator newCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
														RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
														rts.setType(cl4);
														newCommand.setObject(rts);
														AttributeSet newAttributeSet = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createAttributeSet();
														List<AttributeSet> attributeSet = new ArrayList<AttributeSet>();
														for (EObject attSet : ModelManager.getReferences("attributes", obj)) {
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
														for (EObject refSet : ModelManager.getReferences("references", obj)) {
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
														commandMetricsClassHelper(model, classes, newCommand, cl4, metrics, filterAbstract, packages);
													}
												}
												else {
													EClass cl6 = MutatorUtils.getMutatorObjectType(model, mutator);
													if (cl6 != null) {
														if (EcoreUtil.getURI(cl6).equals(uri)) {
															if (mutatorName.equals("RemoveObjectMutator")) {
																//ModifyInformationMutator newCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
																RandomTypeSelection rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
																rts.setType(cl6);
																RemoveObjectMutator removeCommand = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRemoveObjectMutator();
																rts = mutatorenvironment.MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
																rts.setType(cl4);
																removeCommand.setObject(rts);
																List<EClass> recursion = new ArrayList<EClass>();
																recursion.add(cl4);
																removeMetricsClassHelper(model, classes, obj, cl4, metrics, filterAbstract, recursion, packages, true);
															}
														}
													}
												}
											}
											else {
												classURI.add(EcoreUtil.getURI(cl4));
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
		
		return classURI;
	}
	
	private static void processModificationMetrics(Resource model, EObject obj, WodelMetricClass metric, String atts, String refs, LinkedHashMap<URI, WodelMetricClass> metrics, int[] counters) {
		try {
			if (metric != null) {
				WodelMetricAttribute[] metricatt = metric.getAttributes();
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
												counters[0]++;
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
												counters[0]++;
												counters[1]++;
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
								metric = metrics.get(EcoreUtil.getURI(((EClass) ref.get(0).getEType())));
								for (WodelMetricAttribute wmatt : metric.getAttributes()) {
									if (wmatt.getName().equals(att.getName())) {
										wmatt.modification++;
										counters[0]++;
									}
								}
							}
						}
					}
					if (obj.eClass().getName().equals("ModifySourceReferenceMutator") ||
							obj.eClass().getName().equals("ModifyTargetReferenceMutator") ||
							obj.eClass().getName().equals("CreateReferenceMutator") ||
							obj.eClass().getName().equals("RemoveRandomReferenceMutator") ||
							obj.eClass().getName().equals("RemoveSpecificReferenceMutator") ||
							obj.eClass().getName().equals("RemoveCompleteReferenceMutator")) {
						EReference reference = (EReference) ModelManager.getReference(refs, obj);
						for (WodelMetricReference wmref : metric.getReferences()) {
							if (wmref.getName().equals(reference.getName())) {
								wmref.modification++;
								counters[0]++;
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

	private static void processCreationMetrics(Resource model, List<EClass> classes, EObject obj, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> metrics, WodelMetricClass metric, int[] counters, boolean filterAbstract, List<EPackage> packages) {
		try {
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
			WodelMetricAttribute[] metricatt = metric.getAttributes();
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
								metric.icreation++;
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
			WodelMetricReference[] metricref = metric.getReferences();
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
								metric.icreation++;
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
			metric.creation+=counters[0];
			metric.ccreation++;

			EClass containerClass = null;
			EClass containedClass = null;
			for (EClass ec : classes) {
				for (EReference ref : ec.getEAllReferences()) {
					if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
						if (ref.isContainment()) {
							containedClass = mutatedClass;
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
			if (containerClass == null) {
				for (EClass superCl : superClasses) {
					for (EClass ec : classes) {
						for (EReference ref : ec.getEAllReferences()) {
							if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(superCl))) {
								if (ref.isContainment()) {
									containedClass = superCl;
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
				WodelMetricClass metricContainer = metrics.get(EcoreUtil.getURI(containerClass));
				if (metricContainer != null) {
					WodelMetricReference[] containerRef = metricContainer.getReferences();
					for (EReference eReference : containerClass.getEAllReferences()) {
						if (EcoreUtil.getURI(eReference.getEType()).equals(EcoreUtil.getURI(containedClass))) {
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
			}
			for (EClass superClass : superClasses) {
				WodelMetricClass metricSuperClass = metrics.get(EcoreUtil.getURI(superClass));
				if (metricSuperClass != null) {
					WodelMetricAttribute[] metricSuperAtt = metricSuperClass.getAttributes();
					counters[0] = 0;
					for (EAttribute eAttribute : superClass.getEAllAttributes()) {
						for (WodelMetricAttribute wmatt : metricSuperAtt) {
							if (wmatt.getName().equals(eAttribute.getName())) {
								if (eAttribute.getLowerBound() > 0) {
									wmatt.icreation++;
									counters[0]++;
									break;
								}
								else {
									if (explicitAttNames.contains(wmatt.getName())) {
										wmatt.icreation++;
										counters[0]++;
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
									counters[0]++;
									break;
								}
								else {
									if (explicitRefNames.contains(wmref.getName())) {
										wmref.icreation++;
										counters[0]++;
										break;
									}
								}
							}
						}
					}
					metricSuperClass.icreation+=counters[0];
					metricSuperClass.iccreation++;
				}
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
							commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract, packages);
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
						commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract, packages);
					}
				}
			}
			if (obj.eClass().getName().equals("CloneObjectMutator")) {
				boolean contents = ModelManager.getBooleanAttribute("contents", obj);
				if (contents == true) {
					for (EReference ref : mutatedClass.getEAllReferences()) {
						if (ref.isContainment()) {
							List<EClass> recursion = new ArrayList<EClass>();
							recursion.add((EClass) ref.getEType());
							cloneMetricsClassHelper(model, classes, obj, (EClass) ref.getEType(), metrics, filterAbstract, recursion);
						}
					}
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void processRemovalMetrics(Resource model, List<EClass> classes, EObject obj, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> metrics, WodelMetricClass metric, int[] counters, boolean filterAbstract, List<EPackage> packages) {
		try {
			EObject container = ModelManager.getReference("container", obj);
			if (container == null) {
				WodelMetricAttribute[] metricatt = metric.getAttributes();
				for (EAttribute eAttribute : mutatedClass.getEAllAttributes()) {
					for (WodelMetricAttribute wmatt : metricatt) {
						if (wmatt.getName().equals(eAttribute.getName())) {
							wmatt.ideletion++;
							metric.ideletion++;
							break;
						}
					}
				}
				WodelMetricReference[] metricref = metric.getReferences();
				for (EReference eReference : mutatedClass.getEAllReferences()) {
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
				EClass containedClass = null;
				for (EClass ec : classes) {
					for (EReference ref : ec.getEAllReferences()) {
						if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
							if (ref.isContainment()) {
								containedClass = mutatedClass;
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
						for (EClass ec : classes) {
							for (EReference ref : ec.getEAllReferences()) {
								if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(superCl))) {
									if (ref.isContainment()) {
										containedClass = superCl;
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
					WodelMetricClass metricContainer = metrics.get(EcoreUtil.getURI(containerClass));
					if (metricContainer != null) {
						WodelMetricReference[] containerRef = metricContainer.getReferences();
						for (EReference eReference : containerClass.getEAllReferences()) {
							if (EcoreUtil.getURI(eReference.getEType()).equals(EcoreUtil.getURI(containedClass))) {
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
				}
				List<EClass> subClasses = ModelManager.getESubClasses(packages, mutatedClass);
				for (EClass subClass : subClasses) {
					WodelMetricClass metricSubClass = metrics.get(EcoreUtil.getURI(subClass));
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
						metricSubClass.iddeletion++;
					}
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
							commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract, packages);
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
						commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract, packages);
					}
				}
			}
			if (obj.eClass().getName().equals("RemoveObjectMutator")) {
				for (EReference ref : mutatedClass.getEAllReferences()) {
					if (ref.isContainment()) {
						List<EClass> recursion = new ArrayList<EClass>();
						recursion.add((EClass) ref.getEType());
						removeMetricsClassHelper(model, classes, obj, (EClass) ref.getEType(), metrics, filterAbstract, recursion, packages, false);
					}
				}
			}
			
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void processRetypingMetrics(Resource model, List<EClass> classes, EObject obj, EClass mutatedClass, LinkedHashMap<URI, WodelMetricClass> metrics, WodelMetricClass metric, int[] counters, boolean filterAbstract, List<EPackage> packages) {
		try {
			EClass targetClass = MutatorUtils.getMutatorType((Mutator) obj);
			if (targetClass == null) {
				List<EClass> targetClasses = MutatorUtils.getMutatorTypes((Mutator) obj);
				for (EClass tarClass : targetClasses) {
					if (EcoreUtil.getURI(tarClass).equals(EcoreUtil.getURI(mutatedClass))) {
						targetClasses.remove(tarClass);
						break;
					}
				}
				for (EClass tarClass : targetClasses) {
					WodelMetricClass metricTarget = metrics.get(EcoreUtil.getURI(tarClass));
					WodelMetricAttribute[] metricatttar = metricTarget.getAttributes();
					for (EAttribute eAttribute : tarClass.getEAllAttributes()) {
						for (WodelMetricAttribute wmatt : metricatttar) {
							if (wmatt.getName().equals(eAttribute.getName())) {
								if (eAttribute.getLowerBound() > 0) {
									wmatt.icreation++;
									metricTarget.icreation++;
								}
								break;
							}
						}

					}
					WodelMetricReference[] metricreftar = metricTarget.getReferences();
					for (EReference eReference : tarClass.getEAllReferences()) {
						for (WodelMetricReference wmref : metricreftar) {
							if (wmref.getName().equals(eReference.getName())) {
								if (eReference.getLowerBound() > 0) {
									wmref.icreation++;
									metricTarget.icreation++;
								}
								break;
							}
						}
					}
					metricTarget.ccreation++;
					EClass containerClass = null;
					EClass containedClass = null;
					for (EClass ec : classes) {
						for (EReference ref : ec.getEAllReferences()) {
							if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(tarClass))) {
								if (ref.isContainment()) {
									containedClass = tarClass;
									containerClass = ec;
									break;
								}
							}
						}
						if (containerClass != null) {
							break;
						}
					}
					List<EClass> superClasses = tarClass.getEAllSuperTypes();
					if (containerClass == null) {
						for (EClass superCl : superClasses) {
							for (EClass ec : classes) {
								for (EReference ref : ec.getEAllReferences()) {
									if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(superCl))) {
										if (ref.isContainment()) {
											containedClass = superCl;
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
						WodelMetricClass metricContainer = metrics.get(EcoreUtil.getURI(containerClass));
						if (metricContainer != null) {
							WodelMetricReference[] containerRef = metricContainer.getReferences();
							for (EReference eReference : containerClass.getEAllReferences()) {
								if (EcoreUtil.getURI(eReference.getEType()).equals(EcoreUtil.getURI(containedClass))) {
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
					}
					for (EClass superClass : superClasses) {
						WodelMetricClass metricSuperClass = metrics.get(EcoreUtil.getURI(superClass));
						if (metricSuperClass != null) {
							WodelMetricAttribute[] metricSuperAtt = metricSuperClass.getAttributes();
							counters[0] = 0;
							for (EAttribute eAttribute : superClass.getEAllAttributes()) {
								for (WodelMetricAttribute wmatt : metricSuperAtt) {
									if (wmatt.getName().equals(eAttribute.getName())) {
										if (eAttribute.getLowerBound() > 0) {
											wmatt.icreation++;
											counters[0]++;
											break;
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
											counters[0]++;
											break;
										}
									}
								}
							}
							metricSuperClass.icreation+=counters[0];
							metricSuperClass.iccreation++;
						}
					}
					for (EReference ref : tarClass.getEAllReferences()) {
						if (ref.isContainment()) {
							List<EClass> recursion = new ArrayList<EClass>();
							recursion.add((EClass) ref.getEType());
							cloneMetricsClassHelper(model, classes, obj, (EClass) ref.getEType(), metrics, filterAbstract, recursion);
						}
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
									commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract, packages);
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
								commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract, packages);
							}
						}
					}
					
					WodelMetricAttribute[] metricatt = metric.getAttributes();
					for (EAttribute eAttribute : mutatedClass.getEAllAttributes()) {
						for (WodelMetricAttribute wmatt : metricatt) {
							if (wmatt.getName().equals(eAttribute.getName())) {
								wmatt.ideletion++;
								metric.ideletion++;
								break;
							}
						}
					}
					
					WodelMetricReference[] metricref = metric.getReferences();
					for (EReference eReference : mutatedClass.getEAllReferences()) {
						for (WodelMetricReference wmref : metricref) {
							if (wmref.getName().equals(eReference.getName())) {
								wmref.ideletion++;
								metric.ideletion++;
								break;
							}
						}
					}
					metric.ddeletion++;
					containerClass = null;
					containedClass = null;
					for (EClass ec : classes) {
						for (EReference ref : ec.getEAllReferences()) {
							if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
								if (ref.isContainment()) {
									containedClass = mutatedClass;
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
							for (EClass ec : classes) {
								for (EReference ref : ec.getEAllReferences()) {
									if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(superCl))) {
										if (ref.isContainment()) {
											containedClass = superCl;
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
						WodelMetricClass metricContainer = metrics.get(EcoreUtil.getURI(containerClass));
						if (metricContainer != null) {
							WodelMetricReference[] containerRef = metricContainer.getReferences();
							for (EReference eReference : containerClass.getEAllReferences()) {
								if (EcoreUtil.getURI(eReference.getEType()).equals(EcoreUtil.getURI(containedClass))) {
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
					}
					List<EClass> subClasses = ModelManager.getESubClasses(packages, mutatedClass);
					for (EClass subClass : subClasses) {
						WodelMetricClass metricSubClass = metrics.get(EcoreUtil.getURI(subClass));
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
									commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract, packages);
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
								commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract, packages);
							}
						}
						for (EReference ref : mutatedClass.getEAllReferences()) {
							if (ref.isContainment()) {
								List<EClass> recursion = new ArrayList<EClass>();
								recursion.add((EClass) ref.getEType());
								removeMetricsClassHelper(model, classes, obj, (EClass) ref.getEType(), metrics, filterAbstract, recursion, packages, false);
							}
						}
					}
				}
			}
			else {
				WodelMetricClass metricTarget = metrics.get(EcoreUtil.getURI(targetClass));
				WodelMetricAttribute[] metricatttar = metricTarget.getAttributes();
				for (EAttribute eAttribute : targetClass.getEAllAttributes()) {
					for (WodelMetricAttribute wmatt : metricatttar) {
						if (wmatt.getName().equals(eAttribute.getName())) {
							if (eAttribute.getLowerBound() > 0) {
								wmatt.icreation++;
								metricTarget.icreation++;
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
							}
							break;
						}
					}
				}
				metricTarget.ccreation++;
				EClass containerClass = null;
				EClass containedClass = null;
				for (EClass ec : classes) {
					for (EReference ref : ec.getEAllReferences()) {
						if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(targetClass))) {
							if (ref.isContainment()) {
								containedClass = targetClass;
								containerClass = ec;
								break;
							}
						}
					}
					if (containerClass != null) {
						break;
					}
				}
				List<EClass> superClasses = targetClass.getEAllSuperTypes();
				if (containerClass == null) {
					for (EClass superCl : superClasses) {
						for (EClass ec : classes) {
							for (EReference ref : ec.getEAllReferences()) {
								if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(superCl))) {
									if (ref.isContainment()) {
										containedClass = superCl;
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
					WodelMetricClass metricContainer = metrics.get(EcoreUtil.getURI(containerClass));
					if (metricContainer != null) {
						WodelMetricReference[] containerRef = metricContainer.getReferences();
						for (EReference eReference : containerClass.getEAllReferences()) {
							if (EcoreUtil.getURI(eReference.getEType()).equals(EcoreUtil.getURI(containedClass))) {
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
				}
				for (EClass superClass : superClasses) {
					WodelMetricClass metricSuperClass = metrics.get(EcoreUtil.getURI(superClass));
					if (metricSuperClass != null) {
						WodelMetricAttribute[] metricSuperAtt = metricSuperClass.getAttributes();
						counters[0] = 0;
						for (EAttribute eAttribute : superClass.getEAllAttributes()) {
							for (WodelMetricAttribute wmatt : metricSuperAtt) {
								if (wmatt.getName().equals(eAttribute.getName())) {
									if (eAttribute.getLowerBound() > 0) {
										wmatt.icreation++;
										counters[0]++;
										break;
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
										counters[0]++;
										break;
									}
								}
							}
						}
						metricSuperClass.icreation+=counters[0];
						metricSuperClass.iccreation++;
					}
				}
				for (EReference ref : targetClass.getEAllReferences()) {
					if (ref.isContainment()) {
						List<EClass> recursion = new ArrayList<EClass>();
						recursion.add((EClass) ref.getEType());
						cloneMetricsClassHelper(model, classes, obj, (EClass) ref.getEType(), metrics, filterAbstract, recursion);
					}
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
								commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract, packages);
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
							commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract, packages);
						}
					}
				}

				WodelMetricAttribute[] metricatt = metric.getAttributes();
				for (EAttribute eAttribute : mutatedClass.getEAllAttributes()) {
					for (WodelMetricAttribute wmatt : metricatt) {
						if (wmatt.getName().equals(eAttribute.getName())) {
							wmatt.ideletion++;
							metric.ideletion++;
							break;
						}
					}
				}

				WodelMetricReference[] metricref = metric.getReferences();
				for (EReference eReference : mutatedClass.getEAllReferences()) {
					for (WodelMetricReference wmref : metricref) {
						if (wmref.getName().equals(eReference.getName())) {
							wmref.ideletion++;
							metric.ideletion++;
							break;
						}
					}
				}
				metric.ddeletion++;
				containerClass = null;
				containedClass = null;
				for (EClass ec : classes) {
					for (EReference ref : ec.getEAllReferences()) {
						if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(mutatedClass))) {
							if (ref.isContainment()) {
								containedClass = mutatedClass;
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
						for (EClass ec : classes) {
							for (EReference ref : ec.getEAllReferences()) {
								if (EcoreUtil.getURI(ref.getEType()).equals(EcoreUtil.getURI(superCl))) {
									if (ref.isContainment()) {
										containedClass = superCl;
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
					WodelMetricClass metricContainer = metrics.get(EcoreUtil.getURI(containerClass));
					if (metricContainer != null) {
						WodelMetricReference[] containerRef = metricContainer.getReferences();
						for (EReference eReference : containerClass.getEAllReferences()) {
							if (EcoreUtil.getURI(eReference.getEType()).equals(EcoreUtil.getURI(containedClass))) {
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
				}
				List<EClass> subClasses = ModelManager.getESubClasses(packages, mutatedClass);
				for (EClass subClass : subClasses) {
					WodelMetricClass metricSubClass = metrics.get(EcoreUtil.getURI(subClass));
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
								commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract, packages);
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
							commandMetricsClassHelper(model, classes, newCommand, cl5, metrics, filterAbstract, packages);
						}
					}
					for (EReference ref : mutatedClass.getEAllReferences()) {
						if (ref.isContainment()) {
							List<EClass> recursion = new ArrayList<EClass>();
							recursion.add((EClass) ref.getEType());
							removeMetricsClassHelper(model, classes, obj, (EClass) ref.getEType(), metrics, filterAbstract, recursion, packages, false);
						}
					}
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void staticMetricsHelper(Resource model, List<EClass> classes, List<EObject> objects, String mutatorName, URI uri, String refName, LinkedHashMap<URI, WodelMetricClass> metrics, int operation, LinkedHashMap<String, String> strategies, String atts, String refs, List<EPackage> packages, boolean filterAbstract) {
		try {
			String stringURI = uri.toString();
			if (objects != null) {
				if (objects.size() > 0) {
					for (EObject obj : objects) {
						if (obj.eClass().getName().equals(mutatorName)) {
							EObject cl = ModelManager.getReference(refName, obj);
							if (cl != null) {
								List<URI> classURIs = getClassURI(model, classes, mutatorName, obj, uri, strategies, metrics, filterAbstract, packages, cl);
								if (classURIs != null && classURIs.size() > 0) {
									for (URI classURI : classURIs) {
										if (stringURI.endsWith(classURI.toString()) == true) {
											WodelMetricClass metric = metrics.get(uri);
											int[] counters = new int[2];
											processModificationMetrics(model, obj, metric, atts, refs, metrics, counters);
											EClass mutatedClass = ModelManager.getEClassByURI(packages, uri);
											if (operation == 0) {
												processCreationMetrics(model, classes, obj, mutatedClass, metrics, metric, counters, filterAbstract, packages);
											}
											if (operation == 1) {
												metric.modification += counters[0];
												if (counters[1] > 0) {
													metric.mmodification+=counters[1] - 1;
												}
												metric.mmodification++;
											}
											if (operation == 2) {
												processRemovalMetrics(model, classes, obj, mutatedClass, metrics, metric, counters, filterAbstract, packages);
											}
											if (operation == 3) {
												processRetypingMetrics(model, classes, obj, mutatedClass, metrics, metric, counters, filterAbstract, packages);
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

	public static WodelMetricClass[] createWodelStaticMetrics(String projectName, String metamodel) {
		try {

			LinkedHashMap<URI, WodelMetricClass> metrics = new LinkedHashMap<URI, WodelMetricClass>();
			Bundle bundle = Platform.getBundle("wodel.models");
			URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
			String mutatorecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
	   		File mutatorFolder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + projectName + "/src/");
	   		if (mutatorFolder.exists() == false) {
				WodelMetricClass[] ret = new WodelMetricClass[metrics.values().size()];
				metrics.values().toArray(ret);
				return ret;
	   		}
	   		List<String> mutators = new ArrayList<String>();
	   		for (File mutatorFile : mutatorFolder.listFiles()) {
	   			if (mutatorFile.isFile() && mutatorFile.getName().endsWith(".mutator")) {
	   				mutators.add(mutatorFile.getName());
	   			}
	   		}
	   		List<Resource> models = new ArrayList<Resource>();
	   		File modelFolder = new File(ModelManager.getOutputPath());
	   		for (File modelFile : modelFolder.listFiles()) {
	   			if (modelFile.isFile() && modelFile.getName().endsWith(".model")) {
	   				String mutatorName = modelFile.getName().replace(".model", ".mutator");
	   				if (mutators.contains(mutatorName)) {
	   					Resource model = ModelManager.loadModel(mutatorpackages, ModelManager.getOutputPath() + "/" + modelFile.getName());
	   					models.add(model);
	   				}
	   			}
	   		}
			Resource program = ModelManager.createModel(URI.createURI("file:/" + ModelManager.getWorkspaceAbsolutePath() + "/" + ModelManager.getOutputPath() + "/metricsHelper.model").toFileString());
			for (Resource model : models) {
				program.getContents().add(model.getContents().get(0));
			}
			boolean filterAbstract = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Filter concrete classes", false, null);

			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);

			List<EObject> creation = ModelManager.getObjectsOfType("CreateObjectMutator", program);
			List<EObject> modifysrc = ModelManager.getObjectsOfType("ModifySourceReferenceMutator", program);
			List<EObject> modifytar = ModelManager.getObjectsOfType("ModifyTargetReferenceMutator", program);
			List<EObject> createref = ModelManager.getObjectsOfType("CreateReferenceMutator", program);
			List<EObject> removal = ModelManager.getObjectsOfType("RemoveObjectMutator", program);
			List<EObject> removerndref = ModelManager.getObjectsOfType("RemoveRandomReferenceMutator", program);
			List<EObject> removespref = ModelManager.getObjectsOfType("RemoveSpecificReferenceMutator", program);
			List<EObject> removecompref = ModelManager.getObjectsOfType("RemoveCompleteReferenceMutator", program);
			List<EObject> modifyinf = ModelManager.getObjectsOfType("ModifyInformationMutator", program);
			List<EObject> clonation = ModelManager.getObjectsOfType("CloneObjectMutator", program);
			List<EObject> retyping = ModelManager.getObjectsOfType("RetypeObjectMutator", program);
			
			List<EClass> classes = ModelManager.getEClasses(packages);
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
				metrics.put(EcoreUtil.getURI(cl), metric);
			}
			for (EClass cl : classes) {
				if (filterAbstract == true) {
					if (cl.isAbstract() == true) {
						continue;
					}
				}
				URI uri = EcoreUtil.getURI(cl);
				staticMetricsHelper(program, classes, creation, "CreateObjectMutator", uri, "type", metrics, 0, null, null, null, packages, filterAbstract);
				staticMetricsHelper(program, classes, modifysrc, "ModifySourceReferenceMutator", uri, "source", metrics, 1, strategies, null, "refType", packages, filterAbstract);
				staticMetricsHelper(program, classes, modifytar, "ModifyTargetReferenceMutator", uri, "source", metrics, 1, strategies, null, "refType", packages, filterAbstract);
				staticMetricsHelper(program, classes, createref, "CreateReferenceMutator", uri, "source", metrics, 1, strategies, null, "refType", packages, filterAbstract);
				staticMetricsHelper(program, classes, removal, "RemoveObjectMutator", uri, "object", metrics, 2, strategies, null, null, packages, filterAbstract);
				staticMetricsHelper(program, classes, removerndref, "RemoveRandomReferenceMutator", uri, "type", metrics, 1, null, null, "refType", packages, filterAbstract);
				staticMetricsHelper(program, classes, removespref, "RemoveSpecificReferenceMutator", uri, "container", metrics, 1, null, null, "refType", packages, filterAbstract);
				staticMetricsHelper(program, classes, removecompref, "RemoveCompleteReferenceMutator", uri, "type", metrics, 1, null, null, "refType", packages, filterAbstract);
				staticMetricsHelper(program, classes, modifyinf, "ModifyInformationMutator", uri, "object", metrics, 1, strategies, "attributes", "references", packages, filterAbstract);
				staticMetricsHelper(program, classes, clonation, "CloneObjectMutator", uri, "object", metrics, 0, strategies, null, null, packages, filterAbstract);
				staticMetricsHelper(program, classes, retyping, "RetypeObjectMutator", uri, "object", metrics, 3, strategies, null, null, packages, filterAbstract);
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
