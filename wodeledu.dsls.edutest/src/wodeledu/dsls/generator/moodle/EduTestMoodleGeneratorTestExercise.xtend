package wodeledu.dsls.generator.moodle

import wodeledu.dsls.generator.EduTestSuperGenerator
import edutest.MutatorTests
import wodel.utils.manager.ModelManager
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Platform
import org.osgi.framework.Bundle
import org.eclipse.core.runtime.FileLocator
import java.net.URL
import java.util.List
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import java.util.ArrayList
import edutest.Program
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import edutest.AlternativeResponse
import edutest.MultiChoiceDiagram
import edutest.MultiChoiceEmendation
import edutest.MatchPairs
import edutest.MultiChoiceText
import edutest.AlternativeText
import edutest.DragAndDropText
import edutest.MissingWords
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import mutatorenvironment.MutatorEnvironment
import com.google.inject.Inject

class EduTestMoodleGeneratorTestExercise extends EduTestSuperGenerator {
	
	@Inject EduTestMoodleGeneratorAlternativeResponse alternativeResponse
    @Inject EduTestMoodleGeneratorAlternativeText alternativeText
    @Inject EduTestMoodleGeneratorDragAndDropText dragAndDropText
    @Inject EduTestMoodleGeneratorMatchPairs matchPairs
    @Inject EduTestMoodleGeneratorMissingWords missingWords
    @Inject EduTestMoodleGeneratorMultiChoiceDiagram multiChoiceDiagram
    @Inject EduTestMoodleGeneratorMultiChoiceEmendation multiChoiceEmendation
    @Inject EduTestMoodleGeneratorMultiChoiceText multiChoiceText 

	private List<EPackage> metamodel
	private List<EClass> roots
	private List<EObject> blocks
	private List<EObject> mutators
	private String fileName
	private String pageName
	
	def void setUp(Resource resource) {
		project = projectOf(resource);
		projectPath = project !== null ? project.getLocation().toFile().getPath().replace("\\", "/") : null;
		outputFolder = ModelManager.getOutputFolder();
		projectName = project !== null ? project.getName() : null;
		workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString().replace("\\", "/");

		var xmiFileName = workspacePath + "/" + projectName +  "/" + outputFolder + "/" + resource.URI.lastSegment.replaceAll(".test", ".model")
		val Bundle bundle = Platform.getBundle("wodel.models")
	    val URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore")
	    val String mutatorecore = FileLocator.resolve(fileURL).getFile()
		val List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore)		
		val Resource mutatormodel = ModelManager.loadModel(mutatorpackages, xmiFileName)
		blocks = ModelManager.getObjectsOfType("Block", mutatormodel)
		mutators = ModelManager.getObjectsOfType("Mutator", mutatormodel)
	}
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		setUp(resource);
		var i = 0
		for(e: resource.allContents.toIterable.filter(Program)) {
			metamodel = new ArrayList<EPackage>()
			metamodel.addAll(ModelManager.loadMetaModel(e.metamodel))
			roots = new ArrayList<EClass>()
			roots.addAll(ModelManager.getRootEClasses(metamodel))
			if (i == 0) {
				fileName = 'xml/' + resource.URI.lastSegment.replaceAll(".test", "") + '.xml'
				pageName = resource.URI.lastSegment.replaceAll(".test", "") + '.xml'
			} else {
				fileName = 'xml/' + resource.URI.lastSegment.replaceAll(".test", "") + i + '.xml'
				pageName = resource.URI.lastSegment.replaceAll(".test", "") + i + '.xml'
			}
			fsa.generateFile(fileName, e.compile(resource, fileName, fsa, context))
			i++
		}
	}

	def compile(Program program, Resource resource, String fileName, IFileSystemAccess2 fsa, IGeneratorContext context) '''
«{buildOptions(program, resource, blocks, roots, program.class); ""}»
<?xml version="1.0" encoding="UTF-8"?>
<!--«var EObject main = null»-->
«IF blocks.size() > 0»
«{main = blocks.get(0); ""}»
«ELSE»
«IF mutators.size() > 0»
«{main = mutators.get(0); ""}»
«ENDIF»
«ENDIF»
<!--«var List<EPackage> packages = ModelManager.loadMetaModel((main.eContainer as MutatorEnvironment).definition.metamodel)»-->
<!--«var String domain = packages.get(0).getNsURI().replace("http://", "")»-->
<!--«domain = domain.substring(0, domain.lastIndexOf("/")).replace("/", "")»-->
<quiz>
<question type="category">
<category>
<text>$course$/top/«domain»</text>
</category>
<info format="moodle_auto_format">
<text>Default category in the context of deterministic finite automata.</text>
<!--<text>Categoria por defecto para preguntas compartidas en el contexto Aut&#243;matas.</text>-->
</info>
<idnumber></idnumber>

</question>


«var int i = 0»
<!--«var List<Integer> li = new ArrayList<Integer>()»-->
«{li.add(0, i); "";}»
«FOR MutatorTests exercise : program.exercises»
«IF exercise instanceof AlternativeResponse»
«{var String xmlCode = alternativeResponse.setUpAndCompile(this, exercise, program, resource, li, roots); xmlCode }»
«ENDIF»
«IF exercise instanceof MultiChoiceDiagram»
«{var String xmlCode = multiChoiceDiagram.setUpAndCompile(this, exercise, program, resource, li, roots); xmlCode }»
«ENDIF»
«IF exercise instanceof MultiChoiceEmendation»
«{var String xmlCode = multiChoiceEmendation.setUpAndCompile(this, exercise, program, resource, li, roots); xmlCode }»
«ENDIF»
«IF exercise instanceof MatchPairs»
«{var String xmlCode = matchPairs.setUpAndCompile(this, exercise, program, resource, li, roots); xmlCode }»
«ENDIF»
«IF exercise instanceof MissingWords»
«{var String xmlCode = missingWords.setUpAndCompile(this, exercise, program, resource, li, roots); xmlCode }»
«ENDIF»
«IF exercise instanceof MultiChoiceText»
«{var String xmlCode = multiChoiceText.setUpAndCompile(this, exercise, program, resource, li, roots); xmlCode }»
«ENDIF»
«IF exercise instanceof AlternativeText»
«{var String xmlCode = alternativeText.setUpAndCompile(this, exercise, program, resource, li, roots); xmlCode }»
«ENDIF»
«IF exercise instanceof DragAndDropText»
«{var String xmlCode = dragAndDropText.setUpAndCompile(this, exercise, program, resource, li, roots); xmlCode }»
«ENDIF»
«ENDFOR»
</quiz>
	'''
	
}