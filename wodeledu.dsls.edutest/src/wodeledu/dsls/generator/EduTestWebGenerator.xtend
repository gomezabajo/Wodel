/*
 * generated by Xtext 2.13.0
 */
package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import wodel.utils.manager.ModelManager
import edutest.Program
import edutest.AlternativeResponse
import edutest.MultiChoiceDiagram
import edutest.MultiChoiceEmendation
import java.net.URL
import org.eclipse.core.runtime.FileLocator
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.URI
import wodel.utils.exceptions.ModelNotFoundException
import org.osgi.framework.Bundle
import org.eclipse.core.runtime.Platform
import java.util.List
import wodeledu.dsls.generator.EduTestSuperGenerator.TestOption
import wodeledu.dsls.generator.EduTestSuperGenerator.Registry
import java.util.HashMap
import edutest.Test
import java.util.ArrayList
import edutest.Order
import java.util.Collections
import java.util.Comparator
import edutest.Mode
import edutest.Navigation
import org.eclipse.emf.ecore.EClass

/**
 * @author Pablo Gomez-Abajo - eduTest code generator.
 * 
 * Generates the javascript and html code for the
 * test exercises application
 *  
 */
class EduTestWebGenerator extends EduTestSuperGenerator {
	private String fileName
	private String pageName
	private int num
	private List<EObject> blocks
	private List<EPackage> metamodel
	private List<EClass> roots

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		try {
			var i = 0;
			//loads the mutator model
			var xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath + "/" + project.name +
			"/" + ModelManager.getOutputFolder + "/" + resource.URI.lastSegment.replaceAll(".test", ".model")
			val Bundle bundle = Platform.getBundle("wodel.models")
	   		val URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore")
	   		val String mutatorecore = FileLocator.resolve(fileURL).getFile()
			//val String mutatorecore = ModelManager.getWorkspaceAbsolutePath + "/" + project.name + "/resources/MutatorEnvironment.ecore";
			val List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore)
			//val EPackage epackage = mutatorpackages.get(0);
			//EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
			val Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString)
			blocks = ModelManager.getObjectsOfType("Block", mutatormodel)

			for (p : resource.allContents.toIterable.filter(Program)) {
				if (i == 0) {
					fileName = 'html/' + resource.URI.lastSegment.replaceAll(".test", "") + '.html'
					pageName = resource.URI.lastSegment.replaceAll(".test", "") + '.html'
				} else {
					fileName = 'html/' + resource.URI.lastSegment.replaceAll(".test", "") + i + '.html'
					pageName = resource.URI.lastSegment.replaceAll(".test", "") + i + '.html'
				}
				metamodel = new ArrayList<EPackage>()
				metamodel.addAll(ModelManager.loadMetaModel(p.metamodel))
				roots = new ArrayList<EClass>()
				roots.addAll(ModelManager.getRootEClasses(metamodel))
				fsa.generateFile(fileName, removeComments(p.compile(resource)))
				i++
			}
		}
		catch (ModelNotFoundException e) {
		}
	}

	def compile(Program program, Resource resource) '''
		<!--«buildOptions(program, resource, blocks, roots, program.class)»-->
		<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
		<html xmlns="http://www.w3.org/1999/xhtml">
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link type="text/css" rel="stylesheet" href="css/wodel.css" />
        <link type="text/css" rel="stylesheet" href="css/menu.css" />
        <link type="text/css" rel="stylesheet" href="css/table.css" />
        <title>Wodel</title>
    	</head>
    	<body style="background-color: white;">
    	<script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
    	<script language="javascript" type="text/javascript">
		if (!String.prototype.startsWith) {
  			String.prototype.startsWith = function(searchString, position) {
    			position = position || 0;
    			return this.indexOf(searchString, position) === position;
  			};
		}
    	// Pass the checkbox name to the function
		function getCheckedBoxes(chkboxName) {
			var checkboxes = document.getElementsByName(chkboxName);
			var checkboxesChecked = [];
			// loop over them all
			for (var i=0; i<checkboxes.length; i++) {
				// And stick the checked ones onto an array...
				if (checkboxes[i].checked) {
					checkboxesChecked.push(checkboxes[i]);
				}
			}
			// Return the array if it is non-empty, or null
			return checkboxesChecked.length > 0 ? checkboxesChecked : null;
		}
   		function show(part) {
		    //«var int part = 0»
    		«FOR exercise : program.exercises»
    		//«part++»
   			var test = document.getElementById('table-test-«part»');
   			if (test != null) {
	    		if (part == «part») {
    				test.style.display = 'block';
    			}
	    		else {
	    			test.style.display = 'none';
	    		}
    		}
    		«ENDFOR»
    	}
	    //«part = 0»
		«FOR exercise : program.exercises»
		//«part++»
		//«var List<Test> ltests = new ArrayList<Test>()»
		«IF exercise instanceof MultiChoiceEmendation»
		«/* GENERATES THE PUNTUATION FOR EACH TEST */»
		//«var points = new HashMap<Test, Double>()»
		«FOR test : exercise.tests»
			«IF options.get(exercise).get(test) !== null»
				«IF total.get(exercise) !== null»
					//«points.put(test, 1.0 * options.get(exercise).get(test).size / total.get(exercise))»
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		//«puntuation.put(exercise, points)»
		«/* GENERATES THE PENALTY FOR EACH TEST */»
		//«var penal = new HashMap<Test, Double>()»
		«FOR test : exercise.tests»
			«IF exercise instanceof MultiChoiceEmendation»
			«IF puntuation.get(exercise).get(test) !== null»
			//«penal.put(test, puntuation.get(exercise).get(test) * exercise.config.penalty)»
			«ELSE»
			//«penal.put(test, 0.0)»
			«ENDIF»
			«ENDIF»
			«IF exercise instanceof AlternativeResponse»
			//«penal.put(test, 0.0)»
			«ENDIF»
			«IF exercise instanceof MultiChoiceDiagram»
			//«penal.put(test, 0.0)»
			«ENDIF»
		«ENDFOR»
		//«penalty.put(exercise, penal)»
		«/* REORDERS THE TESTS */»
		«FOR test : exercise.tests»
			//«ltests.add(test)»
		«ENDFOR»
		«IF exercise.config.order == Order.FIXED»
		«/* DO NOTHING */»
		«ENDIF»
		«IF exercise.config.order == Order.RANDOM»
		//«Collections.shuffle(ltests)»
		«ENDIF»
		«IF exercise.config.order == Order.ASCENDING»
		//«Collections.sort(ltests, new Comparator<Test>() {
			override compare(Test t1, Test t2) {
				if (options.get(exercise).get(t1) !== null && options.get(exercise).get(t2) !== null) {
					return options.get(exercise).get(t1).size - options.get(exercise).get(t2).size
				}
				return 0
			}
		})»
		«ENDIF»
		«IF exercise.config.order == Order.DESCENDING»
		//«Collections.sort(ltests, new Comparator<Test>() {
			override compare(Test t1, Test t2) {
				if (options.get(exercise).get(t1) !== null && options.get(exercise).get(t2) !== null) {
					return options.get(exercise).get(t2).size - options.get(exercise).get(t1).size
				}
				return 0
			}
		})»
		«ENDIF»
		«ENDIF»
		«IF exercise instanceof AlternativeResponse»
		//«ltests.addAll(exercise.tests)»
		«ENDIF»
		«IF exercise instanceof MultiChoiceDiagram»
		//«ltests.addAll(exercise.tests)»
		«ENDIF»
		//«tests.put(exercise, ltests)»
		var currentTotal«part» = «exercise.tests.size»;
		//COUNTER: «num = 0»
		«FOR test : tests.get(exercise)»
   		//COUNTER: «num = num + 1»
   		var exercise«num»_«part»Mark = false;
   		«IF exercise instanceof MultiChoiceEmendation»
   		«IF puntuation.get(exercise).get(test) !== null»
   		var weight«num»_«part»Mark = «puntuation.get(exercise).get(test)»;
   		«ELSE»
   		var weight«num»_«part»Mark = 0.0;
   		«ENDIF»
   		«ENDIF»
   		var answered«num»_«part»Exercise = false;
   		«IF exercise instanceof MultiChoiceEmendation»
   		«IF penalty.get(exercise).get(test) !== null»
   		var penalty«num»_«part»Mark = «penalty.get(exercise).get(test)»;
   		«ELSE»
   		var penalty«num»_«part»Mark = 0.0;
   		«ENDIF»
   		«ENDIF»
   		«ENDFOR»
   		function show«part»(num) {
    		var exercise = null;
    		//COUNTER: «num = 0»
    		«FOR test : tests.get(exercise)»
    		//COUNTER: «num = num + 1»
    		exercise = document.getElementById('exercise-«num»-«part»');
    		if (num == «num») {
    			exercise.style.display = 'block';
    		}
    		else {
    			exercise.style.display = 'none';
    		}
    		«ENDFOR»
    	}
    	«IF exercise instanceof AlternativeResponse»
    	function right«part»(num, diagram) {
    		var image = null;
	    	var currentMark = 0;
    		//COUNTER: «num = 0»
    		«FOR test : tests.get(exercise)»
    		//COUNTER: «num = num + 1»
    		«IF rand.get(exercise).get(test).size() > 0»
    		//KEY: «var EClass eclass = new ArrayList<EClass>(rand.get(exercise).get(test).keySet()).get(0)»
			//DIAGRAM: «var String diagram = rand.get(exercise).get(test).get(eclass).get(0)»
    		image = document.getElementById('td-exercise-«num»-«part»-«diagram.replace('/', '-')»');
    		if (num == «num») {
    			«IF diagram.indexOf('/') > 0»
    			if (diagram == '«diagram.substring(diagram.indexOf('/') + 1)»') {
    			«ELSE»
    			if (diagram == '«diagram»') {
    			«ENDIF»
    				image.style.border = '1px solid #000000';
    				if (diagram == '«test.source.replace('.model', '.png')»') {
    					exercise«num»_«part»Mark = true;
    					document.getElementById('td-score-null-«num»-«part»').style.display = 'none';
    					document.getElementById('td-score-accept-«num»-«part»').style.display = 'block';
    					document.getElementById('td-score-wrong-«num»-«part»').style.display = 'none';
    					document.getElementById('mark-«num»-«part»').innerHTML = '<img src="images/accept.png" alt="ok" style="height: 40px; width: 40px;" />';
    				}
    				else {
    					exercise«num»Mark = false;
    					document.getElementById('td-score-null-«num»-«part»').style.display = 'none';
    					document.getElementById('td-score-accept-«num»-«part»').style.display = 'none';
    					document.getElementById('td-score-wrong-«num»-«part»').style.display = 'block';
    					document.getElementById('mark-«num»-«part»').innerHTML = '<img src="images/wrong.png" alt="error" style="height: 40px; width: 40px;" />';
    				}
    			}
	    		else {
    				image.style.border = '';
    			}
    			«IF exercise.config.retry == false»
	    		document.getElementById('a-right-«num»-«part»-«diagram.replace('/', '-')»').onclick = function() { return; }
	    		document.getElementById('a-wrong-«num»-«part»-«diagram.replace('/', '-')»').onclick = function() { return; }
	    		«ENDIF»
    		}
   			if (exercise«num»_«part»Mark == true) {
   				currentMark = currentMark + 1;
   			}
   			«ENDIF»
    		«ENDFOR»
    		if (document.getElementById('current-mark-«part»') !=!== null{
    			document.getElementById('current-mark-«part»').innerHTML = '<label class="text">Current mark: ' + currentMark + '/' + currentTotal«part» + '</label>';//SETS THE CURRENT MARK
    		}
			window.location.replace(window.location);
    	}
    	function wrong«part»(num, diagram) {
    		var image = null;
	    	var currentMark = 0;
    		//COUNTER: «num = 0»
    		«FOR test : tests.get(exercise)»
    		//COUNTER: «num = num + 1»
    		//KEY: «var EClass eclass = new ArrayList<EClass>(rand.get(exercise).get(test).keySet()).get(0)»
    		«IF rand.get(exercise).get(test).get(eclass).size > 0»
			//DIAGRAM: «var String diagram = rand.get(exercise).get(test).get(eclass).get(0)»
    		image = document.getElementById('td-exercise-«num»-«part»-«diagram.replace('/', '-')»');
    		if (num == «num») {
    			«IF diagram.indexOf('/') > 0»
    			if (diagram == '«diagram.substring(diagram.indexOf('/') + 1)»') {
    			«ELSE»
    			if (diagram == '«diagram»') {
    			«ENDIF»
    				image.style.border = '1px solid #000000';
    				if (diagram != '«test.source.replace('.model', '.png')»') {
    					exercise«num»_«part»Mark = true;
    					document.getElementById('td-score-null-«num»-«part»').style.display = 'none';
    					document.getElementById('td-score-accept-«num»-«part»').style.display = 'block';
    					document.getElementById('td-score-wrong-«num»-«part»').style.display = 'none';
    					document.getElementById('mark-«num»-«part»').innerHTML = '<img src="images/accept.png" alt="ok" style="height: 40px; width: 40px;" />';
    				}
    				else {
    					exercise«num»_«part»Mark = false;
    					document.getElementById('td-score-null-«num»-«part»').style.display = 'none';
    					document.getElementById('td-score-accept-«num»-«part»').style.display = 'none';
    					document.getElementById('td-score-wrong-«num»-«part»').style.display = 'block';
    					document.getElementById('mark-«num»-«part»').innerHTML = '<img src="images/wrong.png" alt="error" style="height: 40px; width: 40px;" />';
    				}
    			}
	    		else {
    				image.style.border = '';
    			}
    			«IF exercise.config.retry == false»
	    		document.getElementById('a-right-«num»-«part»-«diagram.replace('/', '-')»').onclick = function() { return; }
	    		document.getElementById('a-wrong-«num»-«part»-«diagram.replace('/', '-')»').onclick = function() { return; }
	    		«ENDIF»
    		}
   			if (exercise«num»_«part»Mark == true) {
   				currentMark = currentMark + 1;
   			}
   			«ENDIF»
    		«ENDFOR»
    		if (document.getElementById('current-mark-«part»') != null) {
    			document.getElementById('current-mark-«part»').innerHTML = '<label class="text">Current mark: ' + currentMark + '/' + currentTotal«part» + '</label>';//SETS THE CURRENT MARK
    		}
			window.location.replace(window.location);
    	}
    	«ENDIF»
    	«IF exercise instanceof MultiChoiceDiagram»
    	function check«part»(num, diagram) {
    		var image = null;
	    	var currentMark = 0;
    		//COUNTER: «num = 0»
    		«FOR test : tests.get(exercise)»
    		//COUNTER: «num = num + 1»
    		//KEY: «var EClass eclass = new ArrayList<EClass>(rand.get(exercise).get(test).keySet()).get(0)»
			«FOR String diagram : diagrams.get(exercise).get(test).get(eclass)»
    		image = document.getElementById('td-exercise-«num»-«part»-«diagram.replace('/', '-')»');
    		if (num == «num») {
    			«IF diagram.indexOf('/') > 0»
    			if (diagram == '«diagram.substring(diagram.indexOf('/') + 1)»') {
    			«ELSE»
    			if (diagram == '«diagram»') {
    			«ENDIF»
    				image.style.border = '1px solid #000000';
    				if (diagram == '«test.source.replace('.model', '.png')»') {
    					exercise«num»_«part»Mark = true;
    					document.getElementById('td-score-null-«num»-«part»').style.display = 'none';
    					document.getElementById('td-score-accept-«num»-«part»').style.display = 'block';
    					document.getElementById('td-score-wrong-«num»-«part»').style.display = 'none';
    					document.getElementById('mark-«num»-«part»').innerHTML = '<img src="images/accept.png" alt="ok" style="height: 40px; width: 40px;" />';
    				}
    				else {
    					exercise«num»_«part»Mark = false;
    					document.getElementById('td-score-null-«num»-«part»').style.display = 'none';
    					document.getElementById('td-score-accept-«num»-«part»').style.display = 'none';
    					document.getElementById('td-score-wrong-«num»-«part»').style.display = 'block';
    					document.getElementById('mark-«num»-«part»').innerHTML = '<img src="images/wrong.png" alt="wrong" style="height: 40px; width: 40px;" />';
    				}
    			}
	    		else {
    				image.style.border = '';
    			}
    			«IF exercise.config.retry == false»
	    		document.getElementById('a-exercise-«num»-«part»-«diagram.replace('/', '-')»').onclick = function() { return; }
	    		«ENDIF»
    		}
    		«ENDFOR»
   			if (exercise«num»_«part»Mark == true) {
   				currentMark = currentMark + 1;
   			}
    		«ENDFOR»
    		if (document.getElementById('current-mark-«part»') != null) {
    			document.getElementById('current-mark-«part»').innerHTML = '<label class="text">Current mark: ' + currentMark + '/' + currentTotal«part» + '</label>';//SETS THE CURRENT MARK
    		}
			window.location.replace(window.location);
    	}
    	«ENDIF»
    	«IF exercise instanceof MultiChoiceEmendation»
    	function submit«part»(num, diagram) {
	    	var currentMark = 0;
	    	var weightedMark = 0.0;
	    	var penaltyMark = 0.0;
    		//COUNTER: «num = 0»
    		«FOR test : tests.get(exercise)»
    		//COUNTER: «num = num + 1»
    		if (num == «num») {
    			var answered«num»_«part»Exercise = false;
				//«var String diagram = ''»
				«IF options.get(exercise).get(test) !== null»
				«FOR opt : options.get(exercise).get(test)»
				«IF opt.solution == true»
				//«diagram = opt.path»
				«ENDIF»
				«ENDFOR»
				«ENDIF»
    			if (diagram == '«diagram.replace('/', '-')»') {
					var correction = true;
    				«IF exercise.config.mode == Mode.CHECKBOX»
   					var checkboxes = document.getElementsByName('checkbox-«num»-«part»-«diagram.replace('/', '-')»');
   					if (getCheckedBoxes('checkbox-«num»-«part»-«diagram.replace('/', '-')»') == null) {
   						correction = false;
   					}
   					else {
   						for (var i = 0; i < checkboxes.length; i++) {
   							var value = checkboxes[i].value;
   							if (value.startsWith('«diagram.replace('/', '-')»') == true) {
   								if (checkboxes[i].checked == false) {
   									correction = false;
   									break;
   								}
   							}
   							else {
   								if (checkboxes[i].checked == true) {
   									correction = false;
   									break;
   								}
   							}
   						}
   					}
   					«ELSEIF exercise.config.mode == Mode.RADIOBUTTON»
   					var radiobuttons = document.getElementsByName('radiobutton-«num»-«part»-«diagram.replace('/', '-')»');
   					if (getCheckedBoxes('radiobutton-«num»-«part»-«diagram.replace('/', '-')»') == null) {
   						correction = false;
   					}
   					else {
   						for (var i = 0; i < radiobuttons.length; i++) {
   							var value = radiobuttons[i].value;
   							if (value.startsWith('«diagram.replace('/', '-')»') == true) {
   								if (radiobuttons[i].checked == false) {
   									correction = false;
   									break;
   								}
   							}
   							else {
   								if (radiobuttons[i].checked == true) {
   									correction = false;
   									break;
   								}
   							}
   						}
   					}
   					«ENDIF»
					if (correction == true) {
						exercise«num»_«part»Mark = true;
						document.getElementById('td-score-null-«num»-«part»').style.display = 'none';
						document.getElementById('td-score-accept-«num»-«part»').style.display = 'block';
						document.getElementById('td-score-wrong-«num»-«part»').style.display = 'none';
						document.getElementById('mark-«num»-«part»').innerHTML = '<img src="images/accept.png" alt="ok" style="height: 40px; width: 40px;" />';
					}
   					else {
						exercise«num»_«part»Mark = false;
						document.getElementById('td-score-null-«num»-«part»').style.display = 'none';
						document.getElementById('td-score-accept-«num»-«part»').style.display = 'none';
						document.getElementById('td-score-wrong-«num»-«part»').style.display = 'block';
						document.getElementById('mark-«num»-«part»').innerHTML = '<img src="images/wrong.png" alt="error" style="height: 40px; width: 40px;" />';
					}
					answered«num»_«part»Exercise = true;
    			}
   				«IF exercise.config.retry == false»
   				if (document.getElementById('a-submit-«num»-«part»-«diagram.replace('/', '-')»') != null) {
    				document.getElementById('a-submit-«num»-«part»-«diagram.replace('/', '-')»').onclick = function() { return; }
    			}
    			«ENDIF»
	   		}
  			if (exercise«num»_«part»Mark == true) {
				currentMark = currentMark + 1;
				weightedMark = weightedMark + weight«num»_«part»Mark;
			}
			if ((answered«num»_«part»Exercise == true) && (exercise«num»_«part»Mark == false)) {
				penaltyMark = penaltyMark + penalty«num»_«part»Mark;
			}
			«ENDFOR»
		   	if (document.getElementById('current-mark-«part»') != null) {
    			document.getElementById('current-mark-«part»').innerHTML = '<label class="text">Current mark: ' + currentMark + '/' + currentTotal«part» + '</label>';//SETS THE CURRENT MARK
    		}
    		var tempMark = weightedMark - penaltyMark;
    		if (tempMark < 0) {
    			tempMark = 0.0;
    		}
    		if (document.getElementById('weighted-mark-«part»') != null) {
    			document.getElementById('weighted-mark-«part»').innerHTML = '<label class="text">Current mark: ' + Math.round(tempMark * 100) + '%</label>';//SETS THE WEIGHTED MARK
    		}
   			window.location.replace(window.location);
    	}
    	«ENDIF»
    	«ENDFOR»
	    </script>
	    <!--«part = 0»-->
		«FOR exercise : program.exercises»
		<!--«part++»-->
		«IF part == 1»
	    <table class="table-test-«part»" id="table-test-«part»" style="height: 100%; display: block;">
	    «ELSE»
	    <table class="table-test-«part»" id="table-test-«part»" style="height: 100%; display: none;">
	    «ENDIF»
	    «IF program.config !== null»
	    «IF program.config.navigation == Navigation.FREE»
		«IF part > 1»
		<tr>
		<td align="left">
		<a href="#" class="test-back-«part - 1»" id="test-back-«part - 1»" onclick="show(«part - 1»);"><img src="images/back.png" alt="back" style="height: 30px; width: 30px;" /></a>
		</td>
		</tr>
		«ENDIF»
		«ENDIF»
		«ENDIF»
		«IF part < program.exercises.length»
		<tr>
		<td align="left">
		<a href="#" class="test-continue-«part + 1»" id="test-continue-«part + 1»" onclick="show(«part + 1»);"><img src="images/continue.png" alt="continue" style="height: 30px; width: 30px;" /></a>
		</td>
		</tr>
		«ENDIF»
	    <tr>
		«IF exercise instanceof AlternativeResponse»
    	«exercise.showone(part)»
	    «ENDIF»
		«IF exercise instanceof MultiChoiceDiagram»
    	«exercise.showall(part)»
	    «ENDIF»
	    «IF exercise instanceof MultiChoiceEmendation»
    	«exercise.show(part)»
	    «ENDIF»
		</tr>
		</table>
	    «ENDFOR»
		</body>
		</html>
	'''
	
	def showone(AlternativeResponse ss, int part) '''
	    <td valign="top">
	    <div id="pretty-menu">
	    <ul>
    	<!--COUNTER: «num = 0»--> 
		«FOR test : ss.tests»
			<!--COUNTER: «num = num + 1»-->
			<li class="score-«num»-«part»">
			<table class="score-«num»-«part»" id="score-«num»-«part»">
			<tr>
			<td id="td-score-null-«num»-«part»" style="display: block;">
			<img src="images/null.png" alt="null" style="height: 40px; width: 40px;" />
			</td>
			<td id="td-score-accept-«num»-«part»" style="display: none;">
			<img src="images/accept.png" alt="ok" style="height: 40px; width: 40px;" />
			</td>
			<td id="td-score-wrong-«num»-«part»" style="display: none;">
			<img src="images/wrong.png" alt="error" style="height: 40px; width: 40px;" />
			</td>
			<td>
			<a href="#" class="ex-«num»-«part»" id="ex-«num»-«part»" onclick="show«part»(«num»);">Exercise «num»</a>
			</td>
			</tr>
			</table>
			</li>
		«ENDFOR»
		<li><p class="current-mark-«part»" id="current-mark-«part»"></p></li>
		</ul>
		</div>
		</td>
    	<!--COUNTER: «num = 0»--> 
		«FOR test : ss.tests»
    		<!--KEY: «var EClass eclass = new ArrayList<EClass>(rand.get(ss).get(test).keySet()).get(0)»-->
			«IF rand.get(ss).get(test).get(eclass).size > 0»
    		<!--DIAGRAM: «var diagram = rand.get(ss).get(test).get(eclass).get(0)»-->
			<!--COUNTER: «num = num + 1»-->
			<td class="exercise-«num»-«part»" id="exercise-«num»-«part»" valign="top" style="display: none;">
			<fieldset valign="top">
			<legend class="text"><font color="black">«test.question»&nbsp;&nbsp;&nbsp;<div class="mark-«num»-«part»" id="mark-«num»-«part»"></div></font></legend>
			<table class="pretty">
			<tr>
			<td valign="top">
			<table class="pretty">
			<tr>
			<td id="td-exercise-«num»-«part»-«diagram.replace('/', '-')»" valign="top">
			<img src="diagrams/«test.source.replace('.model', '')»/«diagram»" title="exercise-«num»-«part»-«diagram.replace('/', '-')»" id="exercise-«num»-«part»-«diagram.replace('/', '-')»" name="exercise-«num»-«part»-«diagram.replace('/', '-')»" class="images" />
			</td>
			</tr>
			</table>
			</td>
			</tr>
			<tr>
			<td>
			<table class="pretty" width="100%">
			<tr>
			<td id="td-right-«num»-«part»-«diagram.replace('/', '-')»" valign="top" style="text-align:left">
			«IF diagram.indexOf('/') > 0»
			<a href="#" class="a-right-«num»-«part»-«diagram.replace('/', '-')»" id="a-right-«num»-«part»-«diagram.replace('/', '-')»" onclick="right«part»(«num»,'«diagram.substring(diagram.indexOf('/') + 1)»');"><img src="images/accept.png" alt="accept" style="height: 40px; width: 40px;" class="images" /></a>
			«ELSE»
			<a href="#" class="a-right-«num»-«part»-«diagram.replace('/', '-')»" id="a-right-«num»-«part»-«diagram.replace('/', '-')»" onclick="right«part»(«num»,'«diagram»');"><img src="images/accept.png" alt="accept" style="height: 40px; width: 40px;" class="images" /></a>
			«ENDIF»
			</td>
			<td id="td-wrong-«num»-«diagram»" valign="top" style="text-align:right">
			«IF diagram.indexOf('/') > 0»
			<a href="#" class="a-wrong-«num»-«part»-«diagram.replace('/', '-')»" id="a-wrong-«num»-«part»-«diagram.replace('/', '-')»" onclick="wrong«part»(«num»,'«diagram.substring(diagram.indexOf('/') + 1)»');"><img src="images/wrong.png" alt="wrong" style="height: 40px; width: 40px;" class="images" /></a>
			«ELSE»
			<a href="#" class="a-wrong-«num»-«part»-«diagram.replace('/', '-')»" id="a-wrong-«num»-«part»-«diagram.replace('/', '-')»" onclick="wrong«part»(«num»,'«diagram»');"><img src="images/wrong.png" alt="wrong" style="height: 40px; width: 40px;" class="images" /></a>
			«ENDIF»
			</td>
			</tr>
			</table>
			</td>
			</tr>
			</table>
			</fieldset>
			</td>
			«ENDIF»
		«ENDFOR»
	'''
	
	def showall(MultiChoiceDiagram ss, int part) '''
	    <td valign="top">
	    <div id="pretty-menu">
	    <ul>
    	<!--COUNTER: «num = 0»--> 
		«FOR test : ss.tests»
			<!--COUNTER: «num = num + 1»-->
			<li class="score-«num»-«part»">
			<table class="score-«num»-«part»" id="score-«num»-«part»">
			<tr>
			<td id="td-score-null-«num»-«part»" style="display: block;">
			<img src="images/null.png" alt="null" style="height: 40px; width: 40px;" />
			</td>
			<td id="td-score-accept-«num»-«part»" style="display: none;">
			<img src="images/accept.png" alt="ok" style="height: 40px; width: 40px;" />
			</td>
			<td id="td-score-wrong-«num»-«part»" style="display: none;">
			<img src="images/wrong.png" alt="error" style="height: 40px; width: 40px;" />
			</td>
			<td>
			<a href="#" class="ex-«num»-«part»" id="ex-«num»-«part»" onclick="show«part»(«num»);">Exercise «num»</a>
			</td>
			</tr>
			</table>
			</li>
		«ENDFOR»
		<li><p class="current-mark-«part»" id="current-mark-«part»"></p></li>
		</ul>
		</div>
		</td>
    	<!--COUNTER: «num = 0»--> 
		«FOR test : ss.tests»
			<!--COUNTER: «num = num + 1»-->
			<td class="exercise-«num»-«part»" id="exercise-«num»-«part»" valign="top" style="display: none;">
			<fieldset valign="top">
			<legend class="text"><font color="black">«test.question»&nbsp;&nbsp;&nbsp;<div class="mark-«num»-«part»" id="mark-«num»-«part»"></div></font></legend>
			<table class="pretty">
			<tr>
			<td valign="top">
			<table class="pretty">
			<tr>
    		<!--KEY: «var EClass eclass = new ArrayList<EClass>(rand.get(ss).get(test).keySet()).get(0)»-->
			«FOR String diagram : rand.get(ss).get(test).get(eclass)»
			<td id="td-exercise-«num»-«part»-«diagram.replace('/', '-')»" valign="top">
			«IF diagram.indexOf('/') > 0»
			<a href="#" class="a-exercise-«num»-«part»-«diagram.replace('/', '-')»" id="a-exercise-«num»-«part»-«diagram.replace('/', '-')»" onclick="check«part»(«num»,'«diagram.substring(diagram.indexOf('/') + 1)»');"><img src="diagrams/«test.source.replace('.model', '')»/«diagram»" title="exercise-«num»-«diagram.replace('/', '-')»" id="exercise-«num»-«diagram.replace('/', '-')»" name="exercise-«num»-«diagram.replace('/', '-')»" class="images" /></a>
			«ELSE»
			<a href="#" class="a-exercise-«num»-«part»-«diagram.replace('/', '-')»" id="a-exercise-«num»-«part»-«diagram.replace('/', '-')»" onclick="check«part»(«num»,'«diagram»');"><img src="diagrams/«test.source.replace('.model', '')»/«diagram»" title="exercise-«num»-«diagram.replace('/', '-')»" id="exercise-«num»-«diagram.replace('/', '-')»" name="exercise-«num»-«diagram.replace('/', '-')»" class="images" /></a>
			«ENDIF»
			</td>
			«ENDFOR»
			</tr>
			</table>
			</td>
			</tr>
			</table>
			</fieldset>
			</td>
		«ENDFOR»
	'''

	def show(MultiChoiceEmendation sc, int part) '''
	    <td valign="top">
	    <div id="pretty-menu">
	    <ul>
    	<!--COUNTER: «num = 0»--> 
		«FOR test : tests.get(sc)»
			<!--COUNTER: «num = num + 1»-->
			<li class="score-«num»-«part»">
			<table class="score-«num»-«part»" id="score-«num»-«part»">
			<tr>
			<td id="td-score-null-«num»-«part»" style="display: block;">
			<img src="images/null.png" alt="null" style="height: 40px; width: 40px;" />
			</td>
			<td id="td-score-accept-«num»-«part»" style="display: none;">
			<img src="images/accept.png" alt="ok" style="height: 40px; width: 40px;" />
			</td>
			<td id="td-score-wrong-«num»-«part»" style="display: none;">
			<img src="images/wrong.png" alt="error" style="height: 40px; width: 40px;" />
			</td>
			<td>
			<a href="#" class="ex-«num»-«part»" id="ex-«num»-«part»" onclick="show«part»(«num»);">Exercise «num»</a>
			</td>
			</tr>
			</table>
			</li>
		«ENDFOR»
		«IF sc.config.weighted == false»
		<li><p class="current-mark-«part»" id="current-mark-«part»"></p></li>
		<li><p class="weighted-mark-«part»" id="weighted-mark-«part»" style="display: none;"></p></li>
		«ENDIF»
		«IF sc.config.weighted == true»
		<li><p class="current-mark-«part»" id="current-mark-«part»" style="display: none;"></p></li>
		<li><p class="weighted-mark-«part»" id="weighted-mark-«part»"></p></li>
		«ENDIF»
		</ul>
		</div>
		</td>
    	<!--COUNTER: «num = 0»--> 
		«FOR test : tests.get(sc)»
			<!--«var String diagram = ''»-->
			«IF (options.get(sc).get(test) !== null)»
			«FOR opt : options.get(sc).get(test)»
			«IF opt.solution == true»
				<!--«diagram = opt.path»-->
			«ENDIF»
			«ENDFOR»
			«ENDIF»
			<!--COUNTER: «num = num + 1»-->
			<td class="exercise-«num»-«part»" id="exercise-«num»-«part»" valign="top" style="display: none;">
			<fieldset valign="top">
			<legend class="text"><font color="black">«test.question»&nbsp;&nbsp;&nbsp;<div class="mark-«num»-«part»" id="mark-«num»-«part»"></div></font></legend>
			<table class="pretty">
			<tr>
			<td valign="top">
			<table class="pretty">
			<tr>
			<td id="td-exercise-«num»-«part»-«diagram.replace('/', '-')»" valign="top">
			<img src="«diagram»" title="exercise-«num»-«part»-«diagram.replace('/', '-')»" id="exercise-«num»-«part»-«diagram.replace('/', '-')»" name="exercise-«num»-«part»-«diagram.replace('/', '-')»" class="images" />
			</td>
			</tr>
			</table>
			</td>
			</tr>
			<tr>
			<td>
			<table class="pretty" width="100%">
			<!--«var i = 0»-->
			«IF options.get(sc).get(test) !== null»
			«FOR opt : options.get(sc).get(test)»
			«IF sc.config.mode == Mode.CHECKBOX»
			«IF opt.text.size > 0»
			<tr>
			<td valign="top" style="text-align:left">
			<input type="checkbox" name="checkbox-«num»-«part»-«diagram.replace('/', '-')»" value="«opt.path.replace('/', '-')»-«i»" />
			«opt.text.get(0)»
			<!--«i++»-->
			<td>
			</tr>
			«ENDIF»
			«ELSEIF sc.config.mode == Mode.RADIOBUTTON»
			<tr>
			<td valign="top" style="text-align:left">
			<input type="radio" name="radiobutton-«num»-«part»-«diagram.replace('/', '-')»" value="«opt.path.replace('/', '-')»-«i»" />
			<!--«var j = 0»-->
			«FOR text : opt.text.get(0)»
			«IF j < opt.text.get(0).size»
			«text»<br/>
			«ELSE»
			«text»
			«ENDIF»
			<!--«j++»-->
			«ENDFOR»
			<!--«i++»-->
			<td>
			</tr>
			«ENDIF»
			«ENDFOR»
			«ENDIF»
			</table>
			</td>
			</tr>
			<tr>
			<td>
			<table class="pretty" width="100%">
			<tr>
			<td id="td-submit-«num»-«part»-«diagram.replace('/', '-')»" valign="top" style="text-align:left">
			<a href="#" class="a-submit-«num»-«part»-«diagram.replace('/', '-')»" id="a-submit-«num»-«part»-«diagram.replace('/', '-')»" onclick="submit«part»(«num»,'«diagram.replace('/', '-')»');"><img src="images/submit.png" alt="submit" style="height: 40px; width: 160px;" class="images" /></a>
			</td>
			</tr>
			</table>
			</td>
			</tr>
			</table>
			</fieldset>
			</td>
		«ENDFOR»
	'''
}
