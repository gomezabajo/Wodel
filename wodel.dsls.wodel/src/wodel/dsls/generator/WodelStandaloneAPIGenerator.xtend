package wodel.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import wodel.utils.manager.ProjectUtils
import wodel.utils.manager.ModelManager
import java.io.File
import java.util.ArrayList
import java.util.List
import mutatorenvironment.MutatorEnvironment
import wodel.utils.manager.JavaUtils
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject
import java.util.Map
import java.util.LinkedHashMap

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the code to programmatically execute the Wodel program (standalone mode).
 * 
 */
class WodelStandaloneAPIGenerator extends WodelAPIGenerator {
	var Map<String, List<String>> mutMap = new LinkedHashMap<String, List<String>>()

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		standalone = true
		var IProject project = ProjectUtils.project
		this.project = project !== null ? project : this.project
		var String projectFolderName = this.project !== null ? this.project.getLocation.toFile.getPath.replace("\\", "/") + "/" : ModelManager.getWorkspaceAbsolutePathWithProjectName + "/"	
		var File projectFolder = new File(projectFolderName)
		var File[] files = projectFolder.listFiles
		var String mutatorName = ""
		var MutatorEnvironment mutatorEnvironment = null
		fileURI = resource.URI
		for(e: resource.allContents.toIterable.filter(MutatorEnvironment)) {
			
			program = (e as MutatorEnvironment).definition as Program

			var String fileName = fileURI.lastSegment.replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_") + ".mutator"
			/* Write the EObject into a file */
			mutatorName = fileName.replaceAll(".mutator", "").replaceAll("[.]", "_");
			fileName = mutatorName.replaceAll("[.]", "_") + "StandaloneAPI.java"
			className = fileName.replaceAll(".java", "")
			var String key = className.replace("StandaloneAPI", "")
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
     		fsa.generateFile("mutator/" + mutatorName + "/" + fileName, JavaUtils.format(e.compile(project, mutatorName, className), false))
     		mutatorEnvironment = e
		}
		if (fsa.isFile("mutator/" + project.name.replaceAll("[.]", "/") + "/" + project.name.replaceAll("[.]", "_") + "StandaloneAPILauncher.java")) {
			fsa.deleteFile("mutator/" + project.name.replaceAll("[.]", "/") + "/" + project.name.replaceAll("[.]", "_") + "StandaloneAPILauncher.java")
     	}
		fsa.generateFile("mutator/" + project.name.replaceAll("[.]", "/") + "/" + project.name.replaceAll("[.]", "_") + "StandaloneAPILauncher.java", JavaUtils.format(resource.allContents.toIterable.filter(MutatorEnvironment).toList().launcherStandalone(this.project, mutMap), false))
	}
}