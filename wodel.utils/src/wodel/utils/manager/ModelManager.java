package wodel.utils.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.UnresolvedReferenceException;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import wodel.utils.commands.selection.strategies.ObSelectionStrategy;
import wodel.utils.commands.strategies.AttributeConfigurationStrategy;
import wodel.utils.commands.strategies.RandomStringNumberConfigurationStrategy;
import wodel.utils.commands.strategies.ReferenceConfigurationStrategy;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ModelManager static methods to get information of
 * the models
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class ModelManager {

	public static Random rn = new Random((int) System.currentTimeMillis());

	public static final String NATURE_ID = "wodel.project.wodelNature";
	
	public static boolean isRegistered(List<EPackage> packages) {
		for (EPackage pack : packages) {
			if(EPackage.Registry.INSTANCE.containsKey(pack.getNsURI())) {
				return true;
			}
		}
		return false;
	}

	public static Map<String, EPackage> unregisterMetaModel (List<EPackage> packages) {
		Map<String, EPackage> packs = new HashMap<String, EPackage>(); 
		for (EPackage pack : packages) {
			if (EPackage.Registry.INSTANCE.containsKey(pack.getNsURI())) {
				packs.put(pack.getNsURI(), EPackage.Registry.INSTANCE.getEPackage(pack.getNsURI()));
				EPackage.Registry.INSTANCE.remove(pack.getNsURI());
			}
		}
		return packs;
	}

	public static void registerMetaModel (Map<String, EPackage> packages) {
		for (String nsURI : packages.keySet()) {
			EPackage.Registry.INSTANCE.put(nsURI, packages.get(nsURI));
		}
	}

	public static Map<String, EPackage> registeredMetaModels (List<EPackage> packages) {
		Map<String, EPackage> packs = new HashMap<String, EPackage>(); 
		for (EPackage pack : packages) {
			if (EPackage.Registry.INSTANCE.containsKey(pack.getNsURI())) {
				packs.put(pack.getNsURI(), EPackage.Registry.INSTANCE.getEPackage(pack.getNsURI()));
			}
		}
		return packs;
	}
	
	private static String getProjectNameFromWodelTest() {
		String projectName = null;
		IWodelTest test = getTest();
		if (test != null) {
			projectName = test.getProjectName();
		}
		return projectName;
	}
	
	private static Class<?> getClassFromWodelTest() {
		Class<?> cls = null;
		IWodelTest test = getTest();
		if (test != null) {
			cls = test.getClass();
		}
		return cls;
	}

	public static String processURI(String uri) {
		String processedURI = uri.replace("\\", "/");
		processedURI = processedURI.startsWith("/") && processedURI.indexOf(":") != -1 ? processedURI.substring(1, processedURI.length()) : processedURI;
		if (FileSystems.getDefault().getPath(processedURI).isAbsolute()) {
			return processedURI;
		}
		if (!processedURI.startsWith("/") && !processedURI.startsWith("./")) {
			processedURI = "/" + processedURI;
		}
		IProject project = ProjectUtils.getProject();
		if (project != null) {
			if (ProjectUtils.isWodelProject(project))  {
				if (!processedURI.startsWith("/" + project.getName())) {
					if (!project.getName().endsWith("_1.0.0")) {
						processedURI = "/" + project.getName() + processedURI;
					}
				}
				if (project.getName().endsWith("_1.0.0")) {
					String projectName = project.getName().substring(0, project.getName().lastIndexOf("_1.0.0"));
					if (processedURI.startsWith("/" + projectName)) {
						String endURI = processedURI.substring(("/" + projectName).length(), processedURI.length());
						endURI = endURI.substring(endURI.indexOf("/"), endURI.length());
						processedURI = "/" + project.getName() + endURI;
					}
					else {
						processedURI = "/" + project.getName() + processedURI;
					}
				}
			}
		}
		else {
			String path = getWorkspaceAbsolutePathWithProjectName();
			if (path == null) {
				return processedURI;
			}
			path = path.replace("\\", "/");
			String projectName = path.substring(path.lastIndexOf("/") + 1, path.length());
			if (projectName != null && projectName.length() > 0) {
				if (!processedURI.startsWith("/" + projectName)) {
					if (!projectName.endsWith("_1.0.0")) {
						processedURI = "/" + projectName + processedURI;
					}
				}
				if (projectName.endsWith("_1.0.0")) {
					projectName = projectName.substring(0, projectName.lastIndexOf("_1.0.0"));
					if (processedURI.startsWith("/" + projectName)) {
						String endURI = processedURI.substring(("/" + projectName).length(), processedURI.length());
						endURI = endURI.substring(endURI.indexOf("/"), endURI.length());
						processedURI = "/" + projectName + "_1.0.0" + endURI;
					}
					else {
						processedURI = "/" + projectName + "_1.0.0" + processedURI;
					}
				}
			}
		}
		return processedURI;
	}
	
	private static List<String> subProcessURI(String uri) {
		IProject project = ProjectUtils.getProject();
		String subProcessedURI1 = uri.replace("\\", "/");
		if (project != null) {
			if (subProcessedURI1.startsWith("/" + project.getName())) {
				String str = subProcessedURI1.substring(subProcessedURI1.indexOf("/" + project.getName()), subProcessedURI1.length());
				str = str.substring(1, str.length());
				str = str.substring(str.indexOf("/"), str.length());
				if (subProcessedURI1.indexOf("_1.0.0/") == -1) {
					subProcessedURI1 = "/" + project.getName() + str;
				}
				else {
					subProcessedURI1 = "/" + project.getName() + "_1.0.0" + str;
				}
			}
		}
		String subProcessedURI2 = uri.replace("\\", "/");
		if (project != null) {
			if (subProcessedURI2.startsWith("/" + project.getName())) {
				if (subProcessedURI2.indexOf("_1.0.0/") == -1) {
					subProcessedURI2 = subProcessedURI2.substring(("/" + project.getName()).length(), subProcessedURI2.length());
				}
				else {
					subProcessedURI2 = subProcessedURI2.substring(("/" + project.getName() + "_1.0.0").length(), subProcessedURI2.length());
				}
			}
		}
		List<String> subProcessedURI = new ArrayList<String>();
		subProcessedURI.add(subProcessedURI1);
		subProcessedURI.add(subProcessedURI2);
		return subProcessedURI;
	}

	private static String getAbsoluteMetaModelURI(String uri) throws MetaModelNotFoundException {
		IProject project = ProjectUtils.getProject();
		String path = "";
		String projectName = getProjectNameFromWodelTest();
		if (project == null && projectName != null) {
			Class<?> cls = getClassFromWodelTest();
			path = getWorkspaceAbsolutePath(cls).replace("\\", "/");
		}
		if (path != null && path.length() > 0) {
			path = path.substring(0, path.lastIndexOf("/"));
			String fullPath = path + uri.replace("\\", "/");
			File fmm = new File(fullPath);
			if (fmm.exists()) {
				System.out.println(fullPath);
				return fullPath;
			}
		}
		if (path == null || (path != null && path.length() == 0)) {
			path = Platform.getLocation().toFile().getPath().replace("\\", "/");			
		}
		if (path == null || (path != null && path.length() == 0)) {
			path = getWorkspaceAbsolutePath().replace("\\", "/");
		}
		if (path == null || (path != null && path.length() == 0)) {
			return path;
		}
		String fullPath = path + uri.replace("\\", "/");
		File fmm = new File(fullPath);
		if (!fmm.exists()) {
			String pluginName = uri.substring(1, uri.length());
			pluginName = pluginName.substring(0, pluginName.indexOf("/"));
			String processedURI = "/" + pluginName + "_1.0.0" + uri.substring(("/" + pluginName).length(), uri.length());
			fullPath = path + processedURI;
			fmm = new File(fullPath);
			if (!fmm.exists()) {
				List<String> subProcessedURI = subProcessURI(processedURI);
				fullPath = path + subProcessedURI.get(0);
				fmm = new File(fullPath);
				if (!fmm.exists()) {
					fullPath = path = subProcessedURI.get(1);
					fmm = new File(fullPath);
					if (!fmm.exists()) {
						throw new MetaModelNotFoundException(uri);
					}
				}
			}
		}
		return fullPath;
	}

	public static String getProjectName(String uri) {
		String workspacePath = Platform.getLocation().toFile().toString();
		
		String projectName = "";
		if (uri.startsWith(workspacePath) && workspacePath.indexOf("/") != - 1) {
			projectName = uri.substring((workspacePath + "/").length());
			projectName = projectName.substring(0, projectName.indexOf("/"));
		}
		else if (uri.startsWith(workspacePath) && workspacePath.indexOf("\\") != - 1) {
			projectName = uri.substring((workspacePath + "\\").length());
			projectName = projectName.substring(0, projectName.indexOf("\\"));
		}
		if (projectName.length() == 0 && uri.indexOf("/") != -1) {
			if (uri.indexOf("/") == 0) {
				projectName = uri.substring(1);
				projectName = projectName.substring(0, projectName.indexOf("/"));
			}
			else {
				projectName = uri.substring(0, uri.indexOf("/"));
			}
		}
		else if (projectName.length() == 0 && uri.indexOf("\\") != -1) {
			if (uri.indexOf("\\") == 0) {
				projectName = uri.substring(1, uri.indexOf("\\"));
				projectName = projectName.substring(0, projectName.indexOf("\\"));
			}
			else {
				projectName = uri.substring(0, uri.indexOf("\\"));
			}
		}
		return projectName;
	}

	public static String getMetaModelPathNoException(String projectName) {
		if (projectName == null) {
			return "";
		}

		try {
			String path = Platform.getLocation().toFile().toString() + '/'
					+ projectName;

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = path + '/' + br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static List<EPackage> loadMetaModelNoException (String uri) {
		List<EPackage> metamodel = null;
		
		if (uri == null) {
			return metamodel;			
		}
		String projectName = getProjectName(uri);
		
		if (projectName.length() == 0) {
			return metamodel;
		}
	
		try {
			metamodel = new ArrayList<EPackage>();
			
			String mmURI = uri;
			
			File fmm = new File(uri);
			if (fmm.exists() == false && uri.indexOf("/") != -1) {
				mmURI = getMetaModelPathNoException(projectName) + "/" + uri.substring(uri.lastIndexOf("/") + 1, uri.length());
			}
			if (fmm.exists() == false && uri.indexOf("/") == -1) {
				mmURI = getMetaModelPathNoException(projectName) + "/" + uri;
			}

			// check if it is already registered
			EPackage pck = EPackage.Registry.INSTANCE.getEPackage(mmURI);
			
			// otherwise
			if (pck == null) {
				EPackage.Registry.INSTANCE.put(uri, EPackage.class);
				if (Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().size() == 0)
					Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
				
				ResourceSetImpl resourceSet = new ResourceSetImpl();
				Resource        resource    = resourceSet.getResource(URI.createFileURI(mmURI), true);
				for (EObject obj : resource.getContents()) {
					if (obj instanceof EPackage) {
						resourceSet.getPackageRegistry().put(((EPackage)obj).getNsURI(), ((EPackage)obj).getEFactoryInstance().getEPackage());
						metamodel.add((EPackage)obj);
					}
				}
			}
			else metamodel.add(pck);

			
		}
		catch (Exception e) {
		}
		
		return metamodel;
	}
	
	public static List<EPackage> loadMetaModelNoException (String projectName, String uri) {
		List<EPackage> metamodel = null;
		if (uri == null) {
			return metamodel;			
		}
		try {
			metamodel = new ArrayList<EPackage>();
			
			String mmURI = uri;
			
			File fmm = new File(uri);
			if (fmm.exists() == false && uri.indexOf("/") != -1) {
				mmURI = getMetaModelPathNoException(projectName) + "/" + uri.substring(uri.lastIndexOf("/") + 1, uri.length());
			}
			if (fmm.exists() == false && uri.indexOf("/") == -1) {
				mmURI = getMetaModelPathNoException(projectName) + "/" + uri;
			}

			// check if it is already registered
			EPackage pck = EPackage.Registry.INSTANCE.getEPackage(mmURI);
			
			// otherwise
			if (pck == null) {
				EPackage.Registry.INSTANCE.put(uri, EPackage.class);
				if (Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().size() == 0)
					Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
				
				ResourceSetImpl resourceSet = new ResourceSetImpl();
				Resource        resource    = resourceSet.getResource(URI.createFileURI(mmURI), true);
				for (EObject obj : resource.getContents()) {
					if (obj instanceof EPackage) {
						resourceSet.getPackageRegistry().put(((EPackage)obj).getNsURI(), ((EPackage)obj).getEFactoryInstance().getEPackage());
						metamodel.add((EPackage)obj);
					}
				}
			}
			else metamodel.add(pck);

			
		}
		catch (Exception e) {
		}
		
		return metamodel;
	}


	public static List<EPackage> loadMetaModel (String uri) throws MetaModelNotFoundException {
		List<EPackage> metamodel = null;
		String mmURI = processURI(uri);
		
		try {
			metamodel = new ArrayList<EPackage>();
			
			File fmm = new File(mmURI);
			if (fmm.exists() == false) {
				String absoluteURI = getAbsoluteMetaModelURI(mmURI);
				if (absoluteURI == null) {
					return null;
				}
				fmm = new File(absoluteURI);
				if (fmm.exists()) {
					mmURI = absoluteURI;
				}
			}
			if (fmm.exists() == false && mmURI.indexOf("/") != -1) {
				String absoluteURI = getMetaModelPath() + "/" + mmURI.substring(mmURI.lastIndexOf("/") + 1, mmURI.length());
				fmm = new File(absoluteURI);
				if (fmm.exists()) {
					mmURI = absoluteURI;
				}
			}
			if (fmm.exists() == false && mmURI.indexOf("/") == -1) {
				String absoluteURI = getMetaModelPath() + "/" + mmURI;
				if (absoluteURI.startsWith("/") && (absoluteURI.indexOf(":") != -1)) {
					absoluteURI = absoluteURI.substring(1, absoluteURI.length());
				}
				fmm = new File(absoluteURI);
				if (fmm.exists()) {
					mmURI = absoluteURI;
				}
			}
			if (fmm.exists() == false) {
				throw new MetaModelNotFoundException(mmURI);
			}
			// check if it is already registered
			EPackage pck = EPackage.Registry.INSTANCE.getEPackage(URI.createFileURI(mmURI).toFileString());
			
			// otherwise
			if (pck == null) {
				EPackage.Registry.INSTANCE.put(URI.createFileURI(mmURI).toFileString(), EPackage.class);
				if (Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().size() == 0)
					Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
				
				ResourceSetImpl resourceSet = new ResourceSetImpl();
				Resource        resource    = resourceSet.getResource(URI.createFileURI(mmURI), true);
				
				for (EObject obj : resource.getContents()) {
					if (obj instanceof EPackage) {
						resourceSet.getPackageRegistry().put(((EPackage)obj).getNsURI(), ((EPackage)obj).getEFactoryInstance().getEPackage());
						metamodel.add((EPackage)obj);
					}
				}
			}
			else metamodel.add(pck);

			
		}
		catch (Exception e) {
			throw new MetaModelNotFoundException(mmURI);
		}
		
		return metamodel;
	}

	public static List<EPackage> loadMetaModels (List<String> uris) throws MetaModelNotFoundException {
		List<EPackage> metamodel = null;
		for (String uri : uris) {
			String mmURI = processURI(uri);
			
			try {
				metamodel = new ArrayList<EPackage>();
				
				File fmm = new File(mmURI);
				if (fmm.exists() == false) {
					String absoluteURI = getAbsoluteMetaModelURI(mmURI);
					if (absoluteURI == null) {
						return null;
					}
					fmm = new File(absoluteURI);
					if (fmm.exists()) {
						mmURI = absoluteURI;
					}
				}
				if (fmm.exists() == false && mmURI.indexOf("/") != -1) {
					String absoluteURI = getMetaModelPath() + "/" + mmURI.substring(mmURI.lastIndexOf("/") + 1, mmURI.length());
					fmm = new File(absoluteURI);
					if (fmm.exists()) {
						mmURI = absoluteURI;
					}
				}
				if (fmm.exists() == false && mmURI.indexOf("/") == -1) {
					String absoluteURI = getMetaModelPath() + "/" + mmURI;
					if (absoluteURI.startsWith("/") && (absoluteURI.indexOf(":") != -1)) {
						absoluteURI = absoluteURI.substring(1, absoluteURI.length());
					}
					fmm = new File(absoluteURI);
					if (fmm.exists()) {
						mmURI = absoluteURI;
					}
				}
				if (fmm.exists() == false) {
					throw new MetaModelNotFoundException(mmURI);
				}
				
				// check if it is already registered
				EPackage pck = EPackage.Registry.INSTANCE.getEPackage(URI.createFileURI(mmURI).toFileString());
				
				// otherwise
				if (pck == null) {
					EPackage.Registry.INSTANCE.put(URI.createFileURI(mmURI).toFileString(), EPackage.class);
					if (Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().size() == 0)
						Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
					
					ResourceSetImpl resourceSet = new ResourceSetImpl();
					Resource        resource    = resourceSet.getResource(URI.createFileURI(mmURI), true);
					
					for (EObject obj : resource.getContents()) {
						if (obj instanceof EPackage) {
							resourceSet.getPackageRegistry().put(((EPackage)obj).getNsURI(), ((EPackage)obj).getEFactoryInstance().getEPackage());
							metamodel.add((EPackage)obj);
						}
					}
				}
				else metamodel.add(pck);

				
			}
			catch (Exception e) {
				throw new MetaModelNotFoundException(mmURI);
			}
		}
		return metamodel;
	}
	
	public static String processURI(String uri, Class<?> cls) {
		String processedURI = uri.replace("\\", "/");
		processedURI = processedURI.startsWith("/") && processedURI.indexOf(":") != -1 ? processedURI.substring(1, processedURI.length()) : processedURI;
		if (FileSystems.getDefault().getPath(processedURI).isAbsolute()) {
			return processedURI;
		}
		if (!processedURI.startsWith("/")) {
			processedURI = "/" + processedURI;
		}
		IProject project = ProjectUtils.getProject();
		if (project != null) {
			if (ProjectUtils.isWodelProject(project))  {
				if (!processedURI.startsWith("/" + project.getName())) {
					if (!project.getName().endsWith("_1.0.0")) {
						processedURI = "/" + project.getName() + processedURI;
					}
				}
				if (project.getName().endsWith("_1.0.0")) {
					String projectName = project.getName().substring(0, project.getName().lastIndexOf("_1.0.0"));
					if (processedURI.startsWith("/" + projectName)) {
						String endURI = processedURI.substring(("/" + projectName).length(), processedURI.length());
						endURI = endURI.substring(endURI.indexOf("/"), endURI.length());
						processedURI = "/" + project.getName() + endURI;
					}
					else {
						processedURI = "/" + project.getName() + processedURI;
					}
				}
			}
		}
		else {
			String projectName = getProjectNameFromWodelTest();
			if (projectName == null || projectName.length() == 0) {
				String path = null;
				path = getWorkspaceAbsolutePathWithProjectName(cls);
				if (path == null) {
					return processedURI;
				}
				path = path.replace("\\", "/");
				projectName = path.substring(path.lastIndexOf("/") + 1, path.length());
			}
			if (projectName != null && projectName.length() > 0) {
				String path = null;
				path = getWorkspaceAbsolutePathWithProjectName(cls);
				if (path == null) {
					return processedURI;
				}
				path = path.replace("\\", "/");
				String projectName2 = path.substring(path.lastIndexOf("/") + 1, path.length());
				if (!processedURI.startsWith("/" + projectName2)) {
					if (!projectName2.endsWith("_1.0.0")) {
						processedURI = "/" + projectName2 + processedURI;
					}
				}
				if (projectName2.endsWith("_1.0.0")) {
					projectName = projectName2.substring(0, projectName2.lastIndexOf("_1.0.0"));
					if (processedURI.startsWith("/" + projectName)) {
						String endURI = processedURI.substring(("/" + projectName).length(), processedURI.length());
						endURI = endURI.substring(endURI.indexOf("/"), endURI.length());
						processedURI = "/" + projectName2 + endURI;
					}
					else {
						processedURI = "/" + projectName2 + processedURI;
					}
				}
			}
		}
		return processedURI;
	}

	
	private static List<String> subProcessURI(String uri, Class<?> cls) {
		String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
		path = path.replace("\\", "/");
		path = path.substring(0, path.lastIndexOf("/"));
		if (path.contains("/bin")) {
			path = path.substring(0, path.lastIndexOf("/bin"));
		}
		String projectName = path.substring(path.lastIndexOf("/") + 1, path.length());
		String subProcessedURI1 = uri.replace("\\", "/");
		if (projectName != null) {
			if (subProcessedURI1.startsWith("/" + projectName)) {
				String str = subProcessedURI1.substring(subProcessedURI1.indexOf("/" + projectName), subProcessedURI1.length());
				str = str.substring(1, str.length());
				str = str.substring(str.indexOf("/"), str.length());
				if (subProcessedURI1.indexOf("_1.0.0/") == -1) {
					subProcessedURI1 = "/" + projectName + str;
				}
				else {
					subProcessedURI1 = "/" + projectName + "_1.0.0" + str;
				}
			}
		}
		String subProcessedURI2 = uri.replace("\\", "/");
		if (projectName != null) {
			if (subProcessedURI2.startsWith("/" + projectName)) {
				if (subProcessedURI2.indexOf("_1.0.0/") == -1) {
					subProcessedURI2 = subProcessedURI2.substring(("/" + projectName).length(), subProcessedURI2.length());
				}
				else {
					subProcessedURI2 = subProcessedURI2.substring(("/" + projectName + "_1.0.0").length(), subProcessedURI2.length());
				}
			}
		}
		List<String> subProcessedURI = new ArrayList<String>();
		subProcessedURI.add(subProcessedURI1);
		subProcessedURI.add(subProcessedURI2);
		return subProcessedURI;
	}

	
	private static String getAbsoluteMetaModelURI(String uri, Class<?> cls) throws MetaModelNotFoundException {
		String path = null;
		String projectName = getProjectNameFromWodelTest();
		if (projectName != null) {
			Class<?> localCls = getClassFromWodelTest();
			path = getWorkspaceAbsolutePath(localCls).replace("\\", "/");
		}
		if (path != null && path.length() > 0) {
			path = path.substring(0, path.lastIndexOf("/"));
			String fullPath = path + uri.replace("\\", "/");
			File fmm = new File(fullPath);
			if (fmm.exists()) {
				return fullPath;
			}
		}
		if (path == null || (path != null && path.length() == 0)) {
			path = Platform.getLocation().toFile().getPath().replace("\\", "/");			
		}
		if (path == null || (path != null && path.length() == 0)) {
			path = getWorkspaceAbsolutePath(cls).replace("\\", "/");
		}
		String fullPath = path + uri.replace("\\", "/");
		File fmm = new File(fullPath);
		if (!fmm.exists()) {
			String pluginName = uri.substring(1, uri.length());
			pluginName = pluginName.substring(0, pluginName.indexOf("/"));
			String processedURI = "/" + pluginName + "_1.0.0" + uri.substring(("/" + pluginName).length(), uri.length());
			fullPath = path + processedURI;
			fmm = new File(fullPath);
			if (!fmm.exists()) {
				List<String> subProcessedURI = subProcessURI(processedURI, cls);
				fullPath = path + subProcessedURI.get(0);
				fmm = new File(fullPath);
				if (!fmm.exists()) {
					fullPath = path + subProcessedURI.get(1);
					fmm = new File(fullPath);
					if (!fmm.exists()) {
						throw new MetaModelNotFoundException(uri);
					}
				}
			}
		}
		return fullPath;
	}

	public static List<EPackage> loadMetaModel (String uri, Class<?> cls) throws MetaModelNotFoundException {
		List<EPackage> metamodel = null;
		String mmURI = processURI(uri, cls);
		try {
			metamodel = new ArrayList<EPackage>();
			
			// check if it is already registered
			File fmm = new File(mmURI);
			if (fmm.exists() == false) {
				String absoluteURI = getAbsoluteMetaModelURI(mmURI, cls);
				if (absoluteURI == null) {
					return null;
				}
				fmm = new File(absoluteURI);
				if (fmm.exists()) {
					mmURI = absoluteURI;
				}
			}
			if (fmm.exists() == false && mmURI.indexOf("/") != -1) {
				String absoluteURI = getMetaModelPath(cls) + "/" + mmURI.substring(mmURI.lastIndexOf("/") + 1, mmURI.length());
				fmm = new File(absoluteURI);
				if (fmm.exists()) {
					mmURI = absoluteURI;
				}
			}
			if (fmm.exists() == false && mmURI.indexOf("/") == -1) {
				String absoluteURI = getMetaModelPath(cls) + "/" + mmURI;
				if (absoluteURI.startsWith("/") && (absoluteURI.indexOf(":") != -1)) {
					absoluteURI = absoluteURI.substring(1, absoluteURI.length());
				}
				fmm = new File(absoluteURI);
				if (fmm.exists()) {
					mmURI = absoluteURI;
				}
			}
			if (fmm.exists() == false) {
				throw new MetaModelNotFoundException(mmURI);
			}
			
			EPackage pck = EPackage.Registry.INSTANCE.getEPackage(URI.createFileURI(mmURI).toFileString());
			
			// otherwise
			if (pck==null) {
				EPackage.Registry.INSTANCE.put(URI.createFileURI(mmURI).toFileString(), EPackage.class);
				if (Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().size() == 0)
					Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
				
				ResourceSetImpl resourceSet = new ResourceSetImpl();
				Resource        resource    = resourceSet.getResource(URI.createFileURI(mmURI), true);
				for (EObject obj : resource.getContents()) {
					if (obj instanceof EPackage) {
						resourceSet.getPackageRegistry().put(((EPackage)obj).getNsURI(), ((EPackage)obj).getEFactoryInstance().getEPackage());
						metamodel.add((EPackage)obj);
					}
				}
			}
			else metamodel.add(pck);

			
		}
		catch (Exception e) {
			throw new MetaModelNotFoundException(mmURI);
		}
		
		return metamodel;
	}

	public static List<EPackage> loadMetaModels (List<String> uris, Class<?> cls) throws MetaModelNotFoundException {
		List<EPackage> metamodel = null;
		for (String uri : uris) {
			String mmURI = processURI(uri, cls);
			try {
				metamodel = new ArrayList<EPackage>();
				
				// check if it is already registered
				File fmm = new File(mmURI);
				if (fmm.exists() == false) {
					String absoluteURI = getAbsoluteMetaModelURI(mmURI, cls);
					if (absoluteURI == null) {
						return null;
					}
					fmm = new File(absoluteURI);
					if (fmm.exists()) {
						mmURI = absoluteURI;
					}
				}
				if (fmm.exists() == false && mmURI.indexOf("/") != -1) {
					String absoluteURI = getMetaModelPath(cls) + "/" + mmURI.substring(mmURI.lastIndexOf("/") + 1, mmURI.length());
					fmm = new File(absoluteURI);
					if (fmm.exists()) {
						mmURI = absoluteURI;
					}
				}
				if (fmm.exists() == false && mmURI.indexOf("/") == -1) {
					String absoluteURI = getMetaModelPath(cls) + "/" + mmURI;
					if (absoluteURI.startsWith("/") && (absoluteURI.indexOf(":") != -1)) {
						absoluteURI = absoluteURI.substring(1, absoluteURI.length());
					}
					fmm = new File(absoluteURI);
					if (fmm.exists()) {
						mmURI = absoluteURI;
					}
				}
				if (fmm.exists() == false) {
					throw new MetaModelNotFoundException(mmURI);
				}
				EPackage pck = EPackage.Registry.INSTANCE.getEPackage(URI.createFileURI(mmURI).toFileString());
				
				// otherwise
				if (pck==null) {
					EPackage.Registry.INSTANCE.put(URI.createFileURI(mmURI).toFileString(), EPackage.class);
					if (Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().size() == 0)
						Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
					
					ResourceSetImpl resourceSet = new ResourceSetImpl();
					Resource        resource    = resourceSet.getResource(URI.createFileURI(mmURI), true);
					for (EObject obj : resource.getContents()) {
						if (obj instanceof EPackage) {
							resourceSet.getPackageRegistry().put(((EPackage)obj).getNsURI(), ((EPackage)obj).getEFactoryInstance().getEPackage());
							metamodel.add((EPackage)obj);
						}
					}
				}
				else metamodel.add(pck);

				
			}
			catch (Exception e) {
				throw new MetaModelNotFoundException(mmURI);
			}
		}
		
		return metamodel;
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
	
	public static void setProjectNameByResource(Resource resource) {
		String projectName = resource.getURI().devicePath();
		if (projectName.startsWith("/resource/")) {
			projectName = projectName.substring("/resource/".length(), projectName.length());
		}
		else {
			projectName = projectName.substring(ModelManager.getWorkspaceAbsolutePath().length() + 1, projectName.length());
		}
		projectName = projectName.substring(0, projectName.indexOf("/"));
		//WodelContext.setProject(projectName);
	}

	public static String getWorkspaceAbsolutePath() {
		String ret = null;
		if (ProjectUtils.getProject() != null) {
			String path = ProjectUtils.getProject() != null ? ProjectUtils.getProject().getLocation().toFile().getPath() : null; 
			if (path != null) {
				URI uri = URI.createFileURI(path);
				ret = uri.toString();
				ret = ret.replaceFirst("file:/", "/");
				if (ret.indexOf(":") != -1) {
					ret = ret.replaceFirst("/", "");
				}
				ret = ret.substring(0, ret.lastIndexOf("/" + ProjectUtils.getProject().getName()));
			}
		}
		if (ret == null || ret.equals("")) {
			IWodelTest test = getTest();
			if (test != null) {
				String path = test.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
				path = path.replace("\\", "/");
				int index = path.lastIndexOf("/bin");
				if (index == -1) {
					index = path.lastIndexOf("/");
				}
				path = path.substring(0, index);
				ret = path;
			}
		}
		if (ret == null || ret.equals("")) {
			String path = Platform.getLocation().toFile().getPath();
			URI uri = URI.createFileURI(path);
			ret = uri.toString();
			ret = ret.replaceFirst("file:/", "/");
			if (ret.indexOf(":") != -1) {
				if (ret.indexOf("/") != -1) {
					ret = ret.substring(1, ret.lastIndexOf("/"));
				}
				else {
					ret = ret.substring(1, ret.length());
				}
			}
		}
		if (ret != null && ret.startsWith("/")) {
			ret = ret.substring(1, ret.length());
		}
		return ret;
	}
	
	public static String getWorkspaceAbsolutePathWithProjectName() {
		String ret = null;
		if (ProjectUtils.getProject() != null) {
			String path = ProjectUtils.getProject() != null ? ProjectUtils.getProject().getLocation().toFile().getPath() : null; 
			if (path != null) {
				URI uri = URI.createFileURI(path);
				ret = uri.toString();
				ret = ret.replaceFirst("file:/", "/");
				if (ret.indexOf(":") != -1) {
					ret = ret.replaceFirst("/", "");
				}
			}
		}
		if (ret == null || ret.equals("")) {
			IWodelTest test = getTest();
			if (test != null) {
				String path = test.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
				path = path.replace("\\", "/");
				int index = path.lastIndexOf("/bin");
				if (index == -1) {
					index = path.lastIndexOf("/");
				}
				path = path.substring(0, index);
				ret = path;
			}
		}
		if (ret == null || ret.equals("")) {
			String path = Platform.getLocation().toFile().getPath();
			URI uri = URI.createFileURI(path);
			ret = uri.toString();
			ret = ret.replaceFirst("file:/", "/");
			if (ret.indexOf(":") != -1) {
				if (ret.indexOf("/") != -1) {
					ret = ret.substring(1, ret.lastIndexOf("/"));
				}
				else {
					ret = ret.substring(1, ret.length());
				}
			}
		}
		return ret;
	}

	public static String getWorkspaceAbsolutePath(Class<?> cls) {
		if (cls == null) {
			return null;
		}
		String ret = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
		ret = ret.replaceAll("\\\\", "/");
		ret = ret.replaceFirst("file:/", "/");
		int index = ret.indexOf("/bin");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("\\bin");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("/src");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("\\src");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("/data/out");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("\\data\\out");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		if (ret.indexOf("/") != -1) {
			ret = ret.substring(0, ret.lastIndexOf("/"));
		}
		if (ret.indexOf("\\") != -1) {
			ret = ret.substring(0, ret.lastIndexOf("\\"));
		}
		if (ret.startsWith("/")) {
			ret = ret.substring(1, ret.length());
		}
		return ret;
	}

	public static String getWorkspaceAbsolutePathWithProjectName(Class<?> cls) {
		if (cls == null) {
			return null;
		}
		String ret = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
		ret = ret.replaceAll("\\\\", "/");
		ret = ret.replaceFirst("file:/", "/");
		int index = ret.indexOf("/bin");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("\\bin");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("/src");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("\\src");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("/data/out");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("\\data\\out");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		if (ret.startsWith("/")) {
			ret = ret.substring(1, ret.length());
		}
		if (ret.endsWith("/")) {
			ret = ret.substring(0, ret.lastIndexOf("/"));
		}
		return ret;
	}

	public static String getWorkspaceAbsolutePath(Resource resource) {
		if (resource == null) {
			return null;
		}
		String ret = resource.getURI().toFileString();
		if (ret == null) {
			ret = Platform.getLocation().toFile().getPath().replace("\\", "/");
			return (ret != null) ? ret : getWorkspaceAbsolutePath();
		}
		ret = ret.replaceAll("\\\\", "/");
		ret = ret.replaceFirst("file:/", "/");
		int index = ret.indexOf("/bin");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("\\bin");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("/src");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("\\src");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("/data/out");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("\\data\\out");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		if (ret.indexOf("/") != -1) {
			ret = ret.substring(0, ret.lastIndexOf("/"));
		}
		if (ret.indexOf("\\") != -1) {
			ret = ret.substring(0, ret.lastIndexOf("\\"));
		}
		if (ret.startsWith("/")) {
			ret = ret.substring(1, ret.length());
		}
		return ret;
	}

	public static String getWorkspaceAbsolutePath(EObject object) {
		if (object == null) {
			return null;
		}
		String ret = EcoreUtil.getURI(object).toFileString();
		if (ret == null) {
			ret = Platform.getLocation().toFile().getPath().replace("\\", "/");
			return (ret != null) ? ret : getWorkspaceAbsolutePath();
		}
		ret = ret.replaceAll("\\\\", "/");
		ret = ret.replaceFirst("file:/", "/");
		int index = ret.indexOf("/bin");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("\\bin");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("/src");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("\\src");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("/data/out");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		index = ret.indexOf("\\data\\out");
		if (index != -1) {
			ret = ret.substring(0, index);
		}
		if (ret.indexOf("/") != -1) {
			ret = ret.substring(0, ret.lastIndexOf("/"));
		}
		if (ret.indexOf("\\") != -1) {
			ret = ret.substring(0, ret.lastIndexOf("\\"));
		}
		if (ret.startsWith("/")) {
			ret = ret.substring(1, ret.length());
		}
		return ret;
	}

	public static URI getModelWithFolder(String model) {
		IPath path = Platform.getLocation().makeAbsolute();

		IProject project = ProjectUtils.getProject();
		URI uri = URI.createFileURI(model);
		if (project != null) {
			// The URI is relative so we have to complete it
			if (uri.hasAbsolutePath() != true) {
				uri = URI.createFileURI(path.toString() + "/"
						+ project.getName() + "/" + model);
			}
		}

		return uri;
	}
	
	public static URI getModelWithFolder(String model, Class<?> cls) {
		if (cls == null) {
			return null;
		}
		String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
		path = path.replace("\\", "/");
		path = path.substring(0, path.lastIndexOf("/"));
		if (path.contains("/bin")) {
			path = path.substring(0, path.lastIndexOf("/bin"));
		}
		String projectName = path.substring(path.lastIndexOf("/") + 1, path.length());
		path = path.substring(0, path.lastIndexOf("/"));
		URI uri = URI.createFileURI(model);
		if (projectName != null) {
			// The URI is relative so we have to complete it
			if (uri.hasAbsolutePath() != true) {
				uri = URI.createFileURI(path + "/"
						+ projectName + "/" + model);
			}
		}

		return uri;
	}

	private static IWodelTest getTest() {
		IWodelTest test = null;
		List<IWodelTest> tests = new ArrayList<IWodelTest>();
		if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							"wodeltest.extension.MutTesting");
			for (int j = 0; j < extensions.length; j++) {
				IWodelTest t = null;
				try {
					t = (IWodelTest) extensions[j]
							.createExecutableExtension("class");
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tests.add(t);
			}
		}
		
		for (IWodelTest t : tests) {
			test = t;
			break;
		}
		return test;
	}


	public static String getMetaModel() {
		try {
			String path = "";
			if (ProjectUtils.getProject() != null) {
				path = ProjectUtils.getProject().getLocation().toFile().getPath();
			}
			else {
				IWodelTest test = getTest();
				if (test != null) {
					path = test.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
					path = path.replaceAll("\\\\", "/");
					int index = path.lastIndexOf("/bin");
					if (index == -1) {
						index = path.lastIndexOf("/");
					}
					path = path.substring(0, index);
				}
			}
			if (path.length() == 0) {
				return "";
			}

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String modelName = br.readLine();
			File[] files = new File(path + '/' + modelName).listFiles();
			for (File file : files) {
				if (file.isFile() == true) {
					String modelpath = file.getPath().replaceAll("\\\\", "/");
					if (modelpath.endsWith(".ecore") == true) {
						br.close();
						return modelpath;
					}
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static List<String> getMetaModels() {
		List<String> modelpaths = new ArrayList<String>();
		try {
			String path = "";
			if (ProjectUtils.getProject() != null) {
				path = ProjectUtils.getProject().getLocation().toFile().getPath();
			}
			else {
				IWodelTest test = getTest();
				if (test != null) {
					path = test.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
					path = path.replaceAll("\\\\", "/");
					int index = path.lastIndexOf("/bin");
					if (index == -1) {
						index = path.lastIndexOf("/");
					}
					path = path.substring(0, index);
				}
			}
			if (path.length() == 0) {
				return modelpaths;
			}

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String modelName = br.readLine();
			File[] files = new File(path + '/' + modelName).listFiles();
			for (File file : files) {
				if (file.isFile() == true) {
					String modelpath = file.getPath().replaceAll("\\\\", "/");
					if (modelpath.endsWith(".ecore") == true) {
						modelpaths.add(modelpath);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelpaths;
	}

	public static List<String> getMetaModel(Class<?> cls) {
		List<String> modelpaths = new ArrayList<String>();
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			path = path.replaceAll("\\\\", "/");
			if (path.contains("/bin")) {
				path = path.substring(0, path.lastIndexOf("/bin"));
			}
			if (path.contains("\\bin")) {
				path = path.substring(0, path.lastIndexOf("\\bin"));
			}
			if (path.contains("/src")) {
				path = path.substring(0, path.lastIndexOf("/src"));
			}
			if (path.contains("\\src")) {
				path = path.substring(0, path.lastIndexOf("\\src"));
			}
			if (path.contains("/data/out")) {
				path = path.substring(0, path.lastIndexOf("/data/out"));
			}
			if (path.contains("\\data\\out")) {
				path = path.substring(0, path.lastIndexOf("\\data\\out"));
			}
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String modelName = br.readLine();
			File[] files = new File(path + '/' + modelName).listFiles();
			for (File file : files) {
				if (file.isFile() == true) {
					String modelpath = file.getPath().replaceAll("\\\\", "/");
					if (modelpath.endsWith(".ecore") == true) {
						modelpaths.add(modelpath);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelpaths;
	}

	public static String getMetaModel(EObject object) {
		try {
			String path = EcoreUtil.getURI(object).toFileString();
			if (path == null) {
				if (ProjectUtils.getProject() != null) {
					path = ProjectUtils.getProject().getLocation().toFile().getPath();
				}
			}
			path = path.replaceAll("\\\\", "/");
			if (path.contains("/bin")) {
				path = path.substring(0, path.lastIndexOf("/bin"));
			}
			if (path.contains("\\bin")) {
				path = path.substring(0, path.lastIndexOf("\\bin"));
			}
			if (path.contains("/src")) {
				path = path.substring(0, path.lastIndexOf("/src"));
			}
			if (path.contains("\\src")) {
				path = path.substring(0, path.lastIndexOf("\\src"));
			}
			if (path.contains("/data/out")) {
				path = path.substring(0, path.lastIndexOf("/data/out"));
			}
			if (path.contains("\\data\\out")) {
				path = path.substring(0, path.lastIndexOf("\\data\\out"));
			}
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));
			String modelName = br.readLine();
			File[] files = new File(path + '/' + modelName).listFiles();
			for (File file : files) {
				if (file.isFile() == true) {
					String modelpath = file.getPath().replaceAll("\\\\", "/");
					if (modelpath.endsWith(".ecore") == true) {
						br.close();
						return modelpath;
					}
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getMetaModelPath() {
		try {
			String path = "";
			if (ProjectUtils.getProject() != null) {
				path = ProjectUtils.getProject().getLocation().toFile().getPath();
			}
			if (path.length() == 0) {
				return "";
			}
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = path + '/' + br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getMetaModelPath(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			path = path.substring(0, path.lastIndexOf("/")).replaceAll("\\\\", "/");
			if (path.contains("/bin")) {
				path = path.substring(0, path.lastIndexOf("/bin"));
			}

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = path + '/' + br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getDifferentRatioPath(String mutatorName) {
		String path = "";
		if (ProjectUtils.getProject() != null) {
			path = ProjectUtils.getProject().getLocation().toFile().getPath();
		}
		if (path.length() == 0) {
			return "";
		}
		String ret = path.replaceAll("\\\\", "/") + "/data/config/" + mutatorName + ".different.txt";
		return ret;
	}

	public static String getDifferentRatioPath(String mutatorName, IProject project) {
		String path = "";
		if (project != null) {
			path = project.getLocation().toFile().getPath();
		}
		if (path.length() == 0) {
			return "";
		}
		String ret = path + "/data/" + mutatorName + ".different.txt";
		return ret;
	}
	
	public static String getGeneratedMutantsPath(String mutatorName) {
		String path = "";
		if (ProjectUtils.getProject() != null) {
			path = ProjectUtils.getProject().getLocation().toFile().getPath();
		}
		if (path.length() == 0) {
			return "";
		}
		String ret = path.replaceAll("\\\\", "/") + "/data/config/" + mutatorName + ".generated.txt";
		return ret;
	}
	
	public static String getGeneratedMutantsPath(String mutatorName, IProject project) {
		String path = "";
		if (project != null) {
			path = project.getLocation().toFile().getPath();
		}
		if (path.length() == 0) {
			return "";
		}
		String ret = path + "/data/" + mutatorName + ".generated.txt";
		return ret;
	}

	public static String getMetaModelPath(String project) {
		try {
			String path = getWorkspaceAbsolutePath() + '/' + project;

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = path + '/' + br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static Set<String> getExtensions() {
		Set<String> extensions = new HashSet<String>();
		try {
			String path = "";
			if (ProjectUtils.getProject() != null) {
				path = ProjectUtils.getProject().getLocation().toFile().getPath();
			}
			if (path.length() == 0) {
				return extensions;
			}
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			br.readLine();
			String ext = null;
			while ((ext = br.readLine()) != null) {
				extensions.add(ext);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return extensions;
	}
	
	public static Set<String> getExtensions(Class<?> cls) {
		Set<String> extensions = new HashSet<String>();
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			br.readLine();
			String ext = null;
			while ((ext = br.readLine()) != null) {
				extensions.add(ext);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return extensions;
	}

	public static List<String> getModels() {
		List<String> modelpaths = null;
		try {
			String path = "";
			if (ProjectUtils.getProject() != null) {
				path = ProjectUtils.getProject().getLocation().toFile().getPath();
			}
			if (path.length() == 0) {
				return modelpaths;
			}
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

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
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelpaths;
	}
	
	private static List<String> getMutantsFromFolder(File folder) {
		List<String> mutantpaths = new ArrayList<String>();
		if (folder != null && folder.listFiles() != null && !folder.getName().equals("registry") && !(folder.getName().startsWith("Output") && folder.getName().endsWith("vs"))) {
			for (File file : folder.listFiles()) {
				if (file.isFile() == true) {
					String modelpath = file.getPath();
					if (modelpath.endsWith(".model") == true) {
						mutantpaths.add(modelpath);
					}
				}
				else if (file.isDirectory() == true) {
					mutantpaths.addAll(getMutantsFromFolder(file));
				}
			}
		}
		return mutantpaths;
	}

	public static List<String> getMutants() {
		List<String> mutantpaths = null;
		try {
			String path = "";
			if (ProjectUtils.getProject() != null) {
				path = ProjectUtils.getProject().getLocation().toFile().getPath();
			}
			if (path.length() == 0) {
				return mutantpaths;
			}
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			String mutantName = br.readLine();
			File[] files = new File(path + '/' + mutantName).listFiles();
			mutantpaths = new ArrayList<String>();
			for (File file : files) {
				if (file.isFile() == true) {
					String modelpath = file.getPath();
					if (modelpath.endsWith(".model") == true) {
						mutantpaths.add(modelpath);
					}
				}
				else if (file.isDirectory() == true) {
					mutantpaths.addAll(getMutantsFromFolder(file));
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mutantpaths;
	}

	public static List<String> getModels(Class<?> cls) {
		List<String> modelpaths = null;
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);
			
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

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
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelpaths;
	}

	public static List<String> getMutants(Class<?> cls) {
		List<String> mutantpaths = null;
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);
			
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			String mutantName = br.readLine();
			File[] files = new File(path + '/' + mutantName).listFiles();
			mutantpaths = new ArrayList<String>();
			for (File file : files) {
				if (file.isFile() == true) {
					String modelpath = file.getPath();
					if (modelpath.endsWith(".model") == true) {
						mutantpaths.add(modelpath);
					}
				}
				else if (file.isDirectory() == true) {
					mutantpaths.addAll(getMutantsFromFolder(file));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mutantpaths;
	}

	public static String getModelsFolder() {
		try {
			String path = "";
			if (ProjectUtils.getProject() != null) {
				path = ProjectUtils.getProject().getLocation().toFile().getPath();
			}
			if (path.length() == 0) {
				path = ModelManager.getWorkspaceAbsolutePath();
			}
			if (path.length() == 0) {
				return "";
			}
			path = path.replaceAll("\\\\", "/");
			
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = path
				+ '/' + br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getModelsFolder(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			path = path.replaceAll("\\\\", "/");
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);
			index = path.lastIndexOf("/src-gen");
			if (index != -1) {
				path = path.substring(0, index);
			}
			index = path.lastIndexOf("\\src-gen");
			if (index != -1) {
				path = path.substring(0, index);
			}
			index = path.lastIndexOf("/src");
			if (index != -1) {
				path = path.substring(0, index);
			}
			index = path.lastIndexOf("\\src");
			if (index != -1) {
				path = path.substring(0, index);
			}

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = path
				+ '/' + br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getModelsFolder(EObject object) {
		try {
			String path = EcoreUtil.getURI(object).toFileString();
			if (path == null) {
				if (ProjectUtils.getProject() != null) {
					path = ProjectUtils.getProject().getLocation().toFile().getPath();
				}
				if (path.length() == 0) {
					return "";
				}
			}
			path = path.replaceAll("\\\\", "/");
			if (path.contains("/bin")) {
				path = path.substring(0, path.lastIndexOf("/bin"));
			}
			if (path.contains("\\bin")) {
				path = path.substring(0, path.lastIndexOf("\\bin"));
			}
			if (path.contains("/src")) {
				path = path.substring(0, path.lastIndexOf("/src"));
			}
			if (path.contains("\\src")) {
				path = path.substring(0, path.lastIndexOf("\\src"));
			}
			if (path.contains("/data/out")) {
				path = path.substring(0, path.lastIndexOf("/data/out"));
			}
			if (path.contains("\\data\\out")) {
				path = path.substring(0, path.lastIndexOf("\\data\\out"));
			}
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = path
				+ '/' + br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getMutatorEnvironmentBundle() {
		try {
			String path = "";
			if (ProjectUtils.getProject() != null) {
				path = ProjectUtils.getProject().getLocation().toFile().getPath();
			}
			if (path.length() == 0) {
				return "";
			}

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/mutatorEnvironment.bundle"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getMutatorEnvironmentBundle(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			path = path.replaceAll("\\\\", "/");
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);
			index = path.lastIndexOf("/src-gen");
			if (index != -1) {
				path = path.substring(0, index);
			}
			index = path.lastIndexOf("\\src-gen");
			if (index != -1) {
				path = path.substring(0, index);
			}
			index = path.lastIndexOf("/src");
			if (index != -1) {
				path = path.substring(0, index);
			}
			index = path.lastIndexOf("\\src");
			if (index != -1) {
				path = path.substring(0, index);
			}

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/mutatorEnvironment.bundle"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getMutatorEnvironmentBundle(EObject object) {
		try {
			String path = EcoreUtil.getURI(object).toFileString();
			if (path == null) {
				if (ProjectUtils.getProject() != null) {
					path = ProjectUtils.getProject().getLocation().toFile().getPath();
				}
				if (path.length() == 0) {
					return "";
				}
			}
			path = path.replaceAll("\\\\", "/");
			if (path.contains("/bin")) {
				path = path.substring(0, path.lastIndexOf("/bin"));
			}
			if (path.contains("\\bin")) {
				path = path.substring(0, path.lastIndexOf("\\bin"));
			}
			if (path.contains("/src")) {
				path = path.substring(0, path.lastIndexOf("/src"));
			}
			if (path.contains("\\src")) {
				path = path.substring(0, path.lastIndexOf("\\src"));
			}
			if (path.contains("/data/out")) {
				path = path.substring(0, path.lastIndexOf("/data/out"));
			}
			if (path.contains("\\data\\out")) {
				path = path.substring(0, path.lastIndexOf("\\data\\out"));
			}
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/mutatorEnvironment.bundle"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getMutatorEnvironmentBundle(Resource resource) {
		try {
			String path = resource.getURI().toFileString();
			if (path == null) {
				if (ProjectUtils.getProject() != null) {
					path = ProjectUtils.getProject().getLocation().toFile().getPath();
				}
				if (path.length() == 0) {
					return "";
				}
			}
			path = path.replaceAll("\\\\", "/");
			if (path.contains("/bin")) {
				path = path.substring(0, path.lastIndexOf("/bin"));
			}
			if (path.contains("\\bin")) {
				path = path.substring(0, path.lastIndexOf("\\bin"));
			}
			if (path.contains("/src")) {
				path = path.substring(0, path.lastIndexOf("/src"));
			}
			if (path.contains("\\src")) {
				path = path.substring(0, path.lastIndexOf("\\src"));
			}
			if (path.contains("/data/out")) {
				path = path.substring(0, path.lastIndexOf("/data/out"));
			}
			if (path.contains("\\data\\out")) {
				path = path.substring(0, path.lastIndexOf("\\data\\out"));
			}
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/mutatorEnvironment.bundle"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getMetricsEnvironmentBundle() {
		try {
			String path = "";
			if (ProjectUtils.getProject() != null) {
				path = ProjectUtils.getProject().getLocation().toFile().getPath();
			}
			if (path.length() == 0) {
				return "";
			}

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/metricsEnvironment.bundle"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getMetricsEnvironmentBundle(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			path = path.replaceAll("\\\\", "/");
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);
			index = path.lastIndexOf("/src-gen");
			if (index != -1) {
				path = path.substring(0, index);
			}
			index = path.lastIndexOf("\\src-gen");
			if (index != -1) {
				path = path.substring(0, index);
			}
			index = path.lastIndexOf("/src");
			if (index != -1) {
				path = path.substring(0, index);
			}
			index = path.lastIndexOf("\\src");
			if (index != -1) {
				path = path.substring(0, index);
			}

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/metricsEnvironment.bundle"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getMetricsEnvironmentBundle(EObject object) {
		try {
			String path = EcoreUtil.getURI(object).toFileString();
			if (path == null) {
				if (ProjectUtils.getProject() != null) {
					path = ProjectUtils.getProject().getLocation().toFile().getPath();
				}
				if (path.length() == 0) {
					return "";
				}
			}
			path = path.replaceAll("\\\\", "/");
			if (path.contains("/bin")) {
				path = path.substring(0, path.lastIndexOf("/bin"));
			}
			if (path.contains("\\bin")) {
				path = path.substring(0, path.lastIndexOf("\\bin"));
			}
			if (path.contains("/src")) {
				path = path.substring(0, path.lastIndexOf("/src"));
			}
			if (path.contains("\\src")) {
				path = path.substring(0, path.lastIndexOf("\\src"));
			}
			if (path.contains("/data/out")) {
				path = path.substring(0, path.lastIndexOf("/data/out"));
			}
			if (path.contains("\\data\\out")) {
				path = path.substring(0, path.lastIndexOf("\\data\\out"));
			}
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/metricsEnvironment.bundle"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getMetricsEnvironmentBundle(Resource resource) {
		try {
			String path = resource.getURI().toFileString();
			if (path == null) {
				if (ProjectUtils.getProject() != null) {
					path = ProjectUtils.getProject().getLocation().toFile().getPath();
				}
				if (path.length() == 0) {
					return "";
				}
			}
			path = path.replaceAll("\\\\", "/");
			if (path.contains("/bin")) {
				path = path.substring(0, path.lastIndexOf("/bin"));
			}
			if (path.contains("\\bin")) {
				path = path.substring(0, path.lastIndexOf("\\bin"));
			}
			if (path.contains("/src")) {
				path = path.substring(0, path.lastIndexOf("/src"));
			}
			if (path.contains("\\src")) {
				path = path.substring(0, path.lastIndexOf("\\src"));
			}
			if (path.contains("/data/out")) {
				path = path.substring(0, path.lastIndexOf("/data/out"));
			}
			if (path.contains("\\data\\out")) {
				path = path.substring(0, path.lastIndexOf("\\data\\out"));
			}
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/metricsEnvironment.bundle"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static void saveMetricsEnvironmentBundle(Resource resource, String bundle) {
		try {
			String path = resource.getURI().toFileString();
			if (path == null) {
				if (ProjectUtils.getProject() != null) {
					path = ProjectUtils.getProject().getLocation().toFile().getPath();
				}
				if (path.length() == 0) {
					return;
				}
			}
			path = path.replaceAll("\\\\", "/");
			if (path.contains("/bin")) {
				path = path.substring(0, path.lastIndexOf("/bin"));
			}
			if (path.contains("\\bin")) {
				path = path.substring(0, path.lastIndexOf("\\bin"));
			}
			if (path.contains("/src")) {
				path = path.substring(0, path.lastIndexOf("/src"));
			}
			if (path.contains("\\src")) {
				path = path.substring(0, path.lastIndexOf("\\src"));
			}
			if (path.contains("/data/out")) {
				path = path.substring(0, path.lastIndexOf("/data/out"));
			}
			if (path.contains("\\data\\out")) {
				path = path.substring(0, path.lastIndexOf("\\data\\out"));
			}
			PrintWriter pw = new PrintWriter(path + "/data/config/metricsEnvironment.bundle");
			pw.write(bundle + "\n");
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void saveMutatorEnvironmentBundle(Resource resource, String bundle) {
		try {
			String path = resource.getURI().toFileString();
			if (path == null) {
				if (ProjectUtils.getProject() != null) {
					path = ProjectUtils.getProject().getLocation().toFile().getPath();
				}
				if (path.length() == 0) {
					return;
				}
			}
			path = path.replaceAll("\\\\", "/");
			if (path.contains("/bin")) {
				path = path.substring(0, path.lastIndexOf("/bin"));
			}
			if (path.contains("\\bin")) {
				path = path.substring(0, path.lastIndexOf("\\bin"));
			}
			if (path.contains("/src")) {
				path = path.substring(0, path.lastIndexOf("/src"));
			}
			if (path.contains("\\src")) {
				path = path.substring(0, path.lastIndexOf("\\src"));
			}
			if (path.contains("/data/out")) {
				path = path.substring(0, path.lastIndexOf("/data/out"));
			}
			if (path.contains("\\data\\out")) {
				path = path.substring(0, path.lastIndexOf("\\data\\out"));
			}
			PrintWriter pw = new PrintWriter(path + "/data/config/mutatorEnvironment.bundle");
			pw.write(bundle + "\n");
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static List<Resource> recGetModels(List<EPackage> packages, File modelsFolder) {
		List<Resource> resources = new ArrayList<Resource>();
		File[] modelFiles = modelsFolder.listFiles();
		try {
			for (File modelFile : modelFiles) {
				if (modelFile.exists()) {
					if (modelFile.isDirectory()) {
						resources.addAll(recGetModels(packages, modelFile));
					}
					if (modelFile.isFile() && modelFile.getName().endsWith(".model")) {
						Resource model = ModelManager.loadModel(packages, modelFile.getPath().replace("\\", "/"));
						resources.add(model);
					}
				}
			}
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resources;
	}
	
	public static String getModelsPath(String metamodel, Resource model) {
		List<EObject> programs = ModelManager.getObjectsOfType("Program", model);
		for (EObject p : programs) {
			try {
				Object ob = ModelManager.getReferenced("source", p);
				if (ob instanceof EObject) {
					EObject source = (EObject) ob;
					return ModelManager.getStringAttribute("path", source);
				}
			} catch (ReferenceNonExistingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}

	public static List<Resource> getModels(String metamodel, Resource wodel) {
		IProject project = ProjectUtils.getProject();
		String models = Platform.getLocation().toFile().getPath().replace("\\", "/") + "/" + project.getName() + "/" + ModelManager.getModelsPath(metamodel, wodel);
		File[] modelFiles = new File(models).listFiles();
		List<Resource> resources = null;
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			resources = new ArrayList<Resource>();
			if (modelFiles != null) {
				for (File modelFile : modelFiles) {
					if (modelFile.exists()) {
						if (modelFile.isDirectory()) {
							resources.addAll(recGetModels(packages, modelFile));
						}
						if (modelFile.isFile() && modelFile.getName().endsWith(".model")) {
							Resource model = ModelManager.loadModel(packages, modelFile.getPath().replace("\\", "/"));
							resources.add(model);
						}
					}
				}
			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resources;
	}

	private static List<Resource> recGetModelsNoException(List<EPackage> packages, File modelsFolder) {
		List<Resource> resources = new ArrayList<Resource>();
		File[] modelFiles = modelsFolder.listFiles();
		for (File modelFile : modelFiles) {
			if (modelFile.exists()) {
				if (modelFile.isDirectory()) {
					resources.addAll(recGetModelsNoException(packages, modelFile));
				}
				if (modelFile.isFile() && modelFile.getName().endsWith(".model")) {
					Resource model = ModelManager.loadModelNoException(packages, modelFile.getPath().replace("\\", "/"));
					resources.add(model);
				}
			}
		}
		return resources;
	}

	public static List<Resource> getModelsNoException(String metamodel, String path) {
		String models = path;
		File[] modelFiles = new File(models).listFiles();
		List<Resource> resources = null;
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			resources = new ArrayList<Resource>();
			if (modelFiles != null) {
				for (File modelFile : modelFiles) {
					if (modelFile.exists()) {
						if (modelFile.isDirectory()) {
							resources.addAll(recGetModelsNoException(packages, modelFile));
						}
						if (modelFile.isFile() && modelFile.getName().endsWith(".model")) {
							Resource model = ModelManager.loadModelNoException(packages, modelFile.getPath().replace("\\", "/"));
							resources.add(model);
						}
					}
				}
			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resources;
	}

	public static String getOutputPath() {
		try {
			String path = "";
			if (ProjectUtils.getProject() != null) {
				path = ProjectUtils.getProject().getLocation().toFile().getPath();
			}
			if (path.length() == 0) {
				path = ModelManager.getWorkspaceAbsolutePath();
			}
			if (path.length() == 0) {
				return "";
			}

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			String mutatorName = br.readLine();
			br.close();
			return path + "/" + mutatorName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getOutputPath(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			path = path.replaceAll("\\\\", "/");
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			String mutantName = br.readLine();
			br.close();
			return path	+ '/' + mutantName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getOutputFolder() {
		try {
			String path = "";
			if (ProjectUtils.getProject() != null) {
				path = ProjectUtils.getProject().getLocation().toFile().getPath();
			}
			if (path.length() == 0) {
				path = ModelManager.getWorkspaceAbsolutePath();
			}
			if (path.length() == 0) {
				return "";
			}

			path = path.replaceAll("\\\\", "/");
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getOutputFolder(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			path = path.replaceAll("\\\\", "/");
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getOutputFolder(EObject object) {
		try {
			String path = EcoreUtil.getURI(object).toFileString();
			if (path == null) {
				if (ProjectUtils.getProject() != null) {
					path = ProjectUtils.getProject().getLocation().toFile().getPath();
				}
				if (path.length() == 0) {
					return "";
				}
			}
			path = path.replaceAll("\\\\", "/");
			if (path.contains("/bin")) {
				path = path.substring(0, path.lastIndexOf("/bin"));
			}
			if (path.contains("\\bin")) {
				path = path.substring(0, path.lastIndexOf("\\bin"));
			}
			if (path.contains("/data/out")) {
				path = path.substring(0, path.lastIndexOf("/data/out"));
			}
			if (path.contains("\\data\\out")) {
				path = path.substring(0, path.lastIndexOf("\\data\\out"));
			}
			if (path.contains("/src")) {
				path = path.substring(0, path.lastIndexOf("/src"));
			}
			if (path.contains("\\src")) {
				path = path.substring(0, path.lastIndexOf("\\src"));
			}
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public static String getMutatorName(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			br.readLine();
			String mutantName = br.readLine();
			br.close();
			return mutantName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getMutatorName() {
		try {
			String path = "";
			if (ProjectUtils.getProject() != null) {
				path = ProjectUtils.getProject().getLocation().toFile().getPath();
			}
			if (path.length() == 0) {
				return "";
			}

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			br.readLine();
			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getModelName() {
		try {
			String path = "";
			if (ProjectUtils.getProject() != null) {
				path = ProjectUtils.getProject().getLocation().toFile().getPath();
			}
			if (path.length() == 0) {
				return "";
			}

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getModelName(String project) {
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ project;

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getModelName(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	private static String getAbsoluteModelURI(String uri) {
		IProject project = ProjectUtils.getProject();
		String path = "";
		if (project == null) {
			String projectName = getProjectNameFromWodelTest();
			Class<?> cls = getClassFromWodelTest();
			if (projectName != null) {
				path = getWorkspaceAbsolutePath(cls).replace("\\", "/") + "/" + projectName;
			}
			else {
				path = Platform.getLocation().toFile().getPath().replace("\\", "/");
				path = (path != null) ? path : getWorkspaceAbsolutePath().replace("\\", "/");
			}
		}
		else {
			path = project.getLocation().toFile().getPath().replace("\\", "/");
		}
		String fullPath = path + uri.replace("\\", "/");
		File fmm = new File(fullPath);
		if (!fmm.exists()) {
			List<String> subProcessedURI = subProcessURI(uri);
			fullPath = path + subProcessedURI.get(0);
			fmm = new File(fullPath);
			if (!fmm.exists()) {
				fullPath = path + subProcessedURI.get(1);
				fmm = new File(fullPath);
				if (!fmm.exists()) {
					return null;
				}
			}
		}
		return fullPath;
	}

	private static String getAbsoluteModelURI(String uri, Class<?> cls) {
		String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
		path = path.replace("\\", "/");
		path = path.substring(0, path.lastIndexOf("/"));
		if (path.contains("/bin")) {
			path = path.substring(0, path.lastIndexOf("/bin"));
		}
		path = path.substring(0, path.lastIndexOf("/"));
		String fullPath = path + uri.replace("\\", "/");
		File fmm = new File(fullPath);
		if (!fmm.exists()) {
			String pluginName = uri.substring(1, uri.length());
			pluginName = pluginName.substring(0, pluginName.indexOf("/"));
			String processedURI = "/" + pluginName + "_1.0.0" + uri.substring(("/" + pluginName).length(), uri.length());
			fullPath = path + processedURI;
			fmm = new File(fullPath);
			if (!fmm.exists()) {
				List<String> subProcessedURI = subProcessURI(processedURI, cls);
				fullPath = path + subProcessedURI.get(0);
				fmm = new File(fullPath);
				if (!fmm.exists()) {
					fullPath = path + subProcessedURI.get(1);
					fmm = new File(fullPath);
					if (!fmm.exists()) {
						throw null;
					}
				}
			}
		}
		return fullPath;
	}

	public static ResourceSet initializeResource(String modelURI) {
		ResourceSet resourceSet = new ResourceSetImpl();

		int i = modelURI.lastIndexOf('.');
		if (i > 0) {
			String ext = modelURI.substring(i + 1);
			if (!resourceSet.getResourceFactoryRegistry()
					.getExtensionToFactoryMap().containsKey(ext)) {
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
	public static Resource loadModelWithoutOptions(List<EPackage> packages,
			String strURI) throws ModelNotFoundException {
		String modelURI = processURI(strURI);
		File fm = new File(modelURI);
		if (fm.exists() == false) {
			modelURI = getAbsoluteModelURI(modelURI);
			if (modelURI == null) {
				return null;
			}
			fm = new File(modelURI);
			if (fm.exists() == false) {
				throw new ModelNotFoundException(strURI);
			}
		}
		ResourceSet resourceSet = ModelManager.initializeResource(modelURI);
		URI uri = ModelManager.getModelWithFolder(modelURI);
		for (EPackage p : packages) {
			// Add packages to package registry
			if (!resourceSet.getPackageRegistry().containsKey(p.getNsURI()))
				resourceSet.getPackageRegistry().put(p.getNsURI(), p);
			// nested packages
			for (EPackage sp : p.getESubpackages()) {
				if (!resourceSet.getPackageRegistry().containsKey(sp.getNsURI()))
					resourceSet.getPackageRegistry().put(sp.getNsURI(), sp);
			}
		}
		Resource model = null;
		try {
			model = resourceSet.createResource(uri);
			model.load(null);
			// model = resourceSet.getResource(URI.createURI(modelURI),true); //
			// load model using the URI
		} catch (IOException r) {
			r.printStackTrace();
			throw new ModelNotFoundException(strURI);
		}

		return model;
	}

	/**
	 * @param packages
	 *            MetaModel
	 * @param modelURI
	 *            URI of the Model
	 * @return Resource Loaded Model
	 * @throws
	 */
	public static Resource loadModel(List<EPackage> packages,
			String strURI) throws ModelNotFoundException {
		
		String modelURI = processURI(strURI);
		File fm = new File(modelURI);
		if (!fm.exists() && fm.isAbsolute()) {
			return null;
		}
		if (fm.exists() == false) {
			modelURI = getAbsoluteModelURI(modelURI);
			if (modelURI == null) {
				return null;
			}
			fm = new File(modelURI);
			if (fm.exists() == false) {
				throw new ModelNotFoundException(strURI);
			}
		}
		ResourceSet resourceSet = ModelManager.initializeResource(modelURI);
		URI uri = ModelManager.getModelWithFolder(modelURI);
		for (EPackage p : packages) {
			// Add packages to package registry
			if (!resourceSet.getPackageRegistry().containsKey(p.getNsURI()))
				resourceSet.getPackageRegistry().put(p.getNsURI(), p);
			// nested packages
			for (EPackage sp : p.getESubpackages()) {
				if (!resourceSet.getPackageRegistry().containsKey(sp.getNsURI()))
					resourceSet.getPackageRegistry().put(sp.getNsURI(), sp);
			}
		}
		final Map<Object, Object> options = resourceSet.getLoadOptions();
		options.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
		options.put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.FALSE);
		options.put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, new LinkedHashMap<Object, Object>());
		options.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
		options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		Resource model = null;
		try {
			model = resourceSet.createResource(uri);
			model.load(options);
			// model = resourceSet.getResource(URI.createURI(modelURI),true); //
			// load model using the URI
		} catch (Resource.IOWrappedException e) {
		} catch (IOException r) {
			r.printStackTrace();
			throw new ModelNotFoundException(strURI);
		}

		return model;
	}
	
	/**
	 * @param packages
	 *            MetaModel
	 * @param modelURI
	 *            URI of the Model
	 * @return Resource Loaded Model
	 * @throws
	 */
	public static Resource loadModel(List<EPackage> packages,
			String strURI, Class<?> cls) throws ModelNotFoundException {
		
		String modelURI = processURI(strURI);
		File fm = new File(modelURI);
		if (!fm.exists() && fm.isAbsolute()) {
			return null;
		}

		if (fm.exists() == false) {
			modelURI = getAbsoluteModelURI(modelURI, cls);
			if (modelURI == null) {
				return null;
			}
			fm = new File(modelURI);
			if (fm.exists() == false) {
				throw new ModelNotFoundException(strURI);
			}
		}
		ResourceSet resourceSet = ModelManager.initializeResource(modelURI);
		URI uri = ModelManager.getModelWithFolder(modelURI, cls);
		for (EPackage p : packages) {
			// Add packages to package registry
			if (!resourceSet.getPackageRegistry().containsKey(p.getNsURI()))
				resourceSet.getPackageRegistry().put(p.getNsURI(), p);
			// nested packages
			for (EPackage sp : p.getESubpackages()) {
				if (!resourceSet.getPackageRegistry().containsKey(sp.getNsURI()))
					resourceSet.getPackageRegistry().put(sp.getNsURI(), sp);
			}
		}
		final Map<Object, Object> options = resourceSet.getLoadOptions();
		options.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
		options.put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.FALSE);
		options.put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, new HashMap<Object, Object>());
		options.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
		options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		Resource model = null;
		try {
			model = resourceSet.createResource(uri);
			model.load(options);
			// model = resourceSet.getResource(URI.createURI(modelURI),true); //
			// load model using the URI
		} catch (Resource.IOWrappedException e) {
		} catch (IOException r) {
			r.printStackTrace();
			throw new ModelNotFoundException(strURI);
		}

		return model;
	}

	
	/**
	 * @param packages
	 *            MetaModel
	 * @param modelURI
	 *            URI of the Model
	 * @return Resource Loaded Model
	 * @throws
	 */
	public static Resource loadModelNoException(List<EPackage> packages,
			String strURI) {
		String modelURI = processURI(strURI);
		File fm = new File(modelURI);
		if (!fm.exists() && fm.isAbsolute()) {
			return null;
		}

		if (fm.exists() == false) {
			modelURI = getAbsoluteModelURI(modelURI);
			if (modelURI == null) {
				return null;
			}
			fm = new File(modelURI);
			if (fm.exists() == false) {
				return null;
			}
		}
		ResourceSet resourceSet = ModelManager.initializeResource(modelURI);
 		URI uri = URI.createFileURI(modelURI);
 		
		for (EPackage p : packages) {
			// Add packages to package registry
			if (!resourceSet.getPackageRegistry().containsKey(p.getNsURI()))
				resourceSet.getPackageRegistry().put(p.getNsURI(), p);
			// nested packages
			for (EPackage sp : p.getESubpackages()) {
				if (!resourceSet.getPackageRegistry().containsKey(sp.getNsURI()))
					resourceSet.getPackageRegistry().put(sp.getNsURI(), sp);
			}
		}
		final Map<Object, Object> options = resourceSet.getLoadOptions();
		options.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
		options.put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.FALSE);
		options.put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, new HashMap<Object, Object>());
		options.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
		options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		Resource model = null;
		try {
			model = resourceSet.createResource(uri);
			model.load(options);
			// model = resourceSet.getResource(URI.createURI(modelURI),true); //
			// load model using the URI
		} catch (Resource.IOWrappedException e) {
		} catch (IOException r) {
			r.printStackTrace();
		}

		return model;
	}

	
	/**
	 * @param packages
	 *            MetaModel
	 * @param modelURI
	 *            URI of the Model
	 * @return Resource Loaded Model
	 * @throws
	 */
	public static List<Resource> loadModels(List<EPackage> packages,
			String path) throws ModelNotFoundException {
		List<Resource> models = new ArrayList<Resource>();
		File filePath = new File(path);
		for (File file : filePath.listFiles()) {
			if (file.getName().endsWith(".model")) {
				String modelURI = file.getPath();
				Resource model = loadModel(packages, modelURI);
				models.add(model);
			}
		}
		return models;
	}

	/**
	 * @param packages
	 *            MetaModel
	 * @param modelURI
	 *            URI of the Model
	 * @return Resource Loaded Model
	 * @throws
	 */
	public static Resource loadMetaModelAsResource(List<EPackage> packages,
			String strURI) throws ModelNotFoundException {

		String modelURI = processURI(strURI);
		File fm = new File(modelURI);
		if (fm.exists() == false) {
			modelURI = getAbsoluteModelURI(modelURI);
			if (modelURI == null) {
				return null;
			}
			fm = new File(modelURI);
			if (fm.exists() == false) {
				throw new ModelNotFoundException(strURI);
			}
		}

		ResourceSet resourceSet = ModelManager.initializeResource(modelURI);
		URI uri = ModelManager.getModelWithFolder(modelURI);
		for (EPackage p : packages) {
			// Add packages to package registry
			if (!resourceSet.getPackageRegistry().containsKey(p.getNsURI()))
				resourceSet.getPackageRegistry().put(p.getNsURI(), p);
			for (EPackage sp : p.getESubpackages()) {
				if (!resourceSet.getPackageRegistry().containsKey(sp.getNsURI()))
					resourceSet.getPackageRegistry().put(sp.getNsURI(), sp);
			}
		}
		final Map<Object, Object> options = resourceSet.getLoadOptions();
		options.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
		options.put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.FALSE);
		options.put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, new HashMap<Object, Object>());
		options.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
		options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		Resource model = null;
		try {
			model = resourceSet.createResource(uri);
			model.load(options);
			// model = resourceSet.getResource(URI.createURI(modelURI),true); //
			// load model using the URI
		} catch (Resource.IOWrappedException e) {
		} catch (IOException r) {
			throw new ModelNotFoundException(strURI);
		}

		return model;
	}
	
	private static String getAbsoluteMetaModelURINoException(String uri) {
		IProject project = ProjectUtils.getProject();
		String path = "";
		if (project == null) {
			String projectName = getProjectNameFromWodelTest();
			Class<?> cls = getClassFromWodelTest();
			if (projectName != null) {
				path = getWorkspaceAbsolutePath(cls).replace("\\", "/") + "/" + projectName;
			}
		}
		else {
			path = project.getLocation().toFile().getPath();
		}
		path = path.replace("\\", "/");
		path = path.substring(0, path.lastIndexOf("/"));
		String fullPath = path + uri.replace("\\", "/");
		File fmm = new File(fullPath);
		if (!fmm.exists()) {
			List<String> subProcessedURI = subProcessURI(uri);
			fullPath = path + subProcessedURI.get(0);
			fmm = new File(fullPath);
			if (!fmm.exists()) {
				fullPath = path = subProcessedURI.get(1);
				fmm = new File(fullPath);
				if (!fmm.exists()) {
					return null;
				}
			}
		}
		return fullPath;
	}


	/**
	 * @param packages
	 *            MetaModel
	 * @param modelURI
	 *            URI of the Model
	 * @return Resource Loaded Model
	 * @throws
	 */
	public static Resource loadMetaModelAsResourceNoException(List<EPackage> packages,
			String strURI) {
		String modelURI = processURI(strURI);
		File fm = new File(modelURI);
		if (fm.exists() == false) {
			modelURI = getAbsoluteMetaModelURINoException(modelURI);
			if (modelURI == null) {
				return null;
			}
			fm = new File(modelURI);
			if (fm.exists() == false) {
				return null;
			}
		}

		ResourceSet resourceSet = ModelManager.initializeResource(modelURI);
		URI uri = URI.createURI(modelURI);
		for (EPackage p : packages) {
			// Add packages to package registry
			if (!resourceSet.getPackageRegistry().containsKey(p.getNsURI()))
				resourceSet.getPackageRegistry().put(p.getNsURI(), p);
			for (EPackage sp : p.getESubpackages()) {
				if (!resourceSet.getPackageRegistry().containsKey(sp.getNsURI()))
					resourceSet.getPackageRegistry().put(sp.getNsURI(), sp);
			}
		}
		final Map<Object, Object> options = resourceSet.getLoadOptions();
		options.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
		options.put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.FALSE);
		options.put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, new HashMap<Object, Object>());
		options.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
		options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		Resource model = null;
		try {
			model = resourceSet.createResource(uri);
			model.load(options);
			// model = resourceSet.getResource(URI.createURI(modelURI),true); //
			// load model using the URI
		} catch (Resource.IOWrappedException e) {
		} catch (IOException r) {
			r.printStackTrace();
		}

		return model;
	}

	/**
	 * @param metamodel
	 *            : path of the MetaModel
	 * @return boolean True if the MetaModel is validated
	 * @throws MetaModelNotFoundException, ModelNotFoundException
	 */
	public static boolean validateMetaModel(String metamodel)
			throws MetaModelNotFoundException, ModelNotFoundException {
		
		List<EPackage> packages = loadMetaModel(metamodel);
		Resource rs = loadMetaModelAsResource(packages, metamodel);
		
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(rs.getContents().get(0));
		if (diagnostic.getSeverity() == Diagnostic.OK || diagnostic.getSeverity() == Diagnostic.WARNING || diagnostic.getSeverity() == Diagnostic.ERROR) {
			return true;
		}
		return false;
	}
	
	public static boolean validateModel(String metamodel, String model)
			throws MetaModelNotFoundException, ModelNotFoundException {
		
		List<EPackage> packages = loadMetaModel(metamodel);
		Resource rs = loadModel(packages, model);
		
		Iterator<EObject> objects = rs.getAllContents();
		while (objects.hasNext()) {
			EObject eObject = objects.next();
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
			if (diagnostic.getSeverity() == Diagnostic.ERROR) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean validateModel(Resource model)
			throws MetaModelNotFoundException, ModelNotFoundException {
		Iterator<EObject> objects = model.getAllContents();
		while (objects.hasNext()) {
			EObject eObject = objects.next();
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
			if (diagnostic.getSeverity() == Diagnostic.ERROR) {
				return false;
			}
		}
		return true;		
	}
	
	public static boolean checkModel(String model) {
		File file = new File(model);
		if (file.exists() && !file.isDirectory()) {
			return true;
		}
		return false;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return ArrayList<EObject> All the objects except root
	 */
	public static List<EObject> getObjects(Resource model) {

		List<EObject> objs = new ArrayList<EObject>();

		Iterator<EObject> objects = model.getAllContents();

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
	public static List<EObject> getObjectsOfType(String type,
			Resource model) {

		List<EObject> objs = new ArrayList<EObject>();
		for (EObject obj : model.getContents()) {
			List<EClass> types = new ArrayList<EClass>();
			types.add(obj.eClass());
			types.addAll(obj.eClass().getEAllSuperTypes());
			for (EClass t : types) { 
				if (type.equals(t.getName())) {
					objs.add(obj);
				}
			}
			
			Iterator<EObject> it = obj.eAllContents();

			while (it.hasNext()) {
				EObject object = it.next();
				// Check the type
				types = new ArrayList<EClass>();
				types.add(object.eClass());
				types.addAll(object.eClass().getEAllSuperTypes());
				for (EClass t : types) { 
					if (type.equals(t.getName())) {
						objs.add(object);
					}
				}
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
	public static List<EObject> getObjectsOfType(String type,
			Resource model, List<EObject> excludes) {

		List<EObject> objs = new ArrayList<EObject>();
		for (EObject obj : model.getContents()) {
			List<EClass> types = new ArrayList<EClass>();
			types.add(obj.eClass());
			types.addAll(obj.eClass().getEAllSuperTypes());
			for (EClass t : types) { 
				if (type.equals(t.getName())) {
					boolean corresponds = true;
					for (EObject exc : excludes) {
						if (EcoreUtil.equals(obj, exc)) {
							corresponds = false;
							break;
						}
					}
					if (corresponds == true) {
						objs.add(obj);
					}
				}
			}
			
			Iterator<EObject> it = obj.eAllContents();

			while (it.hasNext()) {
				EObject object = it.next();
				// Check the type
				types = new ArrayList<EClass>();
				types.add(object.eClass());
				types.addAll(object.eClass().getEAllSuperTypes());
				for (EClass t : types) { 
					if (type.equals(t.getName())) {
						boolean corresponds = true;
						for (EObject exc : excludes) {
							if (EcoreUtil.equals(object, exc)) {
								corresponds = false;
								break;
							}
						}
						if (corresponds == true) {
							objs.add(object);
						}
					}
				}
			}
		}
		return objs;
	}

	/**
	 * @param type
	 *            Name of the wanted object
	 * @param source
	 *            Source object
	 * @param processed
	 *            Processed objects
	 * @return List<EObject> All the classes or objects of the specified
	 *         type
	 */
	private static List<EObject> getConnectedObjectsOfType(String type,
			EObject source, EObject initial, List<EObject> processed) {

		// first round direct references
		boolean found = false;
		List<EObject> objs = new ArrayList<EObject>();
		for (EReference ref : source.eClass().getEAllReferences()) {
			List<EClass> types = new ArrayList<EClass>();
			if (ref.getEType() instanceof EClass) {
				EClass eType = (EClass) ref.getEType();
				types.add(eType);
				types.addAll(eType.getEAllSuperTypes());
				List<EPackage> packages = new ArrayList<EPackage>();
				packages.add(eType.getEPackage());
				types.addAll(ModelManager.getESubClasses(packages, eType));
			}
			for (EClass t : types) {
				if (type.equals(t.getName())) {
					found = true;
					Object obj = source.eGet(ref);
					if (obj instanceof EObject && !EcoreUtil.equals((EObject) obj, initial)) {
						objs.add((EObject) obj);
					}
					if (obj instanceof List<?>) {
						for (EObject ob : (List<EObject>) obj) {
							if (!EcoreUtil.equals(ob, initial)) {
								objs.add(ob);
							}
						}
					}
				}
			}
		}
		if (found == true) {
			return objs;
		}

		//second round direct inverted references
		List<EObject> objects = ModelManager.getObjectsOfType(type, source.eResource());
		List<EObject> objectsOfType = new ArrayList<EObject>();
		for (EObject object : objects) {
			if (!EcoreUtil.equals(object, initial)) {
				objectsOfType.add(object);
			}
		}
		for (EObject object : objectsOfType) {
			for (EReference refToSource : object.eClass().getEAllReferences()) {
				if (refToSource.getEType().getName().equals(source.eClass().getName())) {
					Object obj = object.eGet(refToSource);
					if (obj instanceof EObject) {
						if (EcoreUtil.equals((EObject) obj, source)) {
							found = true;
							objs.add(object);
						}
					}
					if (obj instanceof List<?>) {
						for (EObject ob : (List<EObject>) obj) {
							if (EcoreUtil.equals(ob, source)) {
								found = true;
								objs.add(object);
							}
						}
					}
				}
			}
		}
		if (found == true) {
			return objs;
		}
		// third round secondary references
		List<EObject> target = new ArrayList<EObject>();
		processed.add(source);
		for (EReference ref : source.eClass().getEAllReferences()) {
			Object obj = source.eGet(ref);
			if (obj instanceof EObject) {
				EObject eObject = (EObject) obj;
				if (!processed.contains(eObject)) {
					processed.add(eObject);
					List<EObject> result = getConnectedObjectsOfType(type, eObject, initial, processed);
					for (EObject r : result) {
						if (!target.contains(r)) {
							found = true;
							target.add(r);
						}
					}
					if (found == true) {
						break;
					}
				}
			}
			if (obj instanceof List<?>) {
				for (EObject src : (List<EObject>) obj) {
					if (!processed.contains(src)) {
						processed.add((EObject) src);
						List<EObject> result = getConnectedObjectsOfType(type, src, initial, processed);
						for (EObject r : result) {
							if (!target.contains(r)) {
								found = true;
								target.add(r);
							}
						}
						if (found == true) {
							break;
						}
					}
				}
			}
		}
		for (EObject tar : target) {
			if (!objs.contains(tar)) {
				found = true;
				objs.add(tar);
			}
		}
		if (found == true) {
			return objs;
		}
		
		// fourth round recursive inverted search
		for (EObject object : objectsOfType) {
			processed.add(object);
			List<EObject> result = getConnectedObjectsOfType(source.eClass().getName(), object, initial, processed);
			if (result.size() > 0) {
				objs.add(object);
			}
		}
		return objs;
	}

	/**
	 * @param type
	 *            Name of the wanted object
	 * @param source
	 *            Source object
	 * @return List<EObject> All the classes or objects of the specified
	 *         type
	 */
	public static List<EObject> getConnectedObjectsOfType(String type,
			EObject source) {

		// first round direct references
		boolean found = false;
		List<EObject> objs = new ArrayList<EObject>();
		for (EReference ref : source.eClass().getEAllReferences()) {
			List<EClass> types = new ArrayList<EClass>();
			if (ref.getEType() instanceof EClass) {
				EClass eType = (EClass) ref.getEType();
				types.add(eType);
				types.addAll(eType.getEAllSuperTypes());
				List<EPackage> packages = new ArrayList<EPackage>();
				packages.add(eType.getEPackage());
				types.addAll(ModelManager.getESubClasses(packages, eType));
			}
			for (EClass t : types) {
				if (type.equals(t.getName())) {
					found = true;
					Object obj = source.eGet(ref);
					if (obj instanceof EObject) {
						objs.add((EObject) obj);
					}
					if (obj instanceof List<?>) {
						objs.addAll((List<EObject>) obj);
					}
				}
			}
		}
		if (found == true) {
			return objs;
		}
		
		//second round direct inverted references
		List<EObject> objects = ModelManager.getObjectsOfType(type, source.eResource());
		List<EObject> objectsOfType = new ArrayList<EObject>();
		for (EObject object : objects) {
			if (!EcoreUtil.equals(object, source)) {
				objectsOfType.add(object);
			}
		}
		for (EObject object : objectsOfType) {
			for (EReference refToSource : object.eClass().getEAllReferences()) {
				if (refToSource.getEType().getName().equals(source.eClass().getName())) {
					Object obj = object.eGet(refToSource);
					if (obj instanceof EObject) {
						if (EcoreUtil.equals((EObject) obj, source)) {
							found = true;
							objs.add(object);
						}
					}
					if (obj instanceof List<?>) {
						for (EObject o : (List<EObject>) obj) {
							if (EcoreUtil.equals(o, source)) {
								found = true;
								objs.add(object);
							}
						}
					}
				}
			}
		}
		if (found == true) {
			return objs;
		}
			
		// third round recursive direct search
		List<EObject> processed = new ArrayList<EObject>();
		List<EObject> target = new ArrayList<EObject>();
		processed.add(source);
		for (EReference ref : source.eClass().getEAllReferences()) {
			Object obj = source.eGet(ref);
			if (obj instanceof EObject) {
				EObject eObject = (EObject) obj;
				if (!processed.contains(eObject)) {
					processed.add(eObject);
					List<EObject> result = getConnectedObjectsOfType(type, eObject, source, processed);
					for (EObject r : result) {
						if (!target.contains(r)) {
							found = true;
							target.add(r);
						}
					}
					if (found == true) {
						break;
					}
				}
			}
			if (obj instanceof List<?>) {
				for (EObject src : (List<EObject>) obj) {
					if (!processed.contains(src)) {
						processed.add((EObject) src);
						List<EObject> result = getConnectedObjectsOfType(type, src, source, processed);
						for (EObject r : result) {
							if (!target.contains(r)) {
								found = true;
								target.add(r);
							}
						}
						if (found == true) {
							break;
						}
					}
				}
			}
		}
		for (EObject tar : target) {
			if (!objs.contains(tar)) {
				found = true;
				objs.add(tar);
			}
		}
		if (found == true) {
			return objs;
		}
		// fourth round recursive inverted search
		for (EObject object : objectsOfType) {
			processed.add(object);
			List<EObject> result = getConnectedObjectsOfType(source.eClass().getName(), object, source, processed);
			if (result.size() > 0) {
				objs.add(object);
			}
		}
		return objs;
	}


	/**
	 * @param refName
	 *            Name of the reference to the target object
	 * @param source
	 *            Source object
	 * @return Object Refered object
	 */
	public static Object getReferredObject(String refName, EObject source) {

		for (EReference ref : source.eClass().getEAllReferences()) {
			if (ref.getName().equals(refName)) {
				//return ReferenceUtil.safeEGet(source, ref);
				return source.eGet(ref);
			}
		}
		return null;
	}

	/**
	 * @param refNames
	 *            Names of the references to the target object
	 * @param sources
	 *            Source candidate objects
	 * @param targets
	 *            Target referenced objects
	 * @return ArrayList<EObject> Refered objects
	 */
	public static List<EObject> getReferredObjects(List<String> refNames, List<EObject> sources, List<EObject> targets) {

		List<EObject> objs = new ArrayList<EObject>();
		for (EObject src : sources) {
			EObject refObject = src;
			for (String refName : refNames) {
				EObject currentObject = refObject;
				try {
					refObject = ModelManager.getReference(refName, currentObject);
				} catch (ReferenceNonExistingException e) {
					break;
				}
				if (refObject == null) {
					break;
				}
			}
			if (refObject != null) {
				for (EObject tar : targets) {
					if (EcoreUtil.equals(tar, refObject)) {
						boolean found = false;
						for (EObject obj : objs) {
							if (EcoreUtil.equals(obj, src)) {
								found = true;
								break;
							}
						}
						if (!found) {
							objs.add(src);
						}
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
			if (p.getESubpackages() != null) {
				EObject object = getObjectOfType(type, p.getESubpackages());
				if (object != null) {
					return object;
				}
			}
		}

		return null;
	}
	
	/**
	 * @param uri
	 *            uri of the eClass
	 * @param metaModel
	 *            Loaded MetaModel
	 * @return EObject Class or reference of the specified type
	 */
	public static EObject getObjectOfURI(URI uri, List<EPackage> metaModel) {

		for (EPackage p : metaModel) {
			// For each classifier
			for (EClassifier c : p.getEClassifiers()) {
				// If we are looking for a Class, check its name
				if (EcoreUtil.getURI(c).equals(uri)) {
					return c;
				}
				// If we are looking for a Reference, check all references of
				// the classifier
				else {
					if (c instanceof EClass) {
						for (EReference r : ((EClass) c).getEAllReferences()) {
							if (EcoreUtil.getURI(r).equals(uri)) {
								return r;
							}
						}
					}
				}
			}
			if (p.getESubpackages() != null) {
				EObject object = getObjectOfURI(uri, p.getESubpackages());
				if (object != null) {
					return object;
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
	public static List<EObject> getObjectFromMetaModel(
			List<EPackage> metaModel) {

		List<EObject> ret = new ArrayList<EObject>();

		for (EPackage p : metaModel) {
			// For each classifier
			for (EClassifier c : p.getEClassifiers()) {
				ret.add(c);
			}
			if (p.getESubpackages() != null) {
				ret.addAll(getObjectFromMetaModel(p.getESubpackages()));
			}
		}

		return ret;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return ArrayList<EObject> All the classes or objects
	 */
	public static List<EObject> getAllObjects(Resource model) {

		List<EObject> objs = new ArrayList<EObject>();

		if (model == null) {
			return objs;
		}
		for (EObject obj : model.getContents()) {
			objs.add(obj);
			
			Iterator<EObject> it = obj.eAllContents();

			while (it.hasNext()) {
				EObject object = it.next();
				objs.add(object);
			}
		}
		return objs;
	}
	
		
	/**
	 * @param metamodel
	 *            Loaded MetaModel
	 * @return ArrayList<EObject> All the classes or objects
	 */
	public static List<EObject> getAllObjects(List<EPackage> metamodel) {

		List<EObject> objs = new ArrayList<EObject>();

		for (EPackage p : metamodel) {
			EList<EObject> objects = p.eContents();

			for (EObject object : objects) {
				objs.add(object);
			}
			if (p.getESubpackages() != null) {
				objs.addAll(getAllObjects(p.getESubpackages()));
			}
		}
		return objs;
	}
	
	/**
	 * @param packages
	 *            Loaded MetaModel
	 * @param model
	 *            Loaded Model
	 * @param containing
	 *            Name of the containing Class
	 * @return Parents
	 */
	public static List<EObject> getParentObjects(List<EPackage> packages, Resource model,
			String containing) {

		List<EObject> mmobjs = new ArrayList<EObject>();
		List<EObject> mmparents = new ArrayList<EObject>();
		List<EObject> parents = new ArrayList<EObject>();
		EObject obj = getObjectOfType(containing, packages);

		if ((containing.equals("EAttribute")
				|| containing.equals("EReference")
				|| containing.equals("EStructuralFeature"))) {
			mmobjs.add(getObjectOfType("EClass", packages));
		}
		else {
			mmobjs = getAllObjects(packages);

		}

		for (EObject mmo : mmobjs) {
			// We search inside the object
			for (EObject mmcont : mmo.eContents()) {
				if (mmcont.eClass().getName().equals(containing)) {
					mmparents.add(mmo);
					break;
				}
				if (mmcont instanceof EReference) {
					EReference ref = (EReference) mmcont;
					ArrayList<EClass> classes = new ArrayList<EClass>();
					classes.add((EClass) obj);
					classes.addAll(((EClass) obj).getEAllSuperTypes());
					for (EClass c : classes) {
						if (ref.getEType().getName().equals(c.getName()) && (ref.isContainment() == true)) {
							mmparents.add(mmo);
							break;
						}
					}
				}
			}
		}

		for (EObject mmp : mmparents) {
			parents.addAll(getObjectsOfType(((EClass) mmp).getName(), model));
		}
		if (parents.size() == 0) {
			parents.add(getRoot(model));
		}

		return parents;

	}

	/**
	 * @param model
	 *            Loaded Model
	 * @param containing
	 *            Name of the containing Class
	 * @return Parents
	 */
	public static EObject getContainer(Resource model, EObject object) {

		List<EObject> objs = getAllObjects(model);
		EObject parent = null;

		for (EObject obj : objs) {
			// We search inside the object
			for (EObject cont : obj.eContents()) {
				if (EcoreUtil.getURI(cont).equals(EcoreUtil.getURI(object))) {
					parent = obj;
					break;
				}
			}
			if (parent != null) {
				break;
			}
		}

		return parent;

	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @param containment
	 *            Name of the containment Class
	 * @return Containers
	 */
	public static List<EClass> getContainersList(List<EPackage> packages,
			URI uri, EClass rootClass, Map<EClass, Boolean> map) {

		List<EClass> containers = new ArrayList<EClass>();
		List<EClassifier> classifiers = getContainerTypes(packages, uri);
		if (classifiers.size() > 0) {
			for (EClassifier classifier : classifiers) {
				EClass eClass = (EClass) classifier;
				if (!map.get(eClass)) {
					map.put(eClass, true);
					containers.add(eClass);
					List<EClass> result = getContainersList(packages, EcoreUtil.getURI(eClass), rootClass, map);
					if (result != null) {
						for (EClass ec : result) {
							map.put(ec, true);
							if (!containers.contains(ec)) {
								containers.add(ec);
							}
						}
					}
					if (containers.contains(rootClass)) {
						break;
					}
				}
			}
		}
		return containers;

	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @param containment
	 *            Name of the containment Class
	 * @return Containers
	 */
	public static List<EObject> getContainerObjects(Resource model,
			String containment) {

		List<EObject> objs = getAllObjects(model);
		List<EObject> containers = new ArrayList<EObject>();


		for (EObject o : objs) {
			// We search the references inside the objects
			for (EObject cont : o.eContents()) {
				if (cont instanceof EReference) {
					EReference ref = (EReference) cont;
					if (ref.getEType().getName().equals(containment)) {
						containers.add(o);
						containers.addAll(getContainerObjects(model, ((EClass) o).getName()));
					}
				}
			}
		}

		return containers;

	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @param container
	 *            Container object
	 * @return Containers
	 */
	public static EObject getContainerObject(Resource model,
			EObject object) {
		
		List<EObject> objs = getAllObjects(model);
		List<EClass> types = new ArrayList<EClass>();
		types.add(object.eClass());
		types.addAll(object.eClass().getEAllSuperTypes());
		for (EObject obj : objs) {
			for (EReference ref : obj.eClass().getEAllReferences()) {
				if (ref.isContainment()) {
					for (EClass type : types) {
						if (EcoreUtil.equals(ref.getEReferenceType(), type)) {
							return obj;
						}
					}
				}
			}
		}

		return null;

	}

	/**
	 * @param model
	 *            Loaded Model
	 * @param container
	 *            Container object
	 * @return Containers
	 */
	public static EObject getContainerObject(EObject container,
			EObject object) {
		ArrayList<EClass> types = new ArrayList<EClass>();
		types.add(object.eClass());
		types.addAll(object.eClass().getEAllSuperTypes());

		for (EReference ref : container.eClass().getEAllReferences()) {
			if (ref.isContainment()) {
				for (EClass type : types) {
					if (EcoreUtil.equals(ref.getEReferenceType(), type)) {
						return container;
					}
					else {
						if (container.eGet(ref) != null) {
							EObject nextContainer = null;
							if (container.eGet(ref) instanceof List<?>) {
								List<EObject> list = (List<EObject>) container.eGet(ref);
								if (list.size() > 0) {
									nextContainer = list.get(0);
								}
							}
							else {
								nextContainer = (EObject) container.eGet(ref);
							}
							if (nextContainer != null) {
								EObject ret = getContainerObject(nextContainer, object);
								if (ret != null) {
									return ret;
								}
							}
						}
					}
				}
			}
		}

		return null;

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
	 * @return Root object
	 */
	public static List<EObject> getRoots(Resource model) {
		Iterator<EObject> objects = model.getAllContents();
		List<EObject> roots = new ArrayList<EObject>();
		Set<EPackage> packages = new LinkedHashSet<EPackage>();
		
		if (objects.hasNext()) {
			EObject obj = objects.next();
			packages.add(obj.eClass().getEPackage());
		}
		
		objects = model.getAllContents();
		if (objects.hasNext()) {
			EObject obj = objects.next();
			EPackage pck = obj.eClass().getEPackage();
			if (packages.contains(pck)) {
				roots.add(obj);
				packages.remove(pck);
			}
		}
		return roots;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getEObject(List<EObject> objs, EObject eobj) {
		EObject ob = null;
		if (eobj != null && objs != null && objs.size() > 0) {

			for (EObject obj : objs) {
				if (EcoreUtil.equals(obj, eobj)) {
					ob = obj;
					break;
				}
			}
			if (ob == null) {
				ob = getObjectByURI(objs, EcoreUtil.getURI(eobj));
			}
			if (ob == null) {
				ob = getObjectByURIEnding(objs, EcoreUtil.getURI(eobj));
			}
			if (ob == null) {
				ob = getObjectByID(objs, EcoreUtil.getIdentification(eobj));
			}
			if (ob == null) {
				ob = getObjectByPartialID(objs, EcoreUtil.getIdentification(eobj));
			}
		}
		return ob;
	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObject(Resource model, EObject eobj) {
		EObject eo = eobj;
		if (eo == null) {
			return null;
		}
		if (eo.eIsProxy()) {
			eo = EcoreUtil.resolve(eo, model.getResourceSet());
		}
		EObject ob = null;
		if (eobj != null) {
			List<EObject> objs = getAllObjects(model);

			for (EObject obj : objs) {
				if (EcoreUtil.equals(obj, eo)) {
					ob = obj;
					break;
				}
			}
			if (ob == null) {
				ob = getObjectByURI(model, EcoreUtil.getURI(eo));
			}
			if (ob == null) {
				ob = getObjectByURIEnding(model, EcoreUtil.getURI(eo));
			}
			if (ob == null) {
				ob = getObjectByID(model, EcoreUtil.getIdentification(eo));
			}
			if (ob == null) {
				ob = getObjectByPartialID(model, EcoreUtil.getIdentification(eo));
			}
		}
		return ob;
	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject loadObject(Resource model, EObject eobj) {
		EObject ob = null;
		if (eobj != null) {
			List<EObject> objs = getAllObjects(model);

			for (EObject obj : objs) {
				if (EcoreUtil.equals(obj, eobj)) {
					ob = obj;
					break;
				}
			}
			if (ob == null) {
				ob = getObjectByURI(model, EcoreUtil.getURI(eobj));
			}
			if (ob == null) {
				ob = getObjectByID(model, EcoreUtil.getIdentification(eobj));
			}
		}
		return ob;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObject(List<Resource> models, EObject eobj) {
		EObject ob = null;
		if (eobj != null) {
			for (Resource model : models) {
				List<EObject> objs = getAllObjects(model);

				for (EObject obj : objs) {
					if (EcoreUtil.equals(obj, eobj)) {
						ob = obj;
						break;
					}
				}
				if (ob == null) {
					ob = getObjectByURI(model, EcoreUtil.getURI(eobj));
				}
				if (ob == null) {
					ob = getObjectByURIEnding(model, EcoreUtil.getURI(eobj));
				}
				if (ob == null) {
					ob = getObjectByID(model, EcoreUtil.getIdentification(eobj));
				}
				if (ob == null) {
					ob = getObjectByPartialID(model, EcoreUtil.getIdentification(eobj));
				}
				if (ob != null) {
					break;
				}
			}
		}
		return ob;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObjectByID(List<EObject> objs, String identification) {
		if (objs != null && objs.size() > 0) {
			for (EObject obj : objs) {
				if (EcoreUtil.getIdentification(obj).equals(identification)) {
					return obj;
				}
			}
		}
		return null;
	}
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObjectByID(Resource model, String identification) {
		List<EObject> objs = getAllObjects(model);

		for (EObject obj : objs) {
			if (EcoreUtil.getIdentification(obj).equals(identification)) {
				return obj;
			}
		}
		return null;
	}
	
	private static String getURIToFind(String objectURI) {
		String uriToFind = "";
		int index = objectURI.indexOf(".");
		String tmpURIToFind = objectURI.substring(objectURI.indexOf("/@") + 1, objectURI.length());
//		int k = 0;
		while (index >= 0) {
			String featureURI = tmpURIToFind.substring(1, tmpURIToFind.indexOf("."));
			int value = 0;
			String newFeatureURI = "";
			if (tmpURIToFind.indexOf("/") >= 0 && tmpURIToFind.indexOf(".") >= 0 && tmpURIToFind.indexOf("/") > tmpURIToFind.indexOf(".")) {
				String str = tmpURIToFind.substring(tmpURIToFind.indexOf(".") + 1, tmpURIToFind.indexOf("/"));
				if (!JavaUtils.isNumeric(str)) {
					break;
				}
				value = Integer.valueOf(str);
				newFeatureURI = featureURI + "." + String.format("%d", value);
			}
			else {
				newFeatureURI = featureURI;
			}
//			if (tmpURIToFind.indexOf("/@") < 0 && k != 0) {
//				value = value - 1;
//			}
//			k++;
			uriToFind += "/@" + newFeatureURI;
			if (tmpURIToFind.indexOf("/@") < 0) {
				break;
			}
			tmpURIToFind = tmpURIToFind.substring(tmpURIToFind.indexOf("/@") + 1, tmpURIToFind.length());
			index = tmpURIToFind.indexOf(".");
		}
		if (uriToFind.isEmpty()) {
			uriToFind = objectURI;
		}
		return uriToFind;
	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObjectByPartialID(List<EObject> objs, String identification) {
		if (objs != null && objs.size() > 0) {
			String objectType = identification.substring(identification.indexOf("#"), identification.indexOf("@"));
			String objectURI = identification.substring(identification.lastIndexOf("#/") + 2, identification.indexOf("}"));
			String uriToFind = getURIToFind(objectURI);
			//String partialID = identification.substring(identification.indexOf("#"), identification.indexOf("{"));
			for (EObject obj : objs) {
				String objID = EcoreUtil.getIdentification(obj);
				String objType = objID.substring(objID.indexOf("#"), objID.indexOf("@"));
				String objURI = objID.substring(objID.lastIndexOf("#/") + 2, objID.indexOf("}"));
				if (objURI.equals(uriToFind) && objType.equals(objectType)) {
					return obj;
				}
				//partialObjID = partialObjID.substring(partialObjID.indexOf("#"), partialObjID.indexOf("{"));
				//if (partialID.equals(partialObjID)) {
				//	return obj;
				//}
			}
		}
		return null;
	}
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObjectByPartialID(Resource model, String identification) {
		List<EObject> objs = getAllObjects(model);

		String partID = identification;
		if (partID.indexOf("{") != -1) {
			partID = partID.substring(partID.indexOf("{") + 1 , partID.length());
		}
		if (partID.indexOf("#//@") != -1) {
			partID = partID.substring(partID.indexOf("#//@"), partID.length());
		}
		else if (partID.indexOf("#") != -1) {
			partID = partID.substring(partID.indexOf("#"), partID.length());
		}
		if (partID.indexOf("}") != -1) {
			partID = partID.substring(0, partID.indexOf("}"));
		}
		String objectURI = partID;
		int start = 0;
		if (objectURI.indexOf("#//@") != -1) {
			start = "#//@".length();
		}
		String objectType = objectURI.substring(start, objectURI.length());
		int end = objectType.length();
		if (objectType.indexOf(".") != -1) {
			end = objectType.indexOf(".");
		}
		objectType = objectType.substring(0, end);
		String uriToFind = getURIToFind(objectURI);
		//String partialID = partID.substring(partID.indexOf("#"), partID.indexOf("{"));
		for (EObject obj : objs) {
			String objID = EcoreUtil.getIdentification(obj);
			String objType = objID.substring(objID.indexOf("#"), objID.indexOf("@"));
			String objURI = objID.substring(objID.lastIndexOf("#/") + 2, objID.indexOf("}"));
			if (objURI.equals(uriToFind) && objType.equals(objectType)) {
				return obj;
			}
			//partialObjID = partialObjID.substring(partialObjID.indexOf("#"), partialObjID.indexOf("{"));
			//if (partialID.equals(partialObjID)) {
			//	return obj;
			//}
		}
		return null;
	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObjectByURI(Resource model, URI uri) {
		List<EObject> objs = getAllObjects(model);

		for (EObject obj : objs) {
			if (EcoreUtil.getURI(obj).equals(uri)) {
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
	public static EObject getObjectByURI(List<EObject> objs, URI uri) {
		if (objs != null && objs.size() > 0) {
			for (EObject obj : objs) {
				if (EcoreUtil.getURI(obj).equals(uri)) {
					return obj;
				}
			}
		}
		return null;
	}
	
	public static String getURIEnding(EObject object) {
		URI uri = EcoreUtil.getURI(object);
		String partialURI = uri.toString();
		partialURI = partialURI.substring(partialURI.indexOf("#"), partialURI.length());
		return partialURI;
	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObjectByURIEnding(List<EObject> objs, URI uri) {
		if (objs != null && objs.size() > 0) {
			String partialURI = uri.toString();
			partialURI = partialURI.substring(partialURI.indexOf("#"), partialURI.length());
			for (EObject obj : objs) {
				String partialObjURI = EcoreUtil.getURI(obj).toString();
				partialObjURI = partialObjURI.substring(partialObjURI.indexOf("#"), partialObjURI.length());
				if (partialURI.equals(partialObjURI)) {
					return obj;
				}
			}
		}
		return null;
	}
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObjectByURIEnding(Resource model, URI uri) {
		List<EObject> objs = getAllObjects(model);

		String partialURI = uri.toString();
		partialURI = partialURI.substring(partialURI.indexOf("#"), partialURI.length());
		for (EObject obj : objs) {
			String partialObjURI = EcoreUtil.getURI(obj).toString();
			partialObjURI = partialObjURI.substring(partialObjURI.indexOf("#"), partialObjURI.length());
			if (partialURI.equals(partialObjURI)) {
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
	public static EObject getObjectByName(Resource model, EObject object) {
		List<EObject> objs = getAllObjects(model);
		
		EStructuralFeature nameFeature = object.eClass().getEStructuralFeature("name");
		if (nameFeature == null) {
			return null;
		}
		Object ob = object.eGet(nameFeature);
		if (ob == null) {
			return null;
		}
		String name = null;
		if (ob instanceof String) {
			name = (String) ob;
		}
		if (name == null) {
			return null;
		}
		for (EObject obj : objs) {
			if (EcoreUtil.equals(obj.eClass(), object.eClass())) {
				EClass eClass = obj.eClass();
				EStructuralFeature feature = eClass.getEStructuralFeature("name");
				if (feature == null) {
					continue;
				}
				ob = obj.eGet(feature);
				if (ob == null) {
					continue;
				}
				String currentName = null;
				if (ob instanceof String) {
					currentName = (String) ob;
				}
				if (currentName == null) {
					continue;
				}
				if (name.equals(currentName)) {
					return obj;
				}
			}
		}
		return null;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static List<EObject> getObjects(Resource model, List<EObject> objects) {
		List<EObject> objs = new ArrayList<EObject>();
		
		for (EObject obj : objects) {
			EObject ob = getObject(model, obj);
			if (ob == null) {
				 ob = getObjectByURI(model, EcoreUtil.getURI(obj));
			}
			if (ob == null) {
				 ob = getObjectByURIEnding(model, EcoreUtil.getURI(obj));
			}
			if (ob == null) {
				 ob = getObjectByID(model, EcoreUtil.getIdentification(obj));
			}
			if (ob == null) {
				 ob = getObjectByPartialID(model, EcoreUtil.getIdentification(obj));
			}
			if (ob != null) {
				objs.add(ob);
			}
		}
		return objs;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EReference getReference(Resource model, EReference eref) {
		List<EReference> refs = getAllReferences(model);

		for (EReference ref : refs) {
			if (EcoreUtil.equals(eref, ref)) {
				return ref;
			}
		}
		return null;
	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static List<EReference> getContainmentReferencesOfType(List<EPackage> packages, EObject container, EObject obj) {
		
		List<EReference> refs = new ArrayList<EReference>();
		List<EClass> superTypes = new ArrayList<EClass>();
		superTypes.add(obj.eClass());
		superTypes.addAll(obj.eClass().getEAllSuperTypes());
		for (EReference ref : container.eClass().getEAllReferences()) {
			if (ref.isContainment()) {
				List<EClass> subTypes = new ArrayList<EClass>();
				subTypes.add(ref.getEReferenceType());
				subTypes.addAll(getESubClasses(packages, ref.getEReferenceType()));
				for (EClass subType : subTypes) {
					for (EClass superType : superTypes) {
						if (EcoreUtil.equals(subType, superType)) {
							if (!refs.contains(ref)) refs.add(ref);
						}
					}
				}
			}
		}
		return refs;
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
	 * @return List<String> Values of the attribute named by -att-
	 */
	public static List<String> getListStringAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return (List<String>) object.eGet(sf, true);
			}
		}
		return null;
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
				if (sf.getEType() instanceof EEnum) {
					Object value = object.eGet(sf, true);
					if (value instanceof EEnumLiteral) {
						return ((EEnumLiteral) value).getLiteral();
					}
				}
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
	 * @return List<String> Values of the attribute named by -att-
	 */
	public static List<String> getStringAttributes(String att, EObject object) {
		List<String> ret = new ArrayList<String>();
		if (att == null || object == null) {
			return ret;
		}

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				if (sf.getEType() instanceof EEnum) {
					Object value = object.eGet(sf, true);
					if (value instanceof EEnumLiteral) {
						ret.add(((EEnumLiteral) value).getLiteral());
						break;
					}
				}
				if (sf.getUpperBound() > 1 || sf.getUpperBound() == -1) {
					EDataTypeUniqueEList<String> list = (EDataTypeUniqueEList<String>) object.eGet(sf, true);
					for (String value : list) {
						ret.add(value); 
					}
					break;
				}
				ret.add((String) object.eGet(sf, true));
				break;
			}
		}
		return ret;
	}
	
	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @return String Value of the attribute named by -att-
	 */
	public static List<String> getStringListAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return (List<String>) object.eGet(sf, true);
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
	public static boolean hasAttribute(String att, EObject object) {
		if (object != null) {
			EClass tipo = object.eClass();

			for (EStructuralFeature sf : tipo.getEAllAttributes()) {
				if (sf != null) {
					if (sf.getName().equals(att)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @throws WrongAttributeTypeException
	 */
	public static Object getAttribute(String att, EObject object) {
		if (object != null) {
			EClass tipo = object.eClass();

			for (EStructuralFeature sf : tipo.getEAllAttributes()) {
				if (sf != null) {
					if (sf.getName().equals(att)) {
						return object.eGet(sf);
					}
				}
			}
		}
		return null;
	}
	
	private static double getNumericValue(Object val) {
		double currentValue = Double.MIN_VALUE;
		if (val instanceof String) {
			String strValue = (String) val;
			boolean error = false;
			try {
				currentValue = (double) Long.decode(strValue);
			}
			catch (NumberFormatException ex) {
				error = true;
			}
			if (error) {
				error = false;
				try {
					currentValue = Double.valueOf(strValue);
				}
				catch (NumberFormatException ex) {
					error = true;
				}
			}
			if (error) {
				error = false;
				try {
					currentValue = Float.valueOf(strValue);
				}
				catch (NumberFormatException ex) {
					error = true;
				}
			}
			if (error) {
				error = false;
				try {
					currentValue = Long.valueOf(strValue);
				}
				catch (NumberFormatException ex) {
					error = true;
				}
			}
			if (error) {
				error = false;
				try {
					currentValue = Integer.valueOf(strValue);
				}
				catch (NumberFormatException ex) {
					error = true;
				}
			}
			if (error) {
				error = false;
				try {
					currentValue = new BigInteger(strValue, 16).doubleValue();
				}
				catch (NumberFormatException ex) {
					error = true;
				}
			}
		}
		if (val instanceof Double || val instanceof Float || val instanceof Long || val instanceof Integer) {
			currentValue = (double) val;
		}
		return currentValue;
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

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf != null) {
				if (sf.getName().equals(att)) {
					Object value = acs.getValue(object);
					if (sf.getEType() instanceof EEnum && value.getClass().getSimpleName().toLowerCase().equals("string")) {
						EList<EEnumLiteral> literals = ((EEnum) sf.getEType()).getELiterals();
						for (EEnumLiteral lit : literals) {
							if (lit.getLiteral().equals((String) value)) {
								object.eSet(sf, lit.getInstance());
								break;
							}
						}
					}
					else {
						if (acs.sameType(sf.getEType())) {
							if (acs instanceof RandomStringNumberConfigurationStrategy) {
								RandomStringNumberConfigurationStrategy attConfig = (RandomStringNumberConfigurationStrategy) acs;
								Object val = object.eGet(sf, true);
								double currentValue = ModelManager.getNumericValue(val);
								if (currentValue != Double.MIN_VALUE) { 
									List<Double> skipValues = new ArrayList<Double>();
									skipValues.add(currentValue);
									RandomStringNumberConfigurationStrategy newAttConfig = new RandomStringNumberConfigurationStrategy(attConfig.getMin(), attConfig.getMax(), false, skipValues);
									String newValue = newAttConfig.getValue();
									if (Integer.valueOf(newValue) != Integer.MIN_VALUE) {
										object.eSet(sf, newValue);
									}
								}
							}
							else {
								object.eSet(sf, acs.getValue(object));
							}
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
	}

	/**
	 * @throws ReferenceNonExistingException
	 */
	public static EObject getReference(String ref, EObject object) throws
		ReferenceNonExistingException {

		EClass tipo = object.eClass();

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
	 * @throws ReferenceNonExistingException
	 */
	public static Object getReferenced(String ref, EObject object) throws
		ReferenceNonExistingException {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			if (sf != null) {
				if (sf.getName().equals(ref)) {
					return object.eGet(sf);
				}
			}
		}
		return null;
	}
	
	/**
	 * @throws ReferenceNonExistingException
	 */
	public static Object getReferenced(String ref, List<EObject> objects) throws
		ReferenceNonExistingException {

		List<Object> ret = new ArrayList<Object>();
		
		for (EObject object : objects) {
			EClass tipo = object.eClass();

			for (EStructuralFeature sf : tipo.getEAllReferences()) {
				if (sf != null) {
					if (sf.getName().equals(ref)) {
						ret.add(object.eGet(sf));
					}
				}
			}
		}
		return ret;
	}

	/**
	 * @throws ReferenceNonExistingException
	 */
	public static List<EObject> getReferences(String ref, EObject object) throws
		ReferenceNonExistingException {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			if (sf != null) {
				if (sf.getName().equals(ref)) {
					Object ob = object.eGet(sf);
					if (ob instanceof List<?>) {
						return (List<EObject>) ob;
					}
					if (ob instanceof EObject) {
						List<EObject> ret = new ArrayList<EObject>();
						ret.add((EObject) ob);
						return ret;
					}
				}
			}
		}
		return null;
	}

	public static void setReference(String ref, EObject object,
			EObject newObject) throws WrongAttributeTypeException,
			ReferenceNonExistingException {

		if (newObject == null) {
			return;
		}
		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			if (sf != null) {
				if (sf.getName().equals(ref)) {
					if (newObject != null) {
						if (!sf.isMany() && (((EClass) sf.getEType()).isSuperTypeOf(newObject.eClass()) && sf.isChangeable())) {
							object.eSet(sf, newObject);
							break;
						}
						if (sf.isMany() && ((EClass) sf.getEType()).isSuperTypeOf(newObject.eClass()) && sf.isChangeable()) {
							List<EObject> objects = (List<EObject>) object.eGet(sf);
							objects.add(newObject);
							break;
						}
					} else {
						throw new ReferenceNonExistingException(
								"There is no object for the reference '" + ref
										+ "'");
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
	 * @param acs
	 *            Value of the new attribute
	 * @throws WrongAttributeTypeException
	 * @throws ReferenceNonExistingException
	 */
	public static void setReference(String ref, EObject object,
			ObSelectionStrategy oss) throws WrongAttributeTypeException,
			ReferenceNonExistingException {

		EClass tipo = object.eClass();
		if (oss == null) {
			unsetReference(ref, object);
			return;
		}
		EObject tarObj = oss.getObject();
		// EClass tipo = tarObj.eClass();

		if (tarObj != null) {
			for (EStructuralFeature sf : tipo.getEAllReferences()) {
				if (sf != null) {
					if (sf.getName().equals(ref)) {
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
									if (((EClass) sf.getEType()).isSuperTypeOf(tarObj.eClass()) && sf.isChangeable()) {
										if (sf.getUpperBound() == 1) {
											object.eSet(sf, tarObj);
										}
										else {
											List<EObject> objects = (List<EObject>) object.eGet(sf);
											objects.add(tarObj);
										}
									}
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
					}
				}
			}
			return;
		}
		List<EObject> tarObjs =  oss.getObjects();
		if (tarObjs != null) {
			for (EStructuralFeature sf : tipo.getEAllReferences()) {
				if (sf != null) {
					if (sf.getName().equals(ref)) {
						List<EObject> objects = (List<EObject>) object.eGet(sf);
						objects.addAll(tarObjs);
					}
				}
			}
			return;
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

		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			if (sf != null) {
				if (sf.getName().equals(ref)) {
					if (rcs.sameType()) {
						if (sf.isChangeable()) {
							if (rcs.getValue(object) instanceof List<?>) {
								List<EObject> o = (List<EObject>) object.eGet(sf, true);
								o.addAll((List<EObject>) rcs.getValue(object));
							}
							if (rcs.getValue(object) instanceof EObject) {
								object.eSet(sf, rcs.getValue(object));
							}
						}
					} else {
						if (rcs.getValue(object) != null) {
							throw new WrongAttributeTypeException("The reference '"
									+ ref
									+ "' is not of the type "
									+ "'" + rcs.getValue(object).getClass().getSimpleName() + "'");
						}
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
	 * @param newValue
	 *            Value of the new attribute
	 */
	public static void setIntAttribute(String att, EObject object,
			int newValue) {

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
	 * @param newValue
	 *            Value of the new attribute
	 */
	public static void setEEnumAttribute(String att, EObject object,
			EEnum eenum, int newValue) {

		if (newValue < 0) {
			newValue = -newValue;
		}

		EClass tipo = object.eClass();
		
		EEnumLiteral literal = eenum.getELiterals().get(newValue % eenum.getELiterals().size());

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				object.eSet(sf, literal);
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
	public static Object getEEnumAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return object.eGet(sf, true);
			}
		}
		return null;
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param newValue
	 *            Value of the new attribute
	 */
	public static void setDoubleAttribute(String att, EObject object,
			double newValue) {

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
	 * @return Float Value of the attribute named by -att-
	 */
	public static Float getFloatAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return (Float) object.eGet(sf, true);
			}
		}
		return null;
	}
/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param newValue
	 *            Value of the new attribute
	 */
	public static void setBooleanAttribute(String att, EObject object,
			boolean newValue) {

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
 	public static List<EReference> getContainingReferences(
			List<EPackage> metaModel, EObject container, String containing)
			throws ReferenceNonExistingException {
		ArrayList<EReference> contRefs = new ArrayList<EReference>();
		List<EReference> refs = getReferences(container);
		EClass obj = (EClass) getObjectOfType(containing, metaModel);

		for (EReference r : refs) {
			if (r.isChangeable()) {
				if (r.getEType().getName().equals(containing)) {
					if (!contRefs.contains(r)) {
						contRefs.add(r);
					}
				}
				for (EClass c : obj.getEAllSuperTypes()) {
					if (c.getName().equals(r.getEType().getName())) {
						if (!contRefs.contains(r)) {
							contRefs.add(r);
						}
					}
				}
			}
		}

		return contRefs;
	}
 	
 	public static EReference getContainingReference(EClass container, EClass containing)
			throws ReferenceNonExistingException {
		EReference contRef = null;
		List<EReference> refs = container.getEAllReferences();

		for (EReference r : refs) {
			if (r.isChangeable()) {
				if (r.getEType().getName().equals(containing.getName())
						|| containing.getEAllSuperTypes().contains(r.getEType())) {
					contRef = r;
					break;
				}
			}
		}

		return contRef;
	}

	/**
	 * @param name
	 *            Name of the reference
	 * @param model
	 *            Loaded Model
	 * @return ArrayList<EStructuralFeature> Specified references of the model
	 */
	public static List<EStructuralFeature> getAllReferencesByName(
			String name, Resource model) {
		List<EStructuralFeature> ret = new ArrayList<EStructuralFeature>();
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
	public static List<EReference> getAllReferences(Resource model) {
		List<EReference> ret = new ArrayList<EReference>();
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
				if (source.eGet(r, true) != null) {
					if (source.eGet(r, true).equals(target))
						return r;
				}
			} else {
				if (source.eGet(r, true) != null) {
					for (EObject aux : (List<EObject>) source.eGet(r, true)) {
						if (aux != null && target.equals(aux)) {
							return r;
						}
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
	 * @param name
	 *            Name of the reference
	 * @param object
	 *            Object one wants to explore
	 * @return EStructuralFeature Specified reference
	 */
	public static EStructuralFeature getReferenceByName(String name,
			EClass eClass) {
		EStructuralFeature sf = eClass.getEStructuralFeature(name);
		return sf;
	}
	
	/**
	 * @param name
	 *            Name of the reference
	 * @param object
	 *            Object one wants to explore
	 * @return EStructuralFeature Specified reference
	 */
	public static EReference getReferenceByURI(URI uri,
			EClass eClass) {
		List<EReference> refs = eClass.getEAllReferences();
		
		EReference ret = null;

		for (EReference ref : refs) {
			if (EcoreUtil.getURI(ref).equals(uri)) {
				ret = ref;
				break;
			}
		}
		return ret;
	}

	/**
	 * @param name
	 *            Name of the reference
	 * @param object
	 *            Object one wants to explore
	 * @return EStructuralFeature Specified reference
	 */
	public static EStructuralFeature getAttributeByName(String name,
			EObject object) {
		EStructuralFeature sf = null;

		List<EAttribute> atts = getAttributes(object);

		for (EStructuralFeature sf2 : atts) {
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
		Map<Object, Object> options = new HashMap<Object, Object>();
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
	public static Resource createModel(String outputURI) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMLResourceFactoryImpl());
		URI uri = URI.createFileURI(outputURI);
		Resource resource = rs.createResource(uri);
		return resource;
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
		saveOptions.put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE,	new ArrayList<Object>());
		saveOptions.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		resource.getContents().add(eobj);
		try {
			resource.save(saveOptions);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		resource.unload();
	}
	
	/**
	 * @param model
	 *            Model one wants to output
	 * @param outputURI
	 *            URI of the new created Model
	 */
	public static Resource createAndLoadModel(EObject eobj, String outputURI) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMLResourceFactoryImpl());
		URI uri = URI.createFileURI(outputURI);
		Resource resource = rs.createResource(uri);
		Map<Object, Object> saveOptions = ((XMLResource) resource)
				.getDefaultSaveOptions();
		saveOptions.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE,
				new ArrayList<Object>());
		resource.getContents().add(eobj);
		try {
			resource.save(saveOptions);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return resource;
	}

	/**
	 * @param model
	 *            Model one wants to clone
	 * @param outputURI
	 *            URI of the new created Model
	 */
	public static Resource cloneModel(Resource model, String outputURI) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMLResourceFactoryImpl());
		URI uri = URI.createFileURI(outputURI);
		Resource resource = rs.createResource(uri);
//		EMFCopier.copy(model, resource);
		List<EObject> clonedModel = EMFCopier.copy(model);
		resource.getContents().addAll(clonedModel);
		return resource;
	}
	
	/**
	 * @param l
	 *            List in order to get the size and index
	 * @return Random number
	 */
	public static int getRandomIndex(List<?> l) {
		if (l.size() <= 1)
			return 0;

		int index = rn.nextInt() % l.size();
		if (index < 0)
			index = index * -1;

		return index;
	}

	public static void saveOutModel(Resource model, String outputURI) {
		URI uri = model.getURI();
		model.setURI(URI.createFileURI(outputURI));
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
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
	 * It returns the types that declare some containment reference to the received type.
	 * 
	 * @param List
	 *            <EPackage> metaModel
	 * @param String
	 *            type
	 */
	public static List<EClassifier> getContainerTypes(List<EPackage> metaModel, URI uri) {
		List<EClassifier> classifiers = new ArrayList<EClassifier>();
		EObject object = getObjectOfURI(uri, metaModel);
		if (object instanceof EClass) {
			EClass classifier = (EClass) object;
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
					for (EPackage sp : p.getESubpackages()) {
						List<EPackage> packages = new ArrayList<EPackage>();
						packages.add(sp);
						List<EClassifier> containerTypes = getContainerTypes(packages, uri);
						for (EClassifier containerType : containerTypes) {
							if (!classifiers.contains(containerType)) {
								classifiers.add(containerType);
							}
						}
					}
				}
			}
		}
		return classifiers;
	}
	
	/**
	 * It returns the types that declare some reference to the received type.
	 * 
	 * @param List
	 *            <EPackage> metaModel
	 * @param String
	 *            type
	 */
	public static List<EClassifier> getReferringTypes(List<EPackage> metaModel, URI uri) {
		List<EClassifier> classifiers = new ArrayList<EClassifier>();
		EObject object = getObjectOfURI(uri, metaModel);
		if (object instanceof EClass) {
			EClass classifier = (EClass) object;
			if (classifier != null) {
				for (EPackage p : metaModel) {
					for (EClassifier c : p.getEClassifiers()) {
						if (c instanceof EClass) {
							for (EReference r : ((EClass) c).getEAllReferences()) {
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
					for (EPackage sp : p.getESubpackages()) {
						List<EPackage> packages = new ArrayList<EPackage>();
						packages.add(sp);
						List<EClassifier> containerTypes = getContainerTypes(packages, uri);
						for (EClassifier containerType : containerTypes) {
							if (!classifiers.contains(containerType)) {
								classifiers.add(containerType);
							}
						}
					}
				}
			}
		}
		return classifiers;
	}

	/**
	 * It returns the containment referenced types for the given type
	 * 
	 * @param List
	 *            <EPackage> metaModel
	 * @param String
	 *            type
	 */
	public static List<EClass> getContainmentTypes(List<EPackage> metaModel, URI uri) {
		List<EClass> classifiers = new ArrayList<EClass>();
		EObject object = getObjectOfURI(uri, metaModel);
		if (object instanceof EClass) {
			EClass classifier = (EClass) object;
			if (classifier != null) {
				for (EReference r : classifier.getEAllReferences()) {
					if (r.isContainment()) { // only containment
						// relations!
						EClass c = r.getEReferenceType();
						List<EClass> types = new ArrayList<EClass>();
						types.add(c);
						types.addAll(ModelManager.getESubClasses(metaModel, c));
						for (EClass type : types) {
							if (!classifiers.contains(type)) {
								classifiers.add(type);
							}
						}

					}
				}
			}
		}
		return classifiers;
	}
	
	public static boolean compareModels(String metamodel, String model1, String model2) {
		URI uri1 = URI.createFileURI(model1);
	    URI uri2 = URI.createFileURI(model2);
	    
	    List<EPackage> packages = null;
	    
	    try {
			packages = ModelManager.loadMetaModel(metamodel);
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

	    ResourceSet baseResourceSet = new ResourceSetImpl();
	    ResourceSet branchResourceSet = new ResourceSetImpl();

	    for (EPackage pck : packages) {
	    	baseResourceSet.getPackageRegistry().put(pck.getNsURI(), pck.getEFactoryInstance().getEPackage());
	    	branchResourceSet.getPackageRegistry().put(pck.getNsURI(), pck.getEFactoryInstance().getEPackage());
	    }

	    baseResourceSet.getResource(uri1, true);
	    branchResourceSet.getResource(uri2, true);

	    IComparisonScope scope = new DefaultComparisonScope(branchResourceSet, baseResourceSet, null);
	    Comparison comparison = EMFCompare.builder().build().compare(scope);
	    
	    List<Diff> differences = comparison.getDifferences();
		if (differences.size() == 0) {
			return true;
		}

		return false;
	}

	public static boolean compareModels(Resource model1, Resource model2) {
		IComparisonScope scope = new DefaultComparisonScope(model1, model2, null);
		Comparison comparison = EMFCompare.builder().build().compare(scope);

		List<Diff> differences = comparison.getDifferences();

		if (differences.size() == 0) {
			return true;
		}
		
		return false;
	}
	
	public static boolean compareObjects(EObject ob1, EObject ob2) {
		// note it is necessary to put the resources in a resourceset
		// cause EMF uses the resourceset to compute id's etc.
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource1 = new XMLResourceImpl(URI.createURI("resource1.xml")); //$NON-NLS-1$
		final Resource resource2 = new XMLResourceImpl(URI.createURI("resource2.xml")); //$NON-NLS-1$
		resourceSet.getResources().add(resource1);
		resourceSet.getResources().add(resource2);
		resource1.getContents().add(ob1);
		resource2.getContents().add(ob2);

		final IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		final IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		final IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);
		final EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();

		// Compare the two models
		final IComparisonScope scope = new DefaultComparisonScope(resource1, resource2, null);
		final Comparison comparison = comparator.compare(scope);
		final EList<Diff> differences = comparison.getDifferences();
		if (differences.size() == 0) {
			return true;
		}

		return false;
	}

	public static boolean compareListObjects(List<EObject> lob1, List<EObject> lob2) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource1 = new XMLResourceImpl(URI.createURI("resource1.xml")); //$NON-NLS-1$
		final Resource resource2 = new XMLResourceImpl(URI.createURI("resource2.xml")); //$NON-NLS-1$
		resourceSet.getResources().add(resource1);
		resourceSet.getResources().add(resource2);
		resource1.getContents().addAll(lob1);
		resource2.getContents().addAll(lob2);

		final IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		final IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		final IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);
		final EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();

		// Compare the two models
		final IComparisonScope scope = new DefaultComparisonScope(resource1, resource2,	null);
		final Comparison comparison = comparator.compare(scope);
		final EList<Diff> differences = comparison.getDifferences();
		if (differences.size() == 0) {
			return true;
		}

		return false;
	}
	
	/**
	 * It returns the list of classes defined in a meta-model.
	 */
	public static List<EClass> getEClasses(List<EPackage> packages) {
		return getEClasses(packages, new ArrayList<EPackage>());
	}

	/**
	 * It returns the list of classes defined in a meta-model.
	 */
	private static List<EClass> getEClasses(List<EPackage> packages, List<EPackage> processed) {
		List<EClass> classes = new ArrayList<EClass>();
		for (EPackage pck : packages) {
			if (!processed.contains(pck)) {
				for (EClassifier cl : pck.getEClassifiers()) {
					if (cl instanceof EClass) {
						if (!classes.contains((EClass) cl)) {
							classes.add((EClass) cl);
						}
					}
				}
				processed.add(pck);
				if (pck.getESubpackages() != null) {
					List<EClass> subpackageClasses = getEClasses(pck.getESubpackages(), processed);
					for (EClass cl : subpackageClasses) {
						if (!classes.contains(cl)) {
							classes.add(cl);
						}
					}
				}
			}
		}
		return classes;
	}
	
	/**
	 * It returns the list of the given class subclasses defined in a meta-model.
	 */
	public static List<EClass> getESubClasses(List<EPackage> packages, EClass eClass) {
		List<EClass> subclasses = new ArrayList<EClass>();
		if (eClass == null) {
			return subclasses; 
		}
		List<EClass> classes = ModelManager.getEClasses(packages);
		for (EClass cl : classes) {
			List<EClass> superTypes = cl.getEAllSuperTypes();
			for (EClass superType : superTypes) {
				if (superType != null) {
					if (EcoreUtil.getURI(superType).equals(EcoreUtil.getURI(eClass))) {
						subclasses.add(cl);
					}
				}
			}
		}
		return subclasses;
	}

	/**
	 * It returns the class identified by the name defined in a meta-model.
	 */
	public static EClass getEClassByName(List<EPackage> packages, String name) {
		for (EPackage pck : packages) {
			for (EClassifier cl : pck.getEClassifiers()) {
				if (cl instanceof EClass) {
					if (cl.getName().equals(name) == true) {
						return (EClass) cl;
					}
				}
			}
			if (pck.getESubpackages() != null) {
				EClass cl = getEClassByName(pck.getESubpackages(), name);
				if (cl != null) {
					return cl;
				}
			}
		}
		return null;
	}
	
	/**
	 * It returns the class identified by the uri defined in a meta-model.
	 */
	public static EClass getEClassByURI(List<EPackage> packages, URI uri) {
		for (EPackage pck : packages) {
			for (EClassifier cl : pck.getEClassifiers()) {
				if (cl instanceof EClass) {
					if (EcoreUtil.getURI(cl).equals(uri)) {
						return (EClass) cl;
					}
				}
			}
			if (pck.getESubpackages() != null) {
				EClass cl = getEClassByURI(pck.getESubpackages(), uri);
				if (cl != null) {
					return cl;
				}
			}
		}
		return null;
	}

	/**
	 * It returns the list of classes defined in a meta-model package.
	 */
	public static EClass getEClassFromEPackage(EPackage pck, String name) {
		for (EClassifier cl : pck.getEClassifiers()) {
			if (cl instanceof EClass) {
				if (cl.getName().equals(name) == true) {
					return (EClass) cl;
				}
			}
		}
		if (pck.getESubpackages() != null) {
			for (EPackage spck : pck.getESubpackages()) {
				EClass cl = getEClassFromEPackage(spck, name);
				if (cl != null) {
					return cl;
				}
			}
		}
		return null;
	}

	/**
	 * It returns the reference by identified its uri defined in a meta-model.
	 */
	public static EReference getEReferenceByURI(EClass eClass, URI uri) {
		for (EReference ref : eClass.getEAllReferences()) {
			if (EcoreUtil.getURI(ref).equals(uri)) {
				return ref;
			}
		}
		return null;
	}
	
	/**
	 * Returns the corresponding object checking whether it is
	 * a proxy object
	 */
	public static EObject getEObject(EObject object, Resource seed) {
		if (object.eIsProxy()) {
			return EcoreUtil.resolve(object, seed);
		}
		return object;
	}
	
	/**
	 * Gets the root EClass
	 */
	public static EClass getRootEClass(List<EPackage> packages) {
		EClass root = null;
		List<EClass> eclasses = ModelManager.getEClasses(packages);
		for (EClass eclass : eclasses) {
			if (eclass.isAbstract() == false) {
				List<EClassifier> containerTypes = ModelManager.getContainerTypes(packages, EcoreUtil.getURI(eclass));
				if (containerTypes.size() == 0) {
					root = eclass;
					break;
				}
			}
		}
		return root;
	}
	
	/**
	 * Gets the root EClass
	 */
	private static List<EClass> getRootEClassesSubpackages(List<EPackage> subpackages) {
		List<EClass> roots = new ArrayList<EClass>();
		for (EPackage pck : subpackages) {
			List<EPackage> pcks = new ArrayList<EPackage>();
			pcks.add(pck);
			roots.add(getRootEClass(pcks));
			if (pck.getESubpackages() != null && pck.getESubpackages().size() > 0) {
				roots.addAll(getRootEClassesSubpackages(pck.getESubpackages()));
			}
		}
		return roots;
	}

	/**
	 * Gets the root EClass
	 */
	public static List<EClass> getRootEClasses(List<EPackage> packages) {
		List<EClass> roots = new ArrayList<EClass>();
		roots.add(getRootEClass(packages));
		List<EPackage> pcks = new ArrayList<EPackage>();
		pcks.addAll(packages);
		for (EPackage pck : packages) {
			if (pck.getESubpackages() != null && pck.getESubpackages().size() > 0) {
				roots.addAll(getRootEClassesSubpackages(pck.getESubpackages()));
			}
		}
		return roots;
	}

	/**
	 * Gets the corresponding EPackage
	 */
	public static EPackage getEPackage(List<EPackage> packages, EClass eClass) {
		for (EPackage pck : packages) {
			for (EClassifier cl : pck.getEClassifiers()) {
				if (cl instanceof EClass) {
					if (EcoreUtil.equals((EClass) cl, eClass)) {
						return pck;
					}
				}
			}
			if (pck.getESubpackages() != null) {
				EPackage subpck = getEPackage(pck.getESubpackages(), eClass);
				if (subpck != null) {
					return subpck;
				}
			}
		}
		return null;
	}
	
	/**
	 * Gets the EPackage by its name 
	 */
	public static EPackage getEPackage(List<EPackage> packages, String name) {
		for (EPackage pck : packages) {
			if (pck.getName().equals(name)) {
				return pck;
			}
			if (pck.getESubpackages() != null) {
				EPackage subpck = getEPackage(pck.getESubpackages(), name);
				if (subpck != null) {
					return subpck;
				}
			}
		}
		return null;
	}
	
	/**
	 * Gets the compatible list of EClass for the given type
	 */
	public static List<EClass> getSiblingEClasses(String metamodel, EClass type) {
		List<EClass> sibling = new ArrayList<EClass>();
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);

			List<EClass> superTypes = type.getESuperTypes();
			sibling.addAll(ModelManager.getESubClasses(packages, type));
			List<EClass> classes = ModelManager.getEClasses(packages);
			for (EClass superType : superTypes) {
				for (EClass cl : classes) {
					List<EClass> clSuperTypes = cl.getESuperTypes();
					for (EClass clSuperType : clSuperTypes) {
						if (EcoreUtil.equals(superType, clSuperType)) {
							if (!sibling.contains(cl) && !EcoreUtil.equals(cl, type)) {
								sibling.add(cl);
								List<EClass> clSubClasses = ModelManager.getESubClasses(packages, cl);
								for (EClass clSubClass : clSubClasses) {
									if (!sibling.contains(clSubClass) && !EcoreUtil.equals(clSubClass, type)) {
										sibling.add(clSubClass);
									}
								}
							}
						}
					}
				}
			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sibling;
	}
	
	/**
	 * Gets the compatible list of EClass for the given type
	 */
	public static List<EClass> getSiblingEClasses(String metamodel, List<EClass> types) {
		List<EClass> sibling = new ArrayList<EClass>();
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);

			for (EClass type : types) {
				List<EClass> superTypes = type.getESuperTypes();
				sibling.addAll(ModelManager.getESubClasses(packages, type));
				List<EClass> classes = ModelManager.getEClasses(packages);
				for (EClass superType : superTypes) {
					for (EClass cl : classes) {
						List<EClass> clSuperTypes = cl.getESuperTypes();
						for (EClass clSuperType : clSuperTypes) {
							if (EcoreUtil.equals(superType, clSuperType)) {
								if (!sibling.contains(cl) && !EcoreUtil.equals(cl, type)) {
									sibling.add(cl);
									List<EClass> clSubClasses = ModelManager.getESubClasses(packages, cl);
									for (EClass clSubClass : clSubClasses) {
										if (!sibling.contains(clSubClass) && !EcoreUtil.equals(clSubClass, type)) {
											sibling.add(clSubClass);
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sibling;
	}

	/**
	 * Gets the compatible list of EClass for the given type
	 */
	public static List<EClass> getSiblingEClasses(String metamodel, List<EClass> types, List<EClass> excludedSuperTypes) {
		List<EClass> sibling = new ArrayList<EClass>();
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);

			for (EClass type : types) {
				List<EClass> completeSuperTypes = type.getESuperTypes();
				List<EClass> superTypes = new ArrayList<EClass>();
				for (EClass clSuperType : completeSuperTypes) {
					if (!excludedSuperTypes.contains(clSuperType)) {
						superTypes.add(clSuperType);
					}
				}
				sibling.addAll(ModelManager.getESubClasses(packages, type));
				List<EClass> classes = ModelManager.getEClasses(packages);
				for (EClass superType : superTypes) {
					for (EClass cl : classes) {
						List<EClass> clCompleteSuperTypes = cl.getESuperTypes();
						List<EClass> clSuperTypes = new ArrayList<EClass>();
						for (EClass clSuperType : clCompleteSuperTypes) {
							if (!excludedSuperTypes.contains(clSuperType)) {
								clSuperTypes.add(clSuperType);
							}
						}
						for (EClass clSuperType : clSuperTypes) {
							if (EcoreUtil.equals(superType, clSuperType)) {
								if (!sibling.contains(cl) && !EcoreUtil.equals(cl, type)) {
									sibling.add(cl);
									List<EClass> clSubClasses = ModelManager.getESubClasses(packages, cl);
									for (EClass clSubClass : clSubClasses) {
										if (!sibling.contains(clSubClass) && !EcoreUtil.equals(clSubClass, type)) {
											sibling.add(clSubClass);
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sibling;
	}

	/**
	 * Removes an eobject list from an eobject list by its URI ending
	 */
	public static void removeEObjects(List<EObject> target, List<EObject> objectsToRemove) {
		List<EObject> tmpList = new ArrayList<EObject>();
		tmpList.addAll(target);
		
		for (EObject obj : objectsToRemove) {
			String partialObjURI = EcoreUtil.getURI(obj).toString();
			partialObjURI = partialObjURI.substring(partialObjURI.indexOf("#"), partialObjURI.length());
			for (EObject tar : target) {
				String partialURI = EcoreUtil.getURI(tar).toString();
				partialURI = partialURI.substring(partialURI.indexOf("#"), partialURI.length());
				if (partialURI.equals(partialObjURI)) {
					tmpList.remove(tar);
					break;
				}	
			}
		}
		target.clear();
		target.addAll(tmpList);
	}
	
	/** 
	 * Finds the model the object belongs to
	 */
	public static Resource findModel(List<Resource> models, EObject obj) {
		if (obj == null || models == null || models.size() == 0) {
			return null;
		}
		for (Resource model : models) {
			List<EObject> objects = ModelManager.getAllObjects(model);
			for (EObject object : objects) {
				if (EcoreUtil.equals(obj, object)) {
					return model;
				}
			}
		}
		return null;
	}
	
	public static boolean isBigInteger (String type) { return type.equals("EBigInteger"); }	
	public static boolean isInteger  (String type)   { return type.equals("EInt") || type.equals("Integer") || type.equals("IntegerObject") || type.endsWith("Integer"); }	
	public static boolean isString   (String type)   { return type.equals("EString") || type.equals("String") || type.endsWith("String"); }	
	public static boolean isBoolean  (String type)   { return type.equals("EBoolean") || type.equals("boolean") || type.equals("EBooleanObject") || type.equals("Boolean") || type.endsWith("Boolean"); }
	public static boolean isFloating (String type)   { return type.equals("EFloat")  || type.equals("float")  || type.equals("EFloatObject")  || type.equals("Float")  || type.endsWith("Float") ||
	                                                          type.equals("EDouble") || type.equals("double") || type.equals("EDoubleObject") || type.equals("Double") || type.endsWith("Double"); }
}