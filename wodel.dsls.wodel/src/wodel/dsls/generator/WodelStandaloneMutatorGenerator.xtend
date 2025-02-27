package wodel.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import wodel.utils.manager.ProjectUtils
import java.io.File
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Program
import wodel.utils.manager.JavaUtils
import java.util.List
import wodel.utils.manager.ModelManager
import wodel.dsls.WodelUtils

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the Java code for the mutations (standalone mode).
 * 
 */
class WodelStandaloneMutatorGenerator extends WodelMutatorGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
		standalone = true
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
			var String xTextFileName = getMutatorPath(e, files)
			var String xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePathWithProjectName + "/" + program.output + fileName.replaceAll(".mutator", ".model")
			WodelUtils.serialize(xTextFileName, xmiFileName)
			
			fileName = fileName.replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_") + ".mutator"
			/* Write the EObject into a file */
			fileName = fileName.replaceAll(".mutator", "Standalone.java")
			className = fileName.replaceAll("Standalone.java", "Standalone")
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
		
		if (fsa.isFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "/" + getProjectName.replaceAll("[.]", "_") + "StandaloneLauncher.java")) {
			fsa.deleteFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "/" + getProjectName.replaceAll("[.]", "_") + "StandaloneLauncher.java")
     	}
		fsa.generateFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "/" + getProjectName.replaceAll("[.]", "_") + "StandaloneLauncher.java", JavaUtils.format(mutatorEnvironment.launcher(mutators), false))
	}
}