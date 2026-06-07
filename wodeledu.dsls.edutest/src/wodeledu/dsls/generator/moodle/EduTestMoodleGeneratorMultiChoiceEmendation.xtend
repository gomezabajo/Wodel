package wodeledu.dsls.generator.moodle

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.EClass
import java.util.List
import java.util.ArrayList
import java.util.Collections
import java.io.File
import java.util.UUID
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale
import edutest.MultiChoiceEmendation
import java.util.Map
import edutest.Test
import java.util.AbstractMap.SimpleEntry
import wodel.utils.manager.ModelManager
import java.util.LinkedHashMap
import wodel.utils.manager.HTMLUtils
import edutest.Program
import wodeledu.dsls.generator.EduTestSuperGenerator
import org.eclipse.core.resources.IProject
import org.eclipse.emf.common.util.URI
import org.eclipse.core.resources.ResourcesPlugin
import wodeledu.dsls.generator.TestOption
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

class EduTestMoodleGeneratorMultiChoiceEmendation {
 	var MultiChoiceEmendation exercise
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
	def String setUpAndCompile(EduTestSuperGenerator generator, MultiChoiceEmendation exercise, Program program, Resource resource, List<Integer> li, List<EClass> roots) {
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
<!--«var Map<Test, List<SimpleEntry<String, Boolean>>> mapTextOptions = new LinkedHashMap<Test, List<SimpleEntry<String, Boolean>>>()»-->
<!--«var int min = Integer.MAX_VALUE»-->
<!--«var int rndIndex = -1»-->
«FOR Test test : exercise.tests»
«var Test t = test»
«IF generator.options.get(exercise) !== null && generator.options.get(exercise).get(test) !== null»
«var int counter = 0»
«{rndIndex = ModelManager.getRandomIndex(generator.options.get(exercise).get(test)); ""}»
«var List<SimpleEntry<String, Boolean>> textOptions = new ArrayList<SimpleEntry<String, Boolean>>()»
«IF generator.options.get(exercise).get(test).size() > 0»
«FOR TestOption opt : generator.options.get(exercise).get(test).get(rndIndex)»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
«var boolean found = false»
«FOR SimpleEntry<String, Boolean> entry : textOptions»
«IF entry.getKey().equals(text)»
«{found = true; ""}»
«ENDIF»
«ENDFOR»
«IF found == false»
«{counter ++; ""}»
«{textOptions.add(new SimpleEntry<String, Boolean>(text, false)); ""}»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ENDFOR»
«{mapTextOptions.put(test, textOptions); ""}»
«IF min > counter»
«{min = counter; ""}»
«ENDIF»
«ENDIF»
«ENDIF»
<!-- «var EClass answersClass = null»-->
<!-- «var List<EClass> statementClass = new ArrayList<EClass>()»-->
«FOR EClass root : roots»
«IF exercise.config.answers !== null && exercise.config.answers.size() > 0»
«IF exercise.config.answers.get(0).name.equals(root.name)»
«{answersClass = root; ""}»
«ENDIF»
«ELSEIF exercise.config.answers !== null && exercise.config.answers.size() === 0»
«{answersClass = root; ""}»
«ENDIF»
«IF exercise.config.statement !== null && exercise.config.statement.size() > 0»
«FOR EClass st : exercise.config.statement»
«IF st.name.equals(root.name)»
«{statementClass.add(root); ""}»
«ENDIF»
«ENDFOR»
«ELSEIF exercise.config.statement !== null && exercise.config.statement.size() === 0»
«{statementClass.add(root); ""}»
«ENDIF»
«ENDFOR»
«IF answersClass === null»
«{answersClass = roots.get(roots.size() - 1); ""}»
«ENDIF»
«IF statementClass === null»
«IF roots.size() > 1»
«{statementClass.add(roots.get(1)); ""}»
«ELSE»
«{statementClass.add(roots.get(0)); ""}»
«ENDIF»
«ENDIF»
«IF generator.options.get(exercise) !== null && generator.options.get(exercise).get(t) !== null»
<!--«var List<String> diagrams = new ArrayList<String>()»-->
<!--«var List<String> codes = new ArrayList<String>()»-->
<!--«var List<TestOption> answersOptions = new ArrayList<TestOption>()»-->
<!--«var List<String> wrongDiagrams = new ArrayList<String>()»-->
<!--«var List<String> wrongCodes = new ArrayList<String>()»-->
<!--«var List<TestOption> wrongOptions = new ArrayList<TestOption>()»-->
<!--«var List<TestOption> selectedOptions = new ArrayList<TestOption>()»-->
«IF (generator.options.get(exercise).get(t) !== null)»
«IF generator.options.get(exercise).get(t).size() > 0»
«FOR TestOption opt : generator.options.get(exercise).get(t).get(rndIndex)»
«IF opt.text.size > 0»
«IF opt.solution == true»
<!--«diagrams.add(opt.path)»-->
<!--«codes.add(opt.path.replace(".png", ".py"))»-->
<!--«answersOptions.add(opt)»-->
«ENDIF»
«ENDIF»
«ENDFOR»
«FOR TestOption opt : generator.options.get(exercise).get(t).get(rndIndex)»
«IF opt.text.size > 0»
«IF opt.solution == false»
<!--«wrongDiagrams.add(opt.path)»-->
<!--«wrongCodes.add(opt.path.replace(".png", ".py"))»-->
<!--«wrongOptions.add(opt)»-->
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDIF»
«ENDIF»
«{{selectedOptions.addAll(answersOptions)}; ""}»
«{{selectedOptions.addAll(wrongOptions)}; ""}»
«{Collections.shuffle(selectedOptions); ""}»
«IF diagrams.size() > 0»
<!--«var int rndSolution = -1»-->
«{rndSolution = ModelManager.getRandomIndex(diagrams); ""}»
<!--«var List<String> diagram = new ArrayList<String>()»-->
<!--«var List<String> code = new ArrayList<String>()»-->
<!--«var String d = diagrams.get(rndSolution)»-->
<!--«var String c = codes.get(rndSolution)»-->
«IF d.length > 0 || c.length > 0»
<!--«var String data = d.substring(d.indexOf("/data/out/") + ("/data/out/").length, d.lastIndexOf("/"))»-->
<!--«var String cdata = c.substring(c.indexOf("/data/out/") + ("/data/out/").length, c.lastIndexOf("/"))»-->
<!--«var String model = data.substring(0, data.lastIndexOf("/"))»-->
<!--«var String cmodel = cdata.substring(0, cdata.lastIndexOf("/"))»-->
<!--«var String mutOperator = data.substring(data.indexOf(model + "/") + (model + "/").length(), data.length())»-->
<!--«var String cmutOperator = cdata.substring(cdata.indexOf(cmodel + "/") + (cmodel + "/").length(), cdata.length())»-->
<!--«var String checkd = "diagrams/" + model + "/" + mutOperator + "/" + statementClass.get(0).name + "_" + d.substring(d.lastIndexOf("/") + 1, d.length())»-->
<!--«var String checkc = "code/" + cmodel + "/" + cmutOperator + "/" + statementClass.get(0).name + "_" + c.substring(c.lastIndexOf("/") + 1, c.length()).replace(".png", ".py")»-->
«FOR EClass stClass : statementClass»
«{data = d.substring(d.indexOf("/data/out/") + ("/data/out/").length, d.lastIndexOf("/")); ""}»
«{cdata = c.substring(c.indexOf("/data/out/") + ("/data/out/").length, c.lastIndexOf("/")); ""}»
«{model = data.substring(0, data.lastIndexOf("/")); ""}»
«{cmodel = cdata.substring(0, cdata.lastIndexOf("/")); ""}»
«{mutOperator = data.substring(data.indexOf(model + "/") + (model + "/").length(), data.length()); ""}»
«{cmutOperator = cdata.substring(cdata.indexOf(cmodel + "/") + (cmodel + "/").length(), cdata.length()); ""}»
«{diagram.add("diagrams/" + model + "/" + mutOperator + "/" + stClass.name + "_" + d.substring(d.lastIndexOf("/") + 1, d.length())); ""}»
«{code.add("code/" + cmodel + "/" + cmutOperator + "/" + stClass.name + "_" + c.substring(c.lastIndexOf("/") + 1, c.length()).replace(".png", ".py")); ""}»
«ENDFOR»
<question type="multichoice">
<name>
<text>Question «{i++; i;}»</text>
</name>
<!--«var File file = new File(workspacePath + "/" + projectName +  "/src-gen/html/" + checkd)»-->
«IF file.isFile && file.exists()»
<questiontext format="html">
«IF statementClass !== null && statementClass.size() > 0 && answersClass === null»
«IF statementClass.size() == 1»
<!-- «var UUID uuidStatement = UUID.randomUUID()»-->
<text><![CDATA[<p>«t.question.replace("\"", "'")»<br><p><img width="20%" height="20%" src="data:image/png;base64,«generator.getStringBase64(diagram.get(0))»"></p><!--<br><img src="@@PLUGINFILE@@/exercise_«uuidStatement».png" alt="multiple choice" width="20%" height="20%" class="img-responsive atto_image_button_text-bottom"><br>--></p>]]></text>
«ELSEIF statementClass.size() == 2»
<!-- «var UUID uuidStatement = UUID.randomUUID()»-->
<!-- «var UUID uuidAnswers = UUID.randomUUID()»-->
<text><![CDATA[<p>«t.question.replace("\"", "'")»<br><p><img width="20%" height="20%" src="data:image/png;base64,«generator.getStringBase64(diagram.get(0))»"></p><p><img width="20%" height="20%" src="data:image/png;base64,«generator.getStringBase64(diagram.get(1))»"></p><!--<br><img src="@@PLUGINFILE@@/exercise_«uuidStatement».png" alt="multiple choice" width="20%" height="20%" class="img-responsive atto_image_button_text-bottom"><br><br><img src="@@PLUGINFILE@@/exercise_«uuidAnswers».png" alt="multiple choice" width="20%" height="20%" class="img-responsive atto_image_button_text-bottom"><br>--></p>]]></text>
«ENDIF»
«ENDIF»
«IF statementClass !== null && statementClass.size() > 0 && answersClass !== null»
<!-- «var UUID uuidStatement = UUID.randomUUID()»-->
<!-- «var UUID uuidAnswers = UUID.randomUUID()»-->
«{data = diagrams.get(rndSolution).substring(diagrams.get(rndSolution).indexOf("/data/out/") + ("/data/out/").length, diagrams.get(rndSolution).lastIndexOf("/")); ""}»
«{model = data.substring(0, data.lastIndexOf("/")); ""}»
«{mutOperator = data.substring(data.indexOf(model + "/") + (model + "/").length(), data.length()); ""}»
«{diagram.add("diagrams/" + model + "/" + mutOperator + "/" + answersClass.name + "_" + diagrams.get(rndSolution).substring(diagrams.get(rndSolution).lastIndexOf("/") + 1, diagrams.get(rndSolution).length())); ""}»
«{file = new File(workspacePath + "/" + projectName +  "/src-gen/html/" + diagram.get(0)); ""}»-->
«IF file.isFile && file.exists()»
<text><![CDATA[<p>«t.question.replace("\"", "'")»<br><p><img width="20%" height="20%" src="data:image/png;base64,«generator.getStringBase64(diagram.get(0))»"></p><p><img width="20%" height="20%" src="data:image/png;base64,«generator.getStringBase64(diagram.get(1))»"></p><!--<br><img src="@@PLUGINFILE@@/exercise_«uuidStatement».png" alt="multiple choice" width="20%" height="20%" class="img-responsive atto_image_button_text-bottom"><br><br><img src="@@PLUGINFILE@@/exercise_«uuidAnswers».png" alt="multiple choice" width="20%" height="20%" class="img-responsive atto_image_button_text-bottom"><br>--></p>]]></text>
«ENDIF»
«ENDIF»
</questiontext>
<generalfeedback format="html">
<text></text>
</generalfeedback>
<defaultgrade>1.0000000</defaultgrade>
<penalty>0.3333333</penalty>
<hidden>0</hidden>
<idnumber></idnumber>
<single>false</single>
<shuffleanswers>true</shuffleanswers>
<answernumbering>abc«/*var char car = 'a'»«FOR opt : options.get(exercise).get(test)»«car++»«ENDFOR*/»</answernumbering>
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
<!--«var List<String> solutions = new ArrayList<String>()»-->
«IF (generator.options.get(exercise).get(t) !== null)»
«IF generator.options.get(exercise).get(t).size() > 0»
«FOR TestOption opt : selectedOptions»
<!--«var List<String> textOptions = new ArrayList<String>()»-->
«IF opt.text.size > 0»
«IF opt.solution == true»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
<!--«var String value = text.trim()»-->
«IF !textOptions.contains(value)»
«{solutions.add(value); ""}»
«{textOptions.add(value); ""}»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ELSEIF opt.solution == false»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
<!--«var String value = text.trim()»-->
«IF !textOptions.contains(value)»
«{textOptions.add(value); ""}»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDIF»
<!--«var int nSolutions = 0»-->
«IF generator.options.get(exercise).get(t).size() > 0»
«FOR TestOption opt : selectedOptions»
«IF opt.text.size > 0»
«IF opt.solution == true»
«var int counter = 0»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
«var boolean found = false»
«FOR SimpleEntry<String, Boolean> entry : mapTextOptions.get(t)»
«IF entry.getKey().equals(text) && !entry.getValue()»
«{found = true; ""}»
«{entry.setValue(true); ""}»
«ENDIF»
«ENDFOR»
«IF found == true»
«IF counter < min && counter < solutions.size() + 1»
«{nSolutions++; ""}»
«{counter++; ""}»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ELSEIF opt.solution == false»
«var int counter = 0»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
«var boolean found = false»
«FOR SimpleEntry<String, Boolean> entry : mapTextOptions.get(t)»
«IF entry.getKey().equals(text) && !entry.getValue()»
«{found = true; ""}»
«{entry.setValue(true); ""}»
«ENDIF»
«ENDFOR»
«IF found == true»
«IF counter < min && counter < solutions.size() + 1»
«{counter++; ""}»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDIF»
«FOR SimpleEntry<String, Boolean> entry : mapTextOptions.get(t)»
«{entry.setValue(false); ""}»
«ENDFOR»
«IF solutions.size() > min»
«min = solutions.size() + min + 1»
«ENDIF»
«IF generator.options.get(exercise).get(t).size() > 0»
«FOR TestOption opt : selectedOptions»
«IF opt.text.size > 0»
«IF opt.solution == true»
«var int counter = 0»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
«var boolean found = false»
«FOR SimpleEntry<String, Boolean> entry : mapTextOptions.get(t)»
«IF entry.getKey().equals(text) && !entry.getValue()»
«{found = true; ""}»
«{entry.setValue(true); ""}»
«ENDIF»
«ENDFOR»
«IF found == true»
«IF counter < min && counter < solutions.size() + 1»
<!--«var double fraction = 100.0 / nSolutions»-->
«IF 100 % nSolutions == 0»
<answer fraction="«100/nSolutions»" format="html">
<text><![CDATA[<p>«text.trim()»<br></p>]]></text>
<feedback format="html">
<text></text>
</feedback>
</answer>
«ELSE»
<!--«var DecimalFormat formatter = (NumberFormat.getNumberInstance(Locale.ENGLISH) as DecimalFormat)»-->
«{formatter.applyPattern("###.#####"); ""}»
<answer fraction="«formatter.format(fraction)»" format="html">
<text><![CDATA[<p>«text.trim()»<br></p>]]></text>
<feedback format="html">
<text></text>
</feedback>
</answer>
«ENDIF»
«{counter++; ""}»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ELSEIF opt.solution == false»
«var int counter = 0»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
«var boolean found = false»
«FOR SimpleEntry<String, Boolean> entry : mapTextOptions.get(t)»
«IF entry.getKey().equals(text) && !entry.getValue()»
«{found = true; ""}»
«{entry.setValue(true); ""}»
«ENDIF»
«ENDFOR»
«IF found == true»
«IF counter < min && counter < solutions.size() + 1»
<answer fraction="0" format="html">
<text><![CDATA[<p>«text.trim()»<br></p>]]></text>
<feedback format="html">
<text></text>
</feedback>
</answer>
«{counter++; ""}»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDIF»
«ENDIF»
«ELSE»
«{file = new File(workspacePath + "/" + projectName +  "/src-gen/html/" + checkc); ""}»
«IF file.isFile && file.exists()»
<questiontext format="html">
<text><![CDATA[<p>«t.question.replace("\"", "'")»<br></p><div>«generator.getPythonHtmlCode(checkc)»</div>]]></text>
«{cdata = codes.get(rndSolution).substring(codes.get(rndSolution).indexOf("/data/out/") + ("/data/out/").length, codes.get(rndSolution).lastIndexOf("/")); ""}»
«{cmodel = cdata.substring(0, cdata.lastIndexOf("/")); ""}»
«{cmutOperator = cdata.substring(cdata.indexOf(cmodel + "/") + (cmodel + "/").length(), cdata.length()); ""}»
«{code.add("code/" + cmodel + "/" + cmutOperator + "/" + answersClass.name + "_" + codes.get(rndSolution).substring(codes.get(rndSolution).lastIndexOf("/") + 1, codes.get(rndSolution).length()).replace(".png", ".py")); ""}»
«{file = new File(workspacePath + "/" + projectName +  "/src-gen/html/" + code.get(0)); ""}»-->
«IF file.isFile && file.exists()»
<text><![CDATA[<p>«t.question.replace("\"", "'")»<br></p><div>«generator.getPythonHtmlCode(code.get(0))»</div>]]></text>
«ENDIF»
</questiontext>
<generalfeedback format="html">
<text></text>
</generalfeedback>
<defaultgrade>1.0000000</defaultgrade>
<penalty>0.3333333</penalty>
<hidden>0</hidden>
<idnumber></idnumber>
<single>false</single>
<shuffleanswers>true</shuffleanswers>
<answernumbering>abc«/*var char car = 'a'»«FOR opt : options.get(exercise).get(test)»«car++»«ENDFOR*/»</answernumbering>
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
<!--«var ArrayList<String> solutions = new ArrayList<String>()»-->
«IF (generator.options.get(exercise).get(t) !== null)»
«IF generator.options.get(exercise).get(t).size() > 0»
«FOR TestOption opt : selectedOptions»
<!--«var List<String> textOptions = new ArrayList<String>()»-->
«IF opt.text.size > 0»
«IF opt.solution == true»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
<!--«var String value = text.trim()»-->
«IF !textOptions.contains(value)»
«{solutions.add(value); ""}»
«{textOptions.add(value); ""}»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ELSEIF opt.solution == false»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
<!--«var String value = text.trim()»-->
«IF !textOptions.contains(value)»
«{textOptions.add(value); ""}»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDIF»
<!--«var int nSolutions = 0»-->
«IF generator.options.get(exercise).get(t).size() > 0»
«FOR TestOption opt : selectedOptions»
«IF opt.text.size > 0»
«IF opt.solution == true»
«var int counter = 0»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
«var boolean found = false»
«FOR SimpleEntry<String, Boolean> entry : mapTextOptions.get(t)»
«IF entry.getKey().equals(text) && !entry.getValue()»
«{found = true; ""}»
«{entry.setValue(true); ""}»
«ENDIF»
«ENDFOR»
«IF found == true»
«IF counter < min + 1»
«{nSolutions++; ""}»
«{counter++; ""}»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ELSEIF opt.solution == false»
«var int counter = 0»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
«var boolean found = false»
«FOR SimpleEntry<String, Boolean> entry : mapTextOptions.get(t)»
«IF entry.getKey().equals(text) && !entry.getValue()»
«{found = true; ""}»
«{entry.setValue(true); ""}»
«ENDIF»
«ENDFOR»
«IF found == true»
«IF counter < min + 1»
«{counter++; ""}»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDIF»
«FOR SimpleEntry<String, Boolean> entry : mapTextOptions.get(t)»
«{entry.setValue(false); ""}»
«ENDFOR»
«IF solutions.size() > min»
«min = solutions.size() + min + 1»
«ENDIF»
«IF generator.options.get(exercise).get(t).size() > 0»
«FOR TestOption opt : selectedOptions»
«IF opt.text.size > 0»
«IF opt.solution == true»
«var int counter = 0»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
«var boolean found = false»
«FOR SimpleEntry<String, Boolean> entry : mapTextOptions.get(t)»
«IF entry.getKey().equals(text) && !entry.getValue()»
«{found = true; ""}»
«{entry.setValue(true); ""}»
«ENDIF»
«ENDFOR»
«IF found == true»
«IF counter < min && counter < solutions.size() + 1»
<!--«var double fraction = 100.0 / nSolutions»-->
«IF 100 % nSolutions == 0»
<answer fraction="«100/nSolutions»" format="html">
<text><![CDATA[<p>«HTMLUtils.toHtmlEntities(text.replace("\\n", "").trim())»<br></p>]]></text>
<feedback format="html">
<text></text>
</feedback>
</answer>
«ELSE»
<!--«var DecimalFormat formatter = (NumberFormat.getNumberInstance(Locale.ENGLISH) as DecimalFormat)»-->
«{formatter.applyPattern("###.#####"); ""}»
<answer fraction="«formatter.format(fraction)»" format="html">
<text><![CDATA[<p>«HTMLUtils.toHtmlEntities(text.replace("\\n", "").trim())»<br></p>]]></text>
<feedback format="html">
<text></text>
</feedback>
</answer>
«ENDIF»
«{counter++; ""}»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ELSEIF opt.solution == false»
«var int counter = 0»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
«var boolean found = false»
«FOR SimpleEntry<String, Boolean> entry : mapTextOptions.get(t)»
«IF entry.getKey().equals(text) && !entry.getValue()»
«{found = true; ""}»
«{entry.setValue(true); ""}»
«ENDIF»
«ENDFOR»
«IF found == true»
«IF counter < min && counter < solutions.size() + 1»
<answer fraction="0" format="html">
<text><![CDATA[<p>«HTMLUtils.toHtmlEntities(text.replace("\\n", "").replace("\\n", "").trim())»<br></p>]]></text>
<feedback format="html">
<text></text>
</feedback>
</answer>
«{counter++; ""}»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ENDIF»
«ENDIF»
«ENDFOR»
«ENDIF»
«ENDIF»
«ENDIF»
«ENDIF»
«ENDIF»
</question>
«ENDIF»
«ENDIF»
«ENDFOR»
<!-- «li.set(0, i)» -->
	'''
}
