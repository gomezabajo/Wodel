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
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the Java code for the mutations (dynamic mode).
 * 
 */
class WodelDynamicMutatorGenerator extends WodelMutatorGenerator {
	def static IProject projectOf(Resource r) {
		val uri = r?.URI
		if (uri !== null && uri.platformResource) {
			val projectName = uri.segment(1) // platform:/resource/<project>/...
			return ResourcesPlugin.workspace.root.getProject(projectName)
		}
		null
	}

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		standalone = false
		var IProject project = projectOf(resource)
		this.project = project !== null ? project : ProjectUtils.project
		
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

		var String projectFolderName = this.project !== null ? this.project.getLocation.toFile.getPath.replace("\\", "/") + "/" : ModelManager.getWorkspaceAbsolutePathWithProjectName + "/"	
		var File projectFolder = new File(projectFolderName)
		var File[] files = projectFolder.listFiles
		var MutatorEnvironment mutatorEnvironment = null
		fileURI = resource.URI
		for(e: resource.allContents.toIterable.filter(MutatorEnvironment)) {
			
			program = (e as MutatorEnvironment).definition as Program
			
			var String fileName = fileURI.lastSegment.replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_") + ".mutator"
			/* Write the EObject into a file */
			fileName = fileName.replace(".mutator", "Dynamic.java")
			className = fileName.replace("Dynamic.java", "Dynamic")
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
		
		var List<String> mutators = ProjectUtils.getMutatorFiles(this.project).map[name.replace(".mutator", "")]
		
		if (fsa.isFile("mutator/" + this.project.name.replaceAll("[.]", "/") + "/" + this.project.name.replaceAll("[.]", "_") + "DynamicLauncher.java")) {
			fsa.deleteFile("mutator/" + this.project.name.replaceAll("[.]", "/") + "/" + this.project.name.replaceAll("[.]", "_") + "DynamicLauncher.java")
     	}
		fsa.generateFile("mutator/" + this.project.name.replaceAll("[.]", "/") + "/" + this.project.name.replaceAll("[.]", "_") + "DynamicLauncher.java", JavaUtils.format(mutatorEnvironment.launcherDynamic(this.project, mutators), false))
	}
}