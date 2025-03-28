/*
 * generated by Xtext 2.13.0
 */
package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import wodel.utils.manager.ModelManager
import edutest.Program
import java.net.URL
import org.eclipse.core.runtime.FileLocator
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EObject
import wodel.utils.exceptions.ModelNotFoundException
import org.osgi.framework.Bundle
import org.eclipse.core.runtime.Platform
import java.util.List
import wodeledu.dsls.generator.EduTestSuperGenerator.TestOption
import wodeledu.dsls.generator.EduTestSuperGenerator.Registry
import mutatorenvironment.MutatorEnvironment
import java.util.AbstractMap.SimpleEntry
import java.util.HashMap
import edutest.Test
import java.util.Map
import java.util.ArrayList
import edutest.MatchPairs
import edutest.MissingWords
import org.eclipse.emf.ecore.EClass
import edutest.MultiChoiceText
import edutest.AlternativeResponse
import edutest.MultiChoiceDiagram
import edutest.MultiChoiceEmendation
import java.util.Collections
import java.util.Set
import java.io.File
import edutest.MutatorTests
import java.util.LinkedHashSet
import org.eclipse.core.resources.ResourcesPlugin

/**
 * @author Pablo Gomez-Abajo - eduTest code generator.
 * 
 * Generates the javascript and html code for the
 * test exercises application
 *  
 */
class EduTestHotPotatoesGenerator extends EduTestSuperGenerator {

	private String fileName
	private String pageName
	private List<EObject> blocks
	private List<EObject> mutators
	private List<EPackage> metamodel
	private List<EClass> roots

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		try {
			var i = 0;
			//loads the mutator model
			var xmiFileName = projectPath + "/" + outputFolder + "/" + resource.URI.lastSegment.replaceAll(".test", ".model")
			val Bundle bundle = Platform.getBundle("wodel.models")
	   		val URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore")
	   		val String mutatorecore = FileLocator.resolve(fileURL).getFile()
			//val String mutatorecore = ModelManager.getWorkspaceAbsolutePath + "/" + project.name + "/resources/MutatorEnvironment.ecore";
			val List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore)
			//val EPackage epackage = mutatorpackages.get(0);
			//EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
			val Resource mutatormodel = ModelManager.loadModel(mutatorpackages, xmiFileName)
			blocks = ModelManager.getObjectsOfType("Block", mutatormodel)
			mutators = ModelManager.getObjectsOfType("Mutator", mutatormodel)

			for (p : resource.allContents.toIterable.filter(Program)) {
				if (i == 0) {
					fileName = 'xml/' + resource.URI.lastSegment.replaceAll(".test", "") + '.jqz'
					pageName = resource.URI.lastSegment.replaceAll(".test", "") + '.jqz'
				} else {
					fileName = 'xml/' + resource.URI.lastSegment.replaceAll(".test", "") + i + '.jqz'
					pageName = resource.URI.lastSegment.replaceAll(".test", "") + i + '.jqz'
				}
				var EObject main = null
				if (blocks.size() > 0) {
					main = blocks.get(0)
				}
				if (mutators.size() > 0) {
					main = mutators.get(0)					
				}
				var EObject mutEnv = main
				while (!(mutEnv instanceof MutatorEnvironment) && mutEnv.eContainer !== null) {
					mutEnv = mutEnv.eContainer
				}
				if (!(mutEnv instanceof MutatorEnvironment)) {
					return
				}
				var List<EPackage> packages = ModelManager.loadMetaModel((mutEnv as MutatorEnvironment).definition.metamodel)
				var String domain = packages.get(0).getNsURI().replace("http://", "")
				domain = domain.substring(0, domain.lastIndexOf("/")).replace("/", "")

				var int k = 0				
				for (MutatorTests exercise : p.exercises) {
					metamodel = new ArrayList<EPackage>()
					metamodel.addAll(ModelManager.loadMetaModel(p.metamodel))
					roots = new ArrayList<EClass>()
					roots.addAll(ModelManager.getRootEClasses(metamodel))
					fsa.generateFile(fileName.replace(".jqz", k + ".jqz"), p.compile(resource, exercise))
					k++
				}
			}
		}
		catch (ModelNotFoundException e) {
		}
	}

	def compile(Program program, Resource resource, MutatorTests exercise) '''
		«{buildOptions(program, resource, blocks, roots, program.class); ""}»
<?xml version="1.0" encoding="ISO-8859-1"?>

<hotpot-jquiz-file>
<rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" xmlns:dc="http://purl.org/dc/elements/1.1/">
  <rdf:Description rdf:about="">
    <dc:creator>pablo</dc:creator>
  </rdf:Description>
</rdf:RDF><version>7</version>

<data>
<title></title>

<timer><seconds>60</seconds><include-timer>0</include-timer></timer>

<reading>
<include-reading>0</include-reading>
<reading-title></reading-title>
<reading-text></reading-text>
</reading>
<questions>
<question-record>


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
		
    	«IF exercise instanceof AlternativeResponse»
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
        «var String statement = diagrams.get(exercise).get(test).get(statementClass) !== null ? diagrams.get(exercise).get(test).get(statementClass).size() > 0 ? diagrams.get(exercise).get(test).get(statementClass).get(0) : null : null»
        «var List<String> answers = new ArrayList<String>()»
        «var Set<String> answersSet = new LinkedHashSet<String>()»
        «IF diagrams.get(exercise).get(test).get(answersClass) !== null && diagrams.get(exercise).get(test).get(answersClass).size() > 0»
        «{answersSet.addAll(diagrams.get(exercise).get(test).get(answersClass)); ""}»
        «{answers.addAll(answersSet); ""}»
        «{Collections.shuffle(answers); ""}»
	    «IF answers.size() > 0»
        <!--«var File file = new File(projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + statement)»-->
        «IF file.isFile && file.exists()»
        <question>«test.question.replace("\"", "'").trim()»
        &amp;#x003C;img src="«projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + statement»" alt=&quot;statement.png&quot; title=&quot;statement&quot; width=&quot;222&quot; height=&quot;364&quot; style=&quot;float: right;&quot;/&amp;#x003E;
        </question><clue></clue><category></category>
        <weighting>100</weighting><fixed>0</fixed><question-type>1</question-type><answers>
		«var int countTrue = 1»
		«var int countFalse = 1»
           «FOR String diagram : answers»
           <!--«file = new File(projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram)»-->
           «IF file.isFile && file.exists()»
		   «IF diagram.startsWith(answersClass.name) || diagram.contains("/" + answersClass.name) || diagram.contains("\\" + answersClass.name)»
           <!--«var boolean w = false»-->
           «FOR String sol : solutionsMap.get(exercise)»
           «IF diagram.startsWith(sol + "/") 
           || diagram.startsWith(sol + "\\")
           || diagram.contains(sol + "/" + answersClass.name + "_")
           || diagram.contains(sol + "\\" + answersClass.name + "_")»
           «{w = true; ""}»
           «ENDIF»
           «ENDFOR»
           «IF w »
            «IF countFalse > 0»
            «{countFalse--; "<answer><text>&amp;#x003C;img src=&quot;" + projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram + "&quot; width=&quot;355&quot; height=&quot;220&quot; style=&quot;float: left;&quot;/&amp;#x003E;</text><feedback></feedback><correct>0</correct><percent-correct>0</percent-correct></answer>"}»
			«ENDIF»
            «ELSE»
           «IF countTrue > 0»
           «{countTrue--; "<answer><text>&amp;#x003C;img src=&quot;" + projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram + "&quot; alt=&quot;op1.png&quot; title=&quot;op1&quot; width=&quot;355&quot; height=&quot;220&quot; style=&quot;float: left;&quot;/&amp;#x003E;</text><feedback></feedback><correct>1</correct><percent-correct>100</percent-correct><include-in-mc-options>1</include-in-mc-options></answer>"}»
			«ENDIF»
           «ENDIF»
           <!--«w = false»-->
           «FOR String sol : solutionsMap.get(exercise)»
           «IF diagram.startsWith(sol + "/") 
           || diagram.startsWith(sol + "\\")
           || diagram.contains(sol + "/" + answersClass.name + "_")
           || diagram.contains(sol + "\\" + answersClass.name + "_")»
           «{w = true; ""}»
           «ENDIF»
           «ENDFOR»
           «IF w »
           «IF countFalse > 0»
           «{countFalse--; "<answer><text>&amp;#x003C;img src=&quot;" + projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram + "&quot; width=&quot;355&quot; height=&quot;220&quot; style=&quot;float: left;&quot;/&amp;#x003E;</text><feedback></feedback><correct>0</correct><percent-correct>0</percent-correct></answer>"}»
           «ENDIF»
           «ELSE»
           «IF countTrue > 0»
           «{countTrue--; "<answer><text>&amp;#x003C;img src=&quot;" + projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram + "&quot; alt=&quot;op1.png&quot; title=&quot;op1&quot; width=&quot;355&quot; height=&quot;220&quot; style=&quot;float: left;&quot;/&amp;#x003E;</text><feedback></feedback><correct>1</correct><percent-correct>100</percent-correct><include-in-mc-options>1</include-in-mc-options></answer>"}»
           «ENDIF»
           «ENDIF»
           «ENDIF»
           «ENDIF»
           «ENDFOR»
        «ENDIF»
		«ENDIF»
		«ENDIF»
</answers>
</question-record></questions>
		«ENDFOR»
		«ENDIF»
    	«IF exercise instanceof MultiChoiceDiagram»
        «var int min = Integer.MAX_VALUE»
		«FOR test : exercise.tests»
           «FOR EClass eclass : diagrams.get(exercise).get(test).keySet()»
           «var int counter = diagrams.get(exercise).get(test).get(eclass).size()»
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
        «var String statement = diagrams.get(exercise).get(test).get(statementClass) !== null ? diagrams.get(exercise).get(test).get(statementClass).size() > 0 ? diagrams.get(exercise).get(test).get(statementClass).get(0) : null : null»
        «var String solution = diagrams.get(exercise).get(test).get(answersClass) !== null ? diagrams.get(exercise).get(test).get(answersClass).size() > 0 ? diagrams.get(exercise).get(test).get(answersClass).get(0)»
        «var List<String> answers = new ArrayList<String>()»
        «var Set<String> answersSet = new LinkedHashSet<String>()»
        «IF diagrams.get(exercise).get(test).get(answersClass) !== null && diagrams.get(exercise).get(test).get(answersClass).size() > 0»
        «{answersSet.addAll(diagrams.get(exercise).get(test).get(answersClass)); ""}»
        «{answers.addAll(answersSet); ""}»
        «{Collections.shuffle(answers); ""}»
           <!--«var File file = new File(projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + statement)»-->
           «IF file.isFile && file.exists()»
<question>Select which of the following object diagrams is a valid instance of the class diagram shown below:
&amp;#x003C;img src="«projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + statement»" alt=&quot;statement.png&quot; title=&quot;statement&quot; width=&quot;222&quot; height=&quot;364&quot; style=&quot;float: right;&quot;/&amp;#x003E;</question><clue></clue><category></category><weighting>100</weighting><fixed>0</fixed><question-type>1</question-type>
<answers>
           <!--«var int counter = 0»-->
           <!--«var int solutions = 1»-->
		«var int countTrue = 1»
		«var int countFalse = 3»
           «{counter = 0; ""}»
           «FOR String diagram : answers»
           <!--«file = new File(projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram)»-->
           «IF file.isFile && file.exists()»
		   «IF diagram.startsWith(answersClass.name) || diagram.contains("/" + answersClass.name) || diagram.contains("\\" + answersClass.name)»
           <!--«var boolean s = false»-->
           «FOR String sol : solutionsMap.get(exercise)»
           «IF diagram.startsWith(sol + "/") 
           || diagram.startsWith(sol + "\\")
           || diagram.contains(sol + "/" + answersClass.name + "_")
           || diagram.contains(sol + "\\" + answersClass.name + "_")»
           «{s = true; ""}»
           «ENDIF»
           «ENDFOR»
           «IF s == true»
           «IF counter < min - 1»
           «{counter++; ""}»
           «{solutions++; ""}»
           «ENDIF»
           «ENDIF»
           «IF s || diagram.equals(solution)»
           «IF countTrue > 0»
           «{countTrue--;"<answer><text>&amp;#x003C;img src=&quot;" + projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram +"&quot; alt=&quot;op1.png&quot; title=&quot;op1&quot; width=&quot;355&quot; height=&quot;220&quot; style=&quot;float: left;&quot;/&amp;#x003E;</text><feedback></feedback><correct>1</correct><percent-correct>100</percent-correct><include-in-mc-options>1</include-in-mc-options></answer>"}»
           «ENDIF»
           «ELSE»
           «IF countFalse > 0»
           «{countFalse--;"<answer><text>&amp;#x003C;img src=&quot;" + projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram + "&quot; width=&quot;355&quot; height=&quot;220&quot; style=&quot;float: left;&quot;/&amp;#x003E;</text><feedback></feedback><correct>0</correct><percent-correct>0</percent-correct></answer>"}»
           «ENDIF»
           «ENDIF»
           «IF counter < min - 1»
           «{counter++; ""}»
           <!--«s = false»-->
           «FOR String sol : solutionsMap.get(exercise)»
           «IF diagram.startsWith(sol + "/") 
           || diagram.startsWith(sol + "\\")
           || diagram.contains(sol + "/" + answersClass.name + "_")
           || diagram.contains(sol + "\\" + answersClass.name + "_")»
           «{s = true; ""}»
           «ENDIF»
           «ENDFOR»
          «IF s || diagram.equals(solution)»
          «IF countTrue > 0»
          «{countTrue--; "<answer><text>&amp;#x003C;img src=&quot;"+ projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram + "&quot; alt=&quot;op1.png&quot; title=&quot;op1&quot; width=&quot;355&quot; height=&quot;220&quot; style=&quot;float: left;&quot;/&amp;#x003E;</text><feedback></feedback><correct>1</correct><percent-correct>100</percent-correct><include-in-mc-options>1</include-in-mc-options></answer>"}»
          «ENDIF»
           «ELSE»
           «IF countFalse > 0»
           «{countFalse--; "<answer><text>&amp;#x003C;img src=&quot;" + projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram + "&quot; width=&quot;355&quot; height=&quot;220&quot; style=&quot;float: left;&quot;/&amp;#x003E;</text><feedback></feedback><correct>0</correct><percent-correct>0</percent-correct></answer>"}»
           «ENDIF»
           «ENDIF»
           «ENDIF»
           «ENDIF»
           «ENDIF»
           «ENDFOR»
  		«ENDIF»
		«ENDIF»
        «ENDFOR»
</answers>
</question-record></questions>
          «ENDIF»
		«var Map<Test, List<SimpleEntry<String, Boolean>>> mapTextOptions = new HashMap<Test, List<SimpleEntry<String, Boolean>>>()»
		«IF exercise instanceof MultiChoiceEmendation»
        «var int min = Integer.MAX_VALUE»
        «var int rndIndex = -1»
		«FOR Test test : exercise.tests»
		«var Test t = test»
		«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
          «var int counter = 0»
          «{rndIndex = ModelManager.getRandomIndex(options.get(exercise).get(test)); ""}»
          «var List<SimpleEntry<String, Boolean>> textOptions = new ArrayList<SimpleEntry<String, Boolean>>()»
          «IF options.get(exercise).get(test).size() > 0»
          «FOR TestOption opt : options.get(exercise).get(test).get(rndIndex)»
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
<questions>
<question-record>
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
		«IF options.get(exercise) !== null && options.get(exercise).get(t) !== null»
			<!--«var List<String> diagrams = new ArrayList<String>()»-->
			<!--«var List<TestOption> answersOptions = new ArrayList<TestOption>()»-->
			<!--«var List<String> wrongDiagrams = new ArrayList<String>()»-->
			<!--«var List<TestOption> wrongOptions = new ArrayList<TestOption>()»-->
			<!--«var List<TestOption> selectedOptions = new ArrayList<TestOption>()»-->
			«IF (options.get(exercise).get(t) !== null)»
			«IF options.get(exercise).get(t).size() > 0»
            «FOR TestOption opt : options.get(exercise).get(t).get(rndIndex)»
			«IF opt.text.size > 0»
			«IF opt.solution == true»
				<!--«diagrams.add(opt.path)»-->
				<!--«answersOptions.add(opt)»-->
			«ENDIF»
			«ENDIF»
			«ENDFOR»
            «FOR TestOption opt : options.get(exercise).get(t).get(rndIndex)»
			«IF opt.text.size > 0»
			«IF opt.solution == false»
				<!--«wrongDiagrams.add(opt.path)»-->
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
            <!--«var String d = diagrams.get(rndSolution)»-->
			«IF d.length > 0»w
			<!--«var String data = d.substring(d.indexOf("/data/out/") + ("/data/out/").length, d.lastIndexOf("/"))»-->
			<!--«var String model = data.substring(0, data.lastIndexOf("/"))»-->
			<!--«var String mutOperator = data.substring(data.indexOf(model + "/") + (model + "/").length(), data.length())»-->
			<!--«var String checkd = "diagrams/" + model + "/" + mutOperator + "/" + statementClass.get(0).name + "_" + d.substring(d.lastIndexOf("/") + 1, d.length())»-->
            «FOR EClass stClass : statementClass»
			<!--«data = d.substring(d.indexOf("/data/out/") + ("/data/out/").length, d.lastIndexOf("/"))»-->
			<!--«model = data.substring(0, data.lastIndexOf("/"))»-->
			<!--«mutOperator = data.substring(data.indexOf(model + "/") + (model + "/").length(), data.length())»-->
			<!--«{diagram.add("diagrams/" + model + "/" + mutOperator + "/" + stClass.name + "_" + d.substring(d.lastIndexOf("/") + 1, d.length()))}»-->
			«ENDFOR»
           <!--«var File file = new File(workspacePath + "/" + projectName + "/src-gen/html/" + checkd)»-->
           «IF file.isFile && file.exists()»
			<question>
            «IF statementClass !== null && statementClass.size() > 0 && answersClass === null»
            «FOR String diag : diagram»
&amp;#x003C;img src=&quot;«workspacePath + "/" + projectName + "/src-gen/html/" + diag»&quot; alt=&quot;cd.png&quot; title=&quot;cd&quot; width=&quot;222&quot; height=&quot;364&quot; style=&quot;float: right;&quot;/&amp;#x003E;
			«ENDFOR»
            «ENDIF»
            «IF statementClass !== null && statementClass.size() > 0 && answersClass !== null»
            «FOR String diag : diagram»
&amp;#x003C;img src=&quot;«workspacePath + "/" + projectName + "/src-gen/html/" + diag»&quot; alt=&quot;cd_od.png&quot; title=&quot;cd&quot; width=&quot;222&quot; height=&quot;364&quot; style=&quot;float: right;&quot;/&amp;#x003E;
			«ENDFOR»
            «ENDIF»
  </question>
            «ENDIF»
          «var List<String> solutions = new ArrayList<String>()»
          «IF (options.get(exercise).get(t) !== null)»
          «IF options.get(exercise).get(t).size() > 0»
          «FOR TestOption opt : selectedOptions»
          «var List<String> textOptions = new ArrayList<String>()»
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
          «ELSE»
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
          «IF options.get(exercise).get(t).size() > 0»
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
          «IF counter < min - solutions.size() + 1»
<answer><text>«text.trim()»</text><feedback></feedback><correct>1</correct><percent-correct>100</percent-correct><include-in-mc-options>1</include-in-mc-options></answer>
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
          «IF counter < min - solutions.size() + 1»
<answer><text>«text.trim()»</text><feedback></feedback><correct>0</correct><percent-correct>0</percent-correct></answer>         
          «{counter++; ""}»
          «ENDIF»
          «ENDIF»
          «ENDFOR»
          «ENDFOR»
          «ENDIF»
          «ENDIF»
          «ENDFOR»
<!----->

          «ENDIF»
          «ENDIF»
          «ENDIF»
          «ENDIF»
          «ENDIF»
		«ENDFOR»
		«ENDIF»
		«IF exercise instanceof MatchPairs»
        «var int min = Integer.MAX_VALUE»
        «var int index = 0»
        «var int max = Integer.MIN_VALUE»
		«FOR test : exercise.tests»
		«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
          «var List<String> textOptions = new ArrayList<String>()»
          «var int k = 0»
          «var int counter = 0»
          «var int rndIndex = ModelManager.getRandomIndex(options.get(exercise).get(test))»
          «IF options.get(exercise).get(test).size() > 0»
          «FOR TestOption opt : options.get(exercise).get(test).get(rndIndex)»
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
        <!--«var Map<Test, Map<TestOption, String>> mapPairOptions = new HashMap<Test, Map<TestOption, String>>()»-->
		«FOR test : exercise.tests»
		«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
          «var int k = 0»
          «var int counter = 0»
          <!--«var Map<TestOption, String> mapOptions = new HashMap<TestOption, String>()»-->
          «var int rndIndex = ModelManager.getRandomIndex(options.get(exercise).get(test))»
          «IF options.get(exercise).get(test).size() > 0»
          «FOR TestOption opt : options.get(exercise).get(test).get(rndIndex)»
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
          <!--«pairOptions += textOption.trim().replace("  "," ").replace(" ", "+") + ".<br>"»-->
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
        «var int rndIndex = ModelManager.getRandomIndex(options.get(exercise).get(test))»
        «IF options.get(exercise).get(test).size() > 0»
        «IF (options.get(exercise).get(test) !== null && options.get(exercise).get(test).get(rndIndex).size() > index)»
        <!--«opt = options.get(exercise).get(test).get(rndIndex).get(index)»-->
        «ENDIF»
        «IF opt !== null»
        <!--«var String seed = ''»-->
        <!--«seed = opt.path»-->
        «{seed = seed.substring(0, seed.lastIndexOf("/") + 1) + answersClass.name + "_" + seed.substring(seed.lastIndexOf("/") + 1, seed.length)}»
        <!--«var File file = new File(projectPath +  "/src-gen/html/" + seed)»-->
        «IF file.isFile && file.exists()»
        «{k++; ""}»
          «ENDIF»
          «ENDIF»
          «ENDIF»
          «ENDFOR»
        «ENDIF»
        «IF exercise instanceof MissingWords»
        «FOR test : exercise.tests»
		«FOR EClass root : roots»
        «IF exercise.config.answers !== null && exercise.config.answers.size() > 0»
		«IF exercise.config.answers.get(0).name.equals(root.name)»
		«ENDIF»
		«ENDIF»
		«IF exercise.config.statement !== null && exercise.config.statement.size() > 0»
		«IF exercise.config.statement.get(0).name.equals(root.name)»
		«ENDIF»
		«ENDIF»
		«ENDFOR»
	    «ENDFOR»
        «ENDIF»
    	«IF exercise instanceof MultiChoiceText»
        «var int min = Integer.MAX_VALUE»
		«FOR test : exercise.tests»
           «FOR EClass eclass : diagrams.get(exercise).get(test).keySet()»
           «var int counter = diagrams.get(exercise).get(test).get(eclass).size()»
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
        «var String statement = diagrams.get(exercise).get(test).get(statementClass) !== null ? diagrams.get(exercise).get(test).get(statementClass).size() > 0 ? diagrams.get(exercise).get(test).get(statementClass).get(0) : null : null»
        «var String solution = diagrams.get(exercise).get(test).get(answersClass) !== null ? diagrams.get(exercise).get(test).get(answersClass).size() > 0 ? diagrams.get(exercise).get(test).get(answersClass).get(0)»
        «var List<String> answers = new ArrayList<String>()»
        «var Set<String> answersSet = new LinkedHashSet<String>()»
        «IF diagrams.get(exercise).get(test).get(answersClass) !== null && diagrams.get(exercise).get(test).get(answersClass).size() > 0»
        «{answersSet.addAll(diagrams.get(exercise).get(test).get(answersClass)); ""}»
        «{answers.addAll(answersSet); ""}»
        «{Collections.shuffle(answers); ""}»
        <!--«var String diagram = projectPath + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + statement»-->
		«IF diagram.length > 0»
        <!--«var File file = new File(diagram)»-->
        «IF file.isFile && file.exists()»
        «{diagram = diagram.substring(diagram.indexOf("/src-gen/html/") + "/src-gen/html/".length, diagram.length); ""}»
           «ENDIF»
           «ENDIF»
           «ENDIF»
        «ENDFOR»
        «ENDIF»
</question-record></questions>
</data>

<hotpot-config-file>
<jquiz>
<exercise-subtitle>Quiz</exercise-subtitle>
<instructions></instructions>
<guess-correct>Correct!</guess-correct>
<guess-incorrect>Sorry! Try again.</guess-incorrect>
<partly-incorrect>Your answer is partly wrong: </partly-incorrect>
<enter-a-guess>Please enter a guess.</enter-a-guess>
<next-correct-letter>Next correct letter in the answer: </next-correct-letter>
<correct-answers>Correct answers: </correct-answers>
<show-answer-caption>Show answer</show-answer-caption>
<include-hint>1</include-hint>
<include-show-answer>1</include-show-answer>
<next-ex-url>nextpage.htm</next-ex-url>
<send-email>0</send-email>
<continuous-scoring>1</continuous-scoring>
<show-correct-first-time>1</show-correct-first-time>
<shuffle-questions>0</shuffle-questions>
<shuffle-answers>0</shuffle-answers>
<show-limited-questions>0</show-limited-questions>
<questions-to-show>2</questions-to-show>
<short-answer-tries-on-hybrid-q>2</short-answer-tries-on-hybrid-q>
<separate-javascript-file>0</separate-javascript-file>
<case-sensitive>0</case-sensitive>
<include-keypad>0</include-keypad>
</jquiz>

<global>
<your-score-is>Your score is </your-score-is>
<correct-indicator>&amp;#x2714;</correct-indicator>
<incorrect-indicator>&amp;#x2718;</incorrect-indicator>
<correct-first-time>Questions answered correctly first time: </correct-first-time>
<completed-so-far>Questions completed so far: </completed-so-far>
<exercise-completed>You have completed the exercise.</exercise-completed>
<keypad-characters></keypad-characters>
<times-up>Your time is over!</times-up>
<next-ex-caption>=&amp;#x003E;</next-ex-caption>
<back-caption>&amp;#x003C;=</back-caption>
<contents-caption>Index</contents-caption>
<include-next-ex>1</include-next-ex>
<include-contents>1</include-contents>
<include-back>0</include-back>
<contents-url>contents.htm</contents-url>
<graphic-url></graphic-url>
<font-face>Geneva,Arial,sans-serif</font-face>
<font-size>medium</font-size>
<page-bg-color>#C0C0C0</page-bg-color>
<title-color>#000000</title-color>
<ex-bg-color>#FFFFFF</ex-bg-color>
<text-color>#000000</text-color>
<link-color>#0000FF</link-color>
<vlink-color>#0000CC</vlink-color>
<nav-bar-color>#000000</nav-bar-color>
<formmail-url>http://yourserver.com/cgi-bin/FormMail.pl</formmail-url>
<email>you@yourserver.com</email>
<name-please>Please enter your name:</name-please>
<user-string-1>one</user-string-1>
<user-string-2>two</user-string-2>
<user-string-3>three</user-string-3>
<header-code></header-code>
<correct-first-time>Questions answered correctly first time: </correct-first-time>
<check-caption>Check</check-caption>
<ok-caption>OK</ok-caption>
<next-q-caption>=&amp;#x003E;</next-q-caption>
<last-q-caption>&amp;#x003C;=</last-q-caption>
<hint-caption>Hint</hint-caption>
<show-all-questions-caption>Show all questions</show-all-questions-caption>
<show-one-by-one-caption>Show questions one by one</show-one-by-one-caption>
<show-also-correct>1</show-also-correct>
<process-for-rtl>0</process-for-rtl>
<include-scorm-12>0</include-scorm-12>
</global>
</hotpot-config-file>
</hotpot-jquiz-file>

	'''
}
