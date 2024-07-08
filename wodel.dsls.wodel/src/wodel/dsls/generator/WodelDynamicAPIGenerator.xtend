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

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the code to programmatically execute the Wodel program (dynamic mode).
 * 
 */
class WodelDynamicAPIGenerator extends WodelAPIGenerator {

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		project = ProjectUtils.getProject()
		
		standalone = false
		var projectFolderName = ProjectUtils.getProject.getLocation.toFile.getPath + "/"
		var File projectFolder = new File(projectFolderName)
		var File[] files = projectFolder.listFiles
		var String mutatorName = ""
		//var List<String> mutators = getMutators(files)
		var MutatorEnvironment mutatorEnvironment = null
		for(e: resource.allContents.toIterable.filter(MutatorEnvironment)) {
			
			fileName = resource.URI.lastSegment
			var String xTextFileName = getMutatorPath(e, files)
			program = (e as MutatorEnvironment).definition as Program
			xmiFileName = "file:/" + ProjectUtils.getProject.getLocation.toFile.getPath + program.output + fileName.replaceAll(".mutator", ".model")
			try {
				WodelUtils.serialize(xTextFileName, xmiFileName)
			} catch (Exception ex) {}

			fileName = fileName.replaceAll(".model", "").replaceAll(".mutator", "").replaceAll("[.]", "_") + ".mutator"
			/* Write the EObject into a file */
			mutatorName = fileName.replaceAll(".mutator", "").replaceAll("[.]", "_");
			fileName = mutatorName.replaceAll("[.]", "_") + "DynamicAPI.java"
			className = fileName.replaceAll(".java", "")
			var int i = 1
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
     		fsa.generateFile("mutator/" + mutatorName + "/" + fileName, JavaUtils.format(e.compile(mutatorName, className), false))
     		mutatorEnvironment = e
		}
		//if (fsa.isFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "/" + getProjectName.replaceAll("[.]", "_") + "APILauncher.java")) {
		//	fsa.deleteFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "/" + getProjectName.replaceAll("[.]", "_") + "APILauncher.java")
     	//}
		//fsa.generateFile("mutator/" + getProjectName.replaceAll("[.]", "/") + "API/" + getProjectName.replaceAll("[.]", "_") + "APILauncher.java", JavaUtils.format(mutatorEnvironment.launcher(mutators), false))
	}
	
}