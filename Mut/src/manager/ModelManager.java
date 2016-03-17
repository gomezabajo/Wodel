package manager;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import mutatorenvironment.CompositeMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;

import org.eclipse.emf.common.util.URI;
import org.eclipse.core.runtime.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.google.inject.Injector;

import commands.ObjectEmitter;
import commands.selection.strategies.ObSelectionStrategy;
import commands.selection.strategies.RandomTypeSelection;
import commands.strategies.AttributeConfigurationStrategy;
import commands.strategies.ReferenceConfigurationStrategy;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;

/**
 * @author Victor Lopez Rivero Class with static methods to get information of
 *         the models
 */

public class ModelManager {

	public static Random rn = new Random((int) System.currentTimeMillis());

	/**
	 * @param metamodel
	 *            : path of the MetaModel
	 * @return ArrayList<EPackage> Loaded MetaModel
	 */
	public static ArrayList<EPackage> loadMetaModel(String metamodel)
			throws MetaModelNotFoundException {
		ResourceSet rs = new ResourceSetImpl();

		String ecoreURI = createURI(metamodel).toString();

		if (metamodel.startsWith("http:/")) {
			EPackage existingPackage;
			Registry reg = EPackage.Registry.INSTANCE;
			if ((existingPackage = reg.getEPackage(ecoreURI)) != null) { // Check
																			// if
																			// already
																			// registered...
				ArrayList<EPackage> ret = new ArrayList<EPackage>();
				ret.add(existingPackage);
				return ret;
			}
		}

		EPackage.Registry.INSTANCE.put(ecoreURI, EPackage.class);
		if (Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
				.size() == 0)
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"*", new XMIResourceFactoryImpl());

		try {
			Resource resource = rs.getResource(
					org.eclipse.emf.common.util.URI.createFileURI(ecoreURI),
					true);
		} catch (RuntimeException r) {
			throw new MetaModelNotFoundException(ecoreURI);
		}

		ArrayList<EPackage> ret = new ArrayList<EPackage>();
		for (Resource r : rs.getResources()) {
			Resource resourceAux = rs.getResource(r.getURI(), true);

			try {
				resourceAux.load(null);
			} catch (IOException e) {
				throw new MetaModelNotFoundException(r.getURI().toFileString());
			}

			ret.addAll((List<? extends EPackage>) r.getContents());
		}
		return ret;

	}

	public static URI createURI(String path) {
		return createURI(path, null);
	}

	public static URI createURI(String path, String cwd) {
		String uriString = path;
		if (uriString.startsWith("platform:/resource/")) {
			// this option depends on org.eclipse.resources
			// return
			// URI.createPlatformResourceURI(ResourcesPlugin.getWorkspace().getRoot().getFile(new
			// Path(uriString)), true);
			return URI.createPlatformResourceURI(
					extract(uriString, "platform:/resource/"), true);
		} else if (uriString.startsWith("platform:/plugin/")) {
			return URI.createPlatformPluginURI(
					extract(uriString, "platform:/plugin/"), true);
		} else if (uriString.startsWith("http:/")) { // to allow loading
														// http:/www.eclipse.org/emf/2002/Ecore,
														// but this is not the
														// general case
			URI u = URI.createURI(path);
			return u;
		}

		if (cwd == null) {
			return URI.createURI(path);
		} else {
			URI uri = URI.createFileURI(new File(path).getAbsolutePath());
			return uri;
		}
	}

	private static String extract(String s, String extract) {
		return s.replaceFirst("^" + extract, "");
	}

	public static String getWorkspaceAbsolutePath() {
		IPath path = Platform.getLocation().makeAbsolute();
		URI uri = URI.createFileURI(path.toString());
		String ret = uri.toString();
		ret = ret.replaceFirst("file:/", "");
		return ret;
	}

	public static URI getModelWithFolder(String model) {
		IPath path = Platform.getLocation().makeAbsolute();
		System.out.println("PATH: " + path.toOSString());

		URI uri = null;

		// The URI is relative so we have to complete it
		if (URI.createURI(model).isRelative()) {
			uri = URI.createFileURI(path.toString() + "/"
					+ WodelContext.getProject() + "/" + model);
			System.out.println("Relative:" + path.toString() + "/"
					+ WodelContext.getProject() + "/" + model);
		} else {
			uri = URI.createFileURI(model);
			System.out.println("No Relative:" + model);
		}

		System.out.println("platform === " + uri);

		return uri;
	}

	public static String getMetaModel() {
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ WodelContext.getProject();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/config/config.txt"));

			String modelName = br.readLine();
			File[] files = new File(path + '/' + modelName).listFiles();
			for (File file : files) {
				if (file.isFile() == true) {
					String modelpath = file.getPath();
					if (modelpath.endsWith(".ecore") == true) {
						return modelpath;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getMetaModelPath() {
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ WodelContext.getProject();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/config/config.txt"));

			return path + '/' + br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static HashSet<String> getExtensions() {
		HashSet<String> extensions = new HashSet<String>();
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ WodelContext.getProject();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/config/config.txt"));

			br.readLine();
			br.readLine();
			String ext = null;
			while ((ext = br.readLine()) != null) {
				extensions.add(ext);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return extensions;
	}

	public static List<String> getModels() {
		List<String> modelpaths = null;
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ WodelContext.getProject();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/config/config.txt"));

			String modelName = br.readLine();
			File[] files = new File(path + '/' + modelName).listFiles();
			modelpaths = new ArrayList<String>();
			for (File file : files) {
				if (file.isFile() == true) {
					String modelpath = file.getPath();
					if (modelpath.endsWith(".model") == true) {
						modelpaths.add(modelpath);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelpaths;
	}

	public static String getModelsFolder() {
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ WodelContext.getProject();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/config/config.txt"));

			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getOutputPath() {
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ WodelContext.getProject();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/config/config.txt"));

			br.readLine();
			String mutantName = br.readLine();
			return getWorkspaceAbsolutePath() + '/' + WodelContext.getProject()
					+ '/' + mutantName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getOutputFolder() {
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ WodelContext.getProject();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/config/config.txt"));

			br.readLine();
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static ResourceSet initializeResource(String modelURI) {
		ResourceSet resourceSet = new ResourceSetImpl();

		int i = modelURI.lastIndexOf('.');
		if (i > 0) {
			String ext = modelURI.substring(i + 1);
			if (!resourceSet.getResourceFactoryRegistry()
					.getExtensionToFactoryMap().containsKey(ext)) {
				System.out.println("Adding new Factory for extension: " + ext);
				resourceSet.getResourceFactoryRegistry()
						.getExtensionToFactoryMap()
						.put(ext, new XMIResourceFactoryImpl());
			}
		}
		return resourceSet;
	}

	/**
	 * @param packages
	 *            MetaModel
	 * @param modelURI
	 *            URI of the Model
	 * @return Resource Loaded Model
	 * @throws
	 */
	public static Resource loadModel(ArrayList<EPackage> packages,
			String modelURI) throws ModelNotFoundException {

		ResourceSet resourceSet = ModelManager.initializeResource(modelURI);
		URI uri = ModelManager.getModelWithFolder(modelURI);
		for (EPackage p : packages) {
			// Add packages to package registry
			if (!resourceSet.getPackageRegistry().containsKey(p.getNsURI()))
				resourceSet.getPackageRegistry().put(p.getNsURI(), p);
		}
		Resource model;
		try {
			model = resourceSet.createResource(uri);
			model.load(null);
			// model = resourceSet.getResource(URI.createURI(modelURI),true); //
			// load model using the URI
		} catch (IOException r) {
			throw new ModelNotFoundException(modelURI);
		}

		return model;
	}

	/**
	 * Checks whether a certain model exists or not
	 * 
	 * @return
	 */
	public static boolean checkModel(String model) {
		return true;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return ArrayList<EObject> All the objects except root
	 */
	public static ArrayList<EObject> getObjects(Resource model) {

		ArrayList<EObject> objs = new ArrayList<EObject>();

		Iterator<EObject> objects = model.getAllContents();

		EStructuralFeature auxRef = null;

		while (objects.hasNext()) {
			EObject obj = objects.next();
			if (obj.eContainer() == null) {
				continue;
			} else {
				objs.add(obj);
			}
		}
		return objs;
	}

	/**
	 * @param type
	 *            Name of the wanted object
	 * @param model
	 *            Loaded Model
	 * @return ArrayList<EObject> All the classes or objects of the specified
	 *         type
	 */
	public static ArrayList<EObject> getObjectsOfType(String type,
			Resource model) {

		ArrayList<EObject> objs = new ArrayList<EObject>();

		Iterator<EObject> objects = model.getAllContents();

		EStructuralFeature auxRef = null;

		while (objects.hasNext()) {
			EObject object = objects.next();

			// Check the type
			if (type.equals(object.eClass().getName())) {
				objs.add(object);
			} else if ((auxRef = getReferenceByName(type, object)) != null
					&& type.equals(auxRef.getName())) {
				objs.add(auxRef);
			} else {
				for (EClass c : object.eClass().getESuperTypes()) {
					if (type.equals(c.getName())) {
						objs.add(object);
					}
				}
			}
		}
		return objs;
	}

	/**
	 * @param type
	 *            Name of the type
	 * @param metaModel
	 *            Loaded MetaModel
	 * @return EObject Class or reference of the specified type
	 */
	public static EObject getObjectOfType(String type, List<EPackage> metaModel) {

		for (EPackage p : metaModel) {
			// For each classifier
			for (EClassifier c : p.getEClassifiers()) {
				// If we are looking for a Class, check its name
				if (c.getName().equals(type)) {
					return c;
				}
				// If we are looking for a Reference, check all references of
				// the classifier
				else {
					if (c instanceof EClass) {
						for (EReference r : ((EClass) c).getEAllReferences()) {
							if (r.getName().equals(type)) {
								return r;
							}
						}
					}
				}
			}
		}

		return null;
	}

	/**
	 * @param metaModel
	 *            Loaded MetaModel
	 * @return EObject Classes
	 */
	public static ArrayList<EObject> getObjectFromMetamodel(
			List<EPackage> metaModel) {

		ArrayList<EObject> ret = new ArrayList<EObject>();

		for (EPackage p : metaModel) {
			// For each classifier
			for (EClassifier c : p.getEClassifiers()) {
				ret.add(c);
			}
		}

		return ret;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return ArrayList<EObject> All the classes or objects
	 */
	public static ArrayList<EObject> getAllObjects(Resource model) {

		ArrayList<EObject> objs = new ArrayList<EObject>();

		Iterator<EObject> objects = model.getAllContents();

		while (objects.hasNext()) {
			EObject object = objects.next();
			objs.add(object);
		}
		return objs;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @param containing
	 *            Name of the containing Class
	 * @return Parents
	 */
	public static ArrayList<EObject> getParentObjects(Resource model,
			String containing) {

		ArrayList<EObject> objs = new ArrayList<EObject>();
		ArrayList<EObject> parents = new ArrayList<EObject>();

		objs = getAllObjects(model);

		for (EObject o : objs) {
			// We search inside the object
			for (EObject cont : o.eContents()) {
				if (cont.eClass().getName().equals(containing)) {
					parents.add(o);
					break;
				}
			}
		}

		return parents;

	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return Root object
	 */
	public static EObject getRoot(Resource model) {
		Iterator<EObject> objects = model.getAllContents();

		if (objects.hasNext()) {
			EObject obj = objects.next();
			return obj;
		}
		return null;
	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObject(Resource model, EObject eobj) {
		ArrayList<EObject> objs = getAllObjects(model);

		for (EObject obj : objs) {
			if (EcoreUtil.equals(eobj, obj)) {
				return obj;
			}
		}
		return null;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EReference getReference(Resource model, EReference eref) {
		ArrayList<EReference> refs = getAllReferences(model);

		for (EReference ref : refs) {
			if (EcoreUtil.equals(eref, ref)) {
				return ref;
			}
		}
		return null;
	}

	/**
	 * @param object
	 *            Object one wants to explore
	 * @return EList<EAttribute> Attributes of the object
	 */
	public static EList<EAttribute> getAttributes(EObject object) {

		EClass tipo = object.eClass();

		return tipo.getEAllAttributes();
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @return String Value of the attribute named by -att-
	 */
	public static String getStringAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return (String) object.eGet(sf, true);
			}
		}
		return null;
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @throws WrongAttributeTypeException
	 */
	public static Object getAttribute(String att, EObject object) {
		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf != null) {
				if (sf.getName().equals(att)) {
					return object.eGet(sf);
				}
			}
		}
		return null;
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param acs
	 *            Value of the new attribute
	 * @throws WrongAttributeTypeException
	 */
	public static void setAttribute(String att, EObject object,
			AttributeConfigurationStrategy acs)
			throws WrongAttributeTypeException {
		EClass tipo = object.eClass();

		System.out.println("att: " + att + "; EObject: " + object.toString()
				+ "; AttributeConfigurationStrategy: " + acs.toString());
		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			System.out.println("sf: " + sf.toString());
			if (sf != null) {
				if (sf.getName().equals(att)) {
					System.out.println("aqui se produce la excepción!");
					System.out.println("sf.getEType(): " + sf.getEType());
					System.out.println("acs: " + acs);
					if (acs.sameType(sf.getEType())) {
						object.eSet(sf, acs.getValue(object));
					} else {
						throw new WrongAttributeTypeException("The attribute '"
								+ att + "' is not of the type '"
								+ acs.getValue().getClass().getSimpleName()
								+ "'");
					}
				}
			}
		}
	}

	/**
	 * @throws ReferenceNonExistingException
	 */
	public static EObject getReference(String ref, EObject object) throws
		ReferenceNonExistingException {

		EClass tipo = object.eClass();
		// EClass tipo = tarObj.eClass();

		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			if (sf != null) {
				if (sf.getName().equals(ref)) {
					return (EObject) object.eGet(sf);
				}
			}
		}
		return null;
	}

	
	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param acs
	 *            Value of the new attribute
	 * @throws WrongAttributeTypeException
	 * @throws ReferenceNonExistingException
	 */
	public static void setReference(String ref, EObject object,
			ObSelectionStrategy oss) throws WrongAttributeTypeException,
			ReferenceNonExistingException {

		EClass tipo = object.eClass();
		EObject tarObj = oss.getObject();
		// EClass tipo = tarObj.eClass();

		System.out.println("ref: " + ref + "; EObject: " + object.toString()
				+ "; ObSelectionStrategy: " + oss.toString());
		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			System.out.println("sf: " + sf.toString());
			if (sf != null) {
				if (sf.getName().equals(ref)) {
					System.out.println("aqui se produce la excepción!");
					System.out.println("sf.getEType(): " + sf.getEType());
					System.out.println("oss: " + oss);
					System.out.println("tarObj: " + tarObj);
					System.out.println("object: " + object);
					// EObject objSf = (EObject) tarObj.eGet(sf);
					// System.out.println("objSf: " + objSf);
					// EObject objSf = (EObject) tarObj.eGet(sf);
					// System.out.println("objSf: " + objSf);
					if (tarObj != null) {
						boolean b = false;
						for (EStructuralFeature sfTar : tarObj.eClass()
								.getEAllReferences()) {
							if (sfTar != null) {
								if (sfTar.getName().equals(ref)) {
									object.eSet(sf, tarObj.eGet(sfTar));
									b = true;
									break;
								}
							}
						}
						if (b == false) {
							try {
								object.eSet(sf, tarObj);
							} catch (ClassCastException ex) {
								throw new WrongAttributeTypeException(
										"The reference '"
												+ ref
												+ "' is not of the type '"
												+ tarObj.getClass()
														.getSimpleName() + "'");
							}
						}
					} else {
						throw new ReferenceNonExistingException(
								"There is no object for the reference '" + ref
										+ "'");

					}
					// object.eSet(sf, tarObj);
				}
			}
		}
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param acs
	 *            Value of the new attribute
	 * @throws WrongAttributeTypeException
	 * @throws ReferenceNonExistingException
	 */
	public static void setReference(String ref, EObject object,
			ReferenceConfigurationStrategy rcs)
			throws WrongAttributeTypeException, ReferenceNonExistingException {
		EClass tipo = object.eClass();

		System.out.println("ref: " + ref + "; EObject: " + object.toString()
				+ "; ReferenceConfigurationStrategy: " + rcs.toString());
		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			System.out.println("sf: " + sf.toString());
			if (sf != null) {
				if (sf.getName().equals(ref)) {
					System.out.println("aqui se produce la excepción!");
					System.out.println("sf.getEType(): " + sf.getEType());
					System.out.println("rcs: " + rcs);
					if (rcs.sameType()) {
						object.eSet(sf, rcs.getValue(object));
					} else {
						throw new WrongAttributeTypeException("The reference '"
								+ ref
								+ "' is not of the type '"
								+ rcs.getValue(object).getClass()
										.getSimpleName() + "'");
					}
				}
			}
		}
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 */
	public static void unsetAttribute(String att, EObject object) {
		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				object.eUnset(sf);
			}
		}
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 */
	public static void unsetReference(String ref, EObject object) {
		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			if (sf.getName().equals(ref)) {
				object.eUnset(sf);
			}
		}
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param newValue
	 *            Value of the new attribute
	 */
	public static void setStringAttribute(String att, EObject object,
			String newValue) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				object.eSet(sf, newValue);
			}
		}
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @return Integer Value of the attribute named by -att-
	 */
	public static Integer getIntAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return (Integer) object.eGet(sf, true);
			}
		}
		return null;
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @return Double Value of the attribute named by -att-
	 */
	public static Double getDoubleAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return (Double) object.eGet(sf, true);
			}
		}
		return null;
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @return Boolean Value of the attribute named by -att-
	 */
	public static Boolean getBooleanAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return (Boolean) object.eGet(sf, true);
			}
		}
		return null;
	}

	/**
	 * @param object
	 *            Object one wants to explore
	 * @return List<EReference> References of the object
	 */
	public static List<EReference> getReferences(EObject object) {

		EClass tipo = object.eClass();

		return tipo.getEAllReferences();
	}

	/**
	 * @param container
	 *            Container object
	 * @param containing
	 *            Name of the containing Object
	 * @return References that contains the containing object
	 * @throws ReferenceNonExistingException
	 */
	public static ArrayList<EReference> getContainingReferences(
			ArrayList<EPackage> metaModel, EObject container, String containing)
			throws ReferenceNonExistingException {
		ArrayList<EReference> contRefs = new ArrayList<EReference>();
		List<EReference> refs = getReferences(container);
		EClass obj = (EClass) getObjectOfType(containing, metaModel);

		for (EReference r : refs) {
			if (r.isChangeable()) {
				System.out.println("\nref:" + r.getName() + " type:"
						+ r.getEType().getName());
				System.out.println("obj.allSupers: ");
				for (EClass c : obj.getEAllSuperTypes())
					System.out.print(c.getName() + ", ");
				if (r.getEType().getName().equals(containing)
						|| obj.getEAllSuperTypes().contains(r.getEType())) {
					contRefs.add(r);
				}
			}
		}

		return contRefs;
	}

	/**
	 * @param name
	 *            Name of the reference
	 * @param model
	 *            Loaded Model
	 * @return ArrayList<EStructuralFeature> Specified references of the model
	 */
	public static ArrayList<EStructuralFeature> getAllReferencesByName(
			String name, Resource model) {
		ArrayList<EStructuralFeature> ret = new ArrayList<EStructuralFeature>();
		Iterator<EObject> objetos = model.getAllContents();
		EStructuralFeature sf = null;
		while (objetos.hasNext()) {
			EObject objeto = objetos.next();
			if ((sf = getReferenceByName(name, objeto)) != null)
				ret.add(sf);
		}
		return ret;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return ArrayList<EStructuralFeature> References of the model
	 */
	public static ArrayList<EReference> getAllReferences(Resource model) {
		ArrayList<EReference> ret = new ArrayList<EReference>();
		Iterator<EObject> objetos = model.getAllContents();
		while (objetos.hasNext()) {
			EObject objeto = objetos.next();
			List<EReference> refs = getReferences(objeto);
			for (EReference r : refs) {
				if (!ret.contains(r)) {
					ret.add(r);
				}
			}
		}
		return ret;
	}

	/**
	 * @param source
	 *            Source object
	 * @param target
	 *            Target object
	 * @return EReference Specified reference
	 */
	public static EReference getReferenceBetweenObjects(EObject source,
			EObject target) {
		List<EReference> refs = source.eClass().getEAllReferences();

		for (EReference r : refs) {
			if (r.getUpperBound() == 1) {
				if (source.eGet(r, true).equals(target))
					return r;
			} else {
				for (EObject aux : (List<EObject>) source.eGet(r, true)) {
					if (aux != null && target.equals(aux)) {
						return r;
					}
				}
			}
		}
		return null;
	}

	/**
	 * @param name
	 *            Name of the reference
	 * @param object
	 *            Object one wants to explore
	 * @return EStructuralFeature Specified reference
	 */
	public static EStructuralFeature getReferenceByName(String name,
			EObject object) {
		EStructuralFeature sf = null;

		List<EReference> refs = getReferences(object);

		for (EStructuralFeature sf2 : refs) {
			if (sf2.getName().equals(name)) {
				sf = sf2;
			}
		}
		return sf;
	}

	/**
	 * @param model
	 *            Model one wants to output
	 * @param outputURI
	 *            URI of the new created Model
	 */
	public static void saveModel(Resource model, String outputURI) {
		ResourceSet rs = new ResourceSetImpl();
		ResourceSet rs2 = new ResourceSetImpl();
		rs2.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMLResourceFactoryImpl());
		Resource resource = rs.createResource(URI.createURI(outputURI));
		resource.getContents().addAll(model.getContents());
		Map options = new HashMap();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param model
	 *            Model one wants to output
	 * @param outputURI
	 *            URI of the new created Model
	 */
	public static void createModel(EObject eobj, String outputURI) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMLResourceFactoryImpl());
		URI uri = URI.createFileURI(outputURI);
		Resource resource = rs.createResource(uri);
		Map<Object, Object> saveOptions = ((XMLResource) resource)
				.getDefaultSaveOptions();
		saveOptions.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE,
				new ArrayList());
		resource.getContents().add(eobj);
		try {
			resource.save(saveOptions);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param l
	 *            List in order to get the size and index
	 * @return Random number
	 */
	public static int getRandomIndex(List l) {
		if (l.size() == 1)
			return 0;

		int index = rn.nextInt() % l.size();
		if (index < 0)
			index = index * -1;

		System.out.println("index: " + index);

		return index;
	}

	public static void saveOutModel(Resource model, String outputURI) {
		URI uri = model.getURI();
		model.setURI(URI.createFileURI(outputURI));
		Map options = new HashMap();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		try {
			model.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			model.setURI(uri);
		}
	}

	// ESTHER -----------------------------

	/**
	 * It returns the types that declare some reference to the received type.
	 * 
	 * @param List
	 *            <EPackage> metaModel
	 * @param String
	 *            type
	 */
	public static List<EClassifier> getContainerTypes(List<EPackage> metaModel,
			String type) {
		List<EClassifier> classifiers = new ArrayList<EClassifier>();
		EClass classifier = (EClass) getObjectOfType(type, metaModel);
		if (classifier != null) {
			for (EPackage p : metaModel) {
				for (EClassifier c : p.getEClassifiers()) {
					if (c instanceof EClass) {
						for (EReference r : ((EClass) c).getEAllReferences()) {
							if (r.isContainment()) { // only containment
														// relations!
								if (r.getEReferenceType().isSuperTypeOf(
										classifier)
										&& !classifiers.contains(c)) {
									classifiers.add(c);
									break;
								}
							}
						}
					}

				}
			}
		}
		return classifiers;
	}

	public static boolean compareModels(Resource model1, Resource model2) {
		IComparisonScope scope = new DefaultComparisonScope(model1, model2,
				null);
		Comparison comparison = EMFCompare.builder().build().compare(scope);

		List<Diff> differences = comparison.getDifferences();

		if (differences.size() == 0) {
			return true;
		}

		return false;
	}

	/**
	 * It returns the list of classes defined in a meta-model.
	 */
	public static ArrayList<EClass> getEClasses(List<EPackage> packages) {
		ArrayList<EClass> classes = new ArrayList<EClass>();
		for (EPackage pck : packages) {
			for (EClassifier cl : pck.getEClassifiers()) {
				if (cl instanceof EClass) {
					classes.add((EClass) cl);
				}
			}
		}
		return classes;
	}

	/**
	 * Counts the number of commands inside the composite mutator.
	 */
	public static int mutatorSize(CompositeMutator cmut) {
		int count = 0;
		for (Mutator c : cmut.getCommands()) {
			if (c instanceof CompositeMutator) {
				count += mutatorSize((CompositeMutator) c);
			} else {
				count++;
			}
		}
		return count;
	}

	public static int compositeMutatorSize(CompositeMutator cmut) {
		int count = 1;
		for (Mutator c : cmut.getCommands()) {
			if (c instanceof CompositeMutator) {
				count += compositeMutatorSize((CompositeMutator) c);
			}
		}
		return count;
	}

	/**
	 * Counts the number of composite commands inside the composite mutator.
	 */
	public static int mutatorEnvironmentSize(MutatorEnvironment env) {
		int count = 0;
		for (Mutator c : env.getCommands()) {
			if (c instanceof CompositeMutator) {
				count++;
				count += compositeMutatorSize((CompositeMutator) c);
			}
		}
		return count;
	}
}