package wodeltest.run.commands;

import appliedMutations.AttributeChanged;
import appliedMutations.InformationChanged;
import appliedMutations.ObjectCreated;
import appliedMutations.ObjectRemoved;
import appliedMutations.ReferenceChanged;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.WodelTestResultClass;

public class AnnotateMutations {
	public static boolean annotateMutationsProcess(IProject project, String metamodelpath, String metamodel, Resource model) {
		try {

			List<IWodelTest> tests = new ArrayList<IWodelTest>();
			if (Platform.getExtensionRegistry() != null) {
				IConfigurationElement[] extensions = Platform
						.getExtensionRegistry().getConfigurationElementsFor(
								"wodeltest.extension.MutTesting");
				for (int j = 0; j < extensions.length; j++) {
					IWodelTest test = null;
					try {
						test = (IWodelTest) extensions[j]
								.createExecutableExtension("class");
					} catch (CoreException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tests.add(test);
				}
			}
			String path = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getFullPath().toFile().getPath().toString();
			String projectNamePath = path + "/data/project.txt";
			String[] testInfo = WodelTestResultClass.loadProjectInfo(projectNamePath);
			IWodelTest test = null;
			for (IWodelTest t : tests) {
				if (t.getProjectName().equals(testInfo[0])) {
					test = t;
					break;
				}
			}
			String testContainerEClassName = test.getContainerEClassName();
			if (testContainerEClassName != null && testContainerEClassName.length() > 0) {
				path = model.getURI().toFileString();
				String name = path.substring(path.lastIndexOf(File.separator) + File.separator.length(), path.length());
				if (!name.contains("_") && (path.contains("out") || name.replace(".model", "").contains("."))) {
					String registryName = name.replace(".model", "Registry.model");
					String registryPath = path.substring(0, path.lastIndexOf(File.separator) + File.separator.length()) + "registry" + File.separator + registryName;
					String seedName = path.substring(path.lastIndexOf("out" + File.separator) + ("out" + File.separator).length(), path.length());
					seedName = seedName.substring(0, seedName.indexOf(File.separator)) + ".model";
					String seedPath = metamodelpath + "/" + seedName;
					List<EPackage> domainPackages = ModelManager.loadMetaModel(metamodel);
					File seedFile = new File(seedPath);
					if (!seedFile.exists()) {
						return false;
					}
					Resource seed = ModelManager.loadModel(domainPackages, seedPath);
					Bundle bundle = Platform.getBundle("wodel.models");
					URL fileURL = bundle.getEntry("/model/AppliedMutations.ecore");
					String ecore = FileLocator.resolve(fileURL).getFile();
					List<EPackage> packages = ModelManager.loadMetaModel(ecore);
					Resource registry = ModelManager.loadModel(packages, registryPath);
					List<EObject> objects = ModelManager.getAllObjects(registry);
					List<EObject> mutations = MutatorUtils.getMutations(objects);
					EClass containerEClass = ModelManager.getEClassByName(domainPackages, testContainerEClassName);
					List<EClass> containerEClasses = new ArrayList<EClass>();
					containerEClasses.add(containerEClass);
					containerEClasses.addAll(ModelManager.getESubClasses(domainPackages, containerEClass));
					for (EObject mutation : mutations) {
						boolean found = false;
						if (mutation instanceof InformationChanged) {
							InformationChanged mut = (InformationChanged) mutation;
							EObject registryObject = mut.getObject();
							if (registryObject == null) {
								continue;
							}
							if (registryObject.eIsProxy()) {
								registryObject = EcoreUtil.resolve(registryObject, seed);
							}
							EObject seedObject = ModelManager.getObjectByURIEnding(seed, EcoreUtil.getURI(registryObject));
							if (seedObject != null) {
								EObject container = ModelManager.getContainer(seed, seedObject);
								while (container != null) {
									for (EClass containerECl : containerEClasses) {
										if (containerECl.getName().equals(container.eClass().getName())) {
											found = true;
											break;
										}
									}
									if (found == true) {
										break;
									}
									container = ModelManager.getContainer(seed, container);
								}
								if (found == true) {
									EObject modelContainer = ModelManager.getObjectByURIEnding(model, EcoreUtil.getURI(container));
									String annotation = "modify information mutator: ";
									List<AttributeChanged> attChanges = mut.getAttChanges();
									for (AttributeChanged attChange : attChanges) {
										annotation += attChange.getOldVal() + " replaced by " + attChange.getNewVal();
									}
									List<ReferenceChanged> refChanges = mut.getRefChanges();
									for (ReferenceChanged refChange : refChanges) {
										EObject from = refChange.getFrom();
										EObject to = refChange.getTo();
										if (from != null && to != null) {
											annotation += "source " + from.eClass().getName() + " to " + to.eClass().getName();
										}
									}
									test.annotateMutation(model, modelContainer, annotation);
								}
							}
						}
						if (mutation instanceof ObjectRemoved) {
							ObjectRemoved mut = (ObjectRemoved) mutation;
							if (mut.getObject().size() > 0) {
								EObject registryObject = mut.getObject().get(0);
								if (registryObject.eIsProxy()) {
									registryObject = EcoreUtil.resolve(registryObject, seed);
								}
								EObject seedObject = ModelManager.getObjectByURIEnding(seed, EcoreUtil.getURI(registryObject));
								if (seedObject != null) {
									EObject container = ModelManager.getContainer(seed, seedObject);
									while (container != null) {
										for (EClass containerECl : containerEClasses) {
											if (containerECl.getName().equals(container.eClass().getName())) {
												found = true;
												break;
											}
										}
										if (found == true) {
											break;
										}
										container = ModelManager.getContainer(seed, container);
									}
									if (found == true) {
										EObject modelContainer = ModelManager.getObjectByURIEnding(model, EcoreUtil.getURI(container));
										String annotation = "remove object mutator: ";
										annotation += mut.getType().getName() + " object removed";
										test.annotateMutation(model, modelContainer, annotation);
										break;
									}
								}
							}
						}
						if (mutation instanceof ObjectCreated) {
							ObjectCreated mut = (ObjectCreated) mutation;
							if (mut.getObject().size() > 0) {
								EObject registryObject = mut.getObject().get(0);
								if (registryObject.eIsProxy()) {
									registryObject = EcoreUtil.resolve(registryObject, model);
								}
								EObject mutantObject = ModelManager.getObjectByURIEnding(model, EcoreUtil.getURI(registryObject));
								if (mutantObject != null) {
									EObject mutantContainer = ModelManager.getContainer(model, mutantObject);
									EObject container = ModelManager.getObjectByURIEnding(seed, EcoreUtil.getURI(mutantContainer));
									while (container != null) {
										for (EClass containerECl : containerEClasses) {
											if (containerECl.getName().equals(container.eClass().getName())) {
												found = true;
												break;
											}
										}
										if (found == true) {
											break;
										}
										container = ModelManager.getContainer(seed, container);
									}
									if (found == true) {
										EObject modelContainer = ModelManager.getObjectByURIEnding(model, EcoreUtil.getURI(container));
										String annotation = "create object mutator: ";
										annotation += mut.getObject().get(0).eClass().getName() + " object created";
										test.annotateMutation(model, modelContainer, annotation);
										break;
									}
								}
							}
						}
						if (found == false) {
							if (mutation.eClass().getName().equals("InformationChanged")) {
								EObject registryObject = ModelManager.getReference("object", mutation);
								if (registryObject == null) {
									continue;
								}
								if (registryObject.eIsProxy()) {
									registryObject = EcoreUtil.resolve(registryObject, seed);
								}
								EObject seedObject = ModelManager.getObjectByURIEnding(seed, EcoreUtil.getURI(registryObject));
								if (seedObject != null) {
									EObject container = ModelManager.getContainer(seed, seedObject);
									while (container != null) {
										for (EClass containerECl : containerEClasses) {
											if (containerECl.getName().equals(container.eClass().getName())) {
												found = true;
												break;
											}
										}
										if (found == true) {
											break;
										}
										container = ModelManager.getContainer(seed, container);
									}
									if (found == true) {
										EObject modelContainer = ModelManager.getObjectByURIEnding(model, EcoreUtil.getURI(container));
										String annotation = "modify information mutator: ";
										List<EObject> attChanges = ModelManager.getReferences("attChanges", mutation);
										for (EObject attChange : attChanges) {
											annotation += ModelManager.getAttribute("oldValue", attChange) + " replaced by " + ModelManager.getAttribute("newValue", attChange);
										}
										List<EObject> refChanges = ModelManager.getReferences("refChanges", mutation);
										for (EObject refChange : refChanges) {
											EObject from = ModelManager.getReference("from", refChange);
											EObject to = ModelManager.getReference("to", refChange);
											if (from != null && to != null) {
												annotation += "source " + from.eClass().getName() + " to " + to.eClass().getName();
											}
										}
										test.annotateMutation(model, modelContainer, annotation);
									}
								}
							}
							if (mutation.eClass().getName().equals("ObjectRemoved")) {
								List<EObject> registryObjects = ModelManager.getReferences("object", mutation);
								if (registryObjects.size() > 0) {
									EObject registryObject = registryObjects.get(0);
									if (registryObject.eIsProxy()) {
										registryObject = EcoreUtil.resolve(registryObject, seed);
									}
									EObject seedObject = ModelManager.getObjectByURIEnding(seed, EcoreUtil.getURI(registryObject));
									if (seedObject != null) {
										EObject container = ModelManager.getContainer(seed, seedObject);
										while (container != null) {
											for (EClass containerECl : containerEClasses) {
												if (containerECl.getName().equals(container.eClass().getName())) {
													found = true;
													break;
												}
											}
											if (found == true) {
												break;
											}
											container = ModelManager.getContainer(seed, container);
										}
										if (found == true) {
											EObject modelContainer = ModelManager.getObjectByURIEnding(model, EcoreUtil.getURI(container));
											String annotation = "remove object mutator: ";
											annotation += registryObject.eClass().getName() + " object removed";
											test.annotateMutation(model, modelContainer, annotation);
											break;
										}
									}
								}
							}
							if (mutation.eClass().getName().equals("ObjectCreated")) {
								List<EObject> registryObjects = ModelManager.getReferences("object", mutation);
								if (registryObjects.size() > 0) {
									EObject registryObject = registryObjects.get(0);
									if (registryObject.eIsProxy()) {
										registryObject = EcoreUtil.resolve(registryObject, model);
									}
									EObject mutantObject = ModelManager.getObjectByURIEnding(model, EcoreUtil.getURI(registryObject));
									if (mutantObject != null) {
										EObject mutantContainer = ModelManager.getContainer(model, mutantObject);
										EObject container = ModelManager.getObjectByURIEnding(seed, EcoreUtil.getURI(mutantContainer));
										while (container != null) {
											for (EClass containerECl : containerEClasses) {
												if (containerECl.getName().equals(container.eClass().getName())) {
													found = true;
													break;
												}
											}
											if (found == true) {
												break;
											}
											container = ModelManager.getContainer(seed, container);
										}
										if (found == true) {
											EObject modelContainer = ModelManager.getObjectByURIEnding(model, EcoreUtil.getURI(container));
											String annotation = "create object mutator: ";
											annotation += registryObject.eClass().getName() + " object created";
											test.annotateMutation(model, modelContainer, annotation);
											break;
										}
									}
								}
							}
						}
					}
					ModelManager.saveOutModel(model, path);
				}
			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
