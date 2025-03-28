/*
 * generated by Xtext 2.30.0
 */
package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

import com.google.inject.Inject
import org.eclipse.core.runtime.Platform
import modeldraw.MutatorDraw
import wodel.utils.manager.ModelManager
import wodeledu.dsls.ModelDrawUtils
import wodel.utils.manager.ProjectUtils

/**
 * @author Pablo Gomez-Abajo - Main Model-Draw code generator.
 * 
 * It calls ModelDrawDotGenerator to generate the dot code for the models,
 * or ModelDrawCircuitGenerator to generate the m4 code for the circuit models. 
 */
class ModelDrawGenerator extends AbstractGenerator {

	@Inject ModelDrawDotGenerator dotGenerator
	@Inject ModelDrawCircuitGenerator circuitGenerator
	@Inject ModelDrawPlantUMLGenerator plantUMLGenerator
	
	private String fileName
	private String path
	private String xmiFileName

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		path = ProjectUtils.getProject !== null ? ProjectUtils.getProject.getLocation.toFile.getPath : ModelManager.getWorkspaceAbsolutePath	
		for(e: resource.allContents.toIterable.filter(MutatorDraw)) {
			
			
			fileName = resource.URI.lastSegment
			var xTextFileName = "file:/" + path + "/src/" + fileName
			xmiFileName = "file:/" + path + "/" + ModelManager.outputFolder + '/' + fileName.replaceAll(".draw", "_draw.model")
			ModelDrawUtils.serialize(xTextFileName, xmiFileName)
		}
		var String modelDrawMode = Platform.getPreferencesService().getString("wodeledu.dsls.EduTest", "Model-Draw mode", "Dot", null)
		if (modelDrawMode.equals("Dot")) {
			dotGenerator.doGenerate(resource, fsa, context)
		}
		if (modelDrawMode.equals("Circuit")) {
			circuitGenerator.doGenerate(resource, fsa, context)
		}
		if (modelDrawMode.equals("PlantUML")) {
			plantUMLGenerator.doGenerate(resource, fsa, context)
		}
	}
}
