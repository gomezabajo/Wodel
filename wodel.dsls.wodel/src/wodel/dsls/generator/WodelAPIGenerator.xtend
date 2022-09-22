package wodel.dsls.generator

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import mutatorenvironment.MutatorEnvironment
import java.io.File
import manager.ModelManager
import mutatorenvironment.Program
import manager.ProjectUtils
import org.eclipse.core.resources.IProject
import wodel.dsls.WodelUtils
import java.util.Map
import java.util.HashMap
import manager.JavaUtils
import java.util.List
import java.util.ArrayList
import org.eclipse.core.runtime.Platform

public class WodelAPIGenerator extends AbstractGenerator {
	
	private String fileName
	private Program program
	private IProject project = null
	private String path
	private String xmiFileName
	private Map<String, List<String>> mutMap = new HashMap<String, List<String>>()
	
	def List<String> getMutators(File[] files) {
		var List<String> mutators = new ArrayList<String>()
		var int i = 0
		while (files !== null && i < files.size) {
			var File file = files.get(i)
			if (file.isFile == true) {
				if (file.getName().endsWith(".mutator")) {
					var mutator = file.getName().replaceAll(".mutator", "")
					if (!mutators.contains(mutator)) {
						mutators.add(mutator)
					}
				}
			}
			else if (file.isDirectory == true) {
				var List<String> nextMutators = new ArrayList<String>()
				nextMutators.addAll(getMutators(file.listFiles))
				for (String nextMutator : nextMutators) {
					if (!mutators.contains(nextMutator)) {
						mutators.add(nextMutator)
					}
				}
			}
			i++
		}
		return mutators
	}
	
	def String getMutatorPath(File[] files) {
		var String mutatorPath = null
		var int i = 0
		while (mutatorPath === null && files !== null && i < files.size) {
			var File file = files.get(i)
			if (file.isFile == true) {
				if (file.getName().equals(fileName)) {
					var mutatorFolderAndFile = file.path.substring(file.path.indexOf(project.name)).replace("\\", "/")
					mutatorPath = "file:/" + ModelManager.getWorkspaceAbsolutePath+"/"+mutatorFolderAndFile
				}
			}
			else {
				mutatorPath = getMutatorPath(file.listFiles)
			}
			i++
		}
		return mutatorPath
	}
	
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		ProjectUtils.resetProject()
		project = ProjectUtils.getProject()
		
		path = ModelManager.getWorkspaceAbsolutePath + "/" + project.name
		var projectFolderName = ModelManager.getWorkspaceAbsolutePath+ "/" + project.name + "/"
		var File projectFolder = new File(projectFolderName)
		var File[] files = projectFolder.listFiles
		var String className = ""
		var String mutatorName = ""
		//var List<String> mutators = getMutators(files)
		var MutatorEnvironment mutatorEnvironment = null
		for(e: resource.allContents.toIterable.filter(MutatorEnvironment)) {
			
			fileName = resource.URI.lastSegment
			var String xTextFileName = getMutatorPath(files)
			program = (e as MutatorEnvironment).definition as Program
			xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath + "/" + project.name + "/" + program.output + fileName.replaceAll(".mutator", ".model")
			WodelUtils.serialize(xTextFileName, xmiFileName)

			fileName = fileName.replaceAll(".mutator", "").replaceAll("[.]", "_") + ".mutator"
			/* Write the EObject into a file */
			mutatorName = fileName.replaceAll(".mutator", "").replaceAll("[.]", "_");
			fileName = mutatorName.replaceAll("[.]", "_") + "API.java"
			className = fileName.replaceAll(".java", "")
			var int i = 1
			var String key = className.replace("API", "")
			for (b : e.blocks) {
				var List<String> values = new ArrayList<String>()
				if (mutMap.keySet.contains(key)) {
					values = mutMap.get(key)
				}
				if (b.name !== null && !b.name.isEmpty() && !values.contains(b.name)) {
					values.add(b.name)
				}
				mutMap.put(key, values)
			}
     		if (fsa.isFile("mutator/" + mutatorName + "/" + fileName)) {
				fsa.deleteFile("mutator/" + mutatorName + "/" + fileName)
     		}
     		fsa.generateFile("mutator/" + mutatorName + "/" + fileName, JavaUtils.format(e.compile(mutatorName, className), false))
     		mutatorEnvironment = e
		}
		//if (fsa.isFile("mutator/" + project.name.replaceAll("[.]", "/") + "/" + project.name.replaceAll("[.]", "_") + "APILauncher.java")) {
		//	fsa.deleteFile("mutator/" + project.name.replaceAll("[.]", "/") + "/" + project.name.replaceAll("[.]", "_") + "APILauncher.java")
     	//}
		//fsa.generateFile("mutator/" + project.name.replaceAll("[.]", "/") + "API/" + project.name.replaceAll("[.]", "_") + "APILauncher.java", JavaUtils.format(mutatorEnvironment.launcher(mutators), false))
	}
	
	def compile(MutatorEnvironment e, String mutatorName, String className) '''
	package mutator.«mutatorName»;
	
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;
	import java.util.TreeMap;
	import org.eclipse.core.resources.IProject;
	import org.eclipse.core.runtime.IProgressMonitor;
	import org.eclipse.emf.ecore.EPackage;
	
	import exceptions.AbstractCreationException;
	import exceptions.MaxSmallerThanMinException;
	import exceptions.MetaModelNotFoundException;
	import exceptions.ModelNotFoundException;
	import exceptions.ObjectNoTargetableException;
	import exceptions.ObjectNotContainedException;
	import exceptions.ReferenceNonExistingException;
	import exceptions.WrongAttributeTypeException;
	import manager.ModelManager;
	import manager.MutatorAPI;
	import manager.MutatorUtils;

	public class «className» extends MutatorAPI {
		
		public void createMutants(String[] mutationOperators, IProject project, IProgressMonitor monitor)
		 	throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
			
			System.out.println("Wodel mutator file: «mutatorName»");
			
			String ecoreURI = ModelManager.getMetaModel();
			List<EPackage> packages = null;
			try {
				packages = ModelManager.loadMetaModel(ecoreURI, this.getClass());
			}
			catch (Exception e) {
			}
			boolean isRegistered = ModelManager.isRegistered(packages);
			Map<String, EPackage> registeredPackages = ModelManager.registeredMetaModels(packages);
			Map<String, EPackage> localRegisteredPackages = null;
			if (isRegistered == true) {
				if (registeredPackages != null) {
					List<EPackage> packageList = new ArrayList<EPackage>();
					packageList.addAll(registeredPackages.values());
					ModelManager.unregisterMetaModel(packageList);
				}
				localRegisteredPackages = ModelManager.unregisterMetaModel(packages);
			}

			int maxAttempts = «Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of attempts", "0", null))»;
			int numMutants = «Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of mutants", "3", null))»;
			boolean registry = «Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate registry", false, null)»;
			boolean metrics = «Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate net mutant footprints", false, null)»;
			boolean debugMetrics = «Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate debug mutant footprints", false, null)»;
			
			MutatorUtils mut«mutatorName» = new «mutatorName»();
			mut«mutatorName».execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages, localRegisteredPackages, mutationOperators, project, monitor, true, null, new TreeMap<String, List<String>>());
				
			if (isRegistered == true) {
				ModelManager.registerMetaModel(localRegisteredPackages);
				if (registeredPackages != null) {
					ModelManager.registerMetaModel(registeredPackages);
				}
			}
		}
	}
	'''
	def launcher(MutatorEnvironment e, List<String> mutators) '''

package mutator.«project.name»;

import java.util.ArrayList;
import java.util.List;

import manager.MutatorAPILauncher;

public class «project.name.replaceAll("[.]", "_")»APILauncher {

	public static void main(String[] args) {
		String ecoreURI = null;
		«IF e.definition instanceof Program»
		ecoreURI = "«e.definition.metamodel»";
		«ENDIF»
		List<String> mutatorNames = new ArrayList<String>();
		«FOR mutatorName : mutators»
		mutatorNames.add("«mutatorName»");
		«ENDFOR»
		List<List<String>> operatorNames = new ArrayList<List<String>>();
		«FOR mut : mutMap.keySet»
		List<String> mutatorOperatorNames«mut» = new ArrayList<String>();
		«FOR operator : mutMap.get(mut)»
		mutatorOperatorNames«mut».add("«operator»");
		«ENDFOR»
		operatorNames.add(mutatorOperatorNames«mut»);
		«ENDFOR»
		String[] arrMutatorNames = new String[mutatorNames.size()];
		mutatorNames.toArray(arrMutatorNames);
		String[][] arrOperatorNames = new String[mutatorNames.size()][];
		int i = 0;
		for (List<String> mutOpNames : operatorNames) {
			String[] arrMutatorOperatorNames = new String[mutOpNames.size()];
			mutOpNames.toArray(arrMutatorOperatorNames);
			arrOperatorNames[i] = arrMutatorOperatorNames;
			i++;
		}
		MutatorAPILauncher.createMutants("«project.name»", ecoreURI, «project.name.replaceAll("[.]", "_")»APILauncher.class, arrMutatorNames, arrOperatorNames, "D:\\seed", "D:\\mutants");
	}
}
	'''
}
