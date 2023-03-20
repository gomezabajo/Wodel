/*
 * generated by Xtext 2.30.0
 */
package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.core.resources.IProject
import wodel.utils.manager.ProjectUtils
import wodel.utils.manager.ModelManager
import mutatext.Configuration
import wodeledu.dsls.MutaTextUtils

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class MutaTextGenerator extends AbstractGenerator {

	protected IProject project = null
	
	private String fileName
	private String path
	private String xmiFileName
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		ProjectUtils.resetProject()
		project = ProjectUtils.getProject()
		path = ModelManager.getWorkspaceAbsolutePath + '/' + project.name	

		for(e: resource.allContents.toIterable.filter(Configuration)) {
			
			fileName = resource.URI.lastSegment
			var xTextFileName = "file:/" + path + "/src/" + fileName
			xmiFileName = "file:/" + path + '/' + ModelManager.outputFolder + '/' + fileName.replaceAll(".mutatext", "_mutatext.model")
			MutaTextUtils.serialize(xTextFileName, xmiFileName)
			/* Write the EObject into a file */
		}
	}
}
