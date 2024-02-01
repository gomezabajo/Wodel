package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

import modeldraw.MutatorDraw
import wodel.utils.manager.ModelManager
import wodel.utils.manager.JavaUtils
import org.eclipse.core.resources.IProject
import wodel.utils.manager.ProjectUtils
import modeldraw.Node
import org.eclipse.xtext.generator.AbstractGenerator
import modeldraw.NodeStyle
import modeldraw.ValuedFeature
import modeldraw.MutatorInstance

/**
 * @author Pablo Gomez-Abajo - modelDraw dot code generator.
 * 
 * Generates the Java code for the graphical
 * representation of the models. PlantUML mode.
 *  
 */
class ModelDrawPlantUMLGenerator extends AbstractGenerator {
	protected IProject project = null
	
	private String fileName
	private String className
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		ProjectUtils.resetProject()
		project = ProjectUtils.getProject()
		var i = 0;
		fileName = resource.URI.lastSegment
		fileName = fileName.replaceAll(".draw", "").replaceAll("[.]", "_") + ".draw"
		for(e: resource.allContents.toIterable.filter(MutatorDraw)) {
			if (i == 0) {
				fileName = fileName.replace(".draw", "") + 'Draw.java'
			}
			else {
				fileName = fileName.replace(".draw", "") + i + 'Draw.java'
			}
			className = fileName.replaceAll("Draw.java", "")
     		fsa.generateFile("mutator/" + className + "/" + fileName, JavaUtils.format(e.compile, false))
			i++
		}
	}

	def generate(MutatorDraw draw, String folder, int index) '''
		List<String> umlcode = new ArrayList<String>();
		«IF draw.instances.get(index).nodes !== null»
		«IF draw.instances.get(index).nodes.size() > 0»
		generateUMLNodes(packages, model, umlnodes, umlrels);
		«ENDIF»
		«ENDIF»
		umlcode.add("@startuml");
		for (EObject umlnode : umlnodes.get(«index»).keySet()) {
			if (umlnodes.get(«index»).get(umlnode) != null) {
				umlcode.add((umlnodes.get(«index»).get(umlnode).label.replaceAll("'", "") + " " + umlnodes.get(«index»).get(umlnode).name.replaceAll("'", "")).trim());
				if (umlrels.get(«index»).get(umlnode) != null) {
					for (String rel : umlrels.get(«index»).get(umlnode)) { 
						umlcode.add((rel.replaceAll("'", "") + " <|-- " + umlnodes.get(«index»).get(umlnode).name.replaceAll("'", "")).trim());
					}
				}
			}
		}
		umlcode.add("@enduml");
	'''
	
	def compile(MutatorDraw draw) '''
	package mutator.«className»;
	
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.io.PrintWriter;
	import java.io.UnsupportedEncodingException;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Map;
	import java.util.Arrays;	
	import java.util.HashMap;
	import java.util.LinkedHashMap;
	
	import org.eclipse.emf.ecore.EObject;
	import org.eclipse.emf.ecore.EPackage;
	import org.eclipse.emf.ecore.resource.Resource;
	
	import net.sourceforge.plantuml.SourceStringReader;
	import wodel.utils.exceptions.MetaModelNotFoundException;
	import wodel.utils.exceptions.ModelNotFoundException;
	import wodel.utils.exceptions.ReferenceNonExistingException;
	import wodel.utils.manager.ModelManager;
	import wodel.utils.manager.DrawUtils.LabelStyle;
	
	import net.sourceforge.plantuml.GeneratedImage;
	import net.sourceforge.plantuml.SourceFileReader;
	
	public class «className»Draw implements wodel.utils.manager.IMutatorDraw {
		
		private static String getOrdinalFor(int value) {
			int hundredRemainder = value % 100;
			int tenRemainder = value % 10;
			if (hundredRemainder - tenRemainder == 10) {
				return value + "th";
			}
		
			switch (tenRemainder) {
				case 1:
					return value + "st";
				case 2:
					return value + "nd";
				case 3:
					return value + "rd";
				default:
					return value + "th";
			}
		}
   		«var String folder = ModelManager.getWorkspaceAbsolutePath() + "/"
	   			+ project.name»
		private static void generateUMLNodes(List<EPackage> packages, Resource model, Map<Integer, Map<EObject, LabelStyle>> umlnodes, Map<Integer, Map<EObject, List<String>>> umlrels) {
			// COUNTER: «var int counter = 0»
			Map<EObject, LabelStyle> localnodes = null;
			Map<EObject, List<String>> localrels = null;
			int i = 0;
			«FOR MutatorInstance instance : draw.instances»			
			localnodes = new LinkedHashMap<EObject, LabelStyle>();
			umlnodes.put(«counter», localnodes);
			localrels = new LinkedHashMap<EObject, List<String>>();
			umlrels.put(«counter», localrels);
			try {
			«IF draw.instances.get(counter).nodes !== null»
			«IF draw.instances.get(counter).nodes.size() > 0»
			// COUNTER: «var int counter2 = 0»
			«FOR Node node : draw.instances.get(counter).nodes»
			List<EObject> lnode_«counter»_«counter2» = ModelManager.getObjectsOfType("«node.name.name»", model);
			i = 0;
			for (EObject node : lnode_«counter»_«counter2») {
				String name = ModelManager.getStringAttribute("name", node);
				String typeName = node.eClass().getName();
				LabelStyle label = new LabelStyle();
				«IF node.name.name.equals("Class")»
				label.label = "«node.name.name.toLowerCase()»";
				label.name = name;
				«ELSEIF node.name.name.equals("Object")»
				Object o = ModelManager.getReferences("class", node);
				EObject cl = null;
				if (o instanceof List<?>) {
					cl = ((List<EObject>) o).get(0);
				}
				label.label = "«node.name.name.toLowerCase()»";
				label.name = "\"" + name + " :<u>" + ModelManager.getStringAttribute("name", cl) + "</u>\" as " + getOrdinalFor(i);
				«ENDIF»
				«IF node.feature !== null»
				boolean value = false;
				«FOR ValuedFeature feature : node.feature»
				«IF feature.feat.EType.name.equals("EBoolean")»
				value = ModelManager.getBooleanAttribute("«feature.feat.name»", node);
				if (value == true) {
					«IF node.style == NodeStyle.ITALIC»
					label.label = "«feature.feat.name»";
					«ENDIF»
				}
				«ENDIF»
				«ENDFOR»
				«ENDIF»
				localnodes.put(node, label);
				Object noderels = ModelManager.getReferences("superclass", node);
				if (noderels instanceof List<?>) {
					List<String> rels = new ArrayList<String>();
					for (EObject nnode : (List<EObject>) noderels) {
						String rel = ModelManager.getStringAttribute("name", nnode);
						rels.add(rel);
					}
					localrels.put(node, rels);
				}
				i++;
			}
			// INC COUNTER: «counter2++»
			«ENDFOR»
			} catch (ReferenceNonExistingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		«ENDIF»
		«ENDIF»
		// INC COUNTER: «counter++»
		«ENDFOR»
		}
		
		public static void generateUMLGraphs(File file, String folder, List<EPackage> packages, File exercise) throws ModelNotFoundException, FileNotFoundException, UnsupportedEncodingException {
		//«counter = 0»
		Map<Integer, Map<EObject, LabelStyle>> umlnodes = new LinkedHashMap<Integer, Map<EObject, LabelStyle>>();
		Map<Integer, Map<EObject, List<String>>> umlrels = new LinkedHashMap<Integer, Map<EObject, List<String>>>();
		«FOR MutatorInstance instance : draw.instances»			
			if (file.isFile()) {
				String pathfile = file.getPath();
				if (pathfile.endsWith(".model") == true) {
					Resource model = ModelManager.loadModel(packages, pathfile);
					String path = exercise.getName() + "/" + folder;
					String umlfile = "«folder»/src-gen/html/diagrams/" + 
						path + "/" + file.getName().replace(".model", "_«counter».txt");
					«draw.generate(folder, counter)»
					File diagramsfolder = new File("«folder»/src-gen/html/diagrams/");
					if (diagramsfolder.exists() != true) {
						diagramsfolder.mkdirs();
					}
					File exercisefolder = new File("«folder»/src-gen/html/diagrams/" + path + "/");
					if (exercisefolder.exists() != true) {
						exercisefolder.mkdirs();
					}
					PrintWriter umlwriter = new PrintWriter(umlfile, "UTF-8");
					for (String umlline : umlcode) {
						umlwriter.println(umlline);
					}
					umlwriter.close();
					try {
						SourceFileReader reader = new SourceFileReader(new File(umlfile));
						List<GeneratedImage> list = reader.getGeneratedImages();
						File umlpng = list.get(0).getPngFile();
						umlpng.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//Reload input
					try {
						model.unload();
						model.load(null);
					} catch (Exception e) {}
				}
			}
			else {
				if (file.getName().equals("registry") != true && !file.getName().endsWith("vs")) {
					File[] filesBlock = file.listFiles();
					for (File fileBlock : filesBlock) {
						generateUMLGraphs(fileBlock, folder + "/" + file.getName(), packages, exercise);
					}
				}
			}
		//«counter ++»
		«ENDFOR»
		}
			
		public void generate() throws MetaModelNotFoundException, ModelNotFoundException, FileNotFoundException {
				
			Map<Integer, Map<EObject, LabelStyle>> umlnodes = new LinkedHashMap<Integer, Map<EObject, LabelStyle>>();
			Map<Integer, Map<EObject, List<String>>> umlrels = new LinkedHashMap<Integer, Map<EObject, List<String>>>();
			String metamodel = "«ModelManager.getMetaModel().replace("\\", "/")»";
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			// GENERATES PNG FILES FROM SOURCE MODELS
			File folder = new File("«folder»/data/model");
			for (File file : folder.listFiles()) {
			//«counter = 0»
			«FOR MutatorInstance instance : draw.instances»			
				if (file.isFile()) {
					String pathfile = file.getPath();
					if (pathfile.endsWith(".model") == true) {
						Resource model = ModelManager.loadModel(packages, pathfile);
						String umlfile = "«folder»/src-gen/html/diagrams/" + 
							file.getName().replace(".model", "") + "/" +
							file.getName().replace(".model", "_«counter».txt");
						«draw.generate(folder, counter)»
						File diagramsfolder = new File("«folder»/src-gen/html/diagrams/");
						if (diagramsfolder.exists() != true) {
							diagramsfolder.mkdirs();
						}
						File umlfolder = new File("«folder»/src-gen/html/diagrams/" + 
							file.getName().replace(".model", "") + "/");
						if (umlfolder.exists() != true) {
							umlfolder.mkdirs();
						}
						try {
							PrintWriter umlwriter = new PrintWriter(umlfile, "UTF-8");
							for (String umlline : umlcode) {
								umlwriter.println(umlline);
							}
							umlwriter.close();
						} catch (UnsupportedEncodingException e) {
							//Reload input
		    				try {
								model.unload();
								model.load(null);
							} catch (Exception ex) {}
							continue;
						}
						try {
							SourceFileReader reader = new SourceFileReader(new File(umlfile));
							List<GeneratedImage> list = reader.getGeneratedImages();
							File umlpng = list.get(0).getPngFile();
							umlpng.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//Reload input
						try {
							model.unload();
							model.load(null);
						} catch (Exception e) {}
					}
				}
			//«counter ++»
			«ENDFOR»
			}

			// GENERATES PNG FILES FROM MUTANTS
			folder = new File("«folder»/data/out");
			for (File exercise : folder.listFiles()) {
				if (exercise.isDirectory()) {
					for (File file : exercise.listFiles()) {
					//«counter = 0»
					«FOR MutatorInstance instance : draw.instances»			
						if (file.isFile()) {
							String pathfile = file.getPath();
							if (pathfile.endsWith(".model") == true) {
								Resource model = ModelManager.loadModel(packages, pathfile);
								String umlfile = "«folder»/src-gen/html/diagrams/" + exercise.getName() + "/" +
									file.getName().replace(".model", "_«counter».txt");
								«draw.generate(folder, counter)»
								File diagramsfolder = new File("«folder»/src-gen/html/diagrams/");
								if (diagramsfolder.exists() != true) {
									diagramsfolder.mkdirs();
								}
								File umlfolder = new File("«folder»/src-gen/html/diagrams/" + exercise.getName() + "/");
								if (umlfolder.exists() != true) {
									umlfolder.mkdirs();
								}
								try {
									PrintWriter umlwriter = new PrintWriter(umlfile, "UTF-8");
									for (String umlline : umlcode) {
										umlwriter.println(umlline);
									}
									umlwriter.close();
								} catch (UnsupportedEncodingException e) {
									//Reload input
		    						try {
										model.unload();
										model.load(null);
									} catch (Exception ex) {}
									continue;
								}
								try {
									SourceFileReader reader = new SourceFileReader(new File(umlfile));
									List<GeneratedImage> list = reader.getGeneratedImages();
									File umlpng = list.get(0).getPngFile();
									umlpng.createNewFile();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								//Reload input
								try {
									model.unload();
									model.load(null);
								} catch (Exception e) {}
							}
						}
						else {
							if (file.getName().equals("registry") != true && !file.getName().endsWith("vs")) {
								File[] filesBlock = file.listFiles();
								for (File fileBlock : filesBlock) {
									try {
										generateUMLGraphs(fileBlock, file.getName(), packages, exercise);
									} catch (UnsupportedEncodingException e) {
										continue;
									}
								}
							}
						}
					//«counter ++»
					«ENDFOR»
					}
				}
			}
		}
	}

	'''
}
