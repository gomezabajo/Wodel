package wodeledu.dsls.generator.moodle

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.EClass
import java.util.List
import edutest.AlternativeResponse
import edutest.Program
import wodeledu.dsls.generator.EduTestSuperGenerator
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import wodel.utils.manager.ModelManager
import edutest.Test
import java.util.ArrayList
import java.util.Set
import java.util.LinkedHashSet
import java.util.Collections
import java.io.File
import java.util.UUID

class EduTestMoodleGeneratorAlternativeResponse {
	var AlternativeResponse exercise
	var IProject project
	var String projectPath
	var String outputFolder
	var String projectName
	var String workspacePath
	var EduTestSuperGenerator generator
	var Program program
	var List<Integer> li
	var List<EClass> roots
	
	def protected static IProject projectOf(Resource r) {
		var URI uri = r.getURI()
		if (uri !== null && uri.isPlatformResource()) {
			var String projectName = uri.segment(1)
			return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName)
		}
		return null
	}
	
	def String setUpAndCompile(EduTestSuperGenerator generator, AlternativeResponse exercise, Program program, Resource resource, List<Integer> li, List<EClass> roots) {
		this.project = projectOf(resource)
		this.projectPath = (project !== null) ? project.getLocation().toFile().getPath().replace("\\", "/") : null
		this.outputFolder = ModelManager.getOutputFolder()
		this.projectName = project !== null ? project.getName() : null
		this.workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString().replace("\\", "/")
		this.generator = generator
		this.exercise = exercise
		this.program = program
		this.li = li
		this.roots = roots
		return resource.compile().toString()		
	}

	def compile(Resource resource) '''
<!-- «var EClass answersClass = null»-->
<!-- «var EClass statementClass = null»-->
«FOR EClass root : roots»
«IF exercise.config.answers !== null && exercise.config.answers.size() > 0»
«IF exercise.config.answers.get(0).name.equals(root.name)»
«{answersClass = root; ""}»
«ENDIF»
«ELSEIF exercise.config.answers !== null && exercise.config.answers.size() === 0»
«{answersClass = root; ""}»
«ENDIF»
«IF exercise.config.statement !== null && exercise.config.statement.size() > 0»
«IF exercise.config.statement.get(0).name.equals(root.name)»
«{statementClass = root; ""}»
«ENDIF»
«ELSEIF exercise.config.statement !== null && exercise.config.statement.size() === 0»
«{statementClass = root; ""}»
«ENDIF»
«ENDFOR»
«IF answersClass === null»
«{answersClass = roots.get(roots.size() - 1); ""}»
«ENDIF»
«IF statementClass === null»
«IF roots.size() > 1»
«{statementClass = roots.get(1); ""}»
«ELSE»
«{statementClass = roots.get(0); ""}»
«ENDIF»
«ENDIF»
«FOR Test test : exercise.tests»
«var String statement = generator.diagrams.get(exercise).get(test).get(statementClass) !== null ? generator.diagrams.get(exercise).get(test).get(statementClass).size() > 0 ? generator.diagrams.get(exercise).get(test).get(statementClass).get(0)»
«var String solution = generator.diagrams.get(exercise).get(test).get(answersClass) !== null ? generator.diagrams.get(exercise).get(test).get(answersClass).size() > 0 ? generator.diagrams.get(exercise).get(test).get(answersClass).get(0)»
«var List<String> answers = new ArrayList<String>()»
«var Set<String> answersSet = new LinkedHashSet<String>()»
«IF generator.diagrams.get(exercise).get(test).get(answersClass) !== null && generator.diagrams.get(exercise).get(test).get(answersClass).size() > 0»
«{answersSet.addAll(generator.diagrams.get(exercise).get(test).get(answersClass)); ""}»
«{answers.addAll(answersSet); ""}»
«{Collections.shuffle(answers); ""}»
«IF answers.size() > 0»
<!-- «var String diagram = answers.get(0)»-->
<!--«var File file = new File(workspacePath + "/" + projectName +  "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram)»-->
«IF file.isFile && file.exists()»
<question type="truefalse">
<name>
<text><![CDATA[<p>«test.question.replace("\"", "'")»<br></p>]]></text>
</name>
<questiontext format="html">
<!-- «var UUID uuid = UUID.randomUUID()»-->
<text><![CDATA[<p>«test.question.replace("\"", "'")»<br></p><p><img width="20%" height="20%" src="data:image/png;base64,«generator.getStringBase64("diagrams/" + test.source.replace('.model', '') + "/" + statement)»"><img width="20%" height="20%" src="data:image/png;base64,«generator.getStringBase64("diagrams/" + test.source.replace('.model', '') + "/" + diagram)»"><br></p><!--<p><img src="@@PLUGINFILE@@/exercise_«uuid».png" alt="«test.question.replace("\"", "'")»" width="20%" height="20%" class="img-responsive atto_image_button_text-bottom"><br></p>-->]]></text>
</questiontext>
<generalfeedback format="html">
<text></text>
</generalfeedback>
<defaultgrade>1.0000000</defaultgrade>
<penalty>1.0000000</penalty>
<hidden>0</hidden>
<idnumber></idnumber>
«IF diagram.equals(solution.replace(".model", ".png"))»
<answer fraction="100" format="moodle_auto_format">
<text>true</text>
<feedback format="html">
<text></text>
</feedback>
</answer>
<answer fraction="0" format="moodle_auto_format">
<text>false</text>
<feedback format="html">
<text></text>
</feedback>
</answer>
«ELSE»
<answer fraction="0" format="moodle_auto_format">
<text>true</text>
<feedback format="html">
<text></text>
</feedback>
</answer>
<answer fraction="100" format="moodle_auto_format">
<text>false</text>
<feedback format="html">
<text></text>
</feedback>
</answer>
«ENDIF»
«ENDIF»
</question>
«ENDIF»
«ENDIF»
«ENDFOR»	
	'''
	
}
