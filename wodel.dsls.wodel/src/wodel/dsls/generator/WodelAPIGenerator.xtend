package wodel.dsls.generator

import org.eclipse.xtext.generator.AbstractGenerator
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject
import java.util.Map
import java.util.List
import java.util.HashMap
import wodel.utils.manager.ProjectUtils
import java.io.File
import java.util.ArrayList
import mutatorenvironment.MutatorEnvironment
import wodel.utils.manager.ModelManager
import org.eclipse.core.runtime.Platform

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the code to programmatically execute the Wodel program.
 * 
 */
abstract class WodelAPIGenerator extends AbstractGenerator {
	
	protected String fileName
	protected Program program
	protected IProject project = null
	protected String path
	protected String xmiFileName
	protected String className = ""
	protected Map<String, List<String>> mutMap = new HashMap<String, List<String>>()
	
	protected boolean standalone = false
	
	def String getProjectName() {
		var String projectName = null
		if (ProjectUtils.project !== null) {
			projectName = ProjectUtils.project.name
		}
		else {
			projectName = ProjectUtils.projectName
		}
		return projectName
	}
	
	def List<String> getMutators(File[] files) {
		var List<String> mutators = new ArrayList<String>()
		if (files !== null) {
			for (File file : files) {
				if (file !== null) {
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
				}
			}
		}
		return mutators
	}
	
	def String getMutatorPath(MutatorEnvironment e, File[] files) {
		var String mutatorPath = null
		if (mutatorPath === null && files !== null) {
			for (File file : files) {
				if (mutatorPath !== null) {
					return mutatorPath
				}
				if (file !== null) {
				 	if (file.isFile == true) {
						if (file.getName().equals(fileName)) {
							var mutatorFolderAndFile = file.path.substring(file.path.indexOf(getProjectName)).replace("\\", "/")
							mutatorPath = "file:/" + ModelManager.getWorkspaceAbsolutePath(e)+"/"+mutatorFolderAndFile
						}
					}
					else  {
						mutatorPath = getMutatorPath(e, file.listFiles)
					}
				}
			}
		}
		return mutatorPath
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
	
	import wodel.utils.exceptions.AbstractCreationException;
	import wodel.utils.exceptions.MaxSmallerThanMinException;
	import wodel.utils.exceptions.MetaModelNotFoundException;
	import wodel.utils.exceptions.ModelNotFoundException;
	import wodel.utils.exceptions.ObjectNoTargetableException;
	import wodel.utils.exceptions.ObjectNotContainedException;
	import wodel.utils.exceptions.ReferenceNonExistingException;
	import wodel.utils.exceptions.WrongAttributeTypeException;
	import wodel.utils.manager.ModelManager;
	«IF standalone == false»
	import mutator.«mutatorName»Dynamic.«mutatorName»Dynamic;
	import wodel.utils.manager.MutatorAPI;
	«ELSE»
	import mutator.«mutatorName»Standalone.«mutatorName»Standalone;
	import org.eclipse.core.runtime.NullProgressMonitor;
	import wodel.utils.manager.MutatorStandaloneAPI;
	«ENDIF»
	import wodel.utils.manager.MutatorUtils;

		«IF standalone == false»		
	public class «className» extends MutatorAPI {

		public void createMutants(String[] mutationOperators, IProject project, IProgressMonitor monitor)
		 	throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		«ELSE»
	public class «className» extends MutatorStandaloneAPI {

		public static void createMutants(String[] mutationOperators)
		 	throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		«ENDIF»
			
			System.out.println("Wodel mutator file: «mutatorName»");
			
			String ecoreURI = "«ModelManager.getMetaModel(e)»";
			List<EPackage> packages = null;
			try {
				«IF standalone == false»
				packages = ModelManager.loadMetaModel(ecoreURI, this.getClass());
				«ELSE»
				packages = ModelManager.loadMetaModel(ecoreURI, «className».class);
				«ENDIF»
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
			//«var int maxAttempts = 3»
            //«var int numMutants = 10»
            //«var boolean registry = true»
            //«try {
            	maxAttempts = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of attempts", "3", null))
            	numMutants = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of mutants", "3", null))
            	registry = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate registry", true, null)
            } catch (Exception ex) {}»
			int maxAttempts = «maxAttempts»;
			int numMutants = «numMutants»;
			boolean registry = «registry»;
			
			«IF standalone == false»
			//«var boolean metrics = false»
			//«var boolean debugMetrics = false»
			//«try {
			  	metrics = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate net mutant footprints", false, null)
			   	debugMetrics = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate debug mutant footprints", false, null)
			} catch (Exception ex) {}»
			boolean metrics = «metrics»;
			boolean debugMetrics = «debugMetrics»;
			MutatorUtils mut«mutatorName» = new «mutatorName»Dynamic();
			mut«mutatorName».execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages, localRegisteredPackages, mutationOperators, project, monitor, true, null, new TreeMap<String, List<String>>());
			«ELSE»
			boolean metrics = false;
			boolean debugMetrics = false;
			MutatorUtils mut«mutatorName» = new «mutatorName»Standalone();
			mut«mutatorName».execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages, localRegisteredPackages, mutationOperators, new NullProgressMonitor(), true, null, new TreeMap<String, List<String>>());
			«ENDIF»
				
			if (isRegistered == true) {
				ModelManager.registerMetaModel(localRegisteredPackages);
				if (registeredPackages != null) {
					ModelManager.registerMetaModel(registeredPackages);
				}
			}
			
			«IF standalone == true»
			System.out.println("«mutatorName» Mutant generation process finished.");
			«ENDIF»
		}
	}
	'''
	def launcher(MutatorEnvironment e, List<String> mutators) '''

package mutator.«getProjectName»;

import java.util.ArrayList;
import java.util.List;

«IF standalone == false»
import wodel.utils.manager.MutatorAPILauncher;
«ELSE»
import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.MaxSmallerThanMinException;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ObjectNoTargetableException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;
import java.io.IOException;
import java.io.File;
import wodel.utils.manager.IOUtils;
import wodel.utils.manager.MutatorUtils;
«FOR String mutatorName : mutMap.keySet»
import mutator.«mutatorName».«mutatorName»StandaloneAPI;
«ENDFOR»
«ENDIF»

«IF standalone == false»
public class «getProjectName.replaceAll("[.]", "_")»DynamicAPILauncher {
	public static void main(String[] args) 
	{
«ELSE»
public class «getProjectName.replaceAll("[.]", "_")»StandaloneAPILauncher {
	public static void createMutants(String inputFolder, String outputFolder) throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException
	{
«ENDIF»

		String ecoreURI = "«ModelManager.getMetaModel(e)»";
		List<String> mutatorNames = new ArrayList<String>();
		«FOR mutatorName : mutMap.keySet»
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
		«IF standalone == false»
		MutatorAPILauncher.createMutants("«getProjectName»", ecoreURI, «getProjectName.replaceAll("[.]", "_")»APILauncher.class, arrMutatorNames, arrOperatorNames, "D:\\seed", "D:\\mutants");
		«ELSE»
		String inputWodelFolder = "«ModelManager.getModelsFolder(e)»";
		// clean-up input wodel folder only if it is different to the input folder
		if (!inputFolder.equals(inputWodelFolder)) {
			IOUtils.deleteFolder(inputWodelFolder, "model");
		}
			
		File seedWodelFolder = new File(inputWodelFolder);
		File inputCustomizedFolder = new File(inputFolder);
			
		try {
			IOUtils.copyFolder(inputCustomizedFolder, seedWodelFolder, "model");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		File projectFolder = new File("«ModelManager.getWorkspaceAbsolutePath(e)»/«getProjectName»");
		List<String> mutatorList = MutatorUtils.getMutators(projectFolder.listFiles());
		String outputWodelFolder = "«ModelManager.getWorkspaceAbsolutePath(e)»/«getProjectName»/«ModelManager.getOutputFolder(e)»";
		// clean-up output folder preserving xtext auto generated models
		IOUtils.deleteFolder(outputWodelFolder, "model", mutatorList);
		i = 0;
		«FOR String mutatorName : mutMap.keySet»
		«mutatorName»StandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		«ENDFOR»
		File mutantWodelFolder = new File(outputWodelFolder);
		File outputCustomizedFolder = new File(outputFolder);
			
		try {
			IOUtils.copyFolder(mutantWodelFolder, outputCustomizedFolder, "model", mutatorList);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Complete mutant generation process finished.");
		«ENDIF»
	}
	
	«IF standalone == true»
	public static void main(String[] args) throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException
	{
		if (args.length != 2) {
			System.out.println("Use: args[0] = inputFolder; args[1] = outputFolder");
			return;
		}
		createMutants(args[0], args[1]);
	}
	«ENDIF»
}
	'''
}
