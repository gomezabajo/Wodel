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
import org.eclipse.core.resources.IProject

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the Java code for the mutations (standalone mode).
 * 
 */
class WodelStandaloneMutatorGenerator extends WodelMutatorGenerator {
	
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		standalone = true
		var IProject project = ProjectUtils.project
		this.project = project !== null ? project : this.project
		var String projectFolderName = this.project !== null ? this.project.getLocation.toFile.getPath.replace("\\", "/") + "/" : ModelManager.getWorkspaceAbsolutePathWithProjectName + "/"	
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

		var File projectFolder = new File(projectFolderName)
		var File[] files = projectFolder.listFiles
		var MutatorEnvironment mutatorEnvironment = null
		fileURI = resource.URI
		for(e: resource.allContents.toIterable.filter(MutatorEnvironment)) {
			
			program = (e as MutatorEnvironment).definition as Program
			
			var String fileName = fileURI.lastSegment.replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_") + ".mutator"
			/* Write the EObject into a file */
			fileName = fileName.replace(".mutator", "Standalone.java")
			className = fileName.replace("Standalone.java", "Standalone")
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
     		fsa.generateFile("mutator/" + className + "/" + fileName, JavaUtils.format(e.compile(this.project), false))
     		mutatorEnvironment = e
		}
		
		if (fsa.isFile("mutator/" + this.project.name.replaceAll("[.]", "/") + "/" + this.project.name.replaceAll("[.]", "_") + "StandaloneLauncher.java")) {
			fsa.deleteFile("mutator/" + this.project.name.replaceAll("[.]", "/") + "/" + this.project.name.replaceAll("[.]", "_") + "StandaloneLauncher.java")
     	}
		fsa.generateFile("mutator/" + this.project.name.replaceAll("[.]", "/") + "/" + this.project.name.replaceAll("[.]", "_") + "StandaloneLauncher.java", JavaUtils.format(resource.allContents.toIterable.filter(MutatorEnvironment).toList().launcherStandalone(this.project), false))
	}
}