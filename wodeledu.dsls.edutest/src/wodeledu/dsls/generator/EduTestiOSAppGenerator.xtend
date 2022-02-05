package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import manager.ModelManager
import org.osgi.framework.Bundle
import org.eclipse.core.runtime.Platform
import java.net.URL
import org.eclipse.core.runtime.FileLocator
import java.util.List
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EObject
import exceptions.ModelNotFoundException
import org.eclipse.emf.common.util.URI
import edutest.Program
import edutest.AlternativeResponse
import java.util.TreeMap
import manager.WodelContext
import manager.IOUtils
import java.io.File

class EduTestiOSAppGenerator extends EduTestSuperGenerator {
	
	private List<EObject> blocks
	private String questionsSwift
	private String viewControllerSwift
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		manager.WodelContext.setProject(null)
		ModelManager.setProjectNameByResource(resource)
		try {
			var i = 0;
			//loads the mutator model
			var xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath + "/" + manager.WodelContext.getProject +
			"/" + ModelManager.getOutputFolder + "/" + resource.URI.lastSegment.replaceAll(".test", ".model")
			val Bundle bundle = Platform.getBundle("wodel.models")
	   		val URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore")
	   		val String mutatorecore = FileLocator.resolve(fileURL).getFile()
			//val String mutatorecore = ModelManager.getWorkspaceAbsolutePath + "/" + WodelContext.getProject() + "/resources/MutatorEnvironment.ecore";
			val List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore)
			//val EPackage epackage = mutatorpackages.get(0);
			//EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
			val Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString)
			blocks = ModelManager.getObjectsOfType("Block", mutatormodel)
			
			for (p : resource.allContents.toIterable.filter(Program)) {
				if (i == 0) {
					viewControllerSwift = '../app/ios/tfgApp/ViewController.swift'
					questionsSwift = '../app/ios/tfgApp/Questions.swift'
				} else {
					viewControllerSwift = '../app/ios/tfgApp/ViewController.swift'
					questionsSwift = '../app/ios/tfgApp/Questions.swift'
				}
				fsa.generateFile(viewControllerSwift, p.compile(resource, fsa))
				fsa.generateFile(questionsSwift, p.compileQuestions(resource))
				i++
			}
		}
		catch (ModelNotFoundException e) {
		}
	}

	/*iOSApp code will be generated here!!*/
	def compile(Program program, Resource resource, IFileSystemAccess2 fsa) '''
		«{buildOptions(program, resource, blocks, program.class); ""}»
		«var TreeMap<Integer, String> drawable = new TreeMap()»
		«var TreeMap<Integer, TreeMap<Integer,String>> drawableAnswer = new TreeMap()»
		«var int i = 0»
		«FOR exercise : program.exercises»
			«IF exercise instanceof AlternativeResponse»
				«FOR test : exercise.tests»
					«IF rand.get(exercise).get(test).size() > 0»
						«var diagram = rand.get(exercise).get(test).get(0)»
						«var String diagramFolderName = ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/app/ios/tfgApp/Assets.xcassets/ejercicio" + i + ".imageset/"»
						«var File diagramFolder = new File(diagramFolderName)»
						«IF diagramFolder.exists() == false»
						«{diagramFolder.mkdir(); ""}»
						«ENDIF»
						«var String diagramFileName = ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/app/ios/tfgApp/Assets.xcassets/ejercicio" + i + ".imageset/ejercicio" + i + ".png"»
						«IOUtils.copyFile(new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram), new File(diagramFileName))»
						«var String jsonDiagramFileName = "../app/ios/tfgApp/Assets.xcassets/ejercicio" + i + ".imageset/Contents.json"»
						«fsa.generateFile(jsonDiagramFileName, diagramFileName.substring(diagramFileName.lastIndexOf("/") + 1, diagramFileName.length).compileJsonDiagramFile)»  
						«drawable.put(i, "ejercicio" + i + ".png")»
						«{i++; ""}»
					«ENDIF»
				«ENDFOR»
			«ENDIF»
		«ENDFOR»
import UIKit

class ViewController: UIViewController {

    //UI TRUE FALSE
    @IBOutlet weak var rbtnTrueFalse1: UIButton!
    @IBOutlet weak var rbtnTrueFalse2: UIButton!
    @IBOutlet weak var labelTrueFalse1: UILabel!
    @IBOutlet weak var labelTrueFalse2: UILabel!
    //UI MULTISELECCION (usamos las de true/false)
    
    @IBOutlet weak var imageEx: UIImageView!
    @IBOutlet weak var textQuestion : UILabel!
    @IBOutlet weak var backButton: UIButton!
    @IBOutlet weak var nextButton: UIButton!
    // FIN UI
    
    
    //private var idsAnswersRadio = [Int]()
    //private var idsanswersCheck = [Int]()
    private var idsAnswersFalseTrue = [Int]()
    //private var idsAnswerDesplegable = [Int]()
    //private var idsAnswerDesplegableText = [Int]()
   // private var idsAnsweDesplegableSpinner = [Int]()
    private var statements = [Int : Int]()
    private var statementsAnswers = [Int : [Int : Int]]()
    private var btnNext = UIButton()
    private var btnPrevious = UIButton()
    private var type : Int = -1
    private var correctAnswer = [Int]()
    private var currentQuestion = Int()
    private var answerIsCorrect = Bool()
    private var userAllAnswers = [String]()
    private var nAnswers : Int = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        idsAnswersFalseTrue = [rbtnTrueFalse1.tag, rbtnTrueFalse2.tag]
        correctAnswer=[0,0,0,0,0,0]
        //Linkear todas las cosas que no tengo
        reset()
        showQuestion()
        
    }

    func reset() {
        answerIsCorrect = Bool()
        userAllAnswers = ["000000","000000","000000","000000","000000","000000","000000"]
        currentQuestion = 0
    }
    
    func showQuestion() {
        let question = allQuestions[currentQuestion]
        let partsQuestion = question.components(separatedBy: ";")
        textQuestion.text = partsQuestion[1]
        
        //ejercicios true false
        if (partsQuestion[0] == "2") {
            rbtnTrueFalse1.isHidden = false
            rbtnTrueFalse2.isHidden = false
            //rbtnTrueFalse1.isSelected = false
            rbtnTrueFalse2.isSelected = false
            correctAnswer = [0,0,0,0,0,0]

            //ocultar todas las cosas:
            imageEx.image = ResizeImage(UIImage(named: allQuestionsImages[currentQuestion])!, targetSize : CGSize(width: 300, height: 300))
            var answer1 = partsQuestion[2]
            
            var answer2 = partsQuestion[3]
            
            if(answer1.contains("*")) {
                answer1 = String(answer1.dropFirst())
                correctAnswer[0] = 1
                correctAnswer[1] = 0
            }
            else {
                answer2 = String(answer2.dropFirst())
                correctAnswer[0] = 0
                correctAnswer[1] = 1
            }
            labelTrueFalse1.text = answer1
            labelTrueFalse2.text = answer2
            if(Array(userAllAnswers[currentQuestion])[0] == "1"){
                rbtnTrueFalse1.isSelected = true
            }
            else {
                rbtnTrueFalse2.isSelected = true
            }
        }
        
    }
    
    @IBAction func rbtnAction(_ sender: UIButton) {
        if sender.tag == 2 {
            rbtnTrueFalse1.isSelected = true
            rbtnTrueFalse2.isSelected = false
        }
        else if sender.tag == 4 {
            rbtnTrueFalse1.isSelected = false
            rbtnTrueFalse2.isSelected = true
        }
    }
    
    @IBAction func backButtonAction(_ sender: UIButton) {
        if(currentQuestion > 0) {
            currentQuestion = currentQuestion - 1
            showQuestion()
        }
        
    }
    
    @IBAction func nextButtonAction(_ sender: UIButton) {
        currentQuestion = currentQuestion + 1
        showQuestion()
        
    }
    
    func ResizeImage(_ image: UIImage, targetSize: CGSize) -> UIImage? {
        let size = image.size

        let widthRatio  = targetSize.width  / image.size.width
        let heightRatio = targetSize.height / image.size.height

        // Figure out what our orientation is, and use that to form the rectangle
        var newSize: CGSize
        if(widthRatio > heightRatio) {
            newSize = CGSize(width: size.width * heightRatio, height: size.height * heightRatio)
        } else {
            newSize = CGSize(width: size.width * widthRatio, height: size.height * widthRatio)
        }

        // This is the rect that we've calculated out and this is what is actually used below
        let rect = CGRect(x: 0, y: 0, width: newSize.width, height: newSize.height)

        // Actually do the resizing to the rect using the ImageContext stuff
        UIGraphicsBeginImageContextWithOptions(newSize, false, 1.0)
        image.draw(in: rect)
        let newImage = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()

        return newImage
    }

}

	'''

	/*MobileApp code will be generated here!!*/
	def compileQuestions(Program program, Resource resource) '''
		«{buildOptions(program, resource, blocks, program.class); ""}»
		«var TreeMap<Integer, String> drawable = new TreeMap()»
		«var TreeMap<Integer, TreeMap<Integer,String>> drawableAnswer = new TreeMap()»
		«var int i = 0»
		«FOR exercise : program.exercises»
			«IF exercise instanceof AlternativeResponse»
				«FOR test : exercise.tests»
					«IF rand.get(exercise).get(test).size() > 0»
						«var diagram = rand.get(exercise).get(test).get(0)»
						«/*IOUtils.copyFile(new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram), new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/app/mobile/app/src/main/res/drawable/q" + i + "_enunciado.png"))*/»
						«/*drawable.put(i,"q" + i + "_enunciado.png")*/»
						«{i++; ""}»
					«ENDIF»
				«ENDFOR»
			«ENDIF»
		«ENDFOR»
//
//  Questions.swift
//  tfgApp
//
//  Created by jaime on 5/12/21.
//

import Foundation


let allQuestions  =
    ["2;Is this true or false;*True;False" ,"2;Is this good or bad;*Good;Bad"]


let allQuestionsImages = ["ejercicio0","ejercicio1"]
	'''
	
		/*MobileApp code will be generated here!!*/
	def compileJsonDiagramFile(String diagramFileName) '''
{
  "images" : [
    {
      "filename" : "«diagramFileName»",
      "idiom" : "universal",
      "scale" : "1x"
    },
    {
      "idiom" : "universal",
      "scale" : "2x"
    },
    {
      "idiom" : "universal",
      "scale" : "3x"
    }
  ],
  "info" : {
    "author" : "xcode",
    "version" : 1
  }
}	'''
}