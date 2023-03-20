package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import wodel.utils.manager.ModelManager
import org.osgi.framework.Bundle
import org.eclipse.core.runtime.Platform
import java.net.URL
import org.eclipse.core.runtime.FileLocator
import java.util.List
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EObject
import wodel.utils.exceptions.ModelNotFoundException
import org.eclipse.emf.common.util.URI
import edutest.Program
import java.util.TreeMap
import wodel.utils.manager.ProjectUtils
import edutest.AlternativeResponse
import java.io.File
import wodel.utils.manager.IOUtils
import edutest.MultiChoiceEmendation
import edutest.MultiChoiceDiagram
import edutest.MatchPairs
import java.util.ArrayList
import java.util.AbstractMap.SimpleEntry

class EduTestiOSAppGenerator extends EduTestSuperGenerator {
	
	private List<EObject> blocks
	private String questionsSwift
	private String examViewControllerSwift
	private TreeMap<Integer, String> drawable = new TreeMap()
	private TreeMap<Integer, TreeMap<Integer,String>> drawableAnswer = new TreeMap()
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		ProjectUtils.resetProject();
		project = ProjectUtils.getProject();
		try {
			var i = 0;
			//loads the mutator model
			var xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath + "/" + project.getName() +
			"/" + ModelManager.getOutputFolder + "/" + resource.URI.lastSegment.replaceAll(".test", ".model")
			val Bundle bundle = Platform.getBundle("wodel.models")
	   		val URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore")
	   		val String mutatorecore = FileLocator.resolve(fileURL).getFile()
			//val String mutatorecore = ModelManager.getWorkspaceAbsolutePath + "/" + project.getName() + "/resources/MutatorEnvironment.ecore";
			val List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore)
			//val EPackage epackage = mutatorpackages.get(0);
			//EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
			val Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString)
			blocks = ModelManager.getObjectsOfType("Block", mutatormodel)
			
			for (p : resource.allContents.toIterable.filter(Program)) {
				if (i == 0) {
					examViewControllerSwift = '../app/ios/tfgApp/ExamViewController.swift'
					questionsSwift = '../app/ios/tfgApp/Questions.swift'
				} else {
					examViewControllerSwift = '../app/ios/tfgApp/ExamViewController.swift'
					questionsSwift = '../app/ios/tfgApp/Questions.swift'
				}
				fsa.generateFile(examViewControllerSwift, p.compile(resource, fsa))
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
				«var int i = 0»
				«FOR exercise : program.exercises»
					«IF exercise instanceof AlternativeResponse»
						«FOR test : exercise.tests»
							«IF rand.get(exercise).get(test).size() > 0»
								«var diagram = rand.get(exercise).get(test).get(0)»
								«var String diagramFolderName = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/app/ios/tfgApp/Assets.xcassets/ejercicio" + i + ".imageset/"»
								«var File diagramFolder = new File(diagramFolderName)»
								«IF diagramFolder.exists() == false»
								«{diagramFolder.mkdirs(); ""}»
								«ENDIF»
								«var String diagramFileName = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/app/ios/tfgApp/Assets.xcassets/ejercicio" + i + ".imageset/ejercicio" + i + ".png"»
								//«IOUtils.copyFile(new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram), new File(diagramFileName))»
								«var String jsonDiagramFileName = "../app/ios/tfgApp/Assets.xcassets/ejercicio" + i + ".imageset/Contents.json"»
								//«fsa.generateFile(jsonDiagramFileName, diagramFileName.substring(diagramFileName.lastIndexOf("/") + 1, diagramFileName.length).compileJsonDiagramFile)»  
								//«drawable.put(i, "ejercicio" + i + ".png")»
								«{i++; ""}»
							«ENDIF»
						«ENDFOR»
					«ENDIF»
					«IF exercise instanceof MultiChoiceEmendation»
									«FOR test : exercise.tests»
										«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
											«IF (options.get(exercise).get(test) !== null)»
												«FOR opt : options.get(exercise).get(test)»
													«IF opt.text.size > 0»
														«IF opt.solution == true»
														«var String diagramFolderName = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/app/ios/tfgApp/Assets.xcassets/ejercicio" + i + ".imageset/"»
														«var File diagramFolder = new File(diagramFolderName)»
														«IF diagramFolder.exists() == false»
															«{diagramFolder.mkdirs(); ""}»
														«ENDIF»
															«var diagram=opt.path»
															«var String diagramFileName = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/app/ios/tfgApp/Assets.xcassets/ejercicio" + i + ".imageset/enunciado" + i + ".png"»
															//«IOUtils.copyFile(new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/src-gen/html/" + diagram), new File(diagramFileName))»
															«var String jsonDiagramFileName = "../app/ios/tfgApp/Assets.xcassets/ejercicio" + i + ".imageset/Contents.json"»
															//«fsa.generateFile(jsonDiagramFileName, diagramFileName.substring(diagramFileName.lastIndexOf("/") + 1, diagramFileName.length).compileJsonDiagramFile)»  
															//«drawable.put(i, "ejercicio" + i + ".png")»
															«{i++; ""}»
														«ENDIF»
													«ENDIF»
												«ENDFOR»
											«ENDIF»
										«ENDIF»
									«ENDFOR»
					«ENDIF»
					«IF exercise instanceof MultiChoiceDiagram»
									«FOR test : exercise.tests»
										«var int j = 0»
										«var TreeMap<Integer,String> diccAux = new TreeMap()»
										«FOR diag : diagrams.get(exercise).get(test)»
											«var String diagramFolderName = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/app/ios/tfgApp/Assets.xcassets/ejercicio" + i + "respuesta" + j +".imageset/"»
											«var File diagramFolder = new File(diagramFolderName)»
											«IF diagramFolder.exists() == false»
												«{diagramFolder.mkdirs(); ""}»
											«ENDIF»
											«var String diagramFileName = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/app/ios/tfgApp/Assets.xcassets/ejercicio" + i + "respuesta" + j +".imageset/ejercicio" + i + "respuesta" + j + ".png"»																					
											//«IOUtils.copyFile(new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diag), new File(diagramFileName))»
											«var String jsonDiagramFileName = "../app/ios/tfgApp/Assets.xcassets/ejercicio" + i + "respuesta" + j +".imageset/Contents.json"»
											//«fsa.generateFile(jsonDiagramFileName, diagramFileName.substring(diagramFileName.lastIndexOf("/") + 1, diagramFileName.length).compileJsonDiagramFile)»  															
											//«diccAux.put(j, "ejercicio" + i + "respuesta" + j+".png")»
											«{j++; ""}»
										«ENDFOR»
										//«drawableAnswer.put(i,diccAux)»
										«{i++; ""}»
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
											«FOR TestOption opt : options.get(exercise).get(test)»
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
									«ENDFOR»
									«var int k = 0»
									«FOR test : exercise.tests»
										«var TestOption opt = null»
										«IF (options.get(exercise).get(test) !== null && options.get(exercise).get(test).size() > index)»
											//«opt = options.get(exercise).get(test).get(index)»
										«ENDIF»
										«IF opt !== null»
											«var String diagramFolderName = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/app/ios/tfgApp/Assets.xcassets/ejercicio" + i + ".imageset/"»
											«var File diagramFolder = new File(diagramFolderName)»
											«IF diagramFolder.exists() == false»
												«{diagramFolder.mkdirs(); ""}»
											«ENDIF»  
										    «var diagram=opt.path»
											«var String diagramFileName = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/app/ios/tfgApp/Assets.xcassets/ejercicio" + i + ".imageset/ejercicio" + i + ".png"»
											//«IOUtils.copyFile(new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/src-gen/html/" + diagram), new File(diagramFileName))»
											«var String jsonDiagramFileName = "../app/ios/tfgApp/Assets.xcassets/ejercicio" + i + ".imageset/Contents.json"»
											//«fsa.generateFile(jsonDiagramFileName, diagramFileName.substring(diagramFileName.lastIndexOf("/") + 1, diagramFileName.length).compileJsonDiagramFile)»  
											//«drawable.put(i, "ejercicio" + i + ".png")»
											«{i++; ""}»
										«ENDIF»
									«ENDFOR»
					«ENDIF»
				«ENDFOR»
				import UIKit
				
				class ExamViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
				    
				   		
				    //UI TRUE FALSE
				    @IBOutlet weak var rbtnTrueFalse1: UIButton!
				    @IBOutlet weak var rbtnTrueFalse2: UIButton!
				    @IBOutlet weak var labelTrueFalse1: UILabel!
				    @IBOutlet weak var labelTrueFalse2: UILabel!
				    //UI Imgs respuestas
				    @IBOutlet weak var rbtnImg1: UIButton!
				    @IBOutlet weak var imageAnswer1: UIImageView!
				    @IBOutlet weak var rbtnImg2: UIButton!
				    @IBOutlet weak var imageAnswer2: UIImageView!
				    @IBOutlet weak var rbtnImg3: UIButton!
				    @IBOutlet weak var imageAnswer3: UIImageView!
				    @IBOutlet weak var rbtnImg4: UIButton!
				    @IBOutlet weak var imageAnswer4: UIImageView!
				    @IBOutlet weak var rbtnImg5: UIButton!
				    @IBOutlet weak var imageAnswer5: UIImageView!
				    @IBOutlet weak var imageEx: UIImageView!
				    @IBOutlet weak var textQuestion : UILabel!
				    @IBOutlet weak var backButton: UIButton!
				    @IBOutlet weak var nextButton: UIButton!
				    @IBOutlet weak var endButton: UIButton!
				    @IBOutlet weak var undoButton: UIButton!		    
				    //UI multiseleccion
				    @IBOutlet weak var btnSelection1: UIButton!
				    @IBOutlet weak var labelSelection1: UILabel!
				    @IBOutlet weak var btnSelection2: UIButton!
				    @IBOutlet weak var labelSelection2: UILabel!
				    @IBOutlet weak var btnSelection3: UIButton!
				    @IBOutlet weak var labelSelection3: UILabel!
				    @IBOutlet weak var btnSelection4: UIButton!
				    @IBOutlet weak var labelSelection4: UILabel!
				    @IBOutlet weak var btnSelection5: UIButton!
				    @IBOutlet weak var labelSelection5: UILabel!
				    @IBOutlet weak var btnSelection6: UIButton!
				    @IBOutlet weak var labelSelection6: UILabel!		    
				    //UI cajas
				    @IBOutlet weak var labelDropDownList1: UILabel!
				    @IBOutlet weak var btnDropDownList1: UIButton!
				    @IBOutlet weak var tableView1: UITableView!
				    var dataSourceArray1 = [String]()
				    @IBOutlet weak var labelDropDownList2: UILabel!
				    @IBOutlet weak var btnDropDownList2: UIButton!
				    @IBOutlet weak var tableView2: UITableView!
				    var dataSourceArray2 = [String]()
				    @IBOutlet weak var labelDropDownList3: UILabel!
				    @IBOutlet weak var btnDropDownList3: UIButton!
				    @IBOutlet weak var tableView3: UITableView!
				    var dataSourceArray3 = [String]()
				    @IBOutlet weak var labelDropDownList4: UILabel!
				    @IBOutlet weak var btnDropDownList4: UIButton!
				    @IBOutlet weak var tableView4: UITableView!
				    var dataSourceArray4 = [String]()
				    @IBOutlet weak var labelDropDownList5: UILabel!
				    @IBOutlet weak var btnDropDownList5: UIButton!
				    @IBOutlet weak var tableView5: UITableView!
				    var dataSourceArray5 = [String]()
				    @IBOutlet weak var labelDropDownList6: UILabel!
				    @IBOutlet weak var btnDropDownList6: UIButton!
				    @IBOutlet weak var tableView6: UITableView!
				    var dataSourceArray6 = [String]()
				    // FIN UI
				   		    
		
				    private var answersFalseTrue = [Int]()
				    private var answersImg = [Int : [Int : String]]()
				    private var btnNext = UIButton()
				    private var btnPrevious = UIButton()
				    private var exerciseType : Int = -1
				    private var correctAnswer = [Int]()
				    private var currentQuestion = Int()
				    private var answerIsCorrect = Bool()
				    private var userAllAnswers = [String]()
				    private var nAnswers : Int = 0
				    private var userAnswerIsCorrect = [Bool]()
				    
				    private var answerImgsArray = [UIImageView]()
				    private var answerBtnsArray = [UIButton]()
				    private var answerCheckBoxArray = [UIButton]()
				    private var answerLabelCheckBoxArray = [UILabel]()
				    private var questionLabelListArray = [UILabel]()
				    private var answerListBtnsArray = [UIButton]()
				    private var tablesViewArray = [UITableView]()
				    
				    override func viewDidLoad() {
				        super.viewDidLoad()
				        
				        
				        //array botones ejs0
				        answerBtnsArray.append(rbtnImg1)
				        answerBtnsArray.append(rbtnImg2)
				        answerBtnsArray.append(rbtnImg3)
				        answerBtnsArray.append(rbtnImg4)
				        answerBtnsArray.append(rbtnImg5)
				        //array de imagenes de respuestas
				        answerImgsArray.append(imageAnswer1)
				        answerImgsArray.append(imageAnswer2)
				        answerImgsArray.append(imageAnswer3)
				        answerImgsArray.append(imageAnswer4)
				        answerImgsArray.append(imageAnswer5)
				        //array botones y labels ejs1
				        answerCheckBoxArray.append(btnSelection1)
				        answerCheckBoxArray.append(btnSelection2)
				        answerCheckBoxArray.append(btnSelection3)
				        answerCheckBoxArray.append(btnSelection4)
				        answerCheckBoxArray.append(btnSelection5)
				        answerCheckBoxArray.append(btnSelection6)
				        answerLabelCheckBoxArray.append(labelSelection1)
				        answerLabelCheckBoxArray.append(labelSelection2)
				        answerLabelCheckBoxArray.append(labelSelection3)
				        answerLabelCheckBoxArray.append(labelSelection4)
				        answerLabelCheckBoxArray.append(labelSelection5)
				        answerLabelCheckBoxArray.append(labelSelection6)
				        //arrays ejs 3
				        questionLabelListArray.append(labelDropDownList1)
				        questionLabelListArray.append(labelDropDownList2)
				        questionLabelListArray.append(labelDropDownList3)
				        questionLabelListArray.append(labelDropDownList4)
				        questionLabelListArray.append(labelDropDownList5)
				        questionLabelListArray.append(labelDropDownList6)
				        answerListBtnsArray.append(btnDropDownList1)
				        answerListBtnsArray.append(btnDropDownList2)
				        answerListBtnsArray.append(btnDropDownList3)
				        answerListBtnsArray.append(btnDropDownList4)
				        answerListBtnsArray.append(btnDropDownList5)
				        answerListBtnsArray.append(btnDropDownList6)
				        tablesViewArray.append(tableView1)
				        tablesViewArray.append(tableView2)
				        tablesViewArray.append(tableView3)
				        tablesViewArray.append(tableView4)
				        tablesViewArray.append(tableView5)
				        tablesViewArray.append(tableView6)
				        
				        backButton.layer.cornerRadius = 15
				        backButton.layer.borderWidth = 2
				        backButton.layer.borderColor = UIColor.systemGray2.cgColor
				        
				        nextButton.layer.cornerRadius = 15
				        nextButton.layer.borderWidth = 2
				        nextButton.layer.borderColor = UIColor.systemGray2.cgColor
				        
				        endButton.layer.cornerRadius = 15
				        endButton.layer.borderWidth = 2
				        endButton.layer.borderColor = UIColor.white.cgColor
				        tableView1.delegate = self
				        tableView1.dataSource = self
				        tableView2.delegate = self
				        tableView2.dataSource = self
				        tableView3.delegate = self
				        tableView3.dataSource = self
				        tableView4.delegate = self
				        tableView4.dataSource = self
				        tableView5.delegate = self
				        tableView5.dataSource = self
				        tableView6.delegate = self
				        tableView6.dataSource = self
				        
				        
				
				        reset()
				        showQuestion()
				        
				}
				func reset() {
				        answerIsCorrect = Bool()
		
				          «FOR exercise : program.exercises»
				          		«FOR test : exercise.tests»
				              			userAllAnswers.append("000000")
				              			userAnswerIsCorrect.append(false)
				              	«ENDFOR»
				          «ENDFOR»		
				        currentQuestion = 0
				}
				
				func checkAnswer() {
				        var userAnswer = [0,0,0,0,0,0]
				        var userAnswerStr = "000000"
				        if exerciseType == 3 { //true false
				            var i = 0
				            var j = 0
				            for button in answerListBtnsArray {
				                j = 0
				                for option in dataSourceArray1 {
				                    if button.titleLabel?.text == option {
				                        userAnswer[i] = j
				                    }
				                    j = j + 1
				                }
				                i = i + 1
				                
				            }
				            
				            let strAux = userAnswer.map { String($0)}
				            userAnswerStr = String(strAux.compactMap {($0).first })
				            
				            
				        }
				        if exerciseType == 2 { //true false
				            if rbtnTrueFalse1.isSelected {
				                userAnswer[0] = 1
				            }
				            else if rbtnTrueFalse2.isSelected{
				                userAnswer[1] = 1
				            }
				            let strAux = userAnswer.map { String($0)}
				            userAnswerStr = String(strAux.compactMap {($0).first })
				            
				            
				        }
				        else if exerciseType == 1 { //multiseleccion
				            var  i = 0
				            for button in answerCheckBoxArray {
				                if button.isSelected {
				                    userAnswer[i] = 1
				                }
				                i = i+1
				            }
				            
				            let strAux = userAnswer.map { String($0)}
				            userAnswerStr = String(strAux.compactMap {($0).first })
				            
				            
				        }
				        else if exerciseType == 0 { //imagenes
				            var  i = 0
				            for button in answerBtnsArray {
				                if button.isSelected {
				                    userAnswer[i] = 1
				                    break
				                }
				                i = i+1
				            }
				            
				            let strAux = userAnswer.map { String($0)}
				            userAnswerStr = String(strAux.compactMap {($0).first })
				            
				            
				        }
				        
				        
				        //general
				        
				        userAnswerIsCorrect[currentQuestion] = userAnswer == correctAnswer
				        userAllAnswers[currentQuestion] = userAnswerStr
				        
				    }
				    
				    func showQuestion() {
				            let question = allQuestions[currentQuestion]
				            let partsQuestion = question.components(separatedBy: ";")
				            textQuestion.text = partsQuestion[1]
				            hideAllItems()
				            
				            if (partsQuestion[0] == "0") {
				                exerciseType = 0
				                correctAnswer = [0,0,0,0,0,0]
				                imageEx.isHidden = true
				                
				                var i = 0
				                let imgsPath = allAnswersImages[currentQuestion]
				                
				                    for imageName in imgsPath ?? []{
				                        answerImgsArray[i].image = ResizeImage(UIImage(named: imageName)!, targetSize : CGSize(width: 250, height: 250))
				                        answerImgsArray[i].isHidden = false
				                        answerBtnsArray[i].isHidden = false
				                        answerBtnsArray[i].isSelected = false
				                        if(Array(userAllAnswers[currentQuestion])[i] == "1"){
				                            answerBtnsArray[i].isSelected = true
				                        
				                        }
				                        i = i+1
				                    }
				                                
				                    correctAnswer[Int(partsQuestion[3])!] = 1
				                    
				            }
				            
				            if (partsQuestion[0] == "1") { //multiseleccion
				                exerciseType = 1
				                imageEx.isHidden = false
				                correctAnswer = [0,0,0,0,0,0]
				    
				                imageEx.image = ResizeImage(UIImage(named: allQuestionsImages[currentQuestion] ?? "errorImage")!, targetSize : CGSize(width: 300, height: 300))
				                let answers = partsQuestion[2...partsQuestion.count-1]
				                var i = 0
				                var answerCorrect = ""
				                for answer in answers {
				                    if(answer.contains("*")) {
				                        answerCorrect = String(answer.dropFirst())
				                        correctAnswer[i] = 1
				                        answerLabelCheckBoxArray[i].text = answerCorrect
				                    }
				                    else {
				                        answerLabelCheckBoxArray[i].text = answer
				                    }
				                    answerLabelCheckBoxArray[i].isHidden = false
				                    
				                    answerLabelCheckBoxArray[i].sizeToFit()
				                    answerCheckBoxArray[i].isHidden = false
				                    if(Array(userAllAnswers[currentQuestion])[i] == "1"){
				                        answerCheckBoxArray[i].isSelected = true
				                    }
				                    else {
				                        answerCheckBoxArray[i].isSelected = false
				                    }
				                    i = i+1
				                }
				                
				                
				            }
				            
				            //ejercicios true false
				            if (partsQuestion[0] == "2") {
				                exerciseType = 2
				                //muestro los botones para este tipo de ejercicio
				                rbtnTrueFalse1.isHidden = false
				                labelTrueFalse1.isHidden = false
				                rbtnTrueFalse2.isHidden = false
				                labelTrueFalse2.isHidden = false
				                rbtnTrueFalse1.isSelected = false
				                rbtnTrueFalse2.isSelected = false
				                imageEx.isHidden = false
				                correctAnswer = [0,0,0,0,0,0]
				    
				                imageEx.image = ResizeImage(UIImage(named: allQuestionsImages[currentQuestion] ?? "errorImage")!, targetSize : CGSize(width: 300, height: 300))
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
				                    rbtnTrueFalse2.isSelected = false
				                }
				                else if (Array(userAllAnswers[currentQuestion])[1] == "1") {
				                    rbtnTrueFalse1.isSelected = false
				                    rbtnTrueFalse2.isSelected = true
				                }
				            }
				            
				            else if (partsQuestion[0] == "3") { //ejs dropdown list
				                exerciseType = 3
				                cleanDataSources()
				                reloadTableViews()
				                imageEx.isHidden = false
				                imageEx.image = ResizeImage(UIImage(named: allQuestionsImages[currentQuestion] ?? "errorImage")!, targetSize : CGSize(width: 300, height: 300))
				                
				                let partsToEnd = partsQuestion[2...partsQuestion.count-1]
				                var questions = [String]()
				                var solutions = [Int]()
				                var i = 0
				                for part in partsToEnd {
				                    if(part.contains("*")) {
				                        let solution = part[part.index(part.startIndex, offsetBy: 1)]
				                        solutions.append(Int(String(solution)) ?? -1)
				                        questions.append(String((part.dropFirst()).dropFirst()))
				                        correctAnswer[i] = solutions[i]
				                        i = i+1
				                    }
				                    else { //if part "" pasa
				                        addDataToDataSource(data: part)
				                    }
				                }
				                reloadTableViews()
				                
				                var j = 0
				                for question in questions {
				                    questionLabelListArray[j].text = question
				                    questionLabelListArray[j].isHidden = false
				                    answerListBtnsArray[j].isHidden = false
				                
				                            
				                    if(Array(userAllAnswers[currentQuestion])[j] != "0"){
				                        let answered = userAllAnswers[currentQuestion][userAllAnswers[currentQuestion].index(userAllAnswers[currentQuestion].startIndex, offsetBy: j)]
				                        let index = IndexPath.init(row: Int(String(answered)) ?? 0, section: 0)
				                        let cell = tablesViewArray[j].cellForRow(at: index)
				                        cell?.textLabel?.text = dataSourceArray1[Int(String(answered)) ?? 0]
				                        answerListBtnsArray[j].setTitle(cell?.textLabel?.text, for: .normal)
				                    }
				                    j = j+1
				                }
				                
				            }
				            
				            if currentQuestion == 0 {
				                btnPrevious.isHidden = true
				            }
				            else{
				                btnPrevious.isHidden = false
				                
				            }
				            if currentQuestion == allQuestions.count-1 {
				                btnNext.isHidden = true
				            }
				            else {
				                btnNext.isHidden = false
				            }
				            
				        }
				        @IBAction func rbtnAction(_ sender: UIButton) {
				                if sender.tag == 2 {
				                    rbtnTrueFalse1.isSelected = true
				                    rbtnTrueFalse2.isSelected = false
				                    rbtnImg1.isSelected =  false
				                    rbtnImg2.isSelected =  false
				                    rbtnImg3.isSelected =  false
				                    rbtnImg4.isSelected =  false
				                    rbtnImg5.isSelected =  false
				                }
				                else if sender.tag == 4 {
				                    rbtnTrueFalse1.isSelected = false
				                    rbtnTrueFalse2.isSelected = true
				                    rbtnImg1.isSelected =  false
				                    rbtnImg2.isSelected =  false
				                    rbtnImg3.isSelected =  false
				                    rbtnImg4.isSelected =  false
				                    rbtnImg5.isSelected =  false
				                }
				                else if sender.tag == 6 {
				                    rbtnTrueFalse1.isSelected = false
				                    rbtnTrueFalse2.isSelected = false
				                    rbtnImg1.isSelected =  true
				                    rbtnImg2.isSelected =  false
				                    rbtnImg3.isSelected =  false
				                    rbtnImg4.isSelected =  false
				                    rbtnImg5.isSelected =  false
				                }
				                else if sender.tag == 7 {
				                    rbtnTrueFalse1.isSelected = false
				                    rbtnTrueFalse2.isSelected = false
				                    rbtnImg1.isSelected =  false
				                    rbtnImg2.isSelected =  true
				                    rbtnImg3.isSelected =  false
				                    rbtnImg4.isSelected =  false
				                    rbtnImg5.isSelected =  false
				                }
				                else if sender.tag == 8 {
				                    rbtnTrueFalse1.isSelected = false
				                    rbtnTrueFalse2.isSelected = false
				                    rbtnImg1.isSelected =  false
				                    rbtnImg2.isSelected =  false
				                    rbtnImg3.isSelected =  true
				                    rbtnImg4.isSelected =  false
				                    rbtnImg5.isSelected =  false
				                }
				                else if sender.tag == 9 {
				                    rbtnTrueFalse1.isSelected = false
				                    rbtnTrueFalse2.isSelected = false
				                    rbtnImg1.isSelected =  false
				                    rbtnImg2.isSelected =  false
				                    rbtnImg3.isSelected =  false
				                    rbtnImg4.isSelected =  true
				                    rbtnImg5.isSelected =  false
				                }
				                else if sender.tag == 10 {
				                    rbtnTrueFalse1.isSelected = false
				                    rbtnTrueFalse2.isSelected = false
				                    rbtnImg1.isSelected =  false
				                    rbtnImg2.isSelected =  false
				                    rbtnImg3.isSelected =  false
				                    rbtnImg4.isSelected =  false
				                    rbtnImg5.isSelected =  true
				                }
				                
				            }
				            
				            
				            @IBAction func checkBoxAction(_ sender: UIButton) {
				                if sender.tag == 30 {
				                    if(btnSelection1.isSelected) {
				                        btnSelection1.isSelected = false
				                    }
				                    else {
				                        btnSelection1.isSelected = true
				                    }
				                   
				                }
				                else if sender.tag == 31 {
				                    if(btnSelection2.isSelected) {
				                        btnSelection2.isSelected = false
				                    }
				                    else {
				                        btnSelection2.isSelected = true
				                    }
				                }
				                else if sender.tag == 32 {
				                    if(btnSelection3.isSelected) {
				                        btnSelection3.isSelected = false
				                    }
				                    else {
				                        btnSelection3.isSelected = true
				                    }
				                }
				                else if sender.tag == 34 {
				                    if(btnSelection4.isSelected) {
				                        btnSelection4.isSelected = false
				                    }
				                    else {
				                        btnSelection4.isSelected = true
				                    }
				                }
				                else if sender.tag == 36 {
				                    if(btnSelection5.isSelected) {
				                        btnSelection5.isSelected = false
				                    }
				                    else {
				                        btnSelection5.isSelected = true
				                    }
				                }
				                else if sender.tag == 38 {
				                    if(btnSelection6.isSelected) {
				                        btnSelection6.isSelected = false
				                    }
				                    else {
				                        btnSelection6.isSelected = true
				                    }
				                }
				                
				                
				            }
				            
				            @IBAction func backButtonAction(_ sender: UIButton) {
				                if(currentQuestion > 0) {
				                    checkAnswer()
				                    currentQuestion = currentQuestion - 1
				                    showQuestion()
				                }
				                
				            }
				            
				            @IBAction func nextButtonAction(_ sender: UIButton) {
				                if(currentQuestion < allQuestions.count-1) {
				                    checkAnswer()
				                    currentQuestion = currentQuestion + 1
				                    showQuestion()
				                }
				                
				                
				            }
				            
				            @IBAction func endButtonAction(_ sender: UIButton) {
				                var nota = 0.0
				                for answer in userAnswerIsCorrect {
				                    if answer == true {
				                        nota = nota + 1
				                    }
				                }
				                nota = nota*10 / Double(userAnswerIsCorrect.count)
				                let vc = storyboard?.instantiateViewController(identifier: "results") as! ResultsViewController
				                vc.nota = nota
				                vc.modalPresentationStyle = .fullScreen
				                present(vc, animated: true)
				                
				                
				            }
				            
				            @IBAction func undoButtonAction(_ sender: UIButton) {
				                //deshacer seleecion: array de botones guardados por preguntas
				                if exerciseType == 0 {
				                    for button in answerBtnsArray {
				                        button.isSelected = false
				                    }
				                }
				                else if exerciseType == 1 {
				                    for button in answerCheckBoxArray {
				                        button.isSelected = false
				                    }
				                }
				                else if exerciseType == 2 {
				                    rbtnTrueFalse1.isSelected = false
				                    rbtnTrueFalse2.isSelected = false
				                }
				                userAllAnswers[currentQuestion] = "000000"
				                
				            }
				            
				        
				            func numberOfSections(in tableView: UITableView) -> Int {
				                return 1
				            }
				            func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
				                tableView.isHidden = true
				                if tableView == tableView1 {
				                    return dataSourceArray1.count
				                }
				                
				                else if tableView == tableView2 {
				                    return dataSourceArray2.count
				                }
				                else if tableView == tableView3 {
				                    return dataSourceArray3.count
				                }
				                else if tableView == tableView4 {
				                    return dataSourceArray4.count
				                }
				                else if tableView == tableView5 {
				                    return dataSourceArray5.count
				                }
				                else if tableView == tableView6 {
				                    return dataSourceArray6.count
				                }
				                return 0
				            }
				            
				            func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
				                let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)
				                cell.textLabel?.numberOfLines = 0
				                cell.textLabel?.sizeToFit()
				                if tableView == tableView1 {
				                    cell.textLabel?.text = dataSourceArray1[indexPath.row]
				                    
				                }
				                
				                else if tableView == tableView2 {
				                    cell.textLabel?.text = dataSourceArray2[indexPath.row]
				                }
				                else if tableView == tableView3 {
				                    cell.textLabel?.text = dataSourceArray3[indexPath.row]
				                }
				                else if tableView == tableView4 {
				                    cell.textLabel?.text = dataSourceArray4[indexPath.row]
				                }
				                else if tableView == tableView5 {
				                    cell.textLabel?.text = dataSourceArray5[indexPath.row]
				                }
				                else if tableView == tableView6 {
				                    cell.textLabel?.text = dataSourceArray6[indexPath.row]
				                }
				                
				                return cell
				            }
				            func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
				                let cell = tableView.cellForRow(at: indexPath)
				                
				                if tableView == tableView1 {
				                    btnDropDownList1.setTitle(cell?.textLabel?.text, for: .normal)
				                }
				                
				                else if tableView == tableView2 {
				                    btnDropDownList2.setTitle(cell?.textLabel?.text, for: .normal)
				                }
				                else if tableView == tableView3 {
				                    btnDropDownList3.setTitle(cell?.textLabel?.text, for: .normal)
				                }
				                else if tableView == tableView4 {
				                    btnDropDownList4.setTitle(cell?.textLabel?.text, for: .normal)
				                }
				                else if tableView == tableView5 {
				                    btnDropDownList5.setTitle(cell?.textLabel?.text, for: .normal)
				                }
				                else if tableView == tableView6 {
				                    btnDropDownList6.setTitle(cell?.textLabel?.text, for: .normal)
				                }
				                
				                
				                tableView.isHidden = true
				            }
				            
				            
				            @IBAction func btnDropDownListAction(_ sender: UIButton) {
				                if sender.tag == 70 {
				                    tableView1.isHidden = !self.tableView1.isHidden
				                }
				                else if sender.tag == 71 {
				                    tableView2.isHidden = !self.tableView2.isHidden
				                }
				                else if sender.tag == 72 {
				                    tableView3.isHidden = !self.tableView3.isHidden
				                }
				                else if sender.tag == 73 {
				                    tableView4.isHidden = !self.tableView4.isHidden
				                }
				                else if sender.tag == 74 {
				                    tableView5.isHidden = !self.tableView5.isHidden
				                }
				                else if sender.tag == 75 {
				                    tableView6.isHidden = !self.tableView6.isHidden
				                }
				                
				                
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
				            
				            func hideAllItems() {
				                //ejs true false
				                rbtnTrueFalse1.isHidden = true
				                labelTrueFalse1.isHidden = true
				                rbtnTrueFalse2.isHidden = true
				                labelTrueFalse2.isHidden = true
				                
				                //ejs imagenes
				                for img in answerImgsArray {
				                    img.isHidden = true
				                }
				                for button in answerBtnsArray {
				                    button.isHidden = true
				                }
				                
				                //ejs multiseleccion
				                for button in answerCheckBoxArray {
				                    button.isHidden = true
				                }
				                for label in answerLabelCheckBoxArray {
				                    label.isHidden = true
				                }
				                
				                //ejs dropdownlist
				                for label in questionLabelListArray {
				                    label.isHidden = true
				                }
				                for button in answerListBtnsArray {
				                    button.isHidden = true
				                }
				                
				                imageEx.isHidden = true
				                
				                
				                
				            }
				            
				            func addDataToDataSource(data: String) {
				                if !dataSourceArray1.contains(data) {
				                    dataSourceArray1.append(data)
				                }
				                if !dataSourceArray2.contains(data) {
				                    dataSourceArray2.append(data)
				                }
				                if !dataSourceArray3.contains(data) {
				                    dataSourceArray3.append(data)
				                }
				                if !dataSourceArray4.contains(data) {
				                    dataSourceArray4.append(data)
				                }
				                if !dataSourceArray5.contains(data) {
				                    dataSourceArray5.append(data)
				                }
				                if !dataSourceArray6.contains(data) {
				                    dataSourceArray6.append(data)
				                }
				            }
				            
				            func cleanDataSources() {
				                dataSourceArray1.removeAll()
				                dataSourceArray1.append("Elegir")
				                btnDropDownList1.setTitle("Elegir", for: .normal)
				                dataSourceArray2.removeAll()
				                dataSourceArray2.append("Elegir")
				                btnDropDownList2.setTitle("Elegir", for: .normal)
				                dataSourceArray3.removeAll()
				                dataSourceArray3.append("Elegir")
				                btnDropDownList3.setTitle("Elegir", for: .normal)
				                dataSourceArray4.removeAll()
				                dataSourceArray4.append("Elegir")
				                btnDropDownList4.setTitle("Elegir", for: .normal)
				                dataSourceArray5.removeAll()
				                dataSourceArray5.append("Elegir")
				                btnDropDownList5.setTitle("Elegir", for: .normal)
				                dataSourceArray6.removeAll()
				                dataSourceArray6.append("Elegir")
				                btnDropDownList6.setTitle("Elegir", for: .normal)
				            }
				            func reloadTableViews() {
				                tableView1.reloadData()
				                tableView2.reloadData()
				                tableView3.reloadData()
				                tableView4.reloadData()
				                tableView5.reloadData()
				                tableView6.reloadData()
				                
				                
				            }
				            
				            
				            
				        
				        }
		
		
			'''
		
			/*MobileApp code will be generated here!!*/
			def compileQuestions(Program program, Resource resource) 
			'''
				«{buildOptions(program, resource, blocks, program.class); ""}»
				«var int i = 0»
				«FOR exercise : program.exercises»
					«IF exercise instanceof AlternativeResponse»
						«FOR test : exercise.tests»
							«IF rand.get(exercise).get(test).size() > 0»
								«var diagram = rand.get(exercise).get(test).get(0)»
								«/*IOUtils.copyFile(new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/src-gen/html/diagrams/" + test.source.replace('.model', '') + "/" + diagram), new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/app/mobile/app/src/main/res/drawable/q" + i + "_enunciado.png"))*/»
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
		
		
		let allQuestions  = [
					«var boolean isFirst= true»
					«var boolean isFirst2= true»
					«var boolean isFirst3= true»
					«var boolean isFirst4= true»
					«FOR exercise : program.exercises»
						
						«IF exercise instanceof AlternativeResponse»
							«FOR test : exercise.tests»
								«IF isFirst == false»
									,
								«ELSE»
									«{isFirst=false; ""}»				
								«ENDIF»					
								«IF rand.get(exercise).get(test).size() > 0»
									«var diagram = rand.get(exercise).get(test).get(0)»
									«IF diagram.equals(test.source.replace('.model', '.png'))»
										"2;«test.question.replace("\"", "'").replace("'", "")»;*True;False"
									«ELSE»
										"2;«test.question.replace("\"", "'").replace("'", "")»;True;*False"
									«ENDIF»
								«ENDIF»
							«ENDFOR»
						«ENDIF»
						«IF exercise instanceof MultiChoiceDiagram»
							«FOR test : exercise.tests»
								«IF isFirst == false»
									,
								«ELSE»
									«{isFirst=false; ""}»				
								«ENDIF»					
								«var int j=0»
								«var int correct=j»
								«FOR diagram : diagrams.get(exercise).get(test)»
								«IF diagram.equals(test.source.replace('.model', '.png'))»
									«{correct=j; ""}»
												«ENDIF»
												«{j++; ""}»
											«ENDFOR»
										"0;«test.question.replace("\"", "'").replace("'", "")»;«j»;«correct»"
							«ENDFOR»
						«ENDIF»
						«IF exercise instanceof MultiChoiceEmendation»
											«FOR test : exercise.tests»
												«var String fullQuestion = ""»
												«IF isFirst == false»
													,
												«ELSE»
													«{isFirst=false; ""}»				
												«ENDIF»									
												«{fullQuestion += "1;" ; ""}»
												«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
													«{fullQuestion += test.question.replace("\"", "'").replace("'", "")+";" ; ""}»
												«ENDIF»
												«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
													«var counter = 0»
													«var List<SimpleEntry<String, Boolean>> textOptions = new ArrayList<SimpleEntry<String, Boolean>>()»
													«FOR opt : options.get(exercise).get(test)»
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
												«ENDIF»
												«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
												 	«var String diagram = ''»
													«IF (options.get(exercise).get(test) !== null)»
														«FOR opt : options.get(exercise).get(test)»
															«IF opt.text.size > 0»
																«{diagram = opt.path; ""}»
															«ENDIF»
														«ENDFOR»
													«ENDIF»
													«IF !diagram.equals('')»
														«IF (options.get(exercise).get(test) !== null)»
															«FOR opt : options.get(exercise).get(test)»
																«var List<String> textOptions = new ArrayList<String>()»
												          		«IF opt.text.size > 0»
											          				«FOR String key : opt.text.keySet()»
											          					«FOR String text : opt.text.get(key)»
											          						«IF !textOptions.contains(text)»
											                					«{textOptions.add(text); ""}»
											          						«ENDIF»
											          					«ENDFOR»
											          				«ENDFOR»
												          		«ENDIF»
															«ENDFOR»
															«FOR opt : options.get(exercise).get(test)»
																«IF opt.solution == true»
													          		«IF opt.text.size > 0»
													          			«FOR String key : opt.text.keySet()»
								          			          				«FOR String text : opt.text.get(key)»
																				«{fullQuestion += "*"+text.trim()+";" ; ""}»
								          			          				«ENDFOR»
								          			          			«ENDFOR»
													          		«ENDIF»
													          	«ENDIF»
													          	«IF opt.solution == false»
													          		«IF opt.text.size > 0»
													          			«FOR String key : opt.text.keySet()»
								          			          				«FOR String text : opt.text.get(key)»
																				«{fullQuestion += text.trim()+";" ; ""}»
								          			          				«ENDFOR»
								          			          			«ENDFOR»
													          		«ENDIF»
													          	«ENDIF»
															«ENDFOR»
														«ENDIF»
													«ENDIF»
												«ENDIF»
												"«fullQuestion»"
											«ENDFOR»
										«ENDIF»
						«IF exercise instanceof MatchPairs»
											«var int min = Integer.MAX_VALUE»
									        «var int index = 0»
									        «var int max = Integer.MIN_VALUE»
											«FOR test : exercise.tests»
												«var String fullQuestion = ""»
												«IF isFirst == false»
													,
												«ELSE»
													«{isFirst=false; ""}»				
												«ENDIF»									
												«IF options.get(exercise) !== null && options.get(exercise).get(test) !== null»
													«{fullQuestion += "3;Match the correct option on the right with each of the statements on the left;"; ""}»
													
													«var List<String> textOptions = new ArrayList<String>()»
													«var int k = 0»
													«var int counter = 0»
													«FOR TestOption opt : options.get(exercise).get(test)»
														«FOR String key : opt.text.keySet()»
									         				«FOR String text : opt.text.get(key)»
																«IF !textOptions.contains(text)»
																	«{counter++; ""}»															
																	«{fullQuestion += text + ";"; ""}»
																												
																	«{textOptions.add(text);""}»
																«ENDIF»
															«ENDFOR»
														«ENDFOR»
													«ENDFOR»
													«IF counter > max»
														«{max = counter; ""}»
														«{index = k; ""}»
													«ENDIF»
													«{k++; ""}»
													«var TreeMap<Integer, SimpleEntry<String, String>> entries = new TreeMap<Integer, SimpleEntry<String, String>>()»
													«FOR TestOption op : options.get(exercise).get(test)»
														«IF test.expression == true»
															«var String key = getText(test.identifier, op.entry.getKey().getURI().toFileString(), resource)»
															«IF key.length() <= 36»
																«var boolean found = false»
																«FOR int length : entries.keySet()»
																	«var SimpleEntry<String, String> entry = entries.get(length)»
																	«IF entry.getValue().equals(key)»
																		«{found = true; ""}»
																	«ENDIF»
																«ENDFOR»
																«IF found == false»
																	«var SimpleEntry<String, String> entry = new SimpleEntry<String, String>(key, op.text.get(op.text.keySet().get(index)).get(index).trim())»
																	«{entries.put(key.length,  entry); ""}»
																«ENDIF»
															«ENDIF»
														«ENDIF»
													«ENDFOR»
													«var String question = test.question.replace("\"", "'")»
													«var int counter2 = 0»
													«FOR int length : entries.keySet()»
														«IF counter2 < min»
															«var SimpleEntry<String, String> entry = entries.get(length)»
															«FOR int l : 0..textOptions.size-1»
																«IF textOptions.get(l).substring(0,textOptions.get(l).length-1).equals(entry.getValue())»
																		«{fullQuestion += "*" + l + question + entry.getKey() + ";"; ""}»
																«ENDIF»
															«ENDFOR»
														«ENDIF»
													«ENDFOR»
												«ENDIF»
												"«fullQuestion»"
								        	«ENDFOR»	
										«ENDIF»	
					«ENDFOR»
					]
					
					let allQuestionsImages = [
					«FOR int numExercise : drawable.keySet()»
						«IF isFirst2 == false»
							,
						«ELSE»
							«{isFirst2=false; ""}»
						«ENDIF»	
						«numExercise» : "«drawable.get(numExercise).replace(".png","")»"
					«ENDFOR»
					]
		
		let allAnswersImages = [
					«FOR int numExercise : drawableAnswer.keySet()»
						«IF isFirst3 == false»
							,
						«ELSE»
							«{isFirst3=false; ""}»
						«ENDIF»	
						«numExercise» : 
						
						«FOR int numAnswer : drawableAnswer.get(numExercise).keySet()»
						«IF isFirst4 == false»
															,
											«ELSE»
												«{isFirst4=false; ""}»
												[
										«ENDIF»	
						 
							 "«drawableAnswer.get(numExercise).get(numAnswer).replace(".png","")»" 
						«ENDFOR»
						«{isFirst4=true; ""}»
						]
						
					«ENDFOR»
					]
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