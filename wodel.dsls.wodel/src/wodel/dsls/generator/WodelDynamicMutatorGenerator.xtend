package wodel.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import wodel.utils.manager.ProjectUtils
import wodel.utils.manager.ModelManager
import java.io.File
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Program
import java.util.List
import wodel.utils.manager.JavaUtils

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the Java code for the mutations (dynamic mode).
 * 
 */
class WodelDynamicMutatorGenerator extends WodelMutatorGenerator {
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
		standalone = false
//		try {
//			bundle = Platform.getBundle("wodel.models")
//			metricsURL = URI.createURI("file:" + FileLocator.resolve(bundle.getEntry("/model/MutatorMetrics.ecore")).getFile()).toFileString().replace("\\", "/")
//			mutatorURL = URI.createURI("file:" + FileLocator.resolve(bundle.getEntry("/model/MutatorEnvironment.ecore")).getFile()).toFileString().replace("\\", "/")
//			ModelManager.saveMetricsEnvironmentBundle(resource, metricsURL)
//			ModelManager.saveMutatorEnvironmentBundle(resource, mutatorURL)
//		}
//		catch (Exception ex) {
//			metricsURL = URI.createURI("file:" + ModelManager.getMetricsEnvironmentBundle(resource)).toFileString().replace("\\", "/")
//			mutatorURL = URI.createURI("file:" + ModelManager.getMutatorEnvironmentBundle(resource)).toFileString().replace("\\", "/")
//		}

		var String projectFolderName = ProjectUtils.getProject !== null ? ProjectUtils.getProject.getLocation.toFile.getPath + "/" : ModelManager.getWorkspaceAbsolutePath + "/"	
		var File projectFolder = new File(projectFolderName)
		var File[] files = projectFolder.listFiles
		var MutatorEnvironment mutatorEnvironment = null
		for(e: resource.allContents.toIterable.filter(MutatorEnvironment)) {
			
			fileName = resource.URI.lastSegment
			program = (e as MutatorEnvironment).definition as Program
			
			fileName = fileName.replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_") + ".mutator"
			/* Write the EObject into a file */
			fileName = fileName.replaceAll(".mutator", "Dynamic.java")
			className = fileName.replaceAll("Dynamic.java", "Dynamic")
			var int i = 1
			for (mut : e.commands) {
				mutIndexes.put(mut, i++)
			}
			for (b : e.blocks) {
				for (mut : b.commands) {
					mutIndexes.put(mut, i++)
				}
			}
     		if (fsa.isFile("mutator/" + className + "/" + fileName)) {
				fsa.deleteFile("mutator/" + className + "/" + fileName)
     		}
     		fsa.generateFile("mutator/" + className + "/" + fileName, JavaUtils.format(e.compile, false))
     		mutatorEnvironment = e
		}
		
		var List<String> mutators = getMutators(files)
		
		if (fsa.isFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "/" + getProjectName.replaceAll("[.]", "_") + "DynamicLauncher.java")) {
			fsa.deleteFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "/" + getProjectName.replaceAll("[.]", "_") + "DynamicLauncher.java")
     	}
		fsa.generateFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "/" + getProjectName.replaceAll("[.]", "_") + "DynamicLauncher.java", JavaUtils.format(mutatorEnvironment.launcher(mutators), false))
	}
}