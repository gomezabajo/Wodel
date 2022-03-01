/*
 * generated by Xtext 2.13.0
 */
package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import manager.ModelManager
import modeltext.IdentifyElements
import wodeledu.dsls.ModelTextUtils
import org.eclipse.core.resources.IProject
import manager.ProjectUtils

/**
 * @author Pablo Gomez-Abajo - modelText code generator.
 * 
 * Serialization of the modelText code into an EMF XMI model
 *  
 */
class ModelTextGenerator extends AbstractGenerator {
	
	protected IProject project = ProjectUtils.getProject()
	
	private String fileName
	private String path
	private String xmiFileName
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		path = ModelManager.getWorkspaceAbsolutePath + '/' + project.name	

		for(e: resource.allContents.toIterable.filter(IdentifyElements)) {
			
			fileName = resource.URI.lastSegment
			var xTextFileName = "file:/" + path + "/src/" + fileName
			xmiFileName = "file:/" + path + '/' + ModelManager.outputFolder + '/' + fileName.replaceAll(".modeltext", "_modeltext.model")
			ModelTextUtils.serialize(xTextFileName, xmiFileName)
			/* Write the EObject into a file */
		}
	}
}
