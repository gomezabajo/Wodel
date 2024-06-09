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
import wodel.dsls.WodelUtils
import wodel.utils.manager.JavaUtils
import mutatorenvironment.Program

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the code to programmatically execute the Wodel program (standalone mode).
 * 
 */
class WodelStandaloneAPIGenerator extends WodelAPIGenerator {
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		ProjectUtils.resetProject()
		project = ProjectUtils.getProject()
		
		standalone = true
		var projectFolderName = ModelManager.getWorkspaceAbsolutePath(resource)+ "/" + getProjectName + "/"
		var File projectFolder = new File(projectFolderName)
		var File[] files = projectFolder.listFiles
		var String mutatorName = ""
		var List<String> mutators = getMutators(files)
		var MutatorEnvironment mutatorEnvironment = null
		for(e: resource.allContents.toIterable.filter(MutatorEnvironment)) {
			
			fileName = resource.URI.lastSegment
			program = (e as MutatorEnvironment).definition as Program

			fileName = fileName.replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_") + ".mutator"
			/* Write the EObject into a file */
			mutatorName = fileName.replaceAll(".mutator", "").replaceAll("[.]", "_");
			fileName = mutatorName.replaceAll("[.]", "_") + "StandaloneAPI.java"
			className = fileName.replaceAll(".java", "")
			var int i = 1
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
     		fsa.generateFile("mutator/" + mutatorName + "/" + fileName, JavaUtils.format(e.compile(mutatorName, className), false))
     		mutatorEnvironment = e
		}
		if (fsa.isFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "/" + getProjectName.replaceAll("[.]", "_") + "StandaloneAPILauncher.java")) {
			fsa.deleteFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "/" + getProjectName.replaceAll("[.]", "_") + "StandaloneAPILauncher.java")
     	}
		fsa.generateFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "/" + getProjectName.replaceAll("[.]", "_") + "StandaloneAPILauncher.java", JavaUtils.format(mutatorEnvironment.launcher(mutators), false))
	}
}