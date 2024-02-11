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
import modeldraw.Edge
import modeldraw.Relation

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
		generateUMLNodes(packages, model, umlnodes, umlrels, id);
		«ENDIF»
		«ENDIF»
		umlcode.add("@startuml");
		Set<String> rels = new HashSet<String>();
		for (EObject umlnode : umlnodes.get(«index»).keySet()) {
			if (umlnodes.get(«index»).get(umlnode) != null) {
				umlcode.add((umlnodes.get(«index»).get(umlnode).label.replaceAll("'", "") + " " + umlnodes.get(«index»).get(umlnode).name.replaceAll("'", "")).trim());
			}
		}
		«IF draw.instances.get(index).relations !== null»
		«IF draw.instances.get(index).relations.size() > 0»
		generateUMLEdges(packages, model, umlnodes, umlrels, id);
		«ENDIF»
		«ENDIF»
		for (EObject umlrel : umlrels.get(«index»).keySet()) {
			if (umlrels.get(«index»).get(umlrel) != null) {
				for (String key : umlrels.get(«index»).get(umlrel).keySet()) {
					for (LabelStyle value : umlrels.get(«index»).get(umlrel).get(key)) {
						rels.add((key.replaceAll("'", "") + " " + value.style + " " + value.name.replaceAll("'", "")).trim());
					} 					
				}
			}
		}
		for (String rel : rels) {
			umlcode.add(rel);
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
	import java.util.Set;
	import java.util.HashSet;
	
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
		private static void generateUMLNodes(List<EPackage> packages, Resource model, Map<Integer, Map<EObject, LabelStyle>> umlnodes, Map<Integer, Map<EObject, Map<String, List<LabelStyle>>>> umlrels, Map<EObject, Integer> id) {
			// COUNTER: «var int counter = 0»
			Map<EObject, LabelStyle> localnodes = null;
			Map<EObject, Map<String, List<LabelStyle>>> localrels = null;
			
			int i = 0;
			«FOR MutatorInstance instance : draw.instances»
			if (umlnodes.get(«counter») == null) {			
				localnodes = new LinkedHashMap<EObject, LabelStyle>();
			}
			else {
				localnodes = new LinkedHashMap<EObject, LabelStyle>(umlnodes.get(«counter»));
			}
			umlnodes.put(«counter», localnodes);
			if (umlrels.get(«counter») == null) {
				localrels = new LinkedHashMap<EObject, Map<String, List<LabelStyle>>>();
			}
			else {
				localrels = new LinkedHashMap<EObject, Map<String, List<LabelStyle>>>(umlrels.get(«counter»));
			}
			umlrels.put(«counter», localrels);
			try {
			Map<String, List<LabelStyle>> rels = new LinkedHashMap<String, List<LabelStyle>>();
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
				id.put(node, i);
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
					for (EObject nnode : (List<EObject>) noderels) {
						String rel = ModelManager.getStringAttribute("name", nnode);
						List<LabelStyle> values = new ArrayList<LabelStyle>();
						if (rels.get(rel) != null) {
							values = rels.get(rel);
						}
						label = new LabelStyle();
						label.name = name;
						label.style = "<|--";
						values.add(label);
						rels.put(rel, values);
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
		
		private static void generateUMLEdges(List<EPackage> packages, Resource model, Map<Integer, Map<EObject, LabelStyle>> umlnodes, Map<Integer, Map<EObject, Map<String, List<LabelStyle>>>> umlrels, Map<EObject, Integer> id) {
			// COUNTER: «counter = 0»
			Map<EObject, Map<String, List<LabelStyle>>> localrels = null;
			int i = 0;
			«FOR MutatorInstance instance : draw.instances»			
			if (umlrels.get(«counter») == null) {
				localrels = new LinkedHashMap<EObject, Map<String, List<LabelStyle>>>();
			}
			else {
				localrels = new LinkedHashMap<EObject, Map<String, List<LabelStyle>>>(umlrels.get(«counter»));
			}
			umlrels.put(«counter», localrels);
			try {
			Map<String, List<LabelStyle>> rels = null;
			«IF draw.instances.get(counter).relations !== null»
			«IF draw.instances.get(counter).relations.size() > 0»
			// COUNTER: «var int counter2 = 0»
			«FOR Relation rel : draw.instances.get(counter).relations»
			«IF rel instanceof Edge»
			//«var Edge edge = rel as Edge»
			List<EObject> ledge_«counter»_«counter2» = ModelManager.getObjectsOfType("«edge.name.name»", model);
			i = 0;
			for (EObject edge : ledge_«counter»_«counter2») {
				if (localrels.get(edge) == null) {
					rels = new LinkedHashMap<String, List<LabelStyle>>();
				}
				else {
					rels = new LinkedHashMap<String, List<LabelStyle>>(localrels.get(edge));
				}
				String typeName = edge.eClass().getName();
				String src_label = "";
				String tar_label = "";
				«IF edge.name.name.equals("ClassAssociation") || edge.name.name.equals("ClassAggregation") || edge.name.name.equals("ClassComposition")»
				«IF edge.source !== null && edge.target !== null»
				«IF edge.name.name.equals("ClassAssociation")»
				String ref = "source";
				«ELSEIF edge.name.name.equals("ClassAggregation")»
				String ref = "source";
				«ELSEIF edge.name.name.equals("ClassComposition")»
				String ref = "constituent";
				«ENDIF»
				Object o = ModelManager.getReferences(ref, edge);
				EObject src = null;
				if (o instanceof List<?>) {
					src = ((List<EObject>) o).get(0);
				}
				«IF edge.name.name.equals("ClassAssociation")»
				ref = "target";
				«ELSEIF edge.name.name.equals("ClassAggregation")»
				ref = "target";
				«ELSEIF edge.name.name.equals("ClassComposition")»
				ref = "composite";
				«ENDIF»
				o = ModelManager.getReferences(ref, edge);
				EObject tar = null;
				if (o instanceof List<?>) {
					tar = ((List<EObject>) o).get(0);
				}
				if (src != null && tar != null) {
					src_label = ModelManager.getStringAttribute("name", src);
					tar_label = ModelManager.getStringAttribute("name", tar);
					List<LabelStyle> target = new ArrayList<LabelStyle>();
					if (rels.get(src_label) != null) {
						target = rels.get(src_label);
					}
					LabelStyle tar_lbl = new LabelStyle();
					tar_lbl.name = tar_label;
				«IF edge.name.name.equals("ClassAssociation")»
					tar_lbl.style = "<-->";
				«ELSEIF edge.name.name.equals("ClassAggregation")»
					tar_lbl.style = "o-->";
				«ELSEIF edge.name.name.equals("ClassComposition")»
					tar_lbl.style = "*-->";
				«ENDIF»
					target.add(tar_lbl);
					rels.put(src_label, target);
				}
				«ENDIF»
				«ENDIF»
				«IF edge.name.name.equals("ObjectAssociation") || edge.name.name.equals("ObjectAggregation") || edge.name.name.equals("ObjectComposition")»
				«IF edge.source !== null && edge.target !== null»
				«IF edge.name.name.equals("ObjectAssociation")»
				String ref = "source";
				«ELSEIF edge.name.name.equals("ObjectAggregation")»
				String ref = "source";
				«ELSEIF edge.name.name.equals("ObjectComposition")»
				String ref = "constituent";
				«ENDIF»
				Object o = ModelManager.getReferences(ref, edge);
				EObject src = null;
				if (o instanceof List<?>) {
					src = ((List<EObject>) o).get(0);
				}
				«IF edge.name.name.equals("ObjectAssociation")»
				ref = "target";
				«ELSEIF edge.name.name.equals("ObjectAggregation")»
				ref = "target";
				«ELSEIF edge.name.name.equals("ObjectComposition")»
				ref = "composite";
				«ENDIF»
				o = ModelManager.getReferences(ref, edge);
				EObject tar = null;
				if (o instanceof List<?>) {
					tar = ((List<EObject>) o).get(0);
				}
				if (src != null && tar != null) {
					src_label = getOrdinalFor(id.get(src));
					tar_label = getOrdinalFor(id.get(tar));
					List<LabelStyle> target = new ArrayList<LabelStyle>();
					if (rels.get(src_label) != null) {
						target = rels.get(src_label);
					}
					LabelStyle tar_lbl = new LabelStyle();
					tar_lbl.name = tar_label;
					tar_lbl.style = "--";
					target.add(tar_lbl);
					rels.put(src_label, target);
				}
				«ENDIF»
				«ENDIF»
				localrels.put(edge, rels);
				i++;
			}
				«ENDIF»
				// INC COUNTER: «counter2++»
				«ENDFOR»
				«ENDIF»
				«ENDIF»
			} catch (ReferenceNonExistingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// INC COUNTER: «counter++»
		«ENDFOR»
		}

		public static void generateUMLGraphs(File file, String folder, List<EPackage> packages, File exercise) throws ModelNotFoundException, FileNotFoundException, UnsupportedEncodingException {
		//«counter = 0»
		«FOR MutatorInstance instance : draw.instances»			
			if (file.isFile()) {
				String pathfile = file.getPath();
				if (pathfile.endsWith(".model") == true) {
					Resource model = ModelManager.loadModel(packages, pathfile);
					String path = exercise.getName() + "/" + folder;
					String umlfile = "«folder»/src-gen/html/diagrams/" + 
						path + "/" + file.getName().replace(".model", "_«counter».txt");
					Map<Integer, Map<EObject, LabelStyle>> umlnodes = new LinkedHashMap<Integer, Map<EObject, LabelStyle>>();
					Map<Integer, Map<EObject, Map<String, List<LabelStyle>>>> umlrels = new LinkedHashMap<Integer, Map<EObject, Map<String, List<LabelStyle>>>>();
					Map<EObject, Integer> id = new LinkedHashMap<EObject, Integer>();
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
						Map<Integer, Map<EObject, LabelStyle>> umlnodes = new LinkedHashMap<Integer, Map<EObject, LabelStyle>>();
						Map<Integer, Map<EObject, Map<String, List<LabelStyle>>>> umlrels = new LinkedHashMap<Integer, Map<EObject, Map<String, List<LabelStyle>>>>();
						Map<EObject, Integer> id = new LinkedHashMap<EObject, Integer>();
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
								Map<Integer, Map<EObject, LabelStyle>> umlnodes = new LinkedHashMap<Integer, Map<EObject, LabelStyle>>();
								Map<Integer, Map<EObject, Map<String, List<LabelStyle>>>> umlrels = new LinkedHashMap<Integer, Map<EObject, Map<String, List<LabelStyle>>>>();
								Map<EObject, Integer> id = new LinkedHashMap<EObject, Integer>();
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
