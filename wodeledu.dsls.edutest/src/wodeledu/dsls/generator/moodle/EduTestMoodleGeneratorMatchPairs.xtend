package wodeledu.dsls.generator.moodle

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.EClass
import java.util.List
import java.util.ArrayList
import java.io.File
import java.util.UUID
import java.util.Map
import edutest.Test
import java.util.AbstractMap.SimpleEntry
import wodel.utils.manager.ModelManager
import wodel.utils.manager.HTMLUtils
import edutest.MatchPairs
import java.util.LinkedHashMap
import java.util.TreeMap
import java.io.PrintWriter
import edutest.Program
import wodeledu.dsls.generator.EduTestSuperGenerator
import org.eclipse.core.resources.IProject
import org.eclipse.emf.common.util.URI
import org.eclipse.core.resources.ResourcesPlugin
import wodeledu.dsls.generator.TestOption

class EduTestMoodleGeneratorMatchPairs {
	var MatchPairs exercise
	var IProject project
	var String projectPath
	var String outputFolder
	var String projectName
	var String workspacePath
	var EduTestSuperGenerator generator
	var Program program
	var List<Integer> li
	var List<EClass> roots
	var String fileName
	
	def protected static IProject projectOf(Resource r) {
		var URI uri = r.getURI()
		if (uri !== null && uri.isPlatformResource()) {
			var String projectName = uri.segment(1)
			return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName)
		}
		return null
	}
	def String setUpAndCompile(EduTestSuperGenerator generator, MatchPairs exercise, Program program, Resource resource, List<Integer> li, List<EClass> roots) {
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
		this.fileName = fileName
		return resource.compile().toString()		
	}

	def compile(Resource resource) '''
<!-- «var int i = li.get(0)» -->
<!--«var int min = Integer.MAX_VALUE»-->
<!--«var int index = 0»-->
<!--«var int max = Integer.MIN_VALUE»-->
«FOR test : exercise.tests»
«IF generator.options.get(exercise) !== null && generator.options.get(exercise).get(test) !== null»
«var List<String> textOptions = new ArrayList<String>()»
«var int k = 0»
«var int counter = 0»
«var int rndIndex = ModelManager.getRandomIndex(generator.options.get(exercise).get(test))»
«IF generator.options.get(exercise).get(test).size() > 0»
«FOR TestOption opt : generator.options.get(exercise).get(test).get(rndIndex)»
«FOR String key : opt.text.keySet()»
«FOR String text : opt.text.get(key)»
«IF !textOptions.contains(text)»
«{counter++; ""}»
«{textOptions.add(text); ""}»
«ENDIF»
«ENDFOR»
«ENDFOR»
«ENDFOR»
«IF counter > max»
«{max = counter; ""}»
«{index = k; ""}»
«ENDIF»
«{k++; ""}»
«ENDIF»
«ENDIF»
«ENDFOR»
<!--«var Map<Test, Map<TestOption, String>> mapPairOptions = new LinkedHashMap<Test, Map<TestOption, String>>()»-->
«FOR test : exercise.tests»
«IF generator.options.get(exercise) !== null && generator.options.get(exercise).get(test) !== null»
«var int k = 0»
«var int counter = 0»
<!--«var Map<TestOption, String> mapOptions = new LinkedHashMap<TestOption, String>()»-->
«var int rndIndex = ModelManager.getRandomIndex(generator.options.get(exercise).get(test))»
«IF generator.options.get(exercise).get(test).size() > 0»
«FOR TestOption opt : generator.options.get(exercise).get(test).get(rndIndex)»
«var List<String> textOptions = new ArrayList<String>()»
«FOR String key : opt.text.keySet()»
<!--«var String text = opt.text.get(key).get(0)»-->
«IF !textOptions.contains(text)»
«{counter++; ""}»
«{textOptions.add(text); ""}»
«ENDIF»
«ENDFOR»
«var String pairOptions = ""»
«FOR String textOption : textOptions»
<!--«pairOptions += textOption.trim() + ".<br>"»-->
«ENDFOR»
«{mapOptions.put(opt, pairOptions)}»
«ENDFOR»
«{mapPairOptions.put(test, mapOptions)}»
«IF min > counter»
«{min = counter; ""}»
«ENDIF»
«{k++; ""}»
«ENDIF»
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
«var int k = 0»
«FOR Test test : exercise.tests»
<!--«var TestOption opt = null»-->
«var int rndIndex = ModelManager.getRandomIndex(generator.options.get(exercise).get(test))»
«IF generator.options.get(exercise).get(test).size() > 0»
«IF (generator.options.get(exercise).get(test) !== null && generator.options.get(exercise).get(test).get(rndIndex).size() > index)»
<!--«opt = generator.options.get(exercise).get(test).get(rndIndex).get(index)»-->
«ENDIF»
«IF opt !== null»
<!--«var String seed = ''»-->
<!--«seed = opt.path»-->
«{seed = seed.substring(0, seed.lastIndexOf("/") + 1) + answersClass.name + "_" + seed.substring(seed.lastIndexOf("/") + 1, seed.length); ""}»
<!--«var File file = new File(workspacePath + "/" + projectName +  "/src-gen/html/" + seed)»-->
«IF file.isFile && file.exists()»
<question type="matching">
<name>
<text>Question «{i++; i;}»</text>
</name>
<questiontext format="html">
<!--«var String question = test.question.replace("\"", "'")»-->
<!-- «var UUID uuid = UUID.randomUUID()»-->
<text><![CDATA[<p>«question.trim()»<br></p><p><img width="20%" height="20%" src="data:image/png;base64,«generator.getStringBase64(seed)»"><br></p><!--<p><img src="@@PLUGINFILE@@/exercise_«uuid».png" alt="" width="20%" height="20%" role="presentation" class="img-responsive atto_image_button_text-bottom"><br></p>-->]]></text>
<!--<text><![CDATA[<p>Empareja cada uno de los enunciados de la izquierda con la opci&#243;n correcta de la derecha<br><img src="@@PLUGINFILE@@/exercise_«uuid».png" alt="" width="20%" height="20%" role="presentation" class="img-responsive atto_image_button_text-bottom"><br></p>]]></text>-->
<!--<file name="exercise_«uuid».png" path="/" encoding="base64">«generator.getStringBase64(seed)»</file>-->
</questiontext>
<generalfeedback format="html">
<text></text>
</generalfeedback>
<defaultgrade>1.0000000</defaultgrade>
<penalty>0.3333333</penalty>
<hidden>0</hidden>
<idnumber></idnumber>
<shuffleanswers>true</shuffleanswers>
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
<!--«var Map<Integer, SimpleEntry<String, String>> entries = new TreeMap<Integer, SimpleEntry<String, String>>()»-->
<!--«var int keyCounter = 0»-->
«FOR TestOption op : generator.options.get(exercise).get(test).get(rndIndex)»
«var String key = generator.getText((exercise as MatchPairs).config.identifier, op.entry.getKey().getURI().toFileString(), resource)»
«IF key.length() <= 127»
«var boolean found = false»
«FOR int entryKey : entries.keySet()»
«var SimpleEntry<String, String> entry = entries.get(entryKey)»
«IF entry.getKey().equals(key)»
«{found = true; ""}»
«ENDIF»
«ENDFOR»
«IF found == false»
«var SimpleEntry<String, String> entry = new SimpleEntry<String, String>(key, mapPairOptions.get(test).get(op).trim())»
«{entries.put(keyCounter++, entry); ""}»
«ENDIF»
«ENDIF»
«ENDFOR»
«var int counter = 0»
«FOR int key : entries.keySet()»
«IF counter < min»
«var SimpleEntry<String, String> entry = entries.get(key)»
<subquestion format="html">
<text><![CDATA[<p>«entry.getKey()»<br></p>]]></text>
<answer>
<text><![CDATA[<p>«entry.getValue()»<br></p>]]></text>
</answer>
</subquestion>
«{counter++; ""}»
«ENDIF»
«ENDFOR»
</question>
«{k++; ""}»
«ELSE»
«{seed = "code/" + seed.substring("diagrams/".length, seed.length).replace(".png", ".py"); ""}»
«{file = new File(workspacePath + "/" + projectName +  "/src-gen/html/" + seed); ""}»
«IF file.isFile && file.exists()»
<question type="matching">
<name>
<text>Question «{i++; i;}»</text>
</name>
<questiontext format="html">
<!--«var String question = test.question.replace("\"", "'")»-->
<text><![CDATA[<p>«question.trim()»<br></p><div>«generator.getPythonHtmlCode(seed)»</div>]]></text>
</questiontext>
<generalfeedback format="html">
<text></text>
</generalfeedback>
<defaultgrade>1.0000000</defaultgrade>
<penalty>0.3333333</penalty>
<hidden>0</hidden>
<idnumber></idnumber>
<shuffleanswers>true</shuffleanswers>
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
<!--«var TreeMap<Integer, SimpleEntry<String, String>> entries = new TreeMap<Integer, SimpleEntry<String, String>>()»-->
<!--«var int keyCounter = 0»-->
«FOR TestOption op : generator.options.get(exercise).get(test).get(rndIndex)»
«var String outPath = op.entry.getKey().getURI().toFileString().replace("\\", "/")»
«var String seedPath = seed.substring(0, seed.lastIndexOf("/") + 1) + outPath.substring(outPath.lastIndexOf("/") + 1, outPath.length()).replace(".model", "." + rndIndex + ".py")»
«{outPath = workspacePath + "/" + projectName + "/src-gen/html/" + seedPath; ""}»
«var PrintWriter pw = new PrintWriter(outPath, "UTF-8")»
«pw.println(generator.getText((exercise as MatchPairs).config.identifier, op.entry.getKey().getURI().toFileString(), resource))»
«pw.close()»
«{generator.generateHtmlCode(outPath); ""}»
«var String key = seedPath»
«IF key.length() <= 127»
«var boolean found = false»
«FOR int entryKey : entries.keySet()»
«var SimpleEntry<String, String> entry = entries.get(entryKey)»
«IF entry.getKey().equals(key)»
«{found = true; ""}»
«ENDIF»
«ENDFOR»
«IF found == false»
«var SimpleEntry<String, String> entry = new SimpleEntry<String, String>(key, mapPairOptions.get(test).get(op).trim())»
«{entries.put(keyCounter++, entry); ""}»
«ENDIF»
«ENDIF»
«ENDFOR»
«var int counter = 0»
«FOR int key : entries.keySet()»
«IF counter < min»
«var SimpleEntry<String, String> entry = entries.get(key)»
<subquestion format="html">
<text><![CDATA[<p>«generator.getPythonHtmlCode(entry.getKey())»</p>]]></text>
<answer>
<text><![CDATA[<p>«HTMLUtils.toHtmlEntities(entry.getValue().replace("\\n", "").trim())»<br></p>]]></text>
</answer>
</subquestion>
«{counter++; ""}»
«ENDIF»
«ENDFOR»
</question>
«{k++; ""}»
«ENDIF»
«ENDIF»
«ENDIF»
«ENDIF»
«ENDFOR»
<!-- «li.set(0, i)» -->
	'''
}