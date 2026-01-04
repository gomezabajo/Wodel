package wodel.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import wodel.utils.manager.ProjectUtils
import wodel.utils.manager.ModelManager
import java.io.File
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Program
import java.util.ArrayList
import java.util.List
import wodel.utils.manager.JavaUtils
import wodel.dsls.WodelUtils
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import java.util.Map
import java.util.LinkedHashMap

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the code to programmatically execute the Wodel program (dynamic mode).
 * 
 */
class WodelDynamicAPIGenerator extends WodelAPIGenerator {

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
		var String projectFolderName = this.project !== null ? this.project.getLocation.toFile.getPath.replace("\\", "/") + "/" : ModelManager.getWorkspaceAbsolutePathWithProjectName + "/"	
		var File projectFolder = new File(projectFolderName)
		var File[] files = projectFolder.listFiles
		var String mutatorName = ""
		//var List<String> mutators = ProjectUtils.getMutatorFiles(project).map[name.replace(".mutator", "")]
		fileURI = resource.URI
			var Map<String, List<String>> mutMap = new LinkedHashMap<String, List<String>>()
		for(e: resource.allContents.toIterable.filter(MutatorEnvironment)) {
			
			var String xTextFileName = getMutatorPath(e, this.project, files)
			program = (e as MutatorEnvironment).definition as Program
			xmiFileName = "file:/" + projectFolderName + program.output + fileURI.lastSegment.replaceAll(".mutator", ".model")
			WodelUtils.serialize(xTextFileName, xmiFileName)

			var String fileName = fileURI.lastSegment.replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_") + ".mutator"
			/* Write the EObject into a file */
			mutatorName = fileName.replaceAll(".mutator", "").replaceAll("[.]", "_");
			fileName = mutatorName.replaceAll("[.]", "_") + "DynamicAPI.java"
			className = fileName.replaceAll(".java", "")
			var String key = className.replace("DynamicAPI", "")
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
     		fsa.generateFile("mutator/" + mutatorName + "/" + fileName, JavaUtils.format(e.compile(this.project, mutatorName, className), false))
		}
		//if (fsa.isFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "/" + getProjectName.replaceAll("[.]", "_") + "APILauncher.java")) {
		//	fsa.deleteFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "/" + getProjectName.replaceAll("[.]", "_") + "APILauncher.java")
     	//}
		//fsa.generateFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "API/" + getProjectName.replaceAll("[.]", "_") + "APILauncher.java", JavaUtils.format(mutatorEnvironment.launcher(mutators), false))
	}
	
}