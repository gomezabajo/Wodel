package wodeledu.dsls.generator.moodle

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.EClass
import java.util.ArrayList
import java.io.File
import java.util.UUID
import wodel.utils.manager.ModelManager
import edutest.MultiChoiceText
import java.util.Collections
import java.util.LinkedHashSet
import java.text.NumberFormat
import java.util.Locale
import java.text.DecimalFormat
import edutest.Mode
import java.util.Set
import java.util.List
import edutest.Program
import wodeledu.dsls.generator.EduTestSuperGenerator
import org.eclipse.core.resources.IProject
import org.eclipse.emf.common.util.URI
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class EduTestMoodleGeneratorMultiChoiceText {
	var MultiChoiceText exercise
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
	def String setUpAndCompile(EduTestSuperGenerator generator, MultiChoiceText exercise, Program program, Resource resource, List<Integer> li, List<EClass> roots) {
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
<!-- «var int i = li.get(0)» -->
<!--«var int min = Integer.MAX_VALUE»-->
«FOR test : exercise.tests»
«FOR EClass eclass : generator.diagrams.get(exercise).get(test).keySet()»
«var int counter = generator.diagrams.get(exercise).get(test).get(eclass).size()»
«IF min > counter»
«{min = counter; ""}»
«ENDIF»
«ENDFOR»
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
«FOR test : exercise.tests»
«var String statement = generator.diagrams.get(exercise).get(test).get(statementClass) !== null ? generator.diagrams.get(exercise).get(test).get(statementClass).size() > 0 ? generator.diagrams.get(exercise).get(test).get(statementClass).get(0) : null : null»
«statement = statement === null ? generator.programs.get(exercise).get(test).get(statementClass) !== null ? generator.programs.get(exercise).get(test).get(statementClass).size() > 0 ? generator.programs.get(exercise).get(test).get(statementClass).get(0) : null : null»
«var String solution = generator.diagrams.get(exercise).get(test).get(answersClass) !== null ? generator.diagrams.get(exercise).get(test).get(answersClass).size() > 0 ? generator.diagrams.get(exercise).get(test).get(answersClass).get(0)»
«solution = solution === null ? generator.programs.get(exercise).get(test).get(answersClass) !== null ? generator.programs.get(exercise).get(test).get(answersClass).size() > 0 ? generator.programs.get(exercise).get(test).get(answersClass).get(0)»
«var List<String> answers = new ArrayList<String>()»
«var Set<String> answersSet = new LinkedHashSet<String>()»
«IF generator.diagrams.get(exercise).get(test).get(answersClass) !== null && generator.diagrams.get(exercise).get(test).get(answersClass).size() > 0»
«{answersSet.addAll(generator.diagrams.get(exercise).get(test).get(answersClass)); ""}»
«{answers.addAll(answersSet); ""}»
«{Collections.shuffle(answers); ""}»
<!--«var String diagram = workspacePath + "/" + projectName +  "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + statement»-->
«IF diagram.length > 0»
<!--«var File file = new File(diagram)»-->
«IF file.isFile && file.exists()»
«{diagram = diagram.substring(diagram.indexOf("/src-gen/html/") + "/src-gen/html/".length, diagram.length); ""}»
<question type="multichoice">
<name>
<text>Question «{i++; i;}»</text>
</name>
<questiontext format="html">
<!-- «var UUID uuid = UUID.randomUUID()»-->
<text><![CDATA[<p>«test.question.replace("\"", "'")»<br></p><p><img width="20%" height="20%" src="data:image/png;base64,«generator.getStringBase64(diagram)»"><br></p><!--<p><img src="@@PLUGINFILE@@/exercise_«uuid».png" alt="" width="30%" height="30%" role="presentation" class="img-responsive atto_image_button_text-bottom"><br></p>-->]]></text>
<!--<file name="exercise_«uuid».png" path="/" encoding="base64">«generator.getStringBase64(diagram)»</file>-->
</questiontext>
<generalfeedback format="html">
<text></text>
</generalfeedback>
<defaultgrade>1.0000000</defaultgrade>
<penalty>1.0000000</penalty>
<hidden>0</hidden>
<idnumber></idnumber>
«IF exercise.config.mode === Mode.RADIOBUTTON»
<single>true</single>
«ELSEIF exercise.config.mode === Mode.CHECKBOX»
<single>false</single>
«ENDIF»
<shuffleanswers>true</shuffleanswers>
<answernumbering>abc</answernumbering>
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
<!--«var int counter = 0»-->
<!--«var int solutions = 1»-->
<!--«var double fraction = 100.0 / solutions»-->
«{counter = 0; ""}»
«FOR String answer : answers»
<!--«var boolean s = false»-->
«FOR String sol : generator.solutionsMap.get(exercise)»
«IF answer.startsWith(sol + "/") 
|| answer.startsWith(sol + "\\")
|| answer.contains(sol + "/" + answersClass.name + "_")
|| answer.contains(sol + "\\" + answersClass.name + "_")»
«{s = true; ""}»
«ENDIF»
«ENDFOR»
«IF s == true»
«IF counter < min - 1»
«{counter++; ""}»
«{solutions++; ""}»
«ENDIF»
«ENDIF»
<!-- «uuid = UUID.randomUUID()»-->
«IF s || answer.equals(solution)»
«var String text = generator.getText((exercise as MultiChoiceText).config.identifier, ModelManager.getMetaModelPath() + "/" + test.source, resource)»
«IF 100 % solutions == 0»
<answer fraction="«100/solutions»" format="html">
«ELSE»
<!--«var DecimalFormat formatter = (NumberFormat.getNumberInstance(Locale.ENGLISH) as DecimalFormat)»-->
«{formatter.applyPattern("###.#####"); ""}»
<answer fraction="«formatter.format(fraction)»" format="html">
«ENDIF»
<text><![CDATA[<p>«text»<br></p><p><img width="20%" height="20%" src="data:image/png;base64,«generator.getStringBase64("diagrams/" + test.source.replace('.model', '') + "/" + answer)»"><br></p>]]></text>
<!--<text><![CDATA[<p>«text»</p><p><img src="@@PLUGINFILE@@/exercise_«uuid».png" alt="" width="15%" height="15%" role="presentation" class="img-responsive atto_image_button_text-bottom"><br></p>]]></text>-->
<!--<file name="exercise_«uuid».png" path="/" encoding="base64">«generator.getStringBase64("diagrams/" + test.source.replace('.model', '') + "/" + answer)»</file>-->
<feedback format="html">
<text></text>
</feedback>
</answer>
«ELSE»
«IF counter < min - 1»
«{counter++; ""}»
«var String text = generator.getText((exercise as MultiChoiceText).config.identifier, ModelManager.getOutputPath() + "/" + test.source.replace('.model', '') + "/" + diagram.replace(answersClass.name + "_", "").replace(answersClass.name + "_", "").replace(".png", ".model"), resource)»
<answer fraction="0" format="html">
<text><![CDATA[<p>«text»<br></p>]]></text>
<!--<text><![CDATA[<p>«text»<img src="@@PLUGINFILE@@/exercise_«uuid».png" alt="" width="15%" height="15%" role="presentation" class="img-responsive atto_image_button_text-bottom"><br></p>]]></text>
<file name="exercise_«uuid».png" path="/" encoding="base64">«generator.getStringBase64("diagrams/" + test.source.replace('.model', '') + "/" + answer)»</file>-->
<feedback format="html">
<text></text>
</feedback>
</answer>
«ENDIF»
«ENDIF»
«ENDFOR»
</question>
«ENDIF»
«ENDIF»
«ENDIF»
«IF generator.programs.get(exercise).get(test).get(answersClass) !== null && generator.programs.get(exercise).get(test).get(answersClass).size() > 0»
«{answersSet.addAll(generator.programs.get(exercise).get(test).get(answersClass)); ""}»
«{answers.addAll(answersSet); ""}»
«{Collections.shuffle(answers); ""}»
<!--«var String prog = workspacePath + "/" + projectName +  "/src-gen/html/code/" + test.source.replace('.model', '') + "/" + statement»-->
«IF prog.length > 0»
<!--«var File file = new File(prog)»-->
«IF file.isFile && file.exists()»
«{prog = prog.substring(prog.indexOf("/src-gen/html/") + "/src-gen/html/".length, prog.length); ""}»
<question type="multichoice">
<name>
<text>Question «{i++; i;}»</text>
</name>
<questiontext format="html">
<!-- «var UUID uuid = UUID.randomUUID()»-->
<text><![CDATA[<div>«test.question.replace("\"", "'")»<br><img src="@@PLUGINFILE@@/exercise_«uuid».png" alt="" width="30%" height="30%" role="presentation" class="img-responsive atto_image_button_text-bottom"><br></div>]]></text>
<text><![CDATA[<div>«generator.getPythonHtmlCode(prog)»</div>]]></text>
</questiontext>
<generalfeedback format="html">
<text></text>
</generalfeedback>
<defaultgrade>1.0000000</defaultgrade>
<penalty>1.0000000</penalty>
<hidden>0</hidden>
<idnumber></idnumber>
«IF exercise.config.mode === Mode.RADIOBUTTON»
<single>true</single>
«ELSEIF exercise.config.mode === Mode.CHECKBOX»
<single>false</single>
«ENDIF»
<shuffleanswers>true</shuffleanswers>
<answernumbering>abc</answernumbering>
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
<!--«var int counter = 0»-->
<!--«var int solutions = 1»-->
<!--«var double fraction = 100.0 / solutions»-->
«{counter = 0; ""}»
«FOR String answer : answers»
<!--«var boolean s = false»-->
«FOR String sol : generator.solutionsMap.get(exercise)»
«IF answer.startsWith(sol + "/") 
|| answer.startsWith(sol + "\\")
|| answer.contains(sol + "/" + answersClass.name + "_")
|| answer.contains(sol + "\\" + answersClass.name + "_")»
«{s = true; ""}»
«ENDIF»
«ENDFOR»
«IF s == true»
«IF counter < min - 1»
«{counter++; ""}»
«{solutions++; ""}»
«ENDIF»
«ENDIF»
<!-- «uuid = UUID.randomUUID()»-->
«IF s || answer.equals(solution)»
«IF 100 % solutions == 0»
<answer fraction="«100/solutions»" format="html">
«ELSE»
<!--«var DecimalFormat formatter = (NumberFormat.getNumberInstance(Locale.ENGLISH) as DecimalFormat)»-->
«{formatter.applyPattern("###.#####"); ""}»
<answer fraction="«formatter.format(fraction)»" format="html">
«ENDIF»
<text><![CDATA[<div>«generator.getPythonHtmlCode("code/" + test.source.replace('.model', '') + "/" + answer)»</div>]]></text>
<feedback format="html">
<text></text>
</feedback>
</answer>
«ELSE»
«IF counter < min - 1»
«{counter++; ""}»
<answer fraction="0" format="html">
<text><![CDATA[<div>«generator.getPythonHtmlCode("code/" + test.source.replace('.model', '') + "/" + answer)»</div>]]></text>
<feedback format="html">
<text></text>
</feedback>
</answer>
«ENDIF»
«ENDIF»
«ENDFOR»
</question>
«ENDIF»
«ENDIF»
«ENDIF»
«ENDFOR»
<!-- «li.set(0, i)» -->
	'''
}
