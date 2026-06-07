package wodeledu.dsls.generator.moodle

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.EClass
import java.util.List
import wodel.utils.manager.ModelManager
import edutest.Program
import wodeledu.dsls.generator.EduTestSuperGenerator
import org.eclipse.core.resources.IProject
import org.eclipse.emf.common.util.URI
import org.eclipse.core.resources.ResourcesPlugin
import edutest.MissingWords
import edutest.Test
import wodeledu.dsls.generator.TestOption
import wodeledu.dsls.generator.ComparableSimpleEntry
import java.util.AbstractMap.SimpleEntry
import java.io.File
import java.util.UUID

class EduTestMoodleGeneratorMissingWords {
	var MissingWords exercise
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
	def String setUpAndCompile(EduTestSuperGenerator generator, MissingWords exercise, Program program, Resource resource, List<Integer> li, List<EClass> roots) {
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
«FOR Test test : exercise.tests»
<!-- «var int k = 0»-->
<!-- «var int solution = 0»-->
<!-- «var String textWithGaps = ""»-->
<!-- «var TestOption op = null»-->
«IF generator.options.get(exercise).get(test).size() > 0»
«var int rndIndex = ModelManager.getRandomIndex(generator.options.get(exercise).get(test))»
«FOR TestOption opt : generator.options.get(exercise).get(test).get(rndIndex)»
«IF opt.path.contains(exercise.markedBlocks.get(0).block.name)»
<!--«op = opt»-->
«ENDIF»
«ENDFOR»
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
«IF op !== null»
<!-- «var String diagram = op.path»-->
<!-- «var String code = op.path.replace("diagram/", "code/")»-->
<!-- «var UUID uuid = UUID.randomUUID()»-->
«IF op.options !== null»
«FOR String key : op.options.keySet()»
<!-- «var int tmp = k»-->
<!--«var String opWithGaps = ""»-->
«FOR String text : op.text.get(key)»
<!--«k++»-->
<!--«opWithGaps += text + "%" + k + " "»-->
«ENDFOR»
<!-- «k = tmp»-->
<!-- «var List<ComparableSimpleEntry<String, SimpleEntry<EClass, SimpleEntry<String, SimpleEntry<Integer, Boolean>>>>> entries = op.options.get(key)»-->
«FOR ComparableSimpleEntry<String, SimpleEntry<EClass, SimpleEntry<String, SimpleEntry<Integer, Boolean>>>> entry : entries»
<!--«solution++»-->
«IF entry.getValue().getValue().getValue().getValue() == true»
<!-- «k++»-->
<!-- «opWithGaps = opWithGaps.replace("%" + k, "[[" + solution + "]]")»-->
«ENDIF»
«ENDFOR»
<!-- «k++»-->
<!-- «opWithGaps = opWithGaps.replace(" %" + k, "")»-->
<!-- «textWithGaps += opWithGaps.trim() + ".<br>"»-->
«ENDFOR»
«IF diagram.length > 0»
<!--«var String data = diagram.substring(diagram.indexOf("/data/out/") + ("/data/out/").length, diagram.lastIndexOf("/"))»-->
<!--«var String model = data.substring(0, data.lastIndexOf("/"))»-->
<!--«var String mutOperator = data.substring(data.indexOf(model + "/") + (model + "/").length(), data.length())»-->
<!--«{diagram = "diagrams/" + model + "/" + mutOperator + "/" + statementClass.name + "_" + diagram.substring(diagram.lastIndexOf("/") + 1, diagram.length())}»-->
<!--«{code = "code/" + model + "/" + mutOperator + "/" + statementClass.name + "_" + code.substring(code.lastIndexOf("/") + 1, code.length()).replace(".png", ".py")}»-->
<!--«var File file = new File(workspacePath + "/" + projectName +  "/src-gen/html/" + diagram)»-->
«IF file.isFile && file.exists()»
<question type="gapselect">
<name>
<text><![CDATA[<p>«test.question.replace("\"", "'")»<br></p>]]></text>
</name>
<questiontext format="html">
<text><![CDATA[<p>«test.question.replace("\"", "'")»<br></p><p>«textWithGaps.trim()»<br></p><p><img width="20%" height="20%" src="data:image/png;base64,«generator.getStringBase64(diagram)»"><br></p><!--<p><img src="@@PLUGINFILE@@/exercise_«uuid».png" alt="" width="20%" height="20%" role="presentation" class="img-responsive atto_image_button_text-bottom"><br><br></p><p>«textWithGaps.trim()»<br></p>-->]]></text>
<!--<file name="exercise_«uuid».png" path="/" encoding="base64">«generator.getStringBase64(diagram)»</file>-->
</questiontext>
<generalfeedback format="html">
<text></text>
</generalfeedback>
<defaultgrade>1.0000000</defaultgrade>
<penalty>0.3333333</penalty>
<hidden>0</hidden>
<idnumber></idnumber>
<shuffleanswers>0</shuffleanswers>
<correctfeedback format="html">
<!--<text>Respuesta correcta</text>-->
<text>Right answer.</text>
</correctfeedback>
<partiallycorrectfeedback format="html">
<!--<text>Respuesta parcialmente correcta.</text>-->
<text>Partially right answer.</text>
</partiallycorrectfeedback>
<incorrectfeedback format="html">
<!--<text>Respuesta incorrecta.</text>-->
<text>Wrong answer.</text>
</incorrectfeedback>
<shownumcorrect/>
«FOR String key : op.options.keySet()»
<!-- «var List<ComparableSimpleEntry<String, SimpleEntry<EClass, SimpleEntry<String, SimpleEntry<Integer, Boolean>>>>> entries = op.options.get(key)»-->
«FOR ComparableSimpleEntry<String, SimpleEntry<EClass, SimpleEntry<String, SimpleEntry<Integer, Boolean>>>> entry : entries»
<selectoption>
<text>«entry.getKey().trim()»</text>
<group>«entry.getValue().getValue().getValue().getKey()»</group>
</selectoption>
«ENDFOR»
«ENDFOR»
</question>
«ELSE»
<!--«file = new File(workspacePath + "/" + projectName +  "/src-gen/html/" + code)»-->
«IF file.isFile && file.exists()»
<question type="gapselect">
<name>
<text><![CDATA[<p>«test.question.replace("\"", "'")»<br></p>]]></text>
</name>
<questiontext format="html">
<text><![CDATA[<p>«test.question.replace("\"", "'")»<br></p><p>«textWithGaps.trim()»<br></p><p>«generator.getPythonHtmlCode(code)»</p>]]></text>
</questiontext>
<generalfeedback format="html">
<text></text>
</generalfeedback>
<defaultgrade>1.0000000</defaultgrade>
<penalty>0.3333333</penalty>
<hidden>0</hidden>
<idnumber></idnumber>
<shuffleanswers>0</shuffleanswers>
<correctfeedback format="html">
<!--<text>Respuesta correcta</text>-->
<text>Right answer.</text>
</correctfeedback>
<partiallycorrectfeedback format="html">
<!--<text>Respuesta parcialmente correcta.</text>-->
<text>Partially right answer.</text>
</partiallycorrectfeedback>
<incorrectfeedback format="html">
<!--<text>Respuesta incorrecta.</text>-->
<text>Wrong answer.</text>
</incorrectfeedback>
<shownumcorrect/>
«FOR String key : op.options.keySet()»
<!-- «var List<ComparableSimpleEntry<String, SimpleEntry<EClass, SimpleEntry<String, SimpleEntry<Integer, Boolean>>>>> entries = op.options.get(key)»-->
«FOR ComparableSimpleEntry<String, SimpleEntry<EClass, SimpleEntry<String, SimpleEntry<Integer, Boolean>>>> entry : entries»
<selectoption>
<text>«entry.getValue().getValue().getKey().trim()»</text>
<group>«entry.getValue().getValue().getValue().getKey()»</group>
</selectoption>
«ENDFOR»
«ENDFOR»
</question>
«ENDIF»
«ENDIF»
«ENDIF»
«ENDIF»
«ENDIF»
«ENDIF»
«ENDFOR»
'''
}