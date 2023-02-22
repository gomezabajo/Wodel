/*
 * generated by Xtext 2.13.0
 */
package wodel.dsls.generator

import mutatorenvironment.MutatorEnvironment
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import mutatorenvironment.Program
import java.io.File
import manager.ModelManager
import wodel.dsls.WodelUtils
import manager.JavaUtils
import org.eclipse.xtext.generator.IGeneratorContext
import java.util.List
import manager.ProjectUtils
import org.eclipse.emf.common.util.URI
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Platform
import org.eclipse.core.runtime.FileLocator

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the Java code for the mutations.
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class WodelStandaloneMutatorGenerator extends WodelMutatorGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		ProjectUtils.resetProject()
		project = ProjectUtils.getProject()
		
		path = ModelManager.getWorkspaceAbsolutePath(resource) + "/" + getProjectName
		
		standalone = true
		try {
			bundle = Platform.getBundle("wodel.models")
			metricsURL = FileLocator.resolve(bundle.getEntry("/models/MutatorMetrics.ecore")).getFile()
			mutatorURL = FileLocator.resolve(bundle.getEntry("/models/MutatorEnvironment.ecore")).getFile()
			ModelManager.saveMetricsEnvironmentBundle(resource, metricsURL)
			ModelManager.saveMutatorEnvironmentBundle(resource, mutatorURL)
		}
		catch (Exception ex) {
			metricsURL = ModelManager.getMetricsEnvironmentBundle(resource)
			mutatorURL = ModelManager.getMutatorEnvironmentBundle(resource)
		}

		var projectFolderName = ModelManager.getWorkspaceAbsolutePath(resource)+ "/" + getProjectName + "/"
		System.out.println("projectFolderName " + projectFolderName)
		var File projectFolder = new File(projectFolderName)
		var File[] files = projectFolder.listFiles
		var MutatorEnvironment mutatorEnvironment = null
		for(e: resource.allContents.toIterable.filter(MutatorEnvironment)) {
			
			fileName = resource.URI.lastSegment
			var String xTextFileName = getMutatorPath(e, files)
			program = (e as MutatorEnvironment).definition as Program
			xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath(resource) + "/" + getProjectName + "/" + program.output + fileName.replaceAll(".mutator", ".model")
			try {
				WodelUtils.serialize(xTextFileName, xmiFileName)
			} catch (Exception ex) {}

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