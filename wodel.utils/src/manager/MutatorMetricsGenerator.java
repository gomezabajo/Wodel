package manager;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import appliedMutations.AppMutation;
import appliedMutations.AttributeChanged;
import appliedMutations.AttributeSwap;
import appliedMutations.InformationChanged;
import appliedMutations.ReferenceAtt;
import appliedMutations.ReferenceChanged;
import appliedMutations.ReferenceCreated;
import appliedMutations.ReferenceRemoved;
import appliedMutations.ReferenceSwap;
import appliedMutations.SourceReferenceChanged;
import appliedMutations.TargetReferenceChanged;
import exceptions.MetaModelNotFoundException;
import exceptions.ReferenceNonExistingException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * MutatorMetricsGenerator abstract class for dynamic footprints generator
 * 
 */
public abstract class MutatorMetricsGenerator {

	protected List<EPackage> metrics = null;
	protected String output = null;
	protected String metamodel = null;
	protected String modelsFolder = null;
	protected String fileName = null;
	protected Map<String, List<String>> hashmapMutVersions = null;
	protected Class<?> cls = null;

	protected class MutationData {
		public String name = null;
		public EObject primary = null;
		public EObject secondary = null;
		public boolean isReference = false;
		public boolean isAttribute = false;
		public ArrayList<String> referenceNames = null;
		public ArrayList<String> attributeNames = null;
		public EObject mutator = null;
		
		public MutationData() {
			
		}
	}

	private abstract class Metric {
		public int created = 0;
		public int modified = 0;
		public int removed = 0;
		public int ccreated = 0;
		public int cmodified = 0;
		public int cremoved = 0;
	}
	
	protected class MutantMetric extends Metric {
		
		public MutantMetric() {
			
		}
	}

	protected class WodelMutantMetric extends Metric {
		
		public LinkedHashMap<String, MutantMetric> attributes = new LinkedHashMap<String, MutantMetric>();
		public LinkedHashMap<String, MutantMetric> references = new LinkedHashMap<String, MutantMetric>();
		
		public WodelMutantMetric() {
			
		}
	}
	
	protected MutationData getMutationCreationData(List<EObject> regObjects, EObject object) {
		return null;
	}
	
	protected MutationData getMutationDeletionData(List<EObject> regObjects, EObject object) {
		return null;
	}
	
	protected MutationData getMutationData(List<EObject> regObjects, EObject object) {
		MutationData mutationData = null;
		EObject mutantObject1 = null;
		EObject mutantObject2 = null;
		for (EObject regObject : regObjects) {
			if (regObject instanceof AppMutation) {
				mutationData = new MutationData();
				if (regObject instanceof ReferenceChanged) {
					if (regObject instanceof SourceReferenceChanged) {
						mutantObject1 = ((SourceReferenceChanged) regObject).getObject().get(0);
						mutationData.name = "SourceReferenceChanged";
						mutationData.primary = mutantObject1;
						mutationData.mutator = ((SourceReferenceChanged) regObject).getDef();
					}
					if (regObject instanceof TargetReferenceChanged) {
						mutantObject1 = ((TargetReferenceChanged) regObject).getObject().get(0);
						mutationData.name = "TargetReferenceChanged";
						mutationData.primary = mutantObject1;
						mutationData.isReference = true;
						mutationData.referenceNames = new ArrayList<String>();
						mutationData.referenceNames.add(((TargetReferenceChanged) regObject).getRefName());
						mutationData.mutator = ((TargetReferenceChanged) regObject).getDef();
					}
					if (regObject instanceof ReferenceSwap) {
						mutantObject1 = ((ReferenceSwap) regObject).getFrom();
						mutantObject2 = ((ReferenceSwap) regObject).getOtherFrom();
						mutationData.name = "ReferenceSwap";
						mutationData.primary = mutantObject1;
						mutationData.secondary = mutantObject2;
						mutationData.isReference = true;
						mutationData.referenceNames = new ArrayList<String>();
						mutationData.referenceNames.add(((ReferenceSwap) regObject).getRefName());
						mutationData.referenceNames.add(((ReferenceSwap) regObject).getFirstName());
						mutationData.mutator = ((ReferenceSwap) regObject).getDef();
					}
					if (regObject instanceof ReferenceAtt) {
						mutantObject1 = ((InformationChanged) ((ReferenceAtt) regObject).eContainer()).getObject();
						mutationData.name = "InformationChanged";
						mutationData.primary = mutantObject1;
						mutationData.isAttribute = true;
						mutationData.attributeNames = new ArrayList<String>();
						mutationData.attributeNames.add(((ReferenceAtt) regObject).getAttName());
						mutationData.mutator = ((ReferenceAtt) regObject).getDef();
					}
				}
				if (regObject instanceof ReferenceCreated) {
					mutantObject1 = ((ReferenceCreated) regObject).getObject().get(0);
					mutationData.name = "ReferenceCreated";
					mutationData.primary = mutantObject1;
					mutationData.isReference = true;
					mutationData.referenceNames = new ArrayList<String>();
					mutationData.referenceNames.add(((ReferenceCreated) regObject).getRefName());
					mutationData.mutator = ((ReferenceCreated) regObject).getDef();
				}
				if (regObject instanceof ReferenceRemoved) {
					mutantObject1 = ((ReferenceRemoved) regObject).getObject().get(0);
					mutationData.name = "ReferenceRemoved";
					mutationData.primary = mutantObject1;
					mutationData.isReference = true;
					mutationData.referenceNames = new ArrayList<String>();
					mutationData.referenceNames.add(((ReferenceRemoved) regObject).getRefName());
					mutationData.mutator = ((ReferenceRemoved) regObject).getDef();
				}
				if (regObject instanceof InformationChanged) {
					mutantObject1 = ((InformationChanged) regObject).getObject();
					mutationData.name = "InformationChanged";
					mutationData.primary = mutantObject1;
					if (((InformationChanged) regObject).getAttChanges().size() > 0) {
						mutationData.isAttribute = true;
						mutationData.attributeNames = new ArrayList<String>();
						for (AttributeChanged att : ((InformationChanged) regObject).getAttChanges()) {
							mutationData.attributeNames.add(att.getAttName());
							if (att instanceof AttributeSwap) {
								mutantObject2 = ((AttributeSwap) att).getAttObject();
								mutationData.secondary = mutantObject2;
								mutationData.attributeNames.add(((AttributeSwap) att).getFirstName());
							}
						}
					}
					if (((InformationChanged) regObject).getRefChanges().size() > 0) {
						mutationData.isReference = true;
						mutationData.referenceNames = new ArrayList<String>();
						for (ReferenceChanged ref : ((InformationChanged) regObject).getRefChanges()) {
							mutationData.referenceNames.add(ref.getRefName());
						}
					}
					mutationData.mutator = ((InformationChanged) regObject).getDef();
				}
				String objectURI = EcoreUtil.getURI(object).toString().replace("//", "/");
				objectURI = objectURI.substring(objectURI.indexOf("#"));
				if (mutantObject1 != null) {
					String mutantObjectURI = EcoreUtil.getURI(mutantObject1).toString().replace("//", "/");
					mutantObjectURI = mutantObjectURI.substring(mutantObjectURI.indexOf("#"));
					if (mutantObjectURI.equals(objectURI) == true) {
						return mutationData;
					}
				}
				if (mutantObject2 != null) {
					String mutantObjectURI = EcoreUtil.getURI(mutantObject2).toString().replace("//", "/");
					mutantObjectURI = mutantObjectURI.substring(mutantObjectURI.indexOf("#"));
					if (mutantObjectURI.equals(objectURI) == true) {
						return mutationData;
					}
				}
			}
		}
		return null;
	}
	
	protected void getMutantCreationMetrics(List<EObject> regObjects, List<EObject> mutantObjects,
			LinkedHashMap<String, WodelMutantMetric> mutantMetrics, Resource program) {
		try {
			for (EObject object : mutantObjects) {
				WodelMutantMetric metric = null;
				if (mutantMetrics.get(object.eClass().getName()) == null) {
					metric = new WodelMutantMetric();
				}	
				else {
					metric = mutantMetrics.get(object.eClass().getName());
				}
				MutationData mutData = getMutationCreationData(regObjects, object);
				if (mutData != null && mutData.mutator != null) {
					int counter = 0;
					if (mutData.isAttribute == false && mutData.isReference == false) {
						List<EObject> mutators = ModelManager.getAllObjects(program);
						EObject mutator = null;
						String mutatorURI = EcoreUtil.getURI(mutData.mutator).toString().replace("//", "/");
						mutatorURI = mutatorURI.substring(mutatorURI.indexOf("#"), mutatorURI.length());
						for (EObject mut : mutators) {
							String mutURI = EcoreUtil.getURI(mut).toString().replace("//", "/");
							mutURI = mutURI.substring(mutURI.indexOf("#"), mutURI.length());
							if (mutatorURI.equals(mutURI)) {
								//if (EcoreUtil.getURI(mut).equals(EcoreUtil.getURI(mutData.mutator))) {
								mutator = mut;
								break;
							}
						}
						if (mutator == null) {
							continue;
						}
						if (mutator.eClass().getName().equals("CreateObjectMutator")) {
							List<EObject> attributes = ModelManager.getReferences("attributes", mutator);
							ArrayList<String> explicitAttNames = new ArrayList<String>();
							for (EObject attModifier : attributes) {
								for (EReference ref : attModifier.eClass().getEAllReferences()) {
									if (ref.getName().equals("attribute")) {
										List<EAttribute> listAttributes = (List<EAttribute>) attModifier.eGet(ref);
										explicitAttNames.add(listAttributes.get(0).getName());
									}
								}
							}
							EClass eClass = object.eClass();
							for (EAttribute attObject : eClass.getEAllAttributes()) {
								MutantMetric attmetric = null;
								if (metric.attributes.get(attObject.getName()) == null) {
									attmetric = new MutantMetric();
								}
								else {
									attmetric = metric.attributes.get(attObject.getName());
								}
								if (explicitAttNames.contains(attObject.getName())) {
									attmetric.created++;
									counter++;
								}
								else {
									if (attObject.getLowerBound() > 0) {
										attmetric.created++;
										counter++;
									}
								}
								metric.attributes.put(attObject.getName(), attmetric);
							}
							List<EObject> references = ModelManager.getReferences("references", mutator);
							ArrayList<String> explicitRefNames = new ArrayList<String>();
							for (EObject refModifier : references) {
								for (EReference ref : refModifier.eClass().getEAllReferences()) {
									if (ref.getName().equals("reference")) {
										List<EReference> listReferences = (List<EReference>) refModifier.eGet(ref);
										explicitRefNames.add(listReferences.get(0).getName());
									}
								}
							}
							for (EReference refObject : object.eClass().getEAllReferences()) {
								MutantMetric refmetric = null;
								if (metric.references.get(refObject.getName()) == null) {
									refmetric = new MutantMetric();
								}
								else {
									refmetric = metric.references.get(refObject.getName());
								}
								if (explicitRefNames.contains(refObject.getName())) {
									refmetric.created++;
									counter++;
								}
								else {
									if (refObject.getLowerBound() > 0) {
										refmetric.created++;
										counter++;
									}
								}
								metric.references.put(refObject.getName(), refmetric);
							}
							EObject container = object.eContainer();
							if (container != null) {
								for (EReference ref : container.eClass().getEAllReferences()) {
									if (ref.getEType().getName().equals(object.eClass().getName())) {
										WodelMutantMetric containerMetric = null;
										if (mutantMetrics.get(container.eClass().getName()) == null) {
											containerMetric = new WodelMutantMetric();
										}	
										else {
											containerMetric = mutantMetrics.get(container.eClass().getName());
										}
										MutantMetric refmetric = null;
										if (containerMetric.references.get(ref.getName()) == null) {
											refmetric = new MutantMetric();
										}
										else {
											refmetric = containerMetric.references.get(ref.getName());
										}
										refmetric.modified++;
										containerMetric.modified++;
										break;
									}
								}
							}
						}
						if (mutator.eClass().getName().equals("CloneObjectMutator")) {
							List<EObject> attributes = ModelManager.getReferences("attributes", mutator);
							ArrayList<String> explicitAttNames = new ArrayList<String>();
							for (EObject attModifier : attributes) {
								for (EReference ref : attModifier.eClass().getEAllReferences()) {
									if (ref.getName().equals("attribute")) {
										List<EAttribute> listAttributes = (List<EAttribute>) attModifier.eGet(ref);
										explicitAttNames.add(listAttributes.get(0).getName());
									}
								}
							}
							for (EAttribute attObject : object.eClass().getEAllAttributes()) {
								MutantMetric attmetric = null;
								if (metric.attributes.get(attObject.getName()) == null) {
									attmetric = new MutantMetric();
								}
								else {
									attmetric = metric.attributes.get(attObject.getName());
								}
								if (explicitAttNames.contains(attObject.getName())) {
									attmetric.created++;
									counter++;
								}
								else {
									if (attObject.getLowerBound() > 0) {
										attmetric.created++;
										counter++;
									}
								}
								metric.attributes.put(attObject.getName(), attmetric);
							}
							List<EObject> references = ModelManager.getReferences("references", mutator);
							ArrayList<String> explicitRefNames = new ArrayList<String>();
							for (EObject refModifier : references) {
								for (EReference ref : refModifier.eClass().getEAllReferences()) {
									if (ref.getName().equals("reference")) {
										List<EReference> listReferences = (List<EReference>) refModifier.eGet(ref);
										explicitRefNames.add(listReferences.get(0).getName());
									}
								}
							}
							for (EReference refObject : object.eClass().getEAllReferences()) {
								MutantMetric refmetric = null;
								if (metric.references.get(refObject.getName()) == null) {
									refmetric = new MutantMetric();
								}
								else {
									refmetric = metric.references.get(refObject.getName());
								}
								if (explicitRefNames.contains(refObject.getName())) {
									refmetric.created++;
									counter++;
								}
								else {
									if (refObject.getLowerBound() > 0) {
										refmetric.created++;
										counter++;
									}
								}
								metric.references.put(refObject.getName(), refmetric);
							}
							EObject container = object.eContainer();
							for (EReference ref : container.eClass().getEAllReferences()) {
								if (ref.getEType().getName().equals(object.eClass().getName())) {
									WodelMutantMetric containerMetric = null;
									if (mutantMetrics.get(container.eClass().getName()) == null) {
										containerMetric = new WodelMutantMetric();
									}	
									else {
										containerMetric = mutantMetrics.get(container.eClass().getName());
									}
									MutantMetric refmetric = null;
									if (containerMetric.references.get(ref.getName()) == null) {
										refmetric = new MutantMetric();
									}
									else {
										refmetric = containerMetric.references.get(ref.getName());
									}
									refmetric.modified++;
									containerMetric.modified++;
									break;
								}
							}
						}
						if (mutator.eClass().getName().equals("RetypeObjectMutator")) {
							EClass eClass = object.eClass();
							for (EAttribute attObject : eClass.getEAllAttributes()) {
								MutantMetric attmetric = null;
								if (metric.attributes.get(attObject.getName()) == null) {
									attmetric = new MutantMetric();
								}
								else {
									attmetric = metric.attributes.get(attObject.getName());
								}
								if (attObject.getLowerBound() > 0) {
									attmetric.created++;
									counter++;
								}
								metric.attributes.put(attObject.getName(), attmetric);
							}
							for (EReference refObject : object.eClass().getEAllReferences()) {
								MutantMetric refmetric = null;
								if (metric.references.get(refObject.getName()) == null) {
									refmetric = new MutantMetric();
								}
								else {
									refmetric = metric.references.get(refObject.getName());
								}
								if (refObject.getLowerBound() > 0) {
									refmetric.created++;
									counter++;
								}
								metric.references.put(refObject.getName(), refmetric);
							}
							EObject container = object.eContainer();
							for (EReference ref : container.eClass().getEAllReferences()) {
								if (ref.getEType().getName().equals(object.eClass().getName())) {
									WodelMutantMetric containerMetric = null;
									if (mutantMetrics.get(container.eClass().getName()) == null) {
										containerMetric = new WodelMutantMetric();
									}	
									else {
										containerMetric = mutantMetrics.get(container.eClass().getName());
									}
									MutantMetric refmetric = null;
									if (containerMetric.references.get(ref.getName()) == null) {
										refmetric = new MutantMetric();
									}
									else {
										refmetric = containerMetric.references.get(ref.getName());
									}
									refmetric.modified++;
									containerMetric.modified++;
									break;
								}
							}
						}
					}
					metric.created+= counter;
					metric.ccreated++;
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void getMutantDeletionMetrics(List<EObject> regObjects, List<EObject> seedObjects,
			LinkedHashMap<String, WodelMutantMetric> mutantMetrics, Resource program) {
		for (EObject object : seedObjects) {
			WodelMutantMetric metric = null;
			if (mutantMetrics.get(object.eClass().getName()) == null) {
				metric = new WodelMutantMetric();
			}	
			else {
				metric = mutantMetrics.get(object.eClass().getName());
			}
			MutationData mutData = getMutationDeletionData(regObjects, object);
			if (mutData != null && mutData.mutator != null) {
				int counter = 0;
				if (mutData.isAttribute == false && mutData.isReference == false) {
					List<EObject> mutators = ModelManager.getAllObjects(program);
					EObject mutator = null;
					String mutatorURI = EcoreUtil.getURI(mutData.mutator).toString().replace("//", "/");
					mutatorURI = mutatorURI.substring(mutatorURI.indexOf("#"), mutatorURI.length());
					for (EObject mut : mutators) {
						String mutURI = EcoreUtil.getURI(mut).toString().replace("//", "/");
						mutURI = mutURI.substring(mutURI.indexOf("#"), mutURI.length());
						if (mutatorURI.equals(mutURI)) {
							//if (EcoreUtil.getURI(mut).equals(EcoreUtil.getURI(mutData.mutator))) {
							mutator = mut;
							break;
						}
					}
					if (mutator == null) {
						continue;
					}
					if (mutator.eClass().getName().equals("RemoveObjectMutator")) {
						EClass eClass = object.eClass();
						for (EAttribute attObject : eClass.getEAllAttributes()) {
							MutantMetric attmetric = null;
							if (metric.attributes.get(attObject.getName()) == null) {
								attmetric = new MutantMetric();
							}
							else {
								attmetric = metric.attributes.get(attObject.getName());
							}
							if (attObject.getLowerBound() > 0) {
								attmetric.removed++;
								counter++;
							}
							metric.attributes.put(attObject.getName(), attmetric);
						}
						for (EReference refObject : object.eClass().getEAllReferences()) {
							MutantMetric refmetric = null;
							if (metric.references.get(refObject.getName()) == null) {
								refmetric = new MutantMetric();
							}
							else {
								refmetric = metric.references.get(refObject.getName());
							}
							if (refObject.getLowerBound() > 0) {
								refmetric.removed++;
								counter++;
							}
							metric.references.put(refObject.getName(), refmetric);
						}
						EObject container = object.eContainer();
						for (EReference ref : container.eClass().getEAllReferences()) {
							if (ref.getEType().getName().equals(object.eClass().getName())) {
								WodelMutantMetric containerMetric = null;
								if (mutantMetrics.get(container.eClass().getName()) == null) {
									containerMetric = new WodelMutantMetric();
								}	
								else {
									containerMetric = mutantMetrics.get(container.eClass().getName());
								}
								MutantMetric refmetric = null;
								if (containerMetric.references.get(ref.getName()) == null) {
									refmetric = new MutantMetric();
								}
								else {
									refmetric = containerMetric.references.get(ref.getName());
								}
								refmetric.modified++;
								containerMetric.modified++;
								break;
							}
						}
					}
					if (mutator.eClass().getName().equals("RetypeObjectMutator")) {
						EClass eClass = object.eClass();
						for (EAttribute attObject : eClass.getEAllAttributes()) {
							MutantMetric attmetric = null;
							if (metric.attributes.get(attObject.getName()) == null) {
								attmetric = new MutantMetric();
							}
							else {
								attmetric = metric.attributes.get(attObject.getName());
							}
							if (attObject.getLowerBound() > 0) {
								attmetric.removed++;
								counter++;
							}
							metric.attributes.put(attObject.getName(), attmetric);
						}
						for (EReference refObject : object.eClass().getEAllReferences()) {
							MutantMetric refmetric = null;
							if (metric.references.get(refObject.getName()) == null) {
								refmetric = new MutantMetric();
							}
							else {
								refmetric = metric.references.get(refObject.getName());
							}
							if (refObject.getLowerBound() > 0) {
								refmetric.removed++;
								counter++;
							}
							metric.references.put(refObject.getName(), refmetric);
						}
						EObject container = object.eContainer();
						for (EReference ref : container.eClass().getEAllReferences()) {
							if (ref.getEType().getName().equals(object.eClass().getName())) {
								WodelMutantMetric containerMetric = null;
								if (mutantMetrics.get(container.eClass().getName()) == null) {
									containerMetric = new WodelMutantMetric();
								}	
								else {
									containerMetric = mutantMetrics.get(container.eClass().getName());
								}
								MutantMetric refmetric = null;
								if (containerMetric.references.get(ref.getName()) == null) {
									refmetric = new MutantMetric();
								}
								else {
									refmetric = containerMetric.references.get(ref.getName());
								}
								refmetric.modified++;
								containerMetric.modified++;
								break;
							}
						}
					}
				}
				metric.removed+= counter;
				metric.cremoved++;
			}
		}
	}
	
	protected void getMutantMetrics(List<EObject> regObjects, List<EObject> seedObjects,
			LinkedHashMap<String, WodelMutantMetric> mutantMetrics) {
		for (EObject object : seedObjects) {
			WodelMutantMetric metric = null;
			if (mutantMetrics.get(object.eClass().getName()) == null) {
				metric = new WodelMutantMetric();
			}	
			else {
				metric = mutantMetrics.get(object.eClass().getName());
			}
			MutationData mutData = getMutationData(regObjects, object);
			if (mutData != null && mutData.mutator != null) {
				int counter = 0;
				if (mutData.isAttribute == true && mutData.isReference == false) {
					for (EAttribute attObject : object.eClass().getEAllAttributes()) {
						MutantMetric attmetric = null;
						if (metric.attributes.get(attObject.getName()) == null) {
							attmetric = new MutantMetric();
						}
						else {
							attmetric = metric.attributes.get(attObject.getName());
						}
						boolean mutated = false;
						for (String attName : mutData.attributeNames) {
							if (attObject.getName().equals(attName)) {
								mutated = true;
								break;
							}
						}
						if (mutated == true) {
							attmetric.modified++;
							counter++;
							metric.attributes.put(attObject.getName(), attmetric);
						}
					}
				}
				if (mutData.isReference == true && mutData.isAttribute == false) {
					for (EReference refObject : object.eClass().getEAllReferences()) {
						MutantMetric refmetric = null;
						if (metric.references.get(refObject.getName()) == null) {
							refmetric = new MutantMetric();
						}
						else {
							refmetric = metric.references.get(refObject.getName());
						}
						boolean mutated = false;
						for (String refName : mutData.referenceNames) {
							if (refObject.getName().equals(refName)) {
								mutated = true;
								break;
							}
						}
						if (mutated == true) {
							refmetric.modified++;
							counter++;
							metric.references.put(refObject.getName(), refmetric);
						}
					}
				}
				if (mutData.isAttribute == true && mutData.isReference == true) {
					for (EAttribute attObject : object.eClass().getEAllAttributes()) {
						MutantMetric attmetric = null;
						if (metric.attributes.get(attObject.getName()) == null) {
							attmetric = new MutantMetric();
						}
						else {
							attmetric = metric.attributes.get(attObject.getName());
						}
						boolean mutated = false;
						for (String attName : mutData.attributeNames) {
							if (attObject.getName().equals(attName)) {
								mutated = true;
								break;
							}
						}
						if (mutated == true) {
							attmetric.modified++;
							counter++;
							metric.attributes.put(attObject.getName(), attmetric);
						}
					}
					for (EReference refObject : object.eClass().getEAllReferences()) {
						MutantMetric refmetric = null;
						if (metric.references.get(refObject.getName()) == null) {
							refmetric = new MutantMetric();
						}
						else {
							refmetric = metric.references.get(refObject.getName());
						}
						boolean mutated = false;
						for (String refName : mutData.referenceNames) {
							if (refObject.getName().equals(refName)) {
								mutated = true;
								break;
							}
						}
						if (mutated == true) {
							refmetric.modified++;
							counter++;
							metric.references.put(refObject.getName(), refmetric);
						}
					}
				}
				metric.modified+=counter;
				metric.cmodified++;
			}
		}
	}

	protected LinkedHashMap<String, WodelMutantMetric> createRegistryFolderMetrics(List<EPackage> packages,
			File mutantFile, EObject met, File seedFile, File folder, List<EObject> folders,
			List<EPackage> registry, Resource program, List<String> blockNames, boolean filterAbstract) {
		LinkedHashMap<String, WodelMutantMetric> mutantMetrics = null;
		try {
			if ((mutantFile.getName().equals("registry") || mutantFile.getName().endsWith("vs")) == false) {
				EObject container = null;
				List<EObject> newFolders = null;
				// Creates the root object
				if (folders == null) {
					List<EObject> trees = ModelManager.getReferences("trees", met);
					EObject tree = null;
					for (EObject t : trees) {
						if (ModelManager.getStringAttribute("name", t).equals(folder.getName())) {
							tree = t;
							break;
						}
					}
					if (tree == null) {
						tree = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics, "Folder"));
						ModelManager.setStringAttribute("name", tree, folder.getName());
						ModelManager.setStringAttribute("path", tree, folder.getPath());
						trees.add(tree);
					}
					container = tree;
					newFolders = ModelManager.getReferences("mutants", tree);
				}
				else {
					for (EObject obj : folders) {
						if (ModelManager.getStringAttribute("name", obj).equals(folder.getName())) {
							newFolders = ModelManager.getReferences("mutants", obj);
							container = obj;
							break;
						}
					}
				}
				EObject objFolder = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics, "Folder"));
				ModelManager.setStringAttribute("name", objFolder, mutantFile.getName());
				ModelManager.setStringAttribute("path", objFolder, mutantFile.getPath());
				newFolders.add(objFolder);

				// CALL
				mutantMetrics = createMetrics(packages, seedFile, mutantFile, met, newFolders, registry, program, blockNames, filterAbstract);
				// --->

				for (EClass cl : ModelManager.getEClasses(packages)) {
					if (filterAbstract == true) {
						if (cl.isAbstract() == true) {
							continue;
						}
					}
					// Folder stats
					int created = 0;
					int modified = 0;
					int removed = 0;
					int ccreated = 0;
					int cmodified = 0;
					int cremoved = 0;
					String name = null;
					LinkedHashMap<String, Integer[]> attmetrics = new LinkedHashMap<String, Integer[]>();
					LinkedHashMap<String, Integer[]> refmetrics = new LinkedHashMap<String, Integer[]>();
					for (EObject obj : newFolders) {
						EObject folderClass = null;
						List<EObject> folderClasses = ModelManager.getReferences("classes", obj);
						for (EObject folderCl : folderClasses) {
							name = ModelManager.getStringAttribute("name", folderCl);
							if (name.equals(cl.getName())) {
								folderClass = folderCl;
								break;
							}
						}
						if (folderClass != null) {
							List<EObject> folderAttributes = ModelManager.getReferences("attributes", folderClass);
							name = null;
							for (EObject folderAtt : folderAttributes) {
								name = ModelManager.getStringAttribute("name", folderAtt);
								for (EAttribute att : cl.getEAllAttributes()) {
									if (name.equals(att.getName())) {
										Integer[] attmetric = new Integer[3];
										attmetric[0] = ModelManager.getIntAttribute("created", folderAtt);
										attmetric[1] = ModelManager.getIntAttribute("modified", folderAtt);
										attmetric[2] = ModelManager.getIntAttribute("removed", folderAtt);
										attmetrics.put(name, attmetric);
										break;
									}
								}
							}
							List<EObject> folderReferences = ModelManager.getReferences("references", folderClass);
							name = null;
							for (EObject folderRef : folderReferences) {
								name = ModelManager.getStringAttribute("name", folderRef);
								for (EReference ref : cl.getEAllReferences()) {
									if (name.equals(ref.getName())) {
										Integer[] refmetric = new Integer[3];
										refmetric[0] = ModelManager.getIntAttribute("created", folderRef);
										refmetric[1] = ModelManager.getIntAttribute("modified", folderRef);
										refmetric[2] = ModelManager.getIntAttribute("removed", folderRef);
										refmetrics.put(name, refmetric);
										break;
									}
								}
							}
							created += ModelManager.getIntAttribute("created", folderClass);
							modified += ModelManager.getIntAttribute("modified", folderClass);
							removed +=  ModelManager.getIntAttribute("removed", folderClass);
							ccreated += ModelManager.getIntAttribute("ccreated", folderClass);
							cmodified += ModelManager.getIntAttribute("cmodified", folderClass);
							cremoved += ModelManager.getIntAttribute("cremoved", folderClass);
						}
					}
					EObject folderClass = null;
					List<EObject> folderClasses = ModelManager.getReferences("classes", container);
					for (EObject folderCl : folderClasses) {
						name = ModelManager.getStringAttribute("name", folderCl);
						if (name.equals(cl.getName())) {
							folderClass = folderCl;
							break;
						}
					}
					if (folderClass == null) {
						folderClass = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics, "Class"));
						ModelManager.setStringAttribute("name", folderClass, cl.getName());
					}
					List<EObject> folderAttributes = ModelManager.getReferences("attributes", folderClass);
					for (String attName : attmetrics.keySet()) {
						EObject folderAttribute = null;
						for (EObject folderAtt : folderAttributes) {
							name = ModelManager.getStringAttribute("name", folderAtt);
							if (name.equals(attName)) {
								folderAttribute = folderAtt;
								break;
							}
						}
						if (folderAttribute == null) {
							folderAttribute = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics, "Attribute"));
							ModelManager.setStringAttribute("name", folderAttribute, attName);
						}
						int attcreated = attmetrics.containsKey(attName) ? attmetrics.get(attName)[0] : 0;
						int attmodified = attmetrics.containsKey(attName) ? attmetrics.get(attName)[1] : 0;
						int attremoved = attmetrics.containsKey(attName) ? attmetrics.get(attName)[2] : 0;
						ModelManager.setIntAttribute("created", folderAttribute, ModelManager.getIntAttribute("created", folderAttribute) + attcreated);
						ModelManager.setIntAttribute("modified", folderAttribute, ModelManager.getIntAttribute("modified", folderAttribute) + attmodified);
						ModelManager.setIntAttribute("removed", folderAttribute, ModelManager.getIntAttribute("removed", folderAttribute) + attremoved);
						folderAttributes.add(folderAttribute);
					}
					List<EObject> folderReferences = ModelManager.getReferences("references", folderClass);
					for (String refName : refmetrics.keySet()) {
						EObject folderReference = null;
						for (EObject folderRef : folderReferences) {
							name = ModelManager.getStringAttribute("name", folderRef);
							if (name.equals(refName)) {
								folderReference = folderRef;
								break;
							}
						}
						if (folderReference == null) {
							folderReference = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics, "Reference"));
							ModelManager.setStringAttribute("name", folderReference, refName);
						}
						int refcreated = refmetrics.containsKey(refName) ? refmetrics.get(refName)[0] : 0;
						int refmodified = refmetrics.containsKey(refName) ? refmetrics.get(refName)[1] : 0;
						int refremoved = refmetrics.containsKey(refName) ? refmetrics.get(refName)[2] : 0;
						ModelManager.setIntAttribute("created", folderReference, ModelManager.getIntAttribute("created", folderReference) + refcreated);
						ModelManager.setIntAttribute("modified", folderReference, ModelManager.getIntAttribute("modified", folderReference) + refmodified);
						ModelManager.setIntAttribute("removed", folderReference, ModelManager.getIntAttribute("removed", folderReference) + refremoved);
						folderReferences.add(folderReference);
					}
					ModelManager.setIntAttribute("created", folderClass, created);
					ModelManager.setIntAttribute("modified", folderClass, modified);
					ModelManager.setIntAttribute("removed", folderClass, removed);
					ModelManager.setIntAttribute("ccreated", folderClass, ccreated);
					ModelManager.setIntAttribute("cmodified", folderClass, cmodified);
					ModelManager.setIntAttribute("cremoved", folderClass, cremoved);
					folderClasses.add(folderClass);
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mutantMetrics;
	}
	
	protected EObject getMetricsContainer(List<EPackage> metrics, File folder, EObject met, List<EObject> folders) {
		EObject container = null;
		try {
			// Creates the root object
			if (folders != null) {
				for (EObject obj : folders) {
					if (ModelManager.getStringAttribute("name", obj).equals(folder.getName())) {
						container = obj;
						break;
					}
				}
			}
			else {
				List<EObject> trees = ModelManager.getReferences("trees", met);
				for (EObject t : trees) {
					if (ModelManager.getStringAttribute("name", t).equals(folder.getName())) {
						container = t;
						break;
					}
				}
				if (container == null) {
					container = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics, "Folder"));
					ModelManager.setStringAttribute("name", container, folder.getName());
					ModelManager.setStringAttribute("path", container, folder.getPath());
					trees.add(container);
				}
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return container;
	}
	
	protected void createSeedObjectsMetrics(List<EObject> seedObjects,
			LinkedHashMap<String, WodelMutantMetric> mutantMetrics) {
		//Seed objects
		for (EObject object : seedObjects) {
			WodelMutantMetric metric = null;
			if (mutantMetrics.get(object.eClass().getName()) == null) {
				metric = new WodelMutantMetric();
			}
			else {
				metric = mutantMetrics.get(object.eClass().getName());
			}
			for (EAttribute attribute : object.eClass().getEAllAttributes()) {
				MutantMetric attmetric = null;
				if (metric.attributes.get(attribute.getName()) == null) {
					attmetric = new MutantMetric();
				}
				else {
					attmetric = metric.attributes.get(attribute.getName());
				}
				metric.attributes.put(attribute.getName(), attmetric);
			}
			for (EReference reference : object.eClass().getEAllReferences()) {
				MutantMetric refmetric = null;
				if (metric.references.get(reference.getName()) == null) {
					refmetric = new MutantMetric();
				}
				else {
					refmetric = metric.references.get(reference.getName());
				}
				metric.references.put(reference.getName(), refmetric);
			}
			mutantMetrics.put(object.eClass().getName(), metric);
		}
	}

	protected void createMutantObjectsMetrics(List<EObject> mutantObjects,
			LinkedHashMap<String, WodelMutantMetric> mutantMetrics) {
		//Mutant objects
		for (EObject object : mutantObjects) {
			WodelMutantMetric metric = null;
			if (mutantMetrics.get(object.eClass().getName()) == null) {
				metric = new WodelMutantMetric();
			}
			else {
				metric = mutantMetrics.get(object.eClass().getName());
			}
			for (EAttribute attribute : object.eClass().getEAllAttributes()) {
				MutantMetric attmetric = null;
				if (metric.attributes.get(attribute.getName()) == null) {
					attmetric = new MutantMetric();
				}
				else {
					attmetric = metric.attributes.get(attribute.getName());
				}
				metric.attributes.put(attribute.getName(), attmetric);
			}
			for (EReference reference : object.eClass().getEAllReferences()) {
				MutantMetric refmetric = null;
				if (metric.references.get(reference.getName()) == null) {
					refmetric = new MutantMetric();
				}
				else {
					refmetric = metric.references.get(reference.getName());
				}
				metric.references.put(reference.getName(), refmetric);
			}
			mutantMetrics.put(object.eClass().getName(), metric);
		}
	}
	
	protected void storeDynamicMetrics(List<EPackage> packages,
			EObject met, EObject mutant, EObject container,
			LinkedHashMap<String, WodelMutantMetric> mutantMetrics) {
		try {
			List<EObject> classes = ModelManager.getReferences("classes", met);
			List<EObject> mutantClasses = ModelManager.getReferences("classes", mutant);
			List<EObject> containerClasses = ModelManager.getReferences("classes", container);
			for (String className : mutantMetrics.keySet()) {
				WodelMutantMetric metric = mutantMetrics.get(className);
				// Global stats
				EObject mutationClass = null;
				for (EObject cl : classes) {
					String name = ModelManager.getStringAttribute("name", cl);
					if (name.equals(className)) {
						mutationClass = cl;
						break;
					}
				}
				if (mutationClass == null) {
					mutationClass = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics,"Class"));
					ModelManager.setStringAttribute("name", mutationClass, className);
				}
				List<EObject> mutationAttributes = ModelManager.getReferences("attributes", mutationClass);
				EClass eclass = ModelManager.getEClassByName(packages, className);
				for (EAttribute att : eclass.getEAllAttributes()) {
					EObject mutationAttribute = null;
					for (EObject mutationAtt : mutationAttributes) {
						String name = ModelManager.getStringAttribute("name", mutationAtt);
						if (name.equals(att.getName())) {
							mutationAttribute = mutationAtt;
							break;
						}
					}
					if (mutationAttribute == null) {
						mutationAttribute = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics, "Attribute"));
						ModelManager.setStringAttribute("name", mutationAttribute, att.getName());
					}
					int attcreated = ModelManager.getIntAttribute("created", mutationAttribute);
					int attmodified = ModelManager.getIntAttribute("modified", mutationAttribute);
					int attremoved = ModelManager.getIntAttribute("removed", mutationAttribute);
					if (metric.attributes.containsKey(att.getName()) == true) {
						attcreated += metric.attributes.get(att.getName()).created;
						attmodified += metric.attributes.get(att.getName()).modified;
						attremoved += metric.attributes.get(att.getName()).removed;
					}
					ModelManager.setIntAttribute("created", mutationAttribute, attcreated);
					ModelManager.setIntAttribute("modified", mutationAttribute, attmodified);
					ModelManager.setIntAttribute("removed", mutationAttribute, attremoved);
					mutationAttributes.add(mutationAttribute);
				}									
				List<EObject> mutationReferences = ModelManager.getReferences("references", mutationClass);
				for (EReference ref : eclass.getEAllReferences()) {
					EObject mutationReference = null;
					for (EObject mutationRef : mutationReferences) {
						String name = ModelManager.getStringAttribute("name", mutationRef);
						if (name.equals(ref.getName())) {
							mutationReference = mutationRef;
							break;
						}
					}
					if (mutationReference == null) {
						mutationReference = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics, "Reference"));
						ModelManager.setStringAttribute("name", mutationReference, ref.getName());
					}
					int refcreated = ModelManager.getIntAttribute("created", mutationReference);
					int refmodified = ModelManager.getIntAttribute("modified", mutationReference);
					int refremoved = ModelManager.getIntAttribute("removed", mutationReference);
					if (metric.references.containsKey(ref.getName()) == true) {
						refcreated += metric.references.get(ref.getName()).created;
						refmodified += metric.references.get(ref.getName()).modified;
						refremoved += metric.references.get(ref.getName()).removed;
					}
					ModelManager.setIntAttribute("created", mutationReference, refcreated);
					ModelManager.setIntAttribute("modified", mutationReference, refmodified);
					ModelManager.setIntAttribute("removed", mutationReference, refremoved);
					mutationReferences.add(mutationReference);
				}									
				ModelManager.setIntAttribute("created", mutationClass, ModelManager.getIntAttribute("created", mutationClass) + metric.created);
				ModelManager.setIntAttribute("modified", mutationClass, ModelManager.getIntAttribute("modified", mutationClass) + metric.modified);
				ModelManager.setIntAttribute("removed", mutationClass, ModelManager.getIntAttribute("removed", mutationClass) + metric.removed);
				ModelManager.setIntAttribute("ccreated", mutationClass, ModelManager.getIntAttribute("ccreated", mutationClass) + metric.ccreated);
				ModelManager.setIntAttribute("cmodified", mutationClass, ModelManager.getIntAttribute("cmodified", mutationClass) + metric.cmodified);
				ModelManager.setIntAttribute("cremoved", mutationClass, ModelManager.getIntAttribute("cremoved", mutationClass) + metric.cremoved);
				classes.add(mutationClass);
				// Specific stats
				EObject mutantClass = null;
				for (EObject cl : mutantClasses) {
					String name = ModelManager.getStringAttribute("name", cl);
					if (name.equals(className)) {
						mutantClass = cl;
						break;
					}
				}
				if (mutantClass == null) {
					mutantClass = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics,"Class"));
					ModelManager.setStringAttribute("name", mutantClass, className);
				}
				List<EObject> mutantAttributes = ModelManager.getReferences("attributes", mutantClass);
				for (EAttribute att : eclass.getEAllAttributes()) {
					EObject mutantAttribute = null;
					for (EObject mutantAtt : mutantAttributes) {
						String name = ModelManager.getStringAttribute("name", mutantAtt);
						if (name.equals(att.getName())) {
							mutantAttribute = mutantAtt;
							break;
						}
					}
					if (mutantAttribute == null) {
						mutantAttribute = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics, "Attribute"));
						ModelManager.setStringAttribute("name", mutantAttribute, att.getName());
					}
					int attcreated = 0;
					int attmodified = 0;
					int attremoved = 0;
					if (metric.attributes.containsKey(att.getName()) == true) {
						attcreated += metric.attributes.get(att.getName()).created;
						attmodified += metric.attributes.get(att.getName()).modified;
						attremoved += metric.attributes.get(att.getName()).removed;
					}
					ModelManager.setIntAttribute("created", mutantAttribute, attcreated);
					ModelManager.setIntAttribute("modified", mutantAttribute, attmodified);
					ModelManager.setIntAttribute("removed", mutantAttribute, attremoved);
					mutantAttributes.add(mutantAttribute);
				}
				List<EObject> mutantReferences = ModelManager.getReferences("references", mutantClass);
				for (EReference ref : eclass.getEAllReferences()) {
					EObject mutantReference = null;
					for (EObject mutantRef : mutantReferences) {
						String name = ModelManager.getStringAttribute("name", mutantRef);
						if (name.equals(ref.getName())) {
							mutantReference = mutantRef;
							break;
						}
					}
					if (mutantReference == null) {
						mutantReference = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics, "Reference"));
						ModelManager.setStringAttribute("name", mutantReference, ref.getName());
					}
					int refcreated = 0;
					int refmodified = 0;
					int refremoved = 0;
					if (metric.references.containsKey(ref.getName()) == true) {
						refcreated += metric.references.get(ref.getName()).created;
						refmodified += metric.references.get(ref.getName()).modified;
						refremoved += metric.references.get(ref.getName()).removed;
					}
					ModelManager.setIntAttribute("created", mutantReference, refcreated);
					ModelManager.setIntAttribute("modified", mutantReference, refmodified);
					ModelManager.setIntAttribute("removed", mutantReference, refremoved);
					mutantReferences.add(mutantReference);
				}
				ModelManager.setIntAttribute("created", mutantClass, metric.created);
				ModelManager.setIntAttribute("modified", mutantClass, metric.modified);
				ModelManager.setIntAttribute("removed", mutantClass, metric.removed);
				ModelManager.setIntAttribute("ccreated", mutantClass, metric.ccreated);
				ModelManager.setIntAttribute("cmodified", mutantClass, metric.cmodified);
				ModelManager.setIntAttribute("cremoved", mutantClass, metric.cremoved);
				mutantClasses.add(mutantClass);
				// Container stats
				EObject containerClass = null;
				for (EObject cl : containerClasses) {
					String name = ModelManager.getStringAttribute("name", cl);
					if (name.equals(className)) {
						containerClass = cl;
						break;
					}
				}
				if (containerClass == null) {
					containerClass = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics,"Class"));
					ModelManager.setStringAttribute("name", containerClass, className);
				}
				List<EObject> containerAttributes = ModelManager.getReferences("attributes", containerClass);
				for (EAttribute att : eclass.getEAllAttributes()) {
					EObject containerAttribute = null;
					for (EObject containerAtt : containerAttributes) {
						String name = ModelManager.getStringAttribute("name", containerAtt);
						if (name.equals(att.getName())) {
							containerAttribute = containerAtt;
							break;
						}
					}
					if (containerAttribute == null) {
						containerAttribute = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics, "Attribute"));
						ModelManager.setStringAttribute("name", containerAttribute, att.getName());
					}
					int attcreated = ModelManager.getIntAttribute("created", containerAttribute);
					int attmodified = ModelManager.getIntAttribute("modified", containerAttribute);
					int attremoved = ModelManager.getIntAttribute("removed", containerAttribute);
					if (metric.attributes.containsKey(att.getName()) == true) {
						attcreated += metric.attributes.get(att.getName()).created;
						attmodified += metric.attributes.get(att.getName()).modified;
						attremoved += metric.attributes.get(att.getName()).removed;
					}
					ModelManager.setIntAttribute("created", containerAttribute, attcreated);
					ModelManager.setIntAttribute("modified", containerAttribute, attmodified);
					ModelManager.setIntAttribute("removed", containerAttribute, attremoved);
					containerAttributes.add(containerAttribute);
				}
				List<EObject> containerReferences = ModelManager.getReferences("references", containerClass);
				for (EReference ref : eclass.getEAllReferences()) {
					EObject containerReference = null;
					for (EObject containerRef : containerReferences) {
						String name = ModelManager.getStringAttribute("name", containerRef);
						if (name.equals(ref.getName())) {
							containerReference = containerRef;
							break;
						}
					}
					if (containerReference == null) {
						containerReference = mutatormetrics.MutatormetricsFactory.eINSTANCE.create(ModelManager.getEClassByName(metrics, "Reference"));
						ModelManager.setStringAttribute("name", containerReference, ref.getName());
					}
					int refcreated = ModelManager.getIntAttribute("created", containerReference);
					int refmodified = ModelManager.getIntAttribute("modified", containerReference);
					int refremoved = ModelManager.getIntAttribute("removed", containerReference);
					if (metric.references.containsKey(ref.getName()) == true) {
						refcreated += metric.references.get(ref.getName()).created;
						refmodified += metric.references.get(ref.getName()).modified;
						refremoved += metric.references.get(ref.getName()).removed;
					}
					ModelManager.setIntAttribute("created", containerReference, refcreated);
					ModelManager.setIntAttribute("modified", containerReference, refmodified);
					ModelManager.setIntAttribute("removed", containerReference, refremoved);
					containerReferences.add(containerReference);
				}
				ModelManager.setIntAttribute("created", containerClass, ModelManager.getIntAttribute("created", containerClass) + metric.created);
				ModelManager.setIntAttribute("modified", containerClass, ModelManager.getIntAttribute("modified", containerClass) + metric.modified);
				ModelManager.setIntAttribute("removed", containerClass,  ModelManager.getIntAttribute("removed", containerClass) + metric.removed);
				ModelManager.setIntAttribute("ccreated", containerClass, ModelManager.getIntAttribute("ccreated", containerClass) + metric.ccreated);
				ModelManager.setIntAttribute("cmodified", containerClass, ModelManager.getIntAttribute("cmodified", containerClass) + metric.cmodified);
				ModelManager.setIntAttribute("cremoved", containerClass, ModelManager.getIntAttribute("cremoved", containerClass) + metric.cremoved);
				containerClasses.add(containerClass);
			}
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected LinkedHashMap<String, WodelMutantMetric> createMetrics(List<EPackage> packages,
			File seedFile, File folder, EObject met, List<EObject> folders, List<EPackage> registry,
			Resource program, List<String> blockNames, boolean filterAbstract) {
		return null;
	}
	
	public void run() throws MetaModelNotFoundException {
	}
}
