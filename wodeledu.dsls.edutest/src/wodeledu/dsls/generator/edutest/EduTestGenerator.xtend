/*
 * generated by Xtext 2.30.0
 */
package wodeledu.dsls.generator.edutest

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.core.runtime.Platform
import wodel.utils.manager.ProjectUtils
import wodel.utils.manager.ModelManager
import wodeledu.dsls.EduTestUtils
import edutest.Program

/**
 * @author Pablo Gomez-Abajo - Main Wodel-Edu code generator.
 * 
 * It calls WodelMutatorGenerator to generate the Java code for the mutations,
 * and WodelUseGenerator to generate the USE code for the seeds synthesizer. 
 */
/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class EduTestGenerator extends AbstractGenerator {

	@Inject EduTestWebGenerator webGenerator
	@Inject EduTestMoodleGenerator moodleGenerator
	@Inject EduTestAndroidAppGenerator androidAppGenerator
	@Inject EduTestiOSAppGenerator iOSAppGenerator
	
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var String path = ProjectUtils.getProject !== null ? ProjectUtils.getProject.getLocation.toFile.getPath : null	
		for(e: resource.allContents.toIterable.filter(Program)) {
			
			
			var String fileName = resource.URI.lastSegment
			var String xTextFileName = "file:/" + path + "/src/" + fileName
			var String xmiFileName = "file:/" + path + "/" + ModelManager.outputFolder + '/' + fileName.replaceAll(".test", "_test.model")
			EduTestUtils.serialize(xTextFileName, xmiFileName)
		}
		var String eduTestMode = Platform.getPreferencesService().getString("wodeledu.dsls.EduTest", "Wodel-Edu mode", "", null)
		if (eduTestMode.equals("Web")) {
			webGenerator.doGenerate(resource, fsa, context)
		}
		if (eduTestMode.equals("Moodle")) {
			moodleGenerator.doGenerate(resource, fsa, context)
		}
		if (eduTestMode.equals("AndroidApp")) {
			androidAppGenerator.doGenerate(resource, fsa, context)
		}
		if (eduTestMode.equals("iOSApp")) {
			iOSAppGenerator.doGenerate(resource, fsa, context)
		}
	}
}
